package com.android.volley;

/* JADX INFO: loaded from: classes.dex */
public interface ResponseDelivery {
    void postError(Request<?> r1, VolleyError r2);

    void postResponse(Request<?> r1, Response<?> r2);

    void postResponse(Request<?> r1, Response<?> r2, Runnable r3);
}
