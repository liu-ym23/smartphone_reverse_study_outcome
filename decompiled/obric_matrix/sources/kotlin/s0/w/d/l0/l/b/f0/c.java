package kotlin.s0.w.d.l0.l.b.f0;

import java.io.InputStream;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.f.m;
import kotlin.s0.w.d.l0.l.b.q;
import kotlin.s0.w.d.l0.m.n;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends q implements kotlin.s0.w.d.l0.b.b {
    public static final a s = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final c a(kotlin.s0.w.d.l0.g.c r9, n r10, h0 r11, InputStream r12, boolean r13) {
            o.f(r9, "fqName");
            o.f(r10, "storageManager");
            o.f(r11, "module");
            o.f(r12, "inputStream");
            u<m, kotlin.s0.w.d.l0.f.y.a> r8 = kotlin.s0.w.d.l0.f.y.c.a(r12);
            m r4 = r8.a();
            kotlin.s0.w.d.l0.f.y.a r5 = r8.b();
            if (r4 == null) goto L7;
            return new c(r9, r10, r11, r4, r5, r13, null);
        L7:
            throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + kotlin.s0.w.d.l0.f.y.a.f20211g + ", actual " + r5 + ". Please update Kotlin");
        }
    }

    static {
        s = new a(null);
    }

    private c(kotlin.s0.w.d.l0.g.c r8, n r9, h0 r10, m r11, kotlin.s0.w.d.l0.f.y.a r12, boolean r13) {
        super(r8, r9, r10, r11, r12, null);
    }

    public /* synthetic */ c(kotlin.s0.w.d.l0.g.c r1, n r2, h0 r3, m r4, kotlin.s0.w.d.l0.f.y.a r5, boolean r6, g r7) {
        this(r1, r2, r3, r4, r5, r6);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.z, kotlin.s0.w.d.l0.c.q1.j
    public String toString() {
        return "builtins package fragment for " + e() + " from " + kotlin.s0.w.d.l0.k.t.a.l(this);
    }
}
