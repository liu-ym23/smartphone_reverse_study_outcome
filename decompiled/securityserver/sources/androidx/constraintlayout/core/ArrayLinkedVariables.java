package androidx.constraintlayout.core;

import a.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    static final int NONE = -1;
    private static float epsilon = 0.001f;
    private int ROW_SIZE;
    private SolverVariable candidate;
    int currentSize;
    private int[] mArrayIndices;
    private int[] mArrayNextIndices;
    private float[] mArrayValues;
    protected final Cache mCache;
    private boolean mDidFillOnce;
    private int mHead;
    private int mLast;
    private final ArrayRow mRow;

    public ArrayLinkedVariables(ArrayRow r4, Cache r5) {
        this.currentSize = 0;
        this.ROW_SIZE = 8;
        this.candidate = null;
        this.mArrayIndices = new int[8];
        this.mArrayNextIndices = new int[8];
        this.mArrayValues = new float[8];
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mRow = r4;
        this.mCache = r5;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable r9, float r10, boolean r11) {
        float r0 = epsilon;
        if (r10 > (-r0)) goto L5;
    L7:
        int r1 = this.mHead;
        if (r1 != (-1)) goto L15;
        this.mHead = 0;
        this.mArrayValues[0] = r10;
        this.mArrayIndices[0] = r9.id;
        this.mArrayNextIndices[0] = -1;
        r9.usageInRowCount++;
        r9.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L81;
        int r12 = this.mLast + 1;
        this.mLast = r12;
        int[] r13 = this.mArrayIndices;
        if (r12 < r13.length) goto L82;
        this.mDidFillOnce = true;
        this.mLast = r13.length - 1;
        return;
    L82:
        return;
    L81:
        return;
    L15:
        int r4 = 0;
        int r5 = -1;
    L16:
        if (r1 == (-1)) goto L42;
        if (r4 >= this.currentSize) goto L42;
        int r6 = this.mArrayIndices[r1];
        int r7 = r9.id;
        if (r6 == r7) goto L21;
        if (r6 >= r7) goto L41;
        r5 = r1;
    L41:
        r1 = this.mArrayNextIndices[r1];
        r4 = r4 + 1;
        goto L16
    L21:
        float[] r2 = this.mArrayValues;
        float r3 = r2[r1] + r10;
        float r14 = epsilon;
        if (r3 > (-r14)) goto L24;
    L26:
        r2[r1] = r3;
        if (r3 == 0.0f) goto L29;
        return;
    L29:
        if (r1 != this.mHead) goto L31;
        this.mHead = this.mArrayNextIndices[r1];
    L32:
        if (r11 == false) goto L35;
        r9.removeFromRow(this.mRow);
    L35:
        if (this.mDidFillOnce == false) goto L37;
        this.mLast = r1;
    L37:
        r9.usageInRowCount--;
        this.currentSize--;
        return;
    L31:
        int[] r15 = this.mArrayNextIndices;
        r15[r5] = r15[r1];
        goto L32
    L24:
        if (r3 >= r14) goto L26;
        r3 = 0.0f;
    L42:
        int r16 = this.mLast;
        int r8 = r16 + 1;
        if (this.mDidFillOnce == false) goto L48;
        int[] r17 = this.mArrayIndices;
        if (r17[r16] == (-1)) goto L49;
        r16 = r17.length;
    L49:
        int[] r18 = this.mArrayIndices;
        if (r16 >= r18.length) goto L52;
    L60:
        int[] r19 = this.mArrayIndices;
        if (r16 < r19.length) goto L63;
        r16 = r19.length;
        int r20 = this.ROW_SIZE * 2;
        this.ROW_SIZE = r20;
        this.mDidFillOnce = false;
        this.mLast = r16 - 1;
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, r20);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    L63:
        this.mArrayIndices[r16] = r9.id;
        this.mArrayValues[r16] = r10;
        if (r5 == (-1)) goto L66;
        int[] r110 = this.mArrayNextIndices;
        r110[r16] = r110[r5];
        r110[r5] = r16;
    L67:
        r9.usageInRowCount++;
        r9.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L70;
        this.mLast++;
    L70:
        int r21 = this.mLast;
        int[] r111 = this.mArrayIndices;
        if (r21 < r111.length) goto L84;
        this.mDidFillOnce = true;
        this.mLast = r111.length - 1;
        return;
    L84:
        return;
    L66:
        this.mArrayNextIndices[r16] = this.mHead;
        this.mHead = r16;
        goto L67
    L52:
        if (this.currentSize >= r18.length) goto L60;
        int r22 = 0;
    L54:
        int[] r23 = this.mArrayIndices;
        if (r22 >= r23.length) goto L60;
        if (r23[r22] == (-1)) goto L58;
        r22 = r22 + 1;
        goto L54
    L58:
        r16 = r22;
        goto L60
    L48:
        r16 = r8;
        goto L49
    L5:
        if (r10 >= r0) goto L7;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int r0 = this.mHead;
        int r2 = 0;
    L4:
        if (r0 == (-1)) goto L11;
        if (r2 >= this.currentSize) goto L11;
        SolverVariable r3 = this.mCache.mIndexedVariables[this.mArrayIndices[r0]];
        if (r3 == null) goto L10;
        r3.removeFromRow(this.mRow);
    L10:
        r0 = this.mArrayNextIndices[r0];
        r2 = r2 + 1;
    L11:
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable r7) {
        int r0 = this.mHead;
        if (r0 != (-1)) goto L5;
        return false;
    L5:
        int r3 = 0;
    L6:
        if (r0 == (-1)) goto L14;
        if (r3 >= this.currentSize) goto L14;
        if (this.mArrayIndices[r0] == r7.id) goto L11;
        r0 = this.mArrayNextIndices[r0];
        r3 = r3 + 1;
        goto L6
    L11:
        return true;
    L14:
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int r0 = this.currentSize;
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

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float r5) {
        int r0 = this.mHead;
        int r1 = 0;
    L4:
        if (r0 == (-1)) goto L8;
        if (r1 >= this.currentSize) goto L11;
        float[] r2 = this.mArrayValues;
        r2[r0] = r2[r0] / r5;
        r0 = this.mArrayNextIndices[r0];
        r1 = r1 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable r5) {
        int r0 = this.mHead;
        int r1 = 0;
    L4:
        if (r0 == (-1)) goto L12;
        if (r1 >= this.currentSize) goto L17;
        if (this.mArrayIndices[r0] == r5.id) goto L10;
        r0 = this.mArrayNextIndices[r0];
        r1 = r1 + 1;
        goto L4
    L10:
        return this.mArrayValues[r0];
    L17:
        return 0.0f;
    L12:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int r1) {
        return this.mArrayIndices[r1];
    }

    public final int getNextIndice(int r1) {
        return this.mArrayNextIndices[r1];
    }

    public SolverVariable getPivotCandidate() {
        SolverVariable r0 = this.candidate;
        if (r0 != null) goto L18;
        int r1 = this.mHead;
        int r2 = 0;
        SolverVariable r3 = null;
    L6:
        if (r1 == (-1)) goto L17;
        if (r2 >= this.currentSize) goto L17;
        if (this.mArrayValues[r1] >= 0.0f) goto L16;
        SolverVariable r4 = this.mCache.mIndexedVariables[this.mArrayIndices[r1]];
        if (r3 != null) goto L14;
    L15:
        r3 = r4;
        goto L16
    L14:
        if (r3.strength < r4.strength) goto L15;
    L16:
        r1 = this.mArrayNextIndices[r1];
        r2 = r2 + 1;
    L17:
        return r3;
    L18:
        return r0;
    }

    public final float getValue(int r1) {
        return this.mArrayValues[r1];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int r4) {
        int r0 = this.mHead;
        int r1 = 0;
    L4:
        if (r0 == (-1)) goto L11;
        if (r1 >= this.currentSize) goto L16;
        if (r1 == r4) goto L9;
        r0 = this.mArrayNextIndices[r0];
        r1 = r1 + 1;
        goto L4
    L9:
        return this.mCache.mIndexedVariables[this.mArrayIndices[r0]];
    L16:
        return null;
    L11:
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int r4) {
        int r0 = this.mHead;
        int r1 = 0;
    L4:
        if (r0 == (-1)) goto L11;
        if (r1 >= this.currentSize) goto L16;
        if (r1 == r4) goto L9;
        r0 = this.mArrayNextIndices[r0];
        r1 = r1 + 1;
        goto L4
    L9:
        return this.mArrayValues[r0];
    L16:
        return 0.0f;
    L11:
        return 0.0f;
    }

    public boolean hasAtLeastOnePositiveVariable() {
        int r0 = this.mHead;
        int r2 = 0;
    L4:
        if (r0 == (-1)) goto L12;
        if (r2 >= this.currentSize) goto L12;
        if (this.mArrayValues[r0] > 0.0f) goto L9;
        r0 = this.mArrayNextIndices[r0];
        r2 = r2 + 1;
        goto L4
    L9:
        return true;
    L12:
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable r6) {
        int r0 = this.mHead;
        if (r0 != (-1)) goto L5;
        return -1;
    L5:
        int r2 = 0;
    L6:
        if (r0 == (-1)) goto L13;
        if (r2 >= this.currentSize) goto L13;
        if (this.mArrayIndices[r0] == r6.id) goto L11;
        r0 = this.mArrayNextIndices[r0];
        r2 = r2 + 1;
        goto L6
    L11:
        return r0;
    L13:
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int r0 = this.mHead;
        int r1 = 0;
    L4:
        if (r0 == (-1)) goto L8;
        if (r1 >= this.currentSize) goto L11;
        float[] r2 = this.mArrayValues;
        r2[r0] = r2[r0] * (-1.0f);
        r0 = this.mArrayNextIndices[r0];
        r1 = r1 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable r9, float r10) {
        if (r10 != 0.0f) goto L6;
        remove(r9, true);
        return;
    L6:
        int r0 = this.mHead;
        if (r0 != (-1)) goto L14;
        this.mHead = 0;
        this.mArrayValues[0] = r10;
        this.mArrayIndices[0] = r9.id;
        this.mArrayNextIndices[0] = -1;
        r9.usageInRowCount++;
        r9.addToRow(this.mRow);
        this.currentSize++;
        if (this.mDidFillOnce == true) goto L67;
        int r11 = this.mLast + 1;
        this.mLast = r11;
        int[] r12 = this.mArrayIndices;
        if (r11 < r12.length) goto L68;
        this.mDidFillOnce = true;
        this.mLast = r12.length - 1;
        return;
    L68:
        return;
    L67:
        return;
    L14:
        int r4 = 0;
        int r5 = -1;
    L15:
        if (r0 == (-1)) goto L25;
        if (r4 >= this.currentSize) goto L25;
        int r6 = this.mArrayIndices[r0];
        int r7 = r9.id;
        if (r6 == r7) goto L20;
        if (r6 >= r7) goto L24;
        r5 = r0;
    L24:
        r0 = this.mArrayNextIndices[r0];
        r4 = r4 + 1;
        goto L15
    L20:
        this.mArrayValues[r0] = r10;
        return;
    L25:
        int r1 = this.mLast;
        int r8 = r1 + 1;
        if (this.mDidFillOnce == false) goto L31;
        int[] r13 = this.mArrayIndices;
        if (r13[r1] == (-1)) goto L32;
        r1 = r13.length;
    L32:
        int[] r14 = this.mArrayIndices;
        if (r1 >= r14.length) goto L35;
    L43:
        int[] r15 = this.mArrayIndices;
        if (r1 < r15.length) goto L46;
        r1 = r15.length;
        int r16 = this.ROW_SIZE * 2;
        this.ROW_SIZE = r16;
        this.mDidFillOnce = false;
        this.mLast = r1 - 1;
        this.mArrayValues = Arrays.copyOf(this.mArrayValues, r16);
        this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
        this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
    L46:
        this.mArrayIndices[r1] = r9.id;
        this.mArrayValues[r1] = r10;
        if (r5 == (-1)) goto L49;
        int[] r17 = this.mArrayNextIndices;
        r17[r1] = r17[r5];
        r17[r5] = r1;
    L50:
        r9.usageInRowCount++;
        r9.addToRow(this.mRow);
        int r18 = this.currentSize + 1;
        this.currentSize = r18;
        if (this.mDidFillOnce == true) goto L53;
        this.mLast++;
    L53:
        int[] r19 = this.mArrayIndices;
        if (r18 < r19.length) goto L57;
        this.mDidFillOnce = true;
    L57:
        if (this.mLast < r19.length) goto L69;
        this.mDidFillOnce = true;
        this.mLast = r19.length - 1;
        return;
    L69:
        return;
    L49:
        this.mArrayNextIndices[r1] = this.mHead;
        this.mHead = r1;
        goto L50
    L35:
        if (this.currentSize >= r14.length) goto L43;
        int r20 = 0;
    L37:
        int[] r21 = this.mArrayIndices;
        if (r20 >= r21.length) goto L43;
        if (r21[r20] == (-1)) goto L41;
        r20 = r20 + 1;
        goto L37
    L41:
        r1 = r20;
        goto L43
    L31:
        r1 = r8;
        goto L32
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable r9, boolean r10) {
        if (this.candidate != r9) goto L5;
        this.candidate = null;
    L5:
        int r0 = this.mHead;
        if (r0 != (-1)) goto L8;
        return 0.0f;
    L8:
        int r3 = 0;
        int r4 = -1;
    L9:
        if (r0 == (-1)) goto L26;
        if (r3 >= this.currentSize) goto L26;
        if (this.mArrayIndices[r0] == r9.id) goto L15;
        r3 = r3 + 1;
        r4 = r0;
        r0 = this.mArrayNextIndices[r0];
        goto L9
    L15:
        if (r0 != this.mHead) goto L17;
        this.mHead = this.mArrayNextIndices[r0];
    L18:
        if (r10 == false) goto L20;
        r9.removeFromRow(this.mRow);
    L20:
        r9.usageInRowCount--;
        this.currentSize--;
        this.mArrayIndices[r0] = -1;
        if (this.mDidFillOnce == false) goto L24;
        this.mLast = r0;
    L24:
        return this.mArrayValues[r0];
    L17:
        int[] r1 = this.mArrayNextIndices;
        r1[r4] = r1[r0];
    L26:
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int r0 = this.mHead;
        String r1 = "";
        int r2 = 0;
    L4:
        if (r0 == (-1)) goto L8;
        if (r2 >= this.currentSize) goto L8;
        StringBuilder r3 = a.q(a.j(r1, " -> "));
        r3.append(this.mArrayValues[r0]);
        r3.append(" : ");
        StringBuilder r4 = a.q(r3.toString());
        r4.append(this.mCache.mIndexedVariables[this.mArrayIndices[r0]]);
        r1 = r4.toString();
        r0 = this.mArrayNextIndices[r0];
        r2 = r2 + 1;
    L8:
        return r1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow r6, boolean r7) {
        float r0 = get(r6.variable);
        remove(r6.variable, r7);
        ArrayRow.ArrayRowVariables r8 = r6.variables;
        int r1 = r8.getCurrentSize();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        SolverVariable r3 = r8.getVariable(r2);
        add(r3, r8.get(r3) * r0, r7);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }
}
