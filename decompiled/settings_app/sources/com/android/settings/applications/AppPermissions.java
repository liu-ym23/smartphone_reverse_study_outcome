package com.android.settings.applications;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.util.ArrayMap;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AppPermissions {
    private static final String TAG = "AppPermissions";
    private final Context mContext;
    private final ArrayMap<String, PermissionGroup> mGroups;
    private final PackageInfo mPackageInfo;

    /* JADX INFO: renamed from: com.android.settings.applications.AppPermissions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class Permission {
        private boolean granted;
        private final boolean runtime;

        static /* synthetic */ boolean access$200(Permission r0) {
            return r0.runtime;
        }

        static /* synthetic */ boolean access$300(Permission r0) {
            return r0.granted;
        }

        public Permission(boolean r1, boolean r2) {
            this.runtime = r1;
            this.granted = r2;
        }
    }

    private static final class PermissionGroup {
        private boolean mHasRuntimePermissions;
        private final ArrayMap<String, Permission> mPermissions;

        private PermissionGroup() {
            this.mPermissions = new ArrayMap();
        }

        /* synthetic */ PermissionGroup(AnonymousClass1 r1) {
            this();
        }

        static /* synthetic */ boolean access$100(PermissionGroup r0) {
            return r0.mHasRuntimePermissions;
        }

        public boolean hasRuntimePermissions() {
            return this.mHasRuntimePermissions;
        }

        public boolean areRuntimePermissionsGranted() {
            int r0 = this.mPermissions.size();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L10;
            Permission r3 = this.mPermissions.valueAt(r2);
            if (Permission.access$200(r3) == false) goto L9;
            if (Permission.access$300(r3) == true) goto L9;
            return false;
        L9:
            r2 = r2 + 1;
            goto L3
        L10:
            return true;
        }

        public List<Permission> getPermissions() {
            return new ArrayList(this.mPermissions.values());
        }

        void addPermission(Permission r2, String r3) {
            this.mPermissions.put(r3, r2);
            if (Permission.access$200(r2) == false) goto L6;
            this.mHasRuntimePermissions = true;
            return;
        }
    }

    public AppPermissions(Context r2, String r3) {
        this.mGroups = new ArrayMap();
        this.mContext = r2;
        this.mPackageInfo = getPackageInfo(r3);
        refresh();
    }

    private PackageInfo getPackageInfo(String r3) {
        return this.mContext.getPackageManager().getPackageInfo(r3, 4096);
    L4:
        e = move-exception;
        OLog.e(TAG, "Unable to find " + r3, e);
        return null;
    }

    public void refresh() {
        if (this.mPackageInfo == null) goto L6;
        loadPermissionGroups();
        return;
    }

    public int getPermissionCount() {
        return this.mGroups.size();
    }

    public int getGrantedPermissionsCount() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= this.mGroups.size()) goto L9;
        if (this.mGroups.valueAt(r0).areRuntimePermissionsGranted() == false) goto L8;
        r1 = r1 + 1;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r1;
    }

    private void loadPermissionGroups() {
        this.mGroups.clear();
        if (this.mPackageInfo.requestedPermissions != null) goto L5;
        return;
    L5:
        boolean r0 = appSupportsRuntime(this.mPackageInfo.applicationInfo);
        int r2 = 0;
    L6:
        boolean r4 = true;
        if (r2 >= this.mPackageInfo.requestedPermissions.length) goto L29;
        String r3 = this.mPackageInfo.requestedPermissions[r2];
        PermissionInfo r5 = this.mContext.getPackageManager().getPermissionInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L27
        String r6 = r5.name;
        if (r5.group == null) goto L13;
        String r7 = r5.group;
    L14:
        PermissionGroup r8 = this.mGroups.get(r7);
        if (r8 != null) goto L17;
        r8 = new PermissionGroup(null);
        this.mGroups.put(r7, r8);
    L17:
        if (r0 == true) goto L19;
    L21:
        boolean r9 = false;
    L23:
        if ((this.mPackageInfo.requestedPermissionsFlags[r2] & 2) != 0) goto L26;
        r4 = false;
    L26:
        r8.addPermission(new Permission(r9, r4), r6);
    L28:
        r2 = r2 + 1;
        goto L6
    L19:
        if (r5.protectionLevel != 1) goto L21;
        r9 = true;
        goto L23
    L13:
        r7 = r6;
    L27:
        OLog.w(TAG, "Unknown permission: " + r3);
        goto L28
    L29:
        int r1 = this.mGroups.size() - 1;
    L30:
        if (r1 < 0) goto L35;
        if (PermissionGroup.access$100(this.mGroups.valueAt(r1)) == true) goto L34;
        this.mGroups.removeAt(r1);
    L34:
        r1 = r1 - 1;
        goto L30
    }

    public static boolean appSupportsRuntime(ApplicationInfo r1) {
        if (r1.targetSdkVersion <= 22) goto L5;
        return true;
    L5:
        return false;
    }
}
