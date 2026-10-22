package com.android.settings.applications;

import com.android.settings.fuelgauge.PowerWhitelistBackend;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AppStatePowerBridge extends AppStateBaseBridge {
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_POWER_WHITELISTED = null;
    private final PowerWhitelistBackend mBackend;

    public static class HighPowerState {
        public boolean isHighPower;
        public boolean isSystemHighPower;

        public HighPowerState() {
        }
    }

    public AppStatePowerBridge(com.android.settingslib.applications.ApplicationsState r1, AppStateBaseBridge.Callback r2) {
        super(r1, r2);
        this.mBackend = PowerWhitelistBackend.getInstance();
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps();
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        com.android.settingslib.applications.ApplicationsState.AppEntry r3 = r0.get(r2);
        if (this.mBackend.isWhitelisted(r3.info.packageName) == false) goto L7;
        Boolean r4 = Boolean.TRUE;
    L8:
        r3.extraInfo = r4;
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = Boolean.FALSE;
        goto L8
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        if (this.mBackend.isWhitelisted(r2) == false) goto L5;
        Boolean r0 = Boolean.TRUE;
    L6:
        r1.extraInfo = r0;
        return;
    L5:
        r0 = Boolean.FALSE;
        goto L6
    }

    static {
        FILTER_POWER_WHITELISTED = new com.android.settingslib.applications.ApplicationsState.CompoundFilter(com.android.settingslib.applications.ApplicationsState.FILTER_WITHOUT_DISABLED_UNTIL_USED, new AnonymousClass1());
    }
}
