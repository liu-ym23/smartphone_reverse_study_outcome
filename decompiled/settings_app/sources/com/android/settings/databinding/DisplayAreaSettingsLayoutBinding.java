package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemImage;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class DisplayAreaSettingsLayoutBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final SettingItemCheck showContentBelowStatusBar;
    public final SettingItemImage showContentBelowStatusBarImage;
    public final SettingItemCheck statusBarTitleAdaptive;
    public final SettingItemImage statusBarTitleAdaptiveImage;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DisplayAreaSettingsLayoutBinding(RelativeLayout r1, LinearLayout r2, OScrollView r3, SettingItemCheck r4, SettingItemImage r5, SettingItemCheck r6, SettingItemImage r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.pageScrollview = r3;
        this.showContentBelowStatusBar = r4;
        this.showContentBelowStatusBarImage = r5;
        this.statusBarTitleAdaptive = r6;
        this.statusBarTitleAdaptiveImage = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DisplayAreaSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DisplayAreaSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.display_area_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DisplayAreaSettingsLayoutBinding bind(View r11) {
        int r0 = R.id.page_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.page_container);
        if (r4 == null) goto L19;
        r0 = R.id.page_scrollview;
        OScrollView r5 = (OScrollView) ViewBindings.findChildViewById(r11, R.id.page_scrollview);
        if (r5 == null) goto L19;
        r0 = R.id.show_content_below_status_bar;
        SettingItemCheck r6 = (SettingItemCheck) ViewBindings.findChildViewById(r11, R.id.show_content_below_status_bar);
        if (r6 == null) goto L19;
        r0 = R.id.show_content_below_status_bar_image;
        SettingItemImage r7 = (SettingItemImage) ViewBindings.findChildViewById(r11, R.id.show_content_below_status_bar_image);
        if (r7 == null) goto L19;
        r0 = R.id.status_bar_title_adaptive;
        SettingItemCheck r8 = (SettingItemCheck) ViewBindings.findChildViewById(r11, R.id.status_bar_title_adaptive);
        if (r8 == null) goto L19;
        r0 = R.id.status_bar_title_adaptive_image;
        SettingItemImage r9 = (SettingItemImage) ViewBindings.findChildViewById(r11, R.id.status_bar_title_adaptive_image);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new DisplayAreaSettingsLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
