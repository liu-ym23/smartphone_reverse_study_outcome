package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
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

        public Measure() {
        }
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget r1, Measure r2);
    }

    public BasicMeasure(ConstraintWidgetContainer r2) {
        this.mVariableDimensionsWidgets = new ArrayList();
        this.mMeasure = new Measure();
        this.constraintWidgetContainer = r2;
    }

    private boolean measure(Measurer r6, ConstraintWidget r7, int r8) {
        this.mMeasure.horizontalBehavior = r7.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = r7.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = r7.getWidth();
        this.mMeasure.verticalDimension = r7.getHeight();
        Measure r0 = this.mMeasure;
        r0.measuredNeedsSolverPass = false;
        r0.measureStrategy = r8;
        ConstraintWidget.DimensionBehaviour r9 = r0.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r9 != r2) goto L5;
        boolean r10 = true;
    L7:
        if (r0.verticalBehavior != r2) goto L9;
        boolean r3 = true;
    L11:
        if (r10 == true) goto L13;
    L15:
        boolean r11 = false;
    L16:
        if (r3 == true) goto L18;
    L20:
        boolean r4 = false;
    L22:
        if (r11 == true) goto L24;
    L26:
        if (r4 == true) goto L28;
    L30:
        r6.measure(r7, r0);
        r7.setWidth(this.mMeasure.measuredWidth);
        r7.setHeight(this.mMeasure.measuredHeight);
        r7.setHasBaseline(this.mMeasure.measuredHasBaseline);
        r7.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure r5 = this.mMeasure;
        r5.measureStrategy = Measure.SELF_DIMENSIONS;
        return r5.measuredNeedsSolverPass;
    L28:
        if (r7.mResolvedMatchConstraintDefault[1] != 4) goto L30;
        r0.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L30
    L24:
        if (r7.mResolvedMatchConstraintDefault[0] != 4) goto L26;
        r0.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L26
    L18:
        if (r7.mDimensionRatio <= 0.0f) goto L20;
        r4 = true;
        goto L22
    L13:
        if (r7.mDimensionRatio <= 0.0f) goto L15;
        r11 = true;
        goto L16
    L9:
        r3 = false;
        goto L11
    L5:
        r10 = false;
        goto L7
    }

    private void measureChildren(ConstraintWidgetContainer r13) {
        int r0 = r13.mChildren.size();
        boolean r1 = r13.optimizeFor(64);
        Measurer r2 = r13.getMeasurer();
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L63;
        ConstraintWidget r5 = r13.mChildren.get(r4);
        if ((r5 instanceof Guideline) == true) goto L62;
        if ((r5 instanceof Barrier) == true) goto L62;
        if (r5.isInVirtualLayout() == true) goto L62;
        if (r1 == false) goto L23;
        HorizontalWidgetRun r6 = r5.horizontalRun;
        if (r6 == null) goto L23;
        VerticalWidgetRun r7 = r5.verticalRun;
        if (r7 == null) goto L23;
        if (r6.dimension.resolved == false) goto L23;
        if (r7.dimension.resolved == true) goto L62;
    L23:
        ConstraintWidget.DimensionBehaviour r8 = r5.getDimensionBehaviour(0);
        boolean r9 = true;
        ConstraintWidget.DimensionBehaviour r10 = r5.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r11 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r8 == r11) goto L26;
    L31:
        boolean r12 = false;
    L32:
        if (r12 == false) goto L34;
    L56:
        r9 = r12;
    L57:
        if (r9 == true) goto L62;
        measure(r2, r5, Measure.SELF_DIMENSIONS);
        Metrics r14 = r13.mMetrics;
        if (r14 == null) goto L62;
        r14.measuredWidgets++;
        goto L62
    L34:
        if (r13.optimizeFor(1) == false) goto L56;
        if ((r5 instanceof VirtualLayout) == true) goto L56;
        if (r8 == r11) goto L39;
    L44:
        if (r10 == r11) goto L46;
    L51:
        if (r8 == r11) goto L54;
        if (r10 != r11) goto L56;
    L54:
        if (r5.mDimensionRatio <= 0.0f) goto L56;
    L46:
        if (r5.mMatchConstraintDefaultHeight != 0) goto L51;
        if (r8 == r11) goto L51;
        if (r5.isInHorizontalChain() == true) goto L51;
        r12 = true;
        goto L51
    L39:
        if (r5.mMatchConstraintDefaultWidth != 0) goto L44;
        if (r10 == r11) goto L44;
        if (r5.isInHorizontalChain() == true) goto L44;
        r12 = true;
        goto L44
    L26:
        if (r5.mMatchConstraintDefaultWidth == 1) goto L31;
        if (r10 != r11) goto L31;
        if (r5.mMatchConstraintDefaultHeight == 1) goto L31;
        r12 = true;
    L62:
        r4 = r4 + 1;
        goto L3
    L63:
        r2.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer r3, String r4, int r5, int r6, int r7) {
        int r8 = r3.getMinWidth();
        int r0 = r3.getMinHeight();
        r3.setMinWidth(0);
        r3.setMinHeight(0);
        r3.setWidth(r6);
        r3.setHeight(r7);
        r3.setMinWidth(r8);
        r3.setMinHeight(r0);
        this.constraintWidgetContainer.setPass(r5);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33) {
        Measurer r5 = r24.getMeasurer();
        int r6 = r24.mChildren.size();
        int r7 = r24.getWidth();
        int r8 = r24.getHeight();
        boolean r9 = Optimizer.enabled(r25, 128);
        if (r9 == false) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L44;
        int r12 = 0;
    L11:
        if (r12 >= r6) goto L44;
        ConstraintWidget r13 = r24.mChildren.get(r12);
        ConstraintWidget.DimensionBehaviour r14 = r13.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r14 != r15) goto L15;
        boolean r16 = true;
    L17:
        if (r13.getVerticalDimensionBehaviour() != r15) goto L19;
        boolean r10 = true;
    L20:
        if (r16 == false) goto L25;
        if (r10 == false) goto L25;
        if (r13.getDimensionRatio() <= 0.0f) goto L25;
        boolean r11 = true;
    L27:
        if (r13.isInHorizontalChain() == false) goto L31;
        if (r11 == false) goto L31;
    L29:
        r2 = false;
    L31:
        if (r13.isInVerticalChain() == false) goto L35;
        if (r11 == true) goto L29;
    L35:
        if ((r13 instanceof VirtualLayout) == true) goto L29;
        if (r13.isInHorizontalChain() == true) goto L29;
        if (r13.isInVerticalChain() == true) goto L29;
        r12 = r12 + 1;
    L25:
        r11 = false;
        goto L27
    L19:
        r10 = false;
        goto L20
    L15:
        r16 = false;
    L44:
        if (r2 == false) goto L49;
        Metrics r17 = LinearSystem.sMetrics;
        if (r17 == null) goto L49;
        r17.measures++;
    L49:
        if (r28 != 1073741824) goto L51;
        if (r30 != 1073741824) goto L51;
    L52:
        boolean r18 = true;
    L54:
        boolean r3 = r2 & r18;
        int r19 = 2;
        if (r3 == false) goto L83;
        int r110 = Math.min(r24.getMaxWidth(), r29);
        int r111 = Math.min(r24.getMaxHeight(), r31);
        if (r28 == 1073741824) goto L59;
    L61:
        if (r30 == 1073741824) goto L63;
    L65:
        if (r28 != 1073741824) goto L68;
        if (r30 != 1073741824) goto L68;
        boolean r20 = r24.directMeasure(r9);
        int r112 = 2;
    L75:
        if (r20 == false) goto L84;
        if (r28 != 1073741824) goto L78;
        boolean r113 = true;
    L79:
        if (r30 != 1073741824) goto L81;
        boolean r4 = true;
    L82:
        r24.updateFromRuns(r113, r4);
        goto L84
    L81:
        r4 = false;
        goto L82
    L78:
        r113 = false;
    L84:
        if (r20 == false) goto L86;
        if (r112 != 2) goto L86;
        return 0;
    L86:
        int r21 = r24.getOptimizationLevel();
        if (r6 <= 0) goto L89;
        measureChildren(r24);
    L89:
        updateHierarchy(r24);
        int r22 = this.mVariableDimensionsWidgets.size();
        if (r6 <= 0) goto L92;
        solveLinearSystem(r24, "First pass", 0, r7, r8);
    L92:
        if (r22 <= 0) goto L183;
        ConstraintWidget.DimensionBehaviour r23 = r24.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r34 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r23 != r34) goto L96;
        boolean r114 = true;
    L98:
        if (r24.getVerticalDimensionBehaviour() != r34) goto L100;
        boolean r35 = true;
    L101:
        int r36 = Math.max(r24.getWidth(), this.constraintWidgetContainer.getMinWidth());
        int r115 = Math.max(r24.getHeight(), this.constraintWidgetContainer.getMinHeight());
        int r116 = 0;
        boolean r117 = false;
    L102:
        if (r116 >= r22) goto L127;
        ConstraintWidget r118 = this.mVariableDimensionsWidgets.get(r116);
        if ((r118 instanceof VirtualLayout) == false) goto L126;
        int r119 = r118.getWidth();
        int r37 = r118.getHeight();
        boolean r38 = measure(r5, r118, Measure.TRY_GIVEN_DIMENSIONS) | r117;
        Metrics r120 = r24.mMetrics;
        if (r120 == null) goto L109;
        r120.measuredMatchWidgets++;
    L109:
        int r39 = r118.getWidth();
        int r40 = r118.getHeight();
        if (r39 == r119) goto L117;
        r118.setWidth(r39);
        if (r114 == true) goto L114;
    L116:
        boolean r41 = true;
    L118:
        if (r40 == r37) goto L125;
        r118.setHeight(r40);
        if (r35 == true) goto L122;
    L124:
        r41 = true;
        goto L125
    L122:
        if (r118.getBottom() <= r115) goto L124;
        r115 = Math.max(r115, r118.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + r118.getBottom());
    L125:
        r117 = r41 | ((VirtualLayout) r118).needSolverPass();
        goto L126
    L114:
        if (r118.getRight() <= r36) goto L116;
        r36 = Math.max(r36, r118.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + r118.getRight());
        goto L116
    L117:
        r41 = r38;
    L126:
        r116 = r116 + 1;
        r21 = r21;
        r8 = r8;
        r7 = r7;
        r19 = 2;
        goto L102
    L127:
        int r310 = r21;
        int r121 = r7;
        int r122 = r8;
        int r42 = r19;
        int r43 = 0;
    L128:
        if (r43 >= r42) goto L182;
        int r44 = 0;
    L130:
        if (r44 >= r22) goto L179;
        ConstraintWidget r123 = this.mVariableDimensionsWidgets.get(r44);
        if ((r123 instanceof Helper) == false) goto L136;
        if ((r123 instanceof VirtualLayout) == true) goto L136;
    L149:
        boolean r210 = r3;
        int r211 = r22;
        Measurer r212 = r5;
    L178:
        r44 = r44 + 1;
        r5 = r212;
        r3 = r210;
        r22 = r211;
    L136:
        if ((r123 instanceof Guideline) == true) goto L149;
        if (r123.getVisibility() == 8) goto L149;
        if (r3 == false) goto L148;
        if (r123.horizontalRun.dimension.resolved == false) goto L148;
        if (r123.verticalRun.dimension.resolved == true) goto L149;
    L148:
        if ((r123 instanceof VirtualLayout) == true) goto L149;
        int r124 = r123.getWidth();
        int r125 = r123.getHeight();
        int r45 = r123.getBaselineDistance();
        int r213 = Measure.TRY_GIVEN_DIMENSIONS;
        r210 = r3;
        if (r43 != 1) goto L153;
        r213 = Measure.USE_GIVEN_DIMENSIONS;
    L153:
        boolean r46 = measure(r5, r123, r213) | r117;
        Metrics r126 = r24.mMetrics;
        r211 = r22;
        r212 = r5;
        if (r126 == null) goto L157;
        r126.measuredMatchWidgets++;
    L157:
        int r47 = r123.getWidth();
        int r48 = r123.getHeight();
        if (r47 == r124) goto L165;
        r123.setWidth(r47);
        if (r114 == true) goto L162;
    L164:
        r46 = true;
        goto L165
    L162:
        if (r123.getRight() <= r36) goto L164;
        r36 = Math.max(r36, r123.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin() + r123.getRight());
    L165:
        if (r48 == r125) goto L173;
        r123.setHeight(r48);
        if (r35 == true) goto L169;
    L171:
        r46 = true;
        goto L173
    L169:
        if (r123.getBottom() <= r115) goto L171;
        r115 = Math.max(r115, r123.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin() + r123.getBottom());
    L173:
        if (r123.hasBaseline() == true) goto L175;
    L177:
        r117 = r46;
        goto L178
    L175:
        if (r45 == r123.getBaselineDistance()) goto L177;
        r117 = true;
        goto L178
    L179:
        boolean r214 = r3;
        int r215 = r22;
        Measurer r216 = r5;
        if (r117 == false) goto L182;
        r43 = r43 + 1;
        solveLinearSystem(r24, "intermediate pass", r43, r121, r122);
        r5 = r216;
        r3 = r214;
        r22 = r215;
        r42 = 2;
        r117 = false;
    L182:
        int r0 = r310;
    L184:
        r24.setOptimizationLevel(r0);
        return 0;
    L100:
        r35 = false;
        goto L101
    L96:
        r114 = false;
        goto L98
    L183:
        r0 = r21;
    L68:
        boolean r127 = r24.directMeasureSetup(r9);
        if (r28 != 1073741824) goto L71;
        r127 = r127 & r24.directMeasureWithOrientation(r9, 0);
        r112 = 1;
    L72:
        if (r30 != 1073741824) goto L74;
        r20 = r24.directMeasureWithOrientation(r9, 1) & r127;
        r112 = r112 + 1;
        goto L75
    L74:
        r20 = r127;
        goto L75
    L71:
        r112 = 0;
        goto L72
    L63:
        if (r24.getHeight() == r111) goto L65;
        r24.setHeight(r111);
        r24.invalidateGraph();
        goto L65
    L59:
        if (r24.getWidth() == r110) goto L61;
        r24.setWidth(r110);
        r24.invalidateGraph();
        goto L61
    L83:
        r20 = false;
        r112 = 0;
    L51:
        if (r9 == true) goto L52;
        r18 = false;
        goto L54
    L5:
        if (Optimizer.enabled(r25, 64) == true) goto L8;
        r2 = false;
        goto L9
    }

    public void updateHierarchy(ConstraintWidgetContainer r6) {
        this.mVariableDimensionsWidgets.clear();
        int r0 = r6.mChildren.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        ConstraintWidget r2 = r6.mChildren.get(r1);
        ConstraintWidget.DimensionBehaviour r3 = r2.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r3 != r4) goto L7;
    L8:
        this.mVariableDimensionsWidgets.add(r2);
    L9:
        r1 = r1 + 1;
        goto L3
    L7:
        if (r2.getVerticalDimensionBehaviour() != r4) goto L9;
    L10:
        r6.invalidateGraph();
    }
}
