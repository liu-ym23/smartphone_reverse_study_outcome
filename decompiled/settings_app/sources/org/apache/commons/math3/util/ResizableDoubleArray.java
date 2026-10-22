package org.apache.commons.math3.util;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class ResizableDoubleArray implements DoubleArray, Serializable {

    @Deprecated
    public static final int ADDITIVE_MODE = 1;
    private static final double DEFAULT_CONTRACTION_DELTA = 0.5d;
    private static final double DEFAULT_EXPANSION_FACTOR = 2.0d;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @Deprecated
    public static final int MULTIPLICATIVE_MODE = 0;
    private static final long serialVersionUID = -3485529955529426875L;
    private double contractionCriterion;
    private double expansionFactor;
    private ExpansionMode expansionMode;
    private double[] internalArray;
    private int numElements;
    private int startIndex;

    /* JADX INFO: renamed from: org.apache.commons.math3.util.ResizableDoubleArray$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$math3$util$ResizableDoubleArray$ExpansionMode = null;

        static {
            int[] r0 = new int[ExpansionMode.values().length];
            $SwitchMap$org$apache$commons$math3$util$ResizableDoubleArray$ExpansionMode = r0;
            r0[ExpansionMode.MULTIPLICATIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$org$apache$commons$math3$util$ResizableDoubleArray$ExpansionMode[ExpansionMode.ADDITIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum ExpansionMode extends Enum<ExpansionMode> {
        private static final /* synthetic */ ExpansionMode[] $VALUES = null;
        public static final ExpansionMode ADDITIVE = null;
        public static final ExpansionMode MULTIPLICATIVE = null;

        private ExpansionMode(String r1, int r2) {
            super(r1, r2);
        }

        public static ExpansionMode valueOf(String r1) {
            return (ExpansionMode) Enum.valueOf(ExpansionMode.class, r1);
        }

        public static ExpansionMode[] values() {
            return (ExpansionMode[]) $VALUES.clone();
        }

        static {
            ExpansionMode r0 = new ExpansionMode("MULTIPLICATIVE", 0);
            MULTIPLICATIVE = r0;
            ExpansionMode r1 = new ExpansionMode("ADDITIVE", 1);
            ADDITIVE = r1;
            $VALUES = new ExpansionMode[]{r0, r1};
        }
    }

    @Deprecated
    protected void setInitialCapacity(int r1) throws MathIllegalArgumentException {
    }

    public ResizableDoubleArray() {
        this(16);
    }

    public ResizableDoubleArray(int r3) throws MathIllegalArgumentException {
        this(r3, DEFAULT_EXPANSION_FACTOR);
    }

    public ResizableDoubleArray(double[] r9) {
        this(16, DEFAULT_EXPANSION_FACTOR, 2.5d, ExpansionMode.MULTIPLICATIVE, r9);
    }

    @Deprecated
    public ResizableDoubleArray(int r3, float r4) throws MathIllegalArgumentException {
        this(r3, r4);
    }

    public ResizableDoubleArray(int r9, double r10) throws MathIllegalArgumentException {
        this(r9, r10, r10 + 0.5d);
    }

    @Deprecated
    public ResizableDoubleArray(int r7, float r8, float r9) throws MathIllegalArgumentException {
        this(r7, r8, r9);
    }

    public ResizableDoubleArray(int r9, double r10, double r12) throws MathIllegalArgumentException {
        this(r9, r10, r12, ExpansionMode.MULTIPLICATIVE, null);
    }

    @Deprecated
    public ResizableDoubleArray(int r9, float r10, float r11, int r12) throws MathIllegalArgumentException {
        double r2 = r10;
        double r4 = r11;
        if (r12 != 1) goto L5;
        ExpansionMode r13 = ExpansionMode.ADDITIVE;
    L6:
        this(r9, r2, r4, r13, null);
        setExpansionMode(r12);
        return;
    L5:
        r13 = ExpansionMode.MULTIPLICATIVE;
        goto L6
    }

    public ResizableDoubleArray(int r3, double r4, double r6, ExpansionMode r8, double... r9) throws MathIllegalArgumentException {
        this.contractionCriterion = 2.5d;
        this.expansionFactor = DEFAULT_EXPANSION_FACTOR;
        this.expansionMode = ExpansionMode.MULTIPLICATIVE;
        this.numElements = 0;
        this.startIndex = 0;
        if (r3 <= 0) goto L11;
        checkContractExpand(r6, r4);
        this.expansionFactor = r4;
        this.contractionCriterion = r6;
        this.expansionMode = r8;
        this.internalArray = new double[r3];
        this.numElements = 0;
        this.startIndex = 0;
        if (r9 != null) goto L7;
        return;
    L7:
        if (r9.length <= 0) goto L13;
        addElements(r9);
        return;
    L13:
        return;
    L11:
        throw new NotStrictlyPositiveException(LocalizedFormats.INITIAL_CAPACITY_NOT_POSITIVE, Integer.valueOf(r3));
    }

    public ResizableDoubleArray(ResizableDoubleArray r3) throws NullArgumentException {
        this.contractionCriterion = 2.5d;
        this.expansionFactor = DEFAULT_EXPANSION_FACTOR;
        this.expansionMode = ExpansionMode.MULTIPLICATIVE;
        this.numElements = 0;
        this.startIndex = 0;
        MathUtils.checkNotNull(r3);
        copy(r3, this);
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized void addElement(double r5) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.internalArray.length > (this.startIndex + this.numElements)) goto L6;
        expand();     // Catch: Throwable -> L9
    L6:
        double[] r0 = this.internalArray;     // Catch: Throwable -> L9
        int r1 = this.startIndex;     // Catch: Throwable -> L9
        int r2 = this.numElements;     // Catch: Throwable -> L9
        this.numElements = r2 + 1;     // Catch: Throwable -> L9
        r0[r1 + r2] = r5;     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized void addElements(double[] r6) {
        monitor-enter(this);
        int r0 = this.numElements;     // Catch: Throwable -> L6
        double[] r1 = new double[(r6.length + r0) + 1];     // Catch: Throwable -> L6
        System.arraycopy(this.internalArray, this.startIndex, r1, 0, r0);     // Catch: Throwable -> L6
        System.arraycopy(r6, 0, r1, this.numElements, r6.length);     // Catch: Throwable -> L6
        this.internalArray = r1;     // Catch: Throwable -> L6
        this.startIndex = 0;     // Catch: Throwable -> L6
        this.numElements += r6.length;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized double addElementRolling(double r6) {
        monitor-enter(this);
        double[] r0 = this.internalArray;     // Catch: Throwable -> L11
        int r1 = this.startIndex;     // Catch: Throwable -> L11
        double r2 = r0[r1];     // Catch: Throwable -> L11
        if ((r1 + (this.numElements + 1)) <= r0.length) goto L6;
        expand();     // Catch: Throwable -> L11
    L6:
        int r3 = this.startIndex + 1;     // Catch: Throwable -> L11
        this.startIndex = r3;     // Catch: Throwable -> L11
        this.internalArray[r3 + (this.numElements - 1)] = r6;     // Catch: Throwable -> L11
        if (shouldContract() == false) goto L9;
        contract();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r2;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized double substituteMostRecentElement(double r6) throws MathIllegalStateException {
        monitor-enter(this);
        int r0 = this.numElements;     // Catch: Throwable -> L10
        if (r0 < 1) goto L9;
        int r2 = this.startIndex + (r0 - 1);     // Catch: Throwable -> L10
        double[] r1 = this.internalArray;     // Catch: Throwable -> L10
        double r3 = r1[r2];     // Catch: Throwable -> L10
        r1[r2] = r6;     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L9:
        throw new MathIllegalStateException(LocalizedFormats.CANNOT_SUBSTITUTE_ELEMENT_FROM_EMPTY_ARRAY, new Object[0]);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Deprecated
    protected void checkContractExpand(float r3, float r4) throws MathIllegalArgumentException {
        checkContractExpand(r3, r4);
    }

    protected void checkContractExpand(double r6, double r8) throws NumberIsTooSmallException {
        if (r6 >= r8) goto L5;
        NumberIsTooSmallException r5 = new NumberIsTooSmallException(Double.valueOf(r6), 1, true);
        r5.getContext().addMessage(LocalizedFormats.CONTRACTION_CRITERIA_SMALLER_THAN_EXPANSION_FACTOR, new Object[]{Double.valueOf(r6), Double.valueOf(r8)});
        throw r5;
    L5:
        if (r6 > 1.0d) goto L7;
        NumberIsTooSmallException r7 = new NumberIsTooSmallException(Double.valueOf(r6), 1, false);
        r7.getContext().addMessage(LocalizedFormats.CONTRACTION_CRITERIA_SMALLER_THAN_ONE, new Object[]{Double.valueOf(r6)});
        throw r7;
    L7:
        if (r8 <= 1.0d) goto L9;
        return;
    L9:
        NumberIsTooSmallException r9 = new NumberIsTooSmallException(Double.valueOf(r6), 1, false);
        r9.getContext().addMessage(LocalizedFormats.EXPANSION_FACTOR_SMALLER_THAN_ONE, new Object[]{Double.valueOf(r8)});
        throw r9;
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized void clear() {
        monitor-enter(this);
        this.numElements = 0;     // Catch: Throwable -> L7
        this.startIndex = 0;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void contract() {
        monitor-enter(this);
        int r0 = this.numElements;     // Catch: Throwable -> L6
        double[] r1 = new double[r0 + 1];     // Catch: Throwable -> L6
        System.arraycopy(this.internalArray, this.startIndex, r1, 0, r0);     // Catch: Throwable -> L6
        this.internalArray = r1;     // Catch: Throwable -> L6
        this.startIndex = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void discardFrontElements(int r2) throws MathIllegalArgumentException {
        monitor-enter(this);
        discardExtremeElements(r2, true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void discardMostRecentElements(int r2) throws MathIllegalArgumentException {
        monitor-enter(this);
        discardExtremeElements(r2, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized void discardExtremeElements(int r5, boolean r6) throws MathIllegalArgumentException {
        monitor-enter(this);
        int r0 = this.numElements;     // Catch: Throwable -> L18
        if (r5 > r0) goto L17;
        if (r5 < 0) goto L15;
        this.numElements = r0 - r5;     // Catch: Throwable -> L18
        if (r6 == false) goto L10;
        this.startIndex += r5;     // Catch: Throwable -> L18
    L10:
        if (shouldContract() == false) goto L12;
        contract();     // Catch: Throwable -> L18
    L12:
        monitor-exit(this);
        return;
    L15:
        throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_DISCARD_NEGATIVE_NUMBER_OF_ELEMENTS, new Object[]{Integer.valueOf(r5)});     // Catch: Throwable -> L18
    L17:
        throw new MathIllegalArgumentException(LocalizedFormats.TOO_MANY_ELEMENTS_TO_DISCARD_FROM_ARRAY, new Object[]{Integer.valueOf(r5), Integer.valueOf(this.numElements)});     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    protected synchronized void expand() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.expansionMode != ExpansionMode.MULTIPLICATIVE) goto L6;
        int r0 = (int) FastMath.ceil(((double) this.internalArray.length) * this.expansionFactor);     // Catch: Throwable -> L10
    L7:
        double[] r1 = new double[r0];     // Catch: Throwable -> L10
        double[] r2 = this.internalArray;     // Catch: Throwable -> L10
        System.arraycopy(r2, 0, r1, 0, r2.length);     // Catch: Throwable -> L10
        this.internalArray = r1;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0 = (int) (((long) this.internalArray.length) + FastMath.round(this.expansionFactor));     // Catch: Throwable -> L10
        goto L7
    }

    private synchronized void expandTo(int r4) {
        monitor-enter(this);
        double[] r5 = new double[r4];     // Catch: Throwable -> L6
        double[] r0 = this.internalArray;     // Catch: Throwable -> L6
        System.arraycopy(r0, 0, r5, 0, r0.length);     // Catch: Throwable -> L6
        this.internalArray = r5;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public float getContractionCriteria() {
        return (float) getContractionCriterion();
    }

    public double getContractionCriterion() {
        return this.contractionCriterion;
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized double getElement(int r3) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (r3 >= this.numElements) goto L12;
        if (r3 < 0) goto L10;
        double r0 = this.internalArray[this.startIndex + r3];     // Catch: Throwable -> L13
        monitor-exit(this);
        return r0;
    L10:
        throw new ArrayIndexOutOfBoundsException(r3);     // Catch: Throwable -> L13
    L12:
        throw new ArrayIndexOutOfBoundsException(r3);     // Catch: Throwable -> L13
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized double[] getElements() {
        monitor-enter(this);
        int r0 = this.numElements;     // Catch: Throwable -> L6
        double[] r1 = new double[r0];     // Catch: Throwable -> L6
        System.arraycopy(this.internalArray, this.startIndex, r1, 0, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r1;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public float getExpansionFactor() {
        return (float) this.expansionFactor;
    }

    @Deprecated
    public int getExpansionMode() {
        monitor-enter(this);
        int r0 = AnonymousClass1.$SwitchMap$org$apache$commons$math3$util$ResizableDoubleArray$ExpansionMode[this.expansionMode.ordinal()];     // Catch: Throwable -> L14
        if (r0 != 1) goto L6;
        monitor-exit(this);     // Catch: Throwable -> L14
        return 0;
    L6:
        if (r0 != 2) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L14
        return 1;
    L10:
        throw new MathInternalError();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Deprecated
    synchronized int getInternalLength() {
        monitor-enter(this);
        int r0 = this.internalArray.length;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public int getCapacity() {
        return this.internalArray.length;
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized int getNumElements() {
        monitor-enter(this);
        int r0 = this.numElements;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized double[] getInternalValues() {
        monitor-enter(this);
        double[] r0 = this.internalArray;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    protected double[] getArrayRef() {
        return this.internalArray;
    }

    protected int getStartIndex() {
        return this.startIndex;
    }

    @Deprecated
    public void setContractionCriteria(float r3) throws MathIllegalArgumentException {
        checkContractExpand(r3, getExpansionFactor());
        monitor-enter(this);
        this.contractionCriterion = r3;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public double compute(MathArrays.Function r4) {
        monitor-enter(this);
        double[] r0 = this.internalArray;     // Catch: Throwable -> L7
        int r1 = this.startIndex;     // Catch: Throwable -> L7
        int r2 = this.numElements;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return r4.evaluate(r0, r1, r2);
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math3.util.DoubleArray
    public synchronized void setElement(int r5, double r6) {
        monitor-enter(this);
        if (r5 < 0) goto L17;
        int r0 = r5 + 1;
        if (r0 <= this.numElements) goto L8;
        this.numElements = r0;     // Catch: Throwable -> L14
    L8:
        int r1 = this.startIndex;     // Catch: Throwable -> L14
        if ((r1 + r5) < this.internalArray.length) goto L11;
        expandTo(r1 + r0);     // Catch: Throwable -> L14
    L11:
        this.internalArray[this.startIndex + r5] = r6;     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L17:
        throw new ArrayIndexOutOfBoundsException(r5);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public void setExpansionFactor(float r5) throws MathIllegalArgumentException {
        double r2 = r5;
        checkContractExpand(getContractionCriterion(), r2);
        monitor-enter(this);
        this.expansionFactor = r2;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public void setExpansionMode(int r5) throws MathIllegalArgumentException {
        if (r5 == 0) goto L8;
        if (r5 == 1) goto L8;
        throw new MathIllegalArgumentException(LocalizedFormats.UNSUPPORTED_EXPANSION_MODE, new Object[]{Integer.valueOf(r5), 0, "MULTIPLICATIVE_MODE", 1, "ADDITIVE_MODE"});
    L8:
        monitor-enter(this);
        if (r5 != 0) goto L13;
        setExpansionMode(ExpansionMode.MULTIPLICATIVE);     // Catch: Throwable -> L11
    L15:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L13:
        if (r5 != 1) goto L15;
        setExpansionMode(ExpansionMode.ADDITIVE);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public void setExpansionMode(ExpansionMode r1) {
        monitor-enter(this);
        this.expansionMode = r1;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setNumElements(int r5) throws MathIllegalArgumentException {
        monitor-enter(this);
        if (r5 < 0) goto L13;
        int r0 = this.startIndex + r5;     // Catch: Throwable -> L10
        if (r0 <= this.internalArray.length) goto L7;
        expandTo(r0);     // Catch: Throwable -> L10
    L7:
        this.numElements = r5;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L13:
        throw new MathIllegalArgumentException(LocalizedFormats.INDEX_NOT_POSITIVE, new Object[]{Integer.valueOf(r5)});     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private synchronized boolean shouldContract() {
        monitor-enter(this);
        boolean r2 = true;
        if (this.expansionMode != ExpansionMode.MULTIPLICATIVE) goto L14;
        if ((this.internalArray.length / this.numElements) > this.contractionCriterion) goto L10;
        r2 = false;
    L10:
        monitor-exit(this);
        return r2;
    L14:
        if ((this.internalArray.length - this.numElements) > this.contractionCriterion) goto L17;
        r2 = false;
    L17:
        monitor-exit(this);
        return r2;
    L19:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized int start() {
        monitor-enter(this);
        int r0 = this.startIndex;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static void copy(ResizableDoubleArray r4, ResizableDoubleArray r5) throws NullArgumentException {
        MathUtils.checkNotNull(r4);
        MathUtils.checkNotNull(r5);
        monitor-enter(r4);
        monitor-enter(r5);     // Catch: Throwable -> L12
        r5.contractionCriterion = r4.contractionCriterion;     // Catch: Throwable -> L9
        r5.expansionFactor = r4.expansionFactor;     // Catch: Throwable -> L9
        r5.expansionMode = r4.expansionMode;     // Catch: Throwable -> L9
        double[] r0 = new double[r4.internalArray.length];     // Catch: Throwable -> L9
        r5.internalArray = r0;     // Catch: Throwable -> L9
        System.arraycopy(r4.internalArray, 0, r0, 0, r0.length);     // Catch: Throwable -> L9
        r5.numElements = r4.numElements;     // Catch: Throwable -> L9
        r5.startIndex = r4.startIndex;     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L12
        return;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized ResizableDoubleArray copy() {
        monitor-enter(this);
        ResizableDoubleArray r0 = new ResizableDoubleArray();     // Catch: Throwable -> L6
        copy(this, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean equals(Object r8) {
        boolean r0 = true;
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof ResizableDoubleArray) == true) goto L8;
        return false;
    L8:
        monitor-enter(this);
        monitor-enter(r8);     // Catch: Throwable -> L45
        ResizableDoubleArray r1 = (ResizableDoubleArray) r8;     // Catch: Throwable -> L42
        if (r1.contractionCriterion != this.contractionCriterion) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L16;
    L18:
        boolean r4 = false;
    L19:
        if (r4 == true) goto L21;
    L23:
        boolean r5 = false;
    L24:
        if (r5 == true) goto L26;
    L28:
        boolean r6 = false;
    L29:
        if (r6 == true) goto L31;
    L33:
        r0 = false;
    L34:
        if (r0 == true) goto L38;
        monitor-exit(r8);     // Catch: Throwable -> L42
        monitor-exit(this);     // Catch: Throwable -> L45
        return false;
    L38:
        boolean r2 = Arrays.equals(this.internalArray, r1.internalArray);     // Catch: Throwable -> L42
        monitor-exit(r8);     // Catch: Throwable -> L42
        monitor-exit(this);     // Catch: Throwable -> L45
        return r2;
    L31:
        if (r1.startIndex != this.startIndex) goto L33;
    L26:
        if (r1.numElements != this.numElements) goto L28;
        r6 = true;
        goto L29
    L21:
        if (r1.expansionMode != this.expansionMode) goto L23;
        r5 = true;
        goto L24
    L16:
        if (r1.expansionFactor != this.expansionFactor) goto L18;
        r4 = true;
        goto L19
    L13:
        r3 = false;
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public synchronized int hashCode() {
        monitor-enter(this);
        int r0 = Arrays.hashCode(new int[]{Double.valueOf(this.expansionFactor).hashCode(), Double.valueOf(this.contractionCriterion).hashCode(), this.expansionMode.hashCode(), Arrays.hashCode(this.internalArray), this.numElements, this.startIndex});     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }
}
