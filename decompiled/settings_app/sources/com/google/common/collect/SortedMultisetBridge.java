package com.google.common.collect;

import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
interface SortedMultisetBridge<E> extends Multiset<E> {
    @Override // com.google.common.collect.Multiset
    SortedSet<E> elementSet();

    @Override // com.google.common.collect.Multiset
    /* bridge */ /* synthetic */ default Set elementSet() {
        return elementSet();
    }
}
