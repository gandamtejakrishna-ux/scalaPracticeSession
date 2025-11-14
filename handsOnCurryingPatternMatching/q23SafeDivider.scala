object q23SafeDivider {
  def safeDivide(x: Int, y: Int): Option[Int] =
    if (y == 0) None else Some(x / y)

  def main(args: Array[String]): Unit = {
    println(safeDivide(10, 2))
    println(safeDivide(10, 0))

    val result = safeDivide(10, 0).getOrElse(-1)
    println(result)

    val ok = safeDivide(9, 3).getOrElse(-1)
    println(ok)
  }
}
