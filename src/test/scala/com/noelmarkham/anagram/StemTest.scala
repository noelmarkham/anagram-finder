package com.noelmarkham.anagram

class StemTest extends org.scalatest.FunSuite {

  test("Stem of noel is e,l,n,o") {
    assert(Stem("noel").stem == List('e','l','n','o'))
  }

  test("Stem of Hello is H,e,l,l,o") {
    assert(Stem("Hello").stem == List('H', 'e', 'l', 'l', 'o'))
  }

  test("Stems of abc and cba are equal") {
    assert(Stem("abc") == Stem("cba"))
  }
}
