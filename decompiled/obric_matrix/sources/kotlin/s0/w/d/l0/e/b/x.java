package kotlin.s0.w.d.l0.e.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f19797a = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<String, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f19798f = null;

        static {
            f19798f = new a();
        }

        a() {
            super(1);
        }

        public final CharSequence a(String r1) {
            kotlin.n0.d.o.f(r1, "it");
            return x.a(x.f19797a, r1);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ CharSequence invoke(String r1) {
            return a(r1);
        }
    }

    static {
        f19797a = new x();
    }

    private x() {
    }

    public static final /* synthetic */ String a(x r0, String r1) {
        return r0.c(r1);
    }

    private final String c(String r2) {
        if (r2.length() > 1) goto L5;
        return r2;
    L5:
        return 'L' + r2 + ';';
    }

    public final String[] b(String... r7) {
        kotlin.n0.d.o.f(r7, "signatures");
        ArrayList r6 = new ArrayList(r7.length);
        int r0 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r6.add("<init>(" + r7[r2] + ")V");
        r2 = r2 + 1;
        goto L3
    L5:
        Object[] r8 = r6.toArray(new String[0]);
        kotlin.n0.d.o.d(r8, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) r8;
    }

    public final Set<String> d(String r6, String... r7) {
        kotlin.n0.d.o.f(r6, "internalName");
        kotlin.n0.d.o.f(r7, "signatures");
        LinkedHashSet r5 = new LinkedHashSet();
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.add(r6 + '.' + r7[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        return r5;
    }

    public final Set<String> e(String r2, String... r3) {
        kotlin.n0.d.o.f(r2, "name");
        kotlin.n0.d.o.f(r3, "signatures");
        return d(h(r2), (String[]) Arrays.copyOf(r3, r3.length));
    }

    public final Set<String> f(String r2, String... r3) {
        kotlin.n0.d.o.f(r2, "name");
        kotlin.n0.d.o.f(r3, "signatures");
        return d(i(r2), (String[]) Arrays.copyOf(r3, r3.length));
    }

    public final String g(String r2) {
        kotlin.n0.d.o.f(r2, "name");
        return "java/util/function/" + r2;
    }

    public final String h(String r2) {
        kotlin.n0.d.o.f(r2, "name");
        return "java/lang/" + r2;
    }

    public final String i(String r2) {
        kotlin.n0.d.o.f(r2, "name");
        return "java/util/" + r2;
    }

    public final String j(String r11, List<String> r12, String r13) {
        kotlin.n0.d.o.f(r11, "name");
        kotlin.n0.d.o.f(r12, "parameters");
        kotlin.n0.d.o.f(r13, "ret");
        return r11 + '(' + kotlin.i0.r.Z(r12, "", null, null, 0, null, a.f19798f, 30, null) + ')' + c(r13);
    }

    public final String k(String r1, String r2) {
        kotlin.n0.d.o.f(r1, "internalName");
        kotlin.n0.d.o.f(r2, "jvmDescriptor");
        return r1 + '.' + r2;
    }
}
