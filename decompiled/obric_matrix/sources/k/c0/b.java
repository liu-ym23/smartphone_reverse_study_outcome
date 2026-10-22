package k.c0;

import k.e;
import k.h;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f18243a = null;

    static {
        f18243a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static final /* synthetic */ int a(byte[] r0, int r1) {
        return c(r0, r1);
    }

    public static final /* synthetic */ int b(char r0) {
        return e(r0);
    }

    private static final int c(byte[] r19, int r20) {
        int r2 = r19.length;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L3:
        if (r4 >= r2) goto L220;
        byte r7 = r19[r4];
        if (r7 >= 0) goto L6;
        if ((r7 >> 5) != (-2)) goto L90;
        int r3 = r4 + 1;
        if (r2 <= r3) goto L52;
        byte r8 = r19[r4];
        byte r9 = r19[r3];
        if ((r9 & 192) != 128) goto L58;
        boolean r15 = true;
    L59:
        if (r15 == false) goto L60;
        int r10 = (r9 ^ 3968) ^ (r8 << 6);
        if (r10 < 128) goto L65;
        int r11 = r6 + 1;
        if (r6 == r20) goto L70;
        if (r10 == 10) goto L81;
        if (r10 == 13) goto L81;
        if (r10 < 0) goto L75;
        if (31 < r10) goto L75;
    L78:
        boolean r12 = true;
    L80:
        if (r12 == false) goto L81;
    L82:
        return -1;
    L75:
        if (127 > r10) goto L79;
        if (159 >= r10) goto L78;
    L79:
        r12 = false;
    L81:
        if (r10 == 65533) goto L82;
        if (r10 >= 65536) goto L86;
        int r16 = 1;
    L87:
        r5 = r5 + r16;
        r4 = r4 + 2;
    L88:
        r6 = r11;
        goto L3
    L86:
        r16 = 2;
        goto L87
    L70:
        return r5;
    L65:
        if (r6 != r20) goto L67;
        return r5;
    L67:
        return -1;
    L60:
        if (r6 != r20) goto L62;
        return r5;
    L62:
        return -1;
    L58:
        r15 = false;
        goto L59
    L52:
        if (r6 != r20) goto L54;
        return r5;
    L54:
        return -1;
    L90:
        if ((r7 >> 4) != (-2)) goto L147;
        int r13 = r4 + 2;
        if (r2 <= r13) goto L93;
        byte r14 = r19[r4];
        byte r17 = r19[r4 + 1];
        if ((r17 & 192) != 128) goto L99;
        boolean r18 = true;
    L100:
        if (r18 == false) goto L101;
        byte r21 = r19[r13];
        if ((r21 & 192) != 128) goto L107;
        boolean r22 = true;
    L108:
        if (r22 == false) goto L109;
        int r23 = ((r21 ^ (-123008)) ^ (r17 << 6)) ^ (r14 << 12);
        if (r23 < 2048) goto L114;
        if (55296 > r23) goto L123;
        if (57343 < r23) goto L123;
        if (r6 != r20) goto L122;
        return r5;
    L122:
        return -1;
    L123:
        r11 = r6 + 1;
        if (r6 == r20) goto L125;
        if (r23 == 10) goto L139;
        if (r23 == 13) goto L139;
        if (r23 < 0) goto L131;
        if (31 < r23) goto L131;
    L135:
        boolean r24 = true;
    L137:
        if (r24 == false) goto L139;
    L140:
        return -1;
    L131:
        if (127 <= r23) goto L134;
    L136:
        r24 = false;
        goto L137
    L134:
        if (159 < r23) goto L136;
    L139:
        if (r23 == 65533) goto L140;
        if (r23 >= 65536) goto L144;
        int r110 = 1;
    L145:
        r5 = r5 + r110;
        r4 = r4 + 3;
        goto L88
    L144:
        r110 = 2;
        goto L145
    L125:
        return r5;
    L114:
        if (r6 != r20) goto L116;
        return r5;
    L116:
        return -1;
    L109:
        if (r6 != r20) goto L111;
        return r5;
    L111:
        return -1;
    L107:
        r22 = false;
        goto L108
    L101:
        if (r6 != r20) goto L103;
        return r5;
    L103:
        return -1;
    L99:
        r18 = false;
        goto L100
    L93:
        if (r6 != r20) goto L95;
        return r5;
    L95:
        return -1;
    L147:
        if ((r7 >> 3) != (-2)) goto L217;
        int r25 = r4 + 3;
        if (r2 <= r25) goto L150;
        byte r26 = r19[r4];
        byte r27 = r19[r4 + 1];
        if ((r27 & 192) != 128) goto L156;
        boolean r111 = true;
    L157:
        if (r111 == false) goto L158;
        byte r112 = r19[r4 + 2];
        if ((r112 & 192) != 128) goto L164;
        boolean r113 = true;
    L165:
        if (r113 == false) goto L166;
        byte r28 = r19[r25];
        if ((r28 & 192) != 128) goto L172;
        boolean r114 = true;
    L173:
        if (r114 == false) goto L174;
        int r29 = (((r28 ^ 3678080) ^ (r112 << 6)) ^ (r27 << 12)) ^ (r26 << 18);
        if (r29 > 1114111) goto L179;
        if (55296 > r29) goto L189;
        if (57343 < r29) goto L189;
        if (r6 != r20) goto L187;
        return r5;
    L187:
        return -1;
    L189:
        if (r29 < 65536) goto L190;
        r11 = r6 + 1;
        if (r6 == r20) goto L195;
        if (r29 == 10) goto L210;
        if (r29 == 13) goto L210;
        if (r29 < 0) goto L202;
        if (31 < r29) goto L202;
    L206:
        boolean r30 = true;
    L208:
        if (r30 == false) goto L210;
    L211:
        return -1;
    L202:
        if (127 <= r29) goto L205;
    L207:
        r30 = false;
        goto L208
    L205:
        if (159 < r29) goto L207;
    L210:
        if (r29 == 65533) goto L211;
        if (r29 >= 65536) goto L215;
        int r115 = 1;
    L216:
        r5 = r5 + r115;
        r4 = r4 + 4;
        goto L88
    L215:
        r115 = 2;
        goto L216
    L195:
        return r5;
    L190:
        if (r6 != r20) goto L192;
        return r5;
    L192:
        return -1;
    L179:
        if (r6 != r20) goto L181;
        return r5;
    L181:
        return -1;
    L174:
        if (r6 != r20) goto L176;
        return r5;
    L176:
        return -1;
    L172:
        r114 = false;
        goto L173
    L166:
        if (r6 != r20) goto L168;
        return r5;
    L168:
        return -1;
    L164:
        r113 = false;
        goto L165
    L158:
        if (r6 != r20) goto L160;
        return r5;
    L160:
        return -1;
    L156:
        r111 = false;
        goto L157
    L150:
        if (r6 != r20) goto L152;
        return r5;
    L152:
        return -1;
    L217:
        if (r6 != r20) goto L219;
        return r5;
    L219:
        return -1;
    L6:
        int r116 = r6 + 1;
        if (r6 == r20) goto L8;
        if (r7 == 10) goto L19;
        if (r7 == 13) goto L19;
        if (r7 < 0) goto L13;
        if (31 < r7) goto L13;
    L16:
        boolean r31 = true;
    L18:
        if (r31 == false) goto L19;
    L20:
        return -1;
    L13:
        if (127 > r7) goto L17;
        if (159 >= r7) goto L16;
    L17:
        r31 = false;
    L19:
        if (r7 == 65533) goto L20;
        if (r7 >= 65536) goto L23;
        int r32 = 1;
    L24:
        r5 = r5 + r32;
        r4 = r4 + 1;
    L25:
        r6 = r116;
        if (r4 >= r2) goto L3;
        if (r19[r4] < 0) goto L3;
        int r33 = r4 + 1;
        byte r34 = r19[r4];
        r116 = r6 + 1;
        if (r6 == r20) goto L31;
        if (r34 == 10) goto L42;
        if (r34 == 13) goto L42;
        if (r34 < 0) goto L36;
        if (31 < r34) goto L36;
    L39:
        boolean r35 = true;
    L41:
        if (r35 == false) goto L42;
    L43:
        return -1;
    L36:
        if (127 > r34) goto L40;
        if (159 >= r34) goto L39;
    L40:
        r35 = false;
    L42:
        if (r34 == 65533) goto L43;
        if (r34 >= 65536) goto L46;
        int r36 = 1;
    L47:
        r5 = r5 + r36;
        r4 = r33;
        goto L25
    L46:
        r36 = 2;
        goto L47
    L31:
        return r5;
    L23:
        r32 = 2;
        goto L24
    L8:
        return r5;
    L220:
        return r5;
    }

    public static final void d(h r1, e r2, int r3, int r4) {
        o.g(r1, "$this$commonWrite");
        o.g(r2, "buffer");
        r2.q0(r1.m(), r3, r4);
    }

    private static final int e(char r3) {
        if ('0' <= r3) goto L6;
    L8:
        char r1 = 'a';
        if ('a' > r3) goto L13;
        if ('f' < r3) goto L13;
    L20:
        return (r3 - r1) + 10;
    L13:
        r1 = 'A';
        if ('A' > r3) goto L19;
        if ('F' >= r3) goto L20;
    L19:
        throw new IllegalArgumentException("Unexpected hex digit: " + r3);
    L6:
        if ('9' < r3) goto L8;
        return r3 - '0';
    }

    public static final char[] f() {
        return f18243a;
    }
}
