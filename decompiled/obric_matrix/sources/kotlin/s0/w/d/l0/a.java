package kotlin.s0.w.d.l0;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.i0.r;
import kotlin.n0.d.a0;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.e.a.z;
import kotlin.s0.w.d.l0.e.b.q;
import kotlin.s0.w.d.l0.g.b;
import kotlin.s0.w.d.l0.g.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<b> f18664b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f18665c = null;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.a$a, reason: collision with other inner class name */
    public static final class C0493a implements q.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a0 f18666a;

        C0493a(a0 r1) {
            this.f18666a = r1;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.c
        public void a() {
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.c
        public q.a b(b r2, a1 r3) {
            o.f(r2, "classId");
            o.f(r3, "source");
            if (o.a(r2, z.f19662a.a()) == false) goto L7;
            this.f18666a.f18427f = true;
            return null;
        L7:
            return null;
        }
    }

    static {
        f18663a = new a();
        List r0 = r.j(new c[]{kotlin.s0.w.d.l0.e.a.a0.f19204a, kotlin.s0.w.d.l0.e.a.a0.f19211h, kotlin.s0.w.d.l0.e.a.a0.f19212i, kotlin.s0.w.d.l0.e.a.a0.f19206c, kotlin.s0.w.d.l0.e.a.a0.f19207d, kotlin.s0.w.d.l0.e.a.a0.f19209f});
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(b.m((c) r2.next()));
        goto L4
    L6:
        f18664b = r1;
        b r3 = b.m(kotlin.s0.w.d.l0.e.a.a0.f19210g);
        o.e(r3, "topLevel(JvmAnnotationNames.REPEATABLE_ANNOTATION)");
        f18665c = r3;
    }

    private a() {
    }

    public final b a() {
        return f18665c;
    }

    public final Set<b> b() {
        return f18664b;
    }

    public final boolean c(q r3) {
        o.f(r3, "klass");
        a0 r2 = new a0();
        r3.b(new C0493a(r2), null);
        return r2.f18427f;
    }
}
