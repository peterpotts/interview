package com.peterpotts.interview

import scala.annotation.tailrec

object Factorial {
  def apply(n: Long): Long = {
    @tailrec def loop(left: Long, right: Long): Long =
      if (right == 0) left else loop(left * right, right - 1)

    loop(1, n)
  }
}
