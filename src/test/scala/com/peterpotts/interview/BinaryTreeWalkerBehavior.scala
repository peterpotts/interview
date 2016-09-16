package com.peterpotts.interview

import com.peterpotts.interview.BinaryTreeWalker._
import org.scalatest.{Matchers, WordSpec}

trait BinaryTreeWalkerBehavior {
  self: WordSpec with Matchers =>
  val name: String

  def fixture(test: BinaryTreeWalker => Any): Any

  s"A $name binary tree walker" should {
    "walk" in fixture { target =>
      val node = Node(Node(Node(1, Node(2)), 3, Node(4)), 5, Node(Node(6), 7, Node(8, Node(9))))
      target.walk(node) shouldEqual (1 to 9).toList
    }
  }
}
