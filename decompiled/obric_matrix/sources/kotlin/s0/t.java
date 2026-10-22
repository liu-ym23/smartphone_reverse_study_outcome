package kotlin.s0;

import com.bytedance.common.wschannel.WsConstants;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", WsConstants.KEY_CONNECTION_TYPE, "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class t {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18493a = null;

        static {
            int[] r0 = new int[p.values().length];
            r0[p.f18480g.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[p.f18479f.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[p.f18481h.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f18493a = r0;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* synthetic */ class b extends kotlin.n0.d.m implements kotlin.n0.c.l<Class<?>, Class<?>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f18494f = null;

        static {
            f18494f = new b();
        }

        b() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ Class<?> invoke(Class<?> r1) {
            return m(r1);
        }

        public final Class<?> m(Class<?> r1) {
            kotlin.n0.d.o.f(r1, "p0");
            return r1.getComponentType();
        }
    }

    public static final /* synthetic */ Type a(m r0, boolean r1) {
        return c(r0, r1);
    }

    public static final /* synthetic */ String b(Type r0) {
        return h(r0);
    }

    private static final Type c(m r3, boolean r4) {
        e r0 = r3.d();
        if ((r0 instanceof n) == false) goto L7;
        return new s((n) r0);
    L7:
        if ((r0 instanceof d) == false) goto L46;
        d r1 = (d) r0;
        if (r4 == false) goto L11;
        Class r5 = kotlin.n0.a.c(r1);
    L12:
        List<o> r2 = r3.getArguments();
        if (r2.isEmpty() == false) goto L16;
        return r5;
    L16:
        if (r5.isArray() == false) goto L44;
        if (r5.getComponentType().isPrimitive() == false) goto L20;
        return r5;
    L20:
        o r6 = (o) kotlin.i0.r.q0(r2);
        if (r6 == null) goto L42;
        p r7 = r6.a();
        m r8 = r6.b();
        if (r7 != null) goto L25;
        int r9 = -1;
    L26:
        if (r9 != (-1)) goto L28;
        return r5;
    L28:
        if (r9 != 1) goto L30;
        return r5;
    L30:
        if (r9 != 2) goto L32;
    L36:
        kotlin.n0.d.o.c(r8);
        Type r10 = d(r8, false, 1, null);
        if ((r10 instanceof Class) == false) goto L40;
        return r5;
    L40:
        return new kotlin.s0.a(r10);
    L32:
        if (r9 == 3) goto L36;
        throw new kotlin.m();
    L25:
        r9 = a.f18493a[r7.ordinal()];
        goto L26
    L42:
        throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + r3);
    L44:
        return e(r5, r2);
    L11:
        r5 = kotlin.n0.a.b(r1);
        goto L12
    L46:
        throw new UnsupportedOperationException("Unsupported type classifier: " + r3);
    }

    static /* synthetic */ Type d(m r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return c(r0, r1);
    }

    private static final Type e(Class<?> r4, List<o> r5) {
        Class<?> r0 = r4.getDeclaringClass();
        if (r0 != null) goto L11;
        ArrayList r2 = new ArrayList(kotlin.i0.r.q(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        r2.add(g((o) r6.next()));
        goto L6
    L9:
        return new r(r4, null, r2);
    L11:
        if (Modifier.isStatic(r4.getModifiers()) == false) goto L18;
        ArrayList r3 = new ArrayList(kotlin.i0.r.q(r5, 10));
        Iterator<T> r7 = r5.iterator();
    L14:
        if (r7.hasNext() == false) goto L17;
        r3.add(g((o) r7.next()));
        goto L14
    L17:
        return new r(r4, r0, r3);
    L18:
        int r8 = r4.getTypeParameters().length;
        Type r1 = e(r0, r5.subList(r8, r5.size()));
        List<o> r9 = r5.subList(0, r8);
        ArrayList r10 = new ArrayList(kotlin.i0.r.q(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L20:
        if (r11.hasNext() == false) goto L23;
        r10.add(g((o) r11.next()));
        goto L20
    L23:
        return new r(r4, r1, r10);
    }

    public static final Type f(m r3) {
        kotlin.n0.d.o.f(r3, "<this>");
        if ((r3 instanceof kotlin.n0.d.p) == false) goto L8;
        Type r0 = ((kotlin.n0.d.p) r3).j();
        if (r0 == null) goto L8;
        return r0;
    L8:
        return d(r3, false, 1, null);
    }

    private static final Type g(o r4) {
        p r0 = r4.d();
        if (r0 == null) goto L5;
        m r5 = r4.c();
        kotlin.n0.d.o.c(r5);
        int r1 = a.f18493a[r0.ordinal()];
        if (r1 == 1) goto L17;
        if (r1 == 2) goto L19;
        if (r1 != 3) goto L14;
        return new u(c(r5, true), null);
    L14:
        throw new kotlin.m();
    L19:
        return c(r5, true);
    L17:
        return new u(null, c(r5, true));
    L5:
        return u.f18495h.a();
    }

    private static final String h(Type r2) {
        if ((r2 instanceof Class) == false) goto L10;
        Class r0 = (Class) r2;
        if (r0.isArray() == false) goto L7;
        kotlin.t0.h r3 = kotlin.t0.k.h(r2, b.f18494f);
        String r4 = ((Class) kotlin.t0.k.s(r3)).getName() + kotlin.u0.k.s("[]", kotlin.t0.k.l(r3));
    L8:
        kotlin.n0.d.o.e(r4, "{\n        if (type.isArr…   } else type.name\n    }");
        return r4;
    L7:
        r4 = r0.getName();
        goto L8
    L10:
        return r2.toString();
    }
}
