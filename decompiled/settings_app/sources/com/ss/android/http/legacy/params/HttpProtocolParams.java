package com.ss.android.http.legacy.params;

import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class HttpProtocolParams implements CoreProtocolPNames {
    private HttpProtocolParams() {
    }

    public static String getHttpElementCharset(HttpParams r1) {
        if (r1 == null) goto L8;
        String r2 = (String) r1.getParameter("http.protocol.element-charset");
        if (r2 != null) goto L9;
        return "US-ASCII";
    L9:
        return r2;
    L8:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static void setHttpElementCharset(HttpParams r1, String r2) {
        if (r1 == null) goto L6;
        r1.setParameter("http.protocol.element-charset", r2);
        return;
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static String getContentCharset(HttpParams r1) {
        if (r1 == null) goto L8;
        String r2 = (String) r1.getParameter("http.protocol.content-charset");
        if (r2 != null) goto L9;
        return "ISO-8859-1";
    L9:
        return r2;
    L8:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static void setContentCharset(HttpParams r1, String r2) {
        if (r1 == null) goto L6;
        r1.setParameter("http.protocol.content-charset", r2);
        return;
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static String getUserAgent(HttpParams r1) {
        if (r1 == null) goto L6;
        return (String) r1.getParameter("http.useragent");
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static void setUserAgent(HttpParams r1, String r2) {
        if (r1 == null) goto L6;
        r1.setParameter("http.useragent", r2);
        return;
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static boolean useExpectContinue(HttpParams r2) {
        if (r2 == null) goto L6;
        return r2.getBooleanParameter("http.protocol.expect-continue", false);
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static void setUseExpectContinue(HttpParams r1, boolean r2) {
        if (r1 == null) goto L6;
        r1.setBooleanParameter("http.protocol.expect-continue", r2);
        return;
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }
}
