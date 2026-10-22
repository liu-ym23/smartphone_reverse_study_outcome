package d.b.p.a.e.i;

import d.b.p.a.d.h;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.b.p.a.g.e {
    public a() {
    }

    private boolean h(Thread r1, Throwable r2) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        if (r1.getName().equals("FinalizerWatchdogDaemon") == false) goto L9;
        if ((r2 instanceof TimeoutException) == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // d.b.p.a.d.i
    public boolean a(Thread r1, Throwable r2) {
        boolean r3 = h(r1, r2);
        if (r3 == false) goto L5;
        h.c(b(), "Hint FinalizeTimeout case ,fix it.");
    L5:
        return r3;
    }

    @Override // d.b.p.a.g.a
    public String b() {
        return "FinalizeTimeoutPlugin";
    }

    @Override // d.b.p.a.g.e, d.b.p.a.g.a
    public void d() {
        super.d();
    }

    @Override // d.b.p.a.g.e
    public boolean g() {
        return true;
    }
}
