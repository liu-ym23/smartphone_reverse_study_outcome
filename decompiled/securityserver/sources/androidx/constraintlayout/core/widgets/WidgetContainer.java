package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> mChildren;

    public WidgetContainer() {
        this.mChildren = new ArrayList();
    }

    public void add(ConstraintWidget r2) {
        this.mChildren.add(r2);
        if (r2.getParent() == null) goto L5;
        ((WidgetContainer) r2.getParent()).remove(r2);
    L5:
        r2.setParent(this);
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidget r0 = getParent();
        if ((this instanceof ConstraintWidgetContainer) == false) goto L5;
        ConstraintWidgetContainer r3 = (ConstraintWidgetContainer) this;
    L6:
        if (r0 == null) goto L11;
        ConstraintWidget r1 = r0.getParent();
        if ((r0 instanceof ConstraintWidgetContainer) == false) goto L10;
        r3 = (ConstraintWidgetContainer) r0;
    L10:
        r0 = r1;
        goto L6
    L11:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    public void layout() {
        ArrayList<ConstraintWidget> r0 = this.mChildren;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = r0.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L11;
        ConstraintWidget r3 = this.mChildren.get(r2);
        if ((r3 instanceof WidgetContainer) == false) goto L10;
        ((WidgetContainer) r3).layout();
    L10:
        r2 = r2 + 1;
        goto L6
    }

    public void remove(ConstraintWidget r1) {
        this.mChildren.remove(r1);
        r1.reset();
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void resetSolverVariables(Cache r4) {
        super.resetSolverVariables(r4);
        int r0 = this.mChildren.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildren.get(r1).resetSolverVariables(r4);
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void setOffset(int r4, int r5) {
        super.setOffset(r4, r5);
        int r6 = this.mChildren.size();
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L5;
        this.mChildren.get(r7).setOffset(getRootX(), getRootY());
        r7 = r7 + 1;
        goto L3
    }

    public WidgetContainer(int r1, int r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mChildren = new ArrayList();
    }

    public WidgetContainer(int r1, int r2) {
        super(r1, r2);
        this.mChildren = new ArrayList();
    }

    public void add(ConstraintWidget... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        add(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }
}
