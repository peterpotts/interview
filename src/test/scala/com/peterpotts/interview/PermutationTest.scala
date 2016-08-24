package com.peterpotts.interview

import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

import scala.util.Random

class PermutationTest extends WordSpec with Matchers with MockitoSugar {
  "A permutation" should {
    "have predictable size" in {
      val n = Random.nextInt(10) + 1
      val seq = 0 until n
      val combinations = Permutation.permutations(seq)
      val expected = Factorial(n)
      val actual = combinations.size
      actual shouldEqual expected
    }
  }
}

