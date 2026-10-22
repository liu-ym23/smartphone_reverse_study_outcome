package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.settingitemsprovider.Constants;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class LockNotificationSettingsItems extends SettingItems {
    private static final String KEY_KEEP_LOCK_SCREEN_NOTIFICATION = "obric_keyguard_show_old_ntfs";

    public LockNotificationSettingsItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.system_notification_lighting_screen_notification, null, true, "secure", "doze_enabled", null, "1", true, buildPath(new int[]{R.string.lock_notification, R.string.system_notification_lighting_screen_notification}), R.string.wake_screen_on_notification_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.system_notification_keep_lock_screen_notification, null, true, SettingsSwitchKeyUtil.SettingTable.System, KEY_KEEP_LOCK_SCREEN_NOTIFICATION, null, "0", true, buildPath(new int[]{R.string.lock_notification, R.string.system_notification_keep_lock_screen_notification}), R.string.keep_lock_screen_notification_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.system_notification_lock_screen_notification, null, Constants.COMPONENT_NOTIFICATION_SHOW_DETAIL, null, true, buildPath(new int[]{R.string.lock_notification, R.string.system_notification_lock_screen_notification}), R.string.show_notification_details_on_lock_screen_desc));
    }
}
