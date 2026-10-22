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
public final class ProximitySensorCalibrationLayoutBinding implements ViewBinding {
    public final TextView psensorCalibrationResult;
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

    private ProximitySensorCalibrationLayoutBinding(RelativeLayout r1, TextView r2, OButton r3, FrameLayout r4, ProgressBar r5, TextView r6, TextView r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.psensorCalibrationResult = r2;
        this.sensorCalibrateButton = r3;
        this.sensorCalibrationLogo = r4;
        this.sensorCalibrationProgress = r5;
        this.sensorCalibrationText = r6;
        this.sensorCalibrationTips = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ProximitySensorCalibrationLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ProximitySensorCalibrationLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.proximity_sensor_calibration_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ProximitySensorCalibrationLayoutBinding bind(View r11) {
        int r0 = R.id.psensor_calibration_result;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, R.id.psensor_calibration_result);
        if (r4 == null) goto L19;
        r0 = R.id.sensor_calibrate_button;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r11, R.id.sensor_calibrate_button);
        if (r5 == null) goto L19;
        r0 = R.id.sensor_calibration_logo;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r11, R.id.sensor_calibration_logo);
        if (r6 == null) goto L19;
        r0 = R.id.sensor_calibration_progress;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r11, R.id.sensor_calibration_progress);
        if (r7 == null) goto L19;
        r0 = R.id.sensor_calibration_text;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, R.id.sensor_calibration_text);
        if (r8 == null) goto L19;
        r0 = R.id.sensor_calibration_tips;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r11, R.id.sensor_calibration_tips);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new ProximitySensorCalibrationLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
