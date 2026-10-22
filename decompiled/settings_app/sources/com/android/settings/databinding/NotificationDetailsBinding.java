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
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationDetailsBinding implements ViewBinding {
    public final OCardListItem allowSmartNotification;
    public final ManageApplicationsItemBinding appSnippet;
    public final LinearLayout channelSettings;
    public final LinearLayout enabledContainer;
    public final LinearLayout itemsContainer;
    public final LinearLayout listView;
    public final OCardListItem notificationDetail;
    public final View notificationDetailGapView;
    public final OCardListItem notificationEnabled;
    public final OSectionTitleBar notificationMoreText;
    public final OCardListItem notificationRingtoneTitle;
    public final OCardListItem notificationRingtoneVibrate;
    public final OCardListItem notificationSilent;
    public final OSectionSupportiveText notificationTips;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem popUpDialogNotification;
    private final RelativeLayout rootView;
    public final OCardListItem switchHeadsUp;
    public final OCardListItem switchLightenScreen;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationDetailsBinding(RelativeLayout r3, OCardListItem r4, ManageApplicationsItemBinding r5, LinearLayout r6, LinearLayout r7, LinearLayout r8, LinearLayout r9, OCardListItem r10, View r11, OCardListItem r12, OSectionTitleBar r13, OCardListItem r14, OCardListItem r15, OCardListItem r16, OSectionSupportiveText r17, LinearLayout r18, OScrollView r19, OCardListItem r20, OCardListItem r21, OCardListItem r22, OFloatingTitleBar r23) {
        this.rootView = r3;
        this.allowSmartNotification = r4;
        this.appSnippet = r5;
        this.channelSettings = r6;
        this.enabledContainer = r7;
        this.itemsContainer = r8;
        this.listView = r9;
        this.notificationDetail = r10;
        this.notificationDetailGapView = r11;
        this.notificationEnabled = r12;
        this.notificationMoreText = r13;
        this.notificationRingtoneTitle = r14;
        this.notificationRingtoneVibrate = r15;
        this.notificationSilent = r16;
        this.notificationTips = r17;
        this.pageContainer = r18;
        this.pageScrollview = r19;
        this.popUpDialogNotification = r20;
        this.switchHeadsUp = r21;
        this.switchLightenScreen = r22;
        this.viewTitle = r23;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NotificationDetailsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationDetailsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_details, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationDetailsBinding bind(View r25) {
        int r1 = R.id.allow_smart_notification;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.allow_smart_notification);
        if (r5 == null) goto L45;
        r1 = R.id.app_snippet;
        View r2 = ViewBindings.findChildViewById(r25, R.id.app_snippet);
        if (r2 == null) goto L45;
        ManageApplicationsItemBinding r6 = ManageApplicationsItemBinding.bind(r2);
        r1 = R.id.channel_settings;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.channel_settings);
        if (r7 == null) goto L45;
        r1 = R.id.enabled_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.enabled_container);
        if (r8 == null) goto L45;
        r1 = R.id.items_container;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.items_container);
        if (r9 == null) goto L45;
        r1 = R.id.listView;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.listView);
        if (r10 == null) goto L45;
        r1 = R.id.notification_detail;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.notification_detail);
        if (r11 == null) goto L45;
        r1 = R.id.notification_detail_gap_view;
        View r12 = ViewBindings.findChildViewById(r25, R.id.notification_detail_gap_view);
        if (r12 == null) goto L45;
        r1 = R.id.notification_enabled;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.notification_enabled);
        if (r13 == null) goto L45;
        r1 = R.id.notification_more_text;
        OSectionTitleBar r14 = (OSectionTitleBar) ViewBindings.findChildViewById(r25, R.id.notification_more_text);
        if (r14 == null) goto L45;
        r1 = R.id.notification_ringtone_title;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.notification_ringtone_title);
        if (r15 == null) goto L45;
        r1 = R.id.notification_ringtone_vibrate;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.notification_ringtone_vibrate);
        if (r16 == null) goto L45;
        r1 = R.id.notification_silent;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.notification_silent);
        if (r17 == null) goto L45;
        r1 = R.id.notification_tips;
        OSectionSupportiveText r18 = (OSectionSupportiveText) ViewBindings.findChildViewById(r25, R.id.notification_tips);
        if (r18 == null) goto L45;
        r1 = R.id.page_container;
        LinearLayout r19 = (LinearLayout) ViewBindings.findChildViewById(r25, R.id.page_container);
        if (r19 == null) goto L45;
        r1 = R.id.page_scrollview;
        OScrollView r20 = (OScrollView) ViewBindings.findChildViewById(r25, R.id.page_scrollview);
        if (r20 == null) goto L45;
        r1 = R.id.pop_up_dialog_notification;
        OCardListItem r21 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.pop_up_dialog_notification);
        if (r21 == null) goto L45;
        r1 = R.id.switch_heads_up;
        OCardListItem r22 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.switch_heads_up);
        if (r22 == null) goto L45;
        r1 = R.id.switch_lighten_screen;
        OCardListItem r23 = (OCardListItem) ViewBindings.findChildViewById(r25, R.id.switch_lighten_screen);
        if (r23 == null) goto L45;
        r1 = R.id.view_title;
        OFloatingTitleBar r24 = (OFloatingTitleBar) ViewBindings.findChildViewById(r25, R.id.view_title);
        if (r24 == null) goto L45;
        return new NotificationDetailsBinding((RelativeLayout) r25, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r25.getResources().getResourceName(r1)));
    }
}
