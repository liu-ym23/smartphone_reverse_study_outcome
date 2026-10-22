package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.android.setupwizardlib.SetupWizardPreferenceLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class SetupPreferenceBinding implements ViewBinding {
    public final SetupWizardPreferenceLayout listContainer;
    private final SetupWizardPreferenceLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SetupPreferenceBinding(SetupWizardPreferenceLayout r1, SetupWizardPreferenceLayout r2) {
        this.rootView = r1;
        this.listContainer = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SetupWizardPreferenceLayout getRoot() {
        return this.rootView;
    }

    public static SetupPreferenceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SetupPreferenceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setup_preference, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SetupPreferenceBinding bind(View r1) {
        if (r1 == null) goto L6;
        SetupWizardPreferenceLayout r2 = (SetupWizardPreferenceLayout) r1;
        return new SetupPreferenceBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
