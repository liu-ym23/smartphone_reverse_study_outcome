package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.layout.OUILinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewBannerSoundModeBinding implements ViewBinding {
    public final OCheckBox ringModeCheckbox;
    public final OUILinearLayout ringModeContainer;
    private final FrameLayout rootView;
    public final OCheckBox silenceModeCheckbox;
    public final OUILinearLayout silenceModeContainer;
    public final OCheckBox vibrationModeCheckbox;
    public final OUILinearLayout vibrationModeContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewBannerSoundModeBinding(FrameLayout r1, OCheckBox r2, OUILinearLayout r3, OCheckBox r4, OUILinearLayout r5, OCheckBox r6, OUILinearLayout r7) {
        this.rootView = r1;
        this.ringModeCheckbox = r2;
        this.ringModeContainer = r3;
        this.silenceModeCheckbox = r4;
        this.silenceModeContainer = r5;
        this.vibrationModeCheckbox = r6;
        this.vibrationModeContainer = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewBannerSoundModeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewBannerSoundModeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_banner_sound_mode, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewBannerSoundModeBinding bind(View r10) {
        int r0 = R.id.ring_mode_checkbox;
        OCheckBox r4 = (OCheckBox) ViewBindings.findChildViewById(r10, R.id.ring_mode_checkbox);
        if (r4 == null) goto L17;
        r0 = R.id.ring_mode_container;
        OUILinearLayout r5 = (OUILinearLayout) ViewBindings.findChildViewById(r10, R.id.ring_mode_container);
        if (r5 == null) goto L17;
        r0 = R.id.silence_mode_checkbox;
        OCheckBox r6 = (OCheckBox) ViewBindings.findChildViewById(r10, R.id.silence_mode_checkbox);
        if (r6 == null) goto L17;
        r0 = R.id.silence_mode_container;
        OUILinearLayout r7 = (OUILinearLayout) ViewBindings.findChildViewById(r10, R.id.silence_mode_container);
        if (r7 == null) goto L17;
        r0 = R.id.vibration_mode_checkbox;
        OCheckBox r8 = (OCheckBox) ViewBindings.findChildViewById(r10, R.id.vibration_mode_checkbox);
        if (r8 == null) goto L17;
        r0 = R.id.vibration_mode_container;
        OUILinearLayout r9 = (OUILinearLayout) ViewBindings.findChildViewById(r10, R.id.vibration_mode_container);
        if (r9 == null) goto L17;
        return new ViewBannerSoundModeBinding((FrameLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
