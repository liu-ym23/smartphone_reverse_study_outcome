package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionSystemProperties;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SequencesKt___SequencesKt$minus$4 implements Sequence<Object> {
    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        Intrinsics.f(null, "<this>");
        if (CollectionSystemProperties.f331a == true) goto L6;
        SequencesKt.d(null);
        throw null;
    L6:
        Intrinsics.f(null, "<this>");
        SequencesKt___SequencesKt.a(null, new HashSet());
        throw null;
    }
}
