package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* JADX INFO: loaded from: classes.dex */
class GuidelineReference extends WidgetRun {
    public GuidelineReference(ConstraintWidget r2) {
        super(r2);
        r2.horizontalRun.clear();
        r2.verticalRun.clear();
        this.orientation = ((Guideline) r2).getOrientation();
    }

    private void addDependency(DependencyNode r2) {
        this.start.dependencies.add(r2);
        r2.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void apply() {
        Guideline r0 = (Guideline) this.widget;
        int r1 = r0.getRelativeBegin();
        int r2 = r0.getRelativeEnd();
        r0.getRelativePercent();
        if (r0.getOrientation() != 1) goto L12;
        DependencyNode r3 = this.start;
        if (r1 == (-1)) goto L8;
        r3.targets.add(this.widget.mParent.horizontalRun.start);
        this.widget.mParent.horizontalRun.start.dependencies.add(this.start);
        DependencyNode r4 = this.start;
    L7:
        r4.margin = r1;
    L11:
        addDependency(this.widget.horizontalRun.start);
        WidgetRun r5 = this.widget.horizontalRun;
    L20:
        addDependency(r5.end);
        return;
    L8:
        if (r2 == (-1)) goto L10;
        r3.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        r4 = this.start;
        r1 = -r2;
        goto L7
    L10:
        r3.delegateToWidgetRun = true;
        r3.targets.add(this.widget.mParent.horizontalRun.end);
        this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
        goto L11
    L12:
        DependencyNode r6 = this.start;
        if (r1 == (-1)) goto L16;
        r6.targets.add(this.widget.mParent.verticalRun.start);
        this.widget.mParent.verticalRun.start.dependencies.add(this.start);
        DependencyNode r7 = this.start;
    L15:
        r7.margin = r1;
    L19:
        addDependency(this.widget.verticalRun.start);
        r5 = this.widget.verticalRun;
        goto L20
    L16:
        if (r2 == (-1)) goto L18;
        r6.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        r7 = this.start;
        r1 = -r2;
        goto L15
    L18:
        r6.delegateToWidgetRun = true;
        r6.targets.add(this.widget.mParent.verticalRun.end);
        this.widget.mParent.verticalRun.end.dependencies.add(this.start);
        goto L19
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        if (((Guideline) this.widget).getOrientation() != 1) goto L5;
        this.widget.setX(this.start.value);
        return;
    L5:
        this.widget.setY(this.start.value);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void clear() {
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r3) {
        DependencyNode r4 = this.start;
        if (r4.readyToSolve == true) goto L6;
        return;
    L6:
        if (r4.resolved == false) goto L8;
        return;
    L8:
        this.start.resolve((int) ((r4.targets.get(0).value * ((Guideline) this.widget).getRelativePercent()) + 0.5f));
    }
}
