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
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityExpertiseSettingsFragmentBinding implements ViewBinding {
    public final OCardListItem accessibilityGlobalGesture;
    public final OCardListItem autoClick;
    public final OCardListItem idAccessibilityHearingAccess;
    public final ItemSubSettingsPaddingLayout2Binding idAccessibilityHearingShadow;
    public final OCardListItem idAccessibilityVisualAccess;
    public final OCardListItem masterMono;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem powerButtonEndsCall;
    private final RelativeLayout rootView;
    public final OCardListItem selectLongPressTimeoutPreference;
    public final ItemSubSettingsPaddingLayout2Binding shadowBelowPowerButtonEndsCall;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AccessibilityExpertiseSettingsFragmentBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4, ItemSubSettingsPaddingLayout2Binding r5, OCardListItem r6, OCardListItem r7, LinearLayout r8, OScrollView r9, OCardListItem r10, OCardListItem r11, ItemSubSettingsPaddingLayout2Binding r12, OFloatingTitleBar r13) {
        this.rootView = r1;
        this.accessibilityGlobalGesture = r2;
        this.autoClick = r3;
        this.idAccessibilityHearingAccess = r4;
        this.idAccessibilityHearingShadow = r5;
        this.idAccessibilityVisualAccess = r6;
        this.masterMono = r7;
        this.pageContainer = r8;
        this.pageScrollview = r9;
        this.powerButtonEndsCall = r10;
        this.selectLongPressTimeoutPreference = r11;
        this.shadowBelowPowerButtonEndsCall = r12;
        this.viewTitle = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AccessibilityExpertiseSettingsFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AccessibilityExpertiseSettingsFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.accessibility_expertise_settings_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AccessibilityExpertiseSettingsFragmentBinding bind(View r17) {
        int r1 = R.id.accessibility_global_gesture;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.accessibility_global_gesture);
        if (r5 == null) goto L29;
        r1 = R.id.auto_click;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.auto_click);
        if (r6 == null) goto L29;
        r1 = R.id.id_accessibility_hearing_access;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.id_accessibility_hearing_access);
        if (r7 == null) goto L29;
        r1 = R.id.id_accessibility_hearing_shadow;
        View r2 = ViewBindings.findChildViewById(r17, R.id.id_accessibility_hearing_shadow);
        if (r2 == null) goto L29;
        ItemSubSettingsPaddingLayout2Binding r8 = ItemSubSettingsPaddingLayout2Binding.bind(r2);
        r1 = R.id.id_accessibility_visual_access;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.id_accessibility_visual_access);
        if (r9 == null) goto L29;
        r1 = R.id.master_mono;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.master_mono);
        if (r10 == null) goto L29;
        r1 = R.id.page_container;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.page_container);
        if (r11 == null) goto L29;
        r1 = R.id.page_scrollview;
        OScrollView r12 = (OScrollView) ViewBindings.findChildViewById(r17, R.id.page_scrollview);
        if (r12 == null) goto L29;
        r1 = R.id.power_button_ends_call;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.power_button_ends_call);
        if (r13 == null) goto L29;
        r1 = R.id.select_long_press_timeout_preference;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.select_long_press_timeout_preference);
        if (r14 == null) goto L29;
        r1 = R.id.shadow_below_power_button_ends_call;
        View r3 = ViewBindings.findChildViewById(r17, R.id.shadow_below_power_button_ends_call);
        if (r3 == null) goto L29;
        ItemSubSettingsPaddingLayout2Binding r15 = ItemSubSettingsPaddingLayout2Binding.bind(r3);
        r1 = R.id.view_title;
        OFloatingTitleBar r16 = (OFloatingTitleBar) ViewBindings.findChildViewById(r17, R.id.view_title);
        if (r16 == null) goto L29;
        return new AccessibilityExpertiseSettingsFragmentBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
