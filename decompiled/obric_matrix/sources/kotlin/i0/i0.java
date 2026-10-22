package kotlin.i0;

import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0086\u0002J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class i0<T> implements Iterator<g0<? extends T>>, kotlin.n0.d.l0.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Iterator<T> f18353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18354g;

    /* JADX WARN: Multi-variable type inference failed */
    public i0(Iterator<? extends T> r2) {
        kotlin.n0.d.o.f(r2, "iterator");
        this.f18353f = r2;
    }

    public final g0<T> b() {
        int r1 = this.f18354g;
        this.f18354g = r1 + 1;
        if (r1 >= 0) goto L5;
        r.p();
        throw null;
    L5:
        return new g0(r1, this.f18353f.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f18353f.hasNext();
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return b();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
