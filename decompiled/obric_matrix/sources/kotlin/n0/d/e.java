package kotlin.n0.d;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.common.wschannel.WsConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.i0.m0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010F\u001a\u00020\u00122\b\u0010G\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020\u00122\b\u0010M\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010N\u001a\u000201H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0014\u001a\u0004\b \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0014\u001a\u0004\b\"\u0010\u0015R\u001a\u0010$\u001a\u00020\u00128VX\u0097\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0014\u001a\u0004\b$\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u001e\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\u0010R\u0016\u0010-\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R(\u00104\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0014\u001a\u0004\b6\u0010\u000bR\u0016\u00107\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00103R \u00109\u001a\b\u0012\u0004\u0012\u00020:0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0014\u001a\u0004\b<\u0010\u000bR \u0010=\u001a\b\u0012\u0004\u0012\u00020>0\b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b?\u0010\u0014\u001a\u0004\b@\u0010\u000bR\u001c\u0010A\u001a\u0004\u0018\u00010B8VX\u0097\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0014\u001a\u0004\bD\u0010E¨\u0006P"}, d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", WsConstants.KEY_CONNECTION_ERROR, "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e implements kotlin.s0.d<Object>, d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f18432g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Map<Class<? extends kotlin.c<?>>, Integer> f18433h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashMap<String, String> f18434i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final HashMap<String, String> f18435j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final HashMap<String, String> f18436k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map<String, String> f18437l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f18438f;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final String a(Class<?> r2) {
            o.f(r2, "jClass");
            String r0 = null;
            if (r2.isAnonymousClass() == false) goto L6;
            return null;
        L6:
            if (r2.isLocalClass() == false) goto L9;
            return null;
        L9:
            if (r2.isArray() == false) goto L17;
            Class<?> r1 = r2.getComponentType();
            if (r1.isPrimitive() == false) goto L15;
            String r3 = (String) e.f().get(r1.getName());
            if (r3 == null) goto L15;
            r0 = r3 + "Array";
        L15:
            if (r0 != null) goto L21;
            return "kotlin.Array";
        L21:
            return r0;
        L17:
            String r4 = (String) e.f().get(r2.getName());
            if (r4 == null) goto L20;
            return r4;
        L20:
            return r2.getCanonicalName();
        }

        public final String b(Class<?> r7) {
            o.f(r7, "jClass");
            String r1 = null;
            if (r7.isAnonymousClass() == false) goto L6;
        L28:
            return r1;
        L6:
            if (r7.isLocalClass() == false) goto L16;
            String r6 = r7.getSimpleName();
            Method r0 = r7.getEnclosingMethod();
            if (r0 == null) goto L11;
            o.e(r6, "name");
            String r2 = kotlin.u0.k.y0(r6, r0.getName() + '$', null, 2, null);
            if (r2 == null) goto L11;
            return r2;
        L11:
            Constructor<?> r8 = r7.getEnclosingConstructor();
            o.e(r6, "name");
            if (r8 == null) goto L31;
            return kotlin.u0.k.y0(r6, r8.getName() + '$', null, 2, null);
        L31:
            return kotlin.u0.k.x0(r6, '$', null, 2, null);
        L16:
            if (r7.isArray() == false) goto L24;
            Class<?> r9 = r7.getComponentType();
            if (r9.isPrimitive() == false) goto L22;
            String r10 = (String) e.k().get(r9.getName());
            if (r10 == null) goto L22;
            r1 = r10 + "Array";
        L22:
            if (r1 != null) goto L28;
            return "Array";
        L24:
            String r3 = (String) e.k().get(r7.getName());
            if (r3 == null) goto L27;
            return r3;
        L27:
            return r7.getSimpleName();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        f18432g = new a(null);
        int r3 = 0;
        List r0 = kotlin.i0.r.j(new Class[]{kotlin.n0.c.a.class, kotlin.n0.c.l.class, kotlin.n0.c.p.class, kotlin.n0.c.q.class, kotlin.n0.c.r.class, kotlin.n0.c.s.class, kotlin.n0.c.t.class, kotlin.n0.c.u.class, kotlin.n0.c.v.class, kotlin.n0.c.w.class, kotlin.n0.c.b.class, kotlin.n0.c.c.class, kotlin.n0.c.d.class, kotlin.n0.c.e.class, kotlin.n0.c.f.class, kotlin.n0.c.g.class, kotlin.n0.c.h.class, kotlin.n0.c.i.class, kotlin.n0.c.j.class, kotlin.n0.c.k.class, kotlin.n0.c.m.class, kotlin.n0.c.n.class, kotlin.n0.c.o.class});
        ArrayList r2 = new ArrayList(kotlin.i0.r.q(r0, 10));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Object r5 = r1.next();
        int r6 = r3 + 1;
        if (r3 < 0) goto L8;
        r2.add(kotlin.a0.a((Class) r5, Integer.valueOf(r3)));
        r3 = r6;
        goto L4
    L8:
        kotlin.i0.r.p();
        throw null;
    L10:
        f18433h = m0.q(r2);
        HashMap<String, String> r4 = new HashMap();
        r4.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        r4.put("char", "kotlin.Char");
        r4.put("byte", "kotlin.Byte");
        r4.put("short", "kotlin.Short");
        r4.put("int", "kotlin.Int");
        r4.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        r4.put("long", "kotlin.Long");
        r4.put("double", "kotlin.Double");
        f18434i = r4;
        HashMap<String, String> r7 = new HashMap();
        r7.put("java.lang.Boolean", "kotlin.Boolean");
        r7.put("java.lang.Character", "kotlin.Char");
        r7.put("java.lang.Byte", "kotlin.Byte");
        r7.put("java.lang.Short", "kotlin.Short");
        r7.put("java.lang.Integer", "kotlin.Int");
        r7.put("java.lang.Float", "kotlin.Float");
        r7.put("java.lang.Long", "kotlin.Long");
        r7.put("java.lang.Double", "kotlin.Double");
        f18435j = r7;
        HashMap<String, String> r8 = new HashMap();
        r8.put("java.lang.Object", "kotlin.Any");
        r8.put("java.lang.String", "kotlin.String");
        r8.put("java.lang.CharSequence", "kotlin.CharSequence");
        r8.put("java.lang.Throwable", "kotlin.Throwable");
        r8.put("java.lang.Cloneable", "kotlin.Cloneable");
        r8.put("java.lang.Number", "kotlin.Number");
        r8.put("java.lang.Comparable", "kotlin.Comparable");
        r8.put("java.lang.Enum", "kotlin.Enum");
        r8.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        r8.put("java.lang.Iterable", "kotlin.collections.Iterable");
        r8.put("java.util.Iterator", "kotlin.collections.Iterator");
        r8.put("java.util.Collection", "kotlin.collections.Collection");
        r8.put("java.util.List", "kotlin.collections.List");
        r8.put("java.util.Set", "kotlin.collections.Set");
        r8.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        r8.put("java.util.Map", "kotlin.collections.Map");
        r8.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        r8.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        r8.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        r8.putAll(r4);
        r8.putAll(r7);
        Collection<String> r9 = r4.values();
        o.e(r9, "primitiveFqNames.values");
        Iterator<T> r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        String r11 = (String) r10.next();
        StringBuilder r12 = new StringBuilder();
        r12.append("kotlin.jvm.internal.");
        o.e(r11, "kotlinName");
        r12.append(kotlin.u0.k.A0(r11, '.', null, 2, null));
        r12.append("CompanionObject");
        kotlin.u r13 = kotlin.a0.a(r12.toString(), r11 + ".Companion");
        r8.put(r13.c(), r13.d());
        goto L12
    L14:
        Iterator<Map.Entry<Class<? extends kotlin.c<?>>, Integer>> r14 = f18433h.entrySet().iterator();
    L16:
        if (r14.hasNext() == false) goto L18;
        Map.Entry<Class<? extends kotlin.c<?>>, Integer> r15 = r14.next();
        Class<? extends kotlin.c<?>> r16 = r15.getKey();
        int r17 = r15.getValue().intValue();
        r8.put(r16.getName(), "kotlin.Function" + r17);
        goto L16
    L18:
        f18436k = r8;
        LinkedHashMap r18 = new LinkedHashMap(m0.d(r8.size()));
        Iterator r19 = r8.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L22;
        Map.Entry r20 = (Map.Entry) r19.next();
        r18.put(r20.getKey(), kotlin.u0.k.A0((String) r20.getValue(), '.', null, 2, null));
        goto L20
    L22:
        f18437l = r18;
    }

    public e(Class<?> r2) {
        o.f(r2, "jClass");
        this.f18438f = r2;
    }

    public static final /* synthetic */ HashMap f() {
        return f18436k;
    }

    public static final /* synthetic */ Map k() {
        return f18437l;
    }

    @Override // kotlin.s0.d
    public String a() {
        return f18432g.a(e());
    }

    @Override // kotlin.n0.d.d
    public Class<?> e() {
        return this.f18438f;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof e) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(kotlin.n0.a.c(this), kotlin.n0.a.c((kotlin.s0.d) r2)) == false) goto L7;
        return true;
    }

    @Override // kotlin.s0.d
    public String h() {
        return f18432g.b(e());
    }

    public int hashCode() {
        return kotlin.n0.a.c(this).hashCode();
    }

    public String toString() {
        return e().toString() + " (Kotlin reflection is not available)";
    }
}
