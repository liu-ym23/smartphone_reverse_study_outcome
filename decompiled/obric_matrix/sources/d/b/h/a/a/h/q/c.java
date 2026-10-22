package d.b.h.a.a.h.q;

import d.b.h.a.a.g.d;
import d.b.h.a.a.g.e;
import d.b.h.a.a.g.g;
import d.b.r.e0;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class c implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile e f13709f;

    static {
    }

    public c() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r9) {
        if (r9 == null) goto L30;
        d.a r8 = d.a.f13308h;
        boolean r1 = false;
        if ((r9 instanceof e0) == false) goto L21;
        e0 r0 = (e0) r9;
        int r2 = r0.O();
        if (r2 != 0) goto L9;
        r8 = d.a.f13307g;
    L20:
        r1 = r0.V();
        d.a r4 = r8;
        int r5 = r0.F();
    L23:
        if (f13709f != null) goto L25;
        f13709f = g.c();
    L25:
        d.b.h.a.a.g.a r10 = new d.b.h.a.a.g.a("NetExecutor", r4, r5, r9, r1);
        e r11 = f13709f;
        if (r1 == false) goto L28;
        r11.b(r10);
        return;
    L28:
        r11.a(r10);
        return;
    L9:
        if (1 == r2) goto L20;
        if (2 != r2) goto L15;
        r8 = d.a.f13309i;
        goto L20
    L15:
        if (3 != r2) goto L18;
        r8 = d.a.f13310j;
        goto L20
    L18:
        if ((-1) != r2) goto L20;
        r8 = d.a.f13306f;
        goto L20
    L21:
        r4 = r8;
        r5 = 0;
        goto L23
    }
}
