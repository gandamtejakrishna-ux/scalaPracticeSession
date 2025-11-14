object q29UnapplyChainNestedPatternMatching {

  case class Address(city: String, pincode: Int)
  case class Person(name: String, address: Address)

  def main(args: Array[String]): Unit = {

    val p = Person("Ravi", Address("Chennai", 600001))

    p match {
      case Person(_, Address(city, pin)) if city.startsWith("C") =>
        println(s"$city - $pin")
      case _ =>
        println("No match found or city doesn't start with C")
    }

    val p2 = Person("Kiran", Address("Mumbai", 400001))
    p2 match {
      case Person(_, Address(city, pin)) if city.startsWith("C") =>
        println(s"$city - $pin")
      case _ =>
        println("No match found or city doesn't start with C")
    }
  }
}
