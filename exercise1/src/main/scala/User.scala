package scalaworkshop

import scala.util.Try

case class User(name: String, age: Option[Int])

object User {

  // Expected comma separated string. i.e. "Magnus H, 38"
  // Age can also be an emtpy string or invalid number
  def parseUser(input: String) = {
    val Array(name, unparsedAge) = input.split(',').map(_.trim)
    val age = Try(unparsedAge.toInt).toOption
    User(name, age)
  }
}