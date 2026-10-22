package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SegmentOrClosed<S extends Segment<S>> {
    public static final Segment a(Object r1) {
        if (r1 == ConcurrentLinkedListKt.f409a) goto L7;
        return (Segment) r1;
    L7:
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public final boolean equals(Object r1) {
        if ((r1 instanceof SegmentOrClosed) == false) goto L7;
        ((SegmentOrClosed) r1).getClass();
        if (Intrinsics.a(null, null) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "SegmentOrClosed(value=null)";
    }
}
