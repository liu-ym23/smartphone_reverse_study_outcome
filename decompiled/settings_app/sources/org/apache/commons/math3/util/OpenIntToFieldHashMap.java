package org.apache.commons.math3.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: loaded from: classes6.dex */
public class OpenIntToFieldHashMap<T extends FieldElement<T>> implements Serializable {
    private static final int DEFAULT_EXPECTED_SIZE = 16;
    protected static final byte FREE = 0;
    protected static final byte FULL = 1;
    private static final float LOAD_FACTOR = 0.5f;
    private static final int PERTURB_SHIFT = 5;
    protected static final byte REMOVED = 2;
    private static final int RESIZE_MULTIPLIER = 2;
    private static final long serialVersionUID = -9179080286849120720L;
    private transient int count;
    private final Field<T> field;
    private int[] keys;
    private int mask;
    private final T missingEntries;
    private int size;
    private byte[] states;
    private T[] values;

    /* JADX INFO: renamed from: org.apache.commons.math3.util.OpenIntToFieldHashMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public class Iterator {
        private int current;
        private int next;
        private final int referenceCount;
        final /* synthetic */ OpenIntToFieldHashMap this$0;

        /* synthetic */ Iterator(OpenIntToFieldHashMap r1, AnonymousClass1 r2) {
            this(r1);
        }

        private Iterator(OpenIntToFieldHashMap r1) {
            this.this$0 = r1;
            this.referenceCount = OpenIntToFieldHashMap.access$100(r1);
            this.next = -1;
            advance();     // Catch: NoSuchElementException -> L5
            return;
        }

