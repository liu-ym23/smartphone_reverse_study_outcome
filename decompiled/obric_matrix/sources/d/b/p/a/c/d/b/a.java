package d.b.p.a.c.d.b;

import android.os.MessageQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class a extends ArrayList<MessageQueue.IdleHandler> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<MessageQueue.IdleHandler> f14216f;

    public a(ArrayList<MessageQueue.IdleHandler> r1) {
        this.f14216f = r1;
    }

    public void a(int r1, MessageQueue.IdleHandler r2) {
        throw new RuntimeException("Reach method add");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ void add(int r1, Object r2) {
        a(r1, (MessageQueue.IdleHandler) r2);
        throw null;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean add(Object r1) {
        return c((MessageQueue.IdleHandler) r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r1, Collection<? extends MessageQueue.IdleHandler> r2) {
        throw new RuntimeException("Reach method addAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends MessageQueue.IdleHandler> r1) {
        throw new RuntimeException("Reach method addAll");
    }

    public boolean c(MessageQueue.IdleHandler r2) {
        if (r2 == null) goto L8;
        if ((r2 instanceof d) == true) goto L8;
        return this.f14216f.add(new d(r2));
    L8:
        return this.f14216f.add(r2);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        throw new RuntimeException("Reach method clear");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        throw new RuntimeException("Reach method contains");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> r1) {
        throw new RuntimeException("Reach method containsAll");
    }

    public MessageQueue.IdleHandler d(int r1) {
        throw new RuntimeException("Reach method get");
    }

    @Override // java.util.ArrayList
    public void ensureCapacity(int r1) {
        throw new RuntimeException("Reach method ensureCapacity");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r1) {
        return super.equals(r1);
    }

    protected void finalize() {
        super.finalize();
    }

    @Override // java.util.ArrayList, java.lang.Iterable
    public void forEach(Consumer<? super MessageQueue.IdleHandler> r1) {
        throw new RuntimeException("Reach method forEach");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        d(r1);
        throw null;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int indexOf(Object r1) {
        throw new RuntimeException("Reach method indexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        throw new RuntimeException("Reach method isEmpty");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<MessageQueue.IdleHandler> iterator() {
        return this.f14216f.iterator();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r1) {
        throw new RuntimeException("Reach method lastIndexOf");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator() {
        throw new RuntimeException("Reach method listIterator");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public ListIterator<MessageQueue.IdleHandler> listIterator(int r1) {
        throw new RuntimeException("Reach method listIterator");
    }

    public MessageQueue.IdleHandler m(int r1) {
        return this.f14216f.remove(r1);
    }

    public MessageQueue.IdleHandler n(int r1, MessageQueue.IdleHandler r2) {
        throw new RuntimeException("Reach method set");
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> parallelStream() {
        throw new RuntimeException("Reach method parallelStream");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return m(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r5) {
        if (this.f14216f.remove(r5) == false) goto L6;
        return true;
    L6:
        d r0 = null;
        Iterator<MessageQueue.IdleHandler> r1 = this.f14216f.iterator();
    L8:
        if (r1.hasNext() == false) goto L14;
        MessageQueue.IdleHandler r2 = r1.next();
        if ((r2 instanceof d) == false) goto L8;
        d r3 = (d) r2;
        if (r3.a() != r5) goto L8;
        r0 = r3;
    L14:
        if (r0 != null) goto L16;
        return false;
    L16:
        return this.f14216f.remove(r0);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r1) {
        throw new RuntimeException("Reach method removeAll");
    }

    @Override // java.util.ArrayList, java.util.Collection
    public boolean removeIf(Predicate<? super MessageQueue.IdleHandler> r1) {
        throw new RuntimeException("Reach method removeIf");
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int r1, int r2) {
        throw new RuntimeException("Reach method removeRange");
    }

    @Override // java.util.ArrayList, java.util.List
    public void replaceAll(UnaryOperator<MessageQueue.IdleHandler> r1) {
        throw new RuntimeException("Reach method replaceAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r1) {
        throw new RuntimeException("Reach method retainAll");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object set(int r1, Object r2) {
        n(r1, (MessageQueue.IdleHandler) r2);
        throw null;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f14216f.size();
    }

    @Override // java.util.ArrayList, java.util.List
    public void sort(Comparator<? super MessageQueue.IdleHandler> r1) {
        throw new RuntimeException("Reach method sort");
    }

    @Override // java.util.ArrayList, java.util.Collection, java.lang.Iterable, java.util.List
    public Spliterator<MessageQueue.IdleHandler> spliterator() {
        throw new RuntimeException("Reach method spliterator");
    }

    @Override // java.util.Collection
    public Stream<MessageQueue.IdleHandler> stream() {
        throw new RuntimeException("Reach method stream");
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public List<MessageQueue.IdleHandler> subList(int r1, int r2) {
        throw new RuntimeException("Reach method subList");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        throw new RuntimeException("Reach method toArray");
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r1) {
        return (T[]) this.f14216f.toArray(r1);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return super.toString();
    }

    @Override // java.util.ArrayList
    public void trimToSize() {
        throw new RuntimeException("Reach method trimToSize");
    }
}
