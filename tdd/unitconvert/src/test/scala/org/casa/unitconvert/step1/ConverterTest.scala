package org.casa.unitconvert.step1

import org.scalatest.FunSuite
import javax.servlet.http.{HttpServletResponse, HttpServletRequest}
import org.mockito.Mockito._
import java.io.PrintWriter

class ConverterTest extends FunSuite {
  test("Responds to get requests converting miles into kilometers") {
    val response = mock(classOf[HttpServletResponse])
    val printWriter = mock(classOf[PrintWriter])
    when(response.getWriter).thenReturn(printWriter)

    new Converter().doGet(mock(classOf[HttpServletRequest]), response)

    verify(printWriter).print("1.609")
  }
}