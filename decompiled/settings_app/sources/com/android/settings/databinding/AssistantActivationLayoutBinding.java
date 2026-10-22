package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AssistantActivationLayoutBinding implements ViewBinding {
    public final OCardListItem aiKeyWhenScreenOff;
    public final FrameLayout frameLayout;
    public final OCardListItem itemAiKeySensitivity;
    public final OCardListItem itemDoubleClick;
    public final OCardListItem itemFingerprint;
    public final ItemSubSettingsPaddingLayout2Binding itemFingerprintPadding;
    public final OCardListItem itemSingleClick;
    public final LinearLayout pageContainer;
    public final ONestedScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;
    public final OSectionSupportiveText wifiApTips;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AssistantActivationLayoutBinding(RelativeLayout r1, OCardListItem r2, FrameLayout r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, ItemSubSettingsPaddingLayout2Binding r7, OCardListItem r8, LinearLayout r9, ONestedScrollView r10, OFloatingTitleBar r11, OSectionSupportiveText r12) {
        this.rootView = r1;
        this.aiKeyWhenScreenOff = r2;
        this.frameLayout = r3;
        this.itemAiKeySensitivity = r4;
        this.itemDoubleClick = r5;
        this.itemFingerprint = r6;
        this.itemFingerprintPadding = r7;
        this.itemSingleClick = r8;
        this.pageContainer = r9;
        this.pageScrollview = r10;
        this.viewTitle = r11;
        this.wifiApTips = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AssistantActivationLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AssistantActivationLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.assistant_activation_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AssistantActivationLayoutBinding bind(View r15) {
        int r0 = R.id.ai_key_when_screen_off;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.ai_key_when_screen_off);
        if (r4 == null) goto L27;
        r0 = R.id.frame_layout;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r15, R.id.frame_layout);
        if (r5 == null) goto L27;
        r0 = R.id.item_ai_key_sensitivity;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.item_ai_key_sensitivity);
        if (r6 == null) goto L27;
        r0 = R.id.item_double_click;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.item_double_click);
        if (r7 == null) goto L27;
        r0 = R.id.item_fingerprint;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.item_fingerprint);
        if (r8 == null) goto L27;
        r0 = R.id.item_fingerprint_padding;
        View r1 = ViewBindings.findChildViewById(r15, R.id.item_fingerprint_padding);
        if (r1 == null) goto L27;
        ItemSubSettingsPaddingLayout2Binding r9 = ItemSubSettingsPaddingLayout2Binding.bind(r1);
        r0 = R.id.item_single_click;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.item_single_click);
        if (r10 == null) goto L27;
        r0 = R.id.page_container;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.page_container);
        if (r11 == null) goto L27;
        r0 = R.id.page_scrollview;
        ONestedScrollView r12 = (ONestedScrollView) ViewBindings.findChildViewById(r15, R.id.page_scrollview);
        if (r12 == null) goto L27;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r15, R.id.view_title);
        if (r13 == null) goto L27;
        r0 = R.id.wifi_ap_tips;
        OSectionSupportiveText r14 = (OSectionSupportiveText) ViewBindings.findChildViewById(r15, R.id.wifi_ap_tips);
        if (r14 == null) goto L27;
        return new AssistantActivationLayoutBinding((RelativeLayout) r15, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
