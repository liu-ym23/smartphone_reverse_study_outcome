package kotlin.s0.w.d;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.v0;
import kotlin.s0.w.d.l0.c.w0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", "", "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f18547a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.s0.w.d.l0.g.b f18548b = null;

    static {
        f18547a = new f0();
        kotlin.s0.w.d.l0.g.b r0 = kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("java.lang.Void"));
        kotlin.n0.d.o.e(r0, "topLevel(FqName(\"java.lang.Void\"))");
        f18548b = r0;
    }

    private f0() {
    }

    private final kotlin.s0.w.d.l0.b.i a(Class<?> r1) {
        if (r1.isPrimitive() == true) goto L7;
        return null;
    L7:
        return kotlin.s0.w.d.l0.k.u.e.b(r1.getSimpleName()).k();
    }

    private final boolean b(kotlin.s0.w.d.l0.c.y r3) {
        if (kotlin.s0.w.d.l0.k.c.o(r3) == false) goto L5;
    L14:
        return true;
    L5:
        if (kotlin.s0.w.d.l0.k.c.p(r3) == true) goto L14;
        if (kotlin.n0.d.o.a(r3.getName(), kotlin.s0.w.d.l0.b.q.a.f18767e.a()) == true) goto L10;
        return false;
    L10:
        if (r3.h().isEmpty() == false) goto L15;
        return true;
    L15:
        return false;
    }

    private final d.e d(kotlin.s0.w.d.l0.c.y r6) {
        return new d.e(new kotlin.s0.w.d.l0.f.a0.b.d.b(e(r6), kotlin.s0.w.d.l0.e.b.v.c(r6, false, false, 1, null)));
    }

    private final String e(kotlin.s0.w.d.l0.c.b r2) {
        String r1 = kotlin.s0.w.d.l0.e.a.g0.b(r2);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if ((r2 instanceof v0) == false) goto L8;
        String r3 = kotlin.s0.w.d.l0.k.t.a.o(r2).getName().b();
        kotlin.n0.d.o.e(r3, "descriptor.propertyIfAccessor.name.asString()");
        return kotlin.s0.w.d.l0.e.a.z.b(r3);
    L8:
        if ((r2 instanceof w0) == false) goto L10;
        String r4 = kotlin.s0.w.d.l0.k.t.a.o(r2).getName().b();
        kotlin.n0.d.o.e(r4, "descriptor.propertyIfAccessor.name.asString()");
        return kotlin.s0.w.d.l0.e.a.z.e(r4);
    L10:
        String r5 = r2.getName().b();
        kotlin.n0.d.o.e(r5, "descriptor.name.asString()");
        return r5;
    }

    public final kotlin.s0.w.d.l0.g.b c(Class<?> r3) {
        kotlin.n0.d.o.f(r3, "klass");
        if (r3.isArray() == false) goto L11;
        Class<?> r4 = r3.getComponentType();
        kotlin.n0.d.o.e(r4, "klass.componentType");
        kotlin.s0.w.d.l0.b.i r2 = a(r4);
        if (r2 != null) goto L7;
        kotlin.s0.w.d.l0.g.b r5 = kotlin.s0.w.d.l0.g.b.m(kotlin.s0.w.d.l0.b.k.a.f18725h.l());
        kotlin.n0.d.o.e(r5, "topLevel(StandardNames.FqNames.array.toSafe())");
        return r5;
    L7:
        return new kotlin.s0.w.d.l0.g.b(kotlin.s0.w.d.l0.b.k.f18715k, r2.c());
    L11:
        if (kotlin.n0.d.o.a(r3, Void.TYPE) == true) goto L13;
        kotlin.s0.w.d.l0.b.i r6 = a(r3);
        if (r6 != null) goto L17;
        kotlin.s0.w.d.l0.g.b r7 = kotlin.s0.w.d.l0.c.s1.b.d.a(r3);
        if (r7.k() == true) goto L23;
        kotlin.s0.w.d.l0.b.q.c r8 = kotlin.s0.w.d.l0.b.q.c.f18771a;
        kotlin.s0.w.d.l0.g.c r0 = r7.b();
        kotlin.n0.d.o.e(r0, "classId.asSingleFqName()");
        kotlin.s0.w.d.l0.g.b r9 = r8.m(r0);
        if (r9 == null) goto L23;
        return r9;
    L23:
        return r7;
    L17:
        return new kotlin.s0.w.d.l0.g.b(kotlin.s0.w.d.l0.b.k.f18715k, r6.j());
    L13:
        return f18548b;
    }

    public final e f(u0 r7) {
        kotlin.n0.d.o.f(r7, "possiblyOverriddenProperty");
        u0 r1 = ((u0) kotlin.s0.w.d.l0.k.d.L(r7)).a();
        kotlin.n0.d.o.e(r1, "unwrapFakeOverride(possi…rriddenProperty).original");
        Method r0 = null;
        d.e r2 = null;
        if ((r1 instanceof kotlin.s0.w.d.l0.l.b.g0.j) == false) goto L9;
        kotlin.s0.w.d.l0.l.b.g0.j r8 = (kotlin.s0.w.d.l0.l.b.g0.j) r1;
        kotlin.s0.w.d.l0.f.n r3 = r8.g1();
        kotlin.s0.w.d.l0.i.i.f<kotlin.s0.w.d.l0.f.n, kotlin.s0.w.d.l0.f.a0.a.d> r4 = kotlin.s0.w.d.l0.f.a0.a.f19803d;
        kotlin.n0.d.o.e(r4, "propertySignature");
        kotlin.s0.w.d.l0.f.a0.a.d r5 = (kotlin.s0.w.d.l0.f.a0.a.d) kotlin.s0.w.d.l0.f.z.e.a(r3, r4);
        if (r5 != null) goto L7;
    L43:
        v0 r9 = r1.g();
        kotlin.n0.d.o.c(r9);
        d.e r10 = d(r9);
        w0 r6 = r1.Y();
        if (r6 == null) goto L47;
        r2 = d(r6);
    L47:
        return new e.d(r10, r2);
    L7:
        return new e.c(r1, r3, r5, r8.Z(), r8.S());
    L9:
        if ((r1 instanceof kotlin.s0.w.d.l0.e.a.k0.f) == false) goto L43;
        a1 r11 = ((kotlin.s0.w.d.l0.e.a.k0.f) r1).getSource();
        if ((r11 instanceof kotlin.s0.w.d.l0.e.a.m0.a) == false) goto L13;
        kotlin.s0.w.d.l0.e.a.m0.a r12 = (kotlin.s0.w.d.l0.e.a.m0.a) r11;
    L14:
        if (r12 == null) goto L16;
        kotlin.s0.w.d.l0.e.a.n0.l r13 = r12.b();
    L18:
        if ((r13 instanceof kotlin.s0.w.d.l0.c.s1.b.r) == false) goto L21;
        return new e.a(((kotlin.s0.w.d.l0.c.s1.b.r) r13).W());
    L21:
        if ((r13 instanceof kotlin.s0.w.d.l0.c.s1.b.u) == false) goto L42;
        Method r14 = ((kotlin.s0.w.d.l0.c.s1.b.u) r13).W();
        w0 r15 = r1.Y();
        if (r15 == null) goto L25;
        a1 r16 = r15.getSource();
    L27:
        if ((r16 instanceof kotlin.s0.w.d.l0.e.a.m0.a) == false) goto L29;
        kotlin.s0.w.d.l0.e.a.m0.a r17 = (kotlin.s0.w.d.l0.e.a.m0.a) r16;
    L30:
        if (r17 == null) goto L32;
        kotlin.s0.w.d.l0.e.a.n0.l r18 = r17.b();
    L34:
        if ((r18 instanceof kotlin.s0.w.d.l0.c.s1.b.u) == false) goto L36;
        kotlin.s0.w.d.l0.c.s1.b.u r19 = (kotlin.s0.w.d.l0.c.s1.b.u) r18;
    L37:
        if (r19 == null) goto L40;
        r0 = r19.W();
    L40:
        return new e.b(r14, r0);
    L36:
        r19 = null;
        goto L37
    L32:
        r18 = null;
        goto L34
    L29:
        r17 = null;
        goto L30
    L25:
        r16 = null;
        goto L27
    L42:
        throw new a0("Incorrect resolution sequence for Java field " + r1 + " (source = " + r13 + ')');
    L16:
        r13 = null;
        goto L18
    L13:
        r12 = null;
        goto L14
    }

    public final d g(kotlin.s0.w.d.l0.c.y r8) {
        kotlin.n0.d.o.f(r8, "possiblySubstitutedFunction");
        kotlin.s0.w.d.l0.c.y r0 = ((kotlin.s0.w.d.l0.c.y) kotlin.s0.w.d.l0.k.d.L(r8)).a();
        kotlin.n0.d.o.e(r0, "unwrapFakeOverride(possi…titutedFunction).original");
        if ((r0 instanceof kotlin.s0.w.d.l0.l.b.g0.b) == false) goto L21;
        kotlin.s0.w.d.l0.l.b.g0.b r1 = (kotlin.s0.w.d.l0.l.b.g0.b) r0;
        kotlin.s0.w.d.l0.i.q r2 = r1.C();
        if ((r2 instanceof kotlin.s0.w.d.l0.f.i) == false) goto L11;
        kotlin.s0.w.d.l0.f.a0.b.d.b r3 = kotlin.s0.w.d.l0.f.a0.b.i.f19890a.e((kotlin.s0.w.d.l0.f.i) r2, r1.Z(), r1.S());
        if (r3 == null) goto L11;
        return new d.e(r3);
    L11:
        if ((r2 instanceof kotlin.s0.w.d.l0.f.d) == false) goto L20;
        kotlin.s0.w.d.l0.f.a0.b.d.b r4 = kotlin.s0.w.d.l0.f.a0.b.i.f19890a.b((kotlin.s0.w.d.l0.f.d) r2, r1.Z(), r1.S());
        if (r4 == null) goto L20;
        kotlin.s0.w.d.l0.c.m r7 = r8.c();
        kotlin.n0.d.o.e(r7, "possiblySubstitutedFunction.containingDeclaration");
        if (kotlin.s0.w.d.l0.k.f.b(r7) == false) goto L18;
        return new d.e(r4);
    L18:
        return new d.C0482d(r4);
    L20:
        return d(r0);
    L21:
        kotlin.s0.w.d.l0.e.a.n0.l r5 = null;
        kotlin.s0.w.d.l0.c.s1.b.u r6 = null;
        if ((r0 instanceof kotlin.s0.w.d.l0.e.a.k0.e) == false) goto L41;
        a1 r9 = ((kotlin.s0.w.d.l0.e.a.k0.e) r0).getSource();
        if ((r9 instanceof kotlin.s0.w.d.l0.e.a.m0.a) == false) goto L26;
        kotlin.s0.w.d.l0.e.a.m0.a r10 = (kotlin.s0.w.d.l0.e.a.m0.a) r9;
    L27:
        if (r10 == null) goto L29;
        kotlin.s0.w.d.l0.e.a.n0.l r11 = r10.b();
    L31:
        if ((r11 instanceof kotlin.s0.w.d.l0.c.s1.b.u) == false) goto L33;
        r6 = (kotlin.s0.w.d.l0.c.s1.b.u) r11;
    L33:
        if (r6 == null) goto L39;
        Method r12 = r6.W();
        if (r12 == null) goto L39;
        return new d.c(r12);
    L39:
        throw new a0("Incorrect resolution sequence for Java method " + r0);
    L29:
        r11 = null;
        goto L31
    L26:
        r10 = null;
        goto L27
    L41:
        if ((r0 instanceof kotlin.s0.w.d.l0.e.a.k0.b) == false) goto L60;
        a1 r13 = ((kotlin.s0.w.d.l0.e.a.k0.b) r0).getSource();
        if ((r13 instanceof kotlin.s0.w.d.l0.e.a.m0.a) == false) goto L45;
        kotlin.s0.w.d.l0.e.a.m0.a r14 = (kotlin.s0.w.d.l0.e.a.m0.a) r13;
    L46:
        if (r14 == null) goto L49;
        r5 = r14.b();
    L49:
        if ((r5 instanceof kotlin.s0.w.d.l0.c.s1.b.o) == false) goto L52;
        return new d.b(((kotlin.s0.w.d.l0.c.s1.b.o) r5).W());
    L52:
        if ((r5 instanceof kotlin.s0.w.d.l0.c.s1.b.l) == false) goto L58;
        kotlin.s0.w.d.l0.c.s1.b.l r15 = (kotlin.s0.w.d.l0.c.s1.b.l) r5;
        if (r15.q() == false) goto L58;
        return new d.a(r15.V());
    L58:
        throw new a0("Incorrect resolution sequence for Java constructor " + r0 + " (" + r5 + ')');
    L45:
        r14 = null;
        goto L46
    L60:
        if (b(r0) == false) goto L64;
        return d(r0);
    L64:
        throw new a0("Unknown origin of " + r0 + " (" + r0.getClass() + ')');
    }
}
