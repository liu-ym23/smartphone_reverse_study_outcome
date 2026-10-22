package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.layout.OUIFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewBannerSensorCalibrationBinding implements ViewBinding {
    public final ImageView imageContainer;
    private final OUIFrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewBannerSensorCalibrationBinding(OUIFrameLayout r1, ImageView r2) {
        this.rootView = r1;
        this.imageContainer = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OUIFrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewBannerSensorCalibrationBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewBannerSensorCalibrationBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_banner_sensor_calibration, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewBannerSensorCalibrationBinding bind(View r2) {
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r2, R.id.image_container);
        if (r1 == null) goto L7;
        return new ViewBannerSensorCalibrationBinding((OUIFrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.image_container)));
    }
}
