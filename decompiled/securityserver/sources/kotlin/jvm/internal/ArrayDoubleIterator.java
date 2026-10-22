package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.DoubleIterator;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class ArrayDoubleIterator extends DoubleIterator {
    public final double[] b;
    public int c;

    public ArrayDoubleIterator() {
        Intrinsics.f(null, "array");
        this.b = null;
    }

    @Override // kotlin.collections.DoubleIterator
    public final double a() {
        double[] r0 = this.b;     // Catch: ArrayIndexOutOfBoundsException -> L4
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
