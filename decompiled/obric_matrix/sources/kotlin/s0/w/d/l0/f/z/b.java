package kotlin.s0.w.d.l0.f.z;

import kotlin.s0.w.d.l0.f.j;
import kotlin.s0.w.d.l0.f.k;
import kotlin.s0.w.d.l0.f.x;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static final C0549b A = null;
    public static final C0549b B = null;
    public static final C0549b C = null;
    public static final C0549b D = null;
    public static final C0549b E = null;
    public static final C0549b F = null;
    public static final C0549b G = null;
    public static final C0549b H = null;
    public static final C0549b I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final C0549b f20229J = null;
    public static final C0549b K = null;
    public static final C0549b L = null;
    public static final C0549b M = null;
    public static final C0549b N = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0549b f20230a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0549b f20231b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0549b f20232c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d<x> f20233d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d<k> f20234e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d<kotlin.s0.w.d.l0.f.c.EnumC0545c> f20235f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0549b f20236g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0549b f20237h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0549b f20238i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0549b f20239j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0549b f20240k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C0549b f20241l = null;
    public static final C0549b m = null;
    public static final C0549b n = null;
    public static final d<j> o = null;
    public static final C0549b p = null;
    public static final C0549b q = null;
    public static final C0549b r = null;
    public static final C0549b s = null;
    public static final C0549b t = null;
    public static final C0549b u = null;
    public static final C0549b v = null;
    public static final C0549b w = null;
    public static final C0549b x = null;
    public static final C0549b y = null;
    public static final C0549b z = null;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.z.b$b, reason: collision with other inner class name */
    public static class C0549b extends d<Boolean> {
        public C0549b(int r3) {
            super(r3, 1, null);
        }

        private static /* synthetic */ void f(int r2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"}));
        }

        @Override // kotlin.s0.w.d.l0.f.z.b.d
        public /* bridge */ /* synthetic */ Boolean d(int r1) {
            return g(r1);
        }

        @Override // kotlin.s0.w.d.l0.f.z.b.d
        public /* bridge */ /* synthetic */ int e(Boolean r1) {
            return h(r1);
        }

        public Boolean g(int r2) {
            boolean r0 = true;
            if (((1 << this.f20243a) & r2) != 0) goto L6;
            r0 = false;
        L6:
            Boolean r1 = Boolean.valueOf(r0);
            if (r1 == null) goto L9;
            return r1;
        L9:
            f(0);
            throw null;
        }

        public int h(Boolean r1) {
            if (r1.booleanValue() == true) goto L7;
            return 0;
        L7:
            return 1 << this.f20243a;
        }
    }

    private static class c<E extends kotlin.s0.w.d.l0.i.j.a> extends d<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final E[] f20242c;

        public c(int r3, E[] r4) {
            super(r3, g(r4), null);
            this.f20242c = r4;
        }

        private static /* synthetic */ void f(int r2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"}));
        }

        private static <E> int g(E[] r4) {
            if (r4 == null) goto L15;
            int r0 = r4.length - 1;
            if (r0 != 0) goto L6;
            return 1;
        L6:
            int r2 = 31;
        L7:
            if (r2 < 0) goto L14;
            if (((1 << r2) & r0) != 0) goto L11;
            r2 = r2 - 1;
            goto L7
        L11:
            return r2 + 1;
        L14:
            throw new IllegalStateException("Empty enum: " + r4.getClass());
        L15:
            f(0);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.f.z.b.d
        public /* bridge */ /* synthetic */ Object d(int r1) {
            return h(r1);
        }

        @Override // kotlin.s0.w.d.l0.f.z.b.d
        public /* bridge */ /* synthetic */ int e(Object r1) {
            return i((kotlin.s0.w.d.l0.i.j.a) r1);
        }

        public E h(int r5) {
            int r0 = (1 << this.f20244b) - 1;
            int r1 = this.f20243a;
            int r6 = (r5 & (r0 << r1)) >> r1;
            E[] r4 = this.f20242c;
            int r2 = r4.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L8;
            E r7 = r4[r3];
            if (r7.d() == r6) goto L6;
            r3 = r3 + 1;
            goto L3
        L6:
            return r7;
        L8:
            return null;
        }

        public int i(E r1) {
            return r1.d() << this.f20243a;
        }
    }

    public static abstract class d<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f20244b;

        private d(int r1, int r2) {
            this.f20243a = r1;
            this.f20244b = r2;
        }

        /* synthetic */ d(int r1, int r2, a r3) {
            this(r1, r2);
        }

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/s0/w/d/l0/i/j$a;>(Lkotlin/s0/w/d/l0/f/z/b$d<*>;[TE;)Lkotlin/s0/w/d/l0/f/z/b$d<TE;>; */
        public static d a(d r1, kotlin.s0.w.d.l0.i.j.a[] r2) {
            return new c(r1.f20243a + r1.f20244b, r2);
        }

        public static C0549b b(d<?> r1) {
            return new C0549b(r1.f20243a + r1.f20244b);
        }

        public static C0549b c() {
            return new C0549b(0);
        }

        public abstract E d(int r1);

        public abstract int e(E r1);
    }

    static {
        C0549b r0 = d.c();
        f20230a = r0;
        f20231b = d.b(r0);
        C0549b r1 = d.c();
        f20232c = r1;
        d<x> r2 = d.a(r1, x.values());
        f20233d = r2;
        d<k> r3 = d.a(r2, k.values());
        f20234e = r3;
        d<kotlin.s0.w.d.l0.f.c.EnumC0545c> r4 = d.a(r3, kotlin.s0.w.d.l0.f.c.EnumC0545c.values());
        f20235f = r4;
        C0549b r5 = d.b(r4);
        f20236g = r5;
        C0549b r6 = d.b(r5);
        f20237h = r6;
        C0549b r7 = d.b(r6);
        f20238i = r7;
        C0549b r8 = d.b(r7);
        f20239j = r8;
        C0549b r9 = d.b(r8);
        f20240k = r9;
        f20241l = d.b(r9);
        C0549b r10 = d.b(r2);
        m = r10;
        n = d.b(r10);
        d<j> r11 = d.a(r3, j.values());
        o = r11;
        C0549b r12 = d.b(r11);
        p = r12;
        C0549b r13 = d.b(r12);
        q = r13;
        C0549b r14 = d.b(r13);
        r = r14;
        C0549b r15 = d.b(r14);
        s = r15;
        C0549b r16 = d.b(r15);
        t = r16;
        C0549b r17 = d.b(r16);
        u = r17;
        C0549b r18 = d.b(r17);
        v = r18;
        w = d.b(r18);
        C0549b r19 = d.b(r11);
        x = r19;
        C0549b r20 = d.b(r19);
        y = r20;
        C0549b r21 = d.b(r20);
        z = r21;
        C0549b r22 = d.b(r21);
        A = r22;
        C0549b r23 = d.b(r22);
        B = r23;
        C0549b r24 = d.b(r23);
        C = r24;
        C0549b r25 = d.b(r24);
        D = r25;
        C0549b r26 = d.b(r25);
        E = r26;
        F = d.b(r26);
        C0549b r27 = d.b(r1);
        G = r27;
        C0549b r28 = d.b(r27);
        H = r28;
        I = d.b(r28);
        C0549b r29 = d.b(r3);
        f20229J = r29;
        C0549b r30 = d.b(r29);
        K = r30;
        L = d.b(r30);
        C0549b r31 = d.c();
        M = r31;
        d.b(r31);
        N = d.c();
    }

    private static /* synthetic */ void a(int r5) {
        Object[] r0 = new Object[3];
        if (r5 == 1) goto L18;
        if (r5 != 2) goto L6;
        r0[0] = "kind";
    L19:
        r0[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch(r5) {
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L24;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L23;
            case 9: goto L23;
            case 10: goto L22;
            case 11: goto L22;
            default: goto L21;
        };
    L21:
        r0[2] = "getClassFlags";
    L27:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L22:
        r0[2] = "getAccessorFlags";
        goto L27
    L23:
        r0[2] = "getPropertyFlags";
        goto L27
    L24:
        r0[2] = "getFunctionFlags";
        goto L27
    L25:
        r0[2] = "getConstructorFlags";
        goto L27
    L6:
        if (r5 == 5) goto L18;
        if (r5 != 6) goto L10;
    L16:
        r0[0] = "memberKind";
        goto L19
    L10:
        if (r5 == 8) goto L18;
        if (r5 == 9) goto L16;
        if (r5 == 11) goto L18;
        r0[0] = "visibility";
    L18:
        r0[0] = "modality";
        goto L19
    }

    public static int b(boolean r1, x r2, k r3, boolean r4, boolean r5, boolean r6) {
        if (r2 == null) goto L9;
        if (r3 != null) goto L6;
        a(11);
        throw null;
    L6:
        return ((((f20232c.h(Boolean.valueOf(r1)) | f20234e.e(r3)) | f20233d.e(r2)) | f20229J.h(Boolean.valueOf(r4))) | K.h(Boolean.valueOf(r5))) | L.h(Boolean.valueOf(r6));
    L9:
        a(10);
        throw null;
    }
}
