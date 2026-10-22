package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public class DesktopSettingItems extends SettingItems {
    public DesktopSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.desktop_header_title, null, "com.obric.wallpaper/com.obric.wallpaper.WallpaperActivity", null, true, R.string.desktop_header_title, R.string.desktop_desc));
    }
}
