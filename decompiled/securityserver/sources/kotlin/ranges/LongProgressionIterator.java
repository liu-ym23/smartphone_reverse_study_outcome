package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LongProgressionIterator extends LongIterator {
    public final long b;
    public final long c;
    public boolean e;
    public long f;

    public LongProgressionIterator(long r4, long r6) {
        this.b = r6;
        this.c = r4;
        boolean r7 = false;
        if (r6 <= 0) goto L8;
        if (1 > r4) goto L10;
    L6:
        r7 = true;
    L10:
        this.e = r7;
        if (r7 == false) goto L13;
        r4 = 1;
    L13:
        this.f = r4;
        return;
    L8:
        if (1 < r4) goto L10;
        goto L10
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.e;
    }

    @Override // kotlin.collections.LongIterator
    public final long nextLong() {
        long r0 = this.f;
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
