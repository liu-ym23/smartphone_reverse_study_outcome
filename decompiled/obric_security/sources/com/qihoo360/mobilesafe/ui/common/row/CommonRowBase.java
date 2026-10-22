package com.qihoo360.mobilesafe.ui.common.row;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.ripple.CommonRippleRelativeLayout;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CommonRowBase<LEFT extends View, CENTER extends View, RIGHT extends View> extends CommonRippleRelativeLayout {
    protected final int CENTER_ID;
    private int DEFAULT_HEIGHT;
    protected final int LEFT_ID;
    protected final int RIGHT_ID;
    private View mBottomDivider;
    protected CENTER mCenterView;
    private int mLeftMargin;
    protected LEFT mLeftView;
    protected RIGHT mRightView;

    protected abstract CENTER createCenterView();

    protected abstract LEFT createLeftView();

    protected abstract RIGHT createRightView();

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public CommonRowBase(Context r2) {
        this(r2, null);
    }

    public CommonRowBase(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.LEFT_ID = R.id.common_ll_left;
        this.CENTER_ID = R.id.common_ll_middle;
        this.RIGHT_ID = R.id.common_ll_right;
        init(r2, r3);
    }

    public void setDividerVisible(boolean r1) {
        View r0 = this.mBottomDivider;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setDividerLeftPadding(boolean r2) {
        if (r2 == false) goto L4;
        int r3 = CommonUtils.dip2px(getContext(), 15.0f);
    L5:
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mBottomDivider.getLayoutParams();
        r0.leftMargin = r3;
        this.mBottomDivider.setLayoutParams(r0);
        return;
    L4:
        r3 = 0;
        goto L5
    }

    public void setRightVisible(boolean r1) {
        RIGHT r0 = this.mRightView;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r1 == false) goto L7;
        int r2 = 0;
    L8:
        r0.setVisibility(r2);
        return;
    L7:
        r2 = 8;
        goto L8
    }

    public void setCenterVisible(boolean r1) {
        CENTER r0 = this.mCenterView;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setLeftVisible(boolean r5) {
        if (this.mLeftView != null) goto L5;
        return;
    L5:
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mCenterView.getLayoutParams();
        int r1 = 0;
        if (r5 == true) goto L8;
        r0.addRule(9);
        this.mCenterView.setTag(Integer.valueOf(r0.leftMargin));
        r0.leftMargin = this.mLeftMargin;
    L10:
        requestLayout();
        LEFT r4 = this.mLeftView;
        if (r5 == true) goto L14;
        r1 = 8;
    L14:
        r4.setVisibility(r1);
        return;
    L8:
        r0.addRule(9, 0);
        r0.leftMargin = ((Integer) this.mCenterView.getTag()).intValue();     // Catch: Exception -> L16
        goto L10
    }

    protected int getRestrictHeight() {
        return this.DEFAULT_HEIGHT;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int r2, int r3) {
        super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(getRestrictHeight(), 1073741824));
    }

    private void init(Context r7, AttributeSet r8) {
        this.DEFAULT_HEIGHT = CommonUtils.dip2px(getContext(), 66.0f);
        int r9 = getLeftPadding();
        int r0 = CommonUtils.dip2px(getContext(), 18.0f);
        this.mLeftMargin = getLeftMargin();
        this.mLeftView = (LEFT) createLeftView();
        this.mCenterView = (CENTER) createCenterView();
        this.mRightView = (RIGHT) createRightView();
        setId(this.mLeftView, this.LEFT_ID);
        setId(this.mCenterView, this.CENTER_ID);
        setId(this.mRightView, this.RIGHT_ID);
        RelativeLayout.LayoutParams r1 = generateLayoutParams(this.mCenterView.getLayoutParams());
        LEFT r2 = this.mLeftView;
        if (r2 != null) goto L5;
        r1.addRule(9);
        r1.leftMargin = this.mLeftMargin;
    L6:
        RIGHT r3 = this.mRightView;
        if (r3 == null) goto L12;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        RelativeLayout.LayoutParams r5 = generateLayoutParams(r4);
        r5.addRule(11);
        if (r4 != null) goto L11;
        r5.rightMargin = r0;
    L11:
        addView(this.mRightView, r5);
        r1.addRule(0, this.mRightView.getId());
    L12:
        r1.rightMargin = CommonUtils.dip2px(getContext(), 9.0f);
        addView(this.mCenterView, r1);
        View r6 = new View(getContext());
        this.mBottomDivider = r6;
        r6.setBackgroundResource(R.color.inner_common_bg_color_7);
        RelativeLayout.LayoutParams r10 = new RelativeLayout.LayoutParams(-1, 1);
        r10.addRule(12);
        r10.leftMargin = r9;
        addView(this.mBottomDivider, r10);
        setBackgroundResource(R.color.inner_common_bg_color_2);
        TypedArray r11 = getContext().obtainStyledAttributes(r8, R.styleable.CommonListRow);
        boolean r12 = r11.getBoolean(R.styleable.CommonListRow_left_visible, true);
        boolean r13 = r11.getBoolean(R.styleable.CommonListRow_right_visible, true);
        boolean r14 = r11.getBoolean(R.styleable.CommonListRow_divider_visible, true);
        setLeftVisible(r12);
        setRightVisible(r13);
        setDividerVisible(r14);
        r11.recycle();
        return;
    L5:
        RelativeLayout.LayoutParams r15 = generateLayoutParams(r2.getLayoutParams());
        r15.leftMargin = this.mLeftMargin;
        addView(this.mLeftView, r15);
        r1.addRule(1, this.mLeftView.getId());
        goto L6
    }

    public int getLeftMargin() {
        return CommonUtils.dip2px(getContext(), 18.0f);
    }

    public int getLeftPadding() {
        return CommonUtils.dip2px(getContext(), 15.0f);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    protected RelativeLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        if (r1 != null) goto L6;
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-2, -2);
        r0.addRule(15);
        return r0;
    L6:
        if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L10;
        return (RelativeLayout.LayoutParams) r1;
    L10:
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        return new RelativeLayout.LayoutParams((ViewGroup.MarginLayoutParams) r1);
    L14:
        return new RelativeLayout.LayoutParams(r1);
    }

    @Override // android.view.View
    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        LEFT r0 = this.mLeftView;
        if (r0 == null) goto L5;
        r0.setEnabled(r2);
    L5:
        CENTER r1 = this.mCenterView;
        if (r1 == null) goto L8;
        r1.setEnabled(r2);
    L8:
        RIGHT r3 = this.mRightView;
        if (r3 == null) goto L12;
        r3.setEnabled(r2);
        return;
    }

    private void setId(View r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        r1.setId(r2);
    }
}
