package com.peterpotts.interview

//noinspection ScalaStyle
object Permutation {
  def main(args: Array[String]): Unit = {
    permutations(0 until 3).foreach(println)
  }

  def permutations(seq: Seq[Int]): Seq[Seq[Int]] = {
    if (seq.isEmpty) {
      Seq(Seq.empty[Int])
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
