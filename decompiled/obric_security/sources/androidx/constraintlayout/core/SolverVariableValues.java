package androidx.constraintlayout.core;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    private int HASH_SIZE;
    private final int NONE;
    private int SIZE;
    int head;
    int[] keys;
    protected final Cache mCache;
    int mCount;
    private final ArrayRow mRow;
    int[] next;
    int[] nextKeys;
    int[] previous;
    float[] values;
    int[] variables;

    static {
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    SolverVariableValues(ArrayRow r4, Cache r5) {
        this.NONE = -1;
        this.SIZE = 16;
        this.HASH_SIZE = 16;
        this.keys = new int[16];
        this.nextKeys = new int[16];
        this.variables = new int[16];
        this.values = new float[16];
        this.previous = new int[16];
        this.next = new int[16];
        this.mCount = 0;
        this.head = -1;
        this.mRow = r4;
        this.mCache = r5;
        clear();
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int r7) {
        int r0 = this.mCount;
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r2 = this.head;
        int r3 = 0;
    L6:
        if (r3 >= r0) goto L16;
        if (r3 != r7) goto L12;
        if (r2 == (-1)) goto L12;
        return this.mCache.mIndexedVariables[this.variables[r2]];
    L12:
        r2 = this.next[r2];
        if (r2 == (-1)) goto L16;
        r3 = r3 + 1;
    L16:
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int r5) {
        int r0 = this.mCount;
        int r1 = this.head;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (r2 == r5) goto L6;
        r1 = this.next[r1];
        if (r1 == (-1)) goto L16;
        r2 = r2 + 1;
        goto L3
    L16:
        return 0.0f;
    L6:
        return this.values[r1];
    L11:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable r4) {
        if (this.mCount == 0) goto L22;
        if (r4 == null) goto L22;
        int r5 = r4.id;
        int r0 = r5 % this.HASH_SIZE;
        int r1 = this.keys[r0];
        if (r1 != (-1)) goto L10;
        return -1;
    L10:
        if (this.variables[r1] != r5) goto L12;
        return r1;
    L12:
        r1 = this.nextKeys[r1];
        if (r1 == (-1)) goto L17;
        if (this.variables[r1] != r5) goto L12;
    L17:
        if (r1 != (-1)) goto L20;
        return -1;
    L20:
        if (this.variables[r1] != r5) goto L22;
        return r1;
    L22:
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float get(SolverVariable r2) {
        int r3 = indexOf(r2);
        if (r3 != (-1)) goto L5;
        return 0.0f;
    L5:
        return this.values[r3];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int r0 = this.mCount;
        System.out.print("{ ");
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        SolverVariable r2 = getVariable(r1);
        if (r2 == null) goto L8;
        System.out.print(r2 + " = " + getVariableValue(r1) + " ");
    L8:
        r1 = r1 + 1;
        goto L3
    L9:
        System.out.println(" }");
    }

    public String toString() {
        String r0 = hashCode() + " { ";
        int r1 = this.mCount;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L18;
        SolverVariable r3 = getVariable(r2);
        if (r3 == null) goto L16;
        String r4 = r0 + r3 + " = " + getVariableValue(r2) + " ";
        int r5 = indexOf(r3);
        String r6 = r4 + "[p: ";
        if (this.previous[r5] == (-1)) goto L10;
        String r7 = r6 + this.mCache.mIndexedVariables[this.variables[this.previous[r5]]];
    L11:
        String r8 = r7 + ", n: ";
        if (this.next[r5] == (-1)) goto L14;
        String r9 = r8 + this.mCache.mIndexedVariables[this.variables[this.next[r5]]];
    L15:
        r0 = r9 + "]";
        goto L16
    L14:
        r9 = r8 + "none";
        goto L15
    L10:
        r7 = r6 + "none";
    L16:
        r2 = r2 + 1;
        goto L3
    L18:
        return r0 + " }";
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void clear() {
        int r0 = this.mCount;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        SolverVariable r3 = getVariable(r2);
        if (r3 == null) goto L7;
        r3.removeFromRow(this.mRow);
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        int r1 = 0;
    L10:
        if (r1 >= this.SIZE) goto L12;
        this.variables[r1] = -1;
        this.nextKeys[r1] = -1;
        r1 = r1 + 1;
        goto L10
    L12:
        int r4 = 0;
    L14:
        if (r4 >= this.HASH_SIZE) goto L16;
        this.keys[r4] = -1;
        r4 = r4 + 1;
        goto L14
    L16:
        this.mCount = 0;
        this.head = -1;
    }

    private void increaseSize() {
        int r0 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, r0);
        this.values = Arrays.copyOf(this.values, r0);
        this.previous = Arrays.copyOf(this.previous, r0);
        this.next = Arrays.copyOf(this.next, r0);
        this.nextKeys = Arrays.copyOf(this.nextKeys, r0);
        int r1 = this.SIZE;
    L3:
        if (r1 >= r0) goto L5;
        this.variables[r1] = -1;
        this.nextKeys[r1] = -1;
        r1 = r1 + 1;
        goto L3
    L5:
        this.SIZE = r0;
    }

    private void addToHashMap(SolverVariable r4, int r5) {
        int r6 = r4.id % this.HASH_SIZE;
        int[] r0 = this.keys;
        int r1 = r0[r6];
        if (r1 != (-1)) goto L5;
        r0[r6] = r5;
    L9:
        this.nextKeys[r5] = -1;
        return;
    L5:
        int[] r7 = this.nextKeys;
        int r2 = r7[r1];
        if (r2 == (-1)) goto L8;
        r1 = r2;
        goto L5
    L8:
        r7[r1] = r5;
        goto L9
    }

    private void displayHash() {
        int r1 = 0;
    L4:
        if (r1 >= this.HASH_SIZE) goto L15;
        if (this.keys[r1] == (-1)) goto L14;
        String r2 = hashCode() + " hash [" + r1 + "] => ";
        int r4 = this.keys[r1];
        boolean r5 = false;
    L8:
        if (r5 == true) goto L13;
        r2 = r2 + " " + this.variables[r4];
        int r6 = this.nextKeys[r4];
        if (r6 != (-1)) goto L11;
        r5 = true;
        goto L8
    L11:
        r4 = r6;
        goto L8
    L13:
        System.out.println(r2);
    L14:
        r1 = r1 + 1;
        goto L4
    }

    private void removeFromHashMap(SolverVariable r6) {
        int r0 = r6.id % this.HASH_SIZE;
        int r1 = this.keys[r0];
        if (r1 != (-1)) goto L5;
        return;
    L5:
        int r7 = r6.id;
        if (this.variables[r1] != r7) goto L8;
        int[] r8 = this.keys;
        int[] r5 = this.nextKeys;
        r8[r0] = r5[r1];
        r5[r1] = -1;
        return;
    L8:
        int[] r2 = this.nextKeys;
        int r3 = r2[r1];
        if (r3 == (-1)) goto L13;
        if (this.variables[r3] == r7) goto L13;
        r1 = r3;
    L13:
        if (r3 != (-1)) goto L15;
        return;
    L15:
        if (this.variables[r3] != r7) goto L22;
        r2[r1] = r2[r3];
        r2[r3] = -1;
        return;
    }

    private void addVariable(int r3, SolverVariable r4, float r5) {
        this.variables[r3] = r4.id;
        this.values[r3] = r5;
        this.previous[r3] = -1;
        this.next[r3] = -1;
        r4.addToRow(this.mRow);
        r4.usageInRowCount++;
        this.mCount++;
    }

    private int findEmptySlot() {
        int r0 = 0;
    L4:
        if (r0 >= this.SIZE) goto L9;
        if (this.variables[r0] == (-1)) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private void insertVariable(int r4, SolverVariable r5, float r6) {
        int r0 = findEmptySlot();
        addVariable(r0, r5, r6);
        if (r4 == (-1)) goto L5;
        this.previous[r0] = r4;
        int[] r1 = this.next;
        r1[r0] = r1[r4];
        r1[r4] = r0;
    L9:
        int r7 = this.next[r0];
        if (r7 == (-1)) goto L12;
        this.previous[r7] = r0;
    L12:
        addToHashMap(r5, r0);
        return;
    L5:
        this.previous[r0] = -1;
        if (this.mCount <= 0) goto L8;
        this.next[r0] = this.head;
        this.head = r0;
        goto L9
    L8:
        this.next[r0] = -1;
        goto L9
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void put(SolverVariable r8, float r9) {
        float r0 = epsilon;
        if (r9 > (-r0)) goto L5;
    L8:
        int r1 = 0;
        if (this.mCount != 0) goto L11;
        addVariable(0, r8, r9);
        addToHashMap(r8, 0);
        this.head = 0;
        return;
    L11:
        int r2 = indexOf(r8);
        if (r2 == (-1)) goto L15;
        this.values[r2] = r9;
        return;
    L15:
        if ((this.mCount + 1) < this.SIZE) goto L17;
        increaseSize();
    L17:
        int r3 = this.mCount;
        int r4 = this.head;
        int r5 = -1;
    L18:
        if (r1 >= r3) goto L30;
        if (this.variables[r4] == r8.id) goto L21;
        if (this.variables[r4] >= r8.id) goto L26;
        r5 = r4;
    L26:
        r4 = this.next[r4];
        if (r4 == (-1)) goto L30;
        r1 = r1 + 1;
        goto L18
    L21:
        this.values[r4] = r9;
        return;
    L30:
        insertVariable(r5, r8, r9);
        return;
    L5:
        if (r9 >= r0) goto L8;
        remove(r8, true);
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable r8, boolean r9) {
        int r0 = indexOf(r8);
        if (r0 != (-1)) goto L6;
        return 0.0f;
    L6:
        removeFromHashMap(r8);
        float r2 = this.values[r0];
        if (this.head != r0) goto L9;
        this.head = this.next[r0];
    L9:
        this.variables[r0] = -1;
        int[] r3 = this.previous;
        int r4 = r3[r0];
        if (r4 == (-1)) goto L12;
        int[] r5 = this.next;
        r5[r4] = r5[r0];
    L12:
        int r6 = this.next[r0];
        if (r6 == (-1)) goto L15;
        r3[r6] = r3[r0];
    L15:
        this.mCount--;
        r8.usageInRowCount--;
        if (r9 == false) goto L18;
        r8.removeFromRow(this.mRow);
    L18:
        return r2;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable r5, float r6, boolean r7) {
        float r0 = epsilon;
        if (r6 > (-r0)) goto L5;
    L7:
        int r1 = indexOf(r5);
        if (r1 != (-1)) goto L10;
        put(r5, r6);
        return;
    L10:
        float[] r2 = this.values;
        float r3 = r2[r1] + r6;
        r2[r1] = r3;
        float r8 = epsilon;
        if (r3 > (-r8)) goto L13;
        return;
    L13:
        if (r3 >= r8) goto L18;
        r2[r1] = 0.0f;
        remove(r5, r7);
        return;
    L18:
        return;
    L5:
        if (r6 >= r0) goto L7;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow r8, boolean r9) {
        float r0 = get(r8.variable);
        remove(r8.variable, r9);
        SolverVariableValues r10 = (SolverVariableValues) r8.variables;
        int r1 = r10.getCurrentSize();
        int r2 = r10.head;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (r10.variables[r4] == (-1)) goto L7;
        add(this.mCache.mIndexedVariables[r10.variables[r4]], r10.values[r4] * r0, r9);
        r3 = r3 + 1;
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int r0 = this.mCount;
        int r1 = this.head;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        float[] r3 = this.values;
        r3[r1] = r3[r1] * (-1.0f);
        r1 = this.next[r1];
        if (r1 == (-1)) goto L11;
        r2 = r2 + 1;
        goto L3
    L11:
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float r6) {
        int r0 = this.mCount;
        int r1 = this.head;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        float[] r3 = this.values;
        r3[r1] = r3[r1] / r6;
        r1 = this.next[r1];
        if (r1 == (-1)) goto L11;
        r2 = r2 + 1;
        goto L3
    L11:
        return;
    }
}
