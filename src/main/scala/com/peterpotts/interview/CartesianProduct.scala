package com.peterpotts.interview

object CartesianProduct {
  def apply(input: Seq[Seq[Int]]): Seq[Seq[Int]] =
    input match {
      case head +: tail =>
        val seqSeq: Seq[Seq[Int]] = apply(tail)

        head.flatMap { value =>
          seqSeq.map(seq => value +: seq)
        }
      case Nil => Seq(Seq.empty)
    }
}
