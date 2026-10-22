package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TakeWhileSequence<T> implements Sequence<T> {

    /* JADX INFO: renamed from: kotlin.sequences.TakeWhileSequence$iterator$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {
        public int b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int r1 = this.b;
            if (r1 == (-1)) goto L10;
            if (r1 == 1) goto L11;
            return false;
        L11:
            return true;
        L10:
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int r0 = this.b;
            if (r0 == (-1)) goto L9;
            if (r0 == 0) goto L8;
            this.b = -1;
            return null;
        L8:
            throw new NoSuchElementException();
        L9:
            throw null;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        throw null;
    }
}
