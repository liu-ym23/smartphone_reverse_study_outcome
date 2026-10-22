package k;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f18237a = null;

    static {
        h.a r0 = h.f18267j;
        f18237a = r0.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").m();
        r0.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").m();
    }

    public static final String a(byte[] r10, byte[] r11) {
        kotlin.n0.d.o.g(r10, "$this$encodeBase64");
        kotlin.n0.d.o.g(r11, "map");
        byte[] r0 = new byte[((r10.length + 2) / 3) * 4];
        int r2 = r10.length - (r10.length % 3);
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int r5 = r3 + 1;
        byte r6 = r10[r3];
        int r7 = r5 + 1;
        byte r8 = r10[r5];
        int r9 = r7 + 1;
        byte r12 = r10[r7];
        int r13 = r4 + 1;
        r0[r4] = r11[(r6 & 255) >> 2];
        int r14 = r13 + 1;
        r0[r13] = r11[((r6 & 3) << 4) | ((r8 & 255) >> 4)];
        int r15 = r14 + 1;
        r0[r14] = r11[((r8 & 15) << 2) | ((r12 & 255) >> 6)];
        r4 = r15 + 1;
        r0[r15] = r11[r12 & 63];
        r3 = r9;
        goto L3
    L5:
        int r16 = r10.length - r2;
        if (r16 == 1) goto L10;
        if (r16 != 2) goto L12;
        int r17 = r3 + 1;
        byte r18 = r10[r3];
        byte r19 = r10[r17];
        int r20 = r4 + 1;
        r0[r4] = r11[(r18 & 255) >> 2];
        int r21 = r20 + 1;
        r0[r20] = r11[((r18 & 3) << 4) | ((r19 & 255) >> 4)];
        r0[r21] = r11[(r19 & 15) << 2];
        r0[r21 + 1] = (byte) 61;
    L12:
        return b.b(r0);
    L10:
        byte r110 = r10[r3];
        int r22 = r4 + 1;
        r0[r4] = r11[(r110 & 255) >> 2];
        int r1 = r22 + 1;
        r0[r22] = r11[(r110 & 3) << 4];
        byte r111 = (byte) 61;
        r0[r1] = r111;
        r0[r1 + 1] = r111;
        goto L12
    }

    public static /* synthetic */ String b(byte[] r0, byte[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = f18237a;
    L6:
        return a(r0, r1);
    }
}
