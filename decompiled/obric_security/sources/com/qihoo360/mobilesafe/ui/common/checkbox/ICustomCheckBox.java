package com.qihoo360.mobilesafe.ui.common.checkbox;

import android.view.View;
import android.widget.Checkable;

/* JADX INFO: loaded from: classes4.dex */
public interface ICustomCheckBox extends Checkable {

    public interface OnCheckChangedListener {
        void onCheckChanged(View r1, boolean r2);
    }

    void setOnCheckedChangedListener(OnCheckChangedListener r1);
}
