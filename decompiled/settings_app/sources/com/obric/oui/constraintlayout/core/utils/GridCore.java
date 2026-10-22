package com.obric.oui.constraintlayout.core.utils;

import com.obric.oui.constraintlayout.core.LinearSystem;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.obric.oui.constraintlayout.core.widgets.VirtualLayout;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class GridCore extends VirtualLayout {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int SPANS_RESPECT_WIDGET_ORDER = 2;
    public static final int SUB_GRID_BY_COL_ROW = 1;
    public static final int VERTICAL = 1;
    private ConstraintWidget[] mBoxWidgets;
    private String mColumnWeights;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    ConstraintWidgetContainer mContainer;
    private boolean mExtraSpaceHandled;
    private int mFlags;
    private float mHorizontalGaps;
    private int mNextAvailableIndex;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private String mRowWeights;
    private int mRows;
    private int mRowsSet;
    private String mSkips;
    Set<String> mSpanIds;
    private int mSpanIndex;
    private int[][] mSpanMatrix;
    private String mSpans;
    private float mVerticalGaps;

    public GridCore() {
        this.mExtraSpaceHandled = false;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
        this.mSpanIndex = 0;
        updateActualRowsAndColumns();
        initMatrices();
    }

    public GridCore(int r3, int r4) {
        this.mExtraSpaceHandled = false;
        this.mNextAvailableIndex = 0;
        this.mSpanIds = new HashSet();
        this.mSpanIndex = 0;
        this.mRowsSet = r3;
        this.mColumnsSet = r4;
        if (r3 <= 50) goto L5;
        this.mRowsSet = 3;
    L5:
        if (r4 <= 50) goto L7;
        this.mColumnsSet = 3;
    L7:
        updateActualRowsAndColumns();
        initMatrices();
    }

    public ConstraintWidgetContainer getContainer() {
        return this.mContainer;
    }

    public void setContainer(ConstraintWidgetContainer r1) {
        this.mContainer = r1;
    }

    public void setSpans(CharSequence r3) {
        String r0 = this.mSpans;
        if (r0 != null) goto L5;
    L7:
        this.mExtraSpaceHandled = false;
        this.mSpans = r3.toString();
        return;
    L5:
        if (r0.equals(r3.toString()) == false) goto L7;
    }

    public void setSkips(String r2) {
        String r0 = this.mSkips;
        if (r0 != null) goto L5;
    L7:
        this.mExtraSpaceHandled = false;
        this.mSkips = r2;
        return;
    L5:
        if (r0.equals(r2) == false) goto L7;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public void setHorizontalGaps(float r2) {
        if (r2 >= 0.0f) goto L6;
        return;
    L6:
        if (this.mHorizontalGaps != r2) goto L8;
        return;
    L8:
        this.mHorizontalGaps = r2;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    public void setVerticalGaps(float r2) {
        if (r2 >= 0.0f) goto L6;
        return;
    L6:
        if (this.mVerticalGaps != r2) goto L8;
        return;
    L8:
        this.mVerticalGaps = r2;
    }

    public String getRowWeights() {
        return this.mRowWeights;
    }

    public void setRowWeights(String r2) {
        String r0 = this.mRowWeights;
        if (r0 != null) goto L5;
    L7:
        this.mRowWeights = r2;
        return;
    L5:
        if (r0.equals(r2) == false) goto L7;
    }

    public String getColumnWeights() {
        return this.mColumnWeights;
    }

    public void setColumnWeights(String r2) {
        String r0 = this.mColumnWeights;
        if (r0 != null) goto L5;
    L7:
        this.mColumnWeights = r2;
        return;
    L5:
        if (r0.equals(r2) == false) goto L7;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int r2) {
        if (r2 == 0) goto L7;
        if (r2 == 1) goto L7;
        return;
    L7:
        if (this.mOrientation != r2) goto L9;
        return;
    L9:
        this.mOrientation = r2;
    }

    public void setRows(int r2) {
        if (r2 <= 50) goto L6;
        return;
    L6:
        if (this.mRowsSet != r2) goto L8;
        return;
    L8:
        this.mRowsSet = r2;
        updateActualRowsAndColumns();
        initVariables();
    }

    public void setColumns(int r2) {
        if (r2 <= 50) goto L6;
        return;
    L6:
        if (this.mColumnsSet != r2) goto L8;
        return;
    L8:
        this.mColumnsSet = r2;
        updateActualRowsAndColumns();
        initVariables();
    }

    public int getFlags() {
        return this.mFlags;
    }

    public void setFlags(int r1) {
        this.mFlags = r1;
    }

    private void handleSpans(int[][] r10) {
        if (isSpansRespectWidgetOrder() == false) goto L5;
        return;
    L5:
        int r1 = 0;
    L7:
        if (r1 >= r10.length) goto L12;
        int r5 = getRowByIndex(r10[r1][0]);
        int r6 = getColByIndex(r10[r1][0]);
        int[] r2 = r10[r1];
        if (invalidatePositions(r5, r6, r2[1], r2[2]) == false) goto L10;
        ConstraintWidget r4 = this.mWidgets[r1];
        int[] r3 = r10[r1];
        connectWidget(r4, r5, r6, r3[1], r3[2]);
        this.mSpanIds.add(this.mWidgets[r1].stringId);
        r1 = r1 + 1;
        goto L7
    L10:
        return;
    }

    private void arrangeWidgets() {
        int r1 = 0;
    L4:
        if (r1 >= this.mWidgetsCount) goto L25;
        if (this.mSpanIds.contains(this.mWidgets[r1].stringId) == true) goto L24;
        int r2 = getNextPosition();
        int r5 = getRowByIndex(r2);
        int r6 = getColByIndex(r2);
        if (r2 == (-1)) goto L10;
        if (isSpansRespectWidgetOrder() == false) goto L23;
        int[][] r3 = this.mSpanMatrix;
        if (r3 == null) goto L23;
        int r4 = this.mSpanIndex;
        if (r4 >= r3.length) goto L23;
        int[] r7 = r3[r4];
        if (r7[0] != r2) goto L23;
        this.mPositionMatrix[r5][r6] = true;
        if (invalidatePositions(r5, r6, r7[1], r7[2]) == false) goto L24;
        ConstraintWidget r8 = this.mWidgets[r1];
        int[] r9 = this.mSpanMatrix[this.mSpanIndex];
        connectWidget(r8, r5, r6, r9[1], r9[2]);
        this.mSpanIndex++;
    L23:
        connectWidget(this.mWidgets[r1], r5, r6, 1, 1);
        goto L24
    L10:
        return;
    L24:
        r1 = r1 + 1;
        goto L4
    }

    private void setupGrid(boolean r6) {
        if (this.mRows >= 1) goto L5;
        return;
    L5:
        if (this.mColumns >= 1) goto L8;
        return;
    L8:
        if (r6 == false) goto L18;
        int r7 = 0;
    L11:
        if (r7 >= this.mPositionMatrix.length) goto L17;
        int r2 = 0;
    L13:
        boolean[][] r3 = this.mPositionMatrix;
        if (r2 >= r3[0].length) goto L16;
        r3[r7][r2] = true;
        r2 = r2 + 1;
        goto L13
    L16:
        r7 = r7 + 1;
        goto L11
    L17:
        this.mSpanIds.clear();
    L18:
        this.mNextAvailableIndex = 0;
        String r8 = this.mSkips;
        if (r8 != null) goto L21;
    L25:
        String r9 = this.mSpans;
        if (r9 != null) goto L28;
    L30:
        createBoxes();
        int[][] r10 = this.mSpanMatrix;
        if (r10 == null) goto L37;
        handleSpans(r10);
        return;
    L37:
        return;
    L28:
        if (r9.trim().isEmpty() == true) goto L30;
        this.mSpanMatrix = parseSpans(this.mSpans, true);
        goto L30
    L21:
        if (r8.trim().isEmpty() == true) goto L25;
        int[][] r11 = parseSpans(this.mSkips, false);
        if (r11 == null) goto L25;
        handleSkips(r11);
        goto L25
    }

    private int getRowByIndex(int r3) {
        if (this.mOrientation != 1) goto L7;
        return r3 % this.mRows;
    L7:
        return r3 / this.mColumns;
    }

    private int getColByIndex(int r3) {
        if (this.mOrientation != 1) goto L7;
        return r3 / this.mRows;
    L7:
        return r3 % this.mColumns;
    }

    private void handleSkips(int[][] r9) {
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        int[] r3 = r9[r2];
        if (invalidatePositions(getRowByIndex(r3[0]), getColByIndex(r3[0]), r3[1], r3[2]) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return;
    }

    private boolean invalidatePositions(int r6, int r7, int r8, int r9) {
        int r0 = r6;
    L4:
        if (r0 >= (r6 + r8)) goto L18;
        int r1 = r7;
    L7:
        if (r1 >= (r7 + r9)) goto L17;
        boolean[][] r2 = this.mPositionMatrix;
        if (r0 >= r2.length) goto L16;
        if (r1 >= r2[0].length) goto L16;
        boolean[] r3 = r2[r0];
        if (r3[r1] == false) goto L16;
        r3[r1] = false;
        r1 = r1 + 1;
    L16:
        return false;
    L17:
        r0 = r0 + 1;
        goto L4
    L18:
        return true;
    }

    private float[] parseWeights(int r7, String r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.trim().isEmpty() == true) goto L25;
        String[] r6 = r8.split(",");
        float[] r9 = new float[r7];
        int r0 = 0;
    L7:
        if (r0 >= r7) goto L16;
        if (r0 < r6.length) goto L19;
        r9[r0] = 1.0f;
    L15:
        r0 = r0 + 1;
        goto L7
    L19:
        r9[r0] = Float.parseFloat(r6[r0]);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        System.err.println("Error parsing `" + r6[r0] + "`: " + e.getMessage());
        r9[r0] = 1.0f;
        goto L15
    L16:
        return r9;
    L25:
        return null;
    }

    private int getNextPosition() {
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r1 == true) goto L12;
        r2 = this.mNextAvailableIndex;
        if (r2 >= (this.mRows * this.mColumns)) goto L6;
        int r3 = getRowByIndex(r2);
        int r4 = getColByIndex(this.mNextAvailableIndex);
        boolean[] r5 = this.mPositionMatrix[r3];
        if (r5[r4] == false) goto L11;
        r5[r4] = false;
        r1 = true;
    L11:
        this.mNextAvailableIndex++;
        goto L3
    L6:
        return -1;
    L12:
        return r2;
    }

    private void updateActualRowsAndColumns() {
        int r0 = this.mRowsSet;
        if (r0 == 0) goto L8;
        int r1 = this.mColumnsSet;
        if (r1 == 0) goto L8;
        this.mRows = r0;
        this.mColumns = r1;
        return;
    L8:
        int r2 = this.mColumnsSet;
        if (r2 <= 0) goto L11;
        this.mColumns = r2;
        this.mRows = ((this.mWidgetsCount + this.mColumns) - 1) / this.mColumnsSet;
        return;
    L11:
        if (r0 <= 0) goto L13;
        this.mRows = r0;
        int r3 = this.mWidgetsCount;
        int r4 = this.mRowsSet;
        this.mColumns = ((r3 + r4) - 1) / r4;
        return;
    L13:
        this.mRows = (int) (Math.sqrt(this.mWidgetsCount) + 1.5d);
        int r5 = this.mWidgetsCount;
        int r6 = this.mRows;
        this.mColumns = ((r5 + r6) - 1) / r6;
    }

    private ConstraintWidget makeNewWidget() {
        ConstraintWidget r3 = new ConstraintWidget();
        r3.mListDimensionBehaviors[0] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        r3.mListDimensionBehaviors[1] = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        r3.stringId = String.valueOf(r3.hashCode());
        return r3;
    }

    private void connectWidget(ConstraintWidget r4, int r5, int r6, int r7, int r8) {
        r4.mLeft.connect(this.mBoxWidgets[r6].mLeft, 0);
        r4.mTop.connect(this.mBoxWidgets[r5].mTop, 0);
        r4.mRight.connect(this.mBoxWidgets[(r6 + r8) - 1].mRight, 0);
        r4.mBottom.connect(this.mBoxWidgets[(r5 + r7) - 1].mBottom, 0);
    }

    private void setBoxWidgetHorizontalChains() {
        int r0 = Math.max(this.mRows, this.mColumns);
        ConstraintWidget r1 = this.mBoxWidgets[0];
        float[] r3 = parseWeights(this.mColumns, this.mColumnWeights);
        if (this.mColumns != 1) goto L6;
        clearHorizontalAttributes(r1);
        r1.mLeft.connect(this.mLeft, 0);
        r1.mRight.connect(this.mRight, 0);
        return;
    L6:
        int r2 = 0;
    L7:
        int r4 = this.mColumns;
        if (r2 >= r4) goto L22;
        ConstraintWidget r5 = this.mBoxWidgets[r2];
        clearHorizontalAttributes(r5);
        if (r3 == null) goto L12;
        r5.setHorizontalWeight(r3[r2]);
    L12:
        if (r2 <= 0) goto L14;
        r5.mLeft.connect(this.mBoxWidgets[r2 - 1].mRight, 0);
    L16:
        if (r2 >= (this.mColumns - 1)) goto L18;
        r5.mRight.connect(this.mBoxWidgets[r2 + 1].mLeft, 0);
    L19:
        if (r2 <= 0) goto L21;
        r5.mLeft.mMargin = (int) this.mHorizontalGaps;
    L21:
        r2 = r2 + 1;
        goto L7
    L18:
        r5.mRight.connect(this.mRight, 0);
        goto L19
    L14:
        r5.mLeft.connect(this.mLeft, 0);
    L22:
        if (r4 >= r0) goto L24;
        ConstraintWidget r6 = this.mBoxWidgets[r4];
        clearHorizontalAttributes(r6);
        r6.mLeft.connect(this.mLeft, 0);
        r6.mRight.connect(this.mRight, 0);
        r4 = r4 + 1;
        goto L22
    }

    private void setBoxWidgetVerticalChains() {
        int r0 = Math.max(this.mRows, this.mColumns);
        ConstraintWidget r1 = this.mBoxWidgets[0];
        float[] r3 = parseWeights(this.mRows, this.mRowWeights);
        if (this.mRows != 1) goto L6;
        clearVerticalAttributes(r1);
        r1.mTop.connect(this.mTop, 0);
        r1.mBottom.connect(this.mBottom, 0);
        return;
    L6:
        int r2 = 0;
    L7:
        int r4 = this.mRows;
        if (r2 >= r4) goto L22;
        ConstraintWidget r5 = this.mBoxWidgets[r2];
        clearVerticalAttributes(r5);
        if (r3 == null) goto L12;
        r5.setVerticalWeight(r3[r2]);
    L12:
        if (r2 <= 0) goto L14;
        r5.mTop.connect(this.mBoxWidgets[r2 - 1].mBottom, 0);
    L16:
        if (r2 >= (this.mRows - 1)) goto L18;
        r5.mBottom.connect(this.mBoxWidgets[r2 + 1].mTop, 0);
    L19:
        if (r2 <= 0) goto L21;
        r5.mTop.mMargin = (int) this.mVerticalGaps;
    L21:
        r2 = r2 + 1;
        goto L7
    L18:
        r5.mBottom.connect(this.mBottom, 0);
        goto L19
    L14:
        r5.mTop.connect(this.mTop, 0);
    L22:
        if (r4 >= r0) goto L24;
        ConstraintWidget r6 = this.mBoxWidgets[r4];
        clearVerticalAttributes(r6);
        r6.mTop.connect(this.mTop, 0);
        r6.mBottom.connect(this.mBottom, 0);
        r4 = r4 + 1;
        goto L22
    }

    private void addConstraints() {
        setBoxWidgetVerticalChains();
        setBoxWidgetHorizontalChains();
        arrangeWidgets();
    }

    private void createBoxes() {
        int r0 = Math.max(this.mRows, this.mColumns);
        ConstraintWidget[] r1 = this.mBoxWidgets;
        int r2 = 0;
        if (r1 != null) goto L9;
        this.mBoxWidgets = new ConstraintWidget[r0];
    L5:
        ConstraintWidget[] r3 = this.mBoxWidgets;
        if (r2 >= r3.length) goto L28;
        r3[r2] = makeNewWidget();
        r2 = r2 + 1;
        goto L5
    L28:
        return;
    L9:
        if (r0 == r1.length) goto L27;
        ConstraintWidget[] r4 = new ConstraintWidget[r0];
    L11:
        if (r2 >= r0) goto L17;
        ConstraintWidget[] r5 = this.mBoxWidgets;
        if (r2 >= r5.length) goto L15;
        r4[r2] = r5[r2];
    L16:
        r2 = r2 + 1;
        goto L11
    L15:
        r4[r2] = makeNewWidget();
    L17:
        ConstraintWidget[] r6 = this.mBoxWidgets;
        if (r0 >= r6.length) goto L20;
        ConstraintWidget r7 = r6[r0];
        this.mContainer.remove(r7);
        r0 = r0 + 1;
        goto L17
    L20:
        this.mBoxWidgets = r4;
        return;
    }

    private void clearVerticalAttributes(ConstraintWidget r1) {
        r1.setVerticalWeight(-1.0f);
        r1.mTop.reset();
        r1.mBottom.reset();
        r1.mBaseline.reset();
    }

    private void clearHorizontalAttributes(ConstraintWidget r1) {
        r1.setHorizontalWeight(-1.0f);
        r1.mLeft.reset();
        r1.mRight.reset();
    }

    private void initVariables() {
        int r1 = 0;
        boolean[][] r0 = (boolean[][]) Array.newInstance(Boolean.TYPE, new int[]{this.mRows, this.mColumns});
        this.mPositionMatrix = r0;
        int r3 = r0.length;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L6;
        Arrays.fill(r0[r5], true);
        r5 = r5 + 1;
        goto L3
    L6:
        if (this.mWidgetsCount <= 0) goto L10;
        int[][] r2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{this.mWidgetsCount, 4});
        this.mConstraintMatrix = r2;
        int r7 = r2.length;
    L8:
        if (r1 >= r7) goto L13;
        Arrays.fill(r2[r1], -1);
        r1 = r1 + 1;
        goto L8
    L13:
        return;
    }

    private int[][] parseSpans(String r12, boolean r13) {
        String[] r14 = r12.split(",");     // Catch: Exception -> L40
        Arrays.sort(r14, new GridCore$$ExternalSyntheticLambda0());     // Catch: Exception -> L40
        int[][] r0 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{r14.length, 3});     // Catch: Exception -> L40
        if (this.mRows != 1) goto L6;
    L16:
        int r2 = 0;
        int r6 = 0;
        int r7 = 0;
    L18:
        if (r2 >= r14.length) goto L30;
        String[] r8 = r14[r2].trim().split(":");     // Catch: Exception -> L40
        r0[r2][0] = Integer.parseInt(r8[0]);     // Catch: Exception -> L40
        int[] r9 = r0[r2];     // Catch: Exception -> L40
        r9[1] = 1;     // Catch: Exception -> L40
        r9[2] = 1;     // Catch: Exception -> L40
        if (this.mColumns != 1) goto L25;
        r9[1] = Integer.parseInt(r8[1]);     // Catch: Exception -> L40
        r6 = r6 + r0[r2][1];     // Catch: Exception -> L40
        if (r13 == false) goto L25;
        r6 = r6 - 1;     // Catch: Exception -> L40
    L25:
        if (this.mRows != 1) goto L29;
        r0[r2][2] = Integer.parseInt(r8[1]);     // Catch: Exception -> L40
        r7 = r7 + r0[r2][2];     // Catch: Exception -> L40
        if (r13 == false) goto L29;
        r7 = r7 - 1;     // Catch: Exception -> L40
    L29:
        r2 = r2 + 1;     // Catch: Exception -> L40
        goto L18
    L30:
        if (r6 != 0) goto L32;
    L34:
        if (r7 != 0) goto L36;
    L38:
        this.mExtraSpaceHandled = true;     // Catch: Exception -> L40
    L39:
        return r0;
    L36:
        if (this.mExtraSpaceHandled == true) goto L38;
        setColumns(this.mColumns + r7);     // Catch: Exception -> L40
        goto L38
    L32:
        if (this.mExtraSpaceHandled == true) goto L34;
        setRows(this.mRows + r6);     // Catch: Exception -> L40
        goto L34
    L6:
        if (this.mColumns == 1) goto L16;
        int r15 = 0;
    L10:
        if (r15 >= r14.length) goto L39;
        String[] r3 = r14[r15].trim().split(":");     // Catch: Exception -> L40
        String[] r10 = r3[1].split(MaterialConfigFormatNames.X);     // Catch: Exception -> L40
        r0[r15][0] = Integer.parseInt(r3[0]);     // Catch: Exception -> L40
        if (isSubGridByColRow() == false) goto L14;
        r0[r15][1] = Integer.parseInt(r10[1]);     // Catch: Exception -> L40
        r0[r15][2] = Integer.parseInt(r10[0]);     // Catch: Exception -> L40
    L15:
        r15 = r15 + 1;     // Catch: Exception -> L40
        goto L10
    L14:
        r0[r15][1] = Integer.parseInt(r10[0]);     // Catch: Exception -> L40
        r0[r15][2] = Integer.parseInt(r10[1]);     // Catch: Exception -> L40
    L40:
        return null;
    }

    static /* synthetic */ int lambda$parseSpans$0(String r2, String r3) {
        return Integer.parseInt(r2.split(":")[0]) - Integer.parseInt(r3.split(":")[0]);
    }

    private void fillConstraintMatrix(boolean r6) {
        if (r6 == false) goto L20;
        int r7 = 0;
    L6:
        if (r7 >= this.mPositionMatrix.length) goto L12;
        int r2 = 0;
    L8:
        boolean[][] r3 = this.mPositionMatrix;
        if (r2 >= r3[0].length) goto L11;
        r3[r7][r2] = true;
        r2 = r2 + 1;
        goto L8
    L11:
        r7 = r7 + 1;
        goto L6
    L12:
        int r8 = 0;
    L14:
        if (r8 >= this.mConstraintMatrix.length) goto L20;
        int r4 = 0;
    L16:
        int[][] r5 = this.mConstraintMatrix;
        if (r4 >= r5[0].length) goto L19;
        r5[r8][r4] = -1;
        r4 = r4 + 1;
        goto L16
    L19:
        r8 = r8 + 1;
    L20:
        this.mNextAvailableIndex = 0;
        String r9 = this.mSkips;
        if (r9 != null) goto L23;
    L27:
        String r10 = this.mSpans;
        if (r10 != null) goto L30;
        return;
    L30:
        if (r10.trim().isEmpty() == true) goto L40;
        int[][] r11 = parseSpans(this.mSpans, true);
        if (r11 == null) goto L41;
        handleSpans(r11);
        return;
    L41:
        return;
    L40:
        return;
    L23:
        if (r9.trim().isEmpty() == true) goto L27;
        int[][] r12 = parseSpans(this.mSkips, false);
        if (r12 == null) goto L27;
        handleSkips(r12);
        goto L27
    }

    private void initMatrices() {
        int[][] r0 = this.mConstraintMatrix;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L13:
        if (r1 == true) goto L15;
        initVariables();
    L15:
        fillConstraintMatrix(r1);
        return;
    L5:
        if (r0.length != this.mWidgetsCount) goto L13;
        boolean[][] r2 = this.mPositionMatrix;
        if (r2 == null) goto L13;
        if (r2.length != this.mRows) goto L13;
        if (r2[0].length != this.mColumns) goto L13;
        r1 = true;
        goto L13
    }

    private boolean isSubGridByColRow() {
        if ((this.mFlags & 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isSpansRespectWidgetOrder() {
        if ((this.mFlags & 2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.VirtualLayout
    public void measure(int r1, int r2, int r3, int r4) {
        super.measure(r1, r2, r3, r4);
        this.mContainer = (ConstraintWidgetContainer) getParent();
        setupGrid(false);
        this.mContainer.add(this.mBoxWidgets);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem r1, boolean r2) {
        super.addToSolver(r1, r2);
        addConstraints();
    }
}
