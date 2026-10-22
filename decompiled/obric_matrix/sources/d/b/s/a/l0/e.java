package d.b.s.a.l0;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f14853a = null;

    static {
        char[] r0 = "0123456789abcdef".toCharArray();
        kotlin.n0.d.o.b(r0, "(this as java.lang.String).toCharArray()");
        f14853a = r0;
    }

    public static final String a(byte[] r8) {
        kotlin.n0.d.o.g(r8, "$this$toHexString");
        char[] r0 = new char[r8.length * 2];
        int r1 = r8.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L6;
        int r4 = r8[r2] & 255;
        int r5 = r3 + 1;
        char[] r6 = f14853a;
        r0[r3] = r6[r4 >> 4];
        r3 = r5 + 1;
        r0[r5] = r6[r4 & 15];
        r2 = r2 + 1;
        goto L3
    L6:
        return new String(r0);
    }
}
