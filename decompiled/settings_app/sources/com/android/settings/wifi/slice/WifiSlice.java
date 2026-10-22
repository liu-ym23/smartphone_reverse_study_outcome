package com.android.settings.wifi.slice;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.EventLog;
import androidx.core.graphics.drawable.IconCompat;
import androidx.slice.Slice;
import androidx.slice.builders.ListBuilder;
import androidx.slice.builders.SliceAction;
import com.android.settings.R;
import com.android.settings.Settings;
import com.android.settings.SubSettings;
import com.android.settings.core.SubSettingLauncher;
import com.android.settings.slices.CustomSliceRegistry;
import com.android.settings.slices.CustomSliceable;
import com.android.settings.slices.SliceBackgroundWorker;
import com.android.settings.slices.SliceBuilderUtils;
import com.android.settings.wifi.AppStateChangeWifiStateBridge;
import com.android.settings.wifi.WifiDialogActivity;
import com.android.settingslib.wifi.WifiEnterpriseRestrictionUtils;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(forRemoval = true)
public class WifiSlice implements CustomSliceable {
    static final int DEFAULT_EXPANDED_ROW_COUNT = 3;
    public static final String KEY_CHOSEN_WIFIENTRY_KEY = "key_chosen_wifientry_key";
    private static final String TAG = "WifiSlice";
    protected final Context mContext;
    protected final WifiManager mWifiManager;
    protected final WifiRestriction mWifiRestriction;

    static class WifiRestriction {
        WifiRestriction() {
        }

