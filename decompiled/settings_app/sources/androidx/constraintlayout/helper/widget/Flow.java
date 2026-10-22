package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
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

    public Flow(Context context) {
        super(context);
    }

    public Flow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Flow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget widget, boolean isRtl) {
        this.mFlow.applyRtl(isRtl);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        onMeasure(this.mFlow, widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout layout, int widthMeasureSpec, int heightMeasureSpec) {
        int r0 = View.MeasureSpec.getMode(widthMeasureSpec);
        int r4 = View.MeasureSpec.getSize(widthMeasureSpec);
        int r1 = View.MeasureSpec.getMode(heightMeasureSpec);
        int r5 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (layout == null) goto L5;
        layout.measure(r0, r4, r1, r5);
        setMeasuredDimension(layout.getMeasuredWidth(), layout.getMeasuredHeight());
        return;
    L5:
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget child, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        super.loadParameters(constraint, child, layoutParams, mapIdToWidget);
        if ((child instanceof androidx.constraintlayout.core.widgets.Flow) == false) goto L8;
        androidx.constraintlayout.core.widgets.Flow r2 = (androidx.constraintlayout.core.widgets.Flow) child;
        if (layoutParams.orientation == (-1)) goto L9;
        r2.setOrientation(layoutParams.orientation);
        return;
    L9:
        return;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void init(AttributeSet attrs) {
        super.init(attrs);
        this.mFlow = new androidx.constraintlayout.core.widgets.Flow();
        if (attrs == null) goto L86;
        TypedArray r7 = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_Layout);
        int r0 = r7.getIndexCount();
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L85;
        int r3 = r7.getIndex(r2);
        if (r3 != R.styleable.ConstraintLayout_Layout_android_orientation) goto L10;
        this.mFlow.setOrientation(r7.getInt(r3, 0));
    L84:
        r2 = r2 + 1;
        goto L5
    L10:
        if (r3 != R.styleable.ConstraintLayout_Layout_android_padding) goto L13;
        this.mFlow.setPadding(r7.getDimensionPixelSize(r3, 0));
        goto L84
    L13:
        if (r3 != R.styleable.ConstraintLayout_Layout_android_paddingStart) goto L16;
        this.mFlow.setPaddingStart(r7.getDimensionPixelSize(r3, 0));
        goto L84
    L16:
        if (r3 != R.styleable.ConstraintLayout_Layout_android_paddingEnd) goto L19;
        this.mFlow.setPaddingEnd(r7.getDimensionPixelSize(r3, 0));
        goto L84
    L19:
        if (r3 != R.styleable.ConstraintLayout_Layout_android_paddingLeft) goto L22;
        this.mFlow.setPaddingLeft(r7.getDimensionPixelSize(r3, 0));
        goto L84
    L22:
        if (r3 != R.styleable.ConstraintLayout_Layout_android_paddingTop) goto L25;
        this.mFlow.setPaddingTop(r7.getDimensionPixelSize(r3, 0));
        goto L84
    L25:
        if (r3 != R.styleable.ConstraintLayout_Layout_android_paddingRight) goto L28;
        this.mFlow.setPaddingRight(r7.getDimensionPixelSize(r3, 0));
        goto L84
    L28:
        if (r3 != R.styleable.ConstraintLayout_Layout_android_paddingBottom) goto L31;
        this.mFlow.setPaddingBottom(r7.getDimensionPixelSize(r3, 0));
        goto L84
    L31:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_wrapMode) goto L34;
        this.mFlow.setWrapMode(r7.getInt(r3, 0));
        goto L84
    L34:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) goto L37;
        this.mFlow.setHorizontalStyle(r7.getInt(r3, 0));
        goto L84
    L37:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_verticalStyle) goto L40;
        this.mFlow.setVerticalStyle(r7.getInt(r3, 0));
        goto L84
    L40:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) goto L43;
        this.mFlow.setFirstHorizontalStyle(r7.getInt(r3, 0));
        goto L84
    L43:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) goto L46;
        this.mFlow.setLastHorizontalStyle(r7.getInt(r3, 0));
        goto L84
    L46:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) goto L49;
        this.mFlow.setFirstVerticalStyle(r7.getInt(r3, 0));
        goto L84
    L49:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) goto L52;
        this.mFlow.setLastVerticalStyle(r7.getInt(r3, 0));
        goto L84
    L52:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_horizontalBias) goto L55;
        this.mFlow.setHorizontalBias(r7.getFloat(r3, 0.5f));
        goto L84
    L55:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) goto L58;
        this.mFlow.setFirstHorizontalBias(r7.getFloat(r3, 0.5f));
        goto L84
    L58:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) goto L61;
        this.mFlow.setLastHorizontalBias(r7.getFloat(r3, 0.5f));
        goto L84
    L61:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) goto L64;
        this.mFlow.setFirstVerticalBias(r7.getFloat(r3, 0.5f));
        goto L84
    L64:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) goto L67;
        this.mFlow.setLastVerticalBias(r7.getFloat(r3, 0.5f));
        goto L84
    L67:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_verticalBias) goto L70;
        this.mFlow.setVerticalBias(r7.getFloat(r3, 0.5f));
        goto L84
    L70:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) goto L73;
        this.mFlow.setHorizontalAlign(r7.getInt(r3, 2));
        goto L84
    L73:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_verticalAlign) goto L76;
        this.mFlow.setVerticalAlign(r7.getInt(r3, 2));
        goto L84
    L76:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_horizontalGap) goto L79;
        this.mFlow.setHorizontalGap(r7.getDimensionPixelSize(r3, 0));
        goto L84
    L79:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_verticalGap) goto L82;
        this.mFlow.setVerticalGap(r7.getDimensionPixelSize(r3, 0));
        goto L84
    L82:
        if (r3 != R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) goto L84;
        this.mFlow.setMaxElementsWrap(r7.getInt(r3, -1));
        goto L84
    L85:
        r7.recycle();
    L86:
        this.mHelperWidget = this.mFlow;
        validateParams();
    }

    public void setOrientation(int orientation) {
        this.mFlow.setOrientation(orientation);
        requestLayout();
    }

    public void setPadding(int padding) {
        this.mFlow.setPadding(padding);
        requestLayout();
    }

    public void setPaddingLeft(int paddingLeft) {
        this.mFlow.setPaddingLeft(paddingLeft);
        requestLayout();
    }

    public void setPaddingTop(int paddingTop) {
        this.mFlow.setPaddingTop(paddingTop);
        requestLayout();
    }

    public void setPaddingRight(int paddingRight) {
        this.mFlow.setPaddingRight(paddingRight);
        requestLayout();
    }

    public void setPaddingBottom(int paddingBottom) {
        this.mFlow.setPaddingBottom(paddingBottom);
        requestLayout();
    }

    public void setLastHorizontalStyle(int style) {
        this.mFlow.setLastHorizontalStyle(style);
        requestLayout();
    }

    public void setLastVerticalStyle(int style) {
        this.mFlow.setLastVerticalStyle(style);
        requestLayout();
    }

    public void setLastHorizontalBias(float bias) {
        this.mFlow.setLastHorizontalBias(bias);
        requestLayout();
    }

    public void setLastVerticalBias(float bias) {
        this.mFlow.setLastVerticalBias(bias);
        requestLayout();
    }

    public void setWrapMode(int mode) {
        this.mFlow.setWrapMode(mode);
        requestLayout();
    }

    public void setHorizontalStyle(int style) {
        this.mFlow.setHorizontalStyle(style);
        requestLayout();
    }

    public void setVerticalStyle(int style) {
        this.mFlow.setVerticalStyle(style);
        requestLayout();
    }

    public void setHorizontalBias(float bias) {
        this.mFlow.setHorizontalBias(bias);
        requestLayout();
    }

    public void setVerticalBias(float bias) {
        this.mFlow.setVerticalBias(bias);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int style) {
        this.mFlow.setFirstHorizontalStyle(style);
        requestLayout();
    }

    public void setFirstVerticalStyle(int style) {
        this.mFlow.setFirstVerticalStyle(style);
        requestLayout();
    }

    public void setFirstHorizontalBias(float bias) {
        this.mFlow.setFirstHorizontalBias(bias);
        requestLayout();
    }

    public void setFirstVerticalBias(float bias) {
        this.mFlow.setFirstVerticalBias(bias);
        requestLayout();
    }

    public void setHorizontalAlign(int align) {
        this.mFlow.setHorizontalAlign(align);
        requestLayout();
    }

    public void setVerticalAlign(int align) {
        this.mFlow.setVerticalAlign(align);
        requestLayout();
    }

    public void setHorizontalGap(int gap) {
        this.mFlow.setHorizontalGap(gap);
        requestLayout();
    }

    public void setVerticalGap(int gap) {
        this.mFlow.setVerticalGap(gap);
        requestLayout();
    }

    public void setMaxElementsWrap(int max) {
        this.mFlow.setMaxElementsWrap(max);
        requestLayout();
    }
}
