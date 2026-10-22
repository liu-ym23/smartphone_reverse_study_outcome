package kotlin.s0.w.d.l0.e.a;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f19662a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlin.s0.w.d.l0.g.c f19663b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.b f19664c = null;

    static {
        f19662a = new z();
        kotlin.s0.w.d.l0.g.c r0 = new kotlin.s0.w.d.l0.g.c("kotlin.jvm.JvmField");
        f19663b = r0;
        kotlin.n0.d.o.e(kotlin.s0.w.d.l0.g.b.m(r0), "topLevel(JVM_FIELD_ANNOTATION_FQ_NAME)");
        kotlin.n0.d.o.e(kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("kotlin.reflect.jvm.internal.ReflectionFactoryImpl")), "topLevel(FqName(\"kotlin.….ReflectionFactoryImpl\"))");
        kotlin.s0.w.d.l0.g.b r1 = kotlin.s0.w.d.l0.g.b.e("kotlin/jvm/internal/RepeatableContainer");
        kotlin.n0.d.o.e(r1, "fromString(\"kotlin/jvm/i…nal/RepeatableContainer\")");
        f19664c = r1;
    }

    private z() {
    }

    public static final String b(String r2) {
        kotlin.n0.d.o.f(r2, "propertyName");
        if (f(r2) == false) goto L6;
        return r2;
    L6:
        return "get" + kotlin.s0.w.d.l0.o.u.a.a(r2);
    }

    public static final boolean c(String r4) {
        kotlin.n0.d.o.f(r4, "name");
        if (kotlin.u0.k.A(r4, "get", false, 2, null) == false) goto L5;
    L6:
        return true;
    L5:
        if (kotlin.u0.k.A(r4, "is", false, 2, null) == true) goto L6;
        return false;
    }

    public static final boolean d(String r4) {
        kotlin.n0.d.o.f(r4, "name");
        return kotlin.u0.k.A(r4, "set", false, 2, null);
    }

    public static final String e(String r2) {
        kotlin.n0.d.o.f(r2, "propertyName");
        StringBuilder r0 = new StringBuilder();
        r0.append("set");
        if (f(r2) == false) goto L5;
        String r3 = r2.substring(2);
        kotlin.n0.d.o.e(r3, "this as java.lang.String).substring(startIndex)");
    L6:
        r0.append(r3);
        return r0.toString();
    L5:
        r3 = kotlin.s0.w.d.l0.o.u.a.a(r2);
        goto L6
    }

    public static final boolean f(String r4) {
        kotlin.n0.d.o.f(r4, "name");
        if (kotlin.u0.k.A(r4, "is", false, 2, null) == true) goto L6;
        return false;
    L6:
        if (r4.length() != 2) goto L8;
        return false;
    L8:
        char r5 = r4.charAt(2);
        if (kotlin.n0.d.o.h(97, r5) <= 0) goto L11;
    L12:
        return true;
    L11:
        if (kotlin.n0.d.o.h(r5, 122) > 0) goto L12;
        return false;
    }

    public final kotlin.s0.w.d.l0.g.b a() {
        return f19664c;
    }
}
