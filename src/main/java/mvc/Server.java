package mvc;

import java.util.regex.Pattern;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {

  private void start(int port) throws Exception {
    var requestHandlerThreadPool = Executors.newFixedThreadPool(10);
    var serverSocket = new ServerSocket(port);
    System.out.printf("Le serveur est demarre a l'adresse http://localhost:%d\n", port);
    while (true) {
      var clientSocket = serverSocket.accept();
      requestHandlerThreadPool.execute(() -> {
        try (
          var out = new PrintWriter(clientSocket.getOutputStream(), true);
          var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
          var request = parseRequest(in);
          var response = new HttpResponse(out);
          new HttpRequestHandler().handle(request, response);
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      });
    }
  }

  private Pattern requestLinePattern = Pattern.compile("(GET|POST) ([^ ]+) HTTP/1\\.1");

  private HttpRequest parseRequest(BufferedReader in) throws Exception {
    // FIXME: Ne lit que la première ligne de la requête HTTP
    var firstLine = in.readLine();
    var matcher = requestLinePattern.matcher(firstLine);
    if (matcher.matches()) {
      return new HttpRequest(matcher.group(1), matcher.group(2));
    } else {
      throw new IllegalStateException();
    }
  }

  public static void main(String... args) throws Exception {
    var server = new Server();
    server.start(5153);
  }
}
