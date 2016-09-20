package com.peterpotts.interview

import scala.collection.mutable

object DepthFirstBinaryTreeWalker {
  def walk(node: Node): List[Int] = {
    val output = mutable.Buffer.empty[Int]
    val input = mutable.Stack[Any](node)

    def hasNext: Boolean = input.nonEmpty

    def next(): Unit = input.pop() match {
      case value: Int =>
        output += value
      case node: Node =>
        if (node.right.isDefined) {
          input.push(node.right.get)
        }

        input.push(node.value)

        if (node.left.isDefined) {
          input.push(node.left.get)
        }
    }

    while (hasNext) next()

    output.toList
  }
}
