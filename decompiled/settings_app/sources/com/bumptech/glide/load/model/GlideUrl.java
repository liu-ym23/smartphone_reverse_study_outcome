package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class GlideUrl implements Key {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%;$";
    private volatile byte[] cacheKeyBytes;
    private int hashCode;
    private final Headers headers;
    private String safeStringUrl;
    private URL safeUrl;
    private final String stringUrl;
    private final URL url;

    public GlideUrl(URL r2) {
        this(r2, Headers.DEFAULT);
    }

    public GlideUrl(String r2) {
        this(r2, Headers.DEFAULT);
    }

    public GlideUrl(URL r1, Headers r2) {
        this.url = (URL) Preconditions.checkNotNull(r1);
        this.stringUrl = null;
        this.headers = (Headers) Preconditions.checkNotNull(r2);
    }

    public GlideUrl(String r2, Headers r3) {
        this.url = null;
        this.stringUrl = Preconditions.checkNotEmpty(r2);
        this.headers = (Headers) Preconditions.checkNotNull(r3);
    }

    public URL toURL() throws MalformedURLException {
        return getSafeUrl();
    }

    private URL getSafeUrl() throws MalformedURLException {
        if (this.safeUrl != null) goto L6;
        this.safeUrl = new URL(getSafeStringUrl());
    L6:
        return this.safeUrl;
    }

    public String toStringUrl() {
        return getSafeStringUrl();
    }

    private String getSafeStringUrl() {
        if (TextUtils.isEmpty(this.safeStringUrl) == false) goto L9;
        String r0 = this.stringUrl;
        if (TextUtils.isEmpty(r0) == false) goto L7;
        r0 = ((URL) Preconditions.checkNotNull(this.url)).toString();
    L7:
        this.safeStringUrl = Uri.encode(r0, ALLOWED_URI_CHARS);
    L9:
        return this.safeStringUrl;
    }

    public Map<String, String> getHeaders() {
        return this.headers.getHeaders();
    }

    public String getCacheKey() {
        String r0 = this.stringUrl;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ((URL) Preconditions.checkNotNull(this.url)).toString();
    }

    public String toString() {
        return getCacheKey();
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r1) {
        r1.update(getCacheKeyBytes());
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = getCacheKey().getBytes(CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r4) {
        if ((r4 instanceof GlideUrl) == false) goto L10;
        GlideUrl r5 = (GlideUrl) r4;
        if (getCacheKey().equals(r5.getCacheKey()) == true) goto L7;
        return false;
    L7:
        if (this.headers.equals(r5.headers) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        int r0 = getCacheKey().hashCode();
        this.hashCode = r0;
        this.hashCode = (r0 * 31) + this.headers.hashCode();
    L6:
        return this.hashCode;
    }
}
