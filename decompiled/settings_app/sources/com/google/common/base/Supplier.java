package com.google.common.base;

/* JADX INFO: loaded from: classes3.dex */
@FunctionalInterface
@ElementTypesAreNonnullByDefault
public interface Supplier<T> extends java.util.function.Supplier<T> {
    @Override // java.util.function.Supplier
    @ParametricNullness
    T get();
}
