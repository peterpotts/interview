package com.peterpotts.interview

import scala.collection.immutable.Seq

object Combination {
  def combinations(k: Int, n: Int): Seq[Seq[Int]] =
    if (k == 0) {
      Seq(Seq.empty[Int])
    } else {
      (0 until n).flatMap { i => combinations(k - 1, i).map(seq => seq :+ i) }
    }
}
