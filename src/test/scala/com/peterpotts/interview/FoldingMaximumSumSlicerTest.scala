package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class FoldingMaximumSumSlicerTest extends WordSpec with Matchers with MaximumSumSlicerBehavior {
  lazy val name = "folding"

  def fixture(test: MaximumSumSlicer => Any): Any = test(FoldingMaximumSumSlicer)
}
