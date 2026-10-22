package h.a.f3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002\u001a*\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002\u001a1\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0014\b\u0004\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001a!\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\u0011\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0082\u0010\u001a\u0018\u0010\u0015\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¨\u0006\u0018"}, d2 = {"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "", "createConstructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", "E", "clz", "Ljava/lang/Class;", "createSafeConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f17384a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f17385b = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return kotlin.j0.a.a(Integer.valueOf(((Constructor) r2).getParameterTypes().length), Integer.valueOf(((Constructor) r1).getParameterTypes().length));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "E", "", "it", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.l {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f17386f = null;

        static {
            f17386f = new b();
        }

        b() {
            super(1);
        }

        public final Void a(Throwable r1) {
            return null;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return a((Throwable) r1);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class c extends kotlin.n0.d.q implements kotlin.n0.c.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f17387f;

        public c(Constructor r1) {
            this.f17387f = r1;
            super(1);
        }

        public final Throwable a(Throwable r4) {
            kotlin.v.a r0 = kotlin.v.f21457g;     // Catch: Throwable -> L7
            Object r3 = this.f17387f.newInstance(new Object[]{r4.getMessage(), r4});     // Catch: Throwable -> L7
            if (r3 == null) goto L6;
            Object r5 = (Throwable) r3;     // Catch: Throwable -> L7
            kotlin.v.b(r5);     // Catch: Throwable -> L7
        L10:
            if (kotlin.v.f(r5) == false) goto L13;
            r5 = null;
        L13:
            return (Throwable) r5;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            kotlin.v.a r6 = kotlin.v.f21457g;
            r5 = kotlin.w.a(th);
            kotlin.v.b(r5);
            goto L10
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Throwable invoke(Throwable r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class d extends kotlin.n0.d.q implements kotlin.n0.c.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f17388f;

        public d(Constructor r1) {
            this.f17388f = r1;
            super(1);
        }

        public final Throwable a(Throwable r3) {
            kotlin.v.a r0 = kotlin.v.f21457g;     // Catch: Throwable -> L7
            Object r2 = this.f17388f.newInstance(new Object[]{r3});     // Catch: Throwable -> L7
            if (r2 == null) goto L6;
            Object r4 = (Throwable) r2;     // Catch: Throwable -> L7
            kotlin.v.b(r4);     // Catch: Throwable -> L7
        L10:
            if (kotlin.v.f(r4) == false) goto L13;
            r4 = null;
        L13:
            return (Throwable) r4;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            kotlin.v.a r5 = kotlin.v.f21457g;
            r4 = kotlin.w.a(th);
            kotlin.v.b(r4);
            goto L10
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Throwable invoke(Throwable r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class e extends kotlin.n0.d.q implements kotlin.n0.c.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f17389f;

        public e(Constructor r1) {
            this.f17389f = r1;
            super(1);
        }

        public final Throwable a(Throwable r4) {
            kotlin.v.a r0 = kotlin.v.f21457g;     // Catch: Throwable -> L7
            Object r3 = this.f17389f.newInstance(new Object[]{r4.getMessage()});     // Catch: Throwable -> L7
            if (r3 == null) goto L6;
            Throwable r5 = (Throwable) r3;     // Catch: Throwable -> L7
            r5.initCause(r4);     // Catch: Throwable -> L7
            kotlin.v.b(r5);     // Catch: Throwable -> L7
            Object r6 = r5;
        L9:
            boolean r7 = kotlin.v.f(r6);
            Object r8 = r6;
            if (r7 == false) goto L13;
            r8 = null;
        L13:
            return (Throwable) r8;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            kotlin.v.a r9 = kotlin.v.f21457g;
            Object r10 = kotlin.w.a(th);
            kotlin.v.b(r10);
            r6 = r10;
            goto L9
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Throwable invoke(Throwable r1) {
            return a(r1);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "e", "invoke", "kotlinx/coroutines/internal/ExceptionsConstructorKt$safeCtor$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class f extends kotlin.n0.d.q implements kotlin.n0.c.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Constructor f17390f;

        public f(Constructor r1) {
            this.f17390f = r1;
            super(1);
        }

        public final Throwable a(Throwable r2) {
            kotlin.v.a r0 = kotlin.v.f21457g;     // Catch: Throwable -> L7
            Object r1 = this.f17390f.newInstance(new Object[0]);     // Catch: Throwable -> L7
            if (r1 == null) goto L6;
            Throwable r3 = (Throwable) r1;     // Catch: Throwable -> L7
            r3.initCause(r2);     // Catch: Throwable -> L7
            kotlin.v.b(r3);     // Catch: Throwable -> L7
            Object r4 = r3;
        L9:
            boolean r5 = kotlin.v.f(r4);
            Object r6 = r4;
            if (r5 == false) goto L13;
            r6 = null;
        L13:
            return (Throwable) r6;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            kotlin.v.a r7 = kotlin.v.f21457g;
            Object r8 = kotlin.w.a(th);
            kotlin.v.b(r8);
            r4 = r8;
            goto L9
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Throwable invoke(Throwable r1) {
            return a(r1);
        }
    }

    static {
        f17384a = f(Throwable.class, -1);
    L8:
        h r0 = q0.f17407a;
    L9:
        f17385b = r0;
        return;
    L4:
        if (m.a() == false) goto L6;
        r0 = q0.f17407a;     // Catch: Throwable -> L8
    L11:
        goto L9
    L6:
        r0 = h.a.f3.e.f17363a;     // Catch: Throwable -> L8
        goto L11
    }

    public static final /* synthetic */ kotlin.n0.c.l a(Class r0) {
        return b(r0);
    }

    private static final <E extends Throwable> kotlin.n0.c.l<Throwable, Throwable> b(Class<E> r3) {
        b r0 = b.f17386f;
        if (f17384a == f(r3, 0)) goto L5;
        return r0;
    L5:
        Iterator r4 = kotlin.i0.i.V(r3.getConstructors(), new a()).iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        kotlin.n0.c.l<Throwable, Throwable> r1 = c((Constructor) r4.next());
        if (r1 == null) goto L7;
        return r1;
    L11:
        return r0;
    }

    private static final kotlin.n0.c.l<Throwable, Throwable> c(Constructor<?> r7) {
        Class<?>[] r1 = r7.getParameterTypes();
        int r2 = r1.length;
        if (r2 == 0) goto L21;
        if (r2 != 1) goto L7;
        Class<?> r3 = r1[0];
        if (kotlin.n0.d.o.a(r3, Throwable.class) == false) goto L18;
        return new d(r7);
    L18:
        if (kotlin.n0.d.o.a(r3, String.class) == true) goto L27;
        return null;
    L27:
        return new e(r7);
    L7:
        if (r2 == 2) goto L10;
        return null;
    L10:
        if (kotlin.n0.d.o.a(r1[0], String.class) == true) goto L12;
        return null;
    L12:
        if (kotlin.n0.d.o.a(r1[1], Throwable.class) == true) goto L24;
        return null;
    L24:
        return new c(r7);
    L21:
        return new f(r7);
    }

    private static final int d(Class<?> r5, int r6) {
    L2:
        Field[] r0 = r5.getDeclaredFields();
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L7;
        Field r4 = r0[r2];
        r2 = r2 + 1;
        if ((!Modifier.isStatic(r4.getModifiers())) == false) goto L3;
        r3 = r3 + 1;
        goto L3
    L7:
        r6 = r6 + r3;
        r5 = r5.getSuperclass();
        if (r5 != null) goto L2;
        return r6;
    }

    static /* synthetic */ int e(Class r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        return d(r0, r1);
    }

    private static final int f(Class<?> r3, int r4) {
        kotlin.n0.a.e(r3);
        kotlin.v.a r0 = kotlin.v.f21457g;     // Catch: Throwable -> L5
        Object r5 = Integer.valueOf(e(r3, 0, 1, null));     // Catch: Throwable -> L5
        kotlin.v.b(r5);     // Catch: Throwable -> L5
    L7:
        Integer r6 = Integer.valueOf(r4);
        if (kotlin.v.f(r5) == false) goto L11;
        r5 = r6;
    L11:
        return ((Number) r5).intValue();
    L5:
        th = move-exception;
        kotlin.v.a r1 = kotlin.v.f21457g;
        r5 = kotlin.w.a(th);
        kotlin.v.b(r5);
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E g(E r2) {
        if ((r2 instanceof h.a.e0) == false) goto L14;
        kotlin.v.a r0 = kotlin.v.f21457g;     // Catch: Throwable -> L6
        Object r3 = ((h.a.e0) r2).a();     // Catch: Throwable -> L6
        kotlin.v.b(r3);     // Catch: Throwable -> L6
    L9:
        if (kotlin.v.f(r3) == false) goto L12;
        r3 = null;
    L12:
        return (E) r3;
    L6:
        th = move-exception;
        kotlin.v.a r1 = kotlin.v.f21457g;
        r3 = kotlin.w.a(th);
        kotlin.v.b(r3);
        goto L9
    L14:
        return (E) f17385b.a(r2.getClass()).invoke(r2);
    }
}
