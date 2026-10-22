package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ShortIterator;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ArrayShortIterator extends ShortIterator {
    public final short[] b;
    public int c;

    public ArrayShortIterator() {
        Intrinsics.f(null, "array");
        this.b = null;
    }

    @Override // kotlin.collections.ShortIterator
    public final short a() {
        short[] r0 = this.b;     // Catch: ArrayIndexOutOfBoundsException -> L4
        int r1 = this.c;     // Catch: ArrayIndexOutOfBoundsException -> L4
        this.c = r1 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L4
        return r0[r1];
    L4:
        e = move-exception;
        this.c--;
        throw new NoSuchElementException(e.getMessage());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.c >= this.b.length) goto L5;
        return true;
    L5:
        return false;
    }
}
