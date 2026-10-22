package android.app.sceneperception.utils;

import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class StringUtils {
    public StringUtils() {
    }

    public static boolean isEmpty(String str) {
        if (str != null) goto L4;
    L7:
        return true;
    L4:
        if (str.length() == 0) goto L7;
        return false;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        if (str != null) goto L4;
    L7:
        return true;
    L4:
        if (str.trim().isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        if (str1 != str2) goto L5;
        return true;
    L5:
        if (str1 == null) goto L10;
        if (str2 != null) goto L9;
        return false;
    L9:
        return str1.equalsIgnoreCase(str2);
    L10:
        return false;
    }

    public static boolean equals(String str1, String str2) {
        if (str1 != str2) goto L5;
        return true;
    L5:
        if (str1 == null) goto L10;
        if (str2 != null) goto L9;
        return false;
    L9:
        return str1.equals(str2);
    L10:
        return false;
    }

    public static String trim(String str) {
        if (str != null) goto L5;
        return null;
    L5:
        return str.trim();
    }

    public static String trimToEmpty(String str) {
        if (str != null) goto L5;
        return "";
    L5:
        return str.trim();
    }

    public static String defaultIfEmpty(String str, String defaultStr) {
        if (isEmpty(str) == false) goto L6;
        return defaultStr;
    L6:
        return str;
    }

    public static String defaultIfBlank(String str, String defaultStr) {
        if (isBlank(str) == false) goto L6;
        return defaultStr;
    L6:
        return str;
    }

    public static String join(String separator, String... strings) {
        if (strings != null) goto L4;
        return "";
    L4:
        if (strings.length == 0) goto L24;
        if (separator != null) goto L8;
        separator = "";
    L8:
        StringBuilder sb = new StringBuilder();
        int i = 0;
    L10:
        if (i >= strings.length) goto L18;
        if (i <= 0) goto L14;
        sb.append(separator);
    L14:
        if (strings[i] == null) goto L16;
        sb.append(strings[i]);
    L16:
        i = i + 1;
        goto L10
    L18:
        return sb.toString();
    L24:
        return "";
    }

    public static String join(String separator, Collection<String> collection) {
        if (CollectionUtils.isEmpty(collection) == false) goto L7;
        return "";
    L7:
        return join(separator, (String[]) collection.toArray(new String[0]));
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null) goto L7;
        if (searchStr != null) goto L6;
        return false;
    L6:
        return str.toLowerCase().contains(searchStr.toLowerCase());
    L7:
        return false;
    }

    public static String leftPad(String str, int size, char padChar) {
        if (str != null) goto L5;
        return null;
    L5:
        int pads = size - str.length();
        if (pads > 0) goto L8;
        return str;
    L8:
        StringBuilder sb = new StringBuilder();
        int i = 0;
    L9:
        if (i >= pads) goto L11;
        sb.append(padChar);
        i = i + 1;
        goto L9
    L11:
        sb.append(str);
        return sb.toString();
    }

    public static String rightPad(String str, int size, char padChar) {
        if (str != null) goto L5;
        return null;
    L5:
        int pads = size - str.length();
        if (pads > 0) goto L8;
        return str;
    L8:
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
    L9:
        if (i >= pads) goto L12;
        sb.append(padChar);
        i = i + 1;
        goto L9
    L12:
        return sb.toString();
    }
}
