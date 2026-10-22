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
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class MenuMovedownSettingLayoutBinding implements ViewBinding {
    public final SettingItemCheck moveDownAlways;
    public final SettingItemSwitch moveDownNc;
    public final SettingItemCheck moveDownWhenInApp;
    public final SettingItemCheck moveDownWhenInLauncher;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MenuMovedownSettingLayoutBinding(RelativeLayout r1, SettingItemCheck r2, SettingItemSwitch r3, SettingItemCheck r4, SettingItemCheck r5, LinearLayout r6, OScrollView r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.moveDownAlways = r2;
        this.moveDownNc = r3;
        this.moveDownWhenInApp = r4;
        this.moveDownWhenInLauncher = r5;
        this.pageContainer = r6;
        this.pageScrollview = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MenuMovedownSettingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MenuMovedownSettingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.menu_movedown_setting_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MenuMovedownSettingLayoutBinding bind(View r11) {
        int r0 = R.id.move_down_always;
        SettingItemCheck r4 = (SettingItemCheck) ViewBindings.findChildViewById(r11, R.id.move_down_always);
        if (r4 == null) goto L19;
        r0 = R.id.move_down_nc;
        SettingItemSwitch r5 = (SettingItemSwitch) ViewBindings.findChildViewById(r11, R.id.move_down_nc);
        if (r5 == null) goto L19;
        r0 = R.id.move_down_when_in_app;
        SettingItemCheck r6 = (SettingItemCheck) ViewBindings.findChildViewById(r11, R.id.move_down_when_in_app);
        if (r6 == null) goto L19;
        r0 = R.id.move_down_when_in_launcher;
        SettingItemCheck r7 = (SettingItemCheck) ViewBindings.findChildViewById(r11, R.id.move_down_when_in_launcher);
        if (r7 == null) goto L19;
        r0 = R.id.page_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.page_container);
        if (r8 == null) goto L19;
        r0 = R.id.page_scrollview;
        OScrollView r9 = (OScrollView) ViewBindings.findChildViewById(r11, R.id.page_scrollview);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new MenuMovedownSettingLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
