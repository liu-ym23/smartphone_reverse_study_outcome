package kotlin.s0.w.d.l0.p;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.n0.c.l;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: Add missing generic type declarations: [N] */
    static class a<N> extends AbstractC0585b<N, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f21271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean[] f21272b;

        a(l r1, boolean[] r2) {
            this.f21271a = r1;
            this.f21272b = r2;
        }

        @Override // kotlin.s0.w.d.l0.p.b.d
        public /* bridge */ /* synthetic */ Object a() {
            return d();
        }

        @Override // kotlin.s0.w.d.l0.p.b.d
        public boolean c(N r3) {
            if (((Boolean) this.f21271a.invoke(r3)).booleanValue() == false) goto L6;
            this.f21272b[0] = true;
        L6:
            return !this.f21272b[0];
        }

        public Boolean d() {
            return Boolean.valueOf(this.f21272b[0]);
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.p.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0585b<N, R> implements d<N, R> {
        public AbstractC0585b() {
        }

        @Override // kotlin.s0.w.d.l0.p.b.d
        public void b(N r1) {
        }
    }

    public interface c<N> {
        Iterable<? extends N> a(N r1);
    }

    public interface d<N, R> {
        R a();

        void b(N r1);

        boolean c(N r1);
    }

    public interface e<N> {
        boolean a(N r1);
    }

    public static class f<N> implements e<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<N> f21273a;

        public f() {
            this(new HashSet());
        }

        public f(Set<N> r1) {
            if (r1 == null) goto L5;
            this.f21273a = r1;
            return;
        L5:
            b(0);
            throw null;
        }

        private static /* synthetic */ void b(int r2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"}));
        }

        @Override // kotlin.s0.w.d.l0.p.b.e
        public boolean a(N r1) {
            return this.f21273a.add(r1);
        }
    }

    private static /* synthetic */ void a(int r3) {
        Object[] r0 = new Object[3];
        switch(r3) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L4;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L4;
            case 8: goto L10;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            case 14: goto L6;
            case 15: goto L10;
            case 16: goto L9;
            case 17: goto L4;
            case 18: goto L10;
            case 19: goto L9;
            case 20: goto L4;
            case 21: goto L10;
            case 22: goto L5;
            case 23: goto L10;
            case 24: goto L9;
            case 25: goto L8;
            default: goto L4;
        };
    L4:
        r0[0] = "nodes";
    L11:
        r0[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        switch(r3) {
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L16;
            case 12: goto L16;
            case 13: goto L16;
            case 14: goto L16;
            case 15: goto L16;
            case 16: goto L16;
            case 17: goto L15;
            case 18: goto L15;
            case 19: goto L15;
            case 20: goto L15;
            case 21: goto L15;
            case 22: goto L14;
            case 23: goto L14;
            case 24: goto L14;
            case 25: goto L14;
            default: goto L13;
        };
    L13:
        r0[2] = "dfs";
    L19:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L14:
        r0[2] = "doDfs";
        goto L19
    L15:
        r0[2] = "topologicalOrder";
        goto L19
    L16:
        r0[2] = "dfsFromNode";
        goto L19
    L17:
        r0[2] = "ifAny";
        goto L19
    L5:
        r0[0] = "current";
        goto L11
    L6:
        r0[0] = "node";
        goto L11
    L7:
        r0[0] = "predicate";
        goto L11
    L8:
        r0[0] = "handler";
        goto L11
    L9:
        r0[0] = "visited";
        goto L11
    L10:
        r0[0] = "neighbors";
        goto L11
    }

    public static <N, R> R b(Collection<N> r1, c<N> r2, d<N, R> r3) {
        if (r1 == null) goto L12;
        if (r2 == null) goto L10;
        if (r3 != null) goto L7;
        a(6);
        throw null;
    L7:
        return (R) c(r1, r2, new f(), r3);
    L10:
        a(5);
        throw null;
    L12:
        a(4);
        throw null;
    }

    public static <N, R> R c(Collection<N> r1, c<N> r2, e<N> r3, d<N, R> r4) {
        if (r1 == null) goto L19;
        if (r2 == null) goto L17;
        if (r3 == null) goto L15;
        if (r4 == null) goto L13;
        Iterator<N> r5 = r1.iterator();
    L9:
        if (r5.hasNext() == false) goto L12;
        d(r5.next(), r2, r3, r4);
        goto L9
    L12:
        return r4.a();
    L13:
        a(3);
        throw null;
    L15:
        a(2);
        throw null;
    L17:
        a(1);
        throw null;
    L19:
        a(0);
        throw null;
    }

    public static <N> void d(N r2, c<N> r3, e<N> r4, d<N, ?> r5) {
        if (r2 == null) goto L25;
        if (r3 == null) goto L23;
        if (r4 == null) goto L21;
        if (r5 != null) goto L8;
        a(25);
        throw null;
    L8:
        if (r4.a(r2) == true) goto L11;
        return;
    L11:
        if (r5.c(r2) == true) goto L13;
        return;
    L13:
        Iterator<? extends N> r0 = r3.a(r2).iterator();
    L15:
        if (r0.hasNext() == false) goto L17;
        d(r0.next(), r3, r4, r5);
        goto L15
    L17:
        r5.b(r2);
        return;
    L21:
        a(24);
        throw null;
    L23:
        a(23);
        throw null;
    L25:
        a(22);
        throw null;
    }

    public static <N> Boolean e(Collection<N> r2, c<N> r3, l<N, Boolean> r4) {
        if (r2 == null) goto L12;
        if (r3 == null) goto L10;
        if (r4 != null) goto L7;
        a(9);
        throw null;
    L7:
        return (Boolean) b(r2, r3, new a(r4, new boolean[1]));
    L10:
        a(8);
        throw null;
    L12:
        a(7);
        throw null;
    }
}
