package com.obric.search.sdk.embedding.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PCMemoryModelInnerProductFilter.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\u0018\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/search/sdk/embedding/search/PCMemoryModelInnerProductFilter;", "Lcom/obric/search/sdk/embedding/search/IEmbeddingSearchFilter;", "()V", "filter", "", "Lkotlin/Pair;", "", "", "list", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PCMemoryModelInnerProductFilter implements IEmbeddingSearchFilter {
    public PCMemoryModelInnerProductFilter() {
    }

    @Override // com.obric.search.sdk.embedding.search.IEmbeddingSearchFilter
    public List<Pair<Long, Double>> filter(List<Pair<Long, Double>> r9) {
        Intrinsics.checkNotNullParameter(r9, "list");
        if (r9.isEmpty() == false) goto L5;
        return r9;
    L5:
        double r0 = ((Number) ((Pair) CollectionsKt.first(r9)).getSecond()).doubleValue();
        if (r0 < 0.75d) goto L19;
        ArrayList r8 = new ArrayList();
        Iterator<T> r10 = r9.iterator();
    L9:
        if (r10.hasNext() == false) goto L17;
        Object r1 = r10.next();
        if (((Number) ((Pair) r1).getSecond()).doubleValue() < 0.75d) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
        r8.add(r1);
        goto L9
    L13:
        r2 = false;
        goto L14
    L17:
        return r8;
    L19:
        if (r0 <= 0.6d) goto L31;
        double r3 = r0 - 0.1d;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r9.iterator();
    L22:
        if (r12.hasNext() == false) goto L30;
        Object r4 = r12.next();
        if (((Number) ((Pair) r4).getSecond()).doubleValue() < r3) goto L26;
        boolean r5 = true;
    L27:
        if (r5 == false) goto L22;
        r11.add(r4);
        goto L22
    L26:
        r5 = false;
        goto L27
    L30:
        return r11;
    L31:
        double r6 = RangesKt.coerceAtLeast(r0 - 0.05d, 0.4d);
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r9.iterator();
    L33:
        if (r14.hasNext() == false) goto L41;
        Object r7 = r14.next();
        if (((Number) ((Pair) r7).getSecond()).doubleValue() < r6) goto L37;
        boolean r15 = true;
    L38:
        if (r15 == false) goto L33;
        r13.add(r7);
        goto L33
    L37:
        r15 = false;
        goto L38
    L41:
        return r13;
    }
}
