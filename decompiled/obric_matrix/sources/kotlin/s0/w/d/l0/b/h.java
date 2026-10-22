package kotlin.s0.w.d.l0.b;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.q0;
import kotlin.s0.w.d.l0.c.q1.x;
import kotlin.s0.w.d.l0.c.s;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.v0;
import kotlin.s0.w.d.l0.c.w0;
import kotlin.s0.w.d.l0.n.b1;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.f0;
import kotlin.s0.w.d.l0.n.i1;
import kotlin.s0.w.d.l0.n.m0;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final kotlin.s0.w.d.l0.g.f f18675f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private x f18676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private kotlin.s0.w.d.l0.m.i<x> f18677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.i<e> f18678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.g<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.c.e> f18679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.m.n f18680e;

    class a implements kotlin.n0.c.a<Collection<q0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f18681f;

        a(h r1) {
            this.f18681f = r1;
        }

        public Collection<q0> a() {
            return Arrays.asList(new q0[]{this.f18681f.r().N(k.f18715k), this.f18681f.r().N(k.m), this.f18681f.r().N(k.n), this.f18681f.r().N(k.f18716l)});
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Collection<q0> invoke() {
            return a();
        }
    }

    class b implements kotlin.n0.c.a<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f18682f;

        b(h r1) {
            this.f18682f = r1;
        }

        public e a() {
            EnumMap r0 = new EnumMap(i.class);
            HashMap r1 = new HashMap();
            HashMap r2 = new HashMap();
            i[] r3 = i.values();
            int r4 = r3.length;
            int r5 = 0;
        L3:
            if (r5 >= r4) goto L6;
            i r6 = r3[r5];
            m0 r7 = h.b(this.f18682f, r6.j().b());
            m0 r8 = h.b(this.f18682f, r6.c().b());
            r0.put(r6, r8);
            r1.put(r7, r8);
            r2.put(r8, r7);
            r5 = r5 + 1;
            goto L3
        L6:
            return new e(r0, r1, r2, null);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ e invoke() {
            return a();
        }
    }

    class c implements kotlin.n0.c.l<kotlin.s0.w.d.l0.g.f, kotlin.s0.w.d.l0.c.e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ h f18683f;

        c(h r1) {
            this.f18683f = r1;
        }

        public kotlin.s0.w.d.l0.c.e a(kotlin.s0.w.d.l0.g.f r4) {
            kotlin.s0.w.d.l0.c.h r3 = this.f18683f.s().f(r4, kotlin.s0.w.d.l0.d.b.d.f19189i);
            if (r3 == null) goto L11;
            if ((r3 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L9;
            return (kotlin.s0.w.d.l0.c.e) r3;
        L9:
            throw new AssertionError("Must be a class descriptor " + r4 + ", but was " + r3);
        L11:
            throw new AssertionError("Built-in class " + k.f18715k.c(r4) + " is not found");
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.e invoke(kotlin.s0.w.d.l0.g.f r1) {
            return a(r1);
        }
    }

    class d implements kotlin.n0.c.a<Void> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f18684f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ h f18685g;

        d(h r1, x r2) {
            this.f18685g = r1;
            this.f18684f = r2;
        }

        public Void a() {
            if (h.c(this.f18685g) != null) goto L7;
            h.d(this.f18685g, this.f18684f);
            return null;
        L7:
            throw new AssertionError("Built-ins module is already set: " + h.c(this.f18685g) + " (attempting to reset to " + this.f18684f + ")");
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Void invoke() {
            return a();
        }
    }

    private static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<i, m0> f18686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<e0, m0> f18687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<m0, m0> f18688c;

        private e(Map<i, m0> r2, Map<e0, m0> r3, Map<m0, m0> r4) {
            if (r2 == null) goto L12;
            if (r3 == null) goto L10;
            if (r4 == null) goto L8;
            this.f18686a = r2;
            this.f18687b = r3;
            this.f18688c = r4;
            return;
        L8:
            a(2);
            throw null;
        L10:
            a(1);
            throw null;
        L12:
            a(0);
            throw null;
        }

        /* synthetic */ e(Map r1, Map r2, Map r3, a r4) {
            this(r1, r2, r3);
        }

        private static /* synthetic */ void a(int r4) {
            Object[] r0 = new Object[3];
            if (r4 == 1) goto L7;
            if (r4 == 2) goto L6;
            r0[0] = "primitiveTypeToArrayKotlinType";
        L8:
            r0[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns$Primitives";
            r0[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L6:
            r0[0] = "kotlinArrayTypeToPrimitiveKotlinType";
            goto L8
        L7:
            r0[0] = "primitiveKotlinTypeToKotlinArrayType";
            goto L8
        }
    }

    static {
        f18675f = kotlin.s0.w.d.l0.g.f.n("<built-ins module>");
    }

    protected h(kotlin.s0.w.d.l0.m.n r2) {
        if (r2 == null) goto L5;
        this.f18680e = r2;
        r2.d(new a(this));
        this.f18678c = r2.d(new b(this));
        this.f18679d = r2.h(new c(this));
        return;
    L5:
        a(0);
        throw null;
    }

    private static e0 A(e0 r3, h0 r4) {
        if (r3 == null) goto L24;
        if (r4 == null) goto L22;
        kotlin.s0.w.d.l0.c.h r5 = r3.O0().d();
        if (r5 != null) goto L8;
        return null;
    L8:
        o r1 = o.f18745a;
        if (r1.b(r5.getName()) == true) goto L11;
        return null;
    L11:
        kotlin.s0.w.d.l0.g.b r6 = kotlin.s0.w.d.l0.k.t.a.g(r5);
        if (r6 != null) goto L14;
        return null;
    L14:
        kotlin.s0.w.d.l0.g.b r7 = r1.a(r6);
        if (r7 != null) goto L17;
        return null;
    L17:
        kotlin.s0.w.d.l0.c.e r8 = kotlin.s0.w.d.l0.c.x.a(r4, r7);
        if (r8 != null) goto L21;
        return null;
    L21:
        return r8.s();
    L22:
        a(72);
        throw null;
    L24:
        a(71);
        throw null;
    }

    public static boolean A0(kotlin.s0.w.d.l0.c.m r1) {
        if (r1 == null) goto L11;
    L3:
        if (r1 == null) goto L9;
        if ((r1 instanceof l0) == true) goto L7;
        r1 = r1.c();
        goto L3
    L7:
        return ((l0) r1).e().i(k.f18714j);
    L9:
        return false;
    L11:
        a(10);
        throw null;
    }

    public static boolean B0(e0 r1) {
        if (r1 != null) goto L4;
        a(142);
        throw null;
    L4:
        return l0(r1, k.a.f18722e);
    }

    public static boolean C0(e0 r1) {
        if (r1 != null) goto L4;
        a(132);
        throw null;
    L4:
        if (w0(r1) == false) goto L6;
    L13:
        return true;
    L6:
        if (z0(r1) == true) goto L13;
        if (x0(r1) == true) goto L13;
        if (y0(r1) == true) goto L13;
        return false;
    }

    public static i N(e0 r1) {
        if (r1 == null) goto L9;
        kotlin.s0.w.d.l0.c.h r2 = r1.O0().d();
        if (r2 != null) goto L8;
        return null;
    L8:
        return P(r2);
    L9:
        a(92);
        throw null;
    }

    public static i P(kotlin.s0.w.d.l0.c.m r3) {
        if (r3 != null) goto L5;
        a(77);
        throw null;
    L5:
        if (k.a.h0.contains(r3.getName()) == true) goto L7;
        return null;
    L7:
        return k.a.j0.get(kotlin.s0.w.d.l0.k.d.m(r3));
    }

    private kotlin.s0.w.d.l0.c.e Q(i r1) {
        if (r1 != null) goto L4;
        a(16);
        throw null;
    L4:
        return p(r1.j().b());
    }

    public static i S(kotlin.s0.w.d.l0.c.m r3) {
        if (r3 != null) goto L5;
        a(76);
        throw null;
    L5:
        if (k.a.g0.contains(r3.getName()) == true) goto L7;
        return null;
    L7:
        return k.a.i0.get(kotlin.s0.w.d.l0.k.d.m(r3));
    }

    private static /* synthetic */ void a(int r13) {
        switch(r13) {
            case 3: goto L4;
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L4;
            case 7: goto L4;
            case 8: goto L4;
            case 9: goto L3;
            case 10: goto L3;
            case 11: goto L4;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L3;
            case 15: goto L4;
            case 16: goto L3;
            case 17: goto L3;
            case 18: goto L4;
            case 19: goto L4;
            case 20: goto L4;
            case 21: goto L4;
            case 22: goto L4;
            case 23: goto L4;
            case 24: goto L4;
            case 25: goto L4;
            case 26: goto L4;
            case 27: goto L4;
            case 28: goto L4;
            case 29: goto L4;
            case 30: goto L4;
            case 31: goto L4;
            case 32: goto L4;
            case 33: goto L4;
            case 34: goto L4;
            case 35: goto L4;
            case 36: goto L4;
            case 37: goto L4;
            case 38: goto L4;
            case 39: goto L4;
            case 40: goto L4;
            case 41: goto L4;
            case 42: goto L4;
            case 43: goto L4;
            case 44: goto L4;
            case 45: goto L4;
            case 46: goto L3;
            case 47: goto L4;
            case 48: goto L4;
            case 49: goto L4;
            case 50: goto L4;
            case 51: goto L4;
            case 52: goto L4;
            case 53: goto L3;
            case 54: goto L4;
            case 55: goto L4;
            case 56: goto L4;
            case 57: goto L4;
            case 58: goto L4;
            case 59: goto L4;
            case 60: goto L4;
            case 61: goto L4;
            case 62: goto L4;
            case 63: goto L4;
            case 64: goto L4;
            case 65: goto L4;
            case 66: goto L4;
            case 67: goto L3;
            case 68: goto L4;
            case 69: goto L4;
            case 70: goto L4;
            case 71: goto L3;
            case 72: goto L3;
            case 73: goto L3;
            case 74: goto L4;
            case 75: goto L3;
            case 76: goto L3;
            case 77: goto L3;
            case 78: goto L3;
            case 79: goto L3;
            case 80: goto L3;
            case 81: goto L4;
            case 82: goto L3;
            case 83: goto L3;
            case 84: goto L4;
            case 85: goto L3;
            case 86: goto L4;
            case 87: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r13) {
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L8;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L7;
            case 15: goto L8;
            case 16: goto L7;
            case 17: goto L7;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L8;
            case 21: goto L8;
            case 22: goto L8;
            case 23: goto L8;
            case 24: goto L8;
            case 25: goto L8;
            case 26: goto L8;
            case 27: goto L8;
            case 28: goto L8;
            case 29: goto L8;
            case 30: goto L8;
            case 31: goto L8;
            case 32: goto L8;
            case 33: goto L8;
            case 34: goto L8;
            case 35: goto L8;
            case 36: goto L8;
            case 37: goto L8;
            case 38: goto L8;
            case 39: goto L8;
            case 40: goto L8;
            case 41: goto L8;
            case 42: goto L8;
            case 43: goto L8;
            case 44: goto L8;
            case 45: goto L8;
            case 46: goto L7;
            case 47: goto L8;
            case 48: goto L8;
            case 49: goto L8;
            case 50: goto L8;
            case 51: goto L8;
            case 52: goto L8;
            case 53: goto L7;
            case 54: goto L8;
            case 55: goto L8;
            case 56: goto L8;
            case 57: goto L8;
            case 58: goto L8;
            case 59: goto L8;
            case 60: goto L8;
            case 61: goto L8;
            case 62: goto L8;
            case 63: goto L8;
            case 64: goto L8;
            case 65: goto L8;
            case 66: goto L8;
            case 67: goto L7;
            case 68: goto L8;
            case 69: goto L8;
            case 70: goto L8;
            case 71: goto L7;
            case 72: goto L7;
            case 73: goto L7;
            case 74: goto L8;
            case 75: goto L7;
            case 76: goto L7;
            case 77: goto L7;
            case 78: goto L7;
            case 79: goto L7;
            case 80: goto L7;
            case 81: goto L8;
            case 82: goto L7;
            case 83: goto L7;
            case 84: goto L8;
            case 85: goto L7;
            case 86: goto L8;
            case 87: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r13) {
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L27;
            case 4: goto L27;
            case 5: goto L27;
            case 6: goto L27;
            case 7: goto L27;
            case 8: goto L27;
            case 9: goto L26;
            case 10: goto L26;
            case 11: goto L27;
            case 12: goto L25;
            case 13: goto L27;
            case 14: goto L24;
            case 15: goto L27;
            case 16: goto L23;
            case 17: goto L23;
            case 18: goto L27;
            case 19: goto L27;
            case 20: goto L27;
            case 21: goto L27;
            case 22: goto L27;
            case 23: goto L27;
            case 24: goto L27;
            case 25: goto L27;
            case 26: goto L27;
            case 27: goto L27;
            case 28: goto L27;
            case 29: goto L27;
            case 30: goto L27;
            case 31: goto L27;
            case 32: goto L27;
            case 33: goto L27;
            case 34: goto L27;
            case 35: goto L27;
            case 36: goto L27;
            case 37: goto L27;
            case 38: goto L27;
            case 39: goto L27;
            case 40: goto L27;
            case 41: goto L27;
            case 42: goto L27;
            case 43: goto L27;
            case 44: goto L27;
            case 45: goto L27;
            case 46: goto L22;
            case 47: goto L27;
            case 48: goto L27;
            case 49: goto L27;
            case 50: goto L27;
            case 51: goto L27;
            case 52: goto L27;
            case 53: goto L23;
            case 54: goto L27;
            case 55: goto L27;
            case 56: goto L27;
            case 57: goto L27;
            case 58: goto L27;
            case 59: goto L27;
            case 60: goto L27;
            case 61: goto L27;
            case 62: goto L27;
            case 63: goto L27;
            case 64: goto L27;
            case 65: goto L27;
            case 66: goto L27;
            case 67: goto L21;
            case 68: goto L27;
            case 69: goto L27;
            case 70: goto L27;
            case 71: goto L20;
            case 72: goto L29;
            case 73: goto L19;
            case 74: goto L27;
            case 75: goto L18;
            case 76: goto L26;
            case 77: goto L26;
            case 78: goto L17;
            case 79: goto L16;
            case 80: goto L15;
            case 81: goto L27;
            case 82: goto L17;
            case 83: goto L16;
            case 84: goto L27;
            case 85: goto L16;
            case 86: goto L27;
            case 87: goto L27;
            case 88: goto L23;
            case 89: goto L26;
            case 90: goto L23;
            case 91: goto L23;
            case 92: goto L23;
            case 93: goto L23;
            case 94: goto L23;
            case 95: goto L23;
            case 96: goto L26;
            case 97: goto L23;
            case 98: goto L25;
            case 99: goto L23;
            case 100: goto L25;
            case 101: goto L14;
            case 102: goto L25;
            case 103: goto L26;
            case 104: goto L25;
            case 105: goto L23;
            case 106: goto L25;
            case 107: goto L26;
            case 108: goto L26;
            case 109: goto L23;
            case 110: goto L23;
            case 111: goto L23;
            case 112: goto L13;
            case 113: goto L23;
            case 114: goto L23;
            case 115: goto L23;
            case 116: goto L23;
            case 117: goto L23;
            case 118: goto L23;
            case 119: goto L23;
            case 120: goto L23;
            case 121: goto L23;
            case 122: goto L23;
            case 123: goto L23;
            case 124: goto L23;
            case 125: goto L23;
            case 126: goto L23;
            case 127: goto L23;
            case 128: goto L23;
            case 129: goto L23;
            case 130: goto L23;
            case 131: goto L23;
            case 132: goto L23;
            case 133: goto L23;
            case 134: goto L23;
            case 135: goto L25;
            case 136: goto L23;
            case 137: goto L23;
            case 138: goto L23;
            case 139: goto L23;
            case 140: goto L23;
            case 141: goto L23;
            case 142: goto L23;
            case 143: goto L23;
            case 144: goto L23;
            case 145: goto L26;
            case 146: goto L26;
            case 147: goto L23;
            case 148: goto L26;
            case 149: goto L23;
            case 150: goto L23;
            case 151: goto L23;
            case 152: goto L23;
            case 153: goto L23;
            case 154: goto L23;
            case 155: goto L23;
            case 156: goto L26;
            case 157: goto L26;
            case 158: goto L26;
            case 159: goto L26;
            case 160: goto L12;
            case 161: goto L23;
            default: goto L11;
        };
    L11:
        r3[0] = "storageManager";
    L31:
        switch(r13) {
            case 3: goto L93;
            case 4: goto L92;
            case 5: goto L91;
            case 6: goto L90;
            case 7: goto L89;
            case 8: goto L88;
            case 9: goto L32;
            case 10: goto L32;
            case 11: goto L87;
            case 12: goto L32;
            case 13: goto L86;
            case 14: goto L32;
            case 15: goto L85;
            case 16: goto L32;
            case 17: goto L32;
            case 18: goto L84;
            case 19: goto L83;
            case 20: goto L82;
            case 21: goto L81;
            case 22: goto L80;
            case 23: goto L79;
            case 24: goto L78;
            case 25: goto L77;
            case 26: goto L76;
            case 27: goto L75;
            case 28: goto L74;
            case 29: goto L73;
            case 30: goto L72;
            case 31: goto L71;
            case 32: goto L70;
            case 33: goto L69;
            case 34: goto L68;
            case 35: goto L67;
            case 36: goto L66;
            case 37: goto L65;
            case 38: goto L64;
            case 39: goto L63;
            case 40: goto L62;
            case 41: goto L61;
            case 42: goto L60;
            case 43: goto L59;
            case 44: goto L58;
            case 45: goto L57;
            case 46: goto L32;
            case 47: goto L56;
            case 48: goto L55;
            case 49: goto L54;
            case 50: goto L53;
            case 51: goto L52;
            case 52: goto L51;
            case 53: goto L32;
            case 54: goto L50;
            case 55: goto L49;
            case 56: goto L48;
            case 57: goto L47;
            case 58: goto L46;
            case 59: goto L45;
            case 60: goto L44;
            case 61: goto L43;
            case 62: goto L42;
            case 63: goto L41;
            case 64: goto L40;
            case 65: goto L39;
            case 66: goto L38;
            case 67: goto L32;
            case 68: goto L37;
            case 69: goto L37;
            case 70: goto L37;
            case 71: goto L32;
            case 72: goto L32;
            case 73: goto L32;
            case 74: goto L36;
            case 75: goto L32;
            case 76: goto L32;
            case 77: goto L32;
            case 78: goto L32;
            case 79: goto L32;
            case 80: goto L32;
            case 81: goto L35;
            case 82: goto L32;
            case 83: goto L32;
            case 84: goto L35;
            case 85: goto L32;
            case 86: goto L34;
            case 87: goto L33;
            default: goto L32;
        };
    L32:
        r3[1] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
    L94:
        switch(r13) {
            case 1: goto L174;
            case 2: goto L173;
            case 3: goto L175;
            case 4: goto L175;
            case 5: goto L175;
            case 6: goto L175;
            case 7: goto L175;
            case 8: goto L175;
            case 9: goto L172;
            case 10: goto L171;
            case 11: goto L175;
            case 12: goto L170;
            case 13: goto L175;
            case 14: goto L169;
            case 15: goto L175;
            case 16: goto L168;
            case 17: goto L167;
            case 18: goto L175;
            case 19: goto L175;
            case 20: goto L175;
            case 21: goto L175;
            case 22: goto L175;
            case 23: goto L175;
            case 24: goto L175;
            case 25: goto L175;
            case 26: goto L175;
            case 27: goto L175;
            case 28: goto L175;
            case 29: goto L175;
            case 30: goto L175;
            case 31: goto L175;
            case 32: goto L175;
            case 33: goto L175;
            case 34: goto L175;
            case 35: goto L175;
            case 36: goto L175;
            case 37: goto L175;
            case 38: goto L175;
            case 39: goto L175;
            case 40: goto L175;
            case 41: goto L175;
            case 42: goto L175;
            case 43: goto L175;
            case 44: goto L175;
            case 45: goto L175;
            case 46: goto L166;
            case 47: goto L175;
            case 48: goto L175;
            case 49: goto L175;
            case 50: goto L175;
            case 51: goto L175;
            case 52: goto L175;
            case 53: goto L165;
            case 54: goto L175;
            case 55: goto L175;
            case 56: goto L175;
            case 57: goto L175;
            case 58: goto L175;
            case 59: goto L175;
            case 60: goto L175;
            case 61: goto L175;
            case 62: goto L175;
            case 63: goto L175;
            case 64: goto L175;
            case 65: goto L175;
            case 66: goto L175;
            case 67: goto L164;
            case 68: goto L175;
            case 69: goto L175;
            case 70: goto L175;
            case 71: goto L163;
            case 72: goto L163;
            case 73: goto L162;
            case 74: goto L175;
            case 75: goto L161;
            case 76: goto L160;
            case 77: goto L159;
            case 78: goto L158;
            case 79: goto L158;
            case 80: goto L158;
            case 81: goto L175;
            case 82: goto L158;
            case 83: goto L158;
            case 84: goto L175;
            case 85: goto L157;
            case 86: goto L175;
            case 87: goto L175;
            case 88: goto L156;
            case 89: goto L155;
            case 90: goto L155;
            case 91: goto L154;
            case 92: goto L153;
            case 93: goto L160;
            case 94: goto L152;
            case 95: goto L151;
            case 96: goto L150;
            case 97: goto L149;
            case 98: goto L149;
            case 99: goto L149;
            case 100: goto L149;
            case 101: goto L148;
            case 102: goto L148;
            case 103: goto L147;
            case 104: goto L147;
            case 105: goto L146;
            case 106: goto L146;
            case 107: goto L145;
            case 108: goto L144;
            case 109: goto L144;
            case 110: goto L143;
            case 111: goto L142;
            case 112: goto L143;
            case 113: goto L141;
            case 114: goto L140;
            case 115: goto L139;
            case 116: goto L138;
            case 117: goto L137;
            case 118: goto L136;
            case 119: goto L135;
            case 120: goto L134;
            case 121: goto L133;
            case 122: goto L132;
            case 123: goto L131;
            case 124: goto L130;
            case 125: goto L129;
            case 126: goto L128;
            case 127: goto L127;
            case 128: goto L126;
            case 129: goto L125;
            case 130: goto L124;
            case 131: goto L123;
            case 132: goto L122;
            case 133: goto L121;
            case 134: goto L120;
            case 135: goto L120;
            case 136: goto L119;
            case 137: goto L118;
            case 138: goto L117;
            case 139: goto L116;
            case 140: goto L115;
            case 141: goto L114;
            case 142: goto L113;
            case 143: goto L112;
            case 144: goto L111;
            case 145: goto L110;
            case 146: goto L109;
            case 147: goto L109;
            case 148: goto L108;
            case 149: goto L108;
            case 150: goto L107;
            case 151: goto L106;
            case 152: goto L105;
            case 153: goto L104;
            case 154: goto L103;
            case 155: goto L102;
            case 156: goto L101;
            case 157: goto L100;
            case 158: goto L99;
            case 159: goto L98;
            case 160: goto L97;
            case 161: goto L96;
            default: goto L95;
        };
    L95:
        r3[2] = "<init>";
        goto L175
    L96:
        r3[2] = "isNotNullOrNullableFunctionSupertype";
        goto L175
    L97:
        r3[2] = "isDeprecated";
        goto L175
    L98:
        r3[2] = "isCloneable";
        goto L175
    L99:
        r3[2] = "isNonPrimitiveArray";
        goto L175
    L100:
        r3[2] = "isKClass";
        goto L175
    L101:
        r3[2] = "isThrowable";
        goto L175
    L102:
        r3[2] = "isThrowableOrNullableThrowable";
        goto L175
    L103:
        r3[2] = "isIterableOrNullableIterable";
        goto L175
    L104:
        r3[2] = "isMapOrNullableMap";
        goto L175
    L105:
        r3[2] = "isSetOrNullableSet";
        goto L175
    L106:
        r3[2] = "isListOrNullableList";
        goto L175
    L107:
        r3[2] = "isCollectionOrNullableCollection";
        goto L175
    L108:
        r3[2] = "isComparable";
        goto L175
    L109:
        r3[2] = "isEnum";
        goto L175
    L110:
        r3[2] = "isMemberOfAny";
        goto L175
    L111:
        r3[2] = "isBooleanOrSubtype";
        goto L175
    L112:
        r3[2] = "isUnitOrNullableUnit";
        goto L175
    L113:
        r3[2] = "isUnit";
        goto L175
    L114:
        r3[2] = "isDefaultBound";
        goto L175
    L115:
        r3[2] = "isNullableAny";
        goto L175
    L116:
        r3[2] = "isAnyOrNullableAny";
        goto L175
    L117:
        r3[2] = "isNothingOrNullableNothing";
        goto L175
    L118:
        r3[2] = "isNullableNothing";
        goto L175
    L119:
        r3[2] = "isNothing";
        goto L175
    L120:
        r3[2] = "isConstructedFromGivenClassAndNotNullable";
        goto L175
    L121:
        r3[2] = "isDoubleOrNullableDouble";
        goto L175
    L122:
        r3[2] = "isUnsignedArrayType";
        goto L175
    L123:
        r3[2] = "isULongArray";
        goto L175
    L124:
        r3[2] = "isUIntArray";
        goto L175
    L125:
        r3[2] = "isUShortArray";
        goto L175
    L126:
        r3[2] = "isUByteArray";
        goto L175
    L127:
        r3[2] = "isULong";
        goto L175
    L128:
        r3[2] = "isUInt";
        goto L175
    L129:
        r3[2] = "isUShort";
        goto L175
    L130:
        r3[2] = "isUByte";
        goto L175
    L131:
        r3[2] = "isDouble";
        goto L175
    L132:
        r3[2] = "isFloatOrNullableFloat";
        goto L175
    L133:
        r3[2] = "isFloat";
        goto L175
    L134:
        r3[2] = "isShort";
        goto L175
    L135:
        r3[2] = "isLongOrNullableLong";
        goto L175
    L136:
        r3[2] = "isLong";
        goto L175
    L137:
        r3[2] = "isByte";
        goto L175
    L138:
        r3[2] = "isInt";
        goto L175
    L139:
        r3[2] = "isCharOrNullableChar";
        goto L175
    L140:
        r3[2] = "isChar";
        goto L175
    L141:
        r3[2] = "isNumber";
        goto L175
    L142:
        r3[2] = "isBooleanOrNullableBoolean";
        goto L175
    L143:
        r3[2] = "isBoolean";
        goto L175
    L144:
        r3[2] = "isAny";
        goto L175
    L145:
        r3[2] = "isSpecialClassWithNoSupertypes";
        goto L175
    L146:
        r3[2] = "isNotNullConstructedFromGivenClass";
        goto L175
    L147:
        r3[2] = "classFqNameEquals";
        goto L175
    L148:
        r3[2] = "isTypeConstructorForGivenClass";
        goto L175
    L149:
        r3[2] = "isConstructedFromGivenClass";
        goto L175
    L150:
        r3[2] = "isPrimitiveClass";
        goto L175
    L151:
        r3[2] = "isPrimitiveTypeOrNullablePrimitiveType";
        goto L175
    L152:
        r3[2] = "isPrimitiveType";
        goto L175
    L153:
        r3[2] = "getPrimitiveArrayElementType";
        goto L175
    L154:
        r3[2] = "isPrimitiveArray";
        goto L175
    L155:
        r3[2] = "isArrayOrPrimitiveArray";
        goto L175
    L156:
        r3[2] = "isArray";
        goto L175
    L157:
        r3[2] = "getEnumType";
        goto L175
    L158:
        r3[2] = "getArrayType";
        goto L175
    L159:
        r3[2] = "getPrimitiveArrayType";
        goto L175
    L160:
        r3[2] = "getPrimitiveType";
        goto L175
    L161:
        r3[2] = "getPrimitiveArrayKotlinTypeByPrimitiveKotlinType";
        goto L175
    L162:
        r3[2] = "getPrimitiveArrayKotlinType";
        goto L175
    L163:
        r3[2] = "getElementTypeForUnsignedArray";
        goto L175
    L164:
        r3[2] = "getArrayElementType";
        goto L175
    L165:
        r3[2] = "getPrimitiveKotlinType";
        goto L175
    L166:
        r3[2] = "getBuiltInTypeByClassName";
        goto L175
    L167:
        r3[2] = "getPrimitiveArrayClassDescriptor";
        goto L175
    L168:
        r3[2] = "getPrimitiveClassDescriptor";
        goto L175
    L169:
        r3[2] = "getBuiltInClassByName";
        goto L175
    L170:
        r3[2] = "getBuiltInClassByFqName";
        goto L175
    L171:
        r3[2] = "isUnderKotlinPackage";
        goto L175
    L172:
        r3[2] = "isBuiltIn";
        goto L175
    L173:
        r3[2] = "setPostponedBuiltinsModuleComputation";
        goto L175
    L174:
        r3[2] = "setBuiltInsModule";
    L175:
        String r1 = String.format(r0, r3);
        switch(r13) {
            case 3: goto L179;
            case 4: goto L179;
            case 5: goto L179;
            case 6: goto L179;
            case 7: goto L179;
            case 8: goto L179;
            case 9: goto L180;
            case 10: goto L180;
            case 11: goto L179;
            case 12: goto L180;
            case 13: goto L179;
            case 14: goto L180;
            case 15: goto L179;
            case 16: goto L180;
            case 17: goto L180;
            case 18: goto L179;
            case 19: goto L179;
            case 20: goto L179;
            case 21: goto L179;
            case 22: goto L179;
            case 23: goto L179;
            case 24: goto L179;
            case 25: goto L179;
            case 26: goto L179;
            case 27: goto L179;
            case 28: goto L179;
            case 29: goto L179;
            case 30: goto L179;
            case 31: goto L179;
            case 32: goto L179;
            case 33: goto L179;
            case 34: goto L179;
            case 35: goto L179;
            case 36: goto L179;
            case 37: goto L179;
            case 38: goto L179;
            case 39: goto L179;
            case 40: goto L179;
            case 41: goto L179;
            case 42: goto L179;
            case 43: goto L179;
            case 44: goto L179;
            case 45: goto L179;
            case 46: goto L180;
            case 47: goto L179;
            case 48: goto L179;
            case 49: goto L179;
            case 50: goto L179;
            case 51: goto L179;
            case 52: goto L179;
            case 53: goto L180;
            case 54: goto L179;
            case 55: goto L179;
            case 56: goto L179;
            case 57: goto L179;
            case 58: goto L179;
            case 59: goto L179;
            case 60: goto L179;
            case 61: goto L179;
            case 62: goto L179;
            case 63: goto L179;
            case 64: goto L179;
            case 65: goto L179;
            case 66: goto L179;
            case 67: goto L180;
            case 68: goto L179;
            case 69: goto L179;
            case 70: goto L179;
            case 71: goto L180;
            case 72: goto L180;
            case 73: goto L180;
            case 74: goto L179;
            case 75: goto L180;
            case 76: goto L180;
            case 77: goto L180;
            case 78: goto L180;
            case 79: goto L180;
            case 80: goto L180;
            case 81: goto L179;
            case 82: goto L180;
            case 83: goto L180;
            case 84: goto L179;
            case 85: goto L180;
            case 86: goto L179;
            case 87: goto L179;
            default: goto L180;
        };
    L180:
        throw new IllegalArgumentException(r1);
    L179:
        throw new IllegalStateException(r1);
    L33:
        r3[1] = "getAnnotationType";
        goto L94
    L34:
        r3[1] = "getEnumType";
        goto L94
    L35:
        r3[1] = "getArrayType";
        goto L94
    L36:
        r3[1] = "getPrimitiveArrayKotlinType";
        goto L94
    L37:
        r3[1] = "getArrayElementType";
        goto L94
    L38:
        r3[1] = "getIterableType";
        goto L94
    L39:
        r3[1] = "getStringType";
        goto L94
    L40:
        r3[1] = "getUnitType";
        goto L94
    L41:
        r3[1] = "getBooleanType";
        goto L94
    L42:
        r3[1] = "getCharType";
        goto L94
    L43:
        r3[1] = "getDoubleType";
        goto L94
    L44:
        r3[1] = "getFloatType";
        goto L94
    L45:
        r3[1] = "getLongType";
        goto L94
    L46:
        r3[1] = "getIntType";
        goto L94
    L47:
        r3[1] = "getShortType";
        goto L94
    L48:
        r3[1] = "getByteType";
        goto L94
    L49:
        r3[1] = "getNumberType";
        goto L94
    L50:
        r3[1] = "getPrimitiveKotlinType";
        goto L94
    L51:
        r3[1] = "getDefaultBound";
        goto L94
    L52:
        r3[1] = "getNullableAnyType";
        goto L94
    L53:
        r3[1] = "getAnyType";
        goto L94
    L54:
        r3[1] = "getNullableNothingType";
        goto L94
    L55:
        r3[1] = "getNothingType";
        goto L94
    L56:
        r3[1] = "getBuiltInTypeByClassName";
        goto L94
    L57:
        r3[1] = "getMutableListIterator";
        goto L94
    L58:
        r3[1] = "getListIterator";
        goto L94
    L59:
        r3[1] = "getMutableMapEntry";
        goto L94
    L60:
        r3[1] = "getMapEntry";
        goto L94
    L61:
        r3[1] = "getMutableMap";
        goto L94
    L62:
        r3[1] = "getMap";
        goto L94
    L63:
        r3[1] = "getMutableSet";
        goto L94
    L64:
        r3[1] = "getSet";
        goto L94
    L65:
        r3[1] = "getMutableList";
        goto L94
    L66:
        r3[1] = "getList";
        goto L94
    L67:
        r3[1] = "getMutableCollection";
        goto L94
    L68:
        r3[1] = "getCollection";
        goto L94
    L69:
        r3[1] = "getMutableIterator";
        goto L94
    L70:
        r3[1] = "getMutableIterable";
        goto L94
    L71:
        r3[1] = "getIterable";
        goto L94
    L72:
        r3[1] = "getIterator";
        goto L94
    L73:
        r3[1] = "getKMutableProperty2";
        goto L94
    L74:
        r3[1] = "getKMutableProperty1";
        goto L94
    L75:
        r3[1] = "getKMutableProperty0";
        goto L94
    L76:
        r3[1] = "getKProperty2";
        goto L94
    L77:
        r3[1] = "getKProperty1";
        goto L94
    L78:
        r3[1] = "getKProperty0";
        goto L94
    L79:
        r3[1] = "getKProperty";
        goto L94
    L80:
        r3[1] = "getKCallable";
        goto L94
    L81:
        r3[1] = "getKClass";
        goto L94
    L82:
        r3[1] = "getKSuspendFunction";
        goto L94
    L83:
        r3[1] = "getKFunction";
        goto L94
    L84:
        r3[1] = "getSuspendFunction";
        goto L94
    L85:
        r3[1] = "getBuiltInClassByName";
        goto L94
    L86:
        r3[1] = "getBuiltInClassByFqName";
        goto L94
    L87:
        r3[1] = "getBuiltInsPackageScope";
        goto L94
    L88:
        r3[1] = "getBuiltInPackagesImportedByDefault";
        goto L94
    L89:
        r3[1] = "getBuiltInsModule";
        goto L94
    L90:
        r3[1] = "getStorageManager";
        goto L94
    L91:
        r3[1] = "getClassDescriptorFactories";
        goto L94
    L92:
        r3[1] = "getPlatformDependentDeclarationFilter";
        goto L94
    L93:
        r3[1] = "getAdditionalClassPartsProvider";
        goto L94
    L12:
        r3[0] = "declarationDescriptor";
        goto L31
    L13:
        r3[0] = "classDescriptor";
        goto L31
    L14:
        r3[0] = "typeConstructor";
        goto L31
    L15:
        r3[0] = "annotations";
        goto L31
    L16:
        r3[0] = "argument";
        goto L31
    L17:
        r3[0] = "projectionType";
        goto L31
    L18:
        r3[0] = "kotlinType";
        goto L31
    L19:
        r3[0] = "primitiveType";
        goto L31
    L20:
        r3[0] = "notNullArrayType";
        goto L31
    L21:
        r3[0] = "arrayType";
        goto L31
    L22:
        r3[0] = "classSimpleName";
        goto L31
    L23:
        r3[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L31
    L24:
        r3[0] = "simpleName";
        goto L31
    L25:
        r3[0] = "fqName";
        goto L31
    L26:
        r3[0] = "descriptor";
        goto L31
    L27:
        r3[0] = "kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns";
        goto L31
    L28:
        r3[0] = "computation";
        goto L31
    L29:
        r3[0] = "module";
        goto L31
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    public static boolean a0(kotlin.s0.w.d.l0.c.e r1) {
        if (r1 != null) goto L4;
        a(108);
        throw null;
    L4:
        return e(r1, k.a.f18719b);
    }

    static /* synthetic */ m0 b(h r0, String r1) {
        return r0.q(r1);
    }

    public static boolean b0(e0 r1) {
        if (r1 != null) goto L4;
        a(139);
        throw null;
    L4:
        return g0(r1, k.a.f18719b);
    }

    static /* synthetic */ x c(h r0) {
        return r0.f18676a;
    }

    public static boolean c0(e0 r1) {
        if (r1 != null) goto L4;
        a(88);
        throw null;
    L4:
        return g0(r1, k.a.f18725h);
    }

    static /* synthetic */ x d(h r0, x r1) {
        r0.f18676a = r1;
        return r1;
    }

    public static boolean d0(kotlin.s0.w.d.l0.c.e r1) {
        if (r1 != null) goto L4;
        a(89);
        throw null;
    L4:
        if (e(r1, k.a.f18725h) == false) goto L6;
    L9:
        return true;
    L6:
        if (P(r1) != null) goto L9;
        return false;
    }

    private static boolean e(kotlin.s0.w.d.l0.c.h r2, kotlin.s0.w.d.l0.g.d r3) {
        if (r2 == null) goto L14;
        if (r3 != null) goto L6;
        a(104);
        throw null;
    L6:
        if (r2.getName().equals(r3.i()) == true) goto L8;
    L10:
        return false;
    L8:
        if (r3.equals(kotlin.s0.w.d.l0.k.d.m(r2)) == false) goto L10;
        return true;
    L14:
        a(103);
        throw null;
    }

    public static boolean e0(e0 r1) {
        if (r1 != null) goto L4;
        a(90);
        throw null;
    L4:
        if (c0(r1) == false) goto L6;
    L9:
        return true;
    L6:
        if (p0(r1) == true) goto L9;
        return false;
    }

    public static boolean f0(kotlin.s0.w.d.l0.c.m r2) {
        if (r2 != null) goto L4;
        a(9);
        throw null;
    L4:
        if (kotlin.s0.w.d.l0.k.d.r(r2, kotlin.s0.w.d.l0.b.b.class, false) == null) goto L9;
        return true;
    L9:
        return false;
    }

    private static boolean g0(e0 r1, kotlin.s0.w.d.l0.g.d r2) {
        if (r1 == null) goto L9;
        if (r2 != null) goto L6;
        a(98);
        throw null;
    L6:
        return v0(r1.O0(), r2);
    L9:
        a(97);
        throw null;
    }

    private static boolean h0(e0 r1, kotlin.s0.w.d.l0.g.d r2) {
        if (r1 == null) goto L14;
        if (r2 != null) goto L6;
        a(135);
        throw null;
    L6:
        if (g0(r1, r2) == true) goto L8;
    L10:
        return false;
    L8:
        if (r1.P0() == true) goto L10;
        return true;
    L14:
        a(134);
        throw null;
    }

    public static boolean i0(e0 r0) {
        if (r0 != null) goto L4;
        a(141);
        throw null;
    L4:
        return o0(r0);
    }

    public static boolean j0(kotlin.s0.w.d.l0.c.m r4) {
        if (r4 != null) goto L4;
        a(160);
        throw null;
    L4:
        if (r4.a().getAnnotations().k(k.a.n) == false) goto L7;
        return true;
    L7:
        if ((r4 instanceof u0) == false) goto L19;
        u0 r5 = (u0) r4;
        boolean r0 = r5.j0();
        v0 r3 = r5.g();
        w0 r6 = r5.Y();
        if (r3 == null) goto L18;
        if (j0(r3) == false) goto L18;
        if (r0 == false) goto L22;
        if (r6 == null) goto L18;
        if (j0(r6) == false) goto L18;
        return true;
    L22:
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    public static boolean k0(kotlin.s0.w.d.l0.c.e r1) {
        if (r1 != null) goto L4;
        a(157);
        throw null;
    L4:
        return e(r1, k.a.R);
    }

    private static boolean l0(e0 r1, kotlin.s0.w.d.l0.g.d r2) {
        if (r1 == null) goto L14;
        if (r2 != null) goto L6;
        a(106);
        throw null;
    L6:
        if (r1.P0() == false) goto L8;
    L10:
        return false;
    L8:
        if (g0(r1, r2) == false) goto L10;
        return true;
    L14:
        a(105);
        throw null;
    }

    public static boolean m0(e0 r1) {
        if (r1 != null) goto L4;
        a(136);
        throw null;
    L4:
        if (n0(r1) == true) goto L6;
    L8:
        return false;
    L6:
        if (n1.l(r1) == true) goto L8;
        return true;
    }

    public static boolean n0(e0 r1) {
        if (r1 != null) goto L4;
        a(138);
        throw null;
    L4:
        return g0(r1, k.a.f18720c);
    }

    public static boolean o0(e0 r1) {
        if (r1 != null) goto L4;
        a(140);
        throw null;
    L4:
        if (b0(r1) == true) goto L6;
    L8:
        return false;
    L6:
        if (r1.P0() == false) goto L8;
        return true;
    }

    private kotlin.s0.w.d.l0.c.e p(String r2) {
        if (r2 == null) goto L9;
        kotlin.s0.w.d.l0.c.e r1 = this.f18679d.invoke(kotlin.s0.w.d.l0.g.f.k(r2));
        if (r1 == null) goto L7;
        return r1;
    L7:
        a(15);
        throw null;
    L9:
        a(14);
        throw null;
    }

    public static boolean p0(e0 r0) {
        if (r0 == null) goto L10;
        kotlin.s0.w.d.l0.c.h r1 = r0.O0().d();
        if (r1 != null) goto L6;
    L8:
        return false;
    L6:
        if (P(r1) == null) goto L8;
        return true;
    L10:
        a(91);
        throw null;
    }

    private m0 q(String r2) {
        if (r2 == null) goto L9;
        m0 r1 = p(r2).s();
        if (r1 == null) goto L7;
        return r1;
    L7:
        a(47);
        throw null;
    L9:
        a(46);
        throw null;
    }

    public static boolean q0(kotlin.s0.w.d.l0.c.e r0) {
        if (r0 != null) goto L4;
        a(96);
        throw null;
    L4:
        if (S(r0) == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static boolean r0(e0 r1) {
        if (r1 != null) goto L4;
        a(94);
        throw null;
    L4:
        if (r1.P0() == false) goto L6;
    L8:
        return false;
    L6:
        if (s0(r1) == false) goto L8;
        return true;
    }

    public static boolean s0(e0 r1) {
        if (r1 == null) goto L10;
        kotlin.s0.w.d.l0.c.h r2 = r1.O0().d();
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L6;
    L8:
        return false;
    L6:
        if (q0((kotlin.s0.w.d.l0.c.e) r2) == false) goto L8;
        return true;
    L10:
        a(95);
        throw null;
    }

    public static boolean t0(kotlin.s0.w.d.l0.c.e r1) {
        if (r1 != null) goto L4;
        a(107);
        throw null;
    L4:
        if (e(r1, k.a.f18719b) == false) goto L6;
    L9:
        return true;
    L6:
        if (e(r1, k.a.f18720c) == true) goto L9;
        return false;
    }

    public static boolean u0(e0 r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (l0(r1, k.a.f18724g) == false) goto L6;
        return true;
    }

    public static boolean v0(e1 r1, kotlin.s0.w.d.l0.g.d r2) {
        if (r1 == null) goto L14;
        if (r2 == null) goto L12;
        kotlin.s0.w.d.l0.c.h r3 = r1.d();
        if ((r3 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L8;
    L10:
        return false;
    L8:
        if (e(r3, r2) == false) goto L10;
        return true;
    L12:
        a(102);
        throw null;
    L14:
        a(101);
        throw null;
    }

    public static boolean w0(e0 r1) {
        if (r1 != null) goto L4;
        a(128);
        throw null;
    L4:
        return h0(r1, k.a.c0.j());
    }

    public static boolean x0(e0 r1) {
        if (r1 != null) goto L4;
        a(130);
        throw null;
    L4:
        return h0(r1, k.a.e0.j());
    }

    public static boolean y0(e0 r1) {
        if (r1 != null) goto L4;
        a(131);
        throw null;
    L4:
        return h0(r1, k.a.f0.j());
    }

    public static boolean z0(e0 r1) {
        if (r1 != null) goto L4;
        a(129);
        throw null;
    L4:
        return h0(r1, k.a.d0.j());
    }

    public m0 B() {
        m0 r1 = R(i.p);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(60);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e C(int r1) {
        return p(k.b(r1));
    }

    public m0 D() {
        m0 r1 = R(i.o);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(58);
        throw null;
    }

    public void D0(x r3) {
        if (r3 == null) goto L5;
        this.f18680e.e(new d(this, r3));
        return;
    L5:
        a(1);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e E() {
        kotlin.s0.w.d.l0.c.e r1 = o(k.a.R.l());
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(21);
        throw null;
    }

    public m0 F() {
        m0 r1 = R(i.q);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(59);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e G() {
        return p("Nothing");
    }

    public m0 H() {
        m0 r0 = G().s();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(48);
        throw null;
    }

    public m0 I() {
        m0 r1 = i().V0(true);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(51);
        throw null;
    }

    public m0 J() {
        m0 r1 = H().V0(true);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(49);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e K() {
        return p("Number");
    }

    public m0 L() {
        m0 r0 = K().s();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(55);
        throw null;
    }

    protected kotlin.s0.w.d.l0.c.p1.c M() {
        kotlin.s0.w.d.l0.c.p1.c.b r0 = kotlin.s0.w.d.l0.c.p1.c.b.f18948a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(4);
        throw null;
    }

    public m0 O(i r2) {
        if (r2 == null) goto L9;
        m0 r1 = this.f18678c.invoke().f18686a.get(r2);
        if (r1 == null) goto L7;
        return r1;
    L7:
        a(74);
        throw null;
    L9:
        a(73);
        throw null;
    }

    public m0 R(i r2) {
        if (r2 == null) goto L9;
        m0 r1 = Q(r2).s();
        if (r1 == null) goto L7;
        return r1;
    L7:
        a(54);
        throw null;
    L9:
        a(53);
        throw null;
    }

    public m0 T() {
        m0 r1 = R(i.n);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(57);
        throw null;
    }

    protected kotlin.s0.w.d.l0.m.n U() {
        kotlin.s0.w.d.l0.m.n r0 = this.f18680e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(6);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e V() {
        return p("String");
    }

    public m0 W() {
        m0 r0 = V().s();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(65);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e X(int r2) {
        kotlin.s0.w.d.l0.c.e r1 = o(k.f18709e.c(kotlin.s0.w.d.l0.g.f.k(k.d(r2))));
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(18);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e Y() {
        return p("Unit");
    }

    public m0 Z() {
        m0 r0 = Y().s();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(64);
        throw null;
    }

    protected void f(boolean r10) {
        x r0 = new x(f18675f, this.f18680e, this, null);
        this.f18676a = r0;
        r0.T0(kotlin.s0.w.d.l0.b.a.f18667a.a().a(this.f18680e, this.f18676a, v(), M(), g(), r10));
        x r9 = this.f18676a;
        r9.Z0(new x[]{r9});
    }

    protected kotlin.s0.w.d.l0.c.p1.a g() {
        kotlin.s0.w.d.l0.c.p1.a.C0502a r0 = kotlin.s0.w.d.l0.c.p1.a.C0502a.f18946a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(3);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e h() {
        return p("Any");
    }

    public m0 i() {
        m0 r0 = h().s();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(50);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e j() {
        return p("Array");
    }

    public e0 k(e0 r3) {
        if (r3 != null) goto L5;
        a(67);
        throw null;
    L5:
        if (c0(r3) == true) goto L7;
        e0 r1 = n1.n(r3);
        m0 r2 = this.f18678c.invoke().f18688c.get(r1);
        if (r2 == null) goto L21;
        if (r2 == null) goto L19;
        return r2;
    L19:
        a(69);
        throw null;
    L21:
        h0 r4 = kotlin.s0.w.d.l0.k.d.i(r1);
        if (r4 == null) goto L30;
        e0 r5 = A(r1, r4);
        if (r5 == null) goto L30;
        if (r5 == null) goto L27;
        return r5;
    L27:
        a(70);
        throw null;
    L30:
        throw new IllegalStateException("not array: " + r3);
    L7:
        if (r3.M0().size() != 1) goto L14;
        e0 r6 = r3.M0().get(0).b();
        if (r6 == null) goto L11;
        return r6;
    L11:
        a(68);
        throw null;
    L14:
        throw new IllegalStateException();
    }

    public m0 l(r1 r3, e0 r4) {
        if (r3 == null) goto L12;
        if (r4 == null) goto L10;
        m0 r2 = m(r3, r4, kotlin.s0.w.d.l0.c.o1.g.f18919b.b());
        if (r2 == null) goto L8;
        return r2;
    L8:
        a(84);
        throw null;
    L10:
        a(83);
        throw null;
    L12:
        a(82);
        throw null;
    }

    public m0 m(r1 r3, e0 r4, kotlin.s0.w.d.l0.c.o1.g r5) {
        if (r3 == null) goto L15;
        if (r4 == null) goto L13;
        if (r5 == null) goto L11;
        List r6 = Collections.singletonList(new i1(r3, r4));
        m0 r2 = f0.g(b1.b(r5), j(), r6);
        if (r2 == null) goto L9;
        return r2;
    L9:
        a(81);
        throw null;
    L11:
        a(80);
        throw null;
    L13:
        a(79);
        throw null;
    L15:
        a(78);
        throw null;
    }

    public m0 n() {
        m0 r1 = R(i.f18690k);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(63);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e o(kotlin.s0.w.d.l0.g.c r3) {
        if (r3 == null) goto L9;
        kotlin.s0.w.d.l0.c.e r2 = s.c(r(), r3, kotlin.s0.w.d.l0.d.b.d.f19189i);
        if (r2 == null) goto L7;
        return r2;
    L7:
        a(13);
        throw null;
    L9:
        a(12);
        throw null;
    }

    public x r() {
        if (this.f18676a != null) goto L5;
        this.f18676a = this.f18677b.invoke();
    L5:
        x r1 = this.f18676a;
        if (r1 == null) goto L8;
        return r1;
    L8:
        a(7);
        throw null;
    }

    public kotlin.s0.w.d.l0.k.w.h s() {
        kotlin.s0.w.d.l0.k.w.h r1 = r().N(k.f18715k).q();
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(11);
        throw null;
    }

    public m0 t() {
        m0 r1 = R(i.m);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(56);
        throw null;
    }

    public m0 u() {
        m0 r1 = R(i.f18691l);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(62);
        throw null;
    }

    protected Iterable<kotlin.s0.w.d.l0.c.p1.b> v() {
        List r2 = Collections.singletonList(new kotlin.s0.w.d.l0.b.p.a(this.f18680e, r()));
        if (r2 == null) goto L5;
        return r2;
    L5:
        a(5);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e w() {
        kotlin.s0.w.d.l0.c.e r1 = o(k.a.D);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(34);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.e x() {
        return p("Comparable");
    }

    public m0 y() {
        m0 r0 = I();
        if (r0 == null) goto L5;
        return r0;
    L5:
        a(52);
        throw null;
    }

    public m0 z() {
        m0 r1 = R(i.r);
        if (r1 == null) goto L5;
        return r1;
    L5:
        a(61);
        throw null;
    }
}
