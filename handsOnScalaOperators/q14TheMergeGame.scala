object q14TheMergeGame {
  def main(args: Array[String]): Unit = {
    val a = List(1, 2, 3)
    val b = List(4, 5, 6)
    val vector = Vector(7, 8, 9)
    val c1 = a ++ b
    val c2 = a ::: b
    val c3 = vector ++ a
    val merged = a ++ vector ++ b // (a ++ vector) ++ b
    println(s"List c1: $c1")
    println(s"List c2: $c2")
    println(s"Vector c3: $c3")
    println(s"Merged Collection: $merged")
  }
}
