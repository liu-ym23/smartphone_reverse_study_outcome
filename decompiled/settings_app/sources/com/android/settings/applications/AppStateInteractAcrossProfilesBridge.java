package com.android.settings.applications;

import android.app.AppOpsManager;
import android.content.Context;
import android.widget.CompoundButton;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateInteractAcrossProfilesBridge extends AppStateBaseBridge implements AppStateBaseSwitchInterface {
    private static final String APP_OP_STR = "android:interact_across_profiles";
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_INTERACT_ACROSS_PROFILES = null;
    private final AppOpsManager mAppOpsManager;
    private final Context mContext;

    public static class InteractAcrossProfilesState {
        public boolean canInteract;

        public InteractAcrossProfilesState(boolean r1) {
            this.canInteract = r1;
        }
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public boolean enableSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        return true;
    }

    public AppStateInteractAcrossProfilesBridge(Context r1, com.android.settingslib.applications.ApplicationsState r2, AppStateBaseBridge.Callback r3) {
        super(r2, r3);
        this.mContext = r1;
        this.mAppOpsManager = (AppOpsManager) r1.getSystemService(AppOpsManager.class);
    }

    static {
        FILTER_INTERACT_ACROSS_PROFILES = new AnonymousClass1();
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        Iterator<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        com.android.settingslib.applications.ApplicationsState.AppEntry r1 = r0.next();
        updateExtraInfo(r1, r1.info.packageName, r1.info.uid);
        goto L4
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        r1.extraInfo = getInteractAcrossProfilesState(r2, r3);
    }

    public InteractAcrossProfilesState getInteractAcrossProfilesState(String r2, int r3) {
        if (this.mAppOpsManager.checkOpNoThrow(APP_OP_STR, r3, r2) != 0) goto L5;
        boolean r1 = true;
    L7:
        return new InteractAcrossProfilesState(r1);
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final com.android.settingslib.applications.ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AppStateInteractAcrossProfilesBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-applications-AppStateInteractAcrossProfilesBridge, reason: not valid java name */
    /* synthetic */ void m277xc296928b(com.android.settingslib.applications.ApplicationsState.AppEntry r4, CompoundButton r5, boolean r6) {
        AppOpsManager r7 = this.mAppOpsManager;
        int r0 = r4.info.uid;
        String r1 = r4.info.packageName;
        if (r6 == false) goto L5;
        int r8 = 0;
    L6:
        r7.setMode(APP_OP_STR, r0, r1, r8);
        updateExtraInfo(r4, r4.info.packageName, r4.info.uid);
        return;
    L5:
        r8 = 2;
        goto L6
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public boolean checkSwitch(com.android.settingslib.applications.ApplicationsState.AppEntry r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (r1.extraInfo != null) goto L7;
        return false;
    L7:
        return ((InteractAcrossProfilesState) r1.extraInfo).canInteract;
    }
}
