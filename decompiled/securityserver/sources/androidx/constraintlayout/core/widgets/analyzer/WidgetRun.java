package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {
    DimensionDependency dimension;
    protected ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public DependencyNode end;
    protected RunType mRunType;
    public int matchConstraintsType;
    public int orientation;
    boolean resolved;
    RunGroup runGroup;
    public DependencyNode start;
    ConstraintWidget widget;

    /* JADX INFO: renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = null;

        static {
            int[] r0 = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type = r0;
            r0[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final enum RunType extends Enum<RunType> {
        private static final /* synthetic */ RunType[] $VALUES = null;
        public static final RunType CENTER = null;
        public static final RunType END = null;
        public static final RunType NONE = null;
        public static final RunType START = null;

        static {
            RunType r0 = new RunType("NONE", 0);
            NONE = r0;
            RunType r1 = new RunType("START", 1);
            START = r1;
            RunType r2 = new RunType("END", 2);
            END = r2;
            RunType r3 = new RunType("CENTER", 3);
            CENTER = r3;
            $VALUES = new RunType[]{r0, r1, r2, r3};
        }

        private RunType(String r1, int r2) {
            super(r1, r2);
        }

        public static RunType valueOf(String r1) {
            return (RunType) Enum.valueOf(RunType.class, r1);
        }

        public static RunType[] values() {
            return (RunType[]) $VALUES.clone();
        }
    }

    public WidgetRun(ConstraintWidget r2) {
        this.dimension = new DimensionDependency(this);
        this.orientation = 0;
        this.resolved = false;
        this.start = new DependencyNode(this);
        this.end = new DependencyNode(this);
        this.mRunType = RunType.NONE;
        this.widget = r2;
    }

    private void resolveDimension(int r8, int r9) {
        int r0 = this.matchConstraintsType;
        if (r0 != 0) goto L5;
        this.dimension.resolve(getLimitedDimension(r9, r8));
        return;
    L5:
        if (r0 != 1) goto L7;
        this.dimension.resolve(Math.min(getLimitedDimension(this.dimension.wrapValue, r8), r9));
        return;
    L7:
        if (r0 != 2) goto L9;
        ConstraintWidget r10 = this.widget.getParent();
        if (r10 == null) goto L46;
        if (r8 != 0) goto L33;
        WidgetRun r11 = r10.horizontalRun;
    L34:
        DimensionDependency r12 = r11.dimension;
        if (r12.resolved == false) goto L47;
        ConstraintWidget r1 = this.widget;
        if (r8 != 0) goto L39;
        float r2 = r1.mMatchConstraintPercentWidth;
    L40:
        this.dimension.resolve(getLimitedDimension((int) ((r12.value * r2) + 0.5f), r8));
        return;
    L39:
        r2 = r1.mMatchConstraintPercentHeight;
        goto L40
    L47:
        return;
    L33:
        r11 = r10.verticalRun;
        goto L34
    L46:
        return;
    L9:
        if (r0 != 3) goto L50;
        ConstraintWidget r3 = this.widget;
        WidgetRun r4 = r3.horizontalRun;
        ConstraintWidget.DimensionBehaviour r5 = r4.dimensionBehavior;
        ConstraintWidget.DimensionBehaviour r6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r5 == r6) goto L14;
    L20:
        if (r8 != 0) goto L23;
        r4 = r3.verticalRun;
    L23:
        if (r4.dimension.resolved == false) goto L44;
        float r13 = r3.getDimensionRatio();
        if (r8 != 1) goto L27;
        int r14 = (int) ((r4.dimension.value / r13) + 0.5f);
    L28:
        this.dimension.resolve(r14);
        return;
    L27:
        r14 = (int) ((r13 * r4.dimension.value) + 0.5f);
        goto L28
    L44:
        return;
    L14:
        if (r4.matchConstraintsType != 3) goto L20;
        VerticalWidgetRun r7 = r3.verticalRun;
        if (r7.dimensionBehavior != r6) goto L20;
        if (r7.matchConstraintsType != 3) goto L20;
        return;
    }

    public final void addTarget(DependencyNode r1, DependencyNode r2, int r3) {
        r1.targets.add(r2);
        r1.margin = r3;
        r2.dependencies.add(r1);
    }

    public abstract void apply();

    public abstract void applyToWidget();

    public abstract void clear();

    public final int getLimitedDimension(int r1, int r2) {
        if (r2 != 0) goto L8;
        ConstraintWidget r0 = this.widget;
        int r3 = r0.mMatchConstraintMaxWidth;
        int r4 = Math.max(r0.mMatchConstraintMinWidth, r1);
        if (r3 <= 0) goto L6;
        r4 = Math.min(r3, r1);
    L6:
        if (r4 != r1) goto L13;
        return r1;
    L13:
        return r4;
    L8:
        ConstraintWidget r5 = this.widget;
        int r6 = r5.mMatchConstraintMaxHeight;
        r4 = Math.max(r5.mMatchConstraintMinHeight, r1);
        if (r6 <= 0) goto L11;
        r4 = Math.min(r6, r1);
    L11:
        if (r4 != r1) goto L13;
        return r1;
    }

    public final DependencyNode getTarget(ConstraintAnchor r3) {
        ConstraintAnchor r2 = r3.mTarget;
        if (r2 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r0 = r2.mOwner;
        ConstraintAnchor.Type r4 = r2.mType;
        int r5 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r4.ordinal()];
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L25;
        if (r5 == 3) goto L24;
        if (r5 == 4) goto L23;
        if (r5 == 5) goto L22;
        return null;
    L22:
        return r0.verticalRun.end;
    L23:
        return r0.verticalRun.baseline;
    L24:
        return r0.verticalRun.start;
    L25:
        return r0.horizontalRun.end;
    L21:
        return r0.horizontalRun.start;
    }

    public long getWrapDimension() {
        DimensionDependency r2 = this.dimension;
        if (r2.resolved == true) goto L5;
        return 0;
    L5:
        return r2.value;
    }

    public boolean isCenterConnection() {
        int r0 = this.start.targets.size();
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (this.start.targets.get(r2).run == this) goto L7;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        int r1 = this.end.targets.size();
        int r4 = 0;
    L9:
        if (r4 >= r1) goto L15;
        if (this.end.targets.get(r4).run == this) goto L13;
        r3 = r3 + 1;
    L13:
        r4 = r4 + 1;
        goto L9
    L15:
        if (r3 < 2) goto L24;
        return true;
    L24:
        return false;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    public abstract void reset();

    public abstract boolean supportsWrapComputation();

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r1) {
    }

    public void updateRunCenter(Dependency r5, ConstraintAnchor r6, ConstraintAnchor r7, int r8) {
        DependencyNode r9 = getTarget(r6);
        DependencyNode r0 = getTarget(r7);
        if (r9.resolved == true) goto L5;
        return;
    L5:
        if (r0.resolved == false) goto L29;
        int r10 = r6.getMargin() + r9.value;
        int r1 = r0.value - r7.getMargin();
        int r11 = r1 - r10;
        if (this.dimension.resolved == false) goto L10;
    L12:
        DimensionDependency r2 = this.dimension;
        if (r2.resolved == true) goto L16;
        return;
    L16:
        if (r2.value != r11) goto L19;
        this.start.resolve(r10);
        this.end.resolve(r1);
        return;
    L19:
        ConstraintWidget r12 = this.widget;
        if (r8 != 0) goto L22;
        float r13 = r12.getHorizontalBiasPercent();
    L24:
        if (r9 != r0) goto L26;
        r10 = r9.value;
        r1 = r0.value;
        r13 = 0.5f;
    L26:
        this.start.resolve((int) ((((r1 - r10) - this.dimension.value) * r13) + (r10 + 0.5f)));
        this.end.resolve(this.start.value + this.dimension.value);
        return;
    L22:
        r13 = r12.getVerticalBiasPercent();
        goto L24
    L10:
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L12;
        resolveDimension(r8, r11);
        goto L12
    }

    public void updateRunEnd(Dependency r1) {
    }

    public void updateRunStart(Dependency r1) {
    }

    public long wrapSize(int r4) {
        DimensionDependency r0 = this.dimension;
        if (r0.resolved == false) goto L12;
        long r1 = r0.value;
        if (isCenterConnection() == false) goto L8;
        long r3 = this.start.margin - this.end.margin;
    L14:
        return r1 + r3;
    L8:
        if (r4 != 0) goto L11;
        r3 = this.start.margin;
        goto L14
    L11:
        return r1 - ((long) this.end.margin);
    L12:
        return 0;
    }

    public final void addTarget(DependencyNode r2, DependencyNode r3, int r4, DimensionDependency r5) {
        r2.targets.add(r3);
        r2.targets.add(this.dimension);
        r2.marginFactor = r4;
        r2.marginDependency = r5;
        r3.dependencies.add(r2);
        r5.dependencies.add(r2);
    }

    public final DependencyNode getTarget(ConstraintAnchor r2, int r3) {
        ConstraintAnchor r1 = r2.mTarget;
        if (r1 != null) goto L5;
        return null;
    L5:
        ConstraintWidget r0 = r1.mOwner;
        if (r3 != 0) goto L8;
        WidgetRun r4 = r0.horizontalRun;
    L9:
        ConstraintAnchor.Type r5 = r1.mType;
        int r6 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$ConstraintAnchor$Type[r5.ordinal()];
        if (r6 == 1) goto L20;
        if (r6 == 2) goto L21;
        if (r6 == 3) goto L20;
        if (r6 == 5) goto L21;
        return null;
    L21:
        return r4.end;
    L20:
        return r4.start;
    L8:
        r4 = r0.verticalRun;
        goto L9
    }
}
