package com.tencent.wcdb.database;

import com.tencent.wcdb.CursorWindowAllocationException;

/* JADX INFO: loaded from: classes5.dex */
public class ChunkedCursorWindow extends SQLiteClosable {
    public static final long CHUNK_NOT_FOUND = -1;
    private int mNumColumns;
    long mWindowPtr;

    private static native void nativeClear(long r0);

    private static native long nativeCreate(int r0);

    private static native void nativeDispose(long r0);

    private static native void nativeEndRow(long r0, long r2);

    private static native byte[] nativeGetBlob(long r0, int r2);

    private static native double nativeGetDouble(long r0, int r2);

    private static native long nativeGetLong(long r0, int r2);

    private static native int nativeGetNumChunks(long r0);

    private static native long nativeGetRow(long r0, int r2);

    private static native String nativeGetString(long r0, int r2);

    private static native int nativeGetType(long r0, int r2);

    private static native long nativeRemoveChunk(long r0, int r2);

    private static native boolean nativeSetNumColumns(long r0, int r2);

    public ChunkedCursorWindow(int r3) {
        this.mNumColumns = 0;
        long r0 = nativeCreate(r3);
        this.mWindowPtr = r0;
        if (r0 == 0) goto L6;
        return;
    L6:
        throw new CursorWindowAllocationException("Cursor window allocation failed.");
    }

    private void dispose() {
        long r0 = this.mWindowPtr;
        if (r0 == 0) goto L6;
        nativeDispose(r0);
        this.mWindowPtr = 0;
        return;
    }

    protected void finalize() throws Throwable {
        dispose();     // Catch: Throwable -> L5
        super.finalize();
        return;
    L5:
        th = move-exception;
        super.finalize();
        throw th;
    }

    @Override // com.tencent.wcdb.database.SQLiteClosable
    protected void onAllReferencesReleased() {
        dispose();
    }

    public void clear() {
        acquireReference();
        nativeClear(this.mWindowPtr);     // Catch: Throwable -> L6
        releaseReference();
        return;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public long removeChunk(int r3) {
        acquireReference();
        long r0 = nativeRemoveChunk(this.mWindowPtr, r3);     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public int getNumChunks() {
        acquireReference();
        int r0 = nativeGetNumChunks(this.mWindowPtr);     // Catch: Throwable -> L6
        releaseReference();
        return r0;
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public int getNumColumns() {
        return this.mNumColumns;
    }

    public boolean setNumColumns(int r3) {
        acquireReference();
        boolean r0 = nativeSetNumColumns(this.mWindowPtr, r3);     // Catch: Throwable -> L8
        if (r0 == false) goto L6;
        this.mNumColumns = r3;     // Catch: Throwable -> L8
    L6:
        releaseReference();
        return r0;
    L8:
        th = move-exception;
        releaseReference();
        throw th;
    }

    long getRowUnsafe(int r5) {
        acquireReference();
        long r0 = nativeGetRow(this.mWindowPtr, r5);
        if (r0 != 0) goto L5;
        releaseReference();
    L5:
        return r0;
    }

    void endRowUnsafe(long r3) {
        if (r3 != 0) goto L5;
        return;
    L5:
        nativeEndRow(this.mWindowPtr, r3);
        releaseReference();
    }

    int getTypeUnsafe(long r1, int r3) {
        return nativeGetType(r1, r3);
    }

    byte[] getBlobUnsafe(long r1, int r3) {
        return nativeGetBlob(r1, r3);
    }

    String getStringUnsafe(long r1, int r3) {
        return nativeGetString(r1, r3);
    }

    long getLongUnsafe(long r1, int r3) {
        return nativeGetLong(r1, r3);
    }

    double getDoubleUnsafe(long r1, int r3) {
        return nativeGetDouble(r1, r3);
    }

    public int getType(int r5, int r6) {
        long r0 = getRowUnsafe(r5);
        if (r0 == 0) goto L11;
        int r7 = nativeGetType(r0, r6);     // Catch: Throwable -> L7
        endRowUnsafe(r0);
        return r7;
    L7:
        th = move-exception;
        endRowUnsafe(r0);
        throw th;
    L11:
        throw new IllegalStateException("Couldn't read row " + r5 + ", column " + r6 + " from ChunkedCursorWindow.");
    }

    public byte[] getBlob(int r5, int r6) {
        long r0 = getRowUnsafe(r5);
        if (r0 == 0) goto L11;
        byte[] r7 = nativeGetBlob(r0, r6);     // Catch: Throwable -> L7
        endRowUnsafe(r0);
        return r7;
    L7:
        th = move-exception;
        endRowUnsafe(r0);
        throw th;
    L11:
        throw new IllegalStateException("Couldn't read row " + r5 + ", column " + r6 + " from ChunkedCursorWindow.");
    }

    public String getString(int r5, int r6) {
        long r0 = getRowUnsafe(r5);
        if (r0 == 0) goto L11;
        String r7 = nativeGetString(r0, r6);     // Catch: Throwable -> L7
        endRowUnsafe(r0);
        return r7;
    L7:
        th = move-exception;
        endRowUnsafe(r0);
        throw th;
    L11:
        throw new IllegalStateException("Couldn't read row " + r5 + ", column " + r6 + " from ChunkedCursorWindow.");
    }

    public long getLong(int r5, int r6) {
        long r0 = getRowUnsafe(r5);
        if (r0 == 0) goto L11;
        long r7 = nativeGetLong(r0, r6);     // Catch: Throwable -> L7
        endRowUnsafe(r0);
        return r7;
    L7:
        th = move-exception;
        endRowUnsafe(r0);
        throw th;
    L11:
        throw new IllegalStateException("Couldn't read row " + r5 + ", column " + r6 + " from ChunkedCursorWindow.");
    }

    public double getDouble(int r5, int r6) {
        long r0 = getRowUnsafe(r5);
        if (r0 == 0) goto L11;
        double r7 = nativeGetDouble(r0, r6);     // Catch: Throwable -> L7
        endRowUnsafe(r0);
        return r7;
    L7:
        th = move-exception;
        endRowUnsafe(r0);
        throw th;
    L11:
        throw new IllegalStateException("Couldn't read row " + r5 + ", column " + r6 + " from ChunkedCursorWindow.");
    }
}
