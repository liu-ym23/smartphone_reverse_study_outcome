package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f347a;
    public final int b;

    /* JADX INFO: renamed from: kotlin.sequences.DropSequence$iterator$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {
        public final Iterator b;
        public int c;

        public AnonymousClass1(DropSequence r2) {
            this.b = r2.f347a.iterator();
            this.c = r2.b;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
        L2:
            int r0 = this.c;
            Iterator r1 = this.b;
            if (r0 <= 0) goto L8;
            if (r1.hasNext() == false) goto L8;
            r1.next();
            this.c--;
        L8:
            return r1.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
        L2:
            int r0 = this.c;
            Iterator r1 = this.b;
            if (r0 <= 0) goto L8;
            if (r1.hasNext() == false) goto L8;
            r1.next();
            this.c--;
        L8:
            return r1.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public DropSequence(Sequence r2, int r3) {
        Intrinsics.f(r2, "sequence");
        this.f347a = r2;
        this.b = r3;
        if (r3 < 0) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(("count must be non-negative, but was " + r3 + '.').toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence a(int r2) {
        int r0 = this.b + r2;
        if (r0 >= 0) goto L6;
        return new DropSequence(this, r2);
    L6:
        return new DropSequence(this.f347a, r0);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }
}
