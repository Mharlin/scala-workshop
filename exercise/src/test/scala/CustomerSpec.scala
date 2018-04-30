import org.scalatest._
import scalaworkshop.{Customer, Order, Product, User}

class CustomerSpec extends FlatSpec with Matchers {
  //Exercise part 1 parse csv strings
  it should "parse user with age" in {
    User.parseUser("Magnus H, 38") should be (Customer("Magnus H", Some(38)))
  }

  it should "parse user without" in {
    User.parseUser("Magnus H, ") should be (Customer("Magnus H", None))
  }

//  it should "set a user to VIP if order amount is more than 10000" in {
//    Customer("", None, Seq(Order(Seq(Product("Fidget Spinner", 200, "Toys"), Product("Laptop", 900, "Tech")))))
//        .isVip shouldBe true
//  }
//
//  it should "user is not VIP if order amount is less than 10000" in {
//    Customer("", None, Seq(Order(Seq(Product("Fidget Spinner", 50, "Toys"), Product("Laptop", 900, "Tech")))))
//      .isVip shouldBe false
//  }
}
