package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class Internal {
    public static int countNonNull(Object r2, Object r3) {
        int r0 = 1;
        if (r2 == null) goto L5;
        int r4 = 1;
    L6:
        if (r3 != null) goto L10;
        r0 = 0;
    L10:
        return r4 + r0;
    L5:
        r4 = 0;
        goto L6
    }

    public static int countNonNull(Object r2, Object r3, Object r4) {
        int r0 = 1;
        if (r2 == null) goto L5;
        int r5 = 1;
    L6:
        if (r3 == null) goto L8;
        int r6 = 1;
    L9:
        int r7 = r5 + r6;
        if (r4 != null) goto L14;
        r0 = 0;
    L14:
        return r7 + r0;
    L8:
        r6 = 0;
        goto L9
    L5:
        r5 = 0;
        goto L6
    }

    private Internal() {
    }

    public static <T> List<T> newMutableList() {
        return new MutableOnWriteList(Collections.emptyList());
    }

    public static <K, V> Map<K, V> newMutableMap() {
        return new LinkedHashMap();
    }

    public static <T> List<T> copyOf(String r1, List<T> r2) {
        if (r2 == null) goto L13;
        if (r2 == Collections.emptyList()) goto L11;
        if ((r2 instanceof ImmutableList) == true) goto L11;
        return new ArrayList(r2);
    L11:
        return new MutableOnWriteList(r2);
    L13:
        throw new NullPointerException(r1 + " == null");
    }

    public static <K, V> Map<K, V> copyOf(String r1, Map<K, V> r2) {
        if (r2 == null) goto L6;
        return new LinkedHashMap(r2);
    L6:
        throw new NullPointerException(r1 + " == null");
    }

    public static <T> List<T> immutableCopyOf(String r1, List<T> r2) {
        if (r2 == null) goto L18;
        if ((r2 instanceof MutableOnWriteList) == false) goto L7;
        r2 = ((MutableOnWriteList) r2).mutableList;
    L7:
        if (r2 != Collections.emptyList()) goto L9;
    L16:
        return r2;
    L9:
        if ((r2 instanceof ImmutableList) == true) goto L16;
        ImmutableList r0 = new ImmutableList(r2);
        if (r0.contains(null) == true) goto L15;
        return r0;
    L15:
        throw new IllegalArgumentException(r1 + ".contains(null)");
    L18:
        throw new NullPointerException(r1 + " == null");
    }

    public static <K, V> Map<K, V> immutableCopyOf(String r2, Map<K, V> r3) {
        if (r3 == null) goto L18;
        if (r3.isEmpty() == true) goto L6;
        LinkedHashMap r0 = new LinkedHashMap(r3);
        if (r0.containsKey(null) == true) goto L16;
        if (r0.containsValue(null) == true) goto L14;
        return Collections.unmodifiableMap(r0);
    L14:
        throw new IllegalArgumentException(r2 + ".containsValue(null)");
    L16:
        throw new IllegalArgumentException(r2 + ".containsKey(null)");
    L6:
        return Collections.emptyMap();
    L18:
        throw new NullPointerException(r2 + " == null");
    }

    public static <T> void redactElements(List<T> r3, ProtoAdapter<T> r4) {
        int r0 = r3.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3.set(r1, r4.redact(r3.get(r1)));
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void redactElements(Map<?, T> r2, ProtoAdapter<T> r3) {
        Iterator<Map.Entry<?, T>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r0 = r4.next();
        r0.setValue(r3.redact(r0.getValue()));
        goto L4
    }

    public static boolean equals(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static IllegalStateException missingRequiredFields(Object... r5) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r5.length;
        String r2 = "";
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L12;
        if (r5[r3] != null) goto L10;
        if (r0.length() <= 0) goto L9;
        r2 = "s";
    L9:
        r0.append("\n  ");
        r0.append(r5[r3 + 1]);
    L10:
        r3 = r3 + 2;
        goto L3
    L12:
        throw new IllegalStateException("Required field" + r2 + " not set:" + r0);
    }

    public static void checkElementsNotNull(List<?> r3) {
        if (r3 == null) goto L12;
        int r0 = r3.size();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L10;
        if (r3.get(r1) == null) goto L9;
        r1 = r1 + 1;
        goto L4
    L9:
        throw new NullPointerException("Element at index " + r1 + " is null");
    L10:
        return;
    L12:
        throw new NullPointerException("list == null");
    }

    public static void checkElementsNotNull(Map<?, ?> r3) {
        if (r3 == null) goto L17;
        Iterator<Map.Entry<?, ?>> r4 = r3.entrySet().iterator();
    L5:
        if (r4.hasNext() == false) goto L15;
        Map.Entry<?, ?> r0 = r4.next();
        if (r0.getKey() == null) goto L14;
        if (r0.getValue() != null) goto L5;
        throw new NullPointerException("Value for key " + r0.getKey() + " is null");
    L14:
        throw new NullPointerException("map.containsKey(null)");
    L15:
        return;
    L17:
        throw new NullPointerException("map == null");
    }

    public static int countNonNull(Object r1, Object r2, Object r3, Object r4, Object... r5) {
        int r0 = 0;
        if (r1 == null) goto L5;
        int r6 = 1;
    L6:
        if (r2 == null) goto L8;
        r6 = r6 + 1;
    L8:
        if (r3 == null) goto L10;
        r6 = r6 + 1;
    L10:
        if (r4 == null) goto L12;
        r6 = r6 + 1;
    L12:
        int r7 = r5.length;
    L13:
        if (r0 >= r7) goto L18;
        if (r5[r0] == null) goto L17;
        r6 = r6 + 1;
    L17:
        r0 = r0 + 1;
        goto L13
    L18:
        return r6;
    L5:
        r6 = 0;
        goto L6
    }
}
