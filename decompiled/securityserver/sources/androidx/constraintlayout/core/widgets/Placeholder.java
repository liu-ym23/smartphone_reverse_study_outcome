package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;

/* JADX INFO: loaded from: classes.dex */
public class Placeholder extends VirtualLayout {
    public Placeholder() {
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r1, boolean r2) {
        super.addToSolver(r1, r2);
        if (this.mWidgetsCount <= 0) goto L6;
        ConstraintWidget r3 = this.mWidgets[0];
        r3.resetAllConstraints();
        ConstraintAnchor.Type r4 = ConstraintAnchor.Type.LEFT;
        r3.connect(r4, this, r4);
        ConstraintAnchor.Type r5 = ConstraintAnchor.Type.RIGHT;
        r3.connect(r5, this, r5);
        ConstraintAnchor.Type r6 = ConstraintAnchor.Type.TOP;
        r3.connect(r6, this, r6);
        ConstraintAnchor.Type r7 = ConstraintAnchor.Type.BOTTOM;
        r3.connect(r7, this, r7);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int r6, int r7, int r8, int r9) {
        int r0 = getPaddingLeft() + getPaddingRight();
        int r2 = getPaddingTop() + getPaddingBottom();
        boolean r3 = false;
        if (this.mWidgetsCount <= 0) goto L5;
        r0 = r0 + this.mWidgets[0].getWidth();
        r2 = r2 + this.mWidgets[0].getHeight();
    L5:
        int r1 = Math.max(getMinWidth(), r0);
        int r4 = Math.max(getMinHeight(), r2);
        if (r6 == 1073741824) goto L13;
        if (r6 != Integer.MIN_VALUE) goto L10;
        r7 = Math.min(r1, r7);
        goto L13
    L10:
        if (r6 != 0) goto L12;
        r7 = r1;
        goto L13
    L12:
        r7 = 0;
    L13:
        if (r8 == 1073741824) goto L20;
        if (r8 != Integer.MIN_VALUE) goto L17;
        r9 = Math.min(r4, r9);
        goto L20
    L17:
        if (r8 != 0) goto L19;
        r9 = r4;
        goto L20
    L19:
        r9 = 0;
    L20:
        setMeasure(r7, r9);
        setWidth(r7);
        setHeight(r9);
        if (this.mWidgetsCount <= 0) goto L23;
        r3 = true;
    L23:
        needsCallbackFromSolver(r3);
    }
}
