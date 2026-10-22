package com.android.settings;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsSafetyLegalActivity extends AlertActivity implements DialogInterface.OnCancelListener, DialogInterface.OnClickListener {
    private static final String PROPERTY_LSAFETYLEGAL_URL = "ro.url.safetylegal";
    private AlertDialog mErrorDialog;
    private WebView mWebView;

    public SettingsSafetyLegalActivity() {
        this.mErrorDialog = null;
    }

    static /* synthetic */ AlertController access$000(SettingsSafetyLegalActivity r0) {
        return r0.mAlert;
    }

    static /* synthetic */ void access$100(SettingsSafetyLegalActivity r0, String r1) {
        r0.showErrorAndFinish(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle r7) {
        super.onCreate(r7);
        String r0 = SystemProperties.get(PROPERTY_LSAFETYLEGAL_URL);
        Configuration r1 = getResources().getConfiguration();
        String r2 = String.format("%s&%s", new Object[]{r0, String.format("locale=%s-%s", new Object[]{r1.locale.getLanguage(), r1.locale.getCountry()})});
        WebView r3 = new WebView(this);
        this.mWebView = r3;
        r3.getSettings().setJavaScriptEnabled(true);
        if (r7 != null) goto L5;
        this.mWebView.loadUrl(r2);
    L6:
        this.mWebView.setWebViewClient(new AnonymousClass1(this));
        AlertController.AlertParams r8 = this.mAlertParams;
        r8.mTitle = getString(R.string.settings_safetylegal_activity_loading);
        r8.mView = this.mWebView;
        r8.mForceInverseBackground = true;
        setupAlert();
        return;
    L5:
        this.mWebView.restoreState(r7);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showErrorAndFinish(String r5) {
        AlertDialog r0 = this.mErrorDialog;
        if (r0 != null) goto L6;
        this.mErrorDialog = new AlertDialog.Builder(this, getResources().getInteger(R.integer.dialog_style_id)).setTitle(R.string.settings_safetylegal_activity_title).setPositiveButton(android.R.string.ok, this).setOnCancelListener(this).setCancelable(true).create();
    L8:
        this.mErrorDialog.setMessage(getResources().getString(R.string.settings_safetylegal_activity_unreachable, new Object[]{r5}));
        this.mErrorDialog.show();
        return;
    L6:
        if (r0.isShowing() == false) goto L8;
        this.mErrorDialog.dismiss();
        goto L8
    }

    protected void onDestroy() {
        super.onDestroy();
        AlertDialog r0 = this.mErrorDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        this.mErrorDialog = null;
        return;
    }

    public boolean dispatchKeyEvent(KeyEvent r3) {
        if (r3.getKeyCode() != 4) goto L11;
        if (r3.getAction() != 0) goto L11;
        if (this.mWebView.canGoBack() == false) goto L11;
        this.mWebView.goBack();
        return true;
    L11:
        return super.dispatchKeyEvent(r3);
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface r1) {
        finish();
    }

    public void onSaveInstanceState(Bundle r2) {
        this.mWebView.saveState(r2);
        super.onSaveInstanceState(r2);
    }
}
