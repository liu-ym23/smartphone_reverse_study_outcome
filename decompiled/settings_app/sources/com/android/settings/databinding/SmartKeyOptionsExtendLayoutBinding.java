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
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class SmartKeyOptionsExtendLayoutBinding implements ViewBinding {
    public final TextView doubleClickHeaderText;
    public final SettingItemCheck doubleClickLiveSubtitles;
    public final SettingItemCheck doubleClickOptionNone;
    public final SettingItemCheck doubleClickWallet;
    public final TextView headerText;
    public final SettingItemCheck idItemOptionCmel;
    public final SettingItemCheck idItemOptionIdeaPills;
    public final SettingItemCheck idItemOptionNone;
    public final SettingItemCheck idItemOptionOneStep;
    public final SettingItemImage ideaPillsVideoIntro;
    public final SettingItemImage oneStepVideoIntro;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SmartKeyOptionsExtendLayoutBinding(RelativeLayout r1, TextView r2, SettingItemCheck r3, SettingItemCheck r4, SettingItemCheck r5, TextView r6, SettingItemCheck r7, SettingItemCheck r8, SettingItemCheck r9, SettingItemCheck r10, SettingItemImage r11, SettingItemImage r12, LinearLayout r13, OScrollView r14, OFloatingTitleBar r15) {
        this.rootView = r1;
        this.doubleClickHeaderText = r2;
        this.doubleClickLiveSubtitles = r3;
        this.doubleClickOptionNone = r4;
        this.doubleClickWallet = r5;
        this.headerText = r6;
        this.idItemOptionCmel = r7;
        this.idItemOptionIdeaPills = r8;
        this.idItemOptionNone = r9;
        this.idItemOptionOneStep = r10;
        this.ideaPillsVideoIntro = r11;
        this.oneStepVideoIntro = r12;
        this.pageContainer = r13;
        this.pageScrollview = r14;
        this.viewTitle = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SmartKeyOptionsExtendLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SmartKeyOptionsExtendLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.smart_key_options_extend_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SmartKeyOptionsExtendLayoutBinding bind(View r19) {
        int r1 = R.id.double_click_header_text;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r19, R.id.double_click_header_text);
        if (r5 == null) goto L33;
        r1 = R.id.double_click_live_subtitles;
        SettingItemCheck r6 = (SettingItemCheck) ViewBindings.findChildViewById(r19, R.id.double_click_live_subtitles);
        if (r6 == null) goto L33;
        r1 = R.id.double_click_option_none;
        SettingItemCheck r7 = (SettingItemCheck) ViewBindings.findChildViewById(r19, R.id.double_click_option_none);
        if (r7 == null) goto L33;
        r1 = R.id.double_click_wallet;
        SettingItemCheck r8 = (SettingItemCheck) ViewBindings.findChildViewById(r19, R.id.double_click_wallet);
        if (r8 == null) goto L33;
        r1 = R.id.header_text;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r19, R.id.header_text);
        if (r9 == null) goto L33;
        r1 = R.id.id_item_option_cmel;
        SettingItemCheck r10 = (SettingItemCheck) ViewBindings.findChildViewById(r19, R.id.id_item_option_cmel);
        if (r10 == null) goto L33;
        r1 = R.id.id_item_option_idea_pills;
        SettingItemCheck r11 = (SettingItemCheck) ViewBindings.findChildViewById(r19, R.id.id_item_option_idea_pills);
        if (r11 == null) goto L33;
        r1 = R.id.id_item_option_none;
        SettingItemCheck r12 = (SettingItemCheck) ViewBindings.findChildViewById(r19, R.id.id_item_option_none);
        if (r12 == null) goto L33;
        r1 = R.id.id_item_option_one_step;
        SettingItemCheck r13 = (SettingItemCheck) ViewBindings.findChildViewById(r19, R.id.id_item_option_one_step);
        if (r13 == null) goto L33;
        r1 = R.id.idea_pills_video_intro;
        SettingItemImage r14 = (SettingItemImage) ViewBindings.findChildViewById(r19, R.id.idea_pills_video_intro);
        if (r14 == null) goto L33;
        r1 = R.id.one_step_video_intro;
        SettingItemImage r15 = (SettingItemImage) ViewBindings.findChildViewById(r19, R.id.one_step_video_intro);
        if (r15 == null) goto L33;
        r1 = R.id.page_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.page_container);
        if (r16 == null) goto L33;
        r1 = R.id.page_scrollview;
        OScrollView r17 = (OScrollView) ViewBindings.findChildViewById(r19, R.id.page_scrollview);
        if (r17 == null) goto L33;
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r19, R.id.view_title);
        if (r18 == null) goto L33;
        return new SmartKeyOptionsExtendLayoutBinding((RelativeLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
