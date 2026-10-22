package com.obric.oui.constraintlayout.core.state.helpers;

import com.obric.oui.constraintlayout.core.state.HelperReference;
import com.obric.oui.constraintlayout.core.state.State;
import com.obric.oui.constraintlayout.core.utils.GridCore;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;

/* JADX INFO: loaded from: classes4.dex */
public class GridReference extends HelperReference {
    private static final String SPANS_RESPECT_WIDGET_ORDER_STRING = "spansrespectwidgetorder";
    private static final String SUB_GRID_BY_COL_ROW_STRING = "subgridbycolrow";
    private String mColumnWeights;
    private int mColumnsSet;
    private int mFlags;
    private GridCore mGrid;
    private float mHorizontalGaps;
    private int mOrientation;
    private int mPaddingBottom;
    private int mPaddingEnd;
    private int mPaddingStart;
    private int mPaddingTop;
    private String mRowWeights;
    private int mRowsSet;
    private String mSkips;
    private String mSpans;
    private float mVerticalGaps;

    public GridReference(State r2, State.Helper r3) {
        super(r2, r3);
        this.mPaddingStart = 0;
        this.mPaddingEnd = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        if (r3 != State.Helper.ROW) goto L6;
        this.mRowsSet = 1;
        return;
    L6:
        if (r3 != State.Helper.COLUMN) goto L10;
        this.mColumnsSet = 1;
        return;
    }

    public int getPaddingStart() {
        return this.mPaddingStart;
    }

    public void setPaddingStart(int r1) {
        this.mPaddingStart = r1;
    }

    public int getPaddingEnd() {
        return this.mPaddingEnd;
    }

    public void setPaddingEnd(int r1) {
        this.mPaddingEnd = r1;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void setPaddingTop(int r1) {
        this.mPaddingTop = r1;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public void setPaddingBottom(int r1) {
        this.mPaddingBottom = r1;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public void setFlags(int r1) {
        this.mFlags = r1;
    }

    public void setFlags(String r5) {
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        String[] r6 = r5.split("\\|");
        int r0 = 0;
        this.mFlags = 0;
        int r1 = r6.length;
    L6:
        if (r0 >= r1) goto L15;
        String r2 = r6[r0].toLowerCase();
        r2.hashCode();
        if (r2.equals(SUB_GRID_BY_COL_ROW_STRING) == false) goto L10;
        this.mFlags |= 1;
    L14:
        r0 = r0 + 1;
        goto L6
    L10:
        if (r2.equals(SPANS_RESPECT_WIDGET_ORDER_STRING) == false) goto L14;
        this.mFlags |= 2;
        goto L14
    }

    public int getRowsSet() {
        return this.mRowsSet;
    }

    public void setRowsSet(int r3) {
        if (super.getType() != State.Helper.COLUMN) goto L5;
        return;
    L5:
        this.mRowsSet = r3;
    }

    public int getColumnsSet() {
        return this.mColumnsSet;
    }

    public void setColumnsSet(int r3) {
        if (super.getType() != State.Helper.ROW) goto L5;
        return;
    L5:
        this.mColumnsSet = r3;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public void setHorizontalGaps(float r1) {
        this.mHorizontalGaps = r1;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    public void setVerticalGaps(float r1) {
        this.mVerticalGaps = r1;
    }

    public String getRowWeights() {
        return this.mRowWeights;
    }

    public void setRowWeights(String r1) {
        this.mRowWeights = r1;
    }

    public String getColumnWeights() {
        return this.mColumnWeights;
    }

    public void setColumnWeights(String r1) {
        this.mColumnWeights = r1;
    }

    public String getSpans() {
        return this.mSpans;
    }

    public void setSpans(String r1) {
        this.mSpans = r1;
    }

    public String getSkips() {
        return this.mSkips;
    }

    public void setSkips(String r1) {
        this.mSkips = r1;
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference
    public HelperWidget getHelperWidget() {
        if (this.mGrid != null) goto L6;
        this.mGrid = new GridCore();
    L6:
        return this.mGrid;
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference
    public void setHelperWidget(HelperWidget r2) {
        if ((r2 instanceof GridCore) == false) goto L5;
        this.mGrid = (GridCore) r2;
        return;
    L5:
        this.mGrid = null;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int r1) {
        this.mOrientation = r1;
    }

    @Override // com.obric.oui.constraintlayout.core.state.HelperReference, com.obric.oui.constraintlayout.core.state.ConstraintReference, com.obric.oui.constraintlayout.core.state.Reference
    public void apply() {
        getHelperWidget();
        this.mGrid.setOrientation(this.mOrientation);
        int r0 = this.mRowsSet;
        if (r0 == 0) goto L5;
        this.mGrid.setRows(r0);
    L5:
        int r1 = this.mColumnsSet;
        if (r1 == 0) goto L8;
        this.mGrid.setColumns(r1);
    L8:
        float r2 = this.mHorizontalGaps;
        if (r2 == 0.0f) goto L11;
        this.mGrid.setHorizontalGaps(r2);
    L11:
        float r3 = this.mVerticalGaps;
        if (r3 == 0.0f) goto L14;
        this.mGrid.setVerticalGaps(r3);
    L14:
        String r4 = this.mRowWeights;
        if (r4 != null) goto L17;
    L19:
        String r5 = this.mColumnWeights;
        if (r5 != null) goto L22;
    L24:
        String r6 = this.mSpans;
        if (r6 != null) goto L27;
    L29:
        String r7 = this.mSkips;
        if (r7 != null) goto L32;
    L34:
        this.mGrid.setFlags(this.mFlags);
        this.mGrid.setPaddingStart(this.mPaddingStart);
        this.mGrid.setPaddingEnd(this.mPaddingEnd);
        this.mGrid.setPaddingTop(this.mPaddingTop);
        this.mGrid.setPaddingBottom(this.mPaddingBottom);
        applyBase();
        return;
    L32:
        if (r7.isEmpty() == true) goto L34;
        this.mGrid.setSkips(this.mSkips);
        goto L34
    L27:
        if (r6.isEmpty() == true) goto L29;
        this.mGrid.setSpans(this.mSpans);
        goto L29
    L22:
        if (r5.isEmpty() == true) goto L24;
        this.mGrid.setColumnWeights(this.mColumnWeights);
        goto L24
    L17:
        if (r4.isEmpty() == true) goto L19;
        this.mGrid.setRowWeights(this.mRowWeights);
        goto L19
    }
}
