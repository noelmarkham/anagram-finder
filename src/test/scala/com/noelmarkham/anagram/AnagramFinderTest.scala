package com.noelmarkham.anagram

import org.scalatest.FunSuite

class AnagramFinderTest extends FunSuite {

  test("List of words should create appropriate map") {
    val testMap:Map[Stem, Set[String]] = Map(Stem("abc") -> Set("cba"), Stem("def") -> Set("def"), Stem("ggz") -> Set("zgg"))
    val givenList = List("cba", "def", "zgg")

    val mapping = new AnagramFinder(givenList).mapping
    assert(mapping == testMap)
  }
  
  test("Same stemmed words should both exist in the map") {
    val testMap:Map[Stem, Set[String]] = Map(Stem("abc") -> Set("abc", "cba"))
    val givenList = List("abc", "cba")

    val mapping = new AnagramFinder(givenList).mapping
    assert(mapping == testMap)
  }

  test("Finding words") {
    val givenList = List("abc", "cba", "bob", "bca")

    val anagramFinder = new AnagramFinder(givenList)

    val foundAnagrams = anagramFinder.find("abc").get

    val expected = Set("abc", "bca", "cba")

    assert(foundAnagrams.forall(s => expected contains s))
    assert(expected.forall(s => foundAnagrams contains s))
  }
}
