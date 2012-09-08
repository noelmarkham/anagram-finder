package com.noelmarkham.anagram

import org.scalatest.FunSuite

class SystemTest extends FunSuite {

  test("dictionary") {

    val expected = Some(Set("cat", "act"))

    val words = """noel
                   leon
                   abc
                   cat
                   act""".mkString.split('\n').toList

    val finder = new AnagramFinder(words)

    val actual = finder.find("cat")

    assert(expected == actual)
  }

  test("Full test") {

    val expected = Some(Set("act", "cat"))
    val actual = Anagrams("/usr/share/dict/words", "cat")

    assert(expected == actual)
  }
}
