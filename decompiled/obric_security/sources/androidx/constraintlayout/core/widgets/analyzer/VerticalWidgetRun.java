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

    public VerticalWidgetRun(ConstraintWidget r2) {
        super(r2);
        this.baseline = new DependencyNode(this);
        this.baselineDimension = null;
        DependencyNode r3 = this.start;
        r3.type = DependencyNode.Type.TOP;
        DependencyNode r4 = this.end;
        r4.type = DependencyNode.Type.BOTTOM;
        DependencyNode r5 = this.baseline;
        r5.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    public String toString() {
        return "VerticalRun " + this.widget.getDebugName();
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

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r7) {
        int r0 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L12;
        updateRunCenter(r7, this.widget.mTop, this.widget.mBottom, 1);
        return;
    L12:
        if (this.dimension.readyToSolve == false) goto L40;
        if (this.dimension.resolved == true) goto L40;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L40;
        int r8 = this.widget.mMatchConstraintDefaultHeight;
        if (r8 == 2) goto L34;
        if (r8 != 3) goto L40;
        if (this.widget.horizontalRun.dimension.resolved == false) goto L40;
        int r9 = this.widget.getDimensionRatioSide();
        if (r9 == (-1)) goto L30;
        if (r9 == 0) goto L29;
        if (r9 == 1) goto L28;
        int r10 = 0;
    L33:
        this.dimension.resolve(r10);
        goto L40
    L28:
        float r11 = this.widget.horizontalRun.dimension.value;
        float r1 = this.widget.getDimensionRatio();
    L31:
        float r12 = r11 / r1;
    L32:
        r10 = (int) (r12 + 0.5f);
        goto L33
    L29:
        r12 = this.widget.horizontalRun.dimension.value * this.widget.getDimensionRatio();
        goto L32
    L30:
        r11 = this.widget.horizontalRun.dimension.value;
        r1 = this.widget.getDimensionRatio();
        goto L31
    L34:
        ConstraintWidget r13 = this.widget.getParent();
        if (r13 == null) goto L40;
        if (r13.verticalRun.dimension.resolved == false) goto L40;
        this.dimension.resolve((int) ((r13.verticalRun.dimension.value * this.widget.mMatchConstraintPercentHeight) + 0.5f));
    L40:
        if (this.start.readyToSolve == true) goto L42;
        return;
    L42:
        if (this.end.readyToSolve == true) goto L45;
        return;
    L45:
        if (this.start.resolved == false) goto L52;
        if (this.end.resolved == false) goto L52;
        if (this.dimension.resolved == false) goto L52;
        return;
    L52:
        if (this.dimension.resolved == true) goto L62;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        if (this.widget.mMatchConstraintDefaultWidth != 0) goto L62;
        if (this.widget.isInVerticalChain() == true) goto L62;
        DependencyNode r14 = this.start.targets.get(0);
        DependencyNode r2 = this.end.targets.get(0);
        int r15 = r14.value + this.start.margin;
        int r3 = r2.value + this.end.margin;
        this.start.resolve(r15);
        this.end.resolve(r3);
        this.dimension.resolve(r3 - r15);
        return;
    L62:
        if (this.dimension.resolved == true) goto L76;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L76;
        if (this.matchConstraintsType != 1) goto L76;
        if (this.start.targets.size() <= 0) goto L76;
        if (this.end.targets.size() <= 0) goto L76;
        DependencyNode r16 = this.start.targets.get(0);
        DependencyNode r4 = this.end.targets.get(0);
        int r5 = (r4.value + this.end.margin) - (r16.value + this.start.margin);
        if (r5 >= this.dimension.wrapValue) goto L74;
        this.dimension.resolve(r5);
        goto L76
    L74:
        this.dimension.resolve(this.dimension.wrapValue);
    L76:
        if (this.dimension.resolved == true) goto L79;
        return;
    L79:
        if (this.start.targets.size() > 0) goto L81;
        return;
    L81:
        if (this.end.targets.size() <= 0) goto L89;
        DependencyNode r17 = this.start.targets.get(0);
        DependencyNode r6 = this.end.targets.get(0);
        int r18 = r17.value + this.start.margin;
        int r19 = r6.value + this.end.margin;
        float r20 = this.widget.getVerticalBiasPercent();
        if (r17 != r6) goto L85;
        r18 = r17.value;
        r19 = r6.value;
        r20 = 0.5f;
    L85:
        this.start.resolve((int) ((r18 + 0.5f) + (((r19 - r18) - this.dimension.value) * r20)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L89:
        return;
    L9:
        updateRunEnd(r7);
        goto L12
    L10:
        updateRunStart(r7);
        goto L12
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        if (this.widget.measured == false) goto L6;
        this.dimension.resolve(this.widget.getHeight());
    L6:
        if (this.dimension.resolved == true) goto L24;
        this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
        if (this.widget.hasBaseline() == false) goto L11;
        this.baselineDimension = new BaselineDimensionDependency(this);
    L11:
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r0 = this.widget.getParent();
        if (r0 == null) goto L21;
        if (r0.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r1 = (r0.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
        addTarget(this.start, r0.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r0.verticalRun.end, -this.widget.mBottom.getMargin());
        this.dimension.resolve(r1);
        return;
    L21:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.dimension.resolve(this.widget.getHeight());
    L32:
        if (this.dimension.resolved == false) goto L82;
        if (this.widget.measured == false) goto L82;
        if (this.widget.mListAnchors[2].mTarget == null) goto L53;
        if (this.widget.mListAnchors[3].mTarget == null) goto L53;
        if (this.widget.isInVerticalChain() == false) goto L42;
        DependencyNode r2 = this.start;
        r2.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r3 = this.end;
        r3.margin = -this.widget.mListAnchors[3].getMargin();
    L50:
        if (this.widget.hasBaseline() == false) goto L160;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L160:
        return;
    L42:
        DependencyNode r4 = getTarget(this.widget.mListAnchors[2]);
        if (r4 == null) goto L45;
        addTarget(this.start, r4, this.widget.mListAnchors[2].getMargin());
    L45:
        DependencyNode r5 = getTarget(this.widget.mListAnchors[3]);
        if (r5 == null) goto L48;
        addTarget(this.end, r5, -this.widget.mListAnchors[3].getMargin());
    L48:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
    L53:
        if (this.widget.mListAnchors[2].mTarget == null) goto L60;
        DependencyNode r6 = getTarget(this.widget.mListAnchors[2]);
        if (r6 == null) goto L162;
        addTarget(this.start, r6, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == false) goto L163;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L163:
        return;
    L162:
        return;
    L60:
        if (this.widget.mListAnchors[3].mTarget == null) goto L68;
        DependencyNode r7 = getTarget(this.widget.mListAnchors[3]);
        if (r7 == null) goto L65;
        addTarget(this.end, r7, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
    L65:
        if (this.widget.hasBaseline() == false) goto L165;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L165:
        return;
    L68:
        if (this.widget.mListAnchors[4].mTarget == null) goto L73;
        DependencyNode r8 = getTarget(this.widget.mListAnchors[4]);
        if (r8 == null) goto L167;
        addTarget(this.baseline, r8, 0);
        addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L167:
        return;
    L73:
        if ((this.widget instanceof Helper) == false) goto L75;
        return;
    L75:
        if (this.widget.getParent() != null) goto L77;
        return;
    L77:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L171;
        DependencyNode r9 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r9, this.widget.getY());
        addTarget(this.end, this.start, this.dimension.value);
        if (this.widget.hasBaseline() == false) goto L172;
        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
        return;
    L172:
        return;
    L171:
        return;
    L82:
        if (this.dimension.resolved == false) goto L84;
    L99:
        this.dimension.addDependency(this);
    L101:
        if (this.widget.mListAnchors[2].mTarget == null) goto L117;
        if (this.widget.mListAnchors[3].mTarget == null) goto L117;
        if (this.widget.isInVerticalChain() == false) goto L107;
        DependencyNode r10 = this.start;
        r10.margin = this.widget.mListAnchors[2].getMargin();
        DependencyNode r11 = this.end;
        r11.margin = -this.widget.mListAnchors[3].getMargin();
    L114:
        if (this.widget.hasBaseline() == false) goto L157;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L157:
        if (this.dimension.targets.size() != 0) goto L174;
        this.dimension.readyToSolve = true;
        return;
    L174:
        return;
    L107:
        DependencyNode r12 = getTarget(this.widget.mListAnchors[2]);
        DependencyNode r13 = getTarget(this.widget.mListAnchors[3]);
        if (r12 == null) goto L110;
        r12.addDependency(this);
    L110:
        if (r13 == null) goto L112;
        r13.addDependency(this);
    L112:
        this.mRunType = WidgetRun.RunType.CENTER;
    L117:
        if (this.widget.mListAnchors[2].mTarget == null) goto L131;
        DependencyNode r14 = getTarget(this.widget.mListAnchors[2]);
        if (r14 == null) goto L157;
        addTarget(this.start, r14, this.widget.mListAnchors[2].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L124;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L124:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L157;
        if (this.widget.horizontalRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        this.widget.horizontalRun.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L157
    L131:
        if (this.widget.mListAnchors[3].mTarget == null) goto L138;
        DependencyNode r15 = getTarget(this.widget.mListAnchors[3]);
        if (r15 == null) goto L157;
        addTarget(this.end, r15, -this.widget.mListAnchors[3].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L157;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
        goto L157
    L138:
        if (this.widget.mListAnchors[4].mTarget == null) goto L143;
        DependencyNode r16 = getTarget(this.widget.mListAnchors[4]);
        if (r16 == null) goto L157;
        addTarget(this.baseline, r16, 0);
        addTarget(this.start, this.baseline, -1, this.baselineDimension);
        addTarget(this.end, this.start, 1, this.dimension);
        goto L157
    L143:
        if ((this.widget instanceof Helper) == true) goto L157;
        if (this.widget.getParent() == null) goto L157;
        DependencyNode r17 = this.widget.getParent().verticalRun.start;
        addTarget(this.start, r17, this.widget.getY());
        addTarget(this.end, this.start, 1, this.dimension);
        if (this.widget.hasBaseline() == false) goto L150;
        addTarget(this.baseline, this.start, 1, this.baselineDimension);
    L150:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        if (this.widget.getDimensionRatio() <= 0.0f) goto L157;
        if (this.widget.horizontalRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        this.widget.horizontalRun.dimension.dependencies.add(this.dimension);
        this.dimension.targets.add(this.widget.horizontalRun.dimension);
        this.dimension.updateDelegate = this;
        goto L157
    L84:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L99;
        int r18 = this.widget.mMatchConstraintDefaultHeight;
        if (r18 == 2) goto L95;
        if (r18 != 3) goto L101;
        if (this.widget.isInVerticalChain() == true) goto L101;
        if (this.widget.mMatchConstraintDefaultWidth == 3) goto L101;
        DimensionDependency r19 = this.widget.horizontalRun.dimension;
        this.dimension.targets.add(r19);
        r19.dependencies.add(this.dimension);
        this.dimension.delegateToWidgetRun = true;
        this.dimension.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L101
    L95:
        ConstraintWidget r20 = this.widget.getParent();
        if (r20 == null) goto L101;
        DimensionDependency r21 = r20.verticalRun.dimension;
        this.dimension.targets.add(r21);
        r21.dependencies.add(this.dimension);
        this.dimension.delegateToWidgetRun = true;
        this.dimension.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L101
    L24:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L32;
        ConstraintWidget r22 = this.widget.getParent();
        if (r22 == null) goto L32;
        if (r22.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        addTarget(this.start, r22.verticalRun.start, this.widget.mTop.getMargin());
        addTarget(this.end, r22.verticalRun.end, -this.widget.mBottom.getMargin());
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (this.start.resolved == false) goto L6;
        this.widget.setY(this.start.value);
        return;
    }
}
