package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.LinearSystem;
import com.obric.oui.constraintlayout.core.widgets.Barrier;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.obric.oui.constraintlayout.core.widgets.Guideline;
import com.obric.oui.constraintlayout.core.widgets.Helper;
import com.obric.oui.constraintlayout.core.widgets.Optimizer;
import com.obric.oui.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    private static final boolean DO_NOT_USE = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer mConstraintWidgetContainer;
    private Measure mMeasure;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets;

    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;

        static {
        }

        public Measure() {
        }
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget r1, Measure r2);
    }

    public void updateHierarchy(ConstraintWidgetContainer r6) {
        this.mVariableDimensionsWidgets.clear();
        int r0 = r6.mChildren.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        ConstraintWidget r2 = r6.mChildren.get(r1);
        if (r2.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
    L8:
        this.mVariableDimensionsWidgets.add(r2);
    L9:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L9;
    L10:
        r6.invalidateGraph();
    }

    public BasicMeasure(ConstraintWidgetContainer r2) {
        this.mVariableDimensionsWidgets = new ArrayList();
        this.mMeasure = new Measure();
        this.mConstraintWidgetContainer = r2;
    }

    private void measureChildren(ConstraintWidgetContainer r12) {
        int r0 = r12.mChildren.size();
        boolean r1 = r12.optimizeFor(64);
        Measurer r2 = r12.getMeasurer();
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L70;
        ConstraintWidget r5 = r12.mChildren.get(r4);
        if ((r5 instanceof Guideline) == true) goto L69;
        if ((r5 instanceof Barrier) == true) goto L69;
        if (r5.isInVirtualLayout() == true) goto L69;
        if (r1 == true) goto L15;
    L23:
        ConstraintWidget.DimensionBehaviour r6 = r5.getDimensionBehaviour(0);
        boolean r7 = true;
        ConstraintWidget.DimensionBehaviour r8 = r5.getDimensionBehaviour(1);
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L26;
    L32:
        boolean r9 = false;
    L33:
        if (r9 == false) goto L35;
    L63:
        r7 = r9;
    L64:
        if (r7 == true) goto L69;
        measure(r2, r5, Measure.SELF_DIMENSIONS);
        if (r12.mMetrics == null) goto L69;
        r12.mMetrics.measuredWidgets++;
        goto L69
    L35:
        if (r12.optimizeFor(1) == false) goto L63;
        if ((r5 instanceof VirtualLayout) == true) goto L63;
        if (r6 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L48;
        if (r5.mMatchConstraintDefaultWidth != 0) goto L48;
        if (r8 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L48;
        if (r5.isInHorizontalChain() == true) goto L48;
        r9 = true;
    L48:
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L57;
        if (r5.mMatchConstraintDefaultHeight != 0) goto L57;
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L57;
        if (r5.isInHorizontalChain() == true) goto L57;
        r9 = true;
    L57:
        if (r6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L61;
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L63;
    L61:
        if (r5.mDimensionRatio <= 0.0f) goto L63;
    L26:
        if (r5.mMatchConstraintDefaultWidth == 1) goto L32;
        if (r8 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        if (r5.mMatchConstraintDefaultHeight == 1) goto L32;
        r9 = true;
        goto L33
    L15:
        if (r5.mHorizontalRun == null) goto L23;
        if (r5.mVerticalRun == null) goto L23;
        if (r5.mHorizontalRun.mDimension.resolved == false) goto L23;
        if (r5.mVerticalRun.mDimension.resolved == false) goto L23;
    L69:
        r4 = r4 + 1;
        goto L3
    L70:
        r2.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer r5, String r6, int r7, int r8, int r9) {
        if (r5.mMetrics == null) goto L5;
        long r0 = System.nanoTime();
    L6:
        int r10 = r5.getMinWidth();
        int r2 = r5.getMinHeight();
        r5.setMinWidth(0);
        r5.setMinHeight(0);
        r5.setWidth(r8);
        r5.setHeight(r9);
        r5.setMinWidth(r10);
        r5.setMinHeight(r2);
        this.mConstraintWidgetContainer.setPass(r7);
        this.mConstraintWidgetContainer.layout();
        if (r5.mMetrics == null) goto L10;
        long r11 = System.nanoTime();
        r5.mMetrics.mSolverPasses++;
        r5.mMetrics.measuresLayoutDuration += r11 - r0;
        return;
    L10:
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public long solverMeasure(ConstraintWidgetContainer r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34) {
        BasicMeasure r0 = this;
        Measurer r5 = r25.getMeasurer();
        int r6 = r25.mChildren.size();
        int r7 = r25.getWidth();
        int r8 = r25.getHeight();
        boolean r9 = Optimizer.enabled(r26, 128);
        if (r9 == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L44;
        int r12 = 0;
    L11:
        if (r12 >= r6) goto L44;
        ConstraintWidget r13 = r25.mChildren.get(r12);
        if (r13.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L15;
        boolean r14 = true;
    L17:
        if (r13.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        boolean r11 = true;
    L20:
        if (r14 == false) goto L25;
        if (r11 == false) goto L25;
        if (r13.getDimensionRatio() <= 0.0f) goto L25;
        boolean r15 = true;
    L27:
        if (r13.isInHorizontalChain() == false) goto L31;
        if (r15 == false) goto L31;
    L29:
        r2 = false;
    L31:
        if (r13.isInVerticalChain() == false) goto L35;
        if (r15 == true) goto L29;
    L35:
        if ((r13 instanceof VirtualLayout) == true) goto L29;
        if (r13.isInHorizontalChain() == true) goto L29;
        if (r13.isInVerticalChain() == true) goto L29;
        r12 = r12 + 1;
    L25:
        r15 = false;
        goto L27
    L19:
        r11 = false;
        goto L20
    L15:
        r14 = false;
    L44:
        if (r2 == false) goto L49;
        if (LinearSystem.sMetrics == null) goto L49;
        LinearSystem.sMetrics.measures++;
    L49:
        if (r29 != 1073741824) goto L51;
        if (r31 != 1073741824) goto L51;
    L52:
        boolean r16 = true;
    L54:
        boolean r3 = r2 & r16;
        int r17 = 2;
        if (r3 == false) goto L83;
        int r18 = Math.min(r25.getMaxWidth(), r30);
        int r19 = Math.min(r25.getMaxHeight(), r32);
        if (r29 == 1073741824) goto L59;
    L61:
        if (r31 == 1073741824) goto L63;
    L65:
        if (r29 != 1073741824) goto L68;
        if (r31 != 1073741824) goto L68;
        boolean r10 = r25.directMeasure(r9);
        int r110 = 2;
    L75:
        if (r10 == false) goto L84;
        if (r29 != 1073741824) goto L78;
        boolean r111 = true;
    L79:
        if (r31 != 1073741824) goto L81;
        boolean r4 = true;
    L82:
        r25.updateFromRuns(r111, r4);
        goto L84
    L81:
        r4 = false;
        goto L82
    L78:
        r111 = false;
    L84:
        long r20 = 0;
        if (r10 == false) goto L87;
        if (r110 != 2) goto L87;
    L192:
        if (r25.mMetrics != null) goto L194;
        return r20;
    L194:
        return System.nanoTime() - r20;
    L87:
        int r21 = r25.getOptimizationLevel();
        if (r6 <= 0) goto L91;
        measureChildren(r25);
    L91:
        if (r25.mMetrics == null) goto L93;
        r20 = System.nanoTime();
    L93:
        updateHierarchy(r25);
        int r112 = r0.mVariableDimensionsWidgets.size();
        if (r6 <= 0) goto L96;
        solveLinearSystem(r25, "First pass", 0, r7, r8);
    L96:
        if (r112 > 0) goto L98;
        long r22 = r20;
        int r1 = r21;
    L190:
        r25.setOptimizationLevel(r1);
        r20 = r22;
        goto L192
    L98:
        if (r25.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L100;
        boolean r113 = true;
    L102:
        if (r25.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L104;
        boolean r23 = true;
    L105:
        int r114 = Math.max(r25.getWidth(), r0.mConstraintWidgetContainer.getMinWidth());
        int r115 = Math.max(r25.getHeight(), r0.mConstraintWidgetContainer.getMinHeight());
        int r116 = 0;
        boolean r117 = false;
    L106:
        if (r116 >= r112) goto L132;
        ConstraintWidget r118 = r0.mVariableDimensionsWidgets.get(r116);
        long r24 = r20;
        if ((r118 instanceof VirtualLayout) == true) goto L110;
        r7 = r7;
        r8 = r8;
    L131:
        r116 = r116 + 1;
        r21 = r21;
        r20 = r24;
        r7 = r7;
        r8 = r8;
        r17 = 2;
        goto L106
    L110:
        int r35 = r118.getWidth();
        int r36 = r118.getHeight();
        boolean r37 = r117 | r0.measure(r5, r118, Measure.TRY_GIVEN_DIMENSIONS);
        if (r25.mMetrics == null) goto L114;
        r25.mMetrics.measuredMatchWidgets++;
    L114:
        int r38 = r118.getWidth();
        int r39 = r118.getHeight();
        if (r38 == r35) goto L122;
        r118.setWidth(r38);
        if (r113 == true) goto L119;
    L121:
        boolean r40 = true;
    L123:
        if (r39 == r36) goto L130;
        r118.setHeight(r39);
        if (r23 == true) goto L127;
    L129:
        r40 = true;
        goto L130
    L127:
        if (r118.getBottom() <= r115) goto L129;
        r115 = Math.max(r115, r118.getBottom() + r118.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
    L130:
        r117 = r40 | ((VirtualLayout) r118).needSolverPass();
        goto L131
    L119:
        if (r118.getRight() <= r114) goto L121;
        r114 = Math.max(r114, r118.getRight() + r118.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
        goto L121
    L122:
        r40 = r37;
        goto L123
    L132:
        r22 = r20;
        int r210 = r7;
        int r211 = r8;
        int r310 = r21;
        int r41 = r17;
        int r42 = 0;
    L133:
        if (r42 >= r41) goto L188;
        int r43 = 0;
    L135:
        if (r43 >= r112) goto L185;
        ConstraintWidget r44 = r0.mVariableDimensionsWidgets.get(r43);
        if ((r44 instanceof Helper) == false) goto L141;
        if ((r44 instanceof VirtualLayout) == true) goto L141;
    L154:
        r5 = r5;
    L184:
        r43 = r43 + 1;
        r0 = this;
        r5 = r5;
    L141:
        if ((r44 instanceof Guideline) == true) goto L154;
        if (r44.getVisibility() == 8) goto L154;
        if (r3 == false) goto L153;
        if (r44.mHorizontalRun.mDimension.resolved == false) goto L153;
        if (r44.mVerticalRun.mDimension.resolved == true) goto L154;
    L153:
        if ((r44 instanceof VirtualLayout) == true) goto L154;
        int r45 = r44.getWidth();
        int r119 = r44.getHeight();
        int r120 = r44.getBaselineDistance();
        int r121 = Measure.TRY_GIVEN_DIMENSIONS;
        if (r42 != 1) goto L158;
        r121 = Measure.USE_GIVEN_DIMENSIONS;
    L158:
        boolean r46 = r117 | r0.measure(r5, r44, r121);
        if (r25.mMetrics == null) goto L162;
        r25.mMetrics.measuredMatchWidgets++;
    L162:
        int r47 = r44.getWidth();
        int r48 = r44.getHeight();
        if (r47 == r45) goto L170;
        r44.setWidth(r47);
        if (r113 == true) goto L167;
    L169:
        boolean r49 = true;
    L171:
        if (r48 == r119) goto L179;
        r44.setHeight(r48);
        if (r23 == true) goto L175;
    L177:
        r49 = true;
        goto L179
    L175:
        if (r44.getBottom() <= r115) goto L177;
        r115 = Math.max(r115, r44.getBottom() + r44.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
    L179:
        if (r44.hasBaseline() == true) goto L181;
    L183:
        r117 = r49;
        goto L184
    L181:
        if (r120 == r44.getBaselineDistance()) goto L183;
        r117 = true;
        goto L184
    L167:
        if (r44.getRight() <= r114) goto L169;
        r114 = Math.max(r114, r44.getRight() + r44.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
        goto L169
    L170:
        r49 = r46;
        goto L171
    L185:
        Measurer r122 = r5;
        if (r117 == false) goto L188;
        r42 = r42 + 1;
        solveLinearSystem(r25, "intermediate pass", r42, r210, r211);
        r41 = 2;
        r117 = false;
        r0 = this;
        r5 = r122;
    L188:
        r1 = r310;
        goto L190
    L104:
        r23 = false;
        goto L105
    L100:
        r113 = false;
    L68:
        boolean r123 = r25.directMeasureSetup(r9);
        if (r29 != 1073741824) goto L71;
        r123 = r123 & r25.directMeasureWithOrientation(r9, 0);
        r110 = 1;
    L72:
        if (r31 != 1073741824) goto L74;
        r10 = r25.directMeasureWithOrientation(r9, 1) & r123;
        r110 = r110 + 1;
        goto L75
    L74:
        r10 = r123;
        goto L75
    L71:
        r110 = 0;
        goto L72
    L63:
        if (r25.getHeight() == r19) goto L65;
        r25.setHeight(r19);
        r25.invalidateGraph();
        goto L65
    L59:
        if (r25.getWidth() == r18) goto L61;
        r25.setWidth(r18);
        r25.invalidateGraph();
        goto L61
    L83:
        r10 = false;
        r110 = 0;
    L51:
        if (r9 == true) goto L52;
        r16 = false;
        goto L54
    L5:
        if (Optimizer.enabled(r26, 64) == true) goto L8;
        r2 = false;
        goto L9
    }

    private boolean measure(Measurer r5, ConstraintWidget r6, int r7) {
        this.mMeasure.horizontalBehavior = r6.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = r6.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = r6.getWidth();
        this.mMeasure.verticalDimension = r6.getHeight();
        this.mMeasure.measuredNeedsSolverPass = false;
        this.mMeasure.measureStrategy = r7;
        if (this.mMeasure.horizontalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        boolean r8 = true;
    L7:
        if (this.mMeasure.verticalBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L9;
        boolean r0 = true;
    L11:
        if (r8 == true) goto L13;
    L15:
        boolean r9 = false;
    L16:
        if (r0 == true) goto L18;
    L20:
        boolean r1 = false;
    L22:
        if (r9 == true) goto L24;
    L26:
        if (r1 == true) goto L28;
    L30:
        r5.measure(r6, this.mMeasure);
        r6.setWidth(this.mMeasure.measuredWidth);
        r6.setHeight(this.mMeasure.measuredHeight);
        r6.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r6.setBaselineDistance(this.mMeasure.measuredBaseline);
        this.mMeasure.measureStrategy = Measure.SELF_DIMENSIONS;
        return this.mMeasure.measuredNeedsSolverPass;
    L28:
        if (r6.mResolvedMatchConstraintDefault[1] != 4) goto L30;
        this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r6.mResolvedMatchConstraintDefault[0] != 4) goto L26;
        this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r6.mDimensionRatio <= 0.0f) goto L20;
        r1 = true;
        goto L22
    L13:
        if (r6.mDimensionRatio <= 0.0f) goto L15;
        r9 = true;
        goto L16
    L9:
        r0 = false;
        goto L11
    L5:
        r8 = false;
        goto L7
    }
}
