package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FilteringSequence<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sequence f349a;
    public final boolean b;
    public final Function1 c;

    /* JADX INFO: renamed from: kotlin.sequences.FilteringSequence$iterator$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {
        public final Iterator b;
        public int c;
        public Object e;
        public final /* synthetic */ FilteringSequence f;

        public AnonymousClass1(FilteringSequence r1) {
            this.f = r1;
            this.b = r1.f349a.iterator();
            this.c = -1;
        }

        public final void a() {
        L2:
            Iterator r0 = this.b;
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            FilteringSequence r2 = this.f;
            if (((Boolean) r2.c.invoke(r1)).booleanValue() != r2.b) goto L2;
            this.e = r1;
            this.c = 1;
            return;
        L8:
            this.c = 0;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.c != (-1)) goto L6;
            a();
        L6:
            if (this.c == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.c != (-1)) goto L6;
            a();
        L6:
            if (this.c == 0) goto L10;
            Object r0 = this.e;
            this.e = null;
            this.c = -1;
            return r0;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public FilteringSequence(Sequence r2, boolean r3, Function1 r4) {
        Intrinsics.f(r2, "sequence");
        this.f349a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }
}
