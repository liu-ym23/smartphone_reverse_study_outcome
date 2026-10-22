package com.bytedance.frameworks.baselib.network.http.exception;

import com.android.settings.utils.HanziToPinyin;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.net.HttpURLConnection;
import java.net.URI;
import okhttp3.Request;

/* JADX INFO: loaded from: classes3.dex */
public class HttpResponseException extends ClientProtocolException {
    private static final long serialVersionUID = -7186627969477257933L;
    private final String errorResponse;
    private final int statusCode;

    public HttpResponseException(int r1, String r2) {
        super(r2);
        this.statusCode = r1;
        this.errorResponse = null;
    }

    public HttpResponseException(int r3, String r4, String r5) {
        StringBuilder r0 = new StringBuilder();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        StringBuilder r6 = r0.append(r4).append(HanziToPinyin.Token.SEPARATOR);
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        super(r6.append(r5).toString());
        this.statusCode = r3;
        this.errorResponse = null;
    }

    public HttpResponseException(int r3, String r4, String r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        StringBuilder r7 = r0.append(r4).append(HanziToPinyin.Token.SEPARATOR);
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        super(r7.append(r5).toString());
        this.statusCode = r3;
        this.errorResponse = r6;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public static String getPathFromHttpURLConnection(HttpURLConnection r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        if (r1.getURL() != null) goto L6;
        return "";
    L6:
        if (r1.getURL().getPath() != null) goto L8;
        return "";
    L8:
        return r1.getURL().getPath();
    }

    public static String getPathFromUrlString(String r0) {
        URI r1 = UrlUtils.safeCreateUri(r0);
        if (r1 != null) goto L5;
        return "";
    L5:
        return r1.getPath();
    }

    public static String getPathFromOk3Request(Request r1) {
        if (r1 != null) goto L4;
        return "";
    L4:
        if (r1.url() != null) goto L6;
        return "";
    L6:
        return r1.url().url().getPath();
    }

    public String getErrorResponse() {
        return this.errorResponse;
    }
}
