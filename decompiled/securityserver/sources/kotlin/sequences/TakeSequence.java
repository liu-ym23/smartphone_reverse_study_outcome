package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TakeSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* JADX INFO: renamed from: kotlin.sequences.TakeSequence$iterator$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {
        public int b;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.b > 0) goto L7;
            return false;
        L7:
            throw null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            int r0 = this.b;
            if (r0 == 0) goto L5;
            this.b = r0 - 1;
            throw null;
        L5:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence a(int r3) {
        if (r3 >= 0) goto L4;
        new SubSequence(null, r3, 0);
        throw null;
    L4:
        return EmptySequence.f348a;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        new AnonymousClass1().b = 0;
        throw null;
    }
}
