package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

import scala.util.Random

class SeqPermutationTest extends WordSpec with Matchers {
  "A sequence permutation" should {
    "have predictable size" in {
      val n = Random.nextInt(5) + 1
      val seq = 0 until n
      val combinations = SeqPermutation.permutations(seq)
      val expected = Factorial(n)
      val actual = combinations.size
      actual shouldEqual expected
    }
  }
}
