package com.google.gson.internal.n;

import com.google.gson.k;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f7076a = null;

    /* JADX INFO: renamed from: com.google.gson.internal.n.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0214a {
    }

    private static abstract class b {
        private b() {
        }

        /* synthetic */ b(C0214a r1) {
            this();
        }

        public abstract Method a(Class<?> r1, Field r2);

        abstract <T> Constructor<T> b(Class<T> r1);

        abstract String[] c(Class<?> r1);

        abstract boolean d(Class<?> r1);
    }

    private static class c extends b {
        private c() {
            super(null);
        }

        /* synthetic */ c(C0214a r1) {
            this();
        }

        @Override // com.google.gson.internal.n.a.b
        public Method a(Class<?> r1, Field r2) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.n.a.b
        <T> Constructor<T> b(Class<T> r1) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.n.a.b
        String[] c(Class<?> r1) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.n.a.b
        boolean d(Class<?> r1) {
            return false;
        }
    }

    private static class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Method f7077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method f7078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f7079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Method f7080d;

        private d() {
            super(null);
            this.f7077a = Class.class.getMethod("isRecord", new Class[0]);
            Method r0 = Class.class.getMethod("getRecordComponents", new Class[0]);
            this.f7078b = r0;
            Class<?> r1 = r0.getReturnType().getComponentType();
            this.f7079c = r1.getMethod("getName", new Class[0]);
            this.f7080d = r1.getMethod("getType", new Class[0]);
        }

        /* synthetic */ d(C0214a r1) {
            this();
        }

        @Override // com.google.gson.internal.n.a.b
        public Method a(Class<?> r1, Field r2) {
            return r1.getMethod(r2.getName(), new Class[0]);
        L4:
            e = move-exception;
            a.a(e);
            throw null;
        }

        @Override // com.google.gson.internal.n.a.b
        public <T> Constructor<T> b(Class<T> r8) {
            Object[] r0 = (Object[]) this.f7078b.invoke(r8, new Object[0]);     // Catch: ReflectiveOperationException -> L8
            Class<?>[] r2 = new Class[r0.length];     // Catch: ReflectiveOperationException -> L8
            int r3 = 0;
        L4:
            if (r3 >= r0.length) goto L6;
            r2[r3] = (Class) this.f7080d.invoke(r0[r3], new Object[0]);     // Catch: ReflectiveOperationException -> L8
            r3 = r3 + 1;     // Catch: ReflectiveOperationException -> L8
            goto L4
        L6:
            return r8.getDeclaredConstructor(r2);
        L8:
            e = move-exception;
            a.a(e);
            throw null;
        }

        @Override // com.google.gson.internal.n.a.b
        String[] c(Class<?> r7) {
            Object[] r8 = (Object[]) this.f7078b.invoke(r7, new Object[0]);     // Catch: ReflectiveOperationException -> L8
            String[] r0 = new String[r8.length];     // Catch: ReflectiveOperationException -> L8
            int r2 = 0;
        L4:
            if (r2 >= r8.length) goto L7;
            r0[r2] = (String) this.f7079c.invoke(r8[r2], new Object[0]);     // Catch: ReflectiveOperationException -> L8
            r2 = r2 + 1;
            goto L4
        L7:
            return r0;
        L8:
            e = move-exception;
            a.a(e);
            throw null;
        }

        @Override // com.google.gson.internal.n.a.b
        boolean d(Class<?> r2) {
            return ((Boolean) this.f7077a.invoke(r2, new Object[0])).booleanValue();
        L4:
            e = move-exception;
            a.a(e);
            throw null;
        }
    }

    static {
        C0214a r0 = null;
        b r1 = new d(r0);     // Catch: NoSuchMethodException -> L5
    L6:
        f7076a = r1;
        return;
    L5:
        r1 = new c(r0);
        goto L6
    }

    static /* synthetic */ RuntimeException a(ReflectiveOperationException r0) {
        d(r0);
        throw null;
    }

    private static void b(AccessibleObject r2, StringBuilder r3) {
        r3.append('(');
        if ((r2 instanceof Method) == false) goto L5;
        Class<?>[] r4 = ((Method) r2).getParameterTypes();
    L6:
        int r0 = 0;
    L8:
        if (r0 >= r4.length) goto L12;
        if (r0 <= 0) goto L11;
        r3.append(", ");
    L11:
        r3.append(r4[r0].getSimpleName());
        r0 = r0 + 1;
        goto L8
    L12:
        r3.append(')');
        return;
    L5:
        r4 = ((Constructor) r2).getParameterTypes();
        goto L6
    }

    public static String c(Constructor<?> r2) {
        StringBuilder r0 = new StringBuilder(r2.getDeclaringClass().getName());
        b(r2, r0);
        return r0.toString();
    }

    private static RuntimeException d(ReflectiveOperationException r2) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", r2);
    }

    public static RuntimeException e(IllegalAccessException r2) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", r2);
    }

    public static String f(Field r2) {
        return r2.getDeclaringClass().getName() + "#" + r2.getName();
    }

    public static String g(AccessibleObject r4, boolean r5) {
        if ((r4 instanceof Field) == false) goto L8;
        StringBuilder r0 = new StringBuilder();
        r0.append("field '");
        String r6 = f((Field) r4);
    L5:
        r0.append(r6);
        r0.append("'");
    L6:
        String r7 = r0.toString();
    L14:
        if (r5 == true) goto L16;
        return r7;
    L16:
        if (Character.isLowerCase(r7.charAt(0)) == true) goto L18;
        return r7;
    L18:
        return Character.toUpperCase(r7.charAt(0)) + r7.substring(1);
    L8:
        if ((r4 instanceof Method) == false) goto L11;
        Method r8 = (Method) r4;
        StringBuilder r1 = new StringBuilder(r8.getName());
        b(r8, r1);
        r7 = "method '" + r8.getDeclaringClass().getName() + "#" + r1.toString() + "'";
        goto L14
    L11:
        if ((r4 instanceof Constructor) == false) goto L13;
        r0 = new StringBuilder();
        r0.append("constructor '");
        r6 = c((Constructor) r4);
        goto L5
    L13:
        r0 = new StringBuilder();
        r0.append("<unknown AccessibleObject> ");
        r0.append(r4.toString());
        goto L6
    }

    public static Method h(Class<?> r1, Field r2) {
        return f7076a.a(r1, r2);
    }

    public static <T> Constructor<T> i(Class<T> r1) {
        return f7076a.b(r1);
    }

    public static String[] j(Class<?> r1) {
        return f7076a.c(r1);
    }

    public static boolean k(Class<?> r1) {
        return f7076a.d(r1);
    }

    public static void l(AccessibleObject r4) {
        r4.setAccessible(true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new k("Failed making " + g(r4, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e);
    }

    public static String m(Constructor<?> r3) {
        r3.setAccessible(true);     // Catch: Exception -> L6
        return null;
    L6:
        e = move-exception;
        return "Failed making constructor '" + c(r3) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage();
    }
}
