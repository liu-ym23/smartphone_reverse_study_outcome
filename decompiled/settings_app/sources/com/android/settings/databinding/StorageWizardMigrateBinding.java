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
public final class StorageWizardMigrateBinding implements ViewBinding {
    private final SetupWizardLayout rootView;
    public final SetupWizardLayout setupWizardLayout;
    public final TextView storageWizardBody;
    public final RadioButton storageWizardMigrateLater;
    public final RadioButton storageWizardMigrateNow;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StorageWizardMigrateBinding(SetupWizardLayout r1, SetupWizardLayout r2, TextView r3, RadioButton r4, RadioButton r5) {
        this.rootView = r1;
        this.setupWizardLayout = r2;
        this.storageWizardBody = r3;
        this.storageWizardMigrateLater = r4;
        this.storageWizardMigrateNow = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SetupWizardLayout getRoot() {
        return this.rootView;
    }

    public static StorageWizardMigrateBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StorageWizardMigrateBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_wizard_migrate, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StorageWizardMigrateBinding bind(View r6) {
        SetupWizardLayout r2 = (SetupWizardLayout) r6;
        int r0 = R.id.storage_wizard_body;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r6, R.id.storage_wizard_body);
        if (r3 == null) goto L11;
        r0 = R.id.storage_wizard_migrate_later;
        RadioButton r4 = (RadioButton) ViewBindings.findChildViewById(r6, R.id.storage_wizard_migrate_later);
        if (r4 == null) goto L11;
        r0 = R.id.storage_wizard_migrate_now;
        RadioButton r5 = (RadioButton) ViewBindings.findChildViewById(r6, R.id.storage_wizard_migrate_now);
        if (r5 == null) goto L11;
        return new StorageWizardMigrateBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
