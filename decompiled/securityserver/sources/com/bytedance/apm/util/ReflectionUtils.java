package com.bytedance.apm.util;

import a.a;
import android.text.TextUtils;
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
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: loaded from: classes.dex */
public class ReflectionUtils {
    private final Class<?> clazz;
    private final boolean isClass;
    private final Object object;

    public static class NULL {
        private NULL() {
        }
    }

    private ReflectionUtils(Class<?> r1) {
        this.object = r1;
        this.clazz = r1;
        this.isClass = true;
    }

    public static /* synthetic */ Object access$000(ReflectionUtils r0) {
        return r0.object;
    }

    public static /* synthetic */ String access$100(String r0) {
        return property(r0);
    }

    private static <T extends AccessibleObject> T accessible(T r2) {
        if (r2.isAccessible() == true) goto L6;
        r2.setAccessible(true);
    L6:
        if ((r2 instanceof Member) == false) goto L10;
        Member r0 = (Member) r2;
        if (Modifier.isPublic(r0.getModifiers()) == false) goto L10;
        Modifier.isPublic(r0.getDeclaringClass().getModifiers());
    L10:
        return r2;
    }

    private ReflectionUtils callInner(String r4, Map<String, Vector<Method>> r5, Class<?>[] r6, Object... r7) {
        Vector<Method> r8 = r5.get(r4);
        if (r8 == null) goto L15;
        Iterator<Method> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L25;
        Method r0 = r9.next();
        if (r0 == null) goto L6;
        if (r0.getDeclaringClass().isAssignableFrom(type()) == false) goto L6;
        if (isSimilarSignature(r0, r4, r6) == false) goto L6;
        return on(r0, this.object, r7);
    L25:
        return null;
    L15:
        return null;
    }

    private Method exactMethod(String r3, Class<?>[] r4) {
        Class<?> r2 = type();
        return (Method) accessible(r2.getMethod(r3, r4));
    L5:
        e = move-exception;
    L13:
        return (Method) accessible(r2.getDeclaredMethod(r3, r4));
    L8:
        r2 = r2.getSuperclass();
        if (r2 != null) goto L13;
        throw new NoSuchMethodException(e.getMessage());
    }

