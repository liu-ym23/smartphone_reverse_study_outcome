package com.google.zxing.common;

/* JADX INFO: loaded from: classes4.dex */
public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] r1) {
        this.bytes = r1;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int r10) {
        if (r10 <= 0) goto L24;
        if (r10 > 32) goto L24;
        if (r10 > available()) goto L24;
        int r0 = this.bitOffset;
        int r1 = 0;
        if (r0 <= 0) goto L17;
        int r4 = 8 - r0;
        if (r10 >= r4) goto L12;
        int r5 = r10;
    L13:
        int r6 = r4 - r5;
        byte[] r7 = this.bytes;
        int r8 = this.byteOffset;
        int r9 = (((255 >> (8 - r5)) << r6) & r7[r8]) >> r6;
        r10 = r10 - r5;
        int r2 = r0 + r5;
        this.bitOffset = r2;
        if (r2 != 8) goto L16;
        this.bitOffset = 0;
        this.byteOffset = r8 + 1;
    L16:
        r1 = r9;
        goto L17
    L12:
        r5 = r4;
    L17:
        if (r10 <= 0) goto L26;
    L18:
        if (r10 < 8) goto L20;
        int r3 = r1 << 8;
        byte[] r11 = this.bytes;
        int r12 = this.byteOffset;
        r1 = (r11[r12] & 255) | r3;
        this.byteOffset = r12 + 1;
        r10 = r10 - 8;
        goto L18
    L20:
        if (r10 <= 0) goto L27;
        int r13 = 8 - r10;
        int r14 = (r1 << r10) | ((((255 >> r13) << r13) & this.bytes[this.byteOffset]) >> r13);
        this.bitOffset += r10;
        return r14;
    L27:
        return r1;
    L26:
        return r1;
    L24:
        throw new IllegalArgumentException(String.valueOf(r10));
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }
}
