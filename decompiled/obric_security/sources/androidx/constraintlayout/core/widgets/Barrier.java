package androidx.constraintlayout.core.widgets;

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

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public Barrier() {
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
    }

    public Barrier(String r3) {
        this.mBarrierType = 0;
        this.mAllowsGoneWidget = true;
        this.mMargin = 0;
        this.resolved = false;
        setDebugName(r3);
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public void setBarrierType(int r1) {
        this.mBarrierType = r1;
    }

    public void setAllowsGoneWidget(boolean r1) {
        this.mAllowsGoneWidget = r1;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public boolean getAllowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget r1, HashMap<ConstraintWidget, ConstraintWidget> r2) {
        super.copy(r1, r2);
        Barrier r3 = (Barrier) r1;
        this.mBarrierType = r3.mBarrierType;
        this.mAllowsGoneWidget = r3.mAllowsGoneWidget;
        this.mMargin = r3.mMargin;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String r0 = "[Barrier] " + getDebugName() + " {";
        int r1 = 0;
    L4:
        if (r1 >= this.mWidgetsCount) goto L10;
        ConstraintWidget r2 = this.mWidgets[r1];
        if (r1 <= 0) goto L8;
        r0 = r0 + ", ";
    L8:
        r0 = r0 + r2.getDebugName();
        r1 = r1 + 1;
        goto L4
    L10:
        return r0 + "}";
    }

    protected void markWidgets() {
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

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r13, boolean r14) {
        this.mListAnchors[0] = this.mLeft;
        this.mListAnchors[2] = this.mTop;
        this.mListAnchors[1] = this.mRight;
        this.mListAnchors[3] = this.mBottom;
        int r15 = 0;
    L4:
        if (r15 >= this.mListAnchors.length) goto L6;
        this.mListAnchors[r15].mSolverVariable = r13.createObjectVariable(this.mListAnchors[r15]);
        r15 = r15 + 1;
        goto L4
    L6:
        int r16 = this.mBarrierType;
        if (r16 >= 0) goto L9;
        return;
    L9:
        if (r16 >= 4) goto L130;
        ConstraintAnchor r17 = this.mListAnchors[this.mBarrierType];
        if (this.resolved == true) goto L14;
        allSolved();
    L14:
        if (this.resolved == false) goto L24;
        this.resolved = false;
        int r18 = this.mBarrierType;
        if (r18 == 0) goto L22;
        if (r18 == 1) goto L22;
        if (r18 == 2) goto L21;
        if (r18 == 3) goto L21;
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
        int r5 = 0;
    L26:
        if (r5 >= this.mWidgetsCount) goto L53;
        ConstraintWidget r6 = this.mWidgets[r5];
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
        r5 = r5 + 1;
    L46:
        if (r6.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L52;
        if (r6.mTop.mTarget == null) goto L52;
        if (r6.mBottom.mTarget == null) goto L52;
    L41:
        boolean r9 = true;
    L55:
        if (this.mLeft.hasCenteredDependents() == false) goto L57;
    L60:
        boolean r10 = true;
    L62:
        if (this.mTop.hasCenteredDependents() == false) goto L64;
    L67:
        boolean r11 = true;
    L68:
        if (r9 == true) goto L79;
        int r12 = this.mBarrierType;
        if (r12 != 0) goto L72;
        if (r10 == false) goto L72;
    L78:
        boolean r19 = true;
    L80:
        if (r19 == true) goto L82;
        int r20 = 4;
    L83:
        int r21 = 0;
    L85:
        if (r21 >= this.mWidgetsCount) goto L105;
        ConstraintWidget r22 = this.mWidgets[r21];
        if (this.mAllowsGoneWidget == false) goto L89;
    L91:
        SolverVariable r23 = r13.createObjectVariable(r22.mListAnchors[this.mBarrierType]);
        r22.mListAnchors[this.mBarrierType].mSolverVariable = r23;
        if (r22.mListAnchors[this.mBarrierType].mTarget != null) goto L94;
    L96:
        int r24 = 0;
    L97:
        int r110 = this.mBarrierType;
        if (r110 == 0) goto L102;
        if (r110 == 2) goto L102;
        r13.addGreaterBarrier(r17.mSolverVariable, r23, this.mMargin + r24, r9);
    L103:
        r13.addEquality(r17.mSolverVariable, r23, this.mMargin + r24, r20);
    L104:
        r21 = r21 + 1;
    L102:
        r13.addLowerBarrier(r17.mSolverVariable, r23, this.mMargin - r24, r9);
        goto L103
    L94:
        if (r22.mListAnchors[this.mBarrierType].mTarget.mOwner != this) goto L96;
        r24 = r22.mListAnchors[this.mBarrierType].mMargin + 0;
        goto L97
    L89:
        if (r22.allowedInBarrier() == true) goto L91;
    L105:
        int r111 = this.mBarrierType;
        if (r111 != 0) goto L108;
        r13.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
        return;
    L108:
        if (r111 != 1) goto L110;
        r13.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        return;
    L110:
        if (r111 != 2) goto L112;
        r13.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        return;
    L112:
        if (r111 != 3) goto L134;
        r13.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        return;
    L134:
        return;
    L82:
        r20 = 5;
    L72:
        if (r12 != 2) goto L74;
        if (r11 == true) goto L78;
    L74:
        if (r12 != 1) goto L76;
        if (r10 == true) goto L78;
    L76:
        if (r12 != 3) goto L79;
        if (r11 == true) goto L78;
    L79:
        r19 = false;
        goto L80
    L64:
        if (this.mBottom.hasCenteredDependents() == true) goto L67;
        r11 = false;
        goto L68
    L57:
        if (this.mRight.hasCenteredDependents() == true) goto L60;
        r10 = false;
    L36:
        if (r6.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L42;
        if (r6.mLeft.mTarget == null) goto L42;
        if (r6.mRight.mTarget == null) goto L42;
    L30:
        if (r6.allowedInBarrier() == true) goto L32;
    L53:
        r9 = false;
        goto L55
    }

    public void setMargin(int r1) {
        this.mMargin = r1;
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

    public boolean allSolved() {
        int r1 = 0;
        boolean r3 = true;
        int r2 = 0;
    L4:
        if (r2 >= this.mWidgetsCount) goto L23;
        ConstraintWidget r4 = this.mWidgets[r2];
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
        if (r4.isResolvedVertically() == true) goto L22;
    L15:
        r3 = false;
    L14:
        if (r4.isResolvedHorizontally() == true) goto L16;
    L8:
        if (r4.allowedInBarrier() == true) goto L10;
    L23:
        if (r3 == true) goto L25;
    L63:
        return false;
    L25:
        if (this.mWidgetsCount <= 0) goto L63;
        int r5 = 0;
        boolean r6 = false;
    L28:
        if (r1 >= this.mWidgetsCount) goto L55;
        ConstraintWidget r9 = this.mWidgets[r1];
        if (this.mAllowsGoneWidget == false) goto L32;
    L34:
        if (r6 == true) goto L45;
        int r10 = this.mBarrierType;
        if (r10 != 0) goto L38;
        r5 = r9.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
    L44:
        r6 = true;
        goto L45
    L38:
        if (r10 != 1) goto L40;
        r5 = r9.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
        goto L44
    L40:
        if (r10 != 2) goto L42;
        r5 = r9.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
        goto L44
    L42:
        if (r10 != 3) goto L44;
        r5 = r9.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
    L45:
        int r11 = this.mBarrierType;
        if (r11 != 0) goto L48;
        r5 = Math.min(r5, r9.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
    L54:
        r1 = r1 + 1;
        goto L28
    L48:
        if (r11 != 1) goto L50;
        r5 = Math.max(r5, r9.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
        goto L54
    L50:
        if (r11 != 2) goto L52;
        r5 = Math.min(r5, r9.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
        goto L54
    L52:
        if (r11 != 3) goto L54;
        r5 = Math.max(r5, r9.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
        goto L54
    L32:
        if (r9.allowedInBarrier() == true) goto L34;
    L55:
        int r12 = r5 + this.mMargin;
        int r13 = this.mBarrierType;
        if (r13 == 0) goto L60;
        if (r13 == 1) goto L60;
        setFinalVertical(r12, r12);
    L61:
        this.resolved = true;
        return true;
    L60:
        setFinalHorizontal(r12, r12);
        goto L61
    }
}
