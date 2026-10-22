package com.qihoo360.mobilesafe.ui.common.textview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public class CommonRowCenterDoubleLineE extends LinearLayout {
    private CommonMainTextViewE mMainText;
    private CommonSummaryTextViewE mSummaryText;

    public CommonRowCenterDoubleLineE(Context r2) {
        this(r2, null);
    }

    public CommonRowCenterDoubleLineE(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    private void init() {
        setOrientation(1);
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-2, -2);
        r0.bottomMargin = CommonUtils.dip2px(getContext(), 2.0f);
        this.mMainText = new CommonMainTextViewE(getContext());
        this.mSummaryText = new CommonSummaryTextViewE(getContext());
        this.mMainText.setEllipsize(TextUtils.TruncateAt.END);
        this.mSummaryText.setEllipsize(TextUtils.TruncateAt.END);
        this.mMainText.setSingleLine();
        this.mSummaryText.setSingleLine();
        addView(this.mMainText, r0);
        addView(this.mSummaryText, -2, -2);
    }

    public CommonSummaryTextViewE getSummaryText() {
        return this.mSummaryText;
    }

    public CommonMainTextViewE getMainText() {
        return this.mMainText;
    }

    public void setMainTextEllipsize(TextUtils.TruncateAt r1) {
        this.mMainText.setEllipsize(r1);
    }
}
