package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class ImperativeBinaryTreeWalkerTest extends WordSpec with Matchers with BinaryTreeWalkerBehavior {
  lazy val name = "imperative"

  def fixture(test: BinaryTreeWalker => Any): Any = test(ImperativeBinaryTreeWalker)
}
