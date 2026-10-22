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
public final class SetOrChangeLockMethodLayoutBinding implements ViewBinding {
    public final OCardListItem itemEnableVisiblePattern;
    public final ItemSubSettingsPaddingLayoutBinding itemEnableVisiblePatternShadow;
    public final OCardListItem itemModeEasy4;
    public final OCardListItem itemModeEasy6;
    public final OCardListItem itemModeHard;
    public final OCardListItem itemModePattern;
    public final OCardListItem itemModeSwipe;
    public final OCardListItem itemNeedPassward;
    public final ItemSubSettingsPaddingLayoutBinding itemNeedPasswardShadow;
    public final LinearLayout pageContainer;
    public final RelativeLayout pageRoot;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SetOrChangeLockMethodLayoutBinding(RelativeLayout r1, OCardListItem r2, ItemSubSettingsPaddingLayoutBinding r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, ItemSubSettingsPaddingLayoutBinding r10, LinearLayout r11, RelativeLayout r12, OScrollView r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.itemEnableVisiblePattern = r2;
        this.itemEnableVisiblePatternShadow = r3;
        this.itemModeEasy4 = r4;
        this.itemModeEasy6 = r5;
        this.itemModeHard = r6;
        this.itemModePattern = r7;
        this.itemModeSwipe = r8;
        this.itemNeedPassward = r9;
        this.itemNeedPasswardShadow = r10;
        this.pageContainer = r11;
        this.pageRoot = r12;
        this.pageScrollview = r13;
        this.viewTitle = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SetOrChangeLockMethodLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SetOrChangeLockMethodLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.set_or_change_lock_method_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SetOrChangeLockMethodLayoutBinding bind(View r18) {
        int r1 = R.id.item_enable_visible_pattern;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_enable_visible_pattern);
        if (r5 == null) goto L29;
        r1 = R.id.item_enable_visible_pattern_shadow;
        View r2 = ViewBindings.findChildViewById(r18, R.id.item_enable_visible_pattern_shadow);
        if (r2 == null) goto L29;
        ItemSubSettingsPaddingLayoutBinding r6 = ItemSubSettingsPaddingLayoutBinding.bind(r2);
        r1 = R.id.item_mode_easy_4;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_mode_easy_4);
        if (r7 == null) goto L29;
        r1 = R.id.item_mode_easy_6;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_mode_easy_6);
        if (r8 == null) goto L29;
        r1 = R.id.item_mode_hard;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_mode_hard);
        if (r9 == null) goto L29;
        r1 = R.id.item_mode_pattern;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_mode_pattern);
        if (r10 == null) goto L29;
        r1 = R.id.item_mode_swipe;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_mode_swipe);
        if (r11 == null) goto L29;
        r1 = R.id.item_need_passward;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_need_passward);
        if (r12 == null) goto L29;
        r1 = R.id.item_need_passward_shadow;
        View r3 = ViewBindings.findChildViewById(r18, R.id.item_need_passward_shadow);
        if (r3 == null) goto L29;
        ItemSubSettingsPaddingLayoutBinding r13 = ItemSubSettingsPaddingLayoutBinding.bind(r3);
        r1 = R.id.page_container;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.page_container);
        if (r14 == null) goto L29;
        RelativeLayout r15 = (RelativeLayout) r18;
        r1 = R.id.page_scrollview;
        OScrollView r16 = (OScrollView) ViewBindings.findChildViewById(r18, R.id.page_scrollview);
        if (r16 == null) goto L29;
        r1 = R.id.view_title;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.view_title);
        if (r17 == null) goto L29;
        return new SetOrChangeLockMethodLayoutBinding(r15, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
