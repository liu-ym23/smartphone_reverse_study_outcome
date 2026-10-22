package com.bytedance.android.standard.tools.url;

import a.a;
import android.net.Uri;
import android.util.Pair;
import com.bytedance.android.standard.tools.string.StringUtils;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class UrlUtils {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final int CR = 13;
    public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final int HT = 9;
    public static final int LF = 10;
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";
    public static final int SP = 32;
    public static final String USER_AGENT = "User-Agent";
    public static final String UTF_8 = "UTF-8";

    private UrlUtils() {
    }

    public static String addParameter(String r4, String r5, String r6) {
        char r0 = '?';
        int r1 = r4.indexOf(63);
        int r2 = r4.indexOf(35);
        if (r1 == (-1)) goto L6;
        r0 = '&';
    L6:
        String r7 = r0 + encodeUrl(r5) + '=' + encodeUrl(r6);
        if (r2 != (-1)) goto L10;
        return a.j(r4, r7);
    L10:
        return r4.substring(0, r2) + r7 + r4.substring(r2);
    }

    private static String encode(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLEncoder.encode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    private static String encodeUrl(String r1) {
        return URLEncoder.encode(r1, "UTF-8");
    L4:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public static String format(Map<String, List<String>> r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, List<String>>> r7 = r5.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L23;
        Map.Entry<String, List<String>> r1 = r7.next();
        String r2 = encode(r1.getKey(), r6);
        List<String> r3 = r1.getValue();
        if (r3 == null) goto L4;
        if (r3.size() <= 0) goto L4;
        Iterator<String> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L4;
        String r8 = r4.next();
        if (r8 == null) goto L15;
        String r9 = encode(r8, r6);
    L17:
        if (r0.length() <= 0) goto L19;
        r0.append(PARAMETER_SEPARATOR);
    L19:
        r0.append(r2);
        if (r9.isEmpty() == true) goto L11;
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r9);
        goto L11
    L15:
        r9 = "";
        goto L17
    L23:
        return r0.toString();
    }

    public static boolean isHttpUrl(String r2) {
        if (StringUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (r2.startsWith("http://") == false) goto L8;
    L9:
        return true;
    L8:
        if (r2.startsWith("https://") == true) goto L9;
        return false;
    }

    public static boolean isWhitespace(char r1) {
        if (r1 != ' ') goto L5;
    L12:
        return true;
    L5:
        if (r1 == '\t') goto L12;
        if (r1 == '\r') goto L12;
        if (r1 == '\n') goto L12;
        return false;
    }

    @Deprecated
    public static Pair<String, String> parseUrl(String r9, Map<String, String> r10) {
        if (StringUtils.isEmpty(r9) == true) goto L30;
        Uri r11 = Uri.parse(r9);     // Catch: Throwable -> L8
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L8
        String r1 = r11.getScheme();     // Catch: Throwable -> L8
        String r2 = r11.getHost();     // Catch: Throwable -> L8
        int r3 = r11.getPort();     // Catch: Throwable -> L8
        if (r2 == null) goto L13;
        if (r1 == null) goto L10;
        r0.append(r1);     // Catch: Throwable -> L8
        r0.append("://");     // Catch: Throwable -> L8
    L10:
        r0.append(r2);     // Catch: Throwable -> L8
        if (r3 <= 0) goto L13;
        r0.append(':');     // Catch: Throwable -> L8
        r0.append(r3);     // Catch: Throwable -> L8
    L13:
        String r4 = r0.toString();     // Catch: Throwable -> L8
        String r5 = r11.getEncodedPath();     // Catch: Throwable -> L8
        if (r10 == null) goto L25;
        String r12 = r11.getEncodedQuery();     // Catch: Throwable -> L8
        if (r12 == null) goto L25;
        String[] r13 = r12.split(PARAMETER_SEPARATOR);     // Catch: Throwable -> L8
        int r6 = r13.length;     // Catch: Throwable -> L8
        int r7 = 0;
    L18:
        if (r7 >= r6) goto L25;
        String r8 = r13[r7];     // Catch: Throwable -> L8
        int r14 = r8.indexOf(NAME_VALUE_SEPARATOR);     // Catch: Throwable -> L8
        if (r14 < 0) goto L23;
        r10.put(URLDecoder.decode(r8.substring(0, r14), "UTF-8"), URLDecoder.decode(r8.substring(r14 + 1), "UTF-8"));     // Catch: Throwable -> L8
    L24:
        r7 = r7 + 1;     // Catch: Throwable -> L8
        goto L18
    L23:
        r10.put(URLDecoder.decode(r8, "UTF-8"), "");     // Catch: Throwable -> L8
    L25:
        return new Pair(r4, r5);
    L8:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L30:
        throw new IOException("parseUrl url is null !!!");
    }

    public static Pair<String, String> parseUrlWithValueList(String r10, Map<String, List<String>> r11) {
        if (StringUtils.isEmpty(r10) == true) goto L36;
        Uri r12 = Uri.parse(r10);     // Catch: Throwable -> L8
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L8
        String r1 = r12.getScheme();     // Catch: Throwable -> L8
        String r2 = r12.getHost();     // Catch: Throwable -> L8
        int r3 = r12.getPort();     // Catch: Throwable -> L8
        if (r2 == null) goto L13;
        if (r1 == null) goto L10;
        r0.append(r1);     // Catch: Throwable -> L8
        r0.append("://");     // Catch: Throwable -> L8
    L10:
        r0.append(r2);     // Catch: Throwable -> L8
        if (r3 <= 0) goto L13;
        r0.append(':');     // Catch: Throwable -> L8
        r0.append(r3);     // Catch: Throwable -> L8
    L13:
        String r4 = r0.toString();     // Catch: Throwable -> L8
        String r5 = r12.getEncodedPath();     // Catch: Throwable -> L8
        if (r11 == null) goto L31;
        String r13 = r12.getEncodedQuery();     // Catch: Throwable -> L8
        if (r13 == null) goto L31;
        String[] r14 = r13.split(PARAMETER_SEPARATOR);     // Catch: Throwable -> L8
        int r6 = r14.length;     // Catch: Throwable -> L8
        int r7 = 0;
    L18:
        if (r7 >= r6) goto L31;
        String r8 = r14[r7];     // Catch: Throwable -> L8
        int r9 = r8.indexOf(NAME_VALUE_SEPARATOR);     // Catch: Throwable -> L8
        if (r9 < 0) goto L26;
        String r15 = URLDecoder.decode(r8.substring(0, r9), "UTF-8");     // Catch: Throwable -> L8
        List<String> r16 = r11.get(r15);     // Catch: Throwable -> L8
        if (r16 != null) goto L25;
        r16 = new LinkedList();     // Catch: Throwable -> L8
    L25:
        r16.add(URLDecoder.decode(r8.substring(r9 + 1), "UTF-8"));     // Catch: Throwable -> L8
        r11.put(r15, r16);     // Catch: Throwable -> L8
    L30:
        r7 = r7 + 1;     // Catch: Throwable -> L8
        goto L18
    L26:
        String r17 = URLDecoder.decode(r8, "UTF-8");     // Catch: Throwable -> L8
        List<String> r18 = r11.get(r17);     // Catch: Throwable -> L8
        if (r18 != null) goto L29;
        r18 = new LinkedList();     // Catch: Throwable -> L8
    L29:
        r18.add("");     // Catch: Throwable -> L8
        r11.put(r17, r18);     // Catch: Throwable -> L8
    L31:
        return new Pair(r4, r5);
    L8:
        th = move-exception;
        th.printStackTrace();
        throw new IOException("parseUrl url is fail !!!");
    L36:
        throw new IOException("parseUrl url is null !!!");
    }

    public static String removeUrlHashBang(String r2) {
        if (StringUtils.isEmpty(r2) == false) goto L6;
        return r2;
    L6:
        if (r2.contains("#") == true) goto L8;
        return r2;
    L8:
        return r2.substring(0, r2.indexOf("#"));
    }
}
