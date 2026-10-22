package d.c.c.g;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface h extends Closeable {

    public static class a extends RuntimeException {
        public a() {
            super("Invalid bytebuf. Already closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    byte f(int r1);

    int h(int r1, byte[] r2, int r3, int r4);

    ByteBuffer i();

    boolean isClosed();

    long j();

    int size();
}
