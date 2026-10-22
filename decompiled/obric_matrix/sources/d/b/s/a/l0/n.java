package d.b.s.a.l0;

/* JADX INFO: loaded from: classes.dex */
public final class n {
    public static final boolean a(String r1) {
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        return !r2;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L10
    }

    public static final String b(Object r6) {
        if (r6 == null) goto L25;
        if (kotlin.n0.d.o.a(r6, "") == true) goto L25;
        if ((r6 instanceof byte[]) == true) goto L9;
        String r7 = r6.toString();
        int r0 = r7.length();
        if (r0 <= 4) goto L13;
        int r1 = Math.min(4, r0 / 3);
        int r2 = Math.max(r0 - 4, (r0 * 2) / 3);
        StringBuilder r3 = new StringBuilder(r0);
        int r4 = 0;
        int r5 = r7.length();
    L15:
        if (r4 >= r5) goto L22;
        if (r4 >= r1) goto L19;
    L17:
        char r8 = r7.charAt(r4);
    L18:
        r3.append(r8);
        r4 = r4 + 1;
        goto L15
    L19:
        if (r4 >= r2) goto L17;
        r8 = '*';
        goto L18
    L22:
        String r9 = r3.toString();
        kotlin.n0.d.o.b(r9, "sb.toString()");
        return r9;
    L13:
        return kotlin.u0.k.s("*", r0);
    L9:
        return b(e.a((byte[]) r6));
    L25:
        return String.valueOf(r6);
    }
}
