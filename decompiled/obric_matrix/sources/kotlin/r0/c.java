package kotlin.r0;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.i0.j0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/ranges/IntProgressionIterator;", "Lkotlin/collections/IntIterator;", "first", "", "last", "step", "(III)V", "finalElement", "hasNext", "", "next", "getStep", "()I", "nextInt", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c extends j0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f18463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f18464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18466i;

    public c(int r3, int r4, int r5) {
        this.f18463f = r5;
        this.f18464g = r4;
        boolean r0 = true;
        if (r5 <= 0) goto L6;
        if (r3 <= r4) goto L9;
    L8:
        r0 = false;
    L9:
        this.f18465h = r0;
        if (r0 == true) goto L13;
        r3 = r4;
    L13:
        this.f18466i = r3;
        return;
    L6:
        if (r3 < r4) goto L8;
        goto L8
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f18465h;
    }

    @Override // kotlin.i0.j0
    public int nextInt() {
        int r0 = this.f18466i;
        if (r0 == this.f18464g) goto L5;
        this.f18466i = this.f18463f + r0;
    L10:
        return r0;
    L5:
        if (this.f18465h == false) goto L8;
        this.f18465h = false;
        goto L10
    L8:
        throw new NoSuchElementException();
    }
}
