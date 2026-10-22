package com.android.settings.widget;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class ViewHelper {
    public ViewHelper() {
    }

    public static void setEnableState(boolean r3, View r4) {
        if (r4 == null) goto L10;
        r4.setEnabled(r3);
        if ((r4 instanceof ViewGroup) == false) goto L12;
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
        if (r0 <= 0) goto L13;
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L14;
        setEnableState(r3, r5.getChildAt(r1));
        r1 = r1 + 1;
        goto L8
    L14:
        return;
    L13:
        return;
    L12:
        return;
    }
}
