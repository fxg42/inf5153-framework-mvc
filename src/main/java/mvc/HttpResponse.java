package mvc;

import java.io.*;

public class HttpResponse {
  private PrintWriter out;

  public HttpResponse(PrintWriter out) {
    this.out = out;
  }

  public void println(Object o) {
    out.println(o);
  }
  public void print(Object o) {
    out.print(o);
  }
}
