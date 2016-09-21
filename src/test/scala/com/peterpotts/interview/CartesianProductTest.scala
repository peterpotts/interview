package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class CartesianProductTest extends WordSpec with Matchers {
  "A cartesian product" should {
    "evaluate" in {
      val input = Seq(Seq(1, 2, 3), Seq(4, 5), Seq(6, 7, 8))
      val expected = input.map(_.size).product
      val actual = CartesianProduct(input).size
      actual shouldEqual expected
    }
  }
}
