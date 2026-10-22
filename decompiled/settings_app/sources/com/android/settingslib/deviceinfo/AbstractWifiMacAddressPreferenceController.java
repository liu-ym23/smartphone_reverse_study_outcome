package com.android.settingslib.deviceinfo;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settings.AdaptConstants;
import com.android.settingslib.R;
import com.android.settingslib.core.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractWifiMacAddressPreferenceController extends AbstractConnectivityPreferenceController {
    private static final String[] CONNECTIVITY_INTENTS = null;
    static final String KEY_WIFI_MAC_ADDRESS = "wifi_mac_address";
    static final int OFF = 0;
    static final int ON = 1;
    private Preference mWifiMacAddress;
    private final WifiManager mWifiManager;

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return KEY_WIFI_MAC_ADDRESS;
    }

    static {
        CONNECTIVITY_INTENTS = new String[]{"android.net.conn.CONNECTIVITY_CHANGE", AdaptConstants.LINK_CONFIGURATION_CHANGED_ACTION, "android.net.wifi.STATE_CHANGE"};
    }

    public AbstractWifiMacAddressPreferenceController(Context r1, Lifecycle r2) {
        super(r1, r2);
        this.mWifiManager = (WifiManager) r1.getSystemService(WifiManager.class);
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public boolean isAvailable() {
        if (this.mWifiManager == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r2) {
        super.displayPreference(r2);
        this.mWifiMacAddress = r2.findPreference(KEY_WIFI_MAC_ADDRESS);
        updateConnectivity();
    }

    @Override // com.android.settingslib.deviceinfo.AbstractConnectivityPreferenceController
    protected String[] getConnectivityIntents() {
        return CONNECTIVITY_INTENTS;
    }

    @Override // com.android.settingslib.deviceinfo.AbstractConnectivityPreferenceController
    protected void updateConnectivity() {
        WifiManager r0 = this.mWifiManager;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mWifiMacAddress == null) goto L23;
        String[] r1 = r0.getFactoryMacAddresses();
        if (r1 != null) goto L10;
    L12:
        String r2 = null;
    L14:
        if (TextUtils.isEmpty(r2) == false) goto L16;
    L19:
        this.mWifiMacAddress.setSummary(R.string.status_unavailable);
        return;
    L16:
        if (r2.equals("02:00:00:00:00:00") == true) goto L19;
        this.mWifiMacAddress.setSummary(r2);
        return;
    L10:
        if (r1.length <= 0) goto L12;
        r2 = r1[0];
        goto L14
    }
}
