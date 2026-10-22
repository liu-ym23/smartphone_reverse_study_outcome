package com.android.settings.wifi;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.android.settings.R;

/* JADX INFO: loaded from: classes.dex */
class WifiDialog extends AlertDialog implements WifiConfigUiBase {
    static final int BUTTON_FORGET = -3;
    static final int BUTTON_SUBMIT = -1;
    private final AccessPoint mAccessPoint;
    private WifiConfigController mController;
    private boolean mHideSubmitButton;
    private final WifiDialogListener mListener;
    private final int mMode;
    private View mView;

    public interface WifiDialogListener {
        void onForget(WifiDialog r1);

        void onSubmit(WifiDialog r1);
    }

    @Override // com.android.settings.wifi.WifiConfigUiBase
    public void dispatchSubmit() {
    }

    @Override // com.android.settings.wifi.WifiConfigUiBase
    public void setCancelButton(CharSequence r1) {
    }

    @Override // com.android.settings.wifi.WifiConfigUiBase
    public void setForgetButton(CharSequence r1) {
    }

    @Override // com.android.settings.wifi.WifiConfigUiBase
    public void setSubmitButton(CharSequence r1) {
    }

    public WifiDialog(Context r1, WifiDialogListener r2, AccessPoint r3, int r4, boolean r5) {
        this(r1, r2, r3, r4);
        this.mHideSubmitButton = r5;
    }

    public WifiDialog(Context r2, WifiDialogListener r3, AccessPoint r4, int r5) {
        super(r2, R.style.Theme_WifiDialog);
        this.mMode = r5;
        this.mListener = r3;
        this.mAccessPoint = r4;
        this.mHideSubmitButton = false;
    }

    @Override // com.android.settings.wifi.WifiConfigUiBase
    public WifiConfigController getController() {
        return this.mController;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle r5) {
        View r0 = getLayoutInflater().inflate(R.layout.wifi_dialog, null);
        this.mView = r0;
        setView(r0);
        setInverseBackgroundForced(true);
        this.mController = new WifiConfigController(this, this.mView, this.mAccessPoint, this.mMode);
        super.onCreate(r5);
        if (this.mHideSubmitButton == false) goto L5;
        this.mController.hideSubmitButton();
    L7:
        if (this.mAccessPoint != null) goto L10;
        this.mController.hideForgetButton();
        return;
    L10:
        return;
    L5:
        this.mController.enableSubmitIfAppropriate();
        goto L7
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle r1) {
        super.onRestoreInstanceState(r1);
        this.mController.updatePassword();
    }

    @Override // com.android.settings.wifi.WifiConfigUiBase
    public int getMode() {
        return this.mMode;
    }

    @Override // com.android.settings.wifi.WifiConfigUiBase
    public Button getSubmitButton() {
        return getButton(-1);
    }

    @Override // com.android.settings.wifi.WifiConfigUiBase
    public Button getForgetButton() {
        return getButton(-3);
    }

    @Override // com.android.settings.wifi.WifiConfigUiBase
    public Button getCancelButton() {
        return getButton(-2);
    }
}
