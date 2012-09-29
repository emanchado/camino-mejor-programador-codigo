package org.casa.unitconvert.step1.functional

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.matchers.ShouldMatchers
import org.apache.http.client.fluent.Request
import org.eclipse.jetty.server.Server
import org.casa.unitconvert.step1.Converter

class ConversionTest
    extends FunSuite with ShouldMatchers with BeforeAndAfter {

  test("Converts miles into kilometers") {
    get("http://localhost:8080/1.0") should be("1.609")
  }

  def get(url: String): String = {
    Request.Get(url).execute().returnContent().asString()
  }

  var converter: Server = _

  before {
    converter = Converter.start(8080)
  }

  after {
    converter.stop()
  }
}