package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@FunctionalInterface
@ElementTypesAreNonnullByDefault
public interface Predicate<T> extends java.util.function.Predicate<T> {
    boolean apply(@ParametricNullness T r1);

    boolean equals(@CheckForNull Object r1);

    @Override // java.util.function.Predicate
    default boolean test(@ParametricNullness T r1) {
        return apply(r1);
    }
}
