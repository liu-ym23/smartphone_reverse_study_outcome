package cz.msebera.android.httpclient.util;

import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
public class Args {
    public Args() {
    }

    public static void check(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(r1);
    }

    public static void check(boolean r0, String r1, Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r1, r2));
    }

    public static void check(boolean r2, String r3, Object r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r3, new Object[]{r4}));
    }

    public static <T> T notNull(T r1, String r2) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        throw new IllegalArgumentException(r2 + " may not be null");
    }

    public static <T extends CharSequence> T notEmpty(T r1, String r2) {
        if (r1 == null) goto L9;
        if (TextUtils.isEmpty(r1) == true) goto L7;
        return r1;
    L7:
        throw new IllegalArgumentException(r2 + " may not be empty");
    L9:
        throw new IllegalArgumentException(r2 + " may not be null");
    }

    public static <T extends CharSequence> T notBlank(T r1, String r2) {
        if (r1 == null) goto L9;
        if (TextUtils.isBlank(r1) == true) goto L7;
        return r1;
    L7:
        throw new IllegalArgumentException(r2 + " may not be blank");
    L9:
        throw new IllegalArgumentException(r2 + " may not be null");
    }

    public static <T extends CharSequence> T containsNoBlanks(T r1, String r2) {
        if (r1 == null) goto L13;
        if (r1.length() == 0) goto L11;
        if (TextUtils.containsBlanks(r1) == true) goto L9;
        return r1;
    L9:
        throw new IllegalArgumentException(r2 + " may not contain blanks");
    L11:
        throw new IllegalArgumentException(r2 + " may not be empty");
    L13:
        throw new IllegalArgumentException(r2 + " may not be null");
    }

    public static <E, T extends Collection<E>> T notEmpty(T r1, String r2) {
        if (r1 == null) goto L9;
        if (r1.isEmpty() == true) goto L7;
        return r1;
    L7:
        throw new IllegalArgumentException(r2 + " may not be empty");
    L9:
        throw new IllegalArgumentException(r2 + " may not be null");
    }

    public static int positive(int r1, String r2) {
        if (r1 <= 0) goto L5;
        return r1;
    L5:
        throw new IllegalArgumentException(r2 + " may not be negative or zero");
    }

    public static long positive(long r2, String r4) {
        if (r2 <= 0) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException(r4 + " may not be negative or zero");
    }

    public static int notNegative(int r1, String r2) {
        if (r1 < 0) goto L5;
        return r1;
    L5:
        throw new IllegalArgumentException(r2 + " may not be negative");
    }

    public static long notNegative(long r2, String r4) {
        if (r2 < 0) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException(r4 + " may not be negative");
    }
}
