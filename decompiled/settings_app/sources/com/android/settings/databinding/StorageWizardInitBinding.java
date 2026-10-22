package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.setupwizardlib.SetupWizardLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageWizardInitBinding implements ViewBinding {
    private final SetupWizardLayout rootView;
    public final SetupWizardLayout setupWizardLayout;
    public final TextView storageWizardInitExternalSummary;
    public final RadioButton storageWizardInitExternalTitle;
    public final TextView storageWizardInitInternalSummary;
    public final RadioButton storageWizardInitInternalTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StorageWizardInitBinding(SetupWizardLayout r1, SetupWizardLayout r2, TextView r3, RadioButton r4, TextView r5, RadioButton r6) {
        this.rootView = r1;
        this.setupWizardLayout = r2;
        this.storageWizardInitExternalSummary = r3;
        this.storageWizardInitExternalTitle = r4;
        this.storageWizardInitInternalSummary = r5;
        this.storageWizardInitInternalTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SetupWizardLayout getRoot() {
        return this.rootView;
    }

    public static StorageWizardInitBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StorageWizardInitBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_wizard_init, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StorageWizardInitBinding bind(View r7) {
        SetupWizardLayout r2 = (SetupWizardLayout) r7;
        int r0 = R.id.storage_wizard_init_external_summary;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r7, R.id.storage_wizard_init_external_summary);
        if (r3 == null) goto L13;
        r0 = R.id.storage_wizard_init_external_title;
        RadioButton r4 = (RadioButton) ViewBindings.findChildViewById(r7, R.id.storage_wizard_init_external_title);
        if (r4 == null) goto L13;
        r0 = R.id.storage_wizard_init_internal_summary;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r7, R.id.storage_wizard_init_internal_summary);
        if (r5 == null) goto L13;
        r0 = R.id.storage_wizard_init_internal_title;
        RadioButton r6 = (RadioButton) ViewBindings.findChildViewById(r7, R.id.storage_wizard_init_internal_title);
        if (r6 == null) goto L13;
        return new StorageWizardInitBinding(r2, r2, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }
}
