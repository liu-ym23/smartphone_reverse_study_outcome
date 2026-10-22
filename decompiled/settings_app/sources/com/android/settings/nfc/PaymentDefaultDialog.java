package com.android.settings.nfc;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;
import com.android.settings.Constants;
import com.android.settings.R;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class PaymentDefaultDialog extends AlertActivity implements DialogInterface.OnClickListener {
    private static final int PAYMENT_APP_MAX_CAPTION_LENGTH = 40;
    public static final String TAG = "PaymentDefaultDialog";
    private PaymentBackend mBackend;
    private PaymentBackend.PaymentInfo mNewDefault;

    public PaymentDefaultDialog() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.mBackend = new PaymentBackend(this);     // Catch: Exception -> L16
        Intent r5 = getIntent();
        ComponentName r0 = (ComponentName) r5.getParcelableExtra("component");     // Catch: Exception -> L13
        String r1 = r5.getStringExtra("category");     // Catch: Exception -> L13
        UserHandle r6 = (UserHandle) r5.getParcelableExtra("android.intent.extra.USER");     // Catch: Exception -> L13
        if (r6 != null) goto L8;
        int r7 = UserHandle.myUserId();     // Catch: Exception -> L13
    L9:
        setResult(0);     // Catch: Exception -> L13
        if (buildDialog(r0, r1, r7) == true) goto L23;
        finish();     // Catch: Exception -> L13
        return;
    L23:
        return;
    L8:
        r7 = r6.getIdentifier();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        return;
    L16:
        e = move-exception;
        OLog.e(TAG, "init PaymentBackend failed");
        e.printStackTrace();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r3, int r4) {
        if (r4 != (-1)) goto L7;
        this.mBackend.setDefaultPaymentApp(this.mNewDefault.componentName, this.mNewDefault.userId);
        setResult(-1);
        return;
    }

    private boolean buildDialog(ComponentName r7, String r8, int r9) {
        if (r7 == null) goto L41;
        if (r8 == null) goto L41;
        if (Constants.TYPE_PAYMENT.equals(r8) == true) goto L10;
        OLog.e(TAG, "Don't support defaults for category " + r8);
        return false;
    L10:
        PaymentBackend r10 = this.mBackend;
        if (r10 != null) goto L14;
        OLog.e(TAG, "mBackend is null");
        return false;
    L14:
        Iterator<PaymentBackend.PaymentAppInfo> r11 = r10.getPaymentAppInfos().iterator();
        PaymentBackend.PaymentAppInfo r2 = null;
        PaymentBackend.PaymentAppInfo r3 = null;
    L16:
        if (r11.hasNext() == false) goto L24;
        PaymentBackend.PaymentAppInfo r4 = r11.next();
        if (r7.equals(r4.componentName) == false) goto L21;
        r2 = r4;
    L21:
        if (r4.isDefault == false) goto L16;
        r3 = r4;
        goto L16
    L24:
        if (r2 != null) goto L27;
        OLog.e(TAG, "Component " + r7 + " is not a registered payment service.");
        return false;
    L27:
        PaymentBackend.PaymentInfo r5 = this.mBackend.getDefaultPaymentApp();
        if (r5 != null) goto L30;
    L35:
        PaymentBackend.PaymentInfo r12 = new PaymentBackend.PaymentInfo();
        this.mNewDefault = r12;
        r12.componentName = r7;
        this.mNewDefault.userId = r9;
        AlertController.AlertParams r13 = this.mAlertParams;
        r13.mTitle = getString(R.string.nfc_payment_set_default_label);
        if (r3 != null) goto L38;
        r13.mMessage = String.format(getString(R.string.nfc_payment_set_default), new Object[]{sanitizePaymentAppCaption(r2.label.toString())});
    L39:
        r13.mPositiveButtonText = getString(R.string.yes);
        r13.mNegativeButtonText = getString(R.string.no);
        r13.mPositiveButtonListener = this;
        r13.mNegativeButtonListener = this;
        setupAlert();
        return true;
    L38:
        r13.mMessage = String.format(getString(R.string.nfc_payment_set_default_instead_of), new Object[]{sanitizePaymentAppCaption(r2.label.toString()), sanitizePaymentAppCaption(r3.label.toString())});
        goto L39
    L30:
        if (r5.componentName == null) goto L35;
        if (r5.componentName.equals(r7) == false) goto L35;
        OLog.e(TAG, "Component " + r7 + " is already default.");
        return false;
    L41:
        OLog.e(TAG, "Component or category are null");
        return false;
    }

    private String sanitizePaymentAppCaption(String r2) {
        String r1 = r2.replace('\n', TokenParser.SP).replace(TokenParser.CR, TokenParser.SP).trim();
        if (r1.length() > 40) goto L5;
        return r1;
    L5:
        return r1.substring(0, 40);
    }
}
