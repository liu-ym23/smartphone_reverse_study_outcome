package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.core.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.core.widgets.analyzer.Direct;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean DEBUG = false;
    static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    static int myCounter;
    private WeakReference<ConstraintAnchor> horizontalWrapMax;
    private WeakReference<ConstraintAnchor> horizontalWrapMin;
    BasicMeasure mBasicMeasureSolver;
    int mDebugSolverPassCount;
    public DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    ChainHead[] mHorizontalChainsArray;
    public int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    public BasicMeasure.Measure mMeasure;
    protected BasicMeasure.Measurer mMeasurer;
    public Metrics mMetrics;
    private int mOptimizationLevel;
    int mPaddingBottom;
    int mPaddingLeft;
    int mPaddingRight;
    int mPaddingTop;
    public boolean mSkipSolver;
    protected LinearSystem mSystem;
    ChainHead[] mVerticalChainsArray;
    public int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;
    private int pass;
    private WeakReference<ConstraintAnchor> verticalWrapMax;
    private WeakReference<ConstraintAnchor> verticalWrapMin;
    HashSet<ConstraintWidget> widgetsToAdd;

    public ConstraintWidgetContainer() {
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    private void addHorizontalChain(ConstraintWidget r6) {
        int r0 = this.mHorizontalChainsSize + 1;
        ChainHead[] r1 = this.mHorizontalChainsArray;
        if (r0 < r1.length) goto L5;
        this.mHorizontalChainsArray = (ChainHead[]) Arrays.copyOf(r1, r1.length * 2);
    L5:
        this.mHorizontalChainsArray[this.mHorizontalChainsSize] = new ChainHead(r6, 0, isRtl());
        this.mHorizontalChainsSize++;
    }

    private void addMaxWrap(ConstraintAnchor r3, SolverVariable r4) {
        SolverVariable r5 = this.mSystem.createObjectVariable(r3);
        this.mSystem.addGreaterThan(r4, r5, 0, 5);
    }

    private void addMinWrap(ConstraintAnchor r3, SolverVariable r4) {
        SolverVariable r5 = this.mSystem.createObjectVariable(r3);
        this.mSystem.addGreaterThan(r5, r4, 0, 5);
    }

    private void addVerticalChain(ConstraintWidget r6) {
        int r0 = this.mVerticalChainsSize + 1;
        ChainHead[] r2 = this.mVerticalChainsArray;
        if (r0 < r2.length) goto L5;
        this.mVerticalChainsArray = (ChainHead[]) Arrays.copyOf(r2, r2.length * 2);
    L5:
        this.mVerticalChainsArray[this.mVerticalChainsSize] = new ChainHead(r6, 1, isRtl());
        this.mVerticalChainsSize++;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    public void addChain(ConstraintWidget r2, int r3) {
        if (r3 != 0) goto L5;
        addHorizontalChain(r2);
        return;
    L5:
        if (r3 != 1) goto L9;
        addVerticalChain(r2);
        return;
    }

    public boolean addChildrenToSolver(LinearSystem r13) {
        boolean r0 = optimizeFor(64);
        addToSolver(r13, r0);
        int r1 = this.mChildren.size();
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (r3 >= r1) goto L9;
        ConstraintWidget r6 = this.mChildren.get(r3);
        r6.setInBarrier(0, false);
        r6.setInBarrier(1, false);
        if ((r6 instanceof Barrier) == false) goto L8;
        r4 = true;
    L8:
        r3 = r3 + 1;
        goto L4
    L9:
        if (r4 == false) goto L16;
        int r5 = 0;
    L11:
        if (r5 >= r1) goto L16;
        ConstraintWidget r7 = this.mChildren.get(r5);
        if ((r7 instanceof Barrier) == false) goto L15;
        ((Barrier) r7).markWidgets();
    L15:
        r5 = r5 + 1;
    L16:
        this.widgetsToAdd.clear();
        int r8 = 0;
    L17:
        if (r8 >= r1) goto L26;
        ConstraintWidget r9 = this.mChildren.get(r8);
        if (r9.addFirst() == false) goto L24;
        if ((r9 instanceof VirtualLayout) == false) goto L23;
        this.widgetsToAdd.add(r9);
        goto L24
    L23:
        r9.addToSolver(r13, r0);
    L24:
        r8 = r8 + 1;
    L26:
        if (this.widgetsToAdd.size() <= 0) goto L41;
        int r10 = this.widgetsToAdd.size();
        Iterator<ConstraintWidget> r11 = this.widgetsToAdd.iterator();
    L29:
        if (r11.hasNext() == false) goto L34;
        VirtualLayout r12 = (VirtualLayout) r11.next();
        if (r12.contains(this.widgetsToAdd) == false) goto L29;
        r12.addToSolver(r13, r0);
        this.widgetsToAdd.remove(r12);
    L34:
        if (r10 != this.widgetsToAdd.size()) goto L26;
        Iterator<ConstraintWidget> r14 = this.widgetsToAdd.iterator();
    L37:
        if (r14.hasNext() == false) goto L39;
        r14.next().addToSolver(r13, r0);
        goto L37
    L39:
        this.widgetsToAdd.clear();
        goto L26
    L41:
        if (LinearSystem.USE_DEPENDENCY_ORDERING == false) goto L56;
        HashSet<ConstraintWidget> r15 = new HashSet();
        int r16 = 0;
    L43:
        if (r16 >= r1) goto L49;
        ConstraintWidget r17 = this.mChildren.get(r16);
        if (r17.addFirst() == true) goto L47;
        r15.add(r17);
    L47:
        r16 = r16 + 1;
        goto L43
    L49:
        if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L51;
        int r18 = 0;
    L52:
        addChildrenToSolverByDependency(this, r13, r15, r18, false);
        Iterator<ConstraintWidget> r2 = r15.iterator();
    L54:
        if (r2.hasNext() == false) goto L75;
        ConstraintWidget r19 = r2.next();
        Optimizer.checkMatchParent(this, r13, r19);
        r19.addToSolver(r13, r0);
    L75:
        if (this.mHorizontalChainsSize <= 0) goto L78;
        Chain.applyChainConstraints(this, r13, null, 0);
    L78:
        if (this.mVerticalChainsSize <= 0) goto L80;
        Chain.applyChainConstraints(this, r13, null, 1);
    L80:
        return true;
    L51:
        r18 = 1;
        goto L52
    L56:
        int r20 = 0;
    L57:
        if (r20 >= r1) goto L75;
        ConstraintWidget r21 = this.mChildren.get(r20);
        if ((r21 instanceof ConstraintWidgetContainer) == false) goto L70;
        ConstraintWidget.DimensionBehaviour[] r22 = r21.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r23 = r22[0];
        ConstraintWidget.DimensionBehaviour r24 = r22[1];
        ConstraintWidget.DimensionBehaviour r25 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r23 != r25) goto L63;
        r21.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L63:
        if (r24 != r25) goto L65;
        r21.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
    L65:
        r21.addToSolver(r13, r0);
        if (r23 != r25) goto L68;
        r21.setHorizontalDimensionBehaviour(r23);
    L68:
        if (r24 != r25) goto L73;
        r21.setVerticalDimensionBehaviour(r24);
    L73:
        r20 = r20 + 1;
        goto L57
    L70:
        Optimizer.checkMatchParent(this, r13, r21);
        if (r21.addFirst() == true) goto L73;
        r21.addToSolver(r13, r0);
        goto L73
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor r3) {
        WeakReference<ConstraintAnchor> r0 = this.horizontalWrapMax;
        if (r0 != null) goto L5;
    L8:
        this.horizontalWrapMax = new WeakReference(r3);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r3.getFinalValue() > this.horizontalWrapMax.get().getFinalValue()) goto L8;
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor r3) {
        WeakReference<ConstraintAnchor> r0 = this.horizontalWrapMin;
        if (r0 != null) goto L5;
    L8:
        this.horizontalWrapMin = new WeakReference(r3);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r3.getFinalValue() > this.horizontalWrapMin.get().getFinalValue()) goto L8;
    }

    public void addVerticalWrapMaxVariable(ConstraintAnchor r3) {
        WeakReference<ConstraintAnchor> r0 = this.verticalWrapMax;
        if (r0 != null) goto L5;
    L8:
        this.verticalWrapMax = new WeakReference(r3);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r3.getFinalValue() > this.verticalWrapMax.get().getFinalValue()) goto L8;
    }

    public void addVerticalWrapMinVariable(ConstraintAnchor r3) {
        WeakReference<ConstraintAnchor> r0 = this.verticalWrapMin;
        if (r0 != null) goto L5;
    L8:
        this.verticalWrapMin = new WeakReference(r3);
        return;
    L5:
        if (r0.get() == null) goto L8;
        if (r3.getFinalValue() > this.verticalWrapMin.get().getFinalValue()) goto L8;
    }

    public void defineTerminalWidgets() {
        this.mDependencyGraph.defineTerminalWidgets(getHorizontalDimensionBehaviour(), getVerticalDimensionBehaviour());
    }

    public boolean directMeasure(boolean r1) {
        return this.mDependencyGraph.directMeasure(r1);
    }

    public boolean directMeasureSetup(boolean r1) {
        return this.mDependencyGraph.directMeasureSetup(r1);
    }

    public boolean directMeasureWithOrientation(boolean r1, int r2) {
        return this.mDependencyGraph.directMeasureWithOrientation(r1, r2);
    }

    public void fillMetrics(Metrics r1) {
        this.mMetrics = r1;
        this.mSystem.fillMetrics(r1);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> r0 = new ArrayList();
        int r1 = this.mChildren.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        ConstraintWidget r3 = this.mChildren.get(r2);
        if ((r3 instanceof Guideline) == false) goto L9;
        Guideline r4 = (Guideline) r3;
        if (r4.getOrientation() != 0) goto L9;
        r0.add(r4);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    public BasicMeasure.Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void getSceneString(StringBuilder r4) {
        r4.append(this.stringId + ":{\n");
        StringBuilder r0 = new StringBuilder("  actualWidth:");
        r0.append(this.mWidth);
        r4.append(r0.toString());
        r4.append("\n");
        r4.append("  actualHeight:" + this.mHeight);
        r4.append("\n");
        Iterator<ConstraintWidget> r3 = getChildren().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().getSceneString(r4);
        r4.append(",\n");
        goto L4
    L6:
        r4.append("}");
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> r0 = new ArrayList();
        int r1 = this.mChildren.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        ConstraintWidget r3 = this.mChildren.get(r2);
        if ((r3 instanceof Guideline) == false) goto L9;
        Guideline r4 = (Guideline) r3;
        if (r4.getOrientation() != 1) goto L9;
        r0.add(r4);
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return r0;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // androidx.constraintlayout.core.widgets.WidgetContainer
    public void layout() {
        int r2 = 0;
        this.mX = 0;
        this.mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        int r3 = this.mChildren.size();
        int r0 = Math.max(0, getWidth());
        int r4 = Math.max(0, getHeight());
        ConstraintWidget.DimensionBehaviour[] r5 = this.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour r7 = r5[1];
        ConstraintWidget.DimensionBehaviour r6 = r5[0];
        Metrics r8 = this.mMetrics;
        if (r8 == null) goto L6;
        r8.layouts++;
    L6:
        if (this.pass != 0) goto L32;
        if (Optimizer.enabled(this.mOptimizationLevel, 1) == false) goto L32;
        Direct.solvingPass(this, getMeasurer());
        int r9 = 0;
    L10:
        if (r9 >= r3) goto L32;
        ConstraintWidget r10 = this.mChildren.get(r9);
        if (r10.isMeasureRequested() == false) goto L30;
        if ((r10 instanceof Guideline) == true) goto L30;
        if ((r10 instanceof Barrier) == true) goto L30;
        if ((r10 instanceof VirtualLayout) == true) goto L30;
        if (r10.isInVirtualLayout() == true) goto L30;
        ConstraintWidget.DimensionBehaviour r11 = r10.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour r12 = r10.getDimensionBehaviour(1);
        ConstraintWidget.DimensionBehaviour r13 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r11 == r13) goto L24;
    L29:
        measure(0, r10, this.mMeasurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        goto L30
    L24:
        if (r10.mMatchConstraintDefaultWidth == 1) goto L29;
        if (r12 != r13) goto L29;
        if (r10.mMatchConstraintDefaultHeight == 1) goto L29;
    L30:
        r9 = r9 + 1;
    L32:
        if (r3 <= 2) goto L53;
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r6 == r14) goto L37;
        if (r7 != r14) goto L53;
    L37:
        if (Optimizer.enabled(this.mOptimizationLevel, 1024) == false) goto L53;
        if (Grouping.simpleSolvingPass(this, getMeasurer()) == false) goto L53;
        if (r6 == r14) goto L42;
    L46:
        if (r7 == r14) goto L48;
    L52:
        int r15 = r4;
        int r16 = r0;
        boolean r1 = true;
    L55:
        if (optimizeFor(64) == false) goto L57;
    L60:
        boolean r17 = true;
    L61:
        LinearSystem r18 = this.mSystem;
        r18.graphOptimizer = false;
        r18.newgraphOptimizer = false;
        if (this.mOptimizationLevel == 0) goto L65;
        if (r17 == false) goto L65;
        r18.newgraphOptimizer = true;
    L65:
        ArrayList<ConstraintWidget> r19 = this.mChildren;
        ConstraintWidget.DimensionBehaviour r110 = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r110 != r111) goto L68;
    L71:
        boolean r112 = true;
    L72:
        resetChains();
        int r113 = 0;
    L73:
        if (r113 >= r3) goto L78;
        ConstraintWidget r114 = this.mChildren.get(r113);
        if ((r114 instanceof WidgetContainer) == false) goto L77;
        ((WidgetContainer) r114).layout();
    L77:
        r113 = r113 + 1;
        goto L73
    L78:
        boolean r115 = optimizeFor(64);
        ?? r116 = r1;
        int r20 = 0;
        boolean r117 = true;
    L79:
        if (r117 == false) goto L159;
        int r118 = r20 + 1;
        this.mSystem.reset();     // Catch: Exception -> L84
        resetChains();     // Catch: Exception -> L84
        createObjectVariables(this.mSystem);     // Catch: Exception -> L84
        int r21 = r2;
    L82:
        if (r21 >= r3) goto L86;
        this.mChildren.get(r21).createObjectVariables(this.mSystem);     // Catch: Exception -> L84
        r21 = r21 + 1;     // Catch: Exception -> L84
        goto L82
    L86:
        r117 = addChildrenToSolver(this.mSystem);     // Catch: Exception -> L84
        WeakReference<ConstraintAnchor> r22 = this.verticalWrapMin;     // Catch: Exception -> L84
        if (r22 != null) goto L89;
    L91:
        WeakReference<ConstraintAnchor> r23 = this.verticalWrapMax;     // Catch: Exception -> L84
        if (r23 != null) goto L94;
    L96:
        WeakReference<ConstraintAnchor> r24 = this.horizontalWrapMin;     // Catch: Exception -> L84
        if (r24 != null) goto L99;
    L101:
        WeakReference<ConstraintAnchor> r25 = this.horizontalWrapMax;     // Catch: Exception -> L84
        if (r25 != null) goto L104;
    L106:
        if (r117 == false) goto L110;
        this.mSystem.minimize();     // Catch: Exception -> L84
    L110:
        if (r117 == false) goto L112;
        boolean r26 = updateChildrenFromSolver(this.mSystem, Optimizer.flags);
    L117:
        if (r112 == false) goto L133;
        if (r118 >= 8) goto L133;
        if (Optimizer.flags[2] == false) goto L133;
        int r27 = 0;
        int r28 = 0;
        int r119 = 0;
    L122:
        if (r27 >= r3) goto L124;
        ConstraintWidget r29 = this.mChildren.get(r27);
        boolean r120 = r26;
        r119 = Math.max(r119, r29.getWidth() + r29.mX);
        r28 = Math.max(r28, r29.getHeight() + r29.mY);
        r27 = r27 + 1;
        r26 = r120;
        goto L122
    L124:
        boolean r121 = r26;
        int r30 = Math.max(this.mMinWidth, r119);
        int r31 = Math.max(this.mMinHeight, r28);
        ConstraintWidget.DimensionBehaviour r32 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r116 = r116;
        if (r6 != r32) goto L129;
        r116 = r116;
        if (getWidth() >= r30) goto L129;
        setWidth(r30);
        this.mListDimensionBehaviors[0] = r32;
        r116 = 1;
        r121 = true;
    L129:
        if (r7 == r32) goto L131;
    L134:
        int r33 = Math.max(this.mMinWidth, getWidth());
        ?? r122 = r116;
        if (r33 <= getWidth()) goto L137;
        setWidth(r33);
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        r122 = 1;
        r121 = true;
    L137:
        int r34 = Math.max(this.mMinHeight, getHeight());
        if (r34 <= getHeight()) goto L140;
        setHeight(r34);
        ?? r35 = 1;
        this.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        ?? r36 = 1;
        r121 = true;
    L141:
        if (r36 != 0) goto L154;
        ConstraintWidget.DimensionBehaviour r37 = this.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour r123 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r36 = r36;
        r36 = r36;
        if (r37 != r123) goto L149;
        if (r16 <= 0) goto L149;
        r36 = r36;
        if (getWidth() <= r16) goto L149;
        this.mWidthMeasuredTooSmall = r35;
        this.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        setWidth(r16);
        ?? r38 = r35;
        r121 = r38 == true ? 1 : 0;
        r36 = r38;
    L149:
        if (this.mListDimensionBehaviors[r35] != r123) goto L154;
        if (r15 <= 0) goto L154;
        if (getHeight() <= r15) goto L154;
        this.mHeightMeasuredTooSmall = r35;
        this.mListDimensionBehaviors[r35] = ConstraintWidget.DimensionBehaviour.FIXED;
        setHeight(r15);
        int r39 = 8;
        boolean r40 = true;
        ?? r124 = 1;
    L155:
        if (r118 <= r39) goto L157;
        r117 = false;
    L158:
        r20 = r118;
        r2 = 0;
        r116 = r124;
        goto L79
    L157:
        r117 = r40;
    L154:
        r124 = r36;
        r40 = r121;
        r39 = 8;
        goto L155
    L140:
        r35 = 1;
        r36 = r122;
        goto L141
    L131:
        if (getHeight() >= r31) goto L134;
        setHeight(r31);
        this.mListDimensionBehaviors[1] = r32;
        r116 = 1;
        r121 = true;
    L133:
        r121 = r26;
        goto L134
    L112:
        updateFromSolver(this.mSystem, r115);
        int r41 = 0;
    L113:
        if (r41 >= r3) goto L115;
        this.mChildren.get(r41).updateFromSolver(this.mSystem, r115);
        r41 = r41 + 1;
        goto L113
    L115:
        r26 = false;
        goto L117
    L104:
        if (r25.get() == null) goto L106;
        addMaxWrap(this.horizontalWrapMax.get(), this.mSystem.createObjectVariable(this.mRight));     // Catch: Exception -> L84
        this.horizontalWrapMax = null;     // Catch: Exception -> L84
        goto L106
    L99:
        if (r24.get() == null) goto L101;
        addMinWrap(this.horizontalWrapMin.get(), this.mSystem.createObjectVariable(this.mLeft));     // Catch: Exception -> L84
        this.horizontalWrapMin = null;     // Catch: Exception -> L84
        goto L101
    L94:
        if (r23.get() == null) goto L96;
        addMaxWrap(this.verticalWrapMax.get(), this.mSystem.createObjectVariable(this.mBottom));     // Catch: Exception -> L84
        this.verticalWrapMax = null;     // Catch: Exception -> L84
        goto L96
    L89:
        if (r22.get() == null) goto L91;
        addMinWrap(this.verticalWrapMin.get(), this.mSystem.createObjectVariable(this.mTop));     // Catch: Exception -> L84
        this.verticalWrapMin = null;     // Catch: Exception -> L84
    L84:
        e = move-exception;
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        goto L110
    L159:
        this.mChildren = r19;
        if (r116 == 0) goto L162;
        ConstraintWidget.DimensionBehaviour[] r42 = this.mListDimensionBehaviors;
        r42[0] = r6;
        r42[1] = r7;
    L162:
        resetSolverVariables(this.mSystem.getCache());
        return;
    L68:
        if (getVerticalDimensionBehaviour() == r111) goto L71;
        r112 = false;
        goto L72
    L57:
        if (optimizeFor(128) == true) goto L60;
        r17 = false;
        goto L61
    L48:
        if (r4 >= getHeight()) goto L51;
        if (r4 <= 0) goto L51;
        setHeight(r4);
        this.mHeightMeasuredTooSmall = true;
    L51:
        r4 = getHeight();
        goto L52
    L42:
        if (r0 >= getWidth()) goto L45;
        if (r0 <= 0) goto L45;
        setWidth(r0);
        this.mWidthMeasuredTooSmall = true;
    L45:
        r0 = getWidth();
    L53:
        r15 = r4;
        r16 = r0;
        r1 = false;
        goto L55
    }

    public long measure(int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20) {
        this.mPaddingLeft = r19;
        this.mPaddingTop = r20;
        return this.mBasicMeasureSolver.solverMeasure(this, r12, r19, r20, r13, r14, r15, r16, r17, r18);
    }

    public boolean optimizeFor(int r1) {
        if ((this.mOptimizationLevel & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.WidgetContainer, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure.Measurer r1) {
        this.mMeasurer = r1;
        this.mDependencyGraph.setMeasurer(r1);
    }

    public void setOptimizationLevel(int r1) {
        this.mOptimizationLevel = r1;
        LinearSystem.USE_DEPENDENCY_ORDERING = optimizeFor(512);
    }

    public void setPadding(int r1, int r2, int r3, int r4) {
        this.mPaddingLeft = r1;
        this.mPaddingTop = r2;
        this.mPaddingRight = r3;
        this.mPaddingBottom = r4;
    }

    public void setPass(int r1) {
        this.pass = r1;
    }

    public void setRtl(boolean r1) {
        this.mIsRtl = r1;
    }

    public boolean updateChildrenFromSolver(LinearSystem r5, boolean[] r6) {
        int r1 = 0;
        r6[2] = false;
        boolean r7 = optimizeFor(64);
        updateFromSolver(r5, r7);
        int r0 = this.mChildren.size();
        boolean r2 = false;
    L3:
        if (r1 >= r0) goto L8;
        ConstraintWidget r3 = this.mChildren.get(r1);
        r3.updateFromSolver(r5, r7);
        if (r3.hasDimensionOverride() == false) goto L7;
        r2 = true;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void updateFromRuns(boolean r4, boolean r5) {
        super.updateFromRuns(r4, r5);
        int r0 = this.mChildren.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildren.get(r1).updateFromRuns(r4, r5);
        r1 = r1 + 1;
        goto L3
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }

    public static boolean measure(int r5, ConstraintWidget r6, BasicMeasure.Measurer r7, BasicMeasure.Measure r8, int r9) {
        if (r7 != null) goto L6;
        return false;
    L6:
        if (r6.getVisibility() != 8) goto L8;
    L87:
        r8.measuredWidth = 0;
        r8.measuredHeight = 0;
        return false;
    L8:
        if ((r6 instanceof Guideline) == true) goto L87;
        if ((r6 instanceof Barrier) == true) goto L87;
        r8.horizontalBehavior = r6.getHorizontalDimensionBehaviour();
        r8.verticalBehavior = r6.getVerticalDimensionBehaviour();
        r8.horizontalDimension = r6.getWidth();
        r8.verticalDimension = r6.getHeight();
        r8.measuredNeedsSolverPass = false;
        r8.measureStrategy = r9;
        ConstraintWidget.DimensionBehaviour r10 = r8.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r0 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r10 != r0) goto L15;
        boolean r11 = true;
    L17:
        if (r8.verticalBehavior != r0) goto L19;
        boolean r1 = true;
    L21:
        if (r11 == true) goto L23;
    L25:
        boolean r3 = false;
    L26:
        if (r1 == true) goto L28;
    L30:
        boolean r2 = false;
    L31:
        if (r11 == true) goto L33;
    L43:
        if (r1 == false) goto L56;
        if (r6.hasDanglingDimension(1) == false) goto L56;
        if (r6.mMatchConstraintDefaultHeight != 0) goto L56;
        if (r2 == true) goto L56;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r11 == true) goto L52;
    L54:
        r1 = false;
        goto L56
    L52:
        if (r6.mMatchConstraintDefaultWidth != 0) goto L54;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
    L56:
        if (r6.isResolvedHorizontally() == false) goto L59;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r11 = false;
    L59:
        if (r6.isResolvedVertically() == false) goto L62;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        r1 = false;
    L62:
        if (r3 == true) goto L64;
    L72:
        if (r2 == true) goto L74;
    L85:
        r7.measure(r6, r8);
        r6.setWidth(r8.measuredWidth);
        r6.setHeight(r8.measuredHeight);
        r6.setHasBaseline(r8.measuredHasBaseline);
        r6.setBaselineDistance(r8.measuredBaseline);
        r8.measureStrategy = BasicMeasure.Measure.SELF_DIMENSIONS;
        return r8.measuredNeedsSolverPass;
    L74:
        if (r6.mResolvedMatchConstraintDefault[1] != 4) goto L76;
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L85
    L76:
        if (r11 == true) goto L85;
        ConstraintWidget.DimensionBehaviour r12 = r8.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour r13 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r12 != r13) goto L80;
        int r14 = r8.horizontalDimension;
    L81:
        r8.verticalBehavior = r13;
        if (r6.getDimensionRatioSide() != (-1)) goto L84;
        r8.verticalDimension = (int) (r14 / r6.getDimensionRatio());
        goto L85
    L84:
        r8.verticalDimension = (int) (r6.getDimensionRatio() * r14);
        goto L85
    L80:
        r8.verticalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r7.measure(r6, r8);
        r14 = r8.measuredWidth;
        goto L81
    L64:
        if (r6.mResolvedMatchConstraintDefault[0] != 4) goto L66;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L72
    L66:
        if (r1 == true) goto L72;
        ConstraintWidget.DimensionBehaviour r15 = r8.verticalBehavior;
        ConstraintWidget.DimensionBehaviour r4 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r15 != r4) goto L70;
        int r16 = r8.verticalDimension;
    L71:
        r8.horizontalBehavior = r4;
        r8.horizontalDimension = (int) (r6.getDimensionRatio() * r16);
        goto L72
    L70:
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        r7.measure(r6, r8);
        r16 = r8.measuredHeight;
        goto L71
    L33:
        if (r6.hasDanglingDimension(0) == false) goto L43;
        if (r6.mMatchConstraintDefaultWidth != 0) goto L43;
        if (r3 == true) goto L43;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r1 == true) goto L40;
    L42:
        r11 = false;
        goto L43
    L40:
        if (r6.mMatchConstraintDefaultHeight != 0) goto L42;
        r8.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L42
    L28:
        if (r6.mDimensionRatio <= 0.0f) goto L30;
        r2 = true;
        goto L31
    L23:
        if (r6.mDimensionRatio <= 0.0f) goto L25;
        r3 = true;
        goto L26
    L19:
        r1 = false;
        goto L21
    L15:
        r11 = false;
        goto L17
    }

    public ConstraintWidgetContainer(int r1, int r2, int r3, int r4) {
        super(r1, r2, r3, r4);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(int r3, int r4) {
        super(r3, r4);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
    }

    public ConstraintWidgetContainer(String r3, int r4, int r5) {
        super(r4, r5);
        this.mBasicMeasureSolver = new BasicMeasure(this);
        this.mDependencyGraph = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        this.mSystem = new LinearSystem();
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        this.mVerticalChainsArray = new ChainHead[4];
        this.mHorizontalChainsArray = new ChainHead[4];
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.widgetsToAdd = new HashSet();
        this.mMeasure = new BasicMeasure.Measure();
        setDebugName(r3);
    }
}
