package com.loc;

/* JADX INFO: loaded from: classes2.dex */
public class p3 {

    static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f7592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7593b;

        a() {
        }
    }

    static class b extends a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int[] f7594f = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f7595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f7596d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int[] f7597e;

        static {
            f7594f = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public b(byte[] r1) {
            this.f7592a = r1;
            this.f7597e = f7594f;
            this.f7595c = 0;
            this.f7596d = 0;
        }

        public final boolean a(byte[] r18, int r19) {
            int r1 = this.f7595c;
            if (r1 != 6) goto L5;
            return false;
        L5:
            int r4 = r19 + 0;
            int r5 = this.f7596d;
            byte[] r6 = this.f7592a;
            int[] r7 = this.f7597e;
            int r10 = 0;
            int r11 = 0;
        L7:
            if (r10 >= r4) goto L62;
            if (r1 != 0) goto L15;
        L9:
            int r15 = r10 + 4;
            if (r15 > r4) goto L14;
            r5 = r7[r18[r10 + 3] & 255] | (((r7[r18[r10 + 1] & 255] << 12) | (r7[r18[r10] & 255] << 18)) | (r7[r18[r10 + 2] & 255] << 6));
            if (r5 < 0) goto L14;
            r6[r11 + 2] = (byte) r5;
            r6[r11 + 1] = (byte) (r5 >> 8);
            r6[r11] = (byte) (r5 >> 16);
            r11 = r11 + 3;
            r10 = r15;
        L14:
            if (r10 >= r4) goto L62;
        L15:
            r10 = r10 + 1;
            int r12 = r7[r18[r10] & 255];
            if (r1 == 0) goto L53;
            if (r1 != 1) goto L19;
            boolean r13 = false;
            if (r12 < 0) goto L50;
            r5 = (r5 << 6) | r12;
        L49:
            r1 = r1 + 1;
        L56:
            r10 = r10;
            goto L7
        L50:
            if (r12 == (-1)) goto L7;
            this.f7595c = 6;
            return false;
        L19:
            if (r1 == 2) goto L40;
            if (r1 == 3) goto L33;
            if (r1 != 4) goto L22;
            r13 = false;
            if (r12 == (-2)) goto L49;
            if (r12 == (-1)) goto L7;
            this.f7595c = 6;
            return false;
        L22:
            if (r1 != 5) goto L7;
            if (r12 == (-1)) goto L7;
        L25:
            this.f7595c = 6;
            return false;
        L33:
            if (r12 < 0) goto L35;
            r5 = (r5 << 6) | r12;
            r6[r11 + 2] = (byte) r5;
            r6[r11 + 1] = (byte) (r5 >> 8);
            r6[r11] = (byte) (r5 >> 16);
            r11 = r11 + 3;
            r1 = 0;
            goto L7
        L35:
            if (r12 != (-2)) goto L37;
            r6[r11 + 1] = (byte) (r5 >> 2);
            r6[r11] = (byte) (r5 >> 10);
            r11 = r11 + 2;
            r1 = 5;
            goto L7
        L37:
            if (r12 == (-1)) goto L7;
        L38:
            this.f7595c = 6;
            return false;
        L40:
            if (r12 < 0) goto L42;
            r5 = (r5 << 6) | r12;
            r1 = r1 + 1;
            goto L7
        L42:
            if (r12 != (-2)) goto L44;
            r6[r11] = (byte) (r5 >> 4);
            r11 = r11 + 1;
            r1 = 4;
            goto L7
        L44:
            if (r12 == (-1)) goto L7;
        L53:
            r13 = false;
            if (r12 < 0) goto L57;
            r1 = r1 + 1;
            r5 = r12;
            goto L56
        L57:
            if (r12 == (-1)) goto L7;
            this.f7595c = 6;
            return false;
        L62:
            if (r1 == 1) goto L38;
            if (r1 == 2) goto L68;
            if (r1 == 3) goto L67;
            if (r1 == 4) goto L38;
        L69:
            this.f7595c = r1;
            this.f7593b = r11;
            return true;
        L67:
            int r2 = r11 + 1;
            r6[r11] = (byte) (r5 >> 10);
            r11 = r2 + 1;
            r6[r2] = (byte) (r5 >> 2);
            goto L69
        L68:
            r6[r11] = (byte) (r5 >> 4);
            r11 = r11 + 1;
            goto L69
        }
    }

    static {
    }

    public static byte[] a(byte[] r1) {
        return b(r1, r1.length);
    }

    private static byte[] b(byte[] r2, int r3) {
        b r0 = new b(new byte[(r3 * 3) / 4]);
        if (r0.a(r2, r3) == false) goto L10;
        int r4 = r0.f7593b;
        byte[] r5 = r0.f7592a;
        if (r4 != r5.length) goto L7;
        return r5;
    L7:
        byte[] r1 = new byte[r4];
        System.arraycopy(r5, 0, r1, 0, r4);
        return r1;
    L10:
        throw new IllegalArgumentException("bad base-64");
    }
}
