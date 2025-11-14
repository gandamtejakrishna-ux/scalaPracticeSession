object q21PersonalizedCalculator {
  def main(args: Array[String]): Unit = {

    def calculate(op: String)(x: Int, y: Int): Int = {
      op match {
        case "add" => x + y
        case "sub" => x - y
        case "mul" => x * y
        case "div" => x / y
        case _     => 0
      }
    }

    // no trailing underscore needed in Scala 3
    val add = calculate("add")
    val multiply = calculate("mul")

    println(add(10, 5))
    println(multiply(3, 4))
  }
}
