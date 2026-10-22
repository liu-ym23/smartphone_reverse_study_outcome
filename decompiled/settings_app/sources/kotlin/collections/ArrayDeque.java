package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ArrayDeque.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 P*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001PB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u0015\b\u0016\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u0016\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0016J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004H\u0002J\u001d\u0010'\u001a\u00020\u00142\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140)H\u0082\bJ\u000b\u0010*\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010,\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u00100\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u0016\u00102\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0004H\u0083\b¢\u0006\u0002\u0010.J\u0011\u0010!\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0083\bJM\u00103\u001a\u00020\u00172>\u00104\u001a:\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u000e\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u001705H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u00020\u0014H\u0016J\u000b\u0010:\u001a\u00028\u0000¢\u0006\u0002\u0010+J\u0015\u0010;\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\r\u0010<\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0015\u0010?\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0016\u0010@\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010.J\u000b\u0010B\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010C\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u000b\u0010D\u001a\u00028\u0000¢\u0006\u0002\u0010+J\r\u0010E\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010+J\u0016\u0010F\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J\u001e\u0010G\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010HJ\u0017\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0000¢\u0006\u0004\bJ\u0010KJ)\u0010I\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0000¢\u0006\u0004\bJ\u0010NJ\u0015\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bH\u0016¢\u0006\u0002\u0010KJ'\u0010O\u001a\b\u0012\u0004\u0012\u0002HL0\u000b\"\u0004\b\u0001\u0010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002HL0\u000bH\u0016¢\u0006\u0002\u0010NR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006Q"}, d2 = {"Lkotlin/collections/ArrayDeque;", "E", "Lkotlin/collections/AbstractMutableList;", "initialCapacity", "", "(I)V", "()V", "elements", "", "(Ljava/util/Collection;)V", "elementData", "", "", "[Ljava/lang/Object;", "head", "<set-?>", PerfConsts.PERF_DISK_FILE_SIZE, "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "addFirst", "(Ljava/lang/Object;)V", "addLast", "clear", "contains", "copyCollectionElements", "internalIndex", "copyElements", "newCapacity", "decremented", "ensureCapacity", "minCapacity", "filterInPlace", "predicate", "Lkotlin/Function1;", "first", "()Ljava/lang/Object;", "firstOrNull", "get", "(I)Ljava/lang/Object;", "incremented", "indexOf", "(Ljava/lang/Object;)I", "internalGet", "internalStructure", "structure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "internalStructure$kotlin_stdlib", "isEmpty", "last", "lastIndexOf", "lastOrNull", "negativeMod", "positiveMod", "remove", "removeAll", "removeAt", "removeFirst", "removeFirstOrNull", "removeLast", "removeLastOrNull", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "testToArray", "testToArray$kotlin_stdlib", "()[Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toArray", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final Companion Companion = null;
    private static final int defaultMinCapacity = 10;
    private static final Object[] emptyElementData = null;
    private Object[] elementData;
    private int head;
    private int size;

    /* JADX INFO: compiled from: ArrayDeque.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/collections/ArrayDeque$Companion;", "", "()V", "defaultMinCapacity", "", "emptyElementData", "", "[Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    public ArrayDeque(int r3) {
        if (r3 != 0) goto L5;
        Object[] r4 = emptyElementData;
    L7:
        this.elementData = r4;
        return;
    L5:
        if (r3 <= 0) goto L10;
        r4 = new Object[r3];
        goto L7
    L10:
        throw new IllegalArgumentException("Illegal Capacity: " + r3);
    }

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    public ArrayDeque(Collection<? extends E> r3) {
        Intrinsics.checkNotNullParameter(r3, "elements");
        boolean r0 = false;
        Object[] r4 = r3.toArray(new Object[0]);
        this.elementData = r4;
        this.size = r4.length;
        if (r4.length != 0) goto L5;
        r0 = true;
    L5:
        if (r0 == false) goto L8;
        this.elementData = emptyElementData;
        return;
    }

    private final void ensureCapacity(int r3) {
        if (r3 < 0) goto L13;
        Object[] r0 = this.elementData;
        if (r3 > r0.length) goto L7;
        return;
    L7:
        if (r0 != emptyElementData) goto L10;
        this.elementData = new Object[RangesKt.coerceAtLeast(r3, 10)];
        return;
    L10:
        copyElements(AbstractList.Companion.newCapacity$kotlin_stdlib(this.elementData.length, r3));
        return;
    L13:
        throw new IllegalStateException("Deque is too big.");
    }

    private final void copyElements(int r5) {
        Object[] r6 = new Object[r5];
        Object[] r0 = this.elementData;
        ArraysKt.copyInto(r0, r6, 0, this.head, r0.length);
        Object[] r1 = this.elementData;
        int r2 = r1.length;
        int r3 = this.head;
        ArraysKt.copyInto(r1, r6, r2 - r3, 0, r3);
        this.head = 0;
        this.elementData = r6;
    }

    private final E internalGet(int r1) {
        return (E) this.elementData[r1];
    }

    private final int positiveMod(int r2) {
        Object[] r1 = this.elementData;
        if (r2 >= r1.length) goto L5;
        return r2;
    L5:
        return r2 - r1.length;
    }

    private final int negativeMod(int r1) {
        if (r1 < 0) goto L4;
        return r1;
    L4:
        return r1 + this.elementData.length;
    }

    private final int internalIndex(int r2) {
        return positiveMod(this.head + r2);
    }

    private final int incremented(int r1) {
        if (r1 != ArraysKt.getLastIndex(this.elementData)) goto L6;
        return 0;
    L6:
        return r1 + 1;
    }

    private final int decremented(int r1) {
        if (r1 != 0) goto L5;
        return ArraysKt.getLastIndex(this.elementData);
    L5:
        return r1 - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final E first() {
        if (isEmpty() == true) goto L7;
        return (E) this.elementData[this.head];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E firstOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.elementData[this.head];
    }

    public final E last() {
        if (isEmpty() == true) goto L7;
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E lastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return (E) this.elementData[positiveMod(this.head + CollectionsKt.getLastIndex(this))];
    }

    public final void addFirst(E r3) {
        ensureCapacity(size() + 1);
        int r0 = decremented(this.head);
        this.head = r0;
        this.elementData[r0] = r3;
        this.size = size() + 1;
    }

    public final void addLast(E r4) {
        ensureCapacity(size() + 1);
        this.elementData[positiveMod(this.head + size())] = r4;
        this.size = size() + 1;
    }

    public final E removeFirst() {
        if (isEmpty() == true) goto L7;
        Object[] r0 = this.elementData;
        int r1 = this.head;
        E r2 = (E) r0[r1];
        r0[r1] = null;
        this.head = incremented(r1);
        this.size = size() - 1;
        return r2;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeFirstOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeFirst();
    }

    public final E removeLast() {
        if (isEmpty() == true) goto L7;
        int r0 = positiveMod(this.head + CollectionsKt.getLastIndex(this));
        Object[] r1 = this.elementData;
        E r2 = (E) r1[r0];
        r1[r0] = null;
        this.size = size() - 1;
        return r2;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLastOrNull() {
        if (isEmpty() == false) goto L6;
        return null;
    L6:
        return removeLast();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E r1) {
        addLast(r1);
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r8, E r9) {
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r8, size());
        if (r8 != size()) goto L6;
        addLast(r9);
        return;
    L6:
        if (r8 != 0) goto L9;
        addFirst(r9);
        return;
    L9:
        ensureCapacity(size() + 1);
        int r0 = positiveMod(this.head + r8);
        if (r8 >= ((size() + 1) >> 1)) goto L16;
        int r10 = decremented(r0);
        int r1 = decremented(this.head);
        int r2 = this.head;
        if (r10 < r2) goto L14;
        Object[] r3 = this.elementData;
        r3[r1] = r3[r2];
        ArraysKt.copyInto(r3, r3, r2, r2 + 1, r10 + 1);
    L15:
        this.elementData[r10] = r9;
        this.head = r1;
    L21:
        this.size = size() + 1;
        return;
    L14:
        Object[] r4 = this.elementData;
        ArraysKt.copyInto(r4, r4, r2 - 1, r2, r4.length);
        Object[] r5 = this.elementData;
        r5[r5.length - 1] = r5[0];
        ArraysKt.copyInto(r5, r5, 0, 1, r10 + 1);
        goto L15
    L16:
        int r11 = positiveMod(this.head + size());
        if (r0 >= r11) goto L19;
        Object[] r6 = this.elementData;
        ArraysKt.copyInto(r6, r6, r0 + 1, r0, r11);
    L20:
        this.elementData[r0] = r9;
        goto L21
    L19:
        Object[] r7 = this.elementData;
        ArraysKt.copyInto(r7, r7, 1, 0, r11);
        Object[] r12 = this.elementData;
        r12[0] = r12[r12.length - 1];
        ArraysKt.copyInto(r12, r12, r0 + 1, r0, r12.length - 1);
        goto L20
    }

    private final void copyCollectionElements(int r5, Collection<? extends E> r6) {
        Iterator<? extends E> r0 = r6.iterator();
        int r1 = this.elementData.length;
    L3:
        if (r5 >= r1) goto L7;
        if (r0.hasNext() == false) goto L7;
        this.elementData[r5] = r0.next();
        r5 = r5 + 1;
    L7:
        int r7 = this.head;
        int r2 = 0;
    L8:
        if (r2 >= r7) goto L12;
        if (r0.hasNext() == false) goto L12;
        this.elementData[r2] = r0.next();
        r2 = r2 + 1;
    L12:
        this.size = size() + r6.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> r3) {
        Intrinsics.checkNotNullParameter(r3, "elements");
        if (r3.isEmpty() == false) goto L6;
        return false;
    L6:
        ensureCapacity(size() + r3.size());
        copyCollectionElements(positiveMod(this.head + size()), r3);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int r9, Collection<? extends E> r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r9, size());
        if (r10.isEmpty() == false) goto L6;
        return false;
    L6:
        if (r9 == size()) goto L8;
        ensureCapacity(size() + r10.size());
        int r0 = positiveMod(this.head + size());
        int r2 = positiveMod(this.head + r9);
        int r3 = r10.size();
        if (r9 >= ((size() + 1) >> 1)) goto L24;
        int r11 = this.head;
        int r1 = r11 - r3;
        if (r2 < r11) goto L19;
        if (r1 < 0) goto L15;
        Object[] r4 = this.elementData;
        ArraysKt.copyInto(r4, r4, r1, r11, r2);
    L23:
        this.head = r1;
        copyCollectionElements(negativeMod(r2 - r3), r10);
    L38:
        return true;
    L15:
        Object[] r5 = this.elementData;
        r1 = r1 + r5.length;
        int r6 = r2 - r11;
        int r7 = r5.length - r1;
        if (r7 < r6) goto L18;
        ArraysKt.copyInto(r5, r5, r1, r11, r2);
        goto L23
    L18:
        ArraysKt.copyInto(r5, r5, r1, r11, r11 + r7);
        Object[] r12 = this.elementData;
        ArraysKt.copyInto(r12, r12, 0, this.head + r7, r2);
        goto L23
    L19:
        Object[] r8 = this.elementData;
        ArraysKt.copyInto(r8, r8, r1, r11, r8.length);
        if (r3 < r2) goto L22;
        Object[] r13 = this.elementData;
        ArraysKt.copyInto(r13, r13, r13.length - r3, 0, r2);
        goto L23
    L22:
        Object[] r14 = this.elementData;
        ArraysKt.copyInto(r14, r14, r14.length - r3, 0, r3);
        Object[] r15 = this.elementData;
        ArraysKt.copyInto(r15, r15, 0, r3, r2);
        goto L23
    L24:
        int r16 = r2 + r3;
        if (r2 >= r0) goto L33;
        int r17 = r3 + r0;
        Object[] r18 = this.elementData;
        if (r17 > r18.length) goto L30;
        ArraysKt.copyInto(r18, r18, r16, r2, r0);
    L37:
        copyCollectionElements(r2, r10);
        goto L38
    L30:
        if (r16 < r18.length) goto L32;
        ArraysKt.copyInto(r18, r18, r16 - r18.length, r2, r0);
        goto L37
    L32:
        int r19 = r0 - (r17 - r18.length);
        ArraysKt.copyInto(r18, r18, 0, r19, r0);
        Object[] r20 = this.elementData;
        ArraysKt.copyInto(r20, r20, r16, r2, r19);
        goto L37
    L33:
        Object[] r21 = this.elementData;
        ArraysKt.copyInto(r21, r21, r3, 0, r0);
        Object[] r22 = this.elementData;
        if (r16 < r22.length) goto L36;
        ArraysKt.copyInto(r22, r22, r16 - r22.length, r2, r22.length);
        goto L37
    L36:
        ArraysKt.copyInto(r22, r22, 0, r22.length - r3, r22.length);
        Object[] r23 = this.elementData;
        ArraysKt.copyInto(r23, r23, r16, r2, r23.length - r3);
        goto L37
    L8:
        return addAll(r10);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r3) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, size());
        return (E) this.elementData[positiveMod(this.head + r3)];
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public E set(int r3, E r4) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r3, size());
        int r5 = positiveMod(this.head + r3);
        Object[] r2 = this.elementData;
        E r0 = (E) r2[r5];
        r2[r5] = r4;
        return r0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r5) {
        int r0 = positiveMod(this.head + size());
        int r1 = this.head;
        if (r1 >= r0) goto L11;
    L4:
        if (r1 >= r0) goto L32;
        if (Intrinsics.areEqual(r5, this.elementData[r1]) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        int r4 = this.head;
    L9:
        return r1 - r4;
    L32:
        return -1;
    L11:
        if (r1 < r0) goto L24;
        int r2 = this.elementData.length;
    L13:
        if (r1 >= r2) goto L18;
        if (Intrinsics.areEqual(r5, this.elementData[r1]) == true) goto L16;
        r1 = r1 + 1;
        goto L13
    L16:
        r4 = this.head;
        goto L9
    L18:
        int r3 = 0;
    L19:
        if (r3 >= r0) goto L33;
        if (Intrinsics.areEqual(r5, this.elementData[r3]) == true) goto L22;
        r3 = r3 + 1;
        goto L19
    L22:
        r1 = r3 + this.elementData.length;
        r4 = this.head;
        goto L9
    L33:
        return -1;
    L24:
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r5) {
        int r0 = positiveMod(this.head + size());
        int r1 = this.head;
        if (r1 >= r0) goto L13;
        int r2 = r0 - 1;
        if (r1 <= r2) goto L7;
    L27:
        return -1;
    L7:
        if (Intrinsics.areEqual(r5, this.elementData[r2]) == true) goto L8;
        if (r2 == r1) goto L27;
        r2 = r2 - 1;
        goto L7
    L8:
        int r4 = this.head;
    L10:
        return r2 - r4;
    L13:
        if (r1 <= r0) goto L27;
        int r3 = r0 - 1;
    L15:
        if ((-1) >= r3) goto L20;
        if (Intrinsics.areEqual(r5, this.elementData[r3]) == true) goto L18;
        r3 = r3 - 1;
        goto L15
    L18:
        r2 = r3 + this.elementData.length;
        r4 = this.head;
        goto L10
    L20:
        r2 = ArraysKt.getLastIndex(this.elementData);
        int r6 = this.head;
        if (r6 > r2) goto L27;
    L23:
        if (Intrinsics.areEqual(r5, this.elementData[r2]) == true) goto L24;
        if (r2 == r6) goto L27;
        r2 = r2 - 1;
        goto L23
    L24:
        r4 = this.head;
        goto L10
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r2) {
        int r3 = indexOf(r2);
        if (r3 != (-1)) goto L6;
        return false;
    L6:
        remove(r3);
        return true;
    }

    @Override // kotlin.collections.AbstractMutableList
    public E removeAt(int r9) {
        AbstractList.Companion.checkElementIndex$kotlin_stdlib(r9, size());
        ArrayDeque<E> r0 = this;
        if (r9 == CollectionsKt.getLastIndex(r0)) goto L5;
        if (r9 == 0) goto L8;
        int r1 = positiveMod(this.head + r9);
        E r2 = (E) this.elementData[r1];
        if (r9 >= (size() >> 1)) goto L16;
        int r10 = this.head;
        if (r1 < r10) goto L14;
        Object[] r3 = this.elementData;
        ArraysKt.copyInto(r3, r3, r10 + 1, r10, r1);
    L15:
        Object[] r11 = this.elementData;
        int r4 = this.head;
        r11[r4] = null;
        this.head = incremented(r4);
    L21:
        this.size = size() - 1;
        return r2;
    L14:
        Object[] r12 = this.elementData;
        ArraysKt.copyInto(r12, r12, 1, 0, r1);
        Object[] r13 = this.elementData;
        r13[0] = r13[r13.length - 1];
        int r5 = this.head;
        ArraysKt.copyInto(r13, r13, r5 + 1, r5, r13.length - 1);
        goto L15
    L16:
        int r14 = positiveMod(this.head + CollectionsKt.getLastIndex(r0));
        if (r1 > r14) goto L19;
        Object[] r6 = this.elementData;
        ArraysKt.copyInto(r6, r6, r1, r1 + 1, r14 + 1);
    L20:
        this.elementData[r14] = null;
        goto L21
    L19:
        Object[] r7 = this.elementData;
        ArraysKt.copyInto(r7, r7, r1, r1 + 1, r7.length);
        Object[] r8 = this.elementData;
        r8[r8.length - 1] = r8[0];
        ArraysKt.copyInto(r8, r8, 0, 1, r14 + 1);
        goto L20
    L8:
        return removeFirst();
    L5:
        return removeLast();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean filterInPlace(Function1<? super E, Boolean> r12) {
        boolean r1 = false;
        r1 = false;
        int r2 = 0;
        r1 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r1;
    L5:
        if (this.elementData.length != 0) goto L7;
        Object[] r0 = true;
    L8:
        if (r0 == true) goto L37;
        int r3 = positiveMod(this.head + size());
        int r4 = this.head;
        if (r4 >= r3) goto L20;
        int r5 = r4;
    L13:
        if (r4 >= r3) goto L19;
        Object r6 = this.elementData[r4];
        if (r12.invoke(r6).booleanValue() == false) goto L17;
        this.elementData[r5] = r6;
        r5 = r5 + 1;
    L18:
        r4 = r4 + 1;
        goto L13
    L17:
        r1 = true;
        goto L18
    L19:
        ArraysKt.fill(this.elementData, null, r5, r3);
    L35:
        if (r1 == false) goto L37;
        this.size = negativeMod(r5 - this.head);
        goto L37
    L20:
        int r7 = this.elementData.length;
        boolean r8 = false;
        int r9 = r4;
    L21:
        if (r4 >= r7) goto L27;
        Object[] r10 = this.elementData;
        Object r11 = r10[r4];
        r10[r4] = null;
        if (r12.invoke(r11).booleanValue() == false) goto L25;
        this.elementData[r9] = r11;
        r9 = r9 + 1;
    L26:
        r4 = r4 + 1;
        goto L21
    L25:
        r8 = true;
        goto L26
    L27:
        r5 = positiveMod(r9);
    L28:
        if (r2 >= r3) goto L34;
        Object[] r13 = this.elementData;
        Object r14 = r13[r2];
        r13[r2] = null;
        if (r12.invoke(r14).booleanValue() == false) goto L32;
        this.elementData[r5] = r14;
        r5 = incremented(r5);
    L33:
        r2 = r2 + 1;
        goto L28
    L32:
        r8 = true;
        goto L33
    L34:
        r1 = r8;
        goto L35
    L7:
        r0 = false;
        goto L8
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int r0 = positiveMod(this.head + size());
        int r1 = this.head;
        if (r1 >= r0) goto L6;
        ArraysKt.fill(this.elementData, null, r1, r0);
    L8:
        this.head = 0;
        this.size = 0;
        return;
    L6:
        if ((!isEmpty()) == false) goto L8;
        Object[] r2 = this.elementData;
        ArraysKt.fill(r2, null, this.head, r2.length);
        ArraysKt.fill(this.elementData, null, 0, r0);
        goto L8
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r8) {
        Intrinsics.checkNotNullParameter(r8, "array");
        if (r8.length >= size()) goto L6;
        r8 = (T[]) ArraysKt.arrayOfNulls(r8, size());
    L6:
        int r4 = positiveMod(this.head + size());
        int r3 = this.head;
        if (r3 >= r4) goto L10;
        ArraysKt.copyInto$default(this.elementData, r8, 0, r3, r4, 2, null);
    L13:
        return (T[]) CollectionsKt.terminateCollectionToArray(size(), r8);
    L10:
        if ((!isEmpty()) == false) goto L13;
        Object[] r0 = this.elementData;
        ArraysKt.copyInto(r0, r8, 0, this.head, r0.length);
        Object[] r1 = this.elementData;
        ArraysKt.copyInto(r1, r8, r1.length - this.head, 0, r4);
        goto L13
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public final <T> T[] testToArray$kotlin_stdlib(T[] r2) {
        Intrinsics.checkNotNullParameter(r2, "array");
        return (T[]) toArray(r2);
    }

    public final Object[] testToArray$kotlin_stdlib() {
        return toArray();
    }

    static {
        Companion = new Companion(null);
        emptyElementData = new Object[0];
    }

    public final void internalStructure$kotlin_stdlib(Function2<? super Integer, ? super Object[], Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "structure");
        int r0 = positiveMod(this.head + size());
        if (isEmpty() == true) goto L8;
        int r1 = this.head;
        if (r1 < r0) goto L8;
        int r2 = r1 - this.elementData.length;
    L9:
        r3.invoke(Integer.valueOf(r2), toArray());
        return;
    L8:
        r2 = this.head;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "elements");
        boolean r1 = false;
        r1 = false;
        int r2 = 0;
        r1 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r1;
    L5:
        if (this.elementData.length != 0) goto L7;
        Object[] r0 = true;
    L8:
        if (r0 == true) goto L37;
        int r3 = positiveMod(this.head + size());
        int r4 = this.head;
        if (r4 >= r3) goto L20;
        int r5 = r4;
    L13:
        if (r4 >= r3) goto L19;
        Object r6 = this.elementData[r4];
        if ((!r12.contains(r6)) == false) goto L17;
        this.elementData[r5] = r6;
        r5 = r5 + 1;
    L18:
        r4 = r4 + 1;
        goto L13
    L17:
        r1 = true;
        goto L18
    L19:
        ArraysKt.fill(this.elementData, null, r5, r3);
    L35:
        if (r1 == false) goto L37;
        this.size = negativeMod(r5 - this.head);
        goto L37
    L20:
        int r7 = this.elementData.length;
        boolean r8 = false;
        int r9 = r4;
    L21:
        if (r4 >= r7) goto L27;
        Object[] r10 = this.elementData;
        Object r11 = r10[r4];
        r10[r4] = null;
        if ((!r12.contains(r11)) == false) goto L25;
        this.elementData[r9] = r11;
        r9 = r9 + 1;
    L26:
        r4 = r4 + 1;
        goto L21
    L25:
        r8 = true;
        goto L26
    L27:
        r5 = positiveMod(r9);
    L28:
        if (r2 >= r3) goto L34;
        Object[] r13 = this.elementData;
        Object r14 = r13[r2];
        r13[r2] = null;
        if ((!r12.contains(r14)) == false) goto L32;
        this.elementData[r5] = r14;
        r5 = incremented(r5);
    L33:
        r2 = r2 + 1;
        goto L28
    L32:
        r8 = true;
        goto L33
    L34:
        r1 = r8;
        goto L35
    L7:
        r0 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> r12) {
        Intrinsics.checkNotNullParameter(r12, "elements");
        boolean r1 = false;
        r1 = false;
        int r2 = 0;
        r1 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r1;
    L5:
        if (this.elementData.length != 0) goto L7;
        Object[] r0 = true;
    L8:
        if (r0 == true) goto L37;
        int r3 = positiveMod(this.head + size());
        int r4 = this.head;
        if (r4 >= r3) goto L20;
        int r5 = r4;
    L13:
        if (r4 >= r3) goto L19;
        Object r6 = this.elementData[r4];
        if (r12.contains(r6) == false) goto L17;
        this.elementData[r5] = r6;
        r5 = r5 + 1;
    L18:
        r4 = r4 + 1;
        goto L13
    L17:
        r1 = true;
        goto L18
    L19:
        ArraysKt.fill(this.elementData, null, r5, r3);
    L35:
        if (r1 == false) goto L37;
        this.size = negativeMod(r5 - this.head);
        goto L37
    L20:
        int r7 = this.elementData.length;
        boolean r8 = false;
        int r9 = r4;
    L21:
        if (r4 >= r7) goto L27;
        Object[] r10 = this.elementData;
        Object r11 = r10[r4];
        r10[r4] = null;
        if (r12.contains(r11) == false) goto L25;
        this.elementData[r9] = r11;
        r9 = r9 + 1;
    L26:
        r4 = r4 + 1;
        goto L21
    L25:
        r8 = true;
        goto L26
    L27:
        r5 = positiveMod(r9);
    L28:
        if (r2 >= r3) goto L34;
        Object[] r13 = this.elementData;
        Object r14 = r13[r2];
        r13[r2] = null;
        if (r12.contains(r14) == false) goto L32;
        this.elementData[r5] = r14;
        r5 = incremented(r5);
    L33:
        r2 = r2 + 1;
        goto L28
    L32:
        r8 = true;
        goto L33
    L34:
        r1 = r8;
        goto L35
    L7:
        r0 = false;
        goto L8
    }
}
