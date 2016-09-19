package com.peterpotts.interview

object CyclicStream {
  def isCyclic[T](stream: Stream[T]): Boolean = {
    var slow = stream
    var fast = stream

    def hasNext: Boolean = fast.nonEmpty && fast.tail.nonEmpty

    def next(): Unit = {
      slow = slow.tail
      fast = fast.tail.tail
    }

    def hasCycled: Boolean = fast == slow || fast.tail == slow

    if (hasNext) {
      next()
      while (hasNext && !hasCycled) next()
      hasNext
    } else {
      false
    }
  }
}
