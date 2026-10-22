package kotlin.s0.w.d.l0.c.s1.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.e.b.p;
import kotlin.s0.w.d.l0.e.b.q;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.e.b.g f19080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f19081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.k.w.h> f19082c;

    public a(kotlin.s0.w.d.l0.e.b.g r2, g r3) {
        o.f(r2, "resolver");
        o.f(r3, "kotlinClassFinder");
        this.f19080a = r2;
        this.f19081b = r3;
        this.f19082c = new ConcurrentHashMap();
    }

    public final kotlin.s0.w.d.l0.k.w.h a(f r9) {
        o.f(r9, "fileClass");
        ConcurrentHashMap<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.k.w.h> r0 = this.f19082c;
        kotlin.s0.w.d.l0.g.b r1 = r9.f();
        kotlin.s0.w.d.l0.k.w.h r2 = r0.get(r1);
        if (r2 != null) goto L23;
        kotlin.s0.w.d.l0.g.c r3 = r9.f().h();
        o.e(r3, "fileClass.classId.packageFqName");
        if (r9.a().c() != kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.m) goto L12;
        List<String> r4 = r9.a().f();
        Collection r5 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L13;
        kotlin.s0.w.d.l0.g.b r7 = kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.k.u.d.d((String) r6.next()).e());
        o.e(r7, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
        q r8 = p.b(this.f19081b, r7);
        if (r8 == null) goto L8;
        r5.add(r8);
    L13:
        kotlin.s0.w.d.l0.c.q1.m r10 = new kotlin.s0.w.d.l0.c.q1.m(this.f19080a.d().p(), r3);
        ArrayList r11 = new ArrayList();
        Iterator r12 = r5.iterator();
    L15:
        if (r12.hasNext() == false) goto L19;
        kotlin.s0.w.d.l0.k.w.h r13 = this.f19080a.b(r10, (q) r12.next());
        if (r13 == null) goto L15;
        r11.add(r13);
        goto L15
    L19:
        List r14 = r.z0(r11);
        kotlin.s0.w.d.l0.k.w.h r15 = kotlin.s0.w.d.l0.k.w.b.f20617d.a("package " + r3 + " (" + r9 + ')', r14);
        kotlin.s0.w.d.l0.k.w.h r16 = r0.putIfAbsent(r1, r15);
        if (r16 != null) goto L22;
        r2 = r15;
        goto L23
    L22:
        r2 = r16;
        goto L23
    L12:
        r5 = r.d(r9);
    L23:
        o.e(r2, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return r2;
    }
}
