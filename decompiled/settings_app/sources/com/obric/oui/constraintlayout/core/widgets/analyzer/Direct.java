package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.LinearSystem;
import com.obric.oui.constraintlayout.core.widgets.Barrier;
import com.obric.oui.constraintlayout.core.widgets.ChainHead;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.obric.oui.constraintlayout.core.widgets.Guideline;
import java.util.ArrayList;
import java.util.Iterator;
import obric.tablet.widget.BytedanceJustifyTextView;

/* JADX INFO: loaded from: classes4.dex */
public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static final boolean EARLY_TERMINATION = true;
    private static int sHcount;
    private static BasicMeasure.Measure sMeasure;
    private static int sVcount;

    public Direct() {
    }

    static {
        sMeasure = new BasicMeasure.Measure();
        sHcount = 0;
        sVcount = 0;
    }

    public static void solvingPass(ConstraintWidgetContainer r13, BasicMeasure.Measurer r14) {
        ConstraintWidget.DimensionBehaviour r0 = r13.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r1 = r13.getVerticalDimensionBehaviour();
        sHcount = 0;
        sVcount = 0;
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
        if (r2 >= r4) goto L34;
        ConstraintWidget r11 = r3.get(r2);
        if ((r11 instanceof Guideline) == false) goto L29;
        Guideline r12 = (Guideline) r11;
        if (r12.getOrientation() != 1) goto L33;
        if (r12.getRelativeBegin() == (-1)) goto L20;
        r12.setFinalValue(r12.getRelativeBegin());
    L27:
        r7 = true;
        goto L33
    L20:
        if (r12.getRelativeEnd() == (-1)) goto L25;
        if (r13.isResolvedHorizontally() == false) goto L25;
        r12.setFinalValue(r13.getWidth() - r12.getRelativeEnd());
    L25:
        if (r13.isResolvedHorizontally() == false) goto L27;
        r12.setFinalValue((int) ((r12.getRelativePercent() * r13.getWidth()) + 0.5f));
    L33:
        r2 = r2 + 1;
        goto L11
    L29:
        if ((r11 instanceof Barrier) == false) goto L33;
        if (((Barrier) r11).getOrientation() != 0) goto L33;
        r8 = true;
        goto L33
    L34:
        if (r7 == false) goto L43;
        int r9 = 0;
    L36:
        if (r9 >= r4) goto L43;
        ConstraintWidget r10 = r3.get(r9);
        if ((r10 instanceof Guideline) == false) goto L42;
        Guideline r15 = (Guideline) r10;
        if (r15.getOrientation() != 1) goto L42;
        horizontalSolvingPass(0, r15, r14, r6);
    L42:
        r9 = r9 + 1;
    L43:
        horizontalSolvingPass(0, r13, r14, r6);
        if (r8 == false) goto L54;
        int r16 = 0;
    L46:
        if (r16 >= r4) goto L54;
        ConstraintWidget r17 = r3.get(r16);
        if ((r17 instanceof Barrier) == false) goto L52;
        Barrier r18 = (Barrier) r17;
        if (r18.getOrientation() != 0) goto L52;
        solveBarrier(0, r18, r14, 0, r6);
    L52:
        r16 = r16 + 1;
    L54:
        if (r1 != ConstraintWidget.DimensionBehaviour.FIXED) goto L56;
        r13.setFinalVertical(0, r13.getHeight());
    L57:
        int r19 = 0;
        boolean r20 = false;
        boolean r21 = false;
    L58:
        if (r19 >= r4) goto L81;
        ConstraintWidget r22 = r3.get(r19);
        if ((r22 instanceof Guideline) == false) goto L76;
        Guideline r23 = (Guideline) r22;
        if (r23.getOrientation() != 0) goto L80;
        if (r23.getRelativeBegin() == (-1)) goto L67;
        r23.setFinalValue(r23.getRelativeBegin());
    L74:
        r20 = true;
        goto L80
    L67:
        if (r23.getRelativeEnd() == (-1)) goto L72;
        if (r13.isResolvedVertically() == false) goto L72;
        r23.setFinalValue(r13.getHeight() - r23.getRelativeEnd());
    L72:
        if (r13.isResolvedVertically() == false) goto L74;
        r23.setFinalValue((int) ((r23.getRelativePercent() * r13.getHeight()) + 0.5f));
    L80:
        r19 = r19 + 1;
        goto L58
    L76:
        if ((r22 instanceof Barrier) == false) goto L80;
        if (((Barrier) r22).getOrientation() != 1) goto L80;
        r21 = true;
        goto L80
    L81:
        if (r20 == false) goto L90;
        int r24 = 0;
    L83:
        if (r24 >= r4) goto L90;
        ConstraintWidget r25 = r3.get(r24);
        if ((r25 instanceof Guideline) == false) goto L89;
        Guideline r26 = (Guideline) r25;
        if (r26.getOrientation() != 0) goto L89;
        verticalSolvingPass(1, r26, r14);
    L89:
        r24 = r24 + 1;
    L90:
        verticalSolvingPass(0, r13, r14);
        if (r21 == false) goto L100;
        int r110 = 0;
    L93:
        if (r110 >= r4) goto L100;
        ConstraintWidget r27 = r3.get(r110);
        if ((r27 instanceof Barrier) == false) goto L99;
        Barrier r28 = (Barrier) r27;
        if (r28.getOrientation() != 1) goto L99;
        solveBarrier(0, r28, r14, 1, r6);
    L99:
        r110 = r110 + 1;
    L100:
        int r111 = 0;
    L101:
        if (r111 >= r4) goto L114;
        ConstraintWidget r29 = r3.get(r111);
        if (r29.isMeasureRequested() == false) goto L113;
        if (canMeasure(0, r29) == false) goto L113;
        ConstraintWidgetContainer.measure(0, r29, r14, sMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
        if ((r29 instanceof Guideline) == true) goto L109;
        horizontalSolvingPass(0, r29, r14, r6);
        verticalSolvingPass(0, r29, r14);
        goto L113
    L109:
        if (((Guideline) r29).getOrientation() != 0) goto L111;
        verticalSolvingPass(0, r29, r14);
        goto L113
    L111:
        horizontalSolvingPass(0, r29, r14, r6);
    L113:
        r111 = r111 + 1;
        goto L101
    L114:
        return;
    L56:
        r13.setFinalTop(0);
        goto L57
    L8:
        r13.setFinalLeft(0);
        goto L9
    }

    private static void solveBarrier(int r1, Barrier r2, BasicMeasure.Measurer r3, int r4, boolean r5) {
        if (r2.allSolved() == false) goto L8;
        if (r4 != 0) goto L6;
        horizontalSolvingPass(r1 + 1, r2, r3, r5);
        return;
    L6:
        verticalSolvingPass(r1 + 1, r2, r3);
        return;
    }

    public static String ls(int r3) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r0.append(BytedanceJustifyTextView.TWO_BLANK);
        r1 = r1 + 1;
        goto L3
    L5:
        r0.append("+-(" + r3 + ") ");
        return r0.toString();
    }

    private static void horizontalSolvingPass(int r16, ConstraintWidget r17, BasicMeasure.Measurer r18, boolean r19) {
        if (r17.isHorizontalSolvingPassDone() == false) goto L5;
        return;
    L5:
        boolean r4 = true;
        sHcount++;
        if ((r17 instanceof ConstraintWidgetContainer) == false) goto L8;
    L12:
        ConstraintAnchor r3 = r17.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r5 = r17.getAnchor(ConstraintAnchor.Type.RIGHT);
        int r6 = r3.getFinalValue();
        int r7 = r5.getFinalValue();
        if (r3.getDependents() == null) goto L79;
        if (r3.hasFinalValue() == false) goto L79;
        Iterator<ConstraintAnchor> r8 = r3.getDependents().iterator();
    L18:
        if (r8.hasNext() == false) goto L79;
        ConstraintAnchor r9 = r8.next();
        ConstraintWidget r12 = r9.mOwner;
        int r13 = r16 + 1;
        boolean r14 = canMeasure(r13, r12);
        if (r12.isMeasureRequested() == false) goto L24;
        if (r14 == false) goto L24;
        ConstraintWidgetContainer.measure(r13, r12, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L24:
        if (r9 != r12.mLeft) goto L30;
        if (r12.mRight.mTarget == null) goto L30;
        if (r12.mRight.mTarget.hasFinalValue() == false) goto L30;
    L35:
        boolean r11 = r4;
    L38:
        if (r12.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        if (r14 == true) goto L62;
        if (r12.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L63;
        if (r12.mMatchConstraintMaxWidth < 0) goto L63;
        if (r12.mMatchConstraintMinWidth < 0) goto L63;
        if (r12.getVisibility() == 8) goto L54;
        if (r12.mMatchConstraintDefaultWidth != 0) goto L63;
        if (r12.getDimensionRatio() != 0.0f) goto L63;
    L54:
        if (r12.isInHorizontalChain() == true) goto L63;
        if (r12.isInVirtualLayout() == true) goto L63;
        if (r11 == false) goto L63;
        if (r12.isInHorizontalChain() == true) goto L63;
        solveHorizontalMatchConstraint(r13, r17, r18, r12, r19);
    L63:
        r4 = true;
    L62:
        if (r12.isMeasureRequested() == true) goto L63;
        if (r9 != r12.mLeft) goto L70;
        if (r12.mRight.mTarget != null) goto L70;
        int r10 = r12.mLeft.getMargin() + r6;
        r12.setFinalHorizontal(r10, r12.getWidth() + r10);
        horizontalSolvingPass(r13, r12, r18, r19);
    L70:
        if (r9 == r12.mRight) goto L72;
    L74:
        if (r11 == false) goto L63;
        if (r12.isInHorizontalChain() == true) goto L63;
        solveHorizontalCenterConstraints(r13, r18, r12, r19);
        goto L63
    L72:
        if (r12.mLeft.mTarget != null) goto L74;
        int r15 = r6 - r12.mRight.getMargin();
        r12.setFinalHorizontal(r15 - r12.getWidth(), r15);
        horizontalSolvingPass(r13, r12, r18, r19);
    L30:
        if (r9 == r12.mRight) goto L32;
    L36:
        r11 = false;
        goto L38
    L32:
        if (r12.mLeft.mTarget == null) goto L36;
        if (r12.mLeft.mTarget.hasFinalValue() == false) goto L36;
    L79:
        if ((r17 instanceof Guideline) == false) goto L82;
        return;
    L82:
        if (r5.getDependents() != null) goto L84;
    L147:
        r17.markHorizontalSolvingPassDone();
        return;
    L84:
        if (r5.hasFinalValue() == false) goto L147;
        Iterator<ConstraintAnchor> r20 = r5.getDependents().iterator();
    L87:
        if (r20.hasNext() == false) goto L147;
        ConstraintAnchor r21 = r20.next();
        ConstraintWidget r22 = r21.mOwner;
        int r23 = r16 + 1;
        boolean r110 = canMeasure(r23, r22);
        if (r22.isMeasureRequested() == false) goto L93;
        if (r110 == false) goto L93;
        ConstraintWidgetContainer.measure(r23, r22, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L93:
        if (r21 != r22.mLeft) goto L99;
        if (r22.mRight.mTarget == null) goto L99;
        if (r22.mRight.mTarget.hasFinalValue() == false) goto L99;
    L104:
        boolean r111 = true;
    L107:
        if (r22.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L131;
        if (r110 == true) goto L131;
        if (r22.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L87;
        if (r22.mMatchConstraintMaxWidth < 0) goto L87;
        if (r22.mMatchConstraintMinWidth < 0) goto L87;
        if (r22.getVisibility() == 8) goto L123;
        if (r22.mMatchConstraintDefaultWidth != 0) goto L87;
        if (r22.getDimensionRatio() != 0.0f) goto L87;
    L123:
        if (r22.isInHorizontalChain() == true) goto L87;
        if (r22.isInVirtualLayout() == true) goto L87;
        if (r111 == false) goto L87;
        if (r22.isInHorizontalChain() == true) goto L87;
        solveHorizontalMatchConstraint(r23, r17, r18, r22, r19);
    L131:
        if (r22.isMeasureRequested() == true) goto L87;
        if (r21 != r22.mLeft) goto L139;
        if (r22.mRight.mTarget != null) goto L139;
        int r24 = r22.mLeft.getMargin() + r7;
        r22.setFinalHorizontal(r24, r22.getWidth() + r24);
        horizontalSolvingPass(r23, r22, r18, r19);
    L139:
        if (r21 != r22.mRight) goto L143;
        if (r22.mLeft.mTarget != null) goto L143;
        int r25 = r7 - r22.mRight.getMargin();
        r22.setFinalHorizontal(r25 - r22.getWidth(), r25);
        horizontalSolvingPass(r23, r22, r18, r19);
    L143:
        if (r111 == false) goto L87;
        if (r22.isInHorizontalChain() == true) goto L87;
        solveHorizontalCenterConstraints(r23, r18, r22, r19);
    L99:
        if (r21 == r22.mRight) goto L101;
    L105:
        r111 = false;
        goto L107
    L101:
        if (r22.mLeft.mTarget == null) goto L105;
        if (r22.mLeft.mTarget.hasFinalValue() == false) goto L105;
    L8:
        if (r17.isMeasureRequested() == false) goto L12;
        int r26 = r16 + 1;
        if (canMeasure(r26, r17) == false) goto L12;
        ConstraintWidgetContainer.measure(r26, r17, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L12
    }

    private static void verticalSolvingPass(int r16, ConstraintWidget r17, BasicMeasure.Measurer r18) {
        if (r17.isVerticalSolvingPassDone() == false) goto L5;
        return;
    L5:
        sVcount++;
        if ((r17 instanceof ConstraintWidgetContainer) == false) goto L8;
    L12:
        ConstraintAnchor r2 = r17.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r4 = r17.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int r5 = r2.getFinalValue();
        int r6 = r4.getFinalValue();
        if (r2.getDependents() == null) goto L79;
        if (r2.hasFinalValue() == false) goto L79;
        Iterator<ConstraintAnchor> r3 = r2.getDependents().iterator();
    L18:
        if (r3.hasNext() == false) goto L79;
        ConstraintAnchor r7 = r3.next();
        ConstraintWidget r11 = r7.mOwner;
        int r12 = r16 + 1;
        boolean r13 = canMeasure(r12, r11);
        if (r11.isMeasureRequested() == false) goto L24;
        if (r13 == false) goto L24;
        ConstraintWidgetContainer.measure(r12, r11, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L24:
        if (r7 != r11.mTop) goto L30;
        if (r11.mBottom.mTarget == null) goto L30;
        if (r11.mBottom.mTarget.hasFinalValue() == false) goto L30;
    L35:
        boolean r14 = true;
    L38:
        if (r11.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        if (r13 == true) goto L62;
        if (r11.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L18;
        if (r11.mMatchConstraintMaxHeight < 0) goto L18;
        if (r11.mMatchConstraintMinHeight < 0) goto L18;
        if (r11.getVisibility() == 8) goto L54;
        if (r11.mMatchConstraintDefaultHeight != 0) goto L18;
        if (r11.getDimensionRatio() != 0.0f) goto L18;
    L54:
        if (r11.isInVerticalChain() == true) goto L18;
        if (r11.isInVirtualLayout() == true) goto L18;
        if (r14 == false) goto L18;
        if (r11.isInVerticalChain() == true) goto L18;
        solveVerticalMatchConstraint(r12, r17, r18, r11);
    L62:
        if (r11.isMeasureRequested() == true) goto L18;
        if (r7 != r11.mTop) goto L70;
        if (r11.mBottom.mTarget != null) goto L70;
        int r8 = r11.mTop.getMargin() + r5;
        r11.setFinalVertical(r8, r11.getHeight() + r8);
        verticalSolvingPass(r12, r11, r18);
    L70:
        if (r7 != r11.mBottom) goto L74;
        if (r11.mTop.mTarget != null) goto L74;
        int r9 = r5 - r11.mBottom.getMargin();
        r11.setFinalVertical(r9 - r11.getHeight(), r9);
        verticalSolvingPass(r12, r11, r18);
    L74:
        if (r14 == false) goto L18;
        if (r11.isInVerticalChain() == true) goto L18;
        solveVerticalCenterConstraints(r12, r18, r11);
    L30:
        if (r7 == r11.mBottom) goto L32;
    L36:
        r14 = false;
        goto L38
    L32:
        if (r11.mTop.mTarget == null) goto L36;
        if (r11.mTop.mTarget.hasFinalValue() == false) goto L36;
    L79:
        if ((r17 instanceof Guideline) == false) goto L82;
        return;
    L82:
        if (r4.getDependents() != null) goto L84;
    L147:
        ConstraintAnchor r10 = r17.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (r10.getDependents() != null) goto L150;
    L167:
        r17.markVerticalSolvingPassDone();
        return;
    L150:
        if (r10.hasFinalValue() == false) goto L167;
        int r15 = r10.getFinalValue();
        Iterator<ConstraintAnchor> r19 = r10.getDependents().iterator();
    L153:
        if (r19.hasNext() == false) goto L167;
        ConstraintAnchor r20 = r19.next();
        ConstraintWidget r21 = r20.mOwner;
        int r22 = r16 + 1;
        boolean r23 = canMeasure(r22, r21);
        if (r21.isMeasureRequested() == false) goto L159;
        if (r23 == false) goto L159;
        ConstraintWidgetContainer.measure(r22, r21, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L159:
        if (r21.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L162;
        if (r23 == false) goto L153;
    L162:
        if (r21.isMeasureRequested() == true) goto L153;
        if (r20 != r21.mBaseline) goto L153;
        r21.setFinalBaseline(r20.getMargin() + r15);
        verticalSolvingPass(r22, r21, r18);
        goto L153
    L84:
        if (r4.hasFinalValue() == false) goto L147;
        Iterator<ConstraintAnchor> r24 = r4.getDependents().iterator();
    L87:
        if (r24.hasNext() == false) goto L147;
        ConstraintAnchor r25 = r24.next();
        ConstraintWidget r26 = r25.mOwner;
        int r27 = r16 + 1;
        boolean r110 = canMeasure(r27, r26);
        if (r26.isMeasureRequested() == false) goto L93;
        if (r110 == false) goto L93;
        ConstraintWidgetContainer.measure(r27, r26, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
    L93:
        if (r25 != r26.mTop) goto L99;
        if (r26.mBottom.mTarget == null) goto L99;
        if (r26.mBottom.mTarget.hasFinalValue() == false) goto L99;
    L104:
        boolean r111 = true;
    L107:
        if (r26.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L131;
        if (r110 == true) goto L131;
        if (r26.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L87;
        if (r26.mMatchConstraintMaxHeight < 0) goto L87;
        if (r26.mMatchConstraintMinHeight < 0) goto L87;
        if (r26.getVisibility() == 8) goto L123;
        if (r26.mMatchConstraintDefaultHeight != 0) goto L87;
        if (r26.getDimensionRatio() != 0.0f) goto L87;
    L123:
        if (r26.isInVerticalChain() == true) goto L87;
        if (r26.isInVirtualLayout() == true) goto L87;
        if (r111 == false) goto L87;
        if (r26.isInVerticalChain() == true) goto L87;
        solveVerticalMatchConstraint(r27, r17, r18, r26);
    L131:
        if (r26.isMeasureRequested() == true) goto L87;
        if (r25 != r26.mTop) goto L139;
        if (r26.mBottom.mTarget != null) goto L139;
        int r28 = r26.mTop.getMargin() + r6;
        r26.setFinalVertical(r28, r26.getHeight() + r28);
        verticalSolvingPass(r27, r26, r18);
    L139:
        if (r25 != r26.mBottom) goto L143;
        if (r26.mTop.mTarget != null) goto L143;
        int r29 = r6 - r26.mBottom.getMargin();
        r26.setFinalVertical(r29 - r26.getHeight(), r29);
        verticalSolvingPass(r27, r26, r18);
    L143:
        if (r111 == false) goto L87;
        if (r26.isInVerticalChain() == true) goto L87;
        solveVerticalCenterConstraints(r27, r18, r26);
    L99:
        if (r25 == r26.mBottom) goto L101;
    L105:
        r111 = false;
        goto L107
    L101:
        if (r26.mTop.mTarget == null) goto L105;
        if (r26.mTop.mTarget.hasFinalValue() == false) goto L105;
    L8:
        if (r17.isMeasureRequested() == false) goto L12;
        int r30 = r16 + 1;
        if (canMeasure(r30, r17) == false) goto L12;
        ConstraintWidgetContainer.measure(r30, r17, r18, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L12
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

    private static void solveHorizontalMatchConstraint(int r7, ConstraintWidget r8, BasicMeasure.Measurer r9, ConstraintWidget r10, boolean r11) {
        float r0 = r10.getHorizontalBiasPercent();
        int r1 = r10.mLeft.mTarget.getFinalValue() + r10.mLeft.getMargin();
        int r2 = r10.mRight.mTarget.getFinalValue() - r10.mRight.getMargin();
        if (r2 < r1) goto L21;
        int r3 = r10.getWidth();
        if (r10.getVisibility() != 8) goto L7;
    L19:
        int r4 = r1 + ((int) ((r0 * ((r2 - r1) - r3)) + 0.5f));
        r10.setFinalHorizontal(r4, r3 + r4);
        horizontalSolvingPass(r7 + 1, r10, r9, r11);
        return;
    L7:
        if (r10.mMatchConstraintDefaultWidth != 2) goto L14;
        if ((r8 instanceof ConstraintWidgetContainer) == false) goto L11;
        int r12 = r8.getWidth();
    L12:
        r3 = (int) ((r10.getHorizontalBiasPercent() * 0.5f) * r12);
    L16:
        r3 = Math.max(r10.mMatchConstraintMinWidth, r3);
        if (r10.mMatchConstraintMaxWidth <= 0) goto L19;
        r3 = Math.min(r10.mMatchConstraintMaxWidth, r3);
        goto L19
    L11:
        r12 = r8.getParent().getWidth();
        goto L12
    L14:
        if (r10.mMatchConstraintDefaultWidth != 0) goto L16;
        r3 = r2 - r1;
        goto L16
    }

    private static void solveVerticalMatchConstraint(int r7, ConstraintWidget r8, BasicMeasure.Measurer r9, ConstraintWidget r10) {
        float r0 = r10.getVerticalBiasPercent();
        int r1 = r10.mTop.mTarget.getFinalValue() + r10.mTop.getMargin();
        int r2 = r10.mBottom.mTarget.getFinalValue() - r10.mBottom.getMargin();
        if (r2 < r1) goto L21;
        int r3 = r10.getHeight();
        if (r10.getVisibility() != 8) goto L7;
    L19:
        int r4 = r1 + ((int) ((r0 * ((r2 - r1) - r3)) + 0.5f));
        r10.setFinalVertical(r4, r3 + r4);
        verticalSolvingPass(r7 + 1, r10, r9);
        return;
    L7:
        if (r10.mMatchConstraintDefaultHeight != 2) goto L14;
        if ((r8 instanceof ConstraintWidgetContainer) == false) goto L11;
        int r11 = r8.getHeight();
    L12:
        r3 = (int) ((r0 * 0.5f) * r11);
    L16:
        r3 = Math.max(r10.mMatchConstraintMinHeight, r3);
        if (r10.mMatchConstraintMaxHeight <= 0) goto L19;
        r3 = Math.min(r10.mMatchConstraintMaxHeight, r3);
        goto L19
    L11:
        r11 = r8.getParent().getHeight();
        goto L12
    L14:
        if (r10.mMatchConstraintDefaultHeight != 0) goto L16;
        r3 = r2 - r1;
        goto L16
    }

    private static boolean canMeasure(int r5, ConstraintWidget r6) {
        ConstraintWidget.DimensionBehaviour r7 = r6.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r0 = r6.getVerticalDimensionBehaviour();
        if (r6.getParent() == null) goto L5;
        ConstraintWidgetContainer r1 = (ConstraintWidgetContainer) r6.getParent();
    L6:
        if (r1 == null) goto L8;
        r1.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r3 = ConstraintWidget.DimensionBehaviour.FIXED;
    L8:
        if (r1 == null) goto L11;
        r1.getVerticalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r2 = ConstraintWidget.DimensionBehaviour.FIXED;
    L11:
        if (r7 != ConstraintWidget.DimensionBehaviour.FIXED) goto L13;
    L32:
        boolean r8 = true;
    L34:
        if (r0 != ConstraintWidget.DimensionBehaviour.FIXED) goto L36;
    L55:
        boolean r4 = true;
    L57:
        if (r6.mDimensionRatio <= 0.0f) goto L61;
        if (r8 == true) goto L60;
        if (r4 == false) goto L61;
    L60:
        return true;
    L61:
        if (r8 == false) goto L65;
        if (r4 == true) goto L64;
        return false;
    L64:
        return true;
    L65:
        return false;
    L36:
        if (r6.isResolvedVertically() == true) goto L55;
        if (r0 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L55;
        if (r0 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L48;
        if (r6.mMatchConstraintDefaultHeight != 0) goto L48;
        if (r6.mDimensionRatio != 0.0f) goto L48;
        if (r6.hasDanglingDimension(1) == true) goto L55;
    L48:
        if (r0 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L50;
    L54:
        r4 = false;
        goto L57
    L50:
        if (r6.mMatchConstraintDefaultHeight != 1) goto L54;
        if (r6.hasResolvedTargets(1, r6.getHeight()) == false) goto L54;
    L13:
        if (r6.isResolvedHorizontally() == true) goto L32;
        if (r7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L32;
        if (r7 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
        if (r6.mMatchConstraintDefaultWidth != 0) goto L25;
        if (r6.mDimensionRatio != 0.0f) goto L25;
        if (r6.hasDanglingDimension(0) == true) goto L32;
    L25:
        if (r7 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L27;
    L31:
        r8 = false;
        goto L34
    L27:
        if (r6.mMatchConstraintDefaultWidth != 1) goto L31;
        if (r6.hasResolvedTargets(0, r6.getWidth()) == false) goto L31;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v46 */
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
        if (r7.mTarget != null) goto L15;
    L122:
        return false;
    L15:
        if (r9.mTarget == null) goto L122;
        if (r7.mTarget.hasFinalValue() == false) goto L122;
        if (r9.mTarget.hasFinalValue() == false) goto L122;
        if (r4 == null) goto L122;
        if (r5 == null) goto L122;
        int r10 = r7.mTarget.getFinalValue() + r4.mListAnchors[r23].getMargin();
        int r11 = r9.mTarget.getFinalValue() - r5.mListAnchors[r8].getMargin();
        int r12 = r11 - r10;
        if (r12 > 0) goto L28;
        return false;
    L28:
        BasicMeasure.Measure r13 = new BasicMeasure.Measure();
        boolean r14 = false;
        int r15 = 0;
        int r16 = 0;
        int r17 = 0;
        ConstraintWidget r18 = r2;
    L29:
        ConstraintWidget r19 = null;
        if (r14 == true) goto L61;
        if (canMeasure(1, r18) == false) goto L33;
        ConstraintWidget r110 = r2;
        if (r18.mListDimensionBehaviors[r22] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L37;
        if (r18.isMeasureRequested() == false) goto L42;
        ConstraintWidgetContainer.measure(1, r18, r20.getMeasurer(), r13, BasicMeasure.Measure.SELF_DIMENSIONS);
    L42:
        int r111 = r17 + r18.mListAnchors[r23].getMargin();
        if (r22 != 0) goto L45;
        int r0 = r18.getWidth();
    L46:
        r17 = (r111 + r0) + r18.mListAnchors[r8].getMargin();
        r16 = r16 + 1;
        if (r18.getVisibility() == 8) goto L49;
        r15 = r15 + 1;
    L49:
        ConstraintAnchor r28 = r18.mListAnchors[r8].mTarget;
        if (r28 == null) goto L57;
        ConstraintWidget r29 = r28.mOwner;
        if (r29.mListAnchors[r23].mTarget == null) goto L57;
        if (r29.mListAnchors[r23].mTarget.mOwner != r18) goto L57;
        r19 = r29;
    L57:
        if (r19 == null) goto L59;
        r18 = r19;
        r14 = r14;
    L60:
        r2 = r110;
        goto L29
    L59:
        r14 = true;
        goto L60
    L45:
        r0 = r18.getHeight();
        goto L46
    L37:
        return false;
    L33:
        return false;
    L61:
        ConstraintWidget r112 = r2;
        if (r15 != 0) goto L66;
        return false;
    L66:
        if (r15 == r16) goto L68;
        return false;
    L68:
        if (r12 >= r17) goto L70;
        return false;
    L70:
        int r30 = r12 - r17;
        if (r25 == false) goto L74;
        r30 = r30 / (r15 + 1);
    L73:
        int r31 = 1;
    L77:
        if (r15 != r31) goto L87;
        if (r22 != 0) goto L80;
        float r32 = r6.getHorizontalBiasPercent();
    L81:
        int r33 = (int) ((r10 + 0.5f) + (r30 * r32));
        if (r22 != 0) goto L84;
        r4.setFinalHorizontal(r33, r4.getWidth() + r33);
    L85:
        horizontalSolvingPass(1, r4, r20.getMeasurer(), r1);
        return true;
    L84:
        r4.setFinalVertical(r33, r4.getHeight() + r33);
        goto L85
    L80:
        r32 = r6.getVerticalBiasPercent();
        goto L81
    L87:
        if (r25 == false) goto L112;
        int r34 = r10 + r30;
        ConstraintWidget r35 = r112;
        boolean r36 = false;
        ?? r37 = r31;
    L89:
        if (r36 == true) goto L132;
        if (r35.getVisibility() != 8) goto L96;
        if (r22 != 0) goto L94;
        r35.setFinalHorizontal(r34, r34);
        horizontalSolvingPass(r37, r35, r20.getMeasurer(), r1);
    L101:
        r35.addToSolver(r21, false);
        ConstraintAnchor r38 = r35.mListAnchors[r8].mTarget;
        if (r38 == null) goto L107;
        ConstraintWidget r39 = r38.mOwner;
        if (r39.mListAnchors[r23].mTarget == null) goto L107;
        if (r39.mListAnchors[r23].mTarget.mOwner != r35) goto L107;
    L108:
        if (r39 == null) goto L110;
        r35 = r39;
    L111:
        r37 = 1;
        goto L89
    L110:
        r36 = true;
    L107:
        r39 = null;
        goto L108
    L94:
        r35.setFinalVertical(r34, r34);
        verticalSolvingPass(r37, r35, r20.getMeasurer());
        goto L101
    L96:
        int r40 = r34 + r35.mListAnchors[r23].getMargin();
        if (r22 != 0) goto L99;
        r35.setFinalHorizontal(r40, r35.getWidth() + r40);
        horizontalSolvingPass(1, r35, r20.getMeasurer(), r1);
        int r41 = r35.getWidth();
    L100:
        r34 = ((r40 + r41) + r35.mListAnchors[r8].getMargin()) + r30;
        goto L101
    L99:
        r35.setFinalVertical(r40, r35.getHeight() + r40);
        verticalSolvingPass(1, r35, r20.getMeasurer());
        r41 = r35.getHeight();
        goto L100
    L132:
        return r37;
    L112:
        if (r26 == false) goto L120;
        if (r15 != 2) goto L118;
        if (r22 != 0) goto L116;
        r4.setFinalHorizontal(r10, r4.getWidth() + r10);
        r5.setFinalHorizontal(r11 - r5.getWidth(), r11);
        horizontalSolvingPass(1, r4, r20.getMeasurer(), r1);
        horizontalSolvingPass(1, r5, r20.getMeasurer(), r1);
        return true;
    L116:
        r4.setFinalVertical(r10, r4.getHeight() + r10);
        r5.setFinalVertical(r11 - r5.getHeight(), r11);
        verticalSolvingPass(1, r4, r20.getMeasurer());
        verticalSolvingPass(1, r5, r20.getMeasurer());
        return true;
    L118:
        return false;
    L120:
        return true;
    L74:
        if (r26 == false) goto L73;
        if (r15 <= 2) goto L73;
        r31 = 1;
        r30 = (r30 / r15) - 1;
        goto L77
    L10:
        if (r20.isResolvedVertically() == true) goto L12;
        return false;
    }
}
