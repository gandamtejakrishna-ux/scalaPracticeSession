class DownloadTask(fileName: String, downloadSpeed: Int) extends Thread {

  override def run(): Unit = {
    for (percent <- 10 to 100 by 10) {
      Thread.sleep(downloadSpeed)    // simulate download delay
      println(s"$fileName: $percent% downloaded")
    }
    println(s"$fileName download completed!")
  }
}

object DownloadSimulator {
  def main(args: Array[String]): Unit = {

    val file1 = new DownloadTask("FileA.zip", 600)  // slower file
    val file2 = new DownloadTask("FileB.mp4", 400)  // medium speed
    val file3 = new DownloadTask("FileC.pdf", 200)  // fastest

    // Start all downloads (run in parallel)
    file1.start()
    file2.start()
    file3.start()

    // Optional: wait for all to finish
    file1.join()
    file2.join()
    file3.join()

    println("All downloads completed!")
  }
}
