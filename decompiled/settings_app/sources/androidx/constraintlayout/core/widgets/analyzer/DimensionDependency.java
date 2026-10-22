package androidx.constraintlayout.core.widgets.analyzer;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class DimensionDependency extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun r1) {
        super(r1);
        if ((r1 instanceof HorizontalWidgetRun) == false) goto L5;
        this.type = DependencyNode.Type.HORIZONTAL_DIMENSION;
        return;
    L5:
        this.type = DependencyNode.Type.VERTICAL_DIMENSION;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public void resolve(int r2) {
        if (this.resolved == false) goto L5;
        return;
    L5:
        this.resolved = true;
        this.value = r2;
        Iterator<Dependency> r1 = this.dependencies.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Dependency r3 = r1.next();
        r3.update(r3);
        goto L7
    }
}
