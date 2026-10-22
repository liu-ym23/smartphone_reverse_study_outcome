package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ShadowFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintEnrollWizardBinding implements ViewBinding {
    public final TextView fingerprintFilmTips;
    public final TextView fingerprintLawTips;
    public final TextView fingerprintSetupTips;
    public final OButton nextStepBtn;
    public final ShadowFrameLayout nextStepBtnGroup;
    private final FrameLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerprintEnrollWizardBinding(FrameLayout r1, TextView r2, TextView r3, TextView r4, OButton r5, ShadowFrameLayout r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.fingerprintFilmTips = r2;
        this.fingerprintLawTips = r3;
        this.fingerprintSetupTips = r4;
        this.nextStepBtn = r5;
        this.nextStepBtnGroup = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintEnrollWizardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintEnrollWizardBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_enroll_wizard, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintEnrollWizardBinding bind(View r10) {
        int r0 = R.id.fingerprint_film_tips;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, R.id.fingerprint_film_tips);
        if (r4 == null) goto L17;
        r0 = R.id.fingerprint_law_tips;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, R.id.fingerprint_law_tips);
        if (r5 == null) goto L17;
        r0 = R.id.fingerprint_setup_tips;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, R.id.fingerprint_setup_tips);
        if (r6 == null) goto L17;
        r0 = R.id.next_step_btn;
        OButton r7 = (OButton) ViewBindings.findChildViewById(r10, R.id.next_step_btn);
        if (r7 == null) goto L17;
        r0 = R.id.next_step_btn_group;
        ShadowFrameLayout r8 = (ShadowFrameLayout) ViewBindings.findChildViewById(r10, R.id.next_step_btn_group);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new FingerprintEnrollWizardBinding((FrameLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
