package com.bytedanceos.security.permission;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AppPermissionGroup implements Comparable<AppPermissionGroup> {
    private static final String KILL_REASON_APP_OP_CHANGE = "Permission related app op changed";
    private static final String PLATFORM_PACKAGE_NAME = "android";
    private final ActivityManager mActivityManager;
    private final AppOpsManager mAppOps;
    private final boolean mAppSupportsRuntimePermissions;
    private Permission mBackgroundPermission;
    private boolean mContainsEphemeralPermission;
    private boolean mContainsPreRuntimePermission;
    private final Context mContext;
    private final boolean mIsEphemeralApp;
    private int mModeAllow;
    private int mModeIgnore;
    private final String mName;
    private final NativePermission mNativePermission;
    private OpsManagerHelper mOpsManagerHelper;
    private PackageInfo mPackageInfo;
    private final PackageManager mPackageManager;
    private final ArrayMap<String, Permission> mPermissions;
    private final UserHandle mUserHandle;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(AppPermissionGroup another) {
        return compareTo2(another);
    }

    public static AppPermissionGroup create(Context context, PackageInfo packageInfo, NativePermission nativePermission, PackageItemInfo groupInfo, List<PermissionInfo> permissionInfos, PermissionInfo backgroundPermission, UserHandle userHandle) {
        AppPermissionGroup r9 = new AppPermissionGroup(context, packageInfo, nativePermission, groupInfo.name, userHandle);
        if ((groupInfo instanceof PermissionInfo) == false) goto L5;
        List<PermissionInfo> r0 = new ArrayList();
        r0.add((PermissionInfo) groupInfo);
    L6:
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r0.isEmpty() == true) goto L71;
        int r2 = packageInfo.requestedPermissions.length;
        AppOpsManager r3 = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        PackageManager r4 = context.getPackageManager();
        int r10 = 0;
    L11:
        if (r10 >= r2) goto L59;
        String r13 = packageInfo.requestedPermissions[r10];
        Iterator<PermissionInfo> r11 = r0.iterator();
    L14:
        if (r11.hasNext() == false) goto L18;
        PermissionInfo r12 = r11.next();
        if (r13.equals(r12.name) == false) goto L14;
    L19:
        if (backgroundPermission != null) goto L21;
    L23:
        PermissionInfo r14 = r12;
    L24:
        if (r14 == null) goto L58;
        if ((r14.protectionLevel & 15) != 1) goto L58;
        if (packageInfo.applicationInfo.targetSdkVersion > 22) goto L35;
        if (PLATFORM_PACKAGE_NAME.equals(groupInfo.packageName) == false) goto L58;
    L35:
        if ((packageInfo.requestedPermissionsFlags[r10] & 2) == 0) goto L37;
        boolean r15 = true;
    L39:
        if (PLATFORM_PACKAGE_NAME.equals(r14.packageName) == false) goto L41;
        String r5 = AppOpsManager.permissionToOp(r14.name);
    L42:
        if (r5 == null) goto L49;
        if (r3 == null) goto L49;
        if (r3.checkOpNoThrow(r5, packageInfo.applicationInfo.uid, packageInfo.packageName) != 0) goto L47;
        boolean r16 = true;
    L48:
        boolean r17 = r16;
    L50:
        if (r4 != null) goto L52;
        int r18 = 0;
    L53:
        Permission r19 = new Permission(r13, r15, r5, r17, r18, r14.protectionLevel);
        if (backgroundPermission == null) goto L57;
        if (r14 != backgroundPermission) goto L57;
        r9.setBackgroundPermission(r19);
    L57:
        r9.addPermission(r19);
        goto L58
    L52:
        r18 = r4.getPermissionFlags(r13, packageInfo.packageName, userHandle);
        goto L53
    L47:
        r16 = false;
    L49:
        r17 = false;
        goto L50
    L41:
        r5 = null;
        goto L42
    L37:
        r15 = false;
    L58:
        r10 = r10 + 1;
        goto L11
    L21:
        if (TextUtils.equals(backgroundPermission.name, r13) == false) goto L23;
        r14 = backgroundPermission;
        goto L24
    L18:
        r12 = null;
        goto L19
    L59:
        return r9;
    L71:
        return null;
    L5:
        r0 = permissionInfos;
        goto L6
    }

    private AppPermissionGroup(Context context, PackageInfo packageInfo, NativePermission nativePermission, String name, UserHandle userHandle) {
        this.mPermissions = new ArrayMap();
        this.mModeAllow = OpsManagerHelper.get_MODE_ALLOWED();
        this.mModeIgnore = OpsManagerHelper.get_MODE_IGNORED();
        this.mContext = context;
        this.mNativePermission = nativePermission;
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();
        this.mUserHandle = userHandle;
        this.mPackageManager = context.getPackageManager();
        this.mPackageInfo = packageInfo;
        if (packageInfo.applicationInfo.targetSdkVersion <= 22) goto L5;
        boolean r4 = true;
    L6:
        this.mAppSupportsRuntimePermissions = r4;
        this.mIsEphemeralApp = packageInfo.applicationInfo.isInstantApp();
        this.mAppOps = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mActivityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        this.mName = name;
        return;
    L5:
        r4 = false;
        goto L6
    }

    public AppPermissionGroup(Context context, NativePermission nativePermission, String name, UserHandle userHandle) {
        this.mPermissions = new ArrayMap();
        this.mModeAllow = OpsManagerHelper.get_MODE_ALLOWED();
        this.mModeIgnore = OpsManagerHelper.get_MODE_IGNORED();
        this.mContext = context;
        this.mNativePermission = nativePermission;
        this.mOpsManagerHelper = OpsManagerHelper.getInstance();
        this.mUserHandle = userHandle;
        PackageManager r3 = context.getPackageManager();
        this.mPackageManager = r3;
        boolean r5 = false;
        this.mPackageInfo = r3.getPackageInfo(context.getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L5
    L8:
        if (this.mPackageInfo.applicationInfo.targetSdkVersion <= 22) goto L10;
        r5 = true;
    L10:
        this.mAppSupportsRuntimePermissions = r5;
        this.mIsEphemeralApp = this.mPackageInfo.applicationInfo.isInstantApp();
        this.mAppOps = (AppOpsManager) context.getSystemService(AppOpsManager.class);
        this.mActivityManager = (ActivityManager) context.getSystemService(ActivityManager.class);
        this.mName = name;
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public PackageInfo getApp() {
        return this.mPackageInfo;
    }

    public String getName() {
        return this.mName;
    }

    public int getUserId() {
        return this.mUserHandle.getIdentifier();
    }

    public void setBackgroundPermission(Permission permission) {
        this.mBackgroundPermission = permission;
    }

    public Permission getBackgroundPermission() {
        return this.mBackgroundPermission;
    }

    public boolean hasBackgroundPermission() {
        if (this.mBackgroundPermission == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean areBackgroundPermissionsGranted() {
        if (this.mBackgroundPermission != null) goto L6;
        return false;
    L6:
        if (DangerousPermissionUtil.supportRuntimePermission(this.mPackageInfo) == false) goto L12;
        if (DangerousPermissionUtil.getDangerousPermissionMode(this.mAppOps, this.mPackageManager, this.mPackageInfo, this.mBackgroundPermission.getName()) == this.mModeAllow) goto L10;
        return false;
    L10:
        return true;
    L12:
        if (DangerousPermissionUtil.getDangerousPermissionMode(this.mAppOps, this.mPackageManager, this.mPackageInfo, this.mPermissions.keyAt(0)) == this.mModeAllow) goto L14;
        return false;
    L14:
        return true;
    }

    public boolean areRuntimePermissionsGranted() {
        int r0 = DangerousPermissionUtil.getDangerousPermissionMode(this.mAppOps, this.mPackageManager, this.mPackageInfo, new ArrayList(this.mPermissions.keySet()));
        if (DangerousPermissionUtil.supportRuntimePermission(this.mPackageInfo) == false) goto L10;
        if (r0 != this.mModeAllow) goto L8;
        return true;
    L8:
        return false;
    L10:
        if (r0 == this.mModeIgnore) goto L13;
        return true;
    L13:
        return false;
    }

    public boolean areSpecialPermissionsGranted() {
        return SpecailPermissionUtil.checkPermission(this.mAppOps, this.mPackageInfo.applicationInfo.uid, this.mPackageInfo.packageName);
    }

    public void grantBackgroundPermission() {
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(this.mContext, this.mPackageInfo) == false) goto L5;
        return;
    L5:
        Permission r0 = this.mBackgroundPermission;
        if (r0 != null) goto L8;
        return;
    L8:
        DangerousPermissionUtil.grantBackgroundPermission(this.mAppOps, this.mPackageManager, this.mPackageInfo, r0.getName());
        Iterator r1 = new ArrayList(this.mPermissions.keySet()).iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) r1.next();
        DangerousPermissionUtil.setOpsMode(this.mAppOps, this.mPackageInfo, r2, OpsManagerHelper.get_MODE_ALLOWED());
        goto L10
    }

    public void grantRuntimePermissions() {
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(this.mContext, this.mPackageInfo) == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList(this.mPermissions.keySet());
        DangerousPermissionUtil.grantDangrousRuntimePermission(this.mAppOps, this.mPackageManager, this.mPackageInfo, r0, this.mNativePermission.getOpCode());
        if (hasBackgroundPermission() == false) goto L11;
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        String r2 = (String) r1.next();
        DangerousPermissionUtil.setOpsMode(this.mAppOps, this.mPackageInfo, r2, OpsManagerHelper.get_MODE_FOREGROUND());
        goto L9
    L13:
        return;
    }

    public void revokeBackgroundPermission() {
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(this.mContext, this.mPackageInfo) == false) goto L5;
        return;
    L5:
        Permission r0 = this.mBackgroundPermission;
        if (r0 != null) goto L8;
        return;
    L8:
        DangerousPermissionUtil.revokeBackgroundPermission(this.mAppOps, this.mPackageManager, this.mPackageInfo, r0.getName());
        if (areRuntimePermissionsGranted() == false) goto L14;
        Iterator r1 = new ArrayList(this.mPermissions.keySet()).iterator();
    L12:
        if (r1.hasNext() == false) goto L16;
        String r2 = (String) r1.next();
        DangerousPermissionUtil.setOpsMode(this.mAppOps, this.mPackageInfo, r2, OpsManagerHelper.get_MODE_FOREGROUND());
        goto L12
    L16:
        return;
    }

    public void revokeRuntimePermissions() {
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(this.mContext, this.mPackageInfo) == false) goto L5;
        return;
    L5:
        DangerousPermissionUtil.revokePermissions(this.mAppOps, this.mPackageManager, this.mPackageInfo, new ArrayList(this.mPermissions.keySet()), this.mNativePermission.getOpCode());
    }

    public void grantSpecialPermissions(boolean grant) {
        if (RiskPermissionControlGuard.isSensitivePermissionChangeBlocked(this.mContext, this.mPackageInfo) == false) goto L5;
        return;
    L5:
        SpecailPermissionUtil.grantPermission(this.mAppOps, this.mPackageInfo.applicationInfo.uid, grant);
    }

    public List<Permission> getPermissions() {
        return new ArrayList(this.mPermissions.values());
    }

    public int getFlags() {
        int r0 = this.mPermissions.size();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 | this.mPermissions.valueAt(r1).getFlags();
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(AppPermissionGroup another) {
        return this.mPackageInfo.applicationInfo.uid - another.mPackageInfo.applicationInfo.uid;
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if (obj != null) goto L9;
        return false;
    L9:
        if (getClass() == obj.getClass()) goto L11;
        return false;
    L11:
        AppPermissionGroup r5 = (AppPermissionGroup) obj;
        String r4 = this.mName;
        if (r4 != null) goto L17;
        if (r5.mName == null) goto L19;
        return false;
    L19:
        return true;
    L17:
        if (r4.equals(r5.mName) == true) goto L19;
        return false;
    }

    public int hashCode() {
        String r0 = this.mName;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(getClass().getSimpleName());
        r0.append("{name=").append(this.mName);
        if (this.mPermissions.isEmpty() == true) goto L5;
        r0.append(", <has permissions>}");
    L7:
        return r0.toString();
    L5:
        r0.append('}');
        goto L7
    }

    private void addPermission(Permission permission) {
        this.mPermissions.put(permission.getName(), permission);
        if (permission.isEphemeral() == false) goto L6;
        this.mContainsEphemeralPermission = true;
    L6:
        if (permission.isRuntimeOnly() == true) goto L9;
        this.mContainsPreRuntimePermission = true;
        return;
    }
}