        public boolean isChangeWifiStateAllowed(Context r1) {
            if (r1 != null) goto L6;
            return true;
        L6:
            return WifiEnterpriseRestrictionUtils.isChangeWifiStateAllowed(r1);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$U_QlcWB8Xuvutp-FPuoHlo0M96U, reason: not valid java name */
    public static /* synthetic */ String m733$r8$lambda$U_QlcWB8XuvutpFPuoHlo0M96U(String r0) {
        return r0.trim();
    }

    private boolean isSatelliteOn() {
        return false;
    }

    @Override // com.android.settings.slices.CustomSliceable, com.android.settings.slices.Sliceable
    public int getSliceHighlightMenuRes() {
        return R.string.menu_key_network;
    }

    protected boolean isApRowCollapsed() {
        return false;
    }

    public WifiSlice(Context r2) {
        this(r2, new WifiRestriction());
    }

    WifiSlice(Context r2, WifiRestriction r3) {
        this.mContext = r2;
        this.mWifiManager = (WifiManager) r2.getSystemService(WifiManager.class);
        this.mWifiRestriction = r3;
    }

    @Override // com.android.settings.slices.CustomSliceable
    public Uri getUri() {
        return CustomSliceRegistry.WIFI_SLICE_URI;
    }

    @Override // com.android.settings.slices.CustomSliceable
    public Slice getSlice() {
        boolean r0 = isWifiEnabled();
        List<WifiSliceItem> r3 = null;
        int r5 = 0;
        if (isGuestUser(this.mContext) == false) goto L7;
        OLog.e(TAG, "Guest user is not allowed to configure Wi-Fi!");
        EventLog.writeEvent(1397638484, new Object[]{"232798363", -1, "User is a guest"});
        return getListBuilder(r0, null, false).build();
    L7:
        if (isCallerExemptUid(this.mContext) == false) goto L9;
    L12:
        boolean r1 = true;
    L13:
        ListBuilder r6 = getListBuilder(r0, null, r1);
        if (r0 == false) goto L45;
        if (r1 == false) goto L45;
        WifiScanWorker r2 = (WifiScanWorker) SliceBackgroundWorker.getInstance(getUri());
        if (r2 == null) goto L20;
        r3 = r2.getResults();
    L20:
        if (r3 != null) goto L22;
        int r4 = 0;
    L23:
        if (r4 > 0) goto L25;
    L27:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L31;
        r6 = getListBuilder(true, r3.get(0), true);
    L31:
        if (isApRowCollapsed() == true) goto L33;
        CharSequence r8 = this.mContext.getText(R.string.summary_placeholder);
    L35:
        if (r5 >= 3) goto L43;
        if (r5 >= r4) goto L38;
        r6.addRow(getWifiSliceItemRow(r3.get(r5)));
    L41:
        r5 = r5 + 1;
        goto L35
    L38:
        if (r5 != r4) goto L40;
        r6.addRow(getLoadingRow(r8));
        goto L41
    L40:
        r6.addRow(new ListBuilder.RowBuilder().setTitle(r8).setSubtitle(r8));
        goto L41
    L43:
        return r6.build();
    L33:
        return r6.build();
    L25:
        if (r3.get(0).getConnectedState() == 0) goto L27;
        r7 = true;
        goto L28
    L22:
        r4 = r3.size();
    L45:
        return r6.build();
    L9:
        if (isPermissionGranted(this.mContext) == true) goto L12;
        r1 = false;
        goto L13
    }

    protected static boolean isGuestUser(Context r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        UserManager r3 = (UserManager) r2.getSystemService(UserManager.class);
        if (r3 != null) goto L9;
        return false;
    L9:
        return r3.isGuestUser();
    }

    private boolean isCallerExemptUid(Context r5) {
        String[] r4 = r5.getResources().getStringArray(R.array.config_exempt_wifi_permission_uid_name);
        String r6 = r5.getPackageManager().getNameForUid(Binder.getCallingUid());
        OLog.d(TAG, "calling uid name : " + r6);
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (TextUtils.equals(r6, r4[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static boolean isPermissionGranted(Context r7) {
        int r0 = Binder.getCallingUid();
        String r1 = r7.getPackageManager().getPackagesForUid(r0)[0];
        if (r7.createPackageContext(r1, 0).checkPermission("android.permission.CHANGE_WIFI_STATE", Binder.getCallingPid(), r0) != 0) goto L7;
        boolean r3 = true;
    L8:
        AppStateChangeWifiStateBridge.WifiSettingsState r8 = new AppStateChangeWifiStateBridge(r7, null, null).getWifiSettingsInfo(r1, r0);
        if (r3 == true) goto L11;
        return false;
    L11:
        if (r8.isPermissible() == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r3 = false;
    L14:
        OLog.e(TAG, "Cannot create Context for package: " + r1);
        return false;
    }

    protected ListBuilder.RowBuilder getHeaderRow(boolean r3, WifiSliceItem r4) {
        IconCompat r5 = IconCompat.createWithResource(this.mContext, R.drawable.ic_settings_wireless);
        String r6 = this.mContext.getString(R.string.wifi_settings);
        SliceAction r7 = SliceAction.createDeeplink(getPrimaryAction(), r5, 0, r6);
        ListBuilder.RowBuilder r8 = new ListBuilder.RowBuilder().setTitle(r6).setPrimaryAction(r7);
        if (this.mWifiRestriction.isChangeWifiStateAllowed(this.mContext) == true) goto L5;
        r8.setSubtitle(this.mContext.getString(R.string.not_allowed_by_ent));
    L5:
        return r8;
    }

    private ListBuilder getListBuilder(boolean r6, WifiSliceItem r7, boolean r8) {
        ListBuilder r9 = new ListBuilder(this.mContext, getUri(), -1).setAccentColor(-1).setKeywords(getKeywords()).addRow(getHeaderRow(r6, r7));
        if (r8 == true) goto L5;
    L10:
        return r9;
    L5:
        if (this.mWifiRestriction.isChangeWifiStateAllowed(this.mContext) == false) goto L10;
        if (isSatelliteOn() == true) goto L10;
        r9.addAction(SliceAction.createToggle(getBroadcastIntent(this.mContext), null, r6));
        goto L10
    }

    protected ListBuilder.RowBuilder getWifiSliceItemRow(WifiSliceItem r5) {
        String r0 = r5.getTitle();
        return new ListBuilder.RowBuilder().setTitleItem(0).setTitle(r0).setSubtitle(r5.getSummary()).setContentDescription(r5.getContentDescription()).setPrimaryAction(getWifiEntryAction(r5, r0));
    }

    protected SliceAction getWifiEntryAction(WifiSliceItem r7, CharSequence r8) {
        int r0 = r7.getKey().hashCode();
        if (r7.getConnectedState() == 0) goto L7;
        Bundle r1 = new Bundle();
        r1.putString("key_chosen_wifientry_key", r7.getKey());
        return getActivityAction(r0, new SubSettingLauncher(this.mContext).setTitleRes(R.string.pref_title_network_details).setDestination(Settings.AccessPointDetailActivity.class.getName()).setArguments(r1).setSourceMetricsCategory(103).toIntent(), null, r8);
    L7:
        if (r7.shouldEditBeforeConnect() == false) goto L11;
        return getActivityAction(r0, new Intent(this.mContext, WifiDialogActivity.class).putExtra("key_chosen_wifientry_key", r7.getKey()), null, r8);
    L11:
        return getBroadcastAction(r0, new Intent(this.mContext, ConnectToWifiHandler.class).putExtra("key_chosen_wifientry_key", r7.getKey()).putExtra("key_wifi_slice_uri", getUri()), null, r8);
    }

    private SliceAction getActivityAction(int r2, Intent r3, IconCompat r4, CharSequence r5) {
        return SliceAction.createDeeplink(PendingIntent.getActivity(this.mContext, r2, r3, VCardConfig.FLAG_APPEND_TYPE_PARAM), r4, 0, r5);
    }

    private SliceAction getBroadcastAction(int r2, Intent r3, IconCompat r4, CharSequence r5) {
        r3.addFlags(268435456);
        return SliceAction.create(PendingIntent.getBroadcast(this.mContext, r2, r3, 201326592), r4, 0, r5);
    }

    private ListBuilder.RowBuilder getLoadingRow(CharSequence r4) {
        CharSequence r3 = this.mContext.getText(R.string.wifi_empty_list_wifi_on);
        return new ListBuilder.RowBuilder().setTitleItem(null, 0).setTitle(r4).setSubtitle(r3);
    }

    @Override // com.android.settings.slices.CustomSliceable
    public void onNotifyChange(Intent r3) {
        boolean r4 = r3.getBooleanExtra("android.app.slice.extra.TOGGLE_STATE", this.mWifiManager.isWifiEnabled());
        this.mWifiManager.setWifiEnabled(r4);
    }

    @Override // com.android.settings.slices.CustomSliceable
    public Intent getIntent() {
        String r4 = this.mContext.getText(R.string.wifi_settings).toString();
        Uri r0 = new Uri.Builder().appendPath("wifi").build();
        String r2 = Settings.AccessPointDetailActivity.class.getName();
        return SliceBuilderUtils.buildSearchResultPageIntent(this.mContext, r2, "", r4, 603, this).setClassName(this.mContext.getPackageName(), SubSettings.class.getName()).setData(r0);
    }

    private boolean isWifiEnabled() {
        int r1 = this.mWifiManager.getWifiState();
        if (r1 != 2) goto L5;
        return true;
    L5:
        if (r1 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    private PendingIntent getPrimaryAction() {
        Intent r0 = getIntent();
        return PendingIntent.getActivity(this.mContext, 0, r0, VCardConfig.FLAG_APPEND_TYPE_PARAM);
    }

    private Set<String> getKeywords() {
        return (Set) Arrays.asList(TextUtils.split(this.mContext.getString(R.string.keywords_wifi), ",")).stream().map(new WifiSlice$$ExternalSyntheticLambda0()).collect(Collectors.toSet());
    }

    @Override // com.android.settings.slices.Sliceable
    public Class getBackgroundWorkerClass() {
        return WifiScanWorker.class;
    }
}
