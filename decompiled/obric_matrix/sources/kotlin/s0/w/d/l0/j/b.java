package kotlin.s0.w.d.l0.j;

import java.util.ArrayList;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.l0;

/* JADX INFO: loaded from: classes2.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20434a = null;

        static {
            f20434a = new a();
        }

        private a() {
        }

        @Override // kotlin.s0.w.d.l0.j.b
        public String a(kotlin.s0.w.d.l0.c.h r1, kotlin.s0.w.d.l0.j.c r2) {
            o.f(r1, "classifier");
            o.f(r2, "renderer");
            if ((r1 instanceof f1) == false) goto L6;
            kotlin.s0.w.d.l0.g.f r0 = ((f1) r1).getName();
            o.e(r0, "classifier.name");
            return r2.v(r0, false);
        L6:
            kotlin.s0.w.d.l0.g.d r3 = kotlin.s0.w.d.l0.k.d.m(r1);
            o.e(r3, "getFqName(classifier)");
            return r2.u(r3);
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.j.b$b, reason: collision with other inner class name */
    public static final class C0554b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0554b f20435a = null;

        static {
            f20435a = new C0554b();
        }

        private C0554b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, kotlin.s0.w.d.l0.c.h] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.s0.w.d.l0.c.j0, kotlin.s0.w.d.l0.c.m] */
        /* JADX WARN: Type inference failed for: r1v2, types: [kotlin.s0.w.d.l0.c.m] */
        @Override // kotlin.s0.w.d.l0.j.b
        public String a(kotlin.s0.w.d.l0.c.h r1, kotlin.s0.w.d.l0.j.c r2) {
            o.f(r1, "classifier");
            o.f(r2, "renderer");
            if ((r1 instanceof f1) == false) goto L6;
            kotlin.s0.w.d.l0.g.f r0 = ((f1) r1).getName();
            o.e(r0, "classifier.name");
            return r2.v(r0, false);
        L6:
            ArrayList r3 = new ArrayList();
        L7:
            r3.add(r1.getName());
            r1 = r1.c();
            if ((r1 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L7;
            return n.c(r.D(r3));
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f20436a = null;

        static {
            f20436a = new c();
        }

        private c() {
        }

        private final String b(kotlin.s0.w.d.l0.c.h r3) {
            kotlin.s0.w.d.l0.g.f r0 = r3.getName();
            o.e(r0, "descriptor.name");
            String r1 = n.b(r0);
            if ((r3 instanceof f1) == false) goto L5;
            return r1;
        L5:
            kotlin.s0.w.d.l0.c.m r4 = r3.c();
            o.e(r4, "descriptor.containingDeclaration");
            String r2 = c(r4);
            if (r2 != null) goto L8;
            return r1;
        L8:
            if (o.a(r2, "") == false) goto L10;
            return r1;
        L10:
            return r2 + '.' + r1;
        }

        private final String c(kotlin.s0.w.d.l0.c.m r2) {
            if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L6;
            return b((kotlin.s0.w.d.l0.c.h) r2);
        L6:
            if ((r2 instanceof l0) == false) goto L8;
            kotlin.s0.w.d.l0.g.d r1 = ((l0) r2).e().j();
            o.e(r1, "descriptor.fqName.toUnsafe()");
            return n.a(r1);
        L8:
            return null;
        }

        @Override // kotlin.s0.w.d.l0.j.b
        public String a(kotlin.s0.w.d.l0.c.h r2, kotlin.s0.w.d.l0.j.c r3) {
            o.f(r2, "classifier");
            o.f(r3, "renderer");
            return b(r2);
        }
    }

    String a(kotlin.s0.w.d.l0.c.h r1, kotlin.s0.w.d.l0.j.c r2);
}
