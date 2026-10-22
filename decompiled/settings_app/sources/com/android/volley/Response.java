package com.android.volley;

/* JADX INFO: loaded from: classes.dex */
public class Response<T> {
    public final Cache.Entry cacheEntry;
    public final VolleyError error;
    public boolean intermediate;
    public final T result;

    public interface ErrorListener {
        void onErrorResponse(VolleyError r1);
    }

    public interface Listener<T> {
        void onResponse(T r1);
    }

    public static <T> Response<T> success(T r1, Cache.Entry r2) {
        return new Response(r1, r2);
    }

    public static <T> Response<T> error(VolleyError r1) {
        return new Response(r1);
    }

    public boolean isSuccess() {
        if (this.error != null) goto L5;
        return true;
    L5:
        return false;
    }

    private Response(T r2, Cache.Entry r3) {
        this.intermediate = false;
        this.result = r2;
        this.cacheEntry = r3;
        this.error = null;
    }

    private Response(VolleyError r2) {
        this.intermediate = false;
        this.result = null;
        this.cacheEntry = null;
        this.error = r2;
    }
}
