package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class MultiWifiSettingBinding implements ViewBinding {
    public final Barrier barrier;
    public final OSectionSupportiveText bottomTips;
    public final OCardListItem mainWifi;
    public final OSectionTitleBar mainWifiTitle;
    public final OCardListItem multiWifiAcceleration;
    public final Group multiWifiGroup;
    public final OTextView refreshBtn;
    public final ODownloadProgressView refreshLoading;
    private final RelativeLayout rootView;
    public final Group subWifiGroup;
    public final OSectionTitleBar subWifiTitle;
    public final OFloatingTitleBar titleBar;
    public final RecyclerView wifiList;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private MultiWifiSettingBinding(RelativeLayout r1, Barrier r2, OSectionSupportiveText r3, OCardListItem r4, OSectionTitleBar r5, OCardListItem r6, Group r7, OTextView r8, ODownloadProgressView r9, Group r10, OSectionTitleBar r11, OFloatingTitleBar r12, RecyclerView r13) {
        this.rootView = r1;
        this.barrier = r2;
        this.bottomTips = r3;
        this.mainWifi = r4;
        this.mainWifiTitle = r5;
        this.multiWifiAcceleration = r6;
        this.multiWifiGroup = r7;
        this.refreshBtn = r8;
        this.refreshLoading = r9;
        this.subWifiGroup = r10;
        this.subWifiTitle = r11;
        this.titleBar = r12;
        this.wifiList = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static MultiWifiSettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static MultiWifiSettingBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.multi_wifi_setting, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static MultiWifiSettingBinding bind(View r17) {
        int r1 = R.id.barrier;
        Barrier r5 = (Barrier) ViewBindings.findChildViewById(r17, R.id.barrier);
        if (r5 == null) goto L29;
        r1 = R.id.bottom_tips;
        OSectionSupportiveText r6 = (OSectionSupportiveText) ViewBindings.findChildViewById(r17, R.id.bottom_tips);
        if (r6 == null) goto L29;
        r1 = R.id.main_wifi;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.main_wifi);
        if (r7 == null) goto L29;
        r1 = R.id.main_wifi_title;
        OSectionTitleBar r8 = (OSectionTitleBar) ViewBindings.findChildViewById(r17, R.id.main_wifi_title);
        if (r8 == null) goto L29;
        r1 = R.id.multi_wifi_acceleration;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.multi_wifi_acceleration);
        if (r9 == null) goto L29;
        r1 = R.id.multi_wifi_group;
        Group r10 = (Group) ViewBindings.findChildViewById(r17, R.id.multi_wifi_group);
        if (r10 == null) goto L29;
        r1 = R.id.refresh_btn;
        OTextView r11 = (OTextView) ViewBindings.findChildViewById(r17, R.id.refresh_btn);
        if (r11 == null) goto L29;
        r1 = R.id.refresh_loading;
        ODownloadProgressView r12 = (ODownloadProgressView) ViewBindings.findChildViewById(r17, R.id.refresh_loading);
        if (r12 == null) goto L29;
        r1 = R.id.sub_wifi_group;
        Group r13 = (Group) ViewBindings.findChildViewById(r17, R.id.sub_wifi_group);
        if (r13 == null) goto L29;
        r1 = R.id.sub_wifi_title;
        OSectionTitleBar r14 = (OSectionTitleBar) ViewBindings.findChildViewById(r17, R.id.sub_wifi_title);
        if (r14 == null) goto L29;
        r1 = R.id.title_bar;
        OFloatingTitleBar r15 = (OFloatingTitleBar) ViewBindings.findChildViewById(r17, R.id.title_bar);
        if (r15 == null) goto L29;
        r1 = R.id.wifi_list;
        RecyclerView r16 = (RecyclerView) ViewBindings.findChildViewById(r17, R.id.wifi_list);
        if (r16 == null) goto L29;
        return new MultiWifiSettingBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
