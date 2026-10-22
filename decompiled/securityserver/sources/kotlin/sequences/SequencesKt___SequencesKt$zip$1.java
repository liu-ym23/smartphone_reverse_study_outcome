package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SequencesKt___SequencesKt$zip$1 extends Lambda implements Function2<Object, Object, Pair<Object, Object>> {
    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo7invoke(Object r1, Object r2) {
        return new Pair(r1, r2);
    }
}
