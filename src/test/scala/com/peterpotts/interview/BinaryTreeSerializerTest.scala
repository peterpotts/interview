package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class BinaryTreeSerializerTest extends WordSpec with Matchers {
  "A binary tree serializer" should {
    "serialize and deserialize" in {
      val expected = Node(Node(1, Node(2)), 3, Node(Node(4), 5, Node(Node(6), 7)))
      println(BinaryTreeSerializer.serialize(expected))
      BinaryTreeSerializer.deserialize(BinaryTreeSerializer.serialize(expected)) shouldEqual expected
    }
  }
}
