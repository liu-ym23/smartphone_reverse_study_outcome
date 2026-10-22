package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;

/* JADX INFO: loaded from: classes.dex */
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    DimensionDependency baselineDimension;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
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

    public VerticalWidgetRun(ConstraintWidget r3) {
        super(r3);
        DependencyNode r4 = new DependencyNode(this);
        this.baseline = r4;
        this.baselineDimension = null;
        DependencyNode r0 = this.start;
        r0.type = DependencyNode.Type.TOP;
        DependencyNode r1 = this.end;
        r1.type = DependencyNode.Type.BOTTOM;
        r4.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        ConstraintWidget r0 = this.widget;
        if (r0.measured == false) goto L6;
        this.dimension.resolve(r0.getHeight());
    L6:
        if (this.dimension.resolved == true) goto L24;
        this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
        if (this.widget.hasBaseline() == false) goto L10;
        this.baselineDimension = new BaselineDimensionDependency(this);
    L10:
        ConstraintWidget.DimensionBehaviour r1 = this.dimensionBehavior;
        if (r1 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
    L31:
        DimensionDependency r2 = this.dimension;
        boolean r3 = r2.resolved;
        if (r3 == false) goto L82;
        ConstraintWidget r7 = this.widget;
        if (r7.measured == false) goto L82;
        ConstraintAnchor[] r4 = r7.mListAnchors;
        if (r4[2].mTarget == null) goto L54;
        if (r4[3].mTarget == null) goto L54;
        if (r7.isInVerticalChain() == false) goto L42;
        DependencyNode r5 = this.start;
        r5.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r6 = this.end;
        r6.margin = -this.widget.mListAnchors[3].getMargin();
    L50:
        if (this.widget.hasBaseline() == false) goto L162;
    L51:
        DependencyNode r8 = this.baseline;
        DependencyNode r9 = this.start;
        int r10 = this.widget.getBaselineDistance();
    L52:
        addTarget(r8, r9, r10);
        return;
    L162:
        return;
    L42:
        DependencyNode r11 = getTarget(this.widget.mListAnchors[2]);
        if (r11 == null) goto L45;
        addTarget(this.start, r11, this.widget.mListAnchors[2].getMargin());
    L45:
        DependencyNode r12 = getTarget(this.widget.mListAnchors[3]);
        if (r12 == null) goto L48;
        addTarget(this.end, r12, -this.widget.mListAnchors[3].getMargin());
    L48:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
    L54:
        if (r4[2].mTarget == null) goto L61;
        DependencyNode r13 = getTarget(r4[2]);
        if (r13 == null) goto L164;
        addTarget(this.start, r13, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == true) goto L51;
        return;
    L164:
        return;
    L61:
        if (r4[3].mTarget == null) goto L69;
        DependencyNode r14 = getTarget(r4[3]);
        if (r14 == null) goto L66;
        addTarget(this.end, r14, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
    L66:
        if (this.widget.hasBaseline() == true) goto L51;
        return;
    L69:
        if (r4[4].mTarget == null) goto L74;
        DependencyNode r15 = getTarget(r4[4]);
        if (r15 == null) goto L167;
        addTarget(this.baseline, r15, 0);
        addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
        r8 = this.end;
        r9 = this.start;
        r10 = this.dimension.value;
        goto L52
    L167:
        return;
    L74:
        if ((r7 instanceof Helper) == false) goto L76;
        return;
    L76:
        if (r7.getParent() != null) goto L78;
        return;
    L78:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L170;
        DependencyNode r16 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r16, this.widget.getY());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == true) goto L51;
        return;
    L170:
        return;
    L82:
        if (r3 == false) goto L84;
    L100:
        r2.addDependency(this);
    L101:
        ConstraintWidget r17 = this.widget;
        ConstraintAnchor[] r18 = r17.mListAnchors;
        if (r18[2].mTarget == null) goto L119;
        if (r18[3].mTarget == null) goto L119;
        if (r17.isInVerticalChain() == false) goto L108;
        DependencyNode r19 = this.start;
        r19.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r20 = this.end;
        r20.margin = -this.widget.mListAnchors[3].getMargin();
    L115:
        if (this.widget.hasBaseline() == false) goto L159;
    L116:
        DependencyNode r21 = this.baseline;
        DependencyNode r22 = this.start;
        DimensionDependency r23 = this.baselineDimension;
    L117:
        addTarget(r21, r22, 1, r23);
    L159:
        if (this.dimension.targets.size() != 0) goto L172;
        this.dimension.readyToSolve = true;
        return;
    L172:
        return;
    L108:
        DependencyNode r24 = getTarget(this.widget.mListAnchors[2]);
        DependencyNode r25 = getTarget(this.widget.mListAnchors[3]);
        if (r24 == null) goto L111;
        r24.addDependency(this);
    L111:
        if (r25 == null) goto L113;
        r25.addDependency(this);
    L113:
        this.mRunType = WidgetRun.RunType.CENTER;
    L119:
        if (r18[2].mTarget == null) goto L133;
        DependencyNode r26 = getTarget(r18[2]);
        if (r26 == null) goto L159;
        addTarget(this.start, r26, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L125;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L125:
        ConstraintWidget.DimensionBehaviour r27 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r28 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r27 != r28) goto L159;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L159;
        HorizontalWidgetRun r29 = this.widget.horizontalRun;
        if (r29.dimensionBehavior != r28) goto L159;
    L157:
        r29.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L159
    L133:
        if (r18[3].mTarget == null) goto L140;
        DependencyNode r30 = getTarget(r18[3]);
        if (r30 == null) goto L159;
        addTarget(this.end, r30, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L159;
    L140:
        if (r18[4].mTarget == null) goto L145;
        DependencyNode r31 = getTarget(r18[4]);
        if (r31 == null) goto L159;
        addTarget(this.baseline, r31, 0);
        addTarget(this.start, this.baseline, -1, this.baselineDimension);
        r21 = this.end;
        r22 = this.start;
        r23 = this.dimension;
        goto L117
    L145:
        if ((r17 instanceof Helper) == true) goto L159;
        if (r17.getParent() == null) goto L159;
        DependencyNode r32 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r32, this.widget.getY());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L151;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L151:
        ConstraintWidget.DimensionBehaviour r33 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r34 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r33 != r34) goto L159;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L159;
        r29 = this.widget.horizontalRun;
        if (r29.dimensionBehavior != r34) goto L159;
    L84:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L100;
        ConstraintWidget r35 = this.widget;
        int r36 = r35.mMatchConstraintDefaultHeight;
        if (r36 == 2) goto L95;
        if (r36 != 3) goto L101;
        if (r35.isInVerticalChain() == true) goto L101;
        ConstraintWidget r37 = this.widget;
        if (r37.mMatchConstraintDefaultWidth == 3) goto L101;
        WidgetRun r38 = r37.horizontalRun;
    L99:
        DimensionDependency r39 = r38.dimension;
        this.dimension.targets.add(r39);
        r39.dependencies.add(this.dimension);
        DimensionDependency r40 = this.dimension;
        r40.delegateToWidgetRun = true;
        r40.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L101
    L95:
        ConstraintWidget r41 = r35.getParent();
        if (r41 == null) goto L101;
        r38 = r41.verticalRun;
        goto L99
    L13:
        if (r1 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r42 = this.widget.getParent();
        if (r42 == null) goto L21;
        if (r42.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r43 = (r42.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
        addTarget(this.start, r42.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r42.verticalRun.end, -this.widget.mBottom.getMargin());
        this.dimension.resolve(r43);
        return;
    L21:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        this.dimension.resolve(this.widget.getHeight());
        goto L31
    L24:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L31;
        ConstraintWidget r44 = this.widget.getParent();
        if (r44 == null) goto L31;
        if (r44.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        addTarget(this.start, r44.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r44.verticalRun.end, -this.widget.mBottom.getMargin());
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode r0 = this.start;
        if (r0.resolved == false) goto L6;
        this.widget.setY(r0.value);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
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
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.widget.mMatchConstraintDefaultHeight != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public String toString() {
        return "VerticalRun " + this.widget.getDebugName();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r7) {
        int r0 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L11;
        ConstraintWidget r1 = this.widget;
        updateRunCenter(r7, r1.mTop, r1.mBottom, 1);
        return;
    L11:
        DimensionDependency r8 = this.dimension;
        if (r8.readyToSolve == true) goto L14;
    L37:
        DependencyNode r9 = this.start;
        if (r9.readyToSolve == false) goto L85;
        DependencyNode r2 = this.end;
        if (r2.readyToSolve == true) goto L43;
        return;
    L43:
        if (r9.resolved == false) goto L50;
        if (r2.resolved == false) goto L50;
        if (this.dimension.resolved == false) goto L50;
        return;
    L50:
        if (this.dimension.resolved == true) goto L60;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L60;
        ConstraintWidget r10 = this.widget;
        if (r10.mMatchConstraintDefaultWidth != 0) goto L60;
        if (r10.isInVerticalChain() == true) goto L60;
        DependencyNode r11 = this.start.targets.get(0);
        DependencyNode r3 = this.end.targets.get(0);
        int r12 = r11.value;
        DependencyNode r4 = this.start;
        int r13 = r12 + r4.margin;
        int r5 = r3.value + this.end.margin;
        r4.resolve(r13);
        this.end.resolve(r5);
        this.dimension.resolve(r5 - r13);
        return;
    L60:
        if (this.dimension.resolved == true) goto L74;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L74;
        if (this.matchConstraintsType != 1) goto L74;
        if (this.start.targets.size() <= 0) goto L74;
        if (this.end.targets.size() <= 0) goto L74;
        DependencyNode r14 = this.start.targets.get(0);
        DependencyNode r6 = this.end.targets.get(0);
        int r15 = (r6.value + this.end.margin) - (r14.value + this.start.margin);
        DimensionDependency r16 = this.dimension;
        int r17 = r16.wrapValue;
        if (r15 >= r17) goto L72;
        r16.resolve(r15);
        goto L74
    L72:
        r16.resolve(r17);
    L74:
        if (this.dimension.resolved == true) goto L77;
        return;
    L77:
        if (this.start.targets.size() > 0) goto L79;
        return;
    L79:
        if (this.end.targets.size() <= 0) goto L87;
        DependencyNode r18 = this.start.targets.get(0);
        DependencyNode r19 = this.end.targets.get(0);
        int r20 = r18.value + this.start.margin;
        int r21 = r19.value + this.end.margin;
        float r22 = this.widget.getVerticalBiasPercent();
        if (r18 != r19) goto L83;
        r20 = r18.value;
        r21 = r19.value;
        r22 = 0.5f;
    L83:
        this.start.resolve((int) ((r20 + 0.5f) + (((r21 - r20) - this.dimension.value) * r22)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L87:
        return;
    L85:
        return;
    L14:
        if (r8.resolved == true) goto L37;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L37;
        ConstraintWidget r23 = this.widget;
        int r24 = r23.mMatchConstraintDefaultHeight;
        if (r24 == 2) goto L32;
        if (r24 != 3) goto L37;
        if (r23.horizontalRun.dimension.resolved == false) goto L37;
        int r25 = r23.getDimensionRatioSide();
        if (r25 == (-1)) goto L29;
        if (r25 == 0) goto L28;
        if (r25 == 1) goto L29;
        int r26 = 0;
    L31:
        this.dimension.resolve(r26);
        goto L37
    L28:
        ConstraintWidget r27 = this.widget;
        float r28 = r27.horizontalRun.dimension.value * r27.getDimensionRatio();
    L30:
        r26 = (int) (r28 + 0.5f);
    L29:
        ConstraintWidget r29 = this.widget;
        r28 = r29.horizontalRun.dimension.value / r29.getDimensionRatio();
        goto L30
    L32:
        ConstraintWidget r30 = r23.getParent();
        if (r30 == null) goto L37;
        DimensionDependency r31 = r30.verticalRun.dimension;
        if (r31.resolved == false) goto L37;
        r26 = (int) ((r31.value * this.widget.mMatchConstraintPercentHeight) + 0.5f);
        goto L31
    L9:
        updateRunEnd(r7);
        goto L11
    L10:
        updateRunStart(r7);
        goto L11
    }
}
