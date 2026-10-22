package l.b.h.h;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final byte[] f22298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final byte[] f22299b;

    public g() {
        this.f22298a = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        this.f22299b = new byte[128];
        d();
    }

    @Override // l.b.h.h.d
    public int a(byte[] r9, int r10, int r11, OutputStream r12) {
        byte[] r0 = new byte[72];
    L3:
        if (r11 <= 0) goto L6;
        int r7 = Math.min(36, r11);
        r12.write(r0, 0, c(r9, r10, r7, r0, 0));
        r10 = r10 + r7;
        r11 = r11 - r7;
        goto L3
    L6:
        return r11 * 2;
    }

    byte[] b(String r6, int r7, int r8) {
        Objects.requireNonNull(r6, "'str' cannot be null");
        if (r7 < 0) goto L20;
        if (r8 < 0) goto L20;
        if (r7 > (r6.length() - r8)) goto L20;
        if ((r8 & 1) != 0) goto L18;
        int r9 = r8 >>> 1;
        byte[] r0 = new byte[r9];
        int r1 = 0;
    L10:
        if (r1 >= r9) goto L16;
        int r3 = r7 + 1;
        byte r10 = this.f22299b[r6.charAt(r7)];
        int r4 = r3 + 1;
        int r11 = r10 << 4;
        int r12 = r11 | this.f22299b[r6.charAt(r3)];
        if (r12 < 0) goto L15;
        r0[r1] = (byte) r12;
        r1 = r1 + 1;
        r7 = r4;
        goto L10
    L15:
        throw new IOException("invalid characters encountered in Hex string");
    L16:
        return r0;
    L18:
        throw new IOException("a hexadecimal encoding must have an even number of characters");
    L20:
        throw new IndexOutOfBoundsException("invalid offset and/or length specified");
    }

    public int c(byte[] r6, int r7, int r8, byte[] r9, int r10) {
        int r11 = r8 + r7;
        int r0 = r10;
    L3:
        if (r7 >= r11) goto L6;
        int r1 = r7 + 1;
        int r12 = r6[r7] & 255;
        int r2 = r0 + 1;
        byte[] r3 = this.f22298a;
        r9[r0] = r3[r12 >>> 4];
        r0 = r2 + 1;
        r9[r2] = r3[r12 & 15];
        r7 = r1;
        goto L3
    L6:
        return r0 - r10;
    }

    protected void d() {
        int r0 = 0;
        int r1 = 0;
    L3:
        byte[] r2 = this.f22299b;
        if (r1 >= r2.length) goto L6;
        r2[r1] = -1;
        r1 = r1 + 1;
    L6:
        byte[] r3 = this.f22298a;
        if (r0 >= r3.length) goto L9;
        this.f22299b[r3[r0]] = (byte) r0;
        r0 = r0 + 1;
        goto L6
    L9:
        byte[] r4 = this.f22299b;
        r4[65] = r4[97];
        r4[66] = r4[98];
        r4[67] = r4[99];
        r4[68] = r4[100];
        r4[69] = r4[101(0x65, float:1.42E-43)];
        r4[70] = r4[102(0x66, float:1.43E-43)];
    }
}
