package scalaworkshop

import scala.util.Try

object User {
  // Expected comma separated string. i.e. "Magnus H, 38"
  // Age can also be an emtpy string or invalid number
  def parseUser(input: String): User = ???
}

sealed case class User(name: String, age: Option[Int])

