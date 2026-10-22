package d.b.p.a.h;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Method> f14310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<Class<?>, Class<?>> f14311b = null;

    static {
        f14310a = new HashMap();
        HashMap<Class<?>, Class<?>> r0 = new HashMap();
        f14311b = r0;
        r0.put(Boolean.TYPE, Boolean.class);
        r0.put(Byte.TYPE, Byte.class);
        r0.put(Character.TYPE, Character.class);
        r0.put(Short.TYPE, Short.class);
        r0.put(Integer.TYPE, Integer.class);
        r0.put(Long.TYPE, Long.class);
        r0.put(Double.TYPE, Double.class);
        r0.put(Float.TYPE, Float.class);
        r0.put(Void.TYPE, Void.class);
    }

    public static Method a(Class<?> r13, String r14, Class... r15) {
        f.b(r13, "The class must not be null");
        f.c(!TextUtils.isEmpty(r14), "The method name must not be blank");
        String r0 = b(r13, r14, r15);
        Map<String, Method> r2 = f14310a;
        monitor-enter(r2);
        Method r3 = f14310a.get(r0);     // Catch: Throwable -> L54
        monitor-exit(r2);     // Catch: Throwable -> L54
        if (r3 != null) goto L8;
    L11:
        if (r13 == null) goto L52;
        if (e.a() == true) goto L15;
    L18:
        r3 = r13.getDeclaredMethod(r14, r15);     // Catch: NoSuchMethodException -> L57
        goto L19
    L15:
        if (c.a() == null) goto L18;
        r3 = c.a().a(r13, r14, r15);     // Catch: NoSuchMethodException -> L57
        if (r3 == null) goto L18;
    L19:
        if (r3 != null) goto L42;
        Method[] r4 = r13.getDeclaredMethods();
        if (r4 == null) goto L42;
        int r5 = r4.length;
        int r6 = 0;
    L23:
        if (r6 >= r5) goto L42;
        Method r7 = r4[r6];
        if (r7 == null) goto L41;
        if (TextUtils.equals(r7.getName(), r14) == false) goto L41;
        Class<?>[] r8 = r7.getParameterTypes();
        if (r15 == null) goto L41;
        if (r15.length != r8.length) goto L41;
        boolean r10 = true;
        int r9 = 0;
    L34:
        if (r9 >= r15.length) goto L39;
        if (e(r15[r9], r8[r9]) == true) goto L38;
        r10 = false;
    L38:
        r9 = r9 + 1;
        goto L34
    L39:
        if (r10 == false) goto L41;
        r3 = r7;
    L41:
        r6 = r6 + 1;
    L42:
        if (r3 != null) goto L43;
        r13 = r13.getSuperclass();
        goto L11
    L43:
        r3.setAccessible(true);
        Map<String, Method> r11 = f14310a;
        monitor-enter(r11);
        f14310a.put(r0, r3);     // Catch: Throwable -> L48
        monitor-exit(r11);     // Catch: Throwable -> L48
        return r3;
    L48:
        th = move-exception;
        throw th;
    L52:
        return null;
    L8:
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3;
    L54:
        th = move-exception;
        throw th;
    }

    private static String b(Class<?> r3, String r4, Class... r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r3.toString());
        r0.append("#");
        r0.append(r4);
        if (r5 != null) goto L5;
    L9:
        r0.append(Void.class.toString());
    L11:
        return r0.toString();
    L5:
        if (r5.length <= 0) goto L9;
        int r6 = r5.length;
        int r1 = 0;
    L7:
        if (r1 >= r6) goto L11;
        r0.append(r5[r1].toString());
        r0.append("#");
        r1 = r1 + 1;
        goto L7
    }

    public static Object c(Class r1, String r2, Object... r3) {
        Object[] r4 = b.b(r3);
        return d(r1, r2, r4, b.c(r4));
    }

    private static Object d(Class r0, String r1, Object[] r2, Class<?>[] r3) {
        Class<?>[] r4 = b.a(r3);
        Object[] r5 = b.b(r2);
        Method r6 = a(r0, r1, r4);
        if (r6 != null) goto L5;
        return null;
    L5:
        return r6.invoke(null, r5);
    }

    public static boolean e(Class<?> r1, Class<?> r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r1 != null) goto L9;
        return !r2.isPrimitive();
    L9:
        if (r1.isPrimitive() == false) goto L14;
        if (r2.isPrimitive() == true) goto L14;
        r1 = f14311b.get(r1);
    L14:
        if (r2.isPrimitive() == false) goto L19;
        if (r1.isPrimitive() == true) goto L19;
        r2 = f14311b.get(r2);
    L19:
        return r2.isAssignableFrom(r1);
    }
}
