package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class SecurityLayoutBinding implements ViewBinding {
    public final SettingItemText battery;
    public final SettingItemText itemAdvanced;
    public final SettingItemText itemDataUsage;
    public final SettingItemText itemMemory;
    public final SettingItemText itemPackageInstallerSettings;
    public final SettingItemText itemPermissionManager;
    public final SettingItemText junkFilesCleanup;
    private final RelativeLayout rootView;
    public final OScrollView scrollView;
    public final SettingItemText trustedEnvironment;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SecurityLayoutBinding(RelativeLayout r1, SettingItemText r2, SettingItemText r3, SettingItemText r4, SettingItemText r5, SettingItemText r6, SettingItemText r7, SettingItemText r8, OScrollView r9, SettingItemText r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.battery = r2;
        this.itemAdvanced = r3;
        this.itemDataUsage = r4;
        this.itemMemory = r5;
        this.itemPackageInstallerSettings = r6;
        this.itemPermissionManager = r7;
        this.junkFilesCleanup = r8;
        this.scrollView = r9;
        this.trustedEnvironment = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SecurityLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SecurityLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.security_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SecurityLayoutBinding bind(View r14) {
        int r0 = R.id.battery;
        SettingItemText r4 = (SettingItemText) ViewBindings.findChildViewById(r14, R.id.battery);
        if (r4 == null) goto L25;
        r0 = R.id.item_advanced;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r14, R.id.item_advanced);
        if (r5 == null) goto L25;
        r0 = R.id.item_data_usage;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r14, R.id.item_data_usage);
        if (r6 == null) goto L25;
        r0 = R.id.item_memory;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r14, R.id.item_memory);
        if (r7 == null) goto L25;
        r0 = R.id.item_package_installer_settings;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r14, R.id.item_package_installer_settings);
        if (r8 == null) goto L25;
        r0 = R.id.item_permission_manager;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r14, R.id.item_permission_manager);
        if (r9 == null) goto L25;
        r0 = R.id.junk_files_cleanup;
        SettingItemText r10 = (SettingItemText) ViewBindings.findChildViewById(r14, R.id.junk_files_cleanup);
        if (r10 == null) goto L25;
        r0 = R.id.scroll_view;
        OScrollView r11 = (OScrollView) ViewBindings.findChildViewById(r14, R.id.scroll_view);
        if (r11 == null) goto L25;
        r0 = R.id.trusted_environment;
        SettingItemText r12 = (SettingItemText) ViewBindings.findChildViewById(r14, R.id.trusted_environment);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new SecurityLayoutBinding((RelativeLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
