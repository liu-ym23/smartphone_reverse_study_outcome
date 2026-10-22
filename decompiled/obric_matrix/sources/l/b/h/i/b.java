package l.b.h.i;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class b extends OutputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private OutputStream f22303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OutputStream f22304g;

    public b(OutputStream r1, OutputStream r2) {
        this.f22303f = r1;
        this.f22304g = r2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f22303f.close();
        this.f22304g.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f22303f.flush();
        this.f22304g.flush();
    }

    @Override // java.io.OutputStream
    public void write(int r2) {
        this.f22303f.write(r2);
        this.f22304g.write(r2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r2) {
        this.f22303f.write(r2);
        this.f22304g.write(r2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r2, int r3, int r4) {
        this.f22303f.write(r2, r3, r4);
        this.f22304g.write(r2, r3, r4);
    }
}
