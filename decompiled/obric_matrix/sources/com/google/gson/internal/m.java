package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f7070a = null;

    class a extends m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f7071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f7072c;

        a(Method r1, Object r2) {
            this.f7071b = r1;
            this.f7072c = r2;
        }

        @Override // com.google.gson.internal.m
        public <T> T d(Class<T> r4) {
            m.a(r4);
            return (T) this.f7071b.invoke(this.f7072c, new Object[]{r4});
        }
    }

    class b extends m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f7073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f7074c;

        b(Method r1, int r2) {
            this.f7073b = r1;
            this.f7074c = r2;
        }

        @Override // com.google.gson.internal.m
        public <T> T d(Class<T> r4) {
            m.a(r4);
            return (T) this.f7073b.invoke(null, new Object[]{r4, Integer.valueOf(this.f7074c)});
        }
    }

    class c extends m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Method f7075b;

        c(Method r1) {
            this.f7075b = r1;
        }

        @Override // com.google.gson.internal.m
        public <T> T d(Class<T> r3) {
            m.a(r3);
            return (T) this.f7075b.invoke(null, new Object[]{r3, Object.class});
        }
    }

    class d extends m {
        d() {
        }

        @Override // com.google.gson.internal.m
        public <T> T d(Class<T> r3) {
            throw new UnsupportedOperationException("Cannot allocate " + r3 + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    static {
        f7070a = c();
    }

    public m() {
    }

    static /* synthetic */ void a(Class r0) {
        b(r0);
    }

    private static void b(Class<?> r3) {
        String r4 = com.google.gson.internal.c.a(r3);
        if (r4 != null) goto L6;
        return;
    L6:
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + r4);
    }

    private static m c() {
        Class<?> r4 = Class.forName("sun.misc.Unsafe");     // Catch: Exception -> L5
        Field r5 = r4.getDeclaredField("theUnsafe");     // Catch: Exception -> L5
        r5.setAccessible(true);     // Catch: Exception -> L5
        return new a(r4.getMethod("allocateInstance", new Class[]{Class.class}), r5.get(null));
    L14:
        Method r6 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[]{Class.class});     // Catch: Exception -> L8
        r6.setAccessible(true);     // Catch: Exception -> L8
        int r1 = ((Integer) r6.invoke(null, new Object[]{Object.class})).intValue();     // Catch: Exception -> L8
        Method r7 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Integer.TYPE});     // Catch: Exception -> L8
        r7.setAccessible(true);     // Catch: Exception -> L8
        return new b(r7, r1);
    L8:
        Method r0 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[]{Class.class, Class.class});     // Catch: Exception -> L10
        r0.setAccessible(true);     // Catch: Exception -> L10
        return new c(r0);
    L11:
        return new d();
    }

    public abstract <T> T d(Class<T> r1);
}
