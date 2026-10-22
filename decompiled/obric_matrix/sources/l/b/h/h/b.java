package l.b.h.h;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final byte[] f22292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected byte f22293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final byte[] f22294c;

    public b() {
        this.f22292a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        this.f22293b = 61;
        this.f22294c = new byte[128];
        c();
    }

    @Override // l.b.h.h.d
    public int a(byte[] r9, int r10, int r11, OutputStream r12) {
        byte[] r0 = new byte[72];
    L3:
        if (r11 <= 0) goto L6;
        int r7 = Math.min(54, r11);
        r12.write(r0, 0, b(r9, r10, r7, r0, 0));
        r10 = r10 + r7;
        r11 = r11 - r7;
        goto L3
    L6:
        return ((r11 + 2) / 3) * 4;
    }

    public int b(byte[] r11, int r12, int r13, byte[] r14, int r15) {
        int r0 = (r12 + r13) - 2;
        int r2 = r12;
        int r3 = r15;
    L3:
        if (r2 >= r0) goto L5;
        int r4 = r2 + 1;
        byte r5 = r11[r2];
        int r6 = r4 + 1;
        int r7 = r11[r4] & 255;
        int r8 = r6 + 1;
        int r9 = r11[r6] & 255;
        int r10 = r3 + 1;
        byte[] r16 = this.f22292a;
        r14[r3] = r16[(r5 >>> 2) & 63];
        int r17 = r10 + 1;
        r14[r10] = r16[((r5 << 4) | (r7 >>> 4)) & 63];
        int r18 = r17 + 1;
        r14[r17] = r16[((r7 << 2) | (r9 >>> 6)) & 63];
        r3 = r18 + 1;
        r14[r18] = r16[r9 & 63];
        r2 = r8;
        goto L3
    L5:
        int r19 = r13 - (r2 - r12);
        if (r19 == 1) goto L10;
        if (r19 != 2) goto L12;
        int r110 = r11[r2] & 255;
        int r111 = r11[r2 + 1] & 255;
        int r112 = r3 + 1;
        byte[] r1 = this.f22292a;
        r14[r3] = r1[(r110 >>> 2) & 63];
        int r20 = r112 + 1;
        r14[r112] = r1[((r110 << 4) | (r111 >>> 4)) & 63];
        int r113 = r20 + 1;
        r14[r20] = r1[(r111 << 2) & 63];
        r3 = r113 + 1;
        r14[r113] = this.f22293b;
    L12:
        return r3 - r15;
    L10:
        int r114 = r11[r2] & 255;
        int r115 = r3 + 1;
        byte[] r116 = this.f22292a;
        r14[r3] = r116[(r114 >>> 2) & 63];
        int r21 = r115 + 1;
        r14[r115] = r116[(r114 << 4) & 63];
        int r117 = r21 + 1;
        byte r118 = this.f22293b;
        r14[r21] = r118;
        r3 = r117 + 1;
        r14[r117] = r118;
        goto L12
    }

    protected void c() {
        int r0 = 0;
        int r1 = 0;
    L3:
        byte[] r2 = this.f22294c;
        if (r1 >= r2.length) goto L6;
        r2[r1] = -1;
        r1 = r1 + 1;
    L6:
        byte[] r3 = this.f22292a;
        if (r0 >= r3.length) goto L9;
        this.f22294c[r3[r0]] = (byte) r0;
        r0 = r0 + 1;
        goto L6
    }
}
