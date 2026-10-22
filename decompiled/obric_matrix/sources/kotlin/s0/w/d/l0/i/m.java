package kotlin.s0.w.d.l0.i;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f20363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g f20364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f20365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile q f20366d;

    protected void a(q r3) {
        if (this.f20366d == null) goto L5;
        return;
    L5:
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.f20366d == null) goto L21;
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L21:
        if (this.f20363a == null) goto L13;
        r3 = r3.h().d(this.f20363a, this.f20364b);     // Catch: IOException -> L19 Throwable -> L16
    L13:
        this.f20366d = r3;     // Catch: IOException -> L19 Throwable -> L16
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
    }

    public int b() {
        if (this.f20365c == false) goto L7;
        return this.f20366d.e();
    L7:
        return this.f20363a.size();
    }

    public q c(q r1) {
        a(r1);
        return this.f20366d;
    }

    public q d(q r2) {
        q r0 = this.f20366d;
        this.f20366d = r2;
        this.f20363a = null;
        this.f20365c = true;
        return r0;
    }
}
