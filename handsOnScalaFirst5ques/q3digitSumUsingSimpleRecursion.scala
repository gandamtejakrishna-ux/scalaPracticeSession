package handsOnScalaFirst5ques
class q3digitSumUsingSimpleRecursion {
  // Q3. Digit Sum using Simple Recursion
  def digitSum(n: Int): Int = {
    if (n == 0) 0
    else (n % 10) + digitSum(n / 10)
  }

}
