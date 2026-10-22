package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.notification.RestrictedDropDownPreference;

/* JADX INFO: loaded from: classes2.dex */
public final class RestrictedPreferenceDropdownBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final RestrictedDropDownPreference.ReselectionSpinner spinner;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RestrictedPreferenceDropdownBinding(FrameLayout r1, RestrictedDropDownPreference.ReselectionSpinner r2) {
        this.rootView = r1;
        this.spinner = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static RestrictedPreferenceDropdownBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RestrictedPreferenceDropdownBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.restricted_preference_dropdown, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RestrictedPreferenceDropdownBinding bind(View r2) {
        RestrictedDropDownPreference.ReselectionSpinner r1 = (RestrictedDropDownPreference.ReselectionSpinner) ViewBindings.findChildViewById(r2, R.id.spinner);
        if (r1 == null) goto L7;
        return new RestrictedPreferenceDropdownBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.spinner)));
    }
}
