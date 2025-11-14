object q17SentencePipeLine {

  def main(args: Array[String]): Unit = {
    val trimSpaces: String => String = _.trim
    val toLower: String => String = _.toLowerCase
    val capitalizeFirst: String => String = s => s.head.toUpper + s.tail

    val processSentence = trimSpaces andThen toLower andThen capitalizeFirst

    val messy = " HeLLo WOrld "
    val toBeClean = "scAlA iS soFun"
    println(processSentence(messy))
    println(s"Trim process: ${trimSpaces(toBeClean)}")
    println(s"Lowercase process: ${toLower(toBeClean)}")
    println(s"Capitalize process: ${capitalizeFirst(toBeClean)}")
  }
}
