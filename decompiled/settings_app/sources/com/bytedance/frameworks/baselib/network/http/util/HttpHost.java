package com.bytedance.frameworks.baselib.network.http.util;

import com.android.settingslib.accessibility.AccessibilityUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class HttpHost implements Cloneable {
    public static final String DEFAULT_SCHEME_NAME = "http";
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

    public HttpHost(String r2, int r3, String r4) {
        if (r2 == null) goto L11;
        this.hostname = r2;
        this.lcHostname = r2.toLowerCase(Locale.ENGLISH);
        if (r4 == null) goto L7;
        this.schemeName = r4.toLowerCase(Locale.ENGLISH);
    L8:
        this.port = r3;
        return;
    L7:
        this.schemeName = "http";
        goto L8
    L11:
        throw new IllegalArgumentException("Host name may not be null");
    }

    public HttpHost(String r2, int r3) {
        this(r2, r3, null);
    }

    public HttpHost(String r3) {
        this(r3, -1, null);
    }

    public HttpHost(HttpHost r3) {
        this(r3.hostname, r3.port, r3.schemeName);
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public String toURI() {
        CharArrayBuffer r0 = new CharArrayBuffer(32);
        r0.append(this.schemeName);
        r0.append("://");
        r0.append(this.hostname);
        if (this.port == (-1)) goto L6;
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        r0.append(Integer.toString(this.port));
    L6:
        return r0.toString();
    }

    public String toHostString() {
        CharArrayBuffer r0 = new CharArrayBuffer(32);
        r0.append(this.hostname);
        if (this.port == (-1)) goto L6;
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        r0.append(Integer.toString(this.port));
    L6:
        return r0.toString();
    }

    public String toString() {
        return toURI();
    }

    public boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (this != r5) goto L9;
        return true;
    L9:
        if ((r5 instanceof HttpHost) == false) goto L18;
        HttpHost r6 = (HttpHost) r5;
        if (this.lcHostname.equals(r6.lcHostname) == true) goto L13;
        return false;
    L13:
        if (this.port == r6.port) goto L15;
        return false;
    L15:
        if (this.schemeName.equals(r6.schemeName) == true) goto L17;
        return false;
    L17:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, this.lcHostname), this.port), this.schemeName);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
