package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsPermissionHeadBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout settingsPremissionHeader;
    public final OSectionSupportiveText tvPermissionDesc;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingsPermissionHeadBinding(LinearLayout r1, LinearLayout r2, OSectionSupportiveText r3) {
        this.rootView = r1;
        this.settingsPremissionHeader = r2;
        this.tvPermissionDesc = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SettingsPermissionHeadBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingsPermissionHeadBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.settings_permission_head, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingsPermissionHeadBinding bind(View r3) {
        int r0 = R.id.settings_premission_header;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r3, R.id.settings_premission_header);
        if (r1 == null) goto L9;
        r0 = R.id.tv_permission_desc;
        OSectionSupportiveText r2 = (OSectionSupportiveText) ViewBindings.findChildViewById(r3, R.id.tv_permission_desc);
        if (r2 == null) goto L9;
        return new SettingsPermissionHeadBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
