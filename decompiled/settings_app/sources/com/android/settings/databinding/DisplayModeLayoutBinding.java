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
public final class DisplayModeLayoutBinding implements ViewBinding {
    public final OCardListItem autoCloseCustom;
    public final LinearLayout autoCloseCustomContainer;
    public final OCardListItem autoCloseSunTime;
    public final OCardListItem displayDarkMode;
    public final OCardListItem displayLightMode;
    public final OCardListItem displayModeEndTime;
    public final OCardListItem displayModeStartTime;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem setTimeOpenDarkMode;
    public final LinearLayout timeOpenDarkModeContainer;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DisplayModeLayoutBinding(RelativeLayout r1, OCardListItem r2, LinearLayout r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, LinearLayout r9, OScrollView r10, OCardListItem r11, LinearLayout r12, OFloatingTitleBar r13) {
        this.rootView = r1;
        this.autoCloseCustom = r2;
        this.autoCloseCustomContainer = r3;
        this.autoCloseSunTime = r4;
        this.displayDarkMode = r5;
        this.displayLightMode = r6;
        this.displayModeEndTime = r7;
        this.displayModeStartTime = r8;
        this.pageContainer = r9;
        this.pageScrollview = r10;
        this.setTimeOpenDarkMode = r11;
        this.timeOpenDarkModeContainer = r12;
        this.viewTitle = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DisplayModeLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DisplayModeLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.display_mode_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DisplayModeLayoutBinding bind(View r17) {
        int r1 = R.id.auto_close_custom;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.auto_close_custom);
        if (r5 == null) goto L29;
        r1 = R.id.auto_close_custom_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.auto_close_custom_container);
        if (r6 == null) goto L29;
        r1 = R.id.auto_close_sun_time;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.auto_close_sun_time);
        if (r7 == null) goto L29;
        r1 = R.id.display_dark_mode;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.display_dark_mode);
        if (r8 == null) goto L29;
        r1 = R.id.display_light_mode;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.display_light_mode);
        if (r9 == null) goto L29;
        r1 = R.id.display_mode_end_time;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.display_mode_end_time);
        if (r10 == null) goto L29;
        r1 = R.id.display_mode_start_time;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.display_mode_start_time);
        if (r11 == null) goto L29;
        r1 = R.id.page_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.page_container);
        if (r12 == null) goto L29;
        r1 = R.id.page_scrollview;
        OScrollView r13 = (OScrollView) ViewBindings.findChildViewById(r17, R.id.page_scrollview);
        if (r13 == null) goto L29;
        r1 = R.id.set_time_open_dark_mode;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.set_time_open_dark_mode);
        if (r14 == null) goto L29;
        r1 = R.id.time_open_dark_mode_container;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.time_open_dark_mode_container);
        if (r15 == null) goto L29;
        r1 = R.id.view_title;
        OFloatingTitleBar r16 = (OFloatingTitleBar) ViewBindings.findChildViewById(r17, R.id.view_title);
        if (r16 == null) goto L29;
        return new DisplayModeLayoutBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
