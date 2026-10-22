package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.setupwizardlib.SetupWizardLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintEnrollFinishBaseBinding implements ViewBinding {
    public final Button addAnotherButton;
    public final ImageView fingerprintInAppIndicator;
    public final TextView message;
    public final TextView messageSecondary;
    public final Button nextButton;
    private final SetupWizardLayout rootView;
    public final SetupWizardLayout setupWizardLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerprintEnrollFinishBaseBinding(SetupWizardLayout r1, Button r2, ImageView r3, TextView r4, TextView r5, Button r6, SetupWizardLayout r7) {
        this.rootView = r1;
        this.addAnotherButton = r2;
        this.fingerprintInAppIndicator = r3;
        this.message = r4;
        this.messageSecondary = r5;
        this.nextButton = r6;
        this.setupWizardLayout = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SetupWizardLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintEnrollFinishBaseBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintEnrollFinishBaseBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_enroll_finish_base, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintEnrollFinishBaseBinding bind(View r10) {
        int r0 = R.id.add_another_button;
        Button r4 = (Button) ViewBindings.findChildViewById(r10, R.id.add_another_button);
        if (r4 == null) goto L15;
        r0 = R.id.fingerprint_in_app_indicator;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, R.id.fingerprint_in_app_indicator);
        if (r5 == null) goto L15;
        r0 = R.id.message;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, R.id.message);
        if (r6 == null) goto L15;
        r0 = R.id.message_secondary;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, R.id.message_secondary);
        if (r7 == null) goto L15;
        r0 = R.id.next_button;
        Button r8 = (Button) ViewBindings.findChildViewById(r10, R.id.next_button);
        if (r8 == null) goto L15;
        SetupWizardLayout r9 = (SetupWizardLayout) r10;
        return new FingerprintEnrollFinishBaseBinding(r9, r4, r5, r6, r7, r8, r9);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
