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
    val output = mutable.Stack[Chunk]()

    def hasNext = output.size > 1 && output.head.isInstanceOf[ValueLeftRight]

    def next(): Unit = {
      val ValueLeftRight(node) = output.pop()

      output.pop() match {
        case Value(value) =>
          output.push(ValueLeft(value, node))
        case ValueLeft(value, left) =>
          output.push(ValueLeftRight(Some(Node(left, value, node))))
        case error =>
          throw new MatchError(error)
      }
    }

    list.foreach {
      case Some(value) =>
        output.push(Value(value))
      case None =>
        output.push(ValueLeftRight(None))
        while (hasNext) next()
    }

    val ValueLeftRight(node) = output.pop()
    node.get
  }
}

sealed trait Chunk

case class Value(value: Int) extends Chunk

case class ValueLeft(value: Int, left: Option[Node]) extends Chunk

case class ValueLeftRight(node: Option[Node]) extends Chunk