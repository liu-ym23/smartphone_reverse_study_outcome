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
public final class FingerprintEnrollEnrollingBaseBinding implements ViewBinding {
    public final TextView errorText;
    public final TextView repeatMessage;
    private final SetupWizardLayout rootView;
    public final SetupWizardLayout setupWizardLayout;
    public final TextView startMessage;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerprintEnrollEnrollingBaseBinding(SetupWizardLayout r1, TextView r2, TextView r3, SetupWizardLayout r4, TextView r5) {
        this.rootView = r1;
        this.errorText = r2;
        this.repeatMessage = r3;
        this.setupWizardLayout = r4;
        this.startMessage = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SetupWizardLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintEnrollEnrollingBaseBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintEnrollEnrollingBaseBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_enroll_enrolling_base, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintEnrollEnrollingBaseBinding bind(View r8) {
        int r0 = R.id.error_text;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.error_text);
        if (r4 == null) goto L11;
        r0 = R.id.repeat_message;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.repeat_message);
        if (r5 == null) goto L11;
        SetupWizardLayout r6 = (SetupWizardLayout) r8;
        r0 = R.id.start_message;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.start_message);
        if (r7 == null) goto L11;
        return new FingerprintEnrollEnrollingBaseBinding(r6, r4, r5, r6, r7);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
