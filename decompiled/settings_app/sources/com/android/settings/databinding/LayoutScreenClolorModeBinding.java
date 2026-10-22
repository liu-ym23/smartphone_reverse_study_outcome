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
import com.android.settings.display.color.ScreenTemperatureView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutScreenClolorModeBinding implements ViewBinding {
    public final OCardListItem adaptive;
    public final OCardListItem adaptiveTemperature;
    public final FrameLayout banner;
    public final LinearLayout colorTemperatureContainer;
    public final OSectionTitleBar colorTemperatureTitle;
    public final ScreenTemperatureView colorTemperatureView;
    public final OSectionTitleBar colorTitle;
    public final LinearLayout constraintRootView;
    public final OSectionSupportiveText eyeProtectedTips;
    public final OCardListItem professional;
    private final RelativeLayout rootView;
    public final OScrollView scrollView;
    public final OCardListItem standard;
    public final OFloatingTitleBar titleBar;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LayoutScreenClolorModeBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, FrameLayout r4, LinearLayout r5, OSectionTitleBar r6, ScreenTemperatureView r7, OSectionTitleBar r8, LinearLayout r9, OSectionSupportiveText r10, OCardListItem r11, OScrollView r12, OCardListItem r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.adaptive = r2;
        this.adaptiveTemperature = r3;
        this.banner = r4;
        this.colorTemperatureContainer = r5;
        this.colorTemperatureTitle = r6;
        this.colorTemperatureView = r7;
        this.colorTitle = r8;
        this.constraintRootView = r9;
        this.eyeProtectedTips = r10;
        this.professional = r11;
        this.scrollView = r12;
        this.standard = r13;
        this.titleBar = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutScreenClolorModeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LayoutScreenClolorModeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.layout_screen_clolor_mode, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LayoutScreenClolorModeBinding bind(View r18) {
        int r1 = R.id.adaptive;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.adaptive);
        if (r5 == null) goto L31;
        r1 = R.id.adaptive_temperature;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.adaptive_temperature);
        if (r6 == null) goto L31;
        r1 = R.id.banner;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r18, R.id.banner);
        if (r7 == null) goto L31;
        r1 = R.id.color_temperature_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.color_temperature_container);
        if (r8 == null) goto L31;
        r1 = R.id.color_temperature_title;
        OSectionTitleBar r9 = (OSectionTitleBar) ViewBindings.findChildViewById(r18, R.id.color_temperature_title);
        if (r9 == null) goto L31;
        r1 = R.id.color_temperature_view;
        ScreenTemperatureView r10 = (ScreenTemperatureView) ViewBindings.findChildViewById(r18, R.id.color_temperature_view);
        if (r10 == null) goto L31;
        r1 = R.id.color_title;
        OSectionTitleBar r11 = (OSectionTitleBar) ViewBindings.findChildViewById(r18, R.id.color_title);
        if (r11 == null) goto L31;
        r1 = R.id.constraint_root_view;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.constraint_root_view);
        if (r12 == null) goto L31;
        r1 = R.id.eye_protected_tips;
        OSectionSupportiveText r13 = (OSectionSupportiveText) ViewBindings.findChildViewById(r18, R.id.eye_protected_tips);
        if (r13 == null) goto L31;
        r1 = R.id.professional;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.professional);
        if (r14 == null) goto L31;
        r1 = R.id.scroll_view;
        OScrollView r15 = (OScrollView) ViewBindings.findChildViewById(r18, R.id.scroll_view);
        if (r15 == null) goto L31;
        r1 = R.id.standard;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.standard);
        if (r16 == null) goto L31;
        r1 = R.id.title_bar;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.title_bar);
        if (r17 == null) goto L31;
        return new LayoutScreenClolorModeBinding((RelativeLayout) r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
