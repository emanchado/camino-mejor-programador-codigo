package org.casa.unitconvert.step3

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{ServletHolder, ServletContextHandler}

class Converter extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val milesAsString = req.getRequestURI.substring(1)
    try {
      val miles = milesAsString.toDouble
      resp.getWriter.print(miles * 1.609)
    }
    catch {
      case _: NumberFormatException => {
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST)
        resp.getWriter.print("Miles incorrectly specified: " + req.getRequestURI)
      }
    }
  }
}

object Converter {
  def main(args: Array[String]) {
    start(8080)
  }

  def start(port: Int): Server = {
    val context = new ServletContextHandler()
    context.setContextPath("/")
    context.addServlet(new ServletHolder(new Converter()), "/*")

    val converter = new Server(port)
    converter.setHandler(context)

    converter.start()
    converter
  }
}