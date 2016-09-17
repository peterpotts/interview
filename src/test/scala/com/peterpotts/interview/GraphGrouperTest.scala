package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

import scala.collection.immutable.Seq

class GraphGrouperTest extends WordSpec with Matchers {
  "A graph grouper" should {
    "find in group" in {
      val grouper = GraphGrouper(5, Seq(0 -> 2, 1 -> 3, 1 -> 4, 1 -> 2))
      grouper.grouped(0, 4) shouldEqual true
    }

    "not find in group" in {
      val grouper = GraphGrouper(5, Seq(0 -> 2, 1 -> 3, 1 -> 4))
      grouper.grouped(0, 4) shouldEqual false
    }
  }
}