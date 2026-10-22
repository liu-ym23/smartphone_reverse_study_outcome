package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = null;

        static {
            int[] r0 = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = r0;
            r0[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        tempDimensions = new int[2];
    }

    public HorizontalWidgetRun(ConstraintWidget r2) {
        super(r2);
        DependencyNode r3 = this.start;
        r3.type = DependencyNode.Type.LEFT;
        DependencyNode r4 = this.end;
        r4.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    public String toString() {
        return "HorizontalRun " + this.widget.getDebugName();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.widget.mMatchConstraintDefaultWidth != 0) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        if (this.widget.measured == false) goto L6;
        this.dimension.resolve(this.widget.getWidth());
    L6:
        if (this.dimension.resolved == true) goto L23;
        this.dimensionBehavior = this.widget.getHorizontalDimensionBehaviour();
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L33;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L20;
        ConstraintWidget r0 = this.widget.getParent();
        if (r0 == null) goto L20;
        if (r0.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L17:
        int r1 = (r0.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
        addTarget(this.start, r0.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r0.horizontalRun.end, -this.widget.mRight.getMargin());
        this.dimension.resolve(r1);
        return;
    L16:
        if (r0.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L17;
    L20:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L33;
        this.dimension.resolve(this.widget.getWidth());
    L33:
        if (this.dimension.resolved == false) goto L68;
        if (this.widget.measured == false) goto L68;
        if (this.widget.mListAnchors[0].mTarget == null) goto L51;
        if (this.widget.mListAnchors[1].mTarget == null) goto L51;
        if (this.widget.isInHorizontalChain() == false) goto L43;
        DependencyNode r2 = this.start;
        r2.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r3 = this.end;
        r3.margin = -this.widget.mListAnchors[1].getMargin();
        return;
    L43:
        DependencyNode r4 = getTarget(this.widget.mListAnchors[0]);
        if (r4 == null) goto L46;
        addTarget(this.start, r4, this.widget.mListAnchors[0].getMargin());
    L46:
        DependencyNode r5 = getTarget(this.widget.mListAnchors[1]);
        if (r5 == null) goto L49;
        addTarget(this.end, r5, -this.widget.mListAnchors[1].getMargin());
    L49:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
        return;
    L51:
        if (this.widget.mListAnchors[0].mTarget == null) goto L56;
        DependencyNode r6 = getTarget(this.widget.mListAnchors[0]);
        if (r6 == null) goto L119;
        addTarget(this.start, r6, this.widget.mListAnchors[0].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L119:
        return;
    L56:
        if (this.widget.mListAnchors[1].mTarget == null) goto L61;
        DependencyNode r7 = getTarget(this.widget.mListAnchors[1]);
        if (r7 == null) goto L121;
        addTarget(this.end, r7, -this.widget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
        return;
    L121:
        return;
    L61:
        if ((this.widget instanceof Helper) == false) goto L63;
        return;
    L63:
        if (this.widget.getParent() != null) goto L65;
        return;
    L65:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L125;
        DependencyNode r8 = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, r8, this.widget.getX());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L125:
        return;
    L68:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L89;
        int r9 = this.widget.mMatchConstraintDefaultWidth;
        if (r9 != 2) goto L72;
        ConstraintWidget r10 = this.widget.getParent();
        if (r10 == null) goto L89;
        DimensionDependency r11 = r10.verticalRun.dimension;
        this.dimension.targets.add(r11);
        r11.dependencies.add(this.dimension);
        this.dimension.delegateToWidgetRun = true;
        this.dimension.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L89
    L72:
        if (r9 != 3) goto L89;
        if (this.widget.mMatchConstraintDefaultHeight != 3) goto L83;
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        this.widget.verticalRun.start.updateDelegate = this;
        this.widget.verticalRun.end.updateDelegate = this;
        this.dimension.updateDelegate = this;
        if (this.widget.isInVerticalChain() == false) goto L80;
        this.dimension.targets.add(this.widget.verticalRun.dimension);
        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
        this.widget.verticalRun.dimension.updateDelegate = this;
        this.dimension.targets.add(this.widget.verticalRun.start);
        this.dimension.targets.add(this.widget.verticalRun.end);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        goto L89
    L80:
        if (this.widget.isInHorizontalChain() == false) goto L82;
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        this.dimension.dependencies.add(this.widget.verticalRun.dimension);
        goto L89
    L82:
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        goto L89
    L83:
        DimensionDependency r12 = this.widget.verticalRun.dimension;
        this.dimension.targets.add(r12);
        r12.dependencies.add(this.dimension);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        this.dimension.delegateToWidgetRun = true;
        this.dimension.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        this.start.targets.add(this.dimension);
        this.end.targets.add(this.dimension);
    L89:
        if (this.widget.mListAnchors[0].mTarget == null) goto L102;
        if (this.widget.mListAnchors[1].mTarget == null) goto L102;
        if (this.widget.isInHorizontalChain() == false) goto L95;
        DependencyNode r13 = this.start;
        r13.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r14 = this.end;
        r14.margin = -this.widget.mListAnchors[1].getMargin();
        return;
    L95:
        DependencyNode r15 = getTarget(this.widget.mListAnchors[0]);
        DependencyNode r16 = getTarget(this.widget.mListAnchors[1]);
        if (r15 == null) goto L98;
        r15.addDependency(this);
    L98:
        if (r16 == null) goto L100;
        r16.addDependency(this);
    L100:
        this.mRunType = WidgetRun.RunType.CENTER;
        return;
    L102:
        if (this.widget.mListAnchors[0].mTarget == null) goto L107;
        DependencyNode r17 = getTarget(this.widget.mListAnchors[0]);
        if (r17 == null) goto L129;
        addTarget(this.start, r17, this.widget.mListAnchors[0].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        return;
    L129:
        return;
    L107:
        if (this.widget.mListAnchors[1].mTarget == null) goto L112;
        DependencyNode r18 = getTarget(this.widget.mListAnchors[1]);
        if (r18 == null) goto L131;
        addTarget(this.end, r18, -this.widget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        return;
    L131:
        return;
    L112:
        if ((this.widget instanceof Helper) == false) goto L114;
        return;
    L114:
        if (this.widget.getParent() == null) goto L134;
        DependencyNode r19 = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, r19, this.widget.getX());
        addTarget(this.end, this.start, 1, this.dimension);
        return;
    L134:
        return;
    L23:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L33;
        ConstraintWidget r20 = this.widget.getParent();
        if (r20 == null) goto L33;
        if (r20.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        addTarget(this.start, r20.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r20.horizontalRun.end, -this.widget.mRight.getMargin());
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

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r17) {
        int r0 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L12;
        updateRunCenter(r17, this.widget.mLeft, this.widget.mRight, 0);
        return;
    L12:
        if (this.dimension.resolved == true) goto L137;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L137;
        int r1 = this.widget.mMatchConstraintDefaultWidth;
        if (r1 == 2) goto L131;
        if (r1 != 3) goto L137;
        if (this.widget.mMatchConstraintDefaultHeight != 0) goto L22;
    L35:
        DependencyNode r12 = this.widget.verticalRun.start;
        DependencyNode r13 = this.widget.verticalRun.end;
        if (this.widget.mLeft.mTarget == null) goto L38;
        boolean r2 = true;
    L40:
        if (this.widget.mTop.mTarget == null) goto L42;
        boolean r3 = true;
    L44:
        if (this.widget.mRight.mTarget == null) goto L46;
        boolean r4 = true;
    L48:
        if (this.widget.mBottom.mTarget == null) goto L50;
        boolean r5 = true;
    L51:
        int r14 = this.widget.getDimensionRatioSide();
        if (r2 == false) goto L89;
        if (r3 == false) goto L89;
        if (r4 == false) goto L89;
        if (r5 == false) goto L89;
        float r15 = this.widget.getDimensionRatio();
        if (r12.resolved == false) goto L68;
        if (r13.resolved == false) goto L68;
        if (this.start.readyToSolve == true) goto L63;
        return;
    L63:
        if (this.end.readyToSolve == false) goto L181;
        computeInsetRatio(tempDimensions, this.start.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, r12.value + r12.margin, r13.value - r13.margin, r15, r14);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
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
        computeInsetRatio(tempDimensions, this.start.value + this.start.margin, this.end.value - this.end.margin, r12.targets.get(0).value + r12.margin, r13.targets.get(0).value - r13.margin, r15, r14);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
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
        computeInsetRatio(tempDimensions, this.start.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, r12.targets.get(0).value + r12.margin, r13.targets.get(0).value - r13.margin, r15, r14);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
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
        float r6 = this.widget.getDimensionRatio();
        int r7 = this.start.targets.get(0).value + this.start.margin;
        int r8 = this.end.targets.get(0).value - this.end.margin;
        if (r14 == (-1)) goto L105;
        if (r14 == 0) goto L105;
        if (r14 != 1) goto L137;
        int r9 = getLimitedDimension(r8 - r7, 0);
        int r10 = (int) ((r9 / r6) + 0.5f);
        int r11 = getLimitedDimension(r10, 1);
        if (r10 == r11) goto L104;
        r9 = (int) ((r11 * r6) + 0.5f);
    L104:
        this.dimension.resolve(r9);
        this.widget.verticalRun.dimension.resolve(r11);
    L105:
        int r16 = getLimitedDimension(r8 - r7, 0);
        int r18 = (int) ((r16 * r6) + 0.5f);
        int r19 = getLimitedDimension(r18, 1);
        if (r18 == r19) goto L108;
        r16 = (int) ((r19 / r6) + 0.5f);
    L108:
        this.dimension.resolve(r16);
        this.widget.verticalRun.dimension.resolve(r19);
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
        float r20 = this.widget.getDimensionRatio();
        int r21 = r12.targets.get(0).value + r12.margin;
        int r22 = r13.targets.get(0).value - r13.margin;
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
        this.dimension.resolve(r25);
        this.widget.verticalRun.dimension.resolve(r23);
    L126:
        int r26 = getLimitedDimension(r22 - r21, 1);
        int r27 = (int) ((r26 / r20) + 0.5f);
        int r28 = getLimitedDimension(r27, 0);
        if (r27 == r28) goto L129;
        r26 = (int) ((r28 * r20) + 0.5f);
    L129:
        this.dimension.resolve(r28);
        this.widget.verticalRun.dimension.resolve(r26);
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
        if (this.widget.mMatchConstraintDefaultHeight == 3) goto L35;
        int r29 = this.widget.getDimensionRatioSide();
        if (r29 == (-1)) goto L31;
        if (r29 == 0) goto L30;
        if (r29 == 1) goto L29;
        int r30 = 0;
    L34:
        this.dimension.resolve(r30);
        goto L137
    L29:
        float r31 = this.widget.verticalRun.dimension.value;
        float r32 = this.widget.getDimensionRatio();
    L32:
        float r33 = r31 * r32;
    L33:
        r30 = (int) (r33 + 0.5f);
        goto L34
    L30:
        r33 = this.widget.verticalRun.dimension.value / this.widget.getDimensionRatio();
        goto L33
    L31:
        r31 = this.widget.verticalRun.dimension.value;
        r32 = this.widget.getDimensionRatio();
        goto L32
    L131:
        ConstraintWidget r34 = this.widget.getParent();
        if (r34 == null) goto L137;
        if (r34.horizontalRun.dimension.resolved == false) goto L137;
        this.dimension.resolve((int) ((r34.horizontalRun.dimension.value * this.widget.mMatchConstraintPercentWidth) + 0.5f));
    L137:
        if (this.start.readyToSolve == true) goto L139;
        return;
    L139:
        if (this.end.readyToSolve == true) goto L142;
        return;
    L142:
        if (this.start.resolved == false) goto L149;
        if (this.end.resolved == false) goto L149;
        if (this.dimension.resolved == false) goto L149;
        return;
    L149:
        if (this.dimension.resolved == true) goto L159;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L159;
        if (this.widget.mMatchConstraintDefaultWidth != 0) goto L159;
        if (this.widget.isInHorizontalChain() == true) goto L159;
        DependencyNode r35 = this.start.targets.get(0);
        DependencyNode r36 = this.end.targets.get(0);
        int r37 = r35.value + this.start.margin;
        int r38 = r36.value + this.end.margin;
        this.start.resolve(r37);
        this.end.resolve(r38);
        this.dimension.resolve(r38 - r37);
        return;
    L159:
        if (this.dimension.resolved == true) goto L173;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L173;
        if (this.matchConstraintsType != 1) goto L173;
        if (this.start.targets.size() <= 0) goto L173;
        if (this.end.targets.size() <= 0) goto L173;
        DependencyNode r39 = this.start.targets.get(0);
        DependencyNode r40 = this.end.targets.get(0);
        int r41 = Math.min((r40.value + this.end.margin) - (r39.value + this.start.margin), this.dimension.wrapValue);
        int r42 = this.widget.mMatchConstraintMaxWidth;
        int r43 = Math.max(this.widget.mMatchConstraintMinWidth, r41);
        if (r42 <= 0) goto L171;
        r43 = Math.min(r42, r43);
    L171:
        this.dimension.resolve(r43);
    L173:
        if (this.dimension.resolved == true) goto L175;
        return;
    L175:
        DependencyNode r44 = this.start.targets.get(0);
        DependencyNode r45 = this.end.targets.get(0);
        int r46 = r44.value + this.start.margin;
        int r47 = r45.value + this.end.margin;
        float r48 = this.widget.getHorizontalBiasPercent();
        if (r44 != r45) goto L178;
        r46 = r44.value;
        r47 = r45.value;
        r48 = 0.5f;
    L178:
        this.start.resolve((int) ((r46 + 0.5f) + (((r47 - r46) - this.dimension.value) * r48)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L9:
        updateRunEnd(r17);
        goto L12
    L10:
        updateRunStart(r17);
        goto L12
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved == false) goto L6;
        this.widget.setX(this.start.value);
        return;
    }
}
