package kotlin.io;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class LinesSequence implements Sequence<String> {

    /* JADX INFO: renamed from: kotlin.io.LinesSequence$iterator$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements Iterator<String>, KMappedMarker {
        public final /* synthetic */ LinesSequence b;

        public AnonymousClass1(LinesSequence r1) {
            this.b = r1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            this.b.getClass();
            throw null;
        }

        @Override // java.util.Iterator
        public final String next() {
            hasNext();
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }
}
