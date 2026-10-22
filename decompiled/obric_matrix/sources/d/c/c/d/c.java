package d.c.c.d;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class c extends FilterOutputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f15378f;

    public c(OutputStream r3) {
        super(r3);
        this.f15378f = 0;
    }

    public long a() {
        return this.f15378f;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r5) {
        ((FilterOutputStream) this).out.write(r5);
        this.f15378f++;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r3, int r4, int r5) {
        ((FilterOutputStream) this).out.write(r3, r4, r5);
        this.f15378f += (long) r5;
    }
}
