package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.settingitemsprovider.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class AccountSettingItems extends SettingItems {
    public AccountSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.system_account, null, Constants.COMPONENT_SYSTEM_ACCOUNT, null, true, R.string.system_account, R.string.system_account_desc));
    }
}
