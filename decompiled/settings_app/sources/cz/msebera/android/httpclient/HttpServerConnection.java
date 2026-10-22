package cz.msebera.android.httpclient;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpServerConnection extends HttpConnection {
    void flush() throws IOException;

    void receiveRequestEntity(HttpEntityEnclosingRequest r1) throws HttpException, IOException;

    HttpRequest receiveRequestHeader() throws HttpException, IOException;

    void sendResponseEntity(HttpResponse r1) throws HttpException, IOException;

    void sendResponseHeader(HttpResponse r1) throws HttpException, IOException;
}
