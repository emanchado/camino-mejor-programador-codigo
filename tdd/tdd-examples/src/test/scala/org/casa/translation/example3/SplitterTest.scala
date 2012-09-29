package org.casa.translation.example3

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SplitterTest extends FunSuite with ShouldMatchers {
  test("splits by space") {
    Splitter("xxx xx") should be(Seq("xxx", "xx"))
  }

  test("splits by change of line") {
    Splitter("xxx\nxx") should be(Seq("xxx", "xx"))
  }
}