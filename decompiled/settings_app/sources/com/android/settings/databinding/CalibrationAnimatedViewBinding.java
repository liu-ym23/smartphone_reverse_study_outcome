package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class CalibrationAnimatedViewBinding implements ViewBinding {
    public final ImageView calibrationImgDone;
    public final ImageView calibrationImgWave;
    private final View rootView;

    private CalibrationAnimatedViewBinding(View r1, ImageView r2, ImageView r3) {
        this.rootView = r1;
        this.calibrationImgDone = r2;
        this.calibrationImgWave = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static CalibrationAnimatedViewBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.calibration_animated_view, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static CalibrationAnimatedViewBinding bind(View r3) {
        int r0 = R.id.calibration_img_done;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.calibration_img_done);
        if (r1 == null) goto L9;
        r0 = R.id.calibration_img_wave;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r3, R.id.calibration_img_wave);
        if (r2 == null) goto L9;
        return new CalibrationAnimatedViewBinding(r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
