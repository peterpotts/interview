package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

import scala.collection.immutable.IndexedSeq

class BinarySearchIndexedSeqTest extends WordSpec with Matchers {
  "A binary search" should {
    "find" in {
      BinarySearchIndexedSeq.indexOf(IndexedSeq(1, 4, 6, 7, 9), 7) shouldEqual Some(3)
    }

    "not find middle" in {
      BinarySearchIndexedSeq.indexOf(IndexedSeq(1, 4, 6, 7, 9), 5) shouldEqual None
    }

    "not find left" in {
      BinarySearchIndexedSeq.indexOf(IndexedSeq(1, 4, 6, 7, 9), 0) shouldEqual None
    }

    "not find right" in {
      BinarySearchIndexedSeq.indexOf(IndexedSeq(1, 4, 6, 7, 9), 10) shouldEqual None
    }

    "find first" in {
      BinarySearchIndexedSeq.indexOf(IndexedSeq(1, 4, 6, 7, 9), 1) shouldEqual Some(0)
    }

    "find last" in {
      BinarySearchIndexedSeq.indexOf(IndexedSeq(1, 4, 6, 7, 9), 9) shouldEqual Some(4)
    }
  }
}
