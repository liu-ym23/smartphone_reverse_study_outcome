package com.qihoo360.mobilesafe.ui.common.row;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;
import com.qihoo360.mobilesafe.ui.common.textview.CommonRowCenterDoubleLineE;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CommonListRowEBase<RIGHT extends View> extends CommonListRowSmallIconBase<CommonRowCenterDoubleLineE, RIGHT> {
    @Override // com.qihoo360.mobilesafe.ui.common.row.CommonRowBase
    protected /* bridge */ /* synthetic */ View createCenterView() {
        return createCenterView();
    }

    public CommonListRowEBase(Context r1) {
        super(r1);
        init();
    }

    public CommonListRowEBase(Context r1, AttributeSet r2) {
        super(r1, r2);
        init();
    }

    public void setLeftMargin(int r3) {
        RelativeLayout.LayoutParams r0 = (RelativeLayout.LayoutParams) ((ImageView) this.mLeftView).getLayoutParams();
        r0.leftMargin = CommonUtils.dip2px(getContext(), r3);
        ((ImageView) this.mLeftView).setLayoutParams(r0);
    }

    public void setText(CharSequence r2) {
        ((CommonRowCenterDoubleLineE) this.mCenterView).getMainText().setText(r2);
        ((CommonRowCenterDoubleLineE) this.mCenterView).getMainText().setContentDescription(r2);
    }

    public void setSummaryText(CharSequence r3) {
        if (TextUtils.isEmpty(r3) == true) goto L5;
        ((CommonRowCenterDoubleLineE) this.mCenterView).getSummaryText().setVisibility(0);
        ((CommonRowCenterDoubleLineE) this.mCenterView).getSummaryText().setText(r3);
        ((CommonRowCenterDoubleLineE) this.mCenterView).getSummaryText().setContentDescription(r3);
        return;
    L5:
        ((CommonRowCenterDoubleLineE) this.mCenterView).getSummaryText().setVisibility(8);
    }

    public void setImageDrawable(Drawable r1) {
        ((ImageView) this.mLeftView).setImageDrawable(r1);
    }

    public void setImageResource(int r1) {
        ((ImageView) this.mLeftView).setImageResource(r1);
    }

    public void setImageBitmap(Bitmap r1) {
        ((ImageView) this.mLeftView).setImageBitmap(r1);
    }

    public void setImageBackgroud(Drawable r1) {
        ((ImageView) this.mLeftView).setBackgroundDrawable(r1);
    }

    @Override // com.qihoo360.mobilesafe.ui.common.row.CommonRowBase
    protected CommonRowCenterDoubleLineE createCenterView() {
        return new CommonRowCenterDoubleLineE(getContext());
    }

    @Override // com.qihoo360.mobilesafe.ui.common.row.CommonRowBase
    protected int getRestrictHeight() {
        return CommonUtils.dip2px(getContext(), 54.0f);
    }

    private void init() {
        setBackgroundResource(R.color.inner_common_bg_color_1);
    }
}
