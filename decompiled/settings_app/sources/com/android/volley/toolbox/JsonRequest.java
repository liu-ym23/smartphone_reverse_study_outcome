package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public abstract class JsonRequest<T> extends Request<T> {
    protected static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = null;
    private Response.Listener<T> mListener;
    private final Object mLock;
    private final String mRequestBody;

    @Override // com.android.volley.Request
    protected abstract Response<T> parseNetworkResponse(NetworkResponse r1);

    static {
        PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", new Object[]{"utf-8"});
    }

    @Deprecated
    public JsonRequest(String r7, String r8, Response.Listener<T> r9, Response.ErrorListener r10) {
        this(-1, r7, r8, r9, r10);
    }

    public JsonRequest(int r1, String r2, String r3, Response.Listener<T> r4, Response.ErrorListener r5) {
        super(r1, r2, r5);
        this.mLock = new Object();
        this.mListener = r4;
        this.mRequestBody = r3;
    }

    @Override // com.android.volley.Request
    public void cancel() {
        super.cancel();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mListener = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Request
    protected void deliverResponse(T r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Response.Listener<T> r1 = this.mListener;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (r1 == null) goto L14;
        r1.onResponse(r2);
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.volley.Request
    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Override // com.android.volley.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        String r2 = this.mRequestBody;     // Catch: UnsupportedEncodingException -> L8
        if (r2 == null) goto L12;
        return r2.getBytes("utf-8");
    L12:
        return null;
    L8:
        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", new Object[]{this.mRequestBody, "utf-8"});
        return null;
    }
}
