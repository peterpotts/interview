package com.peterpotts.interview

object BinaryTreeSerializer {
  def serialize(root: Node): Stream[Chunk] =
    Value(root.value) #:: {
      root match {
        case Node(None, value, None) =>
          Leaf #:: Stream.empty
        case Node(Some(left), value, None) =>
          Left #:: serialize(left)
        case Node(None, value, Some(right)) =>
          Right #:: serialize(right)
        case Node(Some(left), value, Some(right)) =>
          Fork #:: (serialize(left) ++ serialize(right))
      }
    }

  def deserialize(stream: Stream[Chunk]): Node = {
    def loop(stream: Stream[Chunk]): (Node, Stream[Chunk]) =
      stream match {
        case Value(value) #:: branch =>
          branch match {
            case Leaf #:: zero => (Node(value), zero)
            case Left #:: one =>
              val (left, zero) = loop(one)
              Node(left, value) -> zero
            case Right #:: one => Node(value)
              val (right, zero) = loop(one)
              Node(value, right) -> zero
            case Fork #:: two => Node(value)
              val (left, one) = loop(two)
              val (right, zero) = loop(one)
              Node(left, value, right) -> zero
          }
      }

    val (node, empty) = loop(stream)
    require(empty.isEmpty)
    node
  }
}

sealed trait Chunk

case class Value(value: Int) extends Chunk

case object Leaf extends Chunk

case object Left extends Chunk

case object Right extends Chunk

case object Fork extends Chunk