    private ReflectionUtils field(String r1) {
        return on(field0(r1).get(this.object));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private Field field0(String r3) {
        Class<?> r2 = type();
        return (Field) accessible(r2.getField(r3));
    L5:
        e = move-exception;
    L13:
        return (Field) accessible(r2.getDeclaredField(r3));
    L8:
        r2 = r2.getSuperclass();
        if (r2 != null) goto L13;
        throw new ReflectException(e);
    }

    private static Class<?> forName(String r1) {
        return Class.forName(r1);
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private static Object[] getField(Object r9, String r10, boolean r11) {
        if (r9 != null) goto L5;
        return null;
    L5:
        String[] r12 = r10.split("[.]");
        Class<?> r0 = r9.getClass();
        Object[] r1 = new Object[2];
        int r2 = r12.length;
        int r4 = 0;
        int r5 = 0;
    L6:
        if (r4 >= r2) goto L18;
        String r6 = r12[r4];
        r5 = r5 + 1;
        Field r8 = getField_(r0, r6, r11);
        if (r8 == null) goto L17;
        r8.setAccessible(true);
        r1[0] = r8;
        r1[1] = r9;
        r9 = r8.get(r9);
        if (r9 == null) goto L12;
        r0 = r9.getClass();
        goto L17
    L12:
        if (r5 >= r12.length) goto L18;
        StringBuilder r13 = a.u("can not getFieldValue as field '", r6, "' value is null in '");
        r13.append(r0.getName());
        r13.append("'");
        throw new IllegalAccessException(r13.toString());
    L17:
        r4 = r4 + 1;
    L18:
        return r1;
    }

    public static <T> T getFieldValue(Object r1, String r2) {
        return (T) getFieldValue(r1, r2, true);
    }

    public static Field getField_(Class<?> r4, String r5, boolean r6) {
        NoSuchFieldException e = null;
        Field r2 = r4.getDeclaredField(r5);     // Catch: NoSuchFieldException -> L9
        if (r6 == false) goto L27;
    L11:
        if (e == null) goto L24;
        if (r6 == false) goto L23;
    L13:
        r4 = r4.getSuperclass();
        if (r4 == null) goto L24;
        Field r7 = r4.getDeclaredField(r5);     // Catch: NoSuchFieldException -> L18
        r7.setAccessible(true);     // Catch: NoSuchFieldException -> L18
        return r7;
    L18:
        e = move-exception;
        if (r4.getSuperclass() != null) goto L13;
        throw e;
    L23:
        throw e;
    L24:
        return r2;
    L27:
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L7
        return r2;
    L7:
        e = e;
    L9:
        e = move-exception;
        r2 = null;
        e = e;
        goto L11
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

    public static ReflectionUtils on(String r0) {
        return on(forName(r0));
    }

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

    private boolean same(Class<?>[] r4, Class<?>[] r5) {
        if (r4.length != r5.length) goto L16;
        int r3 = 0;
    L6:
        if (r3 >= r5.length) goto L14;
        if (r5[r3] == NULL.class) goto L12;
        if (TextUtils.equals(wrapper(r4[r3]).getName(), wrapper(r5[r3]).getName()) == true) goto L12;
        return false;
    L12:
        r3 = r3 + 1;
        goto L6
    L14:
        return true;
    L16:
        return false;
    }

    public static void setFieldValue(Object r1, String r2, Object r3) {
        setFieldValue(r1, r2, r3, true);
    }

    private Method similarMethod(String r8, Class<?>[] r9) {
        Class<?> r0 = type();
        Method[] r2 = r0.getMethods();     // Catch: NoClassDefFoundError -> L22
        int r3 = r2.length;     // Catch: NoClassDefFoundError -> L22
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L26;
        Method r5 = r2[r4];     // Catch: NoClassDefFoundError -> L22
        if (isSimilarSignature(r5, r8, r9) == true) goto L7;
        r4 = r4 + 1;
        goto L4
    L7:
        return (Method) accessible(r5);
    L26:
        Method[] r6 = r0.getDeclaredMethods();     // Catch: NoClassDefFoundError -> L23
        int r7 = r6.length;     // Catch: NoClassDefFoundError -> L23
        int r10 = 0;
    L11:
        if (r10 >= r7) goto L17;
        Method r11 = r6[r10];     // Catch: NoClassDefFoundError -> L23
        if (isSimilarSignature(r11, r8, r9) == true) goto L14;
        r10 = r10 + 1;
        goto L11
    L14:
        return (Method) accessible(r11);
    L17:
        r0 = r0.getSuperclass();
        if (r0 != null) goto L26;
        StringBuilder r12 = a.u("No similar method ", r8, " with params ");
        r12.append(Arrays.toString(r9));
        r12.append(" could be found on type ");
        r12.append(type());
        r12.append(LibrarianImpl.Constants.DOT);
        throw new NoSuchMethodException(r12.toString());
    }

    private Class<?> type() {
        Class<?> r0 = this.clazz;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.isClass == false) goto L10;
        return (Class) this.object;
    L10:
        return this.object.getClass();
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
        if ((r1 instanceof ReflectionUtils) == true) goto L5;
        return r1;
    L5:
        return ((ReflectionUtils) r1).get();
    }

    private static Class<?> wrapper(Class<?> r1) {
        if (r1.isPrimitive() == true) goto L5;
        return r1;
    L5:
        if (Boolean.TYPE != r1) goto L9;
        return Boolean.class;
    L9:
        if (Integer.TYPE != r1) goto L13;
        return Integer.class;
    L13:
        if (Long.TYPE != r1) goto L17;
        return Long.class;
    L17:
        if (Short.TYPE != r1) goto L21;
        return Short.class;
    L21:
        if (Byte.TYPE != r1) goto L25;
        return Byte.class;
    L25:
        if (Double.TYPE != r1) goto L29;
        return Double.class;
    L29:
        if (Float.TYPE != r1) goto L33;
        return Float.class;
    L33:
        if (Character.TYPE != r1) goto L37;
        return Character.class;
    L37:
        if (Void.TYPE != r1) goto L41;
        return Void.class;
    L41:
        return r1;
    }

    public <P> P as(Class<P> r3) {
        final boolean r0 = this.object instanceof Map;
        InvocationHandler r1 = new AnonymousClass1(this, r0);
        return (P) Proxy.newProxyInstance(r3.getClassLoader(), new Class[]{r3}, r1);
    }

    public ReflectionUtils call(String r2) {
        return call(r2, new Object[0]);
    }

    public ReflectionUtils create() {
        return create(new Object[0]);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof ReflectionUtils) == true) goto L5;
        return false;
    L5:
        return this.object.equals(((ReflectionUtils) r2).get());
    }

    public Map<String, ReflectionUtils> fields() {
        LinkedHashMap r0 = new LinkedHashMap();
        Class<?> r1 = type();
    L3:
        Field[] r2 = r1.getDeclaredFields();
        int r3 = r2.length;
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L11;
        Field r5 = r2[r4];
        if (((!this.isClass) ^ Modifier.isStatic(r5.getModifiers())) == false) goto L10;
        String r6 = r5.getName();
        if (r0.containsKey(r6) == true) goto L10;
        r0.put(r6, field(r6));
    L10:
        r4 = r4 + 1;
        goto L4
    L11:
        r1 = r1.getSuperclass();
        if (r1 != null) goto L3;
        return r0;
    }

