package com.qihoo360.mobilesafe.common.ui.btn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase;

/* JADX INFO: loaded from: classes4.dex */
public class CommonBtnRowA4 extends CommonBtnBase {
    public CommonBtnRowA4(Context r1) {
        super(r1);
    }

    public CommonBtnRowA4(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CommonBtnRowA4(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase
    protected int getLayoutResId() {
        return R.layout.inner_common_btn_row_a4;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonText(CharSequence r1) {
        this.mUILeftBtn.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonEnabled(boolean r1) {
        this.mUILeftBtn.setEnabled(r1);
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
    public void setUIRightButtonText(CharSequence r1) {
        this.mUIRightBtn.setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightButtonEnabled(boolean r1) {
        this.mUIRightBtn.setEnabled(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightBtnStyle(int r2) {
        parseStyleToButton(this.mUIRightBtn, r2);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightButtonClickListener(View.OnClickListener r1) {
        this.mUIRightBtn.setOnClickListener(r1);
    }
}
