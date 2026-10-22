package androidx.constraintlayout.core.widgets.analyzer;

import a.a;
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
        WidgetRun r4 = r3.run;
        if (r4 == r6) goto L7;
        if (r3 != r4.start) goto L7;
        if ((r6 instanceof ChainRun) == false) goto L22;
        Iterator<WidgetRun> r5 = ((ChainRun) r6).widgets.iterator();
    L19:
        if (r5.hasNext() == false) goto L24;
        defineTerminalWidget(r5.next(), r7);
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
        Dependency r8 = r1.next();
        if ((r8 instanceof DependencyNode) == false) goto L27;
        DependencyNode r9 = (DependencyNode) r8;
        WidgetRun r10 = r9.run;
        if (r10 == r6) goto L27;
        if (r9 != r10.start) goto L27;
        if ((r6 instanceof ChainRun) == false) goto L42;
        Iterator<WidgetRun> r11 = ((ChainRun) r6).widgets.iterator();
    L39:
        if (r11.hasNext() == false) goto L44;
        defineTerminalWidget(r11.next(), r7);
    L44:
        defineTerminalWidget(r9.run, r7);
        goto L27
    L42:
        if ((r6 instanceof HelperReferences) == true) goto L44;
        r6.widget.isTerminalWidget[r7] = false;
        goto L44
    L45:
        return false;
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

    public void add(WidgetRun r2) {
        this.runs.add(r2);
        this.lastRun = r2;
    }

    public long computeWrapSize(ConstraintWidgetContainer r12, int r13) {
        WidgetRun r0 = this.firstRun;
        long r2 = 0;
        if ((r0 instanceof ChainRun) == true) goto L5;
        if (r13 != 0) goto L12;
        if ((r0 instanceof HorizontalWidgetRun) == true) goto L14;
        return 0;
    L14:
        if (r13 != 0) goto L17;
        WidgetRun r1 = r12.horizontalRun;
    L16:
        DependencyNode r3 = r1.start;
        if (r13 != 0) goto L21;
        WidgetRun r14 = r12.horizontalRun;
    L20:
        DependencyNode r15 = r14.end;
        boolean r4 = r0.start.targets.contains(r3);
        boolean r16 = this.firstRun.end.targets.contains(r15);
        long r5 = this.firstRun.getWrapDimension();
        if (r4 == false) goto L36;
        if (r16 == false) goto L36;
        long r6 = traverseStart(this.firstRun.start, 0);
        long r7 = traverseEnd(this.firstRun.end, 0);
        long r8 = r6 - r5;
        WidgetRun r17 = this.firstRun;
        int r9 = r17.end.margin;
        if (r8 < (-r9)) goto L28;
        r8 = r8 + ((long) r9);
    L28:
        int r10 = r17.start.margin;
        long r11 = ((-r7) - r5) - ((long) r10);
        if (r11 < r10) goto L31;
        r11 = r11 - ((long) r10);
    L31:
        float r18 = r17.widget.getBiasPercent(r13);
        if (r18 <= 0.0f) goto L34;
        r2 = (long) ((r8 / (1.0f - r18)) + (r11 / r18));
    L34:
        float r19 = r2;
        long r20 = (((long) ((r19 * r18) + 0.5f)) + r5) + ((long) a.a(1.0f, r18, r19, 0.5f));
        WidgetRun r110 = this.firstRun;
        long r111 = ((long) r110.start.margin) + r20;
        int r112 = r110.end.margin;
    L41:
        return r111 - ((long) r112);
    L36:
        if (r4 == false) goto L38;
        DependencyNode r113 = this.firstRun.start;
        return Math.max(traverseStart(r113, r113.margin), ((long) this.firstRun.start.margin) + r5);
    L38:
        if (r16 == false) goto L40;
        DependencyNode r114 = this.firstRun.end;
        long r115 = traverseEnd(r114, r114.margin);
        return Math.max(-r115, ((long) (-this.firstRun.end.margin)) + r5);
    L40:
        WidgetRun r116 = this.firstRun;
        r111 = r116.getWrapDimension() + r116.start.margin;
        r112 = this.firstRun.end.margin;
        goto L41
    L21:
        r14 = r12.verticalRun;
        goto L20
    L17:
        r1 = r12.verticalRun;
        goto L16
    L12:
        if ((r0 instanceof VerticalWidgetRun) == true) goto L14;
        return 0;
    L5:
        if (((ChainRun) r0).orientation == r13) goto L14;
        return 0;
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
