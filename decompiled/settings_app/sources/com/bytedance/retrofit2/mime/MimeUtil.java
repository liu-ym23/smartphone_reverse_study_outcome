package com.bytedance.retrofit2.mime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class MimeUtil {
    private static final Pattern CHARSET = null;

    static {
        CHARSET = Pattern.compile("\\Wcharset=([^\\s;]+)", 2);
    }

    @Deprecated
    public static String parseCharset(String r1) {
        return parseCharset(r1, "UTF-8");
    }

    public static String parseCharset(String r2, String r3) {
        Matcher r4 = CHARSET.matcher(r2);     // Catch: IllegalArgumentException -> L7
        if (r4.find() == false) goto L6;
        return r4.group(1).replaceAll("[\"\\\\]", "");
    L6:
        return r3;
    }

    private MimeUtil() {
    }
}
