package com.noelmarkham.anagram

class WordTest extends org.scalatest.FunSuite {

  test("Stem of noel is e,l,n,o") {
    assert(Word("noel").stem == List('e','l','n','o'))
  }

  test("Stem of Hello is H,e,l,l,o") {
    assert(Word("Hello").stem == List('H', 'e', 'l', 'l', 'o'))
  }
}
