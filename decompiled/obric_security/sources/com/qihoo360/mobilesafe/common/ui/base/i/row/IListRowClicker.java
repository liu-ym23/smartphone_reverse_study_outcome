package com.qihoo360.mobilesafe.common.ui.base.i.row;

import android.view.View;
import com.qihoo360.mobilesafe.common.ui.base.NotSupportMethodException;

/* JADX INFO: loaded from: classes4.dex */
public interface IListRowClicker {
    void setUILeftIconClickListener(View.OnClickListener r1) throws NotSupportMethodException;

    void setUIRightButtonClickListener(View.OnClickListener r1) throws NotSupportMethodException;

    void setUIRightSelectedListener(View.OnClickListener r1) throws NotSupportMethodException;

    void setUIRowClickListener(View.OnClickListener r1) throws NotSupportMethodException;
}
