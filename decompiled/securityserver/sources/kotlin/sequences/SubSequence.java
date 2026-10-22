package kotlin.sequences;

import a.a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f352a;
    public final int b;
    public final int c;

    /* JADX INFO: renamed from: kotlin.sequences.SubSequence$iterator$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {
        public final Iterator b;
        public int c;
        public final /* synthetic */ SubSequence e;

        public AnonymousClass1(SubSequence r1) {
            this.e = r1;
            this.b = r1.f352a.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
        L2:
            int r0 = this.c;
            SubSequence r1 = this.e;
            int r2 = r1.b;
            Iterator r4 = this.b;
            if (r0 >= r2) goto L8;
            if (r4.hasNext() == false) goto L8;
            r4.next();
            this.c++;
        L8:
            if (this.c < r1.c) goto L10;
        L12:
            return false;
        L10:
            if (r4.hasNext() == false) goto L12;
            return true;
        }

        @Override // java.util.Iterator
        public final Object next() {
        L2:
            int r0 = this.c;
            SubSequence r1 = this.e;
            int r2 = r1.b;
            Iterator r3 = this.b;
            if (r0 >= r2) goto L7;
            if (r3.hasNext() == false) goto L7;
            r3.next();
            this.c++;
        L7:
            int r4 = this.c;
            if (r4 >= r1.c) goto L12;
            this.c = r4 + 1;
            return r3.next();
        L12:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public SubSequence(Sequence r2, int r3, int r4) {
        Intrinsics.f(r2, "sequence");
        this.f352a = r2;
        this.b = r3;
        this.c = r4;
        if (r3 < 0) goto L12;
        if (r4 < 0) goto L10;
        if (r4 < r3) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + r4 + " < " + r3).toString());
    L10:
        throw new IllegalArgumentException(a.e(r4, "endIndex should be non-negative, but is ").toString());
    L12:
        throw new IllegalArgumentException(a.e(r3, "startIndex should be non-negative, but is ").toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence a(int r4) {
        int r0 = this.c;
        int r1 = this.b;
        if (r4 < (r0 - r1)) goto L6;
        return EmptySequence.f348a;
    L6:
        return new SubSequence(this.f352a, r1 + r4, r0);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }
}
