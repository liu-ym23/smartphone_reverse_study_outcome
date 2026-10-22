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
public final class StatusBarModeSettingsHeaderViewBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SettingItemCheck statusBarStyleAdaptive;
    public final SettingItemCheck statusBarStyleClassic;
    public final LinearLayout switchStatusbarModeSystemAppsContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StatusBarModeSettingsHeaderViewBinding(LinearLayout r1, SettingItemCheck r2, SettingItemCheck r3, LinearLayout r4) {
        this.rootView = r1;
        this.statusBarStyleAdaptive = r2;
        this.statusBarStyleClassic = r3;
        this.switchStatusbarModeSystemAppsContainer = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StatusBarModeSettingsHeaderViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StatusBarModeSettingsHeaderViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.status_bar_mode_settings_header_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StatusBarModeSettingsHeaderViewBinding bind(View r4) {
        int r0 = R.id.status_bar_style_adaptive;
        SettingItemCheck r1 = (SettingItemCheck) ViewBindings.findChildViewById(r4, R.id.status_bar_style_adaptive);
        if (r1 == null) goto L11;
        r0 = R.id.status_bar_style_classic;
        SettingItemCheck r2 = (SettingItemCheck) ViewBindings.findChildViewById(r4, R.id.status_bar_style_classic);
        if (r2 == null) goto L11;
        r0 = R.id.switch_statusbar_mode_system_apps_container;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.switch_statusbar_mode_system_apps_container);
        if (r3 == null) goto L11;
        return new StatusBarModeSettingsHeaderViewBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
