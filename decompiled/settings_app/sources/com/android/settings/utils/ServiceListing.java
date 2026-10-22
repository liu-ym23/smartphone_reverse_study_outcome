package com.android.settings.utils;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Slog;
import com.GlobalProxyLancet;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceListing {
    private final List<Callback> mCallbacks;
    private final ManagedServiceSettings.Config mConfig;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final HashSet<ComponentName> mEnabledServices;
    private boolean mListening;
    private final BroadcastReceiver mPackageReceiver;
    private final List<ServiceInfo> mServices;
    private final ContentObserver mSettingsObserver;

    public interface Callback {
        void onServicesReloaded(List<ServiceInfo> r1);
    }

    public ServiceListing(Context r3, ManagedServiceSettings.Config r4) {
        this.mEnabledServices = new HashSet();
        this.mServices = new ArrayList();
        this.mCallbacks = new ArrayList();
        final Handler r1 = new Handler();
        this.mSettingsObserver = new AnonymousClass1(this, r1);
        this.mPackageReceiver = new AnonymousClass2(this);
        this.mContext = r3;
        this.mConfig = r4;
        this.mContentResolver = r3.getContentResolver();
    }

    public void addCallback(Callback r1) {
        this.mCallbacks.add(r1);
    }

    public void removeCallback(Callback r1) {
        this.mCallbacks.remove(r1);
    }

    public void setListening(boolean r4) {
        if (this.mListening != r4) goto L5;
        return;
    L5:
        this.mListening = r4;
        if (r4 == false) goto L8;
        IntentFilter r5 = new IntentFilter();
        r5.addAction("android.intent.action.PACKAGE_ADDED");
        r5.addAction("android.intent.action.PACKAGE_CHANGED");
        r5.addAction("android.intent.action.PACKAGE_REMOVED");
        r5.addAction("android.intent.action.PACKAGE_REPLACED");
        r5.addDataScheme("package");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mPackageReceiver, r5, 2);
        this.mContentResolver.registerContentObserver(Settings.Secure.getUriFor(this.mConfig.setting), false, this.mSettingsObserver);
        return;
    L8:
        this.mContext.unregisterReceiver(this.mPackageReceiver);
        this.mContentResolver.unregisterContentObserver(this.mSettingsObserver);
    }

    public static int getEnabledServicesCount(ManagedServiceSettings.Config r0, Context r1) {
        String r2 = Settings.Secure.getString(r1.getContentResolver(), r0.setting);
        if (r2 != null) goto L5;
        return 0;
    L5:
        if ("".equals(r2) == false) goto L8;
        return 0;
    L8:
        return r2.split(":").length;
    }

    public static int getServicesCount(ManagedServiceSettings.Config r1, PackageManager r2) {
        return getServices(r1, null, r2);
    }

    protected static int getServices(ManagedServiceSettings.Config r7, List<ServiceInfo> r8, PackageManager r9) {
        if (r8 == null) goto L4;
        r8.clear();
    L4:
        List r10 = r9.queryIntentServicesAsUser(new Intent(r7.intentAction), 132, ActivityManager.getCurrentUser());
        int r0 = r10.size();
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L13;
        ServiceInfo r3 = ((ResolveInfo) r10.get(r1)).serviceInfo;
        if (r7.permission.equals(r3.permission) == true) goto L9;
        Slog.w(r7.tag, "Skipping " + r7.noun + " service " + r3.packageName + LibrarianImpl.Constants.SEPARATOR + r3.name + ": it does not require the permission " + r7.permission);
    L12:
        r1 = r1 + 1;
        goto L5
    L9:
        if (r8 == null) goto L11;
        r8.add(r3);
    L11:
        r2 = r2 + 1;
        goto L12
    L13:
        return r2;
    }

    private void saveEnabledServices() {
        Iterator<ComponentName> r0 = this.mEnabledServices.iterator();
        StringBuilder r1 = null;
    L4:
        if (r0.hasNext() == false) goto L10;
        ComponentName r2 = r0.next();
        if (r1 != null) goto L8;
        r1 = new StringBuilder();
    L9:
        r1.append(r2.flattenToString());
        goto L4
    L8:
        r1.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        goto L9
    L10:
        ContentResolver r3 = this.mContentResolver;
        String r4 = this.mConfig.setting;
        if (r1 == null) goto L13;
        String r5 = r1.toString();
    L14:
        Settings.Secure.putString(r3, r4, r5);
        return;
    L13:
        r5 = "";
        goto L14
    }

    private void loadEnabledServices() {
        this.mEnabledServices.clear();
        String r0 = Settings.Secure.getString(this.mContentResolver, this.mConfig.setting);
        if (r0 != null) goto L5;
        return;
    L5:
        if ("".equals(r0) == true) goto L17;
        String[] r1 = r0.split(":");
        int r2 = 0;
    L8:
        if (r2 >= r1.length) goto L18;
        ComponentName r3 = ComponentName.unflattenFromString(r1[r2]);
        if (r3 == null) goto L12;
        this.mEnabledServices.add(r3);
    L12:
        r2 = r2 + 1;
        goto L8
    L18:
        return;
    }

    public void reload() {
        loadEnabledServices();
        this.mServices.clear();
        int r0 = ActivityManager.getCurrentUser();
        PackageManager r1 = this.mContext.getPackageManager();
        Iterator r2 = r1.queryIntentServicesAsUser(new Intent(this.mConfig.intentAction), 132, r0).iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        ServiceInfo r4 = ((ResolveInfo) r2.next()).serviceInfo;
        if (this.mEnabledServices.contains(r4.getComponentName()) == true) goto L4;
        if (this.mConfig.permission.equals(r4.permission) == false) goto L9;
        this.mServices.add(r4);
        goto L4
    L9:
        Slog.w(this.mConfig.tag, "Skipping " + this.mConfig.noun + " service " + r4.packageName + LibrarianImpl.Constants.SEPARATOR + r4.name + ": it does not require the permission " + this.mConfig.permission);
        goto L4
    L11:
        Iterator<ComponentName> r3 = this.mEnabledServices.iterator();
    L13:
        if (r3.hasNext() == false) goto L18;
        Iterator r5 = r1.queryIntentServicesAsUser(new Intent().setComponent(r3.next()), 132, r0).iterator();
    L16:
        if (r5.hasNext() == false) goto L13;
        this.mServices.add(((ResolveInfo) r5.next()).serviceInfo);
        goto L16
    L18:
        Iterator<Callback> r6 = this.mCallbacks.iterator();
    L20:
        if (r6.hasNext() == false) goto L22;
        r6.next().onServicesReloaded(this.mServices);
        goto L20
    }

    public boolean isEnabled(ComponentName r1) {
        return this.mEnabledServices.contains(r1);
    }

    public void setEnabled(ComponentName r1, boolean r2) {
        if (r2 == false) goto L4;
        this.mEnabledServices.add(r1);
    L5:
        saveEnabledServices();
        return;
    L4:
        this.mEnabledServices.remove(r1);
        goto L5
    }
}
