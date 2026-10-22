package tmsdkobf;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import tmsdk.common.exception.BadExpiryDataException;

/* JADX INFO: loaded from: classes5.dex */
final class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f362a;
    private long b;
    private long c;

    n4(boolean r25) {
        int r4 = 0;
        n1.a(new Class[]{ye.class});
        SecureRandom r2 = new SecureRandom();
    L3:
        int r3 = r2.nextInt(900) + 101;
        if (a(r3) == true) goto L3;
        this.f362a = r3;
        int r5 = 100;
        int[] r6 = new int[100];
        double r7 = Math.sqrt(r3);
        int r8 = ((int) r7) - 1;
    L6:
        int r9 = r8 + 1;
        if ((r9 * r9) > r3) goto L9;
        r8 = r9;
        goto L6
    L9:
        r6[0] = r8;
        if ((r8 * r8) != r3) goto L12;
        return;
    L12:
        char r10 = 2;
        char r11 = 3;
        char r12 = 4;
        int[] r13 = {0, 1, 0, -r8, 1};
        int[][] r14 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{100, 5});
        int r15 = 1;
        int r16 = 0;
        int r17 = 0;
    L13:
        if (r15 >= r5) goto L35;
        int r18 = r13[1];
        if (r18 >= 0) goto L17;
        r13[1] = -r18;
        r13[r10] = -r13[r10];
        r13[r11] = -r13[r11];
        r13[r12] = -r13[r12];
    L17:
        int r19 = a(a(a(r13[1], Math.abs(r13[r10])), Math.abs(r13[r11])), Math.abs(r13[r12]));
        if (r19 <= 1) goto L20;
        r13[1] = r13[1] / r19;
        r13[r10] = r13[r10] / r19;
        r13[r11] = r13[r11] / r19;
        r13[r12] = r13[r12] / r19;
    L20:
        r17 = r4;
    L21:
        if (r17 >= r16) goto L32;
        int[] r20 = r14[r17];
        if (r20[1] != r13[1]) goto L31;
        if (r20[r10] != r13[r10]) goto L31;
        if (r20[r11] != r13[r11]) goto L31;
        if (r20[4] == r13[4]) goto L32;
    L31:
        r17 = r17 + 1;
    L32:
        if (r17 < r16) goto L35;
        int[] r21 = r14[r16];
        r21[1] = r13[1];
        r21[r10] = r13[r10];
        r21[r11] = r13[r11];
        r21[4] = r13[4];
        r16 = r16 + 1;
        int r110 = (int) Math.floor(a(r7, r13));
        r6[r15] = r110;
        a(r3, r13, r110);
        r15 = r15 + 1;
        r12 = 4;
        r5 = 100;
        r4 = 0;
        r10 = 2;
        r11 = 3;
    L35:
        int r111 = r15 - 1;
        int r112 = 1;
        long r1 = 1;
        boolean r22 = false;
        long r113 = 0;
    L37:
        if (r113 < 200) goto L42;
        if (r22 == false) goto L42;
        a(r113, r1);
        return;
    L42:
        int r23 = r112 + 1;
        long r114 = 1;
        long r115 = 0;
    L43:
        if (r112 < 0) goto L49;
        if (r23 > r111) goto L46;
        int r24 = r6[r112];
    L47:
        long r116 = r114 + (((long) r24) * r115);
        r112 = r112 - 1;
        r114 = r115;
        r115 = r116;
        goto L43
    L46:
        r24 = r6[((r112 - r17) % r111) + r17];
        goto L47
    L49:
        if (r115 >= 1000000) goto L66;
        long r26 = r115 * r115;
        long r27 = ((long) r3) * (r114 * r114);
        long r28 = 1000 * r26;
        if (r115 < 200) goto L64;
        if ((999 * r27) >= r28) goto L64;
        if (r28 >= (1001 * r27)) goto L64;
        if (r22 == true) goto L64;
        if (r25 == true) goto L59;
    L60:
        if (r25 == true) goto L64;
        if (r26 <= r27) goto L64;
    L63:
        r22 = true;
        goto L64
    L59:
        if (r26 < r27) goto L63;
    L64:
        r112 = r23;
        r1 = r114;
        r113 = r115;
        goto L37
    L66:
        throw new RuntimeException();
    }

    private static final double a(double r6, int[] r8) {
        return (((double) r8[1]) + (((double) r8[2]) * r6)) / (((double) r8[3]) + (((double) r8[4]) * r6));
    }

    private void b() {
        long r0 = this.f362a;
        long r2 = this.b;
        long r4 = this.c;
        if (r2 < 200) goto L12;
        long r1 = r0 * (r4 * r4);
        long r6 = r1 * 1000;
        long r3 = (r2 * r2) * 1000;
        if (r3 <= (r6 - r1)) goto L10;
        if (r3 >= (r6 + r1)) goto L10;
        return;
    L10:
        throw new BadExpiryDataException();
    L12:
        throw new BadExpiryDataException();
    }

    private static final void a(int r9, int[] r10, int r11) {
        int r1 = r10[1];
        int r3 = r10[3];
        int r2 = r1 - (r3 * r11);
        r10[1] = r2;
        int r5 = r10[2];
        int r7 = r10[4];
        int r6 = r5 - (r11 * r7);
        r10[2] = r6;
        int r12 = (r2 * r3) - ((r6 * r7) * r9);
        int r8 = (r7 * r2) - (r3 * r6);
        r10[1] = r12;
        r10[2] = r8;
        r10[3] = (r2 * r2) - ((r6 * r6) * r9);
        r10[4] = 0;
    }

    private static final int a(int r1, int r2) {
        if (r1 != 0) goto L4;
        return r2;
    L4:
        if (r2 != 0) goto L6;
        return r1;
    L6:
        if (r1 < r2) goto L8;
    L9:
        int r3 = r1 % r2;
        if (r3 == 0) goto L11;
        int r0 = r2;
        r2 = r3;
        r1 = r0;
        goto L9
    L11:
        return r2;
    L8:
        return a(r2, r1);
    }

    final boolean a() {
        b();
        long r0 = this.f362a;
        long r2 = this.b;
        long r4 = this.c;
        if ((r2 * r2) >= (r0 * (r4 * r4))) goto L5;
        return true;
    L5:
        return false;
    }

    private static final boolean a(int r4) {
        int r0 = ((int) Math.sqrt(r4)) - 1;
    L3:
        int r2 = r0 + 1;
        if ((r2 * r2) > r4) goto L7;
        r0 = r2;
        goto L3
    L7:
        if ((r0 * r0) == r4) goto L12;
        return false;
    L12:
        return true;
    }

    final void a(long r4, long r6) {
        n1.a(new Class[]{n4.class, ye.class});
        this.b = r4;
        this.c = r6;
        b();
    }
}
