package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    static final double HASH_FLOODING_FPP = 0.001d;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;

    @CheckForNull
    transient Object[] elements;

    @CheckForNull
    private transient int[] entries;
    private transient int metadata;
    private transient int size;

    @CheckForNull
    private transient Object table;

    int adjustAfterRemove(int r1, int r2) {
        return r1 - 1;
    }

    static /* synthetic */ int access$000(CompactHashSet r0) {
        return r0.metadata;
    }

    static /* synthetic */ Object access$100(CompactHashSet r0, int r1) {
        return r0.element(r1);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet();
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> r1) {
        CompactHashSet<E> r0 = createWithExpectedSize(r1.size());
        r0.addAll(r1);
        return r0;
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> create(E... r1) {
        CompactHashSet<E> r0 = createWithExpectedSize(r1.length);
        Collections.addAll(r0, r1);
        return r0;
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int r1) {
        return new CompactHashSet(r1);
    }

    CompactHashSet() {
        init(3);
    }

    CompactHashSet(int r1) {
        init(r1);
    }

    void init(int r4) {
        if (r4 < 0) goto L5;
        boolean r1 = true;
    L6:
        Preconditions.checkArgument(r1, "Expected size must be >= 0");
        this.metadata = Ints.constrainToRange(r4, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        return;
    L5:
        r1 = false;
        goto L6
    }

    boolean needsAllocArrays() {
        if (this.table != null) goto L5;
        return true;
    L5:
        return false;
    }

    int allocArrays() {
        Preconditions.checkState(needsAllocArrays(), "Arrays already allocated");
        int r0 = this.metadata;
        int r1 = CompactHashing.tableSize(r0);
        this.table = CompactHashing.createTable(r1);
        setHashTableMask(r1 - 1);
        this.entries = new int[r0];
        this.elements = new Object[r0];
        return r0;
    }

    @CheckForNull
    Set<E> delegateOrNull() {
        Object r1 = this.table;
        if ((r1 instanceof Set) == true) goto L5;
        return null;
    L5:
        return (Set) r1;
    }

    private Set<E> createHashFloodingResistantDelegate(int r2) {
        return new LinkedHashSet(r2, 1.0f);
    }

    Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> r0 = createHashFloodingResistantDelegate(hashTableMask() + 1);
        int r1 = firstEntryIndex();
    L3:
        if (r1 < 0) goto L5;
        r0.add(element(r1));
        r1 = getSuccessor(r1);
        goto L3
    L5:
        this.table = r0;
        this.entries = null;
        this.elements = null;
        incrementModCount();
        return r0;
    }

    boolean isUsingHashFloodingResistance() {
        if (delegateOrNull() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void setHashTableMask(int r3) {
        int r4 = 32 - Integer.numberOfLeadingZeros(r3);
        this.metadata = CompactHashing.maskCombine(this.metadata, r4, 31);
    }

    private int hashTableMask() {
        return (1 << (this.metadata & 31)) - 1;
    }

    void incrementModCount() {
        this.metadata += 32;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(@ParametricNullness E r14) {
        if (needsAllocArrays() == false) goto L5;
        allocArrays();
    L5:
        Set<E> r0 = delegateOrNull();
        if (r0 != null) goto L8;
        int[] r1 = requireEntries();
        Object[] r2 = requireElements();
        int r3 = this.size;
        int r4 = r3 + 1;
        int r5 = Hashing.smearedHash(r14);
        int r6 = hashTableMask();
        int r7 = r5 & r6;
        int r8 = CompactHashing.tableGet(requireTable(), r7);
        if (r8 != 0) goto L14;
        if (r4 <= r6) goto L13;
        r6 = resizeTable(r6, CompactHashing.newCapacity(r6), r5, r3);
    L29:
        resizeMeMaybe(r4);
        insertEntry(r3, r14, r5, r6);
        this.size = r4;
        incrementModCount();
        return true;
    L13:
        CompactHashing.tableSet(requireTable(), r7, r4);
        goto L29
    L14:
        int r9 = CompactHashing.getHashPrefix(r5, r6);
        int r10 = 0;
    L15:
        int r11 = r8 - 1;
        int r12 = r1[r11];
        if (CompactHashing.getHashPrefix(r12, r6) == r9) goto L18;
    L20:
        int r13 = CompactHashing.getNext(r12, r6);
        r10 = r10 + 1;
        if (r13 == 0) goto L23;
        r8 = r13;
        goto L15
    L23:
        if (r10 >= 9) goto L25;
        if (r4 <= r6) goto L28;
        r6 = resizeTable(r6, CompactHashing.newCapacity(r6), r5, r3);
        goto L29
    L28:
        r1[r11] = CompactHashing.maskCombine(r12, r4, r6);
        goto L29
    L25:
        return convertToHashFloodingResistantImplementation().add(r14);
    L18:
        if (Objects.equal(r14, r2[r11]) == false) goto L20;
        return false;
    L8:
        return r0.add(r14);
    }

    void insertEntry(int r2, @ParametricNullness E r3, int r4, int r5) {
        setEntry(r2, CompactHashing.maskCombine(r4, 0, r5));
        setElement(r2, r3);
    }

    private void resizeMeMaybe(int r3) {
        int r0 = requireEntries().length;
        if (r3 <= r0) goto L8;
        int r4 = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, r0 >>> 1) + r0) | 1);
        if (r4 == r0) goto L9;
        resizeEntries(r4);
        return;
    L9:
        return;
    }

    void resizeEntries(int r2) {
        this.entries = Arrays.copyOf(requireEntries(), r2);
        this.elements = Arrays.copyOf(requireElements(), r2);
    }

    private int resizeTable(int r9, int r10, int r11, int r12) {
        Object r0 = CompactHashing.createTable(r10);
        int r13 = r10 - 1;
        if (r12 == 0) goto L5;
        CompactHashing.tableSet(r0, r11 & r13, r12 + 1);
    L5:
        Object r14 = requireTable();
        int[] r15 = requireEntries();
        int r1 = 0;
    L6:
        if (r1 > r9) goto L11;
        int r2 = CompactHashing.tableGet(r14, r1);
    L8:
        if (r2 == 0) goto L10;
        int r3 = r2 - 1;
        int r4 = r15[r3];
        int r5 = CompactHashing.getHashPrefix(r4, r9) | r1;
        int r6 = r5 & r13;
        int r7 = CompactHashing.tableGet(r0, r6);
        CompactHashing.tableSet(r0, r6, r2);
        r15[r3] = CompactHashing.maskCombine(r5, r7, r13);
        r2 = CompactHashing.getNext(r4, r9);
        goto L8
    L10:
        r1 = r1 + 1;
        goto L6
    L11:
        this.table = r0;
        setHashTableMask(r13);
        return r13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object r8) {
        if (needsAllocArrays() == false) goto L5;
        return false;
    L5:
        Set<E> r0 = delegateOrNull();
        if (r0 != null) goto L8;
        int r1 = Hashing.smearedHash(r8);
        int r2 = hashTableMask();
        int r3 = CompactHashing.tableGet(requireTable(), r1 & r2);
        if (r3 != 0) goto L12;
        return false;
    L12:
        int r4 = CompactHashing.getHashPrefix(r1, r2);
    L13:
        int r5 = r3 - 1;
        int r6 = entry(r5);
        if (CompactHashing.getHashPrefix(r6, r2) == r4) goto L16;
    L18:
        r3 = CompactHashing.getNext(r6, r2);
        if (r3 != 0) goto L13;
        return false;
    L16:
        if (Objects.equal(r8, element(r5)) == false) goto L18;
        return true;
    L8:
        return r0.contains(r8);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@CheckForNull Object r10) {
        if (needsAllocArrays() == false) goto L5;
        return false;
    L5:
        Set<E> r0 = delegateOrNull();
        if (r0 != null) goto L8;
        int r1 = hashTableMask();
        int r11 = CompactHashing.remove(r10, null, r1, requireTable(), requireEntries(), requireElements(), null);
        if (r11 != (-1)) goto L12;
        return false;
    L12:
        moveLastEntry(r11, r1);
        this.size--;
        incrementModCount();
        return true;
    L8:
        return r0.remove(r10);
    }

    void moveLastEntry(int r7, int r8) {
        Object r0 = requireTable();
        int[] r1 = requireEntries();
        Object[] r2 = requireElements();
        int r6 = size() - 1;
        if (r7 >= r6) goto L11;
        Object r5 = r2[r6];
        r2[r7] = r5;
        r2[r6] = null;
        r1[r7] = r1[r6];
        r1[r6] = 0;
        int r3 = Hashing.smearedHash(r5) & r8;
        int r4 = CompactHashing.tableGet(r0, r3);
        int r9 = r6 + 1;
        if (r4 != r9) goto L7;
        CompactHashing.tableSet(r0, r3, r7 + 1);
        return;
    L7:
        int r10 = r4 - 1;
        int r11 = r1[r10];
        int r12 = CompactHashing.getNext(r11, r8);
        if (r12 == r9) goto L9;
        r4 = r12;
        goto L7
    L9:
        r1[r10] = CompactHashing.maskCombine(r11, r7 + 1, r8);
        return;
    L11:
        r2[r7] = null;
        r1[r7] = 0;
    }

    int firstEntryIndex() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        return 0;
    }

    int getSuccessor(int r1) {
        int r2 = r1 + 1;
        if (r2 < this.size) goto L7;
        return -1;
    L7:
        return r2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        Set<E> r0 = delegateOrNull();
        if (r0 == null) goto L7;
        return r0.iterator();
    L7:
        return new AnonymousClass1(this);
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        if (needsAllocArrays() == true) goto L5;
        Set<E> r0 = delegateOrNull();
        if (r0 == null) goto L10;
        return r0.spliterator();
    L10:
        return Spliterators.spliterator(requireElements(), 0, this.size, 17);
    L5:
        return Spliterators.spliterator(new Object[0], 17);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> r3) {
        Preconditions.checkNotNull(r3);
        Set<E> r0 = delegateOrNull();
        if (r0 == null) goto L5;
        r0.forEach(r3);
        return;
    L5:
        int r1 = firstEntryIndex();
    L6:
        if (r1 < 0) goto L10;
        r3.accept(element(r1));
        r1 = getSuccessor(r1);
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        Set<E> r0 = delegateOrNull();
        if (r0 == null) goto L6;
        return r0.size();
    L6:
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        if (needsAllocArrays() == true) goto L5;
        Set<E> r0 = delegateOrNull();
        if (r0 == null) goto L10;
        return r0.toArray();
    L10:
        return Arrays.copyOf(requireElements(), this.size);
    L5:
        return new Object[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] r3) {
        if (needsAllocArrays() == true) goto L5;
        Set<E> r0 = delegateOrNull();
        if (r0 == null) goto L12;
        return (T[]) r0.toArray(r3);
    L12:
        return (T[]) ObjectArrays.toArrayImpl(requireElements(), 0, this.size, r3);
    L5:
        if (r3.length <= 0) goto L7;
        r3[0] = null;
    L7:
        return r3;
    }

    public void trimToSize() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        Set<E> r0 = delegateOrNull();
        if (r0 == null) goto L9;
        Set<E> r1 = createHashFloodingResistantDelegate(size());
        r1.addAll(r0);
        this.table = r1;
        return;
    L9:
        int r2 = this.size;
        if (r2 >= requireEntries().length) goto L12;
        resizeEntries(r2);
    L12:
        int r3 = CompactHashing.tableSize(r2);
        int r4 = hashTableMask();
        if (r3 >= r4) goto L16;
        resizeTable(r4, r3, 0, 0);
        return;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays() == false) goto L5;
        return;
    L5:
        incrementModCount();
        Set<E> r0 = delegateOrNull();
        if (r0 == null) goto L8;
        this.metadata = Ints.constrainToRange(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        r0.clear();
        this.table = null;
        this.size = 0;
        return;
    L8:
        Arrays.fill(requireElements(), 0, this.size, null);
        CompactHashing.tableClear(requireTable());
        Arrays.fill(requireEntries(), 0, this.size, 0);
        this.size = 0;
    }

    private void writeObject(ObjectOutputStream r2) throws IOException {
        r2.defaultWriteObject();
        r2.writeInt(size());
        Iterator<E> r1 = iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r2.writeObject(r1.next());
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r4) throws IOException, ClassNotFoundException {
        r4.defaultReadObject();
        int r0 = r4.readInt();
        if (r0 < 0) goto L9;
        init(r0);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        add(r4.readObject());
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new InvalidObjectException(new StringBuilder(25).append("Invalid size: ").append(r0).toString());
    }

    private Object requireTable() {
        return java.util.Objects.requireNonNull(this.table);
    }

    private int[] requireEntries() {
        return (int[]) java.util.Objects.requireNonNull(this.entries);
    }

    private Object[] requireElements() {
        return (Object[]) java.util.Objects.requireNonNull(this.elements);
    }

    private E element(int r1) {
        return (E) requireElements()[r1];
    }

    private int entry(int r1) {
        return requireEntries()[r1];
    }

    private void setElement(int r1, E r2) {
        requireElements()[r1] = r2;
    }

    private void setEntry(int r1, int r2) {
        requireEntries()[r1] = r2;
    }
}
