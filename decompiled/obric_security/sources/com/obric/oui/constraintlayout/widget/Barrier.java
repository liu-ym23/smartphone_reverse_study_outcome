package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidgetContainer;
import com.obric.oui.constraintlayout.core.widgets.HelperWidget;

/* JADX INFO: loaded from: classes3.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private com.obric.oui.constraintlayout.core.widgets.Barrier mBarrier;
    private int mIndicatedType;
    private int mResolvedType;

    public Barrier(Context r1) {
        super(r1);
        super.setVisibility(8);
    }

    public Barrier(Context r1, AttributeSet r2) {
        super(r1, r2);
        super.setVisibility(8);
    }

    public Barrier(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        super.setVisibility(8);
    }

    public int getType() {
        return this.mIndicatedType;
    }

    public void setType(int r1) {
        this.mIndicatedType = r1;
    }

    private void updateType(ConstraintWidget r4, int r5, boolean r6) {
        this.mResolvedType = r5;
        if (r6 == false) goto L9;
        int r7 = this.mIndicatedType;
        if (r7 != 5) goto L7;
        this.mResolvedType = 1;
    L15:
        if ((r4 instanceof com.obric.oui.constraintlayout.core.widgets.Barrier) == false) goto L18;
        ((com.obric.oui.constraintlayout.core.widgets.Barrier) r4).setBarrierType(this.mResolvedType);
        return;
    L18:
        return;
    L7:
        if (r7 != 6) goto L15;
        this.mResolvedType = 0;
        goto L15
    L9:
        int r8 = this.mIndicatedType;
        if (r8 != 5) goto L12;
        this.mResolvedType = 0;
        goto L15
    L12:
        if (r8 != 6) goto L15;
        this.mResolvedType = 1;
        goto L15
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget r2, boolean r3) {
        updateType(r2, this.mIndicatedType, r3);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r7) {
        super.init(r7);
        this.mBarrier = new com.obric.oui.constraintlayout.core.widgets.Barrier();
        if (r7 == null) goto L17;
        TypedArray r8 = getContext().obtainStyledAttributes(r7, R.styleable.ConstraintLayout_Layout);
        int r0 = r8.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L16;
        int r3 = r8.getIndex(r2);
        if (r3 != R.styleable.ConstraintLayout_Layout_barrierDirection) goto L10;
        setType(r8.getInt(r3, 0));
    L15:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) goto L13;
        this.mBarrier.setAllowsGoneWidget(r8.getBoolean(r3, true));
        goto L15
    L13:
        if (r3 != R.styleable.ConstraintLayout_Layout_barrierMargin) goto L15;
        this.mBarrier.setMargin(r8.getDimensionPixelSize(r3, 0));
        goto L15
    L16:
        r8.recycle();
    L17:
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    public void setAllowsGoneWidget(boolean r1) {
        this.mBarrier.setAllowsGoneWidget(r1);
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mBarrier.getAllowsGoneWidget();
    }

    public boolean getAllowsGoneWidget() {
        return this.mBarrier.getAllowsGoneWidget();
    }

    public void setDpMargin(int r2) {
        this.mBarrier.setMargin((int) ((r2 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public int getMargin() {
        return this.mBarrier.getMargin();
    }

    public void setMargin(int r1) {
        this.mBarrier.setMargin(r1);
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint r1, HelperWidget r2, ConstraintLayout.LayoutParams r3, SparseArray<ConstraintWidget> r4) {
        super.loadParameters(r1, r2, r3, r4);
        if ((r2 instanceof com.obric.oui.constraintlayout.core.widgets.Barrier) == false) goto L6;
        com.obric.oui.constraintlayout.core.widgets.Barrier r5 = (com.obric.oui.constraintlayout.core.widgets.Barrier) r2;
        boolean r6 = ((ConstraintWidgetContainer) r2.getParent()).isRtl();
        updateType(r5, r1.layout.mBarrierDirection, r6);
        r5.setAllowsGoneWidget(r1.layout.mBarrierAllowsGoneWidgets);
        r5.setMargin(r1.layout.mBarrierMargin);
        return;
    }
}
