package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.Guideline;

/* JADX INFO: loaded from: classes4.dex */
class GuidelineReference extends WidgetRun {
    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        return false;
    }

    GuidelineReference(ConstraintWidget r2) {
        super(r2);
        r2.mHorizontalRun.clear();
        r2.mVerticalRun.clear();
        this.orientation = ((Guideline) r2).getOrientation();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.start.clear();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    private void addDependency(DependencyNode r2) {
        this.start.mDependencies.add(r2);
        r2.mTargets.add(this.start);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r2) {
        if (this.start.readyToSolve == true) goto L6;
        return;
    L6:
        if (this.start.resolved == false) goto L8;
        return;
    L8:
        this.start.resolve((int) ((this.start.mTargets.get(0).value * ((Guideline) this.mWidget).getRelativePercent()) + 0.5f));
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Guideline r0 = (Guideline) this.mWidget;
        int r1 = r0.getRelativeBegin();
        int r2 = r0.getRelativeEnd();
        r0.getRelativePercent();
        if (r0.getOrientation() != 1) goto L10;
        if (r1 == (-1)) goto L6;
        this.start.mTargets.add(this.mWidget.mParent.mHorizontalRun.start);
        this.mWidget.mParent.mHorizontalRun.start.mDependencies.add(this.start);
        this.start.mMargin = r1;
    L9:
        addDependency(this.mWidget.mHorizontalRun.start);
        addDependency(this.mWidget.mHorizontalRun.end);
        return;
    L6:
        if (r2 == (-1)) goto L8;
        this.start.mTargets.add(this.mWidget.mParent.mHorizontalRun.end);
        this.mWidget.mParent.mHorizontalRun.end.mDependencies.add(this.start);
        int r3 = -r2;
        this.start.mMargin = r3;
        goto L9
    L8:
        this.start.delegateToWidgetRun = true;
        this.start.mTargets.add(this.mWidget.mParent.mHorizontalRun.end);
        this.mWidget.mParent.mHorizontalRun.end.mDependencies.add(this.start);
        goto L9
    L10:
        if (r1 == (-1)) goto L12;
        this.start.mTargets.add(this.mWidget.mParent.mVerticalRun.start);
        this.mWidget.mParent.mVerticalRun.start.mDependencies.add(this.start);
        this.start.mMargin = r1;
    L15:
        addDependency(this.mWidget.mVerticalRun.start);
        addDependency(this.mWidget.mVerticalRun.end);
        return;
    L12:
        if (r2 == (-1)) goto L14;
        this.start.mTargets.add(this.mWidget.mParent.mVerticalRun.end);
        this.mWidget.mParent.mVerticalRun.end.mDependencies.add(this.start);
        int r4 = -r2;
        this.start.mMargin = r4;
        goto L15
    L14:
        this.start.delegateToWidgetRun = true;
        this.start.mTargets.add(this.mWidget.mParent.mVerticalRun.end);
        this.mWidget.mParent.mVerticalRun.end.mDependencies.add(this.start);
        goto L15
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (((Guideline) this.mWidget).getOrientation() != 1) goto L5;
        this.mWidget.setX(this.start.value);
        return;
    L5:
        this.mWidget.setY(this.start.value);
    }
}
