package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.NotificationSettingsFragment;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.StatusBarSettingFragment;
import com.android.settings.settingitemsprovider.Constants;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationSettingItems extends SettingItems {
    public NotificationSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.system_notification_title, R.string.alias_notification_center, Constants.COMPONENT_NOTIFICATION, null, true, R.string.system_notification_title, R.string.notification_and_status_bar_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.system_notification_high_priority_notification, null, Constants.PKG_ORIGINAL_SMARTNOTIFICATION_CLASS_NAME, null, true, buildPath(new int[]{R.string.system_notification_title, R.string.system_notification_high_priority_notification}), R.string.high_priority_notifications_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.cast_when_connected_bluetooth, null, Constants.PKG_ORIGINAL_SMARTNOTIFICATION_CLASS_NAME, null, true, buildPath(new int[]{R.string.system_notification_title, R.string.system_notification_high_priority_notification}), R.string.cast_when_connected_bluetooth_direction));
        this.mItemList.add(new SettingItems.Items(this, R.string.lock_notification, null, Constants.COMPONENT_LOCK_NOTIFICATION, null, true, buildPath(new int[]{R.string.system_notification_title, R.string.lock_notification}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.system_notification_launcher_badge_notification, null, Constants.COMPONENT_NOTIFICATION, null, true, buildPath(new int[]{R.string.system_notification_title, R.string.system_notification_launcher_badge_notification}), R.string.notification_reminder_method_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.status_bar_title, null, Constants.COMPONENT_STATUS_BAR, null, true, buildPath(new int[]{R.string.system_notification_title, R.string.status_bar_title}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.status_bar_notification_icon, null, true, "secure", StatusBarSettingFragment.STATUS_BAR_NOTIFICATION_ICON, null, "1", true, buildPath(new int[]{R.string.system_notification_title, R.string.status_bar_notification_icon}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.show_network_speed, null, true, "secure", StatusBarSettingFragment.STATUS_BAR_SHOW_NETWORK_SPEED, null, "0", true, buildPath(new int[]{R.string.system_notification_title, R.string.status_bar_title, R.string.show_network_speed}), null));
        if (SettingsFeature.isSupportGameHideNotification() == false) goto L5;
        this.mItemList.add(new SettingItems.Items(this, R.string.game_time_notification, null, true, SettingsSwitchKeyUtil.SettingTable.Global, NotificationSettingsFragment.GAME_MODE_NO_DISTURB_ENABLED, null, "1", true, buildPath(new int[]{R.string.system_notification_title, R.string.game_time_notification}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.notification_launch_freeform_title, null, true, SettingsSwitchKeyUtil.SettingTable.System, NotificationSettingsFragment.NOTIFICATION_LAUNCH_FREEFORM_ENABLED, null, "1", true, buildPath(new int[]{R.string.system_notification_title, R.string.notification_launch_freeform_title}), R.string.notification_launch_freeform_desc));
    L5:
        this.mItemList.add(new SettingItems.Items(this, R.string.live_card_click_title, null, Constants.COMPONENT_LIVE_CARD, null, true, buildPath(new int[]{R.string.system_notification_title, R.string.live_card_click_title}), null));
    }
}
