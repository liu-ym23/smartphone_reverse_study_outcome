package com.qihoo360.mobilesafe.common.ui.base.i.row;

import com.qihoo360.mobilesafe.common.ui.base.NotSupportMethodException;

/* JADX INFO: loaded from: classes4.dex */
public interface IListRowBadge {
    boolean isUIBadgeShown() throws NotSupportMethodException;

    void setUIBadgeColor(int r1) throws NotSupportMethodException;

    void setUIBadgeContent(String r1) throws NotSupportMethodException;

    void setUIBadgeShown(boolean r1) throws NotSupportMethodException;
}
