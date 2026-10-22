package com.tencent.wcdb.database;

import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SQLiteClosable implements Closeable {
    private int mReferenceCount;

    protected abstract void onAllReferencesReleased();

    public SQLiteClosable() {
        this.mReferenceCount = 1;
    }

    @Deprecated
    protected void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleased();
    }

    public void acquireReference() {
        monitor-enter(this);
        int r1 = this.mReferenceCount;     // Catch: Throwable -> L11
        if (r1 <= 0) goto L10;
        this.mReferenceCount = r1 + 1;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("attempt to re-open an already-closed object: " + this);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void releaseReference() {
        monitor-enter(this);
        boolean r1 = true;
        int r0 = this.mReferenceCount - 1;     // Catch: Throwable -> L11
        this.mReferenceCount = r0;     // Catch: Throwable -> L11
        if (r0 == 0) goto L7;
        r1 = false;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r1 == false) goto L16;
        onAllReferencesReleased();
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public void releaseReferenceFromContainer() {
        monitor-enter(this);
        boolean r1 = true;
        int r0 = this.mReferenceCount - 1;     // Catch: Throwable -> L11
        this.mReferenceCount = r0;     // Catch: Throwable -> L11
        if (r0 == 0) goto L7;
        r1 = false;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r1 == false) goto L16;
        onAllReferencesReleased();
        return;
    L16:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        releaseReference();
    }
}
