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
public final class LaserCalibrationLayoutBinding implements ViewBinding {
    public final OButton laserButton;
    public final OButton laserCalibrateButton10;
    public final OButton laserCalibrateButton60;
    public final TextView laserCalibrationHint;
    public final FrameLayout laserCalibrationLogo;
    public final ProgressBar laserCalibrationProgress;
    public final TextView laserCalibrationText;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LaserCalibrationLayoutBinding(RelativeLayout r1, OButton r2, OButton r3, OButton r4, TextView r5, FrameLayout r6, ProgressBar r7, TextView r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.laserButton = r2;
        this.laserCalibrateButton10 = r3;
        this.laserCalibrateButton60 = r4;
        this.laserCalibrationHint = r5;
        this.laserCalibrationLogo = r6;
        this.laserCalibrationProgress = r7;
        this.laserCalibrationText = r8;
        this.viewTitle = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LaserCalibrationLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LaserCalibrationLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.laser_calibration_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LaserCalibrationLayoutBinding bind(View r12) {
        int r0 = R.id.laser_button;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r12, R.id.laser_button);
        if (r4 == null) goto L21;
        r0 = R.id.laser_calibrate_button_10;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r12, R.id.laser_calibrate_button_10);
        if (r5 == null) goto L21;
        r0 = R.id.laser_calibrate_button_60;
        OButton r6 = (OButton) ViewBindings.findChildViewById(r12, R.id.laser_calibrate_button_60);
        if (r6 == null) goto L21;
        r0 = R.id.laser_calibration_hint;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, R.id.laser_calibration_hint);
        if (r7 == null) goto L21;
        r0 = R.id.laser_calibration_logo;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r12, R.id.laser_calibration_logo);
        if (r8 == null) goto L21;
        r0 = R.id.laser_calibration_progress;
        ProgressBar r9 = (ProgressBar) ViewBindings.findChildViewById(r12, R.id.laser_calibration_progress);
        if (r9 == null) goto L21;
        r0 = R.id.laser_calibration_text;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r12, R.id.laser_calibration_text);
        if (r10 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L21;
        return new LaserCalibrationLayoutBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
