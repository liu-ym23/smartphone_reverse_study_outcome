package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class HttpProtocolParams implements CoreProtocolPNames {
    private HttpProtocolParams() {
    }

    public static String getHttpElementCharset(HttpParams r1) {
        Args.notNull(r1, "HTTP parameters");
        String r2 = (String) r1.getParameter("http.protocol.element-charset");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return HTTP.DEF_PROTOCOL_CHARSET.name();
    }

    public static void setHttpElementCharset(HttpParams r1, String r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setParameter("http.protocol.element-charset", r2);
    }

    public static String getContentCharset(HttpParams r1) {
        Args.notNull(r1, "HTTP parameters");
        String r2 = (String) r1.getParameter("http.protocol.content-charset");
        if (r2 == null) goto L5;
        return r2;
    L5:
        return HTTP.DEF_CONTENT_CHARSET.name();
    }

    public static void setContentCharset(HttpParams r1, String r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setParameter("http.protocol.content-charset", r2);
    }

    public static ProtocolVersion getVersion(HttpParams r1) {
        Args.notNull(r1, "HTTP parameters");
        Object r2 = r1.getParameter("http.protocol.version");
        if (r2 != null) goto L7;
        return HttpVersion.HTTP_1_1;
    L7:
        return (ProtocolVersion) r2;
    }

    public static void setVersion(HttpParams r1, ProtocolVersion r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setParameter("http.protocol.version", r2);
    }

    public static String getUserAgent(HttpParams r1) {
        Args.notNull(r1, "HTTP parameters");
        return (String) r1.getParameter("http.useragent");
    }

    public static void setUserAgent(HttpParams r1, String r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setParameter("http.useragent", r2);
    }

    public static boolean useExpectContinue(HttpParams r2) {
        Args.notNull(r2, "HTTP parameters");
        return r2.getBooleanParameter("http.protocol.expect-continue", false);
    }

    public static void setUseExpectContinue(HttpParams r1, boolean r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setBooleanParameter("http.protocol.expect-continue", r2);
    }

    public static CodingErrorAction getMalformedInputAction(HttpParams r1) {
        Args.notNull(r1, "HTTP parameters");
        Object r2 = r1.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION);
        if (r2 != null) goto L7;
        return CodingErrorAction.REPORT;
    L7:
        return (CodingErrorAction) r2;
    }

    public static void setMalformedInputAction(HttpParams r1, CodingErrorAction r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION, r2);
    }

    public static CodingErrorAction getUnmappableInputAction(HttpParams r1) {
        Args.notNull(r1, "HTTP parameters");
        Object r2 = r1.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION);
        if (r2 != null) goto L7;
        return CodingErrorAction.REPORT;
    L7:
        return (CodingErrorAction) r2;
    }

    public static void setUnmappableInputAction(HttpParams r1, CodingErrorAction r2) {
        Args.notNull(r1, "HTTP parameters");
        r1.setParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION, r2);
    }
}
