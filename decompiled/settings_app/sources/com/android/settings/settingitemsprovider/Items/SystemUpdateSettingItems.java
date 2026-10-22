package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.settingitemsprovider.Constants;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class SystemUpdateSettingItems extends SettingItems {
    private static final String UPDATER_PACKAGE_NAME = "com.obric.updater";

    public SystemUpdateSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.about_item_title_update, null, Constants.COMPONENT_OTA, null, true, R.string.about_item_title_update, R.string.system_update_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, UPDATER_PACKAGE_NAME, "auto_download_package_absystem_n1"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "ota_enable_auto_download", null, "0", true, buildPath(new String[]{this.mContext.getString(R.string.about_item_title_update), getPackageString(this.mContext, UPDATER_PACKAGE_NAME, "auto_download_package_absystem_n1")}), R.string.auto_download_and_update_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, UPDATER_PACKAGE_NAME, "night_reboot"), null, Constants.COMPONENT_OTA_SETTINGS, null, true, buildPath(new String[]{this.mContext.getString(R.string.about_item_title_update), getPackageString(this.mContext, UPDATER_PACKAGE_NAME, "night_reboot")}), R.string.system_update_night_reboot_desc));
    }
}
