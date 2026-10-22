package kotlin.s0.w.d.l0.c.s1.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f19098a = null;

    static {
        f19098a = new m();
    }

    private m() {
    }

    public final String a(Constructor<?> r5) {
        o.f(r5, "constructor");
        StringBuilder r4 = new StringBuilder();
        r4.append("(");
        Class<?>[] r6 = r5.getParameterTypes();
        o.e(r6, "constructor.parameterTypes");
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Class<?> r2 = r6[r1];
        o.e(r2, "parameterType");
        r4.append(kotlin.s0.w.d.l0.c.s1.b.d.b(r2));
        r1 = r1 + 1;
        goto L3
    L5:
        r4.append(")V");
        String r7 = r4.toString();
        o.e(r7, "sb.toString()");
        return r7;
    }

    public final String b(Field r1) {
        o.f(r1, "field");
        Class<?> r0 = r1.getType();
        o.e(r0, "field.type");
        return kotlin.s0.w.d.l0.c.s1.b.d.b(r0);
    }

    public final String c(Method r6) {
        o.f(r6, "method");
        StringBuilder r5 = new StringBuilder();
        r5.append("(");
        Class<?>[] r0 = r6.getParameterTypes();
        o.e(r0, "method.parameterTypes");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        Class<?> r3 = r0[r2];
        o.e(r3, "parameterType");
        r5.append(kotlin.s0.w.d.l0.c.s1.b.d.b(r3));
        r2 = r2 + 1;
        goto L3
    L5:
        r5.append(")");
        Class<?> r7 = r6.getReturnType();
        o.e(r7, "method.returnType");
        r5.append(kotlin.s0.w.d.l0.c.s1.b.d.b(r7));
        String r8 = r5.toString();
        o.e(r8, "sb.toString()");
        return r8;
    }
}
