package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.f;
import com.google.gson.j;
import com.google.gson.x;
import com.google.gson.y.c;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes2.dex */
public final class TypeAdapters {
    public static final TypeAdapter<BigInteger> A = null;
    public static final TypeAdapter<f> B = null;
    public static final x C = null;
    public static final TypeAdapter<StringBuilder> D = null;
    public static final x E = null;
    public static final TypeAdapter<StringBuffer> F = null;
    public static final x G = null;
    public static final TypeAdapter<URL> H = null;
    public static final x I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final TypeAdapter<URI> f6991J = null;
    public static final x K = null;
    public static final TypeAdapter<InetAddress> L = null;
    public static final x M = null;
    public static final TypeAdapter<UUID> N = null;
    public static final x O = null;
    public static final TypeAdapter<Currency> P = null;
    public static final x Q = null;
    public static final TypeAdapter<Calendar> R = null;
    public static final x S = null;
    public static final TypeAdapter<Locale> T = null;
    public static final x U = null;
    public static final TypeAdapter<j> V = null;
    public static final x W = null;
    public static final x X = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypeAdapter<Class> f6992a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f6993b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TypeAdapter<BitSet> f6994c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f6995d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TypeAdapter<Boolean> f6996e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TypeAdapter<Boolean> f6997f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x f6998g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TypeAdapter<Number> f6999h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final x f7000i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final TypeAdapter<Number> f7001j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final x f7002k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final TypeAdapter<Number> f7003l = null;
    public static final x m = null;
    public static final TypeAdapter<AtomicInteger> n = null;
    public static final x o = null;
    public static final TypeAdapter<AtomicBoolean> p = null;
    public static final x q = null;
    public static final TypeAdapter<AtomicIntegerArray> r = null;
    public static final x s = null;
    public static final TypeAdapter<Number> t = null;
    public static final TypeAdapter<Number> u = null;
    public static final TypeAdapter<Number> v = null;
    public static final TypeAdapter<Character> w = null;
    public static final x x = null;
    public static final TypeAdapter<String> y = null;
    public static final TypeAdapter<BigDecimal> z = null;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$30, reason: invalid class name */
    class AnonymousClass30 implements x {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.google.gson.z.a f7004f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ TypeAdapter f7005g;

        @Override // com.google.gson.x
        public <T> TypeAdapter<T> a(Gson r1, com.google.gson.z.a<T> r2) {
            if (r2.equals(this.f7004f) == true) goto L7;
            return null;
        L7:
            return this.f7005g;
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, T> f7018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, T> f7019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<T, String> f7020c;

        class a implements PrivilegedAction<Field[]> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Class f7021a;

            a(EnumTypeAdapter r1, Class r2) {
                this.f7021a = r2;
            }

            public Field[] a() {
                Field[] r6 = this.f7021a.getDeclaredFields();
                ArrayList r0 = new ArrayList(r6.length);
                int r1 = r6.length;
                int r3 = 0;
            L3:
                if (r3 >= r1) goto L8;
                Field r4 = r6[r3];
                if (r4.isEnumConstant() == false) goto L7;
                r0.add(r4);
            L7:
                r3 = r3 + 1;
                goto L3
            L8:
                Field[] r7 = (Field[]) r0.toArray(new Field[0]);
                AccessibleObject.setAccessible(r7, true);
                return r7;
            }

            @Override // java.security.PrivilegedAction
            public /* bridge */ /* synthetic */ Field[] run() {
                return a();
            }
        }

