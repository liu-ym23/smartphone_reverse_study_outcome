package com.android.settings.applock.data;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import com.android.settings.applications.ApplicationLabelCache;
import com.android.settings.applications.ApplicationLabelUtils;
import com.android.settings.applications.LabelEntry;

/* JADX INFO: loaded from: classes2.dex */
public class AppEntry {
    private static final String ICON_NAME = "AdaptiveIconDrawable";
    private static final String TAG = "AppEntry";
    private boolean mChecked;
    private final Context mContext;
    private volatile Drawable mIcon;
    private ApplicationInfo mInfo;
    private String mLabel;
    public LabelEntry mLabelEntry;
    private final PackageManager mPm;

    public AppEntry(Context r2, ApplicationInfo r3) {
        this.mChecked = false;
        this.mLabel = null;
        this.mIcon = null;
        this.mInfo = r3;
        this.mContext = r2;
        this.mPm = r2.getPackageManager();
        ensureLabel(r2);
    }

    void ensureLabel(Context r3) {
        if (this.mLabel != null) goto L9;
        LabelEntry r0 = ApplicationLabelCache.getInstance().getLabelEntry(r3, this.mInfo.packageName);
        if (r0 == null) goto L7;
        this.mLabel = r0.label;
        return;
    L7:
        this.mLabel = ApplicationLabelUtils.loadLabel(r3, this.mInfo);
        return;
    }

    public void ensureIcon() {
        if (this.mIcon != null) goto L21;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L6:
        if (this.mIcon != null) goto L16;
        this.mIcon = this.mInfo.loadIcon(this.mPm);     // Catch: Throwable -> L18
        if (UserHandle.getUserId(this.mInfo.uid) != 10) goto L16;
        if (this.mIcon == null) goto L16;
        if ((this.mIcon instanceof BitmapDrawable) == false) goto L14;
    L15:
        this.mIcon = this.mPm.getUserBadgedIcon(this.mIcon, new UserHandle(10));     // Catch: Throwable -> L18
        goto L16
    L14:
        if (this.mIcon.getClass().getSimpleName().equals(ICON_NAME) == true) goto L15;
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    }

    public Drawable getIcon() {
        if (this.mIcon != null) goto L6;
        ensureIcon();
    L6:
        return this.mIcon;
    }

    public String getPackageName() {
        return this.mInfo.packageName;
    }

    public void setLabel(String r1) {
        this.mLabel = r1;
    }

    public String getLabel() {
        return this.mLabel;
    }

    public void setAppLockedStatus(boolean r1) {
        this.mChecked = r1;
    }

    public boolean getAppLockedStatus() {
        return this.mChecked;
    }

    public ApplicationInfo getApplicationInfo() {
        return this.mInfo;
    }

    public void ensureLabelEntry() {
        LabelEntry r0 = ApplicationLabelCache.getInstance().getLabelEntry(this.mContext, this.mInfo.packageName);
        this.mLabelEntry = r0;
        if (r0 != null) goto L6;
        this.mLabelEntry = ApplicationLabelUtils.generatorLabelEntry(this.mContext, this.mInfo.packageName, this.mLabel);
        return;
    }
}
