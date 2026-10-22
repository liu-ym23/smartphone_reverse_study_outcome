package k;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f18295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x f18297h;

    public static final class a extends OutputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ s f18298f;

        a(s r1) {
            this.f18298f = r1;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f18298f.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            s r1 = this.f18298f;
            if (r1.f18296g == true) goto L6;
            r1.flush();
            return;
        }

        public String toString() {
            return this.f18298f + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int r3) {
            s r0 = this.f18298f;
            if (r0.f18296g == true) goto L7;
            r0.f18295f.s0((byte) r3);
            this.f18298f.z();
            return;
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.OutputStream
        public void write(byte[] r3, int r4, int r5) {
            kotlin.n0.d.o.g(r3, "data");
            s r0 = this.f18298f;
            if (r0.f18296g == true) goto L7;
            r0.f18295f.q0(r3, r4, r5);
            this.f18298f.z();
            return;
        L7:
            throw new IOException("closed");
        }
    }

    public s(x r2) {
        kotlin.n0.d.o.g(r2, "sink");
        this.f18297h = r2;
        this.f18295f = new e();
    }

    @Override // k.f
    public f D(String r2) {
        kotlin.n0.d.o.g(r2, TypedValues.Custom.S_STRING);
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.B0(r2);
        z();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.f
    public f I(byte[] r2, int r3, int r4) {
        kotlin.n0.d.o.g(r2, "source");
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.q0(r2, r3, r4);
        z();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.x
    public void J(e r2, long r3) {
        kotlin.n0.d.o.g(r2, "source");
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.J(r2, r3);
        z();
        return;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.f
    public f K(long r2) {
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.u0(r2);
        return z();
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.f
    public f U(byte[] r2) {
        kotlin.n0.d.o.g(r2, "source");
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.p0(r2);
        z();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.f
    public f W(h r2) {
        kotlin.n0.d.o.g(r2, "byteString");
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.o0(r2);
        z();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.f
    public e c() {
        return this.f18295f;
    }

    @Override // k.f
    public f c0(long r2) {
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.t0(r2);
        z();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f18296g == true) goto L24;
        Throwable th = null;
    L10:
        th = th;
    L20:
        this.f18297h.close();     // Catch: Throwable -> L13
    L16:
        this.f18296g = true;
        if (th != null) goto L19;
        return;
    L19:
        throw th;
    L13:
        th = move-exception;
        if (th != null) goto L16;
        th = th;
        goto L16
    L7:
        if (this.f18295f.k0() <= 0) goto L20;
        x r1 = this.f18297h;     // Catch: Throwable -> L10
        e r2 = this.f18295f;     // Catch: Throwable -> L10
        r1.J(r2, r2.k0());     // Catch: Throwable -> L10
        goto L20
    }

    @Override // k.f
    public e d() {
        return this.f18295f;
    }

    @Override // k.x
    public a0 e() {
        return this.f18297h.e();
    }

    @Override // k.f
    public OutputStream e0() {
        return new a(this);
    }

    @Override // k.f, k.x, java.io.Flushable
    public void flush() {
        if ((!this.f18296g) == false) goto L10;
        if (this.f18295f.k0() <= 0) goto L7;
        x r0 = this.f18297h;
        e r1 = this.f18295f;
        r0.J(r1, r1.k0());
    L7:
        this.f18297h.flush();
        return;
    L10:
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f18296g;
    }

    @Override // k.f
    public f o() {
        if ((!this.f18296g) == false) goto L9;
        long r0 = this.f18295f.k0();
        if (r0 <= 0) goto L7;
        this.f18297h.J(this.f18295f, r0);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.f
    public f p(int r2) {
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.z0(r2);
        z();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.f
    public f q(int r2) {
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.v0(r2);
        z();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.f
    public f r(long r2) {
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.y0(r2);
        z();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    public String toString() {
        return "buffer(" + this.f18297h + ')';
    }

    @Override // k.f
    public f u(int r2) {
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.w0(r2);
        z();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.f
    public f w(int r2) {
        if ((!this.f18296g) == false) goto L7;
        this.f18295f.s0(r2);
        z();
        return this;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer r2) {
        kotlin.n0.d.o.g(r2, "source");
        if ((!this.f18296g) == false) goto L7;
        int r3 = this.f18295f.write(r2);
        z();
        return r3;
    L7:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.f
    public f z() {
        if ((!this.f18296g) == false) goto L9;
        long r0 = this.f18295f.E();
        if (r0 <= 0) goto L7;
        this.f18297h.J(this.f18295f, r0);
    L7:
        return this;
    L9:
        throw new IllegalStateException("closed".toString());
    }
}
