package com.peterpotts.interview

object BinarySearchTree {
  def contains(root: Node, value: Int): Boolean = {
    var node: Option[Node] = Some(root)

    def hasNext = node.isDefined && node.get.value != value

    def next(): Unit = if (value < node.get.value) node = node.get.left else node = node.get.right

    while (hasNext) next()

    node.isDefined
  }

}
