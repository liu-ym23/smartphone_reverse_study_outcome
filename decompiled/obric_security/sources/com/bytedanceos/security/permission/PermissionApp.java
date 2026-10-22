package com.bytedanceos.security.permission;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.bytedanceos.application.ApplicationLabelCache;
import com.bytedanceos.application.ApplicationLabelUtils;
import com.bytedanceos.application.LabelEntry;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionApp implements Comparable<PermissionApp> {
    private AppPermissionGroup mAppPermissionGroup;
    private Drawable mIcon;
    private ApplicationInfo mInfo;
    private String mLabel;
    private LabelEntry mLabelEntry;
    private String mPackageName;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(PermissionApp another) {
        return compareTo2(another);
    }

    public PermissionApp(String packageName, AppPermissionGroup appPermissionGroup, String label, Drawable icon, ApplicationInfo info) {
        this.mPackageName = packageName;
        this.mAppPermissionGroup = appPermissionGroup;
        this.mLabel = label;
        this.mIcon = icon;
        this.mInfo = info;
    }

    public LabelEntry getLabelEntry() {
        return this.mLabelEntry;
    }

    public void loadLabelEntry(PackageManager pm) {
        LabelEntry r3 = ApplicationLabelCache.getInstance().getLabelEntry(pm, this.mPackageName);
        this.mLabelEntry = r3;
        if (r3 != null) goto L6;
        this.mLabelEntry = ApplicationLabelUtils.generatorLabelEntry(this.mLabel);
        return;
    }

    public ApplicationInfo getAppInfo() {
        return this.mInfo;
    }

    public String getKey() {
        return this.mPackageName + getUid();
    }

    public String getLabel() {
        return this.mLabel;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public boolean areRuntimePermissionsGranted() {
        return this.mAppPermissionGroup.areRuntimePermissionsGranted();
    }

    public boolean areSpecialPermissionsGranted() {
        return this.mAppPermissionGroup.areSpecialPermissionsGranted();
    }

    public boolean areBackgroudPermissionGranted() {
        if (hasBackgroundPermission() == true) goto L7;
        return false;
    L7:
        return this.mAppPermissionGroup.areBackgroundPermissionsGranted();
    }

    public void grantRuntimePermissions() {
        this.mAppPermissionGroup.grantRuntimePermissions();
    }

    public void grantBackgroundPermission() {
        this.mAppPermissionGroup.grantBackgroundPermission();
    }

    public void revokeBackgroundPermission() {
        this.mAppPermissionGroup.revokeBackgroundPermission();
    }

    public void revokeRuntimePermissions() {
        this.mAppPermissionGroup.revokeRuntimePermissions();
    }

    public boolean hasBackgroundPermission() {
        return this.mAppPermissionGroup.hasBackgroundPermission();
    }

    public void grantSpecialPermissions() {
        this.mAppPermissionGroup.grantSpecialPermissions(true);
    }

    public void revokeSpecialPermissions() {
        this.mAppPermissionGroup.grantSpecialPermissions(false);
    }

    public int getUserId() {
        return this.mAppPermissionGroup.getUserId();
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(PermissionApp another) {
        int r0 = this.mLabel.compareTo(another.mLabel);
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return getKey().compareTo(another.getKey());
    }

    public int getUid() {
        return this.mAppPermissionGroup.getApp().applicationInfo.uid;
    }
}
