package com.android.settings.applications;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import com.android.settings.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateLocaleBridge extends AppStateBaseBridge {
    public static final com.android.settingslib.applications.ApplicationsState.AppFilter FILTER_APPS_LOCALE = null;
    private static final String TAG = "AppStateLocaleBridge";
    private final Context mContext;
    private final Map<Integer, AppInfoByProfiles> mUserIdToAppInfoByProfiles;

    private static class AppInfoByProfiles {
        public final Context mContextAsUser;
        public final List<ResolveInfo> mListInfos;

        /* synthetic */ AppInfoByProfiles(Context r1, int r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private AppInfoByProfiles(Context r2, int r3) {
            Context r4 = r2.createContextAsUser(UserHandle.of(r3), 0);
            this.mContextAsUser = r4;
            this.mListInfos = r4.getPackageManager().queryIntentActivities(AppLocaleUtil.LAUNCHER_ENTRY_INTENT, 128);
        }
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    public AppStateLocaleBridge(Context r1, com.android.settingslib.applications.ApplicationsState r2, AppStateBaseBridge.Callback r3, UserManager r4) {
        super(r2, r3);
        this.mUserIdToAppInfoByProfiles = new ArrayMap();
        this.mContext = r1;
        collectLocaleBridgeInfo(r4);
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3) {
        AppInfoByProfiles r0 = getAppInfo(UserHandle.getUserId(r3));
        if (AppLocaleUtil.canDisplayLocaleUi(r0.mContextAsUser, r1.info, r0.mListInfos) == false) goto L5;
        Boolean r4 = Boolean.TRUE;
    L6:
        r1.extraInfo = r4;
        return;
    L5:
        r4 = Boolean.FALSE;
        goto L6
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps();
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L10;
        com.android.settingslib.applications.ApplicationsState.AppEntry r2 = r0.get(r1);
        AppInfoByProfiles r3 = getAppInfo(UserHandle.getUserId(r2.info.uid));
        if (AppLocaleUtil.canDisplayLocaleUi(r3.mContextAsUser, r2.info, r3.mListInfos) == false) goto L8;
        Boolean r4 = Boolean.TRUE;
    L9:
        r2.extraInfo = r4;
        r1 = r1 + 1;
        goto L4
    L8:
        r4 = Boolean.FALSE;
        goto L9
    }

    static {
        FILTER_APPS_LOCALE = new AnonymousClass1();
    }

    private void collectLocaleBridgeInfo(UserManager r7) {
        ArrayList r0 = new ArrayList();
        r0.add(Integer.valueOf(this.mContext.getUserId()));
        int r8 = Utils.getManagedProfileId(r7, this.mContext.getUserId());
        if (r8 == (-10000)) goto L5;
        r0.add(Integer.valueOf(r8));
    L5:
        Iterator r9 = r0.iterator();
    L7:
        if (r9.hasNext() == false) goto L11;
        int r1 = ((Integer) r9.next()).intValue();
        if (this.mUserIdToAppInfoByProfiles.containsKey(Integer.valueOf(r1)) == true) goto L7;
        this.mUserIdToAppInfoByProfiles.put(Integer.valueOf(r1), new AppInfoByProfiles(this.mContext, r1, null));
        goto L7
    }

    private AppInfoByProfiles getAppInfo(int r4) {
        if (this.mUserIdToAppInfoByProfiles.containsKey(Integer.valueOf(r4)) == true) goto L7;
        AppInfoByProfiles r0 = new AppInfoByProfiles(this.mContext, r4, null);
        this.mUserIdToAppInfoByProfiles.put(Integer.valueOf(r4), r0);
        return r0;
    L7:
        return this.mUserIdToAppInfoByProfiles.get(Integer.valueOf(r4));
    }
}
