package com.android.settings.applications;

import android.app.AppGlobals;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.PackageInfo;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.ArrayMap;
import android.util.SparseArray;
import com.android.settingslib.applications.RecentAppOpsAccess;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AppStateAppOpsBridge extends AppStateBaseBridge {
    private static final String TAG = "AppStateAppOpsBridge";
    private final AppOpsManager mAppOpsManager;
    private final int[] mAppOpsOpCodes;
    private final Context mContext;
    private final IPackageManager mIPackageManager;
    private final String[] mPermissions;
    private final List<UserHandle> mProfiles;
    private final UserManager mUserManager;

    public static class PermissionState {
        public int appOpMode;
        public PackageInfo packageInfo;
        public final String packageName;
        public boolean permissionDeclared;
        public boolean staticPermissionGranted;
        public final UserHandle userHandle;

        public PermissionState(String r1, UserHandle r2) {
            this.packageName = r1;
            this.appOpMode = 3;
            this.userHandle = r2;
        }

        public boolean isPermissible() {
            int r0 = this.appOpMode;
            if (r0 == 3) goto L5;
            if (r0 != 0) goto L8;
            return true;
        L8:
            return false;
        L5:
            return this.staticPermissionGranted;
        }
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected abstract void updateExtraInfo(com.android.settingslib.applications.ApplicationsState.AppEntry r1, String r2, int r3);

    public AppStateAppOpsBridge(Context r8, com.android.settingslib.applications.ApplicationsState r9, AppStateBaseBridge.Callback r10, int r11, String[] r12) {
        this(r8, r9, r10, r11, r12, AppGlobals.getPackageManager());
    }

    AppStateAppOpsBridge(Context r8, com.android.settingslib.applications.ApplicationsState r9, AppStateBaseBridge.Callback r10, int[] r11, String[] r12) {
        this(r8, r9, r10, r11, r12, AppGlobals.getPackageManager());
    }

    AppStateAppOpsBridge(Context r9, com.android.settingslib.applications.ApplicationsState r10, AppStateBaseBridge.Callback r11, int r12, String[] r13, IPackageManager r14) {
        this(r9, r10, r11, new int[]{r12}, r13, r14);
    }

    AppStateAppOpsBridge(Context r1, com.android.settingslib.applications.ApplicationsState r2, AppStateBaseBridge.Callback r3, int[] r4, String[] r5, IPackageManager r6) {
        super(r2, r3);
        this.mContext = r1;
        this.mIPackageManager = r6;
        UserManager r7 = UserManager.get(r1);
        this.mUserManager = r7;
        this.mProfiles = r7.getUserProfiles();
        this.mAppOpsManager = (AppOpsManager) r1.getSystemService("appops");
        this.mAppOpsOpCodes = r4;
        this.mPermissions = r5;
    }

    private boolean isThisUserAProfileOfCurrentUser(int r5) {
        int r0 = this.mProfiles.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (this.mProfiles.get(r2).getIdentifier() == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean doesAnyPermissionMatch(String r4, String[] r5) {
        int r3 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L9;
        if (r4.equals(r5[r1]) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public PermissionState getPermissionInfo(String r8, int r9) {
        PermissionState r0 = new PermissionState(r8, new UserHandle(UserHandle.getUserId(r9)));
        r0.packageInfo = this.mIPackageManager.getPackageInfo(r8, 4198400, r0.userHandle.getIdentifier());     // Catch: RemoteException -> L24
        if (r0.packageInfo == null) goto L16;
        String[] r1 = r0.packageInfo.requestedPermissions;     // Catch: RemoteException -> L24
        int[] r3 = r0.packageInfo.requestedPermissionsFlags;     // Catch: RemoteException -> L24
        if (r1 == null) goto L16;
        int r4 = 0;
    L9:
        if (r4 >= r1.length) goto L16;
        if (doesAnyPermissionMatch(r1[r4], this.mPermissions) == false) goto L15;
        r0.permissionDeclared = true;     // Catch: RemoteException -> L24
        if ((r3[r4] & 2) == 0) goto L15;
        r0.staticPermissionGranted = true;     // Catch: RemoteException -> L24
    L15:
        r4 = r4 + 1;     // Catch: RemoteException -> L24
    L16:
        List r7 = this.mAppOpsManager.getOpsForPackage(r9, r8, this.mAppOpsOpCodes);     // Catch: RemoteException -> L24
        if (r7 != null) goto L19;
    L26:
        return r0;
    L19:
        if (r7.size() <= 0) goto L26;
        if (((AppOpsManager.PackageOps) r7.get(0)).getOps().size() <= 0) goto L26;
        r0.appOpMode = ((AppOpsManager.OpEntry) ((AppOpsManager.PackageOps) r7.get(0)).getOps().get(0)).getMode();     // Catch: RemoteException -> L24
    L24:
        e = move-exception;
        OLog.w(TAG, "PackageManager is dead. Can't get package info " + r8, e);
        goto L26
    }

    @Override // com.android.settings.applications.AppStateBaseBridge
    protected void loadAllExtraInfo() {
        SparseArray<ArrayMap<String, PermissionState>> r0 = getEntries();
        loadPermissionsStates(r0);
        loadAppOpsStates(r0);
        ArrayList<com.android.settingslib.applications.ApplicationsState.AppEntry> r6 = this.mAppSession.getAllApps();
        int r1 = r6.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        com.android.settingslib.applications.ApplicationsState.AppEntry r3 = r6.get(r2);
        int r4 = UserHandle.getUserId(r3.info.uid);
        PermissionState r5 = null;
        if (r0 == null) goto L10;
        ArrayMap<String, PermissionState> r7 = r0.get(r4);
        if (r7 == null) goto L9;
        r5 = r7.get(r3.info.packageName);
    L9:
        r3.extraInfo = r5;
    L11:
        r2 = r2 + 1;
        goto L3
    L10:
        r3.extraInfo = null;
        goto L11
    }

    private SparseArray<ArrayMap<String, PermissionState>> getEntries() {
        SparseArray<ArrayMap<String, PermissionState>> r2 = new SparseArray();     // Catch: RemoteException -> L26
        Iterator<UserHandle> r3 = this.mProfiles.iterator();     // Catch: RemoteException -> L26
    L5:
        if (r3.hasNext() == false) goto L22;
        UserHandle r4 = r3.next();     // Catch: RemoteException -> L26
        int r5 = r4.getIdentifier();     // Catch: RemoteException -> L26
        HashSet r6 = new HashSet();     // Catch: RemoteException -> L26
        String[] r7 = this.mPermissions;     // Catch: RemoteException -> L26
        int r8 = r7.length;     // Catch: RemoteException -> L26
        int r9 = 0;
    L7:
        if (r9 >= r8) goto L13;
        String[] r10 = this.mIPackageManager.getAppOpPermissionPackages(r7[r9], r5);     // Catch: RemoteException -> L26
        if (r10 == null) goto L11;
        r6.addAll(Arrays.asList(r10));     // Catch: RemoteException -> L26
    L11:
        r9 = r9 + 1;     // Catch: RemoteException -> L26
        goto L7
    L13:
        if (r6.isEmpty() == true) goto L5;
        ArrayMap<String, PermissionState> r11 = new ArrayMap();     // Catch: RemoteException -> L26
        r2.put(r5, r11);     // Catch: RemoteException -> L26
        Iterator r12 = r6.iterator();     // Catch: RemoteException -> L26
    L17:
        if (r12.hasNext() == false) goto L5;
        String r13 = (String) r12.next();     // Catch: RemoteException -> L26
        boolean r14 = this.mIPackageManager.isPackageAvailable(r13, r5);     // Catch: RemoteException -> L26
        if (shouldIgnorePackage(r13) == true) goto L17;
        if (r14 == false) goto L17;
        r11.put(r13, new PermissionState(r13, r4));     // Catch: RemoteException -> L26
        goto L17
    L22:
        if (r2.size() != 0) goto L25;
        return null;
    L25:
        return r2;
    L26:
        e = move-exception;
        OLog.w(TAG, "PackageManager is dead. Can't get list of packages requesting " + this.mPermissions[0], e);
        return null;
    }

    private void loadPermissionsStates(SparseArray<ArrayMap<String, PermissionState>> r8) {
        if (r8 != null) goto L22;
        return;
    L22:
        Iterator<UserHandle> r0 = this.mProfiles.iterator();     // Catch: RemoteException -> L19
    L5:
        if (r0.hasNext() == false) goto L33;
        int r1 = r0.next().getIdentifier();     // Catch: RemoteException -> L19
        ArrayMap<String, PermissionState> r2 = r8.get(r1);     // Catch: RemoteException -> L19
        if (r2 == null) goto L5;
        List r3 = this.mIPackageManager.getPackagesHoldingPermissions(this.mPermissions, 0, r1).getList();     // Catch: RemoteException -> L19
        int r4 = 0;
        if (r3 == null) goto L13;
        int r5 = r3.size();     // Catch: RemoteException -> L19
    L14:
        if (r4 >= r5) goto L5;
        PackageInfo r6 = (PackageInfo) r3.get(r4);     // Catch: RemoteException -> L19
        PermissionState r7 = r2.get(r6.packageName);     // Catch: RemoteException -> L19
        if (r7 == null) goto L18;
        r7.packageInfo = r6;     // Catch: RemoteException -> L19
        r7.staticPermissionGranted = true;     // Catch: RemoteException -> L19
    L18:
        r4 = r4 + 1;
        goto L14
    L13:
        r5 = 0;
        goto L14
    L33:
        return;
    L19:
        e = move-exception;
        OLog.w(TAG, "PackageManager is dead. Can't get list of packages granted " + Arrays.toString(this.mPermissions), e);
    }

    private void loadAppOpsStates(SparseArray<ArrayMap<String, PermissionState>> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        List r0 = this.mAppOpsManager.getPackagesForOps(this.mAppOpsOpCodes);
        if (r0 == null) goto L7;
        int r2 = r0.size();
    L8:
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L24;
        AppOpsManager.PackageOps r4 = (AppOpsManager.PackageOps) r0.get(r3);
        int r5 = UserHandle.getUserId(r4.getUid());
        if (isThisUserAProfileOfCurrentUser(r5) == false) goto L23;
        ArrayMap<String, PermissionState> r6 = r10.get(r5);
        if (r6 == null) goto L23;
        PermissionState r7 = r6.get(r4.getPackageName());
        if (r7 != null) goto L20;
        OLog.w(TAG, "AppOp permission exists for package " + r4.getPackageName() + " of user " + r5 + " but package doesn't exist or did not request " + Arrays.toString(this.mPermissions) + " access");
        goto L23
    L20:
        if (r4.getOps().size() >= 1) goto L22;
        OLog.w(TAG, "No AppOps permission exists for package " + r4.getPackageName());
        goto L23
    L22:
        r7.appOpMode = ((AppOpsManager.OpEntry) r4.getOps().get(0)).getMode();
    L23:
        r3 = r3 + 1;
        goto L9
    L24:
        return;
    L7:
        r2 = 0;
        goto L8
    }

    private boolean shouldIgnorePackage(String r2) {
        if (r2.equals(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME) == false) goto L5;
    L8:
        return true;
    L5:
        if (r2.equals(this.mContext.getPackageName()) == true) goto L8;
        return false;
    }

    public int getNumPackagesDeclaredPermission() {
        SparseArray<ArrayMap<String, PermissionState>> r0 = getEntries();
        if (r0 != null) goto L5;
        return 0;
    L5:
        ArrayMap<String, PermissionState> r2 = r0.get(this.mUserManager.getUserHandle());
        if (r2 != null) goto L9;
        return 0;
    L9:
        return r2.size();
    }

    public int getNumPackagesAllowedByAppOps() {
        SparseArray<ArrayMap<String, PermissionState>> r0 = getEntries();
        int r1 = 0;
        if (r0 != null) goto L5;
        return 0;
    L5:
        loadPermissionsStates(r0);
        loadAppOpsStates(r0);
        ArrayMap<String, PermissionState> r2 = r0.get(this.mUserManager.getUserHandle());
        if (r2 != null) goto L8;
        return 0;
    L8:
        Iterator<PermissionState> r3 = r2.values().iterator();
    L10:
        if (r3.hasNext() == false) goto L14;
        if (r3.next().isPermissible() == false) goto L10;
        r1 = r1 + 1;
        goto L10
    L14:
        return r1;
    }
}
