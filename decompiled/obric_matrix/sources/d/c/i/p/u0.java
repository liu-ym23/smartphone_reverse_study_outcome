package d.c.i.p;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u0<T> extends w0<T> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f16440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f16441l;

    public u0(k<T> r1, n0 r2, String r3, String r4) {
        super(r1, r2, r3, r4);
    }

    public void k() {
        if (this.f16440k <= 0) goto L6;
        this.f16441l = SystemClock.elapsedRealtime() - this.f16440k;
        return;
    }

    public void l() {
        this.f16440k = SystemClock.elapsedRealtime();
    }

    public long m() {
        long r0 = this.f16441l;
        if (r0 <= 0) goto L5;
        return r0;
    L5:
        return 0;
    }
}
