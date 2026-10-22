package kotlin.s0.w.d.l0.k.r;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f20566a = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<h0, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e0 f20567f;

        a(e0 r1) {
            this.f20567f = r1;
            super(1);
        }

        public final e0 a(h0 r2) {
            kotlin.n0.d.o.f(r2, "it");
            return this.f20567f;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ e0 invoke(h0 r1) {
            return a(r1);
        }
    }

    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l<h0, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.b.i f20568f;

        b(kotlin.s0.w.d.l0.b.i r1) {
            this.f20568f = r1;
            super(1);
        }

        public final e0 a(h0 r2) {
            kotlin.n0.d.o.f(r2, "module");
            m0 r1 = r2.o().O(this.f20568f);
            kotlin.n0.d.o.e(r1, "module.builtIns.getPrimi…KotlinType(componentType)");
            return r1;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ e0 invoke(h0 r1) {
            return a(r1);
        }
    }

    static {
        f20566a = new h();
    }

    private h() {
    }

    private final kotlin.s0.w.d.l0.k.r.b a(List<?> r3, kotlin.s0.w.d.l0.b.i r4) {
        List r5 = kotlin.i0.r.z0(r3);
        ArrayList r0 = new ArrayList();
        Iterator r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        g<?> r1 = c(r6.next());
        if (r1 == null) goto L4;
        r0.add(r1);
        goto L4
    L9:
        return new kotlin.s0.w.d.l0.k.r.b(r0, new b(r4));
    }

    public final kotlin.s0.w.d.l0.k.r.b b(List<? extends g<?>> r2, e0 r3) {
        kotlin.n0.d.o.f(r2, "value");
        kotlin.n0.d.o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
        return new kotlin.s0.w.d.l0.k.r.b(r2, new a(r3));
    }

    public final g<?> c(Object r3) {
        if ((r3 instanceof Byte) == false) goto L6;
        return new d(((Number) r3).byteValue());
    L6:
        if ((r3 instanceof Short) == false) goto L9;
        return new u(((Number) r3).shortValue());
    L9:
        if ((r3 instanceof Integer) == false) goto L12;
        return new m(((Number) r3).intValue());
    L12:
        if ((r3 instanceof Long) == false) goto L15;
        return new r(((Number) r3).longValue());
    L15:
        if ((r3 instanceof Character) == false) goto L18;
        return new e(((Character) r3).charValue());
    L18:
        if ((r3 instanceof Float) == false) goto L21;
        return new l(((Number) r3).floatValue());
    L21:
        if ((r3 instanceof Double) == false) goto L24;
        return new i(((Number) r3).doubleValue());
    L24:
        if ((r3 instanceof Boolean) == false) goto L27;
        return new c(((Boolean) r3).booleanValue());
    L27:
        if ((r3 instanceof String) == false) goto L30;
        return new v((String) r3);
    L30:
        if ((r3 instanceof byte[]) == false) goto L34;
        List<?> r4 = kotlin.i0.i.Y((byte[]) r3);
        kotlin.s0.w.d.l0.b.i r0 = kotlin.s0.w.d.l0.b.i.m;
    L67:
        return a(r4, r0);
    L34:
        if ((r3 instanceof short[]) == false) goto L37;
        r4 = kotlin.i0.i.f0((short[]) r3);
        r0 = kotlin.s0.w.d.l0.b.i.n;
        goto L67
    L37:
        if ((r3 instanceof int[]) == false) goto L40;
        r4 = kotlin.i0.i.c0((int[]) r3);
        r0 = kotlin.s0.w.d.l0.b.i.o;
        goto L67
    L40:
        if ((r3 instanceof long[]) == false) goto L43;
        r4 = kotlin.i0.i.d0((long[]) r3);
        r0 = kotlin.s0.w.d.l0.b.i.q;
        goto L67
    L43:
        if ((r3 instanceof char[]) == false) goto L46;
        r4 = kotlin.i0.i.Z((char[]) r3);
        r0 = kotlin.s0.w.d.l0.b.i.f18691l;
        goto L67
    L46:
        if ((r3 instanceof float[]) == false) goto L49;
        r4 = kotlin.i0.i.b0((float[]) r3);
        r0 = kotlin.s0.w.d.l0.b.i.p;
        goto L67
    L49:
        if ((r3 instanceof double[]) == false) goto L52;
        r4 = kotlin.i0.i.a0((double[]) r3);
        r0 = kotlin.s0.w.d.l0.b.i.r;
        goto L67
    L52:
        if ((r3 instanceof boolean[]) == false) goto L54;
        r4 = kotlin.i0.i.g0((boolean[]) r3);
        r0 = kotlin.s0.w.d.l0.b.i.f18690k;
        goto L67
    L54:
        if (r3 == null) goto L68;
        return null;
    L68:
        return new s();
    }
}
