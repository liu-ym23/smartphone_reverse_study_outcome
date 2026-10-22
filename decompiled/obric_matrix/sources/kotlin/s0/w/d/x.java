package kotlin.s0.w.d;

import com.bytedance.common.wschannel.WsConstants;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.s0.w.d.l0.c.e1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.n.g1;
import kotlin.s0.w.d.l0.n.n1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001bH\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020,H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006-²\u0006\u0010\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u008a\u0084\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", WsConstants.KEY_CONNECTION_TYPE, "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getComputeJavaType$annotations", "()V", "isMarkedNullable", "", "()Z", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "makeNullableAsSpecified", "nullable", "makeNullableAsSpecified$kotlin_reflection", "toString", "", "kotlin-reflection", "parameterizedTypeArguments"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class x implements kotlin.n0.d.p {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l<Object>[] f21361j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.n.e0 f21362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c0.a<Type> f21363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c0.a f21364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c0.a f21365i;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends kotlin.s0.o>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f21366f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a<Type> f21367g;

        /* JADX INFO: renamed from: kotlin.s0.w.d.x$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0590a extends kotlin.n0.d.q implements kotlin.n0.c.a<Type> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ x f21368f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f21369g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ kotlin.h<List<Type>> f21370h;

            /* JADX WARN: Multi-variable type inference failed */
            C0590a(x r1, int r2, kotlin.h<? extends List<? extends Type>> r3) {
                this.f21368f = r1;
                this.f21369g = r2;
                this.f21370h = r3;
                super(0);
            }

            public final Type a() {
                Type r0 = this.f21368f.j();
                if ((r0 instanceof Class) == false) goto L9;
                Class r1 = (Class) r0;
                if (r1.isArray() == false) goto L7;
                Type r3 = r1.getComponentType();
            L13:
                kotlin.n0.d.o.e(r3, "{\n                      …                        }");
                return r3;
            L7:
                r3 = Object.class;
                goto L13
            L9:
                if ((r0 instanceof GenericArrayType) == false) goto L17;
                if (this.f21369g != 0) goto L15;
                r3 = ((GenericArrayType) r0).getGenericComponentType();
                goto L13
            L15:
                throw new a0("Array type has been queried for a non-0th argument: " + this.f21368f);
            L17:
                if ((r0 instanceof ParameterizedType) == false) goto L27;
                r3 = (Type) a.a(this.f21370h).get(this.f21369g);
                if ((r3 instanceof WildcardType) == false) goto L13;
                WildcardType r4 = (WildcardType) r3;
                Type[] r2 = r4.getLowerBounds();
                kotlin.n0.d.o.e(r2, "argument.lowerBounds");
                Type r5 = (Type) kotlin.i0.i.x(r2);
                if (r5 != null) goto L24;
                Type[] r6 = r4.getUpperBounds();
                kotlin.n0.d.o.e(r6, "argument.upperBounds");
                r3 = (Type) kotlin.i0.i.w(r6);
                goto L13
            L24:
                r3 = r5;
                goto L13
            L27:
                throw new a0("Non-generic type has been queried for arguments: " + this.f21368f);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Type invoke() {
                return a();
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f21371a = null;

            static {
                int[] r0 = new int[r1.values().length];
                r0[r1.f21065h.ordinal()] = 1;
                r0[r1.f21066i.ordinal()] = 2;
                r0[r1.f21067j.ordinal()] = 3;
                f21371a = r0;
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends Type>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ x f21372f;

            c(x r1) {
                this.f21372f = r1;
                super(0);
            }

            public final List<Type> a() {
                Type r0 = this.f21372f.j();
                kotlin.n0.d.o.c(r0);
                return kotlin.s0.w.d.l0.c.s1.b.d.c(r0);
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ List<? extends Type> invoke() {
                return a();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(x r1, kotlin.n0.c.a<? extends Type> r2) {
            this.f21366f = r1;
            this.f21367g = r2;
            super(0);
        }

        public static final /* synthetic */ List a(kotlin.h r0) {
            return c(r0);
        }

        private static final List<Type> c(kotlin.h<? extends List<? extends Type>> r0) {
            return (List) r0.getValue();
        }

        public final List<kotlin.s0.o> b() {
            List<g1> r0 = this.f21366f.k().M0();
            if (r0.isEmpty() == true) goto L5;
            kotlin.h r1 = kotlin.i.a(kotlin.l.f18418g, new c(this.f21366f));
            kotlin.n0.c.a<Type> r2 = this.f21367g;
            x r11 = this.f21366f;
            ArrayList r3 = new ArrayList(kotlin.i0.r.q(r0, 10));
            int r4 = 0;
            Iterator<T> r5 = r0.iterator();
        L8:
            if (r5.hasNext() == false) goto L32;
            Object r6 = r5.next();
            int r7 = r4 + 1;
            C0590a r8 = null;
            if (r4 < 0) goto L30;
            g1 r9 = (g1) r6;
            if (r9.d() == false) goto L14;
            kotlin.s0.o r10 = kotlin.s0.o.f18474c.c();
        L29:
            r3.add(r10);
            r4 = r7;
            goto L8
        L14:
            kotlin.s0.w.d.l0.n.e0 r12 = r9.b();
            kotlin.n0.d.o.e(r12, "typeProjection.type");
            if (r2 == null) goto L18;
            r8 = new C0590a(r11, r4, r1);
        L18:
            x r13 = new x(r12, r8);
            r1 r14 = r9.a();
            int r15 = b.f21371a[r14.ordinal()];
            if (r15 != 1) goto L21;
            r10 = kotlin.s0.o.f18474c.d(r13);
            goto L29
        L21:
            if (r15 != 2) goto L23;
            r10 = kotlin.s0.o.f18474c.a(r13);
            goto L29
        L23:
            if (r15 != 3) goto L26;
            r10 = kotlin.s0.o.f18474c.b(r13);
            goto L29
        L26:
            throw new kotlin.m();
        L30:
            kotlin.i0.r.p();
            throw null;
        L32:
            return r3;
        L5:
            return kotlin.i0.r.g();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends kotlin.s0.o> invoke() {
            return b();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<kotlin.s0.e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x f21373f;

        b(x r1) {
            this.f21373f = r1;
            super(0);
        }

        public final kotlin.s0.e a() {
            x r1 = this.f21373f;
            return x.e(r1, r1.k());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ kotlin.s0.e invoke() {
            return a();
        }
    }

    static {
        f21361j = new kotlin.s0.l[]{kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(x.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), kotlin.n0.d.e0.g(new kotlin.n0.d.y(kotlin.n0.d.e0.b(x.class), "arguments", "getArguments()Ljava/util/List;"))};
    }

    public x(kotlin.s0.w.d.l0.n.e0 r2, kotlin.n0.c.a<? extends Type> r3) {
        kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_TYPE);
        this.f21362f = r2;
        c0.a<Type> r0 = null;
        if ((r3 instanceof c0.a) == false) goto L5;
        c0.a<Type> r4 = (c0.a) r3;
    L6:
        if (r4 != null) goto L9;
        if (r3 == null) goto L10;
        r0 = c0.d(r3);
    L10:
        this.f21363g = r0;
        this.f21364h = c0.d(new b(this));
        this.f21365i = c0.d(new a(this, r3));
        return;
    L9:
        r0 = r4;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public /* synthetic */ x(kotlin.s0.w.d.l0.n.e0 r1, kotlin.n0.c.a r2, int r3, kotlin.n0.d.g r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ kotlin.s0.e e(x r0, kotlin.s0.w.d.l0.n.e0 r1) {
        return r0.f(r1);
    }

    private final kotlin.s0.e f(kotlin.s0.w.d.l0.n.e0 r4) {
        kotlin.s0.w.d.l0.c.h r0 = r4.O0().d();
        if ((r0 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L33;
        Class<?> r1 = i0.o((kotlin.s0.w.d.l0.c.e) r0);
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r1.isArray() == false) goto L23;
        g1 r5 = (g1) kotlin.i0.r.q0(r4.M0());
        if (r5 == null) goto L21;
        kotlin.s0.w.d.l0.n.e0 r6 = r5.b();
        if (r6 == null) goto L21;
        kotlin.s0.e r7 = f(r6);
        if (r7 == null) goto L19;
        return new h(i0.e(kotlin.n0.a.b(kotlin.s0.w.a.a(r7))));
    L19:
        throw new a0("Cannot determine classifier for array element type: " + this);
    L21:
        return new h(r1);
    L23:
        if (n1.l(r4) == true) goto L31;
        Class<?> r8 = kotlin.s0.w.d.l0.c.s1.b.d.d(r1);
        if (r8 == null) goto L29;
        r1 = r8;
    L29:
        return new h(r1);
    L31:
        return new h(r1);
    L33:
        if ((r0 instanceof f1) == false) goto L37;
        return new y(null, (f1) r0);
    L37:
        if ((r0 instanceof e1) == true) goto L40;
        return null;
    L40:
        throw new kotlin.n("An operation is not implemented: Type alias classifiers are not yet supported");
    }

    @Override // kotlin.s0.m
    public kotlin.s0.e d() {
        return (kotlin.s0.e) this.f21364h.b(this, f21361j[0]);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof x) == true) goto L5;
    L7:
        return false;
    L5:
        if (kotlin.n0.d.o.a(this.f21362f, ((x) r2).f21362f) == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.m
    public List<kotlin.s0.o> getArguments() {
        T r3 = this.f21365i.b(this, f21361j[1]);
        kotlin.n0.d.o.e(r3, "<get-arguments>(...)");
        return (List) r3;
    }

    public int hashCode() {
        return this.f21362f.hashCode();
    }

    @Override // kotlin.n0.d.p
    public Type j() {
        c0.a<Type> r0 = this.f21363g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.invoke();
    }

    public final kotlin.s0.w.d.l0.n.e0 k() {
        return this.f21362f;
    }

    public String toString() {
        return e0.f18529a.h(this.f21362f);
    }
}
