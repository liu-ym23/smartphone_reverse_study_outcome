package kotlin.sequences;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SequencesKt extends SequencesKt___SequencesKt {
    public static Sequence c(final Object r2, Function1 r3) {
        if (r2 != null) goto L5;
        return EmptySequence.f348a;
    L5:
        return new GeneratorSequence(new SequencesKt__SequencesKt$generateSequence$2(r2), r3);
    }

    public static List d(Sequence r1) {
        Intrinsics.f(r1, "<this>");
        return CollectionsKt.m(SequencesKt___SequencesKt.b(r1));
    }
}
