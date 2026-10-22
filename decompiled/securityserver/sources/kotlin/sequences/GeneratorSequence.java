package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class GeneratorSequence<T> implements Sequence<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0 f350a;
    public final Function1 b;

    /* JADX INFO: renamed from: kotlin.sequences.GeneratorSequence$iterator$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements Iterator<Object>, KMappedMarker {
        public Object b;
        public int c;
        public final /* synthetic */ GeneratorSequence e;

        public AnonymousClass1(GeneratorSequence r1) {
            this.e = r1;
            this.c = -2;
        }

        public final void a() {
            int r0 = this.c;
            GeneratorSequence r2 = this.e;
            if (r0 != (-2)) goto L5;
            Object r1 = r2.f350a.invoke();
        L6:
            this.b = r1;
            if (r1 != null) goto L9;
            int r3 = 0;
        L10:
            this.c = r3;
            return;
        L9:
            r3 = 1;
            goto L10
        L5:
            Function1 r4 = r2.b;
            Object r5 = this.b;
            Intrinsics.c(r5);
            r1 = r4.invoke(r5);
            goto L6
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.c >= 0) goto L6;
            a();
        L6:
            if (this.c == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.c >= 0) goto L6;
            a();
        L6:
            if (this.c == 0) goto L10;
            Object r0 = this.b;
            Intrinsics.d(r0, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
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

    public GeneratorSequence(Function0 r1, Function1 r2) {
        this.f350a = r1;
        this.b = r2;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }
}
