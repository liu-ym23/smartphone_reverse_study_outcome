package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final ImmutableMultiset<Object> EMPTY = null;
    private static final Multisets.ImmutableEntry<?>[] EMPTY_ARRAY = null;
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_HASH_BUCKET_LENGTH = 9;
    static final double MAX_LOAD_FACTOR = 1.0d;

    @CheckForNull
    @LazyInit
    private transient ImmutableSet<E> elementSet;
    private final transient Multisets.ImmutableEntry<E>[] entries;
    private final transient int hashCode;
    private final transient Multisets.ImmutableEntry<?>[] hashTable;
    private final transient int size;

    private static final class NonTerminalEntry<E> extends Multisets.ImmutableEntry<E> {
        private final Multisets.ImmutableEntry<E> nextInBucket;

        NonTerminalEntry(E r1, int r2, Multisets.ImmutableEntry<E> r3) {
            super(r1, r2);
            this.nextInBucket = r3;
        }

        @Override // com.google.common.collect.Multisets.ImmutableEntry
        public Multisets.ImmutableEntry<E> nextInBucket() {
            return this.nextInBucket;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set elementSet() {
        return elementSet();
    }

    static {
        EMPTY_ARRAY = new Multisets.ImmutableEntry[0];
        EMPTY = create(ImmutableList.of());
    }

    static <E> ImmutableMultiset<E> create(Collection<? extends Multiset.Entry<? extends E>> r14) {
        int r0 = r14.size();
        Multisets.ImmutableEntry[] r2 = new Multisets.ImmutableEntry[r0];
        if (r0 == 0) goto L5;
        int r1 = Hashing.closedTableSize(r0, MAX_LOAD_FACTOR);
        int r3 = r1 - 1;
        Multisets.ImmutableEntry[] r4 = new Multisets.ImmutableEntry[r1];
        Iterator<? extends Multiset.Entry<? extends E>> r15 = r14.iterator();
        long r5 = 0;
        int r6 = 0;
        int r7 = 0;
    L8:
        if (r15.hasNext() == false) goto L23;
        Multiset.Entry<? extends E> r8 = r15.next();
        Object r9 = Preconditions.checkNotNull(r8.getElement());
        int r10 = r8.getCount();
        int r11 = r9.hashCode();
        int r12 = Hashing.smear(r11) & r3;
        Multisets.ImmutableEntry r13 = r4[r12];
        if (r13 == null) goto L12;
        Multisets.ImmutableEntry r16 = new NonTerminalEntry(r9, r10, r13);
    L21:
        r6 = r6 + (r11 ^ r10);
        r2[r7] = r16;
        r4[r12] = r16;
        r5 = r5 + ((long) r10);
        r7 = r7 + 1;
        goto L8
    L12:
        if ((r8 instanceof Multisets.ImmutableEntry) == true) goto L14;
    L16:
        boolean r17 = false;
    L17:
        if (r17 == false) goto L19;
        r16 = (Multisets.ImmutableEntry) r8;
        goto L21
    L19:
        r16 = new Multisets.ImmutableEntry(r9, r10);
        goto L21
    L14:
        if ((r8 instanceof NonTerminalEntry) == true) goto L16;
        r17 = true;
        goto L17
    L23:
        if (hashFloodingDetected(r4) == false) goto L26;
        return JdkBackedImmutableMultiset.create(ImmutableList.asImmutableList(r2));
    L26:
        return new RegularImmutableMultiset(r2, r4, Ints.saturatedCast(r5), r6, null);
    L5:
        return new RegularImmutableMultiset(r2, EMPTY_ARRAY, 0, 0, ImmutableSet.of());
    }

    private static boolean hashFloodingDetected(Multisets.ImmutableEntry<?>[] r6) {
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L12;
        Multisets.ImmutableEntry<?> r2 = r6[r1];
        int r3 = 0;
    L6:
        if (r2 == null) goto L11;
        r3 = r3 + 1;
        if (r3 > 9) goto L9;
        r2 = r2.nextInBucket();
        goto L6
    L9:
        return true;
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        return false;
    }

    private RegularImmutableMultiset(Multisets.ImmutableEntry<E>[] r1, Multisets.ImmutableEntry<?>[] r2, int r3, int r4, @CheckForNull ImmutableSet<E> r5) {
        this.entries = r1;
        this.hashTable = r2;
        this.size = r3;
        this.hashCode = r4;
        this.elementSet = r5;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object r4) {
        Multisets.ImmutableEntry<?>[] r3 = this.hashTable;
        if (r4 != null) goto L5;
    L14:
        return 0;
    L5:
        if (r3.length == 0) goto L14;
        Multisets.ImmutableEntry<?> r5 = r3[Hashing.smearedHash(r4) & (r3.length - 1)];
    L8:
        if (r5 == null) goto L14;
        if (Objects.equal(r4, r5.getElement()) == true) goto L12;
        r5 = r5.nextInBucket();
        goto L8
    L12:
        return r5.getCount();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> r0 = this.elementSet;
        if (r0 != null) goto L6;
        ImmutableMultiset.ElementSet r1 = new ImmutableMultiset.ElementSet(Arrays.asList(this.entries), this);
        this.elementSet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    Multiset.Entry<E> getEntry(int r1) {
        return this.entries[r1];
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return this.hashCode;
    }
}
