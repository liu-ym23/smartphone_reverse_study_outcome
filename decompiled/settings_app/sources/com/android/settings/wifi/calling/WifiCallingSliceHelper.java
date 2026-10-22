package com.android.settings.wifi.calling;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.telephony.SubscriptionManager;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.builders.ListBuilder;
import androidx.slice.builders.SliceAction;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.slices.SliceBroadcastReceiver;
import com.android.vcard.VCardConfig;

/* JADX INFO: loaded from: classes.dex */
public class WifiCallingSliceHelper {
    public static final String ACTION_WIFI_CALLING_CHANGED = "com.android.settings.wifi.calling.action.WIFI_CALLING_CHANGED";
    public static final String ACTION_WIFI_CALLING_PREFERENCE_CELLULAR_PREFERRED = "com.android.settings.slice.action.WIFI_CALLING_PREFERENCE_CELLULAR_PREFERRED";
    public static final String ACTION_WIFI_CALLING_PREFERENCE_WIFI_ONLY = "com.android.settings.slice.action.WIFI_CALLING_PREFERENCE_WIFI_ONLY";
    public static final String ACTION_WIFI_CALLING_PREFERENCE_WIFI_PREFERRED = "com.android.settings.slice.action.WIFI_CALLING_PREFERENCE_WIFI_PREFERRED";
    public static final String ACTION_WIFI_CALLING_SETTINGS_ACTIVITY = "android.settings.WIFI_CALLING_SETTINGS";
    public static final String PATH_WIFI_CALLING = "wifi_calling";
    public static final String PATH_WIFI_CALLING_PREFERENCE = "wifi_calling_preference";
    private static final String TAG = "WifiCallingSliceHelper";
    private static final int TIMEOUT_MILLIS = 2000;
    private final Context mContext;

    public WifiCallingSliceHelper(Context r1) {
        this.mContext = r1;
    }

    public Slice createWifiCallingSlice(Uri r3) {
        return getWifiCallingSlice(r3, false, getDefaultVoiceSubId());
    }

    private Slice getWifiCallingSlice(Uri r6, boolean r7, int r8) {
        IconCompat r0 = IconCompat.createWithResource(this.mContext, R.drawable.wifi_signal);
        Resources r9 = getResourcesForSubId(r8);
        return new ListBuilder(this.mContext, r6, -1).setAccentColor(Utils.getColorAccentDefaultColor(this.mContext)).addRow(new ListBuilder.RowBuilder().setTitle(r9.getText(R.string.wifi_calling_settings_title)).addEndItem(SliceAction.createToggle(getBroadcastIntent(ACTION_WIFI_CALLING_CHANGED, r7), null, r7)).setPrimaryAction(SliceAction.createDeeplink(getActivityIntent(ACTION_WIFI_CALLING_SETTINGS_ACTIVITY), r0, 0, r9.getText(R.string.wifi_calling_settings_title)))).build();
    }

    private PendingIntent getBroadcastIntent(String r3, boolean r4) {
        Intent r0 = new Intent(r3);
        r0.setClass(this.mContext, SliceBroadcastReceiver.class);
        r0.addFlags(268435456);
        r0.putExtra("android.app.slice.extra.TOGGLE_STATE", r4);
        return PendingIntent.getBroadcast(this.mContext, 0, r0, 335544320);
    }

    private PendingIntent getActivityIntent(String r3) {
        Intent r0 = new Intent(r3);
        r0.setPackage("com.android.settings");
        r0.addFlags(268435456);
        return PendingIntent.getActivity(this.mContext, 0, r0, VCardConfig.FLAG_APPEND_TYPE_PARAM);
    }

    protected int getDefaultVoiceSubId() {
        return SubscriptionManager.getDefaultVoiceSubscriptionId();
    }

    private Resources getResourcesForSubId(int r1) {
        return SubscriptionManager.getResourcesForSubId(this.mContext, r1);
    }
}
