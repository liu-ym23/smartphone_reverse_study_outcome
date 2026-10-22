package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.AboutStaticItem;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AboutSettingsLayoutBinding implements ViewBinding {
    public final ImageView aboutLogo;
    public final TextView aboutLogoOsVertion;
    public final TextView aboutLogoOsVertionLand;
    public final AboutStaticItem basebandVersion;
    public final AboutStaticItem buildDate;
    public final AboutStaticItem deviceCpu;
    public final AboutStaticItem deviceMemory;
    public final AboutStaticItem deviceModel;
    public final ViewStub deviceVersionVs;
    public final AboutStaticItem firmwareVersion;
    public final ViewStub hwVersionVs;
    public final OListItemSettings itemDeviceName;
    public final OListItemSettings itemDeviceStatus;
    public final OListItemSettings itemLawInfo;
    public final OListItemSettings itemUserFeedback;
    public final OListItemSettings itemWarranty;
    public final AboutStaticItem kernelVersion;
    public final AboutStaticItem modVersion;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final ViewStub specialVersionVs;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AboutSettingsLayoutBinding(RelativeLayout r3, ImageView r4, TextView r5, TextView r6, AboutStaticItem r7, AboutStaticItem r8, AboutStaticItem r9, AboutStaticItem r10, AboutStaticItem r11, ViewStub r12, AboutStaticItem r13, ViewStub r14, OListItemSettings r15, OListItemSettings r16, OListItemSettings r17, OListItemSettings r18, OListItemSettings r19, AboutStaticItem r20, AboutStaticItem r21, LinearLayout r22, OScrollView r23, ViewStub r24, OFloatingTitleBar r25) {
        this.rootView = r3;
        this.aboutLogo = r4;
        this.aboutLogoOsVertion = r5;
        this.aboutLogoOsVertionLand = r6;
        this.basebandVersion = r7;
        this.buildDate = r8;
        this.deviceCpu = r9;
        this.deviceMemory = r10;
        this.deviceModel = r11;
        this.deviceVersionVs = r12;
        this.firmwareVersion = r13;
        this.hwVersionVs = r14;
        this.itemDeviceName = r15;
        this.itemDeviceStatus = r16;
        this.itemLawInfo = r17;
        this.itemUserFeedback = r18;
        this.itemWarranty = r19;
        this.kernelVersion = r20;
        this.modVersion = r21;
        this.pageContainer = r22;
        this.pageScrollview = r23;
        this.specialVersionVs = r24;
        this.viewTitle = r25;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AboutSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AboutSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.about_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AboutSettingsLayoutBinding bind(View r27) {
        int r1 = R.id.about_logo;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r27, R.id.about_logo);
        if (r5 == null) goto L49;
        r1 = R.id.about_logo_os_vertion;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r27, R.id.about_logo_os_vertion);
        if (r6 == null) goto L49;
        r1 = R.id.about_logo_os_vertion_land;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r27, R.id.about_logo_os_vertion_land);
        if (r7 == null) goto L49;
        r1 = R.id.baseband_version;
        AboutStaticItem r8 = (AboutStaticItem) ViewBindings.findChildViewById(r27, R.id.baseband_version);
        if (r8 == null) goto L49;
        r1 = R.id.build_date;
        AboutStaticItem r9 = (AboutStaticItem) ViewBindings.findChildViewById(r27, R.id.build_date);
        if (r9 == null) goto L49;
        r1 = R.id.device_cpu;
        AboutStaticItem r10 = (AboutStaticItem) ViewBindings.findChildViewById(r27, R.id.device_cpu);
        if (r10 == null) goto L49;
        r1 = R.id.device_memory;
        AboutStaticItem r11 = (AboutStaticItem) ViewBindings.findChildViewById(r27, R.id.device_memory);
        if (r11 == null) goto L49;
        r1 = R.id.device_model;
        AboutStaticItem r12 = (AboutStaticItem) ViewBindings.findChildViewById(r27, R.id.device_model);
        if (r12 == null) goto L49;
        r1 = R.id.device_version_vs;
        ViewStub r13 = (ViewStub) ViewBindings.findChildViewById(r27, R.id.device_version_vs);
        if (r13 == null) goto L49;
        r1 = R.id.firmware_version;
        AboutStaticItem r14 = (AboutStaticItem) ViewBindings.findChildViewById(r27, R.id.firmware_version);
        if (r14 == null) goto L49;
        r1 = R.id.hw_version_vs;
        ViewStub r15 = (ViewStub) ViewBindings.findChildViewById(r27, R.id.hw_version_vs);
        if (r15 == null) goto L49;
        r1 = R.id.item_device_name;
        OListItemSettings r16 = (OListItemSettings) ViewBindings.findChildViewById(r27, R.id.item_device_name);
        if (r16 == null) goto L49;
        r1 = R.id.item_device_status;
        OListItemSettings r17 = (OListItemSettings) ViewBindings.findChildViewById(r27, R.id.item_device_status);
        if (r17 == null) goto L49;
        r1 = R.id.item_law_info;
        OListItemSettings r18 = (OListItemSettings) ViewBindings.findChildViewById(r27, R.id.item_law_info);
        if (r18 == null) goto L49;
        r1 = R.id.item_user_feedback;
        OListItemSettings r19 = (OListItemSettings) ViewBindings.findChildViewById(r27, R.id.item_user_feedback);
        if (r19 == null) goto L49;
        r1 = R.id.item_warranty;
        OListItemSettings r20 = (OListItemSettings) ViewBindings.findChildViewById(r27, R.id.item_warranty);
        if (r20 == null) goto L49;
        r1 = R.id.kernel_version;
        AboutStaticItem r21 = (AboutStaticItem) ViewBindings.findChildViewById(r27, R.id.kernel_version);
        if (r21 == null) goto L49;
        r1 = R.id.mod_version;
        AboutStaticItem r22 = (AboutStaticItem) ViewBindings.findChildViewById(r27, R.id.mod_version);
        if (r22 == null) goto L49;
        r1 = R.id.page_container;
        LinearLayout r23 = (LinearLayout) ViewBindings.findChildViewById(r27, R.id.page_container);
        if (r23 == null) goto L49;
        r1 = R.id.page_scrollview;
        OScrollView r24 = (OScrollView) ViewBindings.findChildViewById(r27, R.id.page_scrollview);
        if (r24 == null) goto L49;
        r1 = R.id.special_version_vs;
        ViewStub r25 = (ViewStub) ViewBindings.findChildViewById(r27, R.id.special_version_vs);
        if (r25 == null) goto L49;
        r1 = R.id.view_title;
        OFloatingTitleBar r26 = (OFloatingTitleBar) ViewBindings.findChildViewById(r27, R.id.view_title);
        if (r26 == null) goto L49;
        return new AboutSettingsLayoutBinding((RelativeLayout) r27, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    L49:
        throw new NullPointerException("Missing required view with ID: ".concat(r27.getResources().getResourceName(r1)));
    }
}
