package androidx.constraintlayout.core.widgets;

import a.a;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private boolean mAllowsGoneWidget;
    private int mBarrierType;
    private int mMargin;
    boolean resolved;

    public Barrier() {
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r13, boolean r14) {
        ConstraintAnchor[] r15 = this.mListAnchors;
        r15[0] = this.mLeft;
        r15[2] = this.mTop;
        r15[1] = this.mRight;
        r15[3] = this.mBottom;
        int r16 = 0;
    L3:
        ConstraintAnchor[] r0 = this.mListAnchors;
        if (r16 >= r0.length) goto L6;
        ConstraintAnchor r1 = r0[r16];
        r1.mSolverVariable = r13.createObjectVariable(r1);
        r16 = r16 + 1;
        goto L3
    L6:
        int r17 = this.mBarrierType;
        if (r17 >= 0) goto L9;
        return;
    L9:
        if (r17 >= 4) goto L129;
        ConstraintAnchor r18 = r0[r17];
        if (this.resolved == true) goto L14;
        allSolved();
    L14:
        if (this.resolved == false) goto L24;
        this.resolved = false;
        int r19 = this.mBarrierType;
        if (r19 == 0) goto L22;
        if (r19 == 1) goto L22;
        if (r19 == 2) goto L21;
        if (r19 == 3) goto L21;
        return;
    L21:
        r13.addEquality(this.mTop.mSolverVariable, this.mY);
        r13.addEquality(this.mBottom.mSolverVariable, this.mY);
        return;
    L22:
        r13.addEquality(this.mLeft.mSolverVariable, this.mX);
        r13.addEquality(this.mRight.mSolverVariable, this.mX);
        return;
    L24:
        int r2 = 0;
    L26:
        if (r2 >= this.mWidgetsCount) goto L53;
        ConstraintWidget r6 = this.mWidgets[r2];
        if (this.mAllowsGoneWidget == false) goto L30;
    L32:
        int r7 = this.mBarrierType;
        if (r7 == 0) goto L36;
        if (r7 == 1) goto L36;
    L42:
        int r8 = this.mBarrierType;
        if (r8 == 2) goto L46;
        if (r8 == 3) goto L46;
    L52:
        r2 = r2 + 1;
    L46:
        if (r6.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L52;
        if (r6.mTop.mTarget == null) goto L52;
        if (r6.mBottom.mTarget == null) goto L52;
    L41:
        boolean r3 = true;
    L55:
        if (this.mLeft.hasCenteredDependents() == false) goto L57;
    L60:
        boolean r9 = true;
    L62:
        if (this.mTop.hasCenteredDependents() == false) goto L64;
    L67:
        boolean r10 = true;
    L68:
        if (r3 == true) goto L79;
        int r11 = this.mBarrierType;
        if (r11 != 0) goto L72;
        if (r9 == false) goto L72;
    L78:
        boolean r12 = true;
    L80:
        if (r12 == true) goto L82;
        int r20 = 4;
    L83:
        int r21 = 0;
    L85:
        if (r21 >= this.mWidgetsCount) goto L104;
        ConstraintWidget r22 = this.mWidgets[r21];
        if (this.mAllowsGoneWidget == false) goto L89;
    L91:
        SolverVariable r23 = r13.createObjectVariable(r22.mListAnchors[this.mBarrierType]);
        ConstraintAnchor[] r24 = r22.mListAnchors;
        int r110 = this.mBarrierType;
        ConstraintAnchor r25 = r24[r110];
        r25.mSolverVariable = r23;
        ConstraintAnchor r111 = r25.mTarget;
        if (r111 != null) goto L94;
    L96:
        int r26 = 0;
    L97:
        if (r110 == 0) goto L101;
        if (r110 == 2) goto L101;
        r13.addGreaterBarrier(r18.mSolverVariable, r23, this.mMargin + r26, r3);
    L102:
        r13.addEquality(r18.mSolverVariable, r23, this.mMargin + r26, r20);
    L103:
        r21 = r21 + 1;
    L101:
        r13.addLowerBarrier(r18.mSolverVariable, r23, this.mMargin - r26, r3);
        goto L102
    L94:
        if (r111.mOwner != this) goto L96;
        r26 = r25.mMargin;
        goto L97
    L89:
        if (r22.allowedInBarrier() == true) goto L91;
    L104:
        int r112 = this.mBarrierType;
        if (r112 != 0) goto L107;
        r13.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
        return;
    L107:
        if (r112 != 1) goto L109;
        r13.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        return;
    L109:
        if (r112 != 2) goto L111;
        r13.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        return;
    L111:
        if (r112 != 3) goto L133;
        r13.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        return;
    L133:
        return;
    L82:
        r20 = 5;
    L72:
        if (r11 != 2) goto L74;
        if (r10 == true) goto L78;
    L74:
        if (r11 != 1) goto L76;
        if (r9 == true) goto L78;
    L76:
        if (r11 != 3) goto L79;
        if (r10 == true) goto L78;
    L79:
        r12 = false;
        goto L80
    L64:
        if (this.mBottom.hasCenteredDependents() == true) goto L67;
        r10 = false;
        goto L68
    L57:
        if (this.mRight.hasCenteredDependents() == true) goto L60;
        r9 = false;
    L36:
        if (r6.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L42;
        if (r6.mLeft.mTarget == null) goto L42;
        if (r6.mRight.mTarget == null) goto L42;
    L30:
        if (r6.allowedInBarrier() == true) goto L32;
    L53:
        r3 = false;
        goto L55
    }

    public boolean allSolved() {
        int r1 = 0;
        boolean r3 = true;
        int r2 = 0;
    L3:
        int r4 = this.mWidgetsCount;
        if (r2 >= r4) goto L23;
        ConstraintWidget r5 = this.mWidgets[r2];
        if (this.mAllowsGoneWidget == false) goto L8;
    L10:
        int r7 = this.mBarrierType;
        if (r7 == 0) goto L14;
        if (r7 == 1) goto L14;
    L16:
        int r8 = this.mBarrierType;
        if (r8 == 2) goto L20;
        if (r8 == 3) goto L20;
    L22:
        r2 = r2 + 1;
    L20:
        if (r5.isResolvedVertically() == true) goto L22;
    L15:
        r3 = false;
    L14:
        if (r5.isResolvedHorizontally() == true) goto L16;
    L8:
        if (r5.allowedInBarrier() == true) goto L10;
    L23:
        if (r3 == false) goto L62;
        if (r4 <= 0) goto L62;
        int r6 = 0;
        boolean r9 = false;
    L27:
        if (r1 >= this.mWidgetsCount) goto L54;
        ConstraintWidget r10 = this.mWidgets[r1];
        if (this.mAllowsGoneWidget == false) goto L31;
    L33:
        if (r9 == true) goto L44;
        int r11 = this.mBarrierType;
        if (r11 != 0) goto L37;
        r6 = r10.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
    L43:
        r9 = true;
        goto L44
    L37:
        if (r11 != 1) goto L39;
        r6 = r10.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
        goto L43
    L39:
        if (r11 != 2) goto L41;
        r6 = r10.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
        goto L43
    L41:
        if (r11 != 3) goto L43;
        r6 = r10.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
    L44:
        int r12 = this.mBarrierType;
        if (r12 != 0) goto L47;
        r6 = Math.min(r6, r10.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
    L53:
        r1 = r1 + 1;
        goto L27
    L47:
        if (r12 != 1) goto L49;
        r6 = Math.max(r6, r10.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
        goto L53
    L49:
        if (r12 != 2) goto L51;
        r6 = Math.min(r6, r10.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
        goto L53
    L51:
        if (r12 != 3) goto L53;
        r6 = Math.max(r6, r10.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
        goto L53
    L31:
        if (r10.allowedInBarrier() == true) goto L33;
    L54:
        int r13 = r6 + this.mMargin;
        int r14 = this.mBarrierType;
        if (r14 == 0) goto L59;
        if (r14 == 1) goto L59;
        setFinalVertical(r13, r13);
    L60:
        this.resolved = true;
        return true;
    L59:
        setFinalHorizontal(r13, r13);
    L62:
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget r1, HashMap<ConstraintWidget, ConstraintWidget> r2) {
        super.copy(r1, r2);
        Barrier r3 = (Barrier) r1;
        this.mBarrierType = r3.mBarrierType;
        this.mAllowsGoneWidget = r3.mAllowsGoneWidget;
        this.mMargin = r3.mMargin;
    }

    public boolean getAllowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int r2 = this.mBarrierType;
        if (r2 != 0) goto L5;
        return 0;
    L5:
        if (r2 != 1) goto L7;
        return 0;
    L7:
        if (r2 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r2 == 3) goto L12;
        return -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public void markWidgets() {
        int r1 = 0;
    L4:
        if (r1 >= this.mWidgetsCount) goto L21;
        ConstraintWidget r2 = this.mWidgets[r1];
        if (this.mAllowsGoneWidget == false) goto L8;
    L10:
        int r3 = this.mBarrierType;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L17;
    L18:
        r2.setInBarrier(1, true);
    L20:
        r1 = r1 + 1;
        goto L4
    L17:
        if (r3 != 3) goto L20;
    L19:
        r2.setInBarrier(0, true);
        goto L20
    L8:
        if (r2.allowedInBarrier() == true) goto L10;
    }

    public void setAllowsGoneWidget(boolean r1) {
        this.mAllowsGoneWidget = r1;
    }

    public void setBarrierType(int r1) {
        this.mBarrierType = r1;
    }

    public void setMargin(int r1) {
        this.mMargin = r1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String r0 = "[Barrier] " + getDebugName() + " {";
        int r1 = 0;
    L4:
        if (r1 >= this.mWidgetsCount) goto L10;
        ConstraintWidget r2 = this.mWidgets[r1];
        if (r1 <= 0) goto L8;
        r0 = a.j(r0, ", ");
    L8:
        StringBuilder r3 = a.q(r0);
        r3.append(r2.getDebugName());
        r0 = r3.toString();
        r1 = r1 + 1;
        goto L4
    L10:
        return a.j(r0, "}");
    }

    public Barrier(String r3) {
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
        setDebugName(r3);
    }
}
