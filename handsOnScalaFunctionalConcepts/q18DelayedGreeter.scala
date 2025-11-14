object q18DelayedGreeter {
  def main(args: Array[String]): Unit = {

    def delayedMessage(delayMs: Int)(message: String): Unit = {
      Thread.sleep(delayMs)
      println(message)
    }

    val oneSecondSay = delayedMessage(1000) _

    oneSecondSay("Hello, Scala!")
    oneSecondSay("Learning partial functions...")
    oneSecondSay("Feels like magic!")
  }
}
