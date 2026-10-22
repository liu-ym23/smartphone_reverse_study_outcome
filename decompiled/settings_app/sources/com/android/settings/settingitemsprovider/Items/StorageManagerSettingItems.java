package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.settingitemsprovider.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class StorageManagerSettingItems extends SettingItems {
    private static final String SECURITY_PACKAGE_NAME = "com.obric.security";

    public StorageManagerSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        String r10 = this.mContext.getString(R.string.storage_pager_header_title);
        this.mItemList.add(new SettingItems.Items(this, r10, null, Constants.COMPONENT_SECURITY_STORAGE, null, true, r10, R.string.storage_management_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "storage_free"), null, Constants.COMPONENT_SECURITY_STORAGE, null, true, buildPath(new String[]{r10, getPackageString(this.mContext, "com.obric.security", "storage_free")}), R.string.remaining_storage_space_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "storage_space"), null, Constants.COMPONENT_SECURITY_STORAGE, null, true, buildPath(new String[]{r10, getPackageString(this.mContext, "com.obric.security", "storage_space")}), R.string.storage_space_distribution_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.memory_junk_file_cleanup), null, Constants.COMPONENT_CLEANER, null, true, buildPath(new String[]{r10, this.mContext.getString(R.string.memory_junk_file_cleanup)}), R.string.junk_file_cleanup_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.advanced_item_application), null, Constants.COMPONENT_APP_MANAGEMENT, null, true, buildPath(new String[]{r10, this.mContext.getString(R.string.advanced_item_application)}), R.string.app_program_management_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.memory_big_file_cleanup), null, Constants.COMPONENT_CLEANER_BIG_FILES, null, true, buildPath(new String[]{r10, this.mContext.getString(R.string.memory_big_file_cleanup)}), R.string.large_file_cleanup_desc));
    }
}
