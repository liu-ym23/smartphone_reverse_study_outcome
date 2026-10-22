package com.qihoo360.mobilesafe.common.ui.base.i.checkbox;

import android.view.View;
import com.qihoo360.mobilesafe.common.ui.checkbox.CommonCheckBox;

/* JADX INFO: loaded from: classes4.dex */
public interface ICheckBox {

    public interface ICheckBoxBase {
        boolean isUICheckBoxChecked();

        void setUICheckBoxChecked(boolean r1);

        void setUICheckBoxClickListener(View.OnClickListener r1);

        void setUICheckBoxStyle(CommonCheckBox.CheckBoxStyle r1);
    }
}
