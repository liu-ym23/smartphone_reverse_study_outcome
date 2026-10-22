package com.qihoo360.mobilesafe.common.ui.base.i.row;

import android.graphics.drawable.Drawable;
import com.qihoo360.mobilesafe.common.ui.base.NotSupportMethodException;

/* JADX INFO: loaded from: classes4.dex */
public interface IListRowMarker {
    void setUIMarkColor(int r1) throws NotSupportMethodException;

    void setUIMarkDrawable(int r1) throws NotSupportMethodException;

    void setUIMarkDrawable(Drawable r1) throws NotSupportMethodException;

    void setUIMarkText(int r1) throws NotSupportMethodException;

    void setUIMarkText(CharSequence r1) throws NotSupportMethodException;

    void setUIMarkTextVisible(boolean r1) throws NotSupportMethodException;
}
