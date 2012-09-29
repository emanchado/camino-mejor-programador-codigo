package org.casa.unitconvert.step2

import org.scalatest.FunSuite
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.mockito.Mockito._
import java.io.PrintWriter

class ConverterTest extends FunSuite {
  test("Responds to get requests converting miles into kilometers") {
    val response = mock(classOf[HttpServletResponse])
    val printWriter = mock(classOf[PrintWriter])
    when(response.getWriter).thenReturn(printWriter)

    val request = mockedRequestWithPath("/1.0")
    new Converter().doGet(request, response)

    verify(printWriter).print(1.609)
  }

  test("Responds to get requests converting miles into kilometers for a negative amount of miles") {
    val response = mock(classOf[HttpServletResponse])
    val printWriter = mock(classOf[PrintWriter])
    when(response.getWriter).thenReturn(printWriter)

    val request = mockedRequestWithPath("/-2.0")
    new Converter().doGet(request, response)

    verify(printWriter).print(-3.218)
  }

  def mockedRequestWithPath(path: String): HttpServletRequest = {
    val request = mock(classOf[HttpServletRequest])
    when(request.getRequestURI).thenReturn(path)

    request
  }
}