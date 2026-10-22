package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ChainHead {
    private boolean mDefined;
    protected ConstraintWidget mFirst;
    protected ConstraintWidget mFirstMatchConstraintWidget;
    protected ConstraintWidget mFirstVisibleWidget;
    protected boolean mHasComplexMatchWeights;
    protected boolean mHasDefinedWeights;
    protected boolean mHasRatio;
    protected boolean mHasUndefinedWeights;
    protected ConstraintWidget mHead;
    private boolean mIsRtl;
    protected ConstraintWidget mLast;
    protected ConstraintWidget mLastMatchConstraintWidget;
    protected ConstraintWidget mLastVisibleWidget;
    boolean mOptimizable;
    private int mOrientation;
    int mTotalMargins;
    int mTotalSize;
    protected float mTotalWeight;
    int mVisibleWidgets;
    protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
    protected int mWidgetsCount;
    protected int mWidgetsMatchCount;

    public ChainHead(ConstraintWidget r2, int r3, boolean r4) {
        this.mTotalWeight = 0.0f;
        this.mIsRtl = false;
        this.mFirst = r2;
        this.mOrientation = r3;
        this.mIsRtl = r4;
    }

    private void defineChainProperties() {
        int r0 = this.mOrientation * 2;
        ConstraintWidget r2 = this.mFirst;
        boolean r3 = true;
        this.mOptimizable = true;
        ConstraintWidget r5 = r2;
        boolean r6 = false;
    L3:
        if (r6 == true) goto L75;
        this.mWidgetsCount++;
        ConstraintWidget[] r7 = r2.mNextChainWidget;
        int r8 = this.mOrientation;
        ConstraintWidget r9 = null;
        r7[r8] = null;
        r2.mListNextMatchConstraintsWidget[r8] = null;
        if (r2.getVisibility() == 8) goto L61;
        this.mVisibleWidgets++;
        ConstraintWidget.DimensionBehaviour r10 = r2.getDimensionBehaviour(this.mOrientation);
        ConstraintWidget.DimensionBehaviour r11 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r10 == r11) goto L9;
        this.mTotalSize += r2.getLength(this.mOrientation);
    L9:
        int r12 = this.mTotalSize + r2.mListAnchors[r0].getMargin();
        this.mTotalSize = r12;
        int r13 = r0 + 1;
        this.mTotalSize = r12 + r2.mListAnchors[r13].getMargin();
        int r14 = this.mTotalMargins + r2.mListAnchors[r0].getMargin();
        this.mTotalMargins = r14;
        this.mTotalMargins = r14 + r2.mListAnchors[r13].getMargin();
        if (this.mFirstVisibleWidget != null) goto L12;
        this.mFirstVisibleWidget = r2;
    L12:
        this.mLastVisibleWidget = r2;
        ConstraintWidget.DimensionBehaviour[] r15 = r2.mListDimensionBehaviors;
        int r16 = this.mOrientation;
        if (r15[r16] != r11) goto L61;
        int[] r17 = r2.mResolvedMatchConstraintDefault;
        if (r17[r16] != 0) goto L17;
    L20:
        this.mWidgetsMatchCount++;
        float[] r18 = r2.mWeight;
        float r19 = r18[r16];
        if (r19 <= 0.0f) goto L24;
        this.mTotalWeight += r18[r16];
    L24:
        if (isMatchConstraintEqualityCandidate(r2, r16) == false) goto L34;
        if (r19 >= 0.0f) goto L28;
        this.mHasUndefinedWeights = true;
    L30:
        if (this.mWeightedMatchConstraintsWidgets != null) goto L32;
        this.mWeightedMatchConstraintsWidgets = new ArrayList();
    L32:
        this.mWeightedMatchConstraintsWidgets.add(r2);
        goto L34
    L28:
        this.mHasDefinedWeights = true;
    L34:
        if (this.mFirstMatchConstraintWidget != null) goto L36;
        this.mFirstMatchConstraintWidget = r2;
    L36:
        ConstraintWidget r20 = this.mLastMatchConstraintWidget;
        if (r20 == null) goto L39;
        r20.mListNextMatchConstraintsWidget[this.mOrientation] = r2;
    L39:
        this.mLastMatchConstraintWidget = r2;
    L41:
        if (this.mOrientation != 0) goto L51;
        if (r2.mMatchConstraintDefaultWidth == 0) goto L46;
    L52:
        this.mOptimizable = false;
    L59:
        if (r2.mDimensionRatio == 0.0f) goto L61;
        this.mOptimizable = false;
        this.mHasRatio = true;
        goto L61
    L46:
        if (r2.mMatchConstraintMinWidth != 0) goto L52;
        if (r2.mMatchConstraintMaxWidth == 0) goto L59;
    L51:
        if (r2.mMatchConstraintDefaultHeight != 0) goto L52;
        if (r2.mMatchConstraintMinHeight != 0) goto L52;
        if (r2.mMatchConstraintMaxHeight == 0) goto L59;
    L17:
        if (r17[r16] == 3) goto L20;
        if (r17[r16] != 2) goto L41;
    L61:
        if (r5 == r2) goto L63;
        r5.mNextChainWidget[this.mOrientation] = r2;
    L63:
        ConstraintAnchor r21 = r2.mListAnchors[r0 + 1].mTarget;
        if (r21 == null) goto L71;
        ConstraintWidget r22 = r21.mOwner;
        ConstraintAnchor[] r23 = r22.mListAnchors;
        if (r23[r0].mTarget == null) goto L71;
        if (r23[r0].mTarget.mOwner != r2) goto L71;
        r9 = r22;
    L71:
        if (r9 != null) goto L74;
        r9 = r2;
        r6 = true;
    L74:
        r5 = r2;
        r2 = r9;
        goto L3
    L75:
        ConstraintWidget r1 = this.mFirstVisibleWidget;
        if (r1 == null) goto L78;
        this.mTotalSize -= r1.mListAnchors[r0].getMargin();
    L78:
        ConstraintWidget r4 = this.mLastVisibleWidget;
        if (r4 == null) goto L81;
        this.mTotalSize -= r4.mListAnchors[r0 + 1].getMargin();
    L81:
        this.mLast = r2;
        if (this.mOrientation == 0) goto L84;
    L86:
        this.mHead = this.mFirst;
    L88:
        if (this.mHasDefinedWeights == true) goto L90;
    L92:
        r3 = false;
    L93:
        this.mHasComplexMatchWeights = r3;
        return;
    L90:
        if (this.mHasUndefinedWeights == false) goto L92;
    L84:
        if (this.mIsRtl == false) goto L86;
        this.mHead = r2;
        goto L88
    }

    private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget r2, int r3) {
        if (r2.getVisibility() != 8) goto L5;
    L11:
        return false;
    L5:
        if (r2.mListDimensionBehaviors[r3] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L11;
        int[] r4 = r2.mResolvedMatchConstraintDefault;
        if (r4[r3] != 0) goto L9;
    L10:
        return true;
    L9:
        if (r4[r3] != 3) goto L11;
        goto L10
    }

    public void define() {
        if (this.mDefined == true) goto L5;
        defineChainProperties();
    L5:
        this.mDefined = true;
    }

    public ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public ConstraintWidget getHead() {
        return this.mHead;
    }

    public ConstraintWidget getLast() {
        return this.mLast;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }
}
