package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.servicemanager.IEmergencyHelp;
import com.android.settings.settingitemsprovider.Constants;
import com.bytedance.news.common.service.manager.ServiceManager;

/* JADX INFO: loaded from: classes2.dex */
public class EmergencyItems extends SettingItems {
    public EmergencyItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        IEmergencyHelp r0 = (IEmergencyHelp) ServiceManager.getService(IEmergencyHelp.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowEmergency() == false) goto L9;
        this.mItemList.add(new SettingItems.Items(this, R.string.emergency_settings_preference_title, null, Constants.COMPONENT_EMERGENCY_HELP, null, true, R.string.emergency_settings_preference_title, null));
        return;
    }
}
