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
        r0[r16].mSolverVariable = r13.createObjectVariable(r0[r16]);
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
        if (this.resolved == false) goto L25;
        this.resolved = false;
        int r19 = this.mBarrierType;
        if (r19 == 0) goto L22;
        if (r19 == 1) goto L22;
        if (r19 == 2) goto L21;
        if (r19 == 3) goto L21;
        return;
    L21:
        r13.addEquality(this.mTop.mSolverVariable, this.mY);
        SolverVariable r110 = this.mBottom.mSolverVariable;
        int r12 = this.mY;
    L23:
        r13.addEquality(r110, r12);
        return;
    L22:
        r13.addEquality(this.mLeft.mSolverVariable, this.mX);
        r110 = this.mRight.mSolverVariable;
        r12 = this.mX;
        goto L23
    L25:
        int r1 = 0;
    L27:
        if (r1 >= this.mWidgetsCount) goto L54;
        ConstraintWidget r6 = this.mWidgets[r1];
        if (this.mAllowsGoneWidget == false) goto L31;
    L33:
        int r7 = this.mBarrierType;
        if (r7 == 0) goto L37;
        if (r7 == 1) goto L37;
    L43:
        int r8 = this.mBarrierType;
        if (r8 == 2) goto L47;
        if (r8 == 3) goto L47;
    L53:
        r1 = r1 + 1;
    L47:
        if (r6.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L53;
        if (r6.mTop.mTarget == null) goto L53;
        if (r6.mBottom.mTarget == null) goto L53;
    L42:
        boolean r2 = true;
    L56:
        if (this.mLeft.hasCenteredDependents() == false) goto L58;
    L61:
        boolean r9 = true;
    L63:
        if (this.mTop.hasCenteredDependents() == false) goto L65;
    L68:
        boolean r10 = true;
    L69:
        if (r2 == true) goto L80;
        int r11 = this.mBarrierType;
        if (r11 != 0) goto L73;
        if (r9 == false) goto L73;
    L79:
        boolean r20 = true;
    L81:
        int r21 = 5;
        if (r20 == true) goto L84;
        r21 = 4;
    L84:
        int r22 = 0;
    L86:
        if (r22 >= this.mWidgetsCount) goto L105;
        ConstraintWidget r23 = this.mWidgets[r22];
        if (this.mAllowsGoneWidget == false) goto L90;
    L92:
        SolverVariable r24 = r13.createObjectVariable(r23.mListAnchors[this.mBarrierType]);
        ConstraintAnchor[] r25 = r23.mListAnchors;
        int r111 = this.mBarrierType;
        r25[r111].mSolverVariable = r24;
        if (r25[r111].mTarget != null) goto L95;
    L97:
        int r26 = 0;
    L98:
        if (r111 == 0) goto L102;
        if (r111 == 2) goto L102;
        r13.addGreaterBarrier(r18.mSolverVariable, r24, this.mMargin + r26, r2);
    L103:
        r13.addEquality(r18.mSolverVariable, r24, this.mMargin + r26, r21);
    L104:
        r22 = r22 + 1;
    L102:
        r13.addLowerBarrier(r18.mSolverVariable, r24, this.mMargin - r26, r2);
        goto L103
    L95:
        if (r25[r111].mTarget.mOwner != this) goto L97;
        r26 = r25[r111].mMargin + 0;
        goto L98
    L90:
        if (r23.allowedInBarrier() == true) goto L92;
    L105:
        int r112 = this.mBarrierType;
        if (r112 != 0) goto L109;
        r13.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
        SolverVariable r113 = this.mLeft.mSolverVariable;
        ConstraintAnchor r114 = this.mParent.mLeft;
    L108:
        r13.addEquality(r113, r114.mSolverVariable, 0, 0);
        return;
    L109:
        if (r112 != 1) goto L111;
        r13.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
        r13.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
        r113 = this.mLeft.mSolverVariable;
        r114 = this.mParent.mRight;
        goto L108
    L111:
        if (r112 != 2) goto L113;
        r13.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
        r113 = this.mTop.mSolverVariable;
        r114 = this.mParent.mTop;
        goto L108
    L113:
        if (r112 != 3) goto L131;
        r13.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
        r13.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
        r113 = this.mTop.mSolverVariable;
        r114 = this.mParent.mBottom;
        goto L108
    L131:
        return;
    L73:
        if (r11 != 2) goto L75;
        if (r10 == true) goto L79;
    L75:
        if (r11 != 1) goto L77;
        if (r9 == true) goto L79;
    L77:
        if (r11 != 3) goto L80;
        if (r10 == true) goto L79;
    L80:
        r20 = false;
        goto L81
    L65:
        if (this.mBottom.hasCenteredDependents() == true) goto L68;
        r10 = false;
        goto L69
    L58:
        if (this.mRight.hasCenteredDependents() == true) goto L61;
        r9 = false;
    L37:
        if (r6.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L43;
        if (r6.mLeft.mTarget == null) goto L43;
        if (r6.mRight.mTarget == null) goto L43;
    L31:
        if (r6.allowedInBarrier() == true) goto L33;
    L54:
        r2 = false;
        goto L56
    }

    public boolean allSolved() {
        int r0 = 0;
        int r2 = 0;
        boolean r3 = true;
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
        if (r3 == false) goto L65;
        if (r4 <= 0) goto L65;
        int r6 = 0;
        boolean r9 = false;
    L27:
        if (r0 >= this.mWidgetsCount) goto L57;
        ConstraintWidget r10 = this.mWidgets[r0];
        if (this.mAllowsGoneWidget == false) goto L31;
    L33:
        if (r9 == true) goto L45;
        int r11 = this.mBarrierType;
        if (r11 != 0) goto L38;
        ConstraintAnchor.Type r12 = ConstraintAnchor.Type.LEFT;
    L37:
        r6 = r10.getAnchor(r12).getFinalValue();
    L44:
        r9 = true;
        goto L45
    L38:
        if (r11 != 1) goto L40;
        r12 = ConstraintAnchor.Type.RIGHT;
        goto L37
    L40:
        if (r11 != 2) goto L42;
        r12 = ConstraintAnchor.Type.TOP;
        goto L37
    L42:
        if (r11 != 3) goto L44;
        r12 = ConstraintAnchor.Type.BOTTOM;
    L45:
        int r13 = this.mBarrierType;
        if (r13 != 0) goto L49;
        ConstraintAnchor.Type r14 = ConstraintAnchor.Type.LEFT;
    L48:
        r6 = Math.min(r6, r10.getAnchor(r14).getFinalValue());
    L56:
        r0 = r0 + 1;
        goto L27
    L49:
        if (r13 != 1) goto L52;
        ConstraintAnchor.Type r15 = ConstraintAnchor.Type.RIGHT;
    L51:
        r6 = Math.max(r6, r10.getAnchor(r15).getFinalValue());
        goto L56
    L52:
        if (r13 != 2) goto L54;
        r14 = ConstraintAnchor.Type.TOP;
        goto L48
    L54:
        if (r13 != 3) goto L56;
        r15 = ConstraintAnchor.Type.BOTTOM;
        goto L51
    L31:
        if (r10.allowedInBarrier() == true) goto L33;
    L57:
        int r16 = r6 + this.mMargin;
        int r1 = this.mBarrierType;
        if (r1 == 0) goto L62;
        if (r1 == 1) goto L62;
        setFinalVertical(r16, r16);
    L63:
        this.resolved = true;
        return true;
    L62:
        setFinalHorizontal(r16, r16);
    L65:
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
        r0 = r0 + ", ";
    L8:
        r0 = r0 + r2.getDebugName();
        r1 = r1 + 1;
        goto L4
    L10:
        return r0 + "}";
    }
}
