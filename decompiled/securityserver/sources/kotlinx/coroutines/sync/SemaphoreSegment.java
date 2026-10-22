package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SemaphoreSegment extends Segment<SemaphoreSegment> {
    public final AtomicReferenceArray e;

    public SemaphoreSegment(long r1, SemaphoreSegment r3, int r4) {
        super(r1, r3, r4);
        this.e = new AtomicReferenceArray(SemaphoreKt.f);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final int f() {
        return SemaphoreKt.f;
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.c + ", hashCode=" + hashCode() + ']';
    }
}
