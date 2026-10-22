package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationSettingsHeaderViewBinding implements ViewBinding {
    public final FrameLayout conversation;
    public final OCardListItem gameTimeNotification;
    public final OCardListItem highPriorityNotification;
    public final LinearLayout itemsContainer;
    public final OCardListItem launcherBadgeNotification;
    public final OCardListItem lockNotification;
    public final OCardListItem lockScreenMessageItem;
    public final OCardListItem lockShowSensitiveNotification;
    public final OCardListItem lockscreenTrivialControlsSwitch;
    public final OCardListItem notificationLaunchFreeform;
    private final RelativeLayout rootView;
    public final OCardListItem statusBarItem;
    public final OCardListItem systemNotificationItem;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationSettingsHeaderViewBinding(RelativeLayout r1, FrameLayout r2, OCardListItem r3, OCardListItem r4, LinearLayout r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13) {
        this.rootView = r1;
        this.conversation = r2;
        this.gameTimeNotification = r3;
        this.highPriorityNotification = r4;
        this.itemsContainer = r5;
        this.launcherBadgeNotification = r6;
        this.lockNotification = r7;
        this.lockScreenMessageItem = r8;
        this.lockShowSensitiveNotification = r9;
        this.lockscreenTrivialControlsSwitch = r10;
        this.notificationLaunchFreeform = r11;
        this.statusBarItem = r12;
        this.systemNotificationItem = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NotificationSettingsHeaderViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationSettingsHeaderViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_settings_header_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationSettingsHeaderViewBinding bind(View r17) {
        int r1 = R.id.conversation;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r17, R.id.conversation);
        if (r5 == null) goto L29;
        r1 = R.id.game_time_notification;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.game_time_notification);
        if (r6 == null) goto L29;
        r1 = R.id.high_priority_notification;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.high_priority_notification);
        if (r7 == null) goto L29;
        r1 = R.id.items_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.items_container);
        if (r8 == null) goto L29;
        r1 = R.id.launcher_badge_notification;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.launcher_badge_notification);
        if (r9 == null) goto L29;
        r1 = R.id.lock_notification;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.lock_notification);
        if (r10 == null) goto L29;
        r1 = R.id.lock_screen_message_item;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.lock_screen_message_item);
        if (r11 == null) goto L29;
        r1 = R.id.lock_show_sensitive_notification;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.lock_show_sensitive_notification);
        if (r12 == null) goto L29;
        r1 = R.id.lockscreen_trivial_controls_switch;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.lockscreen_trivial_controls_switch);
        if (r13 == null) goto L29;
        r1 = R.id.notification_launch_freeform;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.notification_launch_freeform);
        if (r14 == null) goto L29;
        r1 = R.id.status_bar_item;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.status_bar_item);
        if (r15 == null) goto L29;
        r1 = R.id.system_notification_item;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.system_notification_item);
        if (r16 == null) goto L29;
        return new NotificationSettingsHeaderViewBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
