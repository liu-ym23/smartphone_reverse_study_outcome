package com.android.settings.datausage;

import com.android.settings.applications.AppStateBaseBridge;
import com.android.settingslib.applications.ApplicationsState;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateDataUsageBridge extends AppStateBaseBridge {
    private static final String TAG = "AppStateDataUsageBridge";
    private final DataSaverBackend mDataSaverBackend;

    public static class DataUsageState {
        public boolean isDataSaverAllowlisted;
        public boolean isDataSaverDenylisted;

        public DataUsageState(boolean r1, boolean r2) {
            this.isDataSaverAllowlisted = r1;
            this.isDataSaverDenylisted = r2;
        }
    }

    public AppStateDataUsageBridge(ApplicationsState r1, AppStateBaseBridge.Callback r2, DataSaverBackend r3) {
        super(r1, r2);
        this.mDataSaverBackend = r3;
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        ArrayList<ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps();
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        ApplicationsState.AppEntry r3 = r0.get(r2);
        r3.extraInfo = new DataUsageState(this.mDataSaverBackend.isAllowlisted(r3.info.uid), this.mDataSaverBackend.isDenylisted(r3.info.uid));
        r2 = r2 + 1;
        goto L3
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(ApplicationsState.AppEntry r2, String r3, int r4) {
        r2.extraInfo = new DataUsageState(this.mDataSaverBackend.isAllowlisted(r4), this.mDataSaverBackend.isDenylisted(r4));
    }
}
