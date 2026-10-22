package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class EyeProtectionCustomCycleStubBinding implements ViewBinding {
    public final SettingItemText itemDisable;
    public final SettingItemText itemEnable;
    public final TextView itemsTitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private EyeProtectionCustomCycleStubBinding(LinearLayout r1, SettingItemText r2, SettingItemText r3, TextView r4) {
        this.rootView = r1;
        this.itemDisable = r2;
        this.itemEnable = r3;
        this.itemsTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EyeProtectionCustomCycleStubBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static EyeProtectionCustomCycleStubBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.eye_protection_custom_cycle_stub, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static EyeProtectionCustomCycleStubBinding bind(View r4) {
        int r0 = R.id.item_disable;
        SettingItemText r1 = (SettingItemText) ViewBindings.findChildViewById(r4, R.id.item_disable);
        if (r1 == null) goto L11;
        r0 = R.id.item_enable;
        SettingItemText r2 = (SettingItemText) ViewBindings.findChildViewById(r4, R.id.item_enable);
        if (r2 == null) goto L11;
        r0 = R.id.items_title;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.items_title);
        if (r3 == null) goto L11;
        return new EyeProtectionCustomCycleStubBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
