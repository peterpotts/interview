package com.peterpotts.interview

object CartesianProduct extends App {
  val A = Seq(1,2,3)
  val B = Seq(4,5)
  val C = Seq(6,7,8)
  /*
  A * B = [(1,4), (1,5), (2,4), (2,5), (3,4), (3,5)]
  A * B * C = [(1,4,6), (1,4,7), ..., (3,5,8)]
  |A * B * C| = 3 * 2 * 3 = 18
  */
  val input: Seq[Seq[Int]] = Seq(A,B,C)

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
  /*
  1 4 6
  1 4 7
  1 4 8
  ...
  3 5 8
  */
}
