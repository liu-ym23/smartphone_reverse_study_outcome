package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.client.cache.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class FileResource implements Resource {
    private static final long serialVersionUID = 4132244415919043397L;
    private volatile boolean disposed;
    private final File file;

    public FileResource(File r1) {
        this.file = r1;
        this.disposed = false;
    }

    synchronized File getFile() {
        monitor-enter(this);
        File r0 = this.file;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public synchronized InputStream getInputStream() throws IOException {
        monitor-enter(this);
        FileInputStream r0 = new FileInputStream(this.file);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public synchronized long length() {
        monitor-enter(this);
        long r0 = this.file.length();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public synchronized void dispose() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.disposed == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.disposed = true;     // Catch: Throwable -> L11
        this.file.delete();     // Catch: Throwable -> L11
        monitor-exit(this);
    }
}
