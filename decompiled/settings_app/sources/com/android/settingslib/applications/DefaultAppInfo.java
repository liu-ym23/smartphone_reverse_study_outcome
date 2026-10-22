package com.android.settingslib.applications;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.util.IconDrawableFactory;
import com.android.settingslib.widget.CandidateInfo;

/* JADX INFO: loaded from: classes.dex */
public class DefaultAppInfo extends CandidateInfo {
    public final ComponentName componentName;
    private final Context mContext;
    protected final PackageManager mPm;
    public final PackageItemInfo packageItemInfo;
    public final String summary;
    public final int userId;

    public DefaultAppInfo(Context r8, PackageManager r9, int r10, ComponentName r11) {
        this(r8, r9, r10, r11, null, true);
    }

    public DefaultAppInfo(Context r8, PackageManager r9, int r10, PackageItemInfo r11) {
        this(r8, r9, r10, r11, null, true);
    }

    public DefaultAppInfo(Context r1, PackageManager r2, int r3, ComponentName r4, String r5, boolean r6) {
        super(r6);
        this.mContext = r1;
        this.mPm = r2;
        this.packageItemInfo = null;
        this.userId = r3;
        this.componentName = r4;
        this.summary = r5;
    }

    public DefaultAppInfo(Context r1, PackageManager r2, int r3, PackageItemInfo r4, String r5, boolean r6) {
        super(r6);
        this.mContext = r1;
        this.mPm = r2;
        this.userId = r3;
        this.packageItemInfo = r4;
        this.componentName = null;
        this.summary = r5;
    }

    @Override // com.android.settingslib.widget.CandidateInfo
    public CharSequence loadLabel() {
        if (this.componentName != null) goto L16;
        PackageItemInfo r0 = this.packageItemInfo;
        if (r0 != null) goto L14;
        return null;
    L14:
        return r0.loadLabel(this.mPm);
    L16:
        ComponentInfo r1 = getComponentInfo();     // Catch: PackageManager.NameNotFoundException -> L10
        if (r1 == null) goto L9;
        return r1.loadLabel(this.mPm);
    L9:
        return this.mPm.getApplicationInfoAsUser(this.componentName.getPackageName(), 0, this.userId).loadLabel(this.mPm);
    L10:
        return null;
    }

    public String getSummary() {
        return this.summary;
    }

    @Override // com.android.settingslib.widget.CandidateInfo
    public Drawable loadIcon() {
        IconDrawableFactory r0 = IconDrawableFactory.newInstance(this.mContext);
        if (this.componentName != null) goto L19;
        PackageItemInfo r1 = this.packageItemInfo;
        if (r1 != null) goto L17;
    L15:
        return null;
    L17:
        ApplicationInfo r2 = this.mPm.getApplicationInfoAsUser(r1.packageName, 0, this.userId);     // Catch: PackageManager.NameNotFoundException -> L16
        return r0.getBadgedIcon(this.packageItemInfo, r2, this.userId);
    L19:
        ComponentInfo r3 = getComponentInfo();     // Catch: PackageManager.NameNotFoundException -> L10
        ApplicationInfo r4 = this.mPm.getApplicationInfoAsUser(this.componentName.getPackageName(), 0, this.userId);     // Catch: PackageManager.NameNotFoundException -> L10
        if (r3 == null) goto L9;
        return r0.getBadgedIcon(r3, r4, this.userId);
    L9:
        return r0.getBadgedIcon(r4);
    L10:
        return null;
    }

    @Override // com.android.settingslib.widget.CandidateInfo
    public String getKey() {
        ComponentName r0 = this.componentName;
        if (r0 != null) goto L5;
        PackageItemInfo r1 = this.packageItemInfo;
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.packageName;
    L5:
        return r0.flattenToString();
    }

    private ComponentInfo getComponentInfo() {
        ActivityInfo r0 = AppGlobals.getPackageManager().getActivityInfo(this.componentName, 0, this.userId);     // Catch: RemoteException -> L6
        if (r0 != null) goto L10;
        return AppGlobals.getPackageManager().getServiceInfo(this.componentName, 0, this.userId);
    L10:
        return r0;
    L6:
        return null;
    }
}
