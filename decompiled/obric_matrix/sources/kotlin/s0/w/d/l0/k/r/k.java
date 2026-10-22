package kotlin.s0.w.d.l0.k.r;

import kotlin.f0;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends g<f0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f20571b = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final k a(String r1) {
            kotlin.n0.d.o.f(r1, "message");
            return new b(r1);
        }
    }

    public static final class b extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f20572c;

        public b(String r2) {
            kotlin.n0.d.o.f(r2, "message");
            this.f20572c = r2;
        }

        @Override // kotlin.s0.w.d.l0.k.r.g
        public /* bridge */ /* synthetic */ e0 a(h0 r1) {
            return d(r1);
        }

        public kotlin.s0.w.d.l0.n.u1.h d(h0 r3) {
            kotlin.n0.d.o.f(r3, "module");
            return kotlin.s0.w.d.l0.n.u1.k.d(kotlin.s0.w.d.l0.n.u1.j.o0, new String[]{this.f20572c});
        }

        @Override // kotlin.s0.w.d.l0.k.r.g
        public String toString() {
            return this.f20572c;
        }
    }

    static {
        f20571b = new a(null);
    }

    public k() {
        super(f0.f18324a);
    }

    @Override // kotlin.s0.w.d.l0.k.r.g
    public /* bridge */ /* synthetic */ f0 b() {
        c();
        throw null;
    }

    public f0 c() {
        throw new UnsupportedOperationException();
    }
}
