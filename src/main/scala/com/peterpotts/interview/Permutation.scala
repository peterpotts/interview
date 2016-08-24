package com.peterpotts.interview

import scala.collection.immutable.IndexedSeq

object Permutation {
  def main(args: Array[String]): Unit = permutations(0 until 3).foreach(println)

  def permutations(seq: IndexedSeq[Int]): IndexedSeq[IndexedSeq[Int]] = {
    if (seq.isEmpty) {
      IndexedSeq(IndexedSeq.empty[Int])
    } else {
      val seqSeqSeq = for (i <- seq.indices) yield {
        val (left, middle +: right) = seq.splitAt(i)
        val seqSeq = permutations(left ++ right)
        seqSeq.map(seq => middle +: seq)
      }

      seqSeqSeq.flatten
    }
  }
}
