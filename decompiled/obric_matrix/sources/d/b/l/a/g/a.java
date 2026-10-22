package d.b.l.a.g;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f14097a = null;

    /* JADX INFO: renamed from: d.b.l.a.g.a$a, reason: collision with other inner class name */
    public static class C0374a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends T> f14098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f14099b;
    }

    static {
        HashMap r0 = new HashMap();
        f14097a = r0;
        Class r2 = Boolean.TYPE;
        r0.put(Boolean.class, r2);
        r0.put(Byte.class, Byte.TYPE);
        r0.put(Character.class, Character.TYPE);
        r0.put(Short.class, Short.TYPE);
        Class r3 = Integer.TYPE;
        r0.put(Integer.class, r3);
        Class r4 = Float.TYPE;
        r0.put(Float.class, r4);
        Class r5 = Long.TYPE;
        r0.put(Long.class, r5);
        r0.put(Double.class, Double.TYPE);
        r0.put(r2, r2);
        Class r1 = Byte.TYPE;
        r0.put(r1, r1);
        Class r6 = Character.TYPE;
        r0.put(r6, r6);
        Class r7 = Short.TYPE;
        r0.put(r7, r7);
        r0.put(r3, r3);
        r0.put(r4, r4);
        r0.put(r5, r5);
        Class r8 = Double.TYPE;
        r0.put(r8, r8);
    }

    public static <T> T a(String r2, String r3, Object... r4) {
        return (T) b(Class.forName(r2), r3, r4);
    L4:
        e = move-exception;
        Log.w("JavaCalls", "Meet exception when call Method '" + r3 + "' in " + r2, e);
        return null;
    }

    public static <T> T b(Class<?> r1, String r2, Object... r3) {
        return (T) e(r1, r2, f(r3)).invoke(null, g(r3));
    }

    private static boolean c(Class<?>[] r6, Class<?>[] r7) {
        if (r6 != null) goto L10;
        if (r7 != null) goto L6;
        return true;
    L6:
        if (r7.length != 0) goto L9;
        return true;
    L9:
        return false;
    L10:
        if (r7 != null) goto L17;
        if (r6.length != 0) goto L15;
        return true;
    L15:
        return false;
    L17:
        if (r6.length == r7.length) goto L19;
        return false;
    L19:
        int r2 = 0;
    L21:
        if (r2 >= r6.length) goto L30;
        if (r6[r2].isAssignableFrom(r7[r2]) == true) goto L29;
        Map<Class<?>, Class<?>> r3 = f14097a;
        if (r3.containsKey(r6[r2]) == false) goto L28;
        if (r3.get(r6[r2]).equals(r3.get(r7[r2])) == true) goto L29;
    L28:
        return false;
    L29:
        r2 = r2 + 1;
        goto L21
    L30:
        return true;
    }

    private static Method d(Method[] r4, String r5, Class<?>[] r6) {
        Objects.requireNonNull(r5, "Method name must not be null.");
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Method r2 = r4[r1];
        if (r2.getName().equals(r5) == false) goto L9;
        if (c(r2.getParameterTypes(), r6) == false) goto L9;
        return r2;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    private static Method e(Class<?> r1, String r2, Class<?>... r3) {
        Method r0 = d(r1.getDeclaredMethods(), r2, r3);
        if (r0 == null) goto L5;
        r0.setAccessible(true);
        return r0;
    L5:
        if (r1.getSuperclass() == null) goto L9;
        return e(r1.getSuperclass(), r2, r3);
    L9:
        throw new NoSuchMethodException();
    }

    private static Class<?>[] f(Object... r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r5.length <= 0) goto L25;
        Class<?>[] r1 = new Class[r5.length];
        int r2 = 0;
    L8:
        if (r2 >= r5.length) goto L20;
        Object r3 = r5[r2];
        if (r3 != null) goto L12;
    L14:
        if (r3 != null) goto L16;
        Class<?> r4 = null;
    L17:
        r1[r2] = r4;
    L18:
        r2 = r2 + 1;
        goto L8
    L16:
        r4 = r3.getClass();
        goto L17
    L12:
        if ((r3 instanceof C0374a) == false) goto L14;
        r1[r2] = ((C0374a) r3).f14098a;
        goto L18
    L20:
        return r1;
    L25:
        return null;
    }

    private static Object[] g(Object... r4) {
        if (r4 != null) goto L4;
    L15:
        return null;
    L4:
        if (r4.length <= 0) goto L15;
        Object[] r0 = new Object[r4.length];
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L20;
        Object r2 = r4[r1];
        if (r2 != null) goto L11;
    L13:
        r0[r1] = r2;
    L14:
        r1 = r1 + 1;
        goto L7
    L11:
        if ((r2 instanceof C0374a) == false) goto L13;
        r0[r1] = ((C0374a) r2).f14099b;
        goto L14
    L20:
        return r0;
    }
}
