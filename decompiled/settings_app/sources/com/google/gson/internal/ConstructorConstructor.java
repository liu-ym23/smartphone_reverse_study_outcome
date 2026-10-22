package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* JADX INFO: loaded from: classes4.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> r1, boolean r2, List<ReflectionAccessFilter> r3) {
        this.instanceCreators = r1;
        this.useJdkUnsafe = r2;
        this.reflectionFilters = r3;
    }

    static String checkInstantiable(Class<?> r2) {
        int r0 = r2.getModifiers();
        if (Modifier.isInterface(r0) == false) goto L7;
        return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: " + r2.getName();
    L7:
        if (Modifier.isAbstract(r0) == true) goto L9;
        return null;
    L9:
        return "Abstract classes can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Class name: " + r2.getName();
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> r4) {
        final Type r0 = r4.getType();
        Class<? super T> r5 = r4.getRawType();
        final InstanceCreator<?> r1 = this.instanceCreators.get(r0);
        if (r1 != null) goto L5;
        final InstanceCreator<?> r2 = this.instanceCreators.get(r5);
        if (r2 != null) goto L9;
        ObjectConstructor<T> r3 = newSpecialCollectionConstructor(r0, r5);
        if (r3 == null) goto L13;
        return r3;
    L13:
        ReflectionAccessFilter.FilterResult r6 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r5);
        ObjectConstructor<T> r7 = newDefaultConstructor(r5, r6);
        if (r7 == null) goto L16;
        return r7;
    L16:
        ObjectConstructor<T> r8 = newDefaultImplementationConstructor(r0, r5);
        if (r8 == null) goto L19;
        return r8;
    L19:
        final String r9 = checkInstantiable(r5);
        if (r9 == null) goto L24;
        return new AnonymousClass3(this, r9);
    L24:
        if (r6 == ReflectionAccessFilter.FilterResult.ALLOW) goto L26;
        final String r10 = "Unable to create instance of " + r5 + "; ReflectionAccessFilter does not permit using reflection or Unsafe. Register an InstanceCreator or a TypeAdapter for this type or adjust the access filter to allow using reflection.";
        return new AnonymousClass4(this, r10);
    L26:
        return newUnsafeAllocator(r5);
    L9:
        return new AnonymousClass2(this, r2, r0);
    L5:
        return new AnonymousClass1(this, r1, r0);
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(final Type r1, Class<? super T> r2) {
        if (EnumSet.class.isAssignableFrom(r2) == false) goto L7;
        return new AnonymousClass5(r1);
    L7:
        if (r2 == EnumMap.class) goto L9;
        return null;
    L9:
        return new AnonymousClass6(r1);
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> r4, ReflectionAccessFilter.FilterResult r5) {
        if (Modifier.isAbstract(r4.getModifiers()) == false) goto L5;
        return null;
    L5:
        boolean r0 = false;
        final Constructor<? super T> r2 = r4.getDeclaredConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L27
        if (r5 != ReflectionAccessFilter.FilterResult.ALLOW) goto L10;
    L15:
        r0 = true;
    L16:
        if (r0 == true) goto L20;
        final String r6 = "Unable to invoke no-args constructor of " + r4 + "; constructor is not accessible and ReflectionAccessFilter does not permit making it accessible. Register an InstanceCreator or a TypeAdapter for this type, change the visibility of the constructor or adjust the access filter.";
        return new AnonymousClass7(r6);
    L20:
        if (r5 != ReflectionAccessFilter.FilterResult.ALLOW) goto L26;
        final String r7 = ReflectionHelper.tryMakeAccessible(r2);
        if (r7 == null) goto L26;
        return new AnonymousClass8(r7);
    L26:
        return new AnonymousClass9(r2);
    L10:
        if (ReflectionAccessFilterHelper.canAccess(r2, null) == false) goto L16;
        if (r5 != ReflectionAccessFilter.FilterResult.BLOCK_ALL) goto L15;
        if (Modifier.isPublic(r2.getModifiers()) == false) goto L16;
    L27:
        return null;
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type r1, Class<? super T> r2) {
        if (Collection.class.isAssignableFrom(r2) == false) goto L19;
        if (SortedSet.class.isAssignableFrom(r2) == false) goto L9;
        return new AnonymousClass10();
    L9:
        if (Set.class.isAssignableFrom(r2) == false) goto L13;
        return new AnonymousClass11();
    L13:
        if (Queue.class.isAssignableFrom(r2) == false) goto L17;
        return new AnonymousClass12();
    L17:
        return new AnonymousClass13();
    L19:
        if (Map.class.isAssignableFrom(r2) == true) goto L21;
        return null;
    L21:
        if (ConcurrentNavigableMap.class.isAssignableFrom(r2) == false) goto L25;
        return new AnonymousClass14();
    L25:
        if (ConcurrentMap.class.isAssignableFrom(r2) == false) goto L29;
        return new AnonymousClass15();
    L29:
        if (SortedMap.class.isAssignableFrom(r2) == false) goto L33;
        return new AnonymousClass16();
    L33:
        if ((r1 instanceof ParameterizedType) == false) goto L39;
        if (String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) r1).getActualTypeArguments()[0]).getRawType()) == true) goto L39;
        return new AnonymousClass17();
    L39:
        return new AnonymousClass18();
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Class<? super T> r3) {
        if (this.useJdkUnsafe == true) goto L5;
        final String r4 = "Unable to create instance of " + r3 + "; usage of JDK Unsafe is disabled. Registering an InstanceCreator or a TypeAdapter for this type, adding a no-args constructor, or enabling usage of JDK Unsafe may fix this problem.";
        return new AnonymousClass20(this, r4);
    L5:
        return new AnonymousClass19(this, r3);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
