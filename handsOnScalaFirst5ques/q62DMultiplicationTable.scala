package handsOnScalaFirst5ques
class q62DMultiplicationTable {
  // Q6. 2D Multiplication Table (Loops + String Interpolation)
  def multiplicationTable(n: Int): List[String] = {
    val table = for {
      i <- 1 to n
      j <- 1 to n
    } yield s"$i x $j = ${i * j}"
    table.toList
  }
}
