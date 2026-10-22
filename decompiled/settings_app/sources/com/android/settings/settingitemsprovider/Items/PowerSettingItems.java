package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import com.android.settings.R;
import com.android.settings.settingitemsprovider.Constants;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class PowerSettingItems extends SettingItems {
    private static final String SECURITY_PACKAGE_NAME = "com.obric.security";

    public PowerSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        String r13 = this.mContext.getString(R.string.battery_power);
        this.mItemList.add(new SettingItems.Items(this, r13, null, Constants.COMPONENT_POWER_SAVE, null, true, r13, R.string.battery_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "battery_usage_left_title"), null, Constants.COMPONENT_POWER_SAVE, null, true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "battery_usage_left_title")}), R.string.remaining_battery_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "battery_usage_graph_title"), null, Constants.COMPONENT_POWER_SAVE, null, true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "battery_usage_graph_title")}), R.string.battery_consumption_distribution_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "power_usage_battery_percentage"), null, true, SettingsSwitchKeyUtil.SettingTable.System, "status_bar_show_battery_percent", null, "1", true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "power_usage_battery_percentage")}), R.string.show_battery_percentage_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "power_usage_save_mode"), null, Constants.COMPONENT_POWER_SAVE_MODE, null, true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "power_usage_save_mode")}), R.string.power_saving_mode_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "power_usage_low_battery_mode"), null, Constants.COMPONENT_LOW_BATTERY, null, true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "power_usage_save_mode"), getPackageString(this.mContext, "com.obric.security", "power_usage_low_battery_mode")}), R.string.low_battery_mode_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "power_usage_low_battery_mode"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "low_power", null, "0", true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "power_usage_save_mode"), getPackageString(this.mContext, "com.obric.security", "power_usage_low_battery_mode"), getPackageString(this.mContext, "com.obric.security", "power_usage_low_battery_mode")}), R.string.low_battery_mode_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "low_battery_auto_enable"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "low_power_trigger_level", null, "0", true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "power_usage_save_mode"), getPackageString(this.mContext, "com.obric.security", "power_usage_low_battery_mode"), getPackageString(this.mContext, "com.obric.security", "low_battery_auto_enable")}), R.string.auto_activate_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "power_usage_feature_phone_mode"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "feature_phone_mode", null, "0", true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "power_usage_save_mode"), getPackageString(this.mContext, "com.obric.security", "power_usage_feature_phone_mode")}), R.string.ultra_low_battery_mode_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "app_optimization"), null, Constants.COMPONENT_POWER_USAGE_APPS, null, true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "app_optimization")}), R.string.app_power_consumption_optimization_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "app_optimization"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "optimization_APPS", null, "1", true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "app_optimization"), getPackageString(this.mContext, "com.obric.security", "app_optimization")}), R.string.app_power_consumption_optimization_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "screen_power_optimize"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "acl_mode_enable", null, "1", true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "screen_power_optimize")}), R.string.screen_power_consumption_optimization_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "fiveg_optimize"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "fiveg_power_saver_enabled", null, "1", true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "fiveg_optimize")}), R.string.smart_power_saving_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "auto_sleep_mode"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "sleep_mode_enable", null, "1", true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "auto_sleep_mode")}), R.string.smart_sleep_mode_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "reverse_wireless_charging"), null, true, SettingsSwitchKeyUtil.SettingTable.System, "Obric_reverse_charging_enable", null, "0", true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "reverse_wireless_charging")}), R.string.wireless_reverse_charge_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, "com.obric.security", "network_background_control_title"), null, Constants.COMPONENT_SECURITY_NETWORK_CONTROL, null, true, buildPath(new String[]{r13, getPackageString(this.mContext, "com.obric.security", "network_background_control_title")}), R.string.network_connection_control_desc));
    }
}
