package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class HelperReferences extends WidgetRun {
    public HelperReferences(ConstraintWidget r1) {
        super(r1);
    }

    private void addDependency(DependencyNode r2) {
        this.start.dependencies.add(r2);
        r2.targets.add(this.start);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        ConstraintWidget r0 = this.widget;
        if ((r0 instanceof Barrier) == false) goto L69;
        this.start.delegateToWidgetRun = true;
        Barrier r1 = (Barrier) r0;
        int r2 = r1.getBarrierType();
        boolean r3 = r1.getAllowsGoneWidget();
        int r5 = 0;
        if (r2 == 0) goto L45;
        if (r2 != 1) goto L8;
        DependencyNode r4 = this.start;
        r4.type = DependencyNode.Type.RIGHT;
    L36:
        if (r5 >= r1.mWidgetsCount) goto L44;
        ConstraintWidget r6 = r1.mWidgets[r5];
        if (r3 == false) goto L40;
    L42:
        DependencyNode r7 = r6.horizontalRun.end;
        r7.dependencies.add(this.start);
        this.start.targets.add(r7);
    L43:
        r5 = r5 + 1;
        goto L36
    L40:
        if (r6.getVisibility() != 8) goto L42;
    L44:
        addDependency(this.widget.horizontalRun.start);
        addDependency(this.widget.horizontalRun.end);
        return;
    L8:
        if (r2 != 2) goto L10;
        DependencyNode r8 = this.start;
        r8.type = DependencyNode.Type.TOP;
    L25:
        if (r5 >= r1.mWidgetsCount) goto L33;
        ConstraintWidget r9 = r1.mWidgets[r5];
        if (r3 == false) goto L29;
    L31:
        DependencyNode r10 = r9.verticalRun.start;
        r10.dependencies.add(this.start);
        this.start.targets.add(r10);
    L32:
        r5 = r5 + 1;
        goto L25
    L29:
        if (r9.getVisibility() != 8) goto L31;
    L33:
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
        return;
    L10:
        if (r2 != 3) goto L73;
        DependencyNode r11 = this.start;
        r11.type = DependencyNode.Type.BOTTOM;
    L14:
        if (r5 >= r1.mWidgetsCount) goto L22;
        ConstraintWidget r12 = r1.mWidgets[r5];
        if (r3 == false) goto L18;
    L20:
        DependencyNode r13 = r12.verticalRun.end;
        r13.dependencies.add(this.start);
        this.start.targets.add(r13);
    L21:
        r5 = r5 + 1;
        goto L14
    L18:
        if (r12.getVisibility() != 8) goto L20;
    L22:
        addDependency(this.widget.verticalRun.start);
        addDependency(this.widget.verticalRun.end);
        return;
    L73:
        return;
    L45:
        DependencyNode r14 = this.start;
        r14.type = DependencyNode.Type.LEFT;
    L47:
        if (r5 >= r1.mWidgetsCount) goto L55;
        ConstraintWidget r15 = r1.mWidgets[r5];
        if (r3 == false) goto L51;
    L53:
        DependencyNode r16 = r15.horizontalRun.start;
        r16.dependencies.add(this.start);
        this.start.targets.add(r16);
    L54:
        r5 = r5 + 1;
        goto L47
    L51:
        if (r15.getVisibility() != 8) goto L53;
    L55:
        addDependency(this.widget.horizontalRun.start);
        addDependency(this.widget.horizontalRun.end);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        ConstraintWidget r0 = this.widget;
        if ((r0 instanceof Barrier) == false) goto L12;
        int r1 = ((Barrier) r0).getBarrierType();
        if (r1 != 0) goto L7;
    L10:
        this.widget.setX(this.start.value);
        return;
    L7:
        if (r1 == 1) goto L10;
        this.widget.setY(this.start.value);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r7) {
        Barrier r8 = (Barrier) this.widget;
        int r0 = r8.getBarrierType();
        Iterator<DependencyNode> r1 = this.start.targets.iterator();
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
        this.start.resolve(r8.getMargin() + r4);
        return;
    L13:
        if (r0 == 2) goto L16;
        this.start.resolve(r8.getMargin() + r3);
    }
}
