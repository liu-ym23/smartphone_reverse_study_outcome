package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceAdvancedSettingsLayoutBinding implements ViewBinding {
    public final LinearLayout absContainer;
    public final OCardListItem absSwitch;
    public final LinearLayout autoDisconnectContainer;
    public final OCardListItem autoDisconnectTimer;
    public final LinearLayout codecContainer;
    public final OCardListItem devAddress;
    public final View fakeStatusBar;
    public final OCardListItem qualityCheck;
    private final RelativeLayout rootView;
    public final OCardListItem stableCheck;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceAdvancedSettingsLayoutBinding(RelativeLayout r1, LinearLayout r2, OCardListItem r3, LinearLayout r4, OCardListItem r5, LinearLayout r6, OCardListItem r7, View r8, OCardListItem r9, OCardListItem r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.absContainer = r2;
        this.absSwitch = r3;
        this.autoDisconnectContainer = r4;
        this.autoDisconnectTimer = r5;
        this.codecContainer = r6;
        this.devAddress = r7;
        this.fakeStatusBar = r8;
        this.qualityCheck = r9;
        this.stableCheck = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DeviceAdvancedSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceAdvancedSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_advanced_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceAdvancedSettingsLayoutBinding bind(View r14) {
        int r0 = R.id.abs_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.abs_container);
        if (r4 == null) goto L25;
        r0 = R.id.abs_switch;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.abs_switch);
        if (r5 == null) goto L25;
        r0 = R.id.auto_disconnect_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.auto_disconnect_container);
        if (r6 == null) goto L25;
        r0 = R.id.auto_disconnect_timer;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.auto_disconnect_timer);
        if (r7 == null) goto L25;
        r0 = R.id.codec_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.codec_container);
        if (r8 == null) goto L25;
        r0 = R.id.dev_address;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.dev_address);
        if (r9 == null) goto L25;
        r0 = R.id.fake_status_bar;
        View r10 = ViewBindings.findChildViewById(r14, R.id.fake_status_bar);
        if (r10 == null) goto L25;
        r0 = R.id.quality_check;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.quality_check);
        if (r11 == null) goto L25;
        r0 = R.id.stable_check;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.stable_check);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new DeviceAdvancedSettingsLayoutBinding((RelativeLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
