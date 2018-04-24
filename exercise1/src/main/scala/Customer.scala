package scalaworkshop

import scala.util.Try

sealed trait User {
  val orders: Seq[Order]

  val isVip =
    orders.flatMap(o => o.products.map(_.price)).sum > 1000
}

sealed case class Nerd(name: String, orders: Seq[Order]) extends User
sealed case class Customer(name: String, age: Option[Int], orders: Seq[Order]) extends User

sealed case class Order(products: Seq[Product])
sealed case class Product(name: String, price: Double, category: String)


object User {

  // Expected comma separated string. i.e. "Magnus H, 38"
  // Age can also be an emtpy string or invalid number
  def parseUser(input: String) = {
    val Array(name, unparsedAge) = input.split(',').map(_.trim)
    val age = Try(unparsedAge.toInt).toOption
    Customer(name, age, Seq.empty)
  }

}