object q19AdaptiveDiscount {

  def main(args: Array[String]): Unit = {
    def discountStrategy(memberType: String): Double => Double =
      memberType match {
        case "gold"   => (price: Double) => price * 0.8
        case "silver" => (price: Double) => price * 0.9
        case _        => (price: Double) => price
      }

    val goldDiscount = discountStrategy("gold")
    val silverDiscount = discountStrategy("silver")
    val regularDiscount = discountStrategy("normal")

    println(s"Gold member pays: ${goldDiscount(1000)}")
    println(s"Silver member pays: ${silverDiscount(1000)}")
    println(s"Regular member pays: ${regularDiscount(1000)}")

  }

}
