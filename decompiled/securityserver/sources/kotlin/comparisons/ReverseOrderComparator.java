package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ReverseOrderComparator implements Comparator<Comparable<? super Object>> {
    public static final ReverseOrderComparator b = null;

    static {
        b = new ReverseOrderComparator();
    }

    @Override // java.util.Comparator
    public final int compare(Comparable<? super Object> r1, Comparable<? super Object> r2) {
        Comparable<? super Object> r3 = r1;
        Comparable<? super Object> r4 = r2;
        Intrinsics.f(r3, "a");
        Intrinsics.f(r4, "b");
        return r4.compareTo(r3);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return NaturalOrderComparator.b;
    }
}
