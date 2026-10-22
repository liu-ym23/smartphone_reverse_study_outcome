package androidx.constraintlayout.core.widgets.analyzer;

/* JADX INFO: loaded from: classes.dex */
class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun r1) {
        super(r1);
    }

    public void update(DependencyNode r2) {
        DependencyNode r3 = ((VerticalWidgetRun) this.run).baseline;
        r3.margin = this.run.widget.getBaselineDistance();
        this.resolved = true;
    }
}
