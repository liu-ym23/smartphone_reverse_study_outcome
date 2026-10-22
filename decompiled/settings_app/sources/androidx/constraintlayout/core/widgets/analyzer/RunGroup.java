package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int direction;
    public boolean dual;
    WidgetRun firstRun;
    int groupIndex;
    WidgetRun lastRun;
    public int position;
    ArrayList<WidgetRun> runs;

    public RunGroup(WidgetRun r2, int r3) {
        this.position = 0;
        this.dual = false;
        this.firstRun = null;
        this.lastRun = null;
        this.runs = new ArrayList();
        int r0 = index;
        this.groupIndex = r0;
        index = r0 + 1;
        this.firstRun = r2;
        this.lastRun = r2;
        this.direction = r3;
    }

    public void add(WidgetRun r2) {
        this.runs.add(r2);
        this.lastRun = r2;
    }

    private long traverseStart(DependencyNode r9, long r10) {
        WidgetRun r0 = r9.run;
        if ((r0 instanceof HelperReferences) == false) goto L5;
        return r10;
    L5:
        int r1 = r9.dependencies.size();
        int r2 = 0;
        long r3 = r10;
    L6:
        if (r2 >= r1) goto L15;
        Dependency r5 = r9.dependencies.get(r2);
        if ((r5 instanceof DependencyNode) == false) goto L13;
        DependencyNode r6 = (DependencyNode) r5;
        if (r6.run == r0) goto L13;
        r3 = Math.max(r3, traverseStart(r6, ((long) r6.margin) + r10));
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        if (r9 != r0.start) goto L22;
        long r4 = r0.getWrapDimension();
        long r11 = r10 + r4;
        return Math.max(Math.max(r3, traverseStart(r0.end, r11)), r11 - ((long) r0.end.margin));
    L22:
        return r3;
    }

    private long traverseEnd(DependencyNode r9, long r10) {
        WidgetRun r0 = r9.run;
        if ((r0 instanceof HelperReferences) == false) goto L5;
        return r10;
    L5:
        int r1 = r9.dependencies.size();
        int r2 = 0;
        long r3 = r10;
    L6:
        if (r2 >= r1) goto L15;
        Dependency r5 = r9.dependencies.get(r2);
        if ((r5 instanceof DependencyNode) == false) goto L13;
        DependencyNode r6 = (DependencyNode) r5;
        if (r6.run == r0) goto L13;
        r3 = Math.min(r3, traverseEnd(r6, ((long) r6.margin) + r10));
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        if (r9 != r0.end) goto L22;
        long r4 = r0.getWrapDimension();
        long r11 = r10 - r4;
        return Math.min(Math.min(r3, traverseEnd(r0.start, r11)), r11 - ((long) r0.start.margin));
    L22:
        return r3;
    }

    public long computeWrapSize(ConstraintWidgetContainer r11, int r12) {
        WidgetRun r0 = this.firstRun;
        long r2 = 0;
        if ((r0 instanceof ChainRun) == true) goto L5;
        if (r12 != 0) goto L12;
        if ((r0 instanceof HorizontalWidgetRun) == true) goto L14;
        return 0;
    L14:
        if (r12 != 0) goto L16;
        DependencyNode r1 = r11.horizontalRun.start;
    L17:
        if (r12 != 0) goto L19;
        DependencyNode r13 = r11.horizontalRun.end;
    L20:
        boolean r3 = this.firstRun.start.targets.contains(r1);
        boolean r14 = this.firstRun.end.targets.contains(r13);
        long r4 = this.firstRun.getWrapDimension();
        if (r3 == false) goto L33;
        if (r14 == false) goto L33;
        long r5 = traverseStart(this.firstRun.start, 0);
        long r6 = traverseEnd(this.firstRun.end, 0);
        long r7 = r5 - r4;
        if (r7 < (-this.firstRun.end.margin)) goto L26;
        r7 = r7 + ((long) this.firstRun.end.margin);
    L26:
        long r8 = ((-r6) - r4) - ((long) this.firstRun.start.margin);
        if (r8 < this.firstRun.start.margin) goto L29;
        r8 = r8 - ((long) this.firstRun.start.margin);
    L29:
        float r15 = this.firstRun.widget.getBiasPercent(r12);
        if (r15 <= 0.0f) goto L32;
        r2 = (long) ((r8 / r15) + (r7 / (1.0f - r15)));
    L32:
        float r16 = r2;
        long r17 = ((long) this.firstRun.start.margin) + ((((long) ((r16 * r15) + 0.5f)) + r4) + ((long) ((r16 * (1.0f - r15)) + 0.5f)));
        int r10 = this.firstRun.end.margin;
    L39:
        return r17 - ((long) r10);
    L33:
        if (r3 == true) goto L40;
        if (r14 == false) goto L37;
        long r18 = traverseEnd(this.firstRun.end, this.firstRun.end.margin);
        return Math.max(-r18, ((long) (-this.firstRun.end.margin)) + r4);
    L37:
        r17 = ((long) this.firstRun.start.margin) + this.firstRun.getWrapDimension();
        r10 = this.firstRun.end.margin;
        goto L39
    L40:
        return Math.max(traverseStart(this.firstRun.start, this.firstRun.start.margin), ((long) this.firstRun.start.margin) + r4);
    L19:
        r13 = r11.verticalRun.end;
        goto L20
    L16:
        r1 = r11.verticalRun.start;
        goto L17
    L12:
        if ((r0 instanceof VerticalWidgetRun) == true) goto L14;
        return 0;
    L5:
        if (((ChainRun) r0).orientation == r12) goto L14;
        return 0;
    }

    private boolean defineTerminalWidget(WidgetRun r6, int r7) {
        if (r6.widget.isTerminalWidget[r7] == true) goto L5;
        return false;
    L5:
        Iterator<Dependency> r0 = r6.start.dependencies.iterator();
    L7:
        if (r0.hasNext() == false) goto L25;
        Dependency r2 = r0.next();
        if ((r2 instanceof DependencyNode) == false) goto L7;
        DependencyNode r3 = (DependencyNode) r2;
        if (r3.run == r6) goto L7;
        if (r3 != r3.run.start) goto L7;
        if ((r6 instanceof ChainRun) == false) goto L22;
        Iterator<WidgetRun> r4 = ((ChainRun) r6).widgets.iterator();
    L19:
        if (r4.hasNext() == false) goto L24;
        defineTerminalWidget(r4.next(), r7);
    L24:
        defineTerminalWidget(r3.run, r7);
        goto L7
    L22:
        if ((r6 instanceof HelperReferences) == true) goto L24;
        r6.widget.isTerminalWidget[r7] = false;
        goto L24
    L25:
        Iterator<Dependency> r1 = r6.end.dependencies.iterator();
    L27:
        if (r1.hasNext() == false) goto L45;
        Dependency r5 = r1.next();
        if ((r5 instanceof DependencyNode) == false) goto L27;
        DependencyNode r8 = (DependencyNode) r5;
        if (r8.run == r6) goto L27;
        if (r8 != r8.run.start) goto L27;
        if ((r6 instanceof ChainRun) == false) goto L42;
        Iterator<WidgetRun> r9 = ((ChainRun) r6).widgets.iterator();
    L39:
        if (r9.hasNext() == false) goto L44;
        defineTerminalWidget(r9.next(), r7);
    L44:
        defineTerminalWidget(r8.run, r7);
        goto L27
    L42:
        if ((r6 instanceof HelperReferences) == true) goto L44;
        r6.widget.isTerminalWidget[r7] = false;
        goto L44
    L45:
        return false;
    }

    public void defineTerminalWidgets(boolean r2, boolean r3) {
        if (r2 == false) goto L6;
        WidgetRun r4 = this.firstRun;
        if ((r4 instanceof HorizontalWidgetRun) == false) goto L6;
        defineTerminalWidget(r4, 0);
    L6:
        if (r3 == false) goto L11;
        WidgetRun r5 = this.firstRun;
        if ((r5 instanceof VerticalWidgetRun) == false) goto L12;
        defineTerminalWidget(r5, 1);
        return;
    L12:
        return;
    }
}
