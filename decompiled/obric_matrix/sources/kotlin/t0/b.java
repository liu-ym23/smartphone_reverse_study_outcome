package kotlin.t0;

import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b<T> implements h<T>, c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h<T> f21381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21382b;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"kotlin/sequences/DropSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<T>, kotlin.n0.d.l0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Iterator<T> f21383f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f21384g;

        a(b<T> r2) {
            this.f21383f = b.c(r2).iterator();
            this.f21384g = b.b(r2);
        }

        private final void b() {
        L3:
            if (this.f21384g <= 0) goto L7;
            if (this.f21383f.hasNext() == false) goto L10;
            this.f21383f.next();
            this.f21384g--;
            goto L3
        L10:
            return;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f21383f.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            b();
            return this.f21383f.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(h<? extends T> r2, int r3) {
        kotlin.n0.d.o.f(r2, "sequence");
        this.f21381a = r2;
        this.f21382b = r3;
        if (r3 < 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("count must be non-negative, but was " + r3 + '.').toString());
    L5:
        r1 = false;
        goto L6
    }

    public static final /* synthetic */ int b(b r0) {
        return r0.f21382b;
    }

    public static final /* synthetic */ h c(b r0) {
        return r0.f21381a;
    }

    @Override // kotlin.t0.c
    public h<T> a(int r2) {
        int r0 = this.f21382b + r2;
        if (r0 >= 0) goto L6;
        return new b(this, r2);
    L6:
        return new b(this.f21381a, r0);
    }

    @Override // kotlin.t0.h
    public Iterator<T> iterator() {
        return new a(this);
    }
}
