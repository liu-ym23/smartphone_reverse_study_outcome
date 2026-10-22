package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.d;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.c;
import com.google.gson.internal.h;
import com.google.gson.internal.j;
import com.google.gson.k;
import com.google.gson.n;
import com.google.gson.s;
import com.google.gson.u;
import com.google.gson.x;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements x {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f6952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final d f6953g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Excluder f6954h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f6955i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<u> f6956j;

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<String, b> f6957a;

        Adapter(Map<String, b> r1) {
            this.f6957a = r1;
        }

        @Override // com.google.gson.TypeAdapter
        public T b(com.google.gson.a0.a r5) {
            if (r5.k0() != com.google.gson.a0.b.n) goto L6;
            r5.g0();
            return null;
        L6:
            A r0 = e();
            r5.b();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
        L8:
            if (r5.L() == false) goto L18;
            String r1 = r5.Y();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            b r2 = this.f6957a.get(r1);     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            if (r2 == null) goto L16;
            if (r2.f6974e == false) goto L16;
            g(r0, r5, r2);     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
        L16:
            r5.u0();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            goto L8
        L18:
            r5.A();
            return f(r0);
        L20:
            e = move-exception;
            com.google.gson.internal.n.a.e(e);
            throw null;
        L23:
            e = move-exception;
            throw new s(e);
        }

        @Override // com.google.gson.TypeAdapter
        public void d(com.google.gson.a0.c r2, T r3) {
            if (r3 != null) goto L5;
            r2.O();
            return;
        L5:
            r2.l();
            Iterator<b> r1 = this.f6957a.values().iterator();     // Catch: IllegalAccessException -> L13
        L8:
            if (r1.hasNext() == false) goto L11;
            r1.next().c(r2, r3);     // Catch: IllegalAccessException -> L13
            goto L8
        L11:
            r2.A();
            return;
        L13:
            e = move-exception;
            com.google.gson.internal.n.a.e(e);
            throw null;
        }

        abstract A e();

        abstract T f(A r1);

        abstract void g(A r1, com.google.gson.a0.a r2, b r3);
    }

    private static final class FieldReflectionAdapter<T> extends Adapter<T, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h<T> f6958b;

        FieldReflectionAdapter(h<T> r1, Map<String, b> r2) {
            super(r2);
            this.f6958b = r1;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T e() {
            return this.f6958b.a();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        T f(T r1) {
            return r1;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        void g(T r1, com.google.gson.a0.a r2, b r3) {
            r3.b(r2, r1);
        }
    }

    private static final class RecordAdapter<T> extends Adapter<T, Object[]> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        static final Map<Class<?>, Object> f6959e = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Constructor<T> f6960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object[] f6961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<String, Integer> f6962d;

        static {
            f6959e = j();
        }

        RecordAdapter(Class<T> r4, Map<String, b> r5, boolean r6) {
            super(r5);
            this.f6962d = new HashMap();
            Constructor<T> r7 = com.google.gson.internal.n.a.i(r4);
            this.f6960b = r7;
            if (r6 == false) goto L5;
            ReflectiveTypeAdapterFactory.b(null, r7);
        L6:
            String[] r8 = com.google.gson.internal.n.a.j(r4);
            int r9 = 0;
            int r10 = 0;
        L8:
            if (r10 >= r8.length) goto L10;
            this.f6962d.put(r8[r10], Integer.valueOf(r10));
            r10 = r10 + 1;
            goto L8
        L10:
            Class<?>[] r11 = this.f6960b.getParameterTypes();
            this.f6961c = new Object[r11.length];
        L12:
            if (r9 >= r11.length) goto L14;
            this.f6961c[r9] = f6959e.get(r11[r9]);
            r9 = r9 + 1;
            goto L12
        L14:
            return;
        L5:
            com.google.gson.internal.n.a.l(r7);
            goto L6
        }

        private static Map<Class<?>, Object> j() {
            HashMap r0 = new HashMap();
            r0.put(Byte.TYPE, (byte) 0);
            r0.put(Short.TYPE, (short) 0);
            r0.put(Integer.TYPE, 0);
            r0.put(Long.TYPE, 0L);
            r0.put(Float.TYPE, Float.valueOf(0.0f));
            r0.put(Double.TYPE, Double.valueOf(0.0d));
            r0.put(Character.TYPE, (char) 0);
            r0.put(Boolean.TYPE, Boolean.FALSE);
            return r0;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* bridge */ /* synthetic */ Object[] e() {
            return h();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* bridge */ /* synthetic */ Object f(Object[] r1) {
            return i(r1);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        /* bridge */ /* synthetic */ void g(Object[] r1, com.google.gson.a0.a r2, b r3) {
            k(r1, r2, r3);
        }

        Object[] h() {
            return (Object[]) this.f6961c.clone();
        }

        T i(Object[] r6) {
            return this.f6960b.newInstance(r6);
        L11:
            e = move-exception;
            com.google.gson.internal.n.a.e(e);
            throw null;
        L8:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.internal.n.a.c(this.f6960b) + "' with args " + Arrays.toString(r6), e);
        L5:
            e = move-exception;
            throw new RuntimeException("Failed to invoke constructor '" + com.google.gson.internal.n.a.c(this.f6960b) + "' with args " + Arrays.toString(r6), e.getCause());
        }

        void k(Object[] r3, com.google.gson.a0.a r4, b r5) {
            Integer r0 = this.f6962d.get(r5.f6972c);
            if (r0 == null) goto L7;
            r5.a(r4, r0.intValue(), r3);
            return;
        L7:
            throw new IllegalStateException("Could not find the index in the constructor '" + com.google.gson.internal.n.a.c(this.f6960b) + "' for field with name '" + r5.f6972c + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    class a extends b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f6963f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Method f6964g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f6965h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ TypeAdapter f6966i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Gson f6967j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ com.google.gson.z.a f6968k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ boolean f6969l;
        final /* synthetic */ boolean m;

        a(ReflectiveTypeAdapterFactory r1, String r2, Field r3, boolean r4, boolean r5, boolean r6, Method r7, boolean r8, TypeAdapter r9, Gson r10, com.google.gson.z.a r11, boolean r12, boolean r13) {
            this.f6963f = r6;
            this.f6964g = r7;
            this.f6965h = r8;
            this.f6966i = r9;
            this.f6967j = r10;
            this.f6968k = r11;
            this.f6969l = r12;
            this.m = r13;
            super(r2, r3, r4, r5);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void a(com.google.gson.a0.a r3, int r4, Object[] r5) {
            Object r0 = this.f6966i.b(r3);
            if (r0 == null) goto L5;
        L9:
            r5[r4] = r0;
            return;
        L5:
            if (this.f6969l == false) goto L9;
            throw new n("null is not allowed as value for record component '" + this.f6972c + "' of primitive type; at path " + r3.getPath());
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void b(com.google.gson.a0.a r2, Object r3) {
            Object r4 = this.f6966i.b(r2);
            if (r4 != null) goto L7;
            if (this.f6969l == false) goto L7;
            return;
        L7:
            if (this.f6963f == false) goto L10;
            ReflectiveTypeAdapterFactory.b(r3, this.f6971b);
        L11:
            this.f6971b.set(r3, r4);
            return;
        L10:
            if (this.m == false) goto L11;
            throw new k("Cannot set value of 'static final' " + com.google.gson.internal.n.a.g(this.f6971b, false));
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void c(com.google.gson.a0.c r4, Object r5) {
            if (this.f6973d == true) goto L6;
            return;
        L6:
            if (this.f6963f == false) goto L11;
            AccessibleObject r0 = this.f6964g;
            if (r0 != null) goto L10;
            r0 = this.f6971b;
        L10:
            ReflectiveTypeAdapterFactory.b(r5, r0);
        L11:
            Method r1 = this.f6964g;
            if (r1 != null) goto L28;
            Object r2 = this.f6971b.get(r5);
        L20:
            if (r2 != r5) goto L22;
            return;
        L22:
            r4.M(this.f6970a);
            if (this.f6965h == false) goto L25;
            TypeAdapter r3 = this.f6966i;
        L26:
            r3.d(r4, r2);
            return;
        L25:
            r3 = new TypeAdapterRuntimeTypeWrapper(this.f6967j, this.f6966i, this.f6968k.getType());
            goto L26
        L28:
            r2 = r1.invoke(r5, new Object[0]);     // Catch: InvocationTargetException -> L16
        L16:
            e = move-exception;
            throw new k("Accessor " + com.google.gson.internal.n.a.g(this.f6964g, false) + " threw exception", e.getCause());
        }
    }

    static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f6970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Field f6971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f6972c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f6973d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f6974e;

        protected b(String r1, Field r2, boolean r3, boolean r4) {
            this.f6970a = r1;
            this.f6971b = r2;
            this.f6972c = r2.getName();
            this.f6973d = r3;
            this.f6974e = r4;
        }

        abstract void a(com.google.gson.a0.a r1, int r2, Object[] r3);

        abstract void b(com.google.gson.a0.a r1, Object r2);

        abstract void c(com.google.gson.a0.c r1, Object r2);
    }

    public ReflectiveTypeAdapterFactory(c r1, d r2, Excluder r3, JsonAdapterAnnotationTypeAdapterFactory r4, List<u> r5) {
        this.f6952f = r1;
        this.f6953g = r2;
        this.f6954h = r3;
        this.f6955i = r4;
        this.f6956j = r5;
    }

    static /* synthetic */ void b(Object r0, AccessibleObject r1) {
        c(r0, r1);
    }

    private static <M extends AccessibleObject & Member> void c(Object r1, M r2) {
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L6;
        r1 = null;
    L6:
        if (com.google.gson.internal.k.a(r2, r1) == false) goto L9;
        return;
    L9:
        throw new k(com.google.gson.internal.n.a.g(r2, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private b d(Gson r16, Field r17, Method r18, String r19, com.google.gson.z.a<?> r20, boolean r21, boolean r22, boolean r23) {
        boolean r12 = j.a(r20.getRawType());
        int r0 = r17.getModifiers();
        if (Modifier.isStatic(r0) == true) goto L5;
    L7:
        boolean r13 = false;
    L8:
        com.google.gson.y.b r1 = (com.google.gson.y.b) r17.getAnnotation(com.google.gson.y.b.class);
        TypeAdapter<?> r2 = null;
        if (r1 == null) goto L11;
        r2 = this.f6955i.b(this.f6952f, r16, r20, r1);
    L11:
        if (r2 == null) goto L13;
        boolean r8 = true;
    L14:
        if (r2 != null) goto L16;
        TypeAdapter<?> r9 = r16.o(r20);
    L18:
        return new a(this, r19, r17, r21, r22, r23, r18, r8, r9, r16, r20, r12, r13);
    L16:
        r9 = r2;
        goto L18
    L13:
        r8 = false;
        goto L14
    L5:
        if (Modifier.isFinal(r0) == false) goto L7;
        r13 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r22v0 */
    private Map<String, b> e(Gson r29, com.google.gson.z.a<?> r30, Class<?> r31, boolean r32, boolean r33) {
        LinkedHashMap r11 = new LinkedHashMap();
        if (r31.isInterface() == false) goto L5;
        return r11;
    L5:
        com.google.gson.z.a<?> r12 = r30;
        boolean r0 = r32;
        Class<?> r13 = r31;
    L7:
        if (r13 == Object.class) goto L63;
        Field[] r14 = r13.getDeclaredFields();
        boolean r15 = true;
        boolean r8 = false;
        if (r13 != r31) goto L11;
    L20:
        boolean r16 = r0;
        int r7 = r14.length;
        int r6 = 0;
    L21:
        if (r6 >= r7) goto L62;
        Field r5 = r14[r6];
        boolean r1 = this.g(r5, r15);
        boolean r2 = this.g(r5, r8);
        if (r1 == true) goto L26;
        if (r2 == true) goto L26;
        int r21 = r6;
        int r26 = r7;
        boolean r27 = r8;
    L59:
        r6 = r21 + 1;
        r15 = true;
        ReflectiveTypeAdapterFactory this = this;
        r7 = r26;
        r8 = r27;
    L26:
        b r3 = null;
        if (r33 == true) goto L29;
        boolean r17 = r2;
        Method r18 = null;
    L43:
        if (r16 == true) goto L46;
        if (r18 != null) goto L46;
        com.google.gson.internal.n.a.l(r5);
    L46:
        Type r19 = com.google.gson.internal.b.o(r12.getType(), r13, r5.getGenericType());
        List<String> r4 = this.f(r5);
        int r9 = r4.size();
        ?? r10 = r8;
    L47:
        if (r10 >= r9) goto L57;
        String r110 = r4.get(r10);
        if (r10 == 0) goto L51;
        boolean r20 = r8;
    L52:
        ?? r22 = r10;
        b r23 = r3;
        int r24 = r9;
        List<String> r25 = r4;
        Field r28 = r5;
        int r210 = r6;
        int r211 = r7;
        boolean r212 = r8;
        b r34 = (b) r11.put(r110, d(r29, r5, r18, r110, com.google.gson.z.a.get(r19), r20, r17, r16));
        if (r23 != null) goto L55;
        r3 = r34;
    L56:
        r1 = r20;
        r6 = r210;
        r9 = r24;
        r4 = r25;
        r5 = r28;
        r7 = r211;
        r8 = r212;
        r10 = (r22 == true ? 1 : 0) + 1;
        goto L47
    L55:
        r3 = r23;
        goto L56
    L51:
        r20 = r1;
        goto L52
    L57:
        b r35 = r3;
        Field r213 = r5;
        r21 = r6;
        r26 = r7;
        r27 = r8;
        if (r35 == null) goto L59;
        throw new IllegalArgumentException("Class " + r31.getName() + " declares multiple JSON fields named '" + r35.f6970a + "'; conflict is caused by fields " + com.google.gson.internal.n.a.f(r35.f6971b) + " and " + com.google.gson.internal.n.a.f(r213));
    L29:
        if (Modifier.isStatic(r5.getModifiers()) == false) goto L31;
        r18 = null;
        r17 = r8;
        goto L43
    L31:
        Method r36 = com.google.gson.internal.n.a.h(r13, r5);
        if (r16 == true) goto L35;
        com.google.gson.internal.n.a.l(r36);
    L35:
        if (r36.getAnnotation(com.google.gson.y.c.class) != null) goto L37;
    L41:
        r17 = r2;
        r18 = r36;
        goto L43
    L37:
        if (r5.getAnnotation(com.google.gson.y.c.class) != null) goto L41;
        throw new k("@SerializedName on " + com.google.gson.internal.n.a.g(r36, r8) + " is not supported");
    L62:
        r12 = com.google.gson.z.a.get(com.google.gson.internal.b.o(r12.getType(), r13, r13.getGenericSuperclass()));
        r13 = r12.getRawType();
        r0 = r16;
        goto L7
    L11:
        if (r14.length <= 0) goto L20;
        u.a r37 = com.google.gson.internal.k.b(this.f6956j, r13);
        if (r37 == u.a.f7102i) goto L19;
        if (r37 != u.a.f7101h) goto L17;
        r0 = true;
        goto L20
    L17:
        r0 = false;
        goto L20
    L19:
        throw new k("ReflectionAccessFilter does not permit using reflection for " + r13 + " (supertype of " + r31 + "). Register a TypeAdapter for this type or adjust the access filter.");
    L63:
        return r11;
    }

    private List<String> f(Field r3) {
        com.google.gson.y.c r0 = (com.google.gson.y.c) r3.getAnnotation(com.google.gson.y.c.class);
        if (r0 == null) goto L5;
        String r2 = r0.value();
        String[] r4 = r0.alternate();
        if (r4.length == 0) goto L9;
        ArrayList r1 = new ArrayList(r4.length + 1);
        r1.add(r2);
        Collections.addAll(r1, r4);
        return r1;
    L9:
        return Collections.singletonList(r2);
    L5:
        return Collections.singletonList(this.f6953g.a(r3));
    }

    private boolean g(Field r3, boolean r4) {
        if (this.f6954h.d(r3.getType(), r4) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f6954h.h(r3, r4) == true) goto L7;
        return true;
    }

    @Override // com.google.gson.x
    public <T> TypeAdapter<T> a(Gson r11, com.google.gson.z.a<T> r12) {
        Class<? super T> r6 = r12.getRawType();
        if (Object.class.isAssignableFrom(r6) == true) goto L6;
        return null;
    L6:
        u.a r0 = com.google.gson.internal.k.b(this.f6956j, r6);
        if (r0 == u.a.f7102i) goto L19;
        if (r0 != u.a.f7101h) goto L11;
        boolean r1 = true;
    L12:
        boolean r7 = r1;
        if (com.google.gson.internal.n.a.k(r6) == false) goto L17;
        return new RecordAdapter(r6, e(r11, r12, r6, r7, true), r7);
    L17:
        return new FieldReflectionAdapter(this.f6952f.b(r12), e(r11, r12, r6, r7, false));
    L11:
        r1 = false;
        goto L12
    L19:
        throw new k("ReflectionAccessFilter does not permit using reflection for " + r6 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }
}
