package com.peterpotts.interview

import scala.collection.immutable.Seq

object Combination {
  def main(args: Array[String]): Unit = combinations(3, 5).foreach(println)

  def combinations(k: Int, n: Int): Seq[Seq[Int]] = {
    if (k == 0) {
      Seq(Seq.empty[Int])
    } else {
      val seqSeqSeq = for (i <- 0 until n) yield {
        val seqSeq = combinations(k - 1, i)
        seqSeq.map(seq => seq :+ i)
      }

      seqSeqSeq.flatten
    }
  }
}
