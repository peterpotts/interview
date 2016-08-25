package com.peterpotts.interview

object CartesianProduct extends App {
  val input = Seq(Seq(1, 2, 3), Seq(4, 5), Seq(6, 7, 8))

  def printProduct(input: Seq[Seq[Int]]): Unit = {
    product(input).foreach(seq => println(seq.mkString(" ")))
  }

  def product(input: Seq[Seq[Int]]): Seq[Seq[Int]] = {
    val seqSeqSeq = input match {
      case head +: tail =>
        val seqSeq: Seq[Seq[Int]] = product(tail)
        head.flatMap { value =>
          seqSeq.map(seq => value +: seq)
        }
      case Nil => Seq(Seq.empty)
    }

    seqSeqSeq
  }

  printProduct(input)
}
