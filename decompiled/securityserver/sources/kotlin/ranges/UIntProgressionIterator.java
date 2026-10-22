package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
final class UIntProgressionIterator implements Iterator<UInt>, KMappedMarker {
    public final int b;
    public boolean c;
    public final int e;
    public int f;

    public UIntProgressionIterator(int r5, int r6) {
        this.b = r5;
        boolean r1 = false;
        int r3 = UnsignedKt.a(-1, r5);
        if (r6 <= 0) goto L6;
        if (r3 > 0) goto L8;
    L5:
        r1 = true;
    L8:
        this.c = r1;
        this.e = r6;
        if (r1 == false) goto L11;
        r5 = -1;
    L11:
        this.f = r5;
        return;
    L6:
        if (r3 < 0) goto L8;
        goto L8
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // java.util.Iterator
    public final UInt next() {
        int r0 = this.f;
        if (r0 == this.b) goto L5;
        this.f = this.e + r0;
    L11:
        return new UInt(r0);
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
