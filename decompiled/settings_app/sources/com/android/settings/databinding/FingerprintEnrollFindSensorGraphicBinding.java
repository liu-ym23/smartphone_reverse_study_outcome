package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.fingerprint.FingerprintLocationAnimationView;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintEnrollFindSensorGraphicBinding implements ViewBinding {
    public final ImageView fingerprintSensorLocation;
    public final FingerprintLocationAnimationView fingerprintSensorLocationAnimation;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerprintEnrollFindSensorGraphicBinding(FrameLayout r1, ImageView r2, FingerprintLocationAnimationView r3) {
        this.rootView = r1;
        this.fingerprintSensorLocation = r2;
        this.fingerprintSensorLocationAnimation = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintEnrollFindSensorGraphicBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintEnrollFindSensorGraphicBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_enroll_find_sensor_graphic, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintEnrollFindSensorGraphicBinding bind(View r3) {
        int r0 = R.id.fingerprint_sensor_location;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.fingerprint_sensor_location);
        if (r1 == null) goto L9;
        r0 = R.id.fingerprint_sensor_location_animation;
        FingerprintLocationAnimationView r2 = (FingerprintLocationAnimationView) ViewBindings.findChildViewById(r3, R.id.fingerprint_sensor_location_animation);
        if (r2 == null) goto L9;
        return new FingerprintEnrollFindSensorGraphicBinding((FrameLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
