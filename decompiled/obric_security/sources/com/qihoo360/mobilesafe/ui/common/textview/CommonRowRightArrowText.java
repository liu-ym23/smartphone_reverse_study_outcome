package com.qihoo360.mobilesafe.ui.common.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.badge.CommonBadgeView;
import com.qihoo360.mobilesafe.common.ui.badge.IAttachBadgeView;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;
import com.qihoo360.mobilesafe.ui.common.other.CommonLoadingIcon;

/* JADX INFO: loaded from: classes4.dex */
public class CommonRowRightArrowText extends LinearLayout implements IAttachBadgeView {
    private Drawable mArrowDrawable;
    private CommonBadgeView mBadgeView;
    private CommonLoadingIcon mLoadingView;
    private CommonSummaryTextView mTextView;

    public CommonRowRightArrowText(Context r2) {
        this(r2, null);
    }

    public CommonRowRightArrowText(Context r3, AttributeSet r4) {
        super(r3, r4);
        this.mArrowDrawable = getResources().getDrawable(R.drawable.v5_common_icon_right_arrow);
        setOrientation(0);
        setGravity(16);
        this.mTextView = new CommonSummaryTextView(r3);
        this.mLoadingView = new CommonLoadingIcon(r3, this.mArrowDrawable);
        CommonBadgeView r0 = new CommonBadgeView(r3);
        this.mBadgeView = r0;
        r0.setVisibility(8);
        addView(this.mTextView);
        addView(this.mBadgeView);
        addView(this.mLoadingView);
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        r1.rightMargin = CommonUtils.dip2px(r3, 6.0f);
        setLoading(false);
    }

    public void setLoading(boolean r2) {
        this.mLoadingView.setLoading(r2);
        CommonLoadingIcon r0 = this.mLoadingView;
        Resources r1 = getResources();
        if (r2 == false) goto L5;
        int r3 = R.string.common_loading;
    L6:
        r0.setContentDescription(r1.getString(r3));
        return;
    L5:
        r3 = R.string.common_open;
        goto L6
    }

    public void setText(CharSequence r2) {
        this.mTextView.setText(r2);
        this.mTextView.setContentDescription(r2);
    }

    public void setTextColor(int r1) {
        this.mTextView.setTextColor(r1);
    }

    public void setTextSize(float r2) {
        this.mTextView.setTextSize(0, r2);
    }

    public void setTextVisible(boolean r1) {
        CommonSummaryTextView r0 = this.mTextView;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    public void setTextBackgroundResource(int r3) {
        if (r3 != 0) goto L4;
        this.mTextView.setPadding(0, 0, 0, 0);
    L4:
        this.mTextView.setBackgroundResource(r3);
        this.mTextView.setGravity(17);
        requestLayout();
    }

    @Override // com.qihoo360.mobilesafe.common.ui.badge.IAttachBadgeView
    public void setBadgeContent(String r1) {
        this.mBadgeView.setBadgeContent(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.badge.IAttachBadgeView
    public void setBadgeShown(boolean r2) {
        this.mBadgeView.setBadgeShown(r2);
        CommonBadgeView r1 = this.mBadgeView;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r1.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    @Override // com.qihoo360.mobilesafe.common.ui.badge.IAttachBadgeView
    public void setBadgeColor(int r1) {
        this.mBadgeView.setBadgeColor(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.badge.IAttachBadgeView
    public boolean isBadgeShown() {
        return this.mBadgeView.isShown();
    }
}
