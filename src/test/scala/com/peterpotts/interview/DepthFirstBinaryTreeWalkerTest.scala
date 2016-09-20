package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class DepthFirstBinaryTreeWalkerTest extends WordSpec with Matchers {
  "A depth first binary tree walker" should {
    "walk a normal tree" in {
      val node = Node(Node(Node(1, Node(2)), 3, Node(4)), 5, Node(Node(6), 7, Node(8, Node(9))))
      DepthFirstBinaryTreeWalker.walk(node) shouldEqual (1 to 9).toList
    }

    "walk a left branch" in {
      val node = Node(Node(Node(Node(1), 2), 3), 4)
      DepthFirstBinaryTreeWalker.walk(node) shouldEqual (1 to 4).toList
    }

    "walk a right branch" in {
      val node = Node(1, Node(2, Node(3, Node(4))))
      DepthFirstBinaryTreeWalker.walk(node) shouldEqual (1 to 4).toList
    }

    "walk a stump" in {
      val node = Node(1)
      DepthFirstBinaryTreeWalker.walk(node) shouldEqual List(1)
    }
  }
}
