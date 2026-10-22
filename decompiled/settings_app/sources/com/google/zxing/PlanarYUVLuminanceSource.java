package com.google.zxing;

/* JADX INFO: loaded from: classes4.dex */
public final class PlanarYUVLuminanceSource extends LuminanceSource {
    private static final int THUMBNAIL_SCALE_FACTOR = 2;
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final int top;
    private final byte[] yuvData;

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public PlanarYUVLuminanceSource(byte[] r2, int r3, int r4, int r5, int r6, int r7, int r8, boolean r9) {
        super(r7, r8);
        if ((r5 + r7) > r3) goto L11;
        if ((r6 + r8) > r4) goto L11;
        this.yuvData = r2;
        this.dataWidth = r3;
        this.dataHeight = r4;
        this.left = r5;
        this.top = r6;
        if (r9 == false) goto L12;
        reverseHorizontal(r7, r8);
        return;
    L12:
        return;
    L11:
        throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int r3, byte[] r4) {
        if (r3 < 0) goto L13;
        if (r3 >= getHeight()) goto L13;
        int r0 = getWidth();
        if (r4 != null) goto L8;
    L9:
        r4 = new byte[r0];
    L10:
        int r5 = ((r3 + this.top) * this.dataWidth) + this.left;
        System.arraycopy(this.yuvData, r5, r4, 0, r0);
        return r4;
    L8:
        if (r4.length >= r0) goto L10;
    L13:
        throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(r3)));
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int r0 = getWidth();
        int r1 = getHeight();
        int r2 = this.dataWidth;
        if (r0 == r2) goto L5;
    L8:
        int r3 = r0 * r1;
        byte[] r4 = new byte[r3];
        int r5 = (this.top * r2) + this.left;
        int r6 = 0;
        if (r0 != r2) goto L12;
        System.arraycopy(this.yuvData, r5, r4, 0, r3);
        return r4;
    L12:
        if (r6 >= r1) goto L14;
        byte[] r7 = this.yuvData;
        System.arraycopy(r7, r5, r4, r6 * r0, r0);
        r5 = r5 + this.dataWidth;
        r6 = r6 + 1;
        goto L12
    L14:
        return r4;
    L5:
        if (r1 != this.dataHeight) goto L8;
        return this.yuvData;
    }

    @Override // com.google.zxing.LuminanceSource
    public LuminanceSource crop(int r11, int r12, int r13, int r14) {
        return new PlanarYUVLuminanceSource(this.yuvData, this.dataWidth, this.dataHeight, this.left + r11, this.top + r12, r13, r14, false);
    }

    public int[] renderThumbnail() {
        int r0 = getWidth() / 2;
        int r1 = getHeight() / 2;
        int[] r2 = new int[r0 * r1];
        byte[] r3 = this.yuvData;
        int r4 = (this.top * this.dataWidth) + this.left;
        int r6 = 0;
    L3:
        if (r6 >= r1) goto L8;
        int r7 = r6 * r0;
        int r8 = 0;
    L5:
        if (r8 >= r0) goto L7;
        r2[r7 + r8] = ((r3[(r8 << 1) + r4] & 255) * 65793) | (-16777216);
        r8 = r8 + 1;
        goto L5
    L7:
        r4 = r4 + (this.dataWidth << 1);
        r6 = r6 + 1;
        goto L3
    L8:
        return r2;
    }

    public int getThumbnailWidth() {
        return getWidth() / 2;
    }

    public int getThumbnailHeight() {
        return getHeight() / 2;
    }

    private void reverseHorizontal(int r9, int r10) {
        byte[] r0 = this.yuvData;
        int r1 = (this.top * this.dataWidth) + this.left;
        int r2 = 0;
    L3:
        if (r2 >= r10) goto L8;
        int r3 = (r9 / 2) + r1;
        int r4 = (r1 + r9) - 1;
        int r5 = r1;
    L5:
        if (r5 >= r3) goto L7;
        byte r6 = r0[r5];
        r0[r5] = r0[r4];
        r0[r4] = r6;
        r5 = r5 + 1;
        r4 = r4 - 1;
        goto L5
    L7:
        r2 = r2 + 1;
        r1 = r1 + this.dataWidth;
        goto L3
    }
}
