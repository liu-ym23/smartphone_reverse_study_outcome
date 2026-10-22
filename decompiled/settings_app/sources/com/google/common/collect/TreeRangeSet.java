package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C> implements Serializable {

    @CheckForNull
    private transient Set<Range<C>> asDescendingSetOfRanges;

    @CheckForNull
    private transient Set<Range<C>> asRanges;

    @CheckForNull
    private transient RangeSet<C> complement;
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* JADX INFO: renamed from: com.google.common.collect.TreeRangeSet$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    final class AsRanges extends ForwardingCollection<Range<C>> implements Set<Range<C>> {
        final Collection<Range<C>> delegate;

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected /* bridge */ /* synthetic */ Object delegate() {
            return delegate();
        }

        AsRanges(TreeRangeSet r1, Collection<Range<C>> r2) {
            this.delegate = r2;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        protected Collection<Range<C>> delegate() {
            return this.delegate;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object r1) {
            return Sets.equalsImpl(this, r1);
        }
    }

    private final class Complement extends TreeRangeSet<C> {
        final /* synthetic */ TreeRangeSet this$0;

        Complement(TreeRangeSet r2) {
            this.this$0 = r2;
            super(new ComplementRangesByLowerBound(r2.rangesByLowerBound), null);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void add(Range<C> r1) {
            this.this$0.remove(r1);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void remove(Range<C> r1) {
            this.this$0.add(r1);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean contains(C r1) {
            return !this.this$0.contains(r1);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> complement() {
            return this.this$0;
        }
    }

    private static final class ComplementRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        private final Range<Cut<C>> complementLowerBoundWindow;
        private final NavigableMap<Cut<C>, Range<C>> positiveRangesByLowerBound;
        private final NavigableMap<Cut<C>, Range<C>> positiveRangesByUpperBound;

        static /* synthetic */ Range access$100(ComplementRangesByLowerBound r0) {
            return r0.complementLowerBoundWindow;
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public /* bridge */ /* synthetic */ Object get(@CheckForNull Object r1) {
            return get(r1);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap headMap(Object r1, boolean r2) {
            return headMap((Cut) r1, r2);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap subMap(Object r1, boolean r2, Object r3, boolean r4) {
            return subMap((Cut) r1, r2, (Cut) r3, r4);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r1, boolean r2) {
            return tailMap((Cut) r1, r2);
        }

        ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> r2) {
            this(r2, Range.all());
        }

        private ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> r2, Range<Cut<C>> r3) {
            this.positiveRangesByLowerBound = r2;
            this.positiveRangesByUpperBound = new RangesByUpperBound(r2);
            this.complementLowerBoundWindow = r3;
        }

        private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> r2) {
            if (this.complementLowerBoundWindow.isConnected(r2) == false) goto L5;
            Range<C> r3 = r2.intersection(this.complementLowerBoundWindow);
            return new ComplementRangesByLowerBound(this.positiveRangesByLowerBound, r3);
        L5:
            return ImmutableSortedMap.of();
        }

        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> r1, boolean r2, Cut<C> r3, boolean r4) {
            return subMap(Range.range(r1, BoundType.forBoolean(r2), r3, BoundType.forBoolean(r4)));
        }

        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> r1, boolean r2) {
            return subMap(Range.upTo(r1, BoundType.forBoolean(r2)));
        }

        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> r1, boolean r2) {
            return subMap(Range.downTo(r1, BoundType.forBoolean(r2)));
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            if (this.complementLowerBoundWindow.hasLowerBound() == false) goto L9;
            NavigableMap<Cut<C>, Range<C>> r0 = this.positiveRangesByUpperBound;
            Cut<C> r1 = (Cut) this.complementLowerBoundWindow.lowerEndpoint();
            if (this.complementLowerBoundWindow.lowerBoundType() != BoundType.CLOSED) goto L7;
            boolean r2 = true;
        L8:
            Collection<Range<C>> r3 = r0.tailMap(r1, r2).values();
        L10:
            final PeekingIterator r4 = Iterators.peekingIterator(r3.iterator());
            if (this.complementLowerBoundWindow.contains(Cut.belowAll()) == false) goto L18;
            if (r4.hasNext() == true) goto L15;
        L16:
            final Cut r5 = Cut.belowAll();
        L21:
            return new AnonymousClass1(this, r5, r4);
        L15:
            if (((Range) r4.peek()).lowerBound != Cut.belowAll()) goto L16;
        L18:
            if (r4.hasNext() == false) goto L23;
            r5 = ((Range) r4.next()).upperBound;
            goto L21
        L23:
            return Iterators.emptyIterator();
        L7:
            r2 = false;
            goto L8
        L9:
            r3 = this.positiveRangesByUpperBound.values();
            goto L10
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
            if (this.complementLowerBoundWindow.hasUpperBound() == false) goto L5;
            Cut<C> r0 = (Cut) this.complementLowerBoundWindow.upperEndpoint();
        L7:
            if (this.complementLowerBoundWindow.hasUpperBound() == true) goto L9;
        L11:
            boolean r1 = false;
        L12:
            final PeekingIterator r2 = Iterators.peekingIterator(this.positiveRangesByUpperBound.headMap(r0, r1).descendingMap().values().iterator());
            if (r2.hasNext() == false) goto L19;
            if (((Range) r2.peek()).upperBound != Cut.aboveAll()) goto L17;
            Cut<C> r3 = ((Range) r2.next()).lowerBound;
        L24:
            final Cut r4 = (Cut) MoreObjects.firstNonNull(r3, Cut.aboveAll());
            return new AnonymousClass2(this, r4, r2);
        L17:
            r3 = this.positiveRangesByLowerBound.higherKey(((Range) r2.peek()).upperBound);
            goto L24
        L19:
            if (this.complementLowerBoundWindow.contains(Cut.belowAll()) == false) goto L27;
            if (this.positiveRangesByLowerBound.containsKey(Cut.belowAll()) == true) goto L27;
            r3 = this.positiveRangesByLowerBound.higherKey(Cut.belowAll());
        L27:
            return Iterators.emptyIterator();
        L9:
            if (this.complementLowerBoundWindow.upperBoundType() != BoundType.CLOSED) goto L11;
            r1 = true;
            goto L12
        L5:
            r0 = Cut.aboveAll();
            goto L7
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.size(entryIterator());
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Range<C> get(@CheckForNull Object r3) {
            if ((r3 instanceof Cut) == true) goto L12;
        L10:
            return null;
        L12:
            Cut<C> r4 = (Cut) r3;     // Catch: ClassCastException -> L11
            Map.Entry<Cut<C>, Range<C>> r2 = tailMap(r4, true).firstEntry();     // Catch: ClassCastException -> L11
            if (r2 == null) goto L10;
            if (r2.getKey().equals(r4) == false) goto L10;
            return r2.getValue();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            if (get(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static final class RangesByUpperBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
        private final Range<Cut<C>> upperBoundWindow;

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public /* bridge */ /* synthetic */ Object get(@CheckForNull Object r1) {
            return get(r1);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap headMap(Object r1, boolean r2) {
            return headMap((Cut) r1, r2);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap subMap(Object r1, boolean r2, Object r3, boolean r4) {
            return subMap((Cut) r1, r2, (Cut) r3, r4);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r1, boolean r2) {
            return tailMap((Cut) r1, r2);
        }

        static /* synthetic */ Range access$000(RangesByUpperBound r0) {
            return r0.upperBoundWindow;
        }

        RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> r1) {
            this.rangesByLowerBound = r1;
            this.upperBoundWindow = Range.all();
        }

        private RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> r1, Range<Cut<C>> r2) {
            this.rangesByLowerBound = r1;
            this.upperBoundWindow = r2;
        }

        private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> r3) {
            if (r3.isConnected(this.upperBoundWindow) == false) goto L7;
            return new RangesByUpperBound(this.rangesByLowerBound, r3.intersection(this.upperBoundWindow));
        L7:
            return ImmutableSortedMap.of();
        }

        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> r1, boolean r2, Cut<C> r3, boolean r4) {
            return subMap(Range.range(r1, BoundType.forBoolean(r2), r3, BoundType.forBoolean(r4)));
        }

        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> r1, boolean r2) {
            return subMap(Range.upTo(r1, BoundType.forBoolean(r2)));
        }

        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> r1, boolean r2) {
            return subMap(Range.downTo(r1, BoundType.forBoolean(r2)));
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            if (get(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Range<C> get(@CheckForNull Object r3) {
            if ((r3 instanceof Cut) == true) goto L15;
        L13:
            return null;
        L15:
            Cut<C> r4 = (Cut) r3;     // Catch: ClassCastException -> L14
            if (this.upperBoundWindow.contains(r4) == true) goto L7;
            return null;
        L7:
            Map.Entry<Cut<C>, Range<C>> r2 = this.rangesByLowerBound.lowerEntry(r4);     // Catch: ClassCastException -> L14
            if (r2 == null) goto L13;
            if (r2.getValue().upperBound.equals(r4) == false) goto L13;
            return r2.getValue();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            if (this.upperBoundWindow.hasLowerBound() == true) goto L5;
            final Iterator<Range<C>> r0 = this.rangesByLowerBound.values().iterator();
        L13:
            return new AnonymousClass1(this, r0);
        L5:
            Map.Entry<Cut<C>, Range<C>> r1 = this.rangesByLowerBound.lowerEntry((Cut) this.upperBoundWindow.lowerEndpoint());
            if (r1 != null) goto L9;
            r0 = this.rangesByLowerBound.values().iterator();
            goto L13
        L9:
            if (this.upperBoundWindow.lowerBound.isLessThan(r1.getValue().upperBound) == false) goto L11;
            r0 = this.rangesByLowerBound.tailMap(r1.getKey(), true).values().iterator();
            goto L13
        L11:
            r0 = this.rangesByLowerBound.tailMap((Cut) this.upperBoundWindow.lowerEndpoint(), true).values().iterator();
            goto L13
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
            if (this.upperBoundWindow.hasUpperBound() == false) goto L5;
            Collection<Range<C>> r0 = this.rangesByLowerBound.headMap((Cut) this.upperBoundWindow.upperEndpoint(), false).descendingMap().values();
        L6:
            final PeekingIterator r1 = Iterators.peekingIterator(r0.iterator());
            if (r1.hasNext() == false) goto L12;
            if (this.upperBoundWindow.upperBound.isLessThan(((Range) r1.peek()).upperBound) == false) goto L12;
            r1.next();
        L12:
            return new AnonymousClass2(this, r1);
        L5:
            r0 = this.rangesByLowerBound.descendingMap().values();
            goto L6
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.upperBoundWindow.equals(Range.all()) == false) goto L7;
            return this.rangesByLowerBound.size();
        L7:
            return Iterators.size(entryIterator());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.upperBoundWindow.equals(Range.all()) == false) goto L6;
            return this.rangesByLowerBound.isEmpty();
        L6:
            if (entryIterator().hasNext() == true) goto L8;
            return true;
        L8:
            return false;
        }
    }

    private final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;
        final /* synthetic */ TreeRangeSet this$0;

        SubRangeSet(TreeRangeSet r4, Range<C> r5) {
            this.this$0 = r4;
            AnonymousClass1 r2 = null;
            super(new SubRangeSetRangesByLowerBound(Range.all(), r5, r4.rangesByLowerBound, r2), r2);
            this.restriction = r5;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean encloses(Range<C> r3) {
            if (this.restriction.isEmpty() == false) goto L5;
            return false;
        L5:
            if (this.restriction.encloses(r3) == false) goto L13;
            Range r4 = TreeRangeSet.access$600(this.this$0, r3);
            if (r4 != null) goto L9;
            return false;
        L9:
            if (r4.intersection(this.restriction).isEmpty() == true) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        @CheckForNull
        public Range<C> rangeContaining(C r3) {
            if (this.restriction.contains(r3) == true) goto L5;
            return null;
        L5:
            Range<C> r4 = this.this$0.rangeContaining(r3);
            if (r4 != null) goto L9;
            return null;
        L9:
            return r4.intersection(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void add(Range<C> r4) {
            Preconditions.checkArgument(this.restriction.encloses(r4), "Cannot add range %s to subRangeSet(%s)", r4, this.restriction);
            this.this$0.add(r4);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void remove(Range<C> r2) {
            if (r2.isConnected(this.restriction) == false) goto L6;
            this.this$0.remove(r2.intersection(this.restriction));
            return;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean contains(C r2) {
            if (this.restriction.contains(r2) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.this$0.contains(r2) == false) goto L7;
            return true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void clear() {
            this.this$0.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> subRangeSet(Range<C> r3) {
            if (r3.encloses(this.restriction) == false) goto L6;
            return this;
        L6:
            if (r3.isConnected(this.restriction) == false) goto L10;
            return new SubRangeSet(this, this.restriction.intersection(r3));
        L10:
            return ImmutableRangeSet.of();
        }
    }

    private static final class SubRangeSetRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        private final Range<Cut<C>> lowerBoundWindow;
        private final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;
        private final NavigableMap<Cut<C>, Range<C>> rangesByUpperBound;
        private final Range<C> restriction;

        /* synthetic */ SubRangeSetRangesByLowerBound(Range r1, Range r2, NavigableMap r3, AnonymousClass1 r4) {
            this(r1, r2, r3);
        }

        static /* synthetic */ Range access$300(SubRangeSetRangesByLowerBound r0) {
            return r0.restriction;
        }

        static /* synthetic */ Range access$400(SubRangeSetRangesByLowerBound r0) {
            return r0.lowerBoundWindow;
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public /* bridge */ /* synthetic */ Object get(@CheckForNull Object r1) {
            return get(r1);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap headMap(Object r1, boolean r2) {
            return headMap((Cut) r1, r2);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap subMap(Object r1, boolean r2, Object r3, boolean r4) {
            return subMap((Cut) r1, r2, (Cut) r3, r4);
        }

        @Override // java.util.NavigableMap
        public /* bridge */ /* synthetic */ NavigableMap tailMap(Object r1, boolean r2) {
            return tailMap((Cut) r1, r2);
        }

        private SubRangeSetRangesByLowerBound(Range<Cut<C>> r1, Range<C> r2, NavigableMap<Cut<C>, Range<C>> r3) {
            this.lowerBoundWindow = (Range) Preconditions.checkNotNull(r1);
            this.restriction = (Range) Preconditions.checkNotNull(r2);
            this.rangesByLowerBound = (NavigableMap) Preconditions.checkNotNull(r3);
            this.rangesByUpperBound = new RangesByUpperBound(r3);
        }

        private NavigableMap<Cut<C>, Range<C>> subMap(Range<Cut<C>> r3) {
            if (r3.isConnected(this.lowerBoundWindow) == true) goto L7;
            return ImmutableSortedMap.of();
        L7:
            return new SubRangeSetRangesByLowerBound(this.lowerBoundWindow.intersection(r3), this.restriction, this.rangesByLowerBound);
        }

        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> r1, boolean r2, Cut<C> r3, boolean r4) {
            return subMap(Range.range(r1, BoundType.forBoolean(r2), r3, BoundType.forBoolean(r4)));
        }

        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> r1, boolean r2) {
            return subMap(Range.upTo(r1, BoundType.forBoolean(r2)));
        }

        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> r1, boolean r2) {
            return subMap(Range.downTo(r1, BoundType.forBoolean(r2)));
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object r1) {
            if (get(r1) == null) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        @CheckForNull
        public Range<C> get(@CheckForNull Object r4) {
            if ((r4 instanceof Cut) == true) goto L25;
        L23:
            return null;
        L25:
            Cut<C> r5 = (Cut) r4;     // Catch: ClassCastException -> L24
            if (this.lowerBoundWindow.contains(r5) == false) goto L23;
            if (r5.compareTo(this.restriction.lowerBound) < 0) goto L23;
            if (r5.compareTo(this.restriction.upperBound) >= 0) goto L23;
            if (r5.equals(this.restriction.lowerBound) == false) goto L19;
            Range r6 = (Range) Maps.valueOrNull(this.rangesByLowerBound.floorEntry(r5));     // Catch: ClassCastException -> L24
            if (r6 == null) goto L23;
            if (r6.upperBound.compareTo(this.restriction.lowerBound) <= 0) goto L23;
            return r6.intersection(this.restriction);
        L19:
            Range r7 = (Range) this.rangesByLowerBound.get(r5);     // Catch: ClassCastException -> L24
            if (r7 == null) goto L23;
            return r7.intersection(this.restriction);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<Cut<C>, Range<C>>> entryIterator() {
            if (this.restriction.isEmpty() == false) goto L7;
            return Iterators.emptyIterator();
        L7:
            if (this.lowerBoundWindow.upperBound.isLessThan(this.restriction.lowerBound) == true) goto L9;
            boolean r1 = false;
            if (this.lowerBoundWindow.lowerBound.isLessThan(this.restriction.lowerBound) == false) goto L13;
            final Iterator<Range<C>> r0 = this.rangesByUpperBound.tailMap(this.restriction.lowerBound, false).values().iterator();
        L17:
            final Cut r2 = (Cut) Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
            return new AnonymousClass1(this, r0, r2);
        L13:
            NavigableMap<Cut<C>, Range<C>> r3 = this.rangesByLowerBound;
            Cut<C> r4 = (Cut) this.lowerBoundWindow.lowerBound.endpoint();
            if (this.lowerBoundWindow.lowerBoundType() != BoundType.CLOSED) goto L16;
            r1 = true;
        L16:
            r0 = r3.tailMap(r4, r1).values().iterator();
            goto L17
        L9:
            return Iterators.emptyIterator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<Cut<C>, Range<C>>> descendingEntryIterator() {
            if (this.restriction.isEmpty() == true) goto L5;
            Cut r0 = (Cut) Ordering.natural().min(this.lowerBoundWindow.upperBound, Cut.belowValue(this.restriction.upperBound));
            NavigableMap<Cut<C>, Range<C>> r1 = this.rangesByLowerBound;
            Cut<C> r2 = (Cut) r0.endpoint();
            if (r0.typeAsUpperBound() != BoundType.CLOSED) goto L9;
            boolean r3 = true;
        L10:
            final Iterator<Range<C>> r4 = r1.headMap(r2, r3).descendingMap().values().iterator();
            return new AnonymousClass2(this, r4);
        L9:
            r3 = false;
            goto L10
        L5:
            return Iterators.emptyIterator();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.size(entryIterator());
        }
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(RangeSet r1) {
        super.addAll(r1);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable r1) {
        return super.contains(r1);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet r1) {
        return super.enclosesAll(r1);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object r1) {
        return super.equals(r1);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(RangeSet r1) {
        super.removeAll(r1);
    }

    /* synthetic */ TreeRangeSet(NavigableMap r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ Range access$600(TreeRangeSet r0, Range r1) {
        return r0.rangeEnclosing(r1);
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet(new TreeMap());
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> r1) {
        TreeRangeSet<C> r0 = create();
        r0.addAll(r1);
        return r0;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> r1) {
        TreeRangeSet<C> r0 = create();
        r0.addAll(r1);
        return r0;
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> r1) {
        this.rangesByLowerBound = r1;
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asRanges() {
        Set<Range<C>> r0 = this.asRanges;
        if (r0 != null) goto L6;
        AsRanges r1 = new AsRanges(this, this.rangesByLowerBound.values());
        this.asRanges = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> r0 = this.asDescendingSetOfRanges;
        if (r0 != null) goto L6;
        AsRanges r1 = new AsRanges(this, this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @CheckForNull
    public Range<C> rangeContaining(C r2) {
        Preconditions.checkNotNull(r2);
        Map.Entry<Cut<C>, Range<C>> r1 = this.rangesByLowerBound.floorEntry(Cut.belowValue(r2));
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.getValue().contains(r2) == true) goto L7;
        return null;
    L7:
        return r1.getValue();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> r4) {
        Preconditions.checkNotNull(r4);
        Map.Entry<Cut<C>, Range<C>> r0 = this.rangesByLowerBound.ceilingEntry(r4.lowerBound);
        if (r0 != null) goto L5;
    L9:
        Map.Entry<Cut<C>, Range<C>> r3 = this.rangesByLowerBound.lowerEntry(r4.lowerBound);
        if (r3 != null) goto L12;
    L16:
        return false;
    L12:
        if (r3.getValue().isConnected(r4) == false) goto L16;
        if (r3.getValue().intersection(r4).isEmpty() == true) goto L16;
        return true;
    L5:
        if (r0.getValue().isConnected(r4) == false) goto L9;
        if (r0.getValue().intersection(r4).isEmpty() == true) goto L9;
        return true;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> r2) {
        Preconditions.checkNotNull(r2);
        Map.Entry<Cut<C>, Range<C>> r1 = this.rangesByLowerBound.floorEntry(r2.lowerBound);
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.getValue().encloses(r2) == false) goto L7;
        return true;
    }

    @CheckForNull
    private Range<C> rangeEnclosing(Range<C> r2) {
        Preconditions.checkNotNull(r2);
        Map.Entry<Cut<C>, Range<C>> r1 = this.rangesByLowerBound.floorEntry(r2.lowerBound);
        if (r1 != null) goto L5;
    L7:
        return null;
    L5:
        if (r1.getValue().encloses(r2) == false) goto L7;
        return r1.getValue();
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> r0 = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> r1 = this.rangesByLowerBound.lastEntry();
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        return Range.create(r0.getValue().lowerBound, r1.getValue().upperBound);
    L8:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public void add(Range<C> r4) {
        Preconditions.checkNotNull(r4);
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Cut<C> r0 = r4.lowerBound;
        Cut<C> r5 = r4.upperBound;
        Map.Entry<Cut<C>, Range<C>> r1 = this.rangesByLowerBound.lowerEntry(r0);
        if (r1 == null) goto L13;
        Range<C> r2 = r1.getValue();
        if (r2.upperBound.compareTo(r0) < 0) goto L13;
        if (r2.upperBound.compareTo(r5) < 0) goto L12;
        r5 = r2.upperBound;
    L12:
        r0 = r2.lowerBound;
    L13:
        Map.Entry<Cut<C>, Range<C>> r3 = this.rangesByLowerBound.floorEntry(r5);
        if (r3 == null) goto L18;
        Range<C> r6 = r3.getValue();
        if (r6.upperBound.compareTo(r5) < 0) goto L18;
        r5 = r6.upperBound;
    L18:
        this.rangesByLowerBound.subMap(r0, r5).clear();
        replaceRangeWithSameLowerBound(Range.create(r0, r5));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public void remove(Range<C> r4) {
        Preconditions.checkNotNull(r4);
        if (r4.isEmpty() == false) goto L5;
        return;
    L5:
        Map.Entry<Cut<C>, Range<C>> r0 = this.rangesByLowerBound.lowerEntry(r4.lowerBound);
        if (r0 == null) goto L15;
        Range<C> r1 = r0.getValue();
        if (r1.upperBound.compareTo(r4.lowerBound) < 0) goto L15;
        if (r4.hasUpperBound() == true) goto L12;
    L14:
        replaceRangeWithSameLowerBound(Range.create(r1.lowerBound, r4.lowerBound));
        goto L15
    L12:
        if (r1.upperBound.compareTo(r4.upperBound) < 0) goto L14;
        replaceRangeWithSameLowerBound(Range.create(r4.upperBound, r1.upperBound));
    L15:
        Map.Entry<Cut<C>, Range<C>> r2 = this.rangesByLowerBound.floorEntry(r4.upperBound);
        if (r2 == null) goto L22;
        Range<C> r3 = r2.getValue();
        if (r4.hasUpperBound() == false) goto L22;
        if (r3.upperBound.compareTo(r4.upperBound) < 0) goto L22;
        replaceRangeWithSameLowerBound(Range.create(r4.upperBound, r3.upperBound));
    L22:
        this.rangesByLowerBound.subMap(r4.lowerBound, r4.upperBound).clear();
    }

    private void replaceRangeWithSameLowerBound(Range<C> r2) {
        if (r2.isEmpty() == false) goto L5;
        this.rangesByLowerBound.remove(r2.lowerBound);
        return;
    L5:
        this.rangesByLowerBound.put(r2.lowerBound, r2);
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> complement() {
        RangeSet<C> r0 = this.complement;
        if (r0 != null) goto L6;
        Complement r1 = new Complement(this);
        this.complement = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> subRangeSet(Range<C> r2) {
        if (r2.equals(Range.all()) == false) goto L6;
        return this;
    L6:
        return new SubRangeSet(this, r2);
    }
}
