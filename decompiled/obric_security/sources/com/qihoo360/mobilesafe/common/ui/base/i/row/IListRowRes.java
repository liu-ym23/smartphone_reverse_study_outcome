package com.qihoo360.mobilesafe.common.ui.base.i.row;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.qihoo360.mobilesafe.common.ui.base.CommonSwitch;
import com.qihoo360.mobilesafe.common.ui.base.NotSupportMethodException;

/* JADX INFO: loaded from: classes4.dex */
public interface IListRowRes {
    ImageView getUILeftIcon() throws NotSupportMethodException;

    void setUILeftImageDrawable(Drawable r1) throws NotSupportMethodException;

    void setUILeftImageResource(int r1) throws NotSupportMethodException;

    void setUIRightCheckedRes(int r1) throws NotSupportMethodException;

    void setUIRightCheckedSwitchStyle(CommonSwitch.Style r1) throws NotSupportMethodException;
}
