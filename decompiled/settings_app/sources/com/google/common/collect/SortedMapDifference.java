package com.google.common.collect;

import java.util.Map;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {
    @Override // com.google.common.collect.MapDifference
    SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering();

    @Override // com.google.common.collect.MapDifference
    SortedMap<K, V> entriesInCommon();

    @Override // com.google.common.collect.MapDifference
    SortedMap<K, V> entriesOnlyOnLeft();

    @Override // com.google.common.collect.MapDifference
    SortedMap<K, V> entriesOnlyOnRight();

    @Override // com.google.common.collect.MapDifference
    /* bridge */ /* synthetic */ default Map entriesDiffering() {
        return entriesDiffering();
    }

    @Override // com.google.common.collect.MapDifference
    /* bridge */ /* synthetic */ default Map entriesInCommon() {
        return entriesInCommon();
    }

    @Override // com.google.common.collect.MapDifference
    /* bridge */ /* synthetic */ default Map entriesOnlyOnLeft() {
        return entriesOnlyOnLeft();
    }

    @Override // com.google.common.collect.MapDifference
    /* bridge */ /* synthetic */ default Map entriesOnlyOnRight() {
        return entriesOnlyOnRight();
    }
}
