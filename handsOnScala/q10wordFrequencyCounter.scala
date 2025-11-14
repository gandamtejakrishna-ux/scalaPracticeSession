object main {
  def main(args: Array[String]): Unit = {
    val lines = List(
      "Scala is powerful",
      "Scala is concise",
      "Functional programming is powerful"
    )

    val words = for {
      line <- lines
      word <- line.split(" ")
    } yield word

    val wordCount = words.groupBy(identity).mapValues(_.size).toMap
    println(s"Word Frequency Count: $wordCount")
  }
}
