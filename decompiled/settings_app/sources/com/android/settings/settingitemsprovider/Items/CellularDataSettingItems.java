package com.android.settings.settingitemsprovider.Items;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.R;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.settingitemsprovider.DatabaseHelper;
import obric.app.settings.search.SettingsSwitchKeyUtil;

/* JADX INFO: loaded from: classes2.dex */
public class CellularDataSettingItems extends SettingItems {
    private static final String PHONE_PACKAGE_NAME = "com.android.phone";

    public CellularDataSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        String r14 = getPackageString(this.mContext, PHONE_PACKAGE_NAME, "cellular_data");
        this.mItemList.add(new SettingItems.Items(this, r14, this.mContext.getString(R.string.alias_cellular), Constants.COMPONENT_PHONE_MOBILE_DATA, "from_search=true", true, r14, R.string.cellular_mobile_data_desc));
        this.mItemList.add(new SettingItems.Items(this, r14, null, true, null, null, SettingsSwitchKeyUtil.PHONE_MOBILE_DATA_SWITCH, "1", true, buildPath(new String[]{r14, r14}), R.string.cellular_mobile_data_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, PHONE_PACKAGE_NAME, "data_roaming"), null, true, null, null, SettingsSwitchKeyUtil.PHONE_MOBILE_DATA_ROAMING_SWITCH, "1", true, buildPath(new String[]{r14, getPackageString(this.mContext, PHONE_PACKAGE_NAME, "data_roaming")}), R.string.data_roaming_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, PHONE_PACKAGE_NAME, "fiveg_power_saver_title"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "fiveg_power_saver_enabled", null, "1", true, buildPath(new String[]{r14, getPackageString(this.mContext, PHONE_PACKAGE_NAME, "fiveg_power_saver_title")}), R.string.smart_power_saving_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, PHONE_PACKAGE_NAME, "low_power_5g_switch_title"), null, true, SettingsSwitchKeyUtil.SettingTable.Global, "diable_5g_in_psm", null, "1", true, buildPath(new String[]{r14, getPackageString(this.mContext, PHONE_PACKAGE_NAME, "low_power_5g_switch_title")}), R.string.disable_5g_in_power_saving_mode_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.data_usage_title_long), null, Constants.COMPONENT_SECURITY_DATA_USAGE, null, true, buildPath(new String[]{r14, this.mContext.getString(R.string.data_usage_title_long)}), R.string.mobile_data_traffic_management_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.data_usage_alarm), null, Constants.COMPONENT_SECURITY_DATA_USAGE_DETAIL, "hidden_list=true", true, buildPath(new String[]{r14, this.mContext.getString(R.string.data_usage_title_long), this.mContext.getString(R.string.data_usage_alarm)}), R.string.traffic_reminder_desc));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.network_background_control_title), null, Constants.COMPONENT_SECURITY_NETWORK_CONTROL, null, true, buildPath(new String[]{r14, this.mContext.getString(R.string.data_usage_title_long), this.mContext.getString(R.string.network_background_control_title)}), R.string.network_connection_control_desc));
        this.mItemList.add(new SettingItems.Items(this, getPackageString(this.mContext, PHONE_PACKAGE_NAME, "advance_settings"), null, Constants.COMPONENT_PHONE_MOBILE_DATA_ADVANCED, null, true, buildPath(new String[]{r14, getPackageString(this.mContext, PHONE_PACKAGE_NAME, "advance_settings")}), null));
        this.mItemList.add(new SettingItems.Items(this, this.mContext.getString(R.string.mobile_network_vpn), null, Constants.COMPONENT_PHONE_MOBILE_DATA_ADVANCED, null, true, buildPath(new String[]{r14, getPackageString(this.mContext, PHONE_PACKAGE_NAME, "advance_settings"), this.mContext.getString(R.string.mobile_network_vpn)}), R.string.access_point_settings_desc));
    }

    public static void updateItems(Handler r18, Context r19, SQLiteDatabase r20, boolean r21, boolean r22, boolean r23) {
        if (r21 == true) goto L6;
        if (r23 == false) goto L6;
        boolean r11 = true;
    L7:
        String r0 = "is_switch = '1' and name = '" + getPackageString(r19, PHONE_PACKAGE_NAME, "cellular_data") + "'";
        ContentValues r1 = new ContentValues();
        if (r11 == false) goto L10;
        String r2 = "1";
    L11:
        r1.put(DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r2);
        if (r11 == false) goto L14;
        String r3 = ExifInterface.GPS_MEASUREMENT_2D;
    L15:
        r1.put(DatabaseHelper.ItemsRecord.REVONE_SEARCH_TYPE, r3);
        r20.update("settingitems", r1, r0, null);
        String r4 = "is_switch = '0' and name = '" + getPackageString(r19, PHONE_PACKAGE_NAME, "cellular_data") + "' and revone_search_type = '0'";
        ContentValues r5 = new ContentValues();
        if (r21 == false) goto L18;
        String r6 = "0";
    L19:
        r5.put(DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r6);
        r20.update("settingitems", r5, r4, null);
        if (r11 == false) goto L23;
        if (r22 == false) goto L23;
        String r7 = "1";
    L24:
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r7, "name", getPackageString(r19, PHONE_PACKAGE_NAME, "data_roaming"));
        if (r11 == false) goto L28;
        if (r22 == false) goto L28;
        String r8 = "1";
    L29:
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r8, "name", getPackageString(r19, PHONE_PACKAGE_NAME, "fiveg_power_saver_title"));
        if (r21 == false) goto L32;
        String r9 = "0";
    L33:
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r9, "name", getPackageString(r19, PHONE_PACKAGE_NAME, "5g_switch_title"));
        if (r11 == false) goto L37;
        if (r22 == false) goto L37;
        String r10 = "1";
    L38:
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r10, "name", r19.getString(R.string.mobile_network_vpn));
        if (r21 == false) goto L41;
        String r12 = "0";
    L42:
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r12, "name", r19.getString(R.string.data_usage_title_long));
        if (r21 == false) goto L45;
        String r13 = "0";
    L46:
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r13, "name", r19.getString(R.string.data_usage_alarm));
        if (r21 == false) goto L49;
        String r14 = "0";
    L50:
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r14, "name", r19.getString(R.string.network_background_control_title));
        if (r11 == false) goto L54;
        if (r22 == false) goto L54;
        String r15 = "1";
    L55:
        executeUpdate(r18, r19, r20, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r15, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new String[]{getPackageString(r19, PHONE_PACKAGE_NAME, "cellular_data"), getPackageString(r19, PHONE_PACKAGE_NAME, "advance_settings")}));
        return;
    L54:
        r15 = "0";
        goto L55
    L49:
        r14 = "1";
        goto L50
    L45:
        r13 = "1";
        goto L46
    L41:
        r12 = "1";
    L37:
        r10 = "0";
        goto L38
    L32:
        r9 = "1";
    L28:
        r8 = "0";
    L23:
        r7 = "0";
        goto L24
    L18:
        r6 = "1";
        goto L19
    L14:
        r3 = "0";
        goto L15
    L10:
        r2 = "0";
    L6:
        r11 = false;
        goto L7
    }
}
