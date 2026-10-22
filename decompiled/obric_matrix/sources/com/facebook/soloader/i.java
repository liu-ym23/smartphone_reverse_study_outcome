package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    private static class a extends RuntimeException {
        a(String r1) {
            super(r1);
        }
    }

    public static String[] a(File r1) {
        FileInputStream r0 = new FileInputStream(r1);
        String[] r2 = b(r0.getChannel());     // Catch: Throwable -> L6
        r0.close();
        return r2;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public static String[] b(FileChannel r36) {
        ByteBuffer r1 = ByteBuffer.allocate(8);
        r1.order(ByteOrder.LITTLE_ENDIAN);
        if (f(r36, r1, 0) != 1179403647) goto L127;
        boolean r8 = true;
        if (g(r36, r1, 4) == 1) goto L9;
        r8 = false;
    L9:
        if (g(r36, r1, 5) != 2) goto L12;
        r1.order(ByteOrder.BIG_ENDIAN);
    L12:
        if (r8 == false) goto L14;
        long r15 = f(r36, r1, 28);
    L16:
        if (r8 == false) goto L18;
        long r4 = e(r36, r1, 44);
    L19:
        if (r8 == false) goto L21;
        long r2 = 42;
    L22:
        int r3 = e(r36, r1, r2);
        if (r4 != 65535) goto L31;
        if (r8 == false) goto L26;
        long r5 = f(r36, r1, 32);
    L27:
        if (r8 == false) goto L29;
        long r6 = r5 + 28;
    L30:
        r4 = f(r36, r1, r6);
        goto L31
    L29:
        r6 = r5 + 44;
        goto L30
    L26:
        r5 = c(r36, r1, 40);
    L31:
        long r13 = r15;
        long r11 = 0;
    L33:
        if (r11 >= r4) goto L40;
        if (f(r36, r1, r13 + 0) == 2) goto L36;
        r13 = r13 + ((long) r3);
        r11 = r11 + 1;
        goto L33
    L36:
        if (r8 == false) goto L38;
        long r9 = f(r36, r1, r13 + 4);
    L41:
        long r21 = 0;
        if (r9 == 0) goto L125;
        long r14 = r9;
        long r12 = 0;
        int r7 = 0;
    L44:
        boolean r28 = r8;
        if (r8 == false) goto L47;
        long r10 = f(r36, r1, r14 + r21);
    L48:
        long r30 = r9;
        String r16 = "malformed DT_NEEDED section";
        if (r10 != 1) goto L54;
        if (r7 == Integer.MAX_VALUE) goto L53;
        r7 = r7 + 1;
        long r32 = r10;
    L60:
        long r17 = 16;
        if (r28 == false) goto L63;
        long r34 = 8;
    L64:
        r14 = r14 + r34;
        r21 = 0;
        if (r32 == 0) goto L67;
        r8 = r28;
        r9 = r30;
        goto L44
    L67:
        if (r12 == 0) goto L122;
        int r18 = 0;
    L70:
        if (r18 >= r4) goto L89;
        if (f(r36, r1, r15 + r21) != 1) goto L87;
        if (r28 == false) goto L75;
        long r19 = f(r36, r1, r15 + 8);
    L76:
        if (r28 == false) goto L78;
        long r20 = f(r36, r1, r15 + 20);
    L80:
        if (r19 > r12) goto L88;
        if (r12 >= (r20 + r19)) goto L88;
        if (r28 == false) goto L85;
        long r22 = f(r36, r1, r15 + 4);
    L86:
        long r23 = r22 + (r12 - r19);
    L90:
        long r24 = 0;
        if (r23 == 0) goto L120;
        String[] r25 = new String[r7];
        long r26 = r30;
        int r27 = 0;
    L93:
        long r110 = r26 + r24;
        if (r28 == false) goto L96;
        long r111 = f(r36, r1, r110);
    L98:
        if (r111 != 1) goto L109;
        if (r28 == false) goto L102;
        long r29 = f(r36, r1, r26 + 4);
    L103:
        r25[r27] = d(r36, r1, r29 + r23);
        if (r27 == Integer.MAX_VALUE) goto L107;
        r27 = r27 + 1;
        goto L109
    L107:
        throw new a(r16);
    L102:
        r29 = c(r36, r1, r26 + 8);
    L109:
        if (r28 == false) goto L111;
        long r112 = 8;
    L112:
        r26 = r26 + r112;
        if (r111 == 0) goto L114;
        r16 = r16;
        r24 = 0;
        goto L93
    L114:
        if (r27 != r7) goto L117;
        return r25;
    L117:
        throw new a(r16);
    L111:
        r112 = 16;
        goto L112
    L96:
        r111 = c(r36, r1, r110);
        goto L98
    L120:
        throw new a("did not find file offset of DT_STRTAB table");
    L85:
        r22 = c(r36, r1, r15 + 8);
    L88:
        r15 = r15 + ((long) r3);
        r18 = r18 + 1;
        r16 = r16;
        r17 = 16;
        r21 = 0;
        goto L70
    L78:
        r20 = c(r36, r1, r15 + 40);
        goto L80
    L75:
        r19 = c(r36, r1, r15 + r17);
        goto L76
    L87:
        r16 = r16;
        goto L88
    L89:
        r16 = r16;
        r23 = 0;
        goto L90
    L122:
        throw new a("Dynamic section string-table not found");
    L63:
        r34 = 16;
        goto L64
    L53:
        throw new a("malformed DT_NEEDED section");
    L54:
        r32 = r10;
        if (r10 != 5) goto L60;
        if (r28 == false) goto L58;
        long r31 = f(r36, r1, r14 + 4);
    L59:
        r12 = r31;
        goto L60
    L58:
        r31 = c(r36, r1, r14 + 8);
        goto L59
    L47:
        r10 = c(r36, r1, r14 + r21);
        goto L48
    L125:
        throw new a("ELF file does not contain dynamic linking information");
    L38:
        r9 = c(r36, r1, r13 + 8);
        goto L41
    L40:
        r9 = 0;
        goto L41
    L21:
        r2 = 54;
        goto L22
    L18:
        r4 = e(r36, r1, 56);
        goto L19
    L14:
        r15 = c(r36, r1, 32);
        goto L16
    L127:
        throw new a("file is not ELF");
    }

    private static long c(FileChannel r1, ByteBuffer r2, long r3) {
        h(r1, r2, 8, r3);
        return r2.getLong();
    }

    private static String d(FileChannel r3, ByteBuffer r4, long r5) {
        StringBuilder r0 = new StringBuilder();
    L3:
        long r1 = 1 + r5;
        short r6 = g(r3, r4, r5);
        if (r6 == 0) goto L7;
        r0.append((char) r6);
        r5 = r1;
        goto L3
    L7:
        return r0.toString();
    }

    private static int e(FileChannel r1, ByteBuffer r2, long r3) {
        h(r1, r2, 2, r3);
        return r2.getShort() & 65535;
    }

    private static long f(FileChannel r1, ByteBuffer r2, long r3) {
        h(r1, r2, 4, r3);
        return ((long) r2.getInt()) & 4294967295L;
    }

    private static short g(FileChannel r1, ByteBuffer r2, long r3) {
        h(r1, r2, 1, r3);
        return (short) (r2.get() & 255);
    }

    private static void h(FileChannel r3, ByteBuffer r4, int r5, long r6) {
        r4.position(0);
        r4.limit(r5);
    L4:
        if (r4.remaining() <= 0) goto L10;
        int r7 = r3.read(r4, r6);
        if (r7 == (-1)) goto L10;
        r6 = r6 + ((long) r7);
    L10:
        if (r4.remaining() > 0) goto L14;
        r4.position(0);
        return;
    L14:
        throw new a("ELF file truncated");
    }
}
