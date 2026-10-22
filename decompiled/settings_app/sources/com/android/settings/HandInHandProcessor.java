package com.android.settings;

import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public class HandInHandProcessor {
    private static final String ON_HAND_IN_HAND_KEY = "on_hand_in_hand";
    private HandInHandDialog mDialog;

    public HandInHandProcessor() {
    }

    public void showDialog(Context r2, int r3, DialogInterface.OnClickListener r4, DialogInterface.OnClickListener r5, DialogInterface.OnCancelListener r6) {
        HandInHandDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
        HandInHandDialog r1 = new HandInHandDialog(r2, r3, r4, r5);
        this.mDialog = r1;
        r1.setOnCancelListener(r6);
        this.mDialog.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        return;
    L7:
        this.mDialog.show();
    }

    public boolean isHandInHandle(Context r3) {
        int r2 = android.provider.Settings.System.getInt(r3.getContentResolver(), ON_HAND_IN_HAND_KEY, 0);
        if (r2 == 1) goto L9;
        if (r2 == 2) goto L9;
        if (r2 == 101) goto L9;
        return false;
    L9:
        return true;
    }
}
