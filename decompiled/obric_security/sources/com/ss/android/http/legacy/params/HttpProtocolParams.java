package com.ss.android.http.legacy.params;

import org.apache.http.params.HttpParams;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class HttpProtocolParams implements CoreProtocolPNames {
    private HttpProtocolParams() {
    }

    public static String getHttpElementCharset(HttpParams r1) {
        if (r1 == null) goto L8;
        String r2 = (String) r1.getParameter(CoreProtocolPNames.HTTP_ELEMENT_CHARSET);
        if (r2 != null) goto L9;
        return "US-ASCII";
    L9:
        return r2;
    L8:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static void setHttpElementCharset(HttpParams r1, String r2) {
        if (r1 == null) goto L6;
        r1.setParameter(CoreProtocolPNames.HTTP_ELEMENT_CHARSET, r2);
        return;
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static String getContentCharset(HttpParams r1) {
        if (r1 == null) goto L8;
        String r2 = (String) r1.getParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET);
        if (r2 != null) goto L9;
        return "ISO-8859-1";
    L9:
        return r2;
    L8:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static void setContentCharset(HttpParams r1, String r2) {
        if (r1 == null) goto L6;
        r1.setParameter(CoreProtocolPNames.HTTP_CONTENT_CHARSET, r2);
        return;
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static String getUserAgent(HttpParams r1) {
        if (r1 == null) goto L6;
        return (String) r1.getParameter(CoreProtocolPNames.USER_AGENT);
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static void setUserAgent(HttpParams r1, String r2) {
        if (r1 == null) goto L6;
        r1.setParameter(CoreProtocolPNames.USER_AGENT, r2);
        return;
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static boolean useExpectContinue(HttpParams r2) {
        if (r2 == null) goto L6;
        return r2.getBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, false);
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }

    public static void setUseExpectContinue(HttpParams r1, boolean r2) {
        if (r1 == null) goto L6;
        r1.setBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, r2);
        return;
    L6:
        throw new IllegalArgumentException("HTTP parameters may not be null");
    }
}
