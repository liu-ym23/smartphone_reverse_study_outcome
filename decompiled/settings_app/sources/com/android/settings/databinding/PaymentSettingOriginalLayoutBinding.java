package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class PaymentSettingOriginalLayoutBinding implements ViewBinding {
    private final View rootView;
    public final OFloatingTitleBar viewTitle;

    private PaymentSettingOriginalLayoutBinding(View r1, OFloatingTitleBar r2) {
        this.rootView = r1;
        this.viewTitle = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static PaymentSettingOriginalLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.payment_setting_original_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static PaymentSettingOriginalLayoutBinding bind(View r2) {
        OFloatingTitleBar r1 = (OFloatingTitleBar) ViewBindings.findChildViewById(r2, R.id.view_title);
        if (r1 == null) goto L7;
        return new PaymentSettingOriginalLayoutBinding(r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.view_title)));
    }
}
