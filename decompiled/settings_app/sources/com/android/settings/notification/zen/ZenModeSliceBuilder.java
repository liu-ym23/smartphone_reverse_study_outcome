package com.android.settings.notification.zen;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Binder;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.builders.ListBuilder;
import androidx.slice.builders.SliceAction;
import com.android.settings.R;
import com.android.settings.SubSettings;
import com.android.settings.Utils;
import com.android.settings.slices.CustomSliceRegistry;
import com.android.settings.slices.SliceBroadcastReceiver;
import com.android.settings.slices.SliceBuilderUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.vcard.VCardConfig;

/* JADX INFO: loaded from: classes2.dex */
public class ZenModeSliceBuilder {
    public static final String ACTION_ZEN_MODE_SLICE_CHANGED = "com.android.settings.notification.ZEN_MODE_CHANGED";
    public static final IntentFilter INTENT_FILTER = null;
    private static final String TAG = "ZenModeSliceBuilder";
    private static final String ZEN_MODE_SLICE_KEY = "zen_mode_toggle";

    public static void handleUriChange(Context r0, Intent r1) {
    }

    static {
        IntentFilter r0 = new IntentFilter();
        INTENT_FILTER = r0;
        r0.addAction("android.app.action.NOTIFICATION_POLICY_CHANGED");
        r0.addAction("android.app.action.INTERRUPTION_FILTER_CHANGED");
        r0.addAction("android.app.action.INTERRUPTION_FILTER_CHANGED_INTERNAL");
    }

    private ZenModeSliceBuilder() {
    }

    public static Slice getSlice(Context r8) {
        boolean r0 = isZenModeEnabled(r8);
        CharSequence r1 = r8.getText(R.string.zen_mode_settings_title);
        CharSequence r2 = r8.getText(R.string.zen_mode_slice_subtitle);
        int r3 = Utils.getColorAccentDefaultColor(r8);
        PendingIntent r4 = getBroadcastIntent(r8);
        IconCompat r7 = (IconCompat) null;
        SliceAction r5 = SliceAction.createDeeplink(getPrimaryAction(r8), null, 0, r1);
        SliceAction r6 = SliceAction.createToggle(r4, null, r0);
        ListBuilder.RowBuilder r9 = new ListBuilder.RowBuilder().setTitle(r1).setPrimaryAction(r5);
        if (isManagedByAdmin(r8) == true) goto L6;
        r9.addEndItem(r6);
    L6:
        if (isSettingsIntelligence(r8) == true) goto L9;
        r9.setSubtitle(r2);
    L9:
        return new ListBuilder(r8, CustomSliceRegistry.ZEN_MODE_SLICE_URI, -1).setAccentColor(r3).addRow(r9).build();
    }

    public static boolean isSettingsIntelligence(Context r2) {
        int r0 = Binder.getCallingUid();
        return TextUtils.equals(r2.getPackageManager().getPackagesForUid(r0)[0], r2.getString(R.string.config_settingsintelligence_package_name));
    }

    public static Intent getIntent(Context r8) {
        Uri r0 = new Uri.Builder().appendPath(ZEN_MODE_SLICE_KEY).build();
        return SliceBuilderUtils.buildSearchResultPageIntent(r8, "", ZEN_MODE_SLICE_KEY, r8.getText(R.string.zen_mode_settings_title).toString(), 76, R.string.menu_key_notifications).setClassName(r8.getPackageName(), SubSettings.class.getName()).setData(r0);
    }

    private static boolean isZenModeEnabled(Context r1) {
        NotificationManager r2 = (NotificationManager) r1.getSystemService(NotificationManager.class);
        return false;
    }

    private static PendingIntent getPrimaryAction(Context r3) {
        return PendingIntent.getActivity(r3, 0, getIntent(r3), VCardConfig.FLAG_APPEND_TYPE_PARAM);
    }

    private static PendingIntent getBroadcastIntent(Context r3) {
        return PendingIntent.getBroadcast(r3, 0, new Intent(ACTION_ZEN_MODE_SLICE_CHANGED).setClass(r3, SliceBroadcastReceiver.class), 301989888);
    }

    private static boolean isManagedByAdmin(Context r2) {
        if (RestrictedLockUtilsInternal.checkIfRestrictionEnforced(r2, "no_adjust_volume", UserHandle.myUserId()) == null) goto L5;
        return true;
    L5:
        return false;
    }
}
