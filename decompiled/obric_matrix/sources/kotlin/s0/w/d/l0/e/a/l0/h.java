package kotlin.s0.w.d.l0.e.a.l0;

import java.util.Map;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.e.a.n0.y;
import kotlin.s0.w.d.l0.e.a.n0.z;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f19378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m f19379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<y, Integer> f19381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.h<y, kotlin.s0.w.d.l0.e.a.l0.l.m> f19382e;

    static final class a extends q implements l<y, kotlin.s0.w.d.l0.e.a.l0.l.m> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f19383f;

        a(h r1) {
            this.f19383f = r1;
            super(1);
        }

        public final kotlin.s0.w.d.l0.e.a.l0.l.m a(y r5) {
            o.f(r5, "typeParameter");
            Integer r0 = (Integer) h.d(this.f19383f).get(r5);
            if (r0 == null) goto L5;
            h r4 = this.f19383f;
            int r1 = r0.intValue();
            return new kotlin.s0.w.d.l0.e.a.l0.l.m(kotlin.s0.w.d.l0.e.a.l0.a.h(kotlin.s0.w.d.l0.e.a.l0.a.b(h.b(r4), r4), h.c(r4).getAnnotations()), r5, h.e(r4) + r1, h.c(r4));
        L5:
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.e.a.l0.l.m invoke(y r1) {
            return a(r1);
        }
    }

    public h(g r2, m r3, z r4, int r5) {
        o.f(r2, "c");
        o.f(r3, "containingDeclaration");
        o.f(r4, "typeParameterOwner");
        this.f19378a = r2;
        this.f19379b = r3;
        this.f19380c = r5;
        this.f19381d = kotlin.s0.w.d.l0.p.a.d(r4.getTypeParameters());
        this.f19382e = r2.e().i(new a(this));
    }

    public static final /* synthetic */ g b(h r0) {
        return r0.f19378a;
    }

    public static final /* synthetic */ m c(h r0) {
        return r0.f19379b;
    }

    public static final /* synthetic */ Map d(h r0) {
        return r0.f19381d;
    }

    public static final /* synthetic */ int e(h r0) {
        return r0.f19380c;
    }

    @Override // kotlin.s0.w.d.l0.e.a.l0.k
    public f1 a(y r2) {
        o.f(r2, "javaTypeParameter");
        kotlin.s0.w.d.l0.e.a.l0.l.m r0 = this.f19382e.invoke(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.f19378a.f().a(r2);
    }
}
