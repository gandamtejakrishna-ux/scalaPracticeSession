object q16MoodTransformer {
  def main(args: Array[String]): Unit = {
    def evenOddManipulator(text: String): Int => String = { (length: Int) =>
      {
        if (length % 2 == 0) "even" else "odd"
      }
    }

    val letter = evenOddManipulator("Scala")
    val finalResult = letter("Scala".length)
    println(s"The final result is: $finalResult")

    def wordDecorator(symbol: String): String => String = { word =>
      s"$symbol$word$symbol"
    }

    val starWrap = wordDecorator("*")
    val waveWrap = wordDecorator("wave")
    val smileWrap = wordDecorator("smile")

    println(starWrap("Scala"))
    println(waveWrap("Code"))
    println(smileWrap("Fun"))
  }

}
