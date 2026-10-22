package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyLog;
import cz.msebera.android.httpclient.client.cache.HeaderConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
public class HttpHeaderParser {
    private static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String RFC1123_OUTPUT_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";
    private static final String RFC1123_PARSE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";

    public HttpHeaderParser() {
    }

    public static Cache.Entry parseCacheHeaders(NetworkResponse r18) {
        long r1 = System.currentTimeMillis();
        Map<String, String> r3 = r18.headers;
        if (r3 != null) goto L5;
        return null;
    L5:
        String r5 = r3.get("Date");
        if (r5 == null) goto L8;
        long r8 = parseDateAsEpoch(r5);
    L9:
        String r6 = r3.get("Cache-Control");
        int r10 = 0;
        if (r6 == null) goto L37;
        String[] r7 = r6.split(",", 0);
        boolean r11 = false;
        long r12 = 0;
        long r14 = 0;
    L13:
        if (r10 >= r7.length) goto L36;
        String r9 = r7[r10].trim();
        if (r9.equals(HeaderConstants.CACHE_CONTROL_NO_CACHE) == true) goto L35;
        if (r9.equals(HeaderConstants.CACHE_CONTROL_NO_STORE) == true) goto L35;
        if (r9.startsWith("max-age=") == false) goto L25;
        r12 = Long.parseLong(r9.substring(8));     // Catch: Exception -> L61
    L34:
        r10 = r10 + 1;
        goto L13
    L25:
        if (r9.startsWith("stale-while-revalidate=") == false) goto L30;
        r14 = Long.parseLong(r9.substring(23));     // Catch: Exception -> L61
        goto L34
    L30:
        if (r9.equals(HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE) == false) goto L32;
    L33:
        r11 = true;
        goto L34
    L32:
        if (r9.equals(HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE) == false) goto L34;
    L35:
        return null;
    L36:
        r10 = 1;
    L38:
        String r4 = r3.get("Expires");
        if (r4 == null) goto L41;
        long r13 = parseDateAsEpoch(r4);
    L42:
        String r15 = r3.get("Last-Modified");
        if (r15 == null) goto L45;
        long r16 = parseDateAsEpoch(r15);
    L46:
        String r17 = r3.get("ETag");
        if (r10 == 0) goto L53;
        long r2 = r1 + (r12 * 1000);
        if (r11 == false) goto L51;
        long r19 = r2;
    L52:
        long r110 = r19;
    L59:
        Cache.Entry r20 = new Cache.Entry();
        r20.data = r18.data;
        r20.etag = r17;
        r20.softTtl = r2;
        r20.ttl = r110;
        r20.serverDate = r8;
        r20.lastModified = r16;
        r20.responseHeaders = r3;
        r20.allResponseHeaders = r18.allHeaders;
        return r20;
    L51:
        r19 = (r14 * 1000) + r2;
        goto L52
    L53:
        r110 = 0;
        if (r8 > 0) goto L56;
    L58:
        r2 = 0;
        goto L59
    L56:
        if (r13 < r8) goto L58;
        r2 = r1 + (r13 - r8);
        r110 = r2;
        goto L59
    L45:
        r16 = 0;
        goto L46
    L41:
        r13 = 0;
        goto L42
    L37:
        r11 = false;
        r12 = 0;
        r14 = 0;
        goto L38
    L8:
        r8 = 0;
        goto L9
    }

    public static long parseDateAsEpoch(String r5) {
        return newUsGmtFormatter("EEE, dd MMM yyyy HH:mm:ss zzz").parse(r5).getTime();
    L4:
        e = move-exception;
        if ("0".equals(r5) == false) goto L8;
    L11:
        VolleyLog.v("Unable to parse dateStr: %s, falling back to 0", new Object[]{r5});
        return 0;
    L8:
        if ("-1".equals(r5) == true) goto L11;
        VolleyLog.e(e, "Unable to parse dateStr: %s, falling back to 0", new Object[]{r5});
        return 0;
    }

    static String formatEpochAsRfc1123(long r2) {
        return newUsGmtFormatter(RFC1123_OUTPUT_FORMAT).format(new Date(r2));
    }

    private static SimpleDateFormat newUsGmtFormatter(String r2) {
        SimpleDateFormat r0 = new SimpleDateFormat(r2, Locale.US);
        r0.setTimeZone(TimeZone.getTimeZone("GMT"));
        return r0;
    }

    public static String parseCharset(Map<String, String> r6, String r7) {
        if (r6 != null) goto L4;
        return r7;
    L4:
        String r8 = r6.get("Content-Type");
        if (r8 == null) goto L16;
        String[] r9 = r8.split(";", 0);
        int r2 = 1;
    L8:
        if (r2 >= r9.length) goto L16;
        String[] r3 = r9[r2].trim().split("=", 0);
        if (r3.length != 2) goto L15;
        if (r3[0].equals("charset") == false) goto L15;
        return r3[1];
    L15:
        r2 = r2 + 1;
    L16:
        return r7;
    }

    public static String parseCharset(Map<String, String> r1) {
        return parseCharset(r1, "ISO-8859-1");
    }

    static Map<String, String> toHeaderMap(List<Header> r3) {
        TreeMap r0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Header> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Header r1 = r4.next();
        r0.put(r1.getName(), r1.getValue());
        goto L4
    L6:
        return r0;
    }

    static List<Header> toAllHeaderList(Map<String, String> r4) {
        ArrayList r0 = new ArrayList(r4.size());
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, String> r1 = r5.next();
        r0.add(new Header(r1.getKey(), r1.getValue()));
        goto L4
    L6:
        return r0;
    }

    static List<Header> combineHeaders(List<Header> r4, Cache.Entry r5) {
        TreeSet r0 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (r4.isEmpty() == true) goto L8;
        Iterator<Header> r1 = r4.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        r0.add(r1.next().getName());
    L8:
        ArrayList r2 = new ArrayList(r4);
        if (r5.allResponseHeaders == null) goto L19;
        if (r5.allResponseHeaders.isEmpty() == true) goto L26;
        Iterator<Header> r6 = r5.allResponseHeaders.iterator();
    L14:
        if (r6.hasNext() == false) goto L26;
        Header r7 = r6.next();
        if (r0.contains(r7.getName()) == true) goto L14;
        r2.add(r7);
    L26:
        return r2;
    L19:
        if (r5.responseHeaders.isEmpty() == true) goto L26;
        Iterator<Map.Entry<String, String>> r8 = r5.responseHeaders.entrySet().iterator();
    L22:
        if (r8.hasNext() == false) goto L26;
        Map.Entry<String, String> r9 = r8.next();
        if (r0.contains(r9.getKey()) == true) goto L22;
        r2.add(new Header(r9.getKey(), r9.getValue()));
        goto L22
    }

    static Map<String, String> getCacheHeaders(Cache.Entry r5) {
        if (r5 == null) goto L4;
        HashMap r0 = new HashMap();
        if (r5.etag == null) goto L9;
        r0.put("If-None-Match", r5.etag);
    L9:
        if (r5.lastModified <= 0) goto L11;
        r0.put("If-Modified-Since", formatEpochAsRfc1123(r5.lastModified));
    L11:
        return r0;
    L4:
        return Collections.emptyMap();
    }
}
