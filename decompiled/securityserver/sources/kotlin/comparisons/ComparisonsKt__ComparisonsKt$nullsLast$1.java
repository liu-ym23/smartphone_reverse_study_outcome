package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ComparisonsKt__ComparisonsKt$nullsLast$1<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object r1, Object r2) {
        if (r1 != r2) goto L4;
        return 0;
    L4:
        if (r1 != null) goto L6;
        return 1;
    L6:
        if (r2 != null) goto L10;
        return -1;
    L10:
        throw null;
    }
}
