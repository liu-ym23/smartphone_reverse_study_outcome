package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class NaturalOrderComparator implements Comparator<Comparable<? super Object>> {
    public static final NaturalOrderComparator b = null;

    static {
        b = new NaturalOrderComparator();
    }

    @Override // java.util.Comparator
    public final int compare(Comparable<? super Object> r1, Comparable<? super Object> r2) {
        Comparable<? super Object> r3 = r1;
        Comparable<? super Object> r4 = r2;
        Intrinsics.f(r3, "a");
        Intrinsics.f(r4, "b");
        return r3.compareTo(r4);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return ReverseOrderComparator.b;
    }
}
