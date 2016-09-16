package com.peterpotts.interview

import com.peterpotts.interview.BinaryTreeWalker._

import scala.collection.mutable

object ImperativeBinaryTreeWalker extends BinaryTreeWalker {
  def walk(node: Node): List[Int] = {
    val set = mutable.Set.empty[Node]
    val buffer = mutable.Buffer.empty[Int]
    val stack = mutable.Stack(node)

    def next(): Unit = {
      val head = stack.head

      if (head.left.isDefined && !set.contains(head.left.get)) {
        stack.push(head.left.get)
      } else if (!set.contains(head)) {
        set += head
        buffer += head.value
      } else if (head.right.isDefined && !set.contains(head.right.get)) {
        stack.push(head.right.get)
      } else {
        stack.pop()
      }
    }

    while (stack.nonEmpty) next()

    buffer.toList
  }
}
