package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.setupwizardlib.SetupWizardLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class SetupFingerprintEnrollFindSensorBaseBinding implements ViewBinding {
    public final Button nextButton;
    private final SetupWizardLayout rootView;
    public final SetupWizardLayout setupWizardLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SetupFingerprintEnrollFindSensorBaseBinding(SetupWizardLayout r1, Button r2, SetupWizardLayout r3) {
        this.rootView = r1;
        this.nextButton = r2;
        this.setupWizardLayout = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SetupWizardLayout getRoot() {
        return this.rootView;
    }

    public static SetupFingerprintEnrollFindSensorBaseBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SetupFingerprintEnrollFindSensorBaseBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setup_fingerprint_enroll_find_sensor_base, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SetupFingerprintEnrollFindSensorBaseBinding bind(View r2) {
        Button r1 = (Button) ViewBindings.findChildViewById(r2, R.id.next_button);
        if (r1 == null) goto L7;
        SetupWizardLayout r3 = (SetupWizardLayout) r2;
        return new SetupFingerprintEnrollFindSensorBaseBinding(r3, r1, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.next_button)));
    }
}
