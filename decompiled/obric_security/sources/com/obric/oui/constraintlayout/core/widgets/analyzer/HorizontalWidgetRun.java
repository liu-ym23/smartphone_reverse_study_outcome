package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.Helper;

/* JADX INFO: loaded from: classes3.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] sTempDimensions;

    /* JADX INFO: renamed from: com.obric.oui.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = null;

        static {
            int[] r0 = new int[WidgetRun.RunType.values().length];
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = r0;
            r0[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$oui$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        sTempDimensions = new int[2];
    }

    public HorizontalWidgetRun(ConstraintWidget r2) {
        super(r2);
        DependencyNode r3 = this.start;
        r3.mType = DependencyNode.Type.LEFT;
        DependencyNode r4 = this.end;
        r4.mType = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    public String toString() {
        return "HorizontalRun " + this.mWidget.getDebugName();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.mRunGroup = null;
        this.start.clear();
        this.end.clear();
        this.mDimension.clear();
        this.mResolved = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.mResolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.mDimension.resolved = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.mWidget.mMatchConstraintDefaultWidth != 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        if (this.mWidget.measured == false) goto L6;
        this.mDimension.resolve(this.mWidget.getWidth());
    L6:
        if (this.mDimension.resolved == true) goto L23;
        this.mDimensionBehavior = this.mWidget.getHorizontalDimensionBehaviour();
        if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L33;
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L20;
        ConstraintWidget r0 = this.mWidget.getParent();
        if (r0 == null) goto L20;
        if (r0.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L17:
        int r1 = (r0.getWidth() - this.mWidget.mLeft.getMargin()) - this.mWidget.mRight.getMargin();
        addTarget(this.start, r0.mHorizontalRun.start, this.mWidget.mLeft.getMargin());
        addTarget(this.end, r0.mHorizontalRun.end, -this.mWidget.mRight.getMargin());
        this.mDimension.resolve(r1);
        return;
    L16:
        if (r0.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L17;
    L20:
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L33;
        this.mDimension.resolve(this.mWidget.getWidth());
    L33:
        if (this.mDimension.resolved == false) goto L68;
        if (this.mWidget.measured == false) goto L68;
        if (this.mWidget.mListAnchors[0].mTarget == null) goto L51;
        if (this.mWidget.mListAnchors[1].mTarget == null) goto L51;
        if (this.mWidget.isInHorizontalChain() == false) goto L43;
        DependencyNode r2 = this.start;
        r2.mMargin = this.mWidget.mListAnchors[0].getMargin();
        DependencyNode r3 = this.end;
        r3.mMargin = -this.mWidget.mListAnchors[1].getMargin();
        return;
    L43:
        DependencyNode r4 = getTarget(this.mWidget.mListAnchors[0]);
        if (r4 == null) goto L46;
        addTarget(this.start, r4, this.mWidget.mListAnchors[0].getMargin());
    L46:
        DependencyNode r5 = getTarget(this.mWidget.mListAnchors[1]);
        if (r5 == null) goto L49;
        addTarget(this.end, r5, -this.mWidget.mListAnchors[1].getMargin());
    L49:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
        return;
    L51:
        if (this.mWidget.mListAnchors[0].mTarget == null) goto L56;
        DependencyNode r6 = getTarget(this.mWidget.mListAnchors[0]);
        if (r6 == null) goto L119;
        addTarget(this.start, r6, this.mWidget.mListAnchors[0].getMargin());
        addTarget(this.end, this.start, this.mDimension.value);
        return;
    L119:
        return;
    L56:
        if (this.mWidget.mListAnchors[1].mTarget == null) goto L61;
        DependencyNode r7 = getTarget(this.mWidget.mListAnchors[1]);
        if (r7 == null) goto L121;
        addTarget(this.end, r7, -this.mWidget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -this.mDimension.value);
        return;
    L121:
        return;
    L61:
        if ((this.mWidget instanceof Helper) == false) goto L63;
        return;
    L63:
        if (this.mWidget.getParent() != null) goto L65;
        return;
    L65:
        if (this.mWidget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L125;
        DependencyNode r8 = this.mWidget.getParent().mHorizontalRun.start;
        addTarget(this.start, r8, this.mWidget.getX());
        addTarget(this.end, this.start, this.mDimension.value);
        return;
    L125:
        return;
    L68:
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L89;
        int r9 = this.mWidget.mMatchConstraintDefaultWidth;
        if (r9 != 2) goto L72;
        ConstraintWidget r10 = this.mWidget.getParent();
        if (r10 == null) goto L89;
        DimensionDependency r11 = r10.mVerticalRun.mDimension;
        this.mDimension.mTargets.add(r11);
        r11.mDependencies.add(this.mDimension);
        this.mDimension.delegateToWidgetRun = true;
        this.mDimension.mDependencies.add(this.start);
        this.mDimension.mDependencies.add(this.end);
        goto L89
    L72:
        if (r9 != 3) goto L89;
        if (this.mWidget.mMatchConstraintDefaultHeight != 3) goto L83;
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        this.mWidget.mVerticalRun.start.updateDelegate = this;
        this.mWidget.mVerticalRun.end.updateDelegate = this;
        this.mDimension.updateDelegate = this;
        if (this.mWidget.isInVerticalChain() == false) goto L80;
        this.mDimension.mTargets.add(this.mWidget.mVerticalRun.mDimension);
        this.mWidget.mVerticalRun.mDimension.mDependencies.add(this.mDimension);
        this.mWidget.mVerticalRun.mDimension.updateDelegate = this;
        this.mDimension.mTargets.add(this.mWidget.mVerticalRun.start);
        this.mDimension.mTargets.add(this.mWidget.mVerticalRun.end);
        this.mWidget.mVerticalRun.start.mDependencies.add(this.mDimension);
        this.mWidget.mVerticalRun.end.mDependencies.add(this.mDimension);
        goto L89
    L80:
        if (this.mWidget.isInHorizontalChain() == false) goto L82;
        this.mWidget.mVerticalRun.mDimension.mTargets.add(this.mDimension);
        this.mDimension.mDependencies.add(this.mWidget.mVerticalRun.mDimension);
        goto L89
    L82:
        this.mWidget.mVerticalRun.mDimension.mTargets.add(this.mDimension);
        goto L89
    L83:
        DimensionDependency r12 = this.mWidget.mVerticalRun.mDimension;
        this.mDimension.mTargets.add(r12);
        r12.mDependencies.add(this.mDimension);
        this.mWidget.mVerticalRun.start.mDependencies.add(this.mDimension);
        this.mWidget.mVerticalRun.end.mDependencies.add(this.mDimension);
        this.mDimension.delegateToWidgetRun = true;
        this.mDimension.mDependencies.add(this.start);
        this.mDimension.mDependencies.add(this.end);
        this.start.mTargets.add(this.mDimension);
        this.end.mTargets.add(this.mDimension);
    L89:
        if (this.mWidget.mListAnchors[0].mTarget == null) goto L102;
        if (this.mWidget.mListAnchors[1].mTarget == null) goto L102;
        if (this.mWidget.isInHorizontalChain() == false) goto L95;
        DependencyNode r13 = this.start;
        r13.mMargin = this.mWidget.mListAnchors[0].getMargin();
        DependencyNode r14 = this.end;
        r14.mMargin = -this.mWidget.mListAnchors[1].getMargin();
        return;
    L95:
        DependencyNode r15 = getTarget(this.mWidget.mListAnchors[0]);
        DependencyNode r16 = getTarget(this.mWidget.mListAnchors[1]);
        if (r15 == null) goto L98;
        r15.addDependency(this);
    L98:
        if (r16 == null) goto L100;
        r16.addDependency(this);
    L100:
        this.mRunType = WidgetRun.RunType.CENTER;
        return;
    L102:
        if (this.mWidget.mListAnchors[0].mTarget == null) goto L107;
        DependencyNode r17 = getTarget(this.mWidget.mListAnchors[0]);
        if (r17 == null) goto L129;
        addTarget(this.start, r17, this.mWidget.mListAnchors[0].getMargin());
        addTarget(this.end, this.start, 1, this.mDimension);
        return;
    L129:
        return;
    L107:
        if (this.mWidget.mListAnchors[1].mTarget == null) goto L112;
        DependencyNode r18 = getTarget(this.mWidget.mListAnchors[1]);
        if (r18 == null) goto L131;
        addTarget(this.end, r18, -this.mWidget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -1, this.mDimension);
        return;
    L131:
        return;
    L112:
        if ((this.mWidget instanceof Helper) == false) goto L114;
        return;
    L114:
        if (this.mWidget.getParent() == null) goto L134;
        DependencyNode r19 = this.mWidget.getParent().mHorizontalRun.start;
        addTarget(this.start, r19, this.mWidget.getX());
        addTarget(this.end, this.start, 1, this.mDimension);
        return;
    L134:
        return;
    L23:
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L33;
        ConstraintWidget r20 = this.mWidget.getParent();
        if (r20 == null) goto L33;
        if (r20.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        addTarget(this.start, r20.mHorizontalRun.start, this.mWidget.mLeft.getMargin());
        addTarget(this.end, r20.mHorizontalRun.end, -this.mWidget.mRight.getMargin());
        return;
    L29:
        if (r20.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L33;
        goto L30
    }

    private void computeInsetRatio(int[] r2, int r3, int r4, int r5, int r6, float r7, int r8) {
        int r9 = r4 - r3;
        int r10 = r6 - r5;
        if (r8 == (-1)) goto L9;
        if (r8 == 0) goto L8;
        if (r8 != 1) goto L19;
        r2[0] = r9;
        r2[1] = (int) ((r9 * r7) + 0.5f);
        return;
    L19:
        return;
    L8:
        r2[0] = (int) ((r10 * r7) + 0.5f);
        r2[1] = r10;
        return;
    L9:
        int r1 = (int) ((r10 * r7) + 0.5f);
        int r11 = (int) ((r9 / r7) + 0.5f);
        if (r1 > r9) goto L12;
        r2[0] = r1;
        r2[1] = r10;
        return;
    L12:
        if (r11 > r10) goto L18;
        r2[0] = r9;
        r2[1] = r11;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r17) {
        int r0 = AnonymousClass1.$SwitchMap$com$obric$oui$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L12;
        updateRunCenter(r17, this.mWidget.mLeft, this.mWidget.mRight, 0);
        return;
    L12:
        if (this.mDimension.resolved == true) goto L137;
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L137;
        int r1 = this.mWidget.mMatchConstraintDefaultWidth;
        if (r1 == 2) goto L131;
        if (r1 != 3) goto L137;
        if (this.mWidget.mMatchConstraintDefaultHeight != 0) goto L22;
    L35:
        DependencyNode r12 = this.mWidget.mVerticalRun.start;
        DependencyNode r13 = this.mWidget.mVerticalRun.end;
        if (this.mWidget.mLeft.mTarget == null) goto L38;
        boolean r2 = true;
    L40:
        if (this.mWidget.mTop.mTarget == null) goto L42;
        boolean r3 = true;
    L44:
        if (this.mWidget.mRight.mTarget == null) goto L46;
        boolean r4 = true;
    L48:
        if (this.mWidget.mBottom.mTarget == null) goto L50;
        boolean r5 = true;
    L51:
        int r14 = this.mWidget.getDimensionRatioSide();
        if (r2 == false) goto L89;
        if (r3 == false) goto L89;
        if (r4 == false) goto L89;
        if (r5 == false) goto L89;
        float r15 = this.mWidget.getDimensionRatio();
        if (r12.resolved == false) goto L68;
        if (r13.resolved == false) goto L68;
        if (this.start.readyToSolve == true) goto L63;
        return;
    L63:
        if (this.end.readyToSolve == false) goto L181;
        computeInsetRatio(sTempDimensions, this.start.mTargets.get(0).value + this.start.mMargin, this.end.mTargets.get(0).value - this.end.mMargin, r12.value + r12.mMargin, r13.value - r13.mMargin, r15, r14);
        this.mDimension.resolve(sTempDimensions[0]);
        this.mWidget.mVerticalRun.mDimension.resolve(sTempDimensions[1]);
        return;
    L181:
        return;
    L68:
        if (this.start.resolved == false) goto L79;
        if (this.end.resolved == false) goto L79;
        if (r12.readyToSolve == true) goto L74;
        return;
    L74:
        if (r13.readyToSolve == false) goto L182;
        computeInsetRatio(sTempDimensions, this.start.value + this.start.mMargin, this.end.value - this.end.mMargin, r12.mTargets.get(0).value + r12.mMargin, r13.mTargets.get(0).value - r13.mMargin, r15, r14);
        this.mDimension.resolve(sTempDimensions[0]);
        this.mWidget.mVerticalRun.mDimension.resolve(sTempDimensions[1]);
        goto L79
    L182:
        return;
    L79:
        if (this.start.readyToSolve == true) goto L81;
        return;
    L81:
        if (this.end.readyToSolve == true) goto L83;
        return;
    L83:
        if (r12.readyToSolve == true) goto L85;
        return;
    L85:
        if (r13.readyToSolve == false) goto L185;
        computeInsetRatio(sTempDimensions, this.start.mTargets.get(0).value + this.start.mMargin, this.end.mTargets.get(0).value - this.end.mMargin, r12.mTargets.get(0).value + r12.mMargin, r13.mTargets.get(0).value - r13.mMargin, r15, r14);
        this.mDimension.resolve(sTempDimensions[0]);
        this.mWidget.mVerticalRun.mDimension.resolve(sTempDimensions[1]);
        goto L137
    L185:
        return;
    L89:
        if (r2 == false) goto L110;
        if (r4 == false) goto L110;
        if (this.start.readyToSolve == true) goto L94;
        return;
    L94:
        if (this.end.readyToSolve == false) goto L186;
        float r6 = this.mWidget.getDimensionRatio();
        int r7 = this.start.mTargets.get(0).value + this.start.mMargin;
        int r8 = this.end.mTargets.get(0).value - this.end.mMargin;
        if (r14 == (-1)) goto L105;
        if (r14 == 0) goto L105;
        if (r14 != 1) goto L137;
        int r9 = getLimitedDimension(r8 - r7, 0);
        int r10 = (int) ((r9 / r6) + 0.5f);
        int r11 = getLimitedDimension(r10, 1);
        if (r10 == r11) goto L104;
        r9 = (int) ((r11 * r6) + 0.5f);
    L104:
        this.mDimension.resolve(r9);
        this.mWidget.mVerticalRun.mDimension.resolve(r11);
    L105:
        int r16 = getLimitedDimension(r8 - r7, 0);
        int r18 = (int) ((r16 * r6) + 0.5f);
        int r19 = getLimitedDimension(r18, 1);
        if (r18 == r19) goto L108;
        r16 = (int) ((r19 / r6) + 0.5f);
    L108:
        this.mDimension.resolve(r16);
        this.mWidget.mVerticalRun.mDimension.resolve(r19);
        goto L137
    L186:
        return;
    L110:
        if (r3 == false) goto L137;
        if (r5 == false) goto L137;
        if (r12.readyToSolve == true) goto L115;
        return;
    L115:
        if (r13.readyToSolve == false) goto L187;
        float r20 = this.mWidget.getDimensionRatio();
        int r21 = r12.mTargets.get(0).value + r12.mMargin;
        int r22 = r13.mTargets.get(0).value - r13.mMargin;
        if (r14 == (-1)) goto L126;
        if (r14 == 0) goto L122;
        if (r14 == 1) goto L126;
    L122:
        int r23 = getLimitedDimension(r22 - r21, 1);
        int r24 = (int) ((r23 * r20) + 0.5f);
        int r25 = getLimitedDimension(r24, 0);
        if (r24 == r25) goto L125;
        r23 = (int) ((r25 / r20) + 0.5f);
    L125:
        this.mDimension.resolve(r25);
        this.mWidget.mVerticalRun.mDimension.resolve(r23);
    L126:
        int r26 = getLimitedDimension(r22 - r21, 1);
        int r27 = (int) ((r26 / r20) + 0.5f);
        int r28 = getLimitedDimension(r27, 0);
        if (r27 == r28) goto L129;
        r26 = (int) ((r28 * r20) + 0.5f);
    L129:
        this.mDimension.resolve(r28);
        this.mWidget.mVerticalRun.mDimension.resolve(r26);
        goto L137
    L187:
        return;
    L50:
        r5 = false;
        goto L51
    L46:
        r4 = false;
        goto L48
    L42:
        r3 = false;
        goto L44
    L38:
        r2 = false;
        goto L40
    L22:
        if (this.mWidget.mMatchConstraintDefaultHeight == 3) goto L35;
        int r29 = this.mWidget.getDimensionRatioSide();
        if (r29 == (-1)) goto L31;
        if (r29 == 0) goto L30;
        if (r29 == 1) goto L29;
        int r30 = 0;
    L34:
        this.mDimension.resolve(r30);
        goto L137
    L29:
        float r31 = this.mWidget.mVerticalRun.mDimension.value;
        float r32 = this.mWidget.getDimensionRatio();
    L32:
        float r33 = r31 * r32;
    L33:
        r30 = (int) (r33 + 0.5f);
        goto L34
    L30:
        r33 = this.mWidget.mVerticalRun.mDimension.value / this.mWidget.getDimensionRatio();
        goto L33
    L31:
        r31 = this.mWidget.mVerticalRun.mDimension.value;
        r32 = this.mWidget.getDimensionRatio();
        goto L32
    L131:
        ConstraintWidget r34 = this.mWidget.getParent();
        if (r34 == null) goto L137;
        if (r34.mHorizontalRun.mDimension.resolved == false) goto L137;
        this.mDimension.resolve((int) ((r34.mHorizontalRun.mDimension.value * this.mWidget.mMatchConstraintPercentWidth) + 0.5f));
    L137:
        if (this.start.readyToSolve == true) goto L139;
        return;
    L139:
        if (this.end.readyToSolve == true) goto L142;
        return;
    L142:
        if (this.start.resolved == false) goto L149;
        if (this.end.resolved == false) goto L149;
        if (this.mDimension.resolved == false) goto L149;
        return;
    L149:
        if (this.mDimension.resolved == true) goto L159;
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L159;
        if (this.mWidget.mMatchConstraintDefaultWidth != 0) goto L159;
        if (this.mWidget.isInHorizontalChain() == true) goto L159;
        DependencyNode r35 = this.start.mTargets.get(0);
        DependencyNode r36 = this.end.mTargets.get(0);
        int r37 = r35.value + this.start.mMargin;
        int r38 = r36.value + this.end.mMargin;
        this.start.resolve(r37);
        this.end.resolve(r38);
        this.mDimension.resolve(r38 - r37);
        return;
    L159:
        if (this.mDimension.resolved == true) goto L173;
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L173;
        if (this.matchConstraintsType != 1) goto L173;
        if (this.start.mTargets.size() <= 0) goto L173;
        if (this.end.mTargets.size() <= 0) goto L173;
        DependencyNode r39 = this.start.mTargets.get(0);
        DependencyNode r40 = this.end.mTargets.get(0);
        int r41 = Math.min((r40.value + this.end.mMargin) - (r39.value + this.start.mMargin), this.mDimension.wrapValue);
        int r42 = this.mWidget.mMatchConstraintMaxWidth;
        int r43 = Math.max(this.mWidget.mMatchConstraintMinWidth, r41);
        if (r42 <= 0) goto L171;
        r43 = Math.min(r42, r43);
    L171:
        this.mDimension.resolve(r43);
    L173:
        if (this.mDimension.resolved == true) goto L175;
        return;
    L175:
        DependencyNode r44 = this.start.mTargets.get(0);
        DependencyNode r45 = this.end.mTargets.get(0);
        int r46 = r44.value + this.start.mMargin;
        int r47 = r45.value + this.end.mMargin;
        float r48 = this.mWidget.getHorizontalBiasPercent();
        if (r44 != r45) goto L178;
        r46 = r44.value;
        r47 = r45.value;
        r48 = 0.5f;
    L178:
        this.start.resolve((int) ((r46 + 0.5f) + (((r47 - r46) - this.mDimension.value) * r48)));
        this.end.resolve(this.start.value + this.mDimension.value);
        return;
    L9:
        updateRunEnd(r17);
        goto L12
    L10:
        updateRunStart(r17);
        goto L12
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved == false) goto L6;
        this.mWidget.setX(this.start.value);
        return;
    }
}
