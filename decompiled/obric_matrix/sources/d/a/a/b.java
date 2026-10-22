package d.a.a;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class b extends a implements List<Object>, Cloneable, RandomAccess, Serializable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<Object> f12374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected transient Object f12375l;
    protected transient Type m;

    public b() {
        this.f12374k = new ArrayList(10);
    }

    public b(List<Object> r1) {
        this.f12374k = r1;
    }

    @Override // java.util.List
    public void add(int r1, Object r2) {
        this.f12374k.add(r1, r2);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object r1) {
        return this.f12374k.add(r1);
    }

    @Override // java.util.List
    public boolean addAll(int r1, Collection<? extends Object> r2) {
        return this.f12374k.addAll(r1, r2);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Object> r1) {
        return this.f12374k.addAll(r1);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f12374k.clear();
    }

    public Object clone() {
        return new b(new ArrayList(this.f12374k));
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r1) {
        return this.f12374k.contains(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r1) {
        return this.f12374k.containsAll(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r1) {
        return this.f12374k.equals(r1);
    }

    @Override // java.util.List
    public Object get(int r1) {
        return this.f12374k.get(r1);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f12374k.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object r1) {
        return this.f12374k.indexOf(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f12374k.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.f12374k.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object r1) {
        return this.f12374k.lastIndexOf(r1);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.f12374k.listIterator();
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int r1) {
        return this.f12374k.listIterator(r1);
    }

    @Override // java.util.List
    public Object remove(int r1) {
        return this.f12374k.remove(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r1) {
        return this.f12374k.remove(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r1) {
        return this.f12374k.removeAll(r1);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r1) {
        return this.f12374k.retainAll(r1);
    }

    @Override // java.util.List
    public Object set(int r1, Object r2) {
        return this.f12374k.set(r1, r2);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f12374k.size();
    }

    @Override // java.util.List
    public List<Object> subList(int r1, int r2) {
        return this.f12374k.subList(r1, r2);
    }

    public Type t() {
        return this.m;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f12374k.toArray();
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] r1) {
        return (T[]) this.f12374k.toArray(r1);
    }

    public Object u() {
        return this.f12375l;
    }

    public void v(Type r1) {
        this.m = r1;
    }

    public void w(Object r1) {
        this.f12375l = r1;
    }
}
