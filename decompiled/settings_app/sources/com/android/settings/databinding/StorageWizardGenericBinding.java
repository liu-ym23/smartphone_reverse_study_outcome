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
public final class StorageWizardGenericBinding implements ViewBinding {
    private final SetupWizardLayout rootView;
    public final SetupWizardLayout setupWizardLayout;
    public final TextView storageWizardBody;
    public final TextView storageWizardSecondBody;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StorageWizardGenericBinding(SetupWizardLayout r1, SetupWizardLayout r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.setupWizardLayout = r2;
        this.storageWizardBody = r3;
        this.storageWizardSecondBody = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SetupWizardLayout getRoot() {
        return this.rootView;
    }

    public static StorageWizardGenericBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StorageWizardGenericBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_wizard_generic, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StorageWizardGenericBinding bind(View r4) {
        SetupWizardLayout r0 = (SetupWizardLayout) r4;
        int r1 = R.id.storage_wizard_body;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.storage_wizard_body);
        if (r2 == null) goto L9;
        r1 = R.id.storage_wizard_second_body;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.storage_wizard_second_body);
        if (r3 == null) goto L9;
        return new StorageWizardGenericBinding(r0, r0, r2, r3);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r1)));
    }
}
