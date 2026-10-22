package com.ttnet.org.chromium.net.urlconnection;

import com.ttnet.org.chromium.base.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: loaded from: classes3.dex */
class CronetInputStreamWithTTBuffer extends CronetInputStream {
    private static final int MAX_LENGTH = 5242880;
    private boolean mReadDone;
    private TTBuffer mTTBuffer;

    CronetInputStreamWithTTBuffer(CronetHttpURLConnection r1) {
        super(r1);
        this.mReadDone = false;
    }

    private void ensureReadFromCronetDone() throws IOException {
        if (this.mReadDone == true) goto L6;
        readAllBytesFromCronet();
        return;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int read() throws IOException {
        ensureReadFromCronetDone();
        if (this.mTTBuffer.size > 0) goto L5;
        return -1;
    L5:
        return this.mTTBuffer.get() & UByte.MAX_VALUE;
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int read(byte[] r2, int r3, int r4) throws IOException {
        ensureReadFromCronetDone();
        if (r2.length != 0) goto L7;
        return 0;
    L7:
        if (this.mTTBuffer.size > 0) goto L9;
        return -1;
    L9:
        return this.mTTBuffer.readToByteArray(r2, r3, r4);
    }

    @Override // com.ttnet.org.chromium.net.urlconnection.CronetInputStream, java.io.InputStream
    public int available() throws IOException {
        ensureReadFromCronetDone();
        if (this.mTTBuffer.size != 0) goto L10;
        if (this.mException != null) goto L7;
        return 0;
    L7:
        this.mTTBuffer.releaseAllSegments();
        throw this.mException;
    L10:
        if (this.mTTBuffer.size > 0) goto L12;
        return 0;
    L12:
        return this.mTTBuffer.size;
    }

    private void readAllBytesFromCronet() throws IOException {
        if (this.mReadDone == false) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("TTBuffer", "calling ensureReadFromCronetDone");
    L8:
        this.mTTBuffer = new TTBuffer();
    L9:
        Segment r0 = this.mTTBuffer.getWritableSegment();
        ByteBuffer r2 = r0.getInnerBuffer();
        if (Logger.debug() == false) goto L12;
        Logger.d("TTBuffer", "getMoreData");
    L12:
        int r3 = r2.position();
        this.mHttpURLConnection.getMoreData(r2);
        if (this.mException != null) goto L40;
        int r4 = r2.position() - r3;
        if (r4 == 0) goto L16;
        this.mTTBuffer.size += r4;
        if (this.mTTBuffer.size > MAX_LENGTH) goto L38;
        if (r0.isWritable() == true) goto L32;
        if (Logger.debug() == false) goto L37;
        Logger.d("TTBuffer", "new data but full, will use new segment next " + this.mTTBuffer.size);
    L37:
        r0.completeRead();
        goto L9
    L32:
        if (Logger.debug() == false) goto L9;
        Logger.d("TTBuffer", "new data, continue read with this segment " + this.mTTBuffer.size + " remaining: " + r2.remaining());
        goto L9
    L38:
        this.mTTBuffer.releaseAllSegments();
        throw new IOException("Download too large " + this.mTTBuffer.size + " 5242880");
    L16:
        if (r3 != 0) goto L22;
        if (Logger.debug() == false) goto L20;
        Logger.d("TTBuffer", "no new data, release empty segment " + this.mTTBuffer.size);
    L20:
        r0.release();
    L25:
        this.mReadDone = true;
        return;
    L22:
        if (Logger.debug() == false) goto L24;
        Logger.d("TTBuffer", "no new data, save this segment " + this.mTTBuffer.size);
    L24:
        r0.completeRead();
        goto L25
    L40:
        this.mTTBuffer.releaseAllSegments();
        throw this.mException;
    }
}
