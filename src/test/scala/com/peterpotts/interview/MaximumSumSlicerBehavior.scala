package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

trait MaximumSumSlicerBehavior {
  self: WordSpec with Matchers =>
  val name: String

  def fixture(test: MaximumSumSlicer => Any): Any

  s"A $name maximum sum slicer" should {
    "work in normal case" in fixture { target =>
      target.slice(Array(-5, 10, -3, 12, -6)) shouldEqual 19
    }

    "work in degenerate case" in fixture { target =>
      target.slice(Array(-5, -3, -6)) shouldEqual -3
    }
  }
}
