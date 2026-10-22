package tmsdkobf;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class a9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f89a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ Object c;

    public a9(AtomicBoolean r1, AtomicReference r2, Object r3) {
        this.f89a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f89a.get() == false) goto L24;
        return;
    L24:
    L7:
        e = move-exception;
        String r1 = xk.a(xk.E0);
        StackTraceElement[] r0 = e.getStackTrace();
        int r2 = r0.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L15;
        StackTraceElement r4 = r0[r3];
        if (r1.equals(r4.getClassName() + "_" + r4.getMethodName()) == false) goto L13;
        this.b.set(Boolean.TRUE);
    L13:
        r3 = r3 + 1;
        goto L9
    L15:
        monitor-enter(this.c);
        this.c.notify();     // Catch: Throwable -> L19
        return;
    L19:
        th = move-exception;
        throw th;
    L6:
        throw new Exception("");     // Catch: Exception -> L7
    }
}
