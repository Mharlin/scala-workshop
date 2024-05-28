package scalaworkshop

import org.scalatest.*
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.*

class UserSpec extends AnyFlatSpec with should.Matchers {
  //Exercise part 1 parse csv strings
  it should "parse user with age" in {
    User.parseUser("Magnus H, 38") should be (User("Magnus H", Some(38)))
  }

  it should "parse user without" in {
    User.parseUser("Magnus H, ") should be (User("Magnus H", None))
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
