package com.qihoo360.mobilesafe.common.ui.btn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase;

/* JADX INFO: loaded from: classes4.dex */
public class CommonBtnRowA1 extends CommonBtnBase {
    public CommonBtnRowA1(Context r1) {
        super(r1);
    }

    public CommonBtnRowA1(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CommonBtnRowA1(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase
    protected int getLayoutResId() {
        return R.layout.inner_common_btn_row_a1;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonText(CharSequence r1) {
        this.mUILeftBtn.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonText(int r1) {
        this.mUILeftBtn.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftBtnStyle(int r2) {
        parseStyleToButton(this.mUILeftBtn, r2);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonClickListener(View.OnClickListener r1) {
        this.mUILeftBtn.setOnClickListener(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonEnabled(boolean r1) {
        this.mUILeftBtn.setEnabled(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIBackGroundColor(int r1) {
        setBackgroundColor(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonTag(int r1, Object r2) {
        this.mUILeftBtn.setTag(r1, r2);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public Object getUILeftButtonTag(int r1) {
        return this.mUILeftBtn.getTag(r1);
    }
}
