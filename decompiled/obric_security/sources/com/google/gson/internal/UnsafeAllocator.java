package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UnsafeAllocator {
    public static final UnsafeAllocator INSTANCE = null;

    public abstract <T> T newInstance(Class<T> r1) throws Exception;

    public UnsafeAllocator() {
    }

    static /* synthetic */ void access$000(Class r0) {
        assertInstantiable(r0);
    }

    private static void assertInstantiable(Class<?> r3) {
        String r4 = ConstructorConstructor.checkInstantiable(r3);
        if (r4 != null) goto L6;
        return;
    L6:
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + r4);
    }

    static {
        INSTANCE = create();
    }

    private static UnsafeAllocator create() {
        Class<?> r4 = Class.forName("sun.misc.Unsafe");     // Catch: Exception -> L5
        Field r5 = r4.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r5.setAccessible(true);     // Catch: Exception -> L5
        final Object r6 = r5.get(null);     // Catch: Exception -> L5
        final Method r7 = r4.getMethod("allocateInstance", new Class[]{Class.class});     // Catch: Exception -> L5
        return new AnonymousClass1(r7, r6);
    L14:
        Method r8 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});     // Catch: Exception -> L8
        r8.setAccessible(true);     // Catch: Exception -> L8
        final int r1 = ((Integer) r8.invoke(null, new Object[]{Object.class})).intValue();     // Catch: Exception -> L8
        final Method r9 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});     // Catch: Exception -> L8
        r9.setAccessible(true);     // Catch: Exception -> L8
        return new AnonymousClass2(r9, r1);
    L8:
        final Method r0 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});     // Catch: Exception -> L10
        r0.setAccessible(true);     // Catch: Exception -> L10
        return new AnonymousClass3(r0);
    L11:
        return new AnonymousClass4();
    }
}
