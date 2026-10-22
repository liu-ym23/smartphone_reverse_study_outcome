package kotlin.s0.w.d.l0.e.a.j0;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.l.b.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.j0.a$a, reason: collision with other inner class name */
    static class C0509a extends kotlin.s0.w.d.l0.k.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f19293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f19294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f19295c;

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.a.j0.a$a$a, reason: collision with other inner class name */
        class C0510a implements l<kotlin.s0.w.d.l0.c.b, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ C0509a f19296f;

            C0510a(C0509a r1) {
                this.f19296f = r1;
            }

            private static /* synthetic */ void a(int r2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"}));
            }

            public f0 b(kotlin.s0.w.d.l0.c.b r1) {
                if (r1 == null) goto L5;
                this.f19296f.f19293a.a(r1);
                return f0.f18324a;
            L5:
                a(0);
                throw null;
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(kotlin.s0.w.d.l0.c.b r1) {
                return b(r1);
            }
        }

        C0509a(r r1, Set r2, boolean r3) {
            this.f19293a = r1;
            this.f19294b = r2;
            this.f19295c = r3;
        }

        private static /* synthetic */ void f(int r7) {
            Object[] r1 = new Object[3];
            if (r7 == 1) goto L11;
            if (r7 == 2) goto L10;
            if (r7 == 3) goto L9;
            if (r7 == 4) goto L8;
            r1[0] = "fakeOverride";
        L12:
            r1[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (r7 == 1) goto L19;
            if (r7 == 2) goto L19;
            if (r7 == 3) goto L18;
            if (r7 == 4) goto L18;
            r1[2] = "addFakeOverride";
        L21:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
        L18:
            r1[2] = "setOverriddenDescriptors";
        L19:
            r1[2] = "conflict";
            goto L21
        L8:
            r1[0] = "overridden";
            goto L12
        L9:
            r1[0] = "member";
            goto L12
        L10:
            r1[0] = "fromCurrent";
            goto L12
        L11:
            r1[0] = "fromSuper";
            goto L12
        }

        @Override // kotlin.s0.w.d.l0.k.i
        public void a(kotlin.s0.w.d.l0.c.b r2) {
            if (r2 == null) goto L5;
            kotlin.s0.w.d.l0.k.j.K(r2, new C0510a(this));
            this.f19294b.add(r2);
            return;
        L5:
            f(0);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.k.i
        public void d(kotlin.s0.w.d.l0.c.b r3, Collection<? extends kotlin.s0.w.d.l0.c.b> r4) {
            if (r3 == null) goto L14;
            if (r4 != null) goto L6;
            f(4);
            throw null;
        L6:
            if (this.f19295c == true) goto L8;
        L10:
            super.d(r3, r4);
            return;
        L8:
            if (r3.i() == kotlin.s0.w.d.l0.c.b.a.f18849g) goto L10;
            return;
        L14:
            f(3);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.k.h
        public void e(kotlin.s0.w.d.l0.c.b r1, kotlin.s0.w.d.l0.c.b r2) {
            if (r1 == null) goto L8;
            if (r2 == null) goto L6;
            return;
        L6:
            f(2);
            throw null;
        L8:
            f(1);
            throw null;
        }
    }

    private static /* synthetic */ void a(int r7) {
        if (r7 == 18) goto L5;
        String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L7:
        if (r7 == 18) goto L9;
        int r3 = 3;
    L10:
        Object[] r4 = new Object[r3];
        switch(r7) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L12;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            case 12: goto L12;
            case 13: goto L19;
            case 14: goto L18;
            case 15: goto L17;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L14;
            case 19: goto L12;
            case 20: goto L13;
            default: goto L12;
        };
    L12:
        r4[0] = "name";
    L21:
        if (r7 == 18) goto L23;
        r4[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
    L24:
        switch(r7) {
            case 6: goto L28;
            case 7: goto L28;
            case 8: goto L28;
            case 9: goto L28;
            case 10: goto L28;
            case 11: goto L28;
            case 12: goto L27;
            case 13: goto L27;
            case 14: goto L27;
            case 15: goto L27;
            case 16: goto L27;
            case 17: goto L27;
            case 18: goto L29;
            case 19: goto L26;
            case 20: goto L26;
            default: goto L25;
        };
    L25:
        r4[2] = "resolveOverridesForNonStaticMembers";
        goto L29
    L26:
        r4[2] = "getAnnotationParameterByName";
        goto L29
    L27:
        r4[2] = "resolveOverrides";
        goto L29
    L28:
        r4[2] = "resolveOverridesForStaticMembers";
    L29:
        String r2 = String.format(r1, r4);
        if (r7 == 18) goto L33;
        throw new IllegalArgumentException(r2);
    L33:
        throw new IllegalStateException(r2);
    L23:
        r4[1] = "resolveOverrides";
        goto L24
    L13:
        r4[0] = "annotationClass";
        goto L21
    L14:
        r4[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        goto L21
    L15:
        r4[0] = "overridingUtil";
        goto L21
    L16:
        r4[0] = "errorReporter";
        goto L21
    L17:
        r4[0] = "classDescriptor";
        goto L21
    L18:
        r4[0] = "membersFromCurrent";
        goto L21
    L19:
        r4[0] = "membersFromSupertypes";
        goto L21
    L9:
        r3 = 2;
        goto L10
    L5:
        r1 = "@NotNull method %s.%s must not return null";
        goto L7
    }

    public static j1 b(kotlin.s0.w.d.l0.g.f r3, kotlin.s0.w.d.l0.c.e r4) {
        if (r3 == null) goto L17;
        if (r4 == null) goto L15;
        Collection<kotlin.s0.w.d.l0.c.d> r5 = r4.m();
        if (r5.size() == 1) goto L8;
        return null;
    L8:
        Iterator<j1> r6 = r5.iterator().next().h().iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        j1 r1 = r6.next();
        if (r1.getName().equals(r3) == false) goto L10;
        return r1;
    L14:
        return null;
    L15:
        a(20);
        throw null;
    L17:
        a(19);
        throw null;
    }

    private static <D extends kotlin.s0.w.d.l0.c.b> Collection<D> c(kotlin.s0.w.d.l0.g.f r7, Collection<D> r8, Collection<D> r9, kotlin.s0.w.d.l0.c.e r10, r r11, kotlin.s0.w.d.l0.k.j r12, boolean r13) {
        if (r7 == null) goto L21;
        if (r8 == null) goto L19;
        if (r9 == null) goto L17;
        if (r10 == null) goto L15;
        if (r11 == null) goto L13;
        if (r12 == null) goto L11;
        LinkedHashSet r0 = new LinkedHashSet();
        r12.v(r7, r8, r9, r10, new C0509a(r11, r0, r13));
        return r0;
    L11:
        a(17);
        throw null;
    L13:
        a(16);
        throw null;
    L15:
        a(15);
        throw null;
    L17:
        a(14);
        throw null;
    L19:
        a(13);
        throw null;
    L21:
        a(12);
        throw null;
    }

    public static <D extends kotlin.s0.w.d.l0.c.b> Collection<D> d(kotlin.s0.w.d.l0.g.f r8, Collection<D> r9, Collection<D> r10, kotlin.s0.w.d.l0.c.e r11, r r12, kotlin.s0.w.d.l0.k.j r13) {
        if (r8 == null) goto L21;
        if (r9 == null) goto L19;
        if (r10 == null) goto L17;
        if (r11 == null) goto L15;
        if (r12 == null) goto L13;
        if (r13 != null) goto L10;
        a(5);
        throw null;
    L10:
        return c(r8, r9, r10, r11, r12, r13, false);
    L13:
        a(4);
        throw null;
    L15:
        a(3);
        throw null;
    L17:
        a(2);
        throw null;
    L19:
        a(1);
        throw null;
    L21:
        a(0);
        throw null;
    }

    public static <D extends kotlin.s0.w.d.l0.c.b> Collection<D> e(kotlin.s0.w.d.l0.g.f r8, Collection<D> r9, Collection<D> r10, kotlin.s0.w.d.l0.c.e r11, r r12, kotlin.s0.w.d.l0.k.j r13) {
        if (r8 == null) goto L21;
        if (r9 == null) goto L19;
        if (r10 == null) goto L17;
        if (r11 == null) goto L15;
        if (r12 == null) goto L13;
        if (r13 != null) goto L10;
        a(11);
        throw null;
    L10:
        return c(r8, r9, r10, r11, r12, r13, true);
    L13:
        a(10);
        throw null;
    L15:
        a(9);
        throw null;
    L17:
        a(8);
        throw null;
    L19:
        a(7);
        throw null;
    L21:
        a(6);
        throw null;
    }
}
