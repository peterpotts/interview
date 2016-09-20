package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class BinarySearchTreeTest extends WordSpec with Matchers {
  "A binary search tree" should {
    "find" in {
      val root = Node(Node(Node(1), 3, Node(4)), 5, Node(Node(7), 10, Node(12)))
      BinarySearchTree.contains(root, 7) shouldEqual true
    }

    "not find" in {
      val root = Node(Node(Node(1), 3, Node(4)), 5, Node(Node(7), 10, Node(12)))
      BinarySearchTree.contains(root, 6) shouldEqual false
    }
  }
}
