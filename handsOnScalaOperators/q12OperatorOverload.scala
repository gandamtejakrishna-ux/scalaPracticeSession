object q12OperatorOverload {
  class Counter(val value: Int) {
    def +(that: Counter): Int = this.value + that.value
    def +(that: Int): Int = that + this.value
  }

  def main(args: Array[String]): Unit = {
    val a = new Counter(5)
    val b = new Counter(7)

    println(s"Sum of two Counter objects a and b: ${a + b}")
    println(s"Sum of Counter object a and integer 10: ${a + 10}")
  }
}
