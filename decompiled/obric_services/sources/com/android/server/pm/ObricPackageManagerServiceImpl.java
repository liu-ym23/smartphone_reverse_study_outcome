package com.android.server.pm;

import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.content.pm.IObricPackageManager;
import android.content.pm.IPackageDeleteObserver2;
import android.content.pm.VersionedPackage;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Environment;
import android.os.UserHandle;
import android.os.storage.StorageManager;
import android.util.Slog;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.AndroidPackage;
import com.obric.app.ObricAssistUtils;
import com.obric.utils.ObricPermissionCheckHelper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ObricPackageManagerServiceImpl implements IObricPackageManagerService {
    private static final String TAG = "ObricPackageManagerService";
    private final PackageManagerService mBase;
    private IObricPackageManager mIObricPackageManager;
    private ObricRemovableSystemAppHelper mObricRemovableSystemAppHelper;
    private Set<String> mPendingClearDataPkgs;

    public static /* synthetic */ void $r8$lambda$0Jsw2e8QwG1qLN89WPZDCEN0piw(ObricPackageManagerServiceImpl r0) {
        r0.lambda$doClearAppData$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBase, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageManagerService m28$$Nest$fgetmBase(ObricPackageManagerServiceImpl r0) {
        return r0.mBase;
    }

    /* JADX INFO: renamed from: -$$Nest$mdoClearAppData, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m29$$Nest$mdoClearAppData(ObricPackageManagerServiceImpl r0) {
        r0.doClearAppData();
    }

    public ObricPackageManagerServiceImpl(PackageManagerService base) {
        this.mIObricPackageManager = new AnonymousClass1(this);
        this.mBase = base;
    }

    public void systemReady() {
        clearPendingAppDataIfPossible();
        clearObricAssistPermissionIfFirstBoot();
    }

    public void beforeScan() {
        this.mObricRemovableSystemAppHelper = new ObricRemovableSystemAppHelper(this.mBase);
    }

    public boolean isRemovableSysApp(String pkgName) {
        if (this.mObricRemovableSystemAppHelper != null) goto L7;
        return false;
    L7:
        return ObricRemovableSystemAppHelper.isRemovableSysApp(pkgName);
    }

    public boolean recoveryRemovableSystemApp(String scanPath, String packageName) {
        int uid = Binder.getCallingUid();
        int userId = UserHandle.getUserId(uid);
        boolean r8 = false;
        if (packageName != null) goto L6;
        return false;
    L6:
        if (ObricPermissionCheckHelper.isSystemApp(this.mBase.mContext, uid) == true) goto L10;
        Slog.e(TAG, "fail to recovery non-system app , pkg = " + packageName + " uid = " + uid);
        return false;
    L10:
        if (isRemovableSysApp(packageName) == false) goto L26;
        Slog.d(TAG, "recovery removable system app, pkg = " + packageName);
        long token = Binder.clearCallingIdentity();
        int res = ((Integer) this.mBase.installExistingPackageAsUser(packageName, userId, 4194304, 0, null, null).first).intValue();     // Catch: Throwable -> L18 Exception -> L20
        clearObricAssistPermission(packageName, userId);     // Catch: Throwable -> L18 Exception -> L20
        Slog.d(TAG, "recovery removable system app, pkg = " + packageName + " res = " + res);     // Catch: Throwable -> L18 Exception -> L20
        goto L21
    L14:
        if (res != 1) goto L16;
        r8 = true;
    L16:
        Binder.restoreCallingIdentity(token);
        return r8;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L21:
        Slog.d(TAG, "recovery removable system app error");     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(token);
        return false;
    L26:
        return false;
    }

    public IObricPackageManager getIObricExt() {
        return this.mIObricPackageManager;
    }

    public int deletePackageVersionedBefore(VersionedPackage versionedPackage, int deleteFlags, int userId) {
        if (isRemovableSysApp(versionedPackage.getPackageName()) == false) goto L13;
        clearObricAssistPermission(versionedPackage.getPackageName(), userId);
        PackageManagerTracedLock r1 = this.mBase.mLock;
        monitor-enter(r1);
        PackageSetting ps = this.mBase.mSettings.getPackageLPr(versionedPackage.getPackageName());     // Catch: Throwable -> L10
        boolean isUpdatedRemovableSysApp = ps.getPkgState().isUpdatedSystemApp();     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (isUpdatedRemovableSysApp == true) goto L16;
        return deleteFlags | 4;
    L16:
        return deleteFlags;
    L10:
        th = move-exception;
        throw th;
    L13:
        return deleteFlags;
    }

    public void deletePackageVersionedAfter(VersionedPackage versionedPackage, int deleteFlags, DeletePackageHelper deletePackageHelper, IPackageDeleteObserver2 observer, int userId, int callingUid) {
        if (isRemovableSysApp(versionedPackage.getPackageName()) == true) goto L5;
    L7:
        VersionedPackage versionedPackage2 = versionedPackage;
    L9:
        if (ObricAssistUtils.getAssistantPkgName().equals(versionedPackage2.getPackageName()) == false) goto L17;
        AudioManager audioManager = (AudioManager) this.mBase.mContext.getSystemService(AudioManager.class);     // Catch: Exception -> L12
        audioManager.setParameters("enable_backtrace=false");     // Catch: Exception -> L12
        Slog.i(TAG, "setParameters enable_backtrace=false");     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "setParameters error ", e);
        e.printStackTrace();
        return;
    L17:
        return;
    L5:
        if ((deleteFlags & 4) != 0) goto L7;
        versionedPackage2 = versionedPackage;
        deletePackageHelper.deletePackageVersionedInternal(versionedPackage2, observer, userId, deleteFlags | 4, callingUid, false);
        goto L9
    }

    public void deletePackageVersioned(VersionedPackage versionedPackage, int deleteFlags, DeletePackageHelper deletePackageHelper, IPackageDeleteObserver2 observer, int userId, int callingUid) {
        int deleteFlags2 = deletePackageVersionedBefore(versionedPackage, deleteFlags, userId);
        this.mBase.mDeletePackageHelper.deletePackageVersionedInternal(versionedPackage, observer, userId, deleteFlags2, callingUid, false);
        deletePackageVersionedAfter(versionedPackage, deleteFlags2, this.mBase.mDeletePackageHelper, observer, userId, callingUid);
    }

    public void setPendingClearAppData(String pkgName) {
        if (this.mPendingClearDataPkgs != null) goto L5;
        this.mPendingClearDataPkgs = new HashSet();
    L5:
        this.mPendingClearDataPkgs.add(pkgName);
    }

    private void doClearAppData() {
        this.mBase.mHandler.postDelayed(new ObricPackageManagerServiceImpl$$ExternalSyntheticLambda0(this), 100);
    }

    private /* synthetic */ void lambda$doClearAppData$0() {
        ActivityManagerInternal mAmi = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        if (mAmi != null) goto L5;
        return;
    L5:
        if (this.mPendingClearDataPkgs == null) goto L42;
        Iterator<String> r0 = this.mPendingClearDataPkgs.iterator();
    L8:
        if (r0.hasNext() == false) goto L25;
        String pkg = r0.next();
        AndroidPackage p = this.mBase.snapshotComputer().getPackage(pkg);
        if (p != null) goto L11;
        Slog.i(TAG, pkg + " uninstalled, destroy external data");
        PackageManagerTracedLock installLock = this.mBase.mInstallLock.acquireLock();
        this.mBase.mAppDataHelper.destroyExternalAppData(pkg, -1, 4);     // Catch: Throwable -> L17
        if (installLock == null) goto L8;
        installLock.close();
    L17:
        th = move-exception;
        if (installLock == null) goto L39;
        installLock.close();     // Catch: Throwable -> L22
        throw th;
    L22:
        th = move-exception;
        th.addSuppressed(th);
        throw th;
    L39:
        throw th;
    L11:
        Slog.i(TAG, "clear user data of " + pkg);
        mAmi.clearApplicationUserData(pkg, false, false, null, 0);
        goto L8
    L25:
        this.mPendingClearDataPkgs.clear();
        this.mPendingClearDataPkgs = null;
        return;
    }

    private void clearPendingAppDataIfPossible() {
        if (this.mPendingClearDataPkgs != null) goto L5;
        return;
    L5:
        if (this.mPendingClearDataPkgs.isEmpty() == false) goto L8;
        return;
    L8:
        if (Environment.getExternalStorageState().equals("mounted") == false) goto L10;
        Slog.d(TAG, "external storage had ready");
        doClearAppData();
        return;
    L10:
        final StorageManager storage = (StorageManager) this.mBase.mInjector.getSystemService(StorageManager.class);
        storage.registerListener(new AnonymousClass2(this, storage));
    }

    private void clearObricAssistPermissionIfFirstBoot() {
        if (this.mBase.isFirstBoot() == false) goto L12;
        Slog.i(TAG, "First boot: clear obric assist permssion");
        int[] r0 = this.mBase.mUserManager.getUserIds();
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L18;
        int userId = r0[r3];
        clearObricAssistPermission(ObricAssistUtils.getAssistantPkgName(), userId);     // Catch: Exception -> L9
    L11:
        r3 = r3 + 1;
    L9:
        e = move-exception;
        Slog.e(TAG, "First boot: failed to clear MANAGE_EXTERNAL_STORAGE, userId=" + userId, e);
        goto L11
    L18:
        return;
    }

    public void clearObricAssistPermission(String packageName, int userId) {
        if (ObricAssistUtils.getAssistantPkgName().equals(packageName) == false) goto L17;
        long identity = Binder.clearCallingIdentity();
        int uid = this.mBase.snapshotComputer().getPackageUid(packageName, 0, userId);     // Catch: Throwable -> L10 Exception -> L12
        if (uid < 0) goto L9;
        Slog.i(TAG, "Clear obric assist permssion, packageName = " + packageName + ", userId = " + userId);     // Catch: Throwable -> L10 Exception -> L12
        ((AppOpsManager) this.mBase.mInjector.getSystemService(AppOpsManager.class)).setUidMode(92, uid, 2);     // Catch: Throwable -> L10 Exception -> L12
        Slog.i(TAG, "Clear MANAGE_EXTERNAL_STORAGE for " + packageName);     // Catch: Throwable -> L10 Exception -> L12
    L9:
        Binder.restoreCallingIdentity(identity);
        return;
    L12:
        e = move-exception;
        Slog.e(TAG, "Clear obric assist permission error", e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void destroyExternalAppData(String packageName, int userId, int flags, Installer mInstaller) {
        int[] r1 = this.mBase.resolveUserIds(userId);
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L10;
        int realUserId = r1[r3];
        String packageName2 = packageName;
        int flags2 = flags;
        Installer mInstaller2 = mInstaller;
        mInstaller2.destroyAppData(null, packageName2, realUserId, flags2, 0);     // Catch: Installer.InstallerException -> L7
    L9:
        r3 = r3 + 1;
        mInstaller = mInstaller2;
        packageName = packageName2;
        flags = flags2;
    L7:
        e = move-exception;
        Slog.w(TAG, String.valueOf(e));
        goto L9
    }
}
