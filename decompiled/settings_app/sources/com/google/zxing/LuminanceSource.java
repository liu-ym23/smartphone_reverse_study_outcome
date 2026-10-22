package com.google.zxing;

import cz.msebera.android.httpclient.message.TokenParser;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LuminanceSource {
    private final int height;
    private final int width;

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int r1, byte[] r2);

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    protected LuminanceSource(int r1, int r2) {
        this.width = r1;
        this.height = r2;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    public LuminanceSource crop(int r1, int r2, int r3, int r4) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        byte[] r0 = new byte[this.width];
        StringBuilder r1 = new StringBuilder(this.height * (this.width + 1));
        int r3 = 0;
    L4:
        if (r3 >= this.height) goto L21;
        r0 = getRow(r3, r0);
        int r4 = 0;
    L7:
        if (r4 >= this.width) goto L19;
        int r5 = r0[r4] & 255;
        if (r5 >= 64) goto L12;
        char r6 = '#';
    L18:
        r1.append(r6);
        r4 = r4 + 1;
        goto L7
    L12:
        if (r5 >= 128) goto L15;
        r6 = '+';
        goto L18
    L15:
        if (r5 >= 192) goto L17;
        r6 = '.';
        goto L18
    L17:
        r6 = TokenParser.SP;
        goto L18
    L19:
        r1.append('\n');
        r3 = r3 + 1;
        goto L4
    L21:
        return r1.toString();
    }
}
