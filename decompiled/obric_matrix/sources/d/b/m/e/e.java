package d.b.m.e;

import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f14157a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f14158b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f14159c = null;

    static final class a extends q implements kotlin.n0.c.a<d.b.m.c.a> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f14160f = null;

        static {
            f14160f = new a();
        }

        a() {
            super(0);
        }

        public final d.b.m.c.a a() {
            return new d.b.m.c.a(com.bytedance.mpaas.app.a.f5245g, "mp_framework_sp", 4);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ d.b.m.c.a invoke() {
            return a();
        }
    }

    static {
        f14157a = new l[]{e0.g(new y(e0.b(e.class), "frameworkSp", "getFrameworkSp()Lcom/bytedance/mpaas/keva/KevaSharedPreferences;"))};
        f14159c = new e();
        f14158b = i.b(a.f14160f);
    }

    private e() {
    }

    public final d.b.m.c.a a() {
        h r2 = f14158b;
        l r0 = f14157a[0];
        return (d.b.m.c.a) r2.getValue();
    }
}
