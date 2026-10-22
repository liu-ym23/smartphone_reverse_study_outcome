package kotlin.t0;

import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J3\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003\"\u0004\b\u0002\u0010\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000b0\u0006H\u0000¢\u0006\u0002\b\fJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0096\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", "E", "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class r<T, R> implements h<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h<T> f21423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.n0.c.l<T, R> f21424b;

    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\u000e\u0010\u0007\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"kotlin/sequences/TransformingSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<R>, kotlin.n0.d.l0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Iterator<T> f21425f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ r<T, R> f21426g;

        a(r<T, R> r1) {
            this.f21426g = r1;
            this.f21425f = r.b(r1).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21425f.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) r.c(this.f21426g).invoke(this.f21425f.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(h<? extends T> r2, kotlin.n0.c.l<? super T, ? extends R> r3) {
        kotlin.n0.d.o.f(r2, "sequence");
        kotlin.n0.d.o.f(r3, "transformer");
        this.f21423a = r2;
        this.f21424b = r3;
    }

    public static final /* synthetic */ h b(r r0) {
        return r0.f21423a;
    }

    public static final /* synthetic */ kotlin.n0.c.l c(r r0) {
        return r0.f21424b;
    }

    public final <E> h<E> d(kotlin.n0.c.l<? super R, ? extends Iterator<? extends E>> r3) {
        kotlin.n0.d.o.f(r3, "iterator");
        return new f(this.f21423a, this.f21424b, r3);
    }

    @Override // kotlin.t0.h
    public Iterator<R> iterator() {
        return new a(this);
    }
}
