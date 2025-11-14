package handsOnScalaFirst5ques

import scala.annotation.tailrec

class tailRecursiveFactorial {
  def factorial(n: Int): Int = {
    @tailrec
    def loop(x: Int, acc: Int): Int = {
      println(s"[acc=$acc, n=$x]")
      if (x <= 1) acc
      else loop(x - 1, acc * x)
    }
    loop(n, 1)
  }
}
