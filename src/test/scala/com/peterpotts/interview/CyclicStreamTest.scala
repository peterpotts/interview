package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class CyclicStreamTest extends WordSpec with Matchers {
  "A cyclic stream" should {
    "can be odd even cyclic" in {
      lazy val loop: Stream[Int] = 4 #:: 6 #:: 2 #:: loop
      val cyclicList = 3 #:: 2 #:: loop
      CyclicStream.isCyclic(cyclicList) shouldEqual true
    }

    "can be odd odd cyclic" in {
      lazy val loop: Stream[Int] = 4 #:: 6 #:: 2 #:: loop
      val cyclicList = 3 #:: 2 #:: 8 #:: loop
      CyclicStream.isCyclic(cyclicList) shouldEqual true
    }

    "can be even even cyclic" in {
      lazy val loop: Stream[Int] = 4 #:: 6 #:: 2 #:: 7 #:: loop
      val cyclicList = 3 #:: 2 #:: loop
      CyclicStream.isCyclic(cyclicList) shouldEqual true
    }

    "can be even odd cyclic" in {
      lazy val loop: Stream[Int] = 4 #:: 6 #:: 2 #:: 7 #:: loop
      val cyclicList = 3 #:: 2 #:: 8 #:: loop
      CyclicStream.isCyclic(cyclicList) shouldEqual true
    }

    "can be acyclic" in {
      val acyclicList = 3 #:: 2 #:: 4 #:: 6 #:: 2 #:: Stream.empty
      CyclicStream.isCyclic(acyclicList) shouldEqual false
    }

    "can be empty" in {
      CyclicStream.isCyclic(Stream.empty) shouldEqual false
    }

    "can be trivial" in {
      CyclicStream.isCyclic(3 #:: Stream.empty) shouldEqual false
    }
  }
}
