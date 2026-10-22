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
public final class NotificationChannelDetailBinding implements ViewBinding {
    public final LinearLayout enabledContainer;
    public final OCardListItem highImportance;
    public final OCardListItem notificationEnabled;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OSectionTitleBar selectionTitle;
    public final OCardListItem switchNotificationRingtone;
    public final OCardListItem switchNotificationVibrate;
    public final OCardListItem switchNotificationVisible;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationChannelDetailBinding(RelativeLayout r1, LinearLayout r2, OCardListItem r3, OCardListItem r4, LinearLayout r5, OScrollView r6, OSectionTitleBar r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.enabledContainer = r2;
        this.highImportance = r3;
        this.notificationEnabled = r4;
        this.pageContainer = r5;
        this.pageScrollview = r6;
        this.selectionTitle = r7;
        this.switchNotificationRingtone = r8;
        this.switchNotificationVibrate = r9;
        this.switchNotificationVisible = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NotificationChannelDetailBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationChannelDetailBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_channel_detail, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationChannelDetailBinding bind(View r14) {
        int r0 = R.id.enabled_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.enabled_container);
        if (r4 == null) goto L25;
        r0 = R.id.high_importance;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.high_importance);
        if (r5 == null) goto L25;
        r0 = R.id.notification_enabled;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.notification_enabled);
        if (r6 == null) goto L25;
        r0 = R.id.page_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.page_container);
        if (r7 == null) goto L25;
        r0 = R.id.page_scrollview;
        OScrollView r8 = (OScrollView) ViewBindings.findChildViewById(r14, R.id.page_scrollview);
        if (r8 == null) goto L25;
        r0 = R.id.selection_title;
        OSectionTitleBar r9 = (OSectionTitleBar) ViewBindings.findChildViewById(r14, R.id.selection_title);
        if (r9 == null) goto L25;
        r0 = R.id.switch_notification_ringtone;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.switch_notification_ringtone);
        if (r10 == null) goto L25;
        r0 = R.id.switch_notification_vibrate;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.switch_notification_vibrate);
        if (r11 == null) goto L25;
        r0 = R.id.switch_notification_visible;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.switch_notification_visible);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new NotificationChannelDetailBinding((RelativeLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
