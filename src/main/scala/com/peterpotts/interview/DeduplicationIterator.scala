package com.peterpotts.interview

class DeduplicationIterator[T](iterator: Iterator[T]) extends Iterator[T] {
  private var trimmedIterator = iterator

  def hasNext: Boolean = trimmedIterator.hasNext

  def next(): T = {
    val element = trimmedIterator.next()
    trimmedIterator = trimmedIterator.dropWhile(_ == element)
    element
  }
}
