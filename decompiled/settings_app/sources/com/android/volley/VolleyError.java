package com.android.volley;

/* JADX INFO: loaded from: classes.dex */
public class VolleyError extends Exception {
    public final NetworkResponse networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        this.networkResponse = null;
    }

    public VolleyError(NetworkResponse r1) {
        this.networkResponse = r1;
    }

    public VolleyError(String r1) {
        super(r1);
        this.networkResponse = null;
    }

    public VolleyError(String r1, Throwable r2) {
        super(r1, r2);
        this.networkResponse = null;
    }

    public VolleyError(Throwable r1) {
        super(r1);
        this.networkResponse = null;
    }

    void setNetworkTimeMs(long r1) {
        this.networkTimeMs = r1;
    }

    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }
}
