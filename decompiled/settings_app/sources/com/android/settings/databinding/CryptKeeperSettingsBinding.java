package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemButton;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class CryptKeeperSettingsBinding implements ViewBinding {
    public final SettingItemButton initiateEncrypt;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final TextView tipWarningNeedLockScreen;
    public final OFloatingTitleBar viewTitle;
    public final TextView warningUnplugged;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CryptKeeperSettingsBinding(RelativeLayout r1, SettingItemButton r2, LinearLayout r3, OScrollView r4, TextView r5, OFloatingTitleBar r6, TextView r7) {
        this.rootView = r1;
        this.initiateEncrypt = r2;
        this.pageContainer = r3;
        this.pageScrollview = r4;
        this.tipWarningNeedLockScreen = r5;
        this.viewTitle = r6;
        this.warningUnplugged = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CryptKeeperSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CryptKeeperSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.crypt_keeper_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CryptKeeperSettingsBinding bind(View r10) {
        int r0 = R.id.initiate_encrypt;
        SettingItemButton r4 = (SettingItemButton) ViewBindings.findChildViewById(r10, R.id.initiate_encrypt);
        if (r4 == null) goto L17;
        r0 = R.id.page_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r5 == null) goto L17;
        r0 = R.id.page_scrollview;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r10, R.id.page_scrollview);
        if (r6 == null) goto L17;
        r0 = R.id.tip_warning_need_lock_screen;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, R.id.tip_warning_need_lock_screen);
        if (r7 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r8 == null) goto L17;
        r0 = R.id.warning_unplugged;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r10, R.id.warning_unplugged);
        if (r9 == null) goto L17;
        return new CryptKeeperSettingsBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
