package cz.msebera.android.httpclient.util;

/* JADX INFO: loaded from: classes5.dex */
public class Asserts {
    public Asserts() {
    }

    public static void check(boolean r0, String r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(r1);
    }

    public static void check(boolean r0, String r1, Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.format(r1, r2));
    }

    public static void check(boolean r2, String r3, Object r4) {
        if (r2 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.format(r3, new Object[]{r4}));
    }

    public static void notNull(Object r1, String r2) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(r2 + " is null");
    }

    public static void notEmpty(CharSequence r1, String r2) {
        if (TextUtils.isEmpty(r1) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r2 + " is empty");
    }

    public static void notBlank(CharSequence r1, String r2) {
        if (TextUtils.isBlank(r1) == true) goto L6;
        return;
    L6:
        throw new IllegalStateException(r2 + " is blank");
    }
}
