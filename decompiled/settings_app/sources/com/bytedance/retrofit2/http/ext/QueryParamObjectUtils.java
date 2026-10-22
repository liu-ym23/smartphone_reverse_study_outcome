package com.bytedance.retrofit2.http.ext;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public class QueryParamObjectUtils {
    private QueryParamObjectUtils() {
    }

    public static void addQuery(StringBuilder r3, String r4, String r5) {
        if (r4 == null) goto L19;
        if (r3.length() <= 0) goto L7;
        char r1 = Typography.amp;
    L8:
        r3.append(r1);     // Catch: UnsupportedEncodingException -> L16
        String r6 = URLEncoder.encode(r4, "UTF-8");     // Catch: UnsupportedEncodingException -> L16
        String r7 = URLEncoder.encode(r5, "UTF-8");     // Catch: UnsupportedEncodingException -> L16
        if (r7 != null) goto L11;
    L14:
        r3.append(r6);     // Catch: UnsupportedEncodingException -> L16
        return;
    L11:
        if (r7.isEmpty() == true) goto L14;
        r3.append(r6).append('=').append(r7);     // Catch: UnsupportedEncodingException -> L16
        return;
    L7:
        r1 = '?';
        goto L8
    L19:
        throw new IllegalArgumentException("Query param name must not be null.");     // Catch: UnsupportedEncodingException -> L16
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r4 + "\" value to UTF-8: " + r5, e);
    }
}
