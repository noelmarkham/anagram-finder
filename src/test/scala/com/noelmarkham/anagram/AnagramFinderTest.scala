package com.noelmarkham.anagram

import org.scalatest.FunSuite

class AnagramFinderTest extends FunSuite {

  test("List of words should create appropriate map") {
    val testMap:Map[Stem, List[String]] = Map(Stem("abc") -> List("cba"), Stem("def") -> List("def"), Stem("ggz") -> List("zgg"))
    val givenList = List("cba", "def", "zgg")

    val mapping = new AnagramFinder(givenList).mapping
    assert(mapping == testMap)
  }
  
  test("Same stemmed words should both exist in the map") {
    val testMap:Map[Stem, List[String]] = Map(Stem("abc") -> List("abc", "cba"))
    val givenList = List("abc", "cba")

    val mapping = new AnagramFinder(givenList).mapping
    assert(mapping == testMap)
  }

  test("Finding words") {
    val givenList = List("abc", "cba", "bob", "bca")

    val anagramFinder = new AnagramFinder(givenList)

    val foundAnagrams = anagramFinder.find("abc")

    val expected = List("abc", "bca", "cba")

    assert(foundAnagrams.forall(s => expected contains s))
    assert(expected.forall(s => foundAnagrams contains s))
  }
}
