package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.LinearSystem;

/* JADX INFO: loaded from: classes3.dex */
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
    static boolean[] sFlags;

    public static final boolean enabled(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public Optimizer() {
    }

    static {
        sFlags = new boolean[3];
    }

    static void checkMatchParent(ConstraintWidgetContainer r5, LinearSystem r6, ConstraintWidget r7) {
        r7.mHorizontalResolution = -1;
        r7.mVerticalResolution = -1;
        if (r5.mListDimensionBehaviors[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L8;
        if (r7.mListDimensionBehaviors[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L8;
        int r0 = r7.mLeft.mMargin;
        int r1 = r5.getWidth() - r7.mRight.mMargin;
        ConstraintAnchor r2 = r7.mLeft;
        r2.mSolverVariable = r6.createObjectVariable(r7.mLeft);
        ConstraintAnchor r3 = r7.mRight;
        r3.mSolverVariable = r6.createObjectVariable(r7.mRight);
        r6.addEquality(r7.mLeft.mSolverVariable, r0);
        r6.addEquality(r7.mRight.mSolverVariable, r1);
        r7.mHorizontalResolution = 2;
        r7.setHorizontalDimension(r0, r1);
    L8:
        if (r5.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L10;
        return;
    L10:
        if (r7.mListDimensionBehaviors[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        int r4 = r7.mTop.mMargin;
        int r8 = r5.getHeight() - r7.mBottom.mMargin;
        ConstraintAnchor r9 = r7.mTop;
        r9.mSolverVariable = r6.createObjectVariable(r7.mTop);
        ConstraintAnchor r10 = r7.mBottom;
        r10.mSolverVariable = r6.createObjectVariable(r7.mBottom);
        r6.addEquality(r7.mTop.mSolverVariable, r4);
        r6.addEquality(r7.mBottom.mSolverVariable, r8);
        if (r7.mBaselineDistance <= 0) goto L14;
    L15:
        ConstraintAnchor r11 = r7.mBaseline;
        r11.mSolverVariable = r6.createObjectVariable(r7.mBaseline);
        r6.addEquality(r7.mBaseline.mSolverVariable, r7.mBaselineDistance + r4);
    L16:
        r7.mVerticalResolution = 2;
        r7.setVerticalDimension(r4, r8);
        return;
    L14:
        if (r7.getVisibility() != 8) goto L16;
    }
}
