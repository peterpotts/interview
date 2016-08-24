package com.peterpotts.interview

import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

import scala.util.Random

class BinarySearchTest extends WordSpec with Matchers with MockitoSugar {
  "A binary search" should {
    "find" in {
      BinarySearch.binarySearch(Seq(1, 4, 6, 7, 9), 7) shouldEqual Some(3)
    }

    "not find middle" in {
      BinarySearch.binarySearch(Seq(1, 4, 6, 7, 9), 5) shouldEqual None
    }

    "not find left" in {
      BinarySearch.binarySearch(Seq(1, 4, 6, 7, 9), 0) shouldEqual None
    }

    "not find right" in {
      BinarySearch.binarySearch(Seq(1, 4, 6, 7, 9), 10) shouldEqual None
    }

    "find first" in {
      BinarySearch.binarySearch(Seq(1, 4, 6, 7, 9), 1) shouldEqual Some(0)
    }

    "find last" in {
      BinarySearch.binarySearch(Seq(1, 4, 6, 7, 9), 9) shouldEqual Some(4)
    }
  }
}
