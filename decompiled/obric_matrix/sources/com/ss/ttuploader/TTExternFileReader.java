package com.ss.ttuploader;

/* JADX INFO: loaded from: classes2.dex */
public interface TTExternFileReader {
    public static final int KeyGetHeaderSize = 1;
    public static final int KeyIsGetFileSize = 0;
    public static final int ReadSliceEnd = 0;
    public static final int ReadSliceError = -1;
    public static final int ReadSliceErrorIsCancel = -2;

    void cancel();

    long getCrc32ByOffset(long r1, int r3);

    long getValue(int r1);

    int readSlice(int r1, byte[] r2, int r3);

    int readSliceByOffset(long r1, byte[] r3, int r4, int r5);
}
