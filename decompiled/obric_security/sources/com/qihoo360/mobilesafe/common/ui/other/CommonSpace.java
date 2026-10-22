package com.qihoo360.mobilesafe.common.ui.other;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class CommonSpace extends RelativeLayout {
    private Button mBottomBtn;
    private final View mBottomDivider;
    private int mSpaceHeight;
    private final View mTopDivider;
    private RelativeLayout.LayoutParams topLp;

    public CommonSpace(Context r2) {
        this(r2, null);
    }

    public CommonSpace(Context r8, AttributeSet r9) {
        super(r8, r9);
        this.mSpaceHeight = 1;
        setBackgroundResource(R.color.inner_common_bg_color_1);
        View r1 = generateDivider();
        this.mTopDivider = r1;
        RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(-1, 1);
        this.topLp = r2;
        r2.addRule(10);
        addView(r1, this.topLp);
        View r3 = generateDivider();
        this.mBottomDivider = r3;
        RelativeLayout.LayoutParams r4 = new RelativeLayout.LayoutParams(-1, 1);
        r4.addRule(12);
        addView(r3, r4);
        TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.sysopti_pref);
        int r5 = 0;
        setMargins(r10.getDimensionPixelOffset(R.styleable.sysopti_pref_left_margin, 0), 0, 0, 0);
        String r6 = r10.getString(R.styleable.sysopti_pref_title);
        if (TextUtils.isEmpty(r6) == true) goto L5;
        TextView r7 = new TextView(r8);
        r7.setText(r6);
        r7.setContentDescription(r6);
        r7.setTextColor(getResources().getColor(R.color.inner_common_text_color_2));
        r7.setTextSize(0, getResources().getDimension(R.dimen.inner_common_font_size_f));
        r7.setPadding(CommonUtils.dip2px(r8, 15.0f), 0, 0, 0);
        RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(-2, -2);
        r11.addRule(15);
        addView(r7, r11);
        this.mSpaceHeight = CommonUtils.dip2px(r8, 36.0f);
    L5:
        int r12 = r10.getDimensionPixelOffset(R.styleable.sysopti_pref_space_height, 0);
        if (r12 <= 0) goto L8;
        this.mSpaceHeight = r12;
    L8:
        setSpaceHeight(this.mSpaceHeight);
        boolean r13 = r10.getBoolean(R.styleable.sysopti_pref_space_top_visible, true);
        if (r10.getBoolean(R.styleable.sysopti_pref_space_bottom_visible, true) == false) goto L11;
        int r14 = 0;
    L12:
        r3.setVisibility(r14);
        if (r13 == true) goto L16;
        r5 = 8;
    L16:
        r1.setVisibility(r5);
        r10.recycle();
        return;
    L11:
        r14 = 8;
        goto L12
    }

    public void setMargins(int r3, int r4, int r5, int r6) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) this.mTopDivider.getLayoutParams();
        RelativeLayout.LayoutParams r1 = (RelativeLayout.LayoutParams) this.mBottomDivider.getLayoutParams();
        r0.leftMargin = r3;
        r0.rightMargin = r4;
        r1.leftMargin = r5;
        r1.rightMargin = r6;
        this.mTopDivider.requestLayout();
        this.mBottomDivider.requestLayout();
    }

    public void setSpaceColor(int r1) {
        setBackgroundResource(r1);
    }

    public void setTopDividerVisible(boolean r1) {
        View r0 = this.mTopDivider;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setBottomDividerVisible(boolean r1) {
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

    public void setDividerColor(int r2) {
        this.mTopDivider.setBackgroundColor(r2);
        this.mBottomDivider.setBackgroundColor(r2);
    }

    public CommonSpace setSpaceHeight(int r1) {
        this.mSpaceHeight = r1;
        requestLayout();
        return this;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        int r0 = 1;
        if (1 != this.mSpaceHeight) goto L5;
        this.mBottomDivider.setVisibility(8);
    L5:
        int r5 = this.mSpaceHeight;
        if (1 == r5) goto L9;
        r0 = r5 + 2;
    L9:
        super.onMeasure(r3, View.MeasureSpec.makeMeasureSpec(r0, 1073741824));
    }

    private View generateDivider() {
        View r0 = new View(getContext());
        r0.setBackgroundResource(R.color.inner_common_bg_color_7);
        return r0;
    }
}
