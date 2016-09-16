package com.peterpotts.interview

object RecursiveBinaryTreeWalker extends BinaryTreeWalker {
  def walk(node: Node): List[Int] =
    node.left.toList.flatMap(walk) ++ List(node.value) ++ node.right.toList.flatMap(walk)
}
