package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        boolean equals(@CheckForNull Object r1);

        int getCount();

        @ParametricNullness
        E getElement();

        int hashCode();

        String toString();
    }

    int add(@ParametricNullness E r1, int r2);

    boolean add(@ParametricNullness E r1);

    boolean contains(@CheckForNull Object r1);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> r1);

    int count(@CheckForNull Object r1);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@CheckForNull Object r1);

    int hashCode();

    Iterator<E> iterator();

    int remove(@CheckForNull Object r1, int r2);

    boolean remove(@CheckForNull Object r1);

    boolean removeAll(Collection<?> r1);

    boolean retainAll(Collection<?> r1);

    int setCount(@ParametricNullness E r1, int r2);

    boolean setCount(@ParametricNullness E r1, int r2, int r3);

    int size();

    String toString();

    default void forEachEntry(final ObjIntConsumer<? super E> r2) {
        Preconditions.checkNotNull(r2);
        entrySet().forEach(new Multiset$$ExternalSyntheticLambda0(r2));
    }

    static /* synthetic */ void lambda$forEachEntry$0(ObjIntConsumer r1, Entry r2) {
        r1.accept(r2.getElement(), r2.getCount());
    }

    default void forEach(final Consumer<? super E> r2) {
        Preconditions.checkNotNull(r2);
        entrySet().forEach(new Multiset$$ExternalSyntheticLambda1(r2));
    }

    static /* synthetic */ void lambda$forEach$1(Consumer r2, Entry r3) {
        Object r0 = r3.getElement();
        int r4 = r3.getCount();
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        r2.accept(r0);
        r1 = r1 + 1;
        goto L3
    }

    default Spliterator<E> spliterator() {
        return Multisets.spliteratorImpl(this);
    }
}
