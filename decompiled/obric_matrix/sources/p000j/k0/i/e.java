package p000j.k0.i;

import java.io.IOException;
import k.h;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final h f17961a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f17962b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String[] f17963c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String[] f17964d = null;

    static {
        f17961a = h.k("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f17962b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f17963c = new String[64];
        f17964d = new String[256];
        int r0 = 0;
        int r1 = 0;
    L3:
        String[] r2 = f17964d;
        if (r1 >= r2.length) goto L6;
        r2[r1] = c.r("%8s", new Object[]{Integer.toBinaryString(r1)}).replace(' ', '0');
        r1 = r1 + 1;
        goto L3
    L6:
        String[] r3 = f17963c;
        r3[0] = "";
        r3[1] = "END_STREAM";
        int[] r4 = {1};
        r3[8] = "PADDED";
        int r5 = 0;
    L8:
        if (r5 >= 1) goto L10;
        int r7 = r4[r5];
        String[] r8 = f17963c;
        r8[r7 | 8] = r8[r7] + "|PADDED";
        r5 = r5 + 1;
        goto L8
    L10:
        String[] r6 = f17963c;
        r6[4] = "END_HEADERS";
        r6[32] = "PRIORITY";
        r6[36] = "END_HEADERS|PRIORITY";
        int[] r9 = {4, 32, 36};
        int r10 = 0;
    L11:
        if (r10 >= 3) goto L16;
        int r11 = r9[r10];
        int r12 = 0;
    L13:
        if (r12 >= 1) goto L15;
        int r13 = r4[r12];
        String[] r14 = f17963c;
        int r15 = r13 | r11;
        r14[r15] = r14[r13] + '|' + r14[r11];
        r14[r15 | 8] = r14[r13] + '|' + r14[r11] + "|PADDED";
        r12 = r12 + 1;
        goto L13
    L15:
        r10 = r10 + 1;
    L16:
        String[] r16 = f17963c;
        if (r0 >= r16.length) goto L22;
        if (r16[r0] != null) goto L21;
        r16[r0] = f17964d[r0];
    L21:
        r0 = r0 + 1;
        goto L16
    }

    private e() {
    }

    static String a(byte r2, byte r3) {
        if (r3 != 0) goto L6;
        return "";
    L6:
        if (r2 == 2) goto L39;
        if (r2 == 3) goto L39;
        if (r2 == 4) goto L34;
        if (r2 == 6) goto L34;
        if (r2 == 7) goto L39;
        if (r2 == 8) goto L39;
        String[] r0 = f17963c;
        if (r3 >= r0.length) goto L20;
        String r1 = r0[r3];
    L22:
        if (r2 == 5) goto L24;
    L27:
        if (r2 == 0) goto L29;
    L32:
        return r1;
    L29:
        if ((r3 & 32) == 0) goto L32;
        return r1.replace("PRIORITY", "COMPRESSED");
    L24:
        if ((r3 & 4) == 0) goto L27;
        return r1.replace("HEADERS", "PUSH_PROMISE");
    L20:
        r1 = f17964d[r3];
    L34:
        if (r3 != 1) goto L37;
        return "ACK";
    L37:
        return f17964d[r3];
    L39:
        return f17964d[r3];
    }

    static String b(boolean r4, int r5, int r6, byte r7, byte r8) {
        String[] r0 = f17962b;
        if (r7 >= r0.length) goto L5;
        String r1 = r0[r7];
    L6:
        String r9 = a(r7, r8);
        Object[] r10 = new Object[5];
        if (r4 == false) goto L9;
        String r11 = "<<";
    L10:
        r10[0] = r11;
        r10[1] = Integer.valueOf(r5);
        r10[2] = Integer.valueOf(r6);
        r10[3] = r1;
        r10[4] = r9;
        return c.r("%s 0x%08x %5d %-13s %s", r10);
    L9:
        r11 = ">>";
        goto L10
    L5:
        r1 = c.r("0x%02x", new Object[]{Byte.valueOf(r7)});
        goto L6
    }

    static IllegalArgumentException c(String r1, Object... r2) {
        throw new IllegalArgumentException(c.r(r1, r2));
    }

    static IOException d(String r1, Object... r2) {
        throw new IOException(c.r(r1, r2));
    }
}
