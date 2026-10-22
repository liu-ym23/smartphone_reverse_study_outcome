package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class AppSettingsBinding implements ViewBinding {
    public final SettingItemText itemApplicationManage;
    public final SettingItemText itemDoppelganger;
    public final SettingItemText itemPermissions;
    public final SettingItemText itemPowersave;
    public final SettingItemText itemPreferredApp;
    public final SettingItemText itemStorage;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppSettingsBinding(RelativeLayout r1, SettingItemText r2, SettingItemText r3, SettingItemText r4, SettingItemText r5, SettingItemText r6, SettingItemText r7, LinearLayout r8, OScrollView r9, OFloatingTitleBar r10) {
        this.rootView = r1;
        this.itemApplicationManage = r2;
        this.itemDoppelganger = r3;
        this.itemPermissions = r4;
        this.itemPowersave = r5;
        this.itemPreferredApp = r6;
        this.itemStorage = r7;
        this.pageContainer = r8;
        this.pageScrollview = r9;
        this.viewTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppSettingsBinding bind(View r13) {
        int r0 = R.id.item_application_manage;
        SettingItemText r4 = (SettingItemText) ViewBindings.findChildViewById(r13, R.id.item_application_manage);
        if (r4 == null) goto L23;
        r0 = R.id.item_doppelganger;
        SettingItemText r5 = (SettingItemText) ViewBindings.findChildViewById(r13, R.id.item_doppelganger);
        if (r5 == null) goto L23;
        r0 = R.id.item_permissions;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r13, R.id.item_permissions);
        if (r6 == null) goto L23;
        r0 = R.id.item_powersave;
        SettingItemText r7 = (SettingItemText) ViewBindings.findChildViewById(r13, R.id.item_powersave);
        if (r7 == null) goto L23;
        r0 = R.id.item_preferred_app;
        SettingItemText r8 = (SettingItemText) ViewBindings.findChildViewById(r13, R.id.item_preferred_app);
        if (r8 == null) goto L23;
        r0 = R.id.item_storage;
        SettingItemText r9 = (SettingItemText) ViewBindings.findChildViewById(r13, R.id.item_storage);
        if (r9 == null) goto L23;
        r0 = R.id.page_container;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.page_container);
        if (r10 == null) goto L23;
        r0 = R.id.page_scrollview;
        OScrollView r11 = (OScrollView) ViewBindings.findChildViewById(r13, R.id.page_scrollview);
        if (r11 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r13, R.id.view_title);
        if (r12 == null) goto L23;
        return new AppSettingsBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
