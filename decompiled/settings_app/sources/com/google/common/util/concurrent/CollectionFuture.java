package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    @CheckForNull
    private List<Present<V>> values;

    static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
        @Override // com.google.common.util.concurrent.CollectionFuture
        public /* bridge */ /* synthetic */ Object combine(List r1) {
            return combine(r1);
        }

        ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> r1, boolean r2) {
            super(r1, r2);
            init();
        }

        @Override // com.google.common.util.concurrent.CollectionFuture
        public List<V> combine(List<Present<V>> r2) {
            ArrayList r1 = Lists.newArrayListWithCapacity(r2.size());
            Iterator<Present<V>> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L11;
            Present<V> r0 = r3.next();
            if (r0 == null) goto L8;
            V r4 = r0.value;
        L9:
            r1.add(r4);
            goto L4
        L8:
            r4 = null;
            goto L9
        L11:
            return Collections.unmodifiableList(r1);
        }
    }

    private static final class Present<V> {
        V value;

        Present(V r1) {
            this.value = r1;
        }
    }

    abstract C combine(List<Present<V>> r1);

    CollectionFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> r3, boolean r4) {
        super(r3, r4, true);
        if (r3.isEmpty() == false) goto L5;
        List<Present<V>> r5 = Collections.emptyList();
    L6:
        int r0 = 0;
    L8:
        if (r0 >= r3.size()) goto L10;
        r5.add(null);
        r0 = r0 + 1;
        goto L8
    L10:
        this.values = r5;
        return;
    L5:
        r5 = Lists.newArrayListWithCapacity(r3.size());
        goto L6
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    final void collectOneValue(int r2, @ParametricNullness V r3) {
        List<Present<V>> r1 = this.values;
        if (r1 == null) goto L6;
        r1.set(r2, new Present(r3));
        return;
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    final void handleAllCompleted() {
        List<Present<V>> r0 = this.values;
        if (r0 == null) goto L6;
        set(combine(r0));
        return;
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    void releaseResources(AggregateFuture.ReleaseResourcesReason r1) {
        super.releaseResources(r1);
        this.values = null;
    }
}
