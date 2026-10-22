package cz.msebera.android.httpclient.util;

/* JADX INFO: loaded from: classes5.dex */
public final class TextUtils {
    public TextUtils() {
    }

    public static boolean isEmpty(CharSequence r1) {
        if (r1 != null) goto L6;
        return true;
    L6:
        if (r1.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean isBlank(CharSequence r4) {
        if (r4 != null) goto L5;
        return true;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= r4.length()) goto L12;
        if (Character.isWhitespace(r4.charAt(r2)) == false) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    public static boolean containsBlanks(CharSequence r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r3.length()) goto L13;
        if (Character.isWhitespace(r3.charAt(r1)) == true) goto L10;
        r1 = r1 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    }
}
