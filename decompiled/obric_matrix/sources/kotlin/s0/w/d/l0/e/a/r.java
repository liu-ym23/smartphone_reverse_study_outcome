package kotlin.s0.w.d.l0.e.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.Map;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.n1;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlin.s0.w.d.l0.c.u f19635a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlin.s0.w.d.l0.c.u f19636b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final kotlin.s0.w.d.l0.c.u f19637c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<n1, kotlin.s0.w.d.l0.c.u> f19638d = null;

    static class a extends kotlin.s0.w.d.l0.c.r {
        a(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "what";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            r0[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r1, kotlin.s0.w.d.l0.c.q r2, kotlin.s0.w.d.l0.c.m r3, boolean r4) {
            if (r2 == null) goto L9;
            if (r3 != null) goto L6;
            g(1);
            throw null;
        L6:
            return r.b(r2, r3);
        L9:
            g(0);
            throw null;
        }
    }

    static class b extends kotlin.s0.w.d.l0.c.r {
        b(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "what";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            r0[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r1, kotlin.s0.w.d.l0.c.q r2, kotlin.s0.w.d.l0.c.m r3, boolean r4) {
            if (r2 == null) goto L9;
            if (r3 != null) goto L6;
            g(1);
            throw null;
        L6:
            return r.c(r1, r2, r3);
        L9:
            g(0);
            throw null;
        }
    }

    static class c extends kotlin.s0.w.d.l0.c.r {
        c(n1 r1) {
            super(r1);
        }

        private static /* synthetic */ void g(int r3) {
            Object[] r0 = new Object[3];
            if (r3 == 1) goto L5;
            r0[0] = "what";
        L6:
            r0[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            r0[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
        L5:
            r0[0] = TypedValues.TransitionType.S_FROM;
            goto L6
        }

        @Override // kotlin.s0.w.d.l0.c.u
        public boolean e(kotlin.s0.w.d.l0.k.w.o.f r1, kotlin.s0.w.d.l0.c.q r2, kotlin.s0.w.d.l0.c.m r3, boolean r4) {
            if (r2 == null) goto L9;
            if (r3 != null) goto L6;
            g(1);
            throw null;
        L6:
            return r.c(r1, r2, r3);
        L9:
            g(0);
            throw null;
        }
    }

    static {
        a r0 = new a(kotlin.s0.w.d.l0.c.r1.a.f19074c);
        f19635a = r0;
        b r1 = new b(kotlin.s0.w.d.l0.c.r1.c.f19076c);
        f19636b = r1;
        c r2 = new c(kotlin.s0.w.d.l0.c.r1.b.f19075c);
        f19637c = r2;
        f19638d = new HashMap();
        f(r0);
        f(r1);
        f(r2);
    }

    private static /* synthetic */ void a(int r9) {
        if (r9 == 5) goto L6;
        if (r9 == 6) goto L6;
        String r2 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L8:
        if (r9 == 5) goto L11;
        if (r9 == 6) goto L11;
        int r5 = 3;
    L12:
        Object[] r6 = new Object[r5];
        switch(r9) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L15;
            default: goto L14;
        };
    L14:
        r6[0] = "what";
    L21:
        if (r9 == 5) goto L24;
        if (r9 == 6) goto L24;
        r6[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
    L25:
        if (r9 == 2) goto L33;
        if (r9 == 3) goto L33;
        if (r9 == 4) goto L32;
        if (r9 == 5) goto L34;
        if (r9 == 6) goto L34;
        r6[2] = "isVisibleForProtectedAndPackage";
    L34:
        String r3 = String.format(r2, r6);
        if (r9 == 5) goto L39;
        if (r9 == 6) goto L39;
        throw new IllegalArgumentException(r3);
    L39:
        throw new IllegalStateException(r3);
    L32:
        r6[2] = "toDescriptorVisibility";
    L33:
        r6[2] = "areInSamePackage";
    L24:
        r6[1] = "toDescriptorVisibility";
        goto L25
    L15:
        r6[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        goto L21
    L16:
        r6[0] = "visibility";
        goto L21
    L17:
        r6[0] = "second";
        goto L21
    L18:
        r6[0] = "first";
        goto L21
    L19:
        r6[0] = TypedValues.TransitionType.S_FROM;
    L11:
        r5 = 2;
    L6:
        r2 = "@NotNull method %s.%s must not return null";
        goto L8
    }

    static /* synthetic */ boolean b(kotlin.s0.w.d.l0.c.m r0, kotlin.s0.w.d.l0.c.m r1) {
        return d(r0, r1);
    }

    static /* synthetic */ boolean c(kotlin.s0.w.d.l0.k.w.o.f r0, kotlin.s0.w.d.l0.c.q r1, kotlin.s0.w.d.l0.c.m r2) {
        return e(r0, r1, r2);
    }

    private static boolean d(kotlin.s0.w.d.l0.c.m r2, kotlin.s0.w.d.l0.c.m r3) {
        if (r2 == null) goto L14;
        if (r3 == null) goto L12;
        l0 r4 = (l0) kotlin.s0.w.d.l0.k.d.r(r2, l0.class, false);
        l0 r5 = (l0) kotlin.s0.w.d.l0.k.d.r(r3, l0.class, false);
        if (r5 == null) goto L16;
        if (r4 != null) goto L9;
        return false;
    L9:
        if (r4.e().equals(r5.e()) == false) goto L18;
        return true;
    L18:
        return false;
    L16:
        return false;
    L12:
        a(3);
        throw null;
    L14:
        a(2);
        throw null;
    }

    private static boolean e(kotlin.s0.w.d.l0.k.w.o.f r3, kotlin.s0.w.d.l0.c.q r4, kotlin.s0.w.d.l0.c.m r5) {
        if (r4 != null) goto L5;
        a(0);
        throw null;
    L5:
        if (r5 != null) goto L7;
        a(1);
        throw null;
    L7:
        if (d(kotlin.s0.w.d.l0.k.d.M(r4), r5) == false) goto L10;
        return true;
    L10:
        return kotlin.s0.w.d.l0.c.t.f19161c.e(r3, r4, r5, false);
    }

    private static void f(kotlin.s0.w.d.l0.c.u r2) {
        f19638d.put(r2.b(), r2);
    }

    public static kotlin.s0.w.d.l0.c.u g(n1 r2) {
        if (r2 == null) goto L15;
        kotlin.s0.w.d.l0.c.u r1 = f19638d.get(r2);
        if (r1 != null) goto L11;
        kotlin.s0.w.d.l0.c.u r3 = kotlin.s0.w.d.l0.c.t.j(r2);
        if (r3 == null) goto L9;
        return r3;
    L9:
        a(5);
        throw null;
    L11:
        if (r1 == null) goto L13;
        return r1;
    L13:
        a(6);
        throw null;
    L15:
        a(4);
        throw null;
    }
}
