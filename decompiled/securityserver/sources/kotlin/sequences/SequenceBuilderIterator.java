package kotlin.sequences;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {
    public int b;
    public Object c;
    public Iterator e;
    public Continuation f;

    @Override // kotlin.sequences.SequenceScope
    public final void a(Object r1, Continuation r2) {
        this.c = r1;
        this.b = 3;
        this.f = r2;
        Intrinsics.f(r2, TypedValues.AttributesType.S_FRAME);
    }

    public final RuntimeException b() {
        int r0 = this.b;
        if (r0 == 4) goto L9;
        if (r0 == 5) goto L11;
        return new IllegalStateException("Unexpected state of the iterator: " + this.b);
    L11:
        return new IllegalStateException("Iterator has failed.");
    L9:
        return new NoSuchElementException();
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
    L2:
        int r0 = this.b;
        if (r0 == 0) goto L21;
        if (r0 != 1) goto L6;
        Iterator r1 = this.e;
        Intrinsics.c(r1);
        if (r1.hasNext() == true) goto L18;
        this.e = null;
        goto L21
    L18:
        this.b = 2;
        return true;
    L6:
        if (r0 != 2) goto L8;
    L15:
        return true;
    L8:
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L14;
        return false;
    L14:
        throw b();
    L21:
        this.b = 5;
        Continuation r2 = this.f;
        Intrinsics.c(r2);
        this.f = null;
        r2.k(Unit.f330a);
        goto L2
    }

    @Override // kotlin.coroutines.Continuation
    public final void k(Object r1) {
        ResultKt.b(r1);
        this.b = 4;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int r0 = this.b;
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L17;
        if (r0 != 2) goto L9;
        this.b = 1;
        Iterator r3 = this.e;
        Intrinsics.c(r3);
        return r3.next();
    L9:
        if (r0 != 3) goto L13;
        this.b = 0;
        Object r1 = this.c;
        this.c = null;
        return r1;
    L13:
        throw b();
    L17:
        if (hasNext() == false) goto L21;
        return next();
    L21:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
