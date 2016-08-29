package com.peterpotts.interview

import org.scalatest.mock.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

class DeduplicationIteratorTest extends WordSpec with Matchers with MockitoSugar {
  "A deduplication iterator" should {
    "drop consecutive duplicate elements" in {
      val actual = new DeduplicationIterator(Iterator(1, 2, 2, 3, 3, 3, 4, 5, 6, 6, 7))
      val expected = Iterator(1, 2, 3, 4, 5, 6, 7)
      actual.toList shouldEqual expected.toList
    }

    "not drop non-consecutive duplicate elements" in {
      val actual = new DeduplicationIterator(Iterator(1, 2, 1))
      val expected = Iterator(1, 2, 1)
      actual.toList shouldEqual expected.toList
    }

    "preserve empty iterator" in {
      val actual = new DeduplicationIterator(Iterator.empty)
      val expected = Iterator.empty
      actual.toList shouldEqual expected.toList
    }
  }
}
