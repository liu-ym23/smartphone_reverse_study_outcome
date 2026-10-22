package tmsdkobf;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public class yj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f646a;
    public final /* synthetic */ yk b;

    public yj(yk r1, int r2) {
        this.b = r1;
        this.f646a = r2;
    }

    @Override // java.lang.Runnable
    public void run() {
        monitor-enter(mh.class);
        Context r1 = mh.f353a;     // Catch: Throwable -> L21
        monitor-exit(mh.class);
        if (ia.b(r1) == true) goto L9;
        return;
    L9:
        int r0 = 0;
    L10:
        String[] r2 = this.b.f647a;
        if (r0 >= r2.length) goto L30;
        i.a r3 = new i.a(r2[r0]);     // Catch: Throwable -> L19
        int r4 = this.f646a;     // Catch: Throwable -> L19
        if (r4 <= 0) goto L15;
        r3.d = r4;     // Catch: Throwable -> L19
    L15:
        if (r4 <= 0) goto L17;
        r3.e = r4;     // Catch: Throwable -> L19
    L17:
        i r5 = new i(r3);     // Catch: Throwable -> L19
        xi.a(r5, r5.b, r5.d);     // Catch: Throwable -> L19
        this.b.getClass();     // Catch: Throwable -> L19
        return;
    L19:
        r0 = r0 + 1;
        goto L10
    L30:
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
