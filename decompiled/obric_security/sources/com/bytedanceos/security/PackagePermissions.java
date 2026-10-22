package com.bytedanceos.security;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.application.ApplicationLabelCache;
import com.bytedanceos.application.ApplicationLabelUtils;
import com.bytedanceos.application.LabelEntry;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.permission.NativePermission;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PackagePermissions implements Parcelable {
    public static final Parcelable.Creator<PackagePermissions> CREATOR = null;
    private int mCount;
    private HashMap<Integer, PermissionGroup> mGroupMap;
    private Drawable mIcon;
    private String mLabel;
    public LabelEntry mLabelEntry;
    private List<NativePermission> mNativePermissions;
    private String mPkgName;
    private int mUid;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PackagePermissions(String pkgName, int uid) {
        this.mGroupMap = new HashMap();
        this.mNativePermissions = new ArrayList();
        this.mPkgName = pkgName;
        this.mUid = uid;
    }

    public PackagePermissions(Parcel in) {
        this.mGroupMap = new HashMap();
        this.mNativePermissions = new ArrayList();
        this.mPkgName = in.readString();
        this.mUid = in.readInt();
        this.mCount = in.readInt();
        this.mGroupMap = in.readHashMap(PermissionGroup.class.getClassLoader());
    }

    public void ensureLabelEntry(PackageManager pm) {
        LabelEntry r3 = ApplicationLabelCache.getInstance().getLabelEntry(pm, this.mPkgName);
        this.mLabelEntry = r3;
        if (r3 != null) goto L6;
        this.mLabelEntry = ApplicationLabelUtils.generatorLabelEntry(this.mLabel);
        return;
    }

    public void addNativePermission(NativePermission permission) {
        if (permission != null) goto L4;
        return;
    L4:
        this.mNativePermissions.add(permission);
    }

    public void addPermission(int opIndex) {
        int r0 = Utils.mParentGroups[opIndex];
        if (this.mGroupMap.containsKey(Integer.valueOf(r0)) == false) goto L5;
        this.mGroupMap.get(Integer.valueOf(r0)).addPermission(opIndex);
    L6:
        this.mCount++;
        return;
    L5:
        PermissionGroup r1 = new PermissionGroup(r0);
        r1.addPermission(opIndex);
        this.mGroupMap.put(Integer.valueOf(r0), r1);
        goto L6
    }

    public void addPermission(int index, int opIndex) {
        int r0 = Utils.mParentGroups[opIndex];
        if (this.mGroupMap.containsKey(Integer.valueOf(r0)) == false) goto L5;
        this.mGroupMap.get(Integer.valueOf(r0)).addPermission(index, opIndex);
    L6:
        this.mCount++;
        return;
    L5:
        PermissionGroup r1 = new PermissionGroup(r0);
        r1.addPermission(index, opIndex);
        this.mGroupMap.put(Integer.valueOf(r0), r1);
        goto L6
    }

    public void insertThirdPartyBootable() {
        addPermission(0, 19);
    }

    public void insertBootcomplete() {
        addPermission(0, 18);
    }

    public void insertCaptureVideoOutput() {
        addPermission(0, 16);
    }

    public void insertShowOnKeyguard() {
        int r0 = Utils.mParentGroups[26];
        if (this.mGroupMap.containsKey(Integer.valueOf(r0)) == false) goto L7;
        PermissionGroup r1 = this.mGroupMap.get(Integer.valueOf(r0));
        if (r1.getChildCount() <= 0) goto L8;
        r1.addPermission(1, 26);
    L8:
        this.mCount++;
        return;
    L7:
        PermissionGroup r2 = new PermissionGroup(r0);
        r2.addPermission(26);
        this.mGroupMap.put(Integer.valueOf(r0), r2);
        goto L8
    }

    public void insertInstallUnknownApps() {
        int r0 = Utils.mParentGroups[27];
        if (this.mGroupMap.containsKey(Integer.valueOf(r0)) == false) goto L10;
        PermissionGroup r1 = this.mGroupMap.get(Integer.valueOf(r0));
        if (r1.getChildCount() <= 1) goto L8;
        r1.addPermission(2, 27);
    L11:
        this.mCount++;
        return;
    L8:
        if (r1.getChildCount() <= 0) goto L11;
        r1.addPermission(1, 27);
        goto L11
    L10:
        PermissionGroup r2 = new PermissionGroup(r0);
        r2.addPermission(27);
        this.mGroupMap.put(Integer.valueOf(r0), r2);
        goto L11
    }

    public void insertStartOnBackgroundApps() {
        if (MultiSdkAdapter.sdkIsBeforeO() == true) goto L12;
        int r0 = Utils.mParentGroups[28];
        if (this.mGroupMap.containsKey(Integer.valueOf(r0)) == false) goto L9;
        PermissionGroup r1 = this.mGroupMap.get(Integer.valueOf(r0));
        if (r1.getChildCount() <= 0) goto L10;
        r1.addPermission(1, 28);
    L10:
        this.mCount++;
        return;
    L9:
        PermissionGroup r2 = new PermissionGroup(r0);
        r2.addPermission(28);
        this.mGroupMap.put(Integer.valueOf(r0), r2);
        goto L10
    }

    public int getPermissionCount() {
        if (MultiSdkAdapter.sdkIsBeforeO() == false) goto L6;
        return this.mCount;
    L6:
        return this.mNativePermissions.size();
    }

    public String getPackageName() {
        return this.mPkgName;
    }

    public int getUid() {
        return this.mUid;
    }

    public HashMap<Integer, PermissionGroup> getGroupMap() {
        return this.mGroupMap;
    }

    public void setLabel(String label) {
        this.mLabel = label;
    }

    public void setIcon(Drawable icon) {
        this.mIcon = icon;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public Drawable getIcon() {
        if (this.mIcon != null) goto L15;
        PackageManager r0 = SecurityCenterApplication.getApplication().getPackageManager();
        if (r0 != null) goto L16;
        return null;
    L16:
        PackageInfo r2 = r0.getPackageInfo(this.mPkgName, 0);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r2 != null) goto L10;
        return null;
    L10:
        this.mIcon = Utils.getResizedApkIcon(r2.applicationInfo, r0);     // Catch: PackageManager.NameNotFoundException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        return this.mIcon;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mPkgName);
        dest.writeInt(this.mUid);
        dest.writeInt(this.mCount);
        dest.writeMap(this.mGroupMap);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
