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
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class PrivacyPasswordSettingBinding implements ViewBinding {
    public final RelativeLayout btnLayout;
    public final OButton closePassword;
    public final SettingItemText itemApplicationLock;
    public final SettingItemText itemChangePassword;
    public final SettingItemText itemOriginApplicationLock;
    public final SettingItemText itemPlateLock;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PrivacyPasswordSettingBinding(RelativeLayout r1, RelativeLayout r2, OButton r3, SettingItemText r4, SettingItemText r5, SettingItemText r6, SettingItemText r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.btnLayout = r2;
        this.closePassword = r3;
        this.itemApplicationLock = r4;
        this.itemChangePassword = r5;
        this.itemOriginApplicationLock = r6;
        this.itemPlateLock = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PrivacyPasswordSettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PrivacyPasswordSettingBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.privacy_password_setting, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PrivacyPasswordSettingBinding bind(View r11) {
        int r0 = R.id.btnLayout;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r11, R.id.btnLayout);
        if (r4 == null) goto L19;
        r0 = R.id.close_password;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r11, R.id.close_password);
        if (r5 == null) goto L19;
        r0 = R.id.item_application_lock;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r11, R.id.item_application_lock);
        if (r6 == null) goto L19;
        r0 = R.id.item_change_password;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r11, R.id.item_change_password);
        if (r7 == null) goto L19;
        r0 = R.id.item_origin_application_lock;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r11, R.id.item_origin_application_lock);
        if (r8 == null) goto L19;
        r0 = R.id.item_plate_lock;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r11, R.id.item_plate_lock);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new PrivacyPasswordSettingBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
