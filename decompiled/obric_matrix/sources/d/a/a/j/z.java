package d.a.a.j;

import androidx.room.RoomDatabase;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class z extends Writer {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ThreadLocal<char[]> f12521j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int[] f12522k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final char[] f12523l = null;
    static final char[] m = null;
    static final char[] n = null;
    static final char[] o = null;
    static final byte[] p = null;
    static final byte[] q = null;
    static final char[] r = null;
    public static final char[] s = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected char[] f12524f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f12525g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f12526h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final Writer f12527i;

    static {
        f12521j = new ThreadLocal();
        f12522k = new int[]{9, 99, RoomDatabase.MAX_BIND_PARAMETER_CNT, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
        f12523l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        m = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        n = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        o = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
        byte[] r2 = new byte[161];
        p = r2;
        byte[] r1 = new byte[161];
        q = r1;
        r = new char[93];
        r2[0] = 4;
        r2[1] = 4;
        r2[2] = 4;
        r2[3] = 4;
        r2[4] = 4;
        r2[5] = 4;
        r2[6] = 4;
        r2[7] = 4;
        r2[8] = 1;
        r2[9] = 1;
        r2[10] = 1;
        r2[11] = 4;
        r2[12] = 1;
        r2[13] = 1;
        r2[34] = 1;
        r2[92] = 1;
        r1[0] = 4;
        r1[1] = 4;
        r1[2] = 4;
        r1[3] = 4;
        r1[4] = 4;
        r1[5] = 4;
        r1[6] = 4;
        r1[7] = 4;
        r1[8] = 1;
        r1[9] = 1;
        r1[10] = 1;
        r1[11] = 4;
        r1[12] = 1;
        r1[13] = 1;
        r1[92] = 1;
        r1[39] = 1;
        int r3 = 14;
    L4:
        if (r3 > 31) goto L6;
        p[r3] = 4;
        q[r3] = 4;
        r3 = r3 + 1;
        goto L4
    L6:
        int r4 = 127;
    L8:
        if (r4 >= 160) goto L10;
        p[r4] = 4;
        q[r4] = 4;
        r4 = r4 + 1;
        goto L8
    L10:
        char[] r5 = r;
        r5[0] = '0';
        r5[1] = '1';
        r5[2] = '2';
        r5[3] = '3';
        r5[4] = '4';
        r5[5] = '5';
        r5[6] = '6';
        r5[7] = '7';
        r5[8] = 'b';
        r5[9] = 't';
        r5[10] = 'n';
        r5[11] = 'v';
        r5[12] = 'f';
        r5[13] = 'r';
        r5[34] = '\"';
        r5[39] = '\'';
        r5[47] = '/';
        r5[92] = '\\';
        s = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public z(Writer r3, int r4, a0[] r5) {
        this.f12527i = r3;
        ThreadLocal<char[]> r6 = f12521j;
        char[] r0 = r6.get();
        this.f12524f = r0;
        if (r0 == null) goto L6;
        r6.set(null);
    L6:
        if (this.f12524f != null) goto L8;
        this.f12524f = new char[1024];
    L8:
        int r7 = r5.length;
        int r1 = 0;
    L9:
        if (r1 >= r7) goto L11;
        r4 = r4 | r5[r1].f12471f;
        r1 = r1 + 1;
        goto L9
    L11:
        this.f12526h = r4;
    }

    private void M(String r15) {
        int r0 = r15.length();
        boolean r2 = true;
        int r1 = (this.f12525g + r0) + 1;
        int r6 = 0;
        if (r1 > this.f12524f.length) goto L5;
    L32:
        if (r0 != 0) goto L38;
        int r16 = this.f12525g;
        if ((r16 + 3) <= this.f12524f.length) goto L36;
        s(r16 + 3);
    L36:
        char[] r17 = this.f12524f;
        int r3 = this.f12525g;
        int r4 = r3 + 1;
        this.f12525g = r4;
        r17[r3] = '\"';
        int r5 = r4 + 1;
        this.f12525g = r5;
        r17[r4] = '\"';
        this.f12525g = r5 + 1;
        r17[r5] = ':';
        return;
    L38:
        int r7 = this.f12525g;
        int r8 = r7 + r0;
        r15.getChars(0, r0, this.f12524f, r7);
        this.f12525g = r1;
        int r18 = r7;
        boolean r9 = false;
    L39:
        if (r18 >= r8) goto L54;
        char[] r10 = this.f12524f;
        char r11 = r10[r18];
        byte[] r12 = p;
        if (r11 >= r12.length) goto L53;
        if (r12[r11] == 0) goto L53;
        if (r9 == true) goto L49;
        r1 = r1 + 3;
        if (r1 <= r10.length) goto L48;
        s(r1);
    L48:
        this.f12525g = r1;
        char[] r13 = this.f12524f;
        int r14 = r18 + 1;
        System.arraycopy(r13, r14, r13, r18 + 3, (r8 - r18) - 1);
        char[] r19 = this.f12524f;
        System.arraycopy(r19, 0, r19, 1, r18);
        char[] r110 = this.f12524f;
        r110[r7] = '\"';
        r110[r14] = '\\';
        int r20 = r14 + 1;
        r110[r20] = r[r11];
        r8 = r8 + 2;
        r110[this.f12525g - 2] = '\"';
        r18 = r20;
        r9 = true;
        goto L53
    L49:
        r1 = r1 + 1;
        if (r1 <= r10.length) goto L52;
        s(r1);
    L52:
        this.f12525g = r1;
        char[] r21 = this.f12524f;
        int r111 = r18 + 1;
        System.arraycopy(r21, r111, r21, r18 + 2, r8 - r18);
        char[] r22 = this.f12524f;
        r22[r18] = '\\';
        r22[r111] = r[r11];
        r8 = r8 + 1;
        r18 = r111;
    L53:
        r18 = r18 + 1;
        goto L39
    L54:
        this.f12524f[this.f12525g - 1] = ':';
        return;
    L5:
        if (this.f12527i == null) goto L31;
        if (r0 != 0) goto L9;
        write(34);
        write(34);
        write(58);
        return;
    L9:
        int r23 = 0;
    L10:
        if (r23 >= r0) goto L17;
        char r24 = r15.charAt(r23);
        byte[] r25 = p;
        if (r24 >= r25.length) goto L16;
        if (r25[r24] == 0) goto L16;
    L18:
        if (r2 == false) goto L20;
        write(34);
    L20:
        if (r6 >= r0) goto L27;
        char r26 = r15.charAt(r6);
        byte[] r27 = p;
        if (r26 >= r27.length) goto L26;
        if (r27[r26] == 0) goto L26;
        write(92);
        r26 = r[r26];
    L26:
        write(r26);
        r6 = r6 + 1;
        goto L20
    L27:
        if (r2 == false) goto L29;
        write(34);
    L29:
        write(58);
        return;
    L16:
        r23 = r23 + 1;
        goto L10
    L17:
        r2 = false;
        goto L18
    L31:
        s(r1);
        goto L32
    }

    private void N(String r15) {
        int r0 = r15.length();
        boolean r2 = true;
        int r1 = (this.f12525g + r0) + 1;
        int r6 = 0;
        if (r1 > this.f12524f.length) goto L5;
    L32:
        if (r0 != 0) goto L38;
        int r16 = this.f12525g;
        if ((r16 + 3) <= this.f12524f.length) goto L36;
        s(r16 + 3);
    L36:
        char[] r17 = this.f12524f;
        int r3 = this.f12525g;
        int r4 = r3 + 1;
        this.f12525g = r4;
        r17[r3] = '\'';
        int r5 = r4 + 1;
        this.f12525g = r5;
        r17[r4] = '\'';
        this.f12525g = r5 + 1;
        r17[r5] = ':';
        return;
    L38:
        int r7 = this.f12525g;
        int r8 = r7 + r0;
        r15.getChars(0, r0, this.f12524f, r7);
        this.f12525g = r1;
        int r18 = r7;
        boolean r9 = false;
    L39:
        if (r18 >= r8) goto L54;
        char[] r10 = this.f12524f;
        char r11 = r10[r18];
        byte[] r12 = q;
        if (r11 >= r12.length) goto L53;
        if (r12[r11] == 0) goto L53;
        if (r9 == true) goto L49;
        r1 = r1 + 3;
        if (r1 <= r10.length) goto L48;
        s(r1);
    L48:
        this.f12525g = r1;
        char[] r13 = this.f12524f;
        int r14 = r18 + 1;
        System.arraycopy(r13, r14, r13, r18 + 3, (r8 - r18) - 1);
        char[] r19 = this.f12524f;
        System.arraycopy(r19, 0, r19, 1, r18);
        char[] r110 = this.f12524f;
        r110[r7] = '\'';
        r110[r14] = '\\';
        int r20 = r14 + 1;
        r110[r20] = r[r11];
        r8 = r8 + 2;
        r110[this.f12525g - 2] = '\'';
        r18 = r20;
        r9 = true;
        goto L53
    L49:
        r1 = r1 + 1;
        if (r1 <= r10.length) goto L52;
        s(r1);
    L52:
        this.f12525g = r1;
        char[] r21 = this.f12524f;
        int r111 = r18 + 1;
        System.arraycopy(r21, r111, r21, r18 + 2, r8 - r18);
        char[] r22 = this.f12524f;
        r22[r18] = '\\';
        r22[r111] = r[r11];
        r8 = r8 + 1;
        r18 = r111;
    L53:
        r18 = r18 + 1;
        goto L39
    L54:
        this.f12524f[r1 - 1] = ':';
        return;
    L5:
        if (this.f12527i == null) goto L31;
        if (r0 != 0) goto L9;
        write(39);
        write(39);
        write(58);
        return;
    L9:
        int r23 = 0;
    L10:
        if (r23 >= r0) goto L17;
        char r24 = r15.charAt(r23);
        byte[] r25 = q;
        if (r24 >= r25.length) goto L16;
        if (r25[r24] == 0) goto L16;
    L18:
        if (r2 == false) goto L20;
        write(39);
    L20:
        if (r6 >= r0) goto L27;
        char r26 = r15.charAt(r6);
        byte[] r27 = q;
        if (r26 >= r27.length) goto L26;
        if (r27[r26] == 0) goto L26;
        write(92);
        r26 = r[r26];
    L26:
        write(r26);
        r6 = r6 + 1;
        goto L20
    L27:
        if (r2 == false) goto L29;
        write(39);
    L29:
        write(58);
        return;
    L16:
        r23 = r23 + 1;
        goto L10
    L17:
        r2 = false;
        goto L18
    L31:
        s(r1);
        goto L32
    }

    protected static void x(long r7, int r9, char[] r10) {
        if (r7 >= 0) goto L5;
        char r0 = '-';
        r7 = -r7;
    L7:
        if (r7 <= 2147483647L) goto L9;
        long r1 = r7 / 100;
        int r8 = (int) (r7 - (((r1 << 6) + (r1 << 5)) + (r1 << 2)));
        int r11 = r9 - 1;
        r10[r11] = n[r8];
        r9 = r11 - 1;
        r10[r9] = m[r8];
        r7 = r1;
        goto L7
    L9:
        int r12 = (int) r7;
    L11:
        if (r12 < 65536) goto L13;
        int r13 = r12 / 100;
        int r14 = r12 - (((r13 << 6) + (r13 << 5)) + (r13 << 2));
        int r15 = r9 - 1;
        r10[r15] = n[r14];
        r9 = r15 - 1;
        r10[r9] = m[r14];
        r12 = r13;
    L13:
        int r16 = (52429 * r12) >>> 19;
        r9 = r9 - 1;
        r10[r9] = f12523l[r12 - ((r16 << 3) + (r16 << 1))];
        if (r16 == 0) goto L15;
        r12 = r16;
        goto L13
    L15:
        if (r0 == 0) goto L23;
        r10[r9 - 1] = r0;
        return;
    L23:
        return;
    L5:
        r0 = 0;
        goto L7
    }

    public boolean A(a0 r1) {
        if ((this.f12526h & r1.f12471f) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void C(boolean r1) {
        if (r1 == false) goto L4;
        String r2 = "true";
    L5:
        write(r2);
        return;
    L4:
        r2 = "false";
        goto L5
    }

    public void E(byte[] r19) {
        int r2 = r19.length;
        int r4 = 0;
        if ((this.f12526h & a0.f12466h.f12471f) == 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        char r6 = '\'';
    L9:
        if (r2 != 0) goto L15;
        if (r3 == false) goto L12;
        String r1 = "''";
    L13:
        write(r1);
        return;
    L12:
        r1 = "\"\"";
        goto L13
    L15:
        char[] r5 = d.a.a.i.e.y;
        int r7 = (r2 / 3) * 3;
        int r8 = r2 - 1;
        int r11 = this.f12525g;
        int r9 = ((((r8 / 3) + 1) << 2) + r11) + 2;
        if (r9 > this.f12524f.length) goto L18;
    L35:
        this.f12525g = r9;
        int r14 = r11 + 1;
        this.f12524f[r11] = r6;
        int r12 = 0;
    L36:
        if (r12 >= r7) goto L38;
        int r13 = r12 + 1;
        int r15 = r13 + 1;
        int r16 = ((r19[r12] & 255) << 16) | ((r19[r13] & 255) << 8);
        int r17 = r15 + 1;
        int r18 = r16 | (r19[r15] & 255);
        char[] r110 = this.f12524f;
        int r111 = r14 + 1;
        r110[r14] = r5[(r18 >>> 18) & 63];
        int r112 = r111 + 1;
        r110[r111] = r5[(r18 >>> 12) & 63];
        int r113 = r112 + 1;
        r110[r112] = r5[(r18 >>> 6) & 63];
        r14 = r113 + 1;
        r110[r113] = r5[r18 & 63];
        r12 = r17;
        goto L36
    L38:
        int r10 = r2 - r7;
        if (r10 <= 0) goto L48;
        int r20 = (r19[r7] & 255) << 10;
        if (r10 != 2) goto L43;
        r4 = (r19[r8] & 255) << 2;
    L43:
        int r21 = r20 | r4;
        char[] r22 = this.f12524f;
        r22[r9 - 5] = r5[r21 >> 12];
        r22[r9 - 4] = r5[(r21 >>> 6) & 63];
        int r23 = r9 - 3;
        if (r10 != 2) goto L46;
        char r24 = r5[r21 & 63];
    L47:
        r22[r23] = r24;
        r22[r9 - 2] = '=';
        goto L48
    L46:
        r24 = '=';
    L48:
        this.f12524f[r9 - 1] = r6;
        return;
    L18:
        if (this.f12527i == null) goto L34;
        write(r6);
        int r25 = 0;
    L20:
        if (r25 >= r7) goto L22;
        int r26 = r25 + 1;
        int r114 = r26 + 1;
        int r27 = ((r19[r25] & 255) << 16) | ((r19[r26] & 255) << 8);
        int r28 = r27 | (r19[r114] & 255);
        write(r5[(r28 >>> 18) & 63]);
        write(r5[(r28 >>> 12) & 63]);
        write(r5[(r28 >>> 6) & 63]);
        write(r5[r28 & 63]);
        r25 = r114 + 1;
        goto L20
    L22:
        int r29 = r2 - r7;
        if (r29 <= 0) goto L32;
        int r30 = (r19[r7] & 255) << 10;
        if (r29 != 2) goto L27;
        r4 = (r19[r8] & 255) << 2;
    L27:
        int r31 = r30 | r4;
        write(r5[r31 >> 12]);
        write(r5[(r31 >>> 6) & 63]);
        if (r29 != 2) goto L30;
        char r32 = r5[r31 & 63];
    L31:
        write(r32);
        write(61);
        goto L32
    L30:
        r32 = '=';
    L32:
        write(r6);
        return;
    L34:
        s(r9);
        goto L35
    L8:
        r6 = '\"';
        goto L9
    L5:
        r3 = false;
        goto L6
    }

    public void F(String r4, boolean r5) {
        int r0 = this.f12526h;
        if ((a0.f12466h.f12471f & r0) == 0) goto L9;
        if ((a0.f12465g.f12471f & r0) == 0) goto L7;
        X(r4);
        write(58);
        return;
    L7:
        N(r4);
        return;
    L9:
        if ((r0 & a0.f12465g.f12471f) == 0) goto L11;
        V(r4, ':', r5);
        return;
    L11:
        M(r4);
    }

    public void L(int r6) {
        if (r6 != Integer.MIN_VALUE) goto L6;
        write("-2147483648");
        return;
    L6:
        if (r6 >= 0) goto L8;
        int r0 = -r6;
    L9:
        int r2 = 0;
    L10:
        int r3 = f12522k[r2];
        r2 = r2 + 1;
        if (r0 > r3) goto L10;
        if (r6 >= 0) goto L14;
        r2 = r2 + 1;
    L14:
        int r1 = this.f12525g + r2;
        if (r1 > this.f12524f.length) goto L17;
    L21:
        x(r6, r1, this.f12524f);
        this.f12525g = r1;
        return;
    L17:
        if (this.f12527i != null) goto L19;
        s(r1);
        goto L21
    L19:
        char[] r4 = new char[r2];
        x(r6, r2, r4);
        write(r4, 0, r2);
        return;
    L8:
        r0 = r6;
        goto L9
    }

    public void O(long r12) {
        if (r12 != Long.MIN_VALUE) goto L7;
        write("-9223372036854775808");
        return;
    L7:
        if (r12 >= 0) goto L9;
        long r1 = -r12;
    L10:
        int r5 = 1;
        long r6 = 10;
    L11:
        int r8 = 19;
        if (r5 >= 19) goto L17;
        if (r1 < r6) goto L18;
        r6 = r6 * 10;
        r5 = r5 + 1;
    L18:
        if (r5 == 0) goto L21;
        r8 = r5;
    L21:
        if (r12 >= 0) goto L23;
        r8 = r8 + 1;
    L23:
        int r0 = this.f12525g + r8;
        if (r0 > this.f12524f.length) goto L26;
    L30:
        x(r12, r0, this.f12524f);
        this.f12525g = r0;
        return;
    L26:
        if (this.f12527i != null) goto L28;
        s(r0);
        goto L30
    L28:
        char[] r2 = new char[r8];
        x(r12, r8, r2);
        write(r2, 0, r8);
        return;
    L17:
        r5 = 0;
        goto L18
    L9:
        r1 = r12;
        goto L10
    }

    public void Q() {
        write("null");
    }

    public void S(String r3) {
        if ((this.f12526h & a0.f12466h.f12471f) == 0) goto L5;
        X(r3);
        return;
    L5:
        V(r3, 0, true);
    }

    protected void V(String r19, char r20, boolean r21) {
        if (r19 != null) goto L8;
        Q();
        if (r20 == 0) goto L213;
        write(r20);
        return;
    L213:
        return;
    L8:
        int r3 = r19.length();
        int r4 = (this.f12525g + r3) + 2;
        if (r20 == 0) goto L11;
        r4 = r4 + 1;
    L11:
        char r7 = '\r';
        char r10 = ' ';
        char r12 = '/';
        if (r4 > this.f12524f.length) goto L14;
    L50:
        int r5 = this.f12525g;
        int r11 = r5 + 1;
        int r14 = r11 + r3;
        char[] r6 = this.f12524f;
        r6[r5] = '\"';
        r19.getChars(0, r3, r6, r11);
        this.f12525g = r4;
        int r8 = -1;
        if ((this.f12526h & a0.w.f12471f) == 0) goto L107;
        int r1 = r11;
    L53:
        if (r1 >= r14) goto L76;
        char r9 = this.f12524f[r1];
        if (r9 == '\"') goto L72;
        if (r9 == '/') goto L72;
        if (r9 == '\\') goto L72;
        if (r9 == '\b') goto L72;
        if (r9 == '\f') goto L72;
        if (r9 == '\n') goto L72;
        if (r9 == '\r') goto L72;
        if (r9 == '\t') goto L72;
        if (r9 >= ' ') goto L70;
    L68:
        r4 = r4 + 5;
    L73:
        r8 = r1;
    L74:
        r1 = r1 + 1;
        goto L53
    L70:
        if (r9 < 127) goto L74;
    L72:
        r4 = r4 + 1;
        goto L73
    L76:
        if (r4 <= this.f12524f.length) goto L78;
        s(r4);
    L78:
        this.f12525g = r4;
    L79:
        if (r8 < r11) goto L103;
        char[] r2 = this.f12524f;
        char r13 = r2[r8];
        if (r13 == '\b') goto L100;
        if (r13 == '\f') goto L100;
        if (r13 == '\n') goto L100;
        if (r13 == r7) goto L100;
        if (r13 == '\t') goto L100;
        if (r13 == '\"') goto L99;
        if (r13 == '/') goto L99;
        if (r13 == '\\') goto L99;
        if (r13 >= ' ') goto L97;
        int r15 = r8 + 1;
        System.arraycopy(r2, r15, r2, r8 + 6, (r14 - r8) - 1);
        char[] r16 = this.f12524f;
        r16[r8] = '\\';
        r16[r15] = 'u';
        r16[r8 + 2] = '0';
        r16[r8 + 3] = '0';
        char[] r17 = o;
        int r18 = r13 * 2;
        r16[r8 + 4] = r17[r18];
        r16[r8 + 5] = r17[r18 + 1];
    L95:
        r14 = r14 + 5;
    L102:
        r8 = r8 - 1;
        r7 = '\r';
        goto L79
    L97:
        if (r13 < 127) goto L102;
        int r22 = r8 + 1;
        System.arraycopy(r2, r22, r2, r8 + 6, (r14 - r8) - 1);
        char[] r23 = this.f12524f;
        r23[r8] = '\\';
        r23[r22] = 'u';
        char[] r24 = s;
        r23[r8 + 2] = r24[(r13 >>> '\f') & 15];
        r23[r8 + 3] = r24[(r13 >>> '\b') & 15];
        r23[r8 + 4] = r24[(r13 >>> 4) & 15];
        r23[r8 + 5] = r24[r13 & 15];
    L99:
        int r25 = r8 + 1;
        System.arraycopy(r2, r25, r2, r8 + 2, (r14 - r8) - 1);
        char[] r26 = this.f12524f;
        r26[r8] = '\\';
        r26[r25] = r13;
    L101:
        r14 = r14 + 1;
    L100:
        int r27 = r8 + 1;
        System.arraycopy(r2, r27, r2, r8 + 2, (r14 - r8) - 1);
        char[] r28 = this.f12524f;
        r28[r8] = '\\';
        r28[r27] = r[r13];
        goto L101
    L103:
        if (r20 == 0) goto L105;
        char[] r29 = this.f12524f;
        int r0 = this.f12525g;
        r29[r0 - 2] = '\"';
        r29[r0 - 1] = r20;
        return;
    L105:
        this.f12524f[this.f12525g - 1] = '\"';
        return;
    L107:
        if (r21 == false) goto L192;
        int r30 = 0;
        char r110 = 0;
        int r31 = -1;
        int r111 = -1;
        int r32 = r11;
    L110:
        if (r32 >= r14) goto L153;
        char r33 = this.f12524f[r32];
        if (r33 != 8232) goto L119;
        r30 = r30 + 1;
        r4 = r4 + 4;
        if (r31 != (-1)) goto L116;
    L115:
        r31 = r32;
        r111 = r31;
    L117:
        r110 = r33;
    L152:
        r32 = r32 + 1;
        r12 = '/';
    L116:
        r111 = r32;
        goto L117
    L119:
        if (r33 < ']') goto L128;
        if (r33 < 127) goto L152;
        if (r33 >= 160) goto L152;
        if (r31 != (-1)) goto L126;
        r31 = r32;
    L126:
        r30 = r30 + 1;
        r4 = r4 + 4;
        goto L116
    L128:
        if (r33 != ' ') goto L130;
    L129:
        boolean r34 = false;
    L144:
        if (r34 == false) goto L152;
        r30 = r30 + 1;
        byte[] r35 = p;
        if (r33 < r35.length) goto L148;
    L150:
        if (r31 != (-1)) goto L116;
    L148:
        if (r35[r33] != 4) goto L150;
        r4 = r4 + 4;
        goto L150
    L130:
        if (r33 != r12) goto L135;
        if ((this.f12526h & a0.v.f12471f) == 0) goto L135;
    L133:
        r34 = true;
    L135:
        if (r33 <= '#') goto L139;
        if (r33 != '\\') goto L129;
    L139:
        if (r33 <= 31) goto L133;
        if (r33 == '\\') goto L133;
        if (r33 != '\"') goto L129;
    L153:
        if (r30 <= 0) goto L192;
        int r36 = r4 + r30;
        if (r36 <= this.f12524f.length) goto L157;
        s(r36);
    L157:
        this.f12525g = r36;
        if (r30 != 1) goto L168;
        if (r110 != 8232) goto L161;
        int r37 = r111 + 1;
        char[] r38 = this.f12524f;
        System.arraycopy(r38, r37, r38, r111 + 6, (r14 - r111) - 1);
        char[] r39 = this.f12524f;
        r39[r111] = '\\';
        r39[r37] = 'u';
        int r40 = r37 + 1;
        r39[r40] = '2';
        int r41 = r40 + 1;
        r39[r41] = '0';
        int r42 = r41 + 1;
        r39[r42] = '2';
        r39[r42 + 1] = '8';
        goto L192
    L161:
        byte[] r43 = p;
        if (r110 < r43.length) goto L164;
    L166:
        int r44 = r111 + 1;
        char[] r45 = this.f12524f;
        System.arraycopy(r45, r44, r45, r111 + 2, (r14 - r111) - 1);
        char[] r46 = this.f12524f;
        r46[r111] = '\\';
        r46[r44] = r[r110];
        goto L192
    L164:
        if (r43[r110] != 4) goto L166;
        int r47 = r111 + 1;
        char[] r48 = this.f12524f;
        System.arraycopy(r48, r47, r48, r111 + 6, (r14 - r111) - 1);
        char[] r49 = this.f12524f;
        r49[r111] = '\\';
        int r50 = r47 + 1;
        r49[r47] = 'u';
        int r51 = r50 + 1;
        char[] r52 = s;
        r49[r50] = r52[(r110 >>> '\f') & 15];
        int r53 = r51 + 1;
        r49[r51] = r52[(r110 >>> '\b') & 15];
        r49[r53] = r52[(r110 >>> 4) & 15];
        r49[r53 + 1] = r52[r110 & 15];
        goto L192
    L168:
        if (r30 <= 1) goto L192;
        int r54 = r31 - r11;
    L171:
        if (r54 >= r19.length()) goto L192;
        char r55 = r19.charAt(r54);
        byte[] r56 = p;
        if (r55 >= r56.length) goto L179;
        if (r56[r55] == 0) goto L179;
    L182:
        char[] r57 = this.f12524f;
        int r112 = r31 + 1;
        r57[r31] = '\\';
        if (r56[r55] != 4) goto L185;
        int r58 = r112 + 1;
        r57[r112] = 'u';
        int r59 = r58 + 1;
        char[] r113 = s;
        r57[r58] = r113[(r55 >>> '\f') & 15];
        int r60 = r59 + 1;
        r57[r59] = r113[(r55 >>> '\b') & 15];
        int r61 = r60 + 1;
        r57[r60] = r113[(r55 >>> 4) & 15];
        int r62 = r61 + 1;
        r57[r61] = r113[r55 & 15];
    L186:
        r31 = r62;
    L191:
        r54 = r54 + 1;
        goto L171
    L185:
        r62 = r112 + 1;
        r57[r112] = r[r55];
    L179:
        if (r55 != '/') goto L188;
        if ((this.f12526h & a0.v.f12471f) != 0) goto L182;
    L188:
        if (r55 != 8232) goto L190;
        char[] r63 = this.f12524f;
        int r64 = r31 + 1;
        r63[r31] = '\\';
        int r65 = r64 + 1;
        r63[r64] = 'u';
        int r66 = r65 + 1;
        char[] r114 = s;
        r63[r65] = r114[(r55 >>> '\f') & 15];
        int r67 = r66 + 1;
        r63[r66] = r114[(r55 >>> '\b') & 15];
        int r68 = r67 + 1;
        r63[r67] = r114[(r55 >>> 4) & 15];
        r31 = r68 + 1;
        r63[r68] = r114[r55 & 15];
        goto L191
    L190:
        this.f12524f[r31] = r55;
        r31 = r31 + 1;
    L192:
        if (r20 == 0) goto L194;
        char[] r69 = this.f12524f;
        int r70 = this.f12525g;
        r69[r70 - 2] = '\"';
        r69[r70 - 1] = r20;
        return;
    L194:
        this.f12524f[this.f12525g - 1] = '\"';
        return;
    L14:
        if (this.f12527i == null) goto L49;
        write(34);
        int r71 = 0;
    L17:
        if (r71 >= r19.length()) goto L45;
        char r72 = r19.charAt(r71);
        int r73 = this.f12526h;
        if ((a0.w.f12471f & r73) == 0) goto L36;
        if (r72 == '\b') goto L34;
        if (r72 == '\f') goto L34;
        if (r72 == '\n') goto L34;
        if (r72 == '\r') goto L34;
        if (r72 == '\t') goto L34;
        if (r72 == '\"') goto L34;
        if (r72 == '/') goto L34;
        if (r72 == '\\') goto L34;
        if (r72 >= r10) goto L32;
        write(92);
        write(117);
        write(48);
        write(48);
        char[] r74 = o;
        int r75 = r72 * 2;
        write(r74[r75]);
        r72 = r74[r75 + 1];
    L35:
        write(r72);
        r71 = r71 + 1;
        r10 = ' ';
        goto L17
    L32:
        if (r72 < 127) goto L35;
        write(92);
        write(117);
        char[] r76 = s;
        write(r76[(r72 >>> '\f') & 15]);
        write(r76[(r72 >>> '\b') & 15]);
        write(r76[(r72 >>> 4) & 15]);
        r72 = r76[r72 & 15];
    L34:
        write(92);
        r72 = r[r72];
        goto L35
    L36:
        byte[] r115 = p;
        if (r72 < r115.length) goto L39;
    L40:
        if (r72 != '/') goto L35;
        if ((r73 & a0.v.f12471f) == 0) goto L35;
    L43:
        write(92);
        r72 = r[r72];
        goto L35
    L39:
        if (r115[r72] != 0) goto L43;
    L45:
        write(34);
        if (r20 == 0) goto L214;
        write(r20);
        return;
    L214:
        return;
    L49:
        s(r4);
        goto L50
    }

    protected void X(String r14) {
        int r0 = 0;
        if (r14 != null) goto L9;
        int r15 = this.f12525g + 4;
        if (r15 <= this.f12524f.length) goto L7;
        s(r15);
    L7:
        "null".getChars(0, 4, this.f12524f, this.f12525g);
        this.f12525g = r15;
        return;
    L9:
        int r1 = r14.length();
        int r2 = (this.f12525g + r1) + 2;
        if (r2 > this.f12524f.length) goto L12;
    L28:
        int r3 = this.f12525g;
        int r8 = r3 + 1;
        int r9 = r8 + r1;
        char[] r10 = this.f12524f;
        r10[r3] = '\'';
        r14.getChars(0, r1, r10, r8);
        this.f12525g = r2;
        int r16 = -1;
        char r4 = 0;
        int r5 = r8;
    L29:
        if (r5 >= r9) goto L39;
        char r11 = this.f12524f[r5];
        if (r11 <= '\r') goto L37;
        if (r11 == '\\') goto L37;
        if (r11 == '\'') goto L37;
        if (r11 != '/') goto L38;
        if ((this.f12526h & a0.v.f12471f) != 0) goto L37;
    L38:
        r5 = r5 + 1;
    L37:
        r0 = r0 + 1;
        r16 = r5;
        r4 = r11;
        goto L38
    L39:
        int r6 = r2 + r0;
        if (r6 <= this.f12524f.length) goto L42;
        s(r6);
    L42:
        this.f12525g = r6;
        if (r0 != 1) goto L45;
        char[] r7 = this.f12524f;
        int r12 = r16 + 1;
        System.arraycopy(r7, r12, r7, r16 + 2, (r9 - r16) - 1);
        char[] r13 = this.f12524f;
        r13[r16] = '\\';
        r13[r12] = r[r4];
    L57:
        this.f12524f[this.f12525g - 1] = '\'';
        return;
    L45:
        if (r0 <= 1) goto L57;
        char[] r17 = this.f12524f;
        int r18 = r16 + 1;
        System.arraycopy(r17, r18, r17, r16 + 2, (r9 - r16) - 1);
        char[] r19 = this.f12524f;
        r19[r16] = '\\';
        r19[r18] = r[r4];
        int r20 = r9 + 1;
        int r21 = r18 - 2;
    L47:
        if (r21 < r8) goto L57;
        char[] r110 = this.f12524f;
        char r22 = r110[r21];
        if (r22 <= '\r') goto L55;
        if (r22 == '\\') goto L55;
        if (r22 == '\'') goto L55;
        if (r22 != '/') goto L56;
        if ((this.f12526h & a0.v.f12471f) != 0) goto L55;
    L56:
        r21 = r21 - 1;
    L55:
        int r23 = r21 + 1;
        System.arraycopy(r110, r23, r110, r21 + 2, (r20 - r21) - 1);
        char[] r111 = this.f12524f;
        r111[r21] = '\\';
        r111[r23] = r[r22];
        r20 = r20 + 1;
        goto L56
    L12:
        if (this.f12527i == null) goto L27;
        write(39);
    L15:
        if (r0 >= r14.length()) goto L25;
        char r24 = r14.charAt(r0);
        if (r24 <= '\r') goto L23;
        if (r24 == '\\') goto L23;
        if (r24 == '\'') goto L23;
        if (r24 != '/') goto L24;
        if ((this.f12526h & a0.v.f12471f) != 0) goto L23;
    L24:
        write(r24);
        r0 = r0 + 1;
    L23:
        write(92);
        r24 = r[r24];
        goto L24
    L25:
        write(39);
        return;
    L27:
        s(r2);
        goto L28
    }

    public z a(char r1) {
        write(r1);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(char r1) {
        a(r1);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(CharSequence r1) {
        b(r1);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Writer append(CharSequence r1, int r2, int r3) {
        g(r1, r2, r3);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r1) {
        a(r1);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r1) {
        b(r1);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(CharSequence r1, int r2, int r3) {
        g(r1, r2, r3);
        return this;
    }

    public z b(CharSequence r3) {
        if (r3 != null) goto L4;
        String r4 = "null";
    L5:
        write(r4, 0, r4.length());
        return this;
    L4:
        r4 = r3.toString();
        goto L5
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f12527i != null) goto L5;
    L7:
        char[] r0 = this.f12524f;
        if (r0.length > 8192) goto L10;
        f12521j.set(r0);
    L10:
        this.f12524f = null;
        return;
    L5:
        if (this.f12525g <= 0) goto L7;
        flush();
        goto L7
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer r0 = this.f12527i;
        if (r0 != null) goto L10;
        return;
    L10:
        r0.write(this.f12524f, 0, this.f12525g);     // Catch: IOException -> L7
        this.f12527i.flush();     // Catch: IOException -> L7
        this.f12525g = 0;     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        throw new d.a.a.d(e.getMessage(), e);
    }

    public z g(CharSequence r1, int r2, int r3) {
        if (r1 != null) goto L4;
        r1 = "null";
    L4:
        String r4 = r1.subSequence(r2, r3).toString();
        write(r4, 0, r4.length());
        return this;
    }

    public void l(a0 r1, boolean r2) {
        if (r2 == false) goto L4;
        int r3 = this.f12526h;
        int r4 = r1.f12471f | r3;
    L5:
        this.f12526h = r4;
        return;
    L4:
        int r5 = this.f12526h;
        r4 = (~r1.f12471f) & r5;
        goto L5
    }

    protected void s(int r4) {
        char[] r0 = this.f12524f;
        int r1 = ((r0.length * 3) / 2) + 1;
        if (r1 < r4) goto L6;
        r4 = r1;
    L6:
        char[] r5 = new char[r4];
        System.arraycopy(r0, 0, r5, 0, this.f12525g);
        this.f12524f = r5;
    }

    public String toString() {
        return new String(this.f12524f, 0, this.f12525g);
    }

    @Override // java.io.Writer
    public void write(int r4) {
        int r1 = 1;
        int r0 = this.f12525g + 1;
        if (r0 > this.f12524f.length) goto L5;
    L8:
        r1 = r0;
    L9:
        this.f12524f[this.f12525g] = (char) r4;
        this.f12525g = r1;
        return;
    L5:
        if (this.f12527i != null) goto L7;
        s(r0);
        goto L8
    L7:
        flush();
        goto L9
    }

    @Override // java.io.Writer
    public void write(String r3) {
        if (r3 != null) goto L5;
        Q();
        return;
    L5:
        write(r3, 0, r3.length());
    }

    @Override // java.io.Writer
    public void write(String r5, int r6, int r7) {
        int r0 = this.f12525g + r7;
        if (r0 > this.f12524f.length) goto L5;
    L11:
        r5.getChars(r6, r7 + r6, this.f12524f, this.f12525g);
        this.f12525g = r0;
        return;
    L5:
        if (this.f12527i != null) goto L7;
        s(r0);
    L7:
        char[] r1 = this.f12524f;
        int r2 = r1.length;
        int r3 = this.f12525g;
        int r4 = r2 - r3;
        int r8 = r6 + r4;
        r5.getChars(r6, r8, r1, r3);
        this.f12525g = this.f12524f.length;
        flush();
        r7 = r7 - r4;
        if (r7 <= this.f12524f.length) goto L9;
        r6 = r8;
        goto L7
    L9:
        r0 = r7;
        r6 = r8;
        goto L11
    }

    @Override // java.io.Writer
    public void write(char[] r4, int r5, int r6) {
        if (r5 < 0) goto L22;
        if (r5 > r4.length) goto L22;
        if (r6 < 0) goto L22;
        int r0 = r5 + r6;
        if (r0 > r4.length) goto L22;
        if (r0 < 0) goto L22;
        if (r6 != 0) goto L11;
        return;
    L11:
        int r1 = this.f12525g + r6;
        if (r1 > this.f12524f.length) goto L14;
    L19:
        System.arraycopy(r4, r5, this.f12524f, this.f12525g, r6);
        this.f12525g = r1;
        return;
    L14:
        if (this.f12527i != null) goto L16;
        s(r1);
    L16:
        char[] r2 = this.f12524f;
        int r3 = r2.length;
        int r7 = this.f12525g;
        int r8 = r3 - r7;
        System.arraycopy(r4, r5, r2, r7, r8);
        this.f12525g = this.f12524f.length;
        flush();
        r6 = r6 - r8;
        r5 = r5 + r8;
        if (r6 > this.f12524f.length) goto L16;
        r1 = r6;
    L22:
        throw new IndexOutOfBoundsException();
    }
}
