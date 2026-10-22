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
public final class ScreenRefreshRateSettingBinding implements ViewBinding {
    public final OCardListItem autoScreenRefreshRate;
    public final OCardListItem highScreenRefreshRate;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem standardScreenRefreshRate;
    public final OCardListItem useHighScreenRefreshRetaApp;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ScreenRefreshRateSettingBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, LinearLayout r4, OScrollView r5, OCardListItem r6, OCardListItem r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.autoScreenRefreshRate = r2;
        this.highScreenRefreshRate = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.standardScreenRefreshRate = r6;
        this.useHighScreenRefreshRetaApp = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ScreenRefreshRateSettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScreenRefreshRateSettingBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.screen_refresh_rate_setting, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ScreenRefreshRateSettingBinding bind(View r11) {
        int r0 = R.id.auto_screen_refresh_rate;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.auto_screen_refresh_rate);
        if (r4 == null) goto L19;
        r0 = R.id.high_screen_refresh_rate;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.high_screen_refresh_rate);
        if (r5 == null) goto L19;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.page_container);
        if (r6 == null) goto L19;
        r0 = R.id.page_scrollview;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r11, R.id.page_scrollview);
        if (r7 == null) goto L19;
        r0 = R.id.standard_screen_refresh_rate;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.standard_screen_refresh_rate);
        if (r8 == null) goto L19;
        r0 = R.id.use_high_screen_refresh_reta_app;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.use_high_screen_refresh_reta_app);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new ScreenRefreshRateSettingBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
