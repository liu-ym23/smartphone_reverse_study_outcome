package com.google.gson.internal;

import com.google.gson.u;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Type, com.google.gson.f<?>> f7025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7026b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<u> f7027c;

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements com.google.gson.internal.h<T> {
        a() {
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements com.google.gson.internal.h<T> {
        b() {
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.gson.internal.c$c, reason: collision with other inner class name */
    class C0212c<T> implements com.google.gson.internal.h<T> {
        C0212c() {
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class d<T> implements com.google.gson.internal.h<T> {
        d() {
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class e<T> implements com.google.gson.internal.h<T> {
        e() {
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class f<T> implements com.google.gson.internal.h<T> {
        f() {
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class g<T> implements com.google.gson.internal.h<T> {
        g() {
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class h<T> implements com.google.gson.internal.h<T> {
        h() {
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class i<T> implements com.google.gson.internal.h<T> {
        i() {
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) new com.google.gson.internal.g();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class j<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f7028a;

        j(c r1, Class r2) {
            this.f7028a = r2;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) com.google.gson.internal.m.f7070a.d(this.f7028a);
        L4:
            e = move-exception;
            throw new RuntimeException("Unable to create instance of " + this.f7028a + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class k<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.f f7029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f7030b;

        k(c r1, com.google.gson.f r2, Type r3) {
            this.f7029a = r2;
            this.f7030b = r3;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) this.f7029a.a(this.f7030b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class l<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7031a;

        l(c r1, String r2) {
            this.f7031a = r2;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            throw new com.google.gson.k(this.f7031a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class m<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.gson.f f7032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f7033b;

        m(c r1, com.google.gson.f r2, Type r3) {
            this.f7032a = r2;
            this.f7033b = r3;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) this.f7032a.a(this.f7033b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class n<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7034a;

        n(c r1, String r2) {
            this.f7034a = r2;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            throw new com.google.gson.k(this.f7034a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class o<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7035a;

        o(c r1, String r2) {
            this.f7035a = r2;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            throw new com.google.gson.k(this.f7035a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class p<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f7036a;

        p(Type r1) {
            this.f7036a = r1;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            Type r0 = this.f7036a;
            if ((r0 instanceof ParameterizedType) == false) goto L11;
            Type r1 = ((ParameterizedType) r0).getActualTypeArguments()[0];
            if ((r1 instanceof Class) == false) goto L9;
            return (T) EnumSet.noneOf((Class) r1);
        L9:
            throw new com.google.gson.k("Invalid EnumSet type: " + this.f7036a.toString());
        L11:
            throw new com.google.gson.k("Invalid EnumSet type: " + this.f7036a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class q<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f7037a;

        q(Type r1) {
            this.f7037a = r1;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            Type r0 = this.f7037a;
            if ((r0 instanceof ParameterizedType) == false) goto L11;
            Type r1 = ((ParameterizedType) r0).getActualTypeArguments()[0];
            if ((r1 instanceof Class) == false) goto L9;
            return (T) new EnumMap((Class) r1);
        L9:
            throw new com.google.gson.k("Invalid EnumMap type: " + this.f7037a.toString());
        L11:
            throw new com.google.gson.k("Invalid EnumMap type: " + this.f7037a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class r<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7038a;

        r(String r1) {
            this.f7038a = r1;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            throw new com.google.gson.k(this.f7038a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class s<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7039a;

        s(String r1) {
            this.f7039a = r1;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            throw new com.google.gson.k(this.f7039a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class t<T> implements com.google.gson.internal.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f7040a;

        t(Constructor r1) {
            this.f7040a = r1;
        }

        @Override // com.google.gson.internal.h
        public T a() {
            return (T) this.f7040a.newInstance(new Object[0]);
        L5:
            e = move-exception;
            com.google.gson.internal.n.a.e(e);
            throw null;
        L11:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.internal.n.a.c(this.f7040a) + "' with no args", e);
        L8:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.internal.n.a.c(this.f7040a) + "' with no args", e.getCause());
        }
    }

    public c(Map<Type, com.google.gson.f<?>> r1, boolean r2, List<u> r3) {
        this.f7025a = r1;
        this.f7026b = r2;
        this.f7027c = r3;
    }

    static String a(Class<?> r2) {
        int r0 = r2.getModifiers();
        if (Modifier.isInterface(r0) == false) goto L8;
        StringBuilder r1 = new StringBuilder();
        String r3 = "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ";
    L5:
        r1.append(r3);
        r1.append(r2.getName());
        return r1.toString();
    L8:
        if (Modifier.isAbstract(r0) == false) goto L10;
        r1 = new StringBuilder();
        r3 = "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: ";
        goto L5
    L10:
        return null;
    }

    private static <T> com.google.gson.internal.h<T> c(Class<? super T> r4, u.a r5) {
        if (Modifier.isAbstract(r4.getModifiers()) == false) goto L5;
        return null;
    L5:
        boolean r0 = false;
        Constructor<? super T> r2 = r4.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L26
        u.a r3 = u.a.f7099f;
        if (r5 != r3) goto L10;
    L15:
        r0 = true;
    L16:
        if (r0 == false) goto L18;
        if (r5 != r3) goto L25;
        String r6 = com.google.gson.internal.n.a.m(r2);
        if (r6 == null) goto L25;
        return new s(r6);
    L25:
        return new t(r2);
    L18:
        return new r("Unable to invoke no-args constructor of " + r4 + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.");
    L10:
        if (com.google.gson.internal.k.a(r2, null) == false) goto L16;
        if (r5 != u.a.f7102i) goto L15;
        if (Modifier.isPublic(r2.getModifiers()) == false) goto L16;
    L26:
        return null;
    }

    private static <T> com.google.gson.internal.h<T> d(Type r1, Class<? super T> r2) {
        if (Collection.class.isAssignableFrom(r2) == false) goto L19;
        if (SortedSet.class.isAssignableFrom(r2) == false) goto L9;
        return new a();
    L9:
        if (Set.class.isAssignableFrom(r2) == false) goto L13;
        return new b();
    L13:
        if (Queue.class.isAssignableFrom(r2) == false) goto L17;
        return new C0212c();
    L17:
        return new d();
    L19:
        if (Map.class.isAssignableFrom(r2) == true) goto L21;
        return null;
    L21:
        if (ConcurrentNavigableMap.class.isAssignableFrom(r2) == false) goto L25;
        return new e();
    L25:
        if (ConcurrentMap.class.isAssignableFrom(r2) == false) goto L29;
        return new f();
    L29:
        if (SortedMap.class.isAssignableFrom(r2) == false) goto L33;
        return new g();
    L33:
        if ((r1 instanceof ParameterizedType) == false) goto L39;
        if (String.class.isAssignableFrom(com.google.gson.z.a.get(((ParameterizedType) r1).getActualTypeArguments()[0]).getRawType()) == true) goto L39;
        return new h();
    L39:
        return new i();
    }

    private static <T> com.google.gson.internal.h<T> e(Type r1, Class<? super T> r2) {
        if (EnumSet.class.isAssignableFrom(r2) == false) goto L7;
        return new p(r1);
    L7:
        if (r2 == EnumMap.class) goto L9;
        return null;
    L9:
        return new q(r1);
    }

    private <T> com.google.gson.internal.h<T> f(Class<? super T> r3) {
        if (this.f7026b == false) goto L7;
        return new j(this, r3);
    L7:
        return new l(this, "Unable to create instance of " + r3 + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.");
    }

    public <T> com.google.gson.internal.h<T> b(com.google.gson.z.a<T> r4) {
        Type r0 = r4.getType();
        Class<? super T> r5 = r4.getRawType();
        com.google.gson.f<?> r1 = this.f7025a.get(r0);
        if (r1 != null) goto L5;
        com.google.gson.f<?> r2 = this.f7025a.get(r5);
        if (r2 != null) goto L9;
        com.google.gson.internal.h<T> r3 = e(r0, r5);
        if (r3 == null) goto L13;
        return r3;
    L13:
        u.a r6 = com.google.gson.internal.k.b(this.f7027c, r5);
        com.google.gson.internal.h<T> r7 = c(r5, r6);
        if (r7 == null) goto L16;
        return r7;
    L16:
        com.google.gson.internal.h<T> r8 = d(r0, r5);
        if (r8 == null) goto L19;
        return r8;
    L19:
        String r9 = a(r5);
        if (r9 == null) goto L24;
        return new n(this, r9);
    L24:
        if (r6 != u.a.f7099f) goto L28;
        return f(r5);
    L28:
        return new o(this, "Unable to create instance of " + r5 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.");
    L9:
        return new m(this, r2, r0);
    L5:
        return new k(this, r1, r0);
    }

    public String toString() {
        return this.f7025a.toString();
    }
}
