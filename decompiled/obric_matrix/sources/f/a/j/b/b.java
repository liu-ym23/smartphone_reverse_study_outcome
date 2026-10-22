package f.a.j.b;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    static {
    }

    public static int a(int r0, int r1) {
        if (r0 >= r1) goto L4;
        return -1;
    L4:
        if (r0 <= r1) goto L6;
        return 1;
    L6:
        return 0;
    }

    public static int b(long r0, long r2) {
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 <= r2) goto L7;
        return 1;
    L7:
        return 0;
    }

    public static <T> T c(T r0, String r1) {
        Objects.requireNonNull(r0, r1);
        return r0;
    }
}
