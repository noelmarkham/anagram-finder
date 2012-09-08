package com.noelmarkham.anagram

import scalaz._
import Scalaz._

case class Stem(word: String) {
  val stem: List[Char] = word.toLowerCase.trim.toList.sortWith((e1, e2) => (e1 < e2))

  override def equals(p1: Any) = p1 match {
    case s: Stem => s.stem == stem
    case _ => false
  }

  override def hashCode = stem.hashCode

  override def toString = stem.mkString("Stem(", "", ")")
}

class AnagramFinder(words: List[String]) {

  implicit def string2Stem(s: String): Stem = Stem(s)

  val mapping = createMapping(words)

  def createMapping(words: List[String]) = {
    var anagrams: Map[Stem, Set[String]] = Map()

    words.foreach(s => anagrams = anagrams |+| Map(Stem(s) -> Set(s)))

    anagrams
  }
  
  def find(word: String): Option[Set[String]] = mapping.get(word)
}

object Anagrams {

  def apply(wordListFile: String, word: String) = {
    val finder = new AnagramFinder(scala.io.Source.fromFile(wordListFile).mkString.split('\n').toList)
    finder.find(word)
  }
}
