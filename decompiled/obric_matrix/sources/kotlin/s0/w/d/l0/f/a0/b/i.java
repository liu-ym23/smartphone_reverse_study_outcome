package kotlin.s0.w.d.l0.f.a0.b;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.s0.w.d.l0.f.l;
import kotlin.s0.w.d.l0.f.n;
import kotlin.s0.w.d.l0.f.q;
import kotlin.u;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f19890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.i.g f19891b = null;

    static {
        f19890a = new i();
        kotlin.s0.w.d.l0.i.g r0 = kotlin.s0.w.d.l0.i.g.d();
        kotlin.s0.w.d.l0.f.a0.a.a(r0);
        o.e(r0, "newInstance().apply(JvmP…f::registerAllExtensions)");
        f19891b = r0;
    }

    private i() {
    }

    public static /* synthetic */ d.a d(i r0, n r1, kotlin.s0.w.d.l0.f.z.c r2, kotlin.s0.w.d.l0.f.z.g r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = true;
    L6:
        return r0.c(r1, r2, r3, r4);
    }

    public static final boolean f(n r2) {
        o.f(r2, "proto");
        kotlin.s0.w.d.l0.f.z.b.C0549b r0 = c.f19875a.a();
        Object r3 = r2.t(kotlin.s0.w.d.l0.f.a0.a.f19804e);
        o.e(r3, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean r4 = r0.g(((Number) r3).intValue());
        o.e(r4, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return r4.booleanValue();
    }

    private final String g(q r1, kotlin.s0.w.d.l0.f.z.c r2) {
        if (r1.l0() == true) goto L7;
        return null;
    L7:
        return b.b(r2.a(r1.W()));
    }

    public static final u<f, kotlin.s0.w.d.l0.f.c> h(byte[] r2, String[] r3) {
        o.f(r2, "bytes");
        o.f(r3, "strings");
        ByteArrayInputStream r0 = new ByteArrayInputStream(r2);
        return new u(f19890a.k(r0, r3), kotlin.s0.w.d.l0.f.c.w1(r0, f19891b));
    }

    public static final u<f, kotlin.s0.w.d.l0.f.c> i(String[] r1, String[] r2) {
        o.f(r1, "data");
        o.f(r2, "strings");
        byte[] r3 = a.e(r1);
        o.e(r3, "decodeBytes(data)");
        return h(r3, r2);
    }

    public static final u<f, kotlin.s0.w.d.l0.f.i> j(String[] r2, String[] r3) {
        o.f(r2, "data");
        o.f(r3, "strings");
        ByteArrayInputStream r0 = new ByteArrayInputStream(a.e(r2));
        return new u(f19890a.k(r0, r3), kotlin.s0.w.d.l0.f.i.E0(r0, f19891b));
    }

    private final f k(InputStream r2, String[] r3) {
        kotlin.s0.w.d.l0.f.a0.a.e r4 = kotlin.s0.w.d.l0.f.a0.a.e.D(r2, f19891b);
        o.e(r4, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new f(r4, r3);
    }

    public static final u<f, l> l(byte[] r2, String[] r3) {
        o.f(r2, "bytes");
        o.f(r3, "strings");
        ByteArrayInputStream r0 = new ByteArrayInputStream(r2);
        return new u(f19890a.k(r0, r3), l.d0(r0, f19891b));
    }

    public static final u<f, l> m(String[] r1, String[] r2) {
        o.f(r1, "data");
        o.f(r2, "strings");
        byte[] r3 = a.e(r1);
        o.e(r3, "decodeBytes(data)");
        return l(r3, r2);
    }

    public final kotlin.s0.w.d.l0.i.g a() {
        return f19891b;
    }

    public final d.b b(kotlin.s0.w.d.l0.f.d r11, kotlin.s0.w.d.l0.f.z.c r12, kotlin.s0.w.d.l0.f.z.g r13) {
        o.f(r11, "proto");
        o.f(r12, "nameResolver");
        o.f(r13, "typeTable");
        kotlin.s0.w.d.l0.i.i.f<kotlin.s0.w.d.l0.f.d, kotlin.s0.w.d.l0.f.a0.a.c> r10 = kotlin.s0.w.d.l0.f.a0.a.f19800a;
        o.e(r10, "constructorSignature");
        kotlin.s0.w.d.l0.f.a0.a.c r14 = (kotlin.s0.w.d.l0.f.a0.a.c) kotlin.s0.w.d.l0.f.z.e.a(r11, r10);
        if (r14 != null) goto L5;
    L7:
        String r0 = "<init>";
    L8:
        if (r14 != null) goto L10;
    L12:
        List<kotlin.s0.w.d.l0.f.u> r15 = r11.M();
        o.e(r15, "proto.valueParameterList");
        ArrayList r1 = new ArrayList(r.q(r15, 10));
        Iterator<T> r16 = r15.iterator();
    L14:
        if (r16.hasNext() == false) goto L20;
        kotlin.s0.w.d.l0.f.u r17 = (kotlin.s0.w.d.l0.f.u) r16.next();
        i r2 = f19890a;
        o.e(r17, "it");
        String r18 = r2.g(kotlin.s0.w.d.l0.f.z.f.n(r17, r13), r12);
        if (r18 == null) goto L17;
        r1.add(r18);
        goto L14
    L17:
        return null;
    L20:
        String r19 = r.Z(r1, "", "(", ")V", 0, null, null, 56, null);
    L22:
        return new d.b(r0, r19);
    L10:
        if (r14.y() == false) goto L12;
        r19 = r12.b(r14.v());
        goto L22
    L5:
        if (r14.z() == false) goto L7;
        r0 = r12.b(r14.w());
        goto L8
    }

    public final d.a c(n r4, kotlin.s0.w.d.l0.f.z.c r5, kotlin.s0.w.d.l0.f.z.g r6, boolean r7) {
        o.f(r4, "proto");
        o.f(r5, "nameResolver");
        o.f(r6, "typeTable");
        kotlin.s0.w.d.l0.i.i.f<n, kotlin.s0.w.d.l0.f.a0.a.d> r0 = kotlin.s0.w.d.l0.f.a0.a.f19803d;
        o.e(r0, "propertySignature");
        kotlin.s0.w.d.l0.f.a0.a.d r1 = (kotlin.s0.w.d.l0.f.a0.a.d) kotlin.s0.w.d.l0.f.z.e.a(r4, r0);
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.F() == false) goto L8;
        kotlin.s0.w.d.l0.f.a0.a.b r2 = r1.A();
    L9:
        if (r2 != null) goto L12;
        if (r7 == false) goto L12;
        return null;
    L12:
        if (r2 != null) goto L14;
    L16:
        int r8 = r4.c0();
    L17:
        if (r2 != null) goto L19;
    L21:
        String r3 = g(kotlin.s0.w.d.l0.f.z.f.k(r4, r6), r5);
        if (r3 != null) goto L25;
        return null;
    L25:
        return new d.a(r5.b(r8), r3);
    L19:
        if (r2.y() == false) goto L21;
        r3 = r5.b(r2.v());
        goto L25
    L14:
        if (r2.z() == false) goto L16;
        r8 = r2.w();
        goto L17
    L8:
        r2 = null;
        goto L9
    }

    public final d.b e(kotlin.s0.w.d.l0.f.i r18, kotlin.s0.w.d.l0.f.z.c r19, kotlin.s0.w.d.l0.f.z.g r20) {
        o.f(r18, "proto");
        o.f(r19, "nameResolver");
        o.f(r20, "typeTable");
        kotlin.s0.w.d.l0.i.i.f<kotlin.s0.w.d.l0.f.i, kotlin.s0.w.d.l0.f.a0.a.c> r3 = kotlin.s0.w.d.l0.f.a0.a.f19801b;
        o.e(r3, "methodSignature");
        kotlin.s0.w.d.l0.f.a0.a.c r4 = (kotlin.s0.w.d.l0.f.a0.a.c) kotlin.s0.w.d.l0.f.z.e.a(r18, r3);
        if (r4 != null) goto L5;
    L7:
        int r5 = r18.d0();
    L8:
        if (r4 != null) goto L10;
    L12:
        List r6 = r.k(kotlin.s0.w.d.l0.f.z.f.h(r18, r20));
        List<kotlin.s0.w.d.l0.f.u> r7 = r18.p0();
        o.e(r7, "proto.valueParameterList");
        ArrayList r8 = new ArrayList(r.q(r7, 10));
        Iterator<T> r9 = r7.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        kotlin.s0.w.d.l0.f.u r10 = (kotlin.s0.w.d.l0.f.u) r9.next();
        o.e(r10, "it");
        r8.add(kotlin.s0.w.d.l0.f.z.f.n(r10, r20));
        goto L14
    L16:
        List r11 = r.k0(r6, r8);
        ArrayList r12 = new ArrayList(r.q(r11, 10));
        Iterator r13 = r11.iterator();
    L18:
        if (r13.hasNext() == false) goto L23;
        String r14 = f19890a.g((q) r13.next(), r19);
        if (r14 == null) goto L21;
        r12.add(r14);
        goto L18
    L21:
        return null;
    L23:
        String r0 = g(kotlin.s0.w.d.l0.f.z.f.j(r18, r20), r19);
        if (r0 != null) goto L26;
        return null;
    L26:
        String r1 = r.Z(r12, "", "(", ")", 0, null, null, 56, null) + r0;
    L28:
        return new d.b(r19.b(r5), r1);
    L10:
        if (r4.y() == false) goto L12;
        r1 = r19.b(r4.v());
        goto L28
    L5:
        if (r4.z() == false) goto L7;
        r5 = r4.w();
        goto L8
    }
}
