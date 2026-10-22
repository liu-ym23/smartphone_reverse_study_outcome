package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Lifecycling.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002J\u001e\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\f\u0018\u00010\u000b2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u0014\u0010\u0015\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0001H\u0007J\u0014\u0010\u001a\u001a\u00020\u00042\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\t\u001a \u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/lifecycle/Lifecycling;", "", "()V", "GENERATED_CALLBACK", "", "REFLECTIVE_CALLBACK", "callbackCache", "", "Ljava/lang/Class;", "classToAdapters", "", "Ljava/lang/reflect/Constructor;", "Landroidx/lifecycle/GeneratedAdapter;", "createGeneratedAdapter", "constructor", "object", "generatedConstructor", "klass", "getAdapterName", "", "className", "getObserverConstructorType", "isLifecycleParent", "", "lifecycleEventObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "resolveObserverCallbackType", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    public static final Lifecycling INSTANCE = null;
    private static final int REFLECTIVE_CALLBACK = 1;
    private static final Map<Class<?>, Integer> callbackCache = null;
    private static final Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> classToAdapters = null;

    private Lifecycling() {
    }

    static {
        INSTANCE = new Lifecycling();
        callbackCache = new HashMap();
        classToAdapters = new HashMap();
    }

    @JvmStatic
    public static final LifecycleEventObserver lifecycleEventObserver(Object r6) {
        Intrinsics.checkNotNullParameter(r6, "object");
        boolean r0 = r6 instanceof LifecycleEventObserver;
        boolean r1 = r6 instanceof DefaultLifecycleObserver;
        if (r0 == false) goto L7;
        if (r1 == false) goto L7;
        return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) r6, (LifecycleEventObserver) r6);
    L7:
        if (r1 == true) goto L9;
        if (r0 == true) goto L12;
        Class<?> r2 = r6.getClass();
        Lifecycling r3 = INSTANCE;
        if (r3.getObserverConstructorType(r2) != 2) goto L25;
        List<Constructor<? extends GeneratedAdapter>> r4 = classToAdapters.get(r2);
        Intrinsics.checkNotNull(r4);
        List<Constructor<? extends GeneratedAdapter>> r5 = r4;
        int r7 = 0;
        if (r5.size() == 1) goto L18;
        int r8 = r5.size();
        GeneratedAdapter[] r9 = new GeneratedAdapter[r8];
    L20:
        if (r7 >= r8) goto L23;
        r9[r7] = INSTANCE.createGeneratedAdapter(r5.get(r7), r6);
        r7 = r7 + 1;
        goto L20
    L23:
        return new CompositeGeneratedAdaptersObserver(r9);
    L18:
        return new SingleGeneratedAdapterObserver(r3.createGeneratedAdapter(r5.get(0), r6));
    L25:
        return new ReflectiveGenericLifecycleObserver(r6);
    L12:
        return (LifecycleEventObserver) r6;
    L9:
        return new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) r6, null);
    }

    private final GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> r2, Object r3) {
        GeneratedAdapter r1 = r2.newInstance(new Object[]{r3});     // Catch: InvocationTargetException -> L5 InstantiationException -> L8 IllegalAccessException -> L11
        Intrinsics.checkNotNullExpressionValue(r1, "{\n            constructo…tance(`object`)\n        }");     // Catch: InvocationTargetException -> L5 InstantiationException -> L8 IllegalAccessException -> L11
        return r1;
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private final Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> r5) {
        Package r4 = r5.getPackage();     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        String r0 = r5.getCanonicalName();     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        if (r4 == null) goto L5;
        String r6 = r4.getName();     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
    L6:
        Intrinsics.checkNotNullExpressionValue(r6, "fullPackage");     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        if (r6.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        Intrinsics.checkNotNullExpressionValue(r0, "name");     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        r0 = r0.substring(r6.length() + 1);     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        Intrinsics.checkNotNullExpressionValue(r0, "this as java.lang.String).substring(startIndex)");     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
    L13:
        Intrinsics.checkNotNullExpressionValue(r0, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        String r2 = getAdapterName(r0);     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        if (r6.length() != 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L20;
        r2 = r6 + '.' + r2;     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
    L20:
        Class<?> r7 = Class.forName(r2);     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        Constructor r8 = r7.getDeclaredConstructor(new Class[]{r5});     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
        if (r8.isAccessible() == true) goto L31;
        r8.setAccessible(true);     // Catch: NoSuchMethodException -> L24 ClassNotFoundException -> L27
    L32:
        return r8;
    L31:
        return r8;
    L16:
        r3 = false;
        goto L17
    L9:
        r1 = false;
        goto L10
    L5:
        r6 = "";
    L27:
        return null;
    L24:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private final int getObserverConstructorType(Class<?> r3) {
        Map<Class<?>, Integer> r0 = callbackCache;
        Integer r1 = r0.get(r3);
        if (r1 != null) goto L5;
        int r2 = resolveObserverCallbackType(r3);
        r0.put(r3, Integer.valueOf(r2));
        return r2;
    L5:
        return r1.intValue();
    }

    private final int resolveObserverCallbackType(Class<?> r9) {
        if (r9.getCanonicalName() != null) goto L5;
        return 1;
    L5:
        Constructor<? extends GeneratedAdapter> r0 = generatedConstructor(r9);
        if (r0 == null) goto L10;
        classToAdapters.put(r9, CollectionsKt.listOf(r0));
        return 2;
    L10:
        if (ClassesInfoCache.sInstance.hasLifecycleMethods(r9) == false) goto L12;
        return 1;
    L12:
        Class<? super Object> r1 = r9.getSuperclass();
        if (isLifecycleParent(r1) == false) goto L18;
        Intrinsics.checkNotNullExpressionValue(r1, "superclass");
        if (getObserverConstructorType(r1) != 1) goto L17;
        return 1;
    L17:
        List<Constructor<? extends GeneratedAdapter>> r2 = classToAdapters.get(r1);
        Intrinsics.checkNotNull(r2);
        ArrayList r3 = new ArrayList(r2);
    L19:
        Class<?>[] r4 = r9.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(r4, "klass.interfaces");
        int r5 = r4.length;
        int r6 = 0;
    L20:
        if (r6 >= r5) goto L31;
        Class<?> r7 = r4[r6];
        if (isLifecycleParent(r7) == false) goto L30;
        Intrinsics.checkNotNullExpressionValue(r7, "intrface");
        if (getObserverConstructorType(r7) == 1) goto L26;
        if (r3 != null) goto L29;
        r3 = new ArrayList();
    L29:
        List<Constructor<? extends GeneratedAdapter>> r8 = classToAdapters.get(r7);
        Intrinsics.checkNotNull(r8);
        r3.addAll(r8);
        goto L30
    L26:
        return 1;
    L30:
        r6 = r6 + 1;
        goto L20
    L31:
        if (r3 == null) goto L34;
        classToAdapters.put(r9, r3);
        return 2;
    L34:
        return 1;
    L18:
        r3 = null;
        goto L19
    }

    private final boolean isLifecycleParent(Class<?> r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (LifecycleObserver.class.isAssignableFrom(r1) == false) goto L6;
        return true;
    }

    @JvmStatic
    public static final String getAdapterName(String r7) {
        Intrinsics.checkNotNullParameter(r7, "className");
        return StringsKt.replace$default(r7, ".", "_", false, 4, null) + "_LifecycleAdapter";
    }
}
