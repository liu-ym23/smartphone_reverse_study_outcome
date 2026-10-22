package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.Barrier;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
class HelperReferences extends WidgetRun {
    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        return false;
    }

    HelperReferences(ConstraintWidget r1) {
        super(r1);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.mRunGroup = null;
        this.start.clear();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
    }

    private void addDependency(DependencyNode r2) {
        this.start.mDependencies.add(r2);
        r2.mTargets.add(this.start);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        if ((this.mWidget instanceof Barrier) == false) goto L69;
        this.start.delegateToWidgetRun = true;
        Barrier r0 = (Barrier) this.mWidget;
        int r2 = r0.getBarrierType();
        boolean r3 = r0.getAllowsGoneWidget();
        int r5 = 0;
        if (r2 == 0) goto L45;
        if (r2 != 1) goto L8;
        DependencyNode r1 = this.start;
        r1.mType = DependencyNode.Type.RIGHT;
    L36:
        if (r5 >= r0.mWidgetsCount) goto L44;
        ConstraintWidget r4 = r0.mWidgets[r5];
        if (r3 == false) goto L40;
    L42:
        DependencyNode r6 = r4.mHorizontalRun.end;
        r6.mDependencies.add(this.start);
        this.start.mTargets.add(r6);
    L43:
        r5 = r5 + 1;
        goto L36
    L40:
        if (r4.getVisibility() != 8) goto L42;
    L44:
        addDependency(this.mWidget.mHorizontalRun.start);
        addDependency(this.mWidget.mHorizontalRun.end);
        return;
    L8:
        if (r2 != 2) goto L10;
        DependencyNode r7 = this.start;
        r7.mType = DependencyNode.Type.TOP;
    L25:
        if (r5 >= r0.mWidgetsCount) goto L33;
        ConstraintWidget r8 = r0.mWidgets[r5];
        if (r3 == false) goto L29;
    L31:
        DependencyNode r9 = r8.mVerticalRun.start;
        r9.mDependencies.add(this.start);
        this.start.mTargets.add(r9);
    L32:
        r5 = r5 + 1;
        goto L25
    L29:
        if (r8.getVisibility() != 8) goto L31;
    L33:
        addDependency(this.mWidget.mVerticalRun.start);
        addDependency(this.mWidget.mVerticalRun.end);
        return;
    L10:
        if (r2 != 3) goto L73;
        DependencyNode r10 = this.start;
        r10.mType = DependencyNode.Type.BOTTOM;
    L14:
        if (r5 >= r0.mWidgetsCount) goto L22;
        ConstraintWidget r11 = r0.mWidgets[r5];
        if (r3 == false) goto L18;
    L20:
        DependencyNode r12 = r11.mVerticalRun.end;
        r12.mDependencies.add(this.start);
        this.start.mTargets.add(r12);
    L21:
        r5 = r5 + 1;
        goto L14
    L18:
        if (r11.getVisibility() != 8) goto L20;
    L22:
        addDependency(this.mWidget.mVerticalRun.start);
        addDependency(this.mWidget.mVerticalRun.end);
        return;
    L73:
        return;
    L45:
        DependencyNode r13 = this.start;
        r13.mType = DependencyNode.Type.LEFT;
    L47:
        if (r5 >= r0.mWidgetsCount) goto L55;
        ConstraintWidget r14 = r0.mWidgets[r5];
        if (r3 == false) goto L51;
    L53:
        DependencyNode r15 = r14.mHorizontalRun.start;
        r15.mDependencies.add(this.start);
        this.start.mTargets.add(r15);
    L54:
        r5 = r5 + 1;
        goto L47
    L51:
        if (r14.getVisibility() != 8) goto L53;
    L55:
        addDependency(this.mWidget.mHorizontalRun.start);
        addDependency(this.mWidget.mHorizontalRun.end);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r7) {
        Barrier r8 = (Barrier) this.mWidget;
        int r0 = r8.getBarrierType();
        Iterator<DependencyNode> r1 = this.start.mTargets.iterator();
        int r3 = 0;
        int r4 = -1;
    L4:
        if (r1.hasNext() == false) goto L11;
        int r5 = r1.next().value;
        if (r4 == (-1)) goto L8;
        if (r5 < r4) goto L8;
    L9:
        if (r3 >= r5) goto L4;
        r3 = r5;
    L8:
        r4 = r5;
        goto L9
    L11:
        if (r0 != 0) goto L13;
    L16:
        this.start.resolve(r4 + r8.getMargin());
        return;
    L13:
        if (r0 == 2) goto L16;
        this.start.resolve(r3 + r8.getMargin());
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if ((this.mWidget instanceof Barrier) == false) goto L12;
        int r0 = ((Barrier) this.mWidget).getBarrierType();
        if (r0 != 0) goto L7;
    L10:
        this.mWidget.setX(this.start.value);
        return;
    L7:
        if (r0 == 1) goto L10;
        this.mWidget.setY(this.start.value);
        return;
    }
}
