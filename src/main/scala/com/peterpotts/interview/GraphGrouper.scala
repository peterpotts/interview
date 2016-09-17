package com.peterpotts.interview

import scala.collection.immutable.Seq

case class GraphGrouper(vertices: Int, edges: Seq[(Int, Int)]) {
  private val forward: Array[Option[Int]] = Array.fill(vertices)(None)
  private val backward: Array[Option[Int]] = Array.fill(vertices)(None)

  private def scanLeft(x: Int): Int = {
    var scan = x
    var left = backward(scan)

    while (left.isDefined) {
      scan = left.get
      left = backward(scan)
    }

    scan
  }

  private def zip(x: Int, y: Int): Unit = {
    var left = math.min(x, y)
    var right = math.max(x, y)
    var middle = forward(left)

    while (middle.isDefined) {
      if (middle.get < right) {
        left = middle.get
      } else {
        forward(left) = Some(right)
        backward(right) = Some(left)
        left = right
        right = middle.get
      }

      middle = forward(left)
    }

    forward(left) = Some(right)
    backward(right) = Some(left)
  }

  private def link(x: Int, y: Int): Unit = {
    val a = scanLeft(x)
    val b = scanLeft(y)
    if (a != b) zip(a, b)
  }

  edges.foreach((link _).tupled)

  def grouped(x: Int, y: Int): Boolean = {
    var left = math.min(x, y)
    val right = math.max(x, y)
    var middle = forward(left)

    while (middle.isDefined && middle.get < right) {
      left = middle.get
      middle = forward(left)
    }

    middle contains right
  }
}
