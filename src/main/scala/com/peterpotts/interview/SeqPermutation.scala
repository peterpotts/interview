package com.peterpotts.interview

import scala.collection.immutable.Seq

object SeqPermutation {
  def permutations[T](seq: Seq[T]): Seq[Seq[T]] = {
    val seqIndices = loop(seq.indices.toSet)
    val map = seq.zipWithIndex.map(_.swap).toMap
    seqIndices.map { indices => indices.map(map) }
  }

  private def loop(indices: Set[Int]): Seq[Seq[Int]] =
    if (indices.isEmpty) {
      Seq(Seq.empty)
    } else {
      indices.toIndexedSeq.flatMap { index =>
        loop(indices - index).map(seq => index +: seq)
      }
    }
}
