package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnsafeAllocator {
    public UnsafeAllocator() {
    }

    public static void assertInstantiable(Class<?> r2) {
        int r0 = r2.getModifiers();
        if (Modifier.isInterface(r0) == true) goto L10;
        if (Modifier.isAbstract(r0) == true) goto L8;
        return;
    L8:
        throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: ".concat(r2.getName()));
    L10:
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: ".concat(r2.getName()));
    }

    public static UnsafeAllocator create() {
        Class<?> r5 = Class.forName("sun.misc.Unsafe");     // Catch: Exception -> L5
        Field r6 = r5.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r6.setAccessible(true);     // Catch: Exception -> L5
        final Object r7 = r6.get(null);     // Catch: Exception -> L5
        final Method r8 = r5.getMethod("allocateInstance", new Class[]{Class.class});     // Catch: Exception -> L5
        return new AnonymousClass1(r8, r7);
    L5:
        Method r9 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});     // Catch: Exception -> L7
        r9.setAccessible(true);     // Catch: Exception -> L7
        final int r3 = ((Integer) r9.invoke(null, new Object[]{Object.class})).intValue();     // Catch: Exception -> L7
        final Method r1 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});     // Catch: Exception -> L7
        r1.setAccessible(true);     // Catch: Exception -> L7
        return new AnonymousClass2(r1, r3);
    L7:
        final Method r0 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});     // Catch: Exception -> L9
        r0.setAccessible(true);     // Catch: Exception -> L9
        return new AnonymousClass3(r0);
    L10:
        return new AnonymousClass4();
    }

    public abstract <T> T newInstance(Class<T> r1);
}
