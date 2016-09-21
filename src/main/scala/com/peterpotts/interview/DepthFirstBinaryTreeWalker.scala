package com.peterpotts.interview

import scala.collection.mutable

/**
  * Traversal can be pre-order, in-order or post-order. This implementation is in-order traversal.
  */
object DepthFirstBinaryTreeWalker {
  def walk(root: Node): List[Int] = {
    val output = mutable.Buffer.empty[Int]
    val input = mutable.Stack[Any](root)

    def hasNext: Boolean = input.nonEmpty

    def next(): Unit = input.pop() match {
      case value: Int =>
        output += value
      case node: Node =>
        if (node.right.isDefined) input.push(node.right.get)
        input.push(node.value)
        if (node.left.isDefined) input.push(node.left.get)
    }

    while (hasNext) next()

    output.toList
  }
}
