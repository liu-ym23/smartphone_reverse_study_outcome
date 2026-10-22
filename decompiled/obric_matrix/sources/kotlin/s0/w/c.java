package kotlin.s0.w;

import kotlin.Metadata;
import kotlin.n0.c.p;
import kotlin.n0.d.e0;
import kotlin.n0.d.l;
import kotlin.n0.d.o;
import kotlin.s0.f;
import kotlin.s0.g;
import kotlin.s0.w.d.i0;
import kotlin.s0.w.d.j;
import kotlin.s0.w.d.l0.c.z0;
import kotlin.s0.w.d.l0.f.a0.b.e;
import kotlin.s0.w.d.l0.f.i;
import kotlin.s0.w.d.l0.f.t;
import kotlin.s0.w.d.l0.l.b.w;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class c {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* synthetic */ class a extends l implements p<w, i, z0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f18499f = null;

        static {
            f18499f = new a();
        }

        a() {
            super(2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "loadFunction";
        }

        @Override // kotlin.n0.d.c
        public final f getOwner() {
            return e0.b(w.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ z0 invoke(w r1, i r2) {
            return m(r1, r2);
        }

        public final z0 m(w r1, i r2) {
            o.f(r1, "p0");
            o.f(r2, "p1");
            return r1.j(r2);
        }
    }

    public static final <R> g<R> a(kotlin.c<? extends R> r12) {
        o.f(r12, "<this>");
        Metadata r0 = (Metadata) r12.getClass().getAnnotation(Metadata.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        String[] r2 = r0.d1();
        boolean r4 = true;
        if (r2.length != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        r2 = null;
    L12:
        if (r2 != null) goto L14;
        return null;
    L14:
        u<kotlin.s0.w.d.l0.f.a0.b.f, i> r1 = kotlin.s0.w.d.l0.f.a0.b.i.j(r2, r0.d2());
        kotlin.s0.w.d.l0.f.a0.b.f r8 = r1.a();
        i r7 = r1.b();
        int[] r5 = r0.mv();
        if ((r0.xi() & 8) != 0) goto L18;
        r4 = false;
    L18:
        e r10 = new e(r5, r4);
        Class<?> r6 = r12.getClass();
        t r13 = r7.m0();
        o.e(r13, "proto.typeTable");
        return new j(kotlin.s0.w.d.b.f18501i, (z0) i0.g(r6, r7, r8, new kotlin.s0.w.d.l0.f.z.g(r13), r10, a.f18499f));
    L8:
        r3 = false;
        goto L9
    }
}
