package com.google.common.collect;

import com.google.common.base.Strings;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class Platform {
    private static final Logger logger = null;

    static int reduceExponentIfGwt(int r0) {
        return r0;
    }

    static int reduceIterationsIfGwt(int r0) {
        return r0;
    }

    static {
        logger = Logger.getLogger(Platform.class.getName());
    }

    static <K, V> Map<K, V> newHashMapWithExpectedSize(int r0) {
        return Maps.newHashMapWithExpectedSize(r0);
    }

    static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int r0) {
        return Maps.newLinkedHashMapWithExpectedSize(r0);
    }

    static <E> Set<E> newHashSetWithExpectedSize(int r0) {
        return Sets.newHashSetWithExpectedSize(r0);
    }

    static <E> Set<E> newConcurrentHashSet() {
        return ConcurrentHashMap.newKeySet();
    }

    static <E> Set<E> newLinkedHashSetWithExpectedSize(int r0) {
        return Sets.newLinkedHashSetWithExpectedSize(r0);
    }

    static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return Maps.newLinkedHashMap();
    }

    static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return Sets.newLinkedHashSet();
    }

    static <T> T[] newArray(T[] r0, int r1) {
        return (T[]) ((Object[]) Array.newInstance(r0.getClass().getComponentType(), r1));
    }

    static <T> T[] copy(Object[] r0, int r1, int r2, T[] r3) {
        return (T[]) Arrays.copyOfRange(r0, r1, r2, r3.getClass());
    }

    static MapMaker tryWeakKeys(MapMaker r0) {
        return r0.weakKeys();
    }

    static void checkGwtRpcEnabled() {
        if (Boolean.parseBoolean(System.getProperty("guava.gwt.emergency_reenable_rpc", "false")) == false) goto L7;
        logger.log(Level.WARNING, "Later in 2020, we will remove GWT-RPC support for Guava types. You are seeing this warning because you are sending a Guava type over GWT-RPC, which will break. You can identify which type by looking at the class name in the attached stack trace.", new Throwable());
        return;
    L7:
        throw new UnsupportedOperationException(Strings.lenientFormat("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", new Object[]{"guava.gwt.emergency_reenable_rpc", "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ"}));
    }

    private Platform() {
    }
}
