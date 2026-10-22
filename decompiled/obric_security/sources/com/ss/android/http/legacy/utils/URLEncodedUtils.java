package com.ss.android.http.legacy.utils;

import com.ss.android.http.legacy.NameValuePair;
import com.ss.android.http.legacy.message.BasicNameValuePair;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";

    private URLEncodedUtils() {
    }

    public static List<NameValuePair> parse(URI r2, String r3) {
        List<NameValuePair> r0 = Collections.emptyList();
        String r4 = r2.getRawQuery();
        if (r4 != null) goto L5;
        return r0;
    L5:
        if (r4.length() <= 0) goto L9;
        ArrayList r1 = new ArrayList();
        parse(r1, new Scanner(r4), r3);
        return r1;
    L9:
        return r0;
    }

    public static void parse(List<NameValuePair> r4, Scanner r5, String r6) {
        r5.useDelimiter(PARAMETER_SEPARATOR);
    L4:
        if (r5.hasNext() == false) goto L16;
        String[] r0 = r5.next().split(NAME_VALUE_SEPARATOR);
        if (r0.length == 0) goto L15;
        if (r0.length > 2) goto L15;
        String r1 = decode(r0[0], r6);
        if (r0.length != 2) goto L12;
        String r2 = decode(r0[1], r6);
    L13:
        r4.add(new BasicNameValuePair(r1, r2));
        goto L4
    L12:
        r2 = null;
    L15:
        throw new IllegalArgumentException("bad parameter");
    }

    public static String format(List<? extends NameValuePair> r4, String r5) {
        StringBuilder r0 = new StringBuilder();
        Iterator<? extends NameValuePair> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L14;
        NameValuePair r1 = r6.next();
        String r2 = encode(r1.getName(), r5);
        String r3 = r1.getValue();
        if (r3 == null) goto L8;
        String r7 = encode(r3, r5);
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append(PARAMETER_SEPARATOR);
    L12:
        r0.append(r2);
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r7);
        goto L4
    L8:
        r7 = "";
        goto L10
    L14:
        return r0.toString();
    }

    private static String decode(String r0, String r1) {
        if (r1 != null) goto L10;
        r1 = "ISO-8859-1";
    L10:
        return URLDecoder.decode(r0, r1);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
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
}
