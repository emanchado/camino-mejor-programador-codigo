package org.casa.unitconvert.step3.functional

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.matchers.ShouldMatchers
import org.apache.http.client.fluent.Request
import org.eclipse.jetty.server.Server
import org.casa.unitconvert.step3.Converter
import java.io.ByteArrayOutputStream

class ConversionTest
    extends FunSuite with ShouldMatchers with BeforeAndAfter {

  test("Converts miles into kilometers") {
    get("http://localhost:8080/1.0") should be("1.609")
  }

  test("Converts negative miles into kilometers") {
    get("http://localhost:8080/-2.0") should be("-3.218")
  }

  test("Responds with 400 (Bad Request) and error message to unparseable amounts of miles") {
    statusCode("http://localhost:8080/blah") should be(400)
    get("http://localhost:8080/blah") should be("Miles incorrectly specified: /blah")
  }

  test("Responds with 400 to no miles") {
    statusCode("http://localhost:8080") should be(400)
  }

  test("Responds with 400 to requests with extraneous elements in the path"){
    statusCode("http://localhost:8080/blah/1.0") should be(400)
  }

  test("Ignores query string"){
    get("http://localhost:8080/1.0?user=myself") should be("1.609")
    statusCode("http://localhost:8080/blah?user=myself") should be(400)
  }

  def get(url: String): String = {
    val byteArrayOutputStream = new ByteArrayOutputStream()
    Request.Get(url).execute().returnResponse().getEntity.writeTo(byteArrayOutputStream)
    byteArrayOutputStream.toString
  }

  def statusCode(uri: String): Int = {
    Request.Get(uri).execute().returnResponse().getStatusLine.getStatusCode
  }

  var converter: Server = _

  before {
    converter = Converter.start(8080)
  }

  after {
    converter.stop()
  }
}