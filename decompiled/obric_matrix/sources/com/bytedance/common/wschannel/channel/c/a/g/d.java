package com.bytedance.common.wschannel.channel.c.a.g;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    static String a(int r2) {
        if (r2 >= 1000) goto L5;
    L20:
        StringBuilder r0 = new StringBuilder();
        r0.append("Code must be in range [1000,5000): ");
        r0.append(r2);
    L17:
        return r0.toString();
    L5:
        if (r2 >= 5000) goto L20;
        if (r2 < 1004) goto L12;
        if (r2 > 1006) goto L12;
    L15:
        r0 = new StringBuilder();
        r0.append("Code ");
        r0.append(r2);
        r0.append(" is reserved and may not be used.");
    L12:
        if (r2 >= 1012) goto L14;
        return null;
    L14:
        if (r2 <= 2999) goto L15;
        return null;
    }

    static void b(k.e.a r7, byte[] r8) {
        int r0 = r8.length;
        int r1 = 0;
    L3:
        byte[] r2 = r7.f18261j;
        int r3 = r7.f18262k;
        int r4 = r7.f18263l;
    L4:
        if (r3 >= r4) goto L7;
        int r5 = r1 % r0;
        r2[r3] = (byte) (r2[r3] ^ r8[r5]);
        r3 = r3 + 1;
        r1 = r5 + 1;
        goto L4
    L7:
        if (r7.a() != (-1)) goto L3;
    }

    static void c(int r1) {
        String r2 = a(r1);
        if (r2 != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r2);
    }
}
