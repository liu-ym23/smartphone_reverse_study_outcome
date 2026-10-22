package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SequencesKt___SequencesKt$minus$1 implements Sequence<Object> {
    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        Function1<Object, Boolean> r0 = new SequencesKt___SequencesKt$minus$1$iterator$1(r3);
        Intrinsics.f(null, "<this>");
        new FilteringSequence(null, true, r0);
        throw null;
    }
}
