object q35RationalBridge {

  case class Rational(n: Int, d: Int) {

    def /(that: Rational): Rational = {
      Rational(this.n * that.d, this.d * that.n)
    }

    override def toString: String = s"Rational(${n},${d})"
  }

  implicit def intToRational(x: Int): Rational = Rational(x, 1)

  def main(args: Array[String]): Unit = {
    val r1 = Rational(2, 3)
    val result = 1 / r1
    println(s"Result: $result")

    val normalDivision = 6 / 2
    println(s"Normal Int division: $normalDivision")

    val r2 = Rational(4, 5)
    println(s"Chained Rational division: ${r1 / r2}")
  }
}
