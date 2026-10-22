package kotlin.s0.w.d.l0.f.z;

import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.f.v;
import kotlin.s0.w.d.l0.f.w;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f20249b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h f20250c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<v> f20251a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final h a(w r2) {
            o.f(r2, "table");
            if (r2.u() == 0) goto L7;
            List<v> r3 = r2.v();
            o.e(r3, "table.requirementList");
            return new h(r3, null);
        L7:
            return b();
        }

        public final h b() {
            return h.a();
        }
    }

    static {
        f20249b = new a(null);
        f20250c = new h(r.g());
    }

    private h(List<v> r1) {
        this.f20251a = r1;
    }

    public /* synthetic */ h(List r1, kotlin.n0.d.g r2) {
        this(r1);
    }

    public static final /* synthetic */ h a() {
        return f20250c;
    }
}
