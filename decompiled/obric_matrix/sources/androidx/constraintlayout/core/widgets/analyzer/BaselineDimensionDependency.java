package androidx.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes.dex */
class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun r1) {
        super(r1);
    }

    public void update(DependencyNode r2) {
        WidgetRun r3 = this.run;
        DependencyNode r0 = ((VerticalWidgetRun) r3).baseline;
        r0.margin = r3.widget.getBaselineDistance();
        this.resolved = true;
    }
}
