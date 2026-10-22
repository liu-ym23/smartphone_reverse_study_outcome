package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* JADX INFO: loaded from: classes4.dex */
class DetectionResultColumn {
    private static final int MAX_NEARBY_DISTANCE = 5;
    private final BoundingBox boundingBox;
    private final Codeword[] codewords;

    DetectionResultColumn(BoundingBox r2) {
        this.boundingBox = new BoundingBox(r2);
        this.codewords = new Codeword[(r2.getMaxY() - r2.getMinY()) + 1];
    }

    final Codeword getCodewordNearby(int r5) {
        Codeword r0 = getCodeword(r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        int r1 = 1;
    L7:
        if (r1 >= 5) goto L19;
        int r2 = imageRowToCodewordIndex(r5) - r1;
        if (r2 < 0) goto L13;
        Codeword r3 = this.codewords[r2];
        if (r3 == null) goto L13;
        return r3;
    L13:
        int r4 = imageRowToCodewordIndex(r5) + r1;
        Codeword[] r6 = this.codewords;
        if (r4 >= r6.length) goto L18;
        Codeword r7 = r6[r4];
        if (r7 == null) goto L18;
        return r7;
    L18:
        r1 = r1 + 1;
        goto L7
    L19:
        return null;
    }

    final int imageRowToCodewordIndex(int r1) {
        return r1 - this.boundingBox.getMinY();
    }

    final void setCodeword(int r2, Codeword r3) {
        this.codewords[imageRowToCodewordIndex(r2)] = r3;
    }

    final Codeword getCodeword(int r2) {
        return this.codewords[imageRowToCodewordIndex(r2)];
    }

    final BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    final Codeword[] getCodewords() {
        return this.codewords;
    }

    public String toString() {
        Formatter r0 = new Formatter();
        Codeword[] r10 = this.codewords;     // Catch: Throwable -> L13
        int r1 = r10.length;     // Catch: Throwable -> L13
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r1) goto L10;
        Codeword r5 = r10[r3];     // Catch: Throwable -> L13
        if (r5 != null) goto L8;
        r0.format("%3d:    |   %n", new Object[]{Integer.valueOf(r4)});     // Catch: Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13
    L9:
        r3 = r3 + 1;     // Catch: Throwable -> L13
        goto L4
    L8:
        r0.format("%3d: %3d|%3d%n", new Object[]{Integer.valueOf(r4), Integer.valueOf(r5.getRowNumber()), Integer.valueOf(r5.getValue())});     // Catch: Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13
        goto L9
    L10:
        String r11 = r0.toString();     // Catch: Throwable -> L13
        r0.close();
        return r11;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r0.close();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    }
}
