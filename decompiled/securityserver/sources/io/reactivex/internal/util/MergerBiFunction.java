package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    final Comparator<? super T> comparator;

    public MergerBiFunction(Comparator<? super T> r1) {
        this.comparator = r1;
    }

    @Override // io.reactivex.functions.BiFunction
    public /* bridge */ /* synthetic */ Object apply(Object r1, Object r2) {
        return apply((List) r1, (List) r2);
    }

    public List<T> apply(List<T> r6, List<T> r7) {
        int r1 = r7.size() + r6.size();
        if (r1 == 0) goto L5;
        ArrayList r0 = new ArrayList(r1);
        Iterator<T> r8 = r6.iterator();
        Iterator<T> r9 = r7.iterator();
        if (r8.hasNext() == false) goto L9;
        T r2 = r8.next();
    L11:
        if (r9.hasNext() == false) goto L13;
        T r3 = r9.next();
    L14:
        if (r2 == null) goto L25;
        if (r3 == null) goto L25;
        if (this.comparator.compare(r2, r3) < 0) goto L18;
        r0.add(r3);
        if (r9.hasNext() == false) goto L13;
        r3 = r9.next();
        goto L14
    L13:
        r3 = null;
        goto L14
    L18:
        r0.add(r2);
        if (r8.hasNext() == true) goto L20;
        r2 = null;
        goto L14
    L20:
        r2 = r8.next();
    L25:
        if (r2 == null) goto L30;
        r0.add(r2);
    L28:
        if (r8.hasNext() == false) goto L34;
        r0.add(r8.next());
    L34:
        return r0;
    L30:
        r0.add(r3);
    L32:
        if (r9.hasNext() == false) goto L34;
        r0.add(r9.next());
        goto L32
    L35:
        r3 = null;
        goto L14
    L9:
        r2 = null;
        goto L11
    L5:
        return new ArrayList();
    }
}
