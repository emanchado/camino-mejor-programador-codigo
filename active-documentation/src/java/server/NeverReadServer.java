package server;

import org.mortbay.jetty.Request;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NeverReadServer implements App {
    private Server server;

    public void start(int port) {
        server = new Server(port);
        server.setHandler(new AbstractHandler() {
            @Override
            public void handle(String s, HttpServletRequest request, HttpServletResponse response, int i) throws IOException, ServletException {
                response.setContentType("text/html");
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().println("" +
                        "<html>\n" +
                        "<head>\n" +
                        "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/> \n" +
                        "    <title>neverread</title>\n" +
                        "</head>\n" +
                        "<form>\n" +
                        "<input type=\"text\" name=\"url\"/>\n" +
                        "<input type=\"submit\" value=\"agregar\"/>\n" +
                        "</form>\n" +
                        "<br/>\n" +
                        "<h2>Artículos por leer</h2>\n" +
                        "<ul>\n" +
//                        "<li>Chomsky 9/11</li>\n" +
                        "</ul>\n" +
                        "</html>"
                );
                ((Request) request).setHandled(true);
            }
        });

        try {
            server.start();
            System.out.println("Never Read Server started at http://localhost:" + port);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Never Read Server could not be started", e
            );
        }
    }

    public void stop() throws Exception {
        server.stop();
    }

    public static void main(String[] args) {
        new NeverReadServer().start(8081);
    }
}