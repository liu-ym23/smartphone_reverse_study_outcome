package d.c.c.g;

import d.c.c.d.n;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends OutputStream {
    public k() {
    }

    public abstract h a();

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        n.a(e);
        throw null;
    }

    public abstract int size();
}
