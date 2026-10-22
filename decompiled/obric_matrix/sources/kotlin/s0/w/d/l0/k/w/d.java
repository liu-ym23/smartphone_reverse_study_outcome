package kotlin.s0.w.d.l0.k.w;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f20623c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f20624d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f20625e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f20626f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f20627g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f20628h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f20629i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f20630j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f20631k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f20632l = 0;
    private static final int m = 0;
    private static final int n = 0;
    public static final d o = null;
    public static final d p = null;
    public static final d q = null;
    public static final d r = null;
    public static final d s = null;
    private static final List<a.C0563a> t = null;
    private static final List<a.C0563a> u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<c> f20633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20634b;

    public static final class a {

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.k.w.d$a$a, reason: collision with other inner class name */
        private static final class C0563a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f20635a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f20636b;

            public C0563a(int r2, String r3) {
                o.f(r3, "name");
                this.f20635a = r2;
                this.f20636b = r3;
            }

            public final int a() {
                return this.f20635a;
            }

            public final String b() {
                return this.f20636b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public static final /* synthetic */ int a(a r0) {
            return r0.j();
        }

        private final int j() {
            int r1 = d.f();
            a r0 = d.f20623c;
            d.k(d.f() << 1);
            return r1;
        }

        public final int b() {
            return d.b();
        }

        public final int c() {
            return d.c();
        }

        public final int d() {
            return d.d();
        }

        public final int e() {
            return d.e();
        }

        public final int f() {
            return d.g();
        }

        public final int g() {
            return d.h();
        }

        public final int h() {
            return d.i();
        }

        public final int i() {
            return d.j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a r1 = new a(null);
        f20623c = r1;
        int r3 = a.a(r1);
        f20625e = r3;
        int r4 = a.a(r1);
        f20626f = r4;
        int r5 = a.a(r1);
        f20627g = r5;
        int r6 = a.a(r1);
        f20628h = r6;
        int r7 = a.a(r1);
        f20629i = r7;
        int r8 = a.a(r1);
        f20630j = r8;
        int r2 = a.a(r1) - 1;
        f20631k = r2;
        int r10 = (r3 | r4) | r5;
        f20632l = r10;
        int r11 = (r4 | r7) | r8;
        m = r11;
        int r12 = r7 | r8;
        n = r12;
        int r14 = 2;
        o = new d(r2, 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0);
        p = new d(r12, 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0);
        new d(r3, 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0);
        new d(r4, 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0);
        new d(r5, 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0);
        q = new d(r10, 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0);
        new d(r6, 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0);
        r = new d(r7, 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0);
        s = new d(r8, 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0);
        new d(r11, 0 == true ? 1 : 0, r14, 0 == true ? 1 : 0);
        Field[] r9 = d.class.getFields();
        o.e(r9, "T::class.java.fields");
        ArrayList r13 = new ArrayList();
        int r15 = r9.length;
        int r16 = 0;
    L3:
        if (r16 >= r15) goto L8;
        Field r17 = r9[r16];
        if (Modifier.isStatic(r17.getModifiers()) == false) goto L7;
        r13.add(r17);
    L7:
        r16 = r16 + 1;
        goto L3
    L8:
        ArrayList r18 = new ArrayList();
        Iterator r19 = r13.iterator();
    L10:
        if (r19.hasNext() == false) goto L20;
        Field r20 = (Field) r19.next();
        Object r21 = r20.get(null);
        if ((r21 instanceof d) == false) goto L14;
        d r22 = (d) r21;
    L15:
        if (r22 == null) goto L17;
        int r23 = r22.f20634b;
        String r24 = r20.getName();
        o.e(r24, "field.name");
        a.C0563a r110 = new a.C0563a(r23, r24);
    L18:
        if (r110 == null) goto L10;
        r18.add(r110);
        goto L10
    L17:
        r110 = null;
        goto L18
    L14:
        r22 = null;
        goto L15
    L20:
        t = r18;
        Field[] r0 = d.class.getFields();
        o.e(r0, "T::class.java.fields");
        ArrayList r25 = new ArrayList();
        int r26 = r0.length;
        int r27 = 0;
    L21:
        if (r27 >= r26) goto L26;
        Field r28 = r0[r27];
        if (Modifier.isStatic(r28.getModifiers()) == false) goto L25;
        r25.add(r28);
    L25:
        r27 = r27 + 1;
        goto L21
    L26:
        ArrayList r29 = new ArrayList();
        Iterator r30 = r25.iterator();
    L28:
        if (r30.hasNext() == false) goto L32;
        Object r31 = r30.next();
        if (o.a(((Field) r31).getType(), Integer.TYPE) == false) goto L28;
        r29.add(r31);
        goto L28
    L32:
        ArrayList r32 = new ArrayList();
        Iterator r33 = r29.iterator();
    L34:
        if (r33.hasNext() == false) goto L44;
        Field r34 = (Field) r33.next();
        Object r35 = r34.get(null);
        o.d(r35, "null cannot be cast to non-null type kotlin.Int");
        int r36 = ((Integer) r35).intValue();
        if (r36 != ((-r36) & r36)) goto L38;
        Object[] r37 = true;
    L39:
        if (r37 == false) goto L41;
        String r38 = r34.getName();
        o.e(r38, "field.name");
        a.C0563a r39 = new a.C0563a(r36, r38);
    L42:
        if (r39 == null) goto L34;
        r32.add(r39);
        goto L34
    L41:
        r39 = null;
        goto L42
    L38:
        r37 = false;
        goto L39
    L44:
        u = r32;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int r2, List<? extends c> r3) {
        o.f(r3, "excludes");
        this.f20633a = r3;
        Iterator r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r2 = r2 & (~((c) r4.next()).a());
        goto L4
    L6:
        this.f20634b = r2;
    }

    public /* synthetic */ d(int r1, List r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = r.g();
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ int b() {
        return f20631k;
    }

    public static final /* synthetic */ int c() {
        return f20632l;
    }

    public static final /* synthetic */ int d() {
        return f20629i;
    }

    public static final /* synthetic */ int e() {
        return f20625e;
    }

    public static final /* synthetic */ int f() {
        return f20624d;
    }

    public static final /* synthetic */ int g() {
        return f20628h;
    }

    public static final /* synthetic */ int h() {
        return f20626f;
    }

    public static final /* synthetic */ int i() {
        return f20627g;
    }

    public static final /* synthetic */ int j() {
        return f20630j;
    }

    public static final /* synthetic */ void k(int r0) {
        f20624d = r0;
    }

    public final boolean a(int r1) {
        if ((this.f20634b & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (o.a(d.class, r2) == true) goto L12;
        return false;
    L12:
        o.d(r5, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        d r6 = (d) r5;
        if (o.a(this.f20633a, r6.f20633a) == true) goto L16;
        return false;
    L16:
        if (this.f20634b == r6.f20634b) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public int hashCode() {
        return (this.f20633a.hashCode() * 31) + this.f20634b;
    }

    public final List<c> l() {
        return this.f20633a;
    }

    public final int m() {
        return this.f20634b;
    }

    public final d n(int r2) {
        int r3 = r2 & this.f20634b;
        if (r3 != 0) goto L7;
        return null;
    L7:
        return new d(r3, this.f20633a);
    }

    public String toString() {
        Iterator<T> r0 = t.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((a.C0563a) r1).a() != this.f20634b) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
    L12:
        a.C0563a r2 = (a.C0563a) r1;
        if (r2 == null) goto L15;
        String r4 = r2.b();
    L16:
        if (r4 != null) goto L28;
        List<a.C0563a> r5 = u;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L19:
        if (r7.hasNext() == false) goto L26;
        a.C0563a r8 = (a.C0563a) r7.next();
        if (a(r8.a()) == false) goto L23;
        String r9 = r8.b();
    L24:
        if (r9 == null) goto L19;
        r6.add(r9);
        goto L19
    L23:
        r9 = null;
        goto L24
    L26:
        r4 = r.Z(r6, " | ", null, null, 0, null, null, 62, null);
    L28:
        return "DescriptorKindFilter(" + r4 + ", " + this.f20633a + ')';
    L15:
        r4 = null;
        goto L16
    L8:
        r3 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }
}
