package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class RecursiveBinaryTreeWalkerTest extends WordSpec with Matchers with BinaryTreeWalkerBehavior {
  lazy val name = "recursive"

  def fixture(test: BinaryTreeWalker => Any): Any = test(RecursiveBinaryTreeWalker)
}
