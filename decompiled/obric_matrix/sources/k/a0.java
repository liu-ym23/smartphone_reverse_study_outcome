package k;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a0 f18238d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f18239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f18240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f18241c;

    public static final class a extends a0 {
        a() {
        }

        @Override // k.a0
        public a0 d(long r1) {
            return this;
        }

        @Override // k.a0
        public void f() {
        }

        @Override // k.a0
        public a0 g(long r1, TimeUnit r3) {
            kotlin.n0.d.o.g(r3, "unit");
            return this;
        }
    }

    static {
        f18238d = new a();
    }

    public a0() {
    }

    public a0 a() {
        this.f18239a = false;
        return this;
    }

    public a0 b() {
        this.f18241c = 0;
        return this;
    }

    public long c() {
        if (this.f18239a == false) goto L7;
        return this.f18240b;
    L7:
        throw new IllegalStateException("No deadline".toString());
    }

    public a0 d(long r2) {
        this.f18239a = true;
        this.f18240b = r2;
        return this;
    }

    public boolean e() {
        return this.f18239a;
    }

    public void f() {
        if (Thread.interrupted() == false) goto L5;
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    L5:
        if (this.f18239a == true) goto L7;
        return;
    L7:
        if ((this.f18240b - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw new InterruptedIOException("deadline reached");
    }

    public a0 g(long r3, TimeUnit r5) {
        kotlin.n0.d.o.g(r5, "unit");
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        this.f18241c = r5.toNanos(r3);
        return this;
    L10:
        throw new IllegalArgumentException(("timeout < 0: " + r3).toString());
    L5:
        r0 = false;
        goto L6
    }

    public long h() {
        return this.f18241c;
    }
}
