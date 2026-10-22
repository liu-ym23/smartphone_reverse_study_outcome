package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.settingitemsprovider.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionSettingItems extends SettingItems {
    public PermissionSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.permissions_and_privacy, null, Constants.COMPONENT_PERMISSION_AND_PRIVACY, null, true, R.string.permissions_and_privacy, R.string.permissions_and_privacy_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.location_settings_title, null, true, null, null, "location", "0", true, buildPath(new int[]{R.string.permissions_and_privacy, R.string.location_settings_title}), R.string.location_service_description));
    }
}
