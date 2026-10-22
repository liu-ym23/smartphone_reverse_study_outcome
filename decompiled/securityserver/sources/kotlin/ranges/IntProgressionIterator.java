package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IntProgressionIterator extends IntIterator {
    public final int b;
    public final int c;
    public boolean e;
    public int f;

    public IntProgressionIterator(int r3, int r4, int r5) {
        this.b = r5;
        this.c = r4;
        boolean r0 = false;
        if (r5 <= 0) goto L6;
        if (r3 > r4) goto L8;
    L5:
        r0 = true;
    L8:
        this.e = r0;
        if (r0 == true) goto L12;
        r3 = r4;
    L12:
        this.f = r3;
        return;
    L6:
        if (r3 < r4) goto L8;
        goto L8
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.e;
    }

    @Override // kotlin.collections.IntIterator
    public final int nextInt() {
        int r0 = this.f;
        if (r0 == this.c) goto L5;
        this.f = this.b + r0;
    L10:
        return r0;
    L5:
        if (this.e == false) goto L8;
        this.e = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }
}
