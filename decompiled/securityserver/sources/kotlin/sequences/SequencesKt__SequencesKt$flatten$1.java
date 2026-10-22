package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SequencesKt__SequencesKt$flatten$1 extends Lambda implements Function1<Sequence<Object>, Iterator<Object>> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r1) {
        Sequence r2 = (Sequence) r1;
        Intrinsics.f(r2, "it");
        return r2.iterator();
    }
}
