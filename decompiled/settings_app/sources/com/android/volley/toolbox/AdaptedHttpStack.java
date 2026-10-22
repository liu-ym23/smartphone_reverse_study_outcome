package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes.dex */
class AdaptedHttpStack extends BaseHttpStack {
    private final HttpStack mHttpStack;

    AdaptedHttpStack(HttpStack r1) {
        this.mHttpStack = r1;
    }

    @Override // com.android.volley.toolbox.BaseHttpStack
    public HttpResponse executeRequest(Request<?> r7, Map<String, String> r8) throws IOException, AuthFailureError {
        org.apache.http.HttpResponse r6 = this.mHttpStack.performRequest(r7, r8);     // Catch: ConnectTimeoutException -> L16
        int r9 = r6.getStatusLine().getStatusCode();
        Header[] r10 = r6.getAllHeaders();
        ArrayList r0 = new ArrayList(r10.length);
        int r1 = r10.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L7;
        Header r3 = r10[r2];
        r0.add(new com.android.volley.Header(r3.getName(), r3.getValue()));
        r2 = r2 + 1;
        goto L4
    L7:
        if (r6.getEntity() == null) goto L9;
        long r4 = r6.getEntity().getContentLength();
        if (((int) r4) != r4) goto L15;
        return new HttpResponse(r9, r0, (int) r6.getEntity().getContentLength(), r6.getEntity().getContent());
    L15:
        throw new IOException("Response too large: " + r4);
    L9:
        return new HttpResponse(r9, r0);
    L16:
        e = move-exception;
        throw new SocketTimeoutException(e.getMessage());
    }
}
