package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class VisualAccessibilitySettingsFragmentBinding implements ViewBinding {
    public final OCardListItem colorCorrection;
    public final OCardListItem colorInversion;
    public final OCardListItem largePointerIcon;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem screenMagnification;
    public final ItemBottomShadowLayout2Binding shadowBelowSpeakPassword;
    public final OCardListItem speakPassword;
    public final OCardListItem speechReading;
    public final TextView speechTips;
    public final OCardListItem textHighContrast;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private VisualAccessibilitySettingsFragmentBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4, LinearLayout r5, OScrollView r6, OCardListItem r7, ItemBottomShadowLayout2Binding r8, OCardListItem r9, OCardListItem r10, TextView r11, OCardListItem r12, OFloatingTitleBar r13) {
        this.rootView = r1;
        this.colorCorrection = r2;
        this.colorInversion = r3;
        this.largePointerIcon = r4;
        this.pageContainer = r5;
        this.pageScrollview = r6;
        this.screenMagnification = r7;
        this.shadowBelowSpeakPassword = r8;
        this.speakPassword = r9;
        this.speechReading = r10;
        this.speechTips = r11;
        this.textHighContrast = r12;
        this.viewTitle = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static VisualAccessibilitySettingsFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static VisualAccessibilitySettingsFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.visual_accessibility_settings_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static VisualAccessibilitySettingsFragmentBinding bind(View r17) {
        int r1 = R.id.color_correction;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.color_correction);
        if (r5 == null) goto L29;
        r1 = R.id.color_inversion;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.color_inversion);
        if (r6 == null) goto L29;
        r1 = R.id.large_pointer_icon;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.large_pointer_icon);
        if (r7 == null) goto L29;
        r1 = R.id.page_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.page_container);
        if (r8 == null) goto L29;
        r1 = R.id.page_scrollview;
        OScrollView r9 = (OScrollView) ViewBindings.findChildViewById(r17, R.id.page_scrollview);
        if (r9 == null) goto L29;
        r1 = R.id.screen_magnification;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.screen_magnification);
        if (r10 == null) goto L29;
        r1 = R.id.shadow_below_speak_password;
        View r2 = ViewBindings.findChildViewById(r17, R.id.shadow_below_speak_password);
        if (r2 == null) goto L29;
        ItemBottomShadowLayout2Binding r11 = ItemBottomShadowLayout2Binding.bind(r2);
        r1 = R.id.speak_password;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.speak_password);
        if (r12 == null) goto L29;
        r1 = R.id.speech_reading;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.speech_reading);
        if (r13 == null) goto L29;
        r1 = R.id.speech_tips;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r17, R.id.speech_tips);
        if (r14 == null) goto L29;
        r1 = R.id.text_high_contrast;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.text_high_contrast);
        if (r15 == null) goto L29;
        r1 = R.id.view_title;
        OFloatingTitleBar r16 = (OFloatingTitleBar) ViewBindings.findChildViewById(r17, R.id.view_title);
        if (r16 == null) goto L29;
        return new VisualAccessibilitySettingsFragmentBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
