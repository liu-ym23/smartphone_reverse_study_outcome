package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ChainHead;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static final boolean EARLY_TERMINATION = true;
    private static int hcount;
    private static BasicMeasure.Measure measure;
    private static int vcount;

    static {
        measure = new BasicMeasure.Measure();
        hcount = 0;
        vcount = 0;
    }

    public Direct() {
    }

    private static boolean canMeasure(int r7, ConstraintWidget r8) {
        ConstraintWidget.DimensionBehaviour r9 = r8.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r0 = r8.getVerticalDimensionBehaviour();
        if (r8.getParent() == null) goto L5;
        ConstraintWidgetContainer r1 = (ConstraintWidgetContainer) r8.getParent();
    L6:
        if (r1 == null) goto L8;
        r1.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r3 = ConstraintWidget.DimensionBehaviour.FIXED;
    L8:
        if (r1 == null) goto L10;
        r1.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.FIXED;
    L10:
        ConstraintWidget.DimensionBehaviour r4 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r9 != r4) goto L13;
    L31:
        boolean r10 = true;
    L32:
        if (r0 != r4) goto L34;
    L52:
        boolean r5 = true;
    L54:
        if (r8.mDimensionRatio <= 0.0f) goto L58;
        if (r10 == true) goto L57;
        if (r5 == false) goto L58;
    L57:
        return true;
    L58:
        if (r10 == false) goto L62;
        if (r5 == true) goto L61;
        return false;
    L61:
        return true;
    L62:
        return false;
    L34:
        if (r8.isResolvedVertically() == true) goto L52;
        if (r0 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L52;
        ConstraintWidget.DimensionBehaviour r6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r0 == r6) goto L40;
    L45:
        if (r0 == r6) goto L47;
    L51:
        r5 = false;
        goto L54
    L47:
        if (r8.mMatchConstraintDefaultHeight != 1) goto L51;
        if (r8.hasResolvedTargets(1, r8.getHeight()) == false) goto L51;
    L40:
        if (r8.mMatchConstraintDefaultHeight != 0) goto L45;
        if (r8.mDimensionRatio != 0.0f) goto L45;
        if (r8.hasDanglingDimension(1) == true) goto L52;
    L13:
        if (r8.isResolvedHorizontally() == true) goto L31;
        if (r9 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
        ConstraintWidget.DimensionBehaviour r11 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r9 == r11) goto L19;
    L24:
        if (r9 == r11) goto L26;
    L30:
        r10 = false;
        goto L32
    L26:
        if (r8.mMatchConstraintDefaultWidth != 1) goto L30;
        if (r8.hasResolvedTargets(0, r8.getWidth()) == false) goto L30;
    L19:
        if (r8.mMatchConstraintDefaultWidth != 0) goto L24;
        if (r8.mDimensionRatio != 0.0f) goto L24;
        if (r8.hasDanglingDimension(0) == true) goto L31;
    L5:
        r1 = null;
        goto L6
    }

    private static void horizontalSolvingPass(int r16, ConstraintWidget r17, BasicMeasure.Measurer r18, boolean r19) {
        if (r17.isHorizontalSolvingPassDone() == false) goto L5;
        return;
    L5:
        boolean r4 = true;
        hcount++;
        if ((r17 instanceof ConstraintWidgetContainer) == false) goto L8;
    L12:
        ConstraintAnchor r3 = r17.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r5 = r17.getAnchor(ConstraintAnchor.Type.RIGHT);
        int r6 = r3.getFinalValue();
        int r7 = r5.getFinalValue();
        if (r3.getDependents() == null) goto L80;
        if (r3.hasFinalValue() == false) goto L80;
        Iterator<ConstraintAnchor> r8 = r3.getDependents().iterator();
    L18:
        if (r8.hasNext() == false) goto L80;
        ConstraintAnchor r9 = r8.next();
        ConstraintWidget r12 = r9.mOwner;
        int r13 = r16 + 1;
        boolean r14 = canMeasure(r13, r12);
        if (r12.isMeasureRequested() == false) goto L24;
        if (r14 == false) goto L24;
        ConstraintWidgetContainer.measure(r13, r12, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L24:
        if (r9 != r12.mLeft) goto L30;
        ConstraintAnchor r11 = r12.mRight.mTarget;
        if (r11 == null) goto L30;
        if (r11.hasFinalValue() == false) goto L30;
    L35:
        boolean r15 = r4;
    L37:
        ConstraintWidget.DimensionBehaviour r110 = r12.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r10 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r110 != r10) goto L62;
        if (r14 == true) goto L62;
        if (r12.getHorizontalDimensionBehaviour() != r10) goto L63;
        if (r12.mMatchConstraintMaxWidth < 0) goto L63;
        if (r12.mMatchConstraintMinWidth < 0) goto L63;
        if (r12.getVisibility() == 8) goto L54;
        if (r12.mMatchConstraintDefaultWidth != 0) goto L63;
        if (r12.getDimensionRatio() != 0.0f) goto L63;
    L54:
        if (r12.isInHorizontalChain() == true) goto L63;
        if (r12.isInVirtualLayout() == true) goto L63;
        if (r15 == false) goto L63;
        if (r12.isInHorizontalChain() == true) goto L63;
        solveHorizontalMatchConstraint(r13, r17, r18, r12, r19);
    L63:
        r4 = true;
    L62:
        if (r12.isMeasureRequested() == true) goto L63;
        ConstraintAnchor r20 = r12.mLeft;
        if (r9 == r20) goto L67;
    L70:
        ConstraintAnchor r111 = r12.mRight;
        if (r9 == r111) goto L73;
    L75:
        if (r15 == false) goto L63;
        if (r12.isInHorizontalChain() == true) goto L63;
        solveHorizontalCenterConstraints(r13, r18, r12, r19);
        goto L63
    L73:
        if (r20.mTarget != null) goto L75;
        int r21 = r6 - r111.getMargin();
        r12.setFinalHorizontal(r21 - r12.getWidth(), r21);
    L69:
        horizontalSolvingPass(r13, r12, r18, r19);
        goto L63
    L67:
        if (r12.mRight.mTarget != null) goto L70;
        int r22 = r20.getMargin() + r6;
        r12.setFinalHorizontal(r22, r12.getWidth() + r22);
    L30:
        if (r9 != r12.mRight) goto L36;
        ConstraintAnchor r112 = r12.mLeft.mTarget;
        if (r112 == null) goto L36;
        if (r112.hasFinalValue() == true) goto L35;
    L36:
        r15 = false;
    L80:
        if ((r17 instanceof Guideline) == false) goto L83;
        return;
    L83:
        if (r5.getDependents() != null) goto L85;
    L149:
        r17.markHorizontalSolvingPassDone();
        return;
    L85:
        if (r5.hasFinalValue() == false) goto L149;
        Iterator<ConstraintAnchor> r23 = r5.getDependents().iterator();
    L88:
        if (r23.hasNext() == false) goto L149;
        ConstraintAnchor r24 = r23.next();
        ConstraintWidget r25 = r24.mOwner;
        int r26 = r16 + 1;
        boolean r113 = canMeasure(r26, r25);
        if (r25.isMeasureRequested() == false) goto L94;
        if (r113 == false) goto L94;
        ConstraintWidgetContainer.measure(r26, r25, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L94:
        if (r24 != r25.mLeft) goto L100;
        ConstraintAnchor r114 = r25.mRight.mTarget;
        if (r114 == null) goto L100;
        if (r114.hasFinalValue() == false) goto L100;
    L105:
        boolean r115 = true;
    L107:
        ConstraintWidget.DimensionBehaviour r116 = r25.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r117 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r116 != r117) goto L132;
        if (r113 == true) goto L132;
        if (r25.getHorizontalDimensionBehaviour() != r117) goto L88;
        if (r25.mMatchConstraintMaxWidth < 0) goto L88;
        if (r25.mMatchConstraintMinWidth < 0) goto L88;
        if (r25.getVisibility() == 8) goto L124;
        if (r25.mMatchConstraintDefaultWidth != 0) goto L88;
        if (r25.getDimensionRatio() != 0.0f) goto L88;
    L124:
        if (r25.isInHorizontalChain() == true) goto L88;
        if (r25.isInVirtualLayout() == true) goto L88;
        if (r115 == false) goto L88;
        if (r25.isInHorizontalChain() == true) goto L88;
        solveHorizontalMatchConstraint(r26, r17, r18, r25, r19);
    L132:
        if (r25.isMeasureRequested() == true) goto L88;
        ConstraintAnchor r118 = r25.mLeft;
        if (r24 == r118) goto L137;
    L140:
        ConstraintAnchor r119 = r25.mRight;
        if (r24 != r119) goto L145;
        if (r118.mTarget != null) goto L145;
        int r27 = r7 - r119.getMargin();
        r25.setFinalHorizontal(r27 - r25.getWidth(), r27);
    L139:
        horizontalSolvingPass(r26, r25, r18, r19);
    L145:
        if (r115 == false) goto L88;
        if (r25.isInHorizontalChain() == true) goto L88;
        solveHorizontalCenterConstraints(r26, r18, r25, r19);
        goto L88
    L137:
        if (r25.mRight.mTarget != null) goto L140;
        int r28 = r118.getMargin() + r7;
        r25.setFinalHorizontal(r28, r25.getWidth() + r28);
    L100:
        if (r24 != r25.mRight) goto L106;
        ConstraintAnchor r120 = r25.mLeft.mTarget;
        if (r120 == null) goto L106;
        if (r120.hasFinalValue() == true) goto L105;
    L106:
        r115 = false;
        goto L107
    L8:
        if (r17.isMeasureRequested() == false) goto L12;
        int r29 = r16 + 1;
        if (canMeasure(r29, r17) == false) goto L12;
        ConstraintWidgetContainer.measure(r29, r17, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L12
    }

    public static String ls(int r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r0.append("  ");
        r1 = r1 + 1;
        goto L3
    L5:
        r0.append("+-(" + r3 + ") ");
        return r0.toString();
    }

    private static void solveBarrier(int r1, Barrier r2, BasicMeasure.Measurer r3, int r4, boolean r5) {
        if (r2.allSolved() == false) goto L9;
        int r6 = r1 + 1;
        if (r4 != 0) goto L7;
        horizontalSolvingPass(r6, r2, r3, r5);
        return;
    L7:
        verticalSolvingPass(r6, r2, r3);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    public static boolean solveChain(ConstraintWidgetContainer r20, LinearSystem r21, int r22, int r23, ChainHead r24, boolean r25, boolean r26, boolean r27) {
        if (r27 == false) goto L5;
        return false;
    L5:
        if (r22 != 0) goto L10;
        if (r20.isResolvedHorizontally() == true) goto L12;
        return false;
    L12:
        boolean r1 = r20.isRtl();
        ConstraintWidget r2 = r24.getFirst();
        ConstraintWidget r3 = r24.getLast();
        ConstraintWidget r4 = r24.getFirstVisibleWidget();
        ConstraintWidget r5 = r24.getLastVisibleWidget();
        ConstraintWidget r6 = r24.getHead();
        ConstraintAnchor r7 = r2.mListAnchors[r23];
        int r8 = r23 + 1;
        ConstraintAnchor r9 = r3.mListAnchors[r8];
        ConstraintAnchor r10 = r7.mTarget;
        if (r10 != null) goto L15;
    L119:
        return false;
    L15:
        if (r9.mTarget == null) goto L119;
        if (r10.hasFinalValue() == false) goto L119;
        if (r9.mTarget.hasFinalValue() == false) goto L119;
        if (r4 == null) goto L119;
        if (r5 == null) goto L119;
        int r11 = r7.mTarget.getFinalValue() + r4.mListAnchors[r23].getMargin();
        int r12 = r9.mTarget.getFinalValue() - r5.mListAnchors[r8].getMargin();
        int r13 = r12 - r11;
        if (r13 > 0) goto L28;
        return false;
    L28:
        BasicMeasure.Measure r14 = new BasicMeasure.Measure();
        boolean r15 = false;
        int r16 = 0;
        int r17 = 0;
        int r18 = 0;
        ConstraintWidget r19 = r2;
    L29:
        ConstraintWidget r110 = null;
        if (r15 == true) goto L60;
        if (canMeasure(1, r19) == false) goto L33;
        ConstraintWidget r111 = r2;
        if (r19.mListDimensionBehaviors[r22] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        if (r19.isMeasureRequested() == false) goto L41;
        ConstraintWidgetContainer.measure(1, r19, r20.getMeasurer(), r14, BasicMeasure.Measure.SELF_DIMENSIONS);
    L41:
        int r112 = r18 + r19.mListAnchors[r23].getMargin();
        if (r22 != 0) goto L44;
        int r0 = r19.getWidth();
    L45:
        r18 = (r112 + r0) + r19.mListAnchors[r8].getMargin();
        r17 = r17 + 1;
        if (r19.getVisibility() == 8) goto L48;
        r16 = r16 + 1;
    L48:
        ConstraintAnchor r28 = r19.mListAnchors[r8].mTarget;
        if (r28 == null) goto L56;
        ConstraintWidget r29 = r28.mOwner;
        ConstraintAnchor[] r30 = r29.mListAnchors;
        if (r30[r23].mTarget == null) goto L56;
        if (r30[r23].mTarget.mOwner != r19) goto L56;
        r110 = r29;
    L56:
        if (r110 == null) goto L58;
        r19 = r110;
        r15 = r15;
    L59:
        r2 = r111;
        goto L29
    L58:
        r15 = true;
        goto L59
    L44:
        r0 = r19.getHeight();
        goto L45
    L36:
        return false;
    L33:
        return false;
    L60:
        ConstraintWidget r113 = r2;
        if (r16 != 0) goto L63;
        return false;
    L63:
        if (r16 == r17) goto L65;
        return false;
    L65:
        if (r13 >= r18) goto L67;
        return false;
    L67:
        int r31 = r13 - r18;
        if (r25 == false) goto L71;
        r31 = r31 / (r16 + 1);
    L70:
        int r32 = 1;
    L74:
        if (r16 != r32) goto L84;
        if (r22 != 0) goto L77;
        float r33 = r6.getHorizontalBiasPercent();
    L78:
        int r34 = (int) ((r11 + 0.5f) + (r31 * r33));
        if (r22 != 0) goto L81;
        r4.setFinalHorizontal(r34, r4.getWidth() + r34);
    L82:
        horizontalSolvingPass(1, r4, r20.getMeasurer(), r1);
        return true;
    L81:
        r4.setFinalVertical(r34, r4.getHeight() + r34);
        goto L82
    L77:
        r33 = r6.getVerticalBiasPercent();
        goto L78
    L84:
        if (r25 == false) goto L109;
        int r35 = r11 + r31;
        ConstraintWidget r36 = r113;
        boolean r37 = false;
        ?? r38 = r32;
    L86:
        if (r37 == true) goto L129;
        if (r36.getVisibility() != 8) goto L93;
        if (r22 != 0) goto L91;
        r36.setFinalHorizontal(r35, r35);
        horizontalSolvingPass(r38, r36, r20.getMeasurer(), r1);
    L98:
        r36.addToSolver(r21, false);
        ConstraintAnchor r39 = r36.mListAnchors[r8].mTarget;
        if (r39 == null) goto L104;
        ConstraintWidget r40 = r39.mOwner;
        ConstraintAnchor[] r41 = r40.mListAnchors;
        if (r41[r23].mTarget == null) goto L104;
        if (r41[r23].mTarget.mOwner != r36) goto L104;
    L105:
        if (r40 == null) goto L107;
        r36 = r40;
    L108:
        r38 = 1;
        goto L86
    L107:
        r37 = true;
    L104:
        r40 = null;
        goto L105
    L91:
        r36.setFinalVertical(r35, r35);
        verticalSolvingPass(r38, r36, r20.getMeasurer());
        goto L98
    L93:
        int r42 = r35 + r36.mListAnchors[r23].getMargin();
        if (r22 != 0) goto L96;
        r36.setFinalHorizontal(r42, r36.getWidth() + r42);
        horizontalSolvingPass(1, r36, r20.getMeasurer(), r1);
        int r43 = r36.getWidth();
    L97:
        r35 = ((r42 + r43) + r36.mListAnchors[r8].getMargin()) + r31;
        goto L98
    L96:
        r36.setFinalVertical(r42, r36.getHeight() + r42);
        verticalSolvingPass(1, r36, r20.getMeasurer());
        r43 = r36.getHeight();
        goto L97
    L129:
        return r38;
    L109:
        if (r26 == false) goto L117;
        if (r16 != 2) goto L115;
        if (r22 != 0) goto L113;
        r4.setFinalHorizontal(r11, r4.getWidth() + r11);
        r5.setFinalHorizontal(r12 - r5.getWidth(), r12);
        horizontalSolvingPass(1, r4, r20.getMeasurer(), r1);
        horizontalSolvingPass(1, r5, r20.getMeasurer(), r1);
        return true;
    L113:
        r4.setFinalVertical(r11, r4.getHeight() + r11);
        r5.setFinalVertical(r12 - r5.getHeight(), r12);
        verticalSolvingPass(1, r4, r20.getMeasurer());
        verticalSolvingPass(1, r5, r20.getMeasurer());
        return true;
    L115:
        return false;
    L117:
        return true;
    L71:
        if (r26 == false) goto L70;
        if (r16 <= 2) goto L70;
        r32 = 1;
        r31 = (r31 / r16) - 1;
        goto L74
    L10:
        if (r20.isResolvedVertically() == true) goto L12;
        return false;
    }

    private static void solveHorizontalCenterConstraints(int r6, BasicMeasure.Measurer r7, ConstraintWidget r8, boolean r9) {
        float r0 = r8.getHorizontalBiasPercent();
        int r1 = r8.mLeft.mTarget.getFinalValue();
        int r2 = r8.mRight.mTarget.getFinalValue();
        int r3 = r8.mLeft.getMargin() + r1;
        int r4 = r2 - r8.mRight.getMargin();
        if (r1 != r2) goto L5;
        r0 = 0.5f;
    L6:
        int r5 = r8.getWidth();
        int r10 = (r2 - r1) - r5;
        if (r1 <= r2) goto L9;
        r10 = (r1 - r2) - r5;
    L9:
        if (r10 <= 0) goto L11;
        float r11 = (r0 * r10) + 0.5f;
    L12:
        int r12 = ((int) r11) + r1;
        int r13 = r12 + r5;
        if (r1 <= r2) goto L15;
        r13 = r12 - r5;
    L15:
        r8.setFinalHorizontal(r12, r13);
        horizontalSolvingPass(r6 + 1, r8, r7, r9);
        return;
    L11:
        r11 = r0 * r10;
        goto L12
    L5:
        r1 = r3;
        r2 = r4;
        goto L6
    }

    private static void solveHorizontalMatchConstraint(int r7, ConstraintWidget r8, BasicMeasure.Measurer r9, ConstraintWidget r10, boolean r11) {
        float r0 = r10.getHorizontalBiasPercent();
        int r1 = r10.mLeft.mTarget.getFinalValue() + r10.mLeft.getMargin();
        int r2 = r10.mRight.mTarget.getFinalValue() - r10.mRight.getMargin();
        if (r2 < r1) goto L20;
        int r3 = r10.getWidth();
        if (r10.getVisibility() == 8) goto L18;
        int r4 = r10.mMatchConstraintDefaultWidth;
        if (r4 == 2) goto L9;
        if (r4 != 0) goto L15;
        r3 = r2 - r1;
    L15:
        r3 = Math.max(r10.mMatchConstraintMinWidth, r3);
        int r12 = r10.mMatchConstraintMaxWidth;
        if (r12 <= 0) goto L18;
        r3 = Math.min(r12, r3);
        goto L18
    L9:
        if ((r8 instanceof ConstraintWidgetContainer) == true) goto L12;
        r8 = r8.getParent();
    L12:
        r3 = (int) ((r10.getHorizontalBiasPercent() * 0.5f) * r8.getWidth());
    L18:
        int r5 = r1 + ((int) ((r0 * ((r2 - r1) - r3)) + 0.5f));
        r10.setFinalHorizontal(r5, r3 + r5);
        horizontalSolvingPass(r7 + 1, r10, r9, r11);
        return;
    }

    private static void solveVerticalCenterConstraints(int r6, BasicMeasure.Measurer r7, ConstraintWidget r8) {
        float r0 = r8.getVerticalBiasPercent();
        int r1 = r8.mTop.mTarget.getFinalValue();
        int r2 = r8.mBottom.mTarget.getFinalValue();
        int r3 = r8.mTop.getMargin() + r1;
        int r4 = r2 - r8.mBottom.getMargin();
        if (r1 != r2) goto L5;
        r0 = 0.5f;
    L6:
        int r5 = r8.getHeight();
        int r9 = (r2 - r1) - r5;
        if (r1 <= r2) goto L9;
        r9 = (r1 - r2) - r5;
    L9:
        if (r9 <= 0) goto L11;
        float r10 = (r0 * r9) + 0.5f;
    L12:
        int r11 = (int) r10;
        int r12 = r1 + r11;
        int r13 = r12 + r5;
        if (r1 <= r2) goto L15;
        r12 = r1 - r11;
        r13 = r12 - r5;
    L15:
        r8.setFinalVertical(r12, r13);
        verticalSolvingPass(r6 + 1, r8, r7);
        return;
    L11:
        r10 = r0 * r9;
        goto L12
    L5:
        r1 = r3;
        r2 = r4;
        goto L6
    }

    private static void solveVerticalMatchConstraint(int r7, ConstraintWidget r8, BasicMeasure.Measurer r9, ConstraintWidget r10) {
        float r0 = r10.getVerticalBiasPercent();
        int r1 = r10.mTop.mTarget.getFinalValue() + r10.mTop.getMargin();
        int r2 = r10.mBottom.mTarget.getFinalValue() - r10.mBottom.getMargin();
        if (r2 < r1) goto L20;
        int r3 = r10.getHeight();
        if (r10.getVisibility() == 8) goto L18;
        int r4 = r10.mMatchConstraintDefaultHeight;
        if (r4 == 2) goto L9;
        if (r4 != 0) goto L15;
        r3 = r2 - r1;
    L15:
        r3 = Math.max(r10.mMatchConstraintMinHeight, r3);
        int r11 = r10.mMatchConstraintMaxHeight;
        if (r11 <= 0) goto L18;
        r3 = Math.min(r11, r3);
        goto L18
    L9:
        if ((r8 instanceof ConstraintWidgetContainer) == true) goto L12;
        r8 = r8.getParent();
    L12:
        r3 = (int) ((r0 * 0.5f) * r8.getHeight());
    L18:
        int r5 = r1 + ((int) ((r0 * ((r2 - r1) - r3)) + 0.5f));
        r10.setFinalVertical(r5, r3 + r5);
        verticalSolvingPass(r7 + 1, r10, r9);
        return;
    }

    public static void solvingPass(ConstraintWidgetContainer r13, BasicMeasure.Measurer r14) {
        ConstraintWidget.DimensionBehaviour r0 = r13.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r1 = r13.getVerticalDimensionBehaviour();
        hcount = 0;
        vcount = 0;
        r13.resetFinalResolution();
        ArrayList<ConstraintWidget> r3 = r13.getChildren();
        int r4 = r3.size();
        int r5 = 0;
    L3:
        if (r5 >= r4) goto L5;
        r3.get(r5).resetFinalResolution();
        r5 = r5 + 1;
        goto L3
    L5:
        boolean r6 = r13.isRtl();
        if (r0 != ConstraintWidget.DimensionBehaviour.FIXED) goto L8;
        r13.setFinalHorizontal(0, r13.getWidth());
    L9:
        int r2 = 0;
        boolean r7 = false;
        boolean r8 = false;
    L11:
        if (r2 >= r4) goto L35;
        ConstraintWidget r11 = r3.get(r2);
        if ((r11 instanceof Guideline) == false) goto L30;
        Guideline r12 = (Guideline) r11;
        if (r12.getOrientation() != 1) goto L34;
        if (r12.getRelativeBegin() == (-1)) goto L21;
        int r9 = r12.getRelativeBegin();
    L19:
        r12.setFinalValue(r9);
    L28:
        r7 = true;
        goto L34
    L21:
        if (r12.getRelativeEnd() == (-1)) goto L26;
        if (r13.isResolvedHorizontally() == false) goto L26;
        r9 = r13.getWidth() - r12.getRelativeEnd();
    L26:
        if (r13.isResolvedHorizontally() == false) goto L28;
        r9 = (int) ((r12.getRelativePercent() * r13.getWidth()) + 0.5f);
    L34:
        r2 = r2 + 1;
        goto L11
    L30:
        if ((r11 instanceof Barrier) == false) goto L34;
        if (((Barrier) r11).getOrientation() != 0) goto L34;
        r8 = true;
        goto L34
    L35:
        if (r7 == false) goto L44;
        int r10 = 0;
    L37:
        if (r10 >= r4) goto L44;
        ConstraintWidget r15 = r3.get(r10);
        if ((r15 instanceof Guideline) == false) goto L43;
        Guideline r16 = (Guideline) r15;
        if (r16.getOrientation() != 1) goto L43;
        horizontalSolvingPass(0, r16, r14, r6);
    L43:
        r10 = r10 + 1;
    L44:
        horizontalSolvingPass(0, r13, r14, r6);
        if (r8 == false) goto L55;
        int r17 = 0;
    L47:
        if (r17 >= r4) goto L55;
        ConstraintWidget r18 = r3.get(r17);
        if ((r18 instanceof Barrier) == false) goto L53;
        Barrier r19 = (Barrier) r18;
        if (r19.getOrientation() != 0) goto L53;
        solveBarrier(0, r19, r14, 0, r6);
    L53:
        r17 = r17 + 1;
    L55:
        if (r1 != ConstraintWidget.DimensionBehaviour.FIXED) goto L57;
        r13.setFinalVertical(0, r13.getHeight());
    L58:
        int r20 = 0;
        boolean r21 = false;
        boolean r22 = false;
    L59:
        if (r20 >= r4) goto L83;
        ConstraintWidget r23 = r3.get(r20);
        if ((r23 instanceof Guideline) == false) goto L78;
        Guideline r24 = (Guideline) r23;
        if (r24.getOrientation() != 0) goto L82;
        if (r24.getRelativeBegin() == (-1)) goto L69;
        int r25 = r24.getRelativeBegin();
    L67:
        r24.setFinalValue(r25);
    L76:
        r21 = true;
        goto L82
    L69:
        if (r24.getRelativeEnd() == (-1)) goto L74;
        if (r13.isResolvedVertically() == false) goto L74;
        r25 = r13.getHeight() - r24.getRelativeEnd();
    L74:
        if (r13.isResolvedVertically() == false) goto L76;
        r25 = (int) ((r24.getRelativePercent() * r13.getHeight()) + 0.5f);
    L82:
        r20 = r20 + 1;
        goto L59
    L78:
        if ((r23 instanceof Barrier) == false) goto L82;
        if (((Barrier) r23).getOrientation() != 1) goto L82;
        r22 = true;
        goto L82
    L83:
        if (r21 == false) goto L92;
        int r26 = 0;
    L85:
        if (r26 >= r4) goto L92;
        ConstraintWidget r27 = r3.get(r26);
        if ((r27 instanceof Guideline) == false) goto L91;
        Guideline r28 = (Guideline) r27;
        if (r28.getOrientation() != 0) goto L91;
        verticalSolvingPass(1, r28, r14);
    L91:
        r26 = r26 + 1;
    L92:
        verticalSolvingPass(0, r13, r14);
        if (r22 == false) goto L102;
        int r110 = 0;
    L95:
        if (r110 >= r4) goto L102;
        ConstraintWidget r29 = r3.get(r110);
        if ((r29 instanceof Barrier) == false) goto L101;
        Barrier r30 = (Barrier) r29;
        if (r30.getOrientation() != 1) goto L101;
        solveBarrier(0, r30, r14, 1, r6);
    L101:
        r110 = r110 + 1;
    L102:
        int r111 = 0;
    L103:
        if (r111 >= r4) goto L117;
        ConstraintWidget r31 = r3.get(r111);
        if (r31.isMeasureRequested() == false) goto L116;
        if (canMeasure(0, r31) == false) goto L116;
        ConstraintWidgetContainer.measure(0, r31, r14, measure, BasicMeasure.Measure.SELF_DIMENSIONS);
        if ((r31 instanceof Guideline) == true) goto L111;
        horizontalSolvingPass(0, r31, r14, r6);
    L115:
        verticalSolvingPass(0, r31, r14);
        goto L116
    L111:
        if (((Guideline) r31).getOrientation() == 0) goto L115;
        horizontalSolvingPass(0, r31, r14, r6);
    L116:
        r111 = r111 + 1;
        goto L103
    L117:
        return;
    L57:
        r13.setFinalTop(0);
        goto L58
    L8:
        r13.setFinalLeft(0);
        goto L9
    }

    private static void verticalSolvingPass(int r16, ConstraintWidget r17, BasicMeasure.Measurer r18) {
        if (r17.isVerticalSolvingPassDone() == false) goto L5;
        return;
    L5:
        vcount++;
        if ((r17 instanceof ConstraintWidgetContainer) == false) goto L8;
    L12:
        ConstraintAnchor r2 = r17.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r4 = r17.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int r5 = r2.getFinalValue();
        int r6 = r4.getFinalValue();
        if (r2.getDependents() == null) goto L80;
        if (r2.hasFinalValue() == false) goto L80;
        Iterator<ConstraintAnchor> r3 = r2.getDependents().iterator();
    L18:
        if (r3.hasNext() == false) goto L80;
        ConstraintAnchor r7 = r3.next();
        ConstraintWidget r11 = r7.mOwner;
        int r12 = r16 + 1;
        boolean r13 = canMeasure(r12, r11);
        if (r11.isMeasureRequested() == false) goto L24;
        if (r13 == false) goto L24;
        ConstraintWidgetContainer.measure(r12, r11, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L24:
        if (r7 != r11.mTop) goto L30;
        ConstraintAnchor r14 = r11.mBottom.mTarget;
        if (r14 == null) goto L30;
        if (r14.hasFinalValue() == false) goto L30;
    L35:
        boolean r15 = true;
    L37:
        ConstraintWidget.DimensionBehaviour r19 = r11.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r10 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r19 != r10) goto L62;
        if (r13 == true) goto L62;
        if (r11.getVerticalDimensionBehaviour() != r10) goto L18;
        if (r11.mMatchConstraintMaxHeight < 0) goto L18;
        if (r11.mMatchConstraintMinHeight < 0) goto L18;
        if (r11.getVisibility() == 8) goto L54;
        if (r11.mMatchConstraintDefaultHeight != 0) goto L18;
        if (r11.getDimensionRatio() != 0.0f) goto L18;
    L54:
        if (r11.isInVerticalChain() == true) goto L18;
        if (r11.isInVirtualLayout() == true) goto L18;
        if (r15 == false) goto L18;
        if (r11.isInVerticalChain() == true) goto L18;
        solveVerticalMatchConstraint(r12, r17, r18, r11);
    L62:
        if (r11.isMeasureRequested() == true) goto L18;
        ConstraintAnchor r110 = r11.mTop;
        if (r7 == r110) goto L67;
    L70:
        ConstraintAnchor r111 = r11.mBottom;
        if (r7 != r111) goto L75;
        if (r110.mTarget != null) goto L75;
        int r8 = r5 - r111.getMargin();
        r11.setFinalVertical(r8 - r11.getHeight(), r8);
    L69:
        verticalSolvingPass(r12, r11, r18);
    L75:
        if (r15 == false) goto L18;
        if (r11.isInVerticalChain() == true) goto L18;
        solveVerticalCenterConstraints(r12, r18, r11);
        goto L18
    L67:
        if (r11.mBottom.mTarget != null) goto L70;
        int r9 = r110.getMargin() + r5;
        r11.setFinalVertical(r9, r11.getHeight() + r9);
    L30:
        if (r7 != r11.mBottom) goto L36;
        ConstraintAnchor r112 = r11.mTop.mTarget;
        if (r112 == null) goto L36;
        if (r112.hasFinalValue() == true) goto L35;
    L36:
        r15 = false;
    L80:
        if ((r17 instanceof Guideline) == false) goto L83;
        return;
    L83:
        if (r4.getDependents() != null) goto L85;
    L149:
        ConstraintAnchor r20 = r17.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r20.getDependents() != null) goto L152;
    L169:
        r17.markVerticalSolvingPassDone();
        return;
    L152:
        if (r20.hasFinalValue() == false) goto L169;
        int r21 = r20.getFinalValue();
        Iterator<ConstraintAnchor> r22 = r20.getDependents().iterator();
    L155:
        if (r22.hasNext() == false) goto L169;
        ConstraintAnchor r23 = r22.next();
        ConstraintWidget r24 = r23.mOwner;
        int r25 = r16 + 1;
        boolean r26 = canMeasure(r25, r24);
        if (r24.isMeasureRequested() == false) goto L161;
        if (r26 == false) goto L161;
        ConstraintWidgetContainer.measure(r25, r24, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L161:
        if (r24.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L164;
        if (r26 == false) goto L155;
    L164:
        if (r24.isMeasureRequested() == true) goto L155;
        if (r23 != r24.mBaseline) goto L155;
        r24.setFinalBaseline(r23.getMargin() + r21);
        verticalSolvingPass(r25, r24, r18);
        goto L155
    L85:
        if (r4.hasFinalValue() == false) goto L149;
        Iterator<ConstraintAnchor> r27 = r4.getDependents().iterator();
    L88:
        if (r27.hasNext() == false) goto L149;
        ConstraintAnchor r28 = r27.next();
        ConstraintWidget r29 = r28.mOwner;
        int r30 = r16 + 1;
        boolean r113 = canMeasure(r30, r29);
        if (r29.isMeasureRequested() == false) goto L94;
        if (r113 == false) goto L94;
        ConstraintWidgetContainer.measure(r30, r29, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L94:
        if (r28 != r29.mTop) goto L100;
        ConstraintAnchor r114 = r29.mBottom.mTarget;
        if (r114 == null) goto L100;
        if (r114.hasFinalValue() == false) goto L100;
    L105:
        boolean r115 = true;
    L107:
        ConstraintWidget.DimensionBehaviour r116 = r29.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r117 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r116 != r117) goto L132;
        if (r113 == true) goto L132;
        if (r29.getVerticalDimensionBehaviour() != r117) goto L88;
        if (r29.mMatchConstraintMaxHeight < 0) goto L88;
        if (r29.mMatchConstraintMinHeight < 0) goto L88;
        if (r29.getVisibility() == 8) goto L124;
        if (r29.mMatchConstraintDefaultHeight != 0) goto L88;
        if (r29.getDimensionRatio() != 0.0f) goto L88;
    L124:
        if (r29.isInVerticalChain() == true) goto L88;
        if (r29.isInVirtualLayout() == true) goto L88;
        if (r115 == false) goto L88;
        if (r29.isInVerticalChain() == true) goto L88;
        solveVerticalMatchConstraint(r30, r17, r18, r29);
    L132:
        if (r29.isMeasureRequested() == true) goto L88;
        ConstraintAnchor r118 = r29.mTop;
        if (r28 == r118) goto L137;
    L140:
        ConstraintAnchor r119 = r29.mBottom;
        if (r28 != r119) goto L145;
        if (r118.mTarget != null) goto L145;
        int r31 = r6 - r119.getMargin();
        r29.setFinalVertical(r31 - r29.getHeight(), r31);
    L139:
        verticalSolvingPass(r30, r29, r18);
    L145:
        if (r115 == false) goto L88;
        if (r29.isInVerticalChain() == true) goto L88;
        solveVerticalCenterConstraints(r30, r18, r29);
        goto L88
    L137:
        if (r29.mBottom.mTarget != null) goto L140;
        int r32 = r118.getMargin() + r6;
        r29.setFinalVertical(r32, r29.getHeight() + r32);
    L100:
        if (r28 != r29.mBottom) goto L106;
        ConstraintAnchor r120 = r29.mTop.mTarget;
        if (r120 == null) goto L106;
        if (r120.hasFinalValue() == true) goto L105;
    L106:
        r115 = false;
        goto L107
    L8:
        if (r17.isMeasureRequested() == false) goto L12;
        int r33 = r16 + 1;
        if (canMeasure(r33, r17) == false) goto L12;
        ConstraintWidgetContainer.measure(r33, r17, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L12
    }
}
