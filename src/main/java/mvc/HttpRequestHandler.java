package mvc;

import java.util.Date;

public class HttpRequestHandler {

  public void handle(HttpRequest req, HttpResponse res) {
    var body = String.format("<html><body><h1>Hello, HTTP! %tc</h1></body></html>", new Date());

    res.println("HTTP/1.1 200 OK");
    res.println("Content-Type: text/html; charset=UTF-8");
    res.println("Content-Length: "+ body.getBytes().length);
    res.println("");
    res.println(body);
  }
}

