package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    private static final String TAG = "Flow";
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private androidx.constraintlayout.core.widgets.Flow mFlow;

    public Flow(Context r1) {
        super(r1);
    }

    public Flow(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public Flow(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet r8) {
        int r0 = Build.VERSION.SDK_INT;
        super.init(r8);
        this.mFlow = new androidx.constraintlayout.core.widgets.Flow();
        if (r8 == null) goto L88;
        TypedArray r9 = getContext().obtainStyledAttributes(r8, R.styleable.ConstraintLayout_Layout);
        int r1 = r9.getIndexCount();
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L87;
        int r4 = r9.getIndex(r3);
        if (r4 != R.styleable.ConstraintLayout_Layout_android_orientation) goto L10;
        this.mFlow.setOrientation(r9.getInt(r4, 0));
    L86:
        r3 = r3 + 1;
        goto L5
    L10:
        if (r4 != R.styleable.ConstraintLayout_Layout_android_padding) goto L13;
        this.mFlow.setPadding(r9.getDimensionPixelSize(r4, 0));
        goto L86
    L13:
        if (r4 != R.styleable.ConstraintLayout_Layout_android_paddingStart) goto L17;
        if (r0 < 17) goto L86;
        this.mFlow.setPaddingStart(r9.getDimensionPixelSize(r4, 0));
        goto L86
    L17:
        if (r4 != R.styleable.ConstraintLayout_Layout_android_paddingEnd) goto L21;
        if (r0 < 17) goto L86;
        this.mFlow.setPaddingEnd(r9.getDimensionPixelSize(r4, 0));
        goto L86
    L21:
        if (r4 != R.styleable.ConstraintLayout_Layout_android_paddingLeft) goto L24;
        this.mFlow.setPaddingLeft(r9.getDimensionPixelSize(r4, 0));
        goto L86
    L24:
        if (r4 != R.styleable.ConstraintLayout_Layout_android_paddingTop) goto L27;
        this.mFlow.setPaddingTop(r9.getDimensionPixelSize(r4, 0));
        goto L86
    L27:
        if (r4 != R.styleable.ConstraintLayout_Layout_android_paddingRight) goto L30;
        this.mFlow.setPaddingRight(r9.getDimensionPixelSize(r4, 0));
        goto L86
    L30:
        if (r4 != R.styleable.ConstraintLayout_Layout_android_paddingBottom) goto L33;
        this.mFlow.setPaddingBottom(r9.getDimensionPixelSize(r4, 0));
        goto L86
    L33:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_wrapMode) goto L36;
        this.mFlow.setWrapMode(r9.getInt(r4, 0));
        goto L86
    L36:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) goto L39;
        this.mFlow.setHorizontalStyle(r9.getInt(r4, 0));
        goto L86
    L39:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_verticalStyle) goto L42;
        this.mFlow.setVerticalStyle(r9.getInt(r4, 0));
        goto L86
    L42:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) goto L45;
        this.mFlow.setFirstHorizontalStyle(r9.getInt(r4, 0));
        goto L86
    L45:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) goto L48;
        this.mFlow.setLastHorizontalStyle(r9.getInt(r4, 0));
        goto L86
    L48:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) goto L51;
        this.mFlow.setFirstVerticalStyle(r9.getInt(r4, 0));
        goto L86
    L51:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) goto L54;
        this.mFlow.setLastVerticalStyle(r9.getInt(r4, 0));
        goto L86
    L54:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_horizontalBias) goto L57;
        this.mFlow.setHorizontalBias(r9.getFloat(r4, 0.5f));
        goto L86
    L57:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) goto L60;
        this.mFlow.setFirstHorizontalBias(r9.getFloat(r4, 0.5f));
        goto L86
    L60:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) goto L63;
        this.mFlow.setLastHorizontalBias(r9.getFloat(r4, 0.5f));
        goto L86
    L63:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) goto L66;
        this.mFlow.setFirstVerticalBias(r9.getFloat(r4, 0.5f));
        goto L86
    L66:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) goto L69;
        this.mFlow.setLastVerticalBias(r9.getFloat(r4, 0.5f));
        goto L86
    L69:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_verticalBias) goto L72;
        this.mFlow.setVerticalBias(r9.getFloat(r4, 0.5f));
        goto L86
    L72:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) goto L75;
        this.mFlow.setHorizontalAlign(r9.getInt(r4, 2));
        goto L86
    L75:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_verticalAlign) goto L78;
        this.mFlow.setVerticalAlign(r9.getInt(r4, 2));
        goto L86
    L78:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_horizontalGap) goto L81;
        this.mFlow.setHorizontalGap(r9.getDimensionPixelSize(r4, 0));
        goto L86
    L81:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_verticalGap) goto L84;
        this.mFlow.setVerticalGap(r9.getDimensionPixelSize(r4, 0));
        goto L86
    L84:
        if (r4 != R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) goto L86;
        this.mFlow.setMaxElementsWrap(r9.getInt(r4, -1));
        goto L86
    L87:
        r9.recycle();
    L88:
        this.mHelperWidget = this.mFlow;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint r1, HelperWidget r2, ConstraintLayout.LayoutParams r3, SparseArray<ConstraintWidget> r4) {
        super.loadParameters(r1, r2, r3, r4);
        if ((r2 instanceof androidx.constraintlayout.core.widgets.Flow) == false) goto L8;
        androidx.constraintlayout.core.widgets.Flow r5 = (androidx.constraintlayout.core.widgets.Flow) r2;
        int r0 = r3.orientation;
        if (r0 == (-1)) goto L9;
        r5.setOrientation(r0);
        return;
    L9:
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    protected void onMeasure(int r2, int r3) {
        onMeasure(this.mFlow, r2, r3);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout r3, int r4, int r5) {
        int r0 = View.MeasureSpec.getMode(r4);
        int r6 = View.MeasureSpec.getSize(r4);
        int r1 = View.MeasureSpec.getMode(r5);
        int r7 = View.MeasureSpec.getSize(r5);
        if (r3 == null) goto L5;
        r3.measure(r0, r6, r1, r7);
        setMeasuredDimension(r3.getMeasuredWidth(), r3.getMeasuredHeight());
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget r1, boolean r2) {
        this.mFlow.applyRtl(r2);
    }

    public void setFirstHorizontalBias(float r2) {
        this.mFlow.setFirstHorizontalBias(r2);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int r2) {
        this.mFlow.setFirstHorizontalStyle(r2);
        requestLayout();
    }

    public void setFirstVerticalBias(float r2) {
        this.mFlow.setFirstVerticalBias(r2);
        requestLayout();
    }

    public void setFirstVerticalStyle(int r2) {
        this.mFlow.setFirstVerticalStyle(r2);
        requestLayout();
    }

    public void setHorizontalAlign(int r2) {
        this.mFlow.setHorizontalAlign(r2);
        requestLayout();
    }

    public void setHorizontalBias(float r2) {
        this.mFlow.setHorizontalBias(r2);
        requestLayout();
    }

    public void setHorizontalGap(int r2) {
        this.mFlow.setHorizontalGap(r2);
        requestLayout();
    }

    public void setHorizontalStyle(int r2) {
        this.mFlow.setHorizontalStyle(r2);
        requestLayout();
    }

    public void setLastHorizontalBias(float r2) {
        this.mFlow.setLastHorizontalBias(r2);
        requestLayout();
    }

    public void setLastHorizontalStyle(int r2) {
        this.mFlow.setLastHorizontalStyle(r2);
        requestLayout();
    }

    public void setLastVerticalBias(float r2) {
        this.mFlow.setLastVerticalBias(r2);
        requestLayout();
    }

    public void setLastVerticalStyle(int r2) {
        this.mFlow.setLastVerticalStyle(r2);
        requestLayout();
    }

    public void setMaxElementsWrap(int r2) {
        this.mFlow.setMaxElementsWrap(r2);
        requestLayout();
    }

    public void setOrientation(int r2) {
        this.mFlow.setOrientation(r2);
        requestLayout();
    }

    public void setPadding(int r2) {
        this.mFlow.setPadding(r2);
        requestLayout();
    }

    public void setPaddingBottom(int r2) {
        this.mFlow.setPaddingBottom(r2);
        requestLayout();
    }

    public void setPaddingLeft(int r2) {
        this.mFlow.setPaddingLeft(r2);
        requestLayout();
    }

    public void setPaddingRight(int r2) {
        this.mFlow.setPaddingRight(r2);
        requestLayout();
    }

    public void setPaddingTop(int r2) {
        this.mFlow.setPaddingTop(r2);
        requestLayout();
    }

    public void setVerticalAlign(int r2) {
        this.mFlow.setVerticalAlign(r2);
        requestLayout();
    }

    public void setVerticalBias(float r2) {
        this.mFlow.setVerticalBias(r2);
        requestLayout();
    }

    public void setVerticalGap(int r2) {
        this.mFlow.setVerticalGap(r2);
        requestLayout();
    }

    public void setVerticalStyle(int r2) {
        this.mFlow.setVerticalStyle(r2);
        requestLayout();
    }

    public void setWrapMode(int r2) {
        this.mFlow.setWrapMode(r2);
        requestLayout();
    }
}
