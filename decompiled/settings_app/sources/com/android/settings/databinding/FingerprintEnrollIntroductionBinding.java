package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.android.setupwizardlib.SetupWizardRecyclerLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintEnrollIntroductionBinding implements ViewBinding {
    private final SetupWizardRecyclerLayout rootView;
    public final SetupWizardRecyclerLayout setupWizardLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerprintEnrollIntroductionBinding(SetupWizardRecyclerLayout r1, SetupWizardRecyclerLayout r2) {
        this.rootView = r1;
        this.setupWizardLayout = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public SetupWizardRecyclerLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintEnrollIntroductionBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintEnrollIntroductionBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_enroll_introduction, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintEnrollIntroductionBinding bind(View r1) {
        if (r1 == null) goto L6;
        SetupWizardRecyclerLayout r2 = (SetupWizardRecyclerLayout) r1;
        return new FingerprintEnrollIntroductionBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
