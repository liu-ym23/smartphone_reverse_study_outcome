package p000j;

import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;
import k.e;
import k.g;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g0 implements Closeable {

    static class a extends g0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y f17754f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f17755g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ g f17756h;

        a(y r1, long r2, g r4) {
            this.f17754f = r1;
            this.f17755g = r2;
            this.f17756h = r4;
        }

        @Override // p000j.g0
        public g A() {
            return this.f17756h;
        }

        @Override // p000j.g0
        public long g() {
            return this.f17755g;
        }

        @Override // p000j.g0
        public y l() {
            return this.f17754f;
        }
    }

    public g0() {
    }

    private Charset b() {
        y r1 = l();
        if (r1 == null) goto L6;
        return r1.b(c.f17800i);
    L6:
        return c.f17800i;
    }

    public static g0 s(y r1, long r2, g r4) {
        Objects.requireNonNull(r4, "source == null");
        return new a(r1, r2, r4);
    }

    public static g0 x(y r3, byte[] r4) {
        e r0 = new e();
        r0.p0(r4);
        return s(r3, r4.length, r0);
    }

    public abstract g A();

    public final String C() {
        g r0 = A();
        String r1 = r0.H(c.c(r0, b()));     // Catch: Throwable -> L6
        c.g(r0);
        return r1;
    L6:
        th = move-exception;
        c.g(r0);
        throw th;
    }

    public final InputStream a() {
        return A().k();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c.g(A());
    }

    public abstract long g();

    public abstract y l();
}
