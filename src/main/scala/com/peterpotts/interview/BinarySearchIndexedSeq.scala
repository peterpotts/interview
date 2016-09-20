package com.peterpotts.interview

import scala.collection.immutable.IndexedSeq

object BinarySearchIndexedSeq {
  def indexOf(seq: IndexedSeq[Int], value: Int): Option[Int] = {
    var lower = 0
    var upper = seq.size - 1

    def hasNext = lower < upper

    def next(): Unit = {
      val middle = (lower + upper) / 2

      if (value < seq(middle)) {
        upper = middle - 1
      } else if (value > seq(middle)) {
        lower = middle + 1
      } else {
        lower = middle
        upper = middle
      }
    }

    while (hasNext) next()

    if (value == seq(lower)) Some(lower) else None
  }
}

