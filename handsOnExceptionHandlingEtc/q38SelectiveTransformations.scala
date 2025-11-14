object q38SelectiveTransformations {

  def main(args: Array[String]): Unit = {

    val items = List(1, "apple", 3.5, "banana", 42)

    val doubleIntegers: PartialFunction[Any, Int] = { case n: Int =>
      n * 2
    }

    val result = items.collect(doubleIntegers)

    println(s"Original items: $items")
    println(s"Transformed integers: $result")
  }
}
