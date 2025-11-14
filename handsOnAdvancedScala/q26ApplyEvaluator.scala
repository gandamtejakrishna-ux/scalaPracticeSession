object q26ApplyEvaluator {
  object Evaluator {
    def apply(task: => Any): Unit = {
      println("---- Starting Evaluation ----")
      val output = task
      println(s"Computed Output: $output")
      println("-----------------------------\n")
    }
  }

  def main(args: Array[String]): Unit = {
    // Example 1: Simple arithmetic
    Evaluator {
      val price = 250
      val tax = 0.18
      val total = price + (price * tax)
      total.toInt
    }

    // Example 2: String manipulation
    Evaluator {
      val first = "Scala"
      val second = "Rocks"
      s"$first $second!".toUpperCase
    }
  }
}