        public EnumTypeAdapter(Class<T> r12) {
            this.f7018a = new HashMap();
            this.f7019b = new HashMap();
            this.f7020c = new HashMap();
            Field[] r13 = (Field[]) AccessController.doPrivileged(new a(this, r12));     // Catch: IllegalAccessException -> L13
            int r0 = r13.length;     // Catch: IllegalAccessException -> L13
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L12;
            Field r3 = r13[r2];     // Catch: IllegalAccessException -> L13
            Enum r4 = (Enum) r3.get(null);     // Catch: IllegalAccessException -> L13
            String r5 = r4.name();     // Catch: IllegalAccessException -> L13
            String r6 = r4.toString();     // Catch: IllegalAccessException -> L13
            c r7 = (c) r3.getAnnotation(c.class);     // Catch: IllegalAccessException -> L13
            if (r7 == null) goto L10;
            r5 = r7.value();     // Catch: IllegalAccessException -> L13
            String[] r8 = r7.alternate();     // Catch: IllegalAccessException -> L13
            int r9 = r8.length;     // Catch: IllegalAccessException -> L13
            int r10 = 0;
        L8:
            if (r10 >= r9) goto L10;
            this.f7018a.put(r8[r10], (T) r4);     // Catch: IllegalAccessException -> L13
            r10 = r10 + 1;     // Catch: IllegalAccessException -> L13
        L10:
            this.f7018a.put(r5, (T) r4);     // Catch: IllegalAccessException -> L13
            this.f7019b.put(r6, (T) r4);     // Catch: IllegalAccessException -> L13
            this.f7020c.put((T) r4, r5);     // Catch: IllegalAccessException -> L13
            r2 = r2 + 1;
            goto L4
        L12:
            return;
        L13:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object b(com.google.gson.a0.a r1) {
            return e(r1);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void d(com.google.gson.a0.c r1, Object r2) {
            f(r1, (Enum) r2);
        }

        public T e(com.google.gson.a0.a r3) {
            if (r3.k0() != com.google.gson.a0.b.n) goto L6;
            r3.g0();
            return null;
        L6:
            String r4 = r3.i0();
            T r0 = this.f7018a.get(r4);
            if (r0 == null) goto L9;
            return r0;
        L9:
            return this.f7019b.get(r4);
        }

        public void f(com.google.gson.a0.c r1, T r2) {
            if (r2 != null) goto L4;
            String r0 = null;
        L5:
            r1.n0(r0);
            return;
        L4:
            r0 = this.f7020c.get(r2);
            goto L5
        }
    }

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7022a = null;

        static {
            int[] r0 = new int[com.google.gson.a0.b.values().length];
            f7022a = r0;
            r0[com.google.gson.a0.b.f6875l.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f7022a[com.google.gson.a0.b.f6874k.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f7022a[com.google.gson.a0.b.m.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f7022a[com.google.gson.a0.b.f6869f.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f7022a[com.google.gson.a0.b.f6871h.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f7022a[com.google.gson.a0.b.n.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    static {
        TypeAdapter<Class> r0 = new AnonymousClass1().a();
        f6992a = r0;
        f6993b = a(Class.class, r0);
        TypeAdapter<BitSet> r1 = new AnonymousClass2().a();
        f6994c = r1;
        f6995d = a(BitSet.class, r1);
        TypeAdapter<Boolean> r2 = new AnonymousClass3();
        f6996e = r2;
        f6997f = new AnonymousClass4();
        f6998g = b(Boolean.TYPE, Boolean.class, r2);
        TypeAdapter<Number> r3 = new AnonymousClass5();
        f6999h = r3;
        f7000i = b(Byte.TYPE, Byte.class, r3);
        TypeAdapter<Number> r4 = new AnonymousClass6();
        f7001j = r4;
        f7002k = b(Short.TYPE, Short.class, r4);
        TypeAdapter<Number> r5 = new AnonymousClass7();
        f7003l = r5;
        m = b(Integer.TYPE, Integer.class, r5);
        TypeAdapter<AtomicInteger> r6 = new AnonymousClass8().a();
        n = r6;
        o = a(AtomicInteger.class, r6);
        TypeAdapter<AtomicBoolean> r7 = new AnonymousClass9().a();
        p = r7;
        q = a(AtomicBoolean.class, r7);
        TypeAdapter<AtomicIntegerArray> r8 = new AnonymousClass10().a();
        r = r8;
        s = a(AtomicIntegerArray.class, r8);
        t = new AnonymousClass11();
        u = new AnonymousClass12();
        v = new AnonymousClass13();
        TypeAdapter<Character> r9 = new AnonymousClass14();
        w = r9;
        x = b(Character.TYPE, Character.class, r9);
        TypeAdapter<String> r10 = new AnonymousClass15();
        y = r10;
        z = new AnonymousClass16();
        A = new AnonymousClass17();
        B = new AnonymousClass18();
        C = a(String.class, r10);
        TypeAdapter<StringBuilder> r11 = new AnonymousClass19();
        D = r11;
        E = a(StringBuilder.class, r11);
        TypeAdapter<StringBuffer> r12 = new AnonymousClass20();
        F = r12;
        G = a(StringBuffer.class, r12);
        TypeAdapter<URL> r13 = new AnonymousClass21();
        H = r13;
        I = a(URL.class, r13);
        TypeAdapter<URI> r14 = new AnonymousClass22();
        f6991J = r14;
        K = a(URI.class, r14);
        TypeAdapter<InetAddress> r15 = new AnonymousClass23();
        L = r15;
        M = d(InetAddress.class, r15);
        TypeAdapter<UUID> r16 = new AnonymousClass24();
        N = r16;
        O = a(UUID.class, r16);
        TypeAdapter<Currency> r17 = new AnonymousClass25().a();
        P = r17;
        Q = a(Currency.class, r17);
        TypeAdapter<Calendar> r18 = new AnonymousClass26();
        R = r18;
        S = c(Calendar.class, GregorianCalendar.class, r18);
        TypeAdapter<Locale> r19 = new AnonymousClass27();
        T = r19;
        U = a(Locale.class, r19);
        TypeAdapter<j> r20 = new AnonymousClass28();
        V = r20;
        W = d(j.class, r20);
        X = new AnonymousClass29();
    }

    public static <TT> x a(final Class<TT> r1, final TypeAdapter<TT> r2) {
        return new AnonymousClass31(r1, r2);
    }

    public static <TT> x b(final Class<TT> r1, final Class<TT> r2, final TypeAdapter<? super TT> r3) {
        return new AnonymousClass32(r1, r2, r3);
    }

    public static <TT> x c(final Class<TT> r1, final Class<? extends TT> r2, final TypeAdapter<? super TT> r3) {
        return new AnonymousClass33(r1, r2, r3);
    }

    public static <T1> x d(final Class<T1> r1, final TypeAdapter<T1> r2) {
        return new AnonymousClass34(r1, r2);
    }
}
