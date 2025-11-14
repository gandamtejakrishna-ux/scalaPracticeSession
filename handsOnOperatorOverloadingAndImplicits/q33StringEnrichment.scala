object q33StringEnrichment {

  implicit class RichString(str: String) {
    def *(times: Int): String = str.repeat(times)
    def ~(other: String): String = s"$str $other"
  }

  def main(args: Array[String]): Unit = {
    println("Hi" * 3)
    println("Hello" ~ "World")
    println("Scala" ~ "Rocks!")
  }
}
