package org.casa.translation.example0

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.matchers.ShouldMatchers

class MilesToKilometersConverterTest
    extends FunSuite with ShouldMatchers with BeforeAndAfter {

  test("Converts miles into kilometers") {
    MilesToKilometersConverter.convert(1.0) should be(1.609)
  }

  test("Converts negative miles into kilometers") {
    MilesToKilometersConverter.convert(-2.0) should be(-3.218)
  }
}