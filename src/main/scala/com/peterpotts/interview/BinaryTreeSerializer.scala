package com.peterpotts.interview

import scala.collection.mutable

object BinaryTreeSerializer {
  def serialize(root: Node): List[Option[Int]] = {
    val input = mutable.Stack[Option[Node]](Some(root))
    val output = mutable.Buffer.empty[Option[Int]]

    def hasNext: Boolean = input.nonEmpty

    def next(): Unit = input.pop() match {
      case Some(node) =>
        input.push(node.right)
        input.push(node.left)
        output += Some(node.value)
      case None =>
        output += None
      }

    while (hasNext) next()
    output.toList
  }

  def deserialize(list: List[Option[Int]]): Node = {
    var input = list
    val output = mutable.Stack[Option[Node]]()

    def hasNext: Boolean = input.isEmpty

    def next(): Unit = {
      val head = input.head
      input = input.tail

      head match {
        case Some(value) =>

        case None =>
          output.push(None)
      }

    }

    while (hasNext) next()
    println(input)
    println(output)
    println("-----------------")
    output.head.get
  }
}
