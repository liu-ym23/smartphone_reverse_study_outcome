package com.android.settings.nfc;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.nfc.NfcAdapter;
import android.os.UserHandle;
import android.os.UserManager;
import android.widget.CompoundButton;
import com.android.settings.applications.AppStateBaseBridge;
import com.android.settings.applications.AppStateBaseSwitchInterface;
import com.android.settingslib.applications.ApplicationsState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AppStateNfcTagAppsBridge extends AppStateBaseBridge implements AppStateBaseSwitchInterface {
    public static final ApplicationsState.AppFilter FILTER_APPS_NFC_TAG = null;
    private static final String TAG = "AppStateNfcTagAppsBridge";
    private static Map<Integer, Map<String, Boolean>> sList;
    private AppOpsManager mAppOpsManager;
    private final Context mContext;
    private final NfcAdapter mNfcAdapter;

    public static class NfcTagAppState {
        private boolean mIsAllowed;
        private boolean mIsExisted;

        public NfcTagAppState(boolean r1, boolean r2) {
            this.mIsExisted = r1;
            this.mIsAllowed = r2;
        }

        public boolean isExisted() {
            return this.mIsExisted;
        }

        public boolean isAllowed() {
            return this.mIsAllowed;
        }
    }

    static {
        sList = new HashMap();
        FILTER_APPS_NFC_TAG = new AnonymousClass1();
    }

    public AppStateNfcTagAppsBridge(Context r4, ApplicationsState r5, AppStateBaseBridge.Callback r6) {
        super(r5, r6);
        this.mContext = r4;
        NfcAdapter r7 = NfcAdapter.getDefaultAdapter(r4);
        this.mNfcAdapter = r7;
        if (r7 != null) goto L5;
    L10:
        this.mAppOpsManager = (AppOpsManager) r4.getSystemService(AppOpsManager.class);
        return;
    L5:
        if (r7.isTagIntentAppPreferenceSupported() == false) goto L10;
        Iterator r8 = ((UserManager) r4.createContextAsUser(UserHandle.of(ActivityManager.getCurrentUser()), 0).getSystemService(UserManager.class)).getEnabledProfiles().iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        int r9 = ((UserHandle) r8.next()).getIdentifier();
        sList.put(Integer.valueOf(r9), this.mNfcAdapter.getTagIntentAppPreferenceForUser(r9));
        goto L8
    }

    public boolean updateApplist(int r2, String r3, boolean r4) {
        if (this.mNfcAdapter.setTagIntentAppPreferenceForUser(r2, r3, r4) != 0) goto L6;
        sList.put(Integer.valueOf(r2), this.mNfcAdapter.getTagIntentAppPreferenceForUser(r2));
        return true;
    L6:
        return false;
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        ArrayList<ApplicationsState.AppEntry> r0 = this.mAppSession.getAllApps();
        int r1 = 0;
    L4:
        if (r1 >= r0.size()) goto L6;
        ApplicationsState.AppEntry r2 = r0.get(r1);
        updateExtraInfo(r2, r2.info.packageName, r2.info.uid);
        r1 = r1 + 1;
        goto L4
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void updateExtraInfo(ApplicationsState.AppEntry r2, String r3, int r4) {
        int r1 = UserHandle.getUserId(r4);
        Map<String, Boolean> r5 = sList.getOrDefault(Integer.valueOf(r1), new HashMap());
        if (r5.containsKey(r3) == false) goto L5;
        r2.extraInfo = new NfcTagAppState(true, r5.get(r3).booleanValue());
        return;
    L5:
        r2.extraInfo = new NfcTagAppState(false, false);
    }

    private void setNewState(ApplicationsState.AppEntry r2, boolean r3) {
        updateApplist(UserHandle.getUserId(r2.info.uid), r2.info.packageName, r3);
    }

    private NfcTagAppState createPermissionState(ApplicationsState.AppEntry r3) {
        int r2 = UserHandle.getUserId(r3.info.uid);
        Map<String, Boolean> r4 = sList.getOrDefault(Integer.valueOf(r2), new HashMap());
        String r5 = r3.info.packageName;
        if (r4.containsKey(r5) == false) goto L6;
        return new NfcTagAppState(true, r4.get(r5).booleanValue());
    L6:
        return new NfcTagAppState(false, false);
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final ApplicationsState.AppEntry r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new AppStateNfcTagAppsBridge$$ExternalSyntheticLambda0(this, r2);
    }

    /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-nfc-AppStateNfcTagAppsBridge, reason: not valid java name */
    /* synthetic */ void m516x72d56e33(ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        NfcTagAppState r4 = createPermissionState(r1);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r3 == r4.isAllowed()) goto L9;
        setNewState(r1, Boolean.valueOf(r3).booleanValue());
        return;
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean enableSwitch(ApplicationsState.AppEntry r1) {
        NfcTagAppState r0 = createPermissionState(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isExisted();
    }

    @Override // com.android.settings.applications.AppStateBaseSwitchInterface
    public final boolean checkSwitch(ApplicationsState.AppEntry r1) {
        NfcTagAppState r0 = createPermissionState(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isAllowed();
    }
}
