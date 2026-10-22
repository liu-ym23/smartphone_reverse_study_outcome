package com.bumptech.glide.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class ContentLengthInputStream extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    public static InputStream obtain(InputStream r2, String r3) {
        return obtain(r2, parseContentLength(r3));
    }

    public static InputStream obtain(InputStream r1, long r2) {
        return new ContentLengthInputStream(r1, r2);
    }

    private static int parseContentLength(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L12;
    L10:
        return -1;
    L12:
        return Integer.parseInt(r4);
    L6:
        e = move-exception;
        if (Log.isLoggable(TAG, 3) == false) goto L10;
        Log.d(TAG, "failed to parse content length header: " + r4, e);
        goto L10
    }

    private ContentLengthInputStream(InputStream r1, long r2) {
        super(r1);
        this.contentLength = r2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        monitor-enter(this);
        int r0 = (int) Math.max(this.contentLength - ((long) this.readSoFar), this.in.available());
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        monitor-enter(this);
        int r0 = super.read();     // Catch: Throwable -> L10
        if (r0 < 0) goto L6;
        int r1 = 1;
    L7:
        checkReadSoFarOrThrow(r1);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L6:
        r1 = -1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3) throws IOException {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r1, int r2, int r3) throws IOException {
        monitor-enter(this);
        int r4 = checkReadSoFarOrThrow(super.read(r1, r2, r3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    private int checkReadSoFarOrThrow(int r5) throws IOException {
        if (r5 < 0) goto L5;
        this.readSoFar += r5;
    L6:
        return r5;
    L5:
        if ((this.contentLength - ((long) this.readSoFar)) <= 0) goto L6;
        throw new IOException("Failed to read all expected data, expected: " + this.contentLength + ", but read: " + this.readSoFar);
    }
}
