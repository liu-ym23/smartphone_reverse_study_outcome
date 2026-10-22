package kotlin.s0.w.d.l0.c.o1;

import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public interface g extends Iterable<c>, kotlin.n0.d.l0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f18919b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f18920a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final g f18921b = null;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.c.o1.g$a$a, reason: collision with other inner class name */
        public static final class C0501a implements g {
            C0501a() {
            }

            public Void a(kotlin.s0.w.d.l0.g.c r1) {
                o.f(r1, "fqName");
                return null;
            }

            @Override // kotlin.s0.w.d.l0.c.o1.g
            public /* bridge */ /* synthetic */ c i(kotlin.s0.w.d.l0.g.c r1) {
                return (c) a(r1);
            }

            @Override // kotlin.s0.w.d.l0.c.o1.g
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator<c> iterator() {
                return r.g().iterator();
            }

            @Override // kotlin.s0.w.d.l0.c.o1.g
            public boolean k(kotlin.s0.w.d.l0.g.c r1) {
                return b.b(this, r1);
            }

            public String toString() {
                return "EMPTY";
            }
        }

        static {
            f18920a = new a();
            f18921b = new C0501a();
        }

        private a() {
        }

        public final g a(List<? extends c> r1) {
            o.f(r1, "annotations");
            if (r1.isEmpty() == false) goto L6;
            return f18921b;
        L6:
            return new h(r1);
        }

        public final g b() {
            return f18921b;
        }
    }

    public static final class b {
        public static c a(g r2, kotlin.s0.w.d.l0.g.c r3) {
            o.f(r3, "fqName");
            Iterator<c> r4 = r2.iterator();
        L4:
            if (r4.hasNext() == false) goto L8;
            c r0 = r4.next();
            if (o.a(r0.e(), r3) == false) goto L4;
        L10:
            return r0;
        L8:
            r0 = null;
            goto L10
        }

        public static boolean b(g r1, kotlin.s0.w.d.l0.g.c r2) {
            o.f(r2, "fqName");
            if (r1.i(r2) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f18919b = a.f18920a;
    }

    c i(kotlin.s0.w.d.l0.g.c r1);

    boolean isEmpty();

    boolean k(kotlin.s0.w.d.l0.g.c r1);
}
