package com.android.settings.nfc;

import android.content.Context;
import androidx.preference.DropDownPreference;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class NfcForegroundPreference extends DropDownPreference implements PaymentBackend.Callback {
    private final PaymentBackend mPaymentBackend;

    public NfcForegroundPreference(Context r1, PaymentBackend r2) {
        super(r1);
        this.mPaymentBackend = r2;
        r2.registerCallback(this);
        refresh();
    }

    @Override // com.android.settings.nfc.PaymentBackend.Callback
    public void onPaymentAppsChanged() {
        refresh();
    }

    void refresh() {
        this.mPaymentBackend.getDefaultApp();
        boolean r0 = this.mPaymentBackend.isForegroundMode();
        setPersistent(false);
        setTitle(getContext().getString(R.string.nfc_payment_use_default));
        setEntries(new CharSequence[]{getContext().getString(R.string.nfc_payment_favor_open), getContext().getString(R.string.nfc_payment_favor_default)});
        setEntryValues(new CharSequence[]{"1", "0"});
        if (r0 == false) goto L5;
        setValue("1");
        return;
    L5:
        setValue("0");
    }

    @Override // androidx.preference.Preference
    protected boolean persistString(String r2) {
        PaymentBackend r1 = this.mPaymentBackend;
        if (Integer.parseInt(r2) == 0) goto L5;
        boolean r3 = true;
    L6:
        r1.setForegroundMode(r3);
        return true;
    L5:
        r3 = false;
        goto L6
    }
}
