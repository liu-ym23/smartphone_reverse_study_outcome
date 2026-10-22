package com.bytedance.apm.util;

import a.a;
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
        if (TextUtils.isDigitsOnly(r7) == true) goto L26;
        if (r8 == null) goto L26;
        if (r8.isEmpty() == true) goto L26;
        if (r7.indexOf("?") >= 0) goto L12;
        r7 = r7.concat("?");
    L12:
        if (r7.endsWith("?") == false) goto L14;
        StringBuilder r9 = a.q(r7);
        r9.append(encode(WsConstants.KEY_SDK_VERSION, "UTF-8"));
        r9.append("=");
        r9.append(encode(String.valueOf(400), "UTF-8"));
        r7 = r9.toString();
    L16:
        if (r8.size() <= 0) goto L26;
        Iterator<Map.Entry<String, String>> r1 = r8.entrySet().iterator();
    L19:
        if (r1.hasNext() == false) goto L26;
        Map.Entry<String, String> r3 = r1.next();
        if (r8.get(r3.getKey()) == null) goto L19;
        if (r7.endsWith("?") == true) goto L24;
        StringBuilder r10 = a.t(r7, "&");
        r10.append(encode(r3.getKey().toString(), "UTF-8"));
        r10.append("=");
        r10.append(encode(r8.get(r3.getKey()).toString(), "UTF-8"));
        r7 = r10.toString();
        goto L19
    L24:
        StringBuilder r11 = a.q(r7);
        r11.append(encode(r3.getKey().toString(), "UTF-8"));
        r11.append("=");
        r11.append(encode(r8.get(r3.getKey()).toString(), "UTF-8"));
        r7 = r11.toString();
        goto L19
    L14:
        StringBuilder r12 = a.t(r7, "&");
        r12.append(encode(WsConstants.KEY_SDK_VERSION, "UTF-8"));
        r12.append("=");
        r12.append(encode(String.valueOf(400), "UTF-8"));
        r7 = r12.toString();
    L26:
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
