package com.bytedance.apm.util;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class UrlUtils {
    public UrlUtils() {
    }

    public static String addParamsToURL(String r7, Map<String, String> r8) {
        if (TextUtils.isDigitsOnly(r7) == true) goto L27;
        if (r8 == null) goto L27;
        if (r8.isEmpty() == true) goto L27;
        if (r7.indexOf("?") >= 0) goto L12;
        r7 = r7 + "?";
    L12:
        if (r7.endsWith("?") == false) goto L14;
        r7 = r7 + encode(WsConstants.KEY_SDK_VERSION, "UTF-8") + "=" + encode(String.valueOf(400), "UTF-8");
    L15:
        if (r8 == null) goto L27;
        if (r8.size() <= 0) goto L27;
        Iterator<Map.Entry<String, String>> r1 = r8.entrySet().iterator();
    L20:
        if (r1.hasNext() == false) goto L27;
        Map.Entry<String, String> r2 = r1.next();
        if (r8.get(r2.getKey()) == null) goto L20;
        if (r7.endsWith("?") == true) goto L25;
        r7 = r7 + "&" + encode(r2.getKey().toString(), "UTF-8") + "=" + encode(r8.get(r2.getKey()).toString(), "UTF-8");
        goto L20
    L25:
        r7 = r7 + encode(r2.getKey().toString(), "UTF-8") + "=" + encode(r8.get(r2.getKey()).toString(), "UTF-8");
        goto L20
    L14:
        r7 = r7 + "&" + encode(WsConstants.KEY_SDK_VERSION, "UTF-8") + "=" + encode(String.valueOf(400), "UTF-8");
    L27:
        return r7;
    }

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "UTF-8";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String sanitizeUrl(String r3) {
        if (r3 != null) goto L12;
        return null;
    L12:
        URL r1 = new URL(r3);     // Catch: MalformedURLException -> L11
        StringBuffer r4 = new StringBuffer();
        r4.append(r1.getProtocol());
        r4.append("://");
        r4.append(r1.getHost());
        if (r1.getPort() == (-1)) goto L9;
        r4.append(":");
        r4.append(r1.getPort());
    L9:
        r4.append(r1.getPath());
        return r4.toString();
    L11:
        return null;
    }
}
