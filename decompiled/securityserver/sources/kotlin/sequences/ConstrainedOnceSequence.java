package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ConstrainedOnceSequence<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f346a;

    public ConstrainedOnceSequence(SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 r2) {
        this.f346a = new AtomicReference(r2);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        Sequence r1 = (Sequence) this.f346a.getAndSet(null);
        if (r1 == null) goto L7;
        return r1.iterator();
    L7:
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
