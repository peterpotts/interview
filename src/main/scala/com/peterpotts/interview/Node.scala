package com.peterpotts.interview

case class Node(left: Option[Node], value: Int, right: Option[Node])

object Node {
  def apply(left: Node, value: Int, right: Node): Node = Node(Some(left), value, Some(right))

  def apply(left: Node, value: Int): Node = Node(Some(left), value, None)

  def apply(value: Int, right: Node): Node = Node(None, value, Some(right))

  def apply(value: Int): Node = Node(None, value, None)
}
