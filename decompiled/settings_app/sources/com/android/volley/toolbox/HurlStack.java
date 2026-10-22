package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import obric.time.HttpHeadTimeFetcher;

/* JADX INFO: loaded from: classes.dex */
public class HurlStack extends BaseHttpStack {
    private static final int HTTP_CONTINUE = 100;
    private final SSLSocketFactory mSslSocketFactory;
    private final UrlRewriter mUrlRewriter;

    static class UrlConnectionInputStream extends FilterInputStream {
        private final HttpURLConnection mConnection;

        UrlConnectionInputStream(HttpURLConnection r2) {
            super(HurlStack.access$000(r2));
            this.mConnection = r2;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.mConnection.disconnect();
        }
    }

    public interface UrlRewriter extends com.android.volley.toolbox.UrlRewriter {
    }

    private static boolean hasResponseBody(int r1, int r2) {
        if (r1 != 4) goto L5;
    L13:
        return false;
    L5:
        if (100 > r2) goto L9;
        if (r2 < 200) goto L13;
    L9:
        if (r2 == 204) goto L13;
        if (r2 == 304) goto L13;
        return true;
    }

    static /* synthetic */ InputStream access$000(HttpURLConnection r0) {
        return inputStreamFromConnection(r0);
    }

    public HurlStack() {
        this(null);
    }

    public HurlStack(UrlRewriter r2) {
        this(r2, null);
    }

    public HurlStack(UrlRewriter r1, SSLSocketFactory r2) {
        this.mUrlRewriter = r1;
        this.mSslSocketFactory = r2;
    }

    @Override // com.android.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(Request<?> r6, Map<String, String> r7) throws IOException, AuthFailureError {
        String r0 = r6.getUrl();
        HashMap r1 = new HashMap();
        r1.putAll(r7);
        r1.putAll(r6.getHeaders());
        UrlRewriter r8 = this.mUrlRewriter;
        if (r8 == null) goto L9;
        String r9 = r8.rewriteUrl(r0);
        if (r9 == null) goto L8;
        r0 = r9;
        goto L9
    L8:
        throw new IOException("URL blocked by rewriter: " + r0);
    L9:
        HttpURLConnection r10 = openConnection(new URL(r0), r6);
        Iterator r2 = r1.keySet().iterator();     // Catch: Throwable -> L26
    L12:
        if (r2.hasNext() == false) goto L14;
        String r3 = (String) r2.next();     // Catch: Throwable -> L26
        r10.setRequestProperty(r3, (String) r1.get(r3));     // Catch: Throwable -> L26
        goto L12
    L14:
        setConnectionParametersForRequest(r10, r6);     // Catch: Throwable -> L26
        int r4 = r10.getResponseCode();     // Catch: Throwable -> L26
        if (r4 == (-1)) goto L25;
        if (hasResponseBody(r6.getMethod(), r4) == true) goto L23;
        HttpResponse r5 = new HttpResponse(r4, convertHeaders(r10.getHeaderFields()));     // Catch: Throwable -> L26
        r10.disconnect();
        return r5;
    L23:
        return new HttpResponse(r4, convertHeaders(r10.getHeaderFields()), r10.getContentLength(), createInputStream(r6, r10));
    L25:
        throw new IOException("Could not retrieve response code from HttpUrlConnection.");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        if (0 != 0) goto L29;
        r10.disconnect();
    L29:
        throw th;
    }

    static List<Header> convertHeaders(Map<String, List<String>> r6) {
        ArrayList r0 = new ArrayList(r6.size());
        Iterator<Map.Entry<String, List<String>>> r7 = r6.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        Map.Entry<String, List<String>> r1 = r7.next();
        if (r1.getKey() == null) goto L4;
        Iterator<String> r2 = r1.getValue().iterator();
    L9:
        if (r2.hasNext() == false) goto L4;
        String r3 = r2.next();
        r0.add(new Header(r1.getKey(), r3));
        goto L9
    L11:
        return r0;
    }

    protected InputStream createInputStream(Request<?> r1, HttpURLConnection r2) {
        return new UrlConnectionInputStream(r2);
    }

    private static InputStream inputStreamFromConnection(HttpURLConnection r0) {
        return r0.getInputStream();
    L5:
        return r0.getErrorStream();
    }

    protected HttpURLConnection createConnection(URL r1) throws IOException {
        HttpURLConnection r0 = (HttpURLConnection) r1.openConnection();
        r0.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return r0;
    }

    private HttpURLConnection openConnection(URL r2, Request<?> r3) throws IOException {
        HttpURLConnection r0 = createConnection(r2);
        int r4 = r3.getTimeoutMs();
        r0.setConnectTimeout(r4);
        r0.setReadTimeout(r4);
        r0.setUseCaches(false);
        r0.setDoInput(true);
        if (HttpHeadTimeFetcher.FETCHER_TYPE.equals(r2.getProtocol()) == false) goto L7;
        SSLSocketFactory r1 = this.mSslSocketFactory;
        if (r1 == null) goto L7;
        ((HttpsURLConnection) r0).setSSLSocketFactory(r1);
    L7:
        return r0;
    }

    void setConnectionParametersForRequest(HttpURLConnection r3, Request<?> r4) throws IOException, AuthFailureError {
        switch(r4.getMethod()) {
            case -1: goto L14;
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        r3.setRequestMethod("PATCH");
        addBodyIfExists(r3, r4);
        return;
    L7:
        r3.setRequestMethod("TRACE");
        return;
    L8:
        r3.setRequestMethod("OPTIONS");
        return;
    L9:
        r3.setRequestMethod("HEAD");
        return;
    L10:
        r3.setRequestMethod("DELETE");
        return;
    L11:
        r3.setRequestMethod("PUT");
        addBodyIfExists(r3, r4);
        return;
    L12:
        r3.setRequestMethod("POST");
        addBodyIfExists(r3, r4);
        return;
    L13:
        r3.setRequestMethod("GET");
        return;
    L14:
        byte[] r0 = r4.getPostBody();
        if (r0 == null) goto L26;
        r3.setRequestMethod("POST");
        addBody(r3, r4, r0);
        return;
    L26:
        return;
    L5:
        throw new IllegalStateException("Unknown method type.");
    }

    private void addBodyIfExists(HttpURLConnection r2, Request<?> r3) throws IOException, AuthFailureError {
        byte[] r0 = r3.getBody();
        if (r0 == null) goto L6;
        addBody(r2, r3, r0);
        return;
    }

    private void addBody(HttpURLConnection r3, Request<?> r4, byte[] r5) throws IOException {
        r3.setDoOutput(true);
        if (r3.getRequestProperties().containsKey("Content-Type") == true) goto L5;
        r3.setRequestProperty("Content-Type", r4.getBodyContentType());
    L5:
        DataOutputStream r0 = new DataOutputStream(createOutputStream(r4, r3, r5.length));
        r0.write(r5);
        r0.close();
    }

    protected OutputStream createOutputStream(Request<?> r1, HttpURLConnection r2, int r3) throws IOException {
        return r2.getOutputStream();
    }
}
