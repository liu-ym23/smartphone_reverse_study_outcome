package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class NfcSettingsLayoutBinding implements ViewBinding {
    public final FrameLayout banner;
    public final OCardListItem defaultPaymentService;
    public final OCardListItem itemIdAndroidBeam;
    public final OCardListItem itemIdNfc;
    public final OCardListItem itemIdNfcReader;
    public final OCardListItem itemIdWallet;
    public final TextView multiBlockTips;
    public final LinearLayout nfcFeatures;
    public final OCardListItem nfcRepairItem;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NfcSettingsLayoutBinding(RelativeLayout r1, FrameLayout r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, TextView r8, LinearLayout r9, OCardListItem r10, LinearLayout r11, OScrollView r12, OFloatingTitleBar r13) {
        this.rootView = r1;
        this.banner = r2;
        this.defaultPaymentService = r3;
        this.itemIdAndroidBeam = r4;
        this.itemIdNfc = r5;
        this.itemIdNfcReader = r6;
        this.itemIdWallet = r7;
        this.multiBlockTips = r8;
        this.nfcFeatures = r9;
        this.nfcRepairItem = r10;
        this.pageContainer = r11;
        this.pageScrollview = r12;
        this.viewTitle = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NfcSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NfcSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.nfc_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NfcSettingsLayoutBinding bind(View r17) {
        int r1 = R.id.banner;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r17, R.id.banner);
        if (r5 == null) goto L29;
        r1 = R.id.default_payment_service;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.default_payment_service);
        if (r6 == null) goto L29;
        r1 = R.id.item_id_android_beam;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.item_id_android_beam);
        if (r7 == null) goto L29;
        r1 = R.id.item_id_nfc;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.item_id_nfc);
        if (r8 == null) goto L29;
        r1 = R.id.item_id_nfc_reader;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.item_id_nfc_reader);
        if (r9 == null) goto L29;
        r1 = R.id.item_id_wallet;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.item_id_wallet);
        if (r10 == null) goto L29;
        r1 = R.id.multi_block_tips;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r17, R.id.multi_block_tips);
        if (r11 == null) goto L29;
        r1 = R.id.nfc_features;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.nfc_features);
        if (r12 == null) goto L29;
        r1 = R.id.nfc_repair_item;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.nfc_repair_item);
        if (r13 == null) goto L29;
        r1 = R.id.page_container;
        LinearLayout r14 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.page_container);
        if (r14 == null) goto L29;
        r1 = R.id.page_scrollview;
        OScrollView r15 = (OScrollView) ViewBindings.findChildViewById(r17, R.id.page_scrollview);
        if (r15 == null) goto L29;
        r1 = R.id.view_title;
        OFloatingTitleBar r16 = (OFloatingTitleBar) ViewBindings.findChildViewById(r17, R.id.view_title);
        if (r16 == null) goto L29;
        return new NfcSettingsLayoutBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
