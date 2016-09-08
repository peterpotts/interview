package com.peterpotts.interview

object MaximumSumSlice {
  def simple(array: Array[Int]): Int = {
    var sum = 0
    var max = Int.MinValue

    for (value <- array) {
      sum += value
      if (sum > max) max = sum
      if (sum < 0) sum = 0
    }

    max
  }

  def fold(array: Array[Int]): Int =
    array.foldLeft((Int.MinValue, 0)) {
      case ((max, sum), value) =>
        val foldMax = math.max(max, sum + value)
        val foldSum = math.max(0, sum + value)
        foldMax -> foldSum
    }._1
}
