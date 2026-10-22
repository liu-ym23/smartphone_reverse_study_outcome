package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceProfilesSettingsBinding implements ViewBinding {
    public final EditText name;
    public final TextView profilesLabel;
    public final LinearLayout profilesSection;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceProfilesSettingsBinding(LinearLayout r1, EditText r2, TextView r3, LinearLayout r4) {
        this.rootView = r1;
        this.name = r2;
        this.profilesLabel = r3;
        this.profilesSection = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DeviceProfilesSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceProfilesSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_profiles_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceProfilesSettingsBinding bind(View r4) {
        int r0 = R.id.name;
        EditText r1 = (EditText) ViewBindings.findChildViewById(r4, R.id.name);
        if (r1 == null) goto L11;
        r0 = R.id.profiles_label;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.profiles_label);
        if (r2 == null) goto L11;
        r0 = R.id.profiles_section;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.profiles_section);
        if (r3 == null) goto L11;
        return new DeviceProfilesSettingsBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
