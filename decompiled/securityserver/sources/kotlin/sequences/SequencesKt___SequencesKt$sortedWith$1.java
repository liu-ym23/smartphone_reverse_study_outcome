package kotlin.sequences;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SequencesKt___SequencesKt$sortedWith$1 implements Sequence<Object> {
    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        List r0 = SequencesKt___SequencesKt.b(null);
        Intrinsics.f(r0, "<this>");
        Intrinsics.f(null, "comparator");
        if (r0.size() <= 1) goto L6;
        Collections.sort(r0, null);
    L6:
        return r0.iterator();
    }
}
