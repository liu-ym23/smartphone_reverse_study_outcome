package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes2.dex */
public final class Gson {
    static final String o = null;
    static final d p = null;
    static final w q = null;
    static final w r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadLocal<Map<com.google.gson.z.a<?>, TypeAdapter<?>>> f6846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<com.google.gson.z.a<?>, TypeAdapter<?>> f6847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.internal.c f6848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonAdapterAnnotationTypeAdapterFactory f6849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final List<x> f6850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Map<Type, f<?>> f6851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f6852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f6853h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f6854i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f6855j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f6856k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final List<x> f6857l;
    final List<x> m;
    final List<u> n;

    static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TypeAdapter<T> f6860a;

        FutureTypeAdapter() {
            this.f6860a = null;
        }

        private TypeAdapter<T> f() {
            TypeAdapter<T> r1 = this.f6860a;
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.TypeAdapter
        public T b(com.google.gson.a0.a r1) {
            return f().b(r1);
        }

        @Override // com.google.gson.TypeAdapter
        public void d(com.google.gson.a0.c r1, T r2) {
            f().d(r1, r2);
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public TypeAdapter<T> e() {
            return f();
        }

        public void g(TypeAdapter<T> r2) {
            if (this.f6860a != null) goto L7;
            this.f6860a = r2;
            return;
        L7:
            throw new AssertionError("Delegate is already set");
        }
    }

    static {
        p = c.f6884f;
        q = v.f7104f;
        r = v.f7105g;
    }

    public Gson() {
        this(Excluder.f6904l, p, Collections.emptyMap(), false, false, false, true, false, false, false, true, t.f7096f, o, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), q, r, Collections.emptyList());
    }

    Gson(Excluder r11, d r12, Map<Type, f<?>> r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, t r22, String r23, int r24, int r25, List<x> r26, List<x> r27, List<x> r28, w r29, w r30, List<u> r31) {
        this.f6846a = new ThreadLocal();
        this.f6847b = new ConcurrentHashMap();
        this.f6851f = r13;
        com.google.gson.internal.c r4 = new com.google.gson.internal.c(r13, r21, r31);
        this.f6848c = r4;
        this.f6852g = r14;
        this.f6853h = r16;
        this.f6854i = r17;
        this.f6855j = r18;
        this.f6856k = r19;
        this.f6857l = r26;
        this.m = r27;
        this.n = r31;
        ArrayList r1 = new ArrayList();
        r1.add(TypeAdapters.W);
        r1.add(ObjectTypeAdapter.e(r29));
        r1.add(r11);
        r1.addAll(r28);
        r1.add(TypeAdapters.C);
        r1.add(TypeAdapters.m);
        r1.add(TypeAdapters.f6998g);
        r1.add(TypeAdapters.f7000i);
        r1.add(TypeAdapters.f7002k);
        TypeAdapter<Number> r6 = r(r22);
        r1.add(TypeAdapters.b(Long.TYPE, Long.class, r6));
        r1.add(TypeAdapters.b(Double.TYPE, Double.class, e(r20)));
        r1.add(TypeAdapters.b(Float.TYPE, Float.class, f(r20)));
        r1.add(NumberTypeAdapter.e(r30));
        r1.add(TypeAdapters.o);
        r1.add(TypeAdapters.q);
        r1.add(TypeAdapters.a(AtomicLong.class, b(r6)));
        r1.add(TypeAdapters.a(AtomicLongArray.class, c(r6)));
        r1.add(TypeAdapters.s);
        r1.add(TypeAdapters.x);
        r1.add(TypeAdapters.E);
        r1.add(TypeAdapters.G);
        r1.add(TypeAdapters.a(BigDecimal.class, TypeAdapters.z));
        r1.add(TypeAdapters.a(BigInteger.class, TypeAdapters.A));
        r1.add(TypeAdapters.a(com.google.gson.internal.f.class, TypeAdapters.B));
        r1.add(TypeAdapters.I);
        r1.add(TypeAdapters.K);
        r1.add(TypeAdapters.O);
        r1.add(TypeAdapters.Q);
        r1.add(TypeAdapters.U);
        r1.add(TypeAdapters.M);
        r1.add(TypeAdapters.f6995d);
        r1.add(DateTypeAdapter.f6930b);
        r1.add(TypeAdapters.S);
        if (com.google.gson.internal.sql.a.f7087a == false) goto L5;
        r1.add(com.google.gson.internal.sql.a.f7091e);
        r1.add(com.google.gson.internal.sql.a.f7090d);
        r1.add(com.google.gson.internal.sql.a.f7092f);
    L5:
        r1.add(ArrayTypeAdapter.f6924c);
        r1.add(TypeAdapters.f6993b);
        r1.add(new CollectionTypeAdapterFactory(r4));
        r1.add(new MapTypeAdapterFactory(r4, r15));
        JsonAdapterAnnotationTypeAdapterFactory r2 = new JsonAdapterAnnotationTypeAdapterFactory(r4);
        this.f6849d = r2;
        r1.add(r2);
        r1.add(TypeAdapters.X);
        r1.add(new ReflectiveTypeAdapterFactory(r4, r12, r11, r2, r31));
        this.f6850e = Collections.unmodifiableList(r1);
    }

