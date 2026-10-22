package tmsdkobf;

import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ai {

    static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f102a;
        public int b;

        a() {
        }
    }

    static class b extends a {
        private static final int[] f = null;
        private static final int[] g = null;
        private int c;
        private int d;
        private final int[] e;

        static {
            f = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
            g = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        }

        public b(int r1, byte[] r2) {
            this.f102a = r2;
            if ((r1 & 8) != 0) goto L5;
            int[] r3 = f;
        L6:
            this.e = r3;
            this.c = 0;
            this.d = 0;
            return;
        L5:
            r3 = g;
            goto L6
        }

        public boolean a(byte[] r17, int r18, int r19, boolean r20) {
            int r1 = this.c;
            if (r1 != 6) goto L5;
            return false;
        L5:
            int r4 = r19 + r18;
            int r5 = this.d;
            byte[] r6 = this.f102a;
            int[] r7 = this.e;
            int r9 = 0;
            int r8 = r5;
            int r10 = r1;
            int r2 = r18;
        L7:
            if (r2 >= r4) goto L60;
            if (r10 != 0) goto L16;
        L9:
            int r14 = r2 + 4;
            if (r14 > r4) goto L14;
            r8 = (((r7[r17[r2] & UByte.MAX_VALUE] << 18) | (r7[r17[r2 + 1] & UByte.MAX_VALUE] << 12)) | (r7[r17[r2 + 2] & UByte.MAX_VALUE] << 6)) | r7[r17[r2 + 3] & UByte.MAX_VALUE];
            if (r8 < 0) goto L14;
            r6[r9 + 2] = (byte) r8;
            r6[r9 + 1] = (byte) (r8 >> 8);
            r6[r9] = (byte) (r8 >> 16);
            r9 = r9 + 3;
            r2 = r14;
        L14:
            if (r2 >= r4) goto L60;
        L16:
            int r15 = r2 + 1;
            int r3 = r7[r17[r2] & UByte.MAX_VALUE];
            if (r10 == 0) goto L54;
            if (r10 != 1) goto L20;
            if (r3 < 0) goto L51;
        L49:
            r8 = (r8 << 6) | r3;
        L50:
            r10 = r10 + 1;
        L59:
            r2 = r15;
            goto L7
        L51:
            if (r3 == (-1)) goto L59;
            this.c = 6;
            return false;
        L20:
            if (r10 != 2) goto L22;
            if (r3 >= 0) goto L49;
            if (r3 != (-2)) goto L45;
            r6[r9] = (byte) (r8 >> 4);
            r9 = r9 + 1;
            r10 = 4;
            goto L59
        L45:
            if (r3 == (-1)) goto L59;
            this.c = 6;
            return false;
        L22:
            if (r10 == 3) goto L34;
            if (r10 == 4) goto L29;
            if (r10 != 5) goto L59;
            if (r3 == (-1)) goto L59;
            this.c = 6;
            return false;
        L29:
            if (r3 == (-2)) goto L50;
            if (r3 == (-1)) goto L59;
            this.c = 6;
            return false;
        L34:
            if (r3 < 0) goto L36;
            r8 = (r8 << 6) | r3;
            r6[r9 + 2] = (byte) r8;
            r6[r9 + 1] = (byte) (r8 >> 8);
            r6[r9] = (byte) (r8 >> 16);
            r9 = r9 + 3;
            r10 = 0;
            goto L59
        L36:
            if (r3 != (-2)) goto L38;
            r6[r9 + 1] = (byte) (r8 >> 2);
            r6[r9] = (byte) (r8 >> 10);
            r9 = r9 + 2;
            r10 = 5;
            goto L59
        L38:
            if (r3 == (-1)) goto L59;
            this.c = 6;
            return false;
        L54:
            if (r3 < 0) goto L56;
            r10 = r10 + 1;
            r8 = r3;
            goto L59
        L56:
            if (r3 == (-1)) goto L59;
            this.c = 6;
            return false;
        L60:
            if (r20 == true) goto L63;
            this.c = r10;
            this.d = r8;
            this.b = r9;
            return true;
        L63:
            if (r10 == 1) goto L74;
            if (r10 == 2) goto L71;
            if (r10 == 3) goto L70;
            if (r10 != 4) goto L72;
            this.c = 6;
            return false;
        L72:
            this.c = r10;
            this.b = r9;
            return true;
        L70:
            int r11 = r9 + 1;
            r6[r9] = (byte) (r8 >> 10);
            r9 = r9 + 2;
            r6[r11] = (byte) (r8 >> 2);
            goto L72
        L71:
            r6[r9] = (byte) (r8 >> 4);
            r9 = r9 + 1;
            goto L72
        L74:
            this.c = 6;
            return false;
        }
    }

    static {
    }

    public static byte[] a(String r0, int r1) {
        return a(r0.getBytes(), r1);
    }

    public static byte[] a(byte[] r2, int r3) {
        return a(r2, 0, r2.length, r3);
    }

    public static byte[] a(byte[] r2, int r3, int r4, int r5) {
        b r0 = new b(r5, new byte[(r4 * 3) / 4]);
        if (r0.a(r2, r3, r4, true) == false) goto L10;
        int r6 = r0.b;
        byte[] r7 = r0.f102a;
        if (r6 != r7.length) goto L7;
        return r7;
    L7:
        byte[] r8 = new byte[r6];
        System.arraycopy(r7, 0, r8, 0, r6);
        return r8;
    L10:
        throw new IllegalArgumentException("bad base-64");
    }
}
