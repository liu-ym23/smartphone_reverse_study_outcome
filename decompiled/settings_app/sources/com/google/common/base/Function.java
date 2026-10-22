package com.google.common.base;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@FunctionalInterface
@ElementTypesAreNonnullByDefault
public interface Function<F, T> extends java.util.function.Function<F, T> {
    @Override // java.util.function.Function
    @ParametricNullness
    T apply(@ParametricNullness F r1);

    boolean equals(@CheckForNull Object r1);
}
