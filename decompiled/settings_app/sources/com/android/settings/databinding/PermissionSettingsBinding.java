package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class PermissionSettingsBinding implements ViewBinding {
    public final LinearLayout allDetails;
    public final LinearLayout permissionsSection;
    private final OScrollView rootView;
    public final TextView securitySettingsBillingDesc;
    public final LinearLayout securitySettingsBillingList;
    public final TextView securitySettingsDesc;
    public final LinearLayout securitySettingsList;
    public final Spinner securitySettingsPremiumSmsList;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PermissionSettingsBinding(OScrollView r1, LinearLayout r2, LinearLayout r3, TextView r4, LinearLayout r5, TextView r6, LinearLayout r7, Spinner r8) {
        this.rootView = r1;
        this.allDetails = r2;
        this.permissionsSection = r3;
        this.securitySettingsBillingDesc = r4;
        this.securitySettingsBillingList = r5;
        this.securitySettingsDesc = r6;
        this.securitySettingsList = r7;
        this.securitySettingsPremiumSmsList = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static PermissionSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PermissionSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.permission_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PermissionSettingsBinding bind(View r11) {
        int r0 = R.id.all_details;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.all_details);
        if (r4 == null) goto L19;
        r0 = R.id.permissions_section;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.permissions_section);
        if (r5 == null) goto L19;
        r0 = R.id.security_settings_billing_desc;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, R.id.security_settings_billing_desc);
        if (r6 == null) goto L19;
        r0 = R.id.security_settings_billing_list;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.security_settings_billing_list);
        if (r7 == null) goto L19;
        r0 = R.id.security_settings_desc;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, R.id.security_settings_desc);
        if (r8 == null) goto L19;
        r0 = R.id.security_settings_list;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.security_settings_list);
        if (r9 == null) goto L19;
        r0 = R.id.security_settings_premium_sms_list;
        Spinner r10 = (Spinner) ViewBindings.findChildViewById(r11, R.id.security_settings_premium_sms_list);
        if (r10 == null) goto L19;
        return new PermissionSettingsBinding((OScrollView) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
