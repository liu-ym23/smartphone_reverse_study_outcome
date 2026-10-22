package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AiPoweredFingerprintGuideAnimViewBinding implements ViewBinding {
    public final FrameLayout animLayer;
    public final LottieAnimationView guideAnimView;
    public final FrameLayout initLayer;
    public final ImageView introView;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AiPoweredFingerprintGuideAnimViewBinding(RelativeLayout r1, FrameLayout r2, LottieAnimationView r3, FrameLayout r4, ImageView r5) {
        this.rootView = r1;
        this.animLayer = r2;
        this.guideAnimView = r3;
        this.initLayer = r4;
        this.introView = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AiPoweredFingerprintGuideAnimViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AiPoweredFingerprintGuideAnimViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ai_powered_fingerprint_guide_anim_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AiPoweredFingerprintGuideAnimViewBinding bind(View r8) {
        int r0 = R.id.anim_layer;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.anim_layer);
        if (r4 == null) goto L13;
        r0 = R.id.guide_anim_view;
        LottieAnimationView r5 = (LottieAnimationView) ViewBindings.findChildViewById(r8, R.id.guide_anim_view);
        if (r5 == null) goto L13;
        r0 = R.id.init_layer;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.init_layer);
        if (r6 == null) goto L13;
        r0 = R.id.intro_view;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r8, R.id.intro_view);
        if (r7 == null) goto L13;
        return new AiPoweredFingerprintGuideAnimViewBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
