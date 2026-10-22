package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SequencesKt___SequencesKt$requireNoNulls$1 extends Lambda implements Function1<Object, Object> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        throw new IllegalArgumentException("null element found in null.");
    }
}
