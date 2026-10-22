package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;

/* JADX INFO: loaded from: classes.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
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

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
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
        if (r5.resolved == false) goto L67;
        ConstraintWidget r6 = this.widget;
        if (r6.measured == false) goto L67;
        ConstraintAnchor[] r7 = r6.mListAnchors;
        ConstraintAnchor r8 = r7[0];
        ConstraintAnchor r9 = r8.mTarget;
        if (r9 != null) goto L39;
    L50:
        if (r9 == null) goto L54;
        DependencyNode r10 = getTarget(r8);
        if (r10 == null) goto L117;
        addTarget(this.start, r10, this.widget.mListAnchors[0].getMargin());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L117:
        return;
    L54:
        ConstraintAnchor r11 = r7[1];
        if (r11.mTarget == null) goto L60;
        DependencyNode r12 = getTarget(r11);
        if (r12 == null) goto L119;
        addTarget(this.end, r12, -this.widget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -this.dimension.value);
        return;
    L119:
        return;
    L60:
        if ((r6 instanceof Helper) == false) goto L62;
        return;
    L62:
        if (r6.getParent() != null) goto L64;
        return;
    L64:
        if (this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget != null) goto L123;
        DependencyNode r13 = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, r13, this.widget.getX());
        addTarget(this.end, this.start, this.dimension.value);
        return;
    L123:
        return;
    L39:
        if (r7[1].mTarget == null) goto L50;
        if (r6.isInHorizontalChain() == false) goto L43;
        DependencyNode r14 = this.start;
        r14.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r15 = this.end;
        r15.margin = -this.widget.mListAnchors[1].getMargin();
        return;
    L43:
        DependencyNode r16 = getTarget(this.widget.mListAnchors[0]);
        if (r16 == null) goto L46;
        addTarget(this.start, r16, this.widget.mListAnchors[0].getMargin());
    L46:
        DependencyNode r17 = getTarget(this.widget.mListAnchors[1]);
        if (r17 == null) goto L49;
        addTarget(this.end, r17, -this.widget.mListAnchors[1].getMargin());
    L49:
        this.start.delegateToWidgetRun = true;
        this.end.delegateToWidgetRun = true;
        return;
    L67:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L87;
        ConstraintWidget r18 = this.widget;
        int r19 = r18.mMatchConstraintDefaultWidth;
        if (r19 != 2) goto L71;
        ConstraintWidget r20 = r18.getParent();
        if (r20 == null) goto L87;
        DimensionDependency r21 = r20.verticalRun.dimension;
        this.dimension.targets.add(r21);
        r21.dependencies.add(this.dimension);
        DimensionDependency r22 = this.dimension;
        r22.delegateToWidgetRun = true;
        r22.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        goto L87
    L71:
        if (r19 != 3) goto L87;
        if (r18.mMatchConstraintDefaultHeight != 3) goto L82;
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
        VerticalWidgetRun r23 = r18.verticalRun;
        r23.start.updateDelegate = this;
        r23.end.updateDelegate = this;
        r5.updateDelegate = this;
        if (r18.isInVerticalChain() == false) goto L79;
        this.dimension.targets.add(this.widget.verticalRun.dimension);
        this.widget.verticalRun.dimension.dependencies.add(this.dimension);
        VerticalWidgetRun r24 = this.widget.verticalRun;
        r24.dimension.updateDelegate = this;
        this.dimension.targets.add(r24.start);
        this.dimension.targets.add(this.widget.verticalRun.end);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        goto L87
    L79:
        if (this.widget.isInHorizontalChain() == false) goto L81;
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        this.dimension.dependencies.add(this.widget.verticalRun.dimension);
        goto L87
    L81:
        this.widget.verticalRun.dimension.targets.add(this.dimension);
        goto L87
    L82:
        DimensionDependency r25 = r18.verticalRun.dimension;
        r5.targets.add(r25);
        r25.dependencies.add(this.dimension);
        this.widget.verticalRun.start.dependencies.add(this.dimension);
        this.widget.verticalRun.end.dependencies.add(this.dimension);
        DimensionDependency r26 = this.dimension;
        r26.delegateToWidgetRun = true;
        r26.dependencies.add(this.start);
        this.dimension.dependencies.add(this.end);
        this.start.targets.add(this.dimension);
        this.end.targets.add(this.dimension);
    L87:
        ConstraintWidget r27 = this.widget;
        ConstraintAnchor[] r28 = r27.mListAnchors;
        ConstraintAnchor r29 = r28[0];
        ConstraintAnchor r30 = r29.mTarget;
        if (r30 != null) goto L90;
    L100:
        if (r30 == null) goto L104;
        DependencyNode r31 = getTarget(r29);
        if (r31 == null) goto L127;
        addTarget(this.start, r31, this.widget.mListAnchors[0].getMargin());
        addTarget(this.end, this.start, 1, this.dimension);
        return;
    L127:
        return;
    L104:
        ConstraintAnchor r32 = r28[1];
        if (r32.mTarget == null) goto L110;
        DependencyNode r33 = getTarget(r32);
        if (r33 == null) goto L129;
        addTarget(this.end, r33, -this.widget.mListAnchors[1].getMargin());
        addTarget(this.start, this.end, -1, this.dimension);
        return;
    L129:
        return;
    L110:
        if ((r27 instanceof Helper) == false) goto L112;
        return;
    L112:
        if (r27.getParent() == null) goto L132;
        DependencyNode r34 = this.widget.getParent().horizontalRun.start;
        addTarget(this.start, r34, this.widget.getX());
        addTarget(this.end, this.start, 1, this.dimension);
        return;
    L132:
        return;
    L90:
        if (r28[1].mTarget == null) goto L100;
        if (r27.isInHorizontalChain() == false) goto L94;
        DependencyNode r35 = this.start;
        r35.margin = this.widget.mListAnchors[0].getMargin();
        DependencyNode r36 = this.end;
        r36.margin = -this.widget.mListAnchors[1].getMargin();
        return;
    L94:
        DependencyNode r37 = getTarget(this.widget.mListAnchors[0]);
        DependencyNode r38 = getTarget(this.widget.mListAnchors[1]);
        if (r37 == null) goto L97;
        r37.addDependency(this);
    L97:
        if (r38 == null) goto L99;
        r38.addDependency(this);
    L99:
        this.mRunType = WidgetRun.RunType.CENTER;
        return;
    L22:
        ConstraintWidget.DimensionBehaviour r39 = this.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r40 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r39 != r40) goto L32;
        ConstraintWidget r41 = this.widget.getParent();
        if (r41 == null) goto L32;
        if (r41.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        addTarget(this.start, r41.horizontalRun.start, this.widget.mLeft.getMargin());
        addTarget(this.end, r41.horizontalRun.end, -this.widget.mRight.getMargin());
        return;
    L29:
        if (r41.getHorizontalDimensionBehaviour() != r40) goto L32;
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
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
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
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
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
        float r23 = r20 + 0.5f;
        this.start.resolve((int) ((((r21 - r20) - this.dimension.value) * r22) + r23));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L186:
        return;
    L14:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L134;
        ConstraintWidget r24 = this.widget;
        int r25 = r24.mMatchConstraintDefaultWidth;
        if (r25 == 2) goto L129;
        if (r25 != 3) goto L134;
        int r26 = r24.mMatchConstraintDefaultHeight;
        if (r26 == 0) goto L33;
        if (r26 == 3) goto L33;
        int r27 = r24.getDimensionRatioSide();
        if (r27 == (-1)) goto L31;
        if (r27 == 0) goto L30;
        if (r27 == 1) goto L28;
        int r28 = 0;
    L32:
        this.dimension.resolve(r28);
        goto L134
    L28:
        ConstraintWidget r29 = this.widget;
        float r30 = r29.verticalRun.dimension.value;
        float r31 = r29.getDimensionRatio();
    L29:
        r28 = (int) ((r31 * r30) + 0.5f);
        goto L32
    L30:
        ConstraintWidget r32 = this.widget;
        r28 = (int) ((r32.verticalRun.dimension.value / r32.getDimensionRatio()) + 0.5f);
        goto L32
    L31:
        ConstraintWidget r33 = this.widget;
        r30 = r33.verticalRun.dimension.value;
        r31 = r33.getDimensionRatio();
    L33:
        VerticalWidgetRun r34 = r24.verticalRun;
        DependencyNode r110 = r34.start;
        DependencyNode r111 = r34.end;
        if (r24.mLeft.mTarget == null) goto L36;
        boolean r35 = true;
    L38:
        if (r24.mTop.mTarget == null) goto L40;
        boolean r36 = true;
    L42:
        if (r24.mRight.mTarget == null) goto L44;
        boolean r37 = true;
    L46:
        if (r24.mBottom.mTarget == null) goto L48;
        boolean r38 = true;
    L49:
        int r112 = r24.getDimensionRatioSide();
        if (r35 == false) goto L87;
        if (r36 == false) goto L87;
        if (r37 == false) goto L87;
        if (r38 == false) goto L87;
        float r113 = this.widget.getDimensionRatio();
        if (r110.resolved == true) goto L57;
    L65:
        DependencyNode r39 = this.start;
        if (r39.resolved == false) goto L76;
        DependencyNode r40 = this.end;
        if (r40.resolved == false) goto L76;
        if (r110.readyToSolve == true) goto L72;
        return;
    L72:
        if (r111.readyToSolve == false) goto L180;
        computeInsetRatio(tempDimensions, r39.value + r39.margin, r40.value - r40.margin, r110.targets.get(0).value + r110.margin, r111.targets.get(0).value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        goto L76
    L180:
        return;
    L76:
        DependencyNode r41 = this.start;
        if (r41.readyToSolve == true) goto L79;
        return;
    L79:
        if (this.end.readyToSolve == true) goto L81;
        return;
    L81:
        if (r110.readyToSolve == true) goto L83;
        return;
    L83:
        if (r111.readyToSolve == false) goto L183;
        computeInsetRatio(tempDimensions, r41.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, r110.targets.get(0).value + r110.margin, r111.targets.get(0).value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        goto L134
    L183:
        return;
    L57:
        if (r111.resolved == false) goto L65;
        DependencyNode r42 = this.start;
        if (r42.readyToSolve == true) goto L61;
        return;
    L61:
        if (this.end.readyToSolve == false) goto L179;
        computeInsetRatio(tempDimensions, r42.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, r110.value + r110.margin, r111.value - r111.margin, r113, r112);
        this.dimension.resolve(tempDimensions[0]);
        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
        return;
    L179:
        return;
    L87:
        if (r35 == false) goto L108;
        if (r37 == false) goto L108;
        if (this.start.readyToSolve == true) goto L92;
        return;
    L92:
        if (this.end.readyToSolve == false) goto L184;
        float r43 = this.widget.getDimensionRatio();
        int r44 = this.start.targets.get(0).value + this.start.margin;
        int r45 = this.end.targets.get(0).value - this.end.margin;
        if (r112 == (-1)) goto L103;
        if (r112 == 0) goto L103;
        if (r112 != 1) goto L134;
        int r46 = getLimitedDimension(r45 - r44, 0);
        int r47 = (int) ((r46 / r43) + 0.5f);
        int r48 = getLimitedDimension(r47, 1);
        if (r47 == r48) goto L102;
        r46 = (int) ((r48 * r43) + 0.5f);
    L102:
        this.dimension.resolve(r46);
        this.widget.verticalRun.dimension.resolve(r48);
    L103:
        int r49 = getLimitedDimension(r45 - r44, 0);
        int r50 = (int) ((r49 * r43) + 0.5f);
        int r51 = getLimitedDimension(r50, 1);
        if (r50 == r51) goto L106;
        r49 = (int) ((r51 / r43) + 0.5f);
    L106:
        this.dimension.resolve(r49);
        this.widget.verticalRun.dimension.resolve(r51);
        goto L134
    L184:
        return;
    L108:
        if (r36 == false) goto L134;
        if (r38 == false) goto L134;
        if (r110.readyToSolve == true) goto L113;
        return;
    L113:
        if (r111.readyToSolve == false) goto L185;
        float r52 = this.widget.getDimensionRatio();
        int r53 = r110.targets.get(0).value + r110.margin;
        int r54 = r111.targets.get(0).value - r111.margin;
        if (r112 == (-1)) goto L124;
        if (r112 == 0) goto L120;
        if (r112 == 1) goto L124;
    L120:
        int r55 = getLimitedDimension(r54 - r53, 1);
        int r56 = (int) ((r55 * r52) + 0.5f);
        int r57 = getLimitedDimension(r56, 0);
        if (r56 == r57) goto L123;
        r55 = (int) ((r57 / r52) + 0.5f);
    L123:
        this.dimension.resolve(r57);
        this.widget.verticalRun.dimension.resolve(r55);
    L124:
        int r58 = getLimitedDimension(r54 - r53, 1);
        int r59 = (int) ((r58 / r52) + 0.5f);
        int r60 = getLimitedDimension(r59, 0);
        if (r59 == r60) goto L127;
        r58 = (int) ((r60 * r52) + 0.5f);
    L127:
        this.dimension.resolve(r60);
        this.widget.verticalRun.dimension.resolve(r58);
        goto L134
    L185:
        return;
    L48:
        r38 = false;
        goto L49
    L44:
        r37 = false;
        goto L46
    L40:
        r36 = false;
        goto L42
    L36:
        r35 = false;
        goto L38
    L129:
        ConstraintWidget r61 = r24.getParent();
        if (r61 == null) goto L134;
        DimensionDependency r62 = r61.horizontalRun.dimension;
        if (r62.resolved == false) goto L134;
        this.dimension.resolve((int) ((r62.value * this.widget.mMatchConstraintPercentWidth) + 0.5f));
        goto L134
    L9:
        updateRunEnd(r17);
        goto L12
    L10:
        updateRunStart(r17);
        goto L12
    }
}
