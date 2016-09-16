package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

trait BinaryTreeWalkerBehavior {
  self: WordSpec with Matchers =>
  val name: String

  def fixture(test: BinaryTreeWalker => Any): Any

  s"A $name binary tree walker" should {
    "walk a normal tree" in fixture { target =>
      val node = Node(Node(Node(1, Node(2)), 3, Node(4)), 5, Node(Node(6), 7, Node(8, Node(9))))
      target.walk(node) shouldEqual (1 to 9).toList
    }

    "walk a left branch" in fixture { target =>
      val node = Node(Node(Node(Node(1), 2), 3), 4)
      target.walk(node) shouldEqual (1 to 4).toList
    }

    "walk a right branch" in fixture { target =>
      val node = Node(1, Node(2, Node(3, Node(4))))
      target.walk(node) shouldEqual (1 to 4).toList
    }

    "walk a stump" in fixture { target =>
      val node = Node(1)
      target.walk(node) shouldEqual List(1)
    }
  }
}
