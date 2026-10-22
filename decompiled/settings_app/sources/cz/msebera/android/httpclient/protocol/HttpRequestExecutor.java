package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class HttpRequestExecutor {
    public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
    private final int waitForContinue;

    public HttpRequestExecutor(int r2) {
        this.waitForContinue = Args.positive(r2, "Wait for continue time");
    }

    public HttpRequestExecutor() {
        this(3000);
    }

    protected boolean canResponseHaveBody(HttpRequest r1, HttpResponse r2) {
        if ("HEAD".equalsIgnoreCase(r1.getRequestLine().getMethod()) == false) goto L5;
        return false;
    L5:
        int r0 = r2.getStatusLine().getStatusCode();
        if (r0 >= 200) goto L8;
        return false;
    L8:
        if (r0 != 204) goto L10;
        return false;
    L10:
        if (r0 != 304) goto L12;
        return false;
    L12:
        if (r0 == 205) goto L18;
        return true;
    L18:
        return false;
    }

    public HttpResponse execute(HttpRequest r2, HttpClientConnection r3, HttpContext r4) throws IOException, HttpException {
        Args.notNull(r2, "HTTP request");
        Args.notNull(r3, "Client connection");
        Args.notNull(r4, "HTTP context");
        HttpResponse r0 = doSendRequest(r2, r3, r4);     // Catch: RuntimeException -> L7 HttpException -> L10 IOException -> L13
        if (r0 != null) goto L18;
        return doReceiveResponse(r2, r3, r4);
    L18:
        return r0;
    L10:
        e = move-exception;
        closeConnection(r3);
        throw e;
    L13:
        e = move-exception;
        closeConnection(r3);
        throw e;
    L7:
        e = move-exception;
        closeConnection(r3);
        throw e;
    }

    private static void closeConnection(HttpClientConnection r0) {
        r0.close();     // Catch: IOException -> L4
        return;
    }

    public void preProcess(HttpRequest r1, HttpProcessor r2, HttpContext r3) throws HttpException, IOException {
        Args.notNull(r1, "HTTP request");
        Args.notNull(r2, "HTTP processor");
        Args.notNull(r3, "HTTP context");
        r3.setAttribute("http.request", r1);
        r2.process(r1, r3);
    }

    protected HttpResponse doSendRequest(HttpRequest r7, HttpClientConnection r8, HttpContext r9) throws IOException, HttpException {
        Args.notNull(r7, "HTTP request");
        Args.notNull(r8, "Client connection");
        Args.notNull(r9, "HTTP context");
        r9.setAttribute("http.connection", r8);
        r9.setAttribute("http.request_sent", Boolean.FALSE);
        r8.sendRequestHeader(r7);
        HttpResponse r2 = null;
        if ((r7 instanceof HttpEntityEnclosingRequest) == false) goto L23;
        ProtocolVersion r0 = r7.getRequestLine().getProtocolVersion();
        HttpEntityEnclosingRequest r3 = (HttpEntityEnclosingRequest) r7;
        boolean r5 = true;
        if (r3.expectContinue() == true) goto L7;
    L21:
        if (r5 == false) goto L23;
        r8.sendRequestEntity(r3);
        goto L23
    L7:
        if (r0.lessEquals(HttpVersion.HTTP_1_0) == true) goto L21;
        r8.flush();
        if (r8.isResponseAvailable(this.waitForContinue) == false) goto L21;
        HttpResponse r1 = r8.receiveResponseHeader();
        if (canResponseHaveBody(r7, r1) == false) goto L13;
        r8.receiveResponseEntity(r1);
    L13:
        int r6 = r1.getStatusLine().getStatusCode();
        if (r6 < 200) goto L16;
        r5 = false;
        r2 = r1;
        goto L21
    L16:
        if (r6 == 100) goto L21;
        throw new ProtocolException("Unexpected response: " + r1.getStatusLine());
    L23:
        r8.flush();
        r9.setAttribute("http.request_sent", Boolean.TRUE);
        return r2;
    }

    protected HttpResponse doReceiveResponse(HttpRequest r3, HttpClientConnection r4, HttpContext r5) throws HttpException, IOException {
        Args.notNull(r3, "HTTP request");
        Args.notNull(r4, "Client connection");
        Args.notNull(r5, "HTTP context");
        HttpResponse r6 = null;
        int r0 = 0;
    L3:
        if (r6 != null) goto L5;
    L8:
        r6 = r4.receiveResponseHeader();
        r0 = r6.getStatusLine().getStatusCode();
        if (r0 < 100) goto L14;
        if (canResponseHaveBody(r3, r6) == false) goto L3;
        r4.receiveResponseEntity(r6);
        goto L3
    L14:
        throw new ProtocolException("Invalid response: " + r6.getStatusLine());
    L5:
        if (r0 < 200) goto L8;
        return r6;
    }

    public void postProcess(HttpResponse r1, HttpProcessor r2, HttpContext r3) throws HttpException, IOException {
        Args.notNull(r1, "HTTP response");
        Args.notNull(r2, "HTTP processor");
        Args.notNull(r3, "HTTP context");
        r3.setAttribute("http.response", r1);
        r2.process(r1, r3);
    }
}
