package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.slider.SeekBarFloatCompat;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ProtectEyesSettingsLayoutBinding implements ViewBinding {
    public final OCardListItem autoTurnOnOff;
    public final OButton btnDefault;
    public final SeekBarFloatCompat colorTemperatureSeekbar;
    public final LinearLayout mainTitleElement;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem protectEyesEnable;
    public final OCardListItem rhythmicEyeProtection;
    private final RelativeLayout rootView;
    public final OUILinearLayout temperatureContainer;
    public final OTextView tvContentTitle;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ProtectEyesSettingsLayoutBinding(RelativeLayout r1, OCardListItem r2, OButton r3, SeekBarFloatCompat r4, LinearLayout r5, LinearLayout r6, OScrollView r7, OCardListItem r8, OCardListItem r9, OUILinearLayout r10, OTextView r11, OFloatingTitleBar r12) {
        this.rootView = r1;
        this.autoTurnOnOff = r2;
        this.btnDefault = r3;
        this.colorTemperatureSeekbar = r4;
        this.mainTitleElement = r5;
        this.pageContainer = r6;
        this.pageScrollview = r7;
        this.protectEyesEnable = r8;
        this.rhythmicEyeProtection = r9;
        this.temperatureContainer = r10;
        this.tvContentTitle = r11;
        this.viewTitle = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ProtectEyesSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ProtectEyesSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.protect_eyes_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ProtectEyesSettingsLayoutBinding bind(View r15) {
        int r0 = R.id.auto_turn_on_off;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.auto_turn_on_off);
        if (r4 == null) goto L27;
        r0 = R.id.btn_default;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r15, R.id.btn_default);
        if (r5 == null) goto L27;
        r0 = R.id.color_temperature_seekbar;
        SeekBarFloatCompat r6 = (SeekBarFloatCompat) ViewBindings.findChildViewById(r15, R.id.color_temperature_seekbar);
        if (r6 == null) goto L27;
        r0 = R.id.main_title_element;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.main_title_element);
        if (r7 == null) goto L27;
        r0 = R.id.page_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.page_container);
        if (r8 == null) goto L27;
        r0 = R.id.page_scrollview;
        OScrollView r9 = (OScrollView) ViewBindings.findChildViewById(r15, R.id.page_scrollview);
        if (r9 == null) goto L27;
        r0 = R.id.protect_eyes_enable;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.protect_eyes_enable);
        if (r10 == null) goto L27;
        r0 = R.id.rhythmic_eye_protection;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.rhythmic_eye_protection);
        if (r11 == null) goto L27;
        r0 = R.id.temperature_container;
        OUILinearLayout r12 = (OUILinearLayout) ViewBindings.findChildViewById(r15, R.id.temperature_container);
        if (r12 == null) goto L27;
        r0 = R.id.tv_content_title;
        OTextView r13 = (OTextView) ViewBindings.findChildViewById(r15, R.id.tv_content_title);
        if (r13 == null) goto L27;
        r0 = R.id.view_title;
        OFloatingTitleBar r14 = (OFloatingTitleBar) ViewBindings.findChildViewById(r15, R.id.view_title);
        if (r14 == null) goto L27;
        return new ProtectEyesSettingsLayoutBinding((RelativeLayout) r15, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
