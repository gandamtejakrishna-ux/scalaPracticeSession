package handsOnScalaFirst5ques
class q2arrayMirrorPuzzle {
  // Q2. Array Mirror Puzzle (Arrays + Loops + Operators)
  def mirrorArray(arr: Array[Int]): Array[Int] = {
    val mirrored = new Array[Int](arr.length * 2)
    val num: Int = arr.length
    for (i <- arr.indices) {
      mirrored(i) = arr(i)
      mirrored(num + i) = arr(num - 1 - i)
    }
    mirrored
  }
}
