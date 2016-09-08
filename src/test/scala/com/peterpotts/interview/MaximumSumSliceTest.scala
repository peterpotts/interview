package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class MaximumSumSliceTest extends WordSpec with Matchers {
  "A maximum sum slice" should {
    "work in simple case" in {
      MaximumSumSlice.simple(Array(-5, 10, -3, 12, -6)) shouldEqual 19
    }

    "work in degenerate simple case" in {
      MaximumSumSlice.simple(Array(-5, -3, -6)) shouldEqual -3
    }

    "work in fold case" in {
      MaximumSumSlice.fold(Array(-5, 10, -3, 12, -6)) shouldEqual 19
    }

    "work in degenerate fold case" in {
      MaximumSumSlice.fold(Array(-5, -3, -6)) shouldEqual -3
    }
  }
}
