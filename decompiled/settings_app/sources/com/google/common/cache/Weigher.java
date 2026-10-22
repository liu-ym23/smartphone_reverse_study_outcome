package com.google.common.cache;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
@FunctionalInterface
public interface Weigher<K, V> {
    int weigh(K r1, V r2);
}
