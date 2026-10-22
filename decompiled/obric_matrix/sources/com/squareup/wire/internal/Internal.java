package com.squareup.wire.internal;

import com.squareup.wire.ProtoAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"com/squareup/wire/internal/Internal__InternalJvmKt", "com/squareup/wire/internal/Internal__InternalKt"}, d2 = {}, k = 4, mv = {1, 1, 15})
public final class Internal {
    /* JADX INFO: renamed from: -redactElements, reason: not valid java name */
    public static final <T> List<T> m68redactElements(List<? extends T> r0, ProtoAdapter<T> r1) {
        return Internal__InternalKt.m70redactElements(r0, r1);
    }

    /* JADX INFO: renamed from: -redactElements, reason: not valid java name */
    public static final <K, V> Map<K, V> m69redactElements(Map<K, ? extends V> r0, ProtoAdapter<V> r1) {
        return Internal__InternalKt.m71redactElements(r0, r1);
    }

    public static final void checkElementsNotNull(List<?> r0) {
        Internal__InternalKt.checkElementsNotNull(r0);
    }

    public static final void checkElementsNotNull(Map<?, ?> r0) {
        Internal__InternalKt.checkElementsNotNull(r0);
    }

    public static final <T> List<T> copyOf(String r0, List<? extends T> r1) {
        return Internal__InternalKt.copyOf(r0, r1);
    }

    public static final <T> List<T> copyOf(List<? extends T> r0) {
        return Internal__InternalKt.copyOf(r0);
    }

    public static final <K, V> Map<K, V> copyOf(String r0, Map<K, ? extends V> r1) {
        return Internal__InternalKt.copyOf(r0, r1);
    }

    public static final <K, V> Map<K, V> copyOf(Map<K, ? extends V> r0) {
        return Internal__InternalKt.copyOf(r0);
    }

    public static final int countNonNull(Object r0, Object r1) {
        return Internal__InternalKt.countNonNull(r0, r1);
    }

    public static final int countNonNull(Object r0, Object r1, Object r2) {
        return Internal__InternalKt.countNonNull(r0, r1, r2);
    }

    public static final int countNonNull(Object r0, Object r1, Object r2, Object r3, Object... r4) {
        return Internal__InternalKt.countNonNull(r0, r1, r2, r3, r4);
    }

    public static final boolean equals(Object r0, Object r1) {
        return Internal__InternalKt.equals(r0, r1);
    }

    public static final <T> List<T> immutableCopyOf(String r0, List<? extends T> r1) {
        return Internal__InternalKt.immutableCopyOf(r0, r1);
    }

    public static final <K, V> Map<K, V> immutableCopyOf(String r0, Map<K, ? extends V> r1) {
        return Internal__InternalKt.immutableCopyOf(r0, r1);
    }

    public static final IllegalStateException missingRequiredFields(Object... r0) {
        return Internal__InternalKt.missingRequiredFields(r0);
    }

    public static final <T> List<T> newMutableList() {
        return Internal__InternalKt.newMutableList();
    }

    public static final <K, V> Map<K, V> newMutableMap() {
        return Internal__InternalKt.newMutableMap();
    }

    public static final <T> void redactElements(List<T> r0, ProtoAdapter<T> r1) {
        Internal__InternalJvmKt.redactElements(r0, r1);
    }

    public static final <T> void redactElements(Map<?, T> r0, ProtoAdapter<T> r1) {
        Internal__InternalJvmKt.redactElements(r0, r1);
    }
}
