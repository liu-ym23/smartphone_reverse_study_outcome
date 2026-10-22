package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SensorCalibrationLayoutBinding implements ViewBinding {
    public final OButton psensorCalibrateButton;
    public final TextView psensorFar;
    public final TextView psensorLowNoise;
    public final TextView psensorNear;
    private final RelativeLayout rootView;
    public final OButton sensorCalibrateButton;
    public final FrameLayout sensorCalibrationLogo;
    public final ProgressBar sensorCalibrationProgress;
    public final TextView sensorCalibrationText;
    public final TextView sensorCalibrationTips;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SensorCalibrationLayoutBinding(RelativeLayout r1, OButton r2, TextView r3, TextView r4, TextView r5, OButton r6, FrameLayout r7, ProgressBar r8, TextView r9, TextView r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.psensorCalibrateButton = r2;
        this.psensorFar = r3;
        this.psensorLowNoise = r4;
        this.psensorNear = r5;
        this.sensorCalibrateButton = r6;
        this.sensorCalibrationLogo = r7;
        this.sensorCalibrationProgress = r8;
        this.sensorCalibrationText = r9;
        this.sensorCalibrationTips = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SensorCalibrationLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SensorCalibrationLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sensor_calibration_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SensorCalibrationLayoutBinding bind(View r14) {
        int r0 = R.id.psensor_calibrate_button;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r14, R.id.psensor_calibrate_button);
        if (r4 == null) goto L25;
        r0 = R.id.psensor_far;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r14, R.id.psensor_far);
        if (r5 == null) goto L25;
        r0 = R.id.psensor_low_noise;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r14, R.id.psensor_low_noise);
        if (r6 == null) goto L25;
        r0 = R.id.psensor_near;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r14, R.id.psensor_near);
        if (r7 == null) goto L25;
        r0 = R.id.sensor_calibrate_button;
        OButton r8 = (OButton) ViewBindings.findChildViewById(r14, R.id.sensor_calibrate_button);
        if (r8 == null) goto L25;
        r0 = R.id.sensor_calibration_logo;
        FrameLayout r9 = (FrameLayout) ViewBindings.findChildViewById(r14, R.id.sensor_calibration_logo);
        if (r9 == null) goto L25;
        r0 = R.id.sensor_calibration_progress;
        ProgressBar r10 = (ProgressBar) ViewBindings.findChildViewById(r14, R.id.sensor_calibration_progress);
        if (r10 == null) goto L25;
        r0 = R.id.sensor_calibration_text;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r14, R.id.sensor_calibration_text);
        if (r11 == null) goto L25;
        r0 = R.id.sensor_calibration_tips;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r14, R.id.sensor_calibration_tips);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new SensorCalibrationLayoutBinding((RelativeLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
