package com.bytedance.services.apm.api;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpResponse {
    private Map<String, String> headers;
    private byte[] responseBytes;
    private int statusCode;

    public HttpResponse(int r1, Map<String, String> r2, byte[] r3) {
        this.statusCode = r1;
        this.headers = r2;
        this.responseBytes = r3;
    }

    public HttpResponse(int r1, byte[] r2) {
        this.statusCode = r1;
        this.responseBytes = r2;
    }

    @Nullable
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public byte[] getResponseBytes() {
        return this.responseBytes;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
