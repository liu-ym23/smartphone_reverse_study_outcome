package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.banner.OBanner;
import com.obric.oui.indicator.OCarouselIndicator;
import com.obric.oui.layout.OUILinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewBannerAiFingerprintBinding implements ViewBinding {
    public final OBanner banner;
    public final OUILinearLayout bannerLayout;
    private final FrameLayout rootView;
    public final OCarouselIndicator viewPagerIndicator;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewBannerAiFingerprintBinding(FrameLayout r1, OBanner r2, OUILinearLayout r3, OCarouselIndicator r4) {
        this.rootView = r1;
        this.banner = r2;
        this.bannerLayout = r3;
        this.viewPagerIndicator = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewBannerAiFingerprintBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewBannerAiFingerprintBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_banner_ai_fingerprint, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewBannerAiFingerprintBinding bind(View r4) {
        int r0 = R.id.banner;
        OBanner r1 = (OBanner) ViewBindings.findChildViewById(r4, R.id.banner);
        if (r1 == null) goto L11;
        r0 = R.id.bannerLayout;
        OUILinearLayout r2 = (OUILinearLayout) ViewBindings.findChildViewById(r4, R.id.bannerLayout);
        if (r2 == null) goto L11;
        r0 = R.id.view_pager_indicator;
        OCarouselIndicator r3 = (OCarouselIndicator) ViewBindings.findChildViewById(r4, R.id.view_pager_indicator);
        if (r3 == null) goto L11;
        return new ViewBannerAiFingerprintBinding((FrameLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
