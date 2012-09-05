package com.noelmarkham.anagram

import scalaz._
import Scalaz._

case class Stem(word: String) {
  val stem: List[Char] = word.toList.sortWith((e1, e2) => (e1 < e2))

  override def equals(p1: Any) = p1 match {
    case s: Stem => s.stem == stem
    case _ => false
  }
}

class AnagramFinder(words:List[String]) {

  val mapping = createMapping(words)


  def createMapping(words: List[String]) = {
    var anagrams: Map[Stem, List[String]] = Map()

    // todo make this work with mutable map? (add a semigroup for mutable maps?)
    words.foreach(s => anagrams = anagrams |+| Map(Stem(s) -> List(s)))

    anagrams
  }
  
  def find(word: String): List[String] = {
    mapping(Stem(word))
  }
}
