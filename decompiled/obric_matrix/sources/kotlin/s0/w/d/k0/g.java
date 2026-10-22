package kotlin.s0.w.d.k0;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.s0.w.d.a0;
import kotlin.s0.w.d.i0;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.l;
import kotlin.s0.w.d.l0.c.m;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.c.y;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", NotificationCompat.CATEGORY_CALL, "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g<M extends Member> implements d<M> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<M> f18651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f18652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f18653c;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0086\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final kotlin.r0.d f18654a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Method[] f18655b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Method f18656c;

        public a(kotlin.r0.d r2, Method[] r3, Method r4) {
            o.f(r2, "argumentRange");
            o.f(r3, "unbox");
            this.f18654a = r2;
            this.f18655b = r3;
            this.f18656c = r4;
        }

        public final kotlin.r0.d a() {
            return this.f18654a;
        }

        public final Method[] b() {
            return this.f18655b;
        }

        public final Method c() {
            return this.f18656c;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(kotlin.s0.w.d.l0.c.b r11, d<? extends M> r12, boolean r13) {
        o.f(r11, "descriptor");
        o.f(r12, "caller");
        this.f18651a = r12;
        this.f18652b = r13;
        e0 r0 = r11.getReturnType();
        o.c(r0);
        Class<?> r1 = h.i(r0);
        if (r1 == null) goto L5;
        Method r2 = h.d(r1, r11);
    L7:
        if (kotlin.s0.w.d.l0.k.f.a(r11) == false) goto L9;
        a r14 = new a(kotlin.r0.d.f18467j.a(), new Method[0], r2);
    L72:
        this.f18653c = r14;
        return;
    L9:
        int r5 = -1;
        if ((r12 instanceof e.h.c) == false) goto L13;
    L26:
        if (r13 == false) goto L28;
        int r15 = 2;
    L30:
        if ((r11 instanceof y) == true) goto L32;
    L34:
        int r16 = 0;
    L35:
        int r17 = r15 + r16;
        ArrayList r18 = new ArrayList();
        x0 r3 = r11.m0();
        if (r3 == null) goto L38;
        e0 r4 = r3.b();
    L39:
        if (r4 == null) goto L42;
    L40:
        r18.add(r4);
    L52:
        List<j1> r6 = r11.h();
        o.e(r6, "descriptor.valueParameters");
        Iterator<T> r7 = r6.iterator();
    L54:
        if (r7.hasNext() == false) goto L56;
        r18.add(((j1) r7.next()).b());
        goto L54
    L56:
        int r8 = (r18.size() + r5) + r17;
        if (f.a(this) != r8) goto L75;
        kotlin.r0.d r19 = kotlin.r0.e.m(Math.max(r5, 0), r18.size() + r5);
        Method[] r9 = new Method[r8];
        int r10 = 0;
    L59:
        if (r10 >= r8) goto L71;
        int r20 = r19.a();
        if (r10 > r19.b()) goto L64;
        if (r20 > r10) goto L64;
        boolean r21 = true;
    L65:
        if (r21 == false) goto L69;
        Class<?> r22 = h.i((e0) r18.get(r10 - r5));
        if (r22 == null) goto L69;
        Method r23 = h.f(r22, r11);
    L70:
        r9[r10] = r23;
        r10 = r10 + 1;
    L69:
        r23 = null;
    L64:
        r21 = false;
        goto L65
    L71:
        r14 = new a(r19, r9, r2);
        goto L72
    L75:
        throw new a0("Inconsistent number of parameters in the descriptor and Java reflection object: " + f.a(this) + " != " + r8 + "\nCalling: " + r11 + "\nParameter types: " + a() + ")\nDefault: " + this.f18652b);
    L42:
        if ((r11 instanceof l) == false) goto L47;
        kotlin.s0.w.d.l0.c.e r24 = ((l) r11).A();
        o.e(r24, "descriptor.constructedClass");
        if (r24.M() == false) goto L52;
        m r25 = r24.c();
        o.d(r25, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    L46:
        r4 = ((kotlin.s0.w.d.l0.c.e) r25).s();
        goto L40
    L47:
        r25 = r11.c();
        o.e(r25, "descriptor.containingDeclaration");
        if ((r25 instanceof kotlin.s0.w.d.l0.c.e) == false) goto L52;
        if (kotlin.s0.w.d.l0.k.f.b(r25) == false) goto L52;
    L38:
        r4 = null;
        goto L39
    L32:
        if (((y) r11).isSuspend() == false) goto L34;
        r16 = 1;
        goto L35
    L28:
        r15 = 0;
        goto L30
    L13:
        if ((r11 instanceof l) == false) goto L18;
        if ((r12 instanceof c) == true) goto L26;
    L25:
        r5 = 0;
        goto L26
    L18:
        if (r11.f0() == null) goto L25;
        if ((r12 instanceof c) == true) goto L25;
        m r110 = r11.c();
        o.e(r110, "descriptor.containingDeclaration");
        if (kotlin.s0.w.d.l0.k.f.b(r110) == true) goto L25;
        r5 = 1;
        goto L26
    L5:
        r2 = null;
        goto L7
    }

    @Override // kotlin.s0.w.d.k0.d
    public List<Type> a() {
        return this.f18651a.a();
    }

    @Override // kotlin.s0.w.d.k0.d
    public M b() {
        return (M) this.f18651a.b();
    }

    @Override // kotlin.s0.w.d.k0.d
    public Object call(Object[] r10) {
        o.f(r10, "args");
        a r0 = this.f18653c;
        kotlin.r0.d r1 = r0.a();
        Method[] r2 = r0.b();
        Method r3 = r0.c();
        Object[] r4 = Arrays.copyOf(r10, r10.length);
        o.e(r4, "copyOf(this, size)");
        o.d(r4, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int r5 = r1.a();
        int r6 = r1.b();
        if (r5 > r6) goto L12;
    L4:
        Method r7 = r2[r5];
        Object r8 = r10[r5];
        if (r7 == null) goto L9;
        if (r8 == null) goto L8;
        r8 = r7.invoke(r8, new Object[0]);
        goto L9
    L8:
        Class<?> r9 = r7.getReturnType();
        o.e(r9, "method.returnType");
        r8 = i0.f(r9);
    L9:
        r4[r5] = r8;
        if (r5 == r6) goto L12;
        r5 = r5 + 1;
    L12:
        Object r11 = this.f18651a.call(r4);
        if (r3 == null) goto L20;
        Object r12 = r3.invoke(null, new Object[]{r11});
        if (r12 != null) goto L18;
        return r11;
    L18:
        return r12;
    L20:
        return r11;
    }

    @Override // kotlin.s0.w.d.k0.d
    public Type getReturnType() {
        return this.f18651a.getReturnType();
    }
}
