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
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneFragmentBytedanceTntAssistBinding implements ViewBinding {
    public final SettingItemImage connectTntItemImage;
    public final TextView controlsHintTips;
    public final SettingItemImage controlsTntItemImage;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final ListContentItemText tntDefaultMode;
    public final OFloatingTitleBar viewTitle;
    public final ListContentItemText wifiTnt;
    public final GroupListItemVerticalGapLayoutBinding wifiTntGapLayout;
    public final SettingItemImage wifiTntItemImage;
    public final TextView wifiTntTips;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneFragmentBytedanceTntAssistBinding(RelativeLayout r1, SettingItemImage r2, TextView r3, SettingItemImage r4, LinearLayout r5, OScrollView r6, ListContentItemText r7, OFloatingTitleBar r8, ListContentItemText r9, GroupListItemVerticalGapLayoutBinding r10, SettingItemImage r11, TextView r12) {
        this.rootView = r1;
        this.connectTntItemImage = r2;
        this.controlsHintTips = r3;
        this.controlsTntItemImage = r4;
        this.pageContainer = r5;
        this.pageScrollview = r6;
        this.tntDefaultMode = r7;
        this.viewTitle = r8;
        this.wifiTnt = r9;
        this.wifiTntGapLayout = r10;
        this.wifiTntItemImage = r11;
        this.wifiTntTips = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneFragmentBytedanceTntAssistBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneFragmentBytedanceTntAssistBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_fragment_bytedance_tnt_assist, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneFragmentBytedanceTntAssistBinding bind(View r15) {
        int r0 = R.id.connect_tnt_item_image;
        SettingItemImage r4 = (SettingItemImage) ViewBindings.findChildViewById(r15, R.id.connect_tnt_item_image);
        if (r4 == null) goto L27;
        r0 = R.id.controls_hint_tips;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r15, R.id.controls_hint_tips);
        if (r5 == null) goto L27;
        r0 = R.id.controls_tnt_item_image;
        SettingItemImage r6 = (SettingItemImage) ViewBindings.findChildViewById(r15, R.id.controls_tnt_item_image);
        if (r6 == null) goto L27;
        r0 = R.id.page_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.page_container);
        if (r7 == null) goto L27;
        r0 = R.id.page_scrollview;
        OScrollView r8 = (OScrollView) ViewBindings.findChildViewById(r15, R.id.page_scrollview);
        if (r8 == null) goto L27;
        r0 = R.id.tnt_default_mode;
        ListContentItemText r9 = (ListContentItemText) ViewBindings.findChildViewById(r15, R.id.tnt_default_mode);
        if (r9 == null) goto L27;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r15, R.id.view_title);
        if (r10 == null) goto L27;
        r0 = R.id.wifi_tnt;
        ListContentItemText r11 = (ListContentItemText) ViewBindings.findChildViewById(r15, R.id.wifi_tnt);
        if (r11 == null) goto L27;
        r0 = R.id.wifi_tnt_gap_layout;
        View r1 = ViewBindings.findChildViewById(r15, R.id.wifi_tnt_gap_layout);
        if (r1 == null) goto L27;
        GroupListItemVerticalGapLayoutBinding r12 = GroupListItemVerticalGapLayoutBinding.bind(r1);
        r0 = R.id.wifi_tnt_item_image;
        SettingItemImage r13 = (SettingItemImage) ViewBindings.findChildViewById(r15, R.id.wifi_tnt_item_image);
        if (r13 == null) goto L27;
        r0 = R.id.wifi_tnt_tips;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r15, R.id.wifi_tnt_tips);
        if (r14 == null) goto L27;
        return new RevoneFragmentBytedanceTntAssistBinding((RelativeLayout) r15, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