    public <T> T get() {
        return (T) this.object;
    }

    public <T> T getNoException(String r1) {
        return (T) get(r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public ReflectionUtils set(String r2, Object r3) {
        Field r4 = field0(r2);     // Catch: Exception -> L6
        if (r4 == null) goto L8;
        r4.set(this.object, unwrap(r3));     // Catch: Exception -> L6
    L8:
        return this;
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }

    public ReflectionUtils setNoException(String r1, Object r2) {
        set(r1, r2);     // Catch: ReflectException -> L4
    L6:
        return this;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public String toString() {
        return this.object.toString();
    }

    public static <T> T getFieldValue(Object r0, String r1, boolean r2) {
        Object[] r3 = getField(r0, r1, r2);
        if (r3 == null) goto L7;
        return (T) ((Field) r3[0]).get(r3[1]);
    L7:
        throw new NoSuchFieldException(a.A("field:", r1));
    }

    public static ReflectionUtils on(Class<?> r1) {
        return new ReflectionUtils(r1);
    }

    public static void setFieldValue(Object r0, String r1, Object r2, boolean r3) {
        Object[] r4 = getField(r0, r1, r3);
        if (r4 == null) goto L7;
        ((Field) r4[0]).set(r4[1], r2);
        return;
    L7:
        throw new NoSuchFieldException(a.A("field:", r1));
    }

    public ReflectionUtils call(String r2, Object... r3) {
        return call(r2, null, null, r3);
    }

    public ReflectionUtils create(Object... r8) {
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

    public <T> T get(String r1) {
        return (T) field(r1).get();
    }

    public static ReflectionUtils on(Object r1) {
        return new ReflectionUtils(r1);
    }

    public ReflectionUtils call(String r4, Map<String, Vector<Method>> r5, Class<?>[] r6, Object... r7) {
        Class<?>[] r0 = types(r7);
        if (r5 != null) goto L33;
    L7:
        if (r6 != null) goto L36;
        Method r8 = exactMethod(r4, r0);     // Catch: NoSuchMethodException -> L20
    L12:
        if (r5 == null) goto L18;
        if (r8 == null) goto L18;
        Vector<Method> r2 = r5.get(r4);     // Catch: NoSuchMethodException -> L20
        if (r2 != null) goto L17;
        r2 = new Vector(4);     // Catch: NoSuchMethodException -> L20
        r5.put(r4, r2);     // Catch: NoSuchMethodException -> L20
    L17:
        r2.add(r8);     // Catch: NoSuchMethodException -> L20
    L18:
        return on(r8, this.object, r7);
    L20:
        Method r9 = similarMethod(r4, r0);     // Catch: NoSuchMethodException -> L26
        if (r5 == null) goto L29;
        if (r9 == null) goto L29;
        Vector<Method> r1 = r5.get(r4);     // Catch: NoSuchMethodException -> L26
        if (r1 != null) goto L28;
        r1 = new Vector(4);     // Catch: NoSuchMethodException -> L26
        r5.put(r4, r1);     // Catch: NoSuchMethodException -> L26
    L28:
        r1.add(r9);     // Catch: NoSuchMethodException -> L26
    L29:
        return on(r9, this.object, r7);
    L26:
        e = move-exception;
        throw new ReflectException(e);
    L36:
        r8 = exactMethod(r4, r6);     // Catch: NoSuchMethodException -> L10
    L10:
        r8 = exactMethod(r4, r0);     // Catch: NoSuchMethodException -> L20
        goto L12
    L33:
        ReflectionUtils r3 = callInner(r4, r5, r0, r7);     // Catch: NoSuchMethodException -> L20
        if (r3 == null) goto L7;
        return r3;
    }

    public static ReflectionUtils on(Object r1, Class<?> r2) {
        return new ReflectionUtils(r1, r2);
    }

    private ReflectionUtils(Object r1) {
        this.object = r1;
        if (r1 == null) goto L5;
        Class<?> r2 = r1.getClass();
    L6:
        this.clazz = r2;
        this.isClass = false;
        return;
    L5:
        r2 = null;
        goto L6
    }

    private static ReflectionUtils on(Constructor<?> r0, Object... r1) {
        return on(((Constructor) accessible(r0)).newInstance(r1));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    private static ReflectionUtils on(Method r2, Object r3, Object... r4) {
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

    private ReflectionUtils(Object r1, Class<?> r2) {
        this.object = r1;
        this.clazz = r2;
        this.isClass = false;
    }
}
