package com.android.settings;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class PopInfoDialogController {
    private static final String TAG = "PopInfoDialogController";
    private Activity mActivity;
    private Dialog mInfoDialog;

    static {
    }

    static /* synthetic */ Dialog access$000(PopInfoDialogController r0) {
        return r0.mInfoDialog;
    }

    public PopInfoDialogController(Activity r1) {
        this.mActivity = r1;
    }

    private void initDialog() {
        Dialog r0 = new Dialog(this.mActivity, R.style.pop_info_dialog_style);
        this.mInfoDialog = r0;
        r0.setCancelable(true);
        this.mInfoDialog.setCanceledOnTouchOutside(true);
    }

    public void setupDialog(View r2) {
        if (this.mInfoDialog != null) goto L6;
        initDialog();
        this.mInfoDialog.setContentView(r2);
        initTransparentView(r2);
        return;
    }

    private void initTransparentView(View r2) {
        r2.findViewById(R.id.transparent_view).setOnClickListener(new AnonymousClass1(this));
    }

    public void setupDialog(String r4) {
        if (this.mInfoDialog != null) goto L6;
        initDialog();
        View r0 = LayoutInflater.from(this.mActivity).inflate(R.layout.setting_item_popup_info_view, null);
        ((TextView) r0.findViewById(R.id.popup_info_text)).setText(r4);
        this.mInfoDialog.setContentView(r0);
        initTransparentView(r0);
        return;
    }

    public void showDialog() {
        Dialog r0 = this.mInfoDialog;
        if (r0 != null) goto L7;
        OLog.w(TAG, "plz init the dialog first!");
        return;
    L7:
        if (r0.isShowing() == false) goto L9;
        return;
    L9:
        if (this.mActivity.isFinishing() == true) goto L13;
        this.mInfoDialog.show();
        WindowManager.LayoutParams r1 = new WindowManager.LayoutParams();
        r1.copyFrom(this.mInfoDialog.getWindow().getAttributes());
        r1.width = -1;
        r1.height = -2;
        this.mInfoDialog.getWindow().setAttributes(r1);
        return;
    }

    public boolean isShowing() {
        Dialog r0 = this.mInfoDialog;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    public void dismissDialog() {
        if (isShowing() == false) goto L6;
        this.mInfoDialog.dismiss();
        return;
    }
}
