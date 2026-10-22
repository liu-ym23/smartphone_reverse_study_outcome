package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1 implements Sequence<Object> {
    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        Intrinsics.f(null, "block");
        SequenceBuilderIterator r0 = new SequenceBuilderIterator();
        r0.f = IntrinsicsKt.a(r0, r0, null);
        throw null;
    }
}
