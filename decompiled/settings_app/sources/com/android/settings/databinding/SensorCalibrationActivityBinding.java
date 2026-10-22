package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SensorCalibrationActivityBinding implements ViewBinding {
    public final OButton btnStartCalibration;
    public final FrameLayout frameLayout;
    public final LinearLayout pageContainer;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SensorCalibrationActivityBinding(RelativeLayout r1, OButton r2, FrameLayout r3, LinearLayout r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.btnStartCalibration = r2;
        this.frameLayout = r3;
        this.pageContainer = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SensorCalibrationActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SensorCalibrationActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sensor_calibration_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SensorCalibrationActivityBinding bind(View r8) {
        int r0 = R.id.btn_start_calibration;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r8, R.id.btn_start_calibration);
        if (r4 == null) goto L13;
        r0 = R.id.frame_layout;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.frame_layout);
        if (r5 == null) goto L13;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.page_container);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new SensorCalibrationActivityBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
