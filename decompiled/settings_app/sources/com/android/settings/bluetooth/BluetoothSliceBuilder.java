package com.android.settings.bluetooth;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.builders.ListBuilder;
import androidx.slice.builders.SliceAction;
import com.android.settings.R;
import com.android.settings.SubSettings;
import com.android.settings.slices.CustomSliceRegistry;
import com.android.settings.slices.SliceBroadcastReceiver;
import com.android.settings.slices.SliceBuilderUtils;
import com.android.vcard.VCardConfig;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothSliceBuilder {
    public static final String ACTION_BLUETOOTH_SLICE_CHANGED = "com.android.settings.bluetooth.action.BLUETOOTH_MODE_CHANGED";
    public static final IntentFilter INTENT_FILTER = null;
    private static final String TAG = "BluetoothSliceBuilder";

    static {
        IntentFilter r0 = new IntentFilter();
        INTENT_FILTER = r0;
        r0.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        r0.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    }

    private BluetoothSliceBuilder() {
    }

    public static Slice getSlice(Context r8) {
        boolean r0 = isBluetoothEnabled();
        CharSequence r1 = r8.getText(R.string.bluetooth_settings);
        IconCompat r2 = IconCompat.createWithResource(r8, android.R.drawable.pointer_wait_61);
        int r3 = com.android.settings.Utils.getColorAccent(r8).getDefaultColor();
        PendingIntent r4 = getBroadcastIntent(r8);
        SliceAction r5 = SliceAction.createDeeplink(getPrimaryAction(r8), r2, 0, r1);
        SliceAction r6 = SliceAction.createToggle(r4, null, r0);
        return new ListBuilder(r8, CustomSliceRegistry.BLUETOOTH_URI, -1).setAccentColor(r3).addRow(new ListBuilder.RowBuilder().setTitle(r1).addEndItem(r6).setPrimaryAction(r5)).build();
    }

    public static Intent getIntent(Context r7) {
        String r4 = r7.getText(R.string.bluetooth_settings_title).toString();
        Uri r0 = new Uri.Builder().appendPath("bluetooth").build();
        return SliceBuilderUtils.buildSearchResultPageIntent(r7, "", null, r4, 747, R.string.menu_key_connected_devices).setClassName(r7.getPackageName(), SubSettings.class.getName()).setData(r0);
    }

    public static void handleUriChange(Context r1, Intent r2) {
        boolean r3 = r2.getBooleanExtra("android.app.slice.extra.TOGGLE_STATE", false);
        BluetoothAdapter r4 = BluetoothAdapter.getDefaultAdapter();
        if (r3 == false) goto L5;
        r4.enable();
        return;
    L5:
        r4.disable();
    }

    private static boolean isBluetoothEnabled() {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0.getState() != 12) goto L5;
    L8:
        return true;
    L5:
        if (r0.getState() == 11) goto L8;
        return false;
    }

    private static PendingIntent getPrimaryAction(Context r3) {
        return PendingIntent.getActivity(r3, 0, getIntent(r3), VCardConfig.FLAG_APPEND_TYPE_PARAM);
    }

    private static PendingIntent getBroadcastIntent(Context r3) {
        return PendingIntent.getBroadcast(r3, 0, new Intent(ACTION_BLUETOOTH_SLICE_CHANGED).setClass(r3, SliceBroadcastReceiver.class), 167772160);
    }
}
