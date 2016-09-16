package com.peterpotts.interview

object BinaryTreeSerializer {
  def serialize(root: Node): Stream[Chunk] =
    Value(root.value) #:: {
      root match {
        case Node(value, None, None) =>
          Leaf #:: Stream.empty
        case Node(value, Some(left), None) =>
          Left #:: serialize(left)
        case Node(value, None, Some(right)) =>
          Right #:: serialize(right)
        case Node(value, Some(left), Some(right)) =>
          Fork #:: (serialize(left) ++ serialize(right))
      }
    }

  def deserialize(stream: Stream[Chunk]): Node = {
    def loop(stream: Stream[Chunk]): (Node, Stream[Chunk]) =
      stream match {
        case Value(char) #:: branch =>
          branch match {
            case Leaf #:: zero => (Node(char, None, None), zero)
            case Left #:: one =>
              val (left, zero) = loop(one)
              Node(char, Some(left), None) -> zero
            case Right #:: one => Node(char, None, None)
              val (right, zero) = loop(one)
              Node(char, None, Some(right)) -> zero
            case Fork #:: two => Node(char, None, None)
              val (left, one) = loop(two)
              val (right, zero) = loop(one)
              Node(char, Some(left), Some(right)) -> zero
          }
      }

    val (node, empty) = loop(stream)
    require(empty.isEmpty)
    node
  }

  case class Node(value: Char, left: Option[Node], right: Option[Node])

  sealed trait Chunk

  case class Value(char: Char) extends Chunk

  case object Leaf extends Chunk

  case object Left extends Chunk

  case object Right extends Chunk

  case object Fork extends Chunk

}
