package handsOnScalaFirst5ques
import scala.annotation.tailrec

class q5maxElementArrayTailRecursion {
  def maxInArray(arr: Array[Int]): Int = {
    @tailrec
    def loop(i: Int, maxVal: Int): Int = {
      if (i == arr.length) maxVal
      else {
        val newMax = if (arr(i) > maxVal) arr(i) else maxVal
        loop(i + 1, newMax)
      }
    }
    loop(0, Int.MinValue)
  }
}
