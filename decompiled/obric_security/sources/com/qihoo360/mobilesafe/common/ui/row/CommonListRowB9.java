package com.qihoo360.mobilesafe.common.ui.row;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase;

/* JADX INFO: loaded from: classes4.dex */
public class CommonListRowB9 extends CommonListRowBase {
    public CommonListRowB9(Context r1) {
        super(r1);
    }

    public CommonListRowB9(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CommonListRowB9(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase
    protected int getLayoutResId() {
        return R.layout.inner_common_list_row_b9;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowRes
    public void setUILeftImageResource(int r1) {
        this.mUIIconImageView.setImageResource(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowRes
    public void setUILeftImageDrawable(Drawable r1) {
        this.mUIIconImageView.setImageDrawable(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowRes
    public ImageView getUILeftIcon() {
        return this.mUIIconImageView;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowVisible
    public void setUILeftIconVisible(boolean r1) {
        ImageView r0 = this.mUIIconImageView;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIFirstLineText(CharSequence r1) {
        this.mUIFirstLineTextView.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIFirstLineText(int r1) {
        this.mUIFirstLineTextView.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUISecondLineText(CharSequence r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        this.mUISecondLineTextView.setVisibility(8);
        return;
    L6:
        this.mUISecondLineTextView.setVisibility(0);
        this.mUISecondLineTextView.setText(r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIThirdLineText(CharSequence r1) {
        this.mUIThirdLineTextView.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIRightText(CharSequence r1) {
        this.mUIRightTextView.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowText
    public void setUIRightTextColor(int r1) {
        this.mUIRightTextView.setTextColor(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public void setUIRowEnable(boolean r2) {
        setEnabled(r2);
        TextView r0 = this.mUIFirstLineTextView;
        Resources r1 = getResources();
        if (r2 == false) goto L5;
        int r3 = R.color.inner_common_text_color_1;
    L6:
        r0.setTextColor(r1.getColor(r3));
        return;
    L5:
        r3 = R.color.inner_common_text_color_2;
        goto L6
    }
}
