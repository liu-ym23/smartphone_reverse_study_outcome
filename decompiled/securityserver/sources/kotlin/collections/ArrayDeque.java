package kotlin.collections;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@WasExperimental
public final class ArrayDeque<E> extends AbstractMutableList<E> {
    public static final Object[] f = null;
    public int b;
    public Object[] c;
    public int e;

    @Metadata
    public static final class Companion {
    }

    static {
        f = new Object[0];
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int a() {
        return this.e;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object r1) {
        addLast(r1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection r3) {
        Intrinsics.f(r3, "elements");
        if (r3.isEmpty() == false) goto L6;
        return false;
    L6:
        int r0 = a();
        d(r3.size() + r0);
        int r1 = this.b;
        c(f(a() + r1), r3);
        return true;
    }

    public final void addFirst(Object r3) {
        d(this.e + 1);
        int r0 = this.b;
        if (r0 != 0) goto L5;
        Object[] r1 = this.c;
        Intrinsics.f(r1, "<this>");
        r0 = r1.length;
    L5:
        int r2 = r0 - 1;
        this.b = r2;
        this.c[r2] = r3;
        this.e++;
    }

    public final void addLast(Object r4) {
        d(a() + 1);
        Object[] r0 = this.c;
        int r1 = this.b;
        r0[f(a() + r1)] = r4;
        this.e = a() + 1;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object b(int r9) {
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.a(r9, r1);
        if (r9 == CollectionsKt.f(this)) goto L5;
        if (r9 == 0) goto L8;
        int r2 = f(this.b + r9);
        Object[] r3 = this.c;
        Object r4 = r3[r2];
        if (r9 >= (this.e >> 1)) goto L16;
        int r10 = this.b;
        if (r2 < r10) goto L14;
        ArraysKt.h(r3, r3, r10 + 1, r10, r2);
    L15:
        Object[] r11 = this.c;
        int r5 = this.b;
        r11[r5] = null;
        this.b = e(r5);
    L21:
        this.e--;
        return r4;
    L14:
        ArraysKt.h(r3, r3, 1, 0, r2);
        Object[] r12 = this.c;
        r12[0] = r12[r12.length - 1];
        int r6 = this.b;
        ArraysKt.h(r12, r12, r6 + 1, r6, r12.length - 1);
        goto L15
    L16:
        int r13 = f(CollectionsKt.f(this) + this.b);
        if (r2 > r13) goto L19;
        Object[] r7 = this.c;
        ArraysKt.h(r7, r7, r2, r2 + 1, r13 + 1);
    L20:
        this.c[r13] = null;
        goto L21
    L19:
        Object[] r8 = this.c;
        ArraysKt.h(r8, r8, r2, r2 + 1, r8.length);
        Object[] r14 = this.c;
        r14[r14.length - 1] = r14[0];
        ArraysKt.h(r14, r14, 0, 1, r13 + 1);
        goto L20
    L8:
        return removeFirst();
    L5:
        return removeLast();
    }

    public final void c(int r5, Collection r6) {
        Iterator<E> r0 = r6.iterator();
        int r1 = this.c.length;
    L3:
        if (r5 >= r1) goto L7;
        if (r0.hasNext() == false) goto L7;
        this.c[r5] = r0.next();
        r5 = r5 + 1;
    L7:
        int r7 = this.b;
        int r2 = 0;
    L8:
        if (r2 >= r7) goto L12;
        if (r0.hasNext() == false) goto L12;
        this.c[r2] = r0.next();
        r2 = r2 + 1;
    L12:
        int r8 = a();
        this.e = r6.size() + r8;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int r0 = f(a() + this.b);
        int r1 = this.b;
        if (r1 >= r0) goto L6;
        ArraysKt.l(null, this.c, r1, r0);
    L8:
        this.b = 0;
        this.e = 0;
        return;
    L6:
        if ((!isEmpty()) == false) goto L8;
        Object[] r2 = this.c;
        ArraysKt.l(null, r2, this.b, r2.length);
        ArraysKt.l(null, this.c, 0, r0);
        goto L8
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(int r5) {
        if (r5 < 0) goto L24;
        Object[] r0 = this.c;
        if (r5 > r0.length) goto L7;
        return;
    L7:
        if (r0 == f) goto L9;
        int r1 = r0.length;
        int r2 = r1 + (r1 >> 1);
        if ((r2 - r5) >= 0) goto L17;
        r2 = r5;
    L17:
        if ((r2 - 2147483639) <= 0) goto L21;
        if (r5 <= 2147483639) goto L20;
        r2 = Integer.MAX_VALUE;
        goto L21
    L20:
        r2 = 2147483639;
    L21:
        Object[] r6 = new Object[r2];
        ArraysKt.h(r0, r6, 0, this.b, r0.length);
        Object[] r3 = this.c;
        int r4 = r3.length;
        int r7 = this.b;
        ArraysKt.h(r3, r6, r4 - r7, 0, r7);
        this.b = 0;
        this.c = r6;
        return;
    L9:
        if (r5 >= 10) goto L11;
        r5 = 10;
    L11:
        this.c = new Object[r5];
        return;
    L24:
        throw new IllegalStateException("Deque is too big.");
    }

    public final int e(int r2) {
        Object[] r1 = this.c;
        Intrinsics.f(r1, "<this>");
        if (r2 != (r1.length - 1)) goto L6;
        return 0;
    L6:
        return r2 + 1;
    }

    public final int f(int r2) {
        Object[] r1 = this.c;
        if (r2 >= r1.length) goto L5;
        return r2;
    L5:
        return r2 - r1.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int r3) {
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.a(r3, r1);
        return this.c[f(this.b + r3)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object r5) {
        int r0 = this.b;
        int r1 = f(a() + r0);
        int r2 = this.b;
        if (r2 >= r1) goto L11;
    L4:
        if (r2 >= r1) goto L32;
        if (Intrinsics.a(r5, this.c[r2]) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        int r4 = this.b;
    L9:
        return r2 - r4;
    L32:
        return -1;
    L11:
        if (r2 < r1) goto L24;
        int r3 = this.c.length;
    L13:
        if (r2 >= r3) goto L18;
        if (Intrinsics.a(r5, this.c[r2]) == true) goto L16;
        r2 = r2 + 1;
        goto L13
    L16:
        r4 = this.b;
        goto L9
    L18:
        int r6 = 0;
    L19:
        if (r6 >= r1) goto L33;
        if (Intrinsics.a(r5, this.c[r6]) == true) goto L22;
        r6 = r6 + 1;
        goto L19
    L22:
        r2 = r6 + this.c.length;
        r4 = this.b;
        goto L9
    L33:
        return -1;
    L24:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (a() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object r5) {
        int r0 = f(this.e + this.b);
        int r1 = this.b;
        if (r1 >= r0) goto L13;
        int r2 = r0 - 1;
        if (r1 <= r2) goto L7;
    L27:
        return -1;
    L7:
        if (Intrinsics.a(r5, this.c[r2]) == true) goto L8;
        if (r2 == r1) goto L27;
        r2 = r2 - 1;
        goto L7
    L8:
        int r4 = this.b;
    L10:
        return r2 - r4;
    L13:
        if (r1 <= r0) goto L27;
        int r3 = r0 - 1;
    L15:
        if ((-1) >= r3) goto L20;
        if (Intrinsics.a(r5, this.c[r3]) == true) goto L18;
        r3 = r3 - 1;
        goto L15
    L18:
        r2 = r3 + this.c.length;
        r4 = this.b;
        goto L10
    L20:
        Object[] r6 = this.c;
        Intrinsics.f(r6, "<this>");
        r2 = r6.length - 1;
        int r7 = this.b;
        if (r7 > r2) goto L27;
    L23:
        if (Intrinsics.a(r5, this.c[r2]) == true) goto L24;
        if (r2 == r7) goto L27;
        r2 = r2 - 1;
        goto L23
    L24:
        r4 = this.b;
        goto L10
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object r2) {
        int r3 = indexOf(r2);
        if (r3 != (-1)) goto L6;
        return false;
    L6:
        b(r3);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection r12) {
        Intrinsics.f(r12, "elements");
        boolean r1 = false;
        r1 = false;
        int r2 = 0;
        r1 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r1;
    L5:
        if (this.c.length == 0) goto L37;
        int r0 = f(this.e + this.b);
        int r3 = this.b;
        if (r3 >= r0) goto L17;
        int r5 = r3;
    L10:
        if (r3 >= r0) goto L16;
        Object r6 = this.c[r3];
        if ((!r12.contains(r6)) == false) goto L14;
        this.c[r5] = r6;
        r5 = r5 + 1;
    L15:
        r3 = r3 + 1;
        goto L10
    L14:
        r1 = true;
        goto L15
    L16:
        ArraysKt.l(null, this.c, r5, r0);
    L32:
        if (r1 == false) goto L37;
        int r7 = r5 - this.b;
        if (r7 >= 0) goto L36;
        r7 = r7 + this.c.length;
    L36:
        this.e = r7;
        goto L37
    L17:
        int r8 = this.c.length;
        boolean r9 = false;
        int r10 = r3;
    L18:
        if (r3 >= r8) goto L24;
        Object[] r11 = this.c;
        Object r13 = r11[r3];
        r11[r3] = null;
        if ((!r12.contains(r13)) == false) goto L22;
        this.c[r10] = r13;
        r10 = r10 + 1;
    L23:
        r3 = r3 + 1;
        goto L18
    L22:
        r9 = true;
        goto L23
    L24:
        r5 = f(r10);
    L25:
        if (r2 >= r0) goto L31;
        Object[] r4 = this.c;
        Object r14 = r4[r2];
        r4[r2] = null;
        if ((!r12.contains(r14)) == false) goto L29;
        this.c[r5] = r14;
        r5 = e(r5);
    L30:
        r2 = r2 + 1;
        goto L25
    L29:
        r9 = true;
        goto L30
    L31:
        r1 = r9;
        goto L32
    }

    public final Object removeFirst() {
        if (isEmpty() == true) goto L7;
        Object[] r0 = this.c;
        int r1 = this.b;
        Object r2 = r0[r1];
        r0[r1] = null;
        this.b = e(r1);
        this.e = a() - 1;
        return r2;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object removeLast() {
        if (isEmpty() == true) goto L7;
        int r0 = f(CollectionsKt.f(this) + this.b);
        Object[] r1 = this.c;
        Object r2 = r1[r0];
        r1[r0] = null;
        this.e = a() - 1;
        return r2;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection r12) {
        Intrinsics.f(r12, "elements");
        boolean r1 = false;
        r1 = false;
        int r2 = 0;
        r1 = false;
        if (isEmpty() == false) goto L5;
    L37:
        return r1;
    L5:
        if (this.c.length == 0) goto L37;
        int r0 = f(this.e + this.b);
        int r3 = this.b;
        if (r3 >= r0) goto L17;
        int r5 = r3;
    L10:
        if (r3 >= r0) goto L16;
        Object r6 = this.c[r3];
        if (r12.contains(r6) == false) goto L14;
        this.c[r5] = r6;
        r5 = r5 + 1;
    L15:
        r3 = r3 + 1;
        goto L10
    L14:
        r1 = true;
        goto L15
    L16:
        ArraysKt.l(null, this.c, r5, r0);
    L32:
        if (r1 == false) goto L37;
        int r7 = r5 - this.b;
        if (r7 >= 0) goto L36;
        r7 = r7 + this.c.length;
    L36:
        this.e = r7;
        goto L37
    L17:
        int r8 = this.c.length;
        boolean r9 = false;
        int r10 = r3;
    L18:
        if (r3 >= r8) goto L24;
        Object[] r11 = this.c;
        Object r13 = r11[r3];
        r11[r3] = null;
        if (r12.contains(r13) == false) goto L22;
        this.c[r10] = r13;
        r10 = r10 + 1;
    L23:
        r3 = r3 + 1;
        goto L18
    L22:
        r9 = true;
        goto L23
    L24:
        r5 = f(r10);
    L25:
        if (r2 >= r0) goto L31;
        Object[] r4 = this.c;
        Object r14 = r4[r2];
        r4[r2] = null;
        if (r12.contains(r14) == false) goto L29;
        this.c[r5] = r14;
        r5 = e(r5);
    L30:
        r2 = r2 + 1;
        goto L25
    L29:
        r9 = true;
        goto L30
    L31:
        r1 = r9;
        goto L32
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int r3, Object r4) {
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.a(r3, r1);
        int r5 = f(this.b + r3);
        Object[] r2 = this.c;
        Object r6 = r2[r5];
        r2[r5] = r4;
        return r6;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r8, Object r9) {
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.b(r8, r1);
        int r2 = this.e;
        if (r8 != r2) goto L6;
        addLast(r9);
        return;
    L6:
        if (r8 != 0) goto L9;
        addFirst(r9);
        return;
    L9:
        d(r2 + 1);
        int r3 = f(this.b + r8);
        int r4 = this.e;
        if (r8 < ((r4 + 1) >> 1)) goto L12;
        int r10 = f(r4 + this.b);
        if (r3 >= r10) goto L26;
        Object[] r5 = this.c;
        ArraysKt.h(r5, r5, r3 + 1, r3, r10);
    L27:
        this.c[r3] = r9;
    L28:
        this.e++;
        return;
    L26:
        Object[] r6 = this.c;
        ArraysKt.h(r6, r6, 1, 0, r10);
        Object[] r11 = this.c;
        r11[0] = r11[r11.length - 1];
        ArraysKt.h(r11, r11, r3 + 1, r3, r11.length - 1);
        goto L27
    L12:
        if (r3 != 0) goto L14;
        Object[] r7 = this.c;
        Intrinsics.f(r7, "<this>");
        r3 = r7.length;
    L14:
        int r12 = r3 - 1;
        int r13 = this.b;
        if (r13 != 0) goto L17;
        Object[] r14 = this.c;
        Intrinsics.f(r14, "<this>");
        int r15 = r14.length - 1;
    L18:
        int r16 = this.b;
        if (r12 < r16) goto L21;
        Object[] r17 = this.c;
        r17[r15] = r17[r16];
        ArraysKt.h(r17, r17, r16, r16 + 1, r12 + 1);
    L22:
        this.c[r12] = r9;
        this.b = r15;
        goto L28
    L21:
        Object[] r18 = this.c;
        ArraysKt.h(r18, r18, r16 - 1, r16, r18.length);
        Object[] r19 = this.c;
        r19[r19.length - 1] = r19[0];
        ArraysKt.h(r19, r19, 0, 1, r12 + 1);
        goto L22
    L17:
        r15 = r13 - 1;
        goto L18
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] r7) {
        Intrinsics.f(r7, "array");
        int r0 = r7.length;
        int r1 = this.e;
        if (r0 >= r1) goto L6;
        Object r8 = Array.newInstance(r7.getClass().getComponentType(), r1);
        Intrinsics.d(r8, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        r7 = (Object[]) r8;
    L6:
        int r4 = f(this.e + this.b);
        int r3 = this.b;
        if (r3 >= r4) goto L10;
        ArraysKt.i(this.c, r7, 0, r3, r4, 2);
    L12:
        int r2 = r7.length;
        int r6 = this.e;
        if (r2 <= r6) goto L15;
        r7[r6] = null;
    L15:
        return r7;
    L10:
        if ((!isEmpty()) == false) goto L12;
        Object[] r5 = this.c;
        ArraysKt.h(r5, r7, 0, this.b, r5.length);
        Object[] r9 = this.c;
        ArraysKt.h(r9, r7, r9.length - this.b, 0, r4);
        goto L12
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int r9, Collection r10) {
        Intrinsics.f(r10, "elements");
        AbstractList.Companion r0 = AbstractList.Companion;
        int r1 = this.e;
        r0.getClass();
        AbstractList.Companion.b(r9, r1);
        if (r10.isEmpty() == false) goto L5;
        return false;
    L5:
        int r2 = this.e;
        if (r9 == r2) goto L8;
        d(r10.size() + r2);
        int r3 = this.b;
        int r4 = f(this.e + r3);
        int r5 = f(this.b + r9);
        int r6 = r10.size();
        if (r9 >= ((this.e + 1) >> 1)) goto L27;
        int r11 = this.b;
        int r7 = r11 - r6;
        if (r5 < r11) goto L19;
        if (r7 < 0) goto L15;
        Object[] r8 = this.c;
        ArraysKt.h(r8, r8, r7, r11, r5);
    L23:
        this.b = r7;
        int r12 = r5 - r6;
        if (r12 >= 0) goto L26;
        r12 = r12 + this.c.length;
    L26:
        c(r12, r10);
    L41:
        return true;
    L15:
        Object[] r13 = this.c;
        r7 = r7 + r13.length;
        int r14 = r5 - r11;
        int r15 = r13.length - r7;
        if (r15 < r14) goto L18;
        ArraysKt.h(r13, r13, r7, r11, r5);
        goto L23
    L18:
        ArraysKt.h(r13, r13, r7, r11, r11 + r15);
        Object[] r16 = this.c;
        ArraysKt.h(r16, r16, 0, this.b + r15, r5);
        goto L23
    L19:
        Object[] r17 = this.c;
        ArraysKt.h(r17, r17, r7, r11, r17.length);
        if (r6 < r5) goto L22;
        Object[] r18 = this.c;
        ArraysKt.h(r18, r18, r18.length - r6, 0, r5);
        goto L23
    L22:
        Object[] r19 = this.c;
        ArraysKt.h(r19, r19, r19.length - r6, 0, r6);
        Object[] r20 = this.c;
        ArraysKt.h(r20, r20, 0, r6, r5);
        goto L23
    L27:
        int r21 = r5 + r6;
        if (r5 >= r4) goto L36;
        int r22 = r6 + r4;
        Object[] r23 = this.c;
        if (r22 > r23.length) goto L33;
        ArraysKt.h(r23, r23, r21, r5, r4);
    L40:
        c(r5, r10);
        goto L41
    L33:
        if (r21 < r23.length) goto L35;
        ArraysKt.h(r23, r23, r21 - r23.length, r5, r4);
        goto L40
    L35:
        int r24 = r4 - (r22 - r23.length);
        ArraysKt.h(r23, r23, 0, r24, r4);
        Object[] r25 = this.c;
        ArraysKt.h(r25, r25, r21, r5, r24);
        goto L40
    L36:
        Object[] r26 = this.c;
        ArraysKt.h(r26, r26, r6, 0, r4);
        Object[] r27 = this.c;
        if (r21 < r27.length) goto L39;
        ArraysKt.h(r27, r27, r21 - r27.length, r5, r27.length);
        goto L40
    L39:
        ArraysKt.h(r27, r27, 0, r27.length - r6, r27.length);
        Object[] r28 = this.c;
        ArraysKt.h(r28, r28, r21, r5, r28.length - r6);
        goto L40
    L8:
        return addAll(r10);
    }
}
