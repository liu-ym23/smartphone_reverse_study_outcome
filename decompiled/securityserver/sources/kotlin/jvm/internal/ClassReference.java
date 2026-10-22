package kotlin.jvm.internal;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public static final Map c = null;
    public final Class b;

    @Metadata
    public static final class Companion {
    }

    static {
        List r0 = CollectionsKt.k(new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList r1 = new ArrayList(CollectionsKt.e(r0, 10));
        Iterator r2 = r0.iterator();
        int r3 = 0;
    L4:
        if (r2.hasNext() == false) goto L10;
        Object r4 = r2.next();
        int r5 = r3 + 1;
        if (r3 < 0) goto L8;
        r1.add(new Pair((Class) r4, Integer.valueOf(r3)));
        r3 = r5;
        goto L4
    L8:
        CollectionsKt.p();
        throw null;
    L10:
        c = MapsKt.f(r1);
        HashMap r6 = new HashMap();
        r6.put("boolean", "kotlin.Boolean");
        r6.put("char", "kotlin.Char");
        r6.put("byte", "kotlin.Byte");
        r6.put("short", "kotlin.Short");
        r6.put("int", "kotlin.Int");
        r6.put("float", "kotlin.Float");
        r6.put(WsChannelMultiProcessSharedProvider.LONG_TYPE, "kotlin.Long");
        r6.put("double", "kotlin.Double");
        HashMap r7 = new HashMap();
        r7.put("java.lang.Boolean", "kotlin.Boolean");
        r7.put("java.lang.Character", "kotlin.Char");
        r7.put("java.lang.Byte", "kotlin.Byte");
        r7.put("java.lang.Short", "kotlin.Short");
        r7.put("java.lang.Integer", "kotlin.Int");
        r7.put("java.lang.Float", "kotlin.Float");
        r7.put("java.lang.Long", "kotlin.Long");
        r7.put("java.lang.Double", "kotlin.Double");
        HashMap r8 = new HashMap();
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
        r8.putAll(r6);
        r8.putAll(r7);
        Collection r9 = r6.values();
        Intrinsics.e(r9, "primitiveFqNames.values");
        Iterator r10 = r9.iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        String r11 = (String) r10.next();
        StringBuilder r12 = new StringBuilder("kotlin.jvm.internal.");
        Intrinsics.e(r11, "kotlinName");
        r12.append(StringsKt.H(r11));
        r12.append("CompanionObject");
        r8.put(r12.toString(), r11.concat(".Companion"));
        goto L12
    L14:
        Iterator r13 = c.entrySet().iterator();
    L16:
        if (r13.hasNext() == false) goto L18;
        Map.Entry r14 = (Map.Entry) r13.next();
        Class r15 = (Class) r14.getKey();
        int r16 = ((Number) r14.getValue()).intValue();
        r8.put(r15.getName(), "kotlin.Function" + r16);
        goto L16
    L18:
        LinkedHashMap r17 = new LinkedHashMap(MapsKt.c(r8.size()));
        Iterator r18 = r8.entrySet().iterator();
    L20:
        if (r18.hasNext() == false) goto L22;
        Map.Entry r19 = (Map.Entry) r18.next();
        r17.put(r19.getKey(), StringsKt.H((String) r19.getValue()));
        goto L20
    }

    public ClassReference(Class r2) {
        Intrinsics.f(r2, "jClass");
        this.b = r2;
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    public final Class a() {
        return this.b;
    }

    public final boolean equals(Object r2) {
        if ((r2 instanceof ClassReference) == true) goto L5;
    L7:
        return false;
    L5:
        if (JvmClassMappingKt.a(this).equals(JvmClassMappingKt.a((KClass) r2)) == false) goto L7;
        return true;
    }

    public final int hashCode() {
        return JvmClassMappingKt.a(this).hashCode();
    }

    public final String toString() {
        return this.b.toString() + " (Kotlin reflection is not available)";
    }
}
