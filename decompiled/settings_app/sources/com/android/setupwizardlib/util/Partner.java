package com.android.setupwizardlib.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class Partner {
    private static final String ACTION_PARTNER_CUSTOMIZATION = "com.android.setupwizard.action.PARTNER_CUSTOMIZATION";
    private static final String TAG = "(SUW) Partner";
    private static Partner partner = null;
    private static boolean searched = false;
    private final String packageName;
    private final Resources resources;

    public static class ResourceEntry {
        public int id;
        public boolean isOverlay;
        public Resources resources;

        ResourceEntry(Resources r1, int r2, boolean r3) {
            this.resources = r1;
            this.id = r2;
            this.isOverlay = r3;
        }
    }

    static {
    }

    public static Drawable getDrawable(Context r0, int r1) {
        ResourceEntry r2 = getResourceEntry(r0, r1);
        return r2.resources.getDrawable(r2.id);
    }

    public static String getString(Context r0, int r1) {
        ResourceEntry r2 = getResourceEntry(r0, r1);
        return r2.resources.getString(r2.id);
    }

    public static int getColor(Context r0, int r1) {
        ResourceEntry r2 = getResourceEntry(r0, r1);
        return r2.resources.getColor(r2.id);
    }

    public static CharSequence getText(Context r0, int r1) {
        ResourceEntry r2 = getResourceEntry(r0, r1);
        return r2.resources.getText(r2.id);
    }

    public static ResourceEntry getResourceEntry(Context r3, int r4) {
        Partner r0 = get(r3);
        if (r0 == null) goto L9;
        Resources r1 = r3.getResources();
        int r2 = r0.getIdentifier(r1.getResourceEntryName(r4), r1.getResourceTypeName(r4));
        if (r2 == 0) goto L9;
        return new ResourceEntry(r0.resources, r2, true);
    L9:
        return new ResourceEntry(r3.getResources(), r4, false);
    }

    public static synchronized Partner get(Context r7) {
        monitor-enter(Partner.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (searched == true) goto L19;
        PackageManager r8 = r7.getPackageManager();     // Catch: Throwable -> L22
        Iterator<ResolveInfo> r1 = r8.queryBroadcastReceivers(new Intent(ACTION_PARTNER_CUSTOMIZATION), 1835008).iterator();     // Catch: Throwable -> L22
    L8:
        if (r1.hasNext() == false) goto L18;
        ResolveInfo r2 = r1.next();     // Catch: Throwable -> L22
        if (r2.activityInfo == null) goto L8;
        ApplicationInfo r3 = r2.activityInfo.applicationInfo;     // Catch: Throwable -> L22
        if ((r3.flags & 1) == 0) goto L8;
        partner = new Partner(r3.packageName, r8.getResourcesForApplication(r3));     // Catch: PackageManager.NameNotFoundException -> L17 Throwable -> L22
    L17:
        Log.w(TAG, "Failed to find resources for " + r3.packageName);     // Catch: Throwable -> L22
    L18:
        searched = true;     // Catch: Throwable -> L22
    L19:
        Partner r9 = partner;     // Catch: Throwable -> L22
        monitor-exit(Partner.class);
        return r9;
    }

    public static synchronized void resetForTesting() {
        monitor-enter(Partner.class);
        searched = false;     // Catch: Throwable -> L8
        partner = null;     // Catch: Throwable -> L8
        monitor-exit(Partner.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private Partner(String r1, Resources r2) {
        this.packageName = r1;
        this.resources = r2;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public Resources getResources() {
        return this.resources;
    }

    public int getIdentifier(String r2, String r3) {
        return this.resources.getIdentifier(r2, r3, this.packageName);
    }
}
