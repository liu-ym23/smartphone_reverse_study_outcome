package com.android.settingslib.utils;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.UserHandle;
import android.os.UserManager;
import com.android.settings.applications.PickApplicationActivity;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class WorkPolicyUtils {
    private static final int USER_NULL = -10000;
    private final Context mContext;
    private final DevicePolicyManager mDevicePolicyManager;
    private final PackageManager mPackageManager;
    private final UserManager mUserManager;

    public WorkPolicyUtils(Context r2) {
        this.mContext = r2;
        this.mPackageManager = r2.getPackageManager();
        this.mUserManager = (UserManager) r2.getSystemService(PickApplicationActivity.EXTRA_USER);
        this.mDevicePolicyManager = (DevicePolicyManager) r2.getSystemService("device_policy");
    }

    public boolean hasWorkPolicy() {
        if (getWorkPolicyInfoIntentDO() == null) goto L5;
    L8:
        return true;
    L5:
        if (getWorkPolicyInfoIntentPO() != null) goto L8;
        return false;
    }

    public boolean showWorkPolicyInfo(Context r4) {
        Intent r0 = getWorkPolicyInfoIntentDO();
        if (r0 == null) goto L6;
        r4.startActivity(r0);
        return true;
    L6:
        Intent r1 = getWorkPolicyInfoIntentPO();
        int r3 = getManagedProfileUserId();
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r3 == (-10000)) goto L14;
        r4.startActivityAsUser(r1, UserHandle.of(r3));
        return true;
    L14:
        return false;
    }

    public Intent getWorkPolicyInfoIntentDO() {
        ComponentName r0 = getDeviceOwnerComponent();
        if (r0 != null) goto L5;
        return null;
    L5:
        Intent r1 = new Intent("android.settings.SHOW_WORK_POLICY_INFO").setPackage(r0.getPackageName());
        if (this.mPackageManager.queryIntentActivities(r1, 0).size() == 0) goto L8;
        return r1;
    L8:
        return null;
    }

    private ComponentName getManagedProfileOwnerComponent(int r4) {
        if (r4 != (-10000)) goto L9;
        return null;
    L9:
        Context r3 = this.mContext;     // Catch: PackageManager.NameNotFoundException -> L8
        return ((DevicePolicyManager) r3.createPackageContextAsUser(r3.getPackageName(), 0, UserHandle.of(r4)).getSystemService("device_policy")).getProfileOwner();
    L8:
        return null;
    }

    public Intent getWorkPolicyInfoIntentPO() {
        int r0 = getManagedProfileUserId();
        ComponentName r1 = getManagedProfileOwnerComponent(r0);
        if (r1 != null) goto L5;
        return null;
    L5:
        Intent r2 = new Intent("android.settings.SHOW_WORK_POLICY_INFO").setPackage(r1.getPackageName());
        if (this.mPackageManager.queryIntentActivitiesAsUser(r2, 0, UserHandle.of(r0)).size() == 0) goto L8;
        return r2;
    L8:
        return null;
    }

    private ComponentName getDeviceOwnerComponent() {
        if (this.mPackageManager.hasSystemFeature("android.software.device_admin") == true) goto L7;
        return null;
    L7:
        return this.mDevicePolicyManager.getDeviceOwnerComponentOnAnyUser();
    }

    public int getManagedProfileUserId() {
        Iterator r0 = this.mUserManager.getAllProfiles().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        int r1 = ((UserHandle) r0.next()).getIdentifier();
        if (this.mUserManager.isManagedProfile(r1) == false) goto L4;
        return r1;
    L8:
        return -10000;
    }
}
