object q34MoneyPrecision {

  case class Money(amount: Double) {

    private def round(value: Double)(implicit precision: Double): Double = {
      val rounded = (value / precision).round * precision
      BigDecimal(rounded).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
    }

    def +(that: Money)(implicit precision: Double): Money =
      Money(round(this.amount + that.amount))

    def -(that: Money)(implicit precision: Double): Money =
      Money(round(this.amount - that.amount))

    override def toString: String = f"Money(${amount}%.2f)"
  }

  def main(args: Array[String]): Unit = {
    implicit val roundingPrecision: Double = 0.05

    val m1 = Money(10.23)
    val m2 = Money(5.19)

    println(m1 + m2)
    println(m1 - m2)

    {
      implicit val customPrecision: Double = 0.10
      val m3 = Money(7.77)
      val m4 = Money(2.14)
      println(m3 + m4)
    }
  }
}
