package handsOnScalaFirst5ques

object MainApp {
  def main(args: Array[String]): Unit = {

    val obj = new q1smartTemperatureConverter()

    println(
      s"Converted 40.0 C to ${obj.convertTemp(40.0, "C")} F"
    )
    println(
      s"Converted 104.0 F to ${obj.convertTemp(104.0, "F")} C"
    )
    println(obj.convertTemp(100.0, "V"))
    val obj1 = new q2arrayMirrorPuzzle()
    println(
      s"Mirrored Array: ${obj1.mirrorArray(Array(1, 2, 3, 4, 5)).mkString(", ")}"
    )
    val obj2Mirror = new q2arrayMirrorPuzzle()
    println(
      s"Mirrored Array: ${obj2Mirror.mirrorArray(Array(1, 2, 3, 4, 5)).mkString(", ")}"
    )
    val obj3 = new q3digitSumUsingSimpleRecursion()
    println(
      s"Digit Sum of 12345 is: ${obj3.digitSum(12345)}"
    )
    val obj4 = new q5maxElementArrayTailRecursion()
    println(
      s"Max element in array is: ${obj4.maxInArray(Array(3, 5, 2, 9, 1))}"
    )
    val obj5 = new q62DMultiplicationTable()
    println(obj5.multiplicationTable(3).mkString("\n"))
  }
}
