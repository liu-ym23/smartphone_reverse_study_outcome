package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.setupwizardlib.SetupWizardLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageWizardReadyBinding implements ViewBinding {
    private final SetupWizardLayout rootView;
    public final SetupWizardLayout setupWizardLayout;
    public final TextView storageWizardReadyBody;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StorageWizardReadyBinding(SetupWizardLayout r1, SetupWizardLayout r2, TextView r3) {
        this.rootView = r1;
        this.setupWizardLayout = r2;
        this.storageWizardReadyBody = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SetupWizardLayout getRoot() {
        return this.rootView;
    }

    public static StorageWizardReadyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StorageWizardReadyBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_wizard_ready, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StorageWizardReadyBinding bind(View r3) {
        SetupWizardLayout r0 = (SetupWizardLayout) r3;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.storage_wizard_ready_body);
        if (r2 == null) goto L7;
        return new StorageWizardReadyBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(R.id.storage_wizard_ready_body)));
    }
}
