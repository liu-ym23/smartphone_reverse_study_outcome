package com.bytedance.apm;

/* JADX INFO: loaded from: classes.dex */
public class h {

    static /* synthetic */ class a {
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final h f1596a = null;

        static {
            f1596a = new h(null);
        }

        static /* synthetic */ h a() {
            return f1596a;
        }
    }

    private h() {
        d.b.b.n.c.a(com.bytedance.apm.config.f.class);
    }

    /* synthetic */ h(a r1) {
        this();
    }

    public static h a() {
        return b.a();
    }

    public void b() {
        d.b.b.n.c.a(com.bytedance.apm.config.f.class);
    }

    public void c(com.bytedance.apm.config.e r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        com.bytedance.apm.r.l.M(r3.d());
        com.bytedance.apm.r.g.a().e();
        com.bytedance.apm.r.g.a().f(r3.a(), false);
        j.b(r3);
        com.bytedance.apm.r.f.b(r3.g(), r3.d());
    }
}
