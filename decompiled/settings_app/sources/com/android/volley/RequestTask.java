package com.android.volley;

/* JADX INFO: loaded from: classes.dex */
public abstract class RequestTask<T> implements Runnable {
    final Request<T> mRequest;

    public RequestTask(Request<T> r1) {
        this.mRequest = r1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public int compareTo(RequestTask<?> r1) {
        return this.mRequest.compareTo(r1.mRequest);
    }
}
