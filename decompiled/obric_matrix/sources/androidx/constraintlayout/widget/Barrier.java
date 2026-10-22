package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    public static final int BOTTOM = 3;
    public static final int END = 6;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int START = 5;
    public static final int TOP = 2;
    private androidx.constraintlayout.core.widgets.Barrier mBarrier;
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

    private void updateType(ConstraintWidget r6, int r7, boolean r8) {
        this.mResolvedType = r7;
        if (Build.VERSION.SDK_INT >= 17) goto L9;
        int r9 = this.mIndicatedType;
        if (r9 != 5) goto L7;
    L6:
        this.mResolvedType = 0;
    L20:
        if ((r6 instanceof androidx.constraintlayout.core.widgets.Barrier) == false) goto L23;
        ((androidx.constraintlayout.core.widgets.Barrier) r6).setBarrierType(this.mResolvedType);
        return;
    L23:
        return;
    L7:
        if (r9 != 6) goto L20;
    L12:
        this.mResolvedType = 1;
        goto L20
    L9:
        int r10 = this.mIndicatedType;
        if (r8 == false) goto L15;
        if (r10 == 5) goto L12;
        if (r10 != 6) goto L20;
    L15:
        if (r10 == 5) goto L6;
        if (r10 != 6) goto L20;
        goto L12
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mBarrier.getAllowsGoneWidget();
    }

    public boolean getAllowsGoneWidget() {
        return this.mBarrier.getAllowsGoneWidget();
    }

    public int getMargin() {
        return this.mBarrier.getMargin();
    }

    public int getType() {
        return this.mIndicatedType;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r7) {
        super.init(r7);
        this.mBarrier = new androidx.constraintlayout.core.widgets.Barrier();
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

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint r1, HelperWidget r2, ConstraintLayout.LayoutParams r3, SparseArray<ConstraintWidget> r4) {
        super.loadParameters(r1, r2, r3, r4);
        if ((r2 instanceof androidx.constraintlayout.core.widgets.Barrier) == false) goto L6;
        androidx.constraintlayout.core.widgets.Barrier r5 = (androidx.constraintlayout.core.widgets.Barrier) r2;
        boolean r6 = ((ConstraintWidgetContainer) r2.getParent()).isRtl();
        updateType(r5, r1.layout.mBarrierDirection, r6);
        r5.setAllowsGoneWidget(r1.layout.mBarrierAllowsGoneWidgets);
        r5.setMargin(r1.layout.mBarrierMargin);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget r2, boolean r3) {
        updateType(r2, this.mIndicatedType, r3);
    }

    public void setAllowsGoneWidget(boolean r1) {
        this.mBarrier.setAllowsGoneWidget(r1);
    }

    public void setDpMargin(int r2) {
        this.mBarrier.setMargin((int) ((r2 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int r1) {
        this.mBarrier.setMargin(r1);
    }

    public void setType(int r1) {
        this.mIndicatedType = r1;
    }
}
