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
public final class SetupWizardEldershipSwitcherBinding implements ViewBinding {
    public final SettingItemCheck itemUsageForEldership;
    public final SettingItemCheck itemUsageForMyself;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SetupWizardEldershipSwitcherBinding(LinearLayout r1, SettingItemCheck r2, SettingItemCheck r3) {
        this.rootView = r1;
        this.itemUsageForEldership = r2;
        this.itemUsageForMyself = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SetupWizardEldershipSwitcherBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SetupWizardEldershipSwitcherBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setup_wizard_eldership_switcher, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SetupWizardEldershipSwitcherBinding bind(View r3) {
        int r0 = R.id.item_usage_for_eldership;
        SettingItemCheck r1 = (SettingItemCheck) ViewBindings.findChildViewById(r3, R.id.item_usage_for_eldership);
        if (r1 == null) goto L9;
        r0 = R.id.item_usage_for_myself;
        SettingItemCheck r2 = (SettingItemCheck) ViewBindings.findChildViewById(r3, R.id.item_usage_for_myself);
        if (r2 == null) goto L9;
        return new SetupWizardEldershipSwitcherBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
