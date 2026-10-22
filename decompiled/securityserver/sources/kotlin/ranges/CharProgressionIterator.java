package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CharProgressionIterator extends CharIterator {
    public final int b;
    public final int c;
    public boolean e;
    public int f;

    public CharProgressionIterator(char r3, int r4) {
        this.b = r4;
        this.c = r3;
        boolean r1 = false;
        if (r4 <= 0) goto L8;
        if (Intrinsics.h(1, r3) > 0) goto L10;
    L6:
        r1 = true;
    L10:
        this.e = r1;
        if (r1 == false) goto L13;
        r3 = 1;
    L13:
        this.f = r3;
        return;
    L8:
        if (Intrinsics.h(1, r3) < 0) goto L10;
        goto L10
    }

    @Override // kotlin.collections.CharIterator
    public final char a() {
        int r0 = this.f;
        if (r0 == this.c) goto L5;
        this.f = this.b + r0;
    L11:
        return (char) r0;
    L5:
        if (this.e == false) goto L8;
        this.e = false;
        goto L11
    L8:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.e;
    }
}
