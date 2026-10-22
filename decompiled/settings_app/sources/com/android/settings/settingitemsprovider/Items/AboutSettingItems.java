package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.servicemanager.IPlatform;
import com.android.settings.settingitemsprovider.Constants;
import com.bytedance.news.common.service.manager.ServiceManager;

/* JADX INFO: loaded from: classes2.dex */
public class AboutSettingItems extends SettingItems {
    public AboutSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.about_settings, null, Constants.COMPONENT_ABOUT, null, true, R.string.about_settings, R.string.about_device_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.about_device_name, null, Constants.COMPONENT_ABOUT, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_device_name}), R.string.device_name_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.model_number, null, Constants.COMPONENT_ABOUT, null, true, buildPath(new int[]{R.string.about_settings, R.string.model_number}), R.string.model_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.cpu_info, null, Constants.COMPONENT_ABOUT, null, true, buildPath(new int[]{R.string.about_settings, R.string.cpu_info}), R.string.processor_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.mem_info, null, Constants.COMPONENT_ABOUT, null, true, buildPath(new int[]{R.string.about_settings, R.string.mem_info}), R.string.ram_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.storage_capacity, null, Constants.COMPONENT_SECURITY_STORAGE, null, true, buildPath(new int[]{R.string.about_settings, R.string.storage_capacity}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.about_screen, null, Constants.COMPONENT_ABOUT, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_screen}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.battery_power, null, Constants.COMPONENT_ABOUT, null, true, buildPath(new int[]{R.string.about_settings, R.string.battery_power}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.about_item_title_device_status, null, Constants.COMPONENT_DEVICE_STATUS, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_item_title_device_status}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.about_item_title_law_info, null, Constants.COMPONENT_LAW_INFO, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_item_title_law_info}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_national_certification, null, Constants.COMPONENT_CERTIFICATION, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_item_title_law_info, R.string.title_national_certification}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_settings_privacy_policy, null, Constants.COMPONENT_LAW_INFO, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_item_title_law_info}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_settings_open_source, null, Constants.COMPONENT_LAW_INFO, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_item_title_law_info}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.title_settings_app_open_source, null, Constants.COMPONENT_LAW_INFO, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_item_title_law_info}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.about_official_warranty, null, Constants.COMPONENT_GUARANTEE, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_official_warranty}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.about_user_feedback, null, Constants.COMPONENT_USER_FEEDBACK, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_user_feedback}), null));
        if (((IPlatform) ServiceManager.getService(IPlatform.class)).isGoogleLawEnable() == false) goto L6;
        this.mItemList.add(new SettingItems.Items(this, R.string.title_google_legal_info, null, Constants.COMPONENT_GOOGLE_LAW_INFO, null, true, buildPath(new int[]{R.string.about_settings, R.string.about_item_title_law_info, R.string.title_google_legal_info}), null));
        return;
    }
}
