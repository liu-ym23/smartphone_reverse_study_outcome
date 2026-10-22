package com.android.settingslib.qrcode;

import com.google.zxing.LuminanceSource;

/* JADX INFO: loaded from: classes.dex */
public class QrYuvLuminanceSource extends LuminanceSource {
    private int mHeight;
    private int mWidth;
    private byte[] mYuvData;

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public QrYuvLuminanceSource(byte[] r1, int r2, int r3) {
        super(r2, r3);
        this.mWidth = r2;
        this.mHeight = r3;
        this.mYuvData = r1;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int r4, int r5, int r6, int r7) {
        byte[] r0 = new byte[r6 * r7];
        int r1 = this.mWidth;
        int r2 = (r5 * r1) + r4;
        if ((r4 + r6) > r1) goto L12;
        if ((r5 + r7) > this.mHeight) goto L12;
        int r8 = 0;
    L7:
        if (r8 >= r7) goto L10;
        System.arraycopy(this.mYuvData, r2, r0, r8 * r6, r6);
        r2 = r2 + this.mWidth;
        r8 = r8 + 1;
        goto L7
    L10:
        return new QrYuvLuminanceSource(r0, r6, r7);
    L12:
        throw new IllegalArgumentException("cropped rectangle does not fit within image data.");
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int r3, byte[] r4) {
        if (r3 < 0) goto L12;
        if (r3 >= this.mHeight) goto L12;
        if (r4 != null) goto L7;
    L8:
        r4 = new byte[this.mWidth];
    L9:
        byte[] r0 = this.mYuvData;
        int r2 = this.mWidth;
        System.arraycopy(r0, r3 * r2, r4, 0, r2);
        return r4;
    L7:
        if (r4.length >= this.mWidth) goto L9;
    L12:
        throw new IllegalArgumentException("Requested row is outside the image: " + r3);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        return this.mYuvData;
    }
}
