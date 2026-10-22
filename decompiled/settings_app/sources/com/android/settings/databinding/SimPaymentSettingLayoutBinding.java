package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class SimPaymentSettingLayoutBinding implements ViewBinding {
    public final SettingItemCheck nfcSim1;
    public final SettingItemCheck nfcSim2;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SimPaymentSettingLayoutBinding(LinearLayout r1, SettingItemCheck r2, SettingItemCheck r3) {
        this.rootView = r1;
        this.nfcSim1 = r2;
        this.nfcSim2 = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SimPaymentSettingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SimPaymentSettingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sim_payment_setting_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SimPaymentSettingLayoutBinding bind(View r3) {
        int r0 = R.id.nfc_sim_1;
        SettingItemCheck r1 = (SettingItemCheck) ViewBindings.findChildViewById(r3, R.id.nfc_sim_1);
        if (r1 == null) goto L9;
        r0 = R.id.nfc_sim_2;
        SettingItemCheck r2 = (SettingItemCheck) ViewBindings.findChildViewById(r3, R.id.nfc_sim_2);
        if (r2 == null) goto L9;
        return new SimPaymentSettingLayoutBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
