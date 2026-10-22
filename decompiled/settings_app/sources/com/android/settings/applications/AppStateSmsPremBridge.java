package com.android.settings.applications;

import android.content.Context;
import android.telephony.SmsManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateSmsPremBridge extends AppStateBaseBridge {
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_APP_PREMIUM_SMS = null;
    private final Context mContext;
    private final SmsManager mSmsManager;

    public static class SmsState {
        public int smsState;

        public SmsState() {
        }

        public boolean isGranted() {
            if (this.smsState != 3) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public AppStateSmsPremBridge(Context r1, com.android.settingslib.applications.ApplicationsState r2, AppStateBaseBridge.Callback r3) {
        super(r2, r3);
        this.mContext = r1;
        this.mSmsManager = SmsManager.getDefault();
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps();
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        com.android.settingslib.applications.ApplicationsState.AppEntry r3 = r0.get(r2);
        updateExtraInfo(r3, r3.info.packageName, r3.info.uid);
        r2 = r2 + 1;
        goto L3
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = getState(r2);
    }

    public SmsState getState(String r2) {
        SmsState r0 = new SmsState();
        r0.smsState = getSmsState(r2);
        return r0;
    }

    private int getSmsState(String r1) {
        return this.mSmsManager.getPremiumSmsConsent(r1);
    }

    public void setSmsState(String r1, int r2) {
        this.mSmsManager.setPremiumSmsConsent(r1, r2);
    }

    static {
        FILTER_APP_PREMIUM_SMS = new AnonymousClass1();
    }
}
