package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentFingerprintSetupPaymentBinding implements ViewBinding {
    public final OButton btnDone;
    public final SettingItemCheck paymentAlipay;
    public final SettingItemCheck paymentUndefined;
    public final SettingItemCheck paymentWechat;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentFingerprintSetupPaymentBinding(RelativeLayout r1, OButton r2, SettingItemCheck r3, SettingItemCheck r4, SettingItemCheck r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.btnDone = r2;
        this.paymentAlipay = r3;
        this.paymentUndefined = r4;
        this.paymentWechat = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFingerprintSetupPaymentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentFingerprintSetupPaymentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_fingerprint_setup_payment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentFingerprintSetupPaymentBinding bind(View r9) {
        int r0 = R.id.btn_done;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r9, R.id.btn_done);
        if (r4 == null) goto L15;
        r0 = R.id.payment_alipay;
        SettingItemCheck r5 = (SettingItemCheck) ViewBindings.findChildViewById(r9, R.id.payment_alipay);
        if (r5 == null) goto L15;
        r0 = R.id.payment_undefined;
        SettingItemCheck r6 = (SettingItemCheck) ViewBindings.findChildViewById(r9, R.id.payment_undefined);
        if (r6 == null) goto L15;
        r0 = R.id.payment_wechat;
        SettingItemCheck r7 = (SettingItemCheck) ViewBindings.findChildViewById(r9, R.id.payment_wechat);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new FragmentFingerprintSetupPaymentBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
