import org.scalatest._
import scalaworkshop.User

class UserSpec extends FlatSpec with Matchers {

  it should "parse user with age" in {
    User.parseUser("Magnus H, 38") should be (scalaworkshop.User("Magnus H", Some(38)))
  }

  it should "parse user without" in {
    User.parseUser("Magnus H, ") should be (scalaworkshop.User("Magnus H", None))
  }

}
