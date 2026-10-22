package com.qihoo360.mobilesafe.common.ui.topview;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonTopViewB extends LinearLayout {
    public static int ANIM_DURATION_TIME = 600;
    private TextView mBottomTextCenter;
    private TextView mBottomTextLeft;
    private Context mContext;
    private TextView mNumber;
    float mNumberInitTopMargin;
    int mNumberStartHeight;
    int mNumberTargetHeight;
    private TextView mRightText;
    private RelativeLayout mRootView;
    private TextView mTopText;
    float mTopTextEndTopMargin;
    float mTopTextInitTopMargin;
    float mTranslationNumberY;
    float mTranslationTopTextY;
    private TextView mUnit;
    private ValueAnimator mValueAnimator;
    int numberEndHeight;
    int numberEndWidth;

    static {
    }

    static /* synthetic */ RelativeLayout access$000(CommonTopViewB r0) {
        return r0.mRootView;
    }

    static /* synthetic */ TextView access$100(CommonTopViewB r0) {
        return r0.mTopText;
    }

    static /* synthetic */ TextView access$200(CommonTopViewB r0) {
        return r0.mNumber;
    }

    static /* synthetic */ TextView access$300(CommonTopViewB r0) {
        return r0.mUnit;
    }

    public CommonTopViewB(Context r1) {
        super(r1);
        initView(r1);
    }

    public CommonTopViewB(Context r1, AttributeSet r2) {
        super(r1, r2);
        initView(r1);
    }

    private void initView(Context r4) {
        this.mContext = r4;
        inflate(r4, R.layout.inner_common_top_view_top_b1, this);
        setOrientation(1);
        this.mRootView = (RelativeLayout) findViewById(R.id.common_top_b1_root_view);
        this.mTopText = (TextView) CommonUtils.$(this, R.id.common_top_b1_text);
        this.mNumber = (TextView) CommonUtils.$(this, R.id.common_top_b1_size_number);
        this.mUnit = (TextView) CommonUtils.$(this, R.id.common_top_b1_size_unit);
        this.mRightText = (TextView) CommonUtils.$(this, R.id.common_top_b1_right_text);
        TextView r0 = (TextView) CommonUtils.$(this, R.id.common_top_b1_bottom_text_center);
        this.mBottomTextCenter = r0;
        r0.setBackgroundDrawable(new CommonTopViewTipDrawable(getContext()));
        this.mBottomTextLeft = (TextView) CommonUtils.$(this, R.id.common_top_b1_bottom_text_left);
        setBackgroundResource(R.color.inner_common_bg_color_3);
        setNumberTypeface(CommonUtils.getHelveticaNeueLTProFonts(r4));
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        if (r1 == 0) goto L6;
        clearAnimation();
        return;
    }

    public void scale(final float r5, final float r6) {
        setNumberParams();
        setTopTextParams();
        final LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{r5, r6});
        this.mValueAnimator = r1;
        r1.setDuration(ANIM_DURATION_TIME);
        this.mValueAnimator.setInterpolator(new DecelerateInterpolator());
        this.mValueAnimator.addUpdateListener(new AnonymousClass1(this, r5, r6, r0));
        this.mValueAnimator.start();
    }

    private void setTopTextParams() {
        this.mTopTextInitTopMargin = this.mContext.getResources().getDimension(R.dimen.inner_common_dimen_6dp);
        this.mTopTextEndTopMargin = this.mContext.getResources().getDimension(R.dimen.inner_common_dimen_105dp);
    }

    private void setNumberParams() {
        this.mNumberInitTopMargin = this.mContext.getResources().getDimension(R.dimen.inner_common_dimen_42dp);
        this.mNumberStartHeight = this.mNumber.getMeasuredHeight();
        this.mNumberTargetHeight = this.numberEndHeight;
        RelativeLayout.LayoutParams r0 = new RelativeLayout.LayoutParams(-2, -2);
        r0.addRule(14);
        r0.topMargin = (int) this.mNumberInitTopMargin;
        this.mNumber.setLayoutParams(r0);
    }

    public void addAnimationListener(AnimatorListenerAdapter r1) {
        ValueAnimator r0 = this.mValueAnimator;
        if (r0 == null) goto L7;
        r0.addListener(r1);
        return;
    L7:
        throw new IllegalStateException("调用顺序有问题，先调用scale");
    }

    public void setTopText(CharSequence r2) {
        this.mTopText.setText(r2);
        this.mTopText.setContentDescription(r2);
    }

    private void setTextViewTopVisible(boolean r1) {
        TextView r0 = this.mTopText;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 4;
        goto L6
    }

    public void setNumber(CharSequence r2) {
        this.mNumber.setText(r2);
        this.mNumber.setContentDescription(r2);
    }

    public void setNumberTypeface(Typeface r1) {
        this.mNumber.setTypeface(r1);
    }

    public void setUnit(CharSequence r2) {
        this.mUnit.setText(r2);
        this.mUnit.setContentDescription(r2);
    }

    public void setRightText(CharSequence r2) {
        this.mRightText.setText(r2);
        this.mRightText.setContentDescription(r2);
    }

    public void setBottomTextCenter(CharSequence r3) {
        TextView r0 = this.mBottomTextCenter;
        if (TextUtils.isEmpty(r3) == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        this.mBottomTextCenter.setText(r3);
        this.mBottomTextCenter.setContentDescription(r3);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public void setBottomTextLeft(CharSequence r3) {
        TextView r0 = this.mBottomTextLeft;
        if (TextUtils.isEmpty(r3) == false) goto L5;
        int r1 = 8;
    L6:
        r0.setVisibility(r1);
        this.mBottomTextLeft.setText(r3);
        this.mBottomTextLeft.setContentDescription(r3);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    public void setBottomClickListener(View.OnClickListener r1) {
        this.mBottomTextCenter.setOnClickListener(r1);
    }

    public void setScaleEndNumberSize(int r1, int r2) {
        this.numberEndWidth = r1;
        this.numberEndHeight = r2;
    }

    public void startScanLoading() {
        if ((this.mBottomTextCenter.getBackground() instanceof CommonTopViewTipDrawable) == false) goto L6;
        ((CommonTopViewTipDrawable) this.mBottomTextCenter.getBackground()).startLoading();
        return;
    }

    public void endScanLoading() {
        if ((this.mBottomTextCenter.getBackground() instanceof CommonTopViewTipDrawable) == false) goto L6;
        ((CommonTopViewTipDrawable) this.mBottomTextCenter.getBackground()).stopLoading();
        return;
    }
}
