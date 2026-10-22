package com.qihoo360.mobilesafe.ui.common.row;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.qihoo360.mobilesafe.ui.common.textview.CommonRowRightArrowText;

/* JADX INFO: loaded from: classes4.dex */
public class CommonListRowE extends CommonListRowEBase<CommonRowRightArrowText> {
    @Override // com.qihoo360.mobilesafe.ui.common.row.CommonRowBase
    protected /* bridge */ /* synthetic */ View createRightView() {
        return createRightView();
    }

    public CommonListRowE(Context r2) {
        this(r2, null);
    }

    public CommonListRowE(Context r1, AttributeSet r2) {
        super(r1, r2);
        setLeftVisible(false);
    }

    public void setRightText(CharSequence r1) {
        ((CommonRowRightArrowText) this.mRightView).setText(r1);
    }

    @Override // com.qihoo360.mobilesafe.ui.common.row.CommonRowBase
    protected CommonRowRightArrowText createRightView() {
        return new CommonRowRightArrowText(getContext());
    }
}
