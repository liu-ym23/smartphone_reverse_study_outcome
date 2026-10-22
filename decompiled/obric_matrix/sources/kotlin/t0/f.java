package kotlin.t0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004BA\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0096\u0002R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class f<T, R, E> implements h<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h<T> f21393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.n0.c.l<T, R> f21394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.n0.c.l<R, Iterator<E>> f21395c;

    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0096\u0002J\u000e\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004¨\u0006\u000e"}, d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<E>, kotlin.n0.d.l0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Iterator<T> f21396f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Iterator<? extends E> f21397g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ f<T, R, E> f21398h;

        a(f<T, R, E> r1) {
            this.f21398h = r1;
            this.f21396f = f.c(r1).iterator();
        }

        private final boolean b() {
            Iterator<? extends E> r0 = this.f21397g;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L11;
            this.f21397g = null;
        L11:
            if (this.f21397g != null) goto L18;
            if (this.f21396f.hasNext() == false) goto L14;
            Iterator<? extends E> r2 = (Iterator) f.b(this.f21398h).invoke(f.d(this.f21398h).invoke(this.f21396f.next()));
            if (r2.hasNext() == false) goto L11;
            this.f21397g = r2;
            goto L18
        L14:
            return false;
        L18:
            return true;
        L5:
            if (r0.hasNext() == true) goto L7;
            r1 = true;
            goto L8
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return b();
        }

        @Override // java.util.Iterator
        public E next() {
            if (b() == false) goto L7;
            Iterator<? extends E> r1 = this.f21397g;
            kotlin.n0.d.o.c(r1);
            return r1.next();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(h<? extends T> r2, kotlin.n0.c.l<? super T, ? extends R> r3, kotlin.n0.c.l<? super R, ? extends Iterator<? extends E>> r4) {
        kotlin.n0.d.o.f(r2, "sequence");
        kotlin.n0.d.o.f(r3, "transformer");
        kotlin.n0.d.o.f(r4, "iterator");
        this.f21393a = r2;
        this.f21394b = r3;
        this.f21395c = r4;
    }

    public static final /* synthetic */ kotlin.n0.c.l b(f r0) {
        return r0.f21395c;
    }

    public static final /* synthetic */ h c(f r0) {
        return r0.f21393a;
    }

    public static final /* synthetic */ kotlin.n0.c.l d(f r0) {
        return r0.f21394b;
    }

    @Override // kotlin.t0.h
    public Iterator<E> iterator() {
        return new a(this);
    }
}
