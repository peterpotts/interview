package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class ImperativeMaximumSumSlicerTest extends WordSpec with Matchers with MaximumSumSlicerBehavior {
  lazy val name = "imperative"

  def fixture(test: MaximumSumSlicer => Any): Any = test(ImperativeMaximumSumSlicer)
}
