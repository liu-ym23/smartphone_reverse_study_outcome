package com.android.settings.settingitemsprovider.Items;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.android.settings.R;
import com.android.settings.settingitemsprovider.Constants;
import com.android.settings.settingitemsprovider.DatabaseHelper;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothSettingItems extends SettingItems {
    public BluetoothSettingItems(Context r1) {
        super(r1);
    }

    @Override // com.android.settings.settingitemsprovider.Items.SettingItems
    public void initItemList() {
        this.mItemList.add(new SettingItems.Items(this, R.string.bluetooth_settings, null, Constants.COMPONENT_BLUETOOTH, null, true, R.string.bluetooth_settings, R.string.bluetooth_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.bluetooth_settings, null, true, null, null, "bluetooth", "0", true, buildPath(new int[]{R.string.bluetooth_settings, R.string.bluetooth_settings}), R.string.bluetooth_desc));
        boolean r0 = BluetoothAdapter.getDefaultAdapter().isEnabled();
        this.mItemList.add(new SettingItems.Items(this, R.string.device_name_new, null, Constants.COMPONENT_BLUETOOTH, null, r0, buildPath(new int[]{R.string.bluetooth_settings, R.string.device_name_new}), R.string.local_device_name_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.bluetooth_show_received_files, null, Constants.COMPONENT_BLUETOOTH_HISTORY, "direction=1|android.btopp.intent.extra.SHOW_ALL=true|android.btopp.intent.extra.SEARCH=true", true, buildPath(new int[]{R.string.bluetooth_settings, R.string.bluetooth_show_received_files}), R.string.files_received_via_bluetooth_desc));
        this.mItemList.add(new SettingItems.Items(this, R.string.bluetooth_preference_found_devices, null, Constants.COMPONENT_BLUETOOTH, null, r0, buildPath(new int[]{R.string.bluetooth_settings, R.string.bluetooth_preference_found_devices}), R.string.pairing_devices_in_range_desc));
    }

    public static void updateItems(Handler r9, Context r10, SQLiteDatabase r11, int r12) {
        if (r12 != 12) goto L5;
        String r13 = "1";
    L6:
        String r4 = r13;
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, DatabaseHelper.ItemsRecord.ITEM_PATH_1, buildPath(new int[]{R.string.bluetooth_settings, R.string.device_name_new}));
        executeUpdate(r9, r10, r11, DatabaseHelper.ItemsRecord.IS_SEARCHABLE, r4, "name", r10.getString(R.string.bluetooth_preference_found_devices));
        return;
    L5:
        r13 = "0";
        goto L6
    }
}
