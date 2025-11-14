// Implicit Conversions in Scala
implicit def intToDouble(x: Int): Double = x.toDouble
implicit def listToSet(l: List[Int]): Set[Int] = l.toSet
implicit def setToList(se: Set[Int]): List[Int] = se.toList

object ImplicitConversion {
  def main(args: Array[String]): Unit = {
    var d: Double = 5
    println("The value of d is: " + d)
    var s: Set[Int] = List(1, 2, 2, 3, 4)
    println("The value of s is: " + s)
    var li: List[Int] = Set(5, 6, 7, 8)
    println("The value of li is: " + li)
  }
}
