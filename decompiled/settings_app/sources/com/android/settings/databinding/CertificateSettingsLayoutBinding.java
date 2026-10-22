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
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class CertificateSettingsLayoutBinding implements ViewBinding {
    public final OCardListItem itemIdCertificate;
    public final OCardListItem itemIdClear;
    public final OCardListItem itemIdCryptKeeperEncrypt;
    public final OSectionTitleBar itemIdCryptKeeperEncryptTips;
    public final OCardListItem itemIdDeviceManager;
    public final ItemSubSettingsPaddingLayoutBinding itemIdEncryptGap;
    public final OCardListItem itemIdInstall;
    public final OCardListItem itemIdSource;
    public final ItemSubSettingsPaddingLayoutBinding itemIdSourceGap;
    public final OCardListItem itemIdTrustAgent;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CertificateSettingsLayoutBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4, OSectionTitleBar r5, OCardListItem r6, ItemSubSettingsPaddingLayoutBinding r7, OCardListItem r8, OCardListItem r9, ItemSubSettingsPaddingLayoutBinding r10, OCardListItem r11, LinearLayout r12, OScrollView r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.itemIdCertificate = r2;
        this.itemIdClear = r3;
        this.itemIdCryptKeeperEncrypt = r4;
        this.itemIdCryptKeeperEncryptTips = r5;
        this.itemIdDeviceManager = r6;
        this.itemIdEncryptGap = r7;
        this.itemIdInstall = r8;
        this.itemIdSource = r9;
        this.itemIdSourceGap = r10;
        this.itemIdTrustAgent = r11;
        this.pageContainer = r12;
        this.pageScrollview = r13;
        this.viewTitle = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static CertificateSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CertificateSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.certificate_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CertificateSettingsLayoutBinding bind(View r18) {
        int r1 = R.id.item_id_certificate;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_certificate);
        if (r5 == null) goto L31;
        r1 = R.id.item_id_clear;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_clear);
        if (r6 == null) goto L31;
        r1 = R.id.item_id_crypt_keeper_encrypt;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_crypt_keeper_encrypt);
        if (r7 == null) goto L31;
        r1 = R.id.item_id_crypt_keeper_encrypt_tips;
        OSectionTitleBar r8 = (OSectionTitleBar) ViewBindings.findChildViewById(r18, R.id.item_id_crypt_keeper_encrypt_tips);
        if (r8 == null) goto L31;
        r1 = R.id.item_id_device_manager;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_device_manager);
        if (r9 == null) goto L31;
        r1 = R.id.item_id_encrypt_gap;
        View r2 = ViewBindings.findChildViewById(r18, R.id.item_id_encrypt_gap);
        if (r2 == null) goto L31;
        ItemSubSettingsPaddingLayoutBinding r10 = ItemSubSettingsPaddingLayoutBinding.bind(r2);
        r1 = R.id.item_id_install;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_install);
        if (r11 == null) goto L31;
        r1 = R.id.item_id_source;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_source);
        if (r12 == null) goto L31;
        r1 = R.id.item_id_source_gap;
        View r3 = ViewBindings.findChildViewById(r18, R.id.item_id_source_gap);
        if (r3 == null) goto L31;
        ItemSubSettingsPaddingLayoutBinding r13 = ItemSubSettingsPaddingLayoutBinding.bind(r3);
        r1 = R.id.item_id_trust_agent;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.item_id_trust_agent);
        if (r14 == null) goto L31;
        r1 = R.id.page_container;
        LinearLayout r15 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.page_container);
        if (r15 == null) goto L31;
        r1 = R.id.page_scrollview;
        OScrollView r16 = (OScrollView) ViewBindings.findChildViewById(r18, R.id.page_scrollview);
        if (r16 == null) goto L31;
        r1 = R.id.view_title;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.view_title);
        if (r17 == null) goto L31;
        return new CertificateSettingsLayoutBinding((RelativeLayout) r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
