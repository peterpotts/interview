package com.peterpotts.interview

import scala.annotation.tailrec

object PrettyPrint {
  def main(args: Array[String]): Unit = {
    val x = """{"a":{"b":"c"}}"""
    pretty(0, Seq.empty, x.toSeq)
  }

  @tailrec def pretty(indent: Int, left: Seq[Char], right: Seq[Char]): Unit = {
    right match {
      case '{' +: tail =>
        println("  " * indent + left.mkString + "{")
        pretty(indent + 1, Seq.empty, tail)
      case '}' +: tail =>
        if (left.nonEmpty) println("  " * indent + left.mkString)
        println("  " * (indent - 1) + "}")
        pretty(indent - 1, Seq.empty, tail)
      case head +: tail =>
        pretty(indent, left :+ head, tail)
      case _ => println("")
    }
  }
}
