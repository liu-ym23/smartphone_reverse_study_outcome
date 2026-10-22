package com.android.volley;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncCache {

    public interface OnGetCompleteCallback {
        void onGetComplete(Cache.Entry r1);
    }

    public interface OnWriteCompleteCallback {
        void onWriteComplete();
    }

    public abstract void clear(OnWriteCompleteCallback r1);

    public abstract void get(String r1, OnGetCompleteCallback r2);

    public abstract void initialize(OnWriteCompleteCallback r1);

    public abstract void invalidate(String r1, boolean r2, OnWriteCompleteCallback r3);

    public abstract void put(String r1, Cache.Entry r2, OnWriteCompleteCallback r3);

    public abstract void remove(String r1, OnWriteCompleteCallback r2);

    public AsyncCache() {
    }
}
