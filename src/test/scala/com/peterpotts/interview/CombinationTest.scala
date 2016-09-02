package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

import scala.util.Random

class CombinationTest extends WordSpec with Matchers {
  "A combination" should {
    "have predictable size" in {
      val n = Random.nextInt(10) + 1
      val k = Random.nextInt(n)
      val combinations = Combination.combinations(k, n)
      val expected = Factorial(n) / (Factorial(k) * Factorial(n - k))
      val actual = combinations.size
      actual shouldEqual expected
    }
  }
}
