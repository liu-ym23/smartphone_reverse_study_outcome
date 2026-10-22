package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class QuickPaymentViaFingerprintLayoutBinding implements ViewBinding {
    public final SettingItemText paymentAlipay;
    public final SettingItemText paymentWechat;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private QuickPaymentViaFingerprintLayoutBinding(RelativeLayout r1, SettingItemText r2, SettingItemText r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.paymentAlipay = r2;
        this.paymentWechat = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static QuickPaymentViaFingerprintLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static QuickPaymentViaFingerprintLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.quick_payment_via_fingerprint_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static QuickPaymentViaFingerprintLayoutBinding bind(View r4) {
        int r0 = R.id.payment_alipay;
        SettingItemText r1 = (SettingItemText) ViewBindings.findChildViewById(r4, R.id.payment_alipay);
        if (r1 == null) goto L11;
        r0 = R.id.payment_wechat;
        SettingItemText r2 = (SettingItemText) ViewBindings.findChildViewById(r4, R.id.payment_wechat);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new QuickPaymentViaFingerprintLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
