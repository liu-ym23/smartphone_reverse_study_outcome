package kotlin.s0.w.d.l0.g;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    private static final Map<b, b> A = null;
    private static final Map<b, b> B = null;
    private static final Set<b> C = null;
    private static final Map<b, b> D = null;
    private static final Map<b, b> E = null;
    private static final b F = null;
    private static final b G = null;
    private static final b H = null;
    private static final b I = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f20282a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f20283b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f20284c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final c f20285d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f20286e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final c f20287f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final c f20288g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final c f20289h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final c f20290i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final b f20291j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final b f20292k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final b f20293l = null;
    private static final b m = null;
    private static final b n = null;
    private static final b o = null;
    private static final b p = null;
    private static final b q = null;
    private static final b r = null;
    private static final b s = null;
    private static final b t = null;
    private static final b u = null;
    private static final b v = null;
    private static final b w = null;
    private static final b x = null;
    private static final b y = null;
    private static final Set<b> z = null;

    static {
        f20282a = new i();
        c r0 = new c("kotlin");
        f20283b = r0;
        c r1 = r0.c(f.k("reflect"));
        o.e(r1, "BASE_KOTLIN_PACKAGE.chil…me.identifier(\"reflect\"))");
        f20284c = r1;
        c r2 = r0.c(f.k("collections"));
        o.e(r2, "BASE_KOTLIN_PACKAGE.chil…dentifier(\"collections\"))");
        f20285d = r2;
        c r3 = r0.c(f.k("ranges"));
        o.e(r3, "BASE_KOTLIN_PACKAGE.chil…ame.identifier(\"ranges\"))");
        f20286e = r3;
        c r4 = r0.c(f.k("jvm"));
        o.e(r4, "BASE_KOTLIN_PACKAGE.child(Name.identifier(\"jvm\"))");
        f20287f = r4;
        o.e(r4.c(f.k("internal")), "BASE_JVM_PACKAGE.child(N…e.identifier(\"internal\"))");
        c r5 = r0.c(f.k("annotation"));
        o.e(r5, "BASE_KOTLIN_PACKAGE.chil…identifier(\"annotation\"))");
        f20288g = r5;
        c r6 = r0.c(f.k("internal"));
        o.e(r6, "BASE_KOTLIN_PACKAGE.chil…e.identifier(\"internal\"))");
        f20289h = r6;
        o.e(r6.c(f.k("ir")), "BASE_INTERNAL_PACKAGE.child(Name.identifier(\"ir\"))");
        c r7 = r0.c(f.k("coroutines"));
        o.e(r7, "BASE_KOTLIN_PACKAGE.chil…identifier(\"coroutines\"))");
        f20290i = r7;
        t0.e(new c[]{r0, r2, r3, r5, r1, r6, r7});
        j.b("Nothing");
        j.b("Unit");
        j.b("Any");
        j.b("Enum");
        j.b("Annotation");
        f20291j = j.b("Array");
        b r8 = j.b("Boolean");
        f20292k = r8;
        b r9 = j.b("Char");
        f20293l = r9;
        b r10 = j.b("Byte");
        m = r10;
        b r11 = j.b("Short");
        n = r11;
        b r12 = j.b("Int");
        o = r12;
        b r13 = j.b("Long");
        p = r13;
        b r14 = j.b("Float");
        q = r14;
        b r15 = j.b("Double");
        r = r15;
        s = j.i(r10);
        t = j.i(r11);
        u = j.i(r12);
        v = j.i(r13);
        w = j.b("String");
        j.b("Throwable");
        j.b("Cloneable");
        j.h("KProperty");
        j.h("KMutableProperty");
        j.h("KProperty0");
        j.h("KMutableProperty0");
        j.h("KProperty1");
        j.h("KMutableProperty1");
        j.h("KProperty2");
        j.h("KMutableProperty2");
        x = j.h("KFunction");
        y = j.h("KClass");
        j.h("KCallable");
        j.b("Comparable");
        j.b("Number");
        j.b("Function");
        Set<b> r16 = t0.e(new b[]{r8, r9, r10, r11, r12, r13, r14, r15});
        z = r16;
        LinkedHashMap r17 = new LinkedHashMap(kotlin.r0.e.c(m0.d(r.q(r16, 10)), 16));
        Iterator<T> r18 = r16.iterator();
    L4:
        if (r18.hasNext() == false) goto L6;
        Object r19 = r18.next();
        f r110 = ((b) r19).j();
        o.e(r110, "id.shortClassName");
        r17.put(r19, j.f(r110));
        goto L4
    L6:
        A = r17;
        B = j.e(r17);
        Set<b> r20 = t0.e(new b[]{s, t, u, v});
        C = r20;
        LinkedHashMap r21 = new LinkedHashMap(kotlin.r0.e.c(m0.d(r.q(r20, 10)), 16));
        Iterator<T> r22 = r20.iterator();
    L8:
        if (r22.hasNext() == false) goto L10;
        Object r23 = r22.next();
        f r24 = ((b) r23).j();
        o.e(r24, "id.shortClassName");
        r21.put(r23, j.f(r24));
        goto L8
    L10:
        D = r21;
        E = j.e(r21);
        t0.i(t0.h(z, C), w);
        j.d("Continuation");
        j.c("Iterator");
        j.c("Iterable");
        j.c("Collection");
        j.c("List");
        j.c("ListIterator");
        j.c("Set");
        b r25 = j.c("Map");
        F = r25;
        j.c("MutableIterator");
        j.c("MutableIterable");
        j.c("MutableCollection");
        G = j.c("MutableList");
        j.c("MutableListIterator");
        H = j.c("MutableSet");
        b r26 = j.c("MutableMap");
        I = r26;
        o.e(r25.d(f.k("Entry")), "Map.createNestedClassId(Name.identifier(\"Entry\"))");
        o.e(r26.d(f.k("MutableEntry")), "MutableMap.createNestedC…entifier(\"MutableEntry\"))");
        j.b("Result");
        j.g("IntRange");
        j.g("LongRange");
        j.g("CharRange");
        j.a("AnnotationRetention");
        j.a("AnnotationTarget");
    }

    private i() {
    }

    public final b a() {
        return f20291j;
    }

    public final c b() {
        return f20288g;
    }

    public final c c() {
        return f20285d;
    }

    public final c d() {
        return f20290i;
    }

    public final c e() {
        return f20283b;
    }

    public final c f() {
        return f20286e;
    }

    public final c g() {
        return f20284c;
    }

    public final b h() {
        return y;
    }

    public final b i() {
        return x;
    }

    public final b j() {
        return G;
    }

    public final b k() {
        return I;
    }

    public final b l() {
        return H;
    }
}
