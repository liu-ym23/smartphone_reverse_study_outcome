package tmsdkobf;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class h4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f237a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ b5 d;

    public h4(b5 r1, Context r2, boolean r3, int r4) {
        this.d = r1;
        this.f237a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // java.lang.Runnable
    public void run() {
        b5 r0 = this.d;
        Context r1 = this.f237a;
        boolean r2 = this.b;
        int r8 = this.c;
        r0.d.getClass();
        String r3 = d5.b(r1, "403");
        if (TextUtils.isEmpty(r3) == true) goto L8;
        boolean r4 = Boolean.valueOf(r3).booleanValue();     // Catch: Throwable -> L29
    L9:
        int r5 = 0;
    L11:
        if (r5 >= r0.f111a.x) goto L19;
        w3 r6 = r0.a(r1, r2, r4, r8);
        r0.a(r6, true);
        int r7 = r6.c;
        if (r7 == 0) goto L19;
        if (r7 == (-30014)) goto L19;
        r5 = r5 + 1;
    L19:
        if (r4 == false) goto L21;
        d5 r9 = r0.d;
        r9.getClass();
        r9.a(r1, "403", "false", true);
    L21:
        AtomicReference r10 = r0.g;
        monitor-enter(r10);
        r0.g.set(Boolean.FALSE);     // Catch: Throwable -> L26
        r0.g.notifyAll();     // Catch: Throwable -> L26
        monitor-exit(r10);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L8:
        r4 = true;
        goto L9
    }
}
