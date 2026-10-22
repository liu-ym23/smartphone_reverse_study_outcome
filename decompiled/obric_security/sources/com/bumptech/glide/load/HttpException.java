package com.bumptech.glide.load;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int r2) {
        this("Http request failed", r2);
    }

    @Deprecated
    public HttpException(String r2) {
        this(r2, -1);
    }

    public HttpException(String r2, int r3) {
        this(r2, r3, null);
    }

    public HttpException(String r2, int r3, Throwable r4) {
        super(r2 + ", status code: " + r3, r4);
        this.statusCode = r3;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
