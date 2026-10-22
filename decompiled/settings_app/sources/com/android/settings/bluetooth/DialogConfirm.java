package com.android.settings.bluetooth;

import android.app.Dialog;
import android.content.Context;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class DialogConfirm extends Dialog {
    public DialogConfirm(Context r2) {
        super(r2, R.style.MmsDialogTheme);
    }

    public void InitDialog(int r1) {
        setContentView(r1);
    }
}
