package k;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: loaded from: classes2.dex */
public interface x extends Closeable, Flushable {
    void J(e r1, long r2);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    a0 e();

    void flush();
}
