package tmsdkobf;

import android.util.Log;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class t4 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f525a;
    public final /* synthetic */ HashMap b;
    public final /* synthetic */ i7 c;
    public final /* synthetic */ Object d;

    public t4(b5 r1, AtomicBoolean r2, HashMap r3, i7 r4, long r5, Object r7) {
        this.f525a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r7;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        if (this.f525a.get() == false) goto L25;
        return;
    L25:
        HashMap r0 = this.b;     // Catch: Throwable -> L16
        String r2 = this.c.c();     // Catch: Throwable -> L16
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.put("274", r2);     // Catch: Throwable -> L16
        HashMap r1 = this.b;     // Catch: Throwable -> L16
        String r3 = this.c.b();     // Catch: Throwable -> L16
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        r1.put("276", r3);     // Catch: Throwable -> L16
        HashMap r4 = this.b;     // Catch: Throwable -> L16
        String r5 = this.c.a();     // Catch: Throwable -> L16
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        r4.put("275", r5);     // Catch: Throwable -> L16
    L17:
        Object r6 = this.d;
        monitor-enter(r6);
        this.d.notify();     // Catch: Throwable -> L22
        monitor-exit(r6);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L16:
        Log.w("Turing", "invoke info impl exception");
        goto L17
    }
}
