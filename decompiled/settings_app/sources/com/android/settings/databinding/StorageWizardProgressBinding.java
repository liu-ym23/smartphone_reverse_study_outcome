package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.setupwizardlib.SetupWizardLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageWizardProgressBinding implements ViewBinding {
    private final SetupWizardLayout rootView;
    public final SetupWizardLayout setupWizardLayout;
    public final TextView storageWizardBody;
    public final ProgressBar storageWizardProgress;
    public final TextView storageWizardProgressSummary;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StorageWizardProgressBinding(SetupWizardLayout r1, SetupWizardLayout r2, TextView r3, ProgressBar r4, TextView r5) {
        this.rootView = r1;
        this.setupWizardLayout = r2;
        this.storageWizardBody = r3;
        this.storageWizardProgress = r4;
        this.storageWizardProgressSummary = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SetupWizardLayout getRoot() {
        return this.rootView;
    }

    public static StorageWizardProgressBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StorageWizardProgressBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_wizard_progress, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StorageWizardProgressBinding bind(View r6) {
        SetupWizardLayout r2 = (SetupWizardLayout) r6;
        int r0 = R.id.storage_wizard_body;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r6, R.id.storage_wizard_body);
        if (r3 == null) goto L11;
        r0 = R.id.storage_wizard_progress;
        ProgressBar r4 = (ProgressBar) ViewBindings.findChildViewById(r6, R.id.storage_wizard_progress);
        if (r4 == null) goto L11;
        r0 = R.id.storage_wizard_progress_summary;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r6, R.id.storage_wizard_progress_summary);
        if (r5 == null) goto L11;
        return new StorageWizardProgressBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
