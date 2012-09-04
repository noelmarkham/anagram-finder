package com.noelmarkham.anagram

import scalaz._
import Scalaz._

case class Word(word: String) {
  def stem: List[Char] = {
    word.toList.sortWith((e1, e2) => (e1 < e2))
  }
}

class Anagram(words:List[String]) {

  val mapping = createMapping(words)

  def createMapping(words: List[String]): Map[List[Char], List[String]] = {
    var anagrams: Map[List[Char], List[String]] = Map()
    words.foreach(s => anagrams = anagrams |+| Map(Word(s).stem -> List(s)))

    anagrams
  }
}