        public boolean hasNext() {
            if (this.next < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int key() throws ConcurrentModificationException, NoSuchElementException {
            if (this.referenceCount != OpenIntToFieldHashMap.access$100(this.this$0)) goto L11;
            if (this.current < 0) goto L9;
            return OpenIntToFieldHashMap.access$200(this.this$0)[this.current];
        L9:
            throw new NoSuchElementException();
        L11:
            throw new ConcurrentModificationException();
        }

        public T value() throws ConcurrentModificationException, NoSuchElementException {
            if (this.referenceCount != OpenIntToFieldHashMap.access$100(this.this$0)) goto L11;
            if (this.current < 0) goto L9;
            return (T) OpenIntToFieldHashMap.access$300(this.this$0)[this.current];
        L9:
            throw new NoSuchElementException();
        L11:
            throw new ConcurrentModificationException();
        }

        public void advance() throws ConcurrentModificationException, NoSuchElementException {
            if (this.referenceCount != OpenIntToFieldHashMap.access$100(this.this$0)) goto L14;
            this.current = this.next;
        L15:
            byte[] r0 = OpenIntToFieldHashMap.access$400(this.this$0);     // Catch: ArrayIndexOutOfBoundsException -> L8
            int r1 = this.next + 1;     // Catch: ArrayIndexOutOfBoundsException -> L8
            this.next = r1;     // Catch: ArrayIndexOutOfBoundsException -> L8
            if (r0[r1] != 1) goto L15;
            return;
        L8:
            this.next = -2;
            if (this.current < 0) goto L12;
            return;
        L12:
            throw new NoSuchElementException();
        L14:
            throw new ConcurrentModificationException();
        }
    }

    private static int changeIndexSign(int r0) {
        return (-r0) - 1;
    }

    private static int hashOf(int r2) {
        int r3 = r2 ^ ((r2 >>> 20) ^ (r2 >>> 12));
        int r0 = (r3 >>> 7) ^ r3;
        return (r3 >>> 4) ^ r0;
    }

    private static int perturb(int r1) {
        return r1 & Integer.MAX_VALUE;
    }

    private static int probe(int r1, int r2) {
        return (((r2 << 2) + r2) + r1) + 1;
    }

    static /* synthetic */ int access$100(OpenIntToFieldHashMap r0) {
        return r0.count;
    }

    static /* synthetic */ int[] access$200(OpenIntToFieldHashMap r0) {
        return r0.keys;
    }

    static /* synthetic */ FieldElement[] access$300(OpenIntToFieldHashMap r0) {
        return r0.values;
    }

    static /* synthetic */ byte[] access$400(OpenIntToFieldHashMap r0) {
        return r0.states;
    }

    public OpenIntToFieldHashMap(Field<T> r3) {
        this(r3, 16, r3.getZero());
    }

    public OpenIntToFieldHashMap(Field<T> r2, T r3) {
        this(r2, 16, r3);
    }

    public OpenIntToFieldHashMap(Field<T> r2, int r3) {
        this(r2, r3, r2.getZero());
    }

    public OpenIntToFieldHashMap(Field<T> r1, int r2, T r3) {
        this.field = r1;
        int r4 = computeCapacity(r2);
        this.keys = new int[r4];
        this.values = (T[]) buildArray(r4);
        this.states = new byte[r4];
        this.missingEntries = r3;
        this.mask = r4 - 1;
    }

    public OpenIntToFieldHashMap(OpenIntToFieldHashMap<T> r5) {
        this.field = r5.field;
        int r0 = r5.keys.length;
        int[] r1 = new int[r0];
        this.keys = r1;
        System.arraycopy(r5.keys, 0, r1, 0, r0);
        T[] r2 = (T[]) buildArray(r0);
        this.values = r2;
        System.arraycopy(r5.values, 0, r2, 0, r0);
        byte[] r3 = new byte[r0];
        this.states = r3;
        System.arraycopy(r5.states, 0, r3, 0, r0);
        this.missingEntries = r5.missingEntries;
        this.size = r5.size;
        this.mask = r5.mask;
        this.count = r5.count;
    }

    private static int computeCapacity(int r2) {
        if (r2 != 0) goto L5;
        return 1;
    L5:
        int r3 = (int) FastMath.ceil(r2 / 0.5f);
        if (Integer.highestOneBit(r3) != r3) goto L9;
        return r3;
    L9:
        return nextPowerOfTwo(r3);
    }

    private static int nextPowerOfTwo(int r0) {
        return Integer.highestOneBit(r0) << 1;
    }

    public T get(int r5) {
        int r0 = hashOf(r5);
        int r1 = this.mask & r0;
        if (containsKey(r5, r1) == false) goto L7;
        return this.values[r1];
    L7:
        if (this.states[r1] == 0) goto L9;
        int r2 = perturb(r0);
        int r3 = r1;
    L12:
        if (this.states[r1] == 0) goto L19;
        r3 = probe(r2, r3);
        r1 = this.mask & r3;
        if (containsKey(r5, r1) == true) goto L16;
        r2 = r2 >> 5;
        goto L12
    L16:
        return this.values[r1];
    L19:
        return this.missingEntries;
    L9:
        return this.missingEntries;
    }

    public boolean containsKey(int r7) {
        int r0 = hashOf(r7);
        int r1 = this.mask & r0;
        if (containsKey(r7, r1) == false) goto L6;
        return true;
    L6:
        if (this.states[r1] != 0) goto L8;
        return false;
    L8:
        int r2 = perturb(r0);
        int r3 = r1;
    L10:
        if (this.states[r1] == 0) goto L15;
        r3 = probe(r2, r3);
        r1 = this.mask & r3;
        if (containsKey(r7, r1) == true) goto L13;
        r2 = r2 >> 5;
        goto L10
    L13:
        return true;
    L15:
        return false;
    }

    public OpenIntToFieldHashMap<T>.Iterator iterator() {
        return new Iterator(this, null);
    }

    private int findInsertionIndex(int r3) {
        return findInsertionIndex(this.keys, this.states, r3, this.mask);
    }

    private static int findInsertionIndex(int[] r7, byte[] r8, int r9, int r10) {
        int r0 = hashOf(r9);
        int r1 = r0 & r10;
        byte r2 = r8[r1];
        if (r2 != 0) goto L6;
        return r1;
    L6:
        if (r2 == 1) goto L8;
    L11:
        int r3 = perturb(r0);
        if (r8[r1] != 1) goto L18;
    L13:
        r1 = probe(r3, r1);
        int r4 = r1 & r10;
        r3 = r3 >> 5;
        if (r8[r4] != 1) goto L17;
        if (r7[r4] != r9) goto L13;
    L17:
        int r5 = r1;
        r1 = r4;
    L19:
        byte r6 = r8[r1];
        if (r6 != 0) goto L22;
        return r1;
    L22:
        if (r6 == 1) goto L24;
    L25:
        r5 = probe(r3, r5);
        int r11 = r5 & r10;
        byte r12 = r8[r11];
        if (r12 == 0) goto L27;
        if (r12 != 1) goto L33;
        if (r7[r11] != r9) goto L33;
        return changeIndexSign(r11);
    L33:
        r3 = r3 >> 5;
        goto L25
    L27:
        return r1;
    L24:
        return changeIndexSign(r1);
    L18:
        r5 = r1;
        goto L19
    L8:
        if (r7[r1] != r9) goto L11;
        return changeIndexSign(r1);
    }

    public int size() {
        return this.size;
    }

    public T remove(int r5) {
        int r0 = hashOf(r5);
        int r1 = this.mask & r0;
        if (containsKey(r5, r1) == false) goto L7;
        return (T) doRemove(r1);
    L7:
        if (this.states[r1] == 0) goto L9;
        int r2 = perturb(r0);
        int r3 = r1;
    L12:
        if (this.states[r1] == 0) goto L19;
        r3 = probe(r2, r3);
        r1 = this.mask & r3;
        if (containsKey(r5, r1) == true) goto L16;
        r2 = r2 >> 5;
        goto L12
    L16:
        return (T) doRemove(r1);
    L19:
        return this.missingEntries;
    L9:
        return this.missingEntries;
    }

    private boolean containsKey(int r3, int r4) {
        if (r3 != 0) goto L7;
        if (this.states[r4] == 1) goto L7;
    L9:
        return false;
    L7:
        if (this.keys[r4] != r3) goto L9;
        return true;
    }

    private T doRemove(int r4) {
        this.keys[r4] = 0;
        this.states[r4] = 2;
        T[] r0 = this.values;
        T r1 = r0[r4];
        r0[r4] = this.missingEntries;
        this.size--;
        this.count++;
        return r1;
    }

    public T put(int r6, T r7) {
        int r0 = findInsertionIndex(r6);
        T r1 = this.missingEntries;
        if (r0 >= 0) goto L5;
        r0 = changeIndexSign(r0);
        r1 = this.values[r0];
        boolean r3 = false;
    L6:
        this.keys[r0] = r6;
        this.states[r0] = 1;
        this.values[r0] = r7;
        if (r3 == false) goto L12;
        this.size++;
        if (shouldGrowTable() == false) goto L11;
        growTable();
    L11:
        this.count++;
    L12:
        return r1;
    L5:
        r3 = true;
        goto L6
    }

    private void growTable() {
        byte[] r0 = this.states;
        int r1 = r0.length;
        int[] r2 = this.keys;
        T[] r3 = this.values;
        int r4 = r1 * 2;
        int[] r5 = new int[r4];
        T[] r6 = (T[]) buildArray(r4);
        byte[] r7 = new byte[r4];
        int r8 = r4 - 1;
        int r9 = 0;
    L3:
        if (r9 >= r1) goto L8;
        if (r0[r9] != 1) goto L7;
        int r10 = r2[r9];
        int r11 = findInsertionIndex(r5, r7, r10, r8);
        r5[r11] = r10;
        r6[r11] = r3[r9];
        r7[r11] = 1;
    L7:
        r9 = r9 + 1;
        goto L3
    L8:
        this.mask = r8;
        this.keys = r5;
        this.values = r6;
        this.states = r7;
    }

    private boolean shouldGrowTable() {
        if (this.size > ((this.mask + 1) * 0.5f)) goto L7;
        return false;
    L7:
        return true;
    }

    private void readObject(ObjectInputStream r1) throws IOException, ClassNotFoundException {
        r1.defaultReadObject();
        this.count = 0;
    }

    private T[] buildArray(int r1) {
        return (T[]) ((FieldElement[]) Array.newInstance(this.field.getRuntimeClass(), r1));
    }
}
