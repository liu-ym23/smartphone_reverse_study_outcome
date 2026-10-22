package com.android.settingslib.deviceinfo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settings.AdaptConstants;
import com.android.settingslib.R;
import com.android.settingslib.core.lifecycle.Lifecycle;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractIpAddressPreferenceController extends AbstractConnectivityPreferenceController {
    private static final String[] CONNECTIVITY_INTENTS = null;
    static final String KEY_IP_ADDRESS = "wifi_ip_address";
    private final ConnectivityManager mCM;
    private Preference mIpAddress;

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return KEY_IP_ADDRESS;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public boolean isAvailable() {
        return true;
    }

    static {
        CONNECTIVITY_INTENTS = new String[]{"android.net.conn.CONNECTIVITY_CHANGE", AdaptConstants.LINK_CONFIGURATION_CHANGED_ACTION, "android.net.wifi.STATE_CHANGE"};
    }

    public AbstractIpAddressPreferenceController(Context r1, Lifecycle r2) {
        super(r1, r2);
        this.mCM = (ConnectivityManager) r1.getSystemService(ConnectivityManager.class);
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r2) {
        super.displayPreference(r2);
        this.mIpAddress = r2.findPreference(KEY_IP_ADDRESS);
        updateConnectivity();
    }

    @Override // com.android.settingslib.deviceinfo.AbstractConnectivityPreferenceController
    protected String[] getConnectivityIntents() {
        return CONNECTIVITY_INTENTS;
    }

    @Override // com.android.settingslib.deviceinfo.AbstractConnectivityPreferenceController
    protected void updateConnectivity() {
        String r0 = getDefaultIpAddresses(this.mCM);
        if (r0 == null) goto L5;
        this.mIpAddress.setSummary(r0);
        return;
    L5:
        this.mIpAddress.setSummary(R.string.status_unavailable);
    }

    private static String getDefaultIpAddresses(ConnectivityManager r1) {
        return formatIpAddresses(r1.getLinkProperties(r1.getActiveNetwork()));
    }

    private static String formatIpAddresses(LinkProperties r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Iterator r3 = r2.getAllLinkAddresses().iterator();
        if (r3.hasNext() == true) goto L8;
        return null;
    L8:
        StringBuilder r0 = new StringBuilder();
    L10:
        if (r3.hasNext() == false) goto L15;
        r0.append(((LinkAddress) r3.next()).getAddress().getHostAddress());
        if (r3.hasNext() == false) goto L10;
        r0.append("\n");
        goto L10
    L15:
        return r0.toString();
    }
}
