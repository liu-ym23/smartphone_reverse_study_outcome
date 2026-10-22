package com.qihoo360.mobilesafe.common.ui.base.i.btn;

import android.view.View;
import com.qihoo360.mobilesafe.common.ui.base.NotSupportMethodException;

/* JADX INFO: loaded from: classes4.dex */
public interface IBtnRow {
    Object getUILeftButtonTag(int r1) throws NotSupportMethodException;

    Object getUIRightButtonTag(int r1) throws NotSupportMethodException;

    boolean isUIRightChecked() throws NotSupportMethodException;

    void setUIBackGroundColor(int r1) throws NotSupportMethodException;

    void setUILeftBtnStyle(int r1) throws NotSupportMethodException;

    void setUILeftButtonClickListener(View.OnClickListener r1) throws NotSupportMethodException;

    void setUILeftButtonEnabled(boolean r1) throws NotSupportMethodException;

    void setUILeftButtonTag(int r1, Object r2) throws NotSupportMethodException;

    void setUILeftButtonText(int r1) throws NotSupportMethodException;

    void setUILeftButtonText(CharSequence r1) throws NotSupportMethodException;

    void setUILeftButtonVisible(boolean r1) throws NotSupportMethodException;

    void setUIRightBtnStyle(int r1) throws NotSupportMethodException;

    void setUIRightButtonClickListener(View.OnClickListener r1) throws NotSupportMethodException;

    void setUIRightButtonEnabled(boolean r1) throws NotSupportMethodException;

    void setUIRightButtonTag(int r1, Object r2) throws NotSupportMethodException;

    void setUIRightButtonText(int r1) throws NotSupportMethodException;

    void setUIRightButtonText(CharSequence r1) throws NotSupportMethodException;

    void setUIRightChecked(boolean r1) throws NotSupportMethodException;

    void setUIRightSelectedListener(View.OnClickListener r1) throws NotSupportMethodException;

    void setUIRightSelectedVisible(boolean r1) throws NotSupportMethodException;
}
