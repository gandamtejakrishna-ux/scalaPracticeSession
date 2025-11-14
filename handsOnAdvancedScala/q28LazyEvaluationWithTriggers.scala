object q28LazyEvaluationWithTriggers {

  def main(args: Array[String]): Unit = {

    var count = 0

    lazy val result = {
      count += 1
      println("Doing some heavy computation...")
      99
    }

    println("Before using the lazy value.")
    println(s"First call -> $result")

    println("Calling again (should not compute again)...")
    println(s"Second call -> $result")

    println(s"Computation actually happened $count time(s)")
  }
}
