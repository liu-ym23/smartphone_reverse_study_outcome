package kotlin.t0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e<T> implements h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h<T> f21386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f21387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.n0.c.l<T, Boolean> f21388c;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<T>, kotlin.n0.d.l0.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Iterator<T> f21389f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f21390g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private T f21391h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ e<T> f21392i;

        a(e<T> r1) {
            this.f21392i = r1;
            this.f21389f = e.d(r1).iterator();
            this.f21390g = -1;
        }

        private final void b() {
        L3:
            if (this.f21389f.hasNext() == false) goto L9;
            T r0 = this.f21389f.next();
            if (((Boolean) e.b(this.f21392i).invoke(r0)).booleanValue() != e.c(this.f21392i)) goto L3;
            this.f21391h = r0;
            int r1 = 1;
        L7:
            this.f21390g = r1;
            return;
        L9:
            r1 = 0;
            goto L7
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21390g != (-1)) goto L6;
            b();
        L6:
            if (this.f21390g == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f21390g != (-1)) goto L6;
            b();
        L6:
            if (this.f21390g == 0) goto L10;
            T r0 = this.f21391h;
            this.f21391h = null;
            this.f21390g = -1;
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
    public e(h<? extends T> r2, boolean r3, kotlin.n0.c.l<? super T, Boolean> r4) {
        kotlin.n0.d.o.f(r2, "sequence");
        kotlin.n0.d.o.f(r4, "predicate");
        this.f21386a = r2;
        this.f21387b = r3;
        this.f21388c = r4;
    }

    public static final /* synthetic */ kotlin.n0.c.l b(e r0) {
        return r0.f21388c;
    }

    public static final /* synthetic */ boolean c(e r0) {
        return r0.f21387b;
    }

    public static final /* synthetic */ h d(e r0) {
        return r0.f21386a;
    }

    @Override // kotlin.t0.h
    public Iterator<T> iterator() {
        return new a(this);
    }
}
