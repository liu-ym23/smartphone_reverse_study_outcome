package k;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class t implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f18299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z f18301h;

    public static final class a extends InputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ t f18302f;

        a(t r1) {
            this.f18302f = r1;
        }

        @Override // java.io.InputStream
        public int available() {
            t r4 = this.f18302f;
            if (r4.f18300g == true) goto L7;
            return (int) Math.min(r4.f18299f.k0(), Integer.MAX_VALUE);
        L7:
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f18302f.close();
        }

        @Override // java.io.InputStream
        public int read() {
            t r0 = this.f18302f;
            if (r0.f18300g == true) goto L13;
            if (r0.f18299f.k0() != 0) goto L11;
            t r1 = this.f18302f;
            if (r1.f18301h.Z(r1.f18299f, 8192) != (-1)) goto L11;
            return -1;
        L11:
            return this.f18302f.f18299f.readByte() & 255;
        L13:
            throw new IOException("closed");
        }

        @Override // java.io.InputStream
        public int read(byte[] r8, int r9, int r10) {
            kotlin.n0.d.o.g(r8, "data");
            if (this.f18302f.f18300g == true) goto L13;
            c.b(r8.length, r9, r10);
            if (this.f18302f.f18299f.k0() != 0) goto L11;
            t r0 = this.f18302f;
            if (r0.f18301h.Z(r0.f18299f, 8192) != (-1)) goto L11;
            return -1;
        L11:
            return this.f18302f.f18299f.read(r8, r9, r10);
        L13:
            throw new IOException("closed");
        }

        public String toString() {
            return this.f18302f + ".inputStream()";
        }
    }

    public t(z r2) {
        kotlin.n0.d.o.g(r2, "source");
        this.f18301h = r2;
        this.f18299f = new e();
    }

    @Override // k.g
    public String B(long r14) {
        if (r14 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L29;
        if (r14 != LocationRequestCompat.PASSIVE_INTERVAL) goto L10;
        long r5 = Long.MAX_VALUE;
    L11:
        byte r2 = (byte) 10;
        long r7 = b(r2, 0, r5);
        if (r7 == (-1)) goto L15;
        return k.c0.a.b(this.f18299f, r7);
    L15:
        if (r5 < LocationRequestCompat.PASSIVE_INTERVAL) goto L17;
    L26:
        e r6 = new e();
        e r1 = this.f18299f;
        r1.L(r6, 0, Math.min(32, r1.k0()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f18299f.k0(), r14) + " content=" + r6.d0().q() + "…");
    L17:
        if (s(r5) == false) goto L26;
        if (this.f18299f.O(r5 - 1) != ((byte) 13)) goto L26;
        if (s(1 + r5) == false) goto L26;
        if (this.f18299f.O(r5) != r2) goto L26;
        return k.c0.a.b(this.f18299f, r5);
    L10:
        r5 = r14 + 1;
        goto L11
    L29:
        throw new IllegalArgumentException(("limit < 0: " + r14).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // k.g
    public boolean G(long r8, h r10) {
        kotlin.n0.d.o.g(r10, "bytes");
        return g(r8, r10, 0, r10.size());
    }

    @Override // k.g
    public String H(Charset r3) {
        kotlin.n0.d.o.g(r3, "charset");
        this.f18299f.r0(this.f18301h);
        return this.f18299f.H(r3);
    }

    @Override // k.g
    public String P() {
        return B(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // k.g
    public int R() {
        b0(4);
        return this.f18299f.R();
    }

    @Override // k.g
    public byte[] T(long r1) {
        b0(r1);
        return this.f18299f.T(r1);
    }

    @Override // k.z
    public long Z(e r7, long r8) {
        kotlin.n0.d.o.g(r7, "sink");
        if (r8 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L19;
        if ((!this.f18300g) == false) goto L17;
        if (this.f18299f.k0() != 0) goto L15;
        if (this.f18301h.Z(this.f18299f, 8192) != (-1)) goto L15;
        return -1;
    L15:
        return this.f18299f.Z(r7, Math.min(r8, this.f18299f.k0()));
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r8).toString());
    L5:
        r2 = false;
        goto L6
    }

    public long a(byte r7) {
        return b(r7, 0, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // k.g
    public long a0() {
        b0(8);
        return this.f18299f.a0();
    }

    public long b(byte r11, long r12, long r14) {
        boolean r1 = true;
        if ((!this.f18300g) == false) goto L27;
        if (0 <= r12) goto L8;
    L10:
        r1 = false;
    L11:
        if (r1 == false) goto L25;
    L13:
        if (r12 >= r14) goto L34;
        long r0 = this.f18299f.Q(r11, r12, r14);
        if (r0 != (-1)) goto L23;
        long r2 = this.f18299f.k0();
        if (r2 >= r14) goto L32;
        if (this.f18301h.Z(this.f18299f, 8192) == (-1)) goto L33;
        r12 = Math.max(r12, r2);
        goto L13
    L33:
        return -1;
    L32:
        return -1;
    L23:
        return r0;
    L34:
        return -1;
    L25:
        throw new IllegalArgumentException(("fromIndex=" + r12 + " toIndex=" + r14).toString());
    L8:
        if (r14 < r12) goto L10;
    L27:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.g
    public void b0(long r1) {
        if (s(r1) == false) goto L6;
        return;
    L6:
        throw new EOFException();
    }

    @Override // k.g, k.f
    public e c() {
        return this.f18299f;
    }

    @Override // k.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f18300g == true) goto L7;
        this.f18300g = true;
        this.f18301h.close();
        this.f18299f.a();
        return;
    }

    @Override // k.g, k.f
    public e d() {
        return this.f18299f;
    }

    @Override // k.z
    public a0 e() {
        return this.f18301h.e();
    }

    @Override // k.g
    public long f0() {
        b0(1);
        int r0 = 0;
    L3:
        int r1 = r0 + 1;
        if (s(r1) == false) goto L24;
        byte r2 = this.f18299f.O(r0);
        if (r2 < ((byte) 48)) goto L10;
        if (r2 > ((byte) 57)) goto L10;
    L18:
        r0 = r1;
    L10:
        if (r2 < ((byte) 97)) goto L14;
        if (r2 <= ((byte) 102)) goto L18;
    L14:
        if (r2 < ((byte) 65)) goto L19;
        if (r2 <= ((byte) 70)) goto L18;
    L19:
        if (r0 != 0) goto L24;
        StringBuilder r5 = new StringBuilder();
        r5.append("Expected leading [0-9a-fA-F] character but was 0x");
        kotlin.u0.a.a(16);
        kotlin.u0.a.a(16);
        String r3 = Integer.toString(r2, 16);
        kotlin.n0.d.o.b(r3, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r5.append(r3);
        throw new NumberFormatException(r5.toString());
    L24:
        return this.f18299f.f0();
    }

    public boolean g(long r8, h r10, int r11, int r12) {
        kotlin.n0.d.o.g(r10, "bytes");
        if ((!this.f18300g) == false) goto L23;
        if (r8 < 0) goto L21;
        if (r11 < 0) goto L21;
        if (r12 < 0) goto L21;
        if ((r10.size() - r11) < r12) goto L21;
        int r0 = 0;
    L12:
        if (r0 >= r12) goto L27;
        long r3 = ((long) r0) + r8;
        if (s(1 + r3) == false) goto L21;
        if (this.f18299f.O(r3) != r10.l(r11 + r0)) goto L21;
        r0 = r0 + 1;
        goto L12
    L27:
        return true;
    L21:
        return false;
    L23:
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f18300g;
    }

    @Override // k.g
    public InputStream k() {
        return new a(this);
    }

    public short l() {
        b0(2);
        return this.f18299f.g0();
    }

    @Override // k.g
    public String m(long r1) {
        b0(r1);
        return this.f18299f.m(r1);
    }

    @Override // k.g
    public h n(long r1) {
        b0(r1);
        return this.f18299f.n(r1);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r5) {
        kotlin.n0.d.o.g(r5, "sink");
        if (this.f18299f.k0() != 0) goto L9;
        if (this.f18301h.Z(this.f18299f, 8192) != (-1)) goto L9;
        return -1;
    L9:
        return this.f18299f.read(r5);
    }

    @Override // k.g
    public byte readByte() {
        b0(1);
        return this.f18299f.readByte();
    }

    @Override // k.g
    public void readFully(byte[] r7) {
        kotlin.n0.d.o.g(r7, "sink");
        b0(r7.length);     // Catch: EOFException -> L6
        this.f18299f.readFully(r7);
        return;
    L6:
        e = move-exception;
        int r1 = 0;
    L9:
        if (this.f18299f.k0() <= 0) goto L15;
        e r2 = this.f18299f;
        int r3 = r2.read(r7, r1, (int) r2.k0());
        if (r3 == (-1)) goto L14;
        r1 = r1 + r3;
        goto L9
    L14:
        throw new AssertionError();
    L15:
        throw e;
    }

    @Override // k.g
    public int readInt() {
        b0(4);
        return this.f18299f.readInt();
    }

    @Override // k.g
    public long readLong() {
        b0(8);
        return this.f18299f.readLong();
    }

    @Override // k.g
    public short readShort() {
        b0(2);
        return this.f18299f.readShort();
    }

    public boolean s(long r8) {
        if (r8 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L19;
        if ((!this.f18300g) == false) goto L17;
    L10:
        if (this.f18299f.k0() >= r8) goto L15;
        if (this.f18301h.Z(this.f18299f, 8192) != (-1)) goto L10;
        return false;
    L15:
        return true;
    L17:
        throw new IllegalStateException("closed".toString());
    L19:
        throw new IllegalArgumentException(("byteCount < 0: " + r8).toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // k.g
    public void skip(long r5) {
        if ((!this.f18300g) == false) goto L16;
    L5:
        if (r5 <= 0) goto L14;
        if (this.f18299f.k0() != 0) goto L13;
        if (this.f18301h.Z(this.f18299f, 8192) != (-1)) goto L13;
        throw new EOFException();
    L13:
        long r0 = Math.min(r5, this.f18299f.k0());
        this.f18299f.skip(r0);
        r5 = r5 - r0;
        goto L5
    L14:
        return;
    L16:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.g
    public byte[] t() {
        this.f18299f.r0(this.f18301h);
        return this.f18299f.t();
    }

    public String toString() {
        return "buffer(" + this.f18301h + ')';
    }

    @Override // k.g
    public boolean v() {
        if ((!this.f18300g) == false) goto L12;
        if (this.f18299f.v() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f18301h.Z(this.f18299f, 8192) != (-1)) goto L9;
        return true;
    L12:
        throw new IllegalStateException("closed".toString());
    }

    @Override // k.g
    public void y(e r2, long r3) {
        kotlin.n0.d.o.g(r2, "sink");
        b0(r3);     // Catch: EOFException -> L6
        this.f18299f.y(r2, r3);
        return;
    L6:
        e = move-exception;
        r2.r0(this.f18299f);
        throw e;
    }
}
