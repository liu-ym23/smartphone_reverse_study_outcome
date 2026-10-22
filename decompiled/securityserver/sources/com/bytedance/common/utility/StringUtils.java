package com.bytedance.common.utility;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class StringUtils {
    private static final int CHAR_12288 = 12288;
    private static final int CHAR_127 = 127;
    private static final int CHAR_32 = 32;
    private static final int CHAR_65248 = 65248;
    private static final int CHAR_65280 = 65280;
    private static final int CHAR_65375 = 65375;
    private static final int CHAR_MAX = 31;
    public static final String EMPTY = "";
    private static final long G = 1073741824;
    private static final long K = 1024;
    private static final long M = 1048576;
    private static final int STRING_MAX_NUM = 255;
    private static final long T = 1099511627776L;
    private static final int XOR_MASK = 5;

    private StringUtils() {
    }

    public static String bytesToHuman(long r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.bytesToHuman(r0);
    }

    public static String clean(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.clean(r0);
    }

    public static String compressWithGzip(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.compressWithGzip(r0);
    }

    public static String decompressWithGzip(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.decompressWithGzip(r0);
    }

    public static String decryptWithXor(String r0, Boolean... r1) {
        return com.bytedance.android.standard.tools.string.StringUtils.decryptWithXor(r0, r1);
    }

    public static String ellipsize(String r0, int r1) {
        return com.bytedance.android.standard.tools.string.StringUtils.ellipsize(r0, r1);
    }

    public static String encryptWithXor(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.encryptWithXor(r0);
    }

    public static boolean equal(String r0, String r1) {
        return com.bytedance.android.standard.tools.string.StringUtils.equal(r0, r1);
    }

    public static void escapeEcmaScript(StringBuilder r0, String r1, boolean r2) {
        com.bytedance.android.standard.tools.string.StringUtils.escapeEcmaScript(r0, r1, r2);
    }

    private static String format(long r2, long r4, String r6) {
        double r3 = r2;
        if (r4 <= 1) goto L6;
        r3 = r3 / r4;
    L6:
        return new DecimalFormat("#.##").format(r3) + " " + r6;
    }

    public static String getShortDateTime(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.getShortDateTime(r0);
    }

    public static String handleAdClickTrackUrl(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.handleAdClickTrackUrl(r0);
    }

    public static boolean isChinese(char r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.isChinese(r0);
    }

    public static boolean isEmpty(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.isEmpty(r0);
    }

    public static String mapToString(Map<String, String> r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.mapToString(r0);
    }

    public static HashMap<String, String> parseResponse(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.parseResponse(r0);
    }

    public static String removeBlank(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.removeBlank(r0);
    }

    public static String strEncode(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.strEncode(r0);
    }

    public static Map<String, String> stringToMap(String r0, Map<String, String> r1) {
        return com.bytedance.android.standard.tools.string.StringUtils.stringToMap(r0, r1);
    }

    public static String toDBC(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.toDBC(r0);
    }

    public static String toSBC(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.toSBC(r0);
    }

    public static String trimString(String r0) {
        return com.bytedance.android.standard.tools.string.StringUtils.trimString(r0);
    }
}
