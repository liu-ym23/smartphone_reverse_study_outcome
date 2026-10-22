package kotlin.s0.w.d.k0;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.i0.r;
import kotlin.n0.c.l;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.s0.w.d.a0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014²\u0006\u0014\u0010\u0015\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002²\u0006\u0014\u0010\u0016\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"createAnnotationInstance", "T", "", "annotationClass", "Ljava/lang/Class;", "values", "", "", "methods", "", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", "", "index", "", "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class b {

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f18629f;

        a(Map<String, ? extends Object> r1) {
            this.f18629f = r1;
            super(0);
        }

        public final Integer a() {
            Iterator<T> r4 = this.f18629f.entrySet().iterator();
            int r0 = 0;
        L4:
            if (r4.hasNext() == false) goto L35;
            Map.Entry r1 = (Map.Entry) r4.next();
            String r2 = (String) r1.getKey();
            Object r3 = r1.getValue();
            if ((r3 instanceof boolean[]) == false) goto L9;
            int r5 = Arrays.hashCode((boolean[]) r3);
        L33:
            r0 = r0 + (r5 ^ (r2.hashCode() * 127));
            goto L4
        L9:
            if ((r3 instanceof char[]) == false) goto L12;
            r5 = Arrays.hashCode((char[]) r3);
            goto L33
        L12:
            if ((r3 instanceof byte[]) == false) goto L15;
            r5 = Arrays.hashCode((byte[]) r3);
            goto L33
        L15:
            if ((r3 instanceof short[]) == false) goto L18;
            r5 = Arrays.hashCode((short[]) r3);
            goto L33
        L18:
            if ((r3 instanceof int[]) == false) goto L21;
            r5 = Arrays.hashCode((int[]) r3);
            goto L33
        L21:
            if ((r3 instanceof float[]) == false) goto L24;
            r5 = Arrays.hashCode((float[]) r3);
            goto L33
        L24:
            if ((r3 instanceof long[]) == false) goto L27;
            r5 = Arrays.hashCode((long[]) r3);
            goto L33
        L27:
            if ((r3 instanceof double[]) == false) goto L30;
            r5 = Arrays.hashCode((double[]) r3);
            goto L33
        L30:
            if ((r3 instanceof Object[]) == false) goto L32;
            r5 = Arrays.hashCode((Object[]) r3);
            goto L33
        L32:
            r5 = r3.hashCode();
            goto L33
        L35:
            return Integer.valueOf(r0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return a();
        }
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.k0.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "T", "<anonymous parameter 0>", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class C0488b implements InvocationHandler {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class<T> f18630f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f18631g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.h<String> f18632h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.h<Integer> f18633i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ List<Method> f18634j;

        C0488b(Class<T> r1, Map<String, ? extends Object> r2, kotlin.h<String> r3, kotlin.h<Integer> r4, List<Method> r5) {
            this.f18630f = r1;
            this.f18631g = r2;
            this.f18632h = r3;
            this.f18633i = r4;
            this.f18634j = r5;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r4, Method r5, Object[] r6) {
            String r7 = r5.getName();
            if (r7 == null) goto L24;
            int r0 = r7.hashCode();
            if (r0 == (-1776922004)) goto L20;
            if (r0 == 147696667) goto L16;
            if (r0 != 1444986633) goto L24;
            if (r7.equals("annotationType") == false) goto L24;
            return this.f18630f;
        L16:
            if (r7.equals("hashCode") == false) goto L24;
            return Integer.valueOf(b.b(this.f18633i));
        L20:
            if (r7.equals("toString") == false) goto L24;
            return b.c(this.f18632h);
        L24:
            if (o.a(r7, "equals") == false) goto L34;
            boolean r1 = true;
            if (r6 != null) goto L28;
        L30:
            r1 = false;
        L31:
            if (r1 == false) goto L34;
            Class<T> r8 = this.f18630f;
            List<Method> r9 = this.f18634j;
            Map<String, Object> r3 = this.f18631g;
            o.e(r6, "args");
            return Boolean.valueOf(b.a(r8, r9, r3, kotlin.i0.i.S(r6)));
        L28:
            if (r6.length != 1) goto L30;
        L34:
            if (this.f18631g.containsKey(r7) == true) goto L36;
            StringBuilder r10 = new StringBuilder();
            r10.append("Method is not supported: ");
            r10.append(r5);
            r10.append(" (args: ");
            if (r6 != null) goto L40;
            r6 = new Object[0];
        L40:
            r10.append(kotlin.i0.i.e0(r6));
            r10.append(')');
            throw new a0(r10.toString());
        L36:
            return this.f18631g.get(r7);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends q implements kotlin.n0.c.a<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class<T> f18635f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f18636g;

        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "", "entry", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends q implements l<Map.Entry<? extends String, ? extends Object>, CharSequence> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f18637f = null;

            static {
                f18637f = new a();
            }

            a() {
                super(1);
            }

            public final CharSequence a(Map.Entry<String, ? extends Object> r3) {
                o.f(r3, "entry");
                String r2 = r3.getKey();
                Object r4 = r3.getValue();
                if ((r4 instanceof boolean[]) == false) goto L7;
                String r5 = Arrays.toString((boolean[]) r4);
            L5:
                o.e(r5, "toString(this)");
            L32:
                return r2 + '=' + r5;
            L7:
                if ((r4 instanceof char[]) == false) goto L10;
                r5 = Arrays.toString((char[]) r4);
                goto L5
            L10:
                if ((r4 instanceof byte[]) == false) goto L13;
                r5 = Arrays.toString((byte[]) r4);
                goto L5
            L13:
                if ((r4 instanceof short[]) == false) goto L16;
                r5 = Arrays.toString((short[]) r4);
                goto L5
            L16:
                if ((r4 instanceof int[]) == false) goto L19;
                r5 = Arrays.toString((int[]) r4);
                goto L5
            L19:
                if ((r4 instanceof float[]) == false) goto L22;
                r5 = Arrays.toString((float[]) r4);
                goto L5
            L22:
                if ((r4 instanceof long[]) == false) goto L25;
                r5 = Arrays.toString((long[]) r4);
                goto L5
            L25:
                if ((r4 instanceof double[]) == false) goto L28;
                r5 = Arrays.toString((double[]) r4);
                goto L5
            L28:
                if ((r4 instanceof Object[]) == false) goto L30;
                r5 = Arrays.toString((Object[]) r4);
                goto L5
            L30:
                r5 = r4.toString();
                goto L32
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> r1) {
                return a(r1);
            }
        }

        c(Class<T> r1, Map<String, ? extends Object> r2) {
            this.f18635f = r1;
            this.f18636g = r2;
            super(0);
        }

        public final String a() {
            Class<T> r0 = this.f18635f;
            Map<String, Object> r12 = this.f18636g;
            StringBuilder r11 = new StringBuilder();
            r11.append('@');
            r11.append(r0.getCanonicalName());
            r.X(r12.entrySet(), r11, ", ", "(", ")", 0, null, a.f18637f, 48, null);
            String r13 = r11.toString();
            o.e(r13, "StringBuilder().apply(builderAction).toString()");
            return r13;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ String invoke() {
            return a();
        }
    }

    public static final /* synthetic */ boolean a(Class r0, List r1, Map r2, Object r3) {
        return h(r0, r1, r2, r3);
    }

    public static final /* synthetic */ int b(kotlin.h r0) {
        return i(r0);
    }

    public static final /* synthetic */ String c(kotlin.h r0) {
        return j(r0);
    }

    public static final /* synthetic */ Void d(int r0, String r1, Class r2) {
        k(r0, r1, r2);
        throw null;
    }

    public static final /* synthetic */ Object e(Object r0, Class r1) {
        return l(r0, r1);
    }

    public static final <T> T f(Class<T> r9, Map<String, ? extends Object> r10, List<Method> r11) {
        o.f(r9, "annotationClass");
        o.f(r10, "values");
        o.f(r11, "methods");
        kotlin.h r5 = kotlin.i.b(new a(r10));
        kotlin.h r4 = kotlin.i.b(new c(r9, r10));
        T r12 = (T) Proxy.newProxyInstance(r9.getClassLoader(), new Class[]{r9}, new C0488b(r9, r10, r4, r5, r11));
        o.d(r12, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return r12;
    }

    public static /* synthetic */ Object g(Class r1, Map r2, List r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L10;
        Set r6 = r2.keySet();
        ArrayList r7 = new ArrayList(r.q(r6, 10));
        Iterator r8 = r6.iterator();
    L6:
        if (r8.hasNext() == false) goto L8;
        r7.add(r1.getDeclaredMethod((String) r8.next(), new Class[0]));
        goto L6
    L8:
        r3 = r7;
    L10:
        return f(r1, r2, r3);
    }

    private static final <T> boolean h(Class<T> r4, List<Method> r5, Map<String, ? extends Object> r6, Object r7) {
        Class r1 = null;
        if ((r7 instanceof Annotation) == false) goto L5;
        Annotation r0 = (Annotation) r7;
    L6:
        if (r0 == null) goto L11;
        kotlin.s0.d r2 = kotlin.n0.a.a(r0);
        if (r2 == null) goto L11;
        r1 = kotlin.n0.a.b(r2);
    L11:
        if (o.a(r1, r4) == false) goto L53;
        if ((r5 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r8 = r5.iterator();
    L19:
        if (r8.hasNext() == false) goto L16;
        Method r9 = (Method) r8.next();
        Object r3 = r6.get(r9.getName());
        Object r10 = r9.invoke(r7, new Object[0]);
        if ((r3 instanceof boolean[]) == false) goto L24;
        o.d(r10, "null cannot be cast to non-null type kotlin.BooleanArray");
        boolean r11 = Arrays.equals((boolean[]) r3, (boolean[]) r10);
    L48:
        if (r11 == true) goto L19;
        boolean r12 = false;
    L50:
        if (r12 == false) goto L53;
        return true;
    L24:
        if ((r3 instanceof char[]) == false) goto L27;
        o.d(r10, "null cannot be cast to non-null type kotlin.CharArray");
        r11 = Arrays.equals((char[]) r3, (char[]) r10);
        goto L48
    L27:
        if ((r3 instanceof byte[]) == false) goto L30;
        o.d(r10, "null cannot be cast to non-null type kotlin.ByteArray");
        r11 = Arrays.equals((byte[]) r3, (byte[]) r10);
        goto L48
    L30:
        if ((r3 instanceof short[]) == false) goto L33;
        o.d(r10, "null cannot be cast to non-null type kotlin.ShortArray");
        r11 = Arrays.equals((short[]) r3, (short[]) r10);
        goto L48
    L33:
        if ((r3 instanceof int[]) == false) goto L36;
        o.d(r10, "null cannot be cast to non-null type kotlin.IntArray");
        r11 = Arrays.equals((int[]) r3, (int[]) r10);
        goto L48
    L36:
        if ((r3 instanceof float[]) == false) goto L39;
        o.d(r10, "null cannot be cast to non-null type kotlin.FloatArray");
        r11 = Arrays.equals((float[]) r3, (float[]) r10);
        goto L48
    L39:
        if ((r3 instanceof long[]) == false) goto L42;
        o.d(r10, "null cannot be cast to non-null type kotlin.LongArray");
        r11 = Arrays.equals((long[]) r3, (long[]) r10);
        goto L48
    L42:
        if ((r3 instanceof double[]) == false) goto L45;
        o.d(r10, "null cannot be cast to non-null type kotlin.DoubleArray");
        r11 = Arrays.equals((double[]) r3, (double[]) r10);
        goto L48
    L45:
        if ((r3 instanceof Object[]) == false) goto L47;
        o.d(r10, "null cannot be cast to non-null type kotlin.Array<*>");
        r11 = Arrays.equals((Object[]) r3, (Object[]) r10);
        goto L48
    L47:
        r11 = o.a(r3, r10);
    L16:
        r12 = true;
        goto L50
    L15:
        if (r5.isEmpty() == false) goto L17;
    L53:
        return false;
    L5:
        r0 = null;
        goto L6
    }

    private static final int i(kotlin.h<Integer> r0) {
        return r0.getValue().intValue();
    }

    private static final String j(kotlin.h<String> r0) {
        return r0.getValue();
    }

    private static final Void k(int r3, String r4, Class<?> r5) {
        if (o.a(r5, Class.class) == false) goto L7;
        Class r6 = kotlin.s0.d.class;
    L5:
        kotlin.s0.d r7 = e0.b(r6);
    L13:
        if (o.a(r7.a(), e0.b(Object[].class).a()) == false) goto L15;
        StringBuilder r0 = new StringBuilder();
        r0.append(r7.a());
        r0.append('<');
        Class<?> r8 = kotlin.n0.a.b(r7).getComponentType();
        o.e(r8, "kotlinClass.java.componentType");
        r0.append(kotlin.n0.a.e(r8).a());
        r0.append('>');
        String r9 = r0.toString();
    L17:
        throw new IllegalArgumentException("Argument #" + r3 + ' ' + r4 + " is not of the required type " + r9);
    L15:
        r9 = r7.a();
        goto L17
    L7:
        if (r5.isArray() == true) goto L9;
    L11:
        r7 = kotlin.n0.a.e(r5);
        goto L13
    L9:
        if (o.a(r5.getComponentType(), Class.class) == false) goto L11;
        r6 = kotlin.s0.d[].class;
        goto L5
    }

    private static final Object l(Object r6, Class<?> r7) {
        if ((r6 instanceof Class) == false) goto L6;
        return null;
    L6:
        if ((r6 instanceof kotlin.s0.d) == false) goto L9;
        r6 = kotlin.n0.a.b((kotlin.s0.d) r6);
    L21:
        if (r7.isInstance(r6) == true) goto L23;
        return null;
    L23:
        return r6;
    L9:
        if ((r6 instanceof Object[]) == false) goto L21;
        Object[] r0 = (Object[]) r6;
        if ((r0 instanceof Class[]) == false) goto L14;
        return null;
    L14:
        if ((r0 instanceof kotlin.s0.d[]) == false) goto L19;
        o.d(r6, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
        kotlin.s0.d[] r8 = (kotlin.s0.d[]) r6;
        ArrayList r1 = new ArrayList(r8.length);
        int r2 = r8.length;
        int r4 = 0;
    L16:
        if (r4 >= r2) goto L18;
        r1.add(kotlin.n0.a.b(r8[r4]));
        r4 = r4 + 1;
        goto L16
    L18:
        r6 = r1.toArray(new Class[0]);
        o.d(r6, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        goto L21
    L19:
        r6 = r0;
        goto L21
    }
}
