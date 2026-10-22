package com.ttnet.org.chromium.base;

import android.annotation.SuppressLint;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Reflect {
    private final boolean isClass;
    private final Object object;

    public static class NULL {
        public NULL() {
        }
    }

    private Reflect(Class<?> r1) {
        this.object = r1;
        this.isClass = true;
    }

    public static /* synthetic */ Class[] access$000(Object[] r0) {
        return types(r0);
    }

    public static /* synthetic */ Object access$100(Reflect r0) {
        return r0.object;
    }

    public static /* synthetic */ String access$200(String r0) {
        return property(r0);
    }

    public static <T extends AccessibleObject> T accessible(T r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof Member) == false) goto L13;
        Member r0 = (Member) r2;
        if (Modifier.isPublic(r0.getModifiers()) == false) goto L13;
        if (Modifier.isPublic(r0.getDeclaringClass().getModifiers()) == false) goto L13;
        return r2;
    L13:
        if (r2.isAccessible() == true) goto L15;
        r2.setAccessible(true);
    L15:
        return r2;
    }

    private Field field0(String r8, Class<?>... r9) {
        Class<?> r7 = type();
        if (r9 != null) goto L5;
    L37:
        return r7.getField(r8);
    L24:
        e = move-exception;
    L35:
        return (Field) accessible(r7.getDeclaredField(r8));
    L27:
        r7 = r7.getSuperclass();
        if (r7 != null) goto L35;
        throw new ReflectException(e);
    L5:
        if (r9.length <= 0) goto L37;
    L33:
        Field[] r0 = r7.getDeclaredFields();     // Catch: Exception -> L32
        int r1 = r0.length;     // Catch: Exception -> L32
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L17;
        Field r4 = r0[r3];     // Catch: Exception -> L32
        Class<?> r5 = r4.getType();     // Catch: Exception -> L32
        if (r5 == null) goto L16;
        if (r5.getName().equals(r9[0].getName()) == false) goto L16;
        if (r4.getName().equals(r8) == false) goto L16;
        return (Field) accessible(r4);
    L16:
        r3 = r3 + 1;
    L17:
        r7 = r7.getSuperclass();
        if (r7 != null) goto L33;
        throw new ReflectException("NoSuchFieldException");
    }

    private static Class<?> forName(String r1) {
        return Class.forName(r1);
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private boolean isSimilarSignature(Method r2, String r3, Class<?>[] r4) {
        if (r2.getName().equals(r3) == true) goto L5;
    L7:
        return false;
    L5:
        if (match(r2.getParameterTypes(), r4) == false) goto L7;
        return true;
    }

    private boolean match(Class<?>[] r4, Class<?>[] r5) {
        if (r4.length != r5.length) goto L16;
        int r3 = 0;
    L6:
        if (r3 >= r5.length) goto L14;
        if (r5[r3] == NULL.class) goto L12;
        if (wrapper(r4[r3]).isAssignableFrom(wrapper(r5[r3])) == true) goto L12;
        return false;
    L12:
        r3 = r3 + 1;
        goto L6
    L14:
        return true;
    L16:
        return false;
    }

    public static Reflect on(String r0) {
        return on(forName(r0));
    }

    @SuppressLint({"DefaultLocale"})
    private static String property(String r3) {
        int r0 = r3.length();
        if (r0 != 0) goto L7;
        return "";
    L7:
        if (r0 != 1) goto L11;
        return r3.toLowerCase();
    L11:
        return r3.substring(0, 1).toLowerCase() + r3.substring(1);
    }

    private Method similarMethod(String r8, Class<?>[] r9) {
        Class<?> r0 = type();
        Method[] r1 = r0.getMethods();
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L8;
        Method r5 = r1[r4];
        if (isSimilarSignature(r5, r8, r9) == true) goto L6;
        r4 = r4 + 1;
        goto L3
    L6:
        return r5;
    L8:
        Method[] r3 = r0.getDeclaredMethods();
        int r6 = r3.length;
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L14;
        Method r10 = r3[r7];
        if (isSimilarSignature(r10, r8, r9) == true) goto L12;
        r7 = r7 + 1;
        goto L9
    L12:
        return r10;
    L14:
        r0 = r0.getSuperclass();
        if (r0 != null) goto L8;
        StringBuilder r11 = a.a.u("No similar method ", r8, " with params ");
        r11.append(Arrays.toString(r9));
        r11.append(" could be found on type ");
        r11.append(type());
        r11.append(LibrarianImpl.Constants.DOT);
        throw new NoSuchMethodException(r11.toString());
    }

    private static Class<?>[] types(Object... r3) {
        int r0 = 0;
        if (r3 == null) goto L5;
        Class<?>[] r1 = new Class[r3.length];
    L8:
        if (r0 >= r3.length) goto L14;
        Object r2 = r3[r0];
        if (r2 != null) goto L12;
        Class<?> r4 = NULL.class;
    L13:
        r1[r0] = r4;
        r0 = r0 + 1;
        goto L8
    L12:
        r4 = r2.getClass();
        goto L13
    L14:
        return r1;
    L5:
        return new Class[0];
    }

    private static Object unwrap(Object r1) {
        if ((r1 instanceof Reflect) == true) goto L5;
        return r1;
    L5:
        return ((Reflect) r1).get();
    }

    public static Class<?> wrapper(Class<?> r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.isPrimitive() == true) goto L8;
        return r1;
    L8:
        if (Boolean.TYPE != r1) goto L12;
        return Boolean.class;
    L12:
        if (Integer.TYPE != r1) goto L16;
        return Integer.class;
    L16:
        if (Long.TYPE != r1) goto L20;
        return Long.class;
    L20:
        if (Short.TYPE != r1) goto L24;
        return Short.class;
    L24:
        if (Byte.TYPE != r1) goto L28;
        return Byte.class;
    L28:
        if (Double.TYPE != r1) goto L32;
        return Double.class;
    L32:
        if (Float.TYPE != r1) goto L36;
        return Float.class;
    L36:
        if (Character.TYPE != r1) goto L40;
        return Character.class;
    L40:
        if (Void.TYPE != r1) goto L44;
        return Void.class;
    L44:
        return r1;
    }

    public <P> P as(Class<P> r3) {
        final boolean r0 = this.object instanceof Map;
        InvocationHandler r1 = new AnonymousClass1(this, r0);
        return (P) Proxy.newProxyInstance(r3.getClassLoader(), new Class[]{r3}, r1);
    }

    public Reflect call(String r3) {
        return call(r3, null, new Object[0]);
    }

    public Reflect create() {
        return create(new Object[0]);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof Reflect) == true) goto L5;
        return false;
    L5:
        return this.object.equals(((Reflect) r2).get());
    }

    public Field exactField(String r1, Class<?>... r2) {
        return field0(r1, r2);
    }

    public Method exactMethod(String r13, Class<?>[] r14, Object... r15) {
        Class<?> r16 = type();
        return r16.getMethod(r13, r14);
    L25:
        return r16.getDeclaredMethod(r13, r14);
    L7:
        r16 = r16.getSuperclass();
        if (r16 != null) goto L25;
        Class<?> r12 = this.type();
        Method[] r17 = r12.getMethods();
        int r0 = r17.length;
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L21;
        Method r3 = r17[r2];
        if (r13.equals(r3.getName()) == false) goto L19;
        Class<?>[] r4 = r3.getParameterTypes();
        int r5 = r4.length;
        int r7 = 0;
        int r8 = 1;
    L14:
        if (r7 >= r5) goto L17;
        Log.d("Plugin", "Reflect type = " + r12 + " method = " + r13 + " paramTypes " + r8 + " = " + r4[r7].getName(), new Object[0]);
        r8 = r8 + 1;
        r7 = r7 + 1;
        goto L14
    L17:
        if (r4.length != r14.length) goto L19;
        return r3;
    L19:
        r2 = r2 + 1;
        goto L10
    L21:
        throw new NoSuchMethodException();
    }

    public Reflect field(String r1, Class<?>... r2) {
        return on(field0(r1, r2).get(this.object));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Map<String, Reflect> fields() {
        LinkedHashMap r0 = new LinkedHashMap();
        Class<?> r1 = type();
    L3:
        Field[] r2 = r1.getDeclaredFields();
        int r3 = r2.length;
        int r5 = 0;
    L4:
        if (r5 >= r3) goto L11;
        Field r6 = r2[r5];
        if (((!this.isClass) ^ Modifier.isStatic(r6.getModifiers())) == false) goto L10;
        String r7 = r6.getName();
        if (r0.containsKey(r7) == true) goto L10;
        r0.put(r7, field(r7, new Class[0]));
    L10:
        r5 = r5 + 1;
        goto L4
    L11:
        r1 = r1.getSuperclass();
        if (r1 != null) goto L3;
        return r0;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public Reflect set(String r2, Object r3) {
        field0(r2, new Class[0]).set(this.object, unwrap(r3));     // Catch: Exception -> L5
        return this;
    L5:
        e = move-exception;
        throw new ReflectException(e);
    }

    public String toString() {
        return this.object.toString();
    }

    public Class<?> type() {
        if (this.isClass == false) goto L7;
        return (Class) this.object;
    L7:
        return this.object.getClass();
    }

    public static Reflect on(Class<?> r1) {
        return new Reflect(r1);
    }

    public Reflect call(String r3, Class<?>[] r4, Object... r5) {
        return on(exactMethod(r3, r4, r5), this.object, r5);
    L4:
        return on(similarMethod(r3, r4), this.object, r5);
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Reflect create(Object... r8) {
        Class<?>[] r0 = types(r8);
        return on(type().getDeclaredConstructor(r0), r8);
    L5:
        e = move-exception;
        Constructor<?>[] r2 = type().getDeclaredConstructors();
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L14;
        Constructor<?> r5 = r2[r4];
        if (match(r5.getParameterTypes(), r0) == true) goto L11;
        r4 = r4 + 1;
        goto L7
    L11:
        return on(r5, r8);
    L14:
        throw new ReflectException(e);
    }

    public <T> T get(String r1, Class<?>... r2) {
        return (T) field(r1, r2).get();
    }

    public static Reflect on(Object r1) {
        return new Reflect(r1);
    }

    private Reflect(Object r1) {
        this.object = r1;
        this.isClass = false;
    }

    private static Reflect on(Constructor<?> r0, Object... r1) {
        return on(((Constructor) accessible(r0)).newInstance(r1));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private static Reflect on(Method r2, Object r3, Object... r4) {
        accessible(r2);     // Catch: Exception -> L6
        if (r2.getReturnType() != Void.TYPE) goto L9;
        r2.invoke(r3, r4);     // Catch: Exception -> L6
        return on(r3);
    L9:
        return on(r2.invoke(r3, r4));
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }
}
