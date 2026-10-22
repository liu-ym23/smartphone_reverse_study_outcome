package com.android.volley.toolbox;

import com.android.volley.Header;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class HttpResponse {
    private final InputStream mContent;
    private final byte[] mContentBytes;
    private final int mContentLength;
    private final List<Header> mHeaders;
    private final int mStatusCode;

    public HttpResponse(int r3, List<Header> r4) {
        this(r3, r4, -1, null);
    }

    public HttpResponse(int r1, List<Header> r2, int r3, InputStream r4) {
        this.mStatusCode = r1;
        this.mHeaders = r2;
        this.mContentLength = r3;
        this.mContent = r4;
        this.mContentBytes = null;
    }

    public HttpResponse(int r1, List<Header> r2, byte[] r3) {
        this.mStatusCode = r1;
        this.mHeaders = r2;
        this.mContentLength = r3.length;
        this.mContentBytes = r3;
        this.mContent = null;
    }

    public final int getStatusCode() {
        return this.mStatusCode;
    }

    public final List<Header> getHeaders() {
        return Collections.unmodifiableList(this.mHeaders);
    }

    public final int getContentLength() {
        return this.mContentLength;
    }

    public final byte[] getContentBytes() {
        return this.mContentBytes;
    }

    public final InputStream getContent() {
        InputStream r0 = this.mContent;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.mContentBytes != null) goto L8;
        return null;
    L8:
        return new ByteArrayInputStream(this.mContentBytes);
    }
}
