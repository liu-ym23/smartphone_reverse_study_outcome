package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.banner.OBanner;
import com.obric.oui.indicator.OCarouselIndicator;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityPickerLayoutBinding implements ViewBinding {
    public final OBanner oBanner;
    public final OCarouselIndicator oCarouselIndicator;
    private final ConstraintLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityPickerLayoutBinding(ConstraintLayout r1, OBanner r2, OCarouselIndicator r3) {
        this.rootView = r1;
        this.oBanner = r2;
        this.oCarouselIndicator = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPickerLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityPickerLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_picker_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityPickerLayoutBinding bind(View r3) {
        int r0 = R.id.o_banner;
        OBanner r1 = (OBanner) ViewBindings.findChildViewById(r3, R.id.o_banner);
        if (r1 == null) goto L9;
        r0 = R.id.o_carousel_indicator;
        OCarouselIndicator r2 = (OCarouselIndicator) ViewBindings.findChildViewById(r3, R.id.o_carousel_indicator);
        if (r2 == null) goto L9;
        return new ActivityPickerLayoutBinding((ConstraintLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
