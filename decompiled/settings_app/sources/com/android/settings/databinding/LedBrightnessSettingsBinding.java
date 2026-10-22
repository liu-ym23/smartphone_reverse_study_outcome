package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.BrightnessSeekBar;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class LedBrightnessSettingsBinding implements ViewBinding {
    public final Button resetBtn;
    private final RelativeLayout rootView;
    public final BrightnessSeekBar seekbarLeft;
    public final BrightnessSeekBar seekbarMiddle;
    public final BrightnessSeekBar seekbarRight;
    public final LinearLayout viewList;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LedBrightnessSettingsBinding(RelativeLayout r1, Button r2, BrightnessSeekBar r3, BrightnessSeekBar r4, BrightnessSeekBar r5, LinearLayout r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.resetBtn = r2;
        this.seekbarLeft = r3;
        this.seekbarMiddle = r4;
        this.seekbarRight = r5;
        this.viewList = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LedBrightnessSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LedBrightnessSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.led_brightness_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LedBrightnessSettingsBinding bind(View r10) {
        int r0 = R.id.reset_btn;
        Button r4 = (Button) ViewBindings.findChildViewById(r10, R.id.reset_btn);
        if (r4 == null) goto L17;
        r0 = R.id.seekbar_left;
        BrightnessSeekBar r5 = (BrightnessSeekBar) ViewBindings.findChildViewById(r10, R.id.seekbar_left);
        if (r5 == null) goto L17;
        r0 = R.id.seekbar_middle;
        BrightnessSeekBar r6 = (BrightnessSeekBar) ViewBindings.findChildViewById(r10, R.id.seekbar_middle);
        if (r6 == null) goto L17;
        r0 = R.id.seekbar_right;
        BrightnessSeekBar r7 = (BrightnessSeekBar) ViewBindings.findChildViewById(r10, R.id.seekbar_right);
        if (r7 == null) goto L17;
        r0 = R.id.view_list;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.view_list);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new LedBrightnessSettingsBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
