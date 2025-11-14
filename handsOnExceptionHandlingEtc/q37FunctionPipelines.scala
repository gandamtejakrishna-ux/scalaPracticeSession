object q37FunctionPipelines {

  def main(args: Array[String]): Unit = {

    val trim: String => String = _.trim
    val toInt: String => Int = _.toInt
    val doubleIt: Int => Int = _ * 2

    val pipelineAndThen = trim andThen toInt andThen doubleIt
    val result1 = pipelineAndThen(" 21 ")
    println(s"Using andThen: ' 21 ' → $result1")

    val pipelineCompose = doubleIt compose toInt compose trim
    val result2 = pipelineCompose(" 21 ")
    println(s"Using compose: ' 21 ' → $result2")

    println("\nObservation:")
    println("andThen → left to right (data flows forward)")
    println("compose → right to left (data flows backward)")
  }
}
