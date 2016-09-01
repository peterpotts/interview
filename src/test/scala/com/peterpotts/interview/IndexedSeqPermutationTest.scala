package com.peterpotts.interview

import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

import scala.util.Random

class IndexedSeqPermutationTest extends WordSpec with Matchers with MockitoSugar {
  "An indexed sequence permutation" should {
    "have predictable size" in {
      val n = Random.nextInt(5) + 1
      val seq = 0 until n
      val combinations = IndexedSeqPermutation.permutations(seq)
      val expected = Factorial(n)
      val actual = combinations.size
      actual shouldEqual expected
    }
  }
}
