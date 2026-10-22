package kotlin.s0.w.d.l0.i;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class x extends AbstractList<String> implements RandomAccess, o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final o f20408f;

    class a implements ListIterator<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ListIterator<String> f20409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f20410g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ x f20411h;

        a(x r1, int r2) {
            this.f20411h = r1;
            this.f20410g = r2;
            this.f20409f = x.a(r1).listIterator(r2);
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(String r1) {
            b(r1);
            throw null;
        }

        public void b(String r1) {
            throw new UnsupportedOperationException();
        }

        public String c() {
            return this.f20409f.next();
        }

        public String d() {
            return this.f20409f.previous();
        }

        public void e(String r1) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f20409f.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f20409f.hasPrevious();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return c();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f20409f.nextIndex();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ String previous() {
            return d();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f20409f.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(String r1) {
            e(r1);
            throw null;
        }
    }

    class b implements Iterator<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Iterator<String> f20412f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ x f20413g;

        b(x r1) {
            this.f20413g = r1;
            this.f20412f = x.a(r1).iterator();
        }

        public String b() {
            return this.f20412f.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f20412f.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ String next() {
            return b();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public x(o r1) {
        this.f20408f = r1;
    }

    static /* synthetic */ o a(x r0) {
        return r0.f20408f;
    }

    public String b(int r1) {
        return this.f20408f.get(r1);
    }

    @Override // kotlin.s0.w.d.l0.i.o
    public List<?> e() {
        return this.f20408f.e();
    }

    @Override // kotlin.s0.w.d.l0.i.o
    public d f(int r1) {
        return this.f20408f.f(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return b(r1);
    }

    @Override // kotlin.s0.w.d.l0.i.o
    public o h() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b(this);
    }

    @Override // kotlin.s0.w.d.l0.i.o
    public void j(d r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int r2) {
        return new a(this, r2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f20408f.size();
    }
}
