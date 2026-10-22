package kotlin.sequences;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SequencesKt___SequencesKt$filterIndexed$2 extends Lambda implements Function1<IndexedValue<Object>, Object> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        IndexedValue r2 = (IndexedValue) r1;
        Intrinsics.f(r2, "it");
        return r2.b;
    }
}
