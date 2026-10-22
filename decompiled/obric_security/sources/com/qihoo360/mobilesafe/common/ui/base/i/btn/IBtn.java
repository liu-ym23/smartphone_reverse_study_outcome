package com.qihoo360.mobilesafe.common.ui.base.i.btn;

import com.qihoo360.mobilesafe.common.ui.base.NotSupportMethodException;
import com.qihoo360.mobilesafe.common.ui.btn.CommonButton;

/* JADX INFO: loaded from: classes4.dex */
public interface IBtn {
    void setUIButtonEnable(boolean r1) throws NotSupportMethodException;

    void setUIButtonStyle(CommonButton.BtnStyle r1) throws NotSupportMethodException;

    void setUIButtonText(int r1) throws NotSupportMethodException;

    void setUIButtonText(CharSequence r1) throws NotSupportMethodException;

    void setUIButtonTextColor(int r1) throws NotSupportMethodException;

    void setUIButtonTextSize(int r1) throws NotSupportMethodException;
}
