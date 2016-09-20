package com.peterpotts.interview

import scala.collection.mutable

object BreadthFirstBinaryTreeWalker {
  def walk(root: Node): List[Int] = {
    val output = mutable.Buffer.empty[Int]
    val input = mutable.Queue(root)

    def hasNext: Boolean = input.nonEmpty

    def next(): Unit = {
      val node = input.dequeue()
      output += node.value

      if (node.left.isDefined) {
        input.enqueue(node.left.get)
      }

      if (node.right.isDefined) {
        input.enqueue(node.right.get)
      }
    }

    while (hasNext) next()

    output.toList
  }
}
