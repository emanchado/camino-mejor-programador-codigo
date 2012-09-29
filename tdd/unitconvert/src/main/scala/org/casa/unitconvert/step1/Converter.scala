package org.casa.unitconvert.step1

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import org.eclipse.jetty.servlet.{ServletHolder, ServletContextHandler}
import org.eclipse.jetty.server.Server

class Converter extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    resp.getWriter.print("1.609")
  }
}

object Converter {
  def main(args: Array[String]){
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