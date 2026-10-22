package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {

    @CheckForNull
    @LazyInit
    private transient ImmutableList<E> asList;

    @CheckForNull
    @LazyInit
    private transient ImmutableSet<Multiset.Entry<E>> entrySet;

    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        final Multiset<E> contents;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object r1) {
            return add(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object[] r1) {
            return add(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterable r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder addAll(Iterator r1) {
            return addAll(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection build() {
            return build();
        }

        public Builder() {
            this(LinkedHashMultiset.create());
        }

        Builder(Multiset<E> r1) {
            this.contents = r1;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E r2) {
            this.contents.add((E) Preconditions.checkNotNull(r2));
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E... r1) {
            super.add(r1);
            return this;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public Builder<E> addCopies(E r2, int r3) {
            this.contents.add((E) Preconditions.checkNotNull(r2), r3);
            return this;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public Builder<E> setCount(E r2, int r3) {
            this.contents.setCount((E) Preconditions.checkNotNull(r2), r3);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterable<? extends E> r2) {
            if ((r2 instanceof Multiset) == false) goto L5;
            Multisets.cast(r2).forEachEntry(new ImmutableMultiset$Builder$$ExternalSyntheticLambda0(this));
        L6:
            return this;
        L5:
            super.addAll(r2);
            goto L6
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        /* JADX INFO: renamed from: lambda$addAll$0$com-google-common-collect-ImmutableMultiset$Builder, reason: not valid java name */
        /* synthetic */ void m903xc4f69b4a(Object r1, int r2) {
            this.contents.add((E) Preconditions.checkNotNull(r1), r2);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterator<? extends E> r1) {
            super.addAll(r1);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableMultiset<E> build() {
            return ImmutableMultiset.copyOf(this.contents);
        }

        ImmutableMultiset<E> buildJdkBacked() {
            if (this.contents.isEmpty() == false) goto L7;
            return ImmutableMultiset.of();
        L7:
            return JdkBackedImmutableMultiset.create(this.contents.entrySet());
        }
    }

    static final class ElementSet<E> extends ImmutableSet.Indexed<E> {
        private final Multiset<E> delegate;
        private final List<Multiset.Entry<E>> entries;

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        ElementSet(List<Multiset.Entry<E>> r1, Multiset<E> r2) {
            this.entries = r1;
            this.delegate = r2;
        }

        @Override // com.google.common.collect.ImmutableSet.Indexed
        E get(int r1) {
            return this.entries.get(r1).getElement();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r1) {
            return this.delegate.contains(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.entries.size();
        }
    }

    private final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;
        final /* synthetic */ ImmutableMultiset this$0;

        @Override // com.google.common.collect.IndexedImmutableSet
        /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        private EntrySet(ImmutableMultiset r1) {
            this.this$0 = r1;
        }

        /* synthetic */ EntrySet(ImmutableMultiset r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.this$0.isPartialView();
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        Multiset.Entry<E> get(int r1) {
            return this.this$0.getEntry(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object r3) {
            if ((r3 instanceof Multiset.Entry) == false) goto L11;
            Multiset.Entry r4 = (Multiset.Entry) r3;
            if (r4.getCount() > 0) goto L8;
            return false;
        L8:
            if (this.this$0.count(r4.getElement()) != r4.getCount()) goto L12;
            return true;
        L12:
            return false;
        L11:
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.this$0.hashCode();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new EntrySetSerializedForm(this.this$0);
        }
    }

    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> r1) {
            this.multiset = r1;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(Multiset<? extends Object> r5) {
            int r0 = r5.entrySet().size();
            this.elements = new Object[r0];
            this.counts = new int[r0];
            Iterator<Multiset.Entry<? extends Object>> r6 = r5.entrySet().iterator();
            int r1 = 0;
        L4:
            if (r6.hasNext() == false) goto L6;
            Multiset.Entry<? extends Object> r2 = r6.next();
            this.elements[r1] = r2.getElement();
            this.counts[r1] = r2.getCount();
            r1 = r1 + 1;
            goto L4
        }

        Object readResolve() {
            LinkedHashMultiset r0 = LinkedHashMultiset.create(this.elements.length);
            int r1 = 0;
        L3:
            Object[] r2 = this.elements;
            if (r1 >= r2.length) goto L7;
            r0.add(r2[r1], this.counts[r1]);
            r1 = r1 + 1;
            goto L3
        L7:
            return ImmutableMultiset.copyOf(r0);
        }
    }

    static /* synthetic */ int lambda$toImmutableMultiset$0(Object r0) {
        return 1;
    }

    public abstract ImmutableSet<E> elementSet();

    abstract Multiset.Entry<E> getEntry(int r1);

    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    @Override // com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        return CollectCollectors.toImmutableMultiset(Function.identity(), new ImmutableMultiset$$ExternalSyntheticLambda0());
    }

    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> r0, ToIntFunction<? super T> r1) {
        return CollectCollectors.toImmutableMultiset(r0, r1);
    }

    public static <E> ImmutableMultiset<E> of() {
        return (ImmutableMultiset<E>) RegularImmutableMultiset.EMPTY;
    }

    public static <E> ImmutableMultiset<E> of(E r2) {
        return copyFromElements(new Object[]{r2});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3) {
        return copyFromElements(new Object[]{r2, r3});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3, E r4) {
        return copyFromElements(new Object[]{r2, r3, r4});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3, E r4, E r5) {
        return copyFromElements(new Object[]{r2, r3, r4, r5});
    }

    public static <E> ImmutableMultiset<E> of(E r2, E r3, E r4, E r5, E r6) {
        return copyFromElements(new Object[]{r2, r3, r4, r5, r6});
    }

    public static <E> ImmutableMultiset<E> of(E r1, E r2, E r3, E r4, E r5, E r6, E... r7) {
        return new Builder().add(r1).add(r2).add(r3).add(r4).add(r5).add(r6).add(r7).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] r0) {
        return copyFromElements(r0);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> r2) {
        if ((r2 instanceof ImmutableMultiset) == false) goto L8;
        ImmutableMultiset<E> r0 = (ImmutableMultiset) r2;
        if (r0.isPartialView() == true) goto L8;
        return r0;
    L8:
        if ((r2 instanceof Multiset) == false) goto L10;
        Multiset r3 = Multisets.cast(r2);
    L12:
        return copyFromEntries(r3.entrySet());
    L10:
        r3 = LinkedHashMultiset.create(r2);
        goto L12
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> r1) {
        LinkedHashMultiset r0 = LinkedHashMultiset.create();
        Iterators.addAll(r0, r1);
        return copyFromEntries(r0.entrySet());
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... r1) {
        LinkedHashMultiset r0 = LinkedHashMultiset.create();
        Collections.addAll(r0, r1);
        return copyFromEntries(r0.entrySet());
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> r1) {
        if (r1.isEmpty() == false) goto L7;
        return of();
    L7:
        return RegularImmutableMultiset.create(r1);
    }

    ImmutableMultiset() {
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        final UnmodifiableIterator<Multiset.Entry<E>> r0 = entrySet().iterator();
        return new AnonymousClass1(this, r0);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> r0 = this.asList;
        if (r0 != null) goto L6;
        ImmutableList<E> r1 = super.asList();
        this.asList = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r1) {
        if (count(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.Multiset
    @Deprecated
    public final int add(E r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @Deprecated
    public final int remove(@CheckForNull Object r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @Deprecated
    public final int setCount(E r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @Deprecated
    public final boolean setCount(E r1, int r2, int r3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] r4, int r5) {
        UnmodifiableIterator<Multiset.Entry<E>> r3 = entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Multiset.Entry<E> r0 = r3.next();
        Arrays.fill(r4, r5, r0.getCount() + r5, r0.getElement());
        r5 = r5 + r0.getCount();
        goto L4
    L6:
        return r5;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@CheckForNull Object r1) {
        return Multisets.equalsImpl(this, r1);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> r0 = this.entrySet;
        if (r0 != null) goto L6;
        ImmutableSet<Multiset.Entry<E>> r1 = createEntrySet();
        this.entrySet = r1;
        return r1;
    L6:
        return r0;
    }

    private ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        if (isEmpty() == false) goto L6;
        return ImmutableSet.of();
    L6:
        return new EntrySet(this, null);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> Builder<E> builder() {
        return new Builder();
    }
}
