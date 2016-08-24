package com.peterpotts.interview

object BinarySearch {
  def main(args: Array[String]): Unit = {
    println(binarySearch(Seq(1, 4, 6, 7, 9), 7))
  }

  def binarySearch(seq: Seq[Int], target: Int): Option[Int] = {
    if (seq.isEmpty) {
      None
    } else {
      val result = seq.size / 2
      val (left, middle +: right) = seq.splitAt(result)

      if (target < middle) {
        binarySearch(left, target)
      } else if (target > middle) {
        binarySearch(right, target).map(result + 1 + _)
      } else {
        Some(result)
      }
    }
  }
}
