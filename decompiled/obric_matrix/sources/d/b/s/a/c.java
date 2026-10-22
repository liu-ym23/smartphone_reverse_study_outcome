package d.b.s.a;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile h f14669b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f14670a;

    private c() {
        this.f14670a = com.ss.android.i.j.k().e();
    }

    public static h a() {
        if (f14669b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f14669b != null) goto L9;
        f14669b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f14669b;
    }

    public void b(String r9, String r10, String r11, Map<String, String> r12, d.b.s.a.q.k.g r13) {
        d.b.s.a.y.h.M(this.f14670a, null, r9, null, r10, r11, r12, r13).D();
    }

    @Override // d.b.s.a.h
    public void l(String r7, String r8, String r9, d.b.s.a.q.k.g r10) {
        b(r7, r8, r9, null, r10);
    }
}
