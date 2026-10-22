package com.qihoo360.mobilesafe.common.ui.base.i.row;

import com.qihoo360.mobilesafe.common.ui.base.NotSupportMethodException;

/* JADX INFO: loaded from: classes4.dex */
public interface IListRowProgress {
    void setUIProgress(int r1) throws NotSupportMethodException;

    void setUIProgressColor(int r1, int r2, int r3, int r4) throws NotSupportMethodException;

    void setUIProgressVisible(boolean r1) throws NotSupportMethodException;

    void startUIProgress() throws NotSupportMethodException;

    void stopUIProgress() throws NotSupportMethodException;
}
