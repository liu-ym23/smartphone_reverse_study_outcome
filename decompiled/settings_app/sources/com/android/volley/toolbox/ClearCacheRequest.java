package com.android.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/* JADX INFO: loaded from: classes.dex */
public class ClearCacheRequest extends Request<Object> {
    private final Cache mCache;
    private final Runnable mCallback;

    @Override // com.android.volley.Request
    protected void deliverResponse(Object r1) {
    }

    @Override // com.android.volley.Request
    protected Response<Object> parseNetworkResponse(NetworkResponse r1) {
        return null;
    }

    public ClearCacheRequest(Cache r3, Runnable r4) {
        super(0, null, null);
        this.mCache = r3;
        this.mCallback = r4;
    }

    @Override // com.android.volley.Request
    public boolean isCanceled() {
        this.mCache.clear();
        if (this.mCallback == null) goto L7;
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.mCallback);
        return true;
    L7:
        return true;
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.IMMEDIATE;
    }
}
