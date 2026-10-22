package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    public boolean dual;
    int mDirection;
    WidgetRun mFirstRun;
    int mGroupIndex;
    WidgetRun mLastRun;
    ArrayList<WidgetRun> mRuns;
    public int position;

    RunGroup(WidgetRun r2, int r3) {
        this.position = 0;
        this.dual = false;
        this.mFirstRun = null;
        this.mLastRun = null;
        this.mRuns = new ArrayList();
        int r0 = index;
        this.mGroupIndex = r0;
        index = r0 + 1;
        this.mFirstRun = r2;
        this.mLastRun = r2;
        this.mDirection = r3;
    }

    public void add(WidgetRun r2) {
        this.mRuns.add(r2);
        this.mLastRun = r2;
    }

    private long traverseStart(DependencyNode r9, long r10) {
        WidgetRun r0 = r9.mRun;
        if ((r0 instanceof HelperReferences) == false) goto L5;
        return r10;
    L5:
        int r1 = r9.mDependencies.size();
        int r2 = 0;
        long r3 = r10;
    L6:
        if (r2 >= r1) goto L15;
        Dependency r5 = r9.mDependencies.get(r2);
        if ((r5 instanceof DependencyNode) == false) goto L13;
        DependencyNode r6 = (DependencyNode) r5;
        if (r6.mRun == r0) goto L13;
        r3 = Math.max(r3, traverseStart(r6, ((long) r6.mMargin) + r10));
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        if (r9 != r0.start) goto L22;
        long r4 = r0.getWrapDimension();
        long r11 = r10 + r4;
        return Math.max(Math.max(r3, traverseStart(r0.end, r11)), r11 - ((long) r0.end.mMargin));
    L22:
        return r3;
    }

    private long traverseEnd(DependencyNode r9, long r10) {
        WidgetRun r0 = r9.mRun;
        if ((r0 instanceof HelperReferences) == false) goto L5;
        return r10;
    L5:
        int r1 = r9.mDependencies.size();
        int r2 = 0;
        long r3 = r10;
    L6:
        if (r2 >= r1) goto L15;
        Dependency r5 = r9.mDependencies.get(r2);
        if ((r5 instanceof DependencyNode) == false) goto L13;
        DependencyNode r6 = (DependencyNode) r5;
        if (r6.mRun == r0) goto L13;
        r3 = Math.min(r3, traverseEnd(r6, ((long) r6.mMargin) + r10));
    L13:
        r2 = r2 + 1;
        goto L6
    L15:
        if (r9 != r0.end) goto L22;
        long r4 = r0.getWrapDimension();
        long r11 = r10 - r4;
        return Math.min(Math.min(r3, traverseEnd(r0.start, r11)), r11 - ((long) r0.start.mMargin));
    L22:
        return r3;
    }

    public long computeWrapSize(ConstraintWidgetContainer r11, int r12) {
        WidgetRun r0 = this.mFirstRun;
        long r2 = 0;
        if ((r0 instanceof ChainRun) == true) goto L5;
        if (r12 != 0) goto L12;
        if ((r0 instanceof HorizontalWidgetRun) == true) goto L14;
        return 0;
    L14:
        if (r12 != 0) goto L16;
        DependencyNode r1 = r11.mHorizontalRun.start;
    L17:
        if (r12 != 0) goto L19;
        DependencyNode r13 = r11.mHorizontalRun.end;
    L20:
        boolean r3 = this.mFirstRun.start.mTargets.contains(r1);
        boolean r14 = this.mFirstRun.end.mTargets.contains(r13);
        long r4 = this.mFirstRun.getWrapDimension();
        if (r3 == false) goto L33;
        if (r14 == false) goto L33;
        long r5 = traverseStart(this.mFirstRun.start, 0);
        long r6 = traverseEnd(this.mFirstRun.end, 0);
        long r7 = r5 - r4;
        if (r7 < (-this.mFirstRun.end.mMargin)) goto L26;
        r7 = r7 + ((long) this.mFirstRun.end.mMargin);
    L26:
        long r8 = ((-r6) - r4) - ((long) this.mFirstRun.start.mMargin);
        if (r8 < this.mFirstRun.start.mMargin) goto L29;
        r8 = r8 - ((long) this.mFirstRun.start.mMargin);
    L29:
        float r15 = this.mFirstRun.mWidget.getBiasPercent(r12);
        if (r15 <= 0.0f) goto L32;
        r2 = (long) ((r8 / r15) + (r7 / (1.0f - r15)));
    L32:
        float r16 = r2;
        long r17 = ((long) this.mFirstRun.start.mMargin) + ((((long) ((r16 * r15) + 0.5f)) + r4) + ((long) ((r16 * (1.0f - r15)) + 0.5f)));
        int r10 = this.mFirstRun.end.mMargin;
    L39:
        return r17 - ((long) r10);
    L33:
        if (r3 == true) goto L40;
        if (r14 == false) goto L37;
        long r18 = traverseEnd(this.mFirstRun.end, this.mFirstRun.end.mMargin);
        return Math.max(-r18, ((long) (-this.mFirstRun.end.mMargin)) + r4);
    L37:
        r17 = ((long) this.mFirstRun.start.mMargin) + this.mFirstRun.getWrapDimension();
        r10 = this.mFirstRun.end.mMargin;
        goto L39
    L40:
        return Math.max(traverseStart(this.mFirstRun.start, this.mFirstRun.start.mMargin), ((long) this.mFirstRun.start.mMargin) + r4);
    L19:
        r13 = r11.mVerticalRun.end;
        goto L20
    L16:
        r1 = r11.mVerticalRun.start;
        goto L17
    L12:
        if ((r0 instanceof VerticalWidgetRun) == true) goto L14;
        return 0;
    L5:
        if (((ChainRun) r0).orientation == r12) goto L14;
        return 0;
    }

    private boolean defineTerminalWidget(WidgetRun r6, int r7) {
        if (r6.mWidget.isTerminalWidget[r7] == true) goto L5;
        return false;
    L5:
        Iterator<Dependency> r0 = r6.start.mDependencies.iterator();
    L7:
        if (r0.hasNext() == false) goto L25;
        Dependency r2 = r0.next();
        if ((r2 instanceof DependencyNode) == false) goto L7;
        DependencyNode r3 = (DependencyNode) r2;
        if (r3.mRun == r6) goto L7;
        if (r3 != r3.mRun.start) goto L7;
        if ((r6 instanceof ChainRun) == false) goto L22;
        Iterator<WidgetRun> r4 = ((ChainRun) r6).mWidgets.iterator();
    L19:
        if (r4.hasNext() == false) goto L24;
        defineTerminalWidget(r4.next(), r7);
    L24:
        defineTerminalWidget(r3.mRun, r7);
        goto L7
    L22:
        if ((r6 instanceof HelperReferences) == true) goto L24;
        r6.mWidget.isTerminalWidget[r7] = false;
        goto L24
    L25:
        Iterator<Dependency> r1 = r6.end.mDependencies.iterator();
    L27:
        if (r1.hasNext() == false) goto L45;
        Dependency r5 = r1.next();
        if ((r5 instanceof DependencyNode) == false) goto L27;
        DependencyNode r8 = (DependencyNode) r5;
        if (r8.mRun == r6) goto L27;
        if (r8 != r8.mRun.start) goto L27;
        if ((r6 instanceof ChainRun) == false) goto L42;
        Iterator<WidgetRun> r9 = ((ChainRun) r6).mWidgets.iterator();
    L39:
        if (r9.hasNext() == false) goto L44;
        defineTerminalWidget(r9.next(), r7);
    L44:
        defineTerminalWidget(r8.mRun, r7);
        goto L27
    L42:
        if ((r6 instanceof HelperReferences) == true) goto L44;
        r6.mWidget.isTerminalWidget[r7] = false;
        goto L44
    L45:
        return false;
    }

    public void defineTerminalWidgets(boolean r2, boolean r3) {
        if (r2 == false) goto L6;
        WidgetRun r4 = this.mFirstRun;
        if ((r4 instanceof HorizontalWidgetRun) == false) goto L6;
        defineTerminalWidget(r4, 0);
    L6:
        if (r3 == false) goto L11;
        WidgetRun r5 = this.mFirstRun;
        if ((r5 instanceof VerticalWidgetRun) == false) goto L12;
        defineTerminalWidget(r5, 1);
        return;
    L12:
        return;
    }
}
