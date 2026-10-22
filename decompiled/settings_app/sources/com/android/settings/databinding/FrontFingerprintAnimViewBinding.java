package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.FingerprintEnrollIntroductionImageView;
import com.android.settings.widget.FingerprintEnrollProgressLottieView;

/* JADX INFO: loaded from: classes2.dex */
public final class FrontFingerprintAnimViewBinding implements ViewBinding {
    public final FingerprintEnrollIntroductionImageView initBaseBg;
    public final FrameLayout initLayer;
    public final FrameLayout progressLayer;
    private final RelativeLayout rootView;
    public final FingerprintEnrollProgressLottieView udfpsProgressLottie;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FrontFingerprintAnimViewBinding(RelativeLayout r1, FingerprintEnrollIntroductionImageView r2, FrameLayout r3, FrameLayout r4, FingerprintEnrollProgressLottieView r5) {
        this.rootView = r1;
        this.initBaseBg = r2;
        this.initLayer = r3;
        this.progressLayer = r4;
        this.udfpsProgressLottie = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FrontFingerprintAnimViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FrontFingerprintAnimViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.front_fingerprint_anim_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FrontFingerprintAnimViewBinding bind(View r8) {
        int r0 = R.id.init_base_bg;
        FingerprintEnrollIntroductionImageView r4 = (FingerprintEnrollIntroductionImageView) ViewBindings.findChildViewById(r8, R.id.init_base_bg);
        if (r4 == null) goto L13;
        r0 = R.id.init_layer;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.init_layer);
        if (r5 == null) goto L13;
        r0 = R.id.progress_layer;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.progress_layer);
        if (r6 == null) goto L13;
        r0 = R.id.udfps_progress_lottie;
        FingerprintEnrollProgressLottieView r7 = (FingerprintEnrollProgressLottieView) ViewBindings.findChildViewById(r8, R.id.udfps_progress_lottie);
        if (r7 == null) goto L13;
        return new FrontFingerprintAnimViewBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
