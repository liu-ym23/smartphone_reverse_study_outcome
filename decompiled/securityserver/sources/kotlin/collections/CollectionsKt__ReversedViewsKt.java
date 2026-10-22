package kotlin.collections;

import a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class CollectionsKt__ReversedViewsKt extends CollectionsKt__MutableCollectionsKt {
    public static final void a(List r5, int r6) {
        if (new IntRange(0, CollectionsKt.f(r5), 1).b(r6) == false) goto L6;
        CollectionsKt.f(r5);
        return;
    L6:
        StringBuilder r7 = a.p(r6, "Element index ", " must be in range [");
        r7.append(new IntRange(0, CollectionsKt.f(r5), 1));
        r7.append("].");
        throw new IndexOutOfBoundsException(r7.toString());
    }
}
