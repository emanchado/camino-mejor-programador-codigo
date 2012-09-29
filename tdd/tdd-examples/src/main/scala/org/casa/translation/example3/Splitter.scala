package org.casa.translation.example3

object Splitter extends ((String) => Seq[String]) {
  def apply(s: String): Seq[String] = s split """[ \n]"""
}