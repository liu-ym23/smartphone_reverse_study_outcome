package kotlin.s0.w.d.l0.n.t1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.n0.d.e0;
import kotlin.s0.w.d.l0.n.d0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.p1;
import kotlin.s0.w.d.l0.n.q1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f extends kotlin.s0.w.d.l0.n.h {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f21079a = null;

        static {
            f21079a = new a();
        }

        private a() {
        }
    }

    /* synthetic */ class b extends kotlin.n0.d.l implements kotlin.n0.c.l<kotlin.s0.w.d.l0.n.w1.i, q1> {
        b(Object r2) {
            super(1, r2);
        }

        @Override // kotlin.n0.d.c, kotlin.s0.c
        public final String getName() {
            return "prepareType";
        }

        @Override // kotlin.n0.d.c
        public final kotlin.s0.f getOwner() {
            return e0.b(f.class);
        }

        @Override // kotlin.n0.d.c
        public final String getSignature() {
            return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ q1 invoke(kotlin.s0.w.d.l0.n.w1.i r1) {
            return m(r1);
        }

        public final q1 m(kotlin.s0.w.d.l0.n.w1.i r2) {
            kotlin.n0.d.o.f(r2, "p0");
            return ((f) this.receiver).b(r2);
        }
    }

    public f() {
    }

    private final m0 c(m0 r17) {
        e1 r0 = r17.O0();
        boolean r2 = true;
        boolean r3 = false;
        d0 r5 = null;
        q1 r6 = null;
        r6 = null;
        kotlin.s0.w.d.l0.n.e0 r7 = null;
        if ((r0 instanceof kotlin.s0.w.d.l0.k.q.a.c) == false) goto L25;
        kotlin.s0.w.d.l0.k.q.a.c r1 = (kotlin.s0.w.d.l0.k.q.a.c) r0;
        g1 r4 = r1.f();
        if (r4.a() == r1.f21066i) goto L8;
        r2 = false;
    L8:
        if (r2 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L15;
        kotlin.s0.w.d.l0.n.e0 r8 = r4.b();
        if (r8 == null) goto L15;
        r6 = r8.R0();
    L15:
        q1 r9 = r6;
        if (r1.h() != null) goto L22;
        g1 r11 = r1.f();
        Collection<kotlin.s0.w.d.l0.n.e0> r10 = r1.a();
        ArrayList r12 = new ArrayList(kotlin.i0.r.q(r10, 10));
        Iterator<T> r13 = r10.iterator();
    L19:
        if (r13.hasNext() == false) goto L21;
        r12.add(((kotlin.s0.w.d.l0.n.e0) r13.next()).R0());
        goto L19
    L21:
        r1.j(new j(r11, r12, null, 4, null));
    L22:
        kotlin.s0.w.d.l0.n.w1.b r14 = kotlin.s0.w.d.l0.n.w1.b.f21182f;
        j r15 = r1.h();
        kotlin.n0.d.o.c(r15);
        return new i(r14, r15, r9, r17.N0(), r17.P0(), false, 32, null);
    L25:
        if ((r0 instanceof kotlin.s0.w.d.l0.k.r.p) == false) goto L33;
        Collection<kotlin.s0.w.d.l0.n.e0> r16 = ((kotlin.s0.w.d.l0.k.r.p) r0).a();
        ArrayList r18 = new ArrayList(kotlin.i0.r.q(r16, 10));
        Iterator<T> r19 = r16.iterator();
    L28:
        if (r19.hasNext() == false) goto L31;
        kotlin.s0.w.d.l0.n.e0 r20 = n1.p((kotlin.s0.w.d.l0.n.e0) r19.next(), r17.P0());
        kotlin.n0.d.o.e(r20, "makeNullableAsSpecified(it, type.isMarkedNullable)");
        r18.add(r20);
        goto L28
    L31:
        return f0.j(r17.N0(), new d0(r18), kotlin.i0.r.g(), false, r17.q());
    L33:
        if ((r0 instanceof d0) == true) goto L35;
    L51:
        return r17;
    L35:
        if (r17.P0() == false) goto L51;
        d0 r21 = (d0) r0;
        Collection<kotlin.s0.w.d.l0.n.e0> r22 = r21.a();
        ArrayList r23 = new ArrayList(kotlin.i0.r.q(r22, 10));
        Iterator<T> r24 = r22.iterator();
    L38:
        if (r24.hasNext() == false) goto L40;
        r23.add(kotlin.s0.w.d.l0.n.x1.a.t((kotlin.s0.w.d.l0.n.e0) r24.next()));
        r3 = true;
        goto L38
    L40:
        if (r3 == false) goto L46;
        kotlin.s0.w.d.l0.n.e0 r25 = r21.i();
        if (r25 == null) goto L45;
        r7 = kotlin.s0.w.d.l0.n.x1.a.t(r25);
    L45:
        r5 = new d0(r23).m(r7);
    L46:
        if (r5 == null) goto L50;
        r21 = r5;
    L50:
        return r21.h();
    }

    @Override // kotlin.s0.w.d.l0.n.h
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.w1.i a(kotlin.s0.w.d.l0.n.w1.i r1) {
        return b(r1);
    }

    public q1 b(kotlin.s0.w.d.l0.n.w1.i r5) {
        kotlin.n0.d.o.f(r5, WsConstants.KEY_CONNECTION_TYPE);
        if ((r5 instanceof kotlin.s0.w.d.l0.n.e0) == false) goto L21;
        q1 r6 = ((kotlin.s0.w.d.l0.n.e0) r5).R0();
        if ((r6 instanceof m0) == false) goto L8;
        q1 r0 = c((m0) r6);
    L17:
        return p1.c(r0, r6, new b(this));
    L8:
        if ((r6 instanceof kotlin.s0.w.d.l0.n.y) == false) goto L19;
        kotlin.s0.w.d.l0.n.y r1 = (kotlin.s0.w.d.l0.n.y) r6;
        m0 r2 = c(r1.W0());
        m0 r3 = c(r1.X0());
        if (r2 == r1.W0()) goto L12;
    L15:
        r0 = f0.d(r2, r3);
        goto L17
    L12:
        if (r3 != r1.X0()) goto L15;
        r0 = r6;
        goto L17
    L19:
        throw new kotlin.m();
    L21:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
