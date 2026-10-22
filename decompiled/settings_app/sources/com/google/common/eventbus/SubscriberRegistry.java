package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.TypeToken;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class SubscriberRegistry {
    private static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> flattenHierarchyCache = null;
    private static final LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache = null;
    private final EventBus bus;
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Subscriber>> subscribers;

    private static final class MethodIdentifier {
        private final String name;
        private final List<Class<?>> parameterTypes;

        MethodIdentifier(Method r2) {
            this.name = r2.getName();
            this.parameterTypes = Arrays.asList(r2.getParameterTypes());
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{this.name, this.parameterTypes});
        }

        public boolean equals(@CheckForNull Object r4) {
            if ((r4 instanceof MethodIdentifier) == false) goto L10;
            MethodIdentifier r5 = (MethodIdentifier) r4;
            if (this.name.equals(r5.name) == true) goto L7;
            return false;
        L7:
            if (this.parameterTypes.equals(r5.parameterTypes) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }
    }

    static /* synthetic */ ImmutableList access$000(Class r0) {
        return getAnnotatedMethodsNotCached(r0);
    }

    SubscriberRegistry(EventBus r2) {
        this.subscribers = Maps.newConcurrentMap();
        this.bus = (EventBus) Preconditions.checkNotNull(r2);
    }

    void register(Object r5) {
        Iterator<Map.Entry<Class<?>, Collection<Subscriber>>> r6 = findAllSubscribers(r5).asMap().entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Map.Entry<Class<?>, Collection<Subscriber>> r0 = r6.next();
        Class<?> r1 = r0.getKey();
        Collection<Subscriber> r2 = r0.getValue();
        CopyOnWriteArraySet<Subscriber> r3 = this.subscribers.get(r1);
        if (r3 != null) goto L8;
        CopyOnWriteArraySet<Subscriber> r4 = new CopyOnWriteArraySet();
        r3 = (CopyOnWriteArraySet) MoreObjects.firstNonNull(this.subscribers.putIfAbsent(r1, r4), r4);
    L8:
        r3.addAll(r2);
        goto L4
    }

    void unregister(Object r5) {
        Iterator<Map.Entry<Class<?>, Collection<Subscriber>>> r0 = findAllSubscribers(r5).asMap().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Map.Entry<Class<?>, Collection<Subscriber>> r1 = r0.next();
        Class<?> r2 = r1.getKey();
        Collection<Subscriber> r3 = r1.getValue();
        CopyOnWriteArraySet<Subscriber> r4 = this.subscribers.get(r2);
        if (r4 == null) goto L10;
        if (r4.removeAll(r3) == true) goto L4;
    L10:
        String r6 = String.valueOf(r5);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(r6).length() + 65).append("missing event subscriber for an annotated method. Is ").append(r6).append(" registered?").toString());
    }

    Set<Subscriber> getSubscribersForTesting(Class<?> r1) {
        return (Set) MoreObjects.firstNonNull(this.subscribers.get(r1), ImmutableSet.of());
    }

    Iterator<Subscriber> getSubscribers(Object r4) {
        ImmutableSet<Class<?>> r5 = flattenHierarchy(r4.getClass());
        ArrayList r0 = Lists.newArrayListWithCapacity(r5.size());
        UnmodifiableIterator<Class<?>> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L9;
        Class<?> r1 = r6.next();
        CopyOnWriteArraySet<Subscriber> r2 = this.subscribers.get(r1);
        if (r2 == null) goto L4;
        r0.add(r2.iterator());
        goto L4
    L9:
        return Iterators.concat(r0.iterator());
    }

    static {
        subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new AnonymousClass1());
        flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new AnonymousClass2());
    }

    private Multimap<Class<?>, Subscriber> findAllSubscribers(Object r6) {
        HashMultimap r0 = HashMultimap.create();
        UnmodifiableIterator<Method> r1 = getAnnotatedMethods(r6.getClass()).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Method r2 = r1.next();
        r0.put(r2.getParameterTypes()[0], Subscriber.create(this.bus, r6, r2));
        goto L4
    L6:
        return r0;
    }

    private static ImmutableList<Method> getAnnotatedMethods(Class<?> r1) {
        return subscriberMethodsCache.getUnchecked(r1);
    L4:
        e = move-exception;
        Throwables.throwIfUnchecked(e.getCause());
        throw e;
    }

    private static ImmutableList<Method> getAnnotatedMethodsNotCached(Class<?> r11) {
        Set r12 = TypeToken.of(r11).getTypes().rawTypes();
        HashMap r0 = Maps.newHashMap();
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L20;
        Method[] r1 = ((Class) r13.next()).getDeclaredMethods();
        int r2 = r1.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L4;
        Method r5 = r1[r4];
        if (r5.isAnnotationPresent(Subscribe.class) == true) goto L10;
    L18:
        r4 = r4 + 1;
        goto L6
    L10:
        if (r5.isSynthetic() == true) goto L18;
        Class<?>[] r6 = r5.getParameterTypes();
        if (r6.length != 1) goto L14;
        boolean r7 = true;
    L15:
        Preconditions.checkArgument(r7, "Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.", r5, r6.length);
        Preconditions.checkArgument(!r6[0].isPrimitive(), "@Subscribe method %s's parameter is %s. Subscriber methods cannot accept primitives. Consider changing the parameter to %s.", r5, r6[0].getName(), Primitives.wrap(r6[0]).getSimpleName());
        MethodIdentifier r8 = new MethodIdentifier(r5);
        if (r0.containsKey(r8) == true) goto L18;
        r0.put(r8, r5);
        goto L18
    L14:
        r7 = false;
        goto L15
    L20:
        return ImmutableList.copyOf(r0.values());
    }

    static ImmutableSet<Class<?>> flattenHierarchy(Class<?> r1) {
        return flattenHierarchyCache.getUnchecked(r1);
    L4:
        e = move-exception;
        throw Throwables.propagate(e.getCause());
    }
}
