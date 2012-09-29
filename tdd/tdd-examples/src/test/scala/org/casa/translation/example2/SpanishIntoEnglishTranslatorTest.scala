package org.casa.translation.example2

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{BeforeAndAfter, FunSuite}

class SpanishIntoEnglishTranslatorTest
    extends FunSuite with ShouldMatchers with BeforeAndAfter {

  var translator: SpanishIntoEnglishTranslator = _

  before {
    translator = new SpanishIntoEnglishTranslator()
  }

  test("translates what it can") {
    translator.translate("yo soy") should be("I am")
  }

  test("mmmehs what it can't") {
    translator.translate("dame argo") should be("mmmeh mmmeh")
  }
}