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
public final class StatusBarSettingsFragmentBinding implements ViewBinding {
    public final OCardListItem liveCardClickAction;
    public final OCardListItem networkSpeed;
    public final OCardListItem notificationIcon;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StatusBarSettingsFragmentBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4, LinearLayout r5, OScrollView r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.liveCardClickAction = r2;
        this.networkSpeed = r3;
        this.notificationIcon = r4;
        this.pageContainer = r5;
        this.pageScrollview = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StatusBarSettingsFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StatusBarSettingsFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.status_bar_settings_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StatusBarSettingsFragmentBinding bind(View r10) {
        int r0 = R.id.live_card_click_action;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.live_card_click_action);
        if (r4 == null) goto L17;
        r0 = R.id.network_speed;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.network_speed);
        if (r5 == null) goto L17;
        r0 = R.id.notification_icon;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.notification_icon);
        if (r6 == null) goto L17;
        r0 = R.id.page_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r7 == null) goto L17;
        r0 = R.id.page_scrollview;
        OScrollView r8 = (OScrollView) ViewBindings.findChildViewById(r10, R.id.page_scrollview);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new StatusBarSettingsFragmentBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
