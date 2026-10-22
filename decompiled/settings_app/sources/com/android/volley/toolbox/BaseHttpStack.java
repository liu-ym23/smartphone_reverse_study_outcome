package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Header;
import com.android.volley.Request;
import cz.msebera.android.httpclient.HttpVersion;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseHttpStack implements HttpStack {
    public abstract HttpResponse executeRequest(Request<?> r1, Map<String, String> r2) throws IOException, AuthFailureError;

    public BaseHttpStack() {
    }

    @Override // com.android.volley.toolbox.HttpStack
    @Deprecated
    public final org.apache.http.HttpResponse performRequest(Request<?> r5, Map<String, String> r6) throws IOException, AuthFailureError {
        HttpResponse r4 = executeRequest(r5, r6);
        BasicHttpResponse r7 = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion(HttpVersion.HTTP, 1, 1), r4.getStatusCode(), ""));
        ArrayList r8 = new ArrayList();
        Iterator<Header> r0 = r4.getHeaders().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Header r1 = r0.next();
        r8.add(new BasicHeader(r1.getName(), r1.getValue()));
        goto L4
    L6:
        r7.setHeaders((org.apache.http.Header[]) r8.toArray(new org.apache.http.Header[0]));
        InputStream r9 = r4.getContent();
        if (r9 == null) goto L9;
        BasicHttpEntity r2 = new BasicHttpEntity();
        r2.setContent(r9);
        r2.setContentLength(r4.getContentLength());
        r7.setEntity(r2);
    L9:
        return r7;
    }
}
