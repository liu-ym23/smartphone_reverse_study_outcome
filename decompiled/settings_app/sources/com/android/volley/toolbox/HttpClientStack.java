package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpClientStack implements HttpStack {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    protected final HttpClient mClient;

    public static final class HttpPatch extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "PATCH";

        @Override // org.apache.http.client.methods.HttpRequestBase, org.apache.http.client.methods.HttpUriRequest
        public String getMethod() {
            return "PATCH";
        }

        public HttpPatch() {
        }

        public HttpPatch(URI r1) {
            setURI(r1);
        }

        public HttpPatch(String r1) {
            setURI(URI.create(r1));
        }
    }

    protected void onPrepareRequest(HttpUriRequest r1) throws IOException {
    }

    public HttpClientStack(HttpClient r1) {
        this.mClient = r1;
    }

    private static void setHeaders(HttpUriRequest r3, Map<String, String> r4) {
        Iterator<String> r0 = r4.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = r0.next();
        r3.setHeader(r1, r4.get(r1));
        goto L4
    }

    private static List<NameValuePair> getPostParameterPairs(Map<String, String> r5) {
        ArrayList r0 = new ArrayList(r5.size());
        Iterator<String> r1 = r5.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r0.add(new BasicNameValuePair(r2, r5.get(r2)));
        goto L4
    L6:
        return r0;
    }

    @Override // com.android.volley.toolbox.HttpStack
    public org.apache.http.HttpResponse performRequest(Request<?> r3, Map<String, String> r4) throws IOException, AuthFailureError {
        HttpUriRequest r0 = createHttpRequest(r3, r4);
        setHeaders(r0, r4);
        setHeaders(r0, r3.getHeaders());
        onPrepareRequest(r0);
        HttpParams r5 = r0.getParams();
        int r6 = r3.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(r5, 5000);
        HttpConnectionParams.setSoTimeout(r5, r6);
        return this.mClient.execute(r0);
    }

    static HttpUriRequest createHttpRequest(Request<?> r3, Map<String, String> r4) throws AuthFailureError {
        switch(r3.getMethod()) {
            case -1: goto L22;
            case 0: goto L21;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        HttpPatch r5 = new HttpPatch(r3.getUrl());
        r5.addHeader("Content-Type", r3.getBodyContentType());
        setEntityIfNonEmptyBody(r5, r3);
        return r5;
    L16:
        HttpPut r6 = new HttpPut(r3.getUrl());
        r6.addHeader("Content-Type", r3.getBodyContentType());
        setEntityIfNonEmptyBody(r6, r3);
        return r6;
    L18:
        HttpPost r7 = new HttpPost(r3.getUrl());
        r7.addHeader("Content-Type", r3.getBodyContentType());
        setEntityIfNonEmptyBody(r7, r3);
        return r7;
    L22:
        byte[] r8 = r3.getPostBody();
        if (r8 == null) goto L27;
        HttpPost r1 = new HttpPost(r3.getUrl());
        r1.addHeader("Content-Type", r3.getPostBodyContentType());
        r1.setEntity(new ByteArrayEntity(r8));
        return r1;
    L27:
        return new HttpGet(r3.getUrl());
    L5:
        throw new IllegalStateException("Unknown request method.");
    L9:
        return new HttpTrace(r3.getUrl());
    L11:
        return new HttpOptions(r3.getUrl());
    L13:
        return new HttpHead(r3.getUrl());
    L15:
        return new HttpDelete(r3.getUrl());
    L21:
        return new HttpGet(r3.getUrl());
    }

    private static void setEntityIfNonEmptyBody(HttpEntityEnclosingRequestBase r1, Request<?> r2) throws AuthFailureError {
        byte[] r3 = r2.getBody();
        if (r3 == null) goto L6;
        r1.setEntity(new ByteArrayEntity(r3));
        return;
    }
}
