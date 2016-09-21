package com.peterpotts.interview

import org.scalatest.{Matchers, WordSpec}

import scala.collection.immutable.Seq
import scala.util.Random

class TwinCakeTest extends WordSpec with Matchers {
  "A twin cake" should {
    "be shared if possible" in {
      val cherries = Seq[Double](20, 30, 40, 270)
      val theta = TwinCake.slice(cherries)
      theta shouldEqual Some[Double](25)
    }

    "be not shared if not possible" in {
      val cherries = Seq[Double](20, 20, 200, 200)
      val theta = TwinCake.slice(cherries)
      theta shouldEqual None
    }

    "be shared even if multiple cherries on same angle" in {
      val cherries = Seq[Double](20, 30, 40, 200)
      val theta = TwinCake.slice(cherries)
      theta shouldEqual Some[Double](35)
    }

    "be shared if random" in {
      val cherries = Seq.fill(2 + Random.nextInt(10) * 2)(Random.nextDouble() * 360.0)
      val theta = TwinCake.slice(cherries)
      theta.isDefined shouldEqual true
    }
  }
}