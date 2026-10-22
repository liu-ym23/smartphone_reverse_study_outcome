package com.android.settings.wifi.slice;

import android.content.Context;
import android.text.TextUtils;
import com.android.settings.R;
import com.android.wifitrackerlib.HotspotNetworkEntry;
import com.android.wifitrackerlib.WifiEntry;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(forRemoval = true)
public class WifiSliceItem {
    private static final int[] WIFI_CONNECTION_STRENGTH = null;
    private final int mConnectedState;
    private final Context mContext;
    private final boolean mHasInternetAccess;
    private int mInstantHotspotDeviceType;
    private boolean mIsInstantHotspotNetwork;
    private final String mKey;
    private final int mLevel;
    private final int mSecurity;
    private final boolean mShouldEditBeforeConnect;
    private final boolean mShouldShowXLevelIcon;
    private final String mSummary;
    private final String mTitle;

    static {
        WIFI_CONNECTION_STRENGTH = new int[]{R.string.accessibility_no_wifi, R.string.accessibility_wifi_one_bar, R.string.accessibility_wifi_two_bars, R.string.accessibility_wifi_three_bars, R.string.accessibility_wifi_signal_full};
    }

    public WifiSliceItem(Context r1, WifiEntry r2) {
        this.mContext = r1;
        this.mKey = r2.getKey();
        this.mTitle = r2.getTitle();
        this.mSecurity = r2.getSecurity();
        this.mConnectedState = r2.getConnectedState();
        this.mLevel = r2.getLevel();
        this.mShouldShowXLevelIcon = r2.shouldShowXLevelIcon();
        this.mShouldEditBeforeConnect = r2.shouldEditBeforeConnect();
        this.mHasInternetAccess = r2.hasInternetAccess();
        this.mSummary = r2.getSummary(false);
        boolean r3 = r2 instanceof HotspotNetworkEntry;
        this.mIsInstantHotspotNetwork = r3;
        if (r3 == false) goto L6;
        this.mInstantHotspotDeviceType = ((HotspotNetworkEntry) r2).getDeviceType();
        return;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof WifiSliceItem) == true) goto L5;
        return false;
    L5:
        WifiSliceItem r5 = (WifiSliceItem) r4;
        if (TextUtils.equals(getKey(), r5.getKey()) == true) goto L9;
        return false;
    L9:
        if (getConnectedState() == r5.getConnectedState()) goto L12;
        return false;
    L12:
        if (getLevel() == r5.getLevel()) goto L15;
        return false;
    L15:
        if (shouldShowXLevelIcon() == r5.shouldShowXLevelIcon()) goto L18;
        return false;
    L18:
        if (TextUtils.equals(getSummary(), r5.getSummary()) == true) goto L21;
        return false;
    L21:
        if (isInstantHotspotNetwork() == r5.isInstantHotspotNetwork()) goto L24;
        return false;
    L24:
        if (getInstantHotspotDeviceType() == r5.getInstantHotspotDeviceType()) goto L26;
        return false;
    L26:
        return true;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getSecurity() {
        return this.mSecurity;
    }

    public int getConnectedState() {
        return this.mConnectedState;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean shouldShowXLevelIcon() {
        return this.mShouldShowXLevelIcon;
    }

    public boolean hasInternetAccess() {
        return this.mHasInternetAccess;
    }

    public boolean shouldEditBeforeConnect() {
        return this.mShouldEditBeforeConnect;
    }

    public String getSummary() {
        return this.mSummary;
    }

    public boolean isInstantHotspotNetwork() {
        return this.mIsInstantHotspotNetwork;
    }

    public int getInstantHotspotDeviceType() {
        return this.mInstantHotspotDeviceType;
    }

    public CharSequence getContentDescription() {
        CharSequence r0 = this.mTitle;
        if (TextUtils.isEmpty(this.mSummary) == true) goto L5;
        r0 = TextUtils.concat(new CharSequence[]{r0, ",", this.mSummary});
    L5:
        int r1 = this.mLevel;
        if (r1 < 0) goto L10;
        int[] r7 = WIFI_CONNECTION_STRENGTH;
        if (r1 >= r7.length) goto L10;
        r0 = TextUtils.concat(new CharSequence[]{r0, ",", this.mContext.getString(r7[r1])});
    L10:
        CharSequence[] r2 = new CharSequence[3];
        r2[0] = r0;
        r2[1] = ",";
        if (this.mSecurity != 0) goto L13;
        String r9 = this.mContext.getString(R.string.accessibility_wifi_security_type_none);
    L14:
        r2[2] = r9;
        return TextUtils.concat(r2);
    L13:
        r9 = this.mContext.getString(R.string.accessibility_wifi_security_type_secured);
        goto L14
    }
}
