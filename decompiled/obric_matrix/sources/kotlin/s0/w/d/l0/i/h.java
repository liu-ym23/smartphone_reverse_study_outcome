package kotlin.s0.w.d.l0.i;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.s0.w.d.l0.i.h.b;

/* JADX INFO: loaded from: classes2.dex */
final class h<FieldDescriptorType extends b<FieldDescriptorType>> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final h f20333d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v<FieldDescriptorType, Object> f20334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f20335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f20336c;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f20337a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f20338b = null;

        static {
            int[] r0 = new int[z.b.values().length];
            f20338b = r0;
            r0[z.b.f20414h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L81:
            f20338b[z.b.f20415i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L97:
            f20338b[z.b.f20416j.ordinal()] = 3;     // Catch: NoSuchFieldError -> L42
        L105:
            f20338b[z.b.f20417k.ordinal()] = 4;     // Catch: NoSuchFieldError -> L43
        L109:
            f20338b[z.b.f20418l.ordinal()] = 5;     // Catch: NoSuchFieldError -> L44
        L69:
            f20338b[z.b.m.ordinal()] = 6;     // Catch: NoSuchFieldError -> L45
        L71:
            f20338b[z.b.n.ordinal()] = 7;     // Catch: NoSuchFieldError -> L46
        L89:
            f20338b[z.b.o.ordinal()] = 8;     // Catch: NoSuchFieldError -> L47
        L91:
            f20338b[z.b.p.ordinal()] = 9;     // Catch: NoSuchFieldError -> L48
        L111:
            f20338b[z.b.s.ordinal()] = 10;     // Catch: NoSuchFieldError -> L49
        L115:
            f20338b[z.b.t.ordinal()] = 11;     // Catch: NoSuchFieldError -> L50
        L73:
            f20338b[z.b.v.ordinal()] = 12;     // Catch: NoSuchFieldError -> L51
        L79:
            f20338b[z.b.w.ordinal()] = 13;     // Catch: NoSuchFieldError -> L52
        L95:
            f20338b[z.b.x.ordinal()] = 14;     // Catch: NoSuchFieldError -> L53
        L101:
            f20338b[z.b.y.ordinal()] = 15;     // Catch: NoSuchFieldError -> L54
        L119:
            f20338b[z.b.q.ordinal()] = 16;     // Catch: NoSuchFieldError -> L55
        L67:
            f20338b[z.b.r.ordinal()] = 17;     // Catch: NoSuchFieldError -> L56
        L83:
            f20338b[z.b.u.ordinal()] = 18;     // Catch: NoSuchFieldError -> L57
        L29:
            int[] r9 = new int[z.c.values().length];
            f20337a = r9;
            r9[z.c.f20421g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L58
        L103:
            f20337a[z.c.f20422h.ordinal()] = 2;     // Catch: NoSuchFieldError -> L59
        L107:
            f20337a[z.c.f20423i.ordinal()] = 3;     // Catch: NoSuchFieldError -> L60
        L117:
            f20337a[z.c.f20424j.ordinal()] = 4;     // Catch: NoSuchFieldError -> L61
        L75:
            f20337a[z.c.f20425k.ordinal()] = 5;     // Catch: NoSuchFieldError -> L62
        L85:
            f20337a[z.c.f20426l.ordinal()] = 6;     // Catch: NoSuchFieldError -> L63
        L87:
            f20337a[z.c.m.ordinal()] = 7;     // Catch: NoSuchFieldError -> L64
        L93:
            f20337a[z.c.n.ordinal()] = 8;     // Catch: NoSuchFieldError -> L65
        L113:
            f20337a[z.c.o.ordinal()] = 9;     // Catch: NoSuchFieldError -> L66
            return;
        }
    }

    public interface b<T extends b<T>> extends Comparable<T> {
        int d();

        q.a e(q.a r1, q r2);

        z.b f();

        z.c i();

        boolean isPacked();

        boolean isRepeated();
    }

    static {
        f20333d = new h(true);
    }

    private h() {
        this.f20336c = false;
        this.f20334a = v.o(16);
    }

    private h(boolean r1) {
        this.f20336c = false;
        this.f20334a = v.o(0);
        q();
    }

    private Object c(Object r3) {
        if ((r3 instanceof byte[]) == false) goto L6;
        byte[] r4 = (byte[]) r3;
        byte[] r2 = new byte[r4.length];
        System.arraycopy(r4, 0, r2, 0, r4.length);
        return r2;
    L6:
        return r3;
    }

    private static int d(z.b r1, int r2, Object r3) {
        int r4 = f.D(r2);
        if (r1 != z.b.q) goto L6;
        r4 = r4 * 2;
    L6:
        return r4 + e(r1, r3);
    }

    private static int e(z.b r1, Object r2) {
        switch(a.f20338b[r1.ordinal()]) {
            case 1: goto L53;
            case 2: goto L51;
            case 3: goto L49;
            case 4: goto L47;
            case 5: goto L45;
            case 6: goto L43;
            case 7: goto L41;
            case 8: goto L39;
            case 9: goto L37;
            case 10: goto L31;
            case 11: goto L29;
            case 12: goto L27;
            case 13: goto L25;
            case 14: goto L23;
            case 15: goto L21;
            case 16: goto L19;
            case 17: goto L13;
            case 18: goto L7;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        if ((r2 instanceof j.a) == false) goto L11;
        return f.i(((j.a) r2).d());
    L11:
        return f.i(((Integer) r2).intValue());
    L13:
        if ((r2 instanceof l) == false) goto L17;
        return f.r((l) r2);
    L17:
        return f.t((q) r2);
    L19:
        return f.n((q) r2);
    L21:
        return f.B(((Long) r2).longValue());
    L23:
        return f.z(((Integer) r2).intValue());
    L25:
        return f.y(((Long) r2).longValue());
    L27:
        return f.x(((Integer) r2).intValue());
    L29:
        return f.E(((Integer) r2).intValue());
    L31:
        if ((r2 instanceof d) == false) goto L35;
        return f.e((d) r2);
    L35:
        return f.c((byte[]) r2);
    L37:
        return f.C((String) r2);
    L39:
        return f.b(((Boolean) r2).booleanValue());
    L41:
        return f.j(((Integer) r2).intValue());
    L43:
        return f.k(((Long) r2).longValue());
    L45:
        return f.p(((Integer) r2).intValue());
    L47:
        return f.F(((Long) r2).longValue());
    L49:
        return f.q(((Long) r2).longValue());
    L51:
        return f.m(((Float) r2).floatValue());
    L53:
        return f.g(((Double) r2).doubleValue());
    }

    public static int f(b<?> r3, Object r4) {
        z.b r0 = r3.f();
        int r1 = r3.d();
        if (r3.isRepeated() == false) goto L18;
        int r2 = 0;
        List r5 = (List) r4;
        if (r3.isPacked() == false) goto L12;
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L11;
        r2 = r2 + e(r0, r6.next());
        goto L8
    L11:
        return (f.D(r1) + r2) + f.v(r2);
    L12:
        Iterator r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L16;
        r2 = r2 + d(r0, r1, r7.next());
        goto L14
    L16:
        return r2;
    L18:
        return d(r0, r1, r4);
    }

    public static <T extends b<T>> h<T> g() {
        return f20333d;
    }

    static int l(z.b r0, boolean r1) {
        if (r1 == false) goto L6;
        return 2;
    L6:
        return r0.b();
    }

    private boolean o(Map.Entry<FieldDescriptorType, Object> r4) {
        FieldDescriptorType r3 = r4.getKey();
        if (r3.i() == z.c.o) goto L5;
    L22:
        return true;
    L5:
        if (r3.isRepeated() == false) goto L12;
        Iterator r5 = ((List) r4.getValue()).iterator();
    L8:
        if (r5.hasNext() == false) goto L22;
        if (((q) r5.next()).isInitialized() == true) goto L8;
        return false;
    L12:
        Object r6 = r4.getValue();
        if ((r6 instanceof q) == false) goto L18;
        if (((q) r6).isInitialized() == true) goto L22;
        return false;
    L18:
        if ((r6 instanceof l) == false) goto L21;
        return true;
    L21:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private void s(Map.Entry<FieldDescriptorType, Object> r5) {
        FieldDescriptorType r0 = r5.getKey();
        Object r6 = r5.getValue();
        if ((r6 instanceof l) == false) goto L6;
        r6 = ((l) r6).e();
    L6:
        if (r0.isRepeated() == false) goto L16;
        Object r1 = h(r0);
        if (r1 != null) goto L10;
        r1 = new ArrayList();
    L10:
        Iterator r7 = ((List) r6).iterator();
    L12:
        if (r7.hasNext() == false) goto L14;
        ((List) r1).add(c(r7.next()));
        goto L12
    L14:
        this.f20334a.p(r0, r1);
        return;
    L16:
        if (r0.i() != z.c.o) goto L21;
        Object r2 = h(r0);
        if (r2 == null) goto L21;
        q r8 = r0.e(((q) r2).c(), (q) r6).build();
        this.f20334a.p(r0, r8);
        return;
    L21:
        this.f20334a.p(r0, c(r6));
    }

    public static <T extends b<T>> h<T> t() {
        return new h();
    }

    public static Object u(e r1, z.b r2, boolean r3) {
        switch(a.f20338b[r2.ordinal()]) {
            case 1: goto L44;
            case 2: goto L42;
            case 3: goto L40;
            case 4: goto L38;
            case 5: goto L36;
            case 6: goto L34;
            case 7: goto L32;
            case 8: goto L30;
            case 9: goto L24;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L15;
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L9;
            case 18: goto L7;
            default: goto L5;
        };
    L24:
        if (r3 == false) goto L28;
        return r1.J();
    L28:
        return r1.I();
    L5:
        throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    L7:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
    L9:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    L11:
        throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    L13:
        return Long.valueOf(r1.H());
    L15:
        return Integer.valueOf(r1.G());
    L17:
        return Long.valueOf(r1.F());
    L19:
        return Integer.valueOf(r1.E());
    L21:
        return Integer.valueOf(r1.L());
    L23:
        return r1.l();
    L30:
        return Boolean.valueOf(r1.k());
    L32:
        return Integer.valueOf(r1.o());
    L34:
        return Long.valueOf(r1.p());
    L36:
        return Integer.valueOf(r1.s());
    L38:
        return Long.valueOf(r1.M());
    L40:
        return Long.valueOf(r1.t());
    L42:
        return Float.valueOf(r1.q());
    L44:
        return Double.valueOf(r1.m());
    }

    private static void w(z.b r2, Object r3) {
        Objects.requireNonNull(r3);
        boolean r0 = true;
        boolean r1 = false;
        switch(a.f20337a[r2.a().ordinal()]) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L16;
            case 8: goto L11;
            case 9: goto L6;
            default: goto L28;
        };
    L22:
        r1 = r3 instanceof String;
        goto L28
    L23:
        r1 = r3 instanceof Boolean;
        goto L28
    L24:
        r1 = r3 instanceof Double;
        goto L28
    L25:
        r1 = r3 instanceof Float;
        goto L28
    L26:
        r1 = r3 instanceof Long;
        goto L28
    L27:
        r1 = r3 instanceof Integer;
    L28:
        if (r1 == false) goto L31;
        return;
    L31:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    L6:
        if ((r3 instanceof q) == false) goto L8;
    L21:
        r1 = r0;
        goto L28
    L8:
        if ((r3 instanceof l) == true) goto L21;
    L20:
        r0 = false;
        goto L21
    L11:
        if ((r3 instanceof Integer) == true) goto L21;
        if ((r3 instanceof j.a) == false) goto L20;
    L16:
        if ((r3 instanceof d) == true) goto L21;
        if ((r3 instanceof byte[]) == false) goto L20;
        goto L20
    }

    private static void x(f r1, z.b r2, int r3, Object r4) {
        if (r2 != z.b.q) goto L5;
        r1.Y(r3, (q) r4);
        return;
    L5:
        r1.w0(r3, l(r2, false));
        y(r1, r2, r4);
    }

    private static void y(f r1, z.b r2, Object r3) {
        switch(a.f20338b[r2.ordinal()]) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L15;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L6;
            default: goto L49;
        };
    L10:
        r1.e0((q) r3);
        return;
    L11:
        r1.Z((q) r3);
        return;
    L12:
        r1.u0(((Long) r3).longValue());
        return;
    L13:
        r1.s0(((Integer) r3).intValue());
        return;
    L14:
        r1.r0(((Long) r3).longValue());
        return;
    L15:
        r1.q0(((Integer) r3).intValue());
        return;
    L16:
        r1.y0(((Integer) r3).intValue());
        return;
    L21:
        r1.v0((String) r3);
        return;
    L22:
        r1.M(((Boolean) r3).booleanValue());
        return;
    L23:
        r1.U(((Integer) r3).intValue());
        return;
    L24:
        r1.V(((Long) r3).longValue());
        return;
    L25:
        r1.b0(((Integer) r3).intValue());
        return;
    L26:
        r1.z0(((Long) r3).longValue());
        return;
    L27:
        r1.c0(((Long) r3).longValue());
        return;
    L28:
        r1.X(((Float) r3).floatValue());
        return;
    L29:
        r1.R(((Double) r3).doubleValue());
        return;
    L49:
        return;
    L6:
        if ((r3 instanceof j.a) == false) goto L8;
        int r4 = ((j.a) r3).d();
    L9:
        r1.T(r4);
        return;
    L8:
        r4 = ((Integer) r3).intValue();
        goto L9
    L18:
        if ((r3 instanceof d) == false) goto L20;
        r1.P((d) r3);
        return;
    L20:
        r1.N((byte[]) r3);
    }

    public static void z(b<?> r3, Object r4, f r5) {
        z.b r0 = r3.f();
        int r1 = r3.d();
        if (r3.isRepeated() == false) goto L19;
        List r6 = (List) r4;
        if (r3.isPacked() == false) goto L14;
        r5.w0(r1, 2);
        int r7 = 0;
        Iterator r2 = r6.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r7 = r7 + e(r0, r2.next());
        goto L8
    L10:
        r5.o0(r7);
        Iterator r8 = r6.iterator();
    L12:
        if (r8.hasNext() == false) goto L27;
        y(r5, r0, r8.next());
        goto L12
    L27:
        return;
    L14:
        Iterator r9 = r6.iterator();
    L16:
        if (r9.hasNext() == false) goto L28;
        x(r5, r0, r1, r9.next());
        goto L16
    L28:
        return;
    L19:
        if ((r4 instanceof l) == false) goto L21;
        x(r5, r0, r1, ((l) r4).e());
        return;
    L21:
        x(r5, r0, r1, r4);
    }

    public void a(FieldDescriptorType r2, Object r3) {
        if (r2.isRepeated() == false) goto L11;
        w(r2.f(), r3);
        Object r0 = h(r2);
        if (r0 != null) goto L7;
        List r1 = new ArrayList();
        this.f20334a.p(r2, r1);
    L8:
        r1.add(r3);
        return;
    L7:
        r1 = (List) r0;
        goto L8
    L11:
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public h<FieldDescriptorType> b() {
        h<FieldDescriptorType> r0 = t();
        int r1 = 0;
    L4:
        if (r1 >= this.f20334a.j()) goto L6;
        Map.Entry<K, Object> r2 = this.f20334a.i(r1);
        r0.v((b) r2.getKey(), r2.getValue());
        r1 = r1 + 1;
        goto L4
    L6:
        Iterator r3 = this.f20334a.k().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        Map.Entry r4 = (Map.Entry) r3.next();
        r0.v((b) r4.getKey(), r4.getValue());
        goto L8
    L10:
        r0.f20336c = this.f20336c;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return b();
    }

    public Object h(FieldDescriptorType r1) {
        Object r0 = this.f20334a.get(r1);
        if ((r0 instanceof l) == true) goto L5;
        return r0;
    L5:
        return ((l) r0).e();
    }

    public Object i(FieldDescriptorType r2, int r3) {
        if (r2.isRepeated() == false) goto L11;
        Object r1 = h(r2);
        if (r1 == null) goto L9;
        return ((List) r1).get(r3);
    L9:
        throw new IndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int j(FieldDescriptorType r2) {
        if (r2.isRepeated() == false) goto L11;
        Object r1 = h(r2);
        if (r1 != null) goto L9;
        return 0;
    L9:
        return ((List) r1).size();
    L11:
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int k() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.f20334a.j()) goto L6;
        Map.Entry<K, Object> r2 = this.f20334a.i(r0);
        r1 = r1 + f((b) r2.getKey(), r2.getValue());
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r4 = this.f20334a.k().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) r4.next();
        r1 = r1 + f((b) r3.getKey(), r3.getValue());
        goto L8
    L10:
        return r1;
    }

    public boolean m(FieldDescriptorType r2) {
        if (r2.isRepeated() == true) goto L10;
        if (this.f20334a.get(r2) == null) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public boolean n() {
        int r1 = 0;
    L4:
        if (r1 >= this.f20334a.j()) goto L9;
        if (o(this.f20334a.i(r1)) == false) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        Iterator r2 = this.f20334a.k().iterator();
    L11:
        if (r2.hasNext() == false) goto L15;
        if (o((Map.Entry) r2.next()) == true) goto L11;
        return false;
    L15:
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> p() {
        if (this.f20336c == false) goto L7;
        return new l.c(this.f20334a.entrySet().iterator());
    L7:
        return this.f20334a.entrySet().iterator();
    }

    public void q() {
        if (this.f20335b == false) goto L5;
        return;
    L5:
        this.f20334a.n();
        this.f20335b = true;
    }

    public void r(h<FieldDescriptorType> r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.f20334a.j()) goto L6;
        s(r3.f20334a.i(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        Iterator r4 = r3.f20334a.k().iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        s((Map.Entry) r4.next());
        goto L8
    }

    public void v(FieldDescriptorType r4, Object r5) {
        if (r4.isRepeated() == true) goto L5;
        w(r4.f(), r5);
    L15:
        if ((r5 instanceof l) == false) goto L17;
        this.f20336c = true;
    L17:
        this.f20334a.p(r4, r5);
        return;
    L5:
        if ((r5 instanceof List) == false) goto L12;
        ArrayList r0 = new ArrayList();
        r0.addAll((List) r5);
        Iterator r6 = r0.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        Object r1 = r6.next();
        w(r4.f(), r1);
        goto L8
    L10:
        r5 = r0;
        goto L15
    L12:
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }
}
