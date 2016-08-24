package com.peterpotts.interview

object Factorial {
  def apply(n: Long): Long = if (n == 0) 1 else n * apply(n - 1)
}
