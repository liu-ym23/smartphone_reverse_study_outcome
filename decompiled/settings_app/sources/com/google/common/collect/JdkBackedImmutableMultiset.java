package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class JdkBackedImmutableMultiset<E> extends ImmutableMultiset<E> {
    private final Map<E, Integer> delegateMap;

    @CheckForNull
    private transient ImmutableSet<E> elementSet;
    private final ImmutableList<Multiset.Entry<E>> entries;
    private final long size;

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    static <E> ImmutableMultiset<E> create(Collection<? extends Multiset.Entry<? extends E>> r8) {
        int r0 = 0;
        Multiset.Entry[] r9 = (Multiset.Entry[]) r8.toArray(new Multiset.Entry[0]);
        HashMap r1 = Maps.newHashMapWithExpectedSize(r9.length);
        long r2 = 0;
    L4:
        if (r0 >= r9.length) goto L10;
        Multiset.Entry r4 = r9[r0];
        int r5 = r4.getCount();
        r2 = r2 + ((long) r5);
        Object r6 = Preconditions.checkNotNull(r4.getElement());
        r1.put(r6, Integer.valueOf(r5));
        if ((r4 instanceof Multisets.ImmutableEntry) == true) goto L8;
        r9[r0] = Multisets.immutableEntry(r6, r5);
    L8:
        r0 = r0 + 1;
        goto L4
    L10:
        return new JdkBackedImmutableMultiset(r1, ImmutableList.asImmutableList(r9), r2);
    }

    private JdkBackedImmutableMultiset(Map<E, Integer> r1, ImmutableList<Multiset.Entry<E>> r2, long r3) {
        this.delegateMap = r1;
        this.entries = r2;
        this.size = r3;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object r2) {
        return this.delegateMap.getOrDefault(r2, 0).intValue();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> r0 = this.elementSet;
        if (r0 != null) goto L6;
        ImmutableMultiset.ElementSet r1 = new ImmutableMultiset.ElementSet(this.entries, this);
        this.elementSet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> getEntry(int r1) {
        return this.entries.get(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(this.size);
    }
}
