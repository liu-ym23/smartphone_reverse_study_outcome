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
public final class GoogleServiceSettingsBinding implements ViewBinding {
    public final OCardListItem itemGoogleSettings;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem switchGoogleService;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private GoogleServiceSettingsBinding(RelativeLayout r1, OCardListItem r2, LinearLayout r3, OScrollView r4, OCardListItem r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.itemGoogleSettings = r2;
        this.pageContainer = r3;
        this.pageScrollview = r4;
        this.switchGoogleService = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static GoogleServiceSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static GoogleServiceSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.google_service_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static GoogleServiceSettingsBinding bind(View r9) {
        int r0 = R.id.item_google_settings;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r9, R.id.item_google_settings);
        if (r4 == null) goto L15;
        r0 = R.id.page_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.page_container);
        if (r5 == null) goto L15;
        r0 = R.id.page_scrollview;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r9, R.id.page_scrollview);
        if (r6 == null) goto L15;
        r0 = R.id.switch_google_service;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r9, R.id.switch_google_service);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new GoogleServiceSettingsBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
