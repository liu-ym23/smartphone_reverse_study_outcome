package d.c.c.d;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    private static String a(int r4, int r5, String r6) {
        if (r4 < 0) goto L5;
        if (r5 < 0) goto L10;
        return k("%s (%s) must be less than size (%s)", new Object[]{r6, Integer.valueOf(r4), Integer.valueOf(r5)});
    L10:
        throw new IllegalArgumentException("negative size: " + r5);
    L5:
        return k("%s (%s) must not be negative", new Object[]{r6, Integer.valueOf(r4)});
    }

    public static void b(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void c(boolean r0, Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r1));
    }

    public static void d(boolean r0, String r1, Object... r2) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(k(r1, r2));
    }

    public static int e(int r1, int r2) {
        f(r1, r2, "index");
        return r1;
    }

    public static int f(int r1, int r2, String r3) {
        if (r1 < 0) goto L6;
        if (r1 >= r2) goto L6;
        return r1;
    L6:
        throw new IndexOutOfBoundsException(a(r1, r2, r3));
    }

    public static <T> T g(T r0) {
        Objects.requireNonNull(r0);
        return r0;
    }

    public static <T> T h(T r0, Object r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(String.valueOf(r1));
    }

    public static void i(boolean r0) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static void j(boolean r0, Object r1) {
        if (r0 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r1));
    }

    static String k(String r6, Object... r7) {
        String r8 = String.valueOf(r6);
        StringBuilder r0 = new StringBuilder(r8.length() + (r7.length * 16));
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r7.length) goto L9;
        int r3 = r8.indexOf("%s", r2);
        if (r3 == (-1)) goto L9;
        r0.append(r8.substring(r2, r3));
        r0.append(r7[r1]);
        r2 = r3 + 2;
        r1 = r1 + 1;
    L9:
        r0.append(r8.substring(r2));
        if (r1 >= r7.length) goto L17;
        r0.append(" [");
        int r9 = r1 + 1;
        r0.append(r7[r1]);
    L13:
        if (r9 >= r7.length) goto L15;
        r0.append(", ");
        r0.append(r7[r9]);
        r9 = r9 + 1;
        goto L13
    L15:
        r0.append(']');
    L17:
        return r0.toString();
    }
}
