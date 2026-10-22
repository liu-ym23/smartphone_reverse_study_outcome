package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT = null;
    private static final int ORIENTATION_POSITION = 0;
    private static final int SEGMENT_LENGTH = 0;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    static {
        byte[] r0 = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = r0;
        int r1 = r0.length;
        SEGMENT_LENGTH = r1;
        ORIENTATION_POSITION = r1 + 2;
    }

    public ExifOrientationStream(InputStream r2, int r3) {
        super(r2);
        if (r3 < (-1)) goto L9;
        if (r3 > 8) goto L9;
        this.orientation = (byte) r3;
        return;
    L9:
        throw new IllegalArgumentException("Cannot add invalid orientation: " + r3);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int r0 = this.position;
        if (r0 < 2) goto L10;
        int r2 = ORIENTATION_POSITION;
        if (r0 > r2) goto L10;
        if (r0 != r2) goto L9;
        int r1 = this.orientation;
    L12:
        if (r1 == (-1)) goto L14;
        this.position++;
    L14:
        return r1;
    L9:
        r1 = EXIF_SEGMENT[r0 - 2] & UByte.MAX_VALUE;
    L10:
        r1 = super.read();
        goto L12
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r4, int r5, int r6) throws IOException {
        int r0 = this.position;
        int r1 = ORIENTATION_POSITION;
        if (r0 <= r1) goto L5;
        int r7 = super.read(r4, r5, r6);
    L11:
        if (r7 <= 0) goto L13;
        this.position += r7;
    L13:
        return r7;
    L5:
        if (r0 != r1) goto L8;
        r4[r5] = this.orientation;
        r7 = 1;
        goto L11
    L8:
        if (r0 >= 2) goto L10;
        r7 = super.read(r4, r5, 2 - r0);
        goto L11
    L10:
        int r8 = Math.min(r1 - r0, r6);
        System.arraycopy(EXIF_SEGMENT, this.position - 2, r4, r5, r8);
        r7 = r8;
        goto L11
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r3) throws IOException {
        long r4 = super.skip(r3);
        if (r4 <= 0) goto L5;
        this.position = (int) (((long) this.position) + r4);
    L5:
        return r4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}
