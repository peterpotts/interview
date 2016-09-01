package com.peterpotts.interview

import scala.collection.immutable.IndexedSeq

object IndexedSeqPermutation {
  def permutations(seq: IndexedSeq[Int]): IndexedSeq[IndexedSeq[Int]] = {
    if (seq.isEmpty) {
      IndexedSeq(IndexedSeq.empty[Int])
    } else {
      seq.indices.flatMap { index =>
        val (left, middle +: right) = seq.splitAt(index)
        val seqSeq = permutations(left ++ right)
        seqSeq.map(seq => middle +: seq)
      }
    }
  }
}
