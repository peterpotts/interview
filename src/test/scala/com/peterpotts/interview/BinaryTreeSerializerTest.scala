package com.peterpotts.interview

import com.peterpotts.interview.BinaryTreeSerializer._
import org.scalatest.{Matchers, WordSpec}

class BinaryTreeSerializerTest extends WordSpec with Matchers {
  "A binary tree serializer" should {
    "serialize and deserialize" in {
      val expected = Node(
        'a',
        Some(Node('d', None, None)),
        Some(Node(
          'c',
          Some(Node('d', None, None)),
          Some(Node('e', None, None)))))

      BinaryTreeSerializer.deserialize(BinaryTreeSerializer.serialize(expected)) shouldEqual expected
    }
  }
}
