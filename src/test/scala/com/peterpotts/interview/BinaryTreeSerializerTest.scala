package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

class BinaryTreeSerializerTest extends WordSpec with Matchers {
  "A binary tree serializer" should {
    "serialize and deserialize" in {
      val expected = Node(Node(1), 2, Node(Node(3), 4, Node(5)))
      BinaryTreeSerializer.deserialize(BinaryTreeSerializer.serialize(expected)) shouldEqual expected
    }
  }
}
