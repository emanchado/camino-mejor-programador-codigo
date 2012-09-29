package server;

import org.mortbay.jetty.Request;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MaybeReadServer implements App {
    private Server server;

    @Override
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
                        "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
                        "\n" +
                        "    <script type=\"text/javascript\">\n" +
                        "        function addElement() {\n" +
                        "            var url = document.getElementById('url').value;\n" +
                        "            setTimeout(function() {\n" +
                        "                var articles = document.getElementById('articles');\n" +
                        "                var new_element = document.createElement('li');\n" +
                        "                new_element.innerHTML = url;\n" +
                        "                articles.insertBefore(new_element, articles.firstChild);\n" +
                        "\n" +
                        "                document.getElementById('url').value = \"\";\n" +
                        "            }, (1000));" +
                        "        }\n" +
                        "    </script>\n" +
                        "\n" +
                        "    <title>mayberead</title>\n" +
                        "</head>\n" +
                        "<form onsubmit=\"addElement(); return false;\">\n" +
                        "    <input type=\"text\" id=\"url\" name=\"url\"/>\n" +
                        "    <input type=\"submit\" value=\"agregar\"/>\n" +
                        "</form>\n" +
                        "<br/>\n" +
                        "\n" +
                        "<h2>Artículos por leer</h2>\n" +
                        "<ul id=\"articles\">\n" +
                        "</ul>\n" +
                        "</html>\n"
                );
                ((Request) request).setHandled(true);
            }
        });

        try {
            server.start();
            System.out.println("Maybe Read Server started at http://localhost:" + port);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Maybe Read Server could not be started", e
            );
        }
    }

    @Override
    public void stop() throws Exception {
        server.stop();
    }

    public static void main(String[] args) {
        new MaybeReadServer().start(8081);
    }
}
