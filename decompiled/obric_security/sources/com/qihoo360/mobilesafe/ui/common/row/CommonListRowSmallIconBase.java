package com.qihoo360.mobilesafe.ui.common.row;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CommonListRowSmallIconBase<CENTER extends View, RIGHT extends View> extends CommonRowBase<ImageView, CENTER, RIGHT> {
    @Override // com.qihoo360.mobilesafe.ui.common.row.CommonRowBase
    protected /* bridge */ /* synthetic */ View createLeftView() {
        return createLeftView();
    }

    public CommonListRowSmallIconBase(Context r1) {
        super(r1);
    }

    public CommonListRowSmallIconBase(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // com.qihoo360.mobilesafe.ui.common.row.CommonRowBase
    protected ImageView createLeftView() {
        ImageView r0 = new ImageView(getContext());
        RelativeLayout.LayoutParams r1 = new RelativeLayout.LayoutParams(-2, -2);
        r1.addRule(15);
        r1.height = getIconHeight();
        r1.width = getIconWidth();
        r1.rightMargin = CommonUtils.dip2px(getContext(), 12.0f);
        r1.leftMargin = CommonUtils.dip2px(getContext(), 36.0f);
        r0.setLayoutParams(r1);
        return r0;
    }

    protected int getIconHeight() {
        return CommonUtils.dip2px(getContext(), 21.0f);
    }

    protected int getIconWidth() {
        return CommonUtils.dip2px(getContext(), 21.0f);
    }
}
