package com.qihoo360.mobilesafe.common.ui.base.i.row;

import com.qihoo360.mobilesafe.common.ui.base.NotSupportMethodException;

/* JADX INFO: loaded from: classes4.dex */
public interface IListRowSelected {
    boolean isUIArrowExpand() throws NotSupportMethodException;

    boolean isUIRightChecked() throws NotSupportMethodException;

    void setUIArrowExpand(boolean r1) throws NotSupportMethodException;

    void setUIArrowVisible(boolean r1) throws NotSupportMethodException;

    void setUIRightChecked(boolean r1) throws NotSupportMethodException;

    void setUIRightSelectEnable(boolean r1) throws NotSupportMethodException;

    void setUIRowEnable(boolean r1) throws NotSupportMethodException;
}
