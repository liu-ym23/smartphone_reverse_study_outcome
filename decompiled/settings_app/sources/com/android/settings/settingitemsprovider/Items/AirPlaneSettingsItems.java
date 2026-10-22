package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class AirPlaneSettingsItems extends SettingItems {
    public AirPlaneSettingsItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.airplane_mode_header_title, null, true, SettingsSwitchKeyUtil.SettingTable.Global, "airplane_mode_on", null, "0", true, buildPath(new int[]{R.string.airplane_mode_header_title}), R.string.airplane_mode_desc));
    }
}
