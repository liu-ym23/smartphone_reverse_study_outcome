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
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class TabletShortcutLayoutBinding implements ViewBinding {
    public final SettingItemSwitch btnL1;
    public final SettingItemSwitch btnL2;
    public final SettingItemSwitch btnL3;
    public final SettingItemSwitch btnL4;
    public final SettingItemSwitch btnL5;
    public final SettingItemSwitch btnR1;
    public final SettingItemSwitch btnR2;
    public final SettingItemSwitch btnR3;
    public final SettingItemSwitch btnR4;
    public final SettingItemSwitch btnR5;
    public final SettingItemSwitch globalToggle;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final LinearLayout switchListViews;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TabletShortcutLayoutBinding(RelativeLayout r3, SettingItemSwitch r4, SettingItemSwitch r5, SettingItemSwitch r6, SettingItemSwitch r7, SettingItemSwitch r8, SettingItemSwitch r9, SettingItemSwitch r10, SettingItemSwitch r11, SettingItemSwitch r12, SettingItemSwitch r13, SettingItemSwitch r14, LinearLayout r15, OScrollView r16, LinearLayout r17, OFloatingTitleBar r18) {
        this.rootView = r3;
        this.btnL1 = r4;
        this.btnL2 = r5;
        this.btnL3 = r6;
        this.btnL4 = r7;
        this.btnL5 = r8;
        this.btnR1 = r9;
        this.btnR2 = r10;
        this.btnR3 = r11;
        this.btnR4 = r12;
        this.btnR5 = r13;
        this.globalToggle = r14;
        this.pageContainer = r15;
        this.pageScrollview = r16;
        this.switchListViews = r17;
        this.viewTitle = r18;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TabletShortcutLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TabletShortcutLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tablet_shortcut_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TabletShortcutLayoutBinding bind(View r20) {
        int r1 = R.id.btn_l1;
        SettingItemSwitch r5 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.btn_l1);
        if (r5 == null) goto L35;
        r1 = R.id.btn_l2;
        SettingItemSwitch r6 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.btn_l2);
        if (r6 == null) goto L35;
        r1 = R.id.btn_l3;
        SettingItemSwitch r7 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.btn_l3);
        if (r7 == null) goto L35;
        r1 = R.id.btn_l4;
        SettingItemSwitch r8 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.btn_l4);
        if (r8 == null) goto L35;
        r1 = R.id.btn_l5;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.btn_l5);
        if (r9 == null) goto L35;
        r1 = R.id.btn_r1;
        SettingItemSwitch r10 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.btn_r1);
        if (r10 == null) goto L35;
        r1 = R.id.btn_r2;
        SettingItemSwitch r11 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.btn_r2);
        if (r11 == null) goto L35;
        r1 = R.id.btn_r3;
        SettingItemSwitch r12 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.btn_r3);
        if (r12 == null) goto L35;
        r1 = R.id.btn_r4;
        SettingItemSwitch r13 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.btn_r4);
        if (r13 == null) goto L35;
        r1 = R.id.btn_r5;
        SettingItemSwitch r14 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.btn_r5);
        if (r14 == null) goto L35;
        r1 = R.id.global_toggle;
        SettingItemSwitch r15 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.global_toggle);
        if (r15 == null) goto L35;
        r1 = R.id.page_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.page_container);
        if (r16 == null) goto L35;
        r1 = R.id.page_scrollview;
        OScrollView r17 = (OScrollView) ViewBindings.findChildViewById(r20, R.id.page_scrollview);
        if (r17 == null) goto L35;
        r1 = R.id.switch_list_views;
        LinearLayout r18 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.switch_list_views);
        if (r18 == null) goto L35;
        r1 = R.id.view_title;
        OFloatingTitleBar r19 = (OFloatingTitleBar) ViewBindings.findChildViewById(r20, R.id.view_title);
        if (r19 == null) goto L35;
        return new TabletShortcutLayoutBinding((RelativeLayout) r20, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r20.getResources().getResourceName(r1)));
    }
}
