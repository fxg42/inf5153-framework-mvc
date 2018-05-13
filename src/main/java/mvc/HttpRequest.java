package mvc;

import java.io.*;

public class HttpRequest {
  
  String method;
  String url;

  public HttpRequest(String method, String url) throws Exception {
    this.method = method;
    this.url = url;
  }

  public String GetMethod() {
    return this.method;
  }
  public String getUrl() {
    return this.url;
  }
}
