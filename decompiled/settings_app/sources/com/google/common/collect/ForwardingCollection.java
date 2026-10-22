package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    @Override // com.google.common.collect.ForwardingObject
    protected abstract Collection<E> delegate();

    @Override // com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    protected ForwardingCollection() {
    }

    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    public boolean removeAll(Collection<?> r1) {
        return delegate().removeAll(r1);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public boolean contains(@CheckForNull Object r1) {
        return delegate().contains(r1);
    }

    public boolean add(@ParametricNullness E r1) {
        return delegate().add(r1);
    }

    public boolean remove(@CheckForNull Object r1) {
        return delegate().remove(r1);
    }

    public boolean containsAll(Collection<?> r1) {
        return delegate().containsAll(r1);
    }

    public boolean addAll(Collection<? extends E> r1) {
        return delegate().addAll(r1);
    }

    public boolean retainAll(Collection<?> r1) {
        return delegate().retainAll(r1);
    }

    public void clear() {
        delegate().clear();
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    public <T> T[] toArray(T[] r1) {
        return (T[]) delegate().toArray(r1);
    }

    protected boolean standardContains(@CheckForNull Object r1) {
        return Iterators.contains(iterator(), r1);
    }

    protected boolean standardContainsAll(Collection<?> r1) {
        return Collections2.containsAllImpl(this, r1);
    }

    protected boolean standardAddAll(Collection<? extends E> r1) {
        return Iterators.addAll(this, r1.iterator());
    }

    protected boolean standardRemove(@CheckForNull Object r2) {
        Iterator<E> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (Objects.equal(r1.next(), r2) == false) goto L4;
        r1.remove();
        return true;
    L9:
        return false;
    }

    protected boolean standardRemoveAll(Collection<?> r1) {
        return Iterators.removeAll(iterator(), r1);
    }

    protected boolean standardRetainAll(Collection<?> r1) {
        return Iterators.retainAll(iterator(), r1);
    }

    protected void standardClear() {
        Iterators.clear(iterator());
    }

    protected boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    protected String standardToString() {
        return Collections2.toStringImpl(this);
    }

    protected Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    protected <T> T[] standardToArray(T[] r1) {
        return (T[]) ObjectArrays.toArrayImpl(this, r1);
    }
}
