package com.loc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class d5 {
    static final Charset o = null;
    static final /* synthetic */ boolean p = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ByteBuffer f7248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f7249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f7250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int[] f7251d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f7252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f7253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f7254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f7255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int[] f7256i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f7257j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f7258k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f7259l;
    CharsetEncoder m;
    ByteBuffer n;

    static {
        o = Charset.forName("UTF-8");
    }

    public d5(ByteBuffer r3) {
        this.f7250c = 1;
        this.f7251d = null;
        this.f7252e = 0;
        this.f7253f = false;
        this.f7254g = false;
        this.f7256i = new int[16];
        this.f7257j = 0;
        this.f7258k = 0;
        this.f7259l = false;
        this.m = o.newEncoder();
        c(r3);
    }

    private int A() {
        return this.f7248a.capacity() - this.f7249b;
    }

    private static ByteBuffer B(int r1) {
        ByteBuffer r2 = ByteBuffer.allocate(r1);
        r2.order(ByteOrder.LITTLE_ENDIAN);
        return r2;
    }

    private byte[] C(int r2, int r3) {
        D();
        byte[] r4 = new byte[r3];
        this.f7248a.position(r2);
        this.f7248a.get(r4);
        return r4;
    }

    private void D() {
        if (this.f7254g == false) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    private void E(int r5) {
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        ByteBuffer r2 = this.f7248a;
        int r3 = this.f7249b - 1;
        this.f7249b = r3;
        r2.put(r3, (byte) 0);
        r1 = r1 + 1;
        goto L3
    }

    private void F() {
        if (this.f7253f == true) goto L6;
        return;
    L6:
        throw new AssertionError("FlatBuffers: object serialization must not be nested.");
    }

    private void G(int r3) {
        ByteBuffer r0 = this.f7248a;
        int r1 = this.f7249b - 4;
        this.f7249b = r1;
        r0.putInt(r1, r3);
    }

    private void H(int r3) {
        x(4, 0);
        G(r3);
    }

    private void I(int r2) {
        this.f7251d[r2] = A();
    }

    private void k(long r3) {
        ByteBuffer r0 = this.f7248a;
        int r1 = this.f7249b - 8;
        this.f7249b = r1;
        r0.putLong(r1, r3);
    }

    private void l(short r3) {
        ByteBuffer r0 = this.f7248a;
        int r1 = this.f7249b - 2;
        this.f7249b = r1;
        r0.putShort(r1, r3);
    }

    private static ByteBuffer o(ByteBuffer r3) {
        int r0 = r3.capacity();
        if (((-1073741824) & r0) != 0) goto L7;
        int r1 = r0 << 1;
        r3.position(0);
        ByteBuffer r2 = B(r1);
        r2.position(r1 - r0);
        r2.put(r3);
        return r2;
    L7:
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    private void p(byte r3) {
        ByteBuffer r0 = this.f7248a;
        int r1 = this.f7249b - 1;
        this.f7249b = r1;
        r0.put(r1, r3);
    }

    private void s(long r3) {
        x(8, 0);
        k(r3);
    }

    private void t(short r3) {
        x(2, 0);
        l(r3);
    }

    private void u(boolean r3) {
        ByteBuffer r0 = this.f7248a;
        int r1 = this.f7249b - 1;
        this.f7249b = r1;
        r0.put(r1, r3 ? 1 : 0);
    }

    private int v(ByteBuffer r4) {
        int r0 = r4.remaining();
        d((byte) 0);
        h(1, r0, 1);
        ByteBuffer r1 = this.f7248a;
        int r2 = this.f7249b - r0;
        this.f7249b = r2;
        r1.position(r2);
        this.f7248a.put(r4);
        return a();
    }

    private void x(int r5, int r6) {
        if (r5 <= this.f7250c) goto L5;
        this.f7250c = r5;
    L5:
        int r0 = ((~((this.f7248a.capacity() - this.f7249b) + r6)) + 1) & (r5 - 1);
    L7:
        if (this.f7249b >= ((r0 + r5) + r6)) goto L9;
        int r1 = this.f7248a.capacity();
        ByteBuffer r2 = o(this.f7248a);
        this.f7248a = r2;
        this.f7249b += r2.capacity() - r1;
        goto L7
    L9:
        E(r0);
    }

    private void y(boolean r3) {
        x(1, 0);
        u(r3);
    }

    public final int a() {
        if (this.f7253f == false) goto L7;
        this.f7253f = false;
        G(this.f7258k);
        return A();
    L7:
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public int b(CharSequence r4) {
        int r0 = (int) (r4.length() * this.m.maxBytesPerChar());
        ByteBuffer r1 = this.n;
        if (r1 != null) goto L5;
    L6:
        this.n = ByteBuffer.allocate(Math.max(128, r0));
    L7:
        this.n.clear();
        if ((r4 instanceof CharBuffer) == false) goto L10;
        CharBuffer r5 = (CharBuffer) r4;
    L11:
        CoderResult r6 = this.m.encode(r5, this.n, true);
        if (r6.isError() == true) goto L20;
    L18:
        this.n.flip();
        return v(this.n);
    L20:
        r6.throwException();     // Catch: CharacterCodingException -> L15
    L15:
        e = move-exception;
        throw new Error(e);
    L10:
        r5 = CharBuffer.wrap(r4);
        goto L11
    L5:
        if (r1.capacity() >= r0) goto L7;
        goto L6
    }

    public final d5 c(ByteBuffer r2) {
        this.f7248a = r2;
        r2.clear();
        this.f7248a.order(ByteOrder.LITTLE_ENDIAN);
        this.f7250c = 1;
        this.f7249b = this.f7248a.capacity();
        this.f7252e = 0;
        this.f7253f = false;
        this.f7254g = false;
        this.f7255h = 0;
        this.f7257j = 0;
        this.f7258k = 0;
        return this;
    }

    public final void d(byte r3) {
        x(1, 0);
        p(r3);
    }

    public final void e(int r3) {
        x(4, 0);
        if (p == false) goto L5;
    L9:
        G((A() - r3) + 4);
        return;
    L5:
        if (r3 <= A()) goto L9;
        throw new AssertionError();
    }

    public final void f(int r2, byte r3) {
        if (this.f7259l == true) goto L5;
        if (r3 != 0) goto L5;
        return;
    L5:
        d(r3);
        I(r2);
    }

    public final void g(int r2, int r3) {
        if (this.f7259l == true) goto L5;
        if (r3 != 0) goto L5;
        return;
    L5:
        H(r3);
        I(r2);
    }

    public final void h(int r1, int r2, int r3) {
        F();
        this.f7258k = r2;
        int r4 = r1 * r2;
        x(4, r4);
        x(r3, r4);
        this.f7253f = true;
    }

    public final void i(int r3, long r4) {
        if (this.f7259l == false) goto L5;
    L6:
        s(r4);
        I(r3);
        return;
    L5:
        if (r4 != 0) goto L6;
    }

    public final void j(int r2, short r3) {
        if (this.f7259l == true) goto L5;
        if (r3 != 0) goto L5;
        return;
    L5:
        t(r3);
        I(r2);
    }

    public final void m(boolean r2) {
        if (this.f7259l == true) goto L5;
        if (r2 == true) goto L5;
        return;
    L5:
        y(r2);
        I(0);
    }

    public final int n() {
        if (this.f7251d == null) goto L35;
        if (this.f7253f == false) goto L35;
        H(0);
        int r1 = A();
        int r2 = this.f7252e - 1;
    L7:
        if (r2 < 0) goto L13;
        int[] r3 = this.f7251d;
        if (r3[r2] == 0) goto L11;
        int r4 = r1 - r3[r2];
    L12:
        t((short) r4);
        r2 = r2 - 1;
        goto L7
    L11:
        r4 = 0;
        goto L12
    L13:
        t((short) (r1 - this.f7255h));
        t((short) ((this.f7252e + 2) * 2));
        int r5 = 0;
    L15:
        if (r5 >= this.f7257j) goto L25;
        int r6 = this.f7248a.capacity() - this.f7256i[r5];
        int r7 = this.f7249b;
        short r8 = this.f7248a.getShort(r6);
        if (r8 != this.f7248a.getShort(r7)) goto L24;
        int r9 = 2;
    L19:
        if (r9 >= r8) goto L23;
        if (this.f7248a.getShort(r6 + r9) != this.f7248a.getShort(r7 + r9)) goto L24;
        r9 = r9 + 2;
        goto L19
    L23:
        int r10 = this.f7256i[r5];
    L26:
        if (r10 == 0) goto L28;
        int r11 = this.f7248a.capacity() - r1;
        this.f7249b = r11;
        this.f7248a.putInt(r11, r10 - r1);
    L32:
        this.f7253f = false;
        return r1;
    L28:
        int r12 = this.f7257j;
        int[] r13 = this.f7256i;
        if (r12 != r13.length) goto L31;
        this.f7256i = Arrays.copyOf(r13, r12 * 2);
    L31:
        int[] r14 = this.f7256i;
        int r15 = this.f7257j;
        this.f7257j = r15 + 1;
        r14[r15] = A();
        ByteBuffer r16 = this.f7248a;
        r16.putInt(r16.capacity() - r1, A() - r1);
    L24:
        r5 = r5 + 1;
        goto L15
    L25:
        r10 = 0;
    L35:
        throw new AssertionError("FlatBuffers: endObject called without startObject");
    }

    public final void q(int r3) {
        F();
        int[] r0 = this.f7251d;
        if (r0 != null) goto L5;
    L6:
        this.f7251d = new int[r3];
    L7:
        this.f7252e = r3;
        Arrays.fill(this.f7251d, 0, r3, 0);
        this.f7253f = true;
        this.f7255h = A();
        return;
    L5:
        if (r0.length >= r3) goto L7;
        goto L6
    }

    public final void r(int r2, int r3) {
        if (this.f7259l == true) goto L5;
        if (r3 != 0) goto L5;
        return;
    L5:
        e(r3);
        I(r2);
    }

    public final void w(int r3) {
        x(this.f7250c, 4);
        e(r3);
        this.f7248a.position(this.f7249b);
        this.f7254g = true;
    }

    public final byte[] z() {
        return C(this.f7249b, this.f7248a.capacity() - this.f7249b);
    }
}
