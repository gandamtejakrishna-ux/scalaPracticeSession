object q11MysteryOperators {
  def main(args: Array[String]): Unit = {
    val nums = List(2, 4, 6)
    val result = nums :+ 8
    val result2 = 0 +: nums
    val finalResult = 0 +: nums :+ 8
    println(s"Original List: $nums")
    println(s"After appending 8 using :+ operator: $result")
    println(s"After prepending 0 using +: operator: $result2")
    println(s"After prepending 0 and appending 8: $finalResult")
  }
}
