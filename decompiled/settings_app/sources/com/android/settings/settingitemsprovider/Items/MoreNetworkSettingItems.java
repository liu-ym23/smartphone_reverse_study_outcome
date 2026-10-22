package com.android.settings.settingitemsprovider.Items;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.wifi.WifiManager;
import android.nfc.NfcAdapter;
import android.os.Handler;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.android.settings.servicemanager.IPlatform;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import com.bytedance.news.common.service.manager.ServiceManager;
import java.util.List;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class MoreNetworkSettingItems extends SettingItems {
    public MoreNetworkSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.more_network_settings, null, Constants.COMPONENT_NETWORK_SETTINGS, null, true, R.string.more_network_settings, null));
        this.mItemList.add(new SettingItems.Items(this, R.string.mobile_network_ap, null, Constants.COMPONENT_PERSONAL_AP, null, true, buildPath(new int[]{R.string.more_network_settings, R.string.mobile_network_ap}), R.string.personal_hotspot_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.mobile_network_ap, null, true, null, null, "wifi_ap", "0", true, buildPath(new int[]{R.string.more_network_settings, R.string.mobile_network_ap, R.string.mobile_network_ap}), R.string.personal_hotspot_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.wifi_tether_configure_ap_text, null, Constants.COMPONENT_WIFI_AP_SETUP, null, true, buildPath(new int[]{R.string.more_network_settings, R.string.mobile_network_ap, R.string.wifi_tether_configure_ap_text}), R.string.set_personal_hotspot_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.wifi_tether_connected_stations_text, null, Constants.COMPONENT_SPFT_AP_CONTROLLER, null, isWifiApEnabled(this.mContext), buildPath(new int[]{R.string.more_network_settings, R.string.mobile_network_ap, R.string.wifi_tether_connected_stations_text}), R.string.connected_devices_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.advanced_item_vpn, null, Constants.COMPONENT_VPN, null, true, buildPath(new int[]{R.string.more_network_settings, R.string.advanced_item_vpn}), R.string.vpn_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.nfc_quick_toggle_title, null, Constants.COMPONENT_NFC, null, true, buildPath(new int[]{R.string.more_network_settings, R.string.nfc_quick_toggle_title}), R.string.nfc_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.nfc_quick_toggle_title, null, true, null, null, SettingsSwitchKeyUtil.NFC, "0", true, buildPath(new int[]{R.string.more_network_settings, R.string.nfc_quick_toggle_title, R.string.nfc_quick_toggle_title}), R.string.nfc_desc));
        NfcAdapter r0 = NfcAdapter.getDefaultAdapter(this.mContext);
        if (r0 != null) goto L5;
    L7:
        boolean r16 = false;
    L8:
        boolean r9 = r16;
        this.mItemList.add(new SettingItems.Items(this, R.string.nfc_reader_main_switch_title, null, true, SettingsSwitchKeyUtil.SettingTable.Global, "nfc_dnd_mode", null, "0", r9, buildPath(new int[]{R.string.more_network_settings, R.string.nfc_quick_toggle_title, R.string.nfc_reader_main_switch_title}), R.string.use_nfc_reader_desc));
        boolean r1 = SettingsFeature.isWalletNfcFeatureEnabled(this.mContext);
        List<SettingItems.Items> r10 = this.mItemList;
        if (r16 == false) goto L12;
        if (r1 == false) goto L12;
        boolean r6 = true;
    L13:
        r10.add(new SettingItems.Items(this, R.string.nfc_wallet_title, null, Constants.COMPONENT_NFC_WALLET, null, r6, buildPath(new int[]{R.string.more_network_settings, R.string.nfc_quick_toggle_title, R.string.nfc_wallet_title}), R.string.nfc_wallet_desc));
        boolean r7 = r16;
        this.mItemList.add(new SettingItems.Items(this, R.string.default_payment_service, null, Constants.COMPONENT_NFC_DEFAULT_PAYMENT, null, r7, buildPath(new int[]{R.string.more_network_settings, R.string.nfc_quick_toggle_title, R.string.default_payment_service}), R.string.default_nfc_payment_service_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.tether_settings_title_usb, null, Constants.COMPONENT_NETWORK_SETTINGS, null, true, buildPath(new int[]{R.string.more_network_settings, R.string.tether_settings_title_usb}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.system_print, null, Constants.COMPONENT_PRINT_SETTINGS, null, ((IPlatform) ServiceManager.getService(IPlatform.class)).isPrintEnable(), buildPath(new int[]{R.string.more_network_settings, R.string.system_print}), R.string.printing_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.nubia_share, null, Constants.COMPONENT_NETWORK_SETTINGS, "intent=#Intent;action=com.zte.cn.zteshare.settingsactivity.main;end", isNubiaShareEnabled(this.mContext), buildPath(new int[]{R.string.more_network_settings, R.string.nubia_share}), null));
        this.mItemList.add(new SettingItems.Items(this, R.string.otg_text, null, true, null, null, SettingsSwitchKeyUtil.OTG, "0", true, buildPath(new int[]{R.string.more_network_settings, R.string.otg_text}), null));
        return;
    L12:
        r6 = false;
        goto L13
    L5:
        if (r0.isEnabled() == false) goto L7;
        r16 = true;
        goto L8
    }

    public static void updateItems(Handler r7, Context r8, SQLiteDatabase r9) {
        if (isWifiApEnabled(r8) == false) goto L5;
        String r0 = "1";
    L6:
        executeUpdate(r7, r8, r9, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r0, "name", r8.getString(R.string.wifi_tether_connected_stations_text));
        return;
    L5:
        r0 = "0";
        goto L6
    }

    public static void updateNFCItems(Handler r9, Context r10, SQLiteDatabase r11, boolean r12) {
        if (r12 == false) goto L4;
        String r13 = "1";
    L5:
        String r4 = r13;
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.nfc_reader_main_switch_title));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.default_payment_service));
        return;
    L4:
        r13 = "0";
        goto L5
    }

    private static boolean isWifiApEnabled(Context r2) {
        WifiManager r3 = (WifiManager) r2.getSystemService("wifi");
        if (r3 != null) goto L5;
        return false;
    L5:
        if (r3.getWifiApState() != 13) goto L9;
        return true;
    L9:
        return false;
    }

    private static boolean isNubiaShareEnabled(Context r1) {
        if (SettingsFeature.isSupportNubiaShare() == true) goto L5;
    L7:
        return false;
    L5:
        if (Utils.isPackageInstalled(r1, "com.zte.cn.zteshare") == false) goto L7;
        return true;
    }
}
