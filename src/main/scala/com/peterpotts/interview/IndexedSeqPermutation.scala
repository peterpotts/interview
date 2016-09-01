package com.peterpotts.interview

import scala.collection.immutable.IndexedSeq

object IndexedSeqPermutation {
  def permutations[T](seq: IndexedSeq[T]): IndexedSeq[IndexedSeq[T]] = {
    if (seq.isEmpty) {
      IndexedSeq(IndexedSeq.empty[T])
    } else {
      seq.indices.flatMap { index =>
        val (left, middle +: right) = seq.splitAt(index)
        val seqSeq = permutations(left ++ right)
        seqSeq.map(seq => middle +: seq)
      }
    }
  }
}
