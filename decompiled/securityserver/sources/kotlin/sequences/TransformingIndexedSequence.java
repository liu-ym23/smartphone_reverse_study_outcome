package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TransformingIndexedSequence<T, R> implements Sequence<R> {

    /* JADX INFO: renamed from: kotlin.sequences.TransformingIndexedSequence$iterator$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {
        public int b;
        public final /* synthetic */ TransformingIndexedSequence c;

        public AnonymousClass1(TransformingIndexedSequence r1) {
            this.c = r1;
            r1.getClass();
            throw null;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            this.c.getClass();
            int r0 = this.b;
            this.b = r0 + 1;
            if (r0 >= 0) goto L6;
            CollectionsKt.p();
            throw null;
        L6:
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        new AnonymousClass1(this);
        throw null;
    }
}
