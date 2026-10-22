package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* JADX INFO: loaded from: classes.dex */
public final class ConstructorConstructor {
    private final ReflectionAccessor accessor;
    private final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> r2) {
        this.accessor = ReflectionAccessor.getInstance();
        this.instanceCreators = r2;
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> r3) {
        final Constructor<? super T> r4 = r3.getDeclaredConstructor(null);     // Catch: NoSuchMethodException -> L8
        if (r4.isAccessible() == true) goto L6;
        this.accessor.makeAccessible(r4);     // Catch: NoSuchMethodException -> L8
    L6:
        return new AnonymousClass3(this, r4);
    L8:
        return null;
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(final Type r2, Class<? super T> r3) {
        if (Collection.class.isAssignableFrom(r3) == false) goto L23;
        if (SortedSet.class.isAssignableFrom(r3) == false) goto L9;
        return new AnonymousClass4(this);
    L9:
        if (EnumSet.class.isAssignableFrom(r3) == false) goto L13;
        return new AnonymousClass5(this, r2);
    L13:
        if (Set.class.isAssignableFrom(r3) == false) goto L17;
        return new AnonymousClass6(this);
    L17:
        if (Queue.class.isAssignableFrom(r3) == false) goto L21;
        return new AnonymousClass7(this);
    L21:
        return new AnonymousClass8(this);
    L23:
        if (Map.class.isAssignableFrom(r3) == true) goto L25;
        return null;
    L25:
        if (ConcurrentNavigableMap.class.isAssignableFrom(r3) == false) goto L29;
        return new AnonymousClass9(this);
    L29:
        if (ConcurrentMap.class.isAssignableFrom(r3) == false) goto L33;
        return new AnonymousClass10(this);
    L33:
        if (SortedMap.class.isAssignableFrom(r3) == false) goto L37;
        return new AnonymousClass11(this);
    L37:
        if ((r2 instanceof ParameterizedType) == false) goto L43;
        if (String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) r2).getActualTypeArguments()[0]).getRawType()) == true) goto L43;
        return new AnonymousClass12(this);
    L43:
        return new AnonymousClass13(this);
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(final Type r2, final Class<? super T> r3) {
        return new AnonymousClass14(this, r3, r2);
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> r3) {
        final Type r0 = r3.getType();
        Class<? super T> r4 = r3.getRawType();
        final InstanceCreator<?> r1 = this.instanceCreators.get(r0);
        if (r1 != null) goto L5;
        final InstanceCreator<?> r2 = this.instanceCreators.get(r4);
        if (r2 != null) goto L9;
        ObjectConstructor<T> r5 = newDefaultConstructor(r4);
        if (r5 == null) goto L13;
        return r5;
    L13:
        ObjectConstructor<T> r6 = newDefaultImplementationConstructor(r0, r4);
        if (r6 == null) goto L17;
        return r6;
    L17:
        return newUnsafeAllocator(r0, r4);
    L9:
        return new AnonymousClass2(this, r2, r0);
    L5:
        return new AnonymousClass1(this, r1, r0);
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
