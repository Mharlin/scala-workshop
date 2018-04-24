package scalaworkshop

import scala.util.Try

sealed trait User {
  val orders: Seq[Order]

  val isVip =
    orders.flatMap(o => o.products.map(_.price)).sum > 1000
}

object User {
  // Expected comma separated string. i.e. "Magnus H, 38"
  // Age can also be an emtpy string or invalid number
  def parseUser(input: String) = {
    val Array(name, unparsedAge) = input.split(',').map(_.trim)
    val age = Try(unparsedAge.toInt).toOption
    Customer(name, age, Seq.empty)
  }
}

sealed case class Nerd(name: String, orders: Seq[Order]) extends User
sealed case class Customer(name: String, age: Option[Int], orders: Seq[Order]) extends User

sealed case class Order(products: Seq[Product])
sealed case class Product(name: String, price: Double, category: String)

sealed case class Price(amount: Double, discount: Double)
sealed case class CategoryPrice(category: String, price: Price)
sealed case class CheckoutSummary(totalPrice: Price, pricePerCategory: Seq[CategoryPrice])


object Checkout {
  def calculatePrice(user: User) = {
    def calculateVipDiscount(sum: Double) =
      if (user.isVip) {
        sum * 0.1
      } else {
        0.0
      }

    def calculateNerdDiscount(category: String, sum: Double) =
      (user, category) match {
        case (Nerd(_, _), "Tech") => sum * 0.15
        case _ => 0.0
      }

    val pricePerCategory = user.orders.flatMap(_.products)
      .groupBy(p => p.category)
      .map(grouped => CategoryPrice(grouped._1, Price(grouped._2.map(_.price).sum, 0)))
      .map(c => {
        val vipDiscount = calculateVipDiscount(c.price.amount)
        val nerdDiscount = calculateNerdDiscount(c.category, c.price.amount)
        val totalDiscount = vipDiscount + nerdDiscount

        c.copy(price = Price(c.price.amount - totalDiscount, totalDiscount ))
      }).toSeq

    val totalAmount = pricePerCategory.map(_.price.amount).sum
    val totalDiscount = pricePerCategory.map(_.price.discount).sum

    CheckoutSummary(Price(totalAmount, totalDiscount), pricePerCategory)
  }
}
