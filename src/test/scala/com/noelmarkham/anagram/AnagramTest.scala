package com.noelmarkham.anagram

import org.scalatest.FunSuite

class AnagramTest extends FunSuite {

  test("List of words should create appropriate map") {
    val testMap:Map[List[Char], List[String]] = Map("abc".toList -> List("cba"), "def".toList -> List("def"), "ggz".toList -> List("zgg"))
    val givenList = List("cba", "def", "zgg")

    val mapping = new Anagram(givenList).mapping
    assert(mapping == testMap)
  }
  
  test("Same stemmed words should both exist in the map") {
    val testMap:Map[List[Char], List[String]] = Map("abc".toList -> List("abc", "cba"))
    val givenList = List("abc", "cba")

    val mapping = new Anagram(givenList).mapping
    assert(mapping == testMap)
  }

  test("Finding words") {
    val givenList = List("abc", "cba", "bob", "bca")

    val anagramFinder = new Anagram(givenList)

    val foundAnagrams = anagramFinder.find("abc")

    val expected = List("abc", "bca", "cba")

    assert(foundAnagrams.forall(s => expected contains s))
    assert(expected.forall(s => foundAnagrams contains s))
  }
}
