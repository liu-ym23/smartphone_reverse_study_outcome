package kotlin.t0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class g<T> implements h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.n0.c.a<T> f21399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.n0.c.l<T, T> f21400b;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<T>, kotlin.n0.d.l0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private T f21401f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f21402g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ g<T> f21403h;

        a(g<T> r1) {
            this.f21403h = r1;
            this.f21402g = -2;
        }

        private final void b() {
            if (this.f21402g != (-2)) goto L5;
            T r0 = (T) g.b(this.f21403h).invoke();
        L6:
            this.f21401f = r0;
            if (r0 != null) goto L9;
            int r1 = 0;
        L10:
            this.f21402g = r1;
            return;
        L9:
            r1 = 1;
            goto L10
        L5:
            kotlin.n0.c.l r2 = g.c(this.f21403h);
            T r3 = this.f21401f;
            kotlin.n0.d.o.c(r3);
            r0 = (T) r2.invoke(r3);
            goto L6
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21402g >= 0) goto L6;
            b();
        L6:
            if (this.f21402g == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f21402g >= 0) goto L6;
            b();
        L6:
            if (this.f21402g == 0) goto L10;
            T r0 = this.f21401f;
            kotlin.n0.d.o.d(r0, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f21402g = -1;
            return r0;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(kotlin.n0.c.a<? extends T> r2, kotlin.n0.c.l<? super T, ? extends T> r3) {
        kotlin.n0.d.o.f(r2, "getInitialValue");
        kotlin.n0.d.o.f(r3, "getNextValue");
        this.f21399a = r2;
        this.f21400b = r3;
    }

    public static final /* synthetic */ kotlin.n0.c.a b(g r0) {
        return r0.f21399a;
    }

    public static final /* synthetic */ kotlin.n0.c.l c(g r0) {
        return r0.f21400b;
    }

    @Override // kotlin.t0.h
    public Iterator<T> iterator() {
        return new a(this);
    }
}
