package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SequencesKt___SequencesKt$filterNotNull$1 extends Lambda implements Function1<Object, Boolean> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        if (r1 != null) goto L4;
        boolean r0 = true;
    L6:
        return Boolean.valueOf(r0);
    L4:
        r0 = false;
        goto L6
    }
}
