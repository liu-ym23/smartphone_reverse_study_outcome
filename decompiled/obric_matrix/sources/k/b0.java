package k;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {
    public static final long a(String r10, int r11, int r12) {
        kotlin.n0.d.o.g(r10, "$this$utf8Size");
        boolean r1 = true;
        if (r11 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L50;
        if (r12 < r11) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L48;
        if (r12 <= r10.length()) goto L15;
        r1 = false;
    L15:
        if (r1 == false) goto L46;
        long r4 = 0;
    L17:
        if (r11 >= r12) goto L44;
        char r5 = r10.charAt(r11);
        if (r5 < 128) goto L20;
        if (r5 < 2048) goto L24;
        if (r5 < 55296) goto L43;
        if (r5 > 57343) goto L43;
        int r7 = r11 + 1;
        if (r7 >= r12) goto L34;
        char r8 = r10.charAt(r7);
    L36:
        if (r5 > 56319) goto L42;
        if (r8 < 56320) goto L42;
        if (r8 > 57343) goto L42;
        r4 = r4 + ((long) 4);
        r11 = r11 + 2;
    L42:
        r4 = r4 + 1;
        r11 = r7;
        goto L17
    L34:
        r8 = 0;
    L43:
        int r6 = 3;
    L25:
        r4 = r4 + ((long) r6);
    L21:
        r11 = r11 + 1;
        goto L17
    L24:
        r6 = 2;
        goto L25
    L20:
        r4 = r4 + 1;
        goto L21
    L44:
        return r4;
    L46:
        throw new IllegalArgumentException(("endIndex > string.length: " + r12 + " > " + r10.length()).toString());
    L48:
        throw new IllegalArgumentException(("endIndex < beginIndex: " + r12 + " < " + r11).toString());
    L9:
        r3 = false;
        goto L10
    L50:
        throw new IllegalArgumentException(("beginIndex < 0: " + r11).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static /* synthetic */ long b(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return a(r0, r1, r2);
    }
}
