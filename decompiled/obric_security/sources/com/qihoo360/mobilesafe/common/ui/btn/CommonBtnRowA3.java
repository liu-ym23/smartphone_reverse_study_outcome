package com.qihoo360.mobilesafe.common.ui.btn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase;

/* JADX INFO: loaded from: classes4.dex */
public class CommonBtnRowA3 extends CommonBtnBase {
    public CommonBtnRowA3(Context r1) {
        super(r1);
    }

    public CommonBtnRowA3(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CommonBtnRowA3(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase
    protected int getLayoutResId() {
        return R.layout.inner_common_btn_row_a3;
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUILeftButtonText(CharSequence r1) {
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
    public void setUIRightChecked(boolean r1) {
        this.mUISelectedView.setSelected(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public boolean isUIRightChecked() {
        return this.mUISelectedView.isSelected();
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightSelectedListener(View.OnClickListener r1) {
        this.mUISelectedView.setOnClickListener(r1);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.base.CommonBtnBase, com.qihoo360.mobilesafe.common.ui.base.i.btn.IBtnRow
    public void setUIRightSelectedVisible(boolean r1) {
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
}
