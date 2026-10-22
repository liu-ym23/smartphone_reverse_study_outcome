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
import com.android.settings.widget.SettingItemImage;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class GameSideBarSettingsBinding implements ViewBinding {
    public final OListView disabledFloatList;
    public final TextView floatApp;
    public final SettingItemImage floatAppSketchMap;
    public final TextView floatDisabledTips;
    public final TextView floatEnabledTips;
    public final LinearLayout floatLayout;
    public final View floatListItemBottomShadowLayout;
    public final SettingItemSwitch gameSideBar;
    public final TextView gameSideBarTips;
    public final SettingItemImage guide;
    public final LinearLayout loadingContainer;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final RelativeLayout parent;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private GameSideBarSettingsBinding(RelativeLayout r3, OListView r4, TextView r5, SettingItemImage r6, TextView r7, TextView r8, LinearLayout r9, View r10, SettingItemSwitch r11, TextView r12, SettingItemImage r13, LinearLayout r14, LinearLayout r15, OScrollView r16, RelativeLayout r17, OFloatingTitleBar r18) {
        this.rootView = r3;
        this.disabledFloatList = r4;
        this.floatApp = r5;
        this.floatAppSketchMap = r6;
        this.floatDisabledTips = r7;
        this.floatEnabledTips = r8;
        this.floatLayout = r9;
        this.floatListItemBottomShadowLayout = r10;
        this.gameSideBar = r11;
        this.gameSideBarTips = r12;
        this.guide = r13;
        this.loadingContainer = r14;
        this.pageContainer = r15;
        this.pageScrollview = r16;
        this.parent = r17;
        this.viewTitle = r18;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static GameSideBarSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static GameSideBarSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.game_side_bar_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static GameSideBarSettingsBinding bind(View r20) {
        int r1 = R.id.disabled_float_list;
        OListView r5 = (OListView) ViewBindings.findChildViewById(r20, R.id.disabled_float_list);
        if (r5 == null) goto L33;
        r1 = R.id.float_app;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r20, R.id.float_app);
        if (r6 == null) goto L33;
        r1 = R.id.float_app_sketch_map;
        SettingItemImage r7 = (SettingItemImage) ViewBindings.findChildViewById(r20, R.id.float_app_sketch_map);
        if (r7 == null) goto L33;
        r1 = R.id.float_disabled_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r20, R.id.float_disabled_tips);
        if (r8 == null) goto L33;
        r1 = R.id.float_enabled_tips;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r20, R.id.float_enabled_tips);
        if (r9 == null) goto L33;
        r1 = R.id.float_layout;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.float_layout);
        if (r10 == null) goto L33;
        r1 = R.id.float_list_item_bottom_shadow_layout;
        View r11 = ViewBindings.findChildViewById(r20, R.id.float_list_item_bottom_shadow_layout);
        if (r11 == null) goto L33;
        r1 = R.id.game_side_bar;
        SettingItemSwitch r12 = (SettingItemSwitch) ViewBindings.findChildViewById(r20, R.id.game_side_bar);
        if (r12 == null) goto L33;
        r1 = R.id.game_side_bar_tips;
        TextView r13 = (TextView) ViewBindings.findChildViewById(r20, R.id.game_side_bar_tips);
        if (r13 == null) goto L33;
        r1 = R.id.guide;
        SettingItemImage r14 = (SettingItemImage) ViewBindings.findChildViewById(r20, R.id.guide);
        if (r14 == null) goto L33;
        r1 = R.id.loading_container;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.loading_container);
        if (r15 == null) goto L33;
        r1 = R.id.page_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r20, R.id.page_container);
        if (r16 == null) goto L33;
        r1 = R.id.page_scrollview;
        OScrollView r17 = (OScrollView) ViewBindings.findChildViewById(r20, R.id.page_scrollview);
        if (r17 == null) goto L33;
        RelativeLayout r18 = (RelativeLayout) r20;
        r1 = R.id.view_title;
        OFloatingTitleBar r19 = (OFloatingTitleBar) ViewBindings.findChildViewById(r20, R.id.view_title);
        if (r19 == null) goto L33;
        return new GameSideBarSettingsBinding(r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r20.getResources().getResourceName(r1)));
    }
}
