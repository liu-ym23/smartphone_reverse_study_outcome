package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityNotificationAccessDetailsBinding implements ViewBinding {
    public final OCardListItem bridgedApps;
    public final OTextView headerText;
    public final LinearLayout llContainer;
    public final ConstraintLayout main;
    public final OCardListItem moreSettings;
    public final OTextView notifListenerNotMigrated;
    public final OCardListItem notificationAccessSwitch;
    private final ConstraintLayout rootView;
    public final LinearLayout subSwitchContainer;
    public final OCardListItem typeFilterAlerting;
    public final OCardListItem typeFilterConversation;
    public final OCardListItem typeFilterOngoing;
    public final OCardListItem typeFilterSilent;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityNotificationAccessDetailsBinding(ConstraintLayout r1, OCardListItem r2, OTextView r3, LinearLayout r4, ConstraintLayout r5, OCardListItem r6, OTextView r7, OCardListItem r8, LinearLayout r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.bridgedApps = r2;
        this.headerText = r3;
        this.llContainer = r4;
        this.main = r5;
        this.moreSettings = r6;
        this.notifListenerNotMigrated = r7;
        this.notificationAccessSwitch = r8;
        this.subSwitchContainer = r9;
        this.typeFilterAlerting = r10;
        this.typeFilterConversation = r11;
        this.typeFilterOngoing = r12;
        this.typeFilterSilent = r13;
        this.viewTitle = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNotificationAccessDetailsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityNotificationAccessDetailsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_notification_access_details, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityNotificationAccessDetailsBinding bind(View r18) {
        int r1 = R.id.bridged_apps;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.bridged_apps);
        if (r5 == null) goto L29;
        r1 = R.id.header_text;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r18, R.id.header_text);
        if (r6 == null) goto L29;
        r1 = R.id.ll_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.ll_container);
        if (r7 == null) goto L29;
        ConstraintLayout r8 = (ConstraintLayout) r18;
        r1 = R.id.more_settings;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.more_settings);
        if (r9 == null) goto L29;
        r1 = R.id.notif_listener_not_migrated;
        OTextView r10 = (OTextView) ViewBindings.findChildViewById(r18, R.id.notif_listener_not_migrated);
        if (r10 == null) goto L29;
        r1 = R.id.notification_access_switch;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.notification_access_switch);
        if (r11 == null) goto L29;
        r1 = R.id.sub_switch_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.sub_switch_container);
        if (r12 == null) goto L29;
        r1 = R.id.type_filter_alerting;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.type_filter_alerting);
        if (r13 == null) goto L29;
        r1 = R.id.type_filter_conversation;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.type_filter_conversation);
        if (r14 == null) goto L29;
        r1 = R.id.type_filter_ongoing;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.type_filter_ongoing);
        if (r15 == null) goto L29;
        r1 = R.id.type_filter_silent;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r18, R.id.type_filter_silent);
        if (r16 == null) goto L29;
        r1 = R.id.view_title;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.view_title);
        if (r17 == null) goto L29;
        return new ActivityNotificationAccessDetailsBinding(r8, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
