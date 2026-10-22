package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.FrontFingerprintEnrollGuideAnimView;

/* JADX INFO: loaded from: classes2.dex */
public final class FrontFingerprintEnrollGuideAnimViewContainerLayoutBinding implements ViewBinding {
    public final FrontFingerprintEnrollGuideAnimView frontFpsEnrollGuideAnimView;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FrontFingerprintEnrollGuideAnimViewContainerLayoutBinding(RelativeLayout r1, FrontFingerprintEnrollGuideAnimView r2) {
        this.rootView = r1;
        this.frontFpsEnrollGuideAnimView = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FrontFingerprintEnrollGuideAnimViewContainerLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FrontFingerprintEnrollGuideAnimViewContainerLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.front_fingerprint_enroll_guide_anim_view_container_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FrontFingerprintEnrollGuideAnimViewContainerLayoutBinding bind(View r2) {
        FrontFingerprintEnrollGuideAnimView r1 = (FrontFingerprintEnrollGuideAnimView) ViewBindings.findChildViewById(r2, R.id.front_fps_enroll_guide_anim_view);
        if (r1 == null) goto L7;
        return new FrontFingerprintEnrollGuideAnimViewContainerLayoutBinding((RelativeLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.front_fps_enroll_guide_anim_view)));
    }
}
