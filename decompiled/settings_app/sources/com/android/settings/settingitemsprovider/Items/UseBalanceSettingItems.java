package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.settingitemsprovider.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class UseBalanceSettingItems extends SettingItems {
    private static final String USE_BALANCE_PACKAGE_NAME = "com.zte.usebalance";

    public UseBalanceSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.minor_mode, null, Constants.COMPONENT_USE_BALANCE, null, true, R.string.minor_mode, R.string.use_balance_desc));
    }
}
