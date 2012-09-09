package com.noelmarkham.anagram

import scalaz._
import Scalaz._

object Stem {
  def apply(word: String): Stem = {
    val stem: List[Char] = word.toLowerCase.trim.toList.sorted
    new Stem(stem)
  }
}

case class Stem private(stem: List[Char])

class AnagramFinder(words: List[String]) {

  implicit def string2Stem(s: String): Stem = Stem(s)

  val mapping = words.map(word => Map(Stem(word) -> Set(word))) reduceLeft (_ |+| _)

  def find(word: String): Option[Set[String]] = mapping.get(word)
}

object Anagrams {

  def apply(wordListFile: String, word: String) = {
    val finder = new AnagramFinder(scala.io.Source.fromFile(wordListFile).getLines().toList)
    finder.find(word)
  }
}
