object q36SafeDivision {
  def safeDivide(a: Int, b: Int): Either[String, Double] = {
    if (b == 0)
      Left("Division by zero")
    else
      Right(a.toDouble / b)
  }

  def main(args: Array[String]): Unit = {
    val pairs = List((10, 2), (5, 0), (8, 4))

    val results = pairs.map { case (x, y) => safeDivide(x, y) }

    val valid = results.collect { case Right(value) => value }
    val errors = results.collect { case Left(err) => err }

    println(s"Valid results: $valid")
    println(s"Errors: $errors")
  }
}
