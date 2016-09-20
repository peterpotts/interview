package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class BreathFirstBinaryTreeWalkerTest extends WordSpec with Matchers {
  "A breadth first binary tree walker" should {
    "walk a normal tree" in {
      val node = Node(Node(Node(1, Node(2)), 3, Node(4)), 5, Node(Node(6), 7, Node(8, Node(9))))
      BreadthFirstBinaryTreeWalker.walk(node) shouldEqual List(5, 3, 7, 1, 4, 6, 8, 2, 9)
    }

    "walk a left branch" in {
      val node = Node(Node(Node(Node(1), 2), 3), 4)
      BreadthFirstBinaryTreeWalker.walk(node) shouldEqual List(4, 3, 2, 1)
    }

    "walk a right branch" in {
      val node = Node(1, Node(2, Node(3, Node(4))))
      BreadthFirstBinaryTreeWalker.walk(node) shouldEqual List(1, 2, 3, 4)
    }

    "walk a stump" in {
      val node = Node(1)
      BreadthFirstBinaryTreeWalker.walk(node) shouldEqual List(1)
    }
  }
}
