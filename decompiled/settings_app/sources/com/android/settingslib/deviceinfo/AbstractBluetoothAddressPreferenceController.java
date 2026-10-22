package com.android.settingslib.deviceinfo;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.settingslib.utils.ThreadUtils;
import com.google.common.util.concurrent.Futures;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBluetoothAddressPreferenceController extends AbstractConnectivityPreferenceController {
    private static final String[] CONNECTIVITY_INTENTS = null;
    static final String KEY_BT_ADDRESS = "bt_address";
    private Preference mBtAddress;

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public String getPreferenceKey() {
        return KEY_BT_ADDRESS;
    }

    static /* synthetic */ Preference access$000(AbstractBluetoothAddressPreferenceController r0) {
        return r0.mBtAddress;
    }

    static {
        CONNECTIVITY_INTENTS = new String[]{"android.bluetooth.adapter.action.STATE_CHANGED"};
    }

    public AbstractBluetoothAddressPreferenceController(Context r1, Lifecycle r2) {
        super(r1, r2);
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public boolean isAvailable() {
        if (BluetoothAdapter.getDefaultAdapter() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.android.settingslib.core.AbstractPreferenceController
    public void displayPreference(PreferenceScreen r2) {
        super.displayPreference(r2);
        this.mBtAddress = r2.findPreference(KEY_BT_ADDRESS);
        updateConnectivity();
    }

    @Override // com.android.settingslib.deviceinfo.AbstractConnectivityPreferenceController
    protected String[] getConnectivityIntents() {
        return CONNECTIVITY_INTENTS;
    }

    @Override // com.android.settingslib.deviceinfo.AbstractConnectivityPreferenceController
    protected void updateConnectivity() {
        final BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mBtAddress == null) goto L9;
        Futures.addCallback(ThreadUtils.getBackgroundExecutor().submit(new AbstractBluetoothAddressPreferenceController$$ExternalSyntheticLambda0(r0)), new AnonymousClass1(this), this.mContext.getMainExecutor());
        return;
    }

    static /* synthetic */ String lambda$updateConnectivity$0(BluetoothAdapter r1) throws Exception {
        if (r1.isEnabled() == true) goto L7;
        return null;
    L7:
        return r1.getAddress();
    }
}
