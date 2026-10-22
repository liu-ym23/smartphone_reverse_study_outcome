package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class Lifecycling {
    private static final int GENERATED_CALLBACK = 2;
    private static final int REFLECTIVE_CALLBACK = 1;
    private static Map<Class<?>, Integer> sCallbackCache;
    private static Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> sClassToAdapters;

    static {
        sCallbackCache = new HashMap();
        sClassToAdapters = new HashMap();
    }

    private Lifecycling() {
    }

    private static GeneratedAdapter createGeneratedAdapter(Constructor<? extends GeneratedAdapter> r2, Object r3) {
        return r2.newInstance(new Object[]{r3});
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

    @Nullable
    private static Constructor<? extends GeneratedAdapter> generatedConstructor(Class<?> r4) {
        Package r0 = r4.getPackage();     // Catch: NoSuchMethodException -> L18 ClassNotFoundException -> L21
        String r1 = r4.getCanonicalName();     // Catch: NoSuchMethodException -> L18 ClassNotFoundException -> L21
        if (r0 == null) goto L5;
        String r2 = r0.getName();     // Catch: NoSuchMethodException -> L18 ClassNotFoundException -> L21
    L7:
        if (r2.isEmpty() == true) goto L10;
        r1 = r1.substring(r2.length() + 1);     // Catch: NoSuchMethodException -> L18 ClassNotFoundException -> L21
    L10:
        String r3 = getAdapterName(r1);     // Catch: NoSuchMethodException -> L18 ClassNotFoundException -> L21
        if (r2.isEmpty() == true) goto L14;
        r3 = r2 + "." + r3;     // Catch: NoSuchMethodException -> L18 ClassNotFoundException -> L21
    L14:
        Constructor r5 = Class.forName(r3).getDeclaredConstructor(new Class[]{r4});     // Catch: NoSuchMethodException -> L18 ClassNotFoundException -> L21
        if (r5.isAccessible() == true) goto L17;
        r5.setAccessible(true);     // Catch: NoSuchMethodException -> L18 ClassNotFoundException -> L21
    L17:
        return r5;
    L5:
        r2 = "";
    L21:
        return null;
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String getAdapterName(String r3) {
        return r3.replace(".", "_") + "_LifecycleAdapter";
    }

    @NonNull
    @Deprecated
    static GenericLifecycleObserver getCallback(Object r1) {
        final LifecycleEventObserver r2 = lifecycleEventObserver(r1);
        return new AnonymousClass1(r2);
    }

    private static int getObserverConstructorType(Class<?> r3) {
        Integer r0 = sCallbackCache.get(r3);
        if (r0 != null) goto L5;
        int r1 = resolveObserverCallbackType(r3);
        sCallbackCache.put(r3, Integer.valueOf(r1));
        return r1;
    L5:
        return r0.intValue();
    }

    private static boolean isLifecycleParent(Class<?> r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (LifecycleObserver.class.isAssignableFrom(r1) == false) goto L6;
        return true;
    }

    @NonNull
    static LifecycleEventObserver lifecycleEventObserver(Object r4) {
        boolean r0 = r4 instanceof LifecycleEventObserver;
        boolean r1 = r4 instanceof FullLifecycleObserver;
        if (r0 == false) goto L7;
        if (r1 == false) goto L7;
        return new FullLifecycleObserverAdapter((FullLifecycleObserver) r4, (LifecycleEventObserver) r4);
    L7:
        if (r1 == true) goto L9;
        if (r0 == true) goto L12;
        Class<?> r2 = r4.getClass();
        if (getObserverConstructorType(r2) != 2) goto L26;
        List<Constructor<? extends GeneratedAdapter>> r3 = sClassToAdapters.get(r2);
        int r5 = 0;
        if (r3.size() == 1) goto L18;
        GeneratedAdapter[] r6 = new GeneratedAdapter[r3.size()];
    L21:
        if (r5 >= r3.size()) goto L24;
        r6[r5] = createGeneratedAdapter(r3.get(r5), r4);
        r5 = r5 + 1;
        goto L21
    L24:
        return new CompositeGeneratedAdaptersObserver(r6);
    L18:
        return new SingleGeneratedAdapterObserver(createGeneratedAdapter(r3.get(0), r4));
    L26:
        return new ReflectiveGenericLifecycleObserver(r4);
    L12:
        return (LifecycleEventObserver) r4;
    L9:
        return new FullLifecycleObserverAdapter((FullLifecycleObserver) r4, null);
    }

    private static int resolveObserverCallbackType(Class<?> r8) {
        if (r8.getCanonicalName() != null) goto L5;
        return 1;
    L5:
        Constructor<? extends GeneratedAdapter> r0 = generatedConstructor(r8);
        if (r0 == null) goto L10;
        sClassToAdapters.put(r8, Collections.singletonList(r0));
        return 2;
    L10:
        if (ClassesInfoCache.sInstance.hasLifecycleMethods(r8) == false) goto L12;
        return 1;
    L12:
        Class<? super Object> r1 = r8.getSuperclass();
        ArrayList r3 = null;
        if (isLifecycleParent(r1) == true) goto L15;
    L18:
        Class<?>[] r2 = r8.getInterfaces();
        int r4 = r2.length;
        int r5 = 0;
    L19:
        if (r5 >= r4) goto L30;
        Class<?> r6 = r2[r5];
        if (isLifecycleParent(r6) == false) goto L29;
        if (getObserverConstructorType(r6) == 1) goto L25;
        if (r3 != null) goto L28;
        r3 = new ArrayList();
    L28:
        r3.addAll(sClassToAdapters.get(r6));
        goto L29
    L25:
        return 1;
    L29:
        r5 = r5 + 1;
        goto L19
    L30:
        if (r3 == null) goto L33;
        sClassToAdapters.put(r8, r3);
        return 2;
    L33:
        return 1;
    L15:
        if (getObserverConstructorType(r1) != 1) goto L17;
        return 1;
    L17:
        r3 = new ArrayList(sClassToAdapters.get(r1));
        goto L18
    }
}
