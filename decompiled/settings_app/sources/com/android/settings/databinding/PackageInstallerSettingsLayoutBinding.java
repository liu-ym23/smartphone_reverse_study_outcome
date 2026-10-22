package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class PackageInstallerSettingsLayoutBinding implements ViewBinding {
    public final TextView idTextInputMethod;
    private final RelativeLayout rootView;
    public final SettingItemCheck sourceBytedance;
    public final SettingItemCheck sourceGooglePlay;
    public final SettingItemCheck sourceUnknown;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PackageInstallerSettingsLayoutBinding(RelativeLayout r1, TextView r2, SettingItemCheck r3, SettingItemCheck r4, SettingItemCheck r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.idTextInputMethod = r2;
        this.sourceBytedance = r3;
        this.sourceGooglePlay = r4;
        this.sourceUnknown = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PackageInstallerSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PackageInstallerSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.package_installer_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PackageInstallerSettingsLayoutBinding bind(View r9) {
        int r0 = R.id.id_text_input_method;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, R.id.id_text_input_method);
        if (r4 == null) goto L15;
        r0 = R.id.source_bytedance;
        SettingItemCheck r5 = (SettingItemCheck) ViewBindings.findChildViewById(r9, R.id.source_bytedance);
        if (r5 == null) goto L15;
        r0 = R.id.source_google_play;
        SettingItemCheck r6 = (SettingItemCheck) ViewBindings.findChildViewById(r9, R.id.source_google_play);
        if (r6 == null) goto L15;
        r0 = R.id.source_unknown;
        SettingItemCheck r7 = (SettingItemCheck) ViewBindings.findChildViewById(r9, R.id.source_unknown);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new PackageInstallerSettingsLayoutBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
