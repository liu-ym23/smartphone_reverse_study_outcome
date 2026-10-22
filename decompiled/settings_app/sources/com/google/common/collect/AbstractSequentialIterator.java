package com.google.common.collect;

import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    @CheckForNull
    private T nextOrNull;

    @CheckForNull
    protected abstract T computeNext(T r1);

    protected AbstractSequentialIterator(@CheckForNull T r1) {
        this.nextOrNull = r1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextOrNull == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        T r0 = this.nextOrNull;
        if (r0 == null) goto L7;
        this.nextOrNull = computeNext(r0);
        return r0;
    L7:
        throw new NoSuchElementException();
    }
}
