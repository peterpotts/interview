package com.peterpotts.interview

import scala.collection.immutable.IndexedSeq

object BinarySearch {
  def main(args: Array[String]): Unit = println(binarySearch(IndexedSeq(1, 4, 6, 7, 9), 7))

  def binarySearch(seq: IndexedSeq[Int], target: Int): Option[Int] = {
    def loop(lower: Int, upper: Int, target: Int): Option[Int] = {
      if (lower > upper) {
        None
      } else {
        val center = (lower + upper) / 2

        if (target < seq(center)) {
          loop(lower, center - 1, target)
        } else if (target > seq(center)) {
          loop(center + 1, upper, target)
        } else {
          Some(center)
        }
      }
    }

    loop(0, seq.size - 1, target)
  }
}

