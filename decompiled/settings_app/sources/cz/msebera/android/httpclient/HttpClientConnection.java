package cz.msebera.android.httpclient;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface HttpClientConnection extends HttpConnection {
    void flush() throws IOException;

    boolean isResponseAvailable(int r1) throws IOException;

    void receiveResponseEntity(HttpResponse r1) throws HttpException, IOException;

    HttpResponse receiveResponseHeader() throws HttpException, IOException;

    void sendRequestEntity(HttpEntityEnclosingRequest r1) throws HttpException, IOException;

    void sendRequestHeader(HttpRequest r1) throws HttpException, IOException;
}
