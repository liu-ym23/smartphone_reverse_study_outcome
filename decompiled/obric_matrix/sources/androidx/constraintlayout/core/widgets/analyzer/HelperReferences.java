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
    void apply() {
        ConstraintWidget r0 = this.widget;
        if ((r0 instanceof Barrier) == false) goto L68;
        this.start.delegateToWidgetRun = true;
        Barrier r1 = (Barrier) r0;
        int r2 = r1.getBarrierType();
        boolean r3 = r1.getAllowsGoneWidget();
        int r5 = 0;
        if (r2 == 0) goto L43;
        if (r2 != 1) goto L8;
        DependencyNode r4 = this.start;
        r4.type = DependencyNode.Type.RIGHT;
    L35:
        if (r5 >= r1.mWidgetsCount) goto L53;
        ConstraintWidget r6 = r1.mWidgets[r5];
        if (r3 == false) goto L39;
    L41:
        DependencyNode r7 = r6.horizontalRun.end;
        r7.dependencies.add(this.start);
        this.start.targets.add(r7);
    L42:
        r5 = r5 + 1;
        goto L35
    L39:
        if (r6.getVisibility() != 8) goto L41;
    L53:
        addDependency(this.widget.horizontalRun.start);
        WidgetRun r8 = this.widget.horizontalRun;
    L54:
        addDependency(r8.end);
        return;
    L8:
        if (r2 != 2) goto L10;
        DependencyNode r9 = this.start;
        r9.type = DependencyNode.Type.TOP;
    L24:
        if (r5 >= r1.mWidgetsCount) goto L32;
        ConstraintWidget r10 = r1.mWidgets[r5];
        if (r3 == false) goto L28;
    L30:
        DependencyNode r11 = r10.verticalRun.start;
        r11.dependencies.add(this.start);
        this.start.targets.add(r11);
    L31:
        r5 = r5 + 1;
        goto L24
    L28:
        if (r10.getVisibility() != 8) goto L30;
    L32:
        addDependency(this.widget.verticalRun.start);
        r8 = this.widget.verticalRun;
        goto L54
    L10:
        if (r2 != 3) goto L69;
        DependencyNode r12 = this.start;
        r12.type = DependencyNode.Type.BOTTOM;
    L14:
        if (r5 >= r1.mWidgetsCount) goto L32;
        ConstraintWidget r13 = r1.mWidgets[r5];
        if (r3 == false) goto L18;
    L20:
        DependencyNode r14 = r13.verticalRun.end;
        r14.dependencies.add(this.start);
        this.start.targets.add(r14);
    L21:
        r5 = r5 + 1;
        goto L14
    L18:
        if (r13.getVisibility() != 8) goto L20;
    L69:
        return;
    L43:
        DependencyNode r15 = this.start;
        r15.type = DependencyNode.Type.LEFT;
    L45:
        if (r5 >= r1.mWidgetsCount) goto L53;
        ConstraintWidget r16 = r1.mWidgets[r5];
        if (r3 == false) goto L49;
    L51:
        DependencyNode r17 = r16.horizontalRun.start;
        r17.dependencies.add(this.start);
        this.start.targets.add(r17);
    L52:
        r5 = r5 + 1;
        goto L45
    L49:
        if (r16.getVisibility() != 8) goto L51;
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
    void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
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
        this.start.resolve(r4 + r8.getMargin());
        return;
    L13:
        if (r0 == 2) goto L16;
        this.start.resolve(r3 + r8.getMargin());
    }
}
