package io.reactivex.internal.util;

import io.reactivex.functions.Function;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class SorterFunction<T> implements Function<List<T>, List<T>> {
    final Comparator<? super T> comparator;

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
        return apply((List) r1);
    }

    public SorterFunction(Comparator<? super T> r1) {
        this.comparator = r1;
    }

    public List<T> apply(List<T> r1) throws Exception {
        Collections.sort(r1, this.comparator);
        return r1;
    }
}
