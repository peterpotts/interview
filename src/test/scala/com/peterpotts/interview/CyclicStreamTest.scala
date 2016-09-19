package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class CyclicStreamTest extends WordSpec with Matchers {
  "A cyclic stream" should {
    "can be identified" in {
      lazy val loop: Stream[Int] = 4 #:: 6 #:: 2 #:: loop
      val cyclicList = 3 #:: 2 #:: loop
      CyclicStream.isCyclic(cyclicList) shouldEqual true
    }

    "can be not identified" in {
      val acyclicList = 3 #:: 2 #:: 4 #:: 6 #:: 2 #:: Stream.empty
      CyclicStream.isCyclic(acyclicList) shouldEqual false
    }
  }
}
