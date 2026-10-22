package com.android.volley.toolbox;

import com.android.volley.AsyncCache;
import com.android.volley.Cache;

/* JADX INFO: loaded from: classes.dex */
public class NoAsyncCache extends AsyncCache {
    public NoAsyncCache() {
    }

    @Override // com.android.volley.AsyncCache
    public void get(String r1, AsyncCache.OnGetCompleteCallback r2) {
        r2.onGetComplete(null);
    }

    @Override // com.android.volley.AsyncCache
    public void put(String r1, Cache.Entry r2, AsyncCache.OnWriteCompleteCallback r3) {
        r3.onWriteComplete();
    }

    @Override // com.android.volley.AsyncCache
    public void clear(AsyncCache.OnWriteCompleteCallback r1) {
        r1.onWriteComplete();
    }

    @Override // com.android.volley.AsyncCache
    public void initialize(AsyncCache.OnWriteCompleteCallback r1) {
        r1.onWriteComplete();
    }

    @Override // com.android.volley.AsyncCache
    public void invalidate(String r1, boolean r2, AsyncCache.OnWriteCompleteCallback r3) {
        r3.onWriteComplete();
    }

    @Override // com.android.volley.AsyncCache
    public void remove(String r1, AsyncCache.OnWriteCompleteCallback r2) {
        r2.onWriteComplete();
    }
}
