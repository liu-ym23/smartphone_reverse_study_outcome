package com.android.settings.notification.zen;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.ArraySet;
import com.android.settings.utils.ManagedServiceSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ZenServiceListing {
    private static final String TAG = "ZenServiceListing";
    private final Set<ComponentInfo> mApprovedComponents;
    private final ManagedServiceSettings.Config mConfig;
    private final Context mContext;
    private final NotificationManager mNm;
    private String mPkg;
    private final List<Callback> mZenCallbacks;

    public interface Callback {
        void onComponentsReloaded(Set<ComponentInfo> r1);
    }

    public ZenServiceListing(Context r2, ManagedServiceSettings.Config r3) {
        this(r2, r3, null);
    }

    public ZenServiceListing(Context r2, ManagedServiceSettings.Config r3, String r4) {
        this.mApprovedComponents = new ArraySet();
        this.mZenCallbacks = new ArrayList();
        this.mContext = r2;
        this.mConfig = r3;
        this.mPkg = r4;
        this.mNm = (NotificationManager) r2.getSystemService("notification");
    }

    public ComponentInfo findService(ComponentName r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        Iterator<ComponentInfo> r5 = this.mApprovedComponents.iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        ComponentInfo r1 = r5.next();
        if (new ComponentName(r1.packageName, r1.name).equals(r6) == false) goto L7;
        return r1;
    L11:
        return null;
    }

    public void addZenCallback(Callback r1) {
        this.mZenCallbacks.add(r1);
    }

    public void removeZenCallback(Callback r1) {
        this.mZenCallbacks.remove(r1);
    }

    public void reloadApprovedServices() {
        this.mApprovedComponents.clear();
        List r0 = this.mNm.getEnabledNotificationListenerPackages();
        ArrayList r1 = new ArrayList();
        getServices(this.mConfig, r1, this.mContext.getPackageManager());
        getActivities(this.mConfig, r1, this.mContext.getPackageManager());
        Iterator<ComponentInfo> r2 = r1.iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        ComponentInfo r3 = r2.next();
        String r4 = r3.getComponentName().getPackageName();
        if (this.mNm.isNotificationPolicyAccessGrantedForPackage(r4) == true) goto L9;
        if (r0.contains(r4) == false) goto L4;
    L9:
        this.mApprovedComponents.add(r3);
        goto L4
    L11:
        if (this.mApprovedComponents.isEmpty() == true) goto L16;
        Iterator<Callback> r5 = this.mZenCallbacks.iterator();
    L14:
        if (r5.hasNext() == false) goto L24;
        r5.next().onComponentsReloaded(this.mApprovedComponents);
        goto L14
    L24:
        return;
    }

    private void getServices(ManagedServiceSettings.Config r4, List<ComponentInfo> r5, PackageManager r6) {
        int r7 = ActivityManager.getCurrentUser();
        Intent r0 = new Intent("android.service.notification.ConditionProviderService");
        String r3 = this.mPkg;
        if (r3 == null) goto L5;
        r0.setPackage(r3);
    L5:
        List r8 = r6.queryIntentServicesAsUser(r0, 132, r7);
        int r9 = r8.size();
        int r10 = 0;
    L6:
        if (r10 >= r9) goto L13;
        ServiceInfo r1 = ((ResolveInfo) r8.get(r10)).serviceInfo;
        if ("android.permission.BIND_CONDITION_PROVIDER_SERVICE".equals(r1.permission) == false) goto L12;
        if (r5 == null) goto L12;
        r5.add(r1);
    L12:
        r10 = r10 + 1;
        goto L6
    }

    private void getActivities(ManagedServiceSettings.Config r3, List<ComponentInfo> r4, PackageManager r5) {
        int r6 = ActivityManager.getCurrentUser();
        Intent r0 = new Intent("android.app.action.AUTOMATIC_ZEN_RULE");
        String r2 = this.mPkg;
        if (r2 == null) goto L5;
        r0.setPackage(r2);
    L5:
        List r7 = r5.queryIntentActivitiesAsUser(r0, 129, r6);
        int r8 = r7.size();
        int r9 = 0;
    L6:
        if (r9 >= r8) goto L11;
        ActivityInfo r1 = ((ResolveInfo) r7.get(r9)).activityInfo;
        if (r4 == null) goto L10;
        r4.add(r1);
    L10:
        r9 = r9 + 1;
        goto L6
    }
}
