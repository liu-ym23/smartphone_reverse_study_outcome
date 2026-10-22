package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import java.util.List;

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

    private void computeInsetRatio(int[] r2, int r3, int r4, int r5, int r6, float r7, int r8) {
        int r9 = r4 - r3;
        int r10 = r6 - r5;
        if (r8 == (-1)) goto L9;
        if (r8 == 0) goto L8;
        if (r8 != 1) goto L22;
        r2[0] = r9;
        r2[1] = (int) ((r9 * r7) + 0.5f);
        return;
    L22:
        return;
    L8:
        r2[0] = (int) ((r10 * r7) + 0.5f);
        r2[1] = r10;
        return;
    L9:
        int r1 = (int) ((r10 * r7) + 0.5f);
        int r11 = (int) ((r9 / r7) + 0.5f);
        if (r1 > r9) goto L13;
        if (r10 > r10) goto L13;
        r2[0] = r1;
        r2[1] = r10;
        return;
    L13:
        if (r9 > r9) goto L20;
        if (r11 > r10) goto L21;
        r2[0] = r9;
        r2[1] = r11;
        return;
    L21:
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        ConstraintWidget r0 = this.widget;
        if (r0.measured == false) goto L6;
        this.dimension.resolve(r0.getWidth());
    L6:
        if (this.dimension.resolved == true) goto L22;
        ConstraintWidget.DimensionBehaviour r1 = this.widget.getHorizontalDimensionBehaviour();
        this.dimensionBehavior = r1;
        if (r1 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r1 != r2) goto L20;
        ConstraintWidget r3 = this.widget.getParent();
        if (r3 == null) goto L20;
        if (r3.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L17:
        int r4 = (r3.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
        addTarget(this.start, r3.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r3.horizontalRun.end, -this.widget.mRight.getMargin());
        this.dimension.resolve(r4);
        return;
    L16:
        if (r3.getHorizontalDimensionBehaviour() == r2) goto L17;
    L20:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.dimension.resolve(this.widget.getWidth());
    L32:
        DimensionDependency r5 = this.dimension;
        if (r5.resolved == false) goto L70;
        ConstraintWidget r6 = this.widget;
        if (r6.measured == false) goto L70;
        ConstraintAnchor[] r7 = r6.mListAnchors;
        if (r7[0].mTarget == null) goto L51;
        if (r7[1].mTarget == null) goto L51;
        if (r6.isInHorizontalChain() == false) goto L43;
        DependencyNode r8 = this.start;
        r8.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r9 = this.end;
        ConstraintAnchor r10 = this.widget.mListAnchors[1];
    L100:
        r9.margin = -r10.getMargin();
        return;
    L43:
        DependencyNode r11 = getTarget(this.widget.mListAnchors[0]);
        if (r11 == null) goto L46;
        addTarget(this.start, r11, this.widget.mListAnchors[0].getMargin());
    L46:
        DependencyNode r12 = getTarget(this.widget.mListAnchors[1]);
        if (r12 == null) goto L49;
        addTarget(this.end, r12, -this.widget.mListAnchors[1].getMargin());
    L49:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
        return;
    L51:
        if (r7[0].mTarget == null) goto L56;
        DependencyNode r13 = getTarget(r7[0]);
        if (r13 == null) goto L125;
        DependencyNode r14 = this.start;
        int r15 = this.widget.mListAnchors[0].getMargin();
    L67:
        addTarget(r14, r13, r15);
        DependencyNode r16 = this.end;
        DependencyNode r17 = this.start;
        int r18 = this.dimension.value;
    L68:
        addTarget(r16, r17, r18);
        return;
    L125:
        return;
    L56:
        if (r7[1].mTarget == null) goto L61;
        DependencyNode r19 = getTarget(r7[1]);
        if (r19 == null) goto L126;
        addTarget(this.end, r19, -this.widget.mListAnchors[1].getMargin());
        r16 = this.start;
        r17 = this.end;
        r18 = -this.dimension.value;
        goto L68
    L126:
        return;
    L61:
        if ((r6 instanceof Helper) == false) goto L63;
        return;
    L63:
        if (r6.getParent() != null) goto L65;
        return;
    L65:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L129;
        r13 = this.widget.getParent().horizontalRun.start;
        r14 = this.start;
        r15 = this.widget.getX();
        goto L67
    L129:
        return;
    L70:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L93;
        ConstraintWidget r20 = this.widget;
        int r21 = r20.mMatchConstraintDefaultWidth;
        if (r21 != 2) goto L74;
        ConstraintWidget r22 = r20.getParent();
        if (r22 == null) goto L93;
        DimensionDependency r23 = r22.verticalRun.dimension;
        this.dimension.targets.add(r23);
        r23.dependencies.add(this.dimension);
        DimensionDependency r24 = this.dimension;
        r24.delegateToWidgetRun = true;
        r24.dependencies.add(this.start);
        List<Dependency> r25 = this.dimension.dependencies;
        Dependency r26 = this.end;
    L92:
        r25.add(r26);
        goto L93
    L74:
        if (r21 != 3) goto L93;
        if (r20.mMatchConstraintDefaultHeight != 3) goto L85;
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        VerticalWidgetRun r27 = r20.verticalRun;
        r27.start.updateDelegate = this;
        r27.end.updateDelegate = this;
        r5.updateDelegate = this;
        if (r20.isInVerticalChain() == false) goto L82;
        this.dimension.targets.add(this.widget.verticalRun.dimension);
        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
        VerticalWidgetRun r28 = this.widget.verticalRun;
        r28.dimension.updateDelegate = this;
        this.dimension.targets.add(r28.start);
        this.dimension.targets.add(this.widget.verticalRun.end);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        r25 = this.widget.verticalRun.end.dependencies;
    L87:
        r26 = this.dimension;
        goto L92
    L82:
        if (this.widget.isInHorizontalChain() == false) goto L84;
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        r25 = this.dimension.dependencies;
        r26 = this.widget.verticalRun.dimension;
        goto L92
    L84:
        DependencyNode r29 = this.widget.verticalRun.dimension;
    L86:
        r25 = r29.targets;
        goto L87
    L85:
        DimensionDependency r30 = r20.verticalRun.dimension;
        r5.targets.add(r30);
        r30.dependencies.add(this.dimension);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        DimensionDependency r31 = this.dimension;
        r31.delegateToWidgetRun = true;
        r31.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        this.start.targets.add(this.dimension);
        r29 = this.end;
    L93:
        ConstraintWidget r32 = this.widget;
        ConstraintAnchor[] r33 = r32.mListAnchors;
        if (r33[0].mTarget == null) goto L108;
        if (r33[1].mTarget == null) goto L108;
        if (r32.isInHorizontalChain() == false) goto L101;
        DependencyNode r34 = this.start;
        r34.margin = this.widget.mListAnchors[0].getMargin();
        r9 = this.end;
        r10 = this.widget.mListAnchors[1];
        goto L100
    L101:
        DependencyNode r35 = getTarget(this.widget.mListAnchors[0]);
        DependencyNode r36 = getTarget(this.widget.mListAnchors[1]);
        if (r35 == null) goto L104;
        r35.addDependency(this);
    L104:
        if (r36 == null) goto L106;
        r36.addDependency(this);
    L106:
        this.mRunType = WidgetRun.RunType.CENTER;
        return;
    L108:
        if (r33[0].mTarget == null) goto L113;
        DependencyNode r37 = getTarget(r33[0]);
        if (r37 == null) goto L133;
        DependencyNode r38 = this.start;
        int r39 = this.widget.mListAnchors[0].getMargin();
    L122:
        addTarget(r38, r37, r39);
        addTarget(this.end, this.start, 1, this.dimension);
        return;
    L133:
        return;
    L113:
        if (r33[1].mTarget == null) goto L118;
        DependencyNode r40 = getTarget(r33[1]);
        if (r40 == null) goto L134;
        addTarget(this.end, r40, -this.widget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        return;
    L134:
        return;
    L118:
        if ((r32 instanceof Helper) == false) goto L120;
        return;
    L120:
        if (r32.getParent() == null) goto L137;
        r37 = this.widget.getParent().horizontalRun.start;
        r38 = this.start;
        r39 = this.widget.getX();
        goto L122
    L137:
        return;
    L22:
        ConstraintWidget.DimensionBehaviour r41 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r42 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r41 != r42) goto L32;
        ConstraintWidget r43 = this.widget.getParent();
        if (r43 == null) goto L32;
        if (r43.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        addTarget(this.start, r43.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r43.horizontalRun.end, -this.widget.mRight.getMargin());
        return;
    L29:
        if (r43.getHorizontalDimensionBehaviour() != r42) goto L32;
        goto L30
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode r0 = this.start;
        if (r0.resolved == false) goto L6;
        this.widget.setX(r0.value);
        return;
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

    public String toString() {
        return "HorizontalRun " + this.widget.getDebugName();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r17) {
        int r0 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L12;
        ConstraintWidget r1 = this.widget;
        updateRunCenter(r17, r1.mLeft, r1.mRight, 0);
        return;
    L12:
        if (this.dimension.resolved == false) goto L14;
    L134:
        DependencyNode r2 = this.start;
        if (r2.readyToSolve == false) goto L186;
        DependencyNode r3 = this.end;
        if (r3.readyToSolve == true) goto L140;
        return;
    L140:
        if (r2.resolved == false) goto L147;
        if (r3.resolved == false) goto L147;
        if (this.dimension.resolved == false) goto L147;
        return;
    L147:
        if (this.dimension.resolved == true) goto L157;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L157;
        ConstraintWidget r4 = this.widget;
        if (r4.mMatchConstraintDefaultWidth != 0) goto L157;
        if (r4.isInHorizontalChain() == true) goto L157;
        DependencyNode r5 = this.start.targets.get(0);
        DependencyNode r6 = this.end.targets.get(0);
        int r7 = r5.value;
        DependencyNode r8 = this.start;
        int r9 = r7 + r8.margin;
        int r10 = r6.value + this.end.margin;
        r8.resolve(r9);
        this.end.resolve(r10);
        this.dimension.resolve(r10 - r9);
        return;
    L157:
        if (this.dimension.resolved == true) goto L171;
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L171;
        if (this.matchConstraintsType != 1) goto L171;
        if (this.start.targets.size() <= 0) goto L171;
        if (this.end.targets.size() <= 0) goto L171;
        DependencyNode r11 = this.start.targets.get(0);
        DependencyNode r12 = this.end.targets.get(0);
        int r13 = Math.min((r12.value + this.end.margin) - (r11.value + this.start.margin), this.dimension.wrapValue);
        ConstraintWidget r14 = this.widget;
        int r15 = r14.mMatchConstraintMaxWidth;
        int r16 = Math.max(r14.mMatchConstraintMinWidth, r13);
        if (r15 <= 0) goto L169;
        r16 = Math.min(r15, r16);
    L169:
        this.dimension.resolve(r16);
    L171:
        if (this.dimension.resolved == true) goto L173;
        return;
    L173:
        DependencyNode r18 = this.start.targets.get(0);
        DependencyNode r19 = this.end.targets.get(0);
        int r20 = r18.value + this.start.margin;
        int r21 = r19.value + this.end.margin;
        float r22 = this.widget.getHorizontalBiasPercent();
        if (r18 != r19) goto L176;
        r20 = r18.value;
        r21 = r19.value;
        r22 = 0.5f;
    L176:
        this.start.resolve((int) ((r20 + 0.5f) + (((r21 - r20) - this.dimension.value) * r22)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L186:
        return;
    L14:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L134;
        ConstraintWidget r23 = this.widget;
        int r24 = r23.mMatchConstraintDefaultWidth;
        if (r24 == 2) goto L129;
        if (r24 != 3) goto L134;
        int r25 = r23.mMatchConstraintDefaultHeight;
        if (r25 == 0) goto L32;
        if (r25 == 3) goto L32;
        int r26 = r23.getDimensionRatioSide();
        if (r26 == (-1)) goto L29;
        if (r26 == 0) goto L28;
        if (r26 == 1) goto L29;
        int r27 = 0;
    L31:
        this.dimension.resolve(r27);
        goto L134
    L28:
        ConstraintWidget r28 = this.widget;
        float r29 = r28.verticalRun.dimension.value / r28.getDimensionRatio();
    L30:
        r27 = (int) (r29 + 0.5f);
    L29:
        ConstraintWidget r30 = this.widget;
        r29 = r30.verticalRun.dimension.value * r30.getDimensionRatio();
    L32:
        VerticalWidgetRun r31 = r23.verticalRun;
        DependencyNode r110 = r31.start;
        DependencyNode r111 = r31.end;
        if (r23.mLeft.mTarget == null) goto L35;
        boolean r32 = true;
    L37:
        if (r23.mTop.mTarget == null) goto L39;
        boolean r33 = true;
    L41:
        if (r23.mRight.mTarget == null) goto L43;
        boolean r34 = true;
    L45:
        if (r23.mBottom.mTarget == null) goto L47;
        boolean r35 = true;
    L48:
        int r112 = r23.getDimensionRatioSide();
        if (r32 == false) goto L86;
        if (r33 == false) goto L86;
        if (r34 == false) goto L86;
        if (r35 == false) goto L86;
        float r113 = this.widget.getDimensionRatio();
        if (r110.resolved == true) goto L56;
    L64:
        DependencyNode r36 = this.start;
        if (r36.resolved == false) goto L75;
        DependencyNode r37 = this.end;
        if (r37.resolved == false) goto L75;
        if (r110.readyToSolve == true) goto L71;
        return;
    L71:
        if (r111.readyToSolve == false) goto L180;
        computeInsetRatio(tempDimensions, r36.value + r36.margin, r37.value - r37.margin, r110.targets.get(0).value + r110.margin, r111.targets.get(0).value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        goto L75
    L180:
        return;
    L75:
        DependencyNode r38 = this.start;
        if (r38.readyToSolve == true) goto L78;
        return;
    L78:
        if (this.end.readyToSolve == true) goto L80;
        return;
    L80:
        if (r110.readyToSolve == true) goto L82;
        return;
    L82:
        if (r111.readyToSolve == false) goto L183;
        computeInsetRatio(tempDimensions, r38.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, r110.targets.get(0).value + r110.margin, r111.targets.get(0).value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        DimensionDependency r39 = this.widget.verticalRun.dimension;
        int r40 = tempDimensions[1];
    L127:
        r39.resolve(r40);
        goto L134
    L183:
        return;
    L56:
        if (r111.resolved == false) goto L64;
        DependencyNode r41 = this.start;
        if (r41.readyToSolve == true) goto L60;
        return;
    L60:
        if (this.end.readyToSolve == false) goto L179;
        computeInsetRatio(tempDimensions, r41.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, r110.value + r110.margin, r111.value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        return;
    L179:
        return;
    L86:
        if (r32 == false) goto L107;
        if (r34 == false) goto L107;
        if (this.start.readyToSolve == true) goto L91;
        return;
    L91:
        if (this.end.readyToSolve == false) goto L184;
        float r42 = this.widget.getDimensionRatio();
        int r43 = this.start.targets.get(0).value + this.start.margin;
        int r44 = this.end.targets.get(0).value - this.end.margin;
        if (r112 == (-1)) goto L101;
        if (r112 == 0) goto L101;
        if (r112 != 1) goto L134;
        int r45 = getLimitedDimension(r44 - r43, 0);
        int r46 = (int) ((r45 / r42) + 0.5f);
        int r47 = getLimitedDimension(r46, 1);
        if (r46 == r47) goto L105;
        float r48 = r47 * r42;
    L104:
        r45 = (int) (r48 + 0.5f);
    L105:
        this.dimension.resolve(r45);
        this.widget.verticalRun.dimension.resolve(r47);
    L101:
        r45 = getLimitedDimension(r44 - r43, 0);
        int r49 = (int) ((r45 * r42) + 0.5f);
        r47 = getLimitedDimension(r49, 1);
        if (r49 == r47) goto L105;
        r48 = r47 / r42;
        goto L104
    L184:
        return;
    L107:
        if (r33 == false) goto L134;
        if (r35 == false) goto L134;
        if (r110.readyToSolve == true) goto L112;
        return;
    L112:
        if (r111.readyToSolve == false) goto L185;
        float r50 = this.widget.getDimensionRatio();
        int r51 = r110.targets.get(0).value + r110.margin;
        int r52 = r111.targets.get(0).value - r111.margin;
        if (r112 == (-1)) goto L122;
        if (r112 == 0) goto L119;
        if (r112 == 1) goto L122;
    L119:
        r40 = getLimitedDimension(r52 - r51, 1);
        int r53 = (int) ((r40 * r50) + 0.5f);
        int r54 = getLimitedDimension(r53, 0);
        if (r53 == r54) goto L126;
        float r55 = r54 / r50;
    L125:
        r40 = (int) (r55 + 0.5f);
    L126:
        this.dimension.resolve(r54);
        r39 = this.widget.verticalRun.dimension;
    L122:
        r40 = getLimitedDimension(r52 - r51, 1);
        int r56 = (int) ((r40 / r50) + 0.5f);
        r54 = getLimitedDimension(r56, 0);
        if (r56 == r54) goto L126;
        r55 = r54 * r50;
        goto L125
    L185:
        return;
    L47:
        r35 = false;
        goto L48
    L43:
        r34 = false;
        goto L45
    L39:
        r33 = false;
        goto L41
    L35:
        r32 = false;
        goto L37
    L129:
        ConstraintWidget r57 = r23.getParent();
        if (r57 == null) goto L134;
        DimensionDependency r58 = r57.horizontalRun.dimension;
        if (r58.resolved == false) goto L134;
        r27 = (int) ((r58.value * this.widget.mMatchConstraintPercentWidth) + 0.5f);
        goto L31
    L9:
        updateRunEnd(r17);
        goto L12
    L10:
        updateRunStart(r17);
        goto L12
    }
}
