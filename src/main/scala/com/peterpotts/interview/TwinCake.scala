package com.peterpotts.interview

import scala.collection.immutable.Seq

case class Point(x: Double, y: Double)

object TwinCake {
  private val radius = 100.0

  def cut(cherries: Seq[Point]): Option[Point] = {
    def angle(point: Point) = math.toDegrees(math.atan2(point.y, point.x))

    slice(cherries.map(angle)).map { theta =>
      Point(radius * math.cos(math.toRadians(theta)), radius * math.sin(math.toRadians(theta)))
    }
  }

  def slice(cherries: Seq[Double]): Option[Double] = {
    val vectors: Seq[(Double, Int)] = cherries.map { angle =>
      if (angle < 180.0) angle -> 1 else (angle - 180.0) -> -1
    }

    val dedupedVectors: Seq[(Double, Int)] = vectors.groupBy(_._1).mapValues(_.map(_._2).sum).toIndexedSeq.sortBy(_._1)
    val angles: Seq[Double] = dedupedVectors.map(_._1)
    val directions: Seq[Int] = dedupedVectors.map(_._2)
    val half = directions.sum / 2
    val sums = directions.scan(0)(_ + _).tail

    if (angles.size < 2) {
      None
    } else {
      sums.zipWithIndex.find(_._1 == half).map(_._2).flatMap { index =>
        if (index + 1 == angles.size) {
          // Wrap
          val preAngle = angles(index)
          val postAngle = angles.head + 180.0
          val angle = (preAngle + postAngle) / 2.0
          Some(if (angle < 180.0) angle else angle - 180.0)
        } else {
          // No wrap
          val preAngle = angles(index)
          val postAngle = angles(index + 1)
          Some((preAngle + postAngle) / 2.0)
        }
      }
    }
  }
}
