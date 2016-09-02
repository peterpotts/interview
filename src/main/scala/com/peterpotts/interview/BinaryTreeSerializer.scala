package com.peterpotts.interview

object BinaryTreeSerializer extends App {
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
            case Leaf #:: more => (Node(char, None, None), more)
            case Left #:: argument =>
              val (left, more) = loop(argument)
              Node(char, Some(left), None) -> more
            case Right #:: argument => Node(char, None, None)
              val (right, more) = loop(argument)
              Node(char, None, Some(right)) -> more
            case Fork #:: arguments => Node(char, None, None)
              val (left, argument) = loop(arguments)
              val (right, more) = loop(argument)
              Node(char, Some(left), Some(right)) -> more
          }
      }

    val (node, more) = loop(stream)
    require(more.isEmpty)
    node
  }
}

case class Node(value: Char, left: Option[Node], right: Option[Node])

sealed trait Chunk

case class Value(char: Char) extends Chunk

case object Leaf extends Chunk

case object Left extends Chunk

case object Right extends Chunk

case object Fork extends Chunk