    private static void a(Object r0, com.google.gson.a0.a r1) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            if (r0 == 0) goto L21
            com.google.gson.a0.b r0 = r1.k0()     // Catch: java.io.IOException -> L13 com.google.gson.a0.d -> L1a
            com.google.gson.a0.b r1 = com.google.gson.a0.b.o     // Catch: java.io.IOException -> L13 com.google.gson.a0.d -> L1a
            if (r0 != r1) goto Lb
            goto L21
        Lb:
            com.google.gson.s r0 = new com.google.gson.s     // Catch: java.io.IOException -> L13 com.google.gson.a0.d -> L1a
            java.lang.String r1 = "JSON document was not fully consumed."
            r0.<init>(r1)     // Catch: java.io.IOException -> L13 com.google.gson.a0.d -> L1a
            throw r0     // Catch: java.io.IOException -> L13 com.google.gson.a0.d -> L1a
        L13:
            r0 = move-exception
            com.google.gson.k r1 = new com.google.gson.k
            r1.<init>(r0)
            throw r1
        L1a:
            r0 = move-exception
            com.google.gson.s r1 = new com.google.gson.s
            r1.<init>(r0)
            throw r1
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.a(java.lang.Object, com.google.gson.a0.a):void");
    }

    private static TypeAdapter<AtomicLong> b(final TypeAdapter<Number> r1) {
        return new AnonymousClass4(r1).a();
    }

    private static TypeAdapter<AtomicLongArray> c(final TypeAdapter<Number> r1) {
        return new AnonymousClass5(r1).a();
    }

    static void d(double r2) {
        if (Double.isNaN(r2) == true) goto L8;
        if (Double.isInfinite(r2) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    private TypeAdapter<Number> e(boolean r1) {
        if (r1 == false) goto L6;
        return TypeAdapters.v;
    L6:
        return new AnonymousClass1(this);
    }

    private TypeAdapter<Number> f(boolean r1) {
        if (r1 == false) goto L6;
        return TypeAdapters.u;
    L6:
        return new AnonymousClass2(this);
    }

    private static TypeAdapter<Number> r(t r1) {
        if (r1 != t.f7096f) goto L7;
        return TypeAdapters.t;
    L7:
        return new AnonymousClass3();
    }

    public void A(Object r1, Type r2, Appendable r3) {
        z(r1, r2, t(com.google.gson.internal.l.c(r3)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new k(e);
    }

    public j B(Object r2) {
        if (r2 != null) goto L6;
        return l.f7093a;
    L6:
        return C(r2, r2.getClass());
    }

    public j C(Object r2, Type r3) {
        com.google.gson.internal.bind.b r0 = new com.google.gson.internal.bind.b();
        z(r2, r3, r0);
        return r0.q0();
    }

    public <T> T g(j r2, com.google.gson.z.a<T> r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (T) j(new com.google.gson.internal.bind.a(r2), r3);
    }

    public <T> T h(j r2, Class<T> r3) {
        Object r1 = g(r2, com.google.gson.z.a.get(r3));
        return (T) com.google.gson.internal.j.b(r3).cast(r1);
    }

    public <T> T i(j r1, Type r2) {
        return (T) g(r1, com.google.gson.z.a.get(r2));
    }

    public <T> T j(com.google.gson.a0.a r4, com.google.gson.z.a<T> r5) {
        boolean r0 = r4.M();
        boolean r1 = true;
        r4.p0(true);
        r4.k0();     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11 IllegalStateException -> L14 EOFException -> L17
        r1 = false;
        T r3 = o(r5).b(r4);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11 IllegalStateException -> L14 EOFException -> L17
        r4.p0(r0);
        return r3;
    L6:
        th = move-exception;
        r4.p0(r0);
        throw th;
    L17:
        e = move-exception;
        if (r1 == false) goto L22;
        r4.p0(r0);
        return null;
    L22:
        throw new s(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new s(e);     // Catch: Throwable -> L6
    L14:
        e = move-exception;
        throw new s(e);     // Catch: Throwable -> L6
    }

    public <T> T k(Reader r1, com.google.gson.z.a<T> r2) {
        com.google.gson.a0.a r3 = s(r1);
        T r0 = (T) j(r3, r2);
        a(r0, r3);
        return r0;
    }

    public <T> T l(String r2, com.google.gson.z.a<T> r3) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (T) k(new StringReader(r2), r3);
    }

    public <T> T m(String r2, Class<T> r3) {
        Object r1 = l(r2, com.google.gson.z.a.get(r3));
        return (T) com.google.gson.internal.j.b(r3).cast(r1);
    }

    public <T> T n(String r1, Type r2) {
        return (T) l(r1, com.google.gson.z.a.get(r2));
    }

    public <T> TypeAdapter<T> o(com.google.gson.z.a<T> r7) {
        Objects.requireNonNull(r7, "type must not be null");
        TypeAdapter<T> r0 = (TypeAdapter) this.f6847b.get(r7);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Map<? extends com.google.gson.z.a<?>, ? extends TypeAdapter<?>> r1 = this.f6846a.get();
        boolean r2 = false;
        if (r1 != null) goto L8;
        r1 = new HashMap();
        this.f6846a.set((Map<com.google.gson.z.a<?>, TypeAdapter<?>>) r1);
        r2 = true;
    L11:
        TypeAdapter<T> r3 = null;
        FutureTypeAdapter r4 = new FutureTypeAdapter();     // Catch: Throwable -> L26
        r1.put(r7, r4);     // Catch: Throwable -> L26
        Iterator<x> r5 = this.f6850e.iterator();     // Catch: Throwable -> L26
    L14:
        if (r5.hasNext() == false) goto L18;
        r3 = r5.next().a(this, r7);     // Catch: Throwable -> L26
        if (r3 == null) goto L14;
        r4.g(r3);     // Catch: Throwable -> L26
        r1.put(r7, r3);     // Catch: Throwable -> L26
    L18:
        if (r2 == false) goto L20;
        this.f6846a.remove();
    L20:
        if (r3 == null) goto L25;
        if (r2 == false) goto L23;
        this.f6847b.putAll(r1);
    L23:
        return r3;
    L25:
        throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + r7);
    L26:
        th = move-exception;
        if (r2 == false) goto L29;
        this.f6846a.remove();
    L29:
        throw th;
    L8:
        TypeAdapter<T> r6 = (TypeAdapter) r1.get(r7);
        if (r6 == null) goto L11;
        return r6;
    }

    public <T> TypeAdapter<T> p(Class<T> r1) {
        return o(com.google.gson.z.a.get(r1));
    }

    public <T> TypeAdapter<T> q(x r4, com.google.gson.z.a<T> r5) {
        if (this.f6850e.contains(r4) == true) goto L5;
        r4 = this.f6849d;
    L5:
        boolean r0 = false;
        Iterator<x> r1 = this.f6850e.iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        x r2 = r1.next();
        if (r0 == false) goto L10;
        TypeAdapter<T> r3 = r2.a(this, r5);
        if (r3 == null) goto L7;
        return r3;
    L10:
        if (r2 != r4) goto L7;
        r0 = true;
        goto L7
    L16:
        throw new IllegalArgumentException("GSON cannot serialize " + r5);
    }

    public com.google.gson.a0.a s(Reader r2) {
        com.google.gson.a0.a r0 = new com.google.gson.a0.a(r2);
        r0.p0(this.f6856k);
        return r0;
    }

    public com.google.gson.a0.c t(Writer r2) {
        if (this.f6853h == false) goto L5;
        r2.write(")]}'\n");
    L5:
        com.google.gson.a0.c r0 = new com.google.gson.a0.c(r2);
        if (this.f6855j == false) goto L8;
        r0.d0("  ");
    L8:
        r0.Y(this.f6854i);
        r0.g0(this.f6856k);
        r0.h0(this.f6852g);
        return r0;
    }

    public String toString() {
        return "{serializeNulls:" + this.f6852g + ",factories:" + this.f6850e + ",instanceCreators:" + this.f6848c + "}";
    }

    public String u(j r2) {
        StringWriter r0 = new StringWriter();
        y(r2, r0);
        return r0.toString();
    }

    public String v(Object r2) {
        if (r2 != null) goto L6;
        return u(l.f7093a);
    L6:
        return w(r2, r2.getClass());
    }

    public String w(Object r2, Type r3) {
        StringWriter r0 = new StringWriter();
        A(r2, r3, r0);
        return r0.toString();
    }

    public void x(j r6, com.google.gson.a0.c r7) {
        boolean r0 = r7.F();
        r7.g0(true);
        boolean r1 = r7.E();
        r7.Y(this.f6854i);
        boolean r2 = r7.C();
        r7.h0(this.f6852g);
        com.google.gson.internal.l.b(r6, r7);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r7.g0(r0);
        r7.Y(r1);
        r7.h0(r2);
        return;
    L6:
        th = move-exception;
        r7.g0(r0);
        r7.Y(r1);
        r7.h0(r2);
        throw th;
    L11:
        e = move-exception;
        throw new k(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public void y(j r1, Appendable r2) {
        x(r1, t(com.google.gson.internal.l.c(r2)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new k(e);
    }

    public void z(Object r5, Type r6, com.google.gson.a0.c r7) {
        TypeAdapter r8 = o(com.google.gson.z.a.get(r6));
        boolean r0 = r7.F();
        r7.g0(true);
        boolean r1 = r7.E();
        r7.Y(this.f6854i);
        boolean r2 = r7.C();
        r7.h0(this.f6852g);
        r8.d(r7, r5);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r7.g0(r0);
        r7.Y(r1);
        r7.h0(r2);
        return;
    L6:
        th = move-exception;
        r7.g0(r0);
        r7.Y(r1);
        r7.h0(r2);
        throw th;
    L11:
        e = move-exception;
        throw new k(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }
}
