package com.qihoo360.mobilesafe.common.ui.row;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase;

/* JADX INFO: loaded from: classes4.dex */
public class CommonListRowB7 extends CommonListRowBase {
    public CommonListRowB7(Context r1) {
        super(r1);
    }

    public CommonListRowB7(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CommonListRowB7(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase
    protected int getLayoutResId() {
        return R.layout.inner_common_list_row_b7;
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
    public void setUIRightText(CharSequence r1) {
        this.mUIRightTextView.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public void setUIRightChecked(boolean r2) {
        this.mUISelectedView.setSelected(r2);
        this.mUIRightTextView.setSelected(r2);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowRes
    public void setUIRightCheckedRes(int r1) {
        this.mUISelectedView.setImageResource(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public boolean isUIRightChecked() {
        return this.mUISelectedView.isSelected();
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowVisible
    public void setUIRightSelectVisible(boolean r1) {
        ImageView r0 = this.mUISelectedView;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowClicker
    public void setUIRightSelectedListener(View.OnClickListener r2) {
        this.mUISelectedView.setOnClickListener(r2);
        this.mUIRightTextView.setOnClickListener(r2);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public void setUIArrowExpand(boolean r1) {
        this.mUIArrowView.setSelected(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public boolean isUIArrowExpand() {
        return this.mUIArrowView.isSelected();
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowSelected
    public void setUIArrowVisible(boolean r1) {
        ImageView r0 = this.mUIArrowView;
        if (r1 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        return;
    L5:
        r2 = 8;
        goto L6
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonListRowBase, com.qihoo360.mobilesafe.common.ui.base.i.row.IListRowVisible
    public void setUILoading(boolean r4) {
        ImageView r0 = this.mUILoadingView;
        int r1 = 0;
        if (r4 == false) goto L5;
        int r2 = 0;
    L6:
        r0.setVisibility(r2);
        ImageView r3 = this.mUISelectedView;
        if (r4 == false) goto L9;
        r1 = 4;
    L9:
        r3.setVisibility(r1);
        if (r4 == false) goto L12;
        this.mUILoadingView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.inner_common_loading));
        return;
    L12:
        this.mUILoadingView.clearAnimation();
        return;
    L5:
        r2 = 8;
        goto L6
    }
}
