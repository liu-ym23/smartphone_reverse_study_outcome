package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
final class ULongProgressionIterator implements Iterator<ULong>, KMappedMarker {
    public final long b;
    public boolean c;
    public final long e;
    public long f;

    public ULongProgressionIterator(long r6, long r8) {
        this.b = r6;
        boolean r3 = false;
        if (r8 <= 0) goto L8;
        if (UnsignedKt.b(-1, r6) > 0) goto L10;
    L6:
        r3 = true;
    L10:
        this.c = r3;
        this.e = r8;
        if (r3 == false) goto L13;
        r6 = -1;
    L13:
        this.f = r6;
        return;
    L8:
        if (UnsignedKt.b(-1, r6) < 0) goto L10;
        goto L10
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // java.util.Iterator
    public final ULong next() {
        long r0 = this.f;
        if (r0 == this.b) goto L5;
        this.f = this.e + r0;
    L11:
        return new ULong(r0);
    L5:
        if (this.c == false) goto L8;
        this.c = false;
        goto L11
    L8:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
