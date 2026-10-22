package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintEnrollEnrollingContentBinding implements ViewBinding {
    public final ImageView fingerprintAnimator;
    public final ProgressBar fingerprintProgressBar;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerprintEnrollEnrollingContentBinding(RelativeLayout r1, ImageView r2, ProgressBar r3) {
        this.rootView = r1;
        this.fingerprintAnimator = r2;
        this.fingerprintProgressBar = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintEnrollEnrollingContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintEnrollEnrollingContentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_enroll_enrolling_content, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintEnrollEnrollingContentBinding bind(View r3) {
        int r0 = R.id.fingerprint_animator;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.fingerprint_animator);
        if (r1 == null) goto L9;
        r0 = R.id.fingerprint_progress_bar;
        ProgressBar r2 = (ProgressBar) ViewBindings.findChildViewById(r3, R.id.fingerprint_progress_bar);
        if (r2 == null) goto L9;
        return new FingerprintEnrollEnrollingContentBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
