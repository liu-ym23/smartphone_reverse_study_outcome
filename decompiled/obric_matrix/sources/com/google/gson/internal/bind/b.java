package com.google.gson.internal.bind;

import com.google.gson.a0.c;
import com.google.gson.g;
import com.google.gson.j;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.p;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {
    private static final Writer u = null;
    private static final p v = null;
    private final List<j> r;
    private String s;
    private j t;

    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] r1, int r2, int r3) {
            throw new AssertionError();
        }
    }

    static {
        u = new a();
        v = new p("closed");
    }

    public b() {
        super(u);
        this.r = new ArrayList();
        this.t = l.f7093a;
    }

    private j r0() {
        List<j> r1 = this.r;
        return r1.get(r1.size() - 1);
    }

    private void s0(j r3) {
        if (this.s == null) goto L11;
        if (r3.n() == true) goto L7;
    L8:
        ((m) r0()).q(this.s, r3);
    L9:
        this.s = null;
        return;
    L7:
        if (C() == false) goto L9;
    L11:
        if (this.r.isEmpty() == false) goto L13;
        this.t = r3;
        return;
    L13:
        j r2 = r0();
        if ((r2 instanceof g) == false) goto L18;
        ((g) r2).q(r3);
        return;
    L18:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.a0.c
    public c A() {
        if (this.r.isEmpty() == true) goto L13;
        if (this.s != null) goto L13;
        if ((r0() instanceof m) == false) goto L11;
        List<j> r0 = this.r;
        r0.remove(r0.size() - 1);
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.a0.c
    public c M(String r2) {
        Objects.requireNonNull(r2, "name == null");
        if (this.r.isEmpty() == true) goto L13;
        if (this.s != null) goto L13;
        if ((r0() instanceof m) == false) goto L11;
        this.s = r2;
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    @Override // com.google.gson.a0.c
    public c O() {
        s0(l.f7093a);
        return this;
    }

    @Override // com.google.gson.a0.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.r.isEmpty() == false) goto L7;
        this.r.add(v);
        return;
    L7:
        throw new IOException("Incomplete document");
    }

    @Override // com.google.gson.a0.c, java.io.Flushable
    public void flush() {
    }

    @Override // com.google.gson.a0.c
    public c g() {
        g r0 = new g();
        s0(r0);
        this.r.add(r0);
        return this;
    }

    @Override // com.google.gson.a0.c
    public c j0(double r3) {
        if (F() == false) goto L5;
    L11:
        s0(new p(Double.valueOf(r3)));
        return this;
    L5:
        if (Double.isNaN(r3) == true) goto L10;
        if (Double.isInfinite(r3) == false) goto L11;
    L10:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r3);
    }

    @Override // com.google.gson.a0.c
    public c k0(long r2) {
        s0(new p(Long.valueOf(r2)));
        return this;
    }

    @Override // com.google.gson.a0.c
    public c l() {
        m r0 = new m();
        s0(r0);
        this.r.add(r0);
        return this;
    }

    @Override // com.google.gson.a0.c
    public c l0(Boolean r2) {
        if (r2 != null) goto L5;
        O();
        return this;
    L5:
        s0(new p(r2));
        return this;
    }

    @Override // com.google.gson.a0.c
    public c m0(Number r4) {
        if (r4 != null) goto L6;
        O();
        return this;
    L6:
        if (F() == true) goto L14;
        double r0 = r4.doubleValue();
        if (Double.isNaN(r0) == true) goto L13;
        if (Double.isInfinite(r0) == false) goto L14;
    L13:
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + r4);
    L14:
        s0(new p(r4));
        return this;
    }

    @Override // com.google.gson.a0.c
    public c n0(String r2) {
        if (r2 != null) goto L5;
        O();
        return this;
    L5:
        s0(new p(r2));
        return this;
    }

    @Override // com.google.gson.a0.c
    public c o0(boolean r2) {
        s0(new p(Boolean.valueOf(r2)));
        return this;
    }

    public j q0() {
        if (this.r.isEmpty() == false) goto L7;
        return this.t;
    L7:
        throw new IllegalStateException("Expected one JSON element but was " + this.r);
    }

    @Override // com.google.gson.a0.c
    public c x() {
        if (this.r.isEmpty() == true) goto L13;
        if (this.s != null) goto L13;
        if ((r0() instanceof g) == false) goto L11;
        List<j> r0 = this.r;
        r0.remove(r0.size() - 1);
        return this;
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }
}
