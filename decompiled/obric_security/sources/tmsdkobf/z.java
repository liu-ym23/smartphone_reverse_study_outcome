package tmsdkobf;

import com.qq.taf.jce.JceStruct;
import kotlin.UByte;

/* JADX INFO: loaded from: classes5.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f648a = true;

    static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f649a;
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
            this.f649a = r2;
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
            byte[] r6 = this.f649a;
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
            if (r20 == true) goto L64;
            this.c = r10;
            this.d = r8;
        L62:
            this.b = r9;
            return true;
        L64:
            if (r10 == 1) goto L74;
            if (r10 == 2) goto L72;
            if (r10 == 3) goto L71;
            if (r10 != 4) goto L73;
            this.c = 6;
            return false;
        L73:
            this.c = r10;
            goto L62
        L71:
            int r11 = r9 + 1;
            r6[r9] = (byte) (r8 >> 10);
            r9 = r9 + 2;
            r6[r11] = (byte) (r8 >> 2);
            goto L73
        L72:
            r6[r9] = (byte) (r8 >> 4);
            r9 = r9 + 1;
            goto L73
        L74:
            this.c = 6;
            return false;
        }
    }

    static class c extends a {
        private static final byte[] j = null;
        private static final byte[] k = null;
        static final /* synthetic */ boolean l = false;
        private final byte[] c;
        int d;
        private int e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        private final byte[] i;

        static {
            l = true;
            j = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
            k = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        }

        public c(int r4, byte[] r5) {
            this.f649a = r5;
            boolean r1 = true;
            if ((r4 & 1) != 0) goto L5;
            boolean r6 = true;
        L6:
            this.f = r6;
            if ((r4 & 2) != 0) goto L9;
            boolean r7 = true;
        L10:
            this.g = r7;
            if ((r4 & 4) != 0) goto L14;
            r1 = false;
        L14:
            this.h = r1;
            if ((r4 & 8) != 0) goto L17;
            byte[] r8 = j;
        L18:
            this.i = r8;
            this.c = new byte[2];
            this.d = 0;
            if (r7 == false) goto L21;
            int r9 = 19;
        L22:
            this.e = r9;
            return;
        L21:
            r9 = -1;
            goto L22
        L17:
            r8 = k;
            goto L18
        L9:
            r7 = false;
            goto L10
        L5:
            r6 = false;
            goto L6
        }

        public boolean a(byte[] r19, int r20, int r21, boolean r22) {
            byte[] r1 = this.i;
            byte[] r2 = this.f649a;
            int r3 = this.e;
            int r4 = r21 + r20;
            int r5 = this.d;
            int r7 = 0;
            if (r5 == 1) goto L9;
            if (r5 != 2) goto L13;
            int r6 = r20 + 1;
            if (r6 > r4) goto L13;
            byte[] r10 = this.c;
            int r11 = ((r10[1] & UByte.MAX_VALUE) << 8) | ((r10[0] & UByte.MAX_VALUE) << 16);
            byte r12 = r19[r20];
        L12:
            int r13 = r11 | (r12 & UByte.MAX_VALUE);
            this.d = 0;
        L15:
            if (r13 == (-1)) goto L25;
            r2[0] = r1[(r13 >> 18) & 63];
            r2[1] = r1[(r13 >> 12) & 63];
            r2[2] = r1[(r13 >> 6) & 63];
            r2[3] = r1[r13 & 63];
            r3 = r3 - 1;
            if (r3 == 0) goto L19;
            int r8 = 4;
        L26:
            int r14 = r6 + 3;
            if (r14 > r4) goto L35;
            int r9 = (r19[r6 + 2] & UByte.MAX_VALUE) | (((r19[r6 + 1] & UByte.MAX_VALUE) << 8) | ((r19[r6] & UByte.MAX_VALUE) << 16));
            r2[r8] = r1[(r9 >> 18) & 63];
            r2[r8 + 1] = r1[(r9 >> 12) & 63];
            r2[r8 + 2] = r1[(r9 >> 6) & 63];
            r2[r8 + 3] = r1[r9 & 63];
            int r15 = r8 + 4;
            r3 = r3 - 1;
            if (r3 == 0) goto L31;
            r8 = r15;
            r6 = r14;
            goto L26
        L31:
            if (this.h == false) goto L33;
            int r16 = r8 + 5;
            r2[r15] = JceStruct.SIMPLE_LIST;
        L33:
            r8 = r16 + 1;
            r2[r16] = 10;
            r6 = r14;
        L23:
            r3 = 19;
            goto L26
        L100:
            r8 = r15 + 1;
            r2[r15] = 10;
            r6 = r14;
            goto L23
        L35:
            if (r22 == false) goto L93;
            int r17 = this.d;
            int r18 = r6 - r17;
            if (r18 != (r4 - 1)) goto L52;
            if (r17 <= 0) goto L40;
            byte r23 = this.c[0];
            r7 = 1;
        L41:
            int r24 = (r23 & UByte.MAX_VALUE) << 4;
            this.d = r17 - r7;
            r2[r8] = r1[(r24 >> 6) & 63];
            int r110 = r8 + 2;
            r2[r8 + 1] = r1[r24 & 63];
            if (this.f == false) goto L45;
            r2[r110] = 61;
            r110 = r8 + 4;
            r2[r8 + 3] = 61;
        L45:
            if (this.g == true) goto L47;
            r8 = r110;
        L80:
            boolean r25 = l;
            if (r25 == false) goto L83;
        L87:
            if (r25 == true) goto L98;
            if (r6 == r4) goto L98;
            throw new AssertionError();
        L98:
            this.b = r8;
            this.e = r3;
            return true;
        L83:
            if (this.d == 0) goto L87;
            throw new AssertionError();
        L47:
            if (this.h == false) goto L49;
            r2[r110] = JceStruct.SIMPLE_LIST;
            r110 = r110 + 1;
        L49:
            int r26 = r110 + 1;
            r2[r110] = 10;
        L79:
            r8 = r26;
            goto L80
        L40:
            r23 = r19[r6];
            r6 = r6 + 1;
            goto L41
        L52:
            if (r18 != (r4 - 2)) goto L71;
            if (r17 <= 1) goto L55;
            byte r27 = this.c[0];
            int r111 = 1;
        L56:
            int r28 = (r27 & UByte.MAX_VALUE) << 10;
            if (r17 <= 0) goto L59;
            int r112 = r111 + 1;
            byte r113 = this.c[r111];
        L60:
            int r29 = ((r113 & UByte.MAX_VALUE) << 2) | r28;
            this.d = r17 - r112;
            r2[r8] = r1[(r29 >> 12) & 63];
            r2[r8 + 1] = r1[(r29 >> 6) & 63];
            int r30 = r8 + 3;
            r2[r8 + 2] = r1[r29 & 63];
            if (this.f == false) goto L64;
            r2[r30] = 61;
            r30 = r8 + 4;
        L64:
            if (this.g == true) goto L66;
            r8 = r30;
            goto L80
        L66:
            if (this.h == false) goto L68;
            r2[r30] = JceStruct.SIMPLE_LIST;
            r30 = r30 + 1;
        L68:
            r26 = r30 + 1;
            r2[r30] = 10;
            goto L79
        L59:
            r112 = r111;
            r113 = r19[r6];
            r6 = r6 + 1;
            goto L60
        L55:
            r27 = r19[r6];
            r6 = r6 + 1;
            r111 = 0;
            goto L56
        L71:
            if (this.g == false) goto L80;
            if (r8 <= 0) goto L80;
            if (r3 == 19) goto L80;
            if (this.h == false) goto L78;
            r2[r8] = JceStruct.SIMPLE_LIST;
            r8 = r8 + 1;
        L78:
            r26 = r8 + 1;
            r2[r8] = 10;
            goto L79
        L93:
            if (r6 != (r4 - 1)) goto L96;
            byte[] r31 = this.c;
            int r32 = this.d;
            this.d = r32 + 1;
            r31[r32] = r19[r6];
            goto L98
        L96:
            if (r6 != (r4 - 2)) goto L98;
            byte[] r33 = this.c;
            int r34 = this.d;
            r33[r34] = r19[r6];
            this.d = r34 + 2;
            r33[r34 + 1] = r19[r6 + 1];
            goto L98
        L19:
            if (this.h == false) goto L21;
            r2[4] = JceStruct.SIMPLE_LIST;
            int r35 = 5;
        L22:
            r8 = r35 + 1;
            r2[r35] = 10;
            goto L23
        L21:
            r35 = 4;
            goto L22
        L25:
            r8 = 0;
        L13:
            r6 = r20;
            r13 = -1;
            goto L15
        L9:
            r6 = r20 + 2;
            if (r6 > r4) goto L13;
            r11 = ((this.c[0] & UByte.MAX_VALUE) << 16) | ((r19[r20] & UByte.MAX_VALUE) << 8);
            r12 = r19[r20 + 1];
            goto L12
        }
    }

    static {
    }

    public static byte[] a(String r0, int r1) {
        return a(r0.getBytes(), r1);
    }

    public static byte[] b(byte[] r2, int r3) {
        return b(r2, 0, r2.length, r3);
    }

    public static String c(byte[] r1, int r2) {
        return new String(b(r1, r2), "US-ASCII");
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public static byte[] a(byte[] r2, int r3) {
        return a(r2, 0, r2.length, r3);
    }

    public static byte[] b(byte[] r5, int r6, int r7, int r8) {
        c r0 = new c(r8, null);
        int r9 = (r7 / 3) * 4;
        int r2 = 2;
        if (r0.f == true) goto L5;
        int r1 = r7 % 3;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L14;
        r9 = r9 + 3;
    L14:
        if (r0.g == false) goto L21;
        if (r7 <= 0) goto L21;
        int r3 = ((r7 - 1) / 57) + 1;
        if (r0.h == true) goto L20;
        r2 = 1;
    L20:
        r9 = r9 + (r3 * r2);
    L21:
        r0.f649a = new byte[r9];
        r0.a(r5, r6, r7, true);
        if (f648a == true) goto L29;
        if (r0.b == r9) goto L29;
        throw new AssertionError();
    L29:
        return r0.f649a;
    L12:
        r9 = r9 + 2;
        goto L14
    L5:
        if ((r7 % 3) <= 0) goto L14;
        r9 = r9 + 4;
        goto L14
    }

    public static byte[] a(byte[] r2, int r3, int r4, int r5) {
        b r0 = new b(r5, new byte[(r4 * 3) / 4]);
        if (r0.a(r2, r3, r4, true) == false) goto L10;
        int r6 = r0.b;
        byte[] r7 = r0.f649a;
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
