package tmsdkobf;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zj {
    public static byte[] a() {
        return new byte[]{-15, 94, 120, -46, 48, 51, -62, -60, -70, -56, -87, 37, 103, 126, -122, 58};
    }

    public static byte[] b(byte[] r14, byte[] r15) {
        if (r14 != null) goto L4;
        return null;
    L4:
        if (r14.length == 0) goto L34;
        int r1 = 4;
        if ((r14.length % 4) != 0) goto L9;
        int r0 = (r14.length >>> 2) + 1;
    L10:
        int[] r2 = new int[r0];
        a(r14, r2);
        int r3 = r0 - 1;
        r2[r3] = r14.length;
        if ((r15.length % 4) != 0) goto L13;
        int r16 = r15.length >>> 2;
    L14:
        if (r16 < 4) goto L17;
        r1 = r16;
    L17:
        int[] r17 = new int[r1];
        int r5 = 0;
    L18:
        if (r5 >= r1) goto L20;
        r17[r5] = 0;
        r5 = r5 + 1;
        goto L18
    L20:
        a(r15, r17);
        int r18 = r2[r3];
        int r4 = r2[0];
        int r6 = (52 / r0) + 6;
        int r7 = 0;
    L21:
        int r8 = r6 - 1;
        if (r6 <= 0) goto L27;
        r7 = r7 - 1640531527;
        int r9 = (r7 >>> 2) & 3;
        int r10 = 0;
    L24:
        if (r10 >= r3) goto L26;
        int r11 = r10 + 1;
        int r12 = r2[r11];
        r18 = ((((r18 >>> 5) ^ (r12 << 2)) + ((r12 >>> 3) ^ (r18 << 4))) ^ ((r12 ^ r7) + (r18 ^ r17[(r10 & 3) ^ r9]))) + r2[r10];
        r2[r10] = r18;
        r10 = r11;
        goto L24
    L26:
        int r13 = r2[0];
        r18 = ((((r18 >>> 5) ^ (r13 << 2)) + ((r13 >>> 3) ^ (r18 << 4))) ^ ((r13 ^ r7) + (r18 ^ r17[r9 ^ (r10 & 3)]))) + r2[r3];
        r2[r3] = r18;
        r6 = r8;
        goto L21
    L27:
        byte[] r19 = new byte[r0 << 2];
        a(r2, r0, r19);
        return r19;
    L13:
        r16 = (r15.length >>> 2) + 1;
        goto L14
    L9:
        r0 = (r14.length >>> 2) + 2;
        goto L10
    L34:
        return null;
    }

    public static void a(byte[] r7, int[] r8) {
        int r0 = r7.length >> 2;
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= r0) goto L7;
        int r5 = r7[r2] & 255;
        r8[r1] = r5;
        int r3 = ((r7[r2 + 1] & 255) << 8) | r5;
        r8[r1] = r3;
        int r4 = r2 + 3;
        int r6 = r3 | ((r7[r2 + 2] & 255) << 16);
        r8[r1] = r6;
        r2 = r2 + 4;
        r8[r1] = r6 | ((r7[r4] & 255) << 24);
        r1 = r1 + 1;
        goto L4
    L7:
        if (r2 >= r7.length) goto L12;
        int r9 = r2 + 1;
        r8[r1] = r7[r2] & 255;
        int r10 = 8;
    L10:
        if (r9 >= r7.length) goto L15;
        r8[r1] = r8[r1] | ((r7[r9] & 255) << r10);
        r9 = r9 + 1;
        r10 = r10 + 8;
        goto L10
    L15:
        return;
    }

    public static void a(int[] r8, int r9, byte[] r10) {
        int r0 = r10.length >> 2;
        if (r0 <= r9) goto L5;
        r0 = r9;
    L5:
        int r1 = 0;
        int r2 = 0;
    L7:
        if (r1 >= r0) goto L9;
        int r5 = r8[r1];
        r10[r2] = (byte) (r5 & 255);
        r10[r2 + 1] = (byte) ((r5 >>> 8) & 255);
        int r4 = r2 + 3;
        r10[r2 + 2] = (byte) ((r5 >>> 16) & 255);
        r2 = r2 + 4;
        r10[r4] = (byte) ((r5 >>> 24) & 255);
        r1 = r1 + 1;
        goto L7
    L9:
        if (r9 > r0) goto L11;
        return;
    L11:
        if (r2 >= r10.length) goto L21;
        int r11 = r2 + 1;
        r10[r2] = (byte) (r8[r1] & 255);
        int r3 = 8;
    L13:
        if (r3 > 24) goto L22;
        if (r11 >= r10.length) goto L23;
        r10[r11] = (byte) ((r8[r1] >>> r3) & 255);
        r3 = r3 + 8;
        r11 = r11 + 1;
        goto L13
    L23:
        return;
    L22:
        return;
    }

    public static byte[] a(byte[] r13, byte[] r14) {
        if (r13 == null) goto L36;
        if (r14 == null) goto L36;
        if (r13.length == 0) goto L36;
        int r2 = 4;
        if ((r13.length % 4) != 0) goto L36;
        if (r13.length < 8) goto L36;
        int r1 = r13.length >>> 2;
        int[] r3 = new int[r1];
        a(r13, r3);
        if ((r14.length % 4) != 0) goto L16;
        int r15 = r14.length >>> 2;
    L17:
        if (r15 < 4) goto L20;
        r2 = r15;
    L20:
        int[] r16 = new int[r2];
        int r5 = 0;
    L21:
        if (r5 >= r2) goto L23;
        r16[r5] = 0;
        r5 = r5 + 1;
        goto L21
    L23:
        a(r14, r16);
        int r17 = r1 - 1;
        int r4 = r3[r17];
        int r6 = r3[0];
        int r7 = ((52 / r1) + 6) * (-1640531527);
    L24:
        if (r7 == 0) goto L29;
        int r8 = (r7 >>> 2) & 3;
        int r9 = r17;
    L26:
        if (r9 <= 0) goto L28;
        int r10 = r3[r9 - 1];
        r6 = r3[r9] - (((r6 ^ r7) + (r10 ^ r16[(r9 & 3) ^ r8])) ^ (((r10 >>> 5) ^ (r6 << 2)) + ((r6 >>> 3) ^ (r10 << 4))));
        r3[r9] = r6;
        r9 = r9 - 1;
        goto L26
    L28:
        int r11 = r3[r17];
        r6 = r3[0] - (((r6 ^ r7) + (r16[r8 ^ (r9 & 3)] ^ r11)) ^ (((r11 >>> 5) ^ (r6 << 2)) + ((r6 >>> 3) ^ (r11 << 4))));
        r3[0] = r6;
        r7 = r7 - (-1640531527);
        goto L24
    L29:
        int r18 = r3[r17];
        if (r18 < 0) goto L36;
        if (r18 > (r17 << 2)) goto L36;
        byte[] r19 = new byte[r18];
        a(r3, r17, r19);
        return r19;
    L16:
        r15 = (r14.length >>> 2) + 1;
    L36:
        return null;
    }
}
