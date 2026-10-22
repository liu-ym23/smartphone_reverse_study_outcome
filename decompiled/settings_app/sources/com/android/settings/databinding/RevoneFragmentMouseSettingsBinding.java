package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.TickMarkView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneFragmentMouseSettingsBinding implements ViewBinding {
    public final SettingItemCheck mouseMainButtonLeft;
    public final SettingItemCheck mouseMainButtonRight;
    public final TickMarkView mousePointerSpeed;
    public final SettingItemSwitch mouseScrollFling;
    public final SettingItemCheck mouseScrollOrientationNatural;
    public final SettingItemCheck mouseScrollOrientationStandard;
    public final TickMarkView mouseScrollSpeed;
    public final SettingItemCheck mouseStyleCircle;
    public final SettingItemCheck mouseStylePointer;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneFragmentMouseSettingsBinding(RelativeLayout r1, SettingItemCheck r2, SettingItemCheck r3, TickMarkView r4, SettingItemSwitch r5, SettingItemCheck r6, SettingItemCheck r7, TickMarkView r8, SettingItemCheck r9, SettingItemCheck r10, LinearLayout r11, OScrollView r12, OFloatingTitleBar r13) {
        this.rootView = r1;
        this.mouseMainButtonLeft = r2;
        this.mouseMainButtonRight = r3;
        this.mousePointerSpeed = r4;
        this.mouseScrollFling = r5;
        this.mouseScrollOrientationNatural = r6;
        this.mouseScrollOrientationStandard = r7;
        this.mouseScrollSpeed = r8;
        this.mouseStyleCircle = r9;
        this.mouseStylePointer = r10;
        this.pageContainer = r11;
        this.pageScrollview = r12;
        this.viewTitle = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneFragmentMouseSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneFragmentMouseSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_fragment_mouse_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneFragmentMouseSettingsBinding bind(View r17) {
        int r1 = R.id.mouse_main_button_left;
        SettingItemCheck r5 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.mouse_main_button_left);
        if (r5 == null) goto L29;
        r1 = R.id.mouse_main_button_right;
        SettingItemCheck r6 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.mouse_main_button_right);
        if (r6 == null) goto L29;
        r1 = R.id.mouse_pointer_speed;
        TickMarkView r7 = (TickMarkView) ViewBindings.findChildViewById(r17, R.id.mouse_pointer_speed);
        if (r7 == null) goto L29;
        r1 = R.id.mouse_scroll_fling;
        SettingItemSwitch r8 = (SettingItemSwitch) ViewBindings.findChildViewById(r17, R.id.mouse_scroll_fling);
        if (r8 == null) goto L29;
        r1 = R.id.mouse_scroll_orientation_natural;
        SettingItemCheck r9 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.mouse_scroll_orientation_natural);
        if (r9 == null) goto L29;
        r1 = R.id.mouse_scroll_orientation_standard;
        SettingItemCheck r10 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.mouse_scroll_orientation_standard);
        if (r10 == null) goto L29;
        r1 = R.id.mouse_scroll_speed;
        TickMarkView r11 = (TickMarkView) ViewBindings.findChildViewById(r17, R.id.mouse_scroll_speed);
        if (r11 == null) goto L29;
        r1 = R.id.mouse_style_circle;
        SettingItemCheck r12 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.mouse_style_circle);
        if (r12 == null) goto L29;
        r1 = R.id.mouse_style_pointer;
        SettingItemCheck r13 = (SettingItemCheck) ViewBindings.findChildViewById(r17, R.id.mouse_style_pointer);
        if (r13 == null) goto L29;
        r1 = R.id.page_container;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.page_container);
        if (r14 == null) goto L29;
        r1 = R.id.page_scrollview;
        OScrollView r15 = (OScrollView) ViewBindings.findChildViewById(r17, R.id.page_scrollview);
        if (r15 == null) goto L29;
        r1 = R.id.view_title;
        OFloatingTitleBar r16 = (OFloatingTitleBar) ViewBindings.findChildViewById(r17, R.id.view_title);
        if (r16 == null) goto L29;
        return new RevoneFragmentMouseSettingsBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
