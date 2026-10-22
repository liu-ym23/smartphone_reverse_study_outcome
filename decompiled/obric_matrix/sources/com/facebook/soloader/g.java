package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FileOutputStream f6825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FileLock f6826g;

    private g(File r2) {
        FileOutputStream r0 = new FileOutputStream(r2);
        this.f6825f = r0;
        FileLock r3 = r0.getChannel().lock();     // Catch: Throwable -> L8
        if (r3 != null) goto L6;
        r0.close();
    L6:
        this.f6826g = r3;
        return;
    L8:
        th = move-exception;
        this.f6825f.close();
        throw th;
    }

    public static g a(File r1) {
        return new g(r1);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        FileLock r0 = this.f6826g;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.release();     // Catch: Throwable -> L7
    L5:
        this.f6825f.close();
        return;
    L7:
        th = move-exception;
        this.f6825f.close();
        throw th;
    }
}
