package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.CalibrationAnimtedView;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class HeadsetCalibrationLayoutBinding implements ViewBinding {
    public final OUILinearLayout apNetworkSharing;
    public final CalibrationAnimtedView calDownKey;
    public final CalibrationAnimtedView calUpKey;
    public final TextView calibrateDoneTips;
    public final TextView calibratingTips;
    public final OButton done;
    public final OButton none;
    public final CalibrationAnimtedView placeHolder;
    public final OButton pressed;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private HeadsetCalibrationLayoutBinding(RelativeLayout r1, OUILinearLayout r2, CalibrationAnimtedView r3, CalibrationAnimtedView r4, TextView r5, TextView r6, OButton r7, OButton r8, CalibrationAnimtedView r9, OButton r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.apNetworkSharing = r2;
        this.calDownKey = r3;
        this.calUpKey = r4;
        this.calibrateDoneTips = r5;
        this.calibratingTips = r6;
        this.done = r7;
        this.none = r8;
        this.placeHolder = r9;
        this.pressed = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HeadsetCalibrationLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static HeadsetCalibrationLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.headset_calibration_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static HeadsetCalibrationLayoutBinding bind(View r14) {
        int r0 = R.id.ap_network_sharing;
        OUILinearLayout r4 = (OUILinearLayout) ViewBindings.findChildViewById(r14, R.id.ap_network_sharing);
        if (r4 == null) goto L25;
        r0 = R.id.cal_down_key;
        CalibrationAnimtedView r5 = (CalibrationAnimtedView) ViewBindings.findChildViewById(r14, R.id.cal_down_key);
        if (r5 == null) goto L25;
        r0 = R.id.cal_up_key;
        CalibrationAnimtedView r6 = (CalibrationAnimtedView) ViewBindings.findChildViewById(r14, R.id.cal_up_key);
        if (r6 == null) goto L25;
        r0 = R.id.calibrate_done_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r14, R.id.calibrate_done_tips);
        if (r7 == null) goto L25;
        r0 = R.id.calibrating_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r14, R.id.calibrating_tips);
        if (r8 == null) goto L25;
        r0 = R.id.done;
        OButton r9 = (OButton) ViewBindings.findChildViewById(r14, R.id.done);
        if (r9 == null) goto L25;
        r0 = R.id.none;
        OButton r10 = (OButton) ViewBindings.findChildViewById(r14, R.id.none);
        if (r10 == null) goto L25;
        r0 = R.id.place_holder;
        CalibrationAnimtedView r11 = (CalibrationAnimtedView) ViewBindings.findChildViewById(r14, R.id.place_holder);
        if (r11 == null) goto L25;
        r0 = R.id.pressed;
        OButton r12 = (OButton) ViewBindings.findChildViewById(r14, R.id.pressed);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new HeadsetCalibrationLayoutBinding((RelativeLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
