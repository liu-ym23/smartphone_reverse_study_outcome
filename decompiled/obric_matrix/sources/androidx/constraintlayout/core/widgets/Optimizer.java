package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;

/* JADX INFO: loaded from: classes.dex */
public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CACHE_MEASURES = 256;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DEPENDENCY_ORDERING = 512;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GRAPH = 64;
    public static final int OPTIMIZATION_GRAPH_WRAP = 128;
    public static final int OPTIMIZATION_GROUPING = 1024;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 257;
    static boolean[] flags;

    static {
        flags = new boolean[3];
    }

    public Optimizer() {
    }

    static void checkMatchParent(ConstraintWidgetContainer r6, LinearSystem r7, ConstraintWidget r8) {
        r8.mHorizontalResolution = -1;
        r8.mVerticalResolution = -1;
        ConstraintWidget.DimensionBehaviour r0 = r6.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r0 == r2) goto L8;
        if (r8.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L8;
        int r1 = r8.mLeft.mMargin;
        int r3 = r6.getWidth() - r8.mRight.mMargin;
        ConstraintAnchor r4 = r8.mLeft;
        r4.mSolverVariable = r7.createObjectVariable(r4);
        ConstraintAnchor r5 = r8.mRight;
        r5.mSolverVariable = r7.createObjectVariable(r5);
        r7.addEquality(r8.mLeft.mSolverVariable, r1);
        r7.addEquality(r8.mRight.mSolverVariable, r3);
        r8.mHorizontalResolution = 2;
        r8.setHorizontalDimension(r1, r3);
    L8:
        if (r6.mListDimensionBehaviors[1] != r2) goto L10;
        return;
    L10:
        if (r8.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        int r9 = r8.mTop.mMargin;
        int r10 = r6.getHeight() - r8.mBottom.mMargin;
        ConstraintAnchor r11 = r8.mTop;
        r11.mSolverVariable = r7.createObjectVariable(r11);
        ConstraintAnchor r12 = r8.mBottom;
        r12.mSolverVariable = r7.createObjectVariable(r12);
        r7.addEquality(r8.mTop.mSolverVariable, r9);
        r7.addEquality(r8.mBottom.mSolverVariable, r10);
        if (r8.mBaselineDistance <= 0) goto L14;
    L15:
        ConstraintAnchor r13 = r8.mBaseline;
        r13.mSolverVariable = r7.createObjectVariable(r13);
        r7.addEquality(r8.mBaseline.mSolverVariable, r8.mBaselineDistance + r9);
    L16:
        r8.mVerticalResolution = 2;
        r8.setVerticalDimension(r9, r10);
        return;
    L14:
        if (r8.getVisibility() != 8) goto L16;
    }

    public static final boolean enabled(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }
}
