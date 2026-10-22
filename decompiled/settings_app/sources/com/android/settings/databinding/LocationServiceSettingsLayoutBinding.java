package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class LocationServiceSettingsLayoutBinding implements ViewBinding {
    public final OCardListItem OListItemSettingsGotoLocationApp;
    public final OCardListItem itemLocationService;
    public final OCardListItem listItemLocationSwitch;
    public final OCardListItem managedProfileLocationSwitch;
    public final RelativeLayout rlLocationServiceSettings;
    private final RelativeLayout rootView;
    public final OSectionSupportiveText tvLocationServiceDescription;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LocationServiceSettingsLayoutBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, RelativeLayout r6, OSectionSupportiveText r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.OListItemSettingsGotoLocationApp = r2;
        this.itemLocationService = r3;
        this.listItemLocationSwitch = r4;
        this.managedProfileLocationSwitch = r5;
        this.rlLocationServiceSettings = r6;
        this.tvLocationServiceDescription = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LocationServiceSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LocationServiceSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.location_service_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LocationServiceSettingsLayoutBinding bind(View r11) {
        int r0 = R.id.OListItemSettings_goto_location_app;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.OListItemSettings_goto_location_app);
        if (r4 == null) goto L19;
        r0 = R.id.item_location_service;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.item_location_service);
        if (r5 == null) goto L19;
        r0 = R.id.list_item_location_switch;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.list_item_location_switch);
        if (r6 == null) goto L19;
        r0 = R.id.managed_profile_location_switch;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.managed_profile_location_switch);
        if (r7 == null) goto L19;
        r0 = R.id.rl_location_service_settings;
        RelativeLayout r8 = (RelativeLayout) ViewBindings.findChildViewById(r11, R.id.rl_location_service_settings);
        if (r8 == null) goto L19;
        r0 = R.id.tv_location_service_description;
        OSectionSupportiveText r9 = (OSectionSupportiveText) ViewBindings.findChildViewById(r11, R.id.tv_location_service_description);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new LocationServiceSettingsLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
