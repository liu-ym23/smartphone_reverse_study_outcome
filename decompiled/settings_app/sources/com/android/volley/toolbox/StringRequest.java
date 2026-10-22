package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class StringRequest extends Request<String> {
    private Response.Listener<String> mListener;
    private final Object mLock;

    @Override // com.android.volley.Request
    protected /* bridge */ /* synthetic */ void deliverResponse(String r1) {
        deliverResponse2(r1);
    }

    public StringRequest(int r1, String r2, Response.Listener<String> r3, Response.ErrorListener r4) {
        super(r1, r2, r4);
        this.mLock = new Object();
        this.mListener = r3;
    }

    public StringRequest(String r2, Response.Listener<String> r3, Response.ErrorListener r4) {
        this(0, r2, r3, r4);
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

    /* JADX INFO: renamed from: deliverResponse, reason: avoid collision after fix types in other method */
    protected void deliverResponse2(String r2) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Response.Listener<String> r1 = this.mListener;     // Catch: Throwable -> L9
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
    protected Response<String> parseNetworkResponse(NetworkResponse r3) {
        String r2 = new String(r3.data, HttpHeaderParser.parseCharset(r3.headers));     // Catch: UnsupportedEncodingException -> L4
    L6:
        return Response.success(r2, HttpHeaderParser.parseCacheHeaders(r3));
    L4:
        r2 = new String(r3.data);
        goto L6
    }
}
