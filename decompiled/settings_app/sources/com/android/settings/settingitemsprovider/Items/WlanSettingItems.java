package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.android.settings.R;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class WlanSettingItems extends SettingItems {
    public WlanSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.wifi_settings, null, Constants.COMPONENT_WIFI, null, true, R.string.wifi_settings, R.string.wireless_network_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.wifi_settings, null, true, null, null, "wifi", "0", true, buildPath(new int[]{R.string.wifi_settings, R.string.wifi_settings}), R.string.wireless_network_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.network_assistant, null, Constants.COMPONENT_NETWORK_ASSISTANT, null, true, buildPath(new int[]{R.string.wifi_settings, R.string.network_assistant}), R.string.network_assistant_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.wifi_cellular_data_fallback_title, null, true, null, null, SettingsSwitchKeyUtil.NETWORK_AVOID_BAD_WIFI, "0", true, buildPath(new int[]{R.string.wifi_settings, R.string.network_assistant, R.string.wifi_cellular_data_fallback_title}), R.string.smart_switch_wifi_mobile_data_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.multi_wifi_acceleration, null, Constants.COMPONENT_MULTI_WIFI, null, true, buildPath(new int[]{R.string.wifi_settings, R.string.network_assistant, R.string.multi_wifi_acceleration}), R.string.dual_wlan_acceleration_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.multi_wifi_acceleration, null, true, null, null, "multi_wifi", "0", true, buildPath(new int[]{R.string.wifi_settings, R.string.network_assistant, R.string.multi_wifi_acceleration, R.string.multi_wifi_acceleration}), R.string.dual_wlan_acceleration_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.wifi_assistant_location_position_title, null, true, SettingsSwitchKeyUtil.SettingTable.Global, "wifi_scan_always_enabled", null, "0", true, buildPath(new int[]{R.string.wifi_settings, R.string.network_assistant, R.string.wifi_assistant_location_position_title}), R.string.assisted_location_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.auto_open_wifi, null, true, SettingsSwitchKeyUtil.SettingTable.Global, "wifi_wakeup_enabled", null, "0", true, buildPath(new int[]{R.string.wifi_settings, R.string.network_assistant, R.string.auto_open_wifi}), R.string.auto_open_wifi_tips));
        this.mItemList.add(new SettingItems.Items(this, R.string.wifi_p2p_settings_title, null, Constants.COMPONENT_WIFI_P2P, null, true, buildPath(new int[]{R.string.wifi_settings, R.string.network_assistant, R.string.wifi_p2p_settings_title}), R.string.wireless_direct_connect_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.wifi_display_settings_title, null, Constants.COMPONENT_WIFI_DISPLAY, "entry_from_wifi=true", true, buildPath(new int[]{R.string.wifi_settings, R.string.network_assistant, R.string.wifi_display_settings_title}), R.string.wireless_display_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.wapi_cert_manage_title, null, Constants.COMPONENT_WAPI_MANAGER, null, true, buildPath(new int[]{R.string.wifi_settings, R.string.network_assistant, R.string.wapi_cert_manage_title}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.network_assistant_wlan_usage, null, Constants.COMPONENT_WLAN_USAGE, null, true, buildPath(new int[]{R.string.wifi_settings, R.string.network_assistant, R.string.network_assistant_wlan_usage}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.wifi_add_network, null, Constants.COMPONENT_WIFI_SETUP, null, true, buildPath(new int[]{R.string.wifi_settings, R.string.wifi_add_network}), R.string.manual_add_network_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.wifi_scan_QRcode, null, Constants.COMPONENT_WIFI_SCAN_QRCODE, "call_camera_with_barcode_scanning=1|launch_by_wifiSettings=true", true, buildPath(new int[]{R.string.wifi_settings, R.string.wifi_scan_QRcode}), R.string.scan_qr_code_add_network_desc));
    }

    public static void updateItems(Handler r18, Context r19, SQLiteDatabase r20) {
        if (getWifiState(r19) != 3) goto L5;
        String r0 = "1";
    L6:
        String r9 = r0;
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r19.getString(R.string.network_assistant));
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r19.getString(R.string.wifi_add_network));
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r19.getString(R.string.wifi_scan_QRcode));
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r19.getString(R.string.wifi_cellular_data_fallback_title));
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r19.getString(R.string.wifi_assistant_location_position_title));
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r19.getString(R.string.auto_open_wifi));
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r19.getString(R.string.wifi_p2p_settings_title));
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r19.getString(R.string.wifi_display_settings_title));
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", r19.getString(R.string.wapi_cert_manage_title));
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new String[]{r19.getString(R.string.wifi_settings), r19.getString(R.string.network_assistant), r19.getString(R.string.multi_wifi_acceleration)}));
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new String[]{r19.getString(R.string.wifi_settings), r19.getString(R.string.network_assistant), r19.getString(R.string.multi_wifi_acceleration), r19.getString(R.string.multi_wifi_acceleration)}));
        return;
    L5:
        r0 = "0";
        goto L6
    }

    private static int getWifiState(Context r1) {
        WifiManager r2 = (WifiManager) r1.getSystemService("wifi");
        if (r2 != null) goto L5;
        return 4;
    L5:
        return r2.getWifiState();
    }
}
