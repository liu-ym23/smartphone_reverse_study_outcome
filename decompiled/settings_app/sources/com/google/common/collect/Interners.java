package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class Interners {

    /* JADX INFO: renamed from: com.google.common.collect.Interners$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class InternerBuilder {
        private final MapMaker mapMaker;
        private boolean strong;

        /* synthetic */ InternerBuilder(AnonymousClass1 r1) {
            this();
        }

        private InternerBuilder() {
            this.mapMaker = new MapMaker();
            this.strong = true;
        }

        public InternerBuilder strong() {
            this.strong = true;
            return this;
        }

        public InternerBuilder weak() {
            this.strong = false;
            return this;
        }

        public InternerBuilder concurrencyLevel(int r2) {
            this.mapMaker.concurrencyLevel(r2);
            return this;
        }

        public <E> Interner<E> build() {
            if (this.strong == true) goto L6;
            this.mapMaker.weakKeys();
        L6:
            return new InternerImpl(this.mapMaker, null);
        }
    }

    private static class InternerFunction<E> implements Function<E, E> {
        private final Interner<E> interner;

        public InternerFunction(Interner<E> r1) {
            this.interner = r1;
        }

        @Override // com.google.common.base.Function, java.util.function.Function
        public E apply(E r1) {
            return this.interner.intern(r1);
        }

        public int hashCode() {
            return this.interner.hashCode();
        }

        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object r2) {
            if ((r2 instanceof InternerFunction) == true) goto L5;
            return false;
        L5:
            return this.interner.equals(((InternerFunction) r2).interner);
        }
    }

    static final class InternerImpl<E> implements Interner<E> {
        final MapMakerInternalMap<E, MapMaker.Dummy, ?, ?> map;

        /* synthetic */ InternerImpl(MapMaker r1, AnonymousClass1 r2) {
            this(r1);
        }

        private InternerImpl(MapMaker r2) {
            this.map = MapMakerInternalMap.createWithDummyValues(r2.keyEquivalence(Equivalence.equals()));
        }

        @Override // com.google.common.collect.Interner
        public E intern(E r3) {
        L2:
            MapMakerInternalMap.InternalEntry r0 = this.map.getEntry(r3);
            if (r0 == null) goto L8;
            E r1 = (E) r0.getKey();
            if (r1 == null) goto L8;
            return r1;
        L8:
            if (this.map.putIfAbsent(r3, MapMaker.Dummy.VALUE) != null) goto L2;
            return r3;
        }
    }

    private Interners() {
    }

    public static InternerBuilder newBuilder() {
        return new InternerBuilder(null);
    }

    public static <E> Interner<E> newStrongInterner() {
        return newBuilder().strong().build();
    }

    public static <E> Interner<E> newWeakInterner() {
        return newBuilder().weak().build();
    }

    public static <E> Function<E, E> asFunction(Interner<E> r1) {
        return new InternerFunction((Interner) Preconditions.checkNotNull(r1));
    }
}
