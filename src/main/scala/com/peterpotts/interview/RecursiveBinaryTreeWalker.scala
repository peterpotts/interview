package com.peterpotts.interview

import com.peterpotts.interview.BinaryTreeWalker._

object RecursiveBinaryTreeWalker extends BinaryTreeWalker {
  def walk(node: Node): List[Int] =
    node.left.toList.flatMap(walk) ++ List(node.value) ++ node.right.toList.flatMap(walk)
}
