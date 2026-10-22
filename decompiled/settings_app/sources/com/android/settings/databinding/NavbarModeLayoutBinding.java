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
import com.android.settings.widget.CustomNavbarStyleView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class NavbarModeLayoutBinding implements ViewBinding {
    public final NavbarModeGesureLayoutBinding gestureSupportLayout;
    public final OCardListItem hideNavHandle;
    public final TextView idGoToSetting;
    public final OCardListItem idNavbarModeSwitch;
    public final LinearLayout idSmartScreenProtectionContainer;
    public final LinearLayout navLayoutContainer;
    public final CustomNavbarStyleView navLayoutLeft;
    public final CustomNavbarStyleView navLayoutRight;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final TextView title;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NavbarModeLayoutBinding(RelativeLayout r1, NavbarModeGesureLayoutBinding r2, OCardListItem r3, TextView r4, OCardListItem r5, LinearLayout r6, LinearLayout r7, CustomNavbarStyleView r8, CustomNavbarStyleView r9, LinearLayout r10, OScrollView r11, TextView r12, OFloatingTitleBar r13) {
        this.rootView = r1;
        this.gestureSupportLayout = r2;
        this.hideNavHandle = r3;
        this.idGoToSetting = r4;
        this.idNavbarModeSwitch = r5;
        this.idSmartScreenProtectionContainer = r6;
        this.navLayoutContainer = r7;
        this.navLayoutLeft = r8;
        this.navLayoutRight = r9;
        this.pageContainer = r10;
        this.pageScrollview = r11;
        this.title = r12;
        this.viewTitle = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NavbarModeLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NavbarModeLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.navbar_mode_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NavbarModeLayoutBinding bind(View r17) {
        int r1 = R.id.gesture_support_layout;
        View r2 = ViewBindings.findChildViewById(r17, R.id.gesture_support_layout);
        if (r2 == null) goto L29;
        NavbarModeGesureLayoutBinding r5 = NavbarModeGesureLayoutBinding.bind(r2);
        r1 = R.id.hide_nav_handle;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.hide_nav_handle);
        if (r6 == null) goto L29;
        r1 = R.id.id_go_to_setting;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r17, R.id.id_go_to_setting);
        if (r7 == null) goto L29;
        r1 = R.id.id_navbar_mode_switch;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.id_navbar_mode_switch);
        if (r8 == null) goto L29;
        r1 = R.id.id_smart_screen_protection_container;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.id_smart_screen_protection_container);
        if (r9 == null) goto L29;
        r1 = R.id.nav_layout_container;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.nav_layout_container);
        if (r10 == null) goto L29;
        r1 = R.id.nav_layout_left;
        CustomNavbarStyleView r11 = (CustomNavbarStyleView) ViewBindings.findChildViewById(r17, R.id.nav_layout_left);
        if (r11 == null) goto L29;
        r1 = R.id.nav_layout_right;
        CustomNavbarStyleView r12 = (CustomNavbarStyleView) ViewBindings.findChildViewById(r17, R.id.nav_layout_right);
        if (r12 == null) goto L29;
        r1 = R.id.page_container;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.page_container);
        if (r13 == null) goto L29;
        r1 = R.id.page_scrollview;
        OScrollView r14 = (OScrollView) ViewBindings.findChildViewById(r17, R.id.page_scrollview);
        if (r14 == null) goto L29;
        r1 = R.id.title;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r17, R.id.title);
        if (r15 == null) goto L29;
        r1 = R.id.view_title;
        OFloatingTitleBar r16 = (OFloatingTitleBar) ViewBindings.findChildViewById(r17, R.id.view_title);
        if (r16 == null) goto L29;
        return new NavbarModeLayoutBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
