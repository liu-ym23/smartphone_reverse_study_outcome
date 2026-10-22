package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;

/* JADX INFO: loaded from: classes.dex */
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    DimensionDependency baselineDimension;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
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
    public void apply() {
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
        if (r3 == false) goto L80;
        ConstraintWidget r7 = this.widget;
        if (r7.measured == false) goto L80;
        ConstraintAnchor[] r4 = r7.mListAnchors;
        ConstraintAnchor r5 = r4[2];
        ConstraintAnchor r8 = r5.mTarget;
        if (r8 != null) goto L38;
    L52:
        if (r8 == null) goto L58;
        DependencyNode r6 = getTarget(r5);
        if (r6 == null) goto L160;
        addTarget(this.start, r6, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == false) goto L161;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L161:
        return;
    L160:
        return;
    L58:
        ConstraintAnchor r9 = r4[3];
        if (r9.mTarget == null) goto L66;
        DependencyNode r10 = getTarget(r9);
        if (r10 == null) goto L64;
        addTarget(this.end, r10, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
    L64:
        if (this.widget.hasBaseline() == false) goto L163;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L163:
        return;
    L66:
        ConstraintAnchor r11 = r4[4];
        if (r11.mTarget == null) goto L72;
        DependencyNode r12 = getTarget(r11);
        if (r12 == null) goto L165;
        addTarget(this.baseline, r12, 0);
        addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L165:
        return;
    L72:
        if ((r7 instanceof Helper) == false) goto L74;
        return;
    L74:
        if (r7.getParent() != null) goto L76;
        return;
    L76:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L169;
        DependencyNode r13 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r13, this.widget.getY());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == false) goto L170;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L170:
        return;
    L169:
        return;
    L38:
        if (r4[3].mTarget == null) goto L52;
        if (r7.isInVerticalChain() == false) goto L42;
        DependencyNode r14 = this.start;
        r14.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r15 = this.end;
        r15.margin = -this.widget.mListAnchors[3].getMargin();
    L50:
        if (this.widget.hasBaseline() == false) goto L158;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L158:
        return;
    L42:
        DependencyNode r16 = getTarget(this.widget.mListAnchors[2]);
        if (r16 == null) goto L45;
        addTarget(this.start, r16, this.widget.mListAnchors[2].getMargin());
    L45:
        DependencyNode r17 = getTarget(this.widget.mListAnchors[3]);
        if (r17 == null) goto L48;
        addTarget(this.end, r17, -this.widget.mListAnchors[3].getMargin());
    L48:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
    L80:
        if (r3 == false) goto L82;
    L97:
        r2.addDependency(this);
    L98:
        ConstraintWidget r18 = this.widget;
        ConstraintAnchor[] r19 = r18.mListAnchors;
        ConstraintAnchor r20 = r19[2];
        ConstraintAnchor r21 = r20.mTarget;
        if (r21 == null) goto L115;
        if (r19[3].mTarget == null) goto L115;
        if (r18.isInVerticalChain() == false) goto L105;
        DependencyNode r22 = this.start;
        r22.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r23 = this.end;
        r23.margin = -this.widget.mListAnchors[3].getMargin();
    L112:
        if (this.widget.hasBaseline() == false) goto L155;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L155:
        if (this.dimension.targets.size() != 0) goto L172;
        this.dimension.readyToSolve = true;
        return;
    L172:
        return;
    L105:
        DependencyNode r24 = getTarget(this.widget.mListAnchors[2]);
        DependencyNode r25 = getTarget(this.widget.mListAnchors[3]);
        if (r24 == null) goto L108;
        r24.addDependency(this);
    L108:
        if (r25 == null) goto L110;
        r25.addDependency(this);
    L110:
        this.mRunType = WidgetRun.RunType.CENTER;
    L115:
        if (r21 == null) goto L128;
        DependencyNode r26 = getTarget(r20);
        if (r26 == null) goto L155;
        addTarget(this.start, r26, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L121;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L121:
        ConstraintWidget.DimensionBehaviour r27 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r28 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r27 != r28) goto L155;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L155;
        HorizontalWidgetRun r29 = this.widget.horizontalRun;
        if (r29.dimensionBehavior != r28) goto L155;
        r29.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L155
    L128:
        ConstraintAnchor r30 = r19[3];
        if (r30.mTarget == null) goto L135;
        DependencyNode r31 = getTarget(r30);
        if (r31 == null) goto L155;
        addTarget(this.end, r31, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L155;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
        goto L155
    L135:
        ConstraintAnchor r32 = r19[4];
        if (r32.mTarget == null) goto L141;
        DependencyNode r33 = getTarget(r32);
        if (r33 == null) goto L155;
        addTarget(this.baseline, r33, 0);
        addTarget(this.start, this.baseline, -1, this.baselineDimension);
        addTarget(this.end, this.start, 1, this.dimension);
        goto L155
    L141:
        if ((r18 instanceof Helper) == true) goto L155;
        if (r18.getParent() == null) goto L155;
        DependencyNode r34 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r34, this.widget.getY());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L147;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L147:
        ConstraintWidget.DimensionBehaviour r35 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r36 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r35 != r36) goto L155;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L155;
        HorizontalWidgetRun r37 = this.widget.horizontalRun;
        if (r37.dimensionBehavior != r36) goto L155;
        r37.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L155
    L82:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L97;
        ConstraintWidget r38 = this.widget;
        int r39 = r38.mMatchConstraintDefaultHeight;
        if (r39 == 2) goto L93;
        if (r39 != 3) goto L98;
        if (r38.isInVerticalChain() == true) goto L98;
        ConstraintWidget r40 = this.widget;
        if (r40.mMatchConstraintDefaultWidth == 3) goto L98;
        DimensionDependency r41 = r40.horizontalRun.dimension;
        this.dimension.targets.add(r41);
        r41.dependencies.add(this.dimension);
        DimensionDependency r42 = this.dimension;
        r42.delegateToWidgetRun = true;
        r42.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L98
    L93:
        ConstraintWidget r43 = r38.getParent();
        if (r43 == null) goto L98;
        DimensionDependency r44 = r43.verticalRun.dimension;
        this.dimension.targets.add(r44);
        r44.dependencies.add(this.dimension);
        DimensionDependency r45 = this.dimension;
        r45.delegateToWidgetRun = true;
        r45.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L98
    L13:
        if (r1 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r46 = this.widget.getParent();
        if (r46 == null) goto L21;
        if (r46.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r47 = (r46.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
        addTarget(this.start, r46.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r46.verticalRun.end, -this.widget.mBottom.getMargin());
        this.dimension.resolve(r47);
        return;
    L21:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        this.dimension.resolve(this.widget.getHeight());
        goto L31
    L24:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L31;
        ConstraintWidget r48 = this.widget.getParent();
        if (r48 == null) goto L31;
        if (r48.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        addTarget(this.start, r48.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r48.verticalRun.end, -this.widget.mBottom.getMargin());
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode r0 = this.start;
        if (r0.resolved == false) goto L6;
        this.widget.setY(r0.value);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
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
    public boolean supportsWrapComputation() {
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
    L38:
        DependencyNode r9 = this.start;
        if (r9.readyToSolve == false) goto L86;
        DependencyNode r2 = this.end;
        if (r2.readyToSolve == true) goto L44;
        return;
    L44:
        if (r9.resolved == false) goto L51;
        if (r2.resolved == false) goto L51;
        if (this.dimension.resolved == false) goto L51;
        return;
    L51:
        if (this.dimension.resolved == true) goto L61;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L61;
        ConstraintWidget r10 = this.widget;
        if (r10.mMatchConstraintDefaultWidth != 0) goto L61;
        if (r10.isInVerticalChain() == true) goto L61;
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
    L61:
        if (this.dimension.resolved == true) goto L75;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L75;
        if (this.matchConstraintsType != 1) goto L75;
        if (this.start.targets.size() <= 0) goto L75;
        if (this.end.targets.size() <= 0) goto L75;
        DependencyNode r14 = this.start.targets.get(0);
        DependencyNode r6 = this.end.targets.get(0);
        int r15 = (r6.value + this.end.margin) - (r14.value + this.start.margin);
        DimensionDependency r16 = this.dimension;
        int r17 = r16.wrapValue;
        if (r15 >= r17) goto L73;
        r16.resolve(r15);
        goto L75
    L73:
        r16.resolve(r17);
    L75:
        if (this.dimension.resolved == true) goto L78;
        return;
    L78:
        if (this.start.targets.size() > 0) goto L80;
        return;
    L80:
        if (this.end.targets.size() <= 0) goto L88;
        DependencyNode r18 = this.start.targets.get(0);
        DependencyNode r19 = this.end.targets.get(0);
        int r20 = r18.value + this.start.margin;
        int r21 = r19.value + this.end.margin;
        float r22 = this.widget.getVerticalBiasPercent();
        if (r18 != r19) goto L84;
        r20 = r18.value;
        r21 = r19.value;
        r22 = 0.5f;
    L84:
        float r23 = r20 + 0.5f;
        this.start.resolve((int) ((((r21 - r20) - this.dimension.value) * r22) + r23));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L88:
        return;
    L86:
        return;
    L14:
        if (r8.resolved == true) goto L38;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L38;
        ConstraintWidget r24 = this.widget;
        int r25 = r24.mMatchConstraintDefaultHeight;
        if (r25 == 2) goto L33;
        if (r25 != 3) goto L38;
        if (r24.horizontalRun.dimension.resolved == false) goto L38;
        int r26 = r24.getDimensionRatioSide();
        if (r26 == (-1)) goto L31;
        if (r26 == 0) goto L30;
        if (r26 == 1) goto L28;
        int r27 = 0;
    L32:
        this.dimension.resolve(r27);
        goto L38
    L28:
        ConstraintWidget r28 = this.widget;
        float r29 = r28.horizontalRun.dimension.value;
        float r30 = r28.getDimensionRatio();
    L29:
        r27 = (int) ((r29 / r30) + 0.5f);
        goto L32
    L30:
        ConstraintWidget r31 = this.widget;
        r27 = (int) ((r31.getDimensionRatio() * r31.horizontalRun.dimension.value) + 0.5f);
        goto L32
    L31:
        ConstraintWidget r32 = this.widget;
        r29 = r32.horizontalRun.dimension.value;
        r30 = r32.getDimensionRatio();
        goto L29
    L33:
        ConstraintWidget r33 = r24.getParent();
        if (r33 == null) goto L38;
        DimensionDependency r34 = r33.verticalRun.dimension;
        if (r34.resolved == false) goto L38;
        this.dimension.resolve((int) ((r34.value * this.widget.mMatchConstraintPercentHeight) + 0.5f));
        goto L38
    L9:
        updateRunEnd(r7);
        goto L11
    L10:
        updateRunStart(r7);
        goto L11
    }
}
