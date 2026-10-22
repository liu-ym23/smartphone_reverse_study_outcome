package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Header;
import com.android.volley.Network;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class BasicNetwork implements Network {
    private static final int DEFAULT_POOL_SIZE = 4096;
    private final BaseHttpStack mBaseHttpStack;

    @Deprecated
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    @Deprecated
    public BasicNetwork(HttpStack r3) {
        this(r3, new ByteArrayPool(4096));
    }

    @Deprecated
    public BasicNetwork(HttpStack r2, ByteArrayPool r3) {
        this.mHttpStack = r2;
        this.mBaseHttpStack = new AdaptedHttpStack(r2);
        this.mPool = r3;
    }

    public BasicNetwork(BaseHttpStack r3) {
        this(r3, new ByteArrayPool(4096));
    }

    public BasicNetwork(BaseHttpStack r1, ByteArrayPool r2) {
        this.mBaseHttpStack = r1;
        this.mHttpStack = r1;
        this.mPool = r2;
    }

    @Override // com.android.volley.Network
    public NetworkResponse performRequest(Request<?> r19) throws VolleyError {
        long r9 = SystemClock.elapsedRealtime();
    L3:
        Collections.emptyList();
        HttpResponse r3 = this.mBaseHttpStack.executeRequest(r19, HttpHeaderParser.getCacheHeaders(r19.getCacheEntry()));     // Catch: IOException -> L23
        int r12 = r3.getStatusCode();     // Catch: IOException -> L21
        List<Header> r0 = r3.getHeaders();     // Catch: IOException -> L21
        if (r12 == 304) goto L8;
        InputStream r4 = r3.getContent();     // Catch: IOException -> L21
        if (r4 == null) goto L12;
        byte[] r2 = NetworkUtility.inputStreamToBytes(r4, r3.getContentLength(), this.mPool);     // Catch: IOException -> L21
    L13:
        NetworkUtility.logSlowRequests(SystemClock.elapsedRealtime() - r9, r19, r2, r12);     // Catch: IOException -> L21
        if (r12 < 200) goto L20;
        if (r12 > 299) goto L20;
        return new NetworkResponse(r12, r2, false, SystemClock.elapsedRealtime() - r9, r0);
    L20:
        throw new IOException();     // Catch: IOException -> L21
    L12:
        r2 = new byte[0];     // Catch: IOException -> L21
        goto L13
    L8:
        return NetworkUtility.getNotModifiedNetworkResponse(r19, SystemClock.elapsedRealtime() - r9, r0);
    L21:
        e = move-exception;
        byte[] r7 = null;
        HttpResponse r6 = r3;
        IOException r5 = e;
    L25:
        NetworkUtility.attemptRetryOnException(r19, NetworkUtility.shouldRetryException(r19, r5, r9, r6, r7));
    L23:
        e = move-exception;
        r5 = e;
        r6 = null;
        r7 = null;
        goto L25
    }

    @Deprecated
    protected static Map<String, String> convertHeaders(Header[] r4) {
        TreeMap r0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L6;
        r0.put(r4[r1].getName(), r4[r1].getValue());
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
